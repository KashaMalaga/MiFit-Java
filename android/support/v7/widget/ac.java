package android.support.v7.widget;

import android.support.v4.view.C0151az;

class ac extends P {
    final /* synthetic */ RecyclerView a;

    private ac(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    public void a() {
        this.a.b(null);
        if (this.a.C.b()) {
            this.a.p.i = true;
            this.a.Q = true;
        } else {
            this.a.p.i = true;
            this.a.Q = true;
        }
        if (!this.a.i.d()) {
            this.a.requestLayout();
        }
    }

    public void a(int i, int i2) {
        this.a.b(null);
        if (this.a.i.b(i, i2)) {
            b();
        }
    }

    public void a(int i, int i2, int i3) {
        this.a.b(null);
        if (this.a.i.a(i, i2, i3)) {
            b();
        }
    }

    void b() {
        if (this.a.O && this.a.J && this.a.I) {
            C0151az.a(this.a, this.a.A);
            return;
        }
        this.a.N = true;
        this.a.requestLayout();
    }

    public void b(int i, int i2) {
        this.a.b(null);
        if (this.a.i.c(i, i2)) {
            b();
        }
    }

    public void c(int i, int i2) {
        this.a.b(null);
        if (this.a.i.d(i, i2)) {
            b();
        }
    }
}
