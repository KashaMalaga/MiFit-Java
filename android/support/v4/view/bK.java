package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public class bK {
    static final int a = 2113929216;
    static final bT b;
    private static final String c = "ViewAnimatorCompat";
    private WeakReference<View> d;
    private Runnable e = null;
    private Runnable f = null;
    private int g = -1;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 19) {
            b = new bS();
        } else if (i >= 18) {
            b = new bQ();
        } else if (i >= 16) {
            b = new bR();
        } else if (i >= 14) {
            b = new bO();
        } else {
            b = new bM();
        }
    }

    bK(View view) {
        this.d = new WeakReference(view);
    }

    public long a() {
        View view = (View) this.d.get();
        return view != null ? b.a(this, view) : 0;
    }

    public bK a(float f) {
        View view = (View) this.d.get();
        if (view != null) {
            b.a(this, view, f);
        }
        return this;
    }

    public bK a(long j) {
        View view = (View) this.d.get();
        if (view != null) {
            b.a(this, view, j);
        }
        return this;
    }

    public bK a(cb cbVar) {
        View view = (View) this.d.get();
        if (view != null) {
            b.a(this, view, cbVar);
        }
        return this;
    }

    public bK a(cd cdVar) {
        View view = (View) this.d.get();
        if (view != null) {
            b.a(this, view, cdVar);
        }
        return this;
    }

    public bK a(Interpolator interpolator) {
        View view = (View) this.d.get();
        if (view != null) {
            b.a(this, view, interpolator);
        }
        return this;
    }

    public bK a(Runnable runnable) {
        View view = (View) this.d.get();
        if (view != null) {
            b.a(this, view, runnable);
        }
        return this;
    }

    public bK b(float f) {
        View view = (View) this.d.get();
        if (view != null) {
            b.d(this, view, f);
        }
        return this;
    }

    public bK b(long j) {
        View view = (View) this.d.get();
        if (view != null) {
            b.b(this, view, j);
        }
        return this;
    }

    public bK b(Runnable runnable) {
        View view = (View) this.d.get();
        if (view != null) {
            b.b(this, view, runnable);
        }
        return this;
    }

    public Interpolator b() {
        View view = (View) this.d.get();
        return view != null ? b.b(this, view) : null;
    }

    public long c() {
        View view = (View) this.d.get();
        return view != null ? b.c(this, view) : 0;
    }

    public bK c(float f) {
        View view = (View) this.d.get();
        if (view != null) {
            b.b(this, view, f);
        }
        return this;
    }

    public bK d(float f) {
        View view = (View) this.d.get();
        if (view != null) {
            b.c(this, view, f);
        }
        return this;
    }

    public void d() {
        View view = (View) this.d.get();
        if (view != null) {
            b.d(this, view);
        }
    }

    public bK e() {
        View view = (View) this.d.get();
        if (view != null) {
            b.e(this, view);
        }
        return this;
    }

    public bK e(float f) {
        View view = (View) this.d.get();
        if (view != null) {
            b.e(this, view, f);
        }
        return this;
    }

    public bK f(float f) {
        View view = (View) this.d.get();
        if (view != null) {
            b.f(this, view, f);
        }
        return this;
    }

    public bK g(float f) {
        View view = (View) this.d.get();
        if (view != null) {
            b.g(this, view, f);
        }
        return this;
    }

    public bK h(float f) {
        View view = (View) this.d.get();
        if (view != null) {
            b.h(this, view, f);
        }
        return this;
    }

    public bK i(float f) {
        View view = (View) this.d.get();
        if (view != null) {
            b.i(this, view, f);
        }
        return this;
    }

    public bK j(float f) {
        View view = (View) this.d.get();
        if (view != null) {
            b.j(this, view, f);
        }
        return this;
    }

    public bK k(float f) {
        View view = (View) this.d.get();
        if (view != null) {
            b.k(this, view, f);
        }
        return this;
    }

    public bK l(float f) {
        View view = (View) this.d.get();
        if (view != null) {
            b.l(this, view, f);
        }
        return this;
    }

    public bK m(float f) {
        View view = (View) this.d.get();
        if (view != null) {
            b.m(this, view, f);
        }
        return this;
    }

    public bK n(float f) {
        View view = (View) this.d.get();
        if (view != null) {
            b.n(this, view, f);
        }
        return this;
    }

    public bK o(float f) {
        View view = (View) this.d.get();
        if (view != null) {
            b.o(this, view, f);
        }
        return this;
    }

    public bK p(float f) {
        View view = (View) this.d.get();
        if (view != null) {
            b.p(this, view, f);
        }
        return this;
    }

    public bK q(float f) {
        View view = (View) this.d.get();
        if (view != null) {
            b.q(this, view, f);
        }
        return this;
    }

    public bK r(float f) {
        View view = (View) this.d.get();
        if (view != null) {
            b.r(this, view, f);
        }
        return this;
    }

    public bK s(float f) {
        View view = (View) this.d.get();
        if (view != null) {
            b.s(this, view, f);
        }
        return this;
    }

    public void start() {
        View view = (View) this.d.get();
        if (view != null) {
            b.start(this, view);
        }
    }

    public bK t(float f) {
        View view = (View) this.d.get();
        if (view != null) {
            b.t(this, view, f);
        }
        return this;
    }
}
