package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.a.r;
import android.support.v4.content.c;
import android.support.v4.view.A;
import android.support.v4.view.C0151az;
import android.support.v4.view.C0165bh;
import android.support.v4.view.C0198v;
import android.support.v4.view.a.C0099a;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import kankan.wheel.widget.a;

public class DrawerLayout extends ViewGroup implements E {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 0;
    public static final int e = 1;
    public static final int f = 2;
    static final C0247r g;
    private static final String h = "DrawerLayout";
    private static final int i = 64;
    private static final int j = -1728053248;
    private static final int k = 160;
    private static final int l = 400;
    private static final boolean m = false;
    private static final boolean n = true;
    private static final float o = 1.0f;
    private static final int[] p;
    private static final boolean q;
    private int A;
    private boolean B;
    private boolean C;
    private int D;
    private int E;
    private boolean F;
    private boolean G;
    private u H;
    private float I;
    private float J;
    private Drawable K;
    private Drawable L;
    private Drawable M;
    private CharSequence N;
    private CharSequence O;
    private Object P;
    private boolean Q;
    private final C0246q r;
    private int s;
    private int t;
    private float u;
    private Paint v;
    private final bf w;
    private final bf x;
    private final A y;
    private final A z;

    public class LayoutParams extends MarginLayoutParams {
        public int a;
        float b;
        boolean c;
        boolean d;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.a = DrawerLayout.d;
        }

        public LayoutParams(int i, int i2, int i3) {
            this(i, i2);
            this.a = i3;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = DrawerLayout.d;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.p);
            this.a = obtainStyledAttributes.getInt(DrawerLayout.d, DrawerLayout.d);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.a = DrawerLayout.d;
            this.a = layoutParams.a;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = DrawerLayout.d;
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.a = DrawerLayout.d;
        }
    }

    public class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C0252x();
        int a = DrawerLayout.d;
        int b = DrawerLayout.d;
        int c = DrawerLayout.d;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
        }
    }

    static {
        boolean z = n;
        int[] iArr = new int[e];
        iArr[d] = 16842931;
        p = iArr;
        if (VERSION.SDK_INT < 19) {
            z = m;
        }
        q = z;
        if (VERSION.SDK_INT >= 21) {
            g = new C0248s();
        } else {
            g = new C0249t();
        }
    }

    public DrawerLayout(Context context) {
        this(context, null);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, d);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.r = new C0246q(this);
        this.t = j;
        this.v = new Paint();
        this.C = n;
        setDescendantFocusability(C0099a.l);
        float f = getResources().getDisplayMetrics().density;
        this.s = (int) ((64.0f * f) + 0.5f);
        f *= a.bP;
        this.y = new A(this, 3);
        this.z = new A(this, 5);
        this.w = bf.a((ViewGroup) this, (float) o, this.y);
        this.w.a((int) e);
        this.w.a(f);
        this.y.a(this.w);
        this.x = bf.a((ViewGroup) this, (float) o, this.z);
        this.x.a((int) f);
        this.x.a(f);
        this.z.a(this.x);
        setFocusableInTouchMode(n);
        C0151az.d((View) this, (int) e);
        C0151az.a((View) this, new C0245p(this));
        C0165bh.a((ViewGroup) this, (boolean) m);
        if (C0151az.N(this)) {
            g.a((View) this);
        }
    }

    private void a(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = d; i < childCount; i += e) {
            View childAt = getChildAt(i);
            if ((z || g(childAt)) && !(z && childAt == view)) {
                C0151az.d(childAt, 4);
            } else {
                C0151az.d(childAt, (int) e);
            }
        }
    }

    static String f(int i) {
        return (i & 3) == 3 ? "LEFT" : (i & 5) == 5 ? "RIGHT" : Integer.toHexString(i);
    }

    private boolean f() {
        int childCount = getChildCount();
        for (int i = d; i < childCount; i += e) {
            if (((LayoutParams) getChildAt(i).getLayoutParams()).c) {
                return n;
            }
        }
        return m;
    }

    private boolean g() {
        return h() != null ? n : m;
    }

    private View h() {
        int childCount = getChildCount();
        for (int i = d; i < childCount; i += e) {
            View childAt = getChildAt(i);
            if (g(childAt) && k(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    private static boolean m(View view) {
        Drawable background = view.getBackground();
        return (background == null || background.getOpacity() != -1) ? m : n;
    }

    private static boolean n(View view) {
        return (C0151az.e(view) == 4 || C0151az.e(view) == f) ? m : n;
    }

    public int a(View view) {
        int e = e(view);
        return e == 3 ? this.D : e == 5 ? this.E : d;
    }

    View a() {
        int childCount = getChildCount();
        for (int i = d; i < childCount; i += e) {
            View childAt = getChildAt(i);
            if (((LayoutParams) childAt.getLayoutParams()).d) {
                return childAt;
            }
        }
        return null;
    }

    public void a(int i) {
        this.t = i;
        invalidate();
    }

    public void a(int i, int i2) {
        a(getResources().getDrawable(i), i2);
    }

    void a(int i, int i2, View view) {
        int i3 = e;
        int b = this.w.b();
        int b2 = this.x.b();
        if (!(b == e || b2 == e)) {
            i3 = (b == f || b2 == f) ? f : d;
        }
        if (view != null && i2 == 0) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams.b == 0.0f) {
                b(view);
            } else if (layoutParams.b == o) {
                c(view);
            }
        }
        if (i3 != this.A) {
            this.A = i3;
            if (this.H != null) {
                this.H.b(i3);
            }
        }
    }

    public void a(int i, View view) {
        if (g(view)) {
            b(i, ((LayoutParams) view.getLayoutParams()).a);
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a " + "drawer with appropriate layout_gravity");
    }

    public void a(int i, CharSequence charSequence) {
        int a = C0198v.a(i, C0151az.j(this));
        if (a == 3) {
            this.N = charSequence;
        } else if (a == 5) {
            this.O = charSequence;
        }
    }

    public void a(Drawable drawable) {
        this.M = drawable;
    }

    public void a(Drawable drawable, int i) {
        int a = C0198v.a(i, C0151az.j(this));
        if ((a & 3) == 3) {
            this.K = drawable;
            invalidate();
        }
        if ((a & 5) == 5) {
            this.L = drawable;
            invalidate();
        }
    }

    public void a(u uVar) {
        this.H = uVar;
    }

    void a(View view, float f) {
        if (this.H != null) {
            this.H.a(view, f);
        }
    }

    public void a(Object obj, boolean z) {
        this.P = obj;
        this.Q = z;
        boolean z2 = (z || getBackground() != null) ? m : n;
        setWillNotDraw(z2);
        requestLayout();
    }

    void a(boolean z) {
        int childCount = getChildCount();
        int i = d;
        for (int i2 = d; i2 < childCount; i2 += e) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (g(childAt) && (!z || layoutParams.c)) {
                i = a(childAt, 3) ? i | this.w.a(childAt, -childAt.getWidth(), childAt.getTop()) : i | this.x.a(childAt, getWidth(), childAt.getTop());
                layoutParams.c = m;
            }
        }
        this.y.a();
        this.z.a();
        if (i != 0) {
            invalidate();
        }
    }

    boolean a(View view, int i) {
        return (e(view) & i) == i ? n : m;
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (a() != null || g(view)) {
            C0151az.d(view, 4);
        } else {
            C0151az.d(view, (int) e);
        }
        if (!q) {
            C0151az.a(view, this.r);
        }
    }

    public void b() {
        a((boolean) m);
    }

    public void b(int i) {
        b(i, 3);
        b(i, 5);
    }

    public void b(int i, int i2) {
        int a = C0198v.a(i2, C0151az.j(this));
        if (a == 3) {
            this.D = i;
        } else if (a == 5) {
            this.E = i;
        }
        if (i != 0) {
            (a == 3 ? this.w : this.x).g();
        }
        View e;
        switch (i) {
            case e /*1*/:
                e = e(a);
                if (e != null) {
                    i(e);
                    return;
                }
                return;
            case f /*2*/:
                e = e(a);
                if (e != null) {
                    h(e);
                    return;
                }
                return;
            default:
                return;
        }
    }

    void b(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.d) {
            layoutParams.d = m;
            if (this.H != null) {
                this.H.b(view);
            }
            a(view, (boolean) m);
            if (hasWindowFocus()) {
                View rootView = getRootView();
                if (rootView != null) {
                    rootView.sendAccessibilityEvent(32);
                }
            }
        }
    }

    void b(View view, float f) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f != layoutParams.b) {
            layoutParams.b = f;
            a(view, f);
        }
    }

    public int c(int i) {
        int a = C0198v.a(i, C0151az.j(this));
        return a == 3 ? this.D : a == 5 ? this.E : d;
    }

    void c() {
        int i = d;
        if (!this.G) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, d);
            int childCount = getChildCount();
            while (i < childCount) {
                getChildAt(i).dispatchTouchEvent(obtain);
                i += e;
            }
            obtain.recycle();
            this.G = n;
        }
    }

    void c(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.d) {
            layoutParams.d = n;
            if (this.H != null) {
                this.H.a(view);
            }
            a(view, (boolean) n);
            view.requestFocus();
        }
    }

    void c(View view, float f) {
        float d = d(view);
        int width = view.getWidth();
        int i = ((int) (((float) width) * f)) - ((int) (d * ((float) width)));
        if (!a(view, 3)) {
            i = -i;
        }
        view.offsetLeftAndRight(i);
        b(view, f);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return ((layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams)) ? n : m;
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = d; i < childCount; i += e) {
            f = Math.max(f, ((LayoutParams) getChildAt(i).getLayoutParams()).b);
        }
        this.u = f;
        if ((this.w.a((boolean) n) | this.x.a((boolean) n)) != 0) {
            C0151az.d(this);
        }
    }

    float d(View view) {
        return ((LayoutParams) view.getLayoutParams()).b;
    }

    @r
    public CharSequence d(int i) {
        int a = C0198v.a(i, C0151az.j(this));
        return a == 3 ? this.N : a == 5 ? this.O : null;
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        int i;
        int height = getHeight();
        boolean f = f(view);
        int i2 = d;
        int width = getWidth();
        int save = canvas.save();
        if (f) {
            int childCount = getChildCount();
            int i3 = d;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                if (childAt != view && childAt.getVisibility() == 0 && m(childAt) && g(childAt)) {
                    if (childAt.getHeight() < height) {
                        i = width;
                    } else if (a(childAt, 3)) {
                        i = childAt.getRight();
                        if (i <= i2) {
                            i = i2;
                        }
                        i2 = i;
                        i = width;
                    } else {
                        i = childAt.getLeft();
                        if (i < width) {
                        }
                    }
                    i3 += e;
                    width = i;
                }
                i = width;
                i3 += e;
                width = i;
            }
            canvas.clipRect(i2, d, width, getHeight());
        }
        i = width;
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        if (this.u > 0.0f && f) {
            this.v.setColor((((int) (((float) ((this.t & C0151az.s) >>> 24)) * this.u)) << 24) | (this.t & C0151az.r));
            canvas.drawRect((float) i2, 0.0f, (float) i, (float) getHeight(), this.v);
        } else if (this.K != null && a(view, 3)) {
            i = this.K.getIntrinsicWidth();
            i2 = view.getRight();
            r2 = Math.max(0.0f, Math.min(((float) i2) / ((float) this.w.c()), o));
            this.K.setBounds(i2, view.getTop(), i + i2, view.getBottom());
            this.K.setAlpha((int) (255.0f * r2));
            this.K.draw(canvas);
        } else if (this.L != null && a(view, 5)) {
            i = this.L.getIntrinsicWidth();
            i2 = view.getLeft();
            r2 = Math.max(0.0f, Math.min(((float) (getWidth() - i2)) / ((float) this.x.c()), o));
            this.L.setBounds(i2 - i, view.getTop(), i2, view.getBottom());
            this.L.setAlpha((int) (255.0f * r2));
            this.L.draw(canvas);
        }
        return drawChild;
    }

    int e(View view) {
        return C0198v.a(((LayoutParams) view.getLayoutParams()).a, C0151az.j(this));
    }

    View e(int i) {
        int a = C0198v.a(i, C0151az.j(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = d; i2 < childCount; i2 += e) {
            View childAt = getChildAt(i2);
            if ((e(childAt) & 7) == a) {
                return childAt;
            }
        }
        return null;
    }

    boolean f(View view) {
        return ((LayoutParams) view.getLayoutParams()).a == 0 ? n : m;
    }

    public void g(int i) {
        this.M = i != 0 ? c.a(getContext(), i) : null;
    }

    boolean g(View view) {
        return (C0198v.a(((LayoutParams) view.getLayoutParams()).a, C0151az.j(view)) & 7) != 0 ? n : m;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof MarginLayoutParams ? new LayoutParams((MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public void h(int i) {
        this.M = new ColorDrawable(i);
    }

    public void h(View view) {
        if (g(view)) {
            if (this.C) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                layoutParams.b = o;
                layoutParams.d = n;
                a(view, (boolean) n);
            } else if (a(view, 3)) {
                this.w.a(view, (int) d, view.getTop());
            } else {
                this.x.a(view, getWidth() - view.getWidth(), view.getTop());
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public void i(int i) {
        View e = e(i);
        if (e == null) {
            throw new IllegalArgumentException("No drawer view found with gravity " + f(i));
        }
        h(e);
    }

    public void i(View view) {
        if (g(view)) {
            if (this.C) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                layoutParams.b = 0.0f;
                layoutParams.d = m;
            } else if (a(view, 3)) {
                this.w.a(view, -view.getWidth(), view.getTop());
            } else {
                this.x.a(view, getWidth(), view.getTop());
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public void j(int i) {
        View e = e(i);
        if (e == null) {
            throw new IllegalArgumentException("No drawer view found with gravity " + f(i));
        }
        i(e);
    }

    public boolean j(View view) {
        if (g(view)) {
            return ((LayoutParams) view.getLayoutParams()).d;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public boolean k(int i) {
        View e = e(i);
        return e != null ? j(e) : m;
    }

    public boolean k(View view) {
        if (g(view)) {
            return ((LayoutParams) view.getLayoutParams()).b > 0.0f ? n : m;
        } else {
            throw new IllegalArgumentException("View " + view + " is not a drawer");
        }
    }

    public boolean l(int i) {
        View e = e(i);
        return e != null ? k(e) : m;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.C = n;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.C = n;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.Q && this.M != null) {
            int a = g.a(this.P);
            if (a > 0) {
                this.M.setBounds(d, d, getWidth(), a);
                this.M.draw(canvas);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
        r7 = this;
        r1 = 1;
        r2 = 0;
        r0 = android.support.v4.view.Y.a(r8);
        r3 = r7.w;
        r3 = r3.a(r8);
        r4 = r7.x;
        r4 = r4.a(r8);
        r3 = r3 | r4;
        switch(r0) {
            case 0: goto L_0x0027;
            case 1: goto L_0x0065;
            case 2: goto L_0x0050;
            case 3: goto L_0x0065;
            default: goto L_0x0016;
        };
    L_0x0016:
        r0 = r2;
    L_0x0017:
        if (r3 != 0) goto L_0x0025;
    L_0x0019:
        if (r0 != 0) goto L_0x0025;
    L_0x001b:
        r0 = r7.f();
        if (r0 != 0) goto L_0x0025;
    L_0x0021:
        r0 = r7.G;
        if (r0 == 0) goto L_0x0026;
    L_0x0025:
        r2 = r1;
    L_0x0026:
        return r2;
    L_0x0027:
        r0 = r8.getX();
        r4 = r8.getY();
        r7.I = r0;
        r7.J = r4;
        r5 = r7.u;
        r6 = 0;
        r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1));
        if (r5 <= 0) goto L_0x006d;
    L_0x003a:
        r5 = r7.w;
        r0 = (int) r0;
        r4 = (int) r4;
        r0 = r5.e(r0, r4);
        if (r0 == 0) goto L_0x006d;
    L_0x0044:
        r0 = r7.f(r0);
        if (r0 == 0) goto L_0x006d;
    L_0x004a:
        r0 = r1;
    L_0x004b:
        r7.F = r2;
        r7.G = r2;
        goto L_0x0017;
    L_0x0050:
        r0 = r7.w;
        r4 = 3;
        r0 = r0.d(r4);
        if (r0 == 0) goto L_0x0016;
    L_0x0059:
        r0 = r7.y;
        r0.a();
        r0 = r7.z;
        r0.a();
        r0 = r2;
        goto L_0x0017;
    L_0x0065:
        r7.a(r1);
        r7.F = r2;
        r7.G = r2;
        goto L_0x0016;
    L_0x006d:
        r0 = r2;
        goto L_0x004b;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !g()) {
            return super.onKeyDown(i, keyEvent);
        }
        A.b(keyEvent);
        return n;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View h = h();
        if (h != null && a(h) == 0) {
            b();
        }
        return h != null ? n : m;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.B = n;
        int i5 = i3 - i;
        int childCount = getChildCount();
        for (int i6 = d; i6 < childCount; i6 += e) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (f(childAt)) {
                    childAt.layout(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.leftMargin + childAt.getMeasuredWidth(), layoutParams.topMargin + childAt.getMeasuredHeight());
                } else {
                    int i7;
                    float f;
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a(childAt, 3)) {
                        i7 = ((int) (((float) measuredWidth) * layoutParams.b)) + (-measuredWidth);
                        f = ((float) (measuredWidth + i7)) / ((float) measuredWidth);
                    } else {
                        i7 = i5 - ((int) (((float) measuredWidth) * layoutParams.b));
                        f = ((float) (i5 - i7)) / ((float) measuredWidth);
                    }
                    Object obj = f != layoutParams.b ? e : null;
                    int i8;
                    switch (layoutParams.a & 112) {
                        case a.bp /*16*/:
                            int i9 = i4 - i2;
                            i8 = (i9 - measuredHeight) / f;
                            if (i8 < layoutParams.topMargin) {
                                i8 = layoutParams.topMargin;
                            } else if (i8 + measuredHeight > i9 - layoutParams.bottomMargin) {
                                i8 = (i9 - layoutParams.bottomMargin) - measuredHeight;
                            }
                            childAt.layout(i7, i8, measuredWidth + i7, measuredHeight + i8);
                            break;
                        case cn.com.smartdevices.bracelet.gps.c.a.h /*80*/:
                            i8 = i4 - i2;
                            childAt.layout(i7, (i8 - layoutParams.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i7, i8 - layoutParams.bottomMargin);
                            break;
                        default:
                            childAt.layout(i7, layoutParams.topMargin, measuredWidth + i7, measuredHeight + layoutParams.topMargin);
                            break;
                    }
                    if (obj != null) {
                        b(childAt, f);
                    }
                    int i10 = layoutParams.b > 0.0f ? d : 4;
                    if (childAt.getVisibility() != i10) {
                        childAt.setVisibility(i10);
                    }
                }
            }
        }
        this.B = m;
        this.C = m;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onMeasure(int r14, int r15) {
        /*
        r13 = this;
        r1 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        r7 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r4 = 0;
        r12 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r3 = android.view.View.MeasureSpec.getMode(r14);
        r5 = android.view.View.MeasureSpec.getMode(r15);
        r2 = android.view.View.MeasureSpec.getSize(r14);
        r0 = android.view.View.MeasureSpec.getSize(r15);
        if (r3 != r12) goto L_0x001b;
    L_0x0019:
        if (r5 == r12) goto L_0x0056;
    L_0x001b:
        r6 = r13.isInEditMode();
        if (r6 == 0) goto L_0x0058;
    L_0x0021:
        if (r3 != r7) goto L_0x0050;
    L_0x0023:
        if (r5 != r7) goto L_0x0054;
    L_0x0025:
        r1 = r0;
    L_0x0026:
        r13.setMeasuredDimension(r2, r1);
        r0 = r13.P;
        if (r0 == 0) goto L_0x0060;
    L_0x002d:
        r0 = android.support.v4.view.C0151az.N(r13);
        if (r0 == 0) goto L_0x0060;
    L_0x0033:
        r0 = 1;
        r3 = r0;
    L_0x0035:
        r6 = android.support.v4.view.C0151az.j(r13);
        r7 = r13.getChildCount();
        r5 = r4;
    L_0x003e:
        if (r5 >= r7) goto L_0x0138;
    L_0x0040:
        r8 = r13.getChildAt(r5);
        r0 = r8.getVisibility();
        r9 = 8;
        if (r0 != r9) goto L_0x0062;
    L_0x004c:
        r0 = r5 + 1;
        r5 = r0;
        goto L_0x003e;
    L_0x0050:
        if (r3 != 0) goto L_0x0023;
    L_0x0052:
        r2 = r1;
        goto L_0x0023;
    L_0x0054:
        if (r5 == 0) goto L_0x0026;
    L_0x0056:
        r1 = r0;
        goto L_0x0026;
    L_0x0058:
        r0 = new java.lang.IllegalArgumentException;
        r1 = "DrawerLayout must be measured with MeasureSpec.EXACTLY.";
        r0.<init>(r1);
        throw r0;
    L_0x0060:
        r3 = r4;
        goto L_0x0035;
    L_0x0062:
        r0 = r8.getLayoutParams();
        r0 = (android.support.v4.widget.DrawerLayout.LayoutParams) r0;
        if (r3 == 0) goto L_0x007d;
    L_0x006a:
        r9 = r0.a;
        r9 = android.support.v4.view.C0198v.a(r9, r6);
        r10 = android.support.v4.view.C0151az.N(r8);
        if (r10 == 0) goto L_0x009e;
    L_0x0076:
        r10 = g;
        r11 = r13.P;
        r10.a(r8, r11, r9);
    L_0x007d:
        r9 = r13.f(r8);
        if (r9 == 0) goto L_0x00a6;
    L_0x0083:
        r9 = r0.leftMargin;
        r9 = r2 - r9;
        r10 = r0.rightMargin;
        r9 = r9 - r10;
        r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r12);
        r10 = r0.topMargin;
        r10 = r1 - r10;
        r0 = r0.bottomMargin;
        r0 = r10 - r0;
        r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r12);
        r8.measure(r9, r0);
        goto L_0x004c;
    L_0x009e:
        r10 = g;
        r11 = r13.P;
        r10.a(r0, r11, r9);
        goto L_0x007d;
    L_0x00a6:
        r9 = r13.g(r8);
        if (r9 == 0) goto L_0x0109;
    L_0x00ac:
        r9 = r13.e(r8);
        r9 = r9 & 7;
        r10 = r4 & r9;
        if (r10 == 0) goto L_0x00eb;
    L_0x00b6:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Child drawer has absolute gravity ";
        r1 = r1.append(r2);
        r2 = f(r9);
        r1 = r1.append(r2);
        r2 = " but this ";
        r1 = r1.append(r2);
        r2 = "DrawerLayout";
        r1 = r1.append(r2);
        r2 = " already has a ";
        r1 = r1.append(r2);
        r2 = "drawer view along that edge";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x00eb:
        r9 = r13.s;
        r10 = r0.leftMargin;
        r9 = r9 + r10;
        r10 = r0.rightMargin;
        r9 = r9 + r10;
        r10 = r0.width;
        r9 = getChildMeasureSpec(r14, r9, r10);
        r10 = r0.topMargin;
        r11 = r0.bottomMargin;
        r10 = r10 + r11;
        r0 = r0.height;
        r0 = getChildMeasureSpec(r15, r10, r0);
        r8.measure(r9, r0);
        goto L_0x004c;
    L_0x0109:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Child ";
        r1 = r1.append(r2);
        r1 = r1.append(r8);
        r2 = " at index ";
        r1 = r1.append(r2);
        r1 = r1.append(r5);
        r2 = " does not have a valid layout_gravity - must be Gravity.LEFT, ";
        r1 = r1.append(r2);
        r2 = "Gravity.RIGHT or Gravity.NO_GRAVITY";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0138:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.DrawerLayout.onMeasure(int, int):void");
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.a != 0) {
            View e = e(savedState.a);
            if (e != null) {
                h(e);
            }
        }
        b(savedState.b, 3);
        b(savedState.c, 5);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        View a = a();
        if (a != null) {
            savedState.a = ((LayoutParams) a.getLayoutParams()).a;
        }
        savedState.b = this.D;
        savedState.c = this.E;
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.w.b(motionEvent);
        this.x.b(motionEvent);
        float x;
        float y;
        switch (motionEvent.getAction() & HeartRateInfo.HR_EMPTY_VALUE) {
            case d /*0*/:
                x = motionEvent.getX();
                y = motionEvent.getY();
                this.I = x;
                this.J = y;
                this.F = m;
                this.G = m;
                break;
            case e /*1*/:
                boolean z;
                x = motionEvent.getX();
                y = motionEvent.getY();
                View e = this.w.e((int) x, (int) y);
                if (e != null && f(e)) {
                    x -= this.I;
                    y -= this.J;
                    int f = this.w.f();
                    if ((x * x) + (y * y) < ((float) (f * f))) {
                        View a = a();
                        if (a != null) {
                            z = a(a) == f ? n : m;
                            a(z);
                            this.F = m;
                            break;
                        }
                    }
                }
                z = n;
                a(z);
                this.F = m;
            case a.l /*3*/:
                a((boolean) n);
                this.F = m;
                this.G = m;
                break;
        }
        return n;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.F = z;
        if (z) {
            a((boolean) n);
        }
    }

    public void requestLayout() {
        if (!this.B) {
            super.requestLayout();
        }
    }
}
