package com.e.c;

import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import com.e.a.C1035b;
import java.lang.ref.WeakReference;

class i extends c {
    private static final long a = -1;
    private final WeakReference<ViewPropertyAnimator> b;

    i(View view) {
        this.b = new WeakReference(view.animate());
    }

    public long a() {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.b.get();
        return viewPropertyAnimator != null ? viewPropertyAnimator.getDuration() : a;
    }

    public c a(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.x(f);
        }
        return this;
    }

    public c a(long j) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setDuration(j);
        }
        return this;
    }

    public c a(Interpolator interpolator) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setInterpolator(interpolator);
        }
        return this;
    }

    public c a(C1035b c1035b) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.b.get();
        if (viewPropertyAnimator != null) {
            if (c1035b == null) {
                viewPropertyAnimator.setListener(null);
            } else {
                viewPropertyAnimator.setListener(new j(this, c1035b));
            }
        }
        return this;
    }

    public long b() {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.b.get();
        return viewPropertyAnimator != null ? viewPropertyAnimator.getStartDelay() : a;
    }

    public c b(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.xBy(f);
        }
        return this;
    }

    public c b(long j) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setStartDelay(j);
        }
        return this;
    }

    public c c(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.y(f);
        }
        return this;
    }

    public void c() {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public c d(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.yBy(f);
        }
        return this;
    }

    public c e(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotation(f);
        }
        return this;
    }

    public c f(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationBy(f);
        }
        return this;
    }

    public c g(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationX(f);
        }
        return this;
    }

    public c h(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationXBy(f);
        }
        return this;
    }

    public c i(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationY(f);
        }
        return this;
    }

    public c j(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationYBy(f);
        }
        return this;
    }

    public c k(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationX(f);
        }
        return this;
    }

    public c l(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationXBy(f);
        }
        return this;
    }

    public c m(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationY(f);
        }
        return this;
    }

    public c n(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationYBy(f);
        }
        return this;
    }

    public c o(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleX(f);
        }
        return this;
    }

    public c p(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleXBy(f);
        }
        return this;
    }

    public c q(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleY(f);
        }
        return this;
    }

    public c r(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleYBy(f);
        }
        return this;
    }

    public c s(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.alpha(f);
        }
        return this;
    }

    public void start() {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.start();
        }
    }

    public c t(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.alphaBy(f);
        }
        return this;
    }
}
