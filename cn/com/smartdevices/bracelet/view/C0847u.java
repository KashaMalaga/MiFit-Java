package cn.com.smartdevices.bracelet.view;

import android.support.v4.view.bz;

class C0847u implements bz {
    final /* synthetic */ PagerSlidingTabStrip a;

    private C0847u(PagerSlidingTabStrip pagerSlidingTabStrip) {
        this.a = pagerSlidingTabStrip;
    }

    public void a(int i) {
        if (this.a.a != null) {
            this.a.a.a(i);
        }
    }

    public void a(int i, float f, int i2) {
        this.a.i = i;
        this.a.j = f;
        this.a.b(i, (int) (((float) this.a.f.getChildAt(i).getWidth()) * f));
        this.a.invalidate();
        if (this.a.a != null) {
            this.a.a.a(i, f, i2);
        }
    }

    public void b(int i) {
        if (i == 0) {
            this.a.b(this.a.g.c(), 0);
        }
        if (this.a.a != null) {
            this.a.a.b(i);
        }
    }
}
