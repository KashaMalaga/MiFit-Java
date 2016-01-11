package android.support.v4.widget;

import android.support.v4.view.C0151az;

class C0235d implements Runnable {
    final /* synthetic */ C0203a a;

    private C0235d(C0203a c0203a) {
        this.a = c0203a;
    }

    public void run() {
        if (this.a.w) {
            if (this.a.u) {
                this.a.u = false;
                this.a.i.start();
            }
            C0234c c = this.a.i;
            if (c.b() || !this.a.c()) {
                this.a.w = false;
                return;
            }
            if (this.a.v) {
                this.a.v = false;
                this.a.f();
            }
            c.c();
            this.a.a(c.f(), c.g());
            C0151az.a(this.a.k, (Runnable) this);
        }
    }
}
