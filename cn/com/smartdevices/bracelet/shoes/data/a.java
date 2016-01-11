package cn.com.smartdevices.bracelet.shoes.data;

import android.content.Context;
import android.content.SharedPreferences.Editor;

public class a {
    private static final String a = "ShoesConfig";
    private static final String b = "WifiConnTime";
    private static final int c = 20000;
    private static final String d = "PartnerState";
    private static final String e = "SkipCalibrateInformed";
    private static final String f = "InitSyncedState:";
    private static final String g = "HistorySyncedState:";
    private static final String h = "SyncedDeviceIds";
    private static final int i = 0;
    private static final int j = 1;

    private a() {
    }

    public static void a(Context context) {
        if (context != null) {
            context.getSharedPreferences(a, 4).edit().clear().commit();
        }
    }

    public static boolean a(Context context, long j) {
        return context != null && j - context.getSharedPreferences(a, 4).getLong(b, 0) > 20000;
    }

    public static boolean a(Context context, String str) {
        return context == null ? false : context.getSharedPreferences(a, 4).getBoolean(g + str, false);
    }

    public static boolean a(Context context, String str, boolean z) {
        return context == null ? false : context.getSharedPreferences(a, 4).edit().putBoolean(g + str, z).commit();
    }

    public static boolean a(Context context, boolean z) {
        return context == null ? false : context.getSharedPreferences(a, 4).edit().putBoolean(h, z).commit();
    }

    public static boolean b(Context context) {
        return context == null ? false : context.getSharedPreferences(a, 4).getBoolean(h, false);
    }

    public static boolean b(Context context, long j) {
        return context == null ? false : context.getSharedPreferences(a, 4).edit().putLong(b, j).commit();
    }

    public static boolean b(Context context, String str) {
        return context == null ? false : context.getSharedPreferences(a, 4).getBoolean(f + str, false);
    }

    public static boolean b(Context context, String str, boolean z) {
        return context == null ? false : context.getSharedPreferences(a, 4).edit().putBoolean(f + str, z).commit();
    }

    public static boolean b(Context context, boolean z) {
        int i = i;
        if (context == null) {
            return false;
        }
        Editor edit = context.getSharedPreferences(a, 4).edit();
        String str = d;
        if (z) {
            i = j;
        }
        return edit.putInt(str, i).commit();
    }

    public static boolean c(Context context) {
        boolean z = true;
        if (context == null) {
            return false;
        }
        if (context.getSharedPreferences(a, 4).getInt(d, i) != j) {
            z = false;
        }
        return z;
    }

    public static boolean d(Context context) {
        return context == null ? false : context.getSharedPreferences(a, 4).getBoolean(e, false);
    }

    public static boolean e(Context context) {
        return context == null ? false : context.getSharedPreferences(a, 4).edit().putBoolean(e, true).commit();
    }
}
