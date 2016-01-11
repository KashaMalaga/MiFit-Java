package cn.com.smartdevices.bracelet.tencent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import com.c.a.C0993k;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.tencent.connect.UserInfo;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import com.xiaomi.e.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class QQLogin {
    public static final String DEFAULT_APP_ID = "1103177325";
    public static final String KEY_ACCESS_TOKEN = "access_token";
    public static final String KEY_COUSUMER_KEY = "oauth_consumer_key";
    public static final String KEY_EXPIRES_IN = "expires_in";
    public static final String KEY_FROM = "from";
    public static final String KEY_OPEN_ID = "openid";
    public static final String KEY_RESULT = "ret";
    public static final String KEY_USER_AVATAR = "figureurl_qq_2";
    public static final String KEY_USER_INFO = "UserInfo";
    public static final String KEY_USER_NICKNAME = "nickname";
    public static final String PERMISSION_ALL = "all";
    public static final String PERMISSION_HEALTH = "get_user_info,health";
    private static final String TAG = "QQ.Login";
    private static QQLogin sLogin;
    private Context mContext;
    public boolean mIsFromQQ;
    private Class<? extends Activity> mLaunchActivity;
    private boolean mLoginCanceled;
    private IUiListener mLoginListener;
    private String mMiID;
    private boolean mNeedLogin;
    private boolean mNeedSwitchLogin;
    private SharedPreferences mPrefs;
    private QQUserInfo mQQUserInfo;
    private Tencent mTencent;
    private UserInfo mUserInfo;
    private IUiListener mUserInfoListener;

    public class QQUserInfo {
        private String avatarUrl;
        private String nickName;

        public String getAvatarUrl() {
            return this.avatarUrl;
        }

        public String getNickName() {
            return this.nickName;
        }

        public void setAvatarUrl(String str) {
            this.avatarUrl = str;
        }

        public void setNickName(String str) {
            this.nickName = str;
        }
    }

    private QQLogin(Context context) {
        this.mContext = context;
        this.mPrefs = context.getSharedPreferences(TAG, 0);
        String str = DEFAULT_APP_ID;
        C0596r.e(TAG, "Create Tencent Instance : " + str);
        this.mTencent = Tencent.createInstance(str, this.mContext);
    }

    public static String fetchMiID() {
        String valueOf = String.valueOf(Keeper.readPersonInfoBaseUID().uid);
        return (valueOf == null || WeiboAuthException.DEFAULT_AUTH_ERROR_CODE.equals(valueOf)) ? a.f : valueOf;
    }

    public static QQLogin getInstance() {
        return sLogin;
    }

    public static QQLogin getInstance(Context context) {
        if (sLogin == null) {
            sLogin = new QQLogin(context);
        }
        if (TextUtils.isEmpty(sLogin.mMiID)) {
            sLogin.mMiID = fetchMiID();
            sLogin.restoreOAuthInfo();
            sLogin.restoreQQUserInfo();
        }
        return sLogin;
    }

    private void onUserInfoReceived(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject.optInt(KEY_RESULT, -1) == 0) {
                C0596r.e(TAG, "Request User Info Success!");
                this.mQQUserInfo = new QQUserInfo();
                this.mQQUserInfo.setNickName(jSONObject.optString(KEY_USER_NICKNAME));
                this.mQQUserInfo.setAvatarUrl(jSONObject.optString(KEY_USER_AVATAR));
                saveQQUserInfo(this.mQQUserInfo);
                C0401a.a(this.mContext, C0401a.fb);
                return;
            }
            C0401a.a(this.mContext, C0401a.fc, obj.toString());
        } catch (Exception e) {
            e.printStackTrace();
            C0401a.a(this.mContext, e);
        }
    }

    private void restoreOAuthInfo() {
        String string = this.mPrefs.getString(KEY_OPEN_ID + this.mMiID, null);
        String string2 = string == null ? this.mPrefs.getString(KEY_OPEN_ID, null) : string;
        if (string2 != null) {
            this.mTencent.setOpenId(string2);
            string = this.mPrefs.getString(KEY_ACCESS_TOKEN + this.mMiID, null);
            if (string == null) {
                string = this.mPrefs.getString(KEY_ACCESS_TOKEN, null);
            }
            String string3 = this.mPrefs.getString(KEY_EXPIRES_IN + this.mMiID, null);
            if (string3 == null) {
                string3 = this.mPrefs.getString(KEY_EXPIRES_IN, null);
            }
            if (!(string == null || string3 == null)) {
                string3 = String.valueOf((Long.valueOf(string3).longValue() - System.currentTimeMillis()) / 1000);
                this.mTencent.setAccessToken(string, string3);
            }
            C0596r.e(TAG, "Read : OpenId = " + string2 + " , AccessToken = " + string + " , ExpiresIn = " + string3);
        }
    }

    private void restoreQQUserInfo() {
        if (isLoginValid()) {
            String string = this.mPrefs.getString(KEY_USER_INFO + this.mMiID, null);
            if (string == null) {
                string = this.mPrefs.getString(KEY_USER_INFO, null);
            }
            C0596r.e(TAG, "Read User Info : " + string);
            if (string != null) {
                this.mQQUserInfo = (QQUserInfo) new C0993k().a(string, QQUserInfo.class);
            }
        }
    }

    private void saveQQUserInfo(QQUserInfo qQUserInfo) {
        String b = new C0993k().b((Object) qQUserInfo);
        C0596r.e(TAG, "Save User Info : " + b);
        Editor edit = this.mPrefs.edit();
        edit.putString(KEY_USER_INFO + this.mMiID, b);
        edit.commit();
    }

    public void clean(boolean z) {
        if (z) {
            this.mQQUserInfo = null;
            Editor edit = this.mPrefs.edit();
            edit.remove(KEY_USER_INFO);
            edit.remove(KEY_OPEN_ID);
            edit.remove(KEY_ACCESS_TOKEN);
            edit.remove(KEY_EXPIRES_IN);
            edit.remove(KEY_USER_INFO + this.mMiID);
            edit.remove(KEY_OPEN_ID + this.mMiID);
            edit.remove(KEY_ACCESS_TOKEN + this.mMiID);
            edit.remove(KEY_EXPIRES_IN + this.mMiID);
            edit.commit();
            return;
        }
        sLogin = null;
    }

    public Class<? extends Activity> getLaunchActivity() {
        return this.mLaunchActivity;
    }

    public Map<String, String> getOAuthInfo() {
        Map<String, String> hashMap = new HashMap();
        if (isLoginValid()) {
            hashMap.put(KEY_ACCESS_TOKEN, this.mTencent.getAccessToken());
            hashMap.put(KEY_COUSUMER_KEY, this.mTencent.getAppId());
            hashMap.put(KEY_OPEN_ID, this.mTencent.getOpenId());
            hashMap.put(Constants.PARAM_PLATFORM_ID, Constants.SOURCE_QZONE);
        }
        return hashMap;
    }

    public QQUserInfo getQQUserInfo() {
        return this.mQQUserInfo;
    }

    public Tencent getTencent() {
        return this.mTencent;
    }

    public boolean isLoginCanceled() {
        return this.mLoginCanceled;
    }

    public boolean isLoginValid() {
        return this.mTencent.isSessionValid() && this.mTencent.getOpenId() != null;
    }

    public boolean isNeedLogin() {
        return this.mNeedLogin;
    }

    public boolean isNeedSwitchLogin() {
        return this.mNeedSwitchLogin;
    }

    public void login(Activity activity) {
        C0596r.e(TAG, "Login : " + (!isLoginValid()));
        if (!isLoginValid()) {
            this.mTencent.login(activity, PERMISSION_ALL, new IUiListener() {
                public void onCancel() {
                    QQLogin.this.onLoginCancel();
                    if (QQLogin.this.mLoginListener != null) {
                        QQLogin.this.mLoginListener.onCancel();
                    }
                }

                public void onComplete(Object obj) {
                    QQLogin.this.onLoginComplete(obj);
                    if (QQLogin.this.mLoginListener != null) {
                        QQLogin.this.mLoginListener.onComplete(obj);
                    }
                }

                public void onError(UiError uiError) {
                    QQLogin.this.onLoginError(uiError);
                    if (QQLogin.this.mLoginListener != null) {
                        QQLogin.this.mLoginListener.onError(uiError);
                    }
                }
            });
        }
    }

    public void logout() {
        C0596r.e(TAG, "Logout");
        this.mTencent.logout(this.mContext);
    }

    protected void onLoginCancel() {
        C0596r.e(TAG, "Login Cancel!");
        C0401a.a(this.mContext, C0401a.eU);
    }

    protected void onLoginComplete(Object obj) {
        C0596r.e(TAG, "Login Complete : " + obj);
        try {
            if (((JSONObject) obj).optInt(KEY_RESULT, -1) == 0) {
                C0401a.a(this.mContext, C0401a.eW);
            } else {
                C0401a.a(this.mContext, C0401a.eX, obj.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            C0401a.a(this.mContext, e);
        }
    }

    protected void onLoginError(UiError uiError) {
        C0596r.e(TAG, "Login Error : " + uiError);
        if (uiError != null) {
            C0401a.a(this.mContext, C0401a.eV, "Code:" + uiError.errorCode + "Msg:" + uiError.errorMessage + ",Detail:" + uiError.errorDetail);
            return;
        }
        C0401a.a(this.mContext, C0401a.eV);
    }

    public void onResult(int i, int i2, Intent intent) {
        this.mTencent.onActivityResult(i, i2, intent);
    }

    public void requestUserInfo() {
        C0596r.e(TAG, "Request User Info : " + isLoginValid());
        if (isLoginValid()) {
            this.mUserInfo = new UserInfo(this.mContext, this.mTencent.getQQToken());
            this.mUserInfo.getUserInfo(new IUiListener() {
                public void onCancel() {
                    C0596r.e(QQLogin.TAG, "Request UserInfo Cancel!");
                    if (QQLogin.this.mUserInfoListener != null) {
                        QQLogin.this.mUserInfoListener.onCancel();
                    }
                }

                public void onComplete(Object obj) {
                    C0596r.e(QQLogin.TAG, "Request UserInfo Complete : " + obj);
                    QQLogin.this.onUserInfoReceived(obj);
                    if (QQLogin.this.mUserInfoListener != null) {
                        QQLogin.this.mUserInfoListener.onComplete(obj);
                    }
                }

                public void onError(UiError uiError) {
                    C0596r.e(QQLogin.TAG, "Request UserInfo Error : " + uiError);
                    if (uiError != null) {
                        C0401a.a(QQLogin.this.mContext, C0401a.fa, uiError.toString());
                    } else {
                        C0401a.a(QQLogin.this.mContext, C0401a.fa);
                    }
                    if (QQLogin.this.mUserInfoListener != null) {
                        QQLogin.this.mUserInfoListener.onError(uiError);
                    }
                }
            });
            C0401a.a(this.mContext, C0401a.eZ);
        }
    }

    public void saveOAuthInfo() {
        String openId = this.mTencent.getOpenId();
        String accessToken = this.mTencent.getAccessToken();
        long expiresIn = this.mTencent.getExpiresIn();
        C0596r.e(TAG, "Save : OpenId = " + openId + " , AccessToken = " + accessToken + " , ExpiresIn = " + expiresIn);
        Editor edit = this.mPrefs.edit();
        edit.putString(KEY_OPEN_ID + this.mMiID, openId);
        edit.putString(KEY_ACCESS_TOKEN + this.mMiID, accessToken);
        edit.putString(KEY_EXPIRES_IN + this.mMiID, String.valueOf(expiresIn));
        edit.commit();
    }

    public void setLaunchActivity(Class<? extends Activity> cls) {
        this.mLaunchActivity = cls;
    }

    public void setLoginCanceled(boolean z) {
        this.mLoginCanceled = z;
    }

    public void setLoginListener(IUiListener iUiListener) {
        this.mLoginListener = iUiListener;
    }

    public void setNeedLogin(boolean z) {
        this.mNeedLogin = z;
    }

    public void setNeedSwitchLogin(boolean z) {
        this.mNeedSwitchLogin = z;
    }

    public void setUserInfoListener(IUiListener iUiListener) {
        this.mUserInfoListener = iUiListener;
    }
}
