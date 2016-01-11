package android.support.v7.widget;

import java.util.ArrayList;

public abstract class Q {
    private S a = null;
    private ArrayList<R> b = new ArrayList();
    private long c = 120;
    private long d = 120;
    private long e = 250;
    private long f = 250;
    private boolean g = false;

    public abstract void a();

    public void a(long j) {
        this.e = j;
    }

    void a(S s) {
        this.a = s;
    }

    public final void a(aj ajVar, boolean z) {
        d(ajVar, z);
        if (this.a != null) {
            this.a.d(ajVar);
        }
    }

    public void a(boolean z) {
        this.g = z;
    }

    public final boolean a(R r) {
        boolean b = b();
        if (r != null) {
            if (b) {
                this.b.add(r);
            } else {
                r.a();
            }
        }
        return b;
    }

    public abstract boolean a(aj ajVar);

    public abstract boolean a(aj ajVar, int i, int i2, int i3, int i4);

    public abstract boolean a(aj ajVar, aj ajVar2, int i, int i2, int i3, int i4);

    public void b(long j) {
        this.c = j;
    }

    public final void b(aj ajVar, boolean z) {
        c(ajVar, z);
    }

    public abstract boolean b();

    public abstract boolean b(aj ajVar);

    public abstract void c();

    public void c(long j) {
        this.d = j;
    }

    public abstract void c(aj ajVar);

    public void c(aj ajVar, boolean z) {
    }

    public long d() {
        return this.e;
    }

    public void d(long j) {
        this.f = j;
    }

    public final void d(aj ajVar) {
        k(ajVar);
        if (this.a != null) {
            this.a.a(ajVar);
        }
    }

    public void d(aj ajVar, boolean z) {
    }

    public long e() {
        return this.c;
    }

    public final void e(aj ajVar) {
        o(ajVar);
        if (this.a != null) {
            this.a.c(ajVar);
        }
    }

    public long f() {
        return this.d;
    }

    public final void f(aj ajVar) {
        m(ajVar);
        if (this.a != null) {
            this.a.b(ajVar);
        }
    }

    public long g() {
        return this.f;
    }

    public final void g(aj ajVar) {
        j(ajVar);
    }

    public final void h(aj ajVar) {
        n(ajVar);
    }

    public boolean h() {
        return this.g;
    }

    public final void i() {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            ((R) this.b.get(i)).a();
        }
        this.b.clear();
    }

    public final void i(aj ajVar) {
        l(ajVar);
    }

    public void j(aj ajVar) {
    }

    public void k(aj ajVar) {
    }

    public void l(aj ajVar) {
    }

    public void m(aj ajVar) {
    }

    public void n(aj ajVar) {
    }

    public void o(aj ajVar) {
    }
}
