package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.a.C0113o;
import android.support.v4.view.a.C0124z;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
    public static final int a = -1;
    static final int b = MeasureSpec.makeMeasureSpec(b, b);
    private static final boolean w = false;
    private static final String x = "GridLayoutManager";
    int c = a;
    int d;
    View[] e;
    final SparseIntArray f = new SparseIntArray();
    final SparseIntArray g = new SparseIntArray();
    C0273t h = new C0274s();
    final Rect i = new Rect();

    public class LayoutParams extends android.support.v7.widget.RecyclerView.LayoutParams {
        public static final int a = -1;
        private int f = a;
        private int g = GridLayoutManager.b;

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(android.support.v7.widget.RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public int a() {
            return this.f;
        }

        public int b() {
            return this.g;
        }
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        a(i);
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        a(i);
    }

    private void P() {
        this.f.clear();
        this.g.clear();
    }

    private void Q() {
        int y = y();
        for (int i = b; i < y; i++) {
            LayoutParams layoutParams = (LayoutParams) h(i).getLayoutParams();
            int g = layoutParams.g();
            this.f.put(g, layoutParams.b());
            this.g.put(g, layoutParams.a());
        }
    }

    private void R() {
        this.d = (j() == 1 ? (z() - D()) - B() : (A() - E()) - C()) / this.c;
    }

    private int a(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        return (mode == af.a || mode == 1073741824) ? MeasureSpec.makeMeasureSpec((MeasureSpec.getSize(i) - i2) - i3, mode) : i;
    }

    private int a(aa aaVar, ag agVar, int i) {
        if (!agVar.b()) {
            return this.h.c(i, this.c);
        }
        int b = aaVar.b(i);
        if (b != a) {
            return this.h.c(b, this.c);
        }
        Log.w(x, "Cannot find span size for pre layout position. " + i);
        return b;
    }

    private void a(aa aaVar, ag agVar, int i, int i2, boolean z) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (z) {
            i3 = 1;
            i4 = b;
        } else {
            i4 = i + a;
            i3 = a;
            i = a;
        }
        if (this.m == 1 && l()) {
            i5 = i2 + a;
            i6 = a;
        } else {
            i5 = b;
            i6 = 1;
        }
        int i7 = i5;
        for (i5 = i4; i5 != i; i5 += i3) {
            View view = this.e[i5];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.g = c(aaVar, agVar, e(view));
            if (i6 != a || layoutParams.g <= 1) {
                layoutParams.f = i7;
            } else {
                layoutParams.f = i7 - (layoutParams.g + a);
            }
            i7 += layoutParams.g * i6;
        }
    }

    private void a(C0277w c0277w) {
        int b = this.h.b(c0277w.a, this.c);
        while (b > 0 && c0277w.a > 0) {
            c0277w.a += a;
            b = this.h.b(c0277w.a, this.c);
        }
    }

    private int b(aa aaVar, ag agVar, int i) {
        if (!agVar.b()) {
            return this.h.b(i, this.c);
        }
        int i2 = this.g.get(i, a);
        if (i2 != a) {
            return i2;
        }
        i2 = aaVar.b(i);
        if (i2 != a) {
            return this.h.b(i2, this.c);
        }
        Log.w(x, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return b;
    }

    private int c(aa aaVar, ag agVar, int i) {
        if (!agVar.b()) {
            return this.h.a(i);
        }
        int i2 = this.f.get(i, a);
        if (i2 != a) {
            return i2;
        }
        i2 = aaVar.b(i);
        if (i2 != a) {
            return this.h.a(i2);
        }
        Log.w(x, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    private void c(View view, int i, int i2) {
        a(view, this.i);
        android.support.v7.widget.RecyclerView.LayoutParams layoutParams = (android.support.v7.widget.RecyclerView.LayoutParams) view.getLayoutParams();
        view.measure(a(i, layoutParams.leftMargin + this.i.left, layoutParams.rightMargin + this.i.right), a(i2, layoutParams.topMargin + this.i.top, layoutParams.bottomMargin + this.i.bottom));
    }

    private int l(int i) {
        return i < 0 ? b : MeasureSpec.makeMeasureSpec(i, 1073741824);
    }

    public int a(aa aaVar, ag agVar) {
        return this.m == 0 ? this.c : agVar.h() < 1 ? b : a(aaVar, agVar, agVar.h() + a);
    }

    public android.support.v7.widget.RecyclerView.LayoutParams a() {
        return new LayoutParams(-2, -2);
    }

    public android.support.v7.widget.RecyclerView.LayoutParams a(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public android.support.v7.widget.RecyclerView.LayoutParams a(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new LayoutParams((MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public void a(int i) {
        if (i != this.c) {
            if (i < 1) {
                throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
            }
            this.c = i;
            this.h.a();
        }
    }

    public void a(RecyclerView recyclerView) {
        this.h.a();
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.h.a();
    }

    public void a(RecyclerView recyclerView, int i, int i2, int i3) {
        this.h.a();
    }

    void a(aa aaVar, ag agVar, C0279y c0279y, C0278x c0278x) {
        boolean z = c0279y.l == 1 ? true : w;
        int i = b;
        int i2 = b;
        int i3 = this.c;
        if (!z) {
            i3 = b(aaVar, agVar, c0279y.k) + c(aaVar, agVar, c0279y.k);
        }
        while (i < this.c && c0279y.a(agVar) && i3 > 0) {
            int i4 = c0279y.k;
            int c = c(aaVar, agVar, i4);
            if (c <= this.c) {
                i3 -= c;
                if (i3 >= 0) {
                    View a = c0279y.a(aaVar);
                    if (a == null) {
                        break;
                    }
                    i2 += c;
                    this.e[i] = a;
                    i++;
                } else {
                    break;
                }
            }
            throw new IllegalArgumentException("Item at position " + i4 + " requires " + c + " spans but GridLayoutManager has only " + this.c + " spans.");
        }
        if (i == 0) {
            c0278x.b = true;
            return;
        }
        int makeMeasureSpec;
        a(aaVar, agVar, i, i2, z);
        c = b;
        i4 = b;
        while (c < i) {
            View view = this.e[c];
            if (c0279y.q == null) {
                if (z) {
                    c(view);
                } else {
                    b(view, (int) b);
                }
            } else if (z) {
                b(view);
            } else {
                a(view, (int) b);
            }
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(c(aaVar, agVar, e(view)) * this.d, 1073741824);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.m == 1) {
                c(view, makeMeasureSpec, l(layoutParams.height));
            } else {
                c(view, l(layoutParams.width), makeMeasureSpec);
            }
            i3 = this.n.c(view);
            if (i3 <= i4) {
                i3 = i4;
            }
            c++;
            i4 = i3;
        }
        c = l(i4);
        for (i3 = b; i3 < i; i3++) {
            view = this.e[i3];
            if (this.n.c(view) != i4) {
                int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(c(aaVar, agVar, e(view)) * this.d, 1073741824);
                if (this.m == 1) {
                    c(view, makeMeasureSpec2, c);
                } else {
                    c(view, c, makeMeasureSpec2);
                }
            }
        }
        c0278x.a = i4;
        i3 = b;
        if (this.m == 1) {
            if (c0279y.m == a) {
                i3 = c0279y.i;
                i4 = i3 - i4;
                c = b;
                i2 = b;
            } else {
                c = c0279y.i;
                i3 = c + i4;
                i4 = c;
                c = b;
                i2 = b;
            }
        } else if (c0279y.m == a) {
            i2 = c0279y.i;
            c = i2;
            i2 -= i4;
            i4 = b;
        } else {
            i2 = c0279y.i;
            c = i4 + i2;
            i4 = b;
        }
        int i5 = b;
        makeMeasureSpec = i2;
        i2 = c;
        c = i4;
        i4 = i3;
        while (i5 < i) {
            int d;
            int i6;
            View view2 = this.e[i5];
            layoutParams = (LayoutParams) view2.getLayoutParams();
            if (this.m == 1) {
                makeMeasureSpec = (this.d * layoutParams.f) + B();
                d = this.n.d(view2) + makeMeasureSpec;
                i6 = makeMeasureSpec;
            } else {
                c = (this.d * layoutParams.f) + C();
                i4 = this.n.d(view2) + c;
                d = i2;
                i6 = makeMeasureSpec;
            }
            a(view2, i6 + layoutParams.leftMargin, c + layoutParams.topMargin, d - layoutParams.rightMargin, i4 - layoutParams.bottomMargin);
            if (layoutParams.e() || layoutParams.f()) {
                c0278x.c = true;
            }
            c0278x.d |= view2.isFocusable();
            i5++;
            i2 = d;
            makeMeasureSpec = i6;
        }
        Arrays.fill(this.e, null);
    }

    public void a(aa aaVar, ag agVar, View view, C0113o c0113o) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            int a = a(aaVar, agVar, layoutParams2.g());
            if (this.m == 0) {
                int a2 = layoutParams2.a();
                int b = layoutParams2.b();
                boolean z = (this.c <= 1 || layoutParams2.b() != this.c) ? w : true;
                c0113o.c(C0124z.a(a2, b, a, 1, z, w));
                return;
            }
            int a3 = layoutParams2.a();
            int b2 = layoutParams2.b();
            boolean z2 = (this.c <= 1 || layoutParams2.b() != this.c) ? w : true;
            c0113o.c(C0124z.a(a, 1, a3, b2, z2, w));
            return;
        }
        super.a(view, c0113o);
    }

    void a(ag agVar, C0277w c0277w) {
        super.a(agVar, c0277w);
        R();
        if (agVar.h() > 0 && !agVar.b()) {
            a(c0277w);
        }
        if (this.e == null || this.e.length != this.c) {
            this.e = new View[this.c];
        }
    }

    public void a(C0273t c0273t) {
        this.h = c0273t;
    }

    public void a(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.a((boolean) w);
    }

    public boolean a(android.support.v7.widget.RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public int b(aa aaVar, ag agVar) {
        return this.m == 1 ? this.c : agVar.h() < 1 ? b : a(aaVar, agVar, agVar.h() + a);
    }

    public C0273t b() {
        return this.h;
    }

    public void b(RecyclerView recyclerView, int i, int i2) {
        this.h.a();
    }

    public int c() {
        return this.c;
    }

    public void c(RecyclerView recyclerView, int i, int i2) {
        this.h.a();
    }

    public void c(aa aaVar, ag agVar) {
        if (agVar.b()) {
            Q();
        }
        super.c(aaVar, agVar);
        P();
    }

    public boolean d() {
        return this.r == null ? true : w;
    }
}
