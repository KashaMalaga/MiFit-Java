package cn.com.smartdevices.bracelet.gps.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class c {
    private static final String a = "running_hr";
    private static final String b = "disconnect_count";
    private static final String c = "reconnect_success_count";
    private static SharedPreferences d;

    public static void a(Context context) {
        d = context.getSharedPreferences(a, 0);
        Editor edit = d.edit();
        edit.putInt(b, d.getInt(b, 0) + 1);
        edit.commit();
    }

    public static void b(Context context) {
        d = context.getSharedPreferences(a, 0);
        Editor edit = d.edit();
        edit.remove(b);
        edit.commit();
    }

    public static int c(Context context) {
        d = context.getSharedPreferences(a, 0);
        return d.getInt(b, 0);
    }

    public static void d(Context context) {
        d = context.getSharedPreferences(a, 0);
        Editor edit = d.edit();
        edit.putInt(c, d.getInt(c, 0) + 1);
        edit.commit();
    }

    public static void e(Context context) {
        d = context.getSharedPreferences(a, 0);
        Editor edit = d.edit();
        edit.remove(c);
        edit.commit();
    }

    public static int f(Context context) {
        d = context.getSharedPreferences(a, 0);
        return d.getInt(c, 0);
    }
}
