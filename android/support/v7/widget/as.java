package android.support.v7.widget;

import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;
import java.util.ArrayList;

class as {
    static final int a = Integer.MIN_VALUE;
    int b;
    int c;
    int d;
    final int e;
    final /* synthetic */ StaggeredGridLayoutManager f;
    private ArrayList<View> g;

    private as(StaggeredGridLayoutManager staggeredGridLayoutManager, int i) {
        this.f = staggeredGridLayoutManager;
        this.g = new ArrayList();
        this.b = a;
        this.c = a;
        this.d = 0;
        this.e = i;
    }

    int a(int i) {
        if (this.b != a) {
            return this.b;
        }
        if (this.g.size() == 0) {
            return i;
        }
        a();
        return this.b;
    }

    int a(int i, int i2, int i3) {
        if (this.g.size() == 0) {
            return 0;
        }
        int d;
        if (i < 0) {
            d = d() - i3;
            return d <= 0 ? 0 : (-i) > d ? -d : i;
        } else {
            d = i2 - b();
            return d <= 0 ? 0 : d < i ? d : i;
        }
    }

    int a(int i, int i2, boolean z) {
        int c = this.f.g.c();
        int d = this.f.g.d();
        int i3 = i2 > i ? 1 : -1;
        while (i != i2) {
            View view = (View) this.g.get(i);
            int a = this.f.g.a(view);
            int b = this.f.g.b(view);
            if (a < d && b > c) {
                if (!z) {
                    return this.f.e(view);
                }
                if (a >= c && b <= d) {
                    return this.f.e(view);
                }
            }
            i += i3;
        }
        return -1;
    }

    void a() {
        View view = (View) this.g.get(0);
        LayoutParams c = c(view);
        this.b = this.f.g.a(view);
        if (c.g) {
            FullSpanItem f = this.f.l.f(c.g());
            if (f != null && f.b == -1) {
                this.b -= f.a(this.e);
            }
        }
    }

    void a(View view) {
        LayoutParams c = c(view);
        c.f = this;
        this.g.add(0, view);
        this.b = a;
        if (this.g.size() == 1) {
            this.c = a;
        }
        if (c.e() || c.f()) {
            this.d += this.f.g.c(view);
        }
    }

    void a(boolean z, int i) {
        int b = z ? b((int) a) : a((int) a);
        e();
        if (b != a) {
            if (z && b < this.f.g.d()) {
                return;
            }
            if (z || b <= this.f.g.c()) {
                if (i != a) {
                    b += i;
                }
                this.c = b;
                this.b = b;
            }
        }
    }

    boolean a(int i, int i2) {
        int size = this.g.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = (View) this.g.get(i3);
            if (this.f.g.a(view) < i2 && this.f.g.b(view) > i) {
                return false;
            }
        }
        return true;
    }

    int b() {
        if (this.b != a) {
            return this.b;
        }
        a();
        return this.b;
    }

    int b(int i) {
        if (this.c != a) {
            return this.c;
        }
        if (this.g.size() == 0) {
            return i;
        }
        c();
        return this.c;
    }

    void b(View view) {
        LayoutParams c = c(view);
        c.f = this;
        this.g.add(view);
        this.c = a;
        if (this.g.size() == 1) {
            this.b = a;
        }
        if (c.e() || c.f()) {
            this.d += this.f.g.c(view);
        }
    }

    LayoutParams c(View view) {
        return (LayoutParams) view.getLayoutParams();
    }

    void c() {
        View view = (View) this.g.get(this.g.size() - 1);
        LayoutParams c = c(view);
        this.c = this.f.g.b(view);
        if (c.g) {
            FullSpanItem f = this.f.l.f(c.g());
            if (f != null && f.b == 1) {
                this.c = f.a(this.e) + this.c;
            }
        }
    }

    void c(int i) {
        this.b = i;
        this.c = i;
    }

    int d() {
        if (this.c != a) {
            return this.c;
        }
        c();
        return this.c;
    }

    void d(int i) {
        if (this.b != a) {
            this.b += i;
        }
        if (this.c != a) {
            this.c += i;
        }
    }

    void e() {
        this.g.clear();
        f();
        this.d = 0;
    }

    void f() {
        this.b = a;
        this.c = a;
    }

    void g() {
        int size = this.g.size();
        View view = (View) this.g.remove(size - 1);
        LayoutParams c = c(view);
        c.f = null;
        if (c.e() || c.f()) {
            this.d -= this.f.g.c(view);
        }
        if (size == 1) {
            this.b = a;
        }
        this.c = a;
    }

    void h() {
        View view = (View) this.g.remove(0);
        LayoutParams c = c(view);
        c.f = null;
        if (this.g.size() == 0) {
            this.c = a;
        }
        if (c.e() || c.f()) {
            this.d -= this.f.g.c(view);
        }
        this.b = a;
    }

    public int i() {
        return this.d;
    }

    public int j() {
        return this.f.w ? a(this.g.size() - 1, -1, false) : a(0, this.g.size(), false);
    }

    public int k() {
        return this.f.w ? a(this.g.size() - 1, -1, true) : a(0, this.g.size(), true);
    }

    public int l() {
        return this.f.w ? a(0, this.g.size(), false) : a(this.g.size() - 1, -1, false);
    }

    public int m() {
        return this.f.w ? a(0, this.g.size(), true) : a(this.g.size() - 1, -1, true);
    }
}
