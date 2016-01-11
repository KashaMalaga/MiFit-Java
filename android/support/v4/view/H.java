package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup.MarginLayoutParams;

public class H {
    static final I a;

    static {
        if (VERSION.SDK_INT >= 17) {
            a = new K();
        } else {
            a = new J();
        }
    }

    public static int a(MarginLayoutParams marginLayoutParams) {
        return a.a(marginLayoutParams);
    }

    public static void a(MarginLayoutParams marginLayoutParams, int i) {
        a.a(marginLayoutParams, i);
    }

    public static int b(MarginLayoutParams marginLayoutParams) {
        return a.b(marginLayoutParams);
    }

    public static void b(MarginLayoutParams marginLayoutParams, int i) {
        a.b(marginLayoutParams, i);
    }

    public static void c(MarginLayoutParams marginLayoutParams, int i) {
        a.c(marginLayoutParams, i);
    }

    public static boolean c(MarginLayoutParams marginLayoutParams) {
        return a.c(marginLayoutParams);
    }

    public static int d(MarginLayoutParams marginLayoutParams) {
        return a.d(marginLayoutParams);
    }

    public static void d(MarginLayoutParams marginLayoutParams, int i) {
        a.d(marginLayoutParams, i);
    }
}
