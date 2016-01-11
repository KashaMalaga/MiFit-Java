package com.tencent.connect.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.open.SocialConstants;
import com.tencent.open.a.f;
import com.tencent.open.b.d;
import com.tencent.open.utils.SystemUtils;
import com.tencent.open.utils.TemporaryStorage;
import com.tencent.open.utils.Util;
import com.tencent.tauth.AuthActivity;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.xiaomi.account.openauth.h;
import com.xiaomi.e.a;
import org.json.JSONObject;

public class AssistActivity extends Activity {
    private static final String RESTART_FLAG = "RESTART_FLAG";
    private static final String TAG = "AssistActivity";
    public static boolean hackAuthActivity = false;
    public static boolean hackShareSend = false;
    public static boolean isQQMobileShare = false;
    private static BaseApi sApiObject;
    private BaseApi mAPiObject;

    public static Intent getAssistActivityIntent(Context context) {
        return new Intent(context, AssistActivity.class);
    }

    private void openBrowser(Bundle bundle) {
        String string = bundle.getString("viaShareType");
        String string2 = bundle.getString("callbackAction");
        String string3 = bundle.getString(SocialConstants.PARAM_URL);
        String string4 = bundle.getString("openId");
        String string5 = bundle.getString("appId");
        String str = a.f;
        String str2 = a.f;
        if (SystemUtils.QQ_SHARE_CALLBACK_ACTION.equals(string2)) {
            str = Constants.VIA_SHARE_TO_QQ;
            str2 = Constants.VIA_REPORT_TYPE_SHARE_TO_QQ;
        } else if (SystemUtils.QZONE_SHARE_CALLBACK_ACTION.equals(string2)) {
            str = Constants.VIA_SHARE_TO_QZONE;
            str2 = Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE;
        }
        if (Util.openBrowser(this, string3)) {
            d.a().a(string4, string5, str, str2, Constants.VIA_TO_TYPE_QQ_DISCUSS_GROUP, Constants.VIA_RESULT_SUCCESS, string, Constants.VIA_RESULT_SUCCESS, Constants.VIA_SSO_LOGIN, Constants.VIA_RESULT_SUCCESS);
        } else {
            IUiListener iUiListener = (IUiListener) TemporaryStorage.get(string2);
            if (iUiListener != null) {
                iUiListener.onError(new UiError(-6, Constants.MSG_OPEN_BROWSER_ERROR, null));
            }
            d.a().a(string4, string5, str, str2, Constants.VIA_TO_TYPE_QQ_DISCUSS_GROUP, Constants.VIA_TO_TYPE_QQ_GROUP, string, Constants.VIA_RESULT_SUCCESS, Constants.VIA_SSO_LOGIN, Constants.VIA_RESULT_SUCCESS);
            finish();
        }
        getIntent().removeExtra("shareH5");
    }

    public static void setApiObject(BaseApi baseApi) {
        sApiObject = baseApi;
    }

    public static void setResultDataForLogin(Activity activity, Intent intent) {
        if (activity != null) {
            if (intent == null) {
                activity.setResult(Constants.RESULT_LOGIN, intent);
                return;
            }
            try {
                Object stringExtra = intent.getStringExtra(Constants.KEY_RESPONSE);
                f.b(TAG, "AssistActivity--setResultDataForLogin-- " + stringExtra);
                if (!TextUtils.isEmpty(stringExtra)) {
                    JSONObject jSONObject = new JSONObject(stringExtra);
                    CharSequence optString = jSONObject.optString(SocialConstants.PARAM_OPEN_ID);
                    CharSequence optString2 = jSONObject.optString(h.I);
                    if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                        activity.setResult(12345, intent);
                    } else {
                        activity.setResult(Constants.RESULT_LOGIN, intent);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        f.b(TAG, "AssistActivity--onActivityResult--" + i2 + " data=" + intent);
        f.b(TAG, "--requestCode: " + i + " | resultCode: " + i2 + " | data: " + intent);
        super.onActivityResult(i, i2, intent);
        if (i != 0) {
            if (intent != null) {
                intent.putExtra(Constants.KEY_ACTION, SystemUtils.ACTION_LOGIN);
            }
            if (this.mAPiObject != null) {
                f.b(TAG, "AssistActivity--onActivityResult-- mAPiObject != null");
                this.mAPiObject.onActivityResult(this, i, i2, intent);
            } else {
                f.b(TAG, "AssistActivity--onActivityResult-- mAPiObject == null");
                setResultDataForLogin(this, intent);
            }
            finish();
        } else if (!isFinishing()) {
            finish();
        }
    }

    protected void onCreate(Bundle bundle) {
        int i = 0;
        super.onCreate(bundle);
        requestWindowFeature(1);
        f.b(TAG, "AssistActivity--onCreate--");
        if (sApiObject != null) {
            this.mAPiObject = sApiObject;
            sApiObject = null;
            Intent activityIntent = this.mAPiObject.getActivityIntent();
            int intExtra = activityIntent == null ? 0 : activityIntent.getIntExtra(Constants.KEY_REQUEST_CODE, 0);
            Bundle bundleExtra = getIntent().getBundleExtra(SystemUtils.H5_SHARE_DATA);
            if (bundle != null) {
                i = bundle.getBoolean(RESTART_FLAG);
            }
            if (i != 0) {
                return;
            }
            if (bundleExtra == null) {
                startActivityForResult(activityIntent, intExtra);
            } else {
                openBrowser(bundleExtra);
            }
        }
    }

    protected void onDestroy() {
        f.b(TAG, "-->onDestroy");
        super.onDestroy();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Object obj = TemporaryStorage.get(intent.getStringExtra(AuthActivity.ACTION_KEY));
        f.b(TAG, "AssistActivity--onNewIntent--" + (obj == null ? "mAPiObject = null" : "mAPiObject != null"));
        intent.putExtra(Constants.KEY_ACTION, SystemUtils.ACTION_SHARE);
        if (obj != null) {
            BaseApi.handleDataToListener(intent, (IUiListener) obj);
        } else {
            setResult(-1, intent);
        }
        if (!isFinishing()) {
            finish();
        }
    }

    protected void onPause() {
        f.b(TAG, "-->onPause");
        super.onPause();
    }

    protected void onResume() {
        f.b(TAG, "-->onResume");
        super.onResume();
        Intent intent = getIntent();
        if (!intent.getBooleanExtra(SystemUtils.IS_LOGIN, false)) {
            if (!intent.getBooleanExtra(SystemUtils.IS_QQ_MOBILE_SHARE, false)) {
                if (!(hackShareSend || isFinishing())) {
                    finish();
                }
                hackShareSend = false;
            }
            if (hackAuthActivity) {
                hackAuthActivity = false;
                finish();
            }
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        f.b(TAG, "AssistActivity--onSaveInstanceState--");
        bundle.putBoolean(RESTART_FLAG, true);
        super.onSaveInstanceState(bundle);
    }

    protected void onStart() {
        f.b(TAG, "-->onStart");
        super.onStart();
    }

    protected void onStop() {
        f.b(TAG, "-->onStop");
        super.onStop();
    }
}
