package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.l.a;
import android.support.v4.view.C0146au;
import android.support.v4.view.C0151az;
import android.support.v4.view.Y;
import android.support.v4.view.aZ;
import android.support.v4.widget.F;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.xiaomi.account.openauth.h;
import java.util.ArrayList;
import java.util.List;

public class RecyclerView extends ViewGroup {
    private static final int W = -1;
    public static final int a = 0;
    private static final Interpolator aq = new K();
    public static final int b = 1;
    public static final int c = -1;
    public static final long d = -1;
    public static final int e = -1;
    public static final int f = 0;
    public static final int g = 1;
    public static final int m = 0;
    public static final int n = 1;
    public static final int o = 2;
    private static final String s = "RecyclerView";
    private static final boolean t = false;
    private static final boolean u;
    private static final boolean v = false;
    private static final int w = 2000;
    private final Runnable A;
    private final Rect B;
    private N C;
    private W D;
    private ab E;
    private final ArrayList<U> F;
    private final ArrayList<X> G;
    private X H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;
    private final boolean O;
    private final AccessibilityManager P;
    private boolean Q;
    private boolean R;
    private F S;
    private F T;
    private F U;
    private F V;
    private int aa;
    private int ab;
    private VelocityTracker ac;
    private int ad;
    private int ae;
    private int af;
    private int ag;
    private int ah;
    private final int ai;
    private final int aj;
    private final ai ak;
    private Y al;
    private S am;
    private boolean an;
    private ak ao;
    private Runnable ap;
    final aa h;
    C0257a i;
    C0259d j;
    final List<View> k;
    Q l;
    final ag p;
    boolean q;
    boolean r;
    private final ac x;
    private SavedState y;
    private boolean z;

    public class LayoutParams extends MarginLayoutParams {
        aj b;
        final Rect c = new Rect();
        boolean d = true;
        boolean e = RecyclerView.v;

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public boolean c() {
            return this.b.o();
        }

        public boolean d() {
            return this.b.n();
        }

        public boolean e() {
            return this.b.r();
        }

        public boolean f() {
            return this.b.p();
        }

        public int g() {
            return this.b.d();
        }
    }

    class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new ad();
        Parcelable a;

        SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readParcelable(W.class.getClassLoader());
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void a(SavedState savedState) {
            this.a = savedState.a;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.a, RecyclerView.m);
        }
    }

    static {
        boolean z = (VERSION.SDK_INT == 19 || VERSION.SDK_INT == 20) ? true : v;
        u = z;
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, m);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        boolean z = v;
        super(context, attributeSet, i);
        this.x = new ac();
        this.h = new aa(this);
        this.k = new ArrayList();
        this.A = new I(this);
        this.B = new Rect();
        this.F = new ArrayList();
        this.G = new ArrayList();
        this.Q = v;
        this.R = v;
        this.l = new C0261g();
        this.aa = m;
        this.ab = e;
        this.ak = new ai(this);
        this.p = new ag();
        this.q = v;
        this.r = v;
        this.am = new T();
        this.an = v;
        this.ap = new J(this);
        this.O = VERSION.SDK_INT >= 16 ? true : v;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.ah = viewConfiguration.getScaledTouchSlop();
        this.ai = viewConfiguration.getScaledMinimumFlingVelocity();
        this.aj = viewConfiguration.getScaledMaximumFlingVelocity();
        if (C0151az.a(this) == o) {
            z = true;
        }
        setWillNotDraw(z);
        this.l.a(this.am);
        b();
        y();
        if (C0151az.e(this) == 0) {
            C0151az.d((View) this, (int) n);
        }
        this.P = (AccessibilityManager) getContext().getSystemService("accessibility");
        a(new ak(this));
    }

    private void A() {
        this.ak.stop();
        this.D.N();
    }

    private void B() {
        int i = m;
        if (this.S != null) {
            i = this.S.c();
        }
        if (this.T != null) {
            i |= this.T.c();
        }
        if (this.U != null) {
            i |= this.U.c();
        }
        if (this.V != null) {
            i |= this.V.c();
        }
        if (i != 0) {
            C0151az.d(this);
        }
    }

    private void C() {
        if (this.ac != null) {
            this.ac.clear();
        }
        B();
        h((int) m);
    }

    private boolean D() {
        return (this.l == null || !this.l.h()) ? v : true;
    }

    private void E() {
        if (!this.an && this.I) {
            C0151az.a((View) this, this.ap);
            this.an = true;
        }
    }

    private boolean F() {
        return (this.l == null || !this.D.d()) ? v : true;
    }

    private void G() {
        boolean z = true;
        if (this.Q) {
            this.i.a();
            u();
            this.D.a(this);
        }
        if (this.l == null || !this.D.d()) {
            this.i.e();
        } else {
            this.i.b();
        }
        boolean z2 = ((this.q && !this.r) || this.q || (this.r && D())) ? true : m;
        ag agVar = this.p;
        boolean z3 = (!this.K || this.l == null || (!(this.Q || z2 || this.D.a) || (this.Q && !this.C.b()))) ? v : true;
        agVar.k = z3;
        ag agVar2 = this.p;
        if (!(this.p.k && z2 && !this.Q && F())) {
            z = v;
        }
        agVar2.l = z;
    }

    private void a(a<View, Rect> aVar) {
        int size = this.k.size();
        for (int i = m; i < size; i += n) {
            View view = (View) this.k.get(i);
            aj b = b(view);
            V v = (V) this.p.a.remove(b);
            if (!this.p.b()) {
                this.p.b.remove(b);
            }
            if (aVar.remove(view) != null) {
                this.D.b(view, this.h);
            } else if (v != null) {
                a(v);
            } else {
                a(new V(b, view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            }
        }
        this.k.clear();
    }

    private void a(N n, boolean z, boolean z2) {
        if (this.C != null) {
            this.C.b(this.x);
            this.C.b(this);
        }
        if (!z || z2) {
            if (this.l != null) {
                this.l.c();
            }
            if (this.D != null) {
                this.D.c(this.h);
                this.D.b(this.h);
            }
        }
        this.i.a();
        N n2 = this.C;
        this.C = n;
        if (n != null) {
            n.a(this.x);
            n.a(this);
        }
        if (this.D != null) {
            this.D.a(n2, this.C);
        }
        this.h.a(n2, this.C, z);
        this.p.i = true;
        u();
    }

    private void a(V v) {
        View view = v.a.a;
        b(v.a);
        int i = v.b;
        int i2 = v.c;
        int left = view.getLeft();
        int top = view.getTop();
        if (i == left && i2 == top) {
            v.a.a((boolean) v);
            if (this.l.a(v.a)) {
                E();
                return;
            }
            return;
        }
        v.a.a((boolean) v);
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        if (this.l.a(v.a, i, i2, left, top)) {
            E();
        }
    }

    private void a(aj ajVar, Rect rect, int i, int i2) {
        View view = ajVar.a;
        if (rect == null || (rect.left == i && rect.top == i2)) {
            ajVar.a((boolean) v);
            if (this.l.b(ajVar)) {
                E();
                return;
            }
            return;
        }
        ajVar.a((boolean) v);
        if (this.l.a(ajVar, rect.left, rect.top, i, i2)) {
            E();
        }
    }

    private void a(aj ajVar, aj ajVar2) {
        int i;
        int i2;
        ajVar.a((boolean) v);
        b(ajVar);
        ajVar.g = ajVar2;
        this.h.c(ajVar);
        int left = ajVar.a.getLeft();
        int top = ajVar.a.getTop();
        if (ajVar2 == null || ajVar2.c()) {
            i = top;
            i2 = left;
        } else {
            i2 = ajVar2.a.getLeft();
            i = ajVar2.a.getTop();
            ajVar2.a((boolean) v);
            ajVar2.h = ajVar;
        }
        if (this.l.a(ajVar, ajVar2, left, top, i2, i)) {
            E();
        }
    }

    private boolean a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.H = null;
        }
        int size = this.G.size();
        int i = m;
        while (i < size) {
            X x = (X) this.G.get(i);
            if (!x.a(this, motionEvent) || action == 3) {
                i += n;
            } else {
                this.H = x;
                return true;
            }
        }
        return v;
    }

    static aj b(View view) {
        return view == null ? null : ((LayoutParams) view.getLayoutParams()).b;
    }

    private void b(aj ajVar) {
        View view = ajVar.a;
        boolean z = view.getParent() == this ? true : v;
        this.h.c(a(view));
        if (ajVar.s()) {
            this.j.a(view, e, view.getLayoutParams(), true);
        } else if (z) {
            this.j.d(view);
        } else {
            this.j.a(view, true);
        }
    }

    private boolean b(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.H != null) {
            if (action == 0) {
                this.H = null;
            } else {
                this.H.b(this, motionEvent);
                if (action == 3 || action == n) {
                    this.H = null;
                }
                return true;
            }
        }
        if (action != 0) {
            int size = this.G.size();
            for (int i = m; i < size; i += n) {
                X x = (X) this.G.get(i);
                if (x.a(this, motionEvent)) {
                    this.H = x;
                    return true;
                }
            }
        }
        return v;
    }

    private void c(MotionEvent motionEvent) {
        int b = Y.b(motionEvent);
        if (Y.b(motionEvent, b) == this.ab) {
            b = b == 0 ? n : m;
            this.ab = Y.b(motionEvent, b);
            int c = (int) (Y.c(motionEvent, b) + 0.5f);
            this.af = c;
            this.ad = c;
            b = (int) (Y.d(motionEvent, b) + 0.5f);
            this.ag = b;
            this.ae = b;
        }
    }

    private void h(int i) {
        if (i != this.aa) {
            this.aa = i;
            if (i != o) {
                A();
            }
            if (this.al != null) {
                this.al.a(this, i);
            }
            this.D.k(i);
        }
    }

    private void h(int i, int i2) {
        if (i < 0) {
            j();
            this.S.a(((float) (-i)) / ((float) getWidth()));
        } else if (i > 0) {
            k();
            this.U.a(((float) i) / ((float) getWidth()));
        }
        if (i2 < 0) {
            l();
            this.T.a(((float) (-i2)) / ((float) getHeight()));
        } else if (i2 > 0) {
            m();
            this.V.a(((float) i2) / ((float) getHeight()));
        }
        if (i != 0 || i2 != 0) {
            C0151az.d(this);
        }
    }

    private boolean h(View view) {
        h();
        boolean e = this.j.e(view);
        if (e) {
            aj b = b(view);
            this.h.c(b);
            this.h.b(b);
        }
        b((boolean) v);
        return e;
    }

    private void i(int i, int i2) {
        int i3 = m;
        if (!(this.S == null || this.S.a() || i <= 0)) {
            i3 = this.S.c();
        }
        if (!(this.U == null || this.U.a() || i >= 0)) {
            i3 |= this.U.c();
        }
        if (!(this.T == null || this.T.a() || i2 <= 0)) {
            i3 |= this.T.c();
        }
        if (!(this.V == null || this.V.a() || i2 >= 0)) {
            i3 |= this.V.c();
        }
        if (i3 != 0) {
            C0151az.d(this);
        }
    }

    private void i(View view) {
        if (this.C != null) {
            this.C.c(b(view));
        }
        f(view);
    }

    private void j(View view) {
        if (this.C != null) {
            this.C.b(b(view));
        }
        e(view);
    }

    private void k(View view) {
        this.k.remove(view);
    }

    private void l(View view) {
        if (!this.k.contains(view)) {
            this.k.add(view);
        }
    }

    private void y() {
        this.j = new C0259d(new L(this));
    }

    private void z() {
        this.A.run();
    }

    long a(aj ajVar) {
        return this.C.b() ? ajVar.f() : (long) ajVar.b;
    }

    aj a(int i, boolean z) {
        int c = this.j.c();
        for (int i2 = m; i2 < c; i2 += n) {
            aj b = b(this.j.c(i2));
            if (!(b == null || b.r())) {
                if (z) {
                    if (b.b == i) {
                        return b;
                    }
                } else if (b.d() == i) {
                    return b;
                }
            }
        }
        return null;
    }

    public aj a(long j) {
        int c = this.j.c();
        for (int i = m; i < c; i += n) {
            aj b = b(this.j.c(i));
            if (b != null && b.f() == j) {
                return b;
            }
        }
        return null;
    }

    public aj a(View view) {
        Object parent = view.getParent();
        if (parent == null || parent == this) {
            return b(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public ak a() {
        return this.ao;
    }

    public View a(float f, float f2) {
        for (int b = this.j.b() + e; b >= 0; b += e) {
            View b2 = this.j.b(b);
            float u = C0151az.u(b2);
            float v = C0151az.v(b2);
            if (f >= ((float) b2.getLeft()) + u && f <= u + ((float) b2.getRight()) && f2 >= ((float) b2.getTop()) + v && f2 <= ((float) b2.getBottom()) + v) {
                return b2;
            }
        }
        return null;
    }

    public void a(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        switch (i) {
            case m /*0*/:
                break;
            case n /*1*/:
                this.ah = aZ.a(viewConfiguration);
                return;
            default:
                Log.w(s, "setScrollingTouchSlop(): bad argument constant " + i + "; using default value");
                break;
        }
        this.ah = viewConfiguration.getScaledTouchSlop();
    }

    void a(int i, int i2) {
        int a;
        int i3;
        int b;
        int i4;
        z();
        if (this.C != null) {
            h();
            this.R = true;
            if (i != 0) {
                a = this.D.a(i, this.h, this.p);
                i3 = i - a;
            } else {
                a = m;
                i3 = m;
            }
            if (i2 != 0) {
                b = this.D.b(i2, this.h, this.p);
                i4 = i2 - b;
            } else {
                b = m;
                i4 = m;
            }
            if (D()) {
                int b2 = this.j.b();
                for (int i5 = m; i5 < b2; i5 += n) {
                    View b3 = this.j.b(i5);
                    aj a2 = a(b3);
                    if (!(a2 == null || a2.h == null)) {
                        a2 = a2.h;
                        View view = a2 != null ? a2.a : null;
                        if (view != null) {
                            int left = b3.getLeft();
                            int top = b3.getTop();
                            if (left != view.getLeft() || top != view.getTop()) {
                                view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                            }
                        }
                    }
                }
            }
            this.R = v;
            b((boolean) v);
            int i6 = a;
            a = i4;
            i4 = i6;
        } else {
            b = m;
            i4 = m;
            a = m;
            i3 = m;
        }
        if (!this.F.isEmpty()) {
            invalidate();
        }
        if (C0151az.a(this) != o) {
            i(i, i2);
            h(i3, a);
        }
        if (!(i4 == 0 && b == 0)) {
            onScrollChanged(m, m, m, m);
            if (this.al != null) {
                this.al.a(this, i4, b);
            }
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
    }

    void a(int i, int i2, boolean z) {
        int i3 = i + i2;
        int c = this.j.c();
        for (int i4 = m; i4 < c; i4 += n) {
            aj b = b(this.j.c(i4));
            if (!(b == null || b.c())) {
                if (b.b >= i3) {
                    b.a(-i2, z);
                    this.p.i = true;
                } else if (b.b >= i) {
                    b.a(i + e, -i2, z);
                    this.p.i = true;
                }
            }
        }
        this.h.b(i, i2, z);
        requestLayout();
    }

    public void a(N n) {
        a(n, (boolean) v, true);
        requestLayout();
    }

    public void a(N n, boolean z) {
        a(n, true, z);
        this.Q = true;
        requestLayout();
    }

    public void a(Q q) {
        if (this.l != null) {
            this.l.c();
            this.l.a(null);
        }
        this.l = q;
        if (this.l != null) {
            this.l.a(this.am);
        }
    }

    public void a(U u) {
        a(u, (int) e);
    }

    public void a(U u, int i) {
        if (this.D != null) {
            this.D.a("Cannot add item decoration during a scroll  or layout");
        }
        if (this.F.isEmpty()) {
            setWillNotDraw(v);
        }
        if (i < 0) {
            this.F.add(u);
        } else {
            this.F.add(i, u);
        }
        q();
        requestLayout();
    }

    public void a(W w) {
        if (w != this.D) {
            if (this.D != null) {
                if (this.I) {
                    this.D.a(this, this.h);
                }
                this.D.b(null);
            }
            this.h.a();
            this.j.a();
            this.D = w;
            if (w != null) {
                if (w.u != null) {
                    throw new IllegalArgumentException("LayoutManager " + w + " is already attached to a RecyclerView: " + w.u);
                }
                this.D.b(this);
                if (this.I) {
                    this.D.c(this);
                }
            }
            requestLayout();
        }
    }

    public void a(X x) {
        this.G.add(x);
    }

    public void a(Y y) {
        this.al = y;
    }

    public void a(Z z) {
        this.h.a(z);
    }

    public void a(ab abVar) {
        this.E = abVar;
    }

    public void a(ah ahVar) {
        this.h.a(ahVar);
    }

    public void a(ak akVar) {
        this.ao = akVar;
        C0151az.a((View) this, this.ao);
    }

    void a(String str) {
        if (!this.R) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling");
            }
            throw new IllegalStateException(str);
        }
    }

    public void a(boolean z) {
        this.J = z;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (!this.D.a(this, (ArrayList) arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    void b() {
        this.i = new C0257a(new M(this));
    }

    public void b(int i) {
        this.h.a(i);
    }

    public void b(int i, int i2) {
        if (i != 0 || i2 != 0) {
            this.ak.b(i, i2);
        }
    }

    public void b(U u) {
        if (this.D != null) {
            this.D.a("Cannot remove item decoration during a scroll  or layout");
        }
        this.F.remove(u);
        if (this.F.isEmpty()) {
            setWillNotDraw(C0151az.a(this) == o ? true : v);
        }
        q();
        requestLayout();
    }

    public void b(X x) {
        this.G.remove(x);
        if (this.H == x) {
            this.H = null;
        }
    }

    void b(String str) {
        if (!this.R) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling");
        }
        throw new IllegalStateException(str);
    }

    void b(boolean z) {
        if (this.L) {
            if (z && this.M && this.D != null && this.C != null) {
                p();
            }
            this.L = v;
            this.M = v;
        }
    }

    public int c(View view) {
        aj b = b(view);
        return b != null ? b.d() : e;
    }

    public void c(int i) {
        i();
        this.D.e(i);
        awakenScrollBars();
    }

    public boolean c() {
        return this.J;
    }

    public boolean c(int i, int i2) {
        if (Math.abs(i) < this.ai) {
            i = m;
        }
        if (Math.abs(i2) < this.ai) {
            i2 = m;
        }
        int max = Math.max(-this.aj, Math.min(i, this.aj));
        int max2 = Math.max(-this.aj, Math.min(i2, this.aj));
        if (max == 0 && max2 == 0) {
            return v;
        }
        this.ak.a(max, max2);
        return true;
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return ((layoutParams instanceof LayoutParams) && this.D.a((LayoutParams) layoutParams)) ? true : v;
    }

    protected int computeHorizontalScrollExtent() {
        return this.D.g() ? this.D.d(this.p) : m;
    }

    protected int computeHorizontalScrollOffset() {
        return this.D.g() ? this.D.b(this.p) : m;
    }

    protected int computeHorizontalScrollRange() {
        return this.D.g() ? this.D.f(this.p) : m;
    }

    protected int computeVerticalScrollExtent() {
        return this.D.h() ? this.D.e(this.p) : m;
    }

    protected int computeVerticalScrollOffset() {
        return this.D.h() ? this.D.c(this.p) : m;
    }

    protected int computeVerticalScrollRange() {
        return this.D.h() ? this.D.g(this.p) : m;
    }

    public long d(View view) {
        if (this.C == null || !this.C.b()) {
            return d;
        }
        aj b = b(view);
        return b != null ? b.f() : d;
    }

    public N d() {
        return this.C;
    }

    public void d(int i) {
        this.D.a(this, this.p, i);
    }

    void d(int i, int i2) {
        if (i < 0) {
            j();
            this.S.a(-i);
        } else if (i > 0) {
            k();
            this.U.a(i);
        }
        if (i2 < 0) {
            l();
            this.T.a(-i2);
        } else if (i2 > 0) {
            m();
            this.V.a(i2);
        }
        if (i != 0 || i2 != 0) {
            C0151az.d(this);
        }
    }

    public void draw(Canvas canvas) {
        int i;
        int i2;
        int i3 = n;
        int i4 = m;
        super.draw(canvas);
        int size = this.F.size();
        for (i = m; i < size; i += n) {
            ((U) this.F.get(i)).b(canvas, this, this.p);
        }
        if (this.S == null || this.S.a()) {
            i2 = m;
        } else {
            i = canvas.save();
            i2 = this.z ? getPaddingBottom() : m;
            canvas.rotate(BitmapDescriptorFactory.HUE_VIOLET);
            canvas.translate((float) (i2 + (-getHeight())), 0.0f);
            i2 = (this.S == null || !this.S.a(canvas)) ? m : n;
            canvas.restoreToCount(i);
        }
        if (!(this.T == null || this.T.a())) {
            size = canvas.save();
            if (this.z) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            i = (this.T == null || !this.T.a(canvas)) ? m : n;
            i2 |= i;
            canvas.restoreToCount(size);
        }
        if (!(this.U == null || this.U.a())) {
            size = canvas.save();
            int width = getWidth();
            i = this.z ? getPaddingTop() : m;
            canvas.rotate(90.0f);
            canvas.translate((float) (-i), (float) (-width));
            i = (this.U == null || !this.U.a(canvas)) ? m : n;
            i2 |= i;
            canvas.restoreToCount(size);
        }
        if (!(this.V == null || this.V.a())) {
            i = canvas.save();
            canvas.rotate(BitmapDescriptorFactory.HUE_CYAN);
            if (this.z) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            if (this.V != null && this.V.a(canvas)) {
                i4 = n;
            }
            i2 |= i4;
            canvas.restoreToCount(i);
        }
        if (i2 != 0 || this.l == null || this.F.size() <= 0 || !this.l.b()) {
            i3 = i2;
        }
        if (i3 != 0) {
            C0151az.d(this);
        }
    }

    public W e() {
        return this.D;
    }

    public aj e(int i) {
        return a(i, (boolean) v);
    }

    void e(int i, int i2) {
        int i3;
        int c = this.j.c();
        int i4;
        int i5;
        if (i < i2) {
            i3 = e;
            i4 = i2;
            i5 = i;
        } else {
            i3 = n;
            i4 = i;
            i5 = i2;
        }
        for (int i6 = m; i6 < c; i6 += n) {
            aj b = b(this.j.c(i6));
            if (b != null && b.b >= r3 && b.b <= r2) {
                if (b.b == i) {
                    b.a(i2 - i, (boolean) v);
                } else {
                    b.a(i3, (boolean) v);
                }
                this.p.i = true;
            }
        }
        this.h.a(i, i2);
        requestLayout();
    }

    public void e(View view) {
    }

    public Z f() {
        return this.h.f();
    }

    public void f(int i) {
        int b = this.j.b();
        for (int i2 = m; i2 < b; i2 += n) {
            this.j.b(i2).offsetTopAndBottom(i);
        }
    }

    void f(int i, int i2) {
        int c = this.j.c();
        for (int i3 = m; i3 < c; i3 += n) {
            aj b = b(this.j.c(i3));
            if (!(b == null || b.c() || b.b < i)) {
                b.a(i2, (boolean) v);
                this.p.i = true;
            }
        }
        this.h.b(i, i2);
        requestLayout();
    }

    public void f(View view) {
    }

    public View focusSearch(View view, int i) {
        View d = this.D.d(view, i);
        if (d != null) {
            return d;
        }
        d = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (d == null && this.C != null) {
            h();
            d = this.D.a(view, i, this.h, this.p);
            b((boolean) v);
        }
        return d == null ? super.focusSearch(view, i) : d;
    }

    public int g() {
        return this.aa;
    }

    Rect g(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.d) {
            return layoutParams.c;
        }
        Rect rect = layoutParams.c;
        rect.set(m, m, m, m);
        int size = this.F.size();
        for (int i = m; i < size; i += n) {
            this.B.set(m, m, m, m);
            ((U) this.F.get(i)).a(this.B, view, this, this.p);
            rect.left += this.B.left;
            rect.top += this.B.top;
            rect.right += this.B.right;
            rect.bottom += this.B.bottom;
        }
        layoutParams.d = v;
        return rect;
    }

    public void g(int i) {
        int b = this.j.b();
        for (int i2 = m; i2 < b; i2 += n) {
            this.j.b(i2).offsetLeftAndRight(i);
        }
    }

    void g(int i, int i2) {
        int c = this.j.c();
        int i3 = i + i2;
        for (int i4 = m; i4 < c; i4 += n) {
            View c2 = this.j.c(i4);
            aj b = b(c2);
            if (b != null && !b.c() && b.b >= i && b.b < i3) {
                b.a((int) o);
                if (D()) {
                    b.a(64);
                }
                ((LayoutParams) c2.getLayoutParams()).d = true;
            }
        }
        this.h.c(i, i2);
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        if (this.D != null) {
            return this.D.a();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (this.D != null) {
            return this.D.a(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (this.D != null) {
            return this.D.a(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    void h() {
        if (!this.L) {
            this.L = true;
            this.M = v;
        }
    }

    public void i() {
        h((int) m);
        A();
    }

    void j() {
        if (this.S == null) {
            this.S = new F(getContext());
            if (this.z) {
                this.S.a((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.S.a(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void k() {
        if (this.U == null) {
            this.U = new F(getContext());
            if (this.z) {
                this.U.a((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.U.a(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void l() {
        if (this.T == null) {
            this.T = new F(getContext());
            if (this.z) {
                this.T.a((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.T.a(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    void m() {
        if (this.V == null) {
            this.V = new F(getContext());
            if (this.z) {
                this.V.a((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.V.a(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    void n() {
        this.V = null;
        this.T = null;
        this.U = null;
        this.S = null;
    }

    public Q o() {
        return this.l;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.I = true;
        this.K = v;
        if (this.D != null) {
            this.D.c(this);
        }
        this.an = v;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.l != null) {
            this.l.c();
        }
        this.K = v;
        i();
        this.I = v;
        if (this.D != null) {
            this.D.a(this, this.h);
        }
        removeCallbacks(this.ap);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.F.size();
        for (int i = m; i < size; i += n) {
            ((U) this.F.get(i)).a(canvas, this, this.p);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int i = e;
        if (a(motionEvent)) {
            C();
            return true;
        }
        boolean g = this.D.g();
        boolean h = this.D.h();
        if (this.ac == null) {
            this.ac = VelocityTracker.obtain();
        }
        this.ac.addMovement(motionEvent);
        int a = Y.a(motionEvent);
        int b = Y.b(motionEvent);
        int x;
        switch (a) {
            case m /*0*/:
                this.ab = Y.b(motionEvent, m);
                x = (int) (motionEvent.getX() + 0.5f);
                this.af = x;
                this.ad = x;
                x = (int) (motionEvent.getY() + 0.5f);
                this.ag = x;
                this.ae = x;
                if (this.aa == o) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    h((int) n);
                    break;
                }
                break;
            case n /*1*/:
                this.ac.clear();
                break;
            case o /*2*/:
                a = Y.a(motionEvent, this.ab);
                if (a >= 0) {
                    b = (int) (Y.c(motionEvent, a) + 0.5f);
                    a = (int) (Y.d(motionEvent, a) + 0.5f);
                    if (this.aa != n) {
                        b -= this.ad;
                        a -= this.ae;
                        if (!g || Math.abs(b) <= this.ah) {
                            g = m;
                        } else {
                            this.af = ((b < 0 ? e : n) * this.ah) + this.ad;
                            g = true;
                        }
                        if (h && Math.abs(a) > this.ah) {
                            x = this.ae;
                            int i2 = this.ah;
                            if (a >= 0) {
                                i = n;
                            }
                            this.ag = x + (i * i2);
                            g = true;
                        }
                        if (g) {
                            getParent().requestDisallowInterceptTouchEvent(true);
                            h((int) n);
                            break;
                        }
                    }
                }
                Log.e(s, "Error processing scroll; pointer index for id " + this.ab + " not found. Did any MotionEvents get skipped?");
                return v;
                break;
            case kankan.wheel.widget.a.l /*3*/:
                C();
                break;
            case kankan.wheel.widget.a.X /*5*/:
                this.ab = Y.b(motionEvent, b);
                x = (int) (Y.c(motionEvent, b) + 0.5f);
                this.af = x;
                this.ad = x;
                x = (int) (Y.d(motionEvent, b) + 0.5f);
                this.ag = x;
                this.ae = x;
                break;
            case kankan.wheel.widget.a.bt /*6*/:
                c(motionEvent);
                break;
        }
        return this.aa != n ? v : true;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        h();
        p();
        b((boolean) v);
        this.K = true;
    }

    protected void onMeasure(int i, int i2) {
        if (this.N) {
            h();
            G();
            if (this.p.l) {
                this.p.j = true;
            } else {
                this.i.e();
                this.p.j = v;
            }
            this.N = v;
            b((boolean) v);
        }
        if (this.C != null) {
            this.p.d = this.C.a();
        } else {
            this.p.d = m;
        }
        this.D.a(this.h, this.p, i, i2);
        this.p.j = v;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        this.y = (SavedState) parcelable;
        super.onRestoreInstanceState(this.y.getSuperState());
        if (this.D != null && this.y.a != null) {
            this.D.a(this.y.a);
        }
    }

    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.y != null) {
            savedState.a(this.y);
        } else if (this.D != null) {
            savedState.a = this.D.f();
        } else {
            savedState.a = null;
        }
        return savedState;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            n();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = e;
        if (b(motionEvent)) {
            C();
            return true;
        }
        boolean g = this.D.g();
        boolean h = this.D.h();
        if (this.ac == null) {
            this.ac = VelocityTracker.obtain();
        }
        this.ac.addMovement(motionEvent);
        int a = Y.a(motionEvent);
        int b = Y.b(motionEvent);
        switch (a) {
            case m /*0*/:
                this.ab = Y.b(motionEvent, m);
                a = (int) (motionEvent.getX() + 0.5f);
                this.af = a;
                this.ad = a;
                a = (int) (motionEvent.getY() + 0.5f);
                this.ag = a;
                this.ae = a;
                return true;
            case n /*1*/:
                this.ac.computeCurrentVelocity(h.E, (float) this.aj);
                float f = g ? -C0146au.a(this.ac, this.ab) : 0.0f;
                float f2 = h ? -C0146au.b(this.ac, this.ab) : 0.0f;
                if ((f == 0.0f && f2 == 0.0f) || !c((int) f, (int) f2)) {
                    h((int) m);
                }
                this.ac.clear();
                B();
                return true;
            case o /*2*/:
                a = Y.a(motionEvent, this.ab);
                if (a < 0) {
                    Log.e(s, "Error processing scroll; pointer index for id " + this.ab + " not found. Did any MotionEvents get skipped?");
                    return v;
                }
                int c = (int) (Y.c(motionEvent, a) + 0.5f);
                b = (int) (Y.d(motionEvent, a) + 0.5f);
                if (this.aa != n) {
                    boolean z;
                    a = c - this.ad;
                    int i2 = b - this.ae;
                    if (!g || Math.abs(a) <= this.ah) {
                        z = m;
                    } else {
                        this.af = ((a < 0 ? e : n) * this.ah) + this.ad;
                        z = true;
                    }
                    if (h && Math.abs(i2) > this.ah) {
                        a = this.ae;
                        int i3 = this.ah;
                        if (i2 >= 0) {
                            i = n;
                        }
                        this.ag = a + (i * i3);
                        z = true;
                    }
                    if (z) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        h((int) n);
                    }
                }
                if (this.aa == n) {
                    a(g ? -(c - this.af) : m, h ? -(b - this.ag) : m);
                }
                this.af = c;
                this.ag = b;
                return true;
            case kankan.wheel.widget.a.l /*3*/:
                C();
                return true;
            case kankan.wheel.widget.a.X /*5*/:
                this.ab = Y.b(motionEvent, b);
                a = (int) (Y.c(motionEvent, b) + 0.5f);
                this.af = a;
                this.ad = a;
                a = (int) (Y.d(motionEvent, b) + 0.5f);
                this.ag = a;
                this.ae = a;
                return true;
            case kankan.wheel.widget.a.bt /*6*/:
                c(motionEvent);
                return true;
            default:
                return true;
        }
    }

    void p() {
        if (this.C == null) {
            Log.e(s, "No adapter attached; skipping layout");
            return;
        }
        int b;
        int i;
        aj b2;
        int b3;
        int i2;
        boolean c;
        int i3;
        a aVar;
        this.k.clear();
        h();
        this.R = true;
        G();
        ag agVar = this.p;
        a aVar2 = (this.p.k && this.r && D()) ? new a() : null;
        agVar.c = aVar2;
        this.r = v;
        this.q = v;
        this.p.j = this.p.l;
        this.p.d = this.C.a();
        if (this.p.k) {
            this.p.a.clear();
            this.p.b.clear();
            b = this.j.b();
            for (i = m; i < b; i += n) {
                b2 = b(this.j.b(i));
                if (!b2.c() && (!b2.n() || this.C.b())) {
                    View view = b2.a;
                    this.p.a.put(b2, new V(b2, view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
                }
            }
        }
        aj b4;
        if (this.p.l) {
            r();
            if (this.p.c != null) {
                b3 = this.j.b();
                for (i2 = m; i2 < b3; i2 += n) {
                    b4 = b(this.j.b(i2));
                    if (!(!b4.p() || b4.r() || b4.c())) {
                        this.p.c.put(Long.valueOf(a(b4)), b4);
                        this.p.a.remove(b4);
                    }
                }
            }
            c = this.p.i;
            this.p.i = v;
            this.D.c(this.h, this.p);
            this.p.i = c;
            a aVar3 = new a();
            for (b3 = m; b3 < this.j.b(); b3 += n) {
                View b5 = this.j.b(b3);
                if (!b(b5).c()) {
                    for (i3 = m; i3 < this.p.a.size(); i3 += n) {
                        if (((aj) this.p.a.b(i3)).a == b5) {
                            c = true;
                            break;
                        }
                    }
                    c = v;
                    if (!c) {
                        aVar3.put(b5, new Rect(b5.getLeft(), b5.getTop(), b5.getRight(), b5.getBottom()));
                    }
                }
            }
            s();
            this.i.c();
            aVar = aVar3;
        } else {
            s();
            this.i.e();
            if (this.p.c != null) {
                b3 = this.j.b();
                for (i2 = m; i2 < b3; i2 += n) {
                    b4 = b(this.j.b(i2));
                    if (!(!b4.p() || b4.r() || b4.c())) {
                        this.p.c.put(Long.valueOf(a(b4)), b4);
                        this.p.a.remove(b4);
                    }
                }
            }
            aVar = null;
        }
        this.p.d = this.C.a();
        this.p.h = m;
        this.p.j = v;
        this.D.c(this.h, this.p);
        this.p.i = v;
        this.y = null;
        agVar = this.p;
        c = (!this.p.k || this.l == null) ? v : true;
        agVar.k = c;
        if (this.p.k) {
            aj ajVar;
            a aVar4 = this.p.c != null ? new a() : null;
            int b6 = this.j.b();
            for (b = m; b < b6; b += n) {
                b2 = b(this.j.b(b));
                if (!b2.c()) {
                    view = b2.a;
                    long a = a(b2);
                    if (aVar4 == null || this.p.c.get(Long.valueOf(a)) == null) {
                        this.p.b.put(b2, new V(b2, view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
                    } else {
                        aVar4.put(Long.valueOf(a), b2);
                    }
                }
            }
            a(aVar);
            for (b3 = this.p.a.size() + e; b3 >= 0; b3 += e) {
                if (!this.p.b.containsKey((aj) this.p.a.b(b3))) {
                    V v = (V) this.p.a.c(b3);
                    this.p.a.d(b3);
                    View view2 = v.a.a;
                    this.h.c(v.a);
                    a(v);
                }
            }
            i2 = this.p.b.size();
            if (i2 > 0) {
                for (int i4 = i2 + e; i4 >= 0; i4 += e) {
                    ajVar = (aj) this.p.b.b(i4);
                    V v2 = (V) this.p.b.c(i4);
                    if (this.p.a.isEmpty() || !this.p.a.containsKey(ajVar)) {
                        this.p.b.d(i4);
                        a(ajVar, aVar != null ? (Rect) aVar.get(ajVar.a) : null, v2.b, v2.c);
                    }
                }
            }
            b = this.p.b.size();
            for (i = m; i < b; i += n) {
                b2 = (aj) this.p.b.b(i);
                V v3 = (V) this.p.b.c(i);
                V v4 = (V) this.p.a.get(b2);
                if (!(v4 == null || v3 == null || (v4.b == v3.b && v4.c == v3.c))) {
                    b2.a((boolean) v);
                    if (this.l.a(b2, v4.b, v4.c, v3.b, v3.c)) {
                        E();
                    }
                }
            }
            for (i3 = (this.p.c != null ? this.p.c.size() : m) + e; i3 >= 0; i3 += e) {
                long longValue = ((Long) this.p.c.b(i3)).longValue();
                ajVar = (aj) this.p.c.get(Long.valueOf(longValue));
                View view3 = ajVar.a;
                if (!(ajVar.c() || this.h.d == null || !this.h.d.contains(ajVar))) {
                    a(ajVar, (aj) aVar4.get(Long.valueOf(longValue)));
                }
            }
        }
        b((boolean) v);
        this.D.b(this.h);
        this.p.g = this.p.d;
        this.Q = v;
        this.p.k = v;
        this.p.l = v;
        this.R = v;
        this.D.a = v;
        if (this.h.d != null) {
            this.h.d.clear();
        }
        this.p.c = null;
    }

    void q() {
        int c = this.j.c();
        for (int i = m; i < c; i += n) {
            ((LayoutParams) this.j.c(i).getLayoutParams()).d = true;
        }
        this.h.i();
    }

    void r() {
        int c = this.j.c();
        for (int i = m; i < c; i += n) {
            aj b = b(this.j.c(i));
            if (!b.c()) {
                b.b();
            }
        }
    }

    protected void removeDetachedView(View view, boolean z) {
        aj b = b(view);
        if (b != null) {
            if (b.s()) {
                b.l();
            } else if (!b.c()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + b);
            }
        }
        i(view);
        super.removeDetachedView(view, z);
    }

    public void requestChildFocus(View view, View view2) {
        boolean z = v;
        if (!(this.D.a(this, this.p, view, view2) || view2 == null)) {
            this.B.set(m, m, view2.getWidth(), view2.getHeight());
            offsetDescendantRectToMyCoords(view2, this.B);
            offsetRectIntoDescendantCoords(view, this.B);
            Rect rect = this.B;
            if (!this.K) {
                z = true;
            }
            requestChildRectangleOnScreen(view, rect, z);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.D.a(this, view, rect, z);
    }

    public void requestLayout() {
        if (this.L) {
            this.M = true;
        } else {
            super.requestLayout();
        }
    }

    void s() {
        int c = this.j.c();
        for (int i = m; i < c; i += n) {
            aj b = b(this.j.c(i));
            if (!b.c()) {
                b.a();
            }
        }
        this.h.h();
    }

    public void scrollBy(int i, int i2) {
        if (this.D == null) {
            throw new IllegalStateException("Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        }
        boolean g = this.D.g();
        boolean h = this.D.h();
        if (g || h) {
            if (!g) {
                i = m;
            }
            if (!h) {
                i2 = m;
            }
            a(i, i2);
        }
    }

    public void scrollTo(int i, int i2) {
        throw new UnsupportedOperationException("RecyclerView does not support scrolling to an absolute position.");
    }

    public void setClipToPadding(boolean z) {
        if (z != this.z) {
            n();
        }
        this.z = z;
        super.setClipToPadding(z);
        if (this.K) {
            requestLayout();
        }
    }

    void t() {
        int b = this.j.b();
        for (int i = m; i < b; i += n) {
            aj b2 = b(this.j.b(i));
            if (!(b2 == null || b2.c())) {
                if (b2.r() || b2.n()) {
                    requestLayout();
                } else if (b2.o()) {
                    if (b2.g() != this.C.a(b2.b)) {
                        b2.a(4);
                        requestLayout();
                    } else if (b2.p() && D()) {
                        requestLayout();
                    } else {
                        this.C.b(b2, b2.b);
                    }
                }
            }
        }
    }

    void u() {
        int c = this.j.c();
        for (int i = m; i < c; i += n) {
            aj b = b(this.j.c(i));
            if (!(b == null || b.c())) {
                b.a(6);
            }
        }
        q();
        this.h.g();
    }

    public void v() {
        if (this.F.size() != 0) {
            if (this.D != null) {
                this.D.a("Cannot invalidate item decorations during a scroll or layout");
            }
            q();
            requestLayout();
        }
    }
}
