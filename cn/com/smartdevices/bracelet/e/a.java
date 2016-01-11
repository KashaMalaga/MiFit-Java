package cn.com.smartdevices.bracelet.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import cn.com.smartdevices.bracelet.model.LoginData;
import java.util.Locale;

public class a {
    public static final String a = "CURRENT_USER_ID";
    public static final String b = "device_id";
    public static final String c = "uid";
    public static final String d = "security";
    private static final String e = "keeper";

    public static String a(Context context) {
        return context.getSharedPreferences(e, 0).getString("debug_channel", com.xiaomi.e.a.f);
    }

    public static void a(Context context, long j, String str) {
        Editor edit = context.getSharedPreferences(e, 0).edit();
        edit.putLong(c, j);
        edit.putString(d, str);
        edit.commit();
    }

    public static void a(Context context, String str) {
        Editor edit = context.getSharedPreferences(e, 0).edit();
        edit.putString(b, str);
        edit.commit();
    }

    public static String b(Context context) {
        return context.getSharedPreferences(e, 0).getString("debug_host", com.xiaomi.e.a.f);
    }

    @SuppressLint({"NewApi"})
    public static void b(Context context, String str) {
        Editor edit = context.getSharedPreferences(e, 0).edit();
        edit.putString("debug_channel", str);
        edit.apply();
    }

    public static String c(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(e, 0);
        Locale locale = Locale.getDefault();
        Editor edit = sharedPreferences.edit();
        edit.putString("Locale", locale.toString());
        edit.commit();
        return locale.toString();
    }

    @SuppressLint({"NewApi"})
    public static void c(Context context, String str) {
        Editor edit = context.getSharedPreferences(e, 0).edit();
        edit.putString("debug_host", str);
        edit.apply();
    }

    public static String d(Context context) {
        return context.getSharedPreferences(e, 0).getString(b, com.xiaomi.e.a.f);
    }

    public static String e(Context context) {
        return context.getSharedPreferences(e, 0).getString("Locale", com.xiaomi.e.a.f);
    }

    public static LoginData f(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(e, 0);
        LoginData loginData = new LoginData();
        loginData.uid = sharedPreferences.getLong(c, -1);
        loginData.security = sharedPreferences.getString(d, null);
        return loginData;
    }
}
