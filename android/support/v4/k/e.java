package android.support.v4.k;

import android.os.Build.VERSION;

public class e {
    private static final f a;

    static {
        if (VERSION.SDK_INT >= 14) {
            a = new h();
        } else {
            a = new g();
        }
    }

    public static String a(String str) {
        return a.a(str);
    }

    public static String b(String str) {
        return a.b(str);
    }
}
