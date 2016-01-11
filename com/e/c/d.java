package com.e.c;

import android.view.View;
import android.view.animation.Interpolator;
import com.e.a.C1034a;
import com.e.a.C1035b;
import com.e.a.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

class d extends c {
    private static final int k = 0;
    private static final int l = 1;
    private static final int m = 2;
    private static final int n = 4;
    private static final int o = 8;
    private static final int p = 16;
    private static final int q = 32;
    private static final int r = 64;
    private static final int s = 128;
    private static final int t = 256;
    private static final int u = 512;
    private static final int v = 511;
    ArrayList<g> a = new ArrayList();
    private final WeakReference<View> b;
    private long c;
    private boolean d = false;
    private long e = 0;
    private boolean f = false;
    private Interpolator g;
    private boolean h = false;
    private C1035b i = null;
    private f j = new f();
    private Runnable w = new e(this);
    private HashMap<C1034a, h> x = new HashMap();

    d(View view) {
        this.b = new WeakReference(view);
    }

    private float a(int i) {
        View view = (View) this.b.get();
        if (view != null) {
            switch (i) {
                case l /*1*/:
                    return view.getTranslationX();
                case m /*2*/:
                    return view.getTranslationY();
                case n /*4*/:
                    return view.getScaleX();
                case o /*8*/:
                    return view.getScaleY();
                case p /*16*/:
                    return view.getRotation();
                case q /*32*/:
                    return view.getRotationX();
                case r /*64*/:
                    return view.getRotationY();
                case s /*128*/:
                    return view.getX();
                case t /*256*/:
                    return view.getY();
                case u /*512*/:
                    return view.getAlpha();
            }
        }
        return 0.0f;
    }

    private void a(int i, float f) {
        float a = a(i);
        a(i, a, f - a);
    }

    private void a(int i, float f, float f2) {
        if (this.x.size() > 0) {
            for (C1034a c1034a : this.x.keySet()) {
                h hVar = (h) this.x.get(c1034a);
                if (hVar.a(i) && hVar.a == 0) {
                    break;
                }
            }
            C1034a c1034a2 = null;
            if (c1034a2 != null) {
                c1034a2.a();
            }
        }
        this.a.add(new g(i, f, f2));
        View view = (View) this.b.get();
        if (view != null) {
            view.removeCallbacks(this.w);
            view.post(this.w);
        }
    }

    private void b(int i, float f) {
        a(i, a(i), f);
    }

    private void c(int i, float f) {
        View view = (View) this.b.get();
        if (view != null) {
            switch (i) {
                case l /*1*/:
                    view.setTranslationX(f);
                    return;
                case m /*2*/:
                    view.setTranslationY(f);
                    return;
                case n /*4*/:
                    view.setScaleX(f);
                    return;
                case o /*8*/:
                    view.setScaleY(f);
                    return;
                case p /*16*/:
                    view.setRotation(f);
                    return;
                case q /*32*/:
                    view.setRotationX(f);
                    return;
                case r /*64*/:
                    view.setRotationY(f);
                    return;
                case s /*128*/:
                    view.setX(f);
                    return;
                case t /*256*/:
                    view.setY(f);
                    return;
                case u /*512*/:
                    view.setAlpha(f);
                    return;
                default:
                    return;
            }
        }
    }

    private void d() {
        float[] fArr = new float[l];
        fArr[k] = 1.0f;
        R b = R.b(fArr);
        ArrayList arrayList = (ArrayList) this.a.clone();
        this.a.clear();
        int size = arrayList.size();
        int i = k;
        for (int i2 = k; i2 < size; i2 += l) {
            i |= ((g) arrayList.get(i2)).a;
        }
        this.x.put(b, new h(i, arrayList));
        b.a(this.j);
        b.a(this.j);
        if (this.f) {
            b.a(this.e);
        }
        if (this.d) {
            b.d(this.c);
        }
        if (this.h) {
            b.a(this.g);
        }
        b.start();
    }

    public long a() {
        return this.d ? this.c : new R().d();
    }

    public c a(float f) {
        a((int) s, f);
        return this;
    }

    public c a(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Animators cannot have negative duration: " + j);
        }
        this.d = true;
        this.c = j;
        return this;
    }

    public c a(Interpolator interpolator) {
        this.h = true;
        this.g = interpolator;
        return this;
    }

    public c a(C1035b c1035b) {
        this.i = c1035b;
        return this;
    }

    public long b() {
        return this.f ? this.e : 0;
    }

    public c b(float f) {
        b(s, f);
        return this;
    }

    public c b(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Animators cannot have negative duration: " + j);
        }
        this.f = true;
        this.e = j;
        return this;
    }

    public c c(float f) {
        a((int) t, f);
        return this;
    }

    public void c() {
        if (this.x.size() > 0) {
            for (C1034a a : ((HashMap) this.x.clone()).keySet()) {
                a.a();
            }
        }
        this.a.clear();
        View view = (View) this.b.get();
        if (view != null) {
            view.removeCallbacks(this.w);
        }
    }

    public c d(float f) {
        b(t, f);
        return this;
    }

    public c e(float f) {
        a((int) p, f);
        return this;
    }

    public c f(float f) {
        b(p, f);
        return this;
    }

    public c g(float f) {
        a((int) q, f);
        return this;
    }

    public c h(float f) {
        b(q, f);
        return this;
    }

    public c i(float f) {
        a((int) r, f);
        return this;
    }

    public c j(float f) {
        b(r, f);
        return this;
    }

    public c k(float f) {
        a((int) l, f);
        return this;
    }

    public c l(float f) {
        b(l, f);
        return this;
    }

    public c m(float f) {
        a((int) m, f);
        return this;
    }

    public c n(float f) {
        b(m, f);
        return this;
    }

    public c o(float f) {
        a((int) n, f);
        return this;
    }

    public c p(float f) {
        b(n, f);
        return this;
    }

    public c q(float f) {
        a((int) o, f);
        return this;
    }

    public c r(float f) {
        b(o, f);
        return this;
    }

    public c s(float f) {
        a((int) u, f);
        return this;
    }

    public void start() {
        d();
    }

    public c t(float f) {
        b(u, f);
        return this;
    }
}
