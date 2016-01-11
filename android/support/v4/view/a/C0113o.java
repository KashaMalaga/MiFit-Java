package android.support.v4.view.a;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class C0113o {
    public static final int A = 2;
    public static final int B = 1;
    public static final int C = 2;
    public static final int D = 4;
    public static final int E = 8;
    public static final int F = 16;
    private static final C0116t G;
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 4;
    public static final int d = 8;
    public static final int e = 16;
    public static final int f = 32;
    public static final int g = 64;
    public static final int h = 128;
    public static final int i = 256;
    public static final int j = 512;
    public static final int k = 1024;
    public static final int l = 2048;
    public static final int m = 4096;
    public static final int n = 8192;
    public static final int o = 16384;
    public static final int p = 32768;
    public static final int q = 65536;
    public static final int r = 131072;
    public static final int s = 2097152;
    public static final String t = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
    public static final String u = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
    public static final String v = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
    public static final String w = "ACTION_ARGUMENT_SELECTION_START_INT";
    public static final String x = "ACTION_ARGUMENT_SELECTION_END_INT";
    public static final String y = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE";
    public static final int z = 1;
    private final Object H;

    static {
        if (VERSION.SDK_INT >= 21) {
            G = new C0122r();
        } else if (VERSION.SDK_INT >= 19) {
            G = new C0121w();
        } else if (VERSION.SDK_INT >= 18) {
            G = new C0120v();
        } else if (VERSION.SDK_INT >= e) {
            G = new C0119u();
        } else if (VERSION.SDK_INT >= 14) {
            G = new C0118s();
        } else {
            G = new C0117x();
        }
    }

    public C0113o(Object obj) {
        this.H = obj;
    }

    public static C0113o a(C0113o c0113o) {
        return C0113o.a(G.c(c0113o.H));
    }

    public static C0113o a(View view) {
        return C0113o.a(G.a(view));
    }

    public static C0113o a(View view, int i) {
        return C0113o.a(G.a(view, i));
    }

    static C0113o a(Object obj) {
        return obj != null ? new C0113o(obj) : null;
    }

    public static C0113o b() {
        return C0113o.a(G.a());
    }

    private static String h(int i) {
        switch (i) {
            case z /*1*/:
                return "ACTION_FOCUS";
            case b /*2*/:
                return "ACTION_CLEAR_FOCUS";
            case c /*4*/:
                return "ACTION_SELECT";
            case d /*8*/:
                return "ACTION_CLEAR_SELECTION";
            case e /*16*/:
                return "ACTION_CLICK";
            case f /*32*/:
                return "ACTION_LONG_CLICK";
            case g /*64*/:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case h /*128*/:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case i /*256*/:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case j /*512*/:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case k /*1024*/:
                return "ACTION_NEXT_HTML_ELEMENT";
            case l /*2048*/:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case m /*4096*/:
                return "ACTION_SCROLL_FORWARD";
            case n /*8192*/:
                return "ACTION_SCROLL_BACKWARD";
            case o /*16384*/:
                return "ACTION_COPY";
            case p /*32768*/:
                return "ACTION_PASTE";
            case q /*65536*/:
                return "ACTION_CUT";
            case r /*131072*/:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }

    public C0123y A() {
        Object B = G.B(this.H);
        return B == null ? null : new C0123y(B);
    }

    public C0124z B() {
        Object C = G.C(this.H);
        return C == null ? null : new C0124z(C);
    }

    public A C() {
        Object D = G.D(this.H);
        return D == null ? null : new A(D);
    }

    public List<C0115q> D() {
        List<C0115q> arrayList = new ArrayList();
        List a = G.a(this.H);
        int size = a.size();
        for (int i = 0; i < size; i += z) {
            arrayList.add(new C0115q(a.get(i)));
        }
        return arrayList;
    }

    public C0113o a(int i) {
        return C0113o.a(G.d(this.H, i));
    }

    public Object a() {
        return this.H;
    }

    public List<C0113o> a(String str) {
        List<C0113o> arrayList = new ArrayList();
        List a = G.a(this.H, str);
        int size = a.size();
        for (int i = 0; i < size; i += z) {
            arrayList.add(new C0113o(a.get(i)));
        }
        return arrayList;
    }

    public void a(Rect rect) {
        G.a(this.H, rect);
    }

    public void a(CharSequence charSequence) {
        G.c(this.H, charSequence);
    }

    public void a(boolean z) {
        G.a(this.H, z);
    }

    public boolean a(int i, Bundle bundle) {
        return G.a(this.H, i, bundle);
    }

    public C0113o b(int i) {
        return C0113o.a(G.e(this.H, i));
    }

    public void b(Rect rect) {
        G.c(this.H, rect);
    }

    public void b(View view) {
        G.c(this.H, view);
    }

    public void b(View view, int i) {
        G.a(this.H, view, i);
    }

    public void b(CharSequence charSequence) {
        G.a(this.H, charSequence);
    }

    public void b(Object obj) {
        G.a(this.H, ((C0123y) obj).d);
    }

    public void b(String str) {
        G.b(this.H, str);
    }

    public void b(boolean z) {
        G.b(this.H, z);
    }

    public int c() {
        return G.k(this.H);
    }

    public C0113o c(int i) {
        return C0113o.a(G.b(this.H, i));
    }

    public void c(Rect rect) {
        G.b(this.H, rect);
    }

    public void c(View view) {
        G.a(this.H, view);
    }

    public void c(View view, int i) {
        G.b(this.H, view, i);
    }

    public void c(CharSequence charSequence) {
        G.d(this.H, charSequence);
    }

    public void c(Object obj) {
        G.b(this.H, ((C0124z) obj).a);
    }

    public void c(boolean z) {
        G.e(this.H, z);
    }

    public int d() {
        return G.e(this.H);
    }

    public void d(int i) {
        G.a(this.H, i);
    }

    public void d(Rect rect) {
        G.d(this.H, rect);
    }

    public void d(View view) {
        G.b(this.H, view);
    }

    public void d(View view, int i) {
        G.c(this.H, view, i);
    }

    public void d(CharSequence charSequence) {
        G.b(this.H, charSequence);
    }

    public void d(boolean z) {
        G.f(this.H, z);
    }

    public int e() {
        return G.d(this.H);
    }

    public void e(boolean z) {
        G.k(this.H, z);
    }

    public boolean e(int i) {
        return G.c(this.H, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        C0113o c0113o = (C0113o) obj;
        return this.H == null ? c0113o.H == null : this.H.equals(c0113o.H);
    }

    public int f() {
        return G.w(this.H);
    }

    public void f(int i) {
        G.f(this.H, i);
    }

    public void f(boolean z) {
        G.l(this.H, z);
    }

    public C0113o g() {
        return C0113o.a(G.i(this.H));
    }

    public void g(int i) {
        G.g(this.H, i);
    }

    public void g(boolean z) {
        G.j(this.H, z);
    }

    public void h(boolean z) {
        G.c(this.H, z);
    }

    public boolean h() {
        return G.l(this.H);
    }

    public int hashCode() {
        return this.H == null ? 0 : this.H.hashCode();
    }

    public void i(boolean z) {
        G.g(this.H, z);
    }

    public boolean i() {
        return G.m(this.H);
    }

    public void j(boolean z) {
        G.d(this.H, z);
    }

    public boolean j() {
        return G.p(this.H);
    }

    public void k(boolean z) {
        G.h(this.H, z);
    }

    public boolean k() {
        return G.q(this.H);
    }

    public void l(boolean z) {
        G.i(this.H, z);
    }

    public boolean l() {
        return G.x(this.H);
    }

    public boolean m() {
        return G.y(this.H);
    }

    public boolean n() {
        return G.u(this.H);
    }

    public boolean o() {
        return G.n(this.H);
    }

    public boolean p() {
        return G.r(this.H);
    }

    public boolean q() {
        return G.o(this.H);
    }

    public boolean r() {
        return G.s(this.H);
    }

    public boolean s() {
        return G.t(this.H);
    }

    public CharSequence t() {
        return G.h(this.H);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        Rect rect = new Rect();
        a(rect);
        stringBuilder.append("; boundsInParent: " + rect);
        c(rect);
        stringBuilder.append("; boundsInScreen: " + rect);
        stringBuilder.append("; packageName: ").append(t());
        stringBuilder.append("; className: ").append(u());
        stringBuilder.append("; text: ").append(v());
        stringBuilder.append("; contentDescription: ").append(w());
        stringBuilder.append("; viewId: ").append(y());
        stringBuilder.append("; checkable: ").append(h());
        stringBuilder.append("; checked: ").append(i());
        stringBuilder.append("; focusable: ").append(j());
        stringBuilder.append("; focused: ").append(k());
        stringBuilder.append("; selected: ").append(n());
        stringBuilder.append("; clickable: ").append(o());
        stringBuilder.append("; longClickable: ").append(p());
        stringBuilder.append("; enabled: ").append(q());
        stringBuilder.append("; password: ").append(r());
        stringBuilder.append("; scrollable: " + s());
        stringBuilder.append("; [");
        int e = e();
        while (e != 0) {
            int numberOfTrailingZeros = z << Integer.numberOfTrailingZeros(e);
            e &= numberOfTrailingZeros ^ -1;
            stringBuilder.append(C0113o.h(numberOfTrailingZeros));
            if (e != 0) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public CharSequence u() {
        return G.f(this.H);
    }

    public CharSequence v() {
        return G.j(this.H);
    }

    public CharSequence w() {
        return G.g(this.H);
    }

    public void x() {
        G.v(this.H);
    }

    public String y() {
        return G.z(this.H);
    }

    public int z() {
        return G.A(this.H);
    }
}
