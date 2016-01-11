package android.support.v4.widget;

import android.support.v4.widget.DrawerLayout.LayoutParams;
import android.view.View;

class A extends bi {
    final /* synthetic */ DrawerLayout a;
    private final int b;
    private bf c;
    private final Runnable d = new B(this);

    public A(DrawerLayout drawerLayout, int i) {
        this.a = drawerLayout;
        this.b = i;
    }

    private void b() {
        int i = 3;
        if (this.b == 3) {
            i = 5;
        }
        View e = this.a.e(i);
        if (e != null) {
            this.a.i(e);
        }
    }

    private void c() {
        View view;
        int i;
        int i2 = 0;
        int c = this.c.c();
        boolean z = this.b == 3;
        if (z) {
            View e = this.a.e(3);
            if (e != null) {
                i2 = -e.getWidth();
            }
            i2 += c;
            view = e;
            i = i2;
        } else {
            i2 = this.a.getWidth() - c;
            view = this.a.e(5);
            i = i2;
        }
        if (view == null) {
            return;
        }
        if (((z && view.getLeft() < i) || (!z && view.getLeft() > i)) && this.a.a(view) == 0) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            this.c.a(view, i, view.getTop());
            layoutParams.c = true;
            this.a.invalidate();
            b();
            this.a.c();
        }
    }

    public int a(View view) {
        return this.a.g(view) ? view.getWidth() : 0;
    }

    public int a(View view, int i, int i2) {
        if (this.a.a(view, 3)) {
            return Math.max(-view.getWidth(), Math.min(i, 0));
        }
        int width = this.a.getWidth();
        return Math.max(width - view.getWidth(), Math.min(i, width));
    }

    public void a() {
        this.a.removeCallbacks(this.d);
    }

    public void a(int i) {
        this.a.a(this.b, i, this.c.d());
    }

    public void a(int i, int i2) {
        this.a.postDelayed(this.d, 160);
    }

    public void a(bf bfVar) {
        this.c = bfVar;
    }

    public void a(View view, float f, float f2) {
        int i;
        float d = this.a.d(view);
        int width = view.getWidth();
        if (this.a.a(view, 3)) {
            i = (f > 0.0f || (f == 0.0f && d > 0.5f)) ? 0 : -width;
        } else {
            i = this.a.getWidth();
            if (f < 0.0f || (f == 0.0f && d > 0.5f)) {
                i -= width;
            }
        }
        this.c.a(i, view.getTop());
        this.a.invalidate();
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        int width = view.getWidth();
        float width2 = this.a.a(view, 3) ? ((float) (width + i)) / ((float) width) : ((float) (this.a.getWidth() - i)) / ((float) width);
        this.a.b(view, width2);
        view.setVisibility(width2 == 0.0f ? 4 : 0);
        this.a.invalidate();
    }

    public boolean a(View view, int i) {
        return this.a.g(view) && this.a.a(view, this.b) && this.a.a(view) == 0;
    }

    public int b(View view, int i, int i2) {
        return view.getTop();
    }

    public void b(int i, int i2) {
        View e = (i & 1) == 1 ? this.a.e(3) : this.a.e(5);
        if (e != null && this.a.a(e) == 0) {
            this.c.a(e, i2);
        }
    }

    public void b(View view, int i) {
        ((LayoutParams) view.getLayoutParams()).c = false;
        b();
    }

    public boolean b(int i) {
        return false;
    }
}
