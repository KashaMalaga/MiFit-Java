package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.C0151az;
import android.support.v4.view.a.C0099a;
import android.support.v4.view.a.C0113o;
import android.support.v4.view.a.C0124z;
import android.support.v4.view.a.Y;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import kankan.wheel.widget.a;

public class StaggeredGridLayoutManager extends W {
    public static final String a = "StaggeredGridLayoutManager";
    public static final int b = 0;
    public static final int c = 1;
    public static final int d = 0;
    @Deprecated
    public static final int e = 1;
    public static final int f = 2;
    private static final boolean m = false;
    private static final int n = Integer.MIN_VALUE;
    private boolean A;
    private SavedState B;
    private int C;
    private int D;
    private int E;
    private final ap F = new ap();
    private boolean G = m;
    private boolean H = true;
    private final Runnable I = new an(this);
    D g;
    D h;
    boolean i = m;
    int j = -1;
    int k = n;
    LazySpanLookup l = new LazySpanLookup();
    private int o = -1;
    private as[] p;
    private int q;
    private int r;
    private C0275u s;
    private boolean w = m;
    private BitSet x;
    private int y = f;
    private boolean z;

    public class LayoutParams extends android.support.v7.widget.RecyclerView.LayoutParams {
        public static final int a = -1;
        as f;
        boolean g;

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

        public void a(boolean z) {
            this.g = z;
        }

        public boolean a() {
            return this.g;
        }

        public final int b() {
            return this.f == null ? a : this.f.e;
        }
    }

    class LazySpanLookup {
        private static final int c = 10;
        int[] a;
        List<FullSpanItem> b;

        class FullSpanItem implements Parcelable {
            public static final Creator<FullSpanItem> CREATOR = new aq();
            int a;
            int b;
            int[] c;

            public FullSpanItem(Parcel parcel) {
                this.a = parcel.readInt();
                this.b = parcel.readInt();
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.c = new int[readInt];
                    parcel.readIntArray(this.c);
                }
            }

            int a(int i) {
                return this.c == null ? StaggeredGridLayoutManager.d : this.c[i];
            }

            public void a() {
                this.c = null;
            }

            public int describeContents() {
                return StaggeredGridLayoutManager.d;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.a + ", mGapDir=" + this.b + ", mGapPerSpan=" + Arrays.toString(this.c) + '}';
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.a);
                parcel.writeInt(this.b);
                if (this.c == null || this.c.length <= 0) {
                    parcel.writeInt(StaggeredGridLayoutManager.d);
                    return;
                }
                parcel.writeInt(this.c.length);
                parcel.writeIntArray(this.c);
            }
        }

        LazySpanLookup() {
        }

        private void c(int i, int i2) {
            if (this.b != null) {
                int i3 = i + i2;
                for (int size = this.b.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = (FullSpanItem) this.b.get(size);
                    if (fullSpanItem.a >= i) {
                        if (fullSpanItem.a < i3) {
                            this.b.remove(size);
                        } else {
                            fullSpanItem.a -= i2;
                        }
                    }
                }
            }
        }

        private void d(int i, int i2) {
            if (this.b != null) {
                for (int size = this.b.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = (FullSpanItem) this.b.get(size);
                    if (fullSpanItem.a >= i) {
                        fullSpanItem.a += i2;
                    }
                }
            }
        }

        private int g(int i) {
            if (this.b == null) {
                return -1;
            }
            FullSpanItem f = f(i);
            if (f != null) {
                this.b.remove(f);
            }
            int size = this.b.size();
            int i2 = StaggeredGridLayoutManager.d;
            while (i2 < size) {
                if (((FullSpanItem) this.b.get(i2)).a >= i) {
                    break;
                }
                i2 += StaggeredGridLayoutManager.e;
            }
            i2 = -1;
            if (i2 == -1) {
                return -1;
            }
            f = (FullSpanItem) this.b.get(i2);
            this.b.remove(i2);
            return f.a;
        }

        int a(int i) {
            if (this.b != null) {
                for (int size = this.b.size() - 1; size >= 0; size--) {
                    if (((FullSpanItem) this.b.get(size)).a >= i) {
                        this.b.remove(size);
                    }
                }
            }
            return b(i);
        }

        public FullSpanItem a(int i, int i2, int i3) {
            if (this.b == null) {
                return null;
            }
            for (int i4 = StaggeredGridLayoutManager.d; i4 < this.b.size(); i4 += StaggeredGridLayoutManager.e) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.b.get(i4);
                if (fullSpanItem.a >= i2) {
                    return null;
                }
                if (fullSpanItem.a >= i && (i3 == 0 || fullSpanItem.b == i3)) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        void a() {
            if (this.a != null) {
                Arrays.fill(this.a, -1);
            }
            this.b = null;
        }

        void a(int i, int i2) {
            if (this.a != null && i < this.a.length) {
                e(i + i2);
                System.arraycopy(this.a, i + i2, this.a, i, (this.a.length - i) - i2);
                Arrays.fill(this.a, this.a.length - i2, this.a.length, -1);
                c(i, i2);
            }
        }

        void a(int i, as asVar) {
            e(i);
            this.a[i] = asVar.e;
        }

        public void a(FullSpanItem fullSpanItem) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            int size = this.b.size();
            for (int i = StaggeredGridLayoutManager.d; i < size; i += StaggeredGridLayoutManager.e) {
                FullSpanItem fullSpanItem2 = (FullSpanItem) this.b.get(i);
                if (fullSpanItem2.a == fullSpanItem.a) {
                    this.b.remove(i);
                }
                if (fullSpanItem2.a >= fullSpanItem.a) {
                    this.b.add(i, fullSpanItem);
                    return;
                }
            }
            this.b.add(fullSpanItem);
        }

        int b(int i) {
            if (this.a == null || i >= this.a.length) {
                return -1;
            }
            int g = g(i);
            if (g == -1) {
                Arrays.fill(this.a, i, this.a.length, -1);
                return this.a.length;
            }
            Arrays.fill(this.a, i, g + StaggeredGridLayoutManager.e, -1);
            return g + StaggeredGridLayoutManager.e;
        }

        void b(int i, int i2) {
            if (this.a != null && i < this.a.length) {
                e(i + i2);
                System.arraycopy(this.a, i, this.a, i + i2, (this.a.length - i) - i2);
                Arrays.fill(this.a, i, i + i2, -1);
                d(i, i2);
            }
        }

        int c(int i) {
            return (this.a == null || i >= this.a.length) ? -1 : this.a[i];
        }

        int d(int i) {
            int length = this.a.length;
            while (length <= i) {
                length *= StaggeredGridLayoutManager.f;
            }
            return length;
        }

        void e(int i) {
            if (this.a == null) {
                this.a = new int[(Math.max(i, c) + StaggeredGridLayoutManager.e)];
                Arrays.fill(this.a, -1);
            } else if (i >= this.a.length) {
                Object obj = this.a;
                this.a = new int[d(i)];
                System.arraycopy(obj, StaggeredGridLayoutManager.d, this.a, StaggeredGridLayoutManager.d, obj.length);
                Arrays.fill(this.a, obj.length, this.a.length, -1);
            }
        }

        public FullSpanItem f(int i) {
            if (this.b == null) {
                return null;
            }
            for (int size = this.b.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.b.get(size);
                if (fullSpanItem.a == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }
    }

    class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new ar();
        int a;
        int b;
        int c;
        int[] d;
        int e;
        int[] f;
        List<FullSpanItem> g;
        boolean h;
        boolean i;
        boolean j;

        SavedState(Parcel parcel) {
            boolean z = true;
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readInt();
            if (this.c > 0) {
                this.d = new int[this.c];
                parcel.readIntArray(this.d);
            }
            this.e = parcel.readInt();
            if (this.e > 0) {
                this.f = new int[this.e];
                parcel.readIntArray(this.f);
            }
            this.h = parcel.readInt() == StaggeredGridLayoutManager.e ? true : StaggeredGridLayoutManager.m;
            this.i = parcel.readInt() == StaggeredGridLayoutManager.e ? true : StaggeredGridLayoutManager.m;
            if (parcel.readInt() != StaggeredGridLayoutManager.e) {
                z = StaggeredGridLayoutManager.m;
            }
            this.j = z;
            this.g = parcel.readArrayList(FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.c = savedState.c;
            this.a = savedState.a;
            this.b = savedState.b;
            this.d = savedState.d;
            this.e = savedState.e;
            this.f = savedState.f;
            this.h = savedState.h;
            this.i = savedState.i;
            this.j = savedState.j;
            this.g = savedState.g;
        }

        void a() {
            this.d = null;
            this.c = StaggeredGridLayoutManager.d;
            this.e = StaggeredGridLayoutManager.d;
            this.f = null;
            this.g = null;
        }

        void b() {
            this.d = null;
            this.c = StaggeredGridLayoutManager.d;
            this.a = -1;
            this.b = -1;
        }

        public int describeContents() {
            return StaggeredGridLayoutManager.d;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2 = StaggeredGridLayoutManager.e;
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            if (this.c > 0) {
                parcel.writeIntArray(this.d);
            }
            parcel.writeInt(this.e);
            if (this.e > 0) {
                parcel.writeIntArray(this.f);
            }
            parcel.writeInt(this.h ? StaggeredGridLayoutManager.e : StaggeredGridLayoutManager.d);
            parcel.writeInt(this.i ? StaggeredGridLayoutManager.e : StaggeredGridLayoutManager.d);
            if (!this.j) {
                i2 = StaggeredGridLayoutManager.d;
            }
            parcel.writeInt(i2);
            parcel.writeList(this.g);
        }
    }

    public StaggeredGridLayoutManager(int i, int i2) {
        this.q = i2;
        a(i);
    }

    private int a(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        return (mode == n || mode == 1073741824) ? MeasureSpec.makeMeasureSpec((MeasureSpec.getSize(i) - i2) - i3, mode) : i;
    }

    private int a(aa aaVar, C0275u c0275u, ag agVar) {
        int d;
        int i;
        int g;
        this.x.set(d, this.o, true);
        if (c0275u.k == e) {
            d = this.g.d() + this.s.h;
            i = d;
            g = (this.s.l + d) + this.g.g();
        } else {
            d = this.g.c() - this.s.h;
            i = d;
            g = (d - this.s.l) - this.g.c();
        }
        d(c0275u.k, g);
        int d2 = this.i ? this.g.d() : this.g.c();
        while (c0275u.a(agVar) && !this.x.isEmpty()) {
            as asVar;
            int c;
            View a = c0275u.a(aaVar);
            LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
            if (c0275u.k == e) {
                c(a);
            } else {
                b(a, (int) d);
            }
            a(a, layoutParams);
            int g2 = layoutParams.g();
            int c2 = this.l.c(g2);
            Object obj = c2 == -1 ? e : d;
            if (obj != null) {
                as a2 = layoutParams.g ? this.p[d] : a(c0275u);
                this.l.a(g2, a2);
                asVar = a2;
            } else {
                asVar = this.p[c2];
            }
            if (c0275u.k == e) {
                d = layoutParams.g ? p(d2) : asVar.b(d2);
                c = d + this.g.c(a);
                if (obj == null || !layoutParams.g) {
                    c2 = d;
                } else {
                    FullSpanItem l = l(d);
                    l.b = -1;
                    l.a = g2;
                    this.l.a(l);
                    c2 = d;
                }
            } else {
                d = layoutParams.g ? o(d2) : asVar.a(d2);
                c2 = d - this.g.c(a);
                if (obj != null && layoutParams.g) {
                    FullSpanItem m = m(d);
                    m.b = e;
                    m.a = g2;
                    this.l.a(m);
                }
                c = d;
            }
            if (layoutParams.g && c0275u.j == -1 && obj != null) {
                this.G = true;
            }
            layoutParams.f = asVar;
            a(a, layoutParams, c0275u);
            int c3 = layoutParams.g ? this.h.c() : this.h.c() + (asVar.e * this.r);
            g2 = c3 + this.h.c(a);
            if (this.q == e) {
                b(a, c3, c2, g2, c);
            } else {
                b(a, c2, c3, c, g2);
            }
            if (layoutParams.g) {
                d(this.s.k, g);
            } else {
                a(asVar, this.s.k, g);
            }
            a(aaVar, this.s, asVar, i);
        }
        if (this.s.k == -1) {
            return Math.max(d, (i - o(this.g.c())) + this.s.h);
        }
        return Math.max(d, (p(this.g.d()) - i) + this.s.h);
    }

    private int a(ag agVar) {
        boolean z = true;
        if (y() == 0) {
            return d;
        }
        p();
        D d = this.g;
        View b = b(!this.H ? true : m);
        if (this.H) {
            z = m;
        }
        return am.a(agVar, d, b, c(z), this, this.H, this.i);
    }

    private as a(C0275u c0275u) {
        int i;
        int i2;
        as asVar = null;
        int i3 = -1;
        if (r(c0275u.k)) {
            i = this.o - 1;
            i2 = -1;
        } else {
            i = d;
            i2 = this.o;
            i3 = e;
        }
        int c;
        int i4;
        as asVar2;
        int b;
        as asVar3;
        if (c0275u.k == e) {
            c = this.g.c();
            i4 = i;
            i = Integer.MAX_VALUE;
            while (i4 != i2) {
                asVar2 = this.p[i4];
                b = asVar2.b(c);
                if (b < i) {
                    asVar3 = asVar2;
                } else {
                    b = i;
                    asVar3 = asVar;
                }
                i4 += i3;
                asVar = asVar3;
                i = b;
            }
        } else {
            c = this.g.d();
            i4 = i;
            i = n;
            while (i4 != i2) {
                asVar2 = this.p[i4];
                b = asVar2.a(c);
                if (b > i) {
                    asVar3 = asVar2;
                } else {
                    b = i;
                    asVar3 = asVar;
                }
                i4 += i3;
                asVar = asVar3;
                i = b;
            }
        }
        return asVar;
    }

    private void a(int i, ag agVar) {
        int i2 = e;
        this.s.h = d;
        this.s.i = i;
        if (v()) {
            if (this.i == (agVar.e() < i ? e : d)) {
                this.s.l = d;
            } else {
                this.s.l = this.g.f();
            }
        } else {
            this.s.l = d;
        }
        this.s.k = -1;
        C0275u c0275u = this.s;
        if (!this.i) {
            i2 = -1;
        }
        c0275u.j = i2;
    }

    private void a(aa aaVar, int i) {
        while (y() > 0) {
            View h = h((int) d);
            if (this.g.b(h) < i) {
                LayoutParams layoutParams = (LayoutParams) h.getLayoutParams();
                if (layoutParams.g) {
                    for (int i2 = d; i2 < this.o; i2 += e) {
                        this.p[i2].h();
                    }
                } else {
                    layoutParams.f.h();
                }
                b(h, aaVar);
            } else {
                return;
            }
        }
    }

    private void a(aa aaVar, ag agVar, boolean z) {
        int d = this.g.d() - p(this.g.d());
        if (d > 0) {
            d -= -c(-d, aaVar, agVar);
            if (z && d > 0) {
                this.g.a(d);
            }
        }
    }

    private void a(aa aaVar, C0275u c0275u, as asVar, int i) {
        if (c0275u.k == -1) {
            b(aaVar, Math.max(i, n(asVar.b())) + (this.g.e() - this.g.c()));
        } else {
            a(aaVar, Math.min(i, q(asVar.d())) - (this.g.e() - this.g.c()));
        }
    }

    private void a(ap apVar) {
        if (this.B.c > 0) {
            if (this.B.c == this.o) {
                for (int i = d; i < this.o; i += e) {
                    this.p[i].e();
                    int i2 = this.B.d[i];
                    if (i2 != n) {
                        i2 = this.B.i ? i2 + this.g.d() : i2 + this.g.c();
                    }
                    this.p[i].c(i2);
                }
            } else {
                this.B.a();
                this.B.a = this.B.b;
            }
        }
        this.A = this.B.j;
        a(this.B.h);
        q();
        if (this.B.a != -1) {
            this.j = this.B.a;
            apVar.c = this.B.i;
        } else {
            apVar.c = this.i;
        }
        if (this.B.e > e) {
            this.l.a = this.B.f;
            this.l.b = this.B.g;
        }
    }

    private void a(as asVar, int i, int i2) {
        int i3 = asVar.i();
        if (i == -1) {
            if (i3 + asVar.b() < i2) {
                this.x.set(asVar.e, m);
            }
        } else if (asVar.d() - i3 > i2) {
            this.x.set(asVar.e, m);
        }
    }

    private void a(View view, LayoutParams layoutParams) {
        if (!layoutParams.g) {
            c(view, this.D, this.E);
        } else if (this.q == e) {
            c(view, this.C, this.E);
        } else {
            c(view, this.D, this.C);
        }
    }

    private void a(View view, LayoutParams layoutParams, C0275u c0275u) {
        if (c0275u.k == e) {
            if (layoutParams.g) {
                v(view);
            } else {
                layoutParams.f.b(view);
            }
        } else if (layoutParams.g) {
            w(view);
        } else {
            layoutParams.f.a(view);
        }
    }

    private boolean a(as asVar) {
        if (this.i) {
            if (asVar.d() < this.g.d()) {
                return true;
            }
        } else if (asVar.b() > this.g.c()) {
            return true;
        }
        return m;
    }

    private void b(int i, int i2, int i3) {
        int r = this.i ? r() : s();
        this.l.b(i);
        switch (i3) {
            case d /*0*/:
                this.l.b(i, i2);
                break;
            case e /*1*/:
                this.l.a(i, i2);
                break;
            case a.l /*3*/:
                this.l.a(i, (int) e);
                this.l.b(i2, e);
                break;
        }
        if (i + i2 > r) {
            if (i <= (this.i ? s() : r())) {
                t();
            }
        }
    }

    private void b(int i, ag agVar) {
        int i2 = e;
        this.s.h = d;
        this.s.i = i;
        if (v()) {
            if (this.i == (agVar.e() > i ? e : d)) {
                this.s.l = d;
            } else {
                this.s.l = this.g.f();
            }
        } else {
            this.s.l = d;
        }
        this.s.k = e;
        C0275u c0275u = this.s;
        if (this.i) {
            i2 = -1;
        }
        c0275u.j = i2;
    }

    private void b(aa aaVar, int i) {
        int y = y() - 1;
        while (y >= 0) {
            View h = h(y);
            if (this.g.a(h) > i) {
                LayoutParams layoutParams = (LayoutParams) h.getLayoutParams();
                if (layoutParams.g) {
                    for (int i2 = d; i2 < this.o; i2 += e) {
                        this.p[i2].g();
                    }
                } else {
                    layoutParams.f.g();
                }
                b(h, aaVar);
                y--;
            } else {
                return;
            }
        }
    }

    private void b(aa aaVar, ag agVar, boolean z) {
        int o = o(this.g.c()) - this.g.c();
        if (o > 0) {
            o -= c(o, aaVar, agVar);
            if (z && o > 0) {
                this.g.a(-o);
            }
        }
    }

    private void b(View view, int i, int i2, int i3, int i4) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        a(view, i + layoutParams.leftMargin, i2 + layoutParams.topMargin, i3 - layoutParams.rightMargin, i4 - layoutParams.bottomMargin);
    }

    private void c(View view, int i, int i2) {
        Rect g = this.u.g(view);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        view.measure(a(i, layoutParams.leftMargin + g.left, layoutParams.rightMargin + g.right), a(i2, layoutParams.topMargin + g.top, layoutParams.bottomMargin + g.bottom));
    }

    private boolean c(ag agVar, ap apVar) {
        apVar.a = this.z ? u(agVar.h()) : t(agVar.h());
        apVar.b = n;
        return true;
    }

    private void d(int i, int i2) {
        for (int i3 = d; i3 < this.o; i3 += e) {
            if (!this.p[i3].g.isEmpty()) {
                a(this.p[i3], i, i2);
            }
        }
    }

    private int h(ag agVar) {
        boolean z = true;
        if (y() == 0) {
            return d;
        }
        p();
        D d = this.g;
        View b = b(!this.H ? true : m);
        if (this.H) {
            z = m;
        }
        return am.a(agVar, d, b, c(z), this, this.H);
    }

    private int i(ag agVar) {
        boolean z = true;
        if (y() == 0) {
            return d;
        }
        p();
        D d = this.g;
        View b = b(!this.H ? true : m);
        if (this.H) {
            z = m;
        }
        return am.b(agVar, d, b, c(z), this, this.H);
    }

    private FullSpanItem l(int i) {
        FullSpanItem fullSpanItem = new FullSpanItem();
        fullSpanItem.c = new int[this.o];
        for (int i2 = d; i2 < this.o; i2 += e) {
            fullSpanItem.c[i2] = i - this.p[i2].b(i);
        }
        return fullSpanItem;
    }

    private FullSpanItem m(int i) {
        FullSpanItem fullSpanItem = new FullSpanItem();
        fullSpanItem.c = new int[this.o];
        for (int i2 = d; i2 < this.o; i2 += e) {
            fullSpanItem.c[i2] = this.p[i2].a(i) - i;
        }
        return fullSpanItem;
    }

    private int n(int i) {
        int a = this.p[d].a(i);
        for (int i2 = e; i2 < this.o; i2 += e) {
            int a2 = this.p[i2].a(i);
            if (a2 > a) {
                a = a2;
            }
        }
        return a;
    }

    private int o(int i) {
        int a = this.p[d].a(i);
        for (int i2 = e; i2 < this.o; i2 += e) {
            int a2 = this.p[i2].a(i);
            if (a2 < a) {
                a = a2;
            }
        }
        return a;
    }

    private void o() {
        if (y() != 0 && this.y != 0) {
            int r;
            int s;
            if (this.i) {
                r = r();
                s = s();
            } else {
                r = s();
                s = r();
            }
            if (r == 0 && b() != null) {
                this.l.a();
                O();
                t();
            } else if (this.G) {
                int i = this.i ? -1 : e;
                FullSpanItem a = this.l.a(r, s + e, i);
                if (a == null) {
                    this.G = m;
                    this.l.a(s + e);
                    return;
                }
                FullSpanItem a2 = this.l.a(r, a.a, i * -1);
                if (a2 == null) {
                    this.l.a(a.a);
                } else {
                    this.l.a(a2.a + e);
                }
                O();
                t();
            }
        }
    }

    private int p(int i) {
        int b = this.p[d].b(i);
        for (int i2 = e; i2 < this.o; i2 += e) {
            int b2 = this.p[i2].b(i);
            if (b2 > b) {
                b = b2;
            }
        }
        return b;
    }

    private void p() {
        if (this.g == null) {
            this.g = D.a((W) this, this.q);
            this.h = D.a((W) this, 1 - this.q);
            this.s = new C0275u();
        }
    }

    private int q(int i) {
        int b = this.p[d].b(i);
        for (int i2 = e; i2 < this.o; i2 += e) {
            int b2 = this.p[i2].b(i);
            if (b2 < b) {
                b = b2;
            }
        }
        return b;
    }

    private void q() {
        boolean z = true;
        if (this.q == e || !j()) {
            this.i = this.w;
            return;
        }
        if (this.w) {
            z = m;
        }
        this.i = z;
    }

    private int r() {
        int y = y();
        return y == 0 ? d : e(h(y - 1));
    }

    private boolean r(int i) {
        if (this.q == 0) {
            return (i == -1 ? true : d) != this.i ? true : m;
        } else {
            return ((i == -1 ? true : d) == this.i ? true : d) != j() ? m : true;
        }
    }

    private int s() {
        return y() == 0 ? d : e(h((int) d));
    }

    private int s(int i) {
        int i2 = -1;
        if (y() == 0) {
            return this.i ? e : -1;
        } else {
            if ((i < s() ? e : m) == this.i) {
                i2 = e;
            }
            return i2;
        }
    }

    private int t(int i) {
        int y = y();
        for (int i2 = d; i2 < y; i2 += e) {
            int e = e(h(i2));
            if (e >= 0 && e < i) {
                return e;
            }
        }
        return d;
    }

    private int u(int i) {
        for (int y = y() - 1; y >= 0; y--) {
            int e = e(h(y));
            if (e >= 0 && e < i) {
                return e;
            }
        }
        return d;
    }

    private void v(View view) {
        for (int i = this.o - 1; i >= 0; i--) {
            this.p[i].b(view);
        }
    }

    private void w(View view) {
        for (int i = this.o - 1; i >= 0; i--) {
            this.p[i].a(view);
        }
    }

    public int a(int i, aa aaVar, ag agVar) {
        return c(i, aaVar, agVar);
    }

    public int a(aa aaVar, ag agVar) {
        return this.q == 0 ? this.o : super.a(aaVar, agVar);
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
        a(null);
        if (i != this.o) {
            i();
            this.o = i;
            this.x = new BitSet(this.o);
            this.p = new as[this.o];
            for (int i2 = d; i2 < this.o; i2 += e) {
                this.p[i2] = new as(this, i2);
            }
            t();
        }
    }

    public void a(int i, int i2) {
        if (this.B != null) {
            this.B.b();
        }
        this.j = i;
        this.k = i2;
        t();
    }

    public void a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.B = (SavedState) parcelable;
            t();
        }
    }

    public void a(RecyclerView recyclerView) {
        this.l.a();
        t();
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        b(i, i2, (int) d);
    }

    public void a(RecyclerView recyclerView, int i, int i2, int i3) {
        b(i, i2, 3);
    }

    public void a(RecyclerView recyclerView, aa aaVar) {
        for (int i = d; i < this.o; i += e) {
            this.p[i].e();
        }
    }

    public void a(RecyclerView recyclerView, ag agVar, int i) {
        ae aoVar = new ao(this, recyclerView.getContext());
        aoVar.d(i);
        a(aoVar);
    }

    public void a(aa aaVar, ag agVar, View view, C0113o c0113o) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (this.q == 0) {
                c0113o.c(C0124z.a(layoutParams2.b(), layoutParams2.g ? this.o : e, -1, -1, layoutParams2.g, m));
                return;
            } else {
                c0113o.c(C0124z.a(-1, -1, layoutParams2.b(), layoutParams2.g ? this.o : e, layoutParams2.g, m));
                return;
            }
        }
        super.a(view, c0113o);
    }

    void a(ag agVar, ap apVar) {
        if (!b(agVar, apVar) && !c(agVar, apVar)) {
            apVar.b();
            apVar.a = d;
        }
    }

    public void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (y() > 0) {
            Y b = C0099a.b(accessibilityEvent);
            View b2 = b((boolean) m);
            View c = c((boolean) m);
            if (b2 != null && c != null) {
                int e = e(b2);
                int e2 = e(c);
                if (e < e2) {
                    b.c(e);
                    b.d(e2);
                    return;
                }
                b.c(e2);
                b.d(e);
            }
        }
    }

    public void a(String str) {
        if (this.B == null) {
            super.a(str);
        }
    }

    public void a(boolean z) {
        a(null);
        if (!(this.B == null || this.B.h == z)) {
            this.B.h = z;
        }
        this.w = z;
        t();
    }

    public boolean a(android.support.v7.widget.RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public int[] a(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.o];
        } else if (iArr.length < this.o) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.o + ", array size:" + iArr.length);
        }
        for (int i = d; i < this.o; i += e) {
            iArr[i] = this.p[i].j();
        }
        return iArr;
    }

    public int b(int i, aa aaVar, ag agVar) {
        return c(i, aaVar, agVar);
    }

    public int b(aa aaVar, ag agVar) {
        return this.q == e ? this.o : super.b(aaVar, agVar);
    }

    public int b(ag agVar) {
        return a(agVar);
    }

    View b() {
        int i;
        int y = y() - 1;
        BitSet bitSet = new BitSet(this.o);
        bitSet.set(d, this.o, true);
        boolean z = (this.q == e && j()) ? true : true;
        if (this.i) {
            y--;
            i = -1;
        } else {
            i = y;
            y = d;
        }
        int i2 = y < i ? e : -1;
        int i3 = y;
        while (i3 != i) {
            View h = h(i3);
            LayoutParams layoutParams = (LayoutParams) h.getLayoutParams();
            if (bitSet.get(layoutParams.f.e)) {
                if (a(layoutParams.f)) {
                    return h;
                }
                bitSet.clear(layoutParams.f.e);
            }
            if (!(layoutParams.g || i3 + i2 == i)) {
                boolean z2;
                View h2 = h(i3 + i2);
                int b;
                if (this.i) {
                    y = this.g.b(h);
                    b = this.g.b(h2);
                    if (y < b) {
                        return h;
                    }
                    if (y == b) {
                        z2 = true;
                    }
                    z2 = d;
                } else {
                    y = this.g.a(h);
                    b = this.g.a(h2);
                    if (y > b) {
                        return h;
                    }
                    if (y == b) {
                        z2 = true;
                    }
                    z2 = d;
                }
                if (z2) {
                    if ((layoutParams.f.e - ((LayoutParams) h2.getLayoutParams()).f.e < 0 ? true : d) != (z >= false ? true : d)) {
                        return h;
                    }
                } else {
                    continue;
                }
            }
            i3 += i2;
        }
        return null;
    }

    View b(boolean z) {
        p();
        int c = this.g.c();
        int d = this.g.d();
        int y = y();
        for (int i = d; i < y; i += e) {
            View h = h(i);
            if ((!z || this.g.a(h) >= c) && this.g.b(h) <= d) {
                return h;
            }
        }
        return null;
    }

    public void b(int i) {
        if (i == 0 || i == e) {
            a(null);
            if (i != this.q) {
                this.q = i;
                if (!(this.g == null || this.h == null)) {
                    D d = this.g;
                    this.g = this.h;
                    this.h = d;
                }
                t();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public void b(RecyclerView recyclerView, int i, int i2) {
        b(i, i2, (int) e);
    }

    boolean b(ag agVar, ap apVar) {
        boolean z = m;
        if (agVar.b() || this.j == -1) {
            return m;
        }
        if (this.j < 0 || this.j >= agVar.h()) {
            this.j = -1;
            this.k = n;
            return m;
        } else if (this.B == null || this.B.a == -1 || this.B.c < e) {
            View c = c(this.j);
            if (c != null) {
                apVar.a = this.i ? r() : s();
                if (this.k != n) {
                    if (apVar.c) {
                        apVar.b = (this.g.d() - this.k) - this.g.b(c);
                        return true;
                    }
                    apVar.b = (this.g.c() + this.k) - this.g.a(c);
                    return true;
                } else if (this.g.c(c) > this.g.f()) {
                    apVar.b = apVar.c ? this.g.d() : this.g.c();
                    return true;
                } else {
                    int a = this.g.a(c) - this.g.c();
                    if (a < 0) {
                        apVar.b = -a;
                        return true;
                    }
                    a = this.g.d() - this.g.b(c);
                    if (a < 0) {
                        apVar.b = a;
                        return true;
                    }
                    apVar.b = n;
                    return true;
                }
            }
            apVar.a = this.j;
            if (this.k == n) {
                if (s(apVar.a) == e) {
                    z = true;
                }
                apVar.c = z;
                apVar.b();
            } else {
                apVar.a(this.k);
            }
            apVar.d = true;
            return true;
        } else {
            apVar.b = n;
            apVar.a = this.j;
            return true;
        }
    }

    public int[] b(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.o];
        } else if (iArr.length < this.o) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.o + ", array size:" + iArr.length);
        }
        for (int i = d; i < this.o; i += e) {
            iArr[i] = this.p[i].k();
        }
        return iArr;
    }

    public int c() {
        return this.y;
    }

    int c(int i, aa aaVar, ag agVar) {
        int i2 = e;
        int i3 = -1;
        p();
        C0275u c0275u;
        if (i > 0) {
            this.s.k = e;
            c0275u = this.s;
            if (!this.i) {
                i3 = e;
            }
            c0275u.j = i3;
            i3 = r();
        } else {
            this.s.k = -1;
            c0275u = this.s;
            if (!this.i) {
                i2 = -1;
            }
            c0275u.j = i2;
            i3 = s();
        }
        this.s.i = i3 + this.s.j;
        i2 = Math.abs(i);
        this.s.h = i2;
        this.s.l = v() ? this.g.f() : d;
        i3 = a(aaVar, this.s, agVar);
        if (i2 >= i3) {
            i = i < 0 ? -i3 : i3;
        }
        this.g.a(-i);
        this.z = this.i;
        return i;
    }

    public int c(ag agVar) {
        return a(agVar);
    }

    View c(boolean z) {
        p();
        int c = this.g.c();
        int d = this.g.d();
        for (int y = y() - 1; y >= 0; y--) {
            View h = h(y);
            if (this.g.a(h) >= c && (!z || this.g.b(h) <= d)) {
                return h;
            }
        }
        return null;
    }

    public void c(RecyclerView recyclerView, int i, int i2) {
        b(i, i2, (int) f);
    }

    public void c(aa aaVar, ag agVar) {
        p();
        ap apVar = this.F;
        apVar.a();
        if (this.B != null) {
            a(apVar);
        } else {
            q();
            apVar.c = this.i;
        }
        a(agVar, apVar);
        if (this.B == null && !(apVar.c == this.z && j() == this.A)) {
            this.l.a();
            apVar.d = true;
        }
        if (y() > 0 && (this.B == null || this.B.c < e)) {
            int i;
            if (apVar.d) {
                for (i = d; i < this.o; i += e) {
                    this.p[i].e();
                    if (apVar.b != n) {
                        this.p[i].c(apVar.b);
                    }
                }
            } else {
                for (i = d; i < this.o; i += e) {
                    this.p[i].a(this.i, apVar.b);
                }
            }
        }
        a(aaVar);
        this.G = m;
        l();
        C0275u c0275u;
        if (apVar.c) {
            a(apVar.a, agVar);
            a(aaVar, this.s, agVar);
            b(apVar.a, agVar);
            c0275u = this.s;
            c0275u.i += this.s.j;
            a(aaVar, this.s, agVar);
        } else {
            b(apVar.a, agVar);
            a(aaVar, this.s, agVar);
            a(apVar.a, agVar);
            c0275u = this.s;
            c0275u.i += this.s.j;
            a(aaVar, this.s, agVar);
        }
        if (y() > 0) {
            if (this.i) {
                a(aaVar, agVar, true);
                b(aaVar, agVar, (boolean) m);
            } else {
                b(aaVar, agVar, true);
                a(aaVar, agVar, (boolean) m);
            }
        }
        if (!agVar.b()) {
            if (y() > 0 && this.j != -1 && this.G) {
                C0151az.a(h((int) d), this.I);
            }
            this.j = -1;
            this.k = n;
        }
        this.z = apVar.c;
        this.A = j();
        this.B = null;
    }

    public int[] c(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.o];
        } else if (iArr.length < this.o) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.o + ", array size:" + iArr.length);
        }
        for (int i = d; i < this.o; i += e) {
            iArr[i] = this.p[i].l();
        }
        return iArr;
    }

    public int d(ag agVar) {
        return h(agVar);
    }

    public void d(int i) {
        a(null);
        if (i != this.y) {
            if (i == 0 || i == f) {
                this.y = i;
                t();
                return;
            }
            throw new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
        }
    }

    public boolean d() {
        return this.B == null ? true : m;
    }

    public int[] d(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.o];
        } else if (iArr.length < this.o) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.o + ", array size:" + iArr.length);
        }
        for (int i = d; i < this.o; i += e) {
            iArr[i] = this.p[i].m();
        }
        return iArr;
    }

    public int e() {
        return this.o;
    }

    public int e(ag agVar) {
        return h(agVar);
    }

    public void e(int i) {
        if (!(this.B == null || this.B.a == i)) {
            this.B.b();
        }
        this.j = i;
        this.k = n;
        t();
    }

    public int f(ag agVar) {
        return i(agVar);
    }

    public Parcelable f() {
        if (this.B != null) {
            return new SavedState(this.B);
        }
        SavedState savedState = new SavedState();
        savedState.h = this.w;
        savedState.i = this.z;
        savedState.j = this.A;
        if (this.l == null || this.l.a == null) {
            savedState.e = d;
        } else {
            savedState.f = this.l.a;
            savedState.e = savedState.f.length;
            savedState.g = this.l.b;
        }
        if (y() > 0) {
            p();
            savedState.a = this.z ? r() : s();
            savedState.b = m();
            savedState.c = this.o;
            savedState.d = new int[this.o];
            for (int i = d; i < this.o; i += e) {
                int b;
                if (this.z) {
                    b = this.p[i].b((int) n);
                    if (b != n) {
                        b -= this.g.d();
                    }
                } else {
                    b = this.p[i].a((int) n);
                    if (b != n) {
                        b -= this.g.c();
                    }
                }
                savedState.d[i] = b;
            }
        } else {
            savedState.a = -1;
            savedState.b = -1;
            savedState.c = d;
        }
        return savedState;
    }

    public int g(ag agVar) {
        return i(agVar);
    }

    public boolean g() {
        return this.q == 0 ? true : m;
    }

    public boolean h() {
        return this.q == e ? true : m;
    }

    public void i() {
        this.l.a();
        t();
    }

    public void i(int i) {
        super.i(i);
        for (int i2 = d; i2 < this.o; i2 += e) {
            this.p[i2].d(i);
        }
    }

    public void j(int i) {
        super.j(i);
        for (int i2 = d; i2 < this.o; i2 += e) {
            this.p[i2].d(i);
        }
    }

    boolean j() {
        return w() == e ? true : m;
    }

    public void k(int i) {
        if (i == 0) {
            o();
        }
    }

    public boolean k() {
        return this.w;
    }

    void l() {
        this.r = this.h.f() / this.o;
        this.C = MeasureSpec.makeMeasureSpec(this.h.f(), 1073741824);
        if (this.q == e) {
            this.D = MeasureSpec.makeMeasureSpec(this.r, 1073741824);
            this.E = MeasureSpec.makeMeasureSpec(d, d);
            return;
        }
        this.E = MeasureSpec.makeMeasureSpec(this.r, 1073741824);
        this.D = MeasureSpec.makeMeasureSpec(d, d);
    }

    int m() {
        View c = this.i ? c(true) : b(true);
        return c == null ? -1 : e(c);
    }

    public int n() {
        return this.q;
    }
}
