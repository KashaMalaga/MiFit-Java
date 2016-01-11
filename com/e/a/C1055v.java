package com.e.a;

import android.view.View;
import com.e.b.d;
import com.e.c.a.a;
import java.util.HashMap;
import java.util.Map;

public final class C1055v extends R {
    private static final boolean p = false;
    private static final Map<String, d> q = new HashMap();
    private Object r;
    private String s;
    private d t;

    static {
        q.put("alpha", C1056w.a);
        q.put("pivotX", C1056w.b);
        q.put("pivotY", C1056w.c);
        q.put("translationX", C1056w.d);
        q.put("translationY", C1056w.e);
        q.put("rotation", C1056w.f);
        q.put("rotationX", C1056w.g);
        q.put("rotationY", C1056w.h);
        q.put("scaleX", C1056w.i);
        q.put("scaleY", C1056w.j);
        q.put("scrollX", C1056w.k);
        q.put("scrollY", C1056w.l);
        q.put("x", C1056w.m);
        q.put("y", C1056w.n);
    }

    private <T> C1055v(T t, d<T, ?> dVar) {
        this.r = t;
        a((d) dVar);
    }

    private C1055v(Object obj, String str) {
        this.r = obj;
        a(str);
    }

    public static <T, V> C1055v a(T t, d<T, V> dVar, Q<V> q, V... vArr) {
        C1055v c1055v = new C1055v((Object) t, (d) dVar);
        c1055v.a((Object[]) vArr);
        c1055v.a((Q) q);
        return c1055v;
    }

    public static <T> C1055v a(T t, d<T, Float> dVar, float... fArr) {
        C1055v c1055v = new C1055v((Object) t, (d) dVar);
        c1055v.a(fArr);
        return c1055v;
    }

    public static <T> C1055v a(T t, d<T, Integer> dVar, int... iArr) {
        C1055v c1055v = new C1055v((Object) t, (d) dVar);
        c1055v.a(iArr);
        return c1055v;
    }

    public static C1055v a(Object obj, String str, Q q, Object... objArr) {
        C1055v c1055v = new C1055v(obj, str);
        c1055v.a(objArr);
        c1055v.a(q);
        return c1055v;
    }

    public static C1055v a(Object obj, String str, float... fArr) {
        C1055v c1055v = new C1055v(obj, str);
        c1055v.a(fArr);
        return c1055v;
    }

    public static C1055v a(Object obj, String str, int... iArr) {
        C1055v c1055v = new C1055v(obj, str);
        c1055v.a(iArr);
        return c1055v;
    }

    public static C1055v a(Object obj, L... lArr) {
        C1055v c1055v = new C1055v();
        c1055v.r = obj;
        c1055v.b(lArr);
        return c1055v;
    }

    void a(float f) {
        super.a(f);
        for (L d : this.k) {
            d.d(this.r);
        }
    }

    public void a(d dVar) {
        if (this.k != null) {
            L l = this.k[0];
            String c = l.c();
            l.a(dVar);
            this.l.remove(c);
            this.l.put(this.s, l);
        }
        if (this.t != null) {
            this.s = dVar.b();
        }
        this.t = dVar;
        this.j = false;
    }

    public void a(Object obj) {
        if (this.r != obj) {
            Object obj2 = this.r;
            this.r = obj;
            if (obj2 == null || obj == null || obj2.getClass() != obj.getClass()) {
                this.j = false;
            }
        }
    }

    public void a(String str) {
        if (this.k != null) {
            L l = this.k[0];
            String c = l.c();
            l.a(str);
            this.l.remove(c);
            this.l.put(str, l);
        }
        this.s = str;
        this.j = false;
    }

    public void a(float... fArr) {
        if (this.k != null && this.k.length != 0) {
            super.a(fArr);
        } else if (this.t != null) {
            b(L.a(this.t, fArr));
        } else {
            b(L.a(this.s, fArr));
        }
    }

    public void a(int... iArr) {
        if (this.k != null && this.k.length != 0) {
            super.a(iArr);
        } else if (this.t != null) {
            b(L.a(this.t, iArr));
        } else {
            b(L.a(this.s, iArr));
        }
    }

    public void a(Object... objArr) {
        if (this.k != null && this.k.length != 0) {
            super.a(objArr);
        } else if (this.t != null) {
            b(L.a(this.t, null, objArr));
        } else {
            b(L.a(this.s, null, objArr));
        }
    }

    public C1055v a_(long j) {
        super.d(j);
        return this;
    }

    public /* synthetic */ R d(long j) {
        return a_(j);
    }

    public void j() {
        m();
        for (L b : this.k) {
            b.b(this.r);
        }
    }

    public void k() {
        m();
        for (L c : this.k) {
            c.c(this.r);
        }
    }

    public String l() {
        return this.s;
    }

    void m() {
        if (!this.j) {
            if (this.t == null && a.a && (this.r instanceof View) && q.containsKey(this.s)) {
                a((d) q.get(this.s));
            }
            for (L a : this.k) {
                a.a(this.r);
            }
            super.m();
        }
    }

    public Object n() {
        return this.r;
    }

    public C1055v o() {
        return (C1055v) super.p();
    }

    public /* synthetic */ R p() {
        return o();
    }

    public void start() {
        super.start();
    }

    public String toString() {
        String str = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + this.r;
        if (this.k != null) {
            for (L l : this.k) {
                str = new StringBuilder(String.valueOf(str)).append("\n    ").append(l.toString()).toString();
            }
        }
        return str;
    }
}
