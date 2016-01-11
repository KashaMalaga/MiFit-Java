package cn.com.smartdevices.bracelet.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Constant;
import cn.com.smartdevices.bracelet.e.a;
import cn.com.smartdevices.bracelet.model.LoginData;
import com.tencent.open.SocialConstants;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import com.xiaomi.mipush.sdk.f;
import com.xiaomi.mipush.sdk.i;
import com.xiaomi.mipush.sdk.j;
import de.greenrobot.event.EventBus;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class MiPushMessageReceiver extends PushMessageReceiver {
    private static final String ABOUT_PAGE = "app://hm.xiaomi.com/about";
    public static final String ANDROID = "android";
    public static final String DATA = "data";
    public static final String EXPIRE_TIME = "expire";
    public static final String INTENT = "intent";
    public static final String IOS = "ios";
    public static final String LUA = "lua";
    public static final String PUSH_TYPE = "type";
    public static final String PUSH_TYPE_DYNAMIC = "dynamic";
    public static final String PUSH_TYPE_INTENT = "intent";
    private static final String TAG = "MiPushMessageReceiver";
    public static final String VERSION = "version";
    private String mAlias;
    private String mEndTime;
    private String mMessage;
    private String mRegId;
    private String mStartTime;
    private String mTopic;

    private boolean processBetaApkUpgrade(Context context, j jVar) {
        this.mMessage = jVar.c();
        if (!TextUtils.isEmpty(jVar.f())) {
            this.mTopic = jVar.f();
        } else if (!TextUtils.isEmpty(jVar.d())) {
            this.mAlias = jVar.d();
        }
        try {
            JSONObject optJSONObject = new JSONObject(this.mMessage).optJSONObject(DATA);
            if (!(optJSONObject == null || optJSONObject.isNull(SocialConstants.PARAM_URL))) {
                C0596r.e(TAG, "dataObj = " + optJSONObject.toString());
                if (ABOUT_PAGE.equals(optJSONObject.optString(SocialConstants.PARAM_URL))) {
                    LoginData f = a.f(context);
                    if (f != null && f.isValid()) {
                        Intent intent = new Intent();
                        intent.setFlags(268435456);
                        intent.setAction("cn.com.smartdevices.bracelet.ui.MainUIActivity");
                        intent.putExtra(Constant.aN, Constant.cb);
                        context.startActivity(intent);
                        return true;
                    }
                }
            }
        } catch (JSONException e) {
            C0596r.e(TAG, "e:" + e.toString());
        }
        return false;
    }

    public void onCommandResult(Context context, i iVar) {
        String a = iVar.a();
        List b = iVar.b();
        String str = (b == null || b.size() <= 0) ? null : (String) b.get(0);
        String str2 = (b == null || b.size() <= 1) ? null : (String) b.get(1);
        if (f.a.equals(a)) {
            if (iVar.c() == 0) {
                this.mRegId = str;
            }
        } else if (f.b.equals(a)) {
            if (iVar.c() == 0) {
                this.mAlias = str;
            }
        } else if (f.c.equals(a)) {
            if (iVar.c() == 0) {
                this.mAlias = str;
            }
        } else if (f.f.equals(a)) {
            if (iVar.c() == 0) {
                this.mTopic = str;
            }
        } else if (f.g.equals(a)) {
            if (iVar.c() == 0) {
                this.mTopic = str;
            }
        } else if (f.h.equals(a) && iVar.c() == 0) {
            this.mStartTime = str;
            this.mEndTime = str2;
        }
    }

    public void onReceiveMessage(Context context, j jVar) {
        if (processBetaApkUpgrade(context, jVar)) {
            C0596r.e(TAG, "Processed about page jump");
            return;
        }
        String c = jVar.c();
        C0596r.e(TAG, "Push message receiver:" + c);
        a a = h.a(context).a(context, c);
        if (a != null) {
            a.b();
            EventBus.getDefault().post(a);
        }
    }
}
