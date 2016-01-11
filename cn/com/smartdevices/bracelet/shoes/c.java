package cn.com.smartdevices.bracelet.shoes;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import kankan.wheel.widget.a;

public class c {
    private static final String a = "ShoesKeeper";
    private static final String b = "SyncSystemDeviceToServer:";
    private static final String c = "BoundState";
    private static final String d = "RTStepCnt";
    private static final String e = "StatisticTime";
    private static final String f = "SyncRTStepTime";
    private static final String g = "SyncDeviceTime";
    private static final int h = 2;
    private static final int i = 1;
    private static final String j = "v";

    public static String a(Context context, String str) {
        if (context == null) {
            return j;
        }
        if (!TextUtils.isEmpty(str)) {
            return context.getSharedPreferences(a, 4).getString(str + a.ci + j, j);
        }
        throw new IllegalArgumentException();
    }

    public static void a(Context context, int i) {
        if (context != null) {
            context.getSharedPreferences(a, 4).edit().putInt(d, i).commit();
        }
    }

    public static void a(Context context, long j) {
        if (context != null) {
            context.getSharedPreferences(a, 4).edit().putLong(e, j).commit();
        }
    }

    public static void a(Context context, String str, boolean z) {
        if (context != null) {
            Editor edit = context.getSharedPreferences(a, 4).edit();
            edit.putInt(b + str, z ? h : i);
            edit.commit();
        }
    }

    public static void a(Context context, boolean z) {
        if (context != null) {
            context.getSharedPreferences(a, 4).edit().putBoolean(c, z).commit();
        }
    }

    public static boolean a(Context context) {
        return context == null ? false : context.getSharedPreferences(a, 4).getBoolean(c, false);
    }

    public static boolean a(Context context, String str, String str2) {
        return (context == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) ? false : context.getSharedPreferences(a, 4).edit().putString(str + a.ci + j, str2).commit();
    }

    public static int b(Context context) {
        return context == null ? -1 : context.getSharedPreferences(a, 4).getInt(d, -1);
    }

    public static String b(Context context, String str) {
        if (context == null) {
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            return context.getSharedPreferences(a, 4).getString(str, com.xiaomi.e.a.f);
        }
        throw new IllegalArgumentException();
    }

    public static void b(Context context, int i) {
    }

    public static void b(Context context, long j) {
        if (context != null) {
            context.getSharedPreferences(a, 4).edit().putLong(g, j).commit();
        }
    }

    public static boolean b(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return false;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(a, 4);
        return TextUtils.isEmpty(sharedPreferences.getString(str, com.xiaomi.e.a.f)) ? sharedPreferences.edit().putString(str, str2).commit() : true;
    }

    public static int c(Context context, String str) {
        return context == null ? 0 : context.getSharedPreferences(a, 4).getInt(b + str, 0);
    }

    public static long c(Context context) {
        return context == null ? -1 : context.getSharedPreferences(a, 4).getLong(e, -1);
    }

    public static void c(Context context, long j) {
        if (context != null) {
            context.getSharedPreferences(a, 4).edit().putLong(f, j).commit();
        }
    }

    public static long d(Context context) {
        return context == null ? -1 : context.getSharedPreferences(a, 4).getLong(g, 0);
    }

    public static boolean d(Context context, String str) {
        return context != null && context.getSharedPreferences(a, 4).getInt(b + str, 0) == h;
    }

    public static long e(Context context) {
        return context == null ? -1 : context.getSharedPreferences(a, 4).getLong(f, 0);
    }

    static void f(Context context) {
        if (context != null) {
            context.getSharedPreferences(a, 4).edit().clear().commit();
        }
    }
}
