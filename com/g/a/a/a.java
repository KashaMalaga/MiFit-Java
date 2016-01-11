package com.g.a.a;

import android.content.Context;
import b.a.bX;
import com.g.a.C1060b;
import com.g.a.c.n;
import com.g.a.c.u;
import com.g.a.f;
import com.g.a.p;
import com.tencent.connect.common.Constants;
import com.xiaomi.channel.b.v;

public class a extends f {
    private static final String a = "Input string is null or empty";
    private static final String b = "Input string must be less than 64 chars";
    private static final String c = "Input value type is negative";
    private static final String d = "The int value for 'Pay Channels' ranges between 1 ~ 99 ";
    private static final e e = new e();
    private static Context f;

    public static void a(double d, double d2, int i) {
        if (i <= 0 || i >= 100) {
            bX.b(p.e, d);
        } else if (d < 0.0d || d2 < 0.0d) {
            bX.b(p.e, c);
        } else {
            e.a(d, d2, i);
        }
    }

    public static void a(double d, int i) {
        if (d < 0.0d) {
            bX.b(p.e, c);
        } else if (i <= 0 || i >= 100) {
            bX.b(p.e, d);
        } else {
            e.a(d, i);
        }
    }

    public static void a(double d, String str, int i, double d2, int i2) {
        if (i2 <= 0 || i2 >= 100) {
            bX.b(p.e, d);
        } else if (d < 0.0d || i < 0 || d2 < 0.0d) {
            bX.b(p.e, c);
        } else if (g(str)) {
            bX.b(p.e, a);
        } else {
            e.a(d, str, i, d2, i2);
        }
    }

    public static void a(String str, int i, double d) {
        if (g(str)) {
            bX.b(p.e, a);
        } else if (i < 0 || d < 0.0d) {
            bX.b(p.e, c);
        } else {
            e.a(str, i, d);
        }
    }

    public static void a(String str, int i, double d, int i2) {
        if (g(str)) {
            bX.b(p.e, a);
        } else if (i < 0 || d < 0.0d) {
            bX.b(p.e, c);
        } else if (i2 <= 0 || i2 >= 100) {
            bX.b(p.e, d);
        } else {
            e.a(str, i, d, i2);
        }
    }

    public static void a(String str, int i, int i2, String str2) {
        if (g(str)) {
            bX.b(p.e, a);
            str = null;
        }
        if (i < 0 || i > v.C) {
            bX.c(p.e, "The int value for 'Age' range between 0~200");
            i = 0;
        }
        if (g(str2)) {
            bX.b(p.e, a);
            str2 = null;
        }
        e.a(str, i, C1060b.a(i2), str2);
    }

    public static void b(Context context, String str, com.g.a.c.a... aVarArr) {
        if (context == null) {
            bX.b(p.e, "context is null in onShareEvent");
            return;
        }
        u.e = Constants.VIA_TO_TYPE_QZONE;
        n.a(context, str, aVarArr);
    }

    public static void b(Context context, com.g.a.c.a... aVarArr) {
        if (context == null) {
            bX.b(p.e, "context is null in onShareEvent");
            return;
        }
        u.e = Constants.VIA_TO_TYPE_QZONE;
        n.a(context, aVarArr);
    }

    public static void b(String str, int i, double d) {
        if (g(str)) {
            bX.b(p.e, a);
        } else if (i < 0 || d < 0.0d) {
            bX.b(p.e, c);
        } else {
            e.b(str, i, d);
        }
    }

    public static void b(String str, String str2) {
        f.b(f, str, str2);
    }

    public static void c(String str) {
        if (g(str)) {
            bX.b(p.e, a);
        } else if (str.length() > 64) {
            bX.b(p.e, b);
        } else {
            e.a(str);
        }
    }

    public static void d(String str) {
        if (g(str)) {
            bX.b(p.e, a);
        } else if (str.length() > 64) {
            bX.b(p.e, b);
        } else {
            e.b(str);
        }
    }

    public static void e(String str) {
        if (g(str)) {
            bX.b(p.e, a);
        } else if (str.length() > 64) {
            bX.b(p.e, b);
        } else {
            e.c(str);
        }
    }

    public static void f(Context context) {
        e.a(context);
        f = context.getApplicationContext();
    }

    public static void f(String str) {
        if (g(str)) {
            bX.b(p.e, a);
        } else if (str.length() > 64) {
            bX.b(p.e, b);
        } else {
            e.d(str);
        }
    }

    public static void f(boolean z) {
        e.a(z);
    }

    private static boolean g(String str) {
        return str == null || str.trim().length() <= 0;
    }
}
