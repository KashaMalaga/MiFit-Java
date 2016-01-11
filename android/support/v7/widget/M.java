package android.support.v7.widget;

import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class M implements C0256b {
    final /* synthetic */ RecyclerView a;

    M(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    public aj a(int i) {
        return this.a.a(i, true);
    }

    public void a(int i, int i2) {
        this.a.a(i, i2, true);
        this.a.q = true;
        ag.a(this.a.p, i2);
    }

    public void a(C0258c c0258c) {
        c(c0258c);
    }

    public void b(int i, int i2) {
        this.a.a(i, i2, false);
        this.a.q = true;
    }

    public void b(C0258c c0258c) {
        c(c0258c);
    }

    public void c(int i, int i2) {
        this.a.g(i, i2);
        this.a.r = true;
    }

    void c(C0258c c0258c) {
        switch (c0258c.f) {
            case a.i /*0*/:
                this.a.D.a(this.a, c0258c.g, c0258c.h);
                return;
            case l.a /*1*/:
                this.a.D.b(this.a, c0258c.g, c0258c.h);
                return;
            case a.k /*2*/:
                this.a.D.c(this.a, c0258c.g, c0258c.h);
                return;
            case a.l /*3*/:
                this.a.D.a(this.a, c0258c.g, c0258c.h, 1);
                return;
            default:
                return;
        }
    }

    public void d(int i, int i2) {
        this.a.f(i, i2);
        this.a.q = true;
    }

    public void e(int i, int i2) {
        this.a.e(i, i2);
        this.a.q = true;
    }
}
