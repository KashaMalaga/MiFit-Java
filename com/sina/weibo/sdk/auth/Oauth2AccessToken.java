package com.sina.weibo.sdk.auth;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.xiaomi.e.a;
import org.json.JSONException;
import org.json.JSONObject;

public class Oauth2AccessToken {
    private static final String KEY_ACCESS_TOKEN = "access_token";
    private static final String KEY_EXPIRES_IN = "expires_in";
    private static final String KEY_REFRESH_TOKEN = "refresh_token";
    private static final String KEY_UID = "uid";
    private String mAccessToken = a.f;
    private long mExpiresTime = 0;
    private String mRefreshToken = a.f;
    private String mUid = a.f;

    @Deprecated
    public Oauth2AccessToken(String str) {
        if (str != null && str.indexOf("{") >= 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                setUid(jSONObject.optString(KEY_UID));
                setToken(jSONObject.optString(KEY_ACCESS_TOKEN));
                setExpiresIn(jSONObject.optString(KEY_EXPIRES_IN));
                setRefreshToken(jSONObject.optString(KEY_REFRESH_TOKEN));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public Oauth2AccessToken(String str, String str2) {
        this.mAccessToken = str;
        this.mExpiresTime = System.currentTimeMillis();
        if (str2 != null) {
            this.mExpiresTime += Long.parseLong(str2) * 1000;
        }
    }

    private static String getString(Bundle bundle, String str, String str2) {
        if (bundle == null) {
            return str2;
        }
        String string = bundle.getString(str);
        return string != null ? string : str2;
    }

    public static Oauth2AccessToken parseAccessToken(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        Oauth2AccessToken oauth2AccessToken = new Oauth2AccessToken();
        oauth2AccessToken.setUid(getString(bundle, KEY_UID, a.f));
        oauth2AccessToken.setToken(getString(bundle, KEY_ACCESS_TOKEN, a.f));
        oauth2AccessToken.setExpiresIn(getString(bundle, KEY_EXPIRES_IN, a.f));
        oauth2AccessToken.setRefreshToken(getString(bundle, KEY_REFRESH_TOKEN, a.f));
        return oauth2AccessToken;
    }

    public static Oauth2AccessToken parseAccessToken(String str) {
        if (!TextUtils.isEmpty(str) && str.indexOf("{") >= 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Oauth2AccessToken oauth2AccessToken = new Oauth2AccessToken();
                oauth2AccessToken.setUid(jSONObject.optString(KEY_UID));
                oauth2AccessToken.setToken(jSONObject.optString(KEY_ACCESS_TOKEN));
                oauth2AccessToken.setExpiresIn(jSONObject.optString(KEY_EXPIRES_IN));
                oauth2AccessToken.setRefreshToken(jSONObject.optString(KEY_REFRESH_TOKEN));
                return oauth2AccessToken;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public long getExpiresTime() {
        return this.mExpiresTime;
    }

    public String getRefreshToken() {
        return this.mRefreshToken;
    }

    public String getToken() {
        return this.mAccessToken;
    }

    public String getUid() {
        return this.mUid;
    }

    public boolean isSessionValid() {
        return !TextUtils.isEmpty(this.mAccessToken);
    }

    public void setExpiresIn(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(Constants.VIA_RESULT_SUCCESS)) {
            setExpiresTime(System.currentTimeMillis() + (Long.parseLong(str) * 1000));
        }
    }

    public void setExpiresTime(long j) {
        this.mExpiresTime = j;
    }

    public void setRefreshToken(String str) {
        this.mRefreshToken = str;
    }

    public void setToken(String str) {
        this.mAccessToken = str;
    }

    public void setUid(String str) {
        this.mUid = str;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_UID, this.mUid);
        bundle.putString(KEY_ACCESS_TOKEN, this.mAccessToken);
        bundle.putString(KEY_REFRESH_TOKEN, this.mRefreshToken);
        bundle.putString(KEY_EXPIRES_IN, Long.toString(this.mExpiresTime));
        return bundle;
    }

    public String toString() {
        return "uid: " + this.mUid + ", " + KEY_ACCESS_TOKEN + ": " + this.mAccessToken + ", " + KEY_REFRESH_TOKEN + ": " + this.mRefreshToken + ", " + KEY_EXPIRES_IN + ": " + Long.toString(this.mExpiresTime);
    }
}
