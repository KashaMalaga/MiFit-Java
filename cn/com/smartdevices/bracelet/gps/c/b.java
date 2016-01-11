package cn.com.smartdevices.bracelet.gps.c;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import com.xiaomi.e.a;

public class b {
    private static final String a = "KeyGPSLocation";
    private static final String b = "GPSTrackerConfig";
    private static final String c = "_GaoDe";
    private static final String d = "_Baidu";
    private static final String e = "DisMinNoticeThreshold";
    private static final String f = "DisMinThreshold";
    private static final String g = "version";
    private static final int h = -1;
    private static final String i = "ConfigTDone";
    private static final String j = "TrackInfoTDone";
    private static final String k = "TrackLocTDone";
    private static final String l = "TrackContourTDone";
    private static final String m = "TrackDeathTDone";
    private static final String n = "LastWifiSyncTimeStamp";
    private static final int o = 50;
    private static final int p = 1;
    private static final boolean q = false;

    private b() {
    }

    private static float a(Context context, String str, float f) {
        return context.getSharedPreferences(b, 0).getFloat(str, f);
    }

    public static String a(Context context) {
        if (context != null) {
            return e(context, a.concat(c));
        }
        throw new IllegalArgumentException();
    }

    public static void a(Context context, long j) {
        if (context != null) {
            a(context, n, j);
        }
    }

    public static void a(Context context, String str) {
        if (context != null) {
            a(context, a.concat(c), str);
        }
    }

    private static void a(Context context, String str, int i) {
        Editor edit = context.getSharedPreferences(b, 0).edit();
        edit.putInt(str, i);
        edit.commit();
    }

    private static void a(Context context, String str, long j) {
        Editor edit = context.getSharedPreferences(b, 0).edit();
        edit.putLong(str, j);
        edit.commit();
    }

    private static void a(Context context, String str, String str2) {
        Editor edit = context.getSharedPreferences(b, 0).edit();
        edit.putString(str, str2);
        edit.commit();
    }

    public static void a(Context context, boolean z) {
        if (context != null) {
            b(context, i, z);
        }
    }

    public static void a(Context context, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        if (context != null) {
            Editor edit = context.getSharedPreferences(b, 0).edit();
            edit.putBoolean(i, z);
            edit.putBoolean(j, z2);
            edit.putBoolean(k, z3);
            edit.putBoolean(l, z4);
            edit.putBoolean(m, z5);
            edit.commit();
        }
    }

    private static boolean a(Context context, String str, boolean z) {
        return context.getSharedPreferences(b, 0).getBoolean(str, z);
    }

    public static String b(Context context) {
        if (context != null) {
            return e(context, a);
        }
        throw new IllegalArgumentException();
    }

    public static void b(Context context, String str) {
        if (context != null) {
            a(context, a, str);
        }
    }

    private static void b(Context context, String str, boolean z) {
        Editor edit = context.getSharedPreferences(b, 0).edit();
        edit.putBoolean(str, z);
        edit.commit();
    }

    public static void b(Context context, boolean z) {
        if (context != null) {
            b(context, l, z);
        }
    }

    private static int c(Context context, String str) {
        return context.getSharedPreferences(b, 0).getInt(str, h);
    }

    public static long c(Context context) {
        if (context != null) {
            return d(context, n);
        }
        throw new IllegalArgumentException();
    }

    public static void c(Context context, boolean z) {
        if (context != null) {
            b(context, m, z);
        }
    }

    public static float d(Context context) {
        return a(context, f, 1.0f);
    }

    private static long d(Context context, String str) {
        return context.getSharedPreferences(b, 0).getLong(str, -1);
    }

    public static void d(Context context, boolean z) {
        if (context != null) {
            b(context, j, z);
        }
    }

    public static float e(Context context) {
        return a(context, e, 50.0f);
    }

    private static String e(Context context, String str) {
        return context.getSharedPreferences(b, 0).getString(str, a.f);
    }

    public static void e(Context context, boolean z) {
        if (context != null) {
            b(context, k, z);
        }
    }

    public static boolean f(Context context) {
        return true;
    }

    public static boolean g(Context context) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        int i;
        try {
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            i = 0;
        }
        return i != context.getSharedPreferences(b, 4).getInt(g, h);
    }

    public static boolean h(Context context) {
        if (context != null) {
            return false;
        }
        throw new IllegalArgumentException();
    }

    public static boolean i(Context context) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        try {
            int i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            int i2 = context.getSharedPreferences(b, 4).getInt(g, h);
            return (i2 == h || i2 == i || i2 >= h) ? false : true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static void j(Context context) {
        int i = 0;
        if (context != null) {
            try {
                i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (NameNotFoundException e) {
            }
            context.getSharedPreferences(b, 4).edit().putInt(g, i).commit();
        }
    }
}
