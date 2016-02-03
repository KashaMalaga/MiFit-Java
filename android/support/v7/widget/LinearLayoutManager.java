package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.media.h;
import android.support.v4.view.a.C0099a;
import android.support.v4.view.a.Y;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.xiaomi.channel.relationservice.data.b;
import java.util.List;
import kankan.wheel.widget.a;

public class LinearLayoutManager extends W {
    private static final String a = "LinearLayoutManager";
    private static final boolean b = false;
    private static final float c = 0.33f;
    public static final int j = 0;
    public static final int k = 1;
    public static final int l = Integer.MIN_VALUE;
    private C0279y d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    int m;
    D n;
    boolean o;
    int p;
    int q;
    SavedState r;
    final C0277w s;

    class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new C0280z();
        int a;
        int b;
        boolean c;

        SavedState(Parcel parcel) {
            boolean z = true;
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            if (parcel.readInt() != LinearLayoutManager.k) {
                z = LinearLayoutManager.b;
            }
            this.c = z;
        }

        public SavedState(SavedState savedState) {
            this.a = savedState.a;
            this.b = savedState.b;
            this.c = savedState.c;
        }

        boolean a() {
            return this.a >= 0 ? true : LinearLayoutManager.b;
        }

        void b() {
            this.a = -1;
        }

        public int describeContents() {
            return LinearLayoutManager.j;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c ? LinearLayoutManager.k : LinearLayoutManager.j);
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, k, b);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.f = b;
        this.o = b;
        this.g = b;
        this.h = true;
        this.p = -1;
        this.q = l;
        this.r = null;
        this.s = new C0277w(this);
        b(i);
        c(z);
    }

    private View P() {
        return h(this.o ? j : y() - 1);
    }

    private void Q() {
        Log.d(a, "internal representation of views on the screen");
        for (int i = j; i < y(); i += k) {
            View h = h(i);
            Log.d(a, "item " + e(h) + ", coord:" + this.n.a(h));
        }
        Log.d(a, "==============");
    }

    private int a(int i) {
        int i2 = k;
        int i3 = l;
        switch (i) {
            case k /*1*/:
                return -1;
            case a.k /*2*/:
                return k;
            case a.bu /*17*/:
                return this.m != 0 ? l : -1;
            case b.H /*33*/:
                return this.m != k ? l : -1;
            case 66:
                if (this.m != 0) {
                    i2 = l;
                }
                return i2;
            case h.k /*130*/:
                if (this.m == k) {
                    i3 = k;
                }
                return i3;
            default:
                return l;
        }
    }

    private int a(int i, aa aaVar, ag agVar, boolean z) {
        int d = this.n.d() - i;
        if (d <= 0) {
            return j;
        }
        d = -c(-d, aaVar, agVar);
        int i2 = i + d;
        if (!z) {
            return d;
        }
        i2 = this.n.d() - i2;
        if (i2 <= 0) {
            return d;
        }
        this.n.a(i2);
        return d + i2;
    }

    private View a(int i, int i2, int i3) {
        View view = null;
        m();
        int c = this.n.c();
        int d = this.n.d();
        int i4 = i2 > i ? k : -1;
        View view2 = null;
        while (i != i2) {
            View view3;
            View h = h(i);
            int e = e(h);
            if (e >= 0 && e < i3) {
                if (((LayoutParams) h.getLayoutParams()).e()) {
                    if (view2 == null) {
                        view3 = view;
                        i += i4;
                        view = view3;
                        view2 = h;
                    }
                } else if (this.n.a(h) < d && this.n.b(h) >= c) {
                    return h;
                } else {
                    if (view == null) {
                        view3 = h;
                        h = view2;
                        i += i4;
                        view = view3;
                        view2 = h;
                    }
                }
            }
            view3 = view;
            h = view2;
            i += i4;
            view = view3;
            view2 = h;
        }
        if (view == null) {
            view = view2;
        }
        return view;
    }

    private void a(int i, int i2, boolean z, ag agVar) {
        int i3 = -1;
        int i4 = k;
        this.d.o = a(agVar);
        this.d.m = i;
        View P;
        C0279y c0279y;
        if (i == k) {
            C0279y c0279y2 = this.d;
            c0279y2.o += this.n.g();
            P = P();
            c0279y = this.d;
            if (!this.o) {
                i3 = k;
            }
            c0279y.l = i3;
            this.d.k = e(P) + this.d.l;
            this.d.i = this.n.b(P);
            i3 = this.n.b(P) - this.n.d();
        } else {
            P = c();
            c0279y = this.d;
            c0279y.o += this.n.c();
            c0279y = this.d;
            if (!this.o) {
                i4 = -1;
            }
            c0279y.l = i4;
            this.d.k = e(P) + this.d.l;
            this.d.i = this.n.a(P);
            i3 = (-this.n.a(P)) + this.n.c();
        }
        this.d.j = i2;
        if (z) {
            C0279y c0279y3 = this.d;
            c0279y3.j -= i3;
        }
        this.d.n = i3;
    }

    private void a(aa aaVar, int i) {
        if (i >= 0) {
            int y = y();
            int i2;
            if (this.o) {
                for (i2 = y - 1; i2 >= 0; i2--) {
                    if (this.n.b(h(i2)) > i) {
                        a(aaVar, y - 1, i2);
                        return;
                    }
                }
                return;
            }
            for (i2 = j; i2 < y; i2 += k) {
                if (this.n.b(h(i2)) > i) {
                    a(aaVar, (int) j, i2);
                    return;
                }
            }
        }
    }

    private void a(aa aaVar, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    b(i3, aaVar);
                }
                return;
            }
            while (i > i2) {
                b(i, aaVar);
                i--;
            }
        }
    }

    private void a(aa aaVar, C0279y c0279y) {
        if (!c0279y.h) {
            return;
        }
        if (c0279y.m == -1) {
            b(aaVar, c0279y.n);
        } else {
            a(aaVar, c0279y.n);
        }
    }

    private void a(C0277w c0277w) {
        d(c0277w.a, c0277w.b);
    }

    private int b(int i, aa aaVar, ag agVar, boolean z) {
        int c = i - this.n.c();
        if (c <= 0) {
            return j;
        }
        c = -c(c, aaVar, agVar);
        int i2 = i + c;
        if (!z) {
            return c;
        }
        i2 -= this.n.c();
        if (i2 <= 0) {
            return c;
        }
        this.n.a(-i2);
        return c - i2;
    }

    private void b() {
        boolean z = true;
        if (this.m == k || !l()) {
            this.o = this.f;
            return;
        }
        if (this.f) {
            z = b;
        }
        this.o = z;
    }

    private void b(aa aaVar, int i) {
        int y = y();
        if (i >= 0) {
            int e = this.n.e() - i;
            int i2;
            if (this.o) {
                for (i2 = j; i2 < y; i2 += k) {
                    if (this.n.a(h(i2)) < e) {
                        a(aaVar, (int) j, i2);
                        return;
                    }
                }
                return;
            }
            for (i2 = y - 1; i2 >= 0; i2--) {
                if (this.n.a(h(i2)) < e) {
                    a(aaVar, y - 1, i2);
                    return;
                }
            }
        }
    }

    private void b(aa aaVar, ag agVar, int i, int i2) {
        if (agVar.c() && y() != 0 && !agVar.b() && d()) {
            C0279y c0279y;
            int i3 = j;
            int i4 = j;
            List b = aaVar.b();
            int size = b.size();
            int e = e(h((int) j));
            int i5 = j;
            while (i5 < size) {
                int c;
                int i6;
                aj ajVar = (aj) b.get(i5);
                if (((ajVar.d() < e ? true : b) != this.o ? -1 : k) == -1) {
                    c = this.n.c(ajVar.a) + i3;
                    i6 = i4;
                } else {
                    i6 = this.n.c(ajVar.a) + i4;
                    c = i3;
                }
                i5 += k;
                i3 = c;
                i4 = i6;
            }
            this.d.q = b;
            if (i3 > 0) {
                e(e(c()), i);
                this.d.o = i3;
                this.d.j = j;
                c0279y = this.d;
                c0279y.k = (this.o ? k : -1) + c0279y.k;
                a(aaVar, this.d, agVar, (boolean) b);
            }
            if (i4 > 0) {
                d(e(P()), i2);
                this.d.o = i4;
                this.d.j = j;
                c0279y = this.d;
                c0279y.k = (this.o ? -1 : k) + c0279y.k;
                a(aaVar, this.d, agVar, (boolean) b);
            }
            this.d.q = null;
        }
    }

    private void b(ag agVar, C0277w c0277w) {
        if (!d(agVar, c0277w) && !c(agVar, c0277w)) {
            c0277w.b();
            c0277w.a = this.g ? agVar.h() - 1 : j;
        }
    }

    private void b(C0277w c0277w) {
        e(c0277w.a, c0277w.b);
    }

    private View c() {
        return h(this.o ? y() - 1 : j);
    }

    private boolean c(ag agVar, C0277w c0277w) {
        boolean z = b;
        if (y() == 0) {
            return b;
        }
        View J = J();
        if (J != null && c0277w.a(J, agVar)) {
            return true;
        }
        if (this.e != this.g) {
            return b;
        }
        J = c0277w.c ? k(agVar) : l(agVar);
        if (J == null) {
            return b;
        }
        c0277w.a(J);
        if (!agVar.b() && d()) {
            if (this.n.a(J) >= this.n.d() || this.n.b(J) < this.n.c()) {
                z = true;
            }
            if (z) {
                c0277w.b = c0277w.c ? this.n.d() : this.n.c();
            }
        }
        return true;
    }

    private void d(int i, int i2) {
        this.d.j = this.n.d() - i2;
        this.d.l = this.o ? -1 : k;
        this.d.k = i;
        this.d.m = k;
        this.d.i = i2;
        this.d.n = l;
    }

    private boolean d(ag agVar, C0277w c0277w) {
        boolean z = b;
        if (agVar.b() || this.p == -1) {
            return b;
        }
        if (this.p < 0 || this.p >= agVar.h()) {
            this.p = -1;
            this.q = l;
            return b;
        }
        c0277w.a = this.p;
        if (this.r != null && this.r.a()) {
            c0277w.c = this.r.c;
            if (c0277w.c) {
                c0277w.b = this.n.d() - this.r.b;
                return true;
            }
            c0277w.b = this.n.c() + this.r.b;
            return true;
        } else if (this.q == l) {
            View c = c(this.p);
            if (c == null) {
                if (y() > 0) {
                    if ((this.p < e(h((int) j)) ? true : b) == this.o) {
                        z = true;
                    }
                    c0277w.c = z;
                }
                c0277w.b();
                return true;
            } else if (this.n.c(c) > this.n.f()) {
                c0277w.b();
                return true;
            } else if (this.n.a(c) - this.n.c() < 0) {
                c0277w.b = this.n.c();
                c0277w.c = b;
                return true;
            } else if (this.n.d() - this.n.b(c) < 0) {
                c0277w.b = this.n.d();
                c0277w.c = true;
                return true;
            } else {
                c0277w.b = c0277w.c ? this.n.b(c) + this.n.b() : this.n.a(c);
                return true;
            }
        } else {
            c0277w.c = this.o;
            if (this.o) {
                c0277w.b = this.n.d() - this.q;
                return true;
            }
            c0277w.b = this.n.c() + this.q;
            return true;
        }
    }

    private void e(int i, int i2) {
        this.d.j = i2 - this.n.c();
        this.d.k = i;
        this.d.l = this.o ? k : -1;
        this.d.m = -1;
        this.d.i = i2;
        this.d.n = l;
    }

    private int h(ag agVar) {
        if (y() == 0) {
            return j;
        }
        m();
        return am.a(agVar, this.n, c(), P(), this, this.h, this.o);
    }

    private int i(ag agVar) {
        if (y() == 0) {
            return j;
        }
        m();
        return am.a(agVar, this.n, c(), P(), this, this.h);
    }

    private int j(ag agVar) {
        if (y() == 0) {
            return j;
        }
        m();
        return am.b(agVar, this.n, c(), P(), this, this.h);
    }

    private View k(ag agVar) {
        return this.o ? l(agVar.h()) : m(agVar.h());
    }

    private View l(int i) {
        return a((int) j, y(), i);
    }

    private View l(ag agVar) {
        return this.o ? m(agVar.h()) : l(agVar.h());
    }

    private View m(int i) {
        return a(y() - 1, -1, i);
    }

    public int a(int i, aa aaVar, ag agVar) {
        return this.m == k ? j : c(i, aaVar, agVar);
    }

    int a(aa aaVar, C0279y c0279y, ag agVar, boolean z) {
        int i = c0279y.j;
        if (c0279y.n != l) {
            if (c0279y.j < 0) {
                c0279y.n += c0279y.j;
            }
            a(aaVar, c0279y);
        }
        int i2 = c0279y.j + c0279y.o;
        C0278x c0278x = new C0278x();
        while (i2 > 0 && c0279y.a(agVar)) {
            c0278x.a();
            a(aaVar, agVar, c0279y, c0278x);
            if (!c0278x.b) {
                c0279y.i += c0278x.a * c0279y.m;
                if (!(c0278x.c && this.d.q == null && agVar.b())) {
                    c0279y.j -= c0278x.a;
                    i2 -= c0278x.a;
                }
                if (c0279y.n != l) {
                    c0279y.n += c0278x.a;
                    if (c0279y.j < 0) {
                        c0279y.n += c0279y.j;
                    }
                    a(aaVar, c0279y);
                }
                if (z && c0278x.d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - c0279y.j;
    }

    protected int a(ag agVar) {
        return agVar.f() ? this.n.f() : j;
    }

    public LayoutParams a() {
        return new LayoutParams(-2, -2);
    }

    View a(int i, int i2, boolean z) {
        m();
        int c = this.n.c();
        int d = this.n.d();
        int i3 = i2 > i ? k : -1;
        while (i != i2) {
            View h = h(i);
            int a = this.n.a(h);
            int b = this.n.b(h);
            if (a < d && b > c) {
                if (!z) {
                    return h;
                }
                if (a >= c && b <= d) {
                    return h;
                }
            }
            i += i3;
        }
        return null;
    }

    public View a(View view, int i, aa aaVar, ag agVar) {
        b();
        if (y() == 0) {
            return null;
        }
        int a = a(i);
        if (a == l) {
            return null;
        }
        m();
        View l = a == -1 ? l(agVar) : k(agVar);
        if (l == null) {
            return null;
        }
        m();
        a(a, (int) (c * ((float) this.n.f())), (boolean) b, agVar);
        this.d.n = l;
        this.d.h = b;
        a(aaVar, this.d, agVar, true);
        View c = a == -1 ? c() : P();
        return (c == l || !c.isFocusable()) ? null : c;
    }

    public void a(int i, int i2) {
        this.p = i;
        this.q = i2;
        if (this.r != null) {
            this.r.b();
        }
        t();
    }

    public void a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.r = (SavedState) parcelable;
            t();
        }
    }

    public void a(RecyclerView recyclerView, aa aaVar) {
        super.a(recyclerView, aaVar);
        if (this.i) {
            c(aaVar);
            aaVar.a();
        }
    }

    public void a(RecyclerView recyclerView, ag agVar, int i) {
        ae c0276v = new C0276v(this, recyclerView.getContext());
        c0276v.d(i);
        a(c0276v);
    }

    void a(aa aaVar, ag agVar, C0279y c0279y, C0278x c0278x) {
        View a = c0279y.a(aaVar);
        if (a == null) {
            c0278x.b = true;
            return;
        }
        int z;
        int d;
        int i;
        int i2;
        LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
        if (c0279y.q == null) {
            if (this.o == (c0279y.m == -1 ? true : j)) {
                c(a);
            } else {
                b(a, (int) j);
            }
        } else {
            if (this.o == (c0279y.m == -1 ? true : j)) {
                b(a);
            } else {
                a(a, (int) j);
            }
        }
        b(a, (int) j, (int) j);
        c0278x.a = this.n.c(a);
        if (this.m == k) {
            if (l()) {
                z = z() - D();
                d = z - this.n.d(a);
            } else {
                d = B();
                z = this.n.d(a) + d;
            }
            if (c0279y.m == -1) {
                i = c0279y.i - c0278x.a;
                i2 = z;
                z = c0279y.i;
            } else {
                i = c0279y.i;
                i2 = z;
                z = c0279y.i + c0278x.a;
            }
        } else {
            i = C();
            z = this.n.d(a) + i;
            if (c0279y.m == -1) {
                d = c0279y.i - c0278x.a;
                i2 = c0279y.i;
            } else {
                d = c0279y.i;
                i2 = c0279y.i + c0278x.a;
            }
        }
        a(a, d + layoutParams.leftMargin, i + layoutParams.topMargin, i2 - layoutParams.rightMargin, z - layoutParams.bottomMargin);
        if (layoutParams.e() || layoutParams.f()) {
            c0278x.c = true;
        }
        c0278x.d = a.isFocusable();
    }

    void a(ag agVar, C0277w c0277w) {
    }

    public void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (y() > 0) {
            Y b = C0099a.b(accessibilityEvent);
            b.c(o());
            b.d(q());
        }
    }

    public void a(String str) {
        if (this.r == null) {
            super.a(str);
        }
    }

    public void a(boolean z) {
        a(null);
        if (this.g != z) {
            this.g = z;
            t();
        }
    }

    public int b(int i, aa aaVar, ag agVar) {
        return this.m == 0 ? j : c(i, aaVar, agVar);
    }

    public int b(ag agVar) {
        return h(agVar);
    }

    public void b(int i) {
        if (i == 0 || i == k) {
            a(null);
            if (i != this.m) {
                this.m = i;
                this.n = null;
                t();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i);
    }

    public void b(boolean z) {
        this.i = z;
    }

    int c(int i, aa aaVar, ag agVar) {
        if (y() == 0 || i == 0) {
            return j;
        }
        this.d.h = true;
        m();
        int i2 = i > 0 ? k : -1;
        int abs = Math.abs(i);
        a(i2, abs, true, agVar);
        int a = this.d.n + a(aaVar, this.d, agVar, (boolean) b);
        if (a < 0) {
            return j;
        }
        if (abs > a) {
            i = i2 * a;
        }
        this.n.a(-i);
        return i;
    }

    public int c(ag agVar) {
        return h(agVar);
    }

    public View c(int i) {
        int y = y();
        if (y == 0) {
            return null;
        }
        int e = i - e(h((int) j));
        return (e < 0 || e >= y) ? null : h(e);
    }

    public void c(aa aaVar, ag agVar) {
        int i;
        if (this.r != null && this.r.a()) {
            this.p = this.r.a;
        }
        m();
        this.d.h = b;
        b();
        this.s.a();
        this.s.c = this.o ^ this.g;
        b(agVar, this.s);
        int a = a(agVar);
        if ((agVar.e() < this.s.a ? true : b) == this.o) {
            i = a;
            a = j;
        } else {
            i = j;
        }
        a += this.n.c();
        i += this.n.g();
        if (!(!agVar.b() || this.p == -1 || this.q == l)) {
            View c = c(this.p);
            if (c != null) {
                int d = this.o ? (this.n.d() - this.n.b(c)) - this.q : this.q - (this.n.a(c) - this.n.c());
                if (d > 0) {
                    a += d;
                } else {
                    i -= d;
                }
            }
        }
        a(agVar, this.s);
        a(aaVar);
        this.d.p = agVar.b();
        if (this.s.c) {
            b(this.s);
            this.d.o = a;
            a(aaVar, this.d, agVar, (boolean) b);
            a = this.d.i;
            if (this.d.j > 0) {
                i += this.d.j;
            }
            a(this.s);
            this.d.o = i;
            C0279y c0279y = this.d;
            c0279y.k += this.d.l;
            a(aaVar, this.d, agVar, (boolean) b);
            i = this.d.i;
        } else {
            a(this.s);
            this.d.o = i;
            a(aaVar, this.d, agVar, (boolean) b);
            i = this.d.i;
            if (this.d.j > 0) {
                a += this.d.j;
            }
            b(this.s);
            this.d.o = a;
            C0279y c0279y2 = this.d;
            c0279y2.k += this.d.l;
            a(aaVar, this.d, agVar, (boolean) b);
            a = this.d.i;
        }
        if (y() > 0) {
            int a2;
            if ((this.o ^ this.g) != 0) {
                a2 = a(i, aaVar, agVar, true);
                a += a2;
                i += a2;
                a2 = b(a, aaVar, agVar, (boolean) b);
                a += a2;
                i += a2;
            } else {
                a2 = b(a, aaVar, agVar, true);
                a += a2;
                i += a2;
                a2 = a(i, aaVar, agVar, (boolean) b);
                a += a2;
                i += a2;
            }
        }
        b(aaVar, agVar, a, i);
        if (!agVar.b()) {
            this.p = -1;
            this.q = l;
            this.n.a();
        }
        this.e = this.g;
        this.r = null;
    }

    public void c(boolean z) {
        a(null);
        if (z != this.f) {
            this.f = z;
            t();
        }
    }

    public int d(ag agVar) {
        return i(agVar);
    }

    public PointF d(int i) {
        int i2 = k;
        boolean z = b;
        if (y() == 0) {
            return null;
        }
        if (i < e(h((int) j))) {
            z = k;
        }
        if (z != this.o) {
            i2 = -1;
        }
        return this.m == 0 ? new PointF((float) i2, 0.0f) : new PointF(0.0f, (float) i2);
    }

    public void d(boolean z) {
        this.h = z;
    }

    public boolean d() {
        return (this.r == null && this.e == this.g) ? true : b;
    }

    public int e(ag agVar) {
        return i(agVar);
    }

    public void e(int i) {
        this.p = i;
        this.q = l;
        if (this.r != null) {
            this.r.b();
        }
        t();
    }

    public boolean e() {
        return this.i;
    }

    public int f(ag agVar) {
        return j(agVar);
    }

    public Parcelable f() {
        if (this.r != null) {
            return new SavedState(this.r);
        }
        Parcelable savedState = new SavedState();
        if (y() > 0) {
            m();
            boolean z = this.e ^ this.o;
            savedState.c = z;
            View P;
            if (z) {
                P = P();
                savedState.b = this.n.d() - this.n.b(P);
                savedState.a = e(P);
                return savedState;
            }
            P = c();
            savedState.a = e(P);
            savedState.b = this.n.a(P) - this.n.c();
            return savedState;
        }
        savedState.b();
        return savedState;
    }

    public int g(ag agVar) {
        return j(agVar);
    }

    public boolean g() {
        return this.m == 0 ? true : b;
    }

    public boolean h() {
        return this.m == k ? true : b;
    }

    public boolean i() {
        return this.g;
    }

    public int j() {
        return this.m;
    }

    public boolean k() {
        return this.f;
    }

    protected boolean l() {
        return w() == k ? true : b;
    }

    void m() {
        if (this.d == null) {
            this.d = new C0279y();
        }
        if (this.n == null) {
            this.n = D.a((W) this, this.m);
        }
    }

    public boolean n() {
        return this.h;
    }

    public int o() {
        View a = a((int) j, y(), (boolean) b);
        return a == null ? -1 : e(a);
    }

    public int p() {
        View a = a((int) j, y(), true);
        return a == null ? -1 : e(a);
    }

    public int q() {
        View a = a(y() - 1, -1, (boolean) b);
        return a == null ? -1 : e(a);
    }

    public int r() {
        View a = a(y() - 1, -1, true);
        return a == null ? -1 : e(a);
    }

    void s() {
        boolean z = true;
        Log.d(a, "validating child count " + y());
        if (y() >= k) {
            int e = e(h((int) j));
            int a = this.n.a(h((int) j));
            int i;
            View h;
            int e2;
            int a2;
            StringBuilder append;
            if (this.o) {
                i = k;
                while (i < y()) {
                    h = h(i);
                    e2 = e(h);
                    a2 = this.n.a(h);
                    if (e2 < e) {
                        Q();
                        append = new StringBuilder().append("detected invalid position. loc invalid? ");
                        if (a2 >= a) {
                            z = b;
                        }
                        throw new RuntimeException(append.append(z).toString());
                    } else if (a2 > a) {
                        Q();
                        throw new RuntimeException("detected invalid location");
                    } else {
                        i += k;
                    }
                }
                return;
            }
            i = k;
            while (i < y()) {
                h = h(i);
                e2 = e(h);
                a2 = this.n.a(h);
                if (e2 < e) {
                    Q();
                    append = new StringBuilder().append("detected invalid position. loc invalid? ");
                    if (a2 >= a) {
                        z = b;
                    }
                    throw new RuntimeException(append.append(z).toString());
                } else if (a2 < a) {
                    Q();
                    throw new RuntimeException("detected invalid location");
                } else {
                    i += k;
                }
            }
        }
    }
}
