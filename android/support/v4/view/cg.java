package android.support.v4.view;

import android.graphics.Rect;
import android.view.WindowInsets;

class cg extends cf {
    private final WindowInsets a;

    cg(WindowInsets windowInsets) {
        this.a = windowInsets;
    }

    public int a() {
        return this.a.getSystemWindowInsetLeft();
    }

    public cf a(int i, int i2, int i3, int i4) {
        return new cg(this.a.replaceSystemWindowInsets(i, i2, i3, i4));
    }

    public cf a(Rect rect) {
        return new cg(this.a.replaceSystemWindowInsets(rect));
    }

    public int b() {
        return this.a.getSystemWindowInsetTop();
    }

    public int c() {
        return this.a.getSystemWindowInsetRight();
    }

    public int d() {
        return this.a.getSystemWindowInsetBottom();
    }

    public boolean e() {
        return this.a.hasSystemWindowInsets();
    }

    public boolean f() {
        return this.a.hasInsets();
    }

    public boolean g() {
        return this.a.isConsumed();
    }

    public boolean h() {
        return this.a.isRound();
    }

    public cf i() {
        return new cg(this.a.consumeSystemWindowInsets());
    }

    public int j() {
        return this.a.getStableInsetTop();
    }

    public int k() {
        return this.a.getStableInsetLeft();
    }

    public int l() {
        return this.a.getStableInsetRight();
    }

    public int m() {
        return this.a.getStableInsetBottom();
    }

    public boolean n() {
        return this.a.hasStableInsets();
    }

    public cf o() {
        return new cg(this.a.consumeStableInsets());
    }

    WindowInsets p() {
        return this.a;
    }
}
