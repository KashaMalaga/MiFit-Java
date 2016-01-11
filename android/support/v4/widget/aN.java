package android.support.v4.widget;

import android.support.v4.widget.SlidingPaneLayout.LayoutParams;
import android.view.View;

class aN extends bi {
    final /* synthetic */ SlidingPaneLayout a;

    private aN(SlidingPaneLayout slidingPaneLayout) {
        this.a = slidingPaneLayout;
    }

    public int a(View view) {
        return this.a.o;
    }

    public int a(View view, int i, int i2) {
        LayoutParams layoutParams = (LayoutParams) this.a.l.getLayoutParams();
        if (this.a.l()) {
            int width = this.a.getWidth() - ((layoutParams.rightMargin + this.a.getPaddingRight()) + this.a.l.getWidth());
            return Math.max(Math.min(i, width), width - this.a.o);
        }
        width = layoutParams.leftMargin + this.a.getPaddingLeft();
        return Math.min(Math.max(i, width), this.a.o + width);
    }

    public void a(int i) {
        if (this.a.u.b() != 0) {
            return;
        }
        if (this.a.m == 0.0f) {
            this.a.d(this.a.l);
            this.a.c(this.a.l);
            this.a.v = false;
            return;
        }
        this.a.b(this.a.l);
        this.a.v = true;
    }

    public void a(View view, float f, float f2) {
        int paddingRight;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (this.a.l()) {
            paddingRight = layoutParams.rightMargin + this.a.getPaddingRight();
            if (f < 0.0f || (f == 0.0f && this.a.m > 0.5f)) {
                paddingRight += this.a.o;
            }
            paddingRight = (this.a.getWidth() - paddingRight) - this.a.l.getWidth();
        } else {
            paddingRight = layoutParams.leftMargin + this.a.getPaddingLeft();
            if (f > 0.0f || (f == 0.0f && this.a.m > 0.5f)) {
                paddingRight += this.a.o;
            }
        }
        this.a.u.a(paddingRight, view.getTop());
        this.a.invalidate();
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        this.a.g(i);
        this.a.invalidate();
    }

    public boolean a(View view, int i) {
        return this.a.p ? false : ((LayoutParams) view.getLayoutParams()).b;
    }

    public int b(View view, int i, int i2) {
        return view.getTop();
    }

    public void b(int i, int i2) {
        this.a.u.a(this.a.l, i2);
    }

    public void b(View view, int i) {
        this.a.d();
    }
}
