package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.g.e;
import android.support.v4.media.h;
import android.support.v4.view.A;
import android.support.v4.view.C0146au;
import android.support.v4.view.C0151az;
import android.support.v4.view.Y;
import android.support.v4.view.a.C0099a;
import android.support.v4.view.aZ;
import android.support.v4.view.ae;
import android.support.v4.widget.F;
import android.support.v7.widget.af;
import android.util.AttributeSet;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Constant;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.edmodo.cropper.cropwindow.CropOverlayView;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import kankan.wheel.widget.a;

public class VerticalViewPager extends ViewGroup {
    private static final int M = -1;
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    private static final String d = "VerticalViewPager";
    private static final boolean e = false;
    private static final boolean f = false;
    private static final int g = 1;
    private static final int h = 600;
    private static final int i = 25;
    private static final int[] j;
    private static final Comparator<S> k = new P();
    private static final Interpolator l = new Q();
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private int E = g;
    private boolean F;
    private boolean G;
    private int H;
    private float I;
    private float J;
    private float K;
    private int L = M;
    private VelocityTracker N;
    private int O;
    private int P;
    private int Q;
    private boolean R;
    private long S;
    private F T;
    private F U;
    private boolean V = true;
    private boolean W;
    private int aa;
    private U ab;
    private U ac;
    private T ad;
    private int ae = a;
    private final ArrayList<S> m = new ArrayList();
    private ae n;
    private int o;
    private int p = M;
    private Parcelable q = null;
    private ClassLoader r = null;
    private Scroller s;
    private V t;
    private int u;
    private Drawable v;
    private int w;
    private int x;
    private int y;
    private int z;

    public class LayoutParams extends android.view.ViewGroup.LayoutParams {
        public boolean a;
        public int b;

        public LayoutParams() {
            super(VerticalViewPager.M, VerticalViewPager.M);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, VerticalViewPager.j);
            this.b = obtainStyledAttributes.getInteger(VerticalViewPager.a, VerticalViewPager.a);
            obtainStyledAttributes.recycle();
        }
    }

    public class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = e.a(new W());
        int a;
        Parcelable b;
        ClassLoader c;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            if (classLoader == null) {
                classLoader = getClass().getClassLoader();
            }
            this.a = parcel.readInt();
            this.b = parcel.readParcelable(classLoader);
            this.c = classLoader;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
            parcel.writeParcelable(this.b, i);
        }
    }

    static {
        int[] iArr = new int[g];
        iArr[a] = 16842931;
        j = iArr;
    }

    public VerticalViewPager(Context context) {
        super(context);
        a();
    }

    public VerticalViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private int a(int i, float f, int i2, int i3) {
        return (Math.abs(i3) <= this.Q || Math.abs(i2) <= this.O) ? (int) ((((float) i) + f) + 0.5f) : i2 > 0 ? i : i + g;
    }

    private void a(int i, int i2, int i3, int i4) {
        int i5 = i + i3;
        if (i2 > 0) {
            int scrollY = getScrollY();
            int i6 = i2 + i4;
            i6 = (int) (((((float) (scrollY % i6)) / ((float) i6)) + ((float) (scrollY / i6))) * ((float) i5));
            scrollTo(getScrollX(), i6);
            if (!this.s.isFinished()) {
                this.s.startScroll(a, i6, i5 * this.o, a, this.s.getDuration() - this.s.timePassed());
                return;
            }
            return;
        }
        scrollY = this.o * i5;
        if (scrollY != getScrollY()) {
            o();
            scrollTo(getScrollX(), scrollY);
        }
    }

    private void a(MotionEvent motionEvent) {
        int b = Y.b(motionEvent);
        if (Y.b(motionEvent, b) == this.L) {
            b = b == 0 ? g : a;
            this.J = Y.d(motionEvent, b);
            this.L = Y.b(motionEvent, b);
            if (this.N != null) {
                this.N.clear();
            }
        }
    }

    private void a(boolean z) {
        if (this.B != z) {
            this.B = z;
        }
    }

    private void f(int i) {
        if (this.ae != i) {
            this.ae = i;
            if (this.ab != null) {
                this.ab.b(i);
            }
        }
    }

    private void g(int i) {
        int height = getHeight() + this.u;
        int i2 = i / height;
        int i3 = i % height;
        float f = ((float) i3) / ((float) height);
        this.W = f;
        a(i2, f, i3);
        if (!this.W) {
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    private void n() {
        int i = a;
        while (i < getChildCount()) {
            if (!((LayoutParams) getChildAt(i).getLayoutParams()).a) {
                removeViewAt(i);
                i += M;
            }
            i += g;
        }
    }

    private void o() {
        int scrollX;
        boolean z = this.D;
        if (z) {
            a((boolean) f);
            this.s.abortAnimation();
            scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.s.getCurrX();
            int currY = this.s.getCurrY();
            if (!(scrollX == currX && scrollY == currY)) {
                scrollTo(currX, currY);
            }
            f(a);
        }
        this.C = f;
        this.D = f;
        boolean z2 = z;
        for (scrollX = a; scrollX < this.m.size(); scrollX += g) {
            S s = (S) this.m.get(scrollX);
            if (s.c) {
                z2 = true;
                s.c = f;
            }
        }
        if (z2) {
            g();
        }
    }

    private void p() {
        this.F = f;
        this.G = f;
        if (this.N != null) {
            this.N.recycle();
            this.N = null;
        }
    }

    float a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    S a(View view) {
        for (int i = a; i < this.m.size(); i += g) {
            S s = (S) this.m.get(i);
            if (this.n.a(view, s.a)) {
                return s;
            }
        }
        return null;
    }

    void a() {
        setWillNotDraw(f);
        setDescendantFocusability(C0099a.l);
        setFocusable(true);
        Context context = getContext();
        this.s = new Scroller(context, l);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.H = aZ.a(viewConfiguration);
        this.O = viewConfiguration.getScaledMinimumFlingVelocity();
        this.P = viewConfiguration.getScaledMaximumFlingVelocity();
        this.T = new F(context);
        this.U = new F(context);
        this.Q = (int) (context.getResources().getDisplayMetrics().density * a.bi);
    }

    public void a(int i) {
        this.C = f;
        a(i, !this.V ? true : f, (boolean) f);
    }

    protected void a(int i, float f, int i2) {
        if (this.aa > 0) {
            int scrollY = getScrollY();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int height = getHeight();
            int childCount = getChildCount();
            int i3 = a;
            while (i3 < childCount) {
                int i4;
                View childAt = getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.a) {
                    int max;
                    switch (layoutParams.b & 112) {
                        case g /*1*/:
                            max = Math.max((height - childAt.getMeasuredHeight()) / c, paddingTop);
                            i4 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i4;
                            break;
                        case Constant.bh /*48*/:
                            max = childAt.getHeight() + paddingTop;
                            i4 = paddingTop;
                            paddingTop = paddingBottom;
                            paddingBottom = max;
                            max = i4;
                            break;
                        case cn.com.smartdevices.bracelet.gps.c.a.h /*80*/:
                            max = (height - paddingBottom) - childAt.getMeasuredHeight();
                            i4 = paddingBottom + childAt.getMeasuredHeight();
                            paddingBottom = paddingTop;
                            paddingTop = i4;
                            break;
                        default:
                            max = paddingTop;
                            i4 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i4;
                            break;
                    }
                    max = (max + scrollY) - childAt.getTop();
                    if (max != 0) {
                        childAt.offsetTopAndBottom(max);
                    }
                } else {
                    i4 = paddingBottom;
                    paddingBottom = paddingTop;
                    paddingTop = i4;
                }
                i3 += g;
                i4 = paddingTop;
                paddingTop = paddingBottom;
                paddingBottom = i4;
            }
        }
        if (this.ab != null) {
            this.ab.a(i, f, i2);
        }
        if (this.ac != null) {
            this.ac.a(i, f, i2);
        }
        this.W = true;
    }

    void a(int i, int i2) {
        a(i, i2, (int) a);
    }

    void a(int i, int i2, int i3) {
        if (getChildCount() == 0) {
            a((boolean) f);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i4 = i - scrollX;
        int i5 = i2 - scrollY;
        if (i4 == 0 && i5 == 0) {
            o();
            f(a);
            return;
        }
        a(true);
        this.D = true;
        f(c);
        int height = getHeight();
        int i6 = height / c;
        float a = (((float) i6) * a(Math.min(1.0f, (((float) Math.abs(i5)) * 1.0f) / ((float) height)))) + ((float) i6);
        int abs = Math.abs(i3);
        this.s.startScroll(scrollX, scrollY, i4, i5, Math.min(abs > 0 ? Math.round(1000.0f * Math.abs(a / ((float) abs))) * 4 : (int) (((((float) Math.abs(i5)) / ((float) (height + this.u))) + 1.0f) * CropOverlayView.a), h));
        invalidate();
    }

    public void a(int i, boolean z) {
        this.C = f;
        a(i, z, (boolean) f);
    }

    void a(int i, boolean z, boolean z2) {
        a(i, z, z2, (int) a);
    }

    void a(int i, boolean z, boolean z2, int i2) {
        if (this.n == null || this.n.b() <= 0) {
            a((boolean) f);
        } else if (z2 || this.o != i || this.m.size() == 0) {
            int i3;
            if (i < 0) {
                i = a;
            } else if (i >= this.n.b()) {
                i = this.n.b() + M;
            }
            int i4 = this.E;
            if (i > this.o + i4 || i < this.o - i4) {
                for (i3 = a; i3 < this.m.size(); i3 += g) {
                    ((S) this.m.get(i3)).c = true;
                }
            }
            boolean z3 = this.o != i ? true : f;
            this.o = i;
            g();
            i3 = (getHeight() + this.u) * i;
            if (z) {
                a((int) a, i3, i2);
                if (z3 && this.ab != null) {
                    this.ab.a(i);
                }
                if (z3 && this.ac != null) {
                    this.ac.a(i);
                    return;
                }
                return;
            }
            if (z3 && this.ab != null) {
                this.ab.a(i);
            }
            if (z3 && this.ac != null) {
                this.ac.a(i);
            }
            o();
            scrollTo(a, i3);
        } else {
            a((boolean) f);
        }
    }

    public void a(Drawable drawable) {
        this.v = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null ? true : f);
        invalidate();
    }

    public void a(ae aeVar) {
        if (this.n != null) {
            this.n.b(this.t);
            this.n.a((ViewGroup) this);
            for (int i = a; i < this.m.size(); i += g) {
                S s = (S) this.m.get(i);
                this.n.a((ViewGroup) this, s.b, s.a);
            }
            this.n.b((ViewGroup) this);
            this.m.clear();
            n();
            this.o = a;
            scrollTo(a, a);
        }
        ae aeVar2 = this.n;
        this.n = aeVar;
        if (this.n != null) {
            if (this.t == null) {
                this.t = new V();
            }
            this.n.a(this.t);
            this.C = f;
            if (this.p >= 0) {
                this.n.a(this.q, this.r);
                a(this.p, (boolean) f, true);
                this.p = M;
                this.q = null;
                this.r = null;
            } else {
                g();
            }
        }
        if (this.ad != null && aeVar2 != aeVar) {
            this.ad.a(aeVar2, aeVar);
        }
    }

    void a(T t) {
        this.ad = t;
    }

    public void a(U u) {
        this.ab = u;
    }

    public boolean a(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return f;
        }
        switch (keyEvent.getKeyCode()) {
            case a.bs /*19*/:
                return e(33);
            case a.aF /*20*/:
                return e(h.k);
            case 61:
                return VERSION.SDK_INT >= 11 ? A.a(keyEvent) ? e(c) : A.a(keyEvent, (int) g) ? e(g) : f : f;
            default:
                return f;
        }
    }

    protected boolean a(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() + M; childCount >= 0; childCount += M) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
                    if (a(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        return (z && C0151az.b(view, -i)) ? true : f;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = a; i3 < getChildCount(); i3 += g) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    S a = a(childAt);
                    if (a != null && a.b == this.o) {
                        childAt.addFocusables(arrayList, i, i2);
                    }
                }
            }
        }
        if ((descendantFocusability == C0099a.l && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i2 & g) != g || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList<View> arrayList) {
        for (int i = a; i < getChildCount(); i += g) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                S a = a(childAt);
                if (a != null && a.b == this.o) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        android.view.ViewGroup.LayoutParams generateLayoutParams = !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : layoutParams;
        LayoutParams layoutParams2 = (LayoutParams) generateLayoutParams;
        layoutParams2.a |= view instanceof R;
        if (!this.A) {
            super.addView(view, i, generateLayoutParams);
        } else if (layoutParams2 == null || !layoutParams2.a) {
            addViewInLayout(view, i, generateLayoutParams);
            view.measure(this.y, this.z);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    public ae b() {
        return this.n;
    }

    S b(View view) {
        while (true) {
            VerticalViewPager parent = view.getParent();
            if (parent == this) {
                return a(view);
            }
            if (parent != null && (parent instanceof View)) {
                view = parent;
            }
        }
        return null;
    }

    U b(U u) {
        U u2 = this.ac;
        this.ac = u;
        return u2;
    }

    public void b(float f) {
        if (this.R) {
            this.J += f;
            float scrollY = ((float) getScrollY()) - f;
            int height = this.u + getHeight();
            float max = (float) Math.max(a, (this.o + M) * height);
            float min = (float) (height * Math.min(this.o + g, this.n.b() + M));
            if (scrollY >= max) {
                max = scrollY > min ? min : scrollY;
            }
            this.J += max - ((float) ((int) max));
            scrollTo(getScrollX(), (int) max);
            g((int) max);
            MotionEvent obtain = MotionEvent.obtain(this.S, SystemClock.uptimeMillis(), c, 0.0f, this.J, a);
            this.N.addMovement(obtain);
            obtain.recycle();
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public void b(int i) {
        if (i < g) {
            C0596r.g(d, "Requested offscreen page limit " + i + " too small; defaulting to " + g);
            i = g;
        }
        if (i != this.E) {
            this.E = i;
            g();
        }
    }

    void b(int i, int i2) {
        S s = new S();
        s.b = i;
        s.a = this.n.a((ViewGroup) this, i);
        if (i2 < 0) {
            this.m.add(s);
        } else {
            this.m.add(i2, s);
        }
    }

    public int c() {
        return this.o;
    }

    public void c(int i) {
        int i2 = this.u;
        this.u = i;
        int height = getHeight();
        a(height, height, i, i2);
        requestLayout();
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return ((layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams)) ? true : f;
    }

    public void computeScroll() {
        if (this.s.isFinished() || !this.s.computeScrollOffset()) {
            o();
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.s.getCurrX();
        int currY = this.s.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            g(currY);
        }
        invalidate();
    }

    public int d() {
        return this.E;
    }

    public void d(int i) {
        a(getContext().getResources().getDrawable(i));
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return (super.dispatchKeyEvent(keyEvent) || a(keyEvent)) ? true : f;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        int childCount = getChildCount();
        for (int i = a; i < childCount; i += g) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                S a = a(childAt);
                if (a != null && a.b == this.o && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return f;
    }

    public void draw(Canvas canvas) {
        int i = g;
        super.draw(canvas);
        int i2 = a;
        int a = C0151az.a(this);
        if (a == 0 || (a == g && this.n != null && this.n.b() > g)) {
            int width;
            if (!this.T.a()) {
                a = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.rotate(0.0f);
                this.T.a(width, getHeight());
                i2 = a | this.T.a(canvas);
                canvas.restoreToCount(a);
            }
            if (!this.U.a()) {
                a = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                int height = getHeight();
                if (this.n != null) {
                    i = this.n.b();
                }
                canvas.rotate(BitmapDescriptorFactory.HUE_CYAN);
                canvas.translate((float) ((-width) + getPaddingLeft()), (float) (((-i) * (this.u + height)) + this.u));
                this.U.a(width, height);
                i2 |= this.U.a(canvas);
                canvas.restoreToCount(a);
            }
        } else {
            this.T.b();
            this.U.b();
        }
        if (i2 != 0) {
            invalidate();
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.v;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    public int e() {
        return this.u;
    }

    public boolean e(int i) {
        boolean k;
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        if (findNextFocus == null || findNextFocus == findFocus) {
            if (i == 33 || i == g) {
                k = k();
            } else {
                if (i == h.k || i == c) {
                    k = l();
                }
                k = f;
            }
        } else if (i == 33) {
            k = (findFocus == null || findNextFocus.getTop() < findFocus.getTop()) ? findNextFocus.requestFocus() : k();
        } else {
            if (i == h.k) {
                k = (findFocus == null || findNextFocus.getTop() > findFocus.getTop()) ? findNextFocus.requestFocus() : l();
            }
            k = f;
        }
        if (k) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return k;
    }

    void f() {
        boolean z = true;
        boolean z2 = (this.m.size() >= 3 || this.m.size() >= this.n.b()) ? f : true;
        int i = a;
        boolean z3 = f;
        int i2 = M;
        boolean z4 = z2;
        while (i < this.m.size()) {
            int i3;
            boolean z5;
            int i4;
            boolean z6;
            S s = (S) this.m.get(i);
            int a = this.n.a(s.a);
            if (a == M) {
                i3 = i;
                z5 = z3;
                i4 = i2;
                z6 = z4;
            } else if (a == -2) {
                this.m.remove(i);
                i += M;
                if (!z3) {
                    this.n.a((ViewGroup) this);
                    z3 = true;
                }
                this.n.a((ViewGroup) this, s.b, s.a);
                if (this.o == s.b) {
                    i3 = i;
                    z5 = z3;
                    i4 = Math.max(a, Math.min(this.o, this.n.b() + M));
                    z6 = true;
                } else {
                    i3 = i;
                    z5 = z3;
                    i4 = i2;
                    z6 = true;
                }
            } else if (s.b != a) {
                if (s.b == this.o) {
                    i2 = a;
                }
                s.b = a;
                i3 = i;
                z5 = z3;
                i4 = i2;
                z6 = true;
            } else {
                i3 = i;
                z5 = z3;
                i4 = i2;
                z6 = z4;
            }
            z4 = z6;
            i2 = i4;
            z3 = z5;
            i = i3 + g;
        }
        if (z3) {
            this.n.b((ViewGroup) this);
        }
        Collections.sort(this.m, k);
        if (i2 >= 0) {
            a(i2, (boolean) f, true);
        } else {
            z = z4;
        }
        if (z) {
            g();
            requestLayout();
        }
    }

    void g() {
        S s = null;
        int i = a;
        if (this.n != null && !this.C && getWindowToken() != null) {
            S s2;
            this.n.a((ViewGroup) this);
            int i2 = this.E;
            int max = Math.max(a, this.o - i2);
            int min = Math.min(this.n.b() + M, i2 + this.o);
            int i3 = a;
            int i4 = M;
            while (i3 < this.m.size()) {
                s2 = (S) this.m.get(i3);
                if ((s2.b < max || s2.b > min) && !s2.c) {
                    this.m.remove(i3);
                    i3 += M;
                    this.n.a((ViewGroup) this, s2.b, s2.a);
                    i4 = i3;
                } else {
                    if (i4 < min && s2.b > max) {
                        i4 += g;
                        if (i4 < max) {
                            i4 = max;
                        }
                        while (i4 <= min && i4 < s2.b) {
                            b(i4, i3);
                            i4 += g;
                            i3 += g;
                        }
                    }
                    i4 = i3;
                }
                i3 = s2.b;
                i2 = i4 + g;
                i4 = i3;
                i3 = i2;
            }
            i2 = this.m.size() > 0 ? ((S) this.m.get(this.m.size() + M)).b : M;
            if (i2 < min) {
                i2 += g;
                if (i2 <= max) {
                    i2 = max;
                }
                while (i2 <= min) {
                    b(i2, M);
                    i2 += g;
                }
            }
            for (i3 = a; i3 < this.m.size(); i3 += g) {
                if (((S) this.m.get(i3)).b == this.o) {
                    s2 = (S) this.m.get(i3);
                    break;
                }
            }
            s2 = null;
            this.n.b((ViewGroup) this, this.o, s2 != null ? s2.a : null);
            this.n.b((ViewGroup) this);
            if (hasFocus()) {
                View findFocus = findFocus();
                if (findFocus != null) {
                    s = b(findFocus);
                }
                if (s == null || s.b != this.o) {
                    while (i < getChildCount()) {
                        findFocus = getChildAt(i);
                        S a = a(findFocus);
                        if (a == null || a.b != this.o || !findFocus.requestFocus(c)) {
                            i += g;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public boolean h() {
        if (this.F) {
            return f;
        }
        this.R = true;
        f(g);
        this.J = 0.0f;
        this.K = 0.0f;
        if (this.N == null) {
            this.N = VelocityTracker.obtain();
        } else {
            this.N.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, a, 0.0f, 0.0f, a);
        this.N.addMovement(obtain);
        obtain.recycle();
        this.S = uptimeMillis;
        return true;
    }

    public void i() {
        if (this.R) {
            VelocityTracker velocityTracker = this.N;
            velocityTracker.computeCurrentVelocity(com.xiaomi.account.openauth.h.E, (float) this.P);
            int a = (int) C0146au.a(velocityTracker, this.L);
            this.C = true;
            int i = (int) (this.J - this.K);
            int scrollY = getScrollY();
            int height = getHeight() + this.u;
            a(a(scrollY / height, ((float) (scrollY % height)) / ((float) height), a, i), true, true, a);
            p();
            this.R = f;
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public boolean j() {
        return this.R;
    }

    boolean k() {
        if (this.o <= 0) {
            return f;
        }
        a(this.o + M, true);
        return true;
    }

    boolean l() {
        if (this.n == null || this.o >= this.n.b() + M) {
            return f;
        }
        a(this.o + g, true);
        return true;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.V = true;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.u > 0 && this.v != null) {
            int scrollY = getScrollY();
            int height = getHeight();
            int i = scrollY % (this.u + height);
            if (i != 0) {
                scrollY = (scrollY - i) + height;
                this.v.setBounds(this.w, scrollY, this.x, this.u + scrollY);
                this.v.draw(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & HeartRateInfo.HR_EMPTY_VALUE;
        if (action == 3 || action == g) {
            this.F = f;
            this.G = f;
            this.L = M;
            if (this.N == null) {
                return f;
            }
            this.N.recycle();
            this.N = null;
            return f;
        }
        if (action != 0) {
            if (this.F) {
                return true;
            }
            if (this.G) {
                return f;
            }
        }
        float y;
        switch (action) {
            case a /*0*/:
                this.I = motionEvent.getX();
                y = motionEvent.getY();
                this.K = y;
                this.J = y;
                this.L = Y.b(motionEvent, a);
                if (this.ae != c) {
                    o();
                    this.F = f;
                    this.G = f;
                    break;
                }
                this.F = true;
                this.G = f;
                f(g);
                break;
            case c /*2*/:
                action = this.L;
                if (action != M) {
                    action = Y.a(motionEvent, action);
                    float c = Y.c(motionEvent, action);
                    float abs = Math.abs(c - this.I);
                    float d = Y.d(motionEvent, action);
                    y = d - this.J;
                    float abs2 = Math.abs(y);
                    if (!a(this, f, (int) y, (int) c, (int) d)) {
                        if (abs2 <= ((float) this.H) || abs2 <= abs) {
                            if (abs > ((float) this.H)) {
                                this.G = true;
                                break;
                            }
                        }
                        this.F = true;
                        f(g);
                        this.J = d;
                        a(true);
                        break;
                    }
                    this.J = d;
                    this.K = d;
                    this.I = c;
                    return f;
                }
                break;
            case a.bt /*6*/:
                a(motionEvent);
                break;
        }
        if (!this.F) {
            if (this.N == null) {
                this.N = VelocityTracker.obtain();
            }
            this.N.addMovement(motionEvent);
        }
        return this.F;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.A = true;
        g();
        this.A = f;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollY = getScrollY();
        int i7 = a;
        int i8 = a;
        while (i8 < childCount) {
            int measuredWidth;
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.a) {
                    int max;
                    int i9 = layoutParams.b & 112;
                    switch (layoutParams.b & 7) {
                        case g /*1*/:
                            max = Math.max((i5 - childAt.getMeasuredWidth()) / c, paddingLeft);
                            break;
                        case a.l /*3*/:
                            max = paddingLeft;
                            paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
                            break;
                        case a.X /*5*/:
                            measuredWidth = (i5 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            max = measuredWidth;
                            break;
                        default:
                            max = paddingLeft;
                            break;
                    }
                    int i10;
                    switch (i9) {
                        case a.bp /*16*/:
                            measuredWidth = Math.max((i6 - childAt.getMeasuredHeight()) / c, paddingTop);
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        case Constant.bh /*48*/:
                            measuredWidth = childAt.getMeasuredHeight() + paddingTop;
                            i10 = paddingTop;
                            paddingTop = paddingBottom;
                            paddingBottom = measuredWidth;
                            measuredWidth = i10;
                            break;
                        case cn.com.smartdevices.bracelet.gps.c.a.h /*80*/:
                            measuredWidth = (i6 - paddingBottom) - childAt.getMeasuredHeight();
                            i10 = paddingBottom + childAt.getMeasuredHeight();
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        default:
                            measuredWidth = paddingTop;
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                    }
                    i9 = measuredWidth + scrollY;
                    measuredWidth = i7 + g;
                    childAt.layout(max, i9, childAt.getMeasuredWidth() + max, childAt.getMeasuredHeight() + i9);
                    i7 = paddingBottom;
                    paddingBottom = paddingTop;
                    paddingTop = paddingRight;
                    paddingRight = paddingLeft;
                    i8 += g;
                    paddingLeft = paddingRight;
                    paddingRight = paddingTop;
                    paddingTop = i7;
                    i7 = measuredWidth;
                } else {
                    S a = a(childAt);
                    if (a != null) {
                        measuredWidth = (a.b * (this.u + i6)) + paddingTop;
                        childAt.layout(paddingLeft, measuredWidth, childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + measuredWidth);
                    }
                }
            }
            measuredWidth = i7;
            i7 = paddingTop;
            paddingTop = paddingRight;
            paddingRight = paddingLeft;
            i8 += g;
            paddingLeft = paddingRight;
            paddingRight = paddingTop;
            paddingTop = i7;
            i7 = measuredWidth;
        }
        this.w = paddingLeft;
        this.x = i5 - paddingRight;
        this.aa = i7;
        this.V = f;
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize(a, i), getDefaultSize(a, i2));
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i3 = a;
        while (i3 < childCount) {
            LayoutParams layoutParams;
            int i4;
            int i5;
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams != null && layoutParams.a) {
                    int i6 = layoutParams.b & 7;
                    int i7 = layoutParams.b & 112;
                    C0596r.e(d, "gravity: " + layoutParams.b + " hgrav: " + i6 + " vgrav: " + i7);
                    i4 = af.a;
                    i5 = af.a;
                    Object obj = (i7 == 48 || i7 == 80) ? g : a;
                    Object obj2 = (i6 == 3 || i6 == 5) ? g : null;
                    if (obj != null) {
                        i4 = 1073741824;
                    } else if (obj2 != null) {
                        i5 = 1073741824;
                    }
                    childAt.measure(MeasureSpec.makeMeasureSpec(measuredWidth, i4), MeasureSpec.makeMeasureSpec(measuredHeight, i5));
                    if (obj != null) {
                        i5 = measuredHeight - childAt.getMeasuredHeight();
                        i4 = measuredWidth;
                    } else if (obj2 != null) {
                        i4 = measuredWidth - childAt.getMeasuredWidth();
                        i5 = measuredHeight;
                    }
                    i3 += g;
                    measuredWidth = i4;
                    measuredHeight = i5;
                }
            }
            i5 = measuredHeight;
            i4 = measuredWidth;
            i3 += g;
            measuredWidth = i4;
            measuredHeight = i5;
        }
        this.y = MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        this.z = MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.A = true;
        g();
        this.A = f;
        measuredHeight = getChildCount();
        for (i4 = a; i4 < measuredHeight; i4 += g) {
            View childAt2 = getChildAt(i4);
            if (childAt2.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt2.getLayoutParams();
                if (layoutParams == null || !layoutParams.a) {
                    childAt2.measure(this.y, this.z);
                }
            }
        }
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3 = M;
        int childCount = getChildCount();
        if ((i & c) != 0) {
            i3 = g;
            i2 = a;
        } else {
            i2 = childCount + M;
            childCount = M;
        }
        while (i2 != childCount) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                S a = a(childAt);
                if (a != null && a.b == this.o && childAt.requestFocus(i, rect)) {
                    return true;
                }
            }
            i2 += i3;
        }
        return f;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (this.n != null) {
                this.n.a(savedState.b, savedState.c);
                a(savedState.a, (boolean) f, true);
                return;
            }
            this.p = savedState.a;
            this.q = savedState.b;
            this.r = savedState.c;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.o;
        if (this.n != null) {
            savedState.b = this.n.a();
        }
        return savedState;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i2 != i4) {
            a(i2, i4, this.u, this.u);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = f;
        if (this.R) {
            return true;
        }
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || this.n == null || this.n.b() == 0) {
            return f;
        }
        if (this.N == null) {
            this.N = VelocityTracker.obtain();
        }
        this.N.addMovement(motionEvent);
        float y;
        int height;
        switch (motionEvent.getAction() & HeartRateInfo.HR_EMPTY_VALUE) {
            case a /*0*/:
                o();
                y = motionEvent.getY();
                this.K = y;
                this.J = y;
                this.L = Y.b(motionEvent, a);
                break;
            case g /*1*/:
                if (this.F) {
                    VelocityTracker velocityTracker = this.N;
                    velocityTracker.computeCurrentVelocity(com.xiaomi.account.openauth.h.E, (float) this.P);
                    int b = (int) C0146au.b(velocityTracker, this.L);
                    this.C = true;
                    height = getHeight() + this.u;
                    int scrollY = getScrollY();
                    a(a(scrollY / height, ((float) (scrollY % height)) / ((float) height), b, (int) (Y.d(motionEvent, Y.a(motionEvent, this.L)) - this.K)), true, true, b);
                    this.L = M;
                    p();
                    z = this.T.c() | this.U.c();
                    break;
                }
                break;
            case c /*2*/:
                float abs;
                float abs2;
                if (!this.F) {
                    height = Y.a(motionEvent, this.L);
                    abs = Math.abs(Y.c(motionEvent, height) - this.I);
                    y = Y.d(motionEvent, height);
                    abs2 = Math.abs(y - this.J);
                    if (abs2 > ((float) this.H) && abs2 > abs) {
                        this.F = true;
                        this.J = y;
                        f(g);
                        a(true);
                    }
                }
                if (this.F) {
                    boolean z2;
                    float f;
                    y = Y.d(motionEvent, Y.a(motionEvent, this.L));
                    abs = this.J - y;
                    this.J = y;
                    abs2 = ((float) getScrollY()) + abs;
                    int height2 = getHeight();
                    int i = height2 + this.u;
                    int b2 = this.n.b() + M;
                    y = (float) Math.max(a, (this.o + M) * i);
                    abs = (float) (Math.min(this.o + g, b2) * i);
                    if (abs2 < y) {
                        if (y == 0.0f) {
                            z = this.T.a((-abs2) / ((float) height2));
                        }
                        float f2 = y;
                        z2 = z;
                        f = f2;
                    } else if (abs2 > abs) {
                        if (abs == ((float) (b2 * i))) {
                            z = this.U.a((abs2 - abs) / ((float) height2));
                        }
                        z2 = z;
                        f = abs;
                    } else {
                        z2 = f;
                        f = abs2;
                    }
                    this.J += f - ((float) ((int) f));
                    scrollTo(getScrollX(), (int) f);
                    g((int) f);
                    z = z2;
                    break;
                }
                break;
            case a.l /*3*/:
                if (this.F) {
                    a(this.o, true, true);
                    this.L = M;
                    p();
                    z = this.T.c() | this.U.c();
                    break;
                }
                break;
            case a.X /*5*/:
                height = Y.b(motionEvent);
                this.J = Y.d(motionEvent, height);
                this.L = Y.b(motionEvent, height);
                break;
            case a.bt /*6*/:
                a(motionEvent);
                this.J = Y.d(motionEvent, Y.a(motionEvent, this.L));
                break;
        }
        if (z) {
            invalidate();
        }
        return true;
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return (super.verifyDrawable(drawable) || drawable == this.v) ? true : f;
    }
}
