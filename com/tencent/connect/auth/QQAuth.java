package com.tencent.connect.auth;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v4.app.Fragment;
import android.support.v4.view.a.C0113o;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import android.widget.Toast;
import com.tencent.connect.a.a;
import com.tencent.connect.common.BaseApi;
import com.tencent.open.a.f;
import com.tencent.open.utils.ApkExternalInfoTool;
import com.tencent.open.utils.Global;
import com.tencent.tauth.IUiListener;
import java.io.File;
import java.io.IOException;

public class QQAuth {
    private AuthAgent a = new AuthAgent(this.b);
    private QQToken b;

    private QQAuth(String str, Context context) {
        f.c("openSDK_LOG", "new QQAuth() --start");
        this.b = new QQToken(str);
        a.c(context, this.b);
        f.c("openSDK_LOG", "new QQAuth() --end");
    }

    private int a(Activity activity, Fragment fragment, String str, IUiListener iUiListener, String str2) {
        String str3;
        String packageName = activity.getApplicationContext().getPackageName();
        for (ApplicationInfo applicationInfo : activity.getPackageManager().getInstalledApplications(C0113o.h)) {
            if (packageName.equals(applicationInfo.packageName)) {
                str3 = applicationInfo.sourceDir;
                break;
            }
        }
        str3 = null;
        if (str3 != null) {
            try {
                String readChannelId = ApkExternalInfoTool.readChannelId(new File(str3));
                if (!TextUtils.isEmpty(readChannelId)) {
                    f.b("openSDK_LOG", "-->login channelId: " + readChannelId);
                    return loginWithOEM(activity, str, iUiListener, readChannelId, readChannelId, com.xiaomi.e.a.f);
                }
            } catch (IOException e) {
                f.b("openSDK_LOG", "-->login get channel id exception." + e.getMessage());
                e.printStackTrace();
            }
        }
        f.b("openSDK_LOG", "-->login channelId is null ");
        BaseApi.isOEM = false;
        return this.a.doLogin(activity, str, iUiListener, false, fragment);
    }

    public static QQAuth createInstance(String str, Context context) {
        Global.setContext(context.getApplicationContext());
        f.c("openSDK_LOG", "QQAuth -- createInstance() --start");
        try {
            PackageManager packageManager = context.getPackageManager();
            packageManager.getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.tauth.AuthActivity"), 0);
            packageManager.getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.connect.common.AssistActivity"), 0);
            QQAuth qQAuth = new QQAuth(str, context);
            f.c("openSDK_LOG", "QQAuth -- createInstance()  --end");
            return qQAuth;
        } catch (Throwable e) {
            f.b("openSDK_LOG", "createInstance() error --end", e);
            Toast.makeText(context.getApplicationContext(), "\u8bf7\u53c2\u7167\u6587\u6863\u5728Androidmanifest.xml\u52a0\u4e0aAuthActivity\u548cAssitActivity\u7684\u5b9a\u4e49 ", 1).show();
            return null;
        }
    }

    public void checkLogin(IUiListener iUiListener) {
        this.a.b(iUiListener);
    }

    public QQToken getQQToken() {
        return this.b;
    }

    public boolean isSessionValid() {
        f.a("openSDK_LOG", "isSessionValid(), result = " + (this.b.isSessionValid() ? "true" : "false") + com.xiaomi.e.a.f);
        return this.b.isSessionValid();
    }

    public int login(Activity activity, String str, IUiListener iUiListener) {
        f.c("openSDK_LOG", "login()");
        return login(activity, str, iUiListener, com.xiaomi.e.a.f);
    }

    public int login(Activity activity, String str, IUiListener iUiListener, String str2) {
        f.c("openSDK_LOG", "-->login activity: " + activity);
        return a(activity, null, str, iUiListener, str2);
    }

    public int login(Fragment fragment, String str, IUiListener iUiListener, String str2) {
        Activity activity = fragment.getActivity();
        f.c("openSDK_LOG", "-->login activity: " + activity);
        return a(activity, fragment, str, iUiListener, str2);
    }

    @Deprecated
    public int loginWithOEM(Activity activity, String str, IUiListener iUiListener, String str2, String str3, String str4) {
        f.c("openSDK_LOG", "loginWithOEM");
        BaseApi.isOEM = true;
        if (str2.equals(com.xiaomi.e.a.f)) {
            str2 = "null";
        }
        if (str3.equals(com.xiaomi.e.a.f)) {
            str3 = "null";
        }
        if (str4.equals(com.xiaomi.e.a.f)) {
            str4 = "null";
        }
        BaseApi.installChannel = str3;
        BaseApi.registerChannel = str2;
        BaseApi.businessId = str4;
        return this.a.doLogin(activity, str, iUiListener);
    }

    public void logout(Context context) {
        f.c("openSDK_LOG", "logout() --start");
        CookieSyncManager.createInstance(context);
        setAccessToken(null, null);
        setOpenId(context, null);
        f.c("openSDK_LOG", "logout() --end");
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        f.c("openSDK_LOG", "onActivityResult() ,resultCode = " + i2 + com.xiaomi.e.a.f);
        return true;
    }

    public int reAuth(Activity activity, String str, IUiListener iUiListener) {
        f.c("openSDK_LOG", "reAuth()");
        return this.a.doLogin(activity, str, iUiListener, true, null);
    }

    public void reportDAU() {
        this.a.a(null);
    }

    public void setAccessToken(String str, String str2) {
        f.a("openSDK_LOG", "setAccessToken(), validTimeInSecond = " + str2 + com.xiaomi.e.a.f);
        this.b.setAccessToken(str, str2);
    }

    public void setOpenId(Context context, String str) {
        f.a("openSDK_LOG", "setOpenId() --start");
        this.b.setOpenId(str);
        a.d(context, this.b);
        f.a("openSDK_LOG", "setOpenId() --end");
    }
}
