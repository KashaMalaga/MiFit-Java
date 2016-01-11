package android.support.v4.view;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.WeakHashMap;

class bM implements bT {
    WeakHashMap<View, Runnable> a = null;

    bM() {
    }

    private void a(View view) {
        if (this.a != null) {
            Runnable runnable = (Runnable) this.a.get(view);
            if (runnable != null) {
                view.removeCallbacks(runnable);
            }
        }
    }

    private void f(bK bKVar, View view) {
        Object tag = view.getTag(2113929216);
        cb cbVar = tag instanceof cb ? (cb) tag : null;
        Runnable a = bKVar.e;
        Runnable b = bKVar.f;
        if (a != null) {
            a.run();
        }
        if (cbVar != null) {
            cbVar.a(view);
            cbVar.b(view);
        }
        if (b != null) {
            b.run();
        }
        if (this.a != null) {
            this.a.remove(view);
        }
    }

    private void g(bK bKVar, View view) {
        Runnable runnable = this.a != null ? (Runnable) this.a.get(view) : null;
        if (runnable == null) {
            runnable = new bN(this, bKVar, view, null);
            if (this.a == null) {
                this.a = new WeakHashMap();
            }
            this.a.put(view, runnable);
        }
        view.removeCallbacks(runnable);
        view.post(runnable);
    }

    public long a(bK bKVar, View view) {
        return 0;
    }

    public void a(bK bKVar, View view, float f) {
        g(bKVar, view);
    }

    public void a(bK bKVar, View view, long j) {
    }

    public void a(bK bKVar, View view, cb cbVar) {
        view.setTag(2113929216, cbVar);
    }

    public void a(bK bKVar, View view, cd cdVar) {
    }

    public void a(bK bKVar, View view, Interpolator interpolator) {
    }

    public void a(bK bKVar, View view, Runnable runnable) {
        bKVar.f = runnable;
        g(bKVar, view);
    }

    public Interpolator b(bK bKVar, View view) {
        return null;
    }

    public void b(bK bKVar, View view, float f) {
        g(bKVar, view);
    }

    public void b(bK bKVar, View view, long j) {
    }

    public void b(bK bKVar, View view, Runnable runnable) {
        bKVar.e = runnable;
        g(bKVar, view);
    }

    public long c(bK bKVar, View view) {
        return 0;
    }

    public void c(bK bKVar, View view, float f) {
        g(bKVar, view);
    }

    public void d(bK bKVar, View view) {
        g(bKVar, view);
    }

    public void d(bK bKVar, View view, float f) {
        g(bKVar, view);
    }

    public void e(bK bKVar, View view) {
    }

    public void e(bK bKVar, View view, float f) {
        g(bKVar, view);
    }

    public void f(bK bKVar, View view, float f) {
        g(bKVar, view);
    }

    public void g(bK bKVar, View view, float f) {
        g(bKVar, view);
    }

    public void h(bK bKVar, View view, float f) {
        g(bKVar, view);
    }

    public void i(bK bKVar, View view, float f) {
        g(bKVar, view);
    }

    public void j(bK bKVar, View view, float f) {
        g(bKVar, view);
    }

    public void k(bK bKVar, View view, float f) {
        g(bKVar, view);
    }

    public void l(bK bKVar, View view, float f) {
        g(bKVar, view);
    }

    public void m(bK bKVar, View view, float f) {
        g(bKVar, view);
    }

    public void n(bK bKVar, View view, float f) {
        g(bKVar, view);
    }

    public void o(bK bKVar, View view, float f) {
        g(bKVar, view);
    }

    public void p(bK bKVar, View view, float f) {
        g(bKVar, view);
    }

    public void q(bK bKVar, View view, float f) {
        g(bKVar, view);
    }

    public void r(bK bKVar, View view, float f) {
        g(bKVar, view);
    }

    public void s(bK bKVar, View view, float f) {
        g(bKVar, view);
    }

    public void start(bK bKVar, View view) {
        a(view);
        f(bKVar, view);
    }

    public void t(bK bKVar, View view, float f) {
        g(bKVar, view);
    }
}
