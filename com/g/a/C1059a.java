package com.g.a;

import android.content.Context;
import b.a.bW;
import com.xiaomi.e.a;

public class C1059a {
    public static String a = null;
    public static String b = null;
    public static int c;
    public static String d = a.f;
    public static String e = a.f;
    public static C1060b f;
    public static int g;
    public static String h;
    public static String i;
    public static boolean j = true;
    public static boolean k = true;
    public static boolean l = true;
    public static boolean m = true;
    public static long n = 30000;
    public static boolean o = true;
    private static String p = null;
    private static String q = null;
    private static double[] r = null;
    private static int[] s;

    public static String a(Context context) {
        if (p == null) {
            p = bW.o(context);
        }
        return p;
    }

    public static void a(double d, double d2) {
        if (r == null) {
            r = new double[2];
        }
        r[0] = d;
        r[1] = d2;
    }

    public static void a(int i, int i2) {
        if (s == null) {
            s = new int[2];
        }
        s[0] = i;
        s[1] = i2;
    }

    public static void a(String str) {
        p = str;
    }

    public static double[] a() {
        return r;
    }

    public static String b(Context context) {
        if (q == null) {
            q = bW.t(context);
        }
        return q;
    }

    public static void b(String str) {
        q = str;
    }

    public static int[] c(Context context) {
        if (s == null) {
            s = B.a(context).a();
        }
        return s;
    }
}
