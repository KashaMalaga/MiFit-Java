package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.a.r;
import android.support.v4.view.C0151az;
import android.support.v4.view.a.C0099a;
import android.support.v4.view.a.C0113o;
import android.support.v4.view.a.C0123y;
import android.support.v4.view.a.C0124z;
import android.support.v4.view.a.Y;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import com.d.a.a.C1012a;
import java.util.ArrayList;

public abstract class W {
    private boolean a = false;
    C0259d t;
    RecyclerView u;
    @r
    ae v;

    public static int a(int i, int i2, int i3, boolean z) {
        int i4 = 1073741824;
        int max = Math.max(0, i - i2);
        if (z) {
            if (i3 < 0) {
                i4 = 0;
                i3 = 0;
            }
        } else if (i3 < 0) {
            if (i3 == -1) {
                i3 = max;
            } else if (i3 == -2) {
                i4 = af.a;
                i3 = max;
            } else {
                i4 = 0;
                i3 = 0;
            }
        }
        return MeasureSpec.makeMeasureSpec(i3, i4);
    }

    private void a(int i, View view) {
        this.t.d(i);
    }

    private void a(aa aaVar, int i, View view) {
        aj b = RecyclerView.b(view);
        if (!b.c()) {
            if (!b.n() || b.r() || b.p() || this.u.C.b()) {
                g(i);
                aaVar.d(view);
                return;
            }
            f(i);
            aaVar.b(b);
        }
    }

    private void a(View view, int i, boolean z) {
        aj b = RecyclerView.b(view);
        if (z || b.r()) {
            this.u.l(view);
        } else {
            this.u.k(view);
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (b.j() || b.h()) {
            if (b.h()) {
                b.i();
            } else {
                b.k();
            }
            this.t.a(view, i, view.getLayoutParams(), false);
        } else if (view.getParent() == this.u) {
            int b2 = this.t.b(view);
            if (i == -1) {
                i = this.t.b();
            }
            if (b2 == -1) {
                throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.u.indexOfChild(view));
            } else if (b2 != i) {
                this.u.D.b(b2, i);
            }
        } else {
            this.t.a(view, i, false);
            layoutParams.d = true;
            if (this.v != null && this.v.g()) {
                this.v.b(view);
            }
        }
        if (layoutParams.e) {
            b.a.invalidate();
            layoutParams.e = false;
        }
    }

    private void b(ae aeVar) {
        if (this.v == aeVar) {
            this.v = null;
        }
    }

    public int A() {
        return this.u != null ? this.u.getHeight() : 0;
    }

    public int B() {
        return this.u != null ? this.u.getPaddingLeft() : 0;
    }

    public int C() {
        return this.u != null ? this.u.getPaddingTop() : 0;
    }

    public int D() {
        return this.u != null ? this.u.getPaddingRight() : 0;
    }

    public int E() {
        return this.u != null ? this.u.getPaddingBottom() : 0;
    }

    public int F() {
        return this.u != null ? C0151az.q(this.u) : 0;
    }

    public int G() {
        return this.u != null ? C0151az.r(this.u) : 0;
    }

    public boolean H() {
        return this.u != null && this.u.isFocused();
    }

    public boolean I() {
        return this.u != null && this.u.hasFocus();
    }

    public View J() {
        if (this.u == null) {
            return null;
        }
        View focusedChild = this.u.getFocusedChild();
        return (focusedChild == null || this.t.c(focusedChild)) ? null : focusedChild;
    }

    public int K() {
        N d = this.u != null ? this.u.d() : null;
        return d != null ? d.a() : 0;
    }

    public int L() {
        return C0151az.w(this.u);
    }

    public int M() {
        return C0151az.x(this.u);
    }

    void N() {
        if (this.v != null) {
            this.v.stop();
        }
    }

    public void O() {
        this.a = true;
    }

    public int a(int i, aa aaVar, ag agVar) {
        return 0;
    }

    public int a(aa aaVar, ag agVar) {
        return (this.u == null || this.u.C == null || !h()) ? 1 : this.u.C.a();
    }

    public abstract LayoutParams a();

    public LayoutParams a(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public LayoutParams a(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof MarginLayoutParams ? new LayoutParams((MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public View a(View view, int i, aa aaVar, ag agVar) {
        return null;
    }

    public void a(int i, aa aaVar) {
        a(aaVar, i, h(i));
    }

    public void a(Parcelable parcelable) {
    }

    void a(C0113o c0113o) {
        a(this.u.h, this.u.p, c0113o);
    }

    public void a(N n, N n2) {
    }

    public void a(RecyclerView recyclerView) {
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
    }

    public void a(RecyclerView recyclerView, int i, int i2, int i3) {
    }

    public void a(RecyclerView recyclerView, aa aaVar) {
        d(recyclerView);
    }

    public void a(RecyclerView recyclerView, ag agVar, int i) {
        Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
    }

    public void a(aa aaVar) {
        for (int y = y() - 1; y >= 0; y--) {
            a(aaVar, y, h(y));
        }
    }

    public void a(aa aaVar, ag agVar, int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        switch (mode) {
            case af.a /*-2147483648*/:
            case 1073741824:
                break;
            default:
                size = L();
                break;
        }
        switch (mode2) {
            case af.a /*-2147483648*/:
            case 1073741824:
                break;
            default:
                size2 = M();
                break;
        }
        c(size, size2);
    }

    public void a(aa aaVar, ag agVar, C0113o c0113o) {
        c0113o.b(RecyclerView.class.getName());
        if (C0151az.b(this.u, -1) || C0151az.a(this.u, -1)) {
            c0113o.d((int) C1012a.e);
            c0113o.l(true);
        }
        if (C0151az.b(this.u, 1) || C0151az.a(this.u, 1)) {
            c0113o.d((int) ChartData.d);
            c0113o.l(true);
        }
        c0113o.b(C0123y.a(a(aaVar, agVar), b(aaVar, agVar), e(aaVar, agVar), d(aaVar, agVar)));
    }

    public void a(aa aaVar, ag agVar, View view, C0113o c0113o) {
        c0113o.c(C0124z.a(h() ? e(view) : 0, 1, g() ? e(view) : 0, 1, false, false));
    }

    public void a(aa aaVar, ag agVar, AccessibilityEvent accessibilityEvent) {
        boolean z = true;
        Y b = C0099a.b(accessibilityEvent);
        if (this.u != null && b != null) {
            if (!(C0151az.b(this.u, 1) || C0151az.b(this.u, -1) || C0151az.a(this.u, -1) || C0151az.a(this.u, 1))) {
                z = false;
            }
            b.e(z);
            if (this.u.C != null) {
                b.a(this.u.C.a());
            }
        }
    }

    public void a(ae aeVar) {
        if (!(this.v == null || aeVar == this.v || !this.v.g())) {
            this.v.stop();
        }
        this.v = aeVar;
        this.v.start(this.u, this);
    }

    public void a(View view) {
        if (this.u.l != null) {
            this.u.l.c(RecyclerView.b(view));
        }
    }

    public void a(View view, int i) {
        a(view, i, true);
    }

    public void a(View view, int i, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect g = this.u.g(view);
        view.measure(a(z(), ((g.left + g.right) + i) + (B() + D()), layoutParams.width, g()), a(A(), ((g.bottom + g.top) + i2) + (C() + E()), layoutParams.height, h()));
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        Rect rect = ((LayoutParams) view.getLayoutParams()).c;
        view.layout(rect.left + i, rect.top + i2, i3 - rect.right, i4 - rect.bottom);
    }

    public void a(View view, int i, LayoutParams layoutParams) {
        aj b = RecyclerView.b(view);
        if (b.r()) {
            this.u.l(view);
        } else {
            this.u.k(view);
        }
        this.t.a(view, i, layoutParams, b.r());
    }

    public void a(View view, Rect rect) {
        if (this.u == null) {
            rect.set(0, 0, 0, 0);
        } else {
            rect.set(this.u.g(view));
        }
    }

    void a(View view, C0113o c0113o) {
        aj b = RecyclerView.b(view);
        if (b != null && !b.r()) {
            a(this.u.h, this.u.p, view, c0113o);
        }
    }

    public void a(View view, aa aaVar) {
        a(aaVar, this.t.b(view), view);
    }

    public void a(AccessibilityEvent accessibilityEvent) {
        a(this.u.h, this.u.p, accessibilityEvent);
    }

    public void a(String str) {
        if (this.u != null) {
            this.u.b(str);
        }
    }

    boolean a(int i, Bundle bundle) {
        return a(this.u.h, this.u.p, i, bundle);
    }

    public boolean a(LayoutParams layoutParams) {
        return layoutParams != null;
    }

    public boolean a(RecyclerView recyclerView, ag agVar, View view, View view2) {
        return a(recyclerView, view, view2);
    }

    public boolean a(RecyclerView recyclerView, View view, Rect rect, boolean z) {
        int B = B();
        int C = C();
        int z2 = z() - D();
        int A = A() - E();
        int left = view.getLeft() + rect.left;
        int top = view.getTop() + rect.top;
        int width = rect.width() + left;
        int height = rect.height() + top;
        left = Math.min(0, left - B);
        C = Math.min(0, top - C);
        B = Math.max(0, width - z2);
        z2 = Math.max(0, height - A);
        if (C0151az.j(recyclerView) == 1) {
            if (B == 0) {
                B = left;
            }
            left = B;
        } else if (left == 0) {
            left = B;
        }
        B = C != 0 ? C : z2;
        if (left == 0 && B == 0) {
            return false;
        }
        if (z) {
            recyclerView.scrollBy(left, B);
        } else {
            recyclerView.b(left, B);
        }
        return true;
    }

    @Deprecated
    public boolean a(RecyclerView recyclerView, View view, View view2) {
        return v() || recyclerView.R;
    }

    public boolean a(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(android.support.v7.widget.aa r7, android.support.v7.widget.ag r8, int r9, android.os.Bundle r10) {
        /*
        r6 = this;
        r4 = -1;
        r2 = 1;
        r1 = 0;
        r0 = r6.u;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        switch(r9) {
            case 4096: goto L_0x004a;
            case 8192: goto L_0x0018;
            default: goto L_0x000b;
        };
    L_0x000b:
        r0 = r1;
        r3 = r1;
    L_0x000d:
        if (r3 != 0) goto L_0x0011;
    L_0x000f:
        if (r0 == 0) goto L_0x0007;
    L_0x0011:
        r1 = r6.u;
        r1.scrollBy(r0, r3);
        r1 = r2;
        goto L_0x0007;
    L_0x0018:
        r0 = r6.u;
        r0 = android.support.v4.view.C0151az.b(r0, r4);
        if (r0 == 0) goto L_0x007f;
    L_0x0020:
        r0 = r6.A();
        r3 = r6.C();
        r0 = r0 - r3;
        r3 = r6.E();
        r0 = r0 - r3;
        r0 = -r0;
    L_0x002f:
        r3 = r6.u;
        r3 = android.support.v4.view.C0151az.a(r3, r4);
        if (r3 == 0) goto L_0x007a;
    L_0x0037:
        r3 = r6.z();
        r4 = r6.B();
        r3 = r3 - r4;
        r4 = r6.D();
        r3 = r3 - r4;
        r3 = -r3;
        r5 = r3;
        r3 = r0;
        r0 = r5;
        goto L_0x000d;
    L_0x004a:
        r0 = r6.u;
        r0 = android.support.v4.view.C0151az.b(r0, r2);
        if (r0 == 0) goto L_0x007d;
    L_0x0052:
        r0 = r6.A();
        r3 = r6.C();
        r0 = r0 - r3;
        r3 = r6.E();
        r0 = r0 - r3;
    L_0x0060:
        r3 = r6.u;
        r3 = android.support.v4.view.C0151az.a(r3, r2);
        if (r3 == 0) goto L_0x007a;
    L_0x0068:
        r3 = r6.z();
        r4 = r6.B();
        r3 = r3 - r4;
        r4 = r6.D();
        r3 = r3 - r4;
        r5 = r3;
        r3 = r0;
        r0 = r5;
        goto L_0x000d;
    L_0x007a:
        r3 = r0;
        r0 = r1;
        goto L_0x000d;
    L_0x007d:
        r0 = r1;
        goto L_0x0060;
    L_0x007f:
        r0 = r1;
        goto L_0x002f;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.W.a(android.support.v7.widget.aa, android.support.v7.widget.ag, int, android.os.Bundle):boolean");
    }

    public boolean a(aa aaVar, ag agVar, View view, int i, Bundle bundle) {
        return false;
    }

    boolean a(View view, int i, Bundle bundle) {
        return a(this.u.h, this.u.p, view, i, bundle);
    }

    public int b(int i, aa aaVar, ag agVar) {
        return 0;
    }

    public int b(aa aaVar, ag agVar) {
        return (this.u == null || this.u.C == null || !g()) ? 1 : this.u.C.a();
    }

    public int b(ag agVar) {
        return 0;
    }

    public void b(int i, int i2) {
        View h = h(i);
        if (h == null) {
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i);
        }
        g(i);
        c(h, i2);
    }

    public void b(int i, aa aaVar) {
        View h = h(i);
        f(i);
        aaVar.a(h);
    }

    void b(RecyclerView recyclerView) {
        if (recyclerView == null) {
            this.u = null;
            this.t = null;
            return;
        }
        this.u = recyclerView;
        this.t = recyclerView.j;
    }

    public void b(RecyclerView recyclerView, int i, int i2) {
    }

    void b(aa aaVar) {
        int d = aaVar.d();
        for (int i = 0; i < d; i++) {
            View e = aaVar.e(i);
            aj b = RecyclerView.b(e);
            if (!b.c()) {
                if (b.s()) {
                    this.u.removeDetachedView(e, false);
                }
                aaVar.c(e);
            }
        }
        aaVar.e();
        if (d > 0) {
            this.u.invalidate();
        }
    }

    public void b(View view) {
        a(view, -1);
    }

    public void b(View view, int i) {
        a(view, i, false);
    }

    public void b(View view, int i, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect g = this.u.g(view);
        view.measure(a(z(), ((g.left + g.right) + i) + (((B() + D()) + layoutParams.leftMargin) + layoutParams.rightMargin), layoutParams.width, g()), a(A(), ((g.bottom + g.top) + i2) + (((C() + E()) + layoutParams.topMargin) + layoutParams.bottomMargin), layoutParams.height, h()));
    }

    public void b(View view, aa aaVar) {
        d(view);
        aaVar.a(view);
    }

    public void b(String str) {
        if (this.u != null) {
            this.u.a(str);
        }
    }

    public int c(ag agVar) {
        return 0;
    }

    public View c(int i) {
        int y = y();
        for (int i2 = 0; i2 < y; i2++) {
            View h = h(i2);
            aj b = RecyclerView.b(h);
            if (b != null && b.d() == i && !b.c() && (this.u.p.b() || !b.r())) {
                return h;
            }
        }
        return null;
    }

    public void c(int i, int i2) {
        this.u.setMeasuredDimension(i, i2);
    }

    public void c(RecyclerView recyclerView) {
    }

    public void c(RecyclerView recyclerView, int i, int i2) {
    }

    public void c(aa aaVar) {
        for (int y = y() - 1; y >= 0; y--) {
            if (!RecyclerView.b(h(y)).c()) {
                b(y, aaVar);
            }
        }
    }

    public void c(aa aaVar, ag agVar) {
        Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
    }

    public void c(View view) {
        b(view, -1);
    }

    public void c(View view, int i) {
        a(view, i, (LayoutParams) view.getLayoutParams());
    }

    public int d(aa aaVar, ag agVar) {
        return 0;
    }

    public int d(ag agVar) {
        return 0;
    }

    public View d(View view, int i) {
        return null;
    }

    @Deprecated
    public void d(RecyclerView recyclerView) {
    }

    public void d(View view) {
        this.t.a(view);
    }

    public boolean d() {
        return false;
    }

    public int e(ag agVar) {
        return 0;
    }

    public int e(View view) {
        return ((LayoutParams) view.getLayoutParams()).g();
    }

    public void e(int i) {
    }

    public boolean e(aa aaVar, ag agVar) {
        return false;
    }

    public int f(ag agVar) {
        return 0;
    }

    public int f(View view) {
        return RecyclerView.b(view).g();
    }

    public Parcelable f() {
        return null;
    }

    public void f(int i) {
        if (h(i) != null) {
            this.t.a(i);
        }
    }

    public int g(ag agVar) {
        return 0;
    }

    public void g(int i) {
        a(i, h(i));
    }

    public void g(View view) {
        int b = this.t.b(view);
        if (b >= 0) {
            a(b, view);
        }
    }

    public boolean g() {
        return false;
    }

    public View h(int i) {
        return this.t != null ? this.t.b(i) : null;
    }

    public void h(View view) {
        c(view, -1);
    }

    public boolean h() {
        return false;
    }

    public void i(int i) {
        if (this.u != null) {
            this.u.g(i);
        }
    }

    public void i(View view) {
        this.u.removeDetachedView(view, false);
    }

    public void j(int i) {
        if (this.u != null) {
            this.u.f(i);
        }
    }

    public void j(View view) {
        if (view.getParent() != this.u || this.u.indexOfChild(view) == -1) {
            throw new IllegalArgumentException("View should be fully attached to be ignored");
        }
        aj b = RecyclerView.b(view);
        b.a((int) C0113o.h);
        this.u.p.b(b);
    }

    public void k(int i) {
    }

    public void k(View view) {
        aj b = RecyclerView.b(view);
        b.m();
        b.t();
        b.a(4);
    }

    public int l(View view) {
        Rect rect = ((LayoutParams) view.getLayoutParams()).c;
        return rect.right + (view.getMeasuredWidth() + rect.left);
    }

    public int m(View view) {
        Rect rect = ((LayoutParams) view.getLayoutParams()).c;
        return rect.bottom + (view.getMeasuredHeight() + rect.top);
    }

    public int n(View view) {
        return view.getLeft() - t(view);
    }

    public int o(View view) {
        return view.getTop() - r(view);
    }

    public int p(View view) {
        return view.getRight() + u(view);
    }

    public int q(View view) {
        return view.getBottom() + s(view);
    }

    public int r(View view) {
        return ((LayoutParams) view.getLayoutParams()).c.top;
    }

    public int s(View view) {
        return ((LayoutParams) view.getLayoutParams()).c.bottom;
    }

    public int t(View view) {
        return ((LayoutParams) view.getLayoutParams()).c.left;
    }

    public void t() {
        if (this.u != null) {
            this.u.requestLayout();
        }
    }

    public int u(View view) {
        return ((LayoutParams) view.getLayoutParams()).c.right;
    }

    public boolean u() {
        return this.u != null && this.u.z;
    }

    public boolean v() {
        return this.v != null && this.v.g();
    }

    public int w() {
        return C0151az.j(this.u);
    }

    public void x() {
        for (int y = y() - 1; y >= 0; y--) {
            h(y);
            this.t.a(y);
        }
    }

    public int y() {
        return this.t != null ? this.t.b() : 0;
    }

    public int z() {
        return this.u != null ? this.u.getWidth() : 0;
    }
}
