package com.sina.weibo.sdk.auth.sso;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sina.sso.RemoteSSO;
import com.sina.sso.RemoteSSO.Stub;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.WeiboAppManager.WeiboInfo;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.exception.WeiboDialogException;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.utils.AidTask;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.SecurityHelper;
import com.sina.weibo.sdk.utils.Utility;
import com.xiaomi.account.openauth.h;
import kankan.wheel.widget.a;

public class SsoHandler {
    public static final String AUTH_FAILED_MSG = "auth failed!!!!!";
    public static final String AUTH_FAILED_NOT_INSTALL_MSG = "not install weibo client!!!!!";
    private static final String DEFAULT_WEIBO_REMOTE_SSO_SERVICE_NAME = "com.sina.weibo.remotessoservice";
    private static final int REQUEST_CODE_SSO_AUTH = 32973;
    private static final String TAG = "Weibo_SSO_login";
    private Activity mAuthActivity;
    private AuthInfo mAuthInfo;
    private WeiboAuthListener mAuthListener;
    private ServiceConnection mConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            RemoteSSO asInterface = Stub.asInterface(iBinder);
            try {
                String packageName = asInterface.getPackageName();
                String activityName = asInterface.getActivityName();
                SsoHandler.this.mAuthActivity.getApplicationContext().unbindService(SsoHandler.this.mConnection);
                if (!SsoHandler.this.startSingleSignOn(packageName, activityName)) {
                    SsoHandler.this.mWebAuthHandler.anthorize(SsoHandler.this.mAuthListener);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            SsoHandler.this.mWebAuthHandler.anthorize(SsoHandler.this.mAuthListener);
        }
    };
    private int mSSOAuthRequestCode;
    private WebAuthHandler mWebAuthHandler;
    private WeiboInfo mWeiboInfo;

    enum AuthType {
        ALL,
        SsoOnly,
        WebOnly
    }

    public SsoHandler(Activity activity, AuthInfo authInfo) {
        this.mAuthActivity = activity;
        this.mAuthInfo = authInfo;
        this.mWebAuthHandler = new WebAuthHandler(activity, authInfo);
        this.mWeiboInfo = WeiboAppManager.getInstance(activity).getWeiboInfo();
        AidTask.getInstance(this.mAuthActivity).aidTaskInit(authInfo.getAppKey());
    }

    private void authorize(int i, WeiboAuthListener weiboAuthListener, AuthType authType) {
        this.mSSOAuthRequestCode = i;
        this.mAuthListener = weiboAuthListener;
        Object obj = null;
        if (authType == AuthType.SsoOnly) {
            obj = 1;
        }
        if (authType == AuthType.WebOnly) {
            if (weiboAuthListener != null) {
                this.mWebAuthHandler.anthorize(weiboAuthListener);
            }
        } else if (!bindRemoteSSOService(this.mAuthActivity.getApplicationContext())) {
            if (obj == null) {
                this.mWebAuthHandler.anthorize(this.mAuthListener);
            } else if (this.mAuthListener != null) {
                this.mAuthListener.onWeiboException(new WeiboException(AUTH_FAILED_NOT_INSTALL_MSG));
            }
        }
    }

    private boolean bindRemoteSSOService(Context context) {
        if (!isWeiboAppInstalled()) {
            return false;
        }
        String packageName = this.mWeiboInfo.getPackageName();
        Intent intent = new Intent(DEFAULT_WEIBO_REMOTE_SSO_SERVICE_NAME);
        intent.setPackage(packageName);
        return context.bindService(intent, this.mConnection, 1);
    }

    public static ComponentName isServiceExisted(Context context, String str) {
        for (RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE)) {
            ComponentName componentName = runningServiceInfo.service;
            if (componentName.getPackageName().equals(str) && componentName.getClassName().equals(new StringBuilder(String.valueOf(str)).append(".business.RemoteSSOService").toString())) {
                return componentName;
            }
        }
        return null;
    }

    private boolean startSingleSignOn(String str, String str2) {
        boolean z = true;
        Intent intent = new Intent();
        intent.setClassName(str, str2);
        intent.putExtras(this.mWebAuthHandler.getAuthInfo().getAuthBundle());
        intent.putExtra(WBConstants.COMMAND_TYPE_KEY, 3);
        intent.putExtra(WBConstants.TRAN, String.valueOf(System.currentTimeMillis()));
        intent.putExtra(WBConstants.AUTH_PARAMS_AID, Utility.getAid(this.mAuthActivity, this.mAuthInfo.getAppKey()));
        if (!SecurityHelper.validateAppSignatureForIntent(this.mAuthActivity, intent)) {
            return false;
        }
        Object aid = Utility.getAid(this.mAuthActivity, this.mAuthInfo.getAppKey());
        if (!TextUtils.isEmpty(aid)) {
            intent.putExtra(WBConstants.AUTH_PARAMS_AID, aid);
        }
        try {
            this.mAuthActivity.startActivityForResult(intent, this.mSSOAuthRequestCode);
        } catch (ActivityNotFoundException e) {
            z = false;
        }
        return z;
    }

    public void authorize(WeiboAuthListener weiboAuthListener) {
        authorize(REQUEST_CODE_SSO_AUTH, weiboAuthListener, AuthType.ALL);
    }

    public void authorizeCallBack(int i, int i2, Intent intent) {
        LogUtil.d(TAG, "requestCode: " + i + ", resultCode: " + i2 + ", data: " + intent);
        if (i != this.mSSOAuthRequestCode) {
            return;
        }
        if (i2 == -1) {
            if (SecurityHelper.checkResponseAppLegal(this.mAuthActivity, this.mWeiboInfo, intent)) {
                String stringExtra = intent.getStringExtra(h.P);
                if (stringExtra == null) {
                    stringExtra = intent.getStringExtra("error_type");
                }
                if (stringExtra == null) {
                    Bundle extras = intent.getExtras();
                    Oauth2AccessToken parseAccessToken = Oauth2AccessToken.parseAccessToken(extras);
                    if (parseAccessToken == null || !parseAccessToken.isSessionValid()) {
                        LogUtil.d(TAG, "Failed to receive access token by SSO");
                        this.mWebAuthHandler.anthorize(this.mAuthListener);
                        return;
                    }
                    LogUtil.d(TAG, "Login Success! " + parseAccessToken.toString());
                    this.mAuthListener.onComplete(extras);
                } else if (stringExtra.equals("access_denied") || stringExtra.equals("OAuthAccessDeniedException")) {
                    LogUtil.d(TAG, "Login canceled by user.");
                    this.mAuthListener.onCancel();
                } else {
                    String stringExtra2 = intent.getStringExtra(h.Q);
                    if (stringExtra2 != null) {
                        stringExtra = new StringBuilder(String.valueOf(stringExtra)).append(a.ci).append(stringExtra2).toString();
                    }
                    LogUtil.d(TAG, "Login failed: " + stringExtra);
                    this.mAuthListener.onWeiboException(new WeiboDialogException(stringExtra, i2, stringExtra2));
                }
            }
        } else if (i2 != 0) {
        } else {
            if (intent != null) {
                LogUtil.d(TAG, "Login failed: " + intent.getStringExtra(h.P));
                this.mAuthListener.onWeiboException(new WeiboDialogException(intent.getStringExtra(h.P), intent.getIntExtra("error_code", -1), intent.getStringExtra("failing_url")));
                return;
            }
            LogUtil.d(TAG, "Login canceled by user.");
            this.mAuthListener.onCancel();
        }
    }

    public void authorizeClientSso(WeiboAuthListener weiboAuthListener) {
        authorize(REQUEST_CODE_SSO_AUTH, weiboAuthListener, AuthType.SsoOnly);
    }

    public void authorizeWeb(WeiboAuthListener weiboAuthListener) {
        authorize(REQUEST_CODE_SSO_AUTH, weiboAuthListener, AuthType.WebOnly);
    }

    public boolean isWeiboAppInstalled() {
        return this.mWeiboInfo != null && this.mWeiboInfo.isLegal();
    }
}
