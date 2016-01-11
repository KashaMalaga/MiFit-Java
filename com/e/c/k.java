package com.e.c;

import android.view.View;
import android.view.animation.Interpolator;
import com.e.a.C1034a;
import com.e.a.C1035b;
import com.e.a.R;
import com.e.c.a.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

class k extends c {
    private static final int l = 0;
    private static final int m = 1;
    private static final int n = 2;
    private static final int o = 4;
    private static final int p = 8;
    private static final int q = 16;
    private static final int r = 32;
    private static final int s = 64;
    private static final int t = 128;
    private static final int u = 256;
    private static final int v = 512;
    private static final int w = 511;
    ArrayList<n> a = new ArrayList();
    private final a b;
    private final WeakReference<View> c;
    private long d;
    private boolean e = false;
    private long f = 0;
    private boolean g = false;
    private Interpolator h;
    private boolean i = false;
    private C1035b j = null;
    private m k = new m();
    private Runnable x = new l(this);
    private HashMap<C1034a, o> y = new HashMap();

    k(View view) {
        this.c = new WeakReference(view);
        this.b = a.a(view);
    }

    private float a(int i) {
        switch (i) {
            case m /*1*/:
                return this.b.k();
            case n /*2*/:
                return this.b.l();
            case o /*4*/:
                return this.b.g();
            case p /*8*/:
                return this.b.h();
            case q /*16*/:
                return this.b.d();
            case r /*32*/:
                return this.b.e();
            case s /*64*/:
                return this.b.f();
            case t /*128*/:
                return this.b.m();
            case u /*256*/:
                return this.b.n();
            case v /*512*/:
                return this.b.a();
            default:
                return 0.0f;
        }
    }

    private void a(int i, float f) {
        float a = a(i);
        a(i, a, f - a);
    }

    private void a(int i, float f, float f2) {
        if (this.y.size() > 0) {
            for (C1034a c1034a : this.y.keySet()) {
                o oVar = (o) this.y.get(c1034a);
                if (oVar.a(i) && oVar.a == 0) {
                    break;
                }
            }
            C1034a c1034a2 = null;
            if (c1034a2 != null) {
                c1034a2.a();
            }
        }
        this.a.add(new n(i, f, f2));
        View view = (View) this.c.get();
        if (view != null) {
            view.removeCallbacks(this.x);
            view.post(this.x);
        }
    }

    private void b(int i, float f) {
        a(i, a(i), f);
    }

    private void c(int i, float f) {
        switch (i) {
            case m /*1*/:
                this.b.i(f);
                return;
            case n /*2*/:
                this.b.j(f);
                return;
            case o /*4*/:
                this.b.g(f);
                return;
            case p /*8*/:
                this.b.h(f);
                return;
            case q /*16*/:
                this.b.d(f);
                return;
            case r /*32*/:
                this.b.e(f);
                return;
            case s /*64*/:
                this.b.f(f);
                return;
            case t /*128*/:
                this.b.k(f);
                return;
            case u /*256*/:
                this.b.l(f);
                return;
            case v /*512*/:
                this.b.a(f);
                return;
            default:
                return;
        }
    }

    private void d() {
        float[] fArr = new float[m];
        fArr[l] = 1.0f;
        R b = R.b(fArr);
        ArrayList arrayList = (ArrayList) this.a.clone();
        this.a.clear();
        int size = arrayList.size();
        int i = l;
        for (int i2 = l; i2 < size; i2 += m) {
            i |= ((n) arrayList.get(i2)).a;
        }
        this.y.put(b, new o(i, arrayList));
        b.a(this.k);
        b.a(this.k);
        if (this.g) {
            b.a(this.f);
        }
        if (this.e) {
            b.d(this.d);
        }
        if (this.i) {
            b.a(this.h);
        }
        b.start();
    }

    public long a() {
        return this.e ? this.d : new R().d();
    }

    public c a(float f) {
        a((int) t, f);
        return this;
    }

    public c a(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Animators cannot have negative duration: " + j);
        }
        this.e = true;
        this.d = j;
        return this;
    }

    public c a(Interpolator interpolator) {
        this.i = true;
        this.h = interpolator;
        return this;
    }

    public c a(C1035b c1035b) {
        this.j = c1035b;
        return this;
    }

    public long b() {
        return this.g ? this.f : 0;
    }

    public c b(float f) {
        b(t, f);
        return this;
    }

    public c b(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Animators cannot have negative duration: " + j);
        }
        this.g = true;
        this.f = j;
        return this;
    }

    public c c(float f) {
        a((int) u, f);
        return this;
    }

    public void c() {
        if (this.y.size() > 0) {
            for (C1034a a : ((HashMap) this.y.clone()).keySet()) {
                a.a();
            }
        }
        this.a.clear();
        View view = (View) this.c.get();
        if (view != null) {
            view.removeCallbacks(this.x);
        }
    }

    public c d(float f) {
        b(u, f);
        return this;
    }

    public c e(float f) {
        a((int) q, f);
        return this;
    }

    public c f(float f) {
        b(q, f);
        return this;
    }

    public c g(float f) {
        a((int) r, f);
        return this;
    }

    public c h(float f) {
        b(r, f);
        return this;
    }

    public c i(float f) {
        a((int) s, f);
        return this;
    }

    public c j(float f) {
        b(s, f);
        return this;
    }

    public c k(float f) {
        a((int) m, f);
        return this;
    }

    public c l(float f) {
        b(m, f);
        return this;
    }

    public c m(float f) {
        a((int) n, f);
        return this;
    }

    public c n(float f) {
        b(n, f);
        return this;
    }

    public c o(float f) {
        a((int) o, f);
        return this;
    }

    public c p(float f) {
        b(o, f);
        return this;
    }

    public c q(float f) {
        a((int) p, f);
        return this;
    }

    public c r(float f) {
        b(p, f);
        return this;
    }

    public c s(float f) {
        a((int) v, f);
        return this;
    }

    public void start() {
        d();
    }

    public c t(float f) {
        b(v, f);
        return this;
    }
}
