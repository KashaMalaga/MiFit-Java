package cn.com.smartdevices.bracelet.weibo;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import cn.com.smartdevices.bracelet.model.ThirdLoginState;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.xiaomi.e.a;

public class q {
    private static final String a = "com_weibo_sdk_android";
    private static final String b = "uid";
    private static final String c = "access_token";
    private static final String d = "expires_time";
    private static final String e = "expires_in";
    private static final String f = "refresh_token";
    private static final String g = "nick_name";
    private static final String h = "bind_state";
    private static final String i = "token_ut";
    private static final String j = "syc_token";
    private static final String k = "notice_token_once";

    public static int a(Context context) {
        return context == null ? 0 : context.getSharedPreferences(a, WXMediaMessage.THUMB_LENGTH_LIMIT).getInt(h, 0);
    }

    public static void a(Context context, int i) {
        if (context == null) {
            throw new NullPointerException("context is null");
        }
        Editor edit = context.getSharedPreferences(a, WXMediaMessage.THUMB_LENGTH_LIMIT).edit();
        edit.putInt(h, i);
        edit.commit();
    }

    public static void a(Context context, ThirdLoginState thirdLoginState) {
        if (context != null && thirdLoginState != null) {
            Editor edit = context.getSharedPreferences(a, WXMediaMessage.THUMB_LENGTH_LIMIT).edit();
            if (!a.f.equals(thirdLoginState.uid)) {
                edit.putString(b, thirdLoginState.uid);
            }
            if (!a.f.equals(thirdLoginState.accessToken)) {
                edit.putString(c, thirdLoginState.accessToken);
            }
            if (!a.f.equals(thirdLoginState.expiresTime)) {
                edit.putString(d, thirdLoginState.expiresTime);
            }
            edit.putLong(e, thirdLoginState.expiresIn);
            edit.putLong(i, System.currentTimeMillis());
            edit.putInt(h, thirdLoginState.bindState);
            if (!a.f.equals(thirdLoginState.refreshToken)) {
                edit.putString(f, thirdLoginState.refreshToken);
            }
            if (!a.f.equals(thirdLoginState.nickName)) {
                edit.putString(g, thirdLoginState.nickName);
            }
            edit.commit();
        }
    }

    public static void a(Context context, String str) {
        if (context != null && str != null) {
            Editor edit = context.getSharedPreferences(a, WXMediaMessage.THUMB_LENGTH_LIMIT).edit();
            edit.putString(g, str);
            edit.commit();
        }
    }

    public static void a(Context context, boolean z) {
        Editor edit = context.getSharedPreferences(a, WXMediaMessage.THUMB_LENGTH_LIMIT).edit();
        edit.putBoolean(k, z);
        edit.commit();
    }

    public static void b(Context context, boolean z) {
        if (context == null) {
            throw new NullPointerException("context is null");
        }
        Editor edit = context.getSharedPreferences(a, WXMediaMessage.THUMB_LENGTH_LIMIT).edit();
        edit.putBoolean(j, z);
        edit.commit();
    }

    public static boolean b(Context context) {
        return context == null ? false : context.getSharedPreferences(a, WXMediaMessage.THUMB_LENGTH_LIMIT).contains(h);
    }

    public static boolean c(Context context) {
        return context.getSharedPreferences(a, WXMediaMessage.THUMB_LENGTH_LIMIT).getBoolean(k, false);
    }

    public static boolean d(Context context) {
        return context == null ? false : context.getSharedPreferences(a, WXMediaMessage.THUMB_LENGTH_LIMIT).getBoolean(j, false);
    }

    public static ThirdLoginState e(Context context) {
        if (context == null) {
            return null;
        }
        ThirdLoginState thirdLoginState = new ThirdLoginState();
        SharedPreferences sharedPreferences = context.getSharedPreferences(a, WXMediaMessage.THUMB_LENGTH_LIMIT);
        thirdLoginState.uid = sharedPreferences.getString(b, a.f);
        thirdLoginState.accessToken = sharedPreferences.getString(c, a.f);
        thirdLoginState.expiresTime = sharedPreferences.getString(d, a.f);
        thirdLoginState.expiresIn = sharedPreferences.getLong(e, 0);
        thirdLoginState.expiresIn = sharedPreferences.getLong(e, 0) - ((System.currentTimeMillis() - sharedPreferences.getLong(i, 0)) / 1000);
        thirdLoginState.refreshToken = sharedPreferences.getString(f, a.f);
        thirdLoginState.nickName = sharedPreferences.getString(g, a.f);
        thirdLoginState.bindState = sharedPreferences.getInt(h, 0);
        return thirdLoginState;
    }

    public static boolean f(Context context) {
        return context == null ? false : context.getSharedPreferences(a, WXMediaMessage.THUMB_LENGTH_LIMIT).edit().clear().commit();
    }

    public static boolean g(Context context) {
        if (context == null) {
            return false;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(a, WXMediaMessage.THUMB_LENGTH_LIMIT);
        return sharedPreferences.contains(b) && sharedPreferences.contains(c);
    }

    public static boolean h(Context context) {
        if (context == null) {
            return false;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(a, WXMediaMessage.THUMB_LENGTH_LIMIT);
        return sharedPreferences.contains(b) && sharedPreferences.contains(c);
    }

    public static String i(Context context) {
        return context == null ? null : context.getSharedPreferences(a, WXMediaMessage.THUMB_LENGTH_LIMIT).getString(g, a.f);
    }

    public static void j(Context context) {
        if (context != null) {
            Editor edit = context.getSharedPreferences(a, WXMediaMessage.THUMB_LENGTH_LIMIT).edit();
            edit.clear();
            edit.commit();
        }
    }
}
