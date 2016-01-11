package cn.com.smartdevices.bracelet;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class A {
    private static final String a = "misc_keeper";
    private static SharedPreferences b = null;
    private static final String c = "ref_track_thumb_cleaned";
    private static final String d = "ref_trash_cleaned";

    public static void a(Context context) {
        if (b == null) {
            b = context.getSharedPreferences(a, 0);
        }
    }

    public static void a(boolean z) {
        Editor edit = b.edit();
        edit.putBoolean(c, z);
        edit.commit();
    }

    public static boolean a() {
        return b.getBoolean(c, false);
    }

    public static void b(boolean z) {
        Editor edit = b.edit();
        edit.putBoolean(d, z);
        edit.commit();
    }

    public static boolean b() {
        return b.getBoolean(d, false);
    }
}
