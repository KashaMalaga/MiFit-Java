package android.support.v4.view;

import android.graphics.Paint;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.a.C0113o;
import android.support.v4.view.a.L;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

public class C0151az {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 0;
    public static final int e = 1;
    public static final int f = 2;
    public static final int g = 4;
    public static final int h = 0;
    public static final int i = 1;
    public static final int j = 2;
    public static final int k = 0;
    public static final int l = 1;
    public static final int m = 2;
    public static final int n = 0;
    public static final int o = 1;
    public static final int p = 2;
    public static final int q = 3;
    public static final int r = 16777215;
    public static final int s = -16777216;
    public static final int t = 16;
    public static final int u = 16777216;
    static final aP v;
    private static final String w = "ViewCompat";
    private static final long x = 10;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            v = new C0127aB();
        } else if (i >= 19) {
            v = new aK();
        } else if (i >= 17) {
            v = new aJ();
        } else if (i >= t) {
            v = new aI();
        } else if (i >= 14) {
            v = new aG();
        } else if (i >= 11) {
            v = new aF();
        } else if (i >= 9) {
            v = new C0126aE();
        } else if (i >= 7) {
            v = new aD();
        } else {
            v = new aC();
        }
    }

    public static float A(View view) {
        return v.L(view);
    }

    public static float B(View view) {
        return v.C(view);
    }

    public static float C(View view) {
        return v.D(view);
    }

    public static float D(View view) {
        return v.E(view);
    }

    public static float E(View view) {
        return v.F(view);
    }

    public static float F(View view) {
        return v.G(view);
    }

    public static float G(View view) {
        return v.A(view);
    }

    public static float H(View view) {
        return v.B(view);
    }

    public static float I(View view) {
        return v.c(view);
    }

    public static float J(View view) {
        return v.d(view);
    }

    public static String K(View view) {
        return v.a(view);
    }

    public static int L(View view) {
        return v.M(view);
    }

    public static void M(View view) {
        v.b(view);
    }

    public static boolean N(View view) {
        return v.N(view);
    }

    public static void O(View view) {
        v.O(view);
    }

    public static int a(int i, int i2, int i3) {
        return v.a(i, i2, i3);
    }

    public static int a(View view) {
        return v.e(view);
    }

    public static void a(View view, float f) {
        v.d(view, f);
    }

    public static void a(View view, int i, int i2, int i3, int i4) {
        v.a(view, i, i2, i3, i4);
    }

    public static void a(View view, int i, Paint paint) {
        v.a(view, i, paint);
    }

    public static void a(View view, Paint paint) {
        v.a(view, paint);
    }

    public static void a(View view, C0113o c0113o) {
        v.a(view, c0113o);
    }

    public static void a(View view, C0125a c0125a) {
        v.a(view, c0125a);
    }

    public static void a(View view, C0130ad c0130ad) {
        v.a(view, c0130ad);
    }

    public static void a(View view, AccessibilityEvent accessibilityEvent) {
        v.a(view, accessibilityEvent);
    }

    public static void a(View view, Runnable runnable) {
        v.a(view, runnable);
    }

    public static void a(View view, Runnable runnable, long j) {
        v.a(view, runnable, j);
    }

    public static void a(View view, String str) {
        v.a(view, str);
    }

    public static void a(View view, boolean z) {
        v.a(view, z);
    }

    public static void a(ViewGroup viewGroup, boolean z) {
        v.a(viewGroup, z);
    }

    public static boolean a(View view, int i) {
        return v.a(view, i);
    }

    public static boolean a(View view, int i, Bundle bundle) {
        return v.a(view, i, bundle);
    }

    public static void b(View view, float f) {
        v.e(view, f);
    }

    public static void b(View view, int i, int i2, int i3, int i4) {
        v.b(view, i, i2, i3, i4);
    }

    public static void b(View view, AccessibilityEvent accessibilityEvent) {
        v.b(view, accessibilityEvent);
    }

    public static boolean b(View view) {
        return v.f(view);
    }

    public static boolean b(View view, int i) {
        return v.b(view, i);
    }

    public static void c(View view, float f) {
        v.f(view, f);
    }

    public static void c(View view, int i) {
        v.c(view, i);
    }

    public static boolean c(View view) {
        return v.g(view);
    }

    public static void d(View view) {
        v.h(view);
    }

    public static void d(View view, float f) {
        v.k(view, f);
    }

    public static void d(View view, int i) {
        v.d(view, i);
    }

    public static int e(View view) {
        return v.i(view);
    }

    public static void e(View view, float f) {
        v.l(view, f);
    }

    public static void e(View view, int i) {
        v.e(view, i);
    }

    public static L f(View view) {
        return v.j(view);
    }

    public static void f(View view, float f) {
        v.c(view, f);
    }

    public static void f(View view, int i) {
        v.f(view, i);
    }

    public static float g(View view) {
        return v.k(view);
    }

    public static void g(View view, float f) {
        v.g(view, f);
    }

    public static void g(View view, int i) {
        v.g(view, i);
    }

    public static int h(View view) {
        return v.l(view);
    }

    public static void h(View view, float f) {
        v.h(view, f);
    }

    public static int i(View view) {
        return v.m(view);
    }

    public static void i(View view, float f) {
        v.i(view, f);
    }

    public static int j(View view) {
        return v.n(view);
    }

    public static void j(View view, float f) {
        v.j(view, f);
    }

    public static ViewParent k(View view) {
        return v.o(view);
    }

    public static void k(View view, float f) {
        v.m(view, f);
    }

    public static void l(View view, float f) {
        v.m(view, f);
    }

    public static boolean l(View view) {
        return v.p(view);
    }

    public static int m(View view) {
        return v.q(view);
    }

    public static void m(View view, float f) {
        v.a(view, f);
    }

    public static int n(View view) {
        return v.r(view);
    }

    public static void n(View view, float f) {
        v.b(view, f);
    }

    public static int o(View view) {
        return v.s(view);
    }

    public static int p(View view) {
        return v.t(view);
    }

    public static int q(View view) {
        return v.u(view);
    }

    public static int r(View view) {
        return v.v(view);
    }

    public static void s(View view) {
        v.w(view);
    }

    public static void t(View view) {
        v.x(view);
    }

    public static float u(View view) {
        return v.y(view);
    }

    public static float v(View view) {
        return v.z(view);
    }

    public static int w(View view) {
        return v.H(view);
    }

    public static int x(View view) {
        return v.I(view);
    }

    public static bK y(View view) {
        return v.J(view);
    }

    public static float z(View view) {
        return v.K(view);
    }
}
