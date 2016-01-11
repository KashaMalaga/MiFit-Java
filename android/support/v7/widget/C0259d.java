package android.support.v7.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

class C0259d {
    private static final boolean d = false;
    private static final String e = "ChildrenHelper";
    final C0255f a;
    final C0260e b = new C0260e();
    final List<View> c = new ArrayList();

    C0259d(C0255f c0255f) {
        this.a = c0255f;
    }

    private int e(int i) {
        if (i < 0) {
            return -1;
        }
        int a = this.a.a();
        int i2 = i;
        while (i2 < a) {
            int e = i - (i2 - this.b.e(i2));
            if (e == 0) {
                while (this.b.c(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += e;
        }
        return -1;
    }

    View a(int i, int i2) {
        int size = this.c.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = (View) this.c.get(i3);
            aj b = this.a.b(view);
            if (b.d() == i && !b.n() && (i2 == -1 || b.g() == i2)) {
                return view;
            }
        }
        return null;
    }

    void a() {
        this.a.b();
        this.b.a();
        this.c.clear();
    }

    void a(int i) {
        int e = e(i);
        View b = this.a.b(e);
        if (b != null) {
            this.a.a(e);
            if (this.b.d(e)) {
                this.c.remove(b);
            }
        }
    }

    void a(View view) {
        int a = this.a.a(view);
        if (a >= 0) {
            this.a.a(a);
            if (this.b.d(a)) {
                this.c.remove(view);
            }
        }
    }

    void a(View view, int i, LayoutParams layoutParams, boolean z) {
        int a = i < 0 ? this.a.a() : e(i);
        this.a.a(view, a, layoutParams);
        this.b.a(a, z);
        if (z) {
            this.c.add(view);
        }
    }

    void a(View view, int i, boolean z) {
        int a = i < 0 ? this.a.a() : e(i);
        this.a.a(view, a);
        this.b.a(a, z);
        if (z) {
            this.c.add(view);
        }
    }

    void a(View view, boolean z) {
        a(view, -1, z);
    }

    int b() {
        return this.a.a() - this.c.size();
    }

    int b(View view) {
        int a = this.a.a(view);
        return (a == -1 || this.b.c(a)) ? -1 : a - this.b.e(a);
    }

    View b(int i) {
        return this.a.b(e(i));
    }

    int c() {
        return this.a.a();
    }

    View c(int i) {
        return this.a.b(i);
    }

    boolean c(View view) {
        return this.c.contains(view);
    }

    void d(int i) {
        int e = e(i);
        this.a.c(e);
        this.b.d(e);
    }

    void d(View view) {
        int a = this.a.a(view);
        if (a < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        this.b.a(a);
        this.c.add(view);
    }

    boolean e(View view) {
        int a = this.a.a(view);
        if (a == -1) {
            return this.c.remove(view) ? true : true;
        } else {
            if (!this.b.c(a)) {
                return d;
            }
            this.b.d(a);
            this.a.a(a);
            return !this.c.remove(view) ? true : true;
        }
    }

    public String toString() {
        return this.b.toString() + ", hidden list:" + this.c.size();
    }
}
