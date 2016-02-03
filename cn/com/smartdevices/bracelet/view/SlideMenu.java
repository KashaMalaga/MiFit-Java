package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.C0151az;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import cn.com.smartdevices.bracelet.push.MiPushMessageReceiver;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.xiaomi.account.openauth.h;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.t;
import kankan.wheel.widget.a;

public class SlideMenu extends ViewGroup {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 1;
    public static final int d = 2;
    public static final int e = 1;
    public static final int f = 2;
    public static final int g = 4;
    public static final int h = 8;
    public static final int i = 16;
    public static final int j = 6;
    public static final Interpolator k = new K();
    private static final int l = 500;
    private static int m = 0;
    private static final int n = -1;
    private static final int o = 0;
    private static final int p = 1;
    private int A;
    private boolean B;
    private Rect C;
    @ExportedProperty
    private Drawable D;
    @ExportedProperty
    private Drawable E;
    @ExportedProperty
    private float F;
    @ExportedProperty
    private float G;
    private int H;
    private boolean I;
    private int J;
    private boolean K;
    private int L;
    private Rect M;
    private boolean N;
    private int O;
    private int P;
    private M Q;
    private L R;
    private VelocityTracker S;
    private Scroller T;
    private Interpolator U;
    private int q;
    private int r;
    private View s;
    private View t;
    private View u;
    private int v;
    private float w;
    private float x;
    private volatile int y;
    private int z;

    public class LayoutParams extends MarginLayoutParams {
        public static final int a = 0;
        public static final int b = 1;
        public static final int c = 2;
        public int d;

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(int i, int i2, int i3) {
            super(i, i2);
            this.d = i3;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.SlideMenu_Layout, a, a);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = a; i < indexCount; i += b) {
                switch (obtainStyledAttributes.getIndex(i)) {
                    case a /*0*/:
                        this.d = obtainStyledAttributes.getInt(a, SlideMenu.n);
                        break;
                    default:
                        break;
                }
            }
            switch (this.d) {
                case a /*0*/:
                    this.width = SlideMenu.n;
                    this.height = SlideMenu.n;
                    break;
                case b /*1*/:
                case c /*2*/:
                    break;
                default:
                    throw new IllegalArgumentException("You must specified a layout_role for this view");
            }
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            if (layoutParams instanceof LayoutParams) {
                this.d = ((LayoutParams) layoutParams).d;
            }
        }
    }

    public class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new N();
        public float a;
        public float b;
        public int c;
        public int d;
        public int e;
        public int f;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readFloat();
            this.b = parcel.readFloat();
            this.c = parcel.readInt();
            this.d = parcel.readInt();
            this.e = parcel.readInt();
            this.f = parcel.readInt();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.a);
            parcel.writeFloat(this.b);
            parcel.writeInt(this.c);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e);
            parcel.writeInt(this.f);
        }
    }

    public SlideMenu(Context context) {
        this(context, null);
    }

    public SlideMenu(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.slideMenuStyle);
    }

    public SlideMenu(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.J = f;
        this.K = true;
        this.v = ViewConfiguration.get(context).getScaledTouchSlop();
        this.S = VelocityTracker.obtain();
        this.C = new Rect();
        this.M = new Rect();
        m = (int) b(context);
        setWillNotDraw(false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.SlideMenu, i, o);
        a(obtainStyledAttributes.getDimension(o, BitmapDescriptorFactory.HUE_ORANGE));
        b(obtainStyledAttributes.getDimension(p, BitmapDescriptorFactory.HUE_ORANGE));
        Drawable drawable = obtainStyledAttributes.getDrawable(f);
        if (drawable == null) {
            Orientation orientation = Orientation.LEFT_RIGHT;
            int[] iArr = new int[f];
            iArr[o] = o;
            iArr[p] = Color.argb(99, o, o, o);
            drawable = new GradientDrawable(orientation, iArr);
        }
        a(drawable);
        drawable = obtainStyledAttributes.getDrawable(3);
        if (drawable == null) {
            orientation = Orientation.LEFT_RIGHT;
            iArr = new int[f];
            iArr[o] = Color.argb(99, o, o, o);
            iArr[p] = o;
            drawable = new GradientDrawable(orientation, iArr);
        }
        b(drawable);
        int resourceId = obtainStyledAttributes.getResourceId(7, n);
        a(n == resourceId ? k : AnimationUtils.loadInterpolator(context, resourceId));
        this.H = obtainStyledAttributes.getInt(j, 3);
        a(obtainStyledAttributes.getBoolean(g, false));
        b(obtainStyledAttributes.getDimensionPixelSize(5, 100));
        obtainStyledAttributes.recycle();
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    private void a(Canvas canvas) {
        if (this.s != null) {
            int left = this.s.getLeft();
            int i = this.O;
            int i2 = this.P;
            if (this.D != null) {
                this.D.setBounds((int) (((float) left) - this.F), o, left, i2);
                this.D.draw(canvas);
            }
            if (this.E != null) {
                this.E.setBounds(left + i, o, (int) (((float) (left + i)) + this.G), i2);
                this.E.draw(canvas);
            }
        }
    }

    public static void a(View view) {
        if (view != null) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
        }
    }

    private void a(View view, int i) {
        if (view != null && view.getVisibility() != i) {
            view.setVisibility(i);
        }
    }

    public static float b(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", MiPushMessageReceiver.ANDROID);
        return identifier != 0 ? resources.getDimension(identifier) : 0.0f;
    }

    private boolean c(float f, float f2) {
        View view = this.s;
        if (view == null) {
            return false;
        }
        view.getHitRect(this.C);
        return this.C.contains((int) f, (int) f2);
    }

    private boolean d(float f, float f2) {
        Rect rect = this.M;
        boolean z = false;
        if (this.t != null) {
            getHitRect(rect);
            rect.right = this.L;
            z = false | rect.contains((int) f, (int) f2);
        }
        if (this.u == null) {
            return z;
        }
        getHitRect(rect);
        rect.left = rect.right - this.L;
        return z | rect.contains((int) f, (int) f2);
    }

    private void f(int i) {
        int i2 = o;
        int i3 = this.H;
        int i4 = (i3 & f) == f ? this.A : o;
        if ((i3 & p) == p) {
            i2 = this.z;
        }
        i4 = Math.min(i4, Math.max(i, i2));
        this.y = i4;
        if (this.Q != null) {
            float f = 0.0f;
            if (i4 > 0) {
                f = (((float) i4) * 1.0f) / ((float) this.A);
            } else if (i4 < 0) {
                f = (((float) (-i4)) * 1.0f) / ((float) this.z);
            }
            this.Q.a(f);
        }
        r();
        invalidate();
        requestLayout();
    }

    private void r() {
        int i = this.y < 0 ? n : this.y == 0 ? o : p;
        this.q = i;
        switch (this.q) {
            case n /*-1*/:
                a(this.t, (int) g);
                a(this.u, (int) o);
                return;
            case o /*0*/:
                a(this.t, (int) g);
                a(this.u, (int) g);
                return;
            case p /*1*/:
                a(this.t, (int) o);
                a(this.u, (int) g);
                return;
            default:
                return;
        }
    }

    private boolean s() {
        View view = (View) getParent();
        return view != null && 16908290 == view.getId() && f == this.J && getRootView() == view && p == this.J;
    }

    protected Drawable a(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16842836, typedValue, true);
        return context.getResources().getDrawable(typedValue.resourceId);
    }

    protected void a() {
        ViewGroup viewGroup = (ViewGroup) getRootView();
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(16908290);
        View view = this.s;
        if (viewGroup != null && view != null && getChildCount() != 0) {
            TypedValue typedValue = new TypedValue();
            getContext().getTheme().resolveAttribute(16842836, typedValue, true);
            switch (this.J) {
                case p /*1*/:
                    a((View) this);
                    android.view.ViewGroup.LayoutParams layoutParams = new LayoutParams(view.getLayoutParams());
                    a(view);
                    viewGroup2.addView(view);
                    View childAt = viewGroup.getChildAt(o);
                    childAt.setBackgroundResource(o);
                    a(childAt);
                    addView(childAt, layoutParams);
                    viewGroup.addView(this);
                    setBackgroundResource(typedValue.resourceId);
                    return;
                case f /*2*/:
                    setBackgroundResource(o);
                    a((View) this);
                    View childAt2 = viewGroup2.getChildAt(o);
                    View view2 = this.s;
                    LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
                    a(childAt2);
                    a(view2);
                    view2.setBackgroundResource(typedValue.resourceId);
                    viewGroup.addView(view2);
                    viewGroup2.addView(this);
                    addView(childAt2, layoutParams2);
                    return;
                default:
                    return;
            }
        }
    }

    public void a(float f) {
        this.F = f;
        invalidate();
    }

    protected void a(float f, float f2) {
        this.y += (int) (f2 - f);
        f(this.y);
    }

    public void a(int i) {
        if (s()) {
            throw new IllegalStateException("SlidingMenu must be the root of layout");
        } else if (this.J != i) {
            this.J = i;
            if (getChildCount() == 0) {
                this.I = true;
            } else {
                a();
            }
        }
    }

    public void a(int i, float f) {
        d(i);
        int i2 = i - this.y;
        float abs = Math.abs(f);
        int i3 = 400;
        if (abs > 0.0f) {
            i3 = Math.round(1000.0f * Math.abs(((float) i2) / abs)) * 3;
        }
        int min = Math.min(i3, l);
        this.T.abortAnimation();
        this.T.startScroll(this.y, o, i2, o, min);
        invalidate();
    }

    public void a(Drawable drawable) {
        this.D = drawable;
    }

    public void a(Interpolator interpolator) {
        this.U = interpolator;
        this.T = new Scroller(getContext(), interpolator);
    }

    public void a(L l) {
        this.R = l;
    }

    public void a(M m) {
        this.Q = m;
    }

    public void a(boolean z) {
        this.K = z;
    }

    public void a(boolean z, boolean z2) {
        if (!h()) {
            int i = z ? this.z : this.A;
            if (z2) {
                e(i);
                return;
            }
            this.T.abortAnimation();
            f(i);
            d(z ? f : g);
        }
    }

    protected final boolean a(View view, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            int childCount = viewGroup.getChildCount();
            for (int i4 = o; i4 < childCount; i4 += p) {
                View childAt = viewGroup.getChildAt(i4);
                int left = childAt.getLeft();
                int top = childAt.getTop();
                if (i2 + scrollX >= left && i2 + scrollX < childAt.getRight() && i3 + scrollY >= top && i3 + scrollY < childAt.getBottom() && childAt.getVisibility() == 0 && (D.a(childAt, i) || a(childAt, i, (i2 + scrollX) - left, (i3 + scrollY) - top))) {
                    return true;
                }
            }
        }
        return C0151az.a(view, -i);
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        if (!(layoutParams instanceof LayoutParams)) {
            throw new IllegalArgumentException("The parameter params must a instance of com.aretha.slidemenu.SlideMenu$LayoutParams");
        } else if (layoutParams != null) {
            switch (((LayoutParams) layoutParams).d) {
                case o /*0*/:
                    removeView(this.s);
                    this.s = view;
                    break;
                case p /*1*/:
                    removeView(this.t);
                    this.t = view;
                    break;
                case f /*2*/:
                    removeView(this.u);
                    this.u = view;
                    break;
                default:
                    return;
            }
            r();
            super.addView(view, i, layoutParams);
        }
    }

    public Interpolator b() {
        return this.U;
    }

    public void b(float f) {
        this.G = f;
        invalidate();
    }

    protected void b(float f, float f2) {
        int i = this.y;
        int i2 = this.q;
        i = Math.abs(f2) > a.bP ? p : o;
        switch (i2) {
            case n /*-1*/:
                if ((f2 < 0.0f && i != 0) || (f2 >= 0.0f && i == 0)) {
                    a(this.z, f2);
                    return;
                } else if ((f2 > 0.0f && i != 0) || (f2 <= 0.0f && i == 0)) {
                    a((int) o, f2);
                    return;
                } else {
                    return;
                }
            case o /*0*/:
                d(p);
                return;
            case p /*1*/:
                if ((f2 > 0.0f && i != 0) || (f2 <= 0.0f && i == 0)) {
                    a(this.A, f2);
                    return;
                } else if ((f2 < 0.0f && i != 0) || (f2 >= 0.0f && i == 0)) {
                    a((int) o, f2);
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void b(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Edge slide width must above 0");
        }
        this.L = i;
    }

    public void b(Drawable drawable) {
        this.E = drawable;
    }

    public void b(boolean z) {
        if (p != this.r) {
            if (z) {
                e(o);
                return;
            }
            this.T.abortAnimation();
            f(o);
            d(p);
        }
    }

    public Drawable c() {
        return this.D;
    }

    public void c(int i) {
        this.H = i;
    }

    public void computeScroll() {
        if (i != this.r && !h()) {
            return;
        }
        if (this.T.computeScrollOffset()) {
            f(this.T.getCurrX());
            return;
        }
        int i = this.y == 0 ? p : this.y > 0 ? f : g;
        d(i);
    }

    public Drawable d() {
        return this.E;
    }

    protected void d(int i) {
        if (!(this.Q == null || i == this.r)) {
            this.Q.a(i);
        }
        this.r = i;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (p == keyEvent.getAction()) {
            boolean h = h();
            switch (keyEvent.getKeyCode()) {
                case g /*4*/:
                    if (h) {
                        b(true);
                        return true;
                    }
                    break;
                case com.xiaomi.hm.health.bt.profile.a.a.Z /*21*/:
                    if (f == this.r) {
                        b(true);
                        return true;
                    } else if (!h) {
                        a(true, true);
                        return true;
                    }
                    break;
                case com.xiaomi.hm.health.bt.profile.a.a.aa /*22*/:
                    if (g == this.r) {
                        b(true);
                        return true;
                    } else if (!h) {
                        a(false, true);
                        return true;
                    }
                    break;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        a(canvas);
    }

    public int e() {
        return this.J;
    }

    public void e(int i) {
        a(i, 0.0f);
    }

    public boolean f() {
        return this.K;
    }

    public float g() {
        return (float) this.L;
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public boolean h() {
        return (this.r & j) != 0;
    }

    public int i() {
        return this.H;
    }

    public M j() {
        return this.Q;
    }

    public L k() {
        return this.R;
    }

    public int l() {
        return this.r;
    }

    public View m() {
        return this.t;
    }

    public View n() {
        return this.u;
    }

    public void o() {
        if (h()) {
            e(o);
        } else if (this.R != null) {
            this.R.a(this);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int i = this.r;
        if (h == i || i == i) {
            return true;
        }
        switch (motionEvent.getAction()) {
            case o /*0*/:
                this.x = x;
                this.w = x;
                this.B = c(x, y);
                this.N = d(x, y);
                return h() && this.B;
            case f /*2*/:
                float f = x - this.w;
                if (this.K && !this.N && this.r == p) {
                    return false;
                }
                if (Math.abs(f) >= ((float) this.v) && this.B && !a(this, (int) f, (int) x, (int) y)) {
                    d(h);
                    return true;
                }
                break;
        }
        return false;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int i5 = this.J == p ? m : o;
        for (int i6 = o; i6 < childCount; i6 += p) {
            View childAt = getChildAt(i6);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            switch (((LayoutParams) childAt.getLayoutParams()).d) {
                case o /*0*/:
                    childAt.bringToFront();
                    childAt.layout(this.y + paddingLeft, paddingTop, (measuredWidth + paddingLeft) + this.y, measuredHeight + paddingTop);
                    break;
                case p /*1*/:
                    this.A = measuredWidth;
                    childAt.layout(paddingLeft, i5 + paddingTop, measuredWidth + paddingLeft, measuredHeight + (i5 + paddingTop));
                    break;
                case f /*2*/:
                    this.z = -measuredWidth;
                    childAt.layout((i3 - paddingRight) - measuredWidth, i5 + paddingTop, i3 - paddingRight, measuredHeight + (i5 + paddingTop));
                    break;
                default:
                    break;
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        int childCount = getChildCount();
        int i3 = this.J;
        int i4 = m;
        int i5 = o;
        int i6 = o;
        for (int i7 = o; i7 < childCount; i7 += p) {
            View childAt = getChildAt(i7);
            switch (((LayoutParams) childAt.getLayoutParams()).d) {
                case o /*0*/:
                    measureChild(childAt, i, i2);
                    break;
                case p /*1*/:
                case f /*2*/:
                    measureChild(childAt, i, i3 == p ? MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i2) - i4, MeasureSpec.getMode(i2)) : i2);
                    break;
                default:
                    break;
            }
            i6 = Math.max(i6, childAt.getMeasuredWidth());
            i5 = Math.max(i5, childAt.getMeasuredHeight());
        }
        setMeasuredDimension(resolveSize((getPaddingLeft() + getPaddingRight()) + i6, i), resolveSize((getPaddingTop() + getPaddingBottom()) + i5, i2));
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.F = savedState.a;
        this.G = savedState.b;
        this.H = savedState.c;
        a(savedState.d);
        this.r = savedState.e;
        this.y = savedState.f;
        r();
        requestLayout();
        invalidate();
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.F;
        savedState.b = this.G;
        savedState.c = this.H;
        savedState.d = this.J;
        savedState.e = this.r;
        savedState.f = this.y;
        return savedState;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.O = i;
        this.P = i2;
        if (this.I) {
            a();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int i = this.r;
        int action = motionEvent.getAction();
        switch (action) {
            case o /*0*/:
                this.x = x;
                this.w = x;
                this.B = c(x, y);
                this.N = d(x, y);
                if (this.B) {
                    this.T.abortAnimation();
                    break;
                }
                break;
            case p /*1*/:
            case a.l /*3*/:
            case g /*4*/:
                if (h == i) {
                    this.S.computeCurrentVelocity(h.E);
                    b(x, this.S.getXVelocity());
                } else if (this.B && p == action) {
                    o();
                }
                this.S.clear();
                getParent().requestDisallowInterceptTouchEvent(false);
                this.N = false;
                this.B = false;
                break;
            case f /*2*/:
                this.S.addMovement(motionEvent);
                if (!this.K || this.N || this.r != p) {
                    if (Math.abs(x - this.w) >= ((float) this.v) && this.B && i != h) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        d(h);
                    }
                    if (h == i) {
                        a(this.x, x);
                        this.x = x;
                        break;
                    }
                    this.x = x;
                    return false;
                }
                return false;
        }
        return true;
    }

    public float p() {
        return this.F;
    }

    public float q() {
        return this.G;
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
