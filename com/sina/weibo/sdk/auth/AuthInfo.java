package com.sina.weibo.sdk.auth;

import android.content.Context;
import android.os.Bundle;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.constant.WBPageConstants.ParamKey;
import com.sina.weibo.sdk.utils.Utility;
import com.xiaomi.account.openauth.h;
import com.xiaomi.e.a;

public class AuthInfo {
    private String mAppKey = a.f;
    private String mKeyHash = a.f;
    private String mPackageName = a.f;
    private String mRedirectUrl = a.f;
    private String mScope = a.f;

    public AuthInfo(Context context, String str, String str2, String str3) {
        this.mAppKey = str;
        this.mRedirectUrl = str2;
        this.mScope = str3;
        this.mPackageName = context.getPackageName();
        this.mKeyHash = Utility.getSign(context, this.mPackageName);
    }

    public static AuthInfo parseBundleData(Context context, Bundle bundle) {
        return new AuthInfo(context, bundle.getString(WBConstants.SSO_APP_KEY), bundle.getString(WBConstants.SSO_REDIRECT_URL), bundle.getString(h.M));
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public Bundle getAuthBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(WBConstants.SSO_APP_KEY, this.mAppKey);
        bundle.putString(WBConstants.SSO_REDIRECT_URL, this.mRedirectUrl);
        bundle.putString(h.M, this.mScope);
        bundle.putString(ParamKey.PACKAGENAME, this.mPackageName);
        bundle.putString(WBConstants.SSO_KEY_HASH, this.mKeyHash);
        return bundle;
    }

    public String getKeyHash() {
        return this.mKeyHash;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public String getRedirectUrl() {
        return this.mRedirectUrl;
    }

    public String getScope() {
        return this.mScope;
    }
}
