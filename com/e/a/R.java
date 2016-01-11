package com.e.a;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.xiaomi.e.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class R extends C1034a {
    private static long I = p;
    static final int b = 0;
    static final int c = 1;
    static final int d = 0;
    static final int e = 1;
    static final int f = 2;
    public static final int m = 1;
    public static final int n = 2;
    public static final int o = -1;
    private static final long p = 10;
    private static ThreadLocal<X> q = new ThreadLocal();
    private static final ThreadLocal<ArrayList<R>> r = new S();
    private static final ThreadLocal<ArrayList<R>> s = new T();
    private static final ThreadLocal<ArrayList<R>> t = new U();
    private static final ThreadLocal<ArrayList<R>> u = new V();
    private static final ThreadLocal<ArrayList<R>> v = new W();
    private static final Interpolator w = new AccelerateDecelerateInterpolator();
    private static final Q x = new C1049o();
    private static final Q y = new C1046m();
    private int A = d;
    private float B = 0.0f;
    private boolean C = false;
    private long D;
    private boolean E = false;
    private boolean F = false;
    private long G = 300;
    private long H = 0;
    private int J = d;
    private int K = m;
    private Interpolator L = w;
    private ArrayList<Y> M = null;
    long g;
    long h = -1;
    int i = d;
    boolean j = false;
    L[] k;
    HashMap<String, L> l;
    private boolean z = false;

    public static int A() {
        return ((ArrayList) r.get()).size();
    }

    public static void B() {
        ((ArrayList) r.get()).clear();
        ((ArrayList) s.get()).clear();
        ((ArrayList) t.get()).clear();
    }

    public static R a(Q q, Object... objArr) {
        R r = new R();
        r.a(objArr);
        r.a(q);
        return r;
    }

    public static R a(L... lArr) {
        R r = new R();
        r.b(lArr);
        return r;
    }

    public static R b(float... fArr) {
        R r = new R();
        r.a(fArr);
        return r;
    }

    public static R b(int... iArr) {
        R r = new R();
        r.a(iArr);
        return r;
    }

    public static void f(long j) {
        I = j;
    }

    private boolean g(long j) {
        if (this.C) {
            long j2 = j - this.D;
            if (j2 > this.H) {
                this.g = j - (j2 - this.H);
                this.i = m;
                return true;
            }
        }
        this.C = true;
        this.D = j;
        return false;
    }

    private void l() {
        ((ArrayList) r.get()).remove(this);
        ((ArrayList) s.get()).remove(this);
        ((ArrayList) t.get()).remove(this);
        this.i = d;
        if (this.E && this.a != null) {
            ArrayList arrayList = (ArrayList) this.a.clone();
            int size = arrayList.size();
            for (int i = d; i < size; i += m) {
                ((C1035b) arrayList.get(i)).b(this);
            }
        }
        this.E = false;
        this.F = false;
    }

    private void n() {
        m();
        ((ArrayList) r.get()).add(this);
        if (this.H > 0 && this.a != null) {
            ArrayList arrayList = (ArrayList) this.a.clone();
            int size = arrayList.size();
            for (int i = d; i < size; i += m) {
                ((C1035b) arrayList.get(i)).a(this);
            }
        }
    }

    public static long s() {
        return I;
    }

    private void start(boolean z) {
        if (Looper.myLooper() == null) {
            throw new AndroidRuntimeException("Animators may only be run on Looper threads");
        }
        this.z = z;
        this.A = d;
        this.i = d;
        this.F = true;
        this.C = false;
        ((ArrayList) s.get()).add(this);
        if (this.H == 0) {
            e(r());
            this.i = d;
            this.E = true;
            if (this.a != null) {
                ArrayList arrayList = (ArrayList) this.a.clone();
                int size = arrayList.size();
                for (int i = d; i < size; i += m) {
                    ((C1035b) arrayList.get(i)).a(this);
                }
            }
        }
        X x = (X) q.get();
        if (x == null) {
            x = new X();
            q.set(x);
        }
        x.sendEmptyMessage(d);
    }

    public void a() {
        if (this.i != 0 || ((ArrayList) s.get()).contains(this) || ((ArrayList) t.get()).contains(this)) {
            if (this.E && this.a != null) {
                Iterator it = ((ArrayList) this.a.clone()).iterator();
                while (it.hasNext()) {
                    ((C1035b) it.next()).c(this);
                }
            }
            l();
        }
    }

    void a(float f) {
        int i;
        float interpolation = this.L.getInterpolation(f);
        this.B = interpolation;
        int length = this.k.length;
        for (i = d; i < length; i += m) {
            this.k[i].a(interpolation);
        }
        if (this.M != null) {
            int size = this.M.size();
            for (i = d; i < size; i += m) {
                ((Y) this.M.get(i)).a(this);
            }
        }
    }

    public void a(int i) {
        this.J = i;
    }

    public void a(long j) {
        this.H = j;
    }

    public void a(Interpolator interpolator) {
        if (interpolator != null) {
            this.L = interpolator;
        } else {
            this.L = new LinearInterpolator();
        }
    }

    public void a(Q q) {
        if (q != null && this.k != null && this.k.length > 0) {
            this.k[d].a(q);
        }
    }

    public void a(Y y) {
        if (this.M == null) {
            this.M = new ArrayList();
        }
        this.M.add(y);
    }

    public void a(float... fArr) {
        if (fArr != null && fArr.length != 0) {
            if (this.k == null || this.k.length == 0) {
                L[] lArr = new L[m];
                lArr[d] = L.a(a.f, fArr);
                b(lArr);
            } else {
                this.k[d].a(fArr);
            }
            this.j = false;
        }
    }

    public void a(int... iArr) {
        if (iArr != null && iArr.length != 0) {
            if (this.k == null || this.k.length == 0) {
                L[] lArr = new L[m];
                lArr[d] = L.a(a.f, iArr);
                b(lArr);
            } else {
                this.k[d].a(iArr);
            }
            this.j = false;
        }
    }

    public void a(Object... objArr) {
        if (objArr != null && objArr.length != 0) {
            if (this.k == null || this.k.length == 0) {
                L[] lArr = new L[m];
                lArr[d] = L.a(a.f, null, objArr);
                b(lArr);
            } else {
                this.k[d].a(objArr);
            }
            this.j = false;
        }
    }

    public /* synthetic */ C1034a b(long j) {
        return d(j);
    }

    public Object b(String str) {
        L l = (L) this.l.get(str);
        return l != null ? l.d() : null;
    }

    public void b() {
        if (!((ArrayList) r.get()).contains(this) && !((ArrayList) s.get()).contains(this)) {
            this.C = false;
            n();
        } else if (!this.j) {
            m();
        }
        if (this.J <= 0 || (this.J & m) != m) {
            a(1.0f);
        } else {
            a(0.0f);
        }
        l();
    }

    public void b(int i) {
        this.K = i;
    }

    public void b(Y y) {
        if (this.M != null) {
            this.M.remove(y);
            if (this.M.size() == 0) {
                this.M = null;
            }
        }
    }

    public void b(L... lArr) {
        int length = lArr.length;
        this.k = lArr;
        this.l = new HashMap(length);
        for (int i = d; i < length; i += m) {
            L l = lArr[i];
            this.l.put(l.c(), l);
        }
        this.j = false;
    }

    public long c() {
        return this.H;
    }

    boolean c(long j) {
        boolean z = false;
        if (this.i == 0) {
            this.i = m;
            if (this.h < 0) {
                this.g = j;
            } else {
                this.g = j - this.h;
                this.h = -1;
            }
        }
        switch (this.i) {
            case m /*1*/:
            case n /*2*/:
                float f;
                float f2 = this.G > 0 ? ((float) (j - this.g)) / ((float) this.G) : 1.0f;
                if (f2 < 1.0f) {
                    f = f2;
                } else if (this.A < this.J || this.J == o) {
                    if (this.a != null) {
                        int size = this.a.size();
                        for (int i = d; i < size; i += m) {
                            ((C1035b) this.a.get(i)).d(this);
                        }
                    }
                    if (this.K == n) {
                        this.z = !this.z;
                    }
                    this.A += (int) f2;
                    f = f2 % 1.0f;
                    this.g += this.G;
                } else {
                    f = Math.min(f2, 1.0f);
                    z = m;
                }
                if (this.z) {
                    f = 1.0f - f;
                }
                a(f);
                break;
        }
        return z;
    }

    public long d() {
        return this.G;
    }

    public R d(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Animators cannot have negative duration: " + j);
        }
        this.G = j;
        return this;
    }

    public void e(long j) {
        m();
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.i != m) {
            this.h = j;
            this.i = n;
        }
        this.g = currentAnimationTimeMillis - j;
        c(currentAnimationTimeMillis);
    }

    public boolean e() {
        return this.i == m || this.E;
    }

    public boolean f() {
        return this.F;
    }

    public /* synthetic */ C1034a i() {
        return p();
    }

    void m() {
        if (!this.j) {
            int length = this.k.length;
            for (int i = d; i < length; i += m) {
                this.k[i].b();
            }
            this.j = true;
        }
    }

    public R p() {
        R r = (R) super.i();
        if (this.M != null) {
            ArrayList arrayList = this.M;
            r.M = new ArrayList();
            int size = arrayList.size();
            for (int i = d; i < size; i += m) {
                r.M.add((Y) arrayList.get(i));
            }
        }
        r.h = -1;
        r.z = false;
        r.A = d;
        r.j = false;
        r.i = d;
        r.C = false;
        L[] lArr = this.k;
        if (lArr != null) {
            int length = lArr.length;
            r.k = new L[length];
            r.l = new HashMap(length);
            for (int i2 = d; i2 < length; i2 += m) {
                L a = lArr[i2].a();
                r.k[i2] = a;
                r.l.put(a.c(), a);
            }
        }
        return r;
    }

    public L[] q() {
        return this.k;
    }

    public long r() {
        return (!this.j || this.i == 0) ? 0 : AnimationUtils.currentAnimationTimeMillis() - this.g;
    }

    public void start() {
        start(false);
    }

    public Object t() {
        return (this.k == null || this.k.length <= 0) ? null : this.k[d].d();
    }

    public String toString() {
        String str = "ValueAnimator@" + Integer.toHexString(hashCode());
        if (this.k != null) {
            for (int i = d; i < this.k.length; i += m) {
                str = new StringBuilder(String.valueOf(str)).append("\n    ").append(this.k[i].toString()).toString();
            }
        }
        return str;
    }

    public int u() {
        return this.J;
    }

    public int v() {
        return this.K;
    }

    public void w() {
        if (this.M != null) {
            this.M.clear();
            this.M = null;
        }
    }

    public Interpolator x() {
        return this.L;
    }

    public void y() {
        this.z = !this.z;
        if (this.i == m) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.g = currentAnimationTimeMillis - (this.G - (currentAnimationTimeMillis - this.g));
            return;
        }
        start(true);
    }

    public float z() {
        return this.B;
    }
}
