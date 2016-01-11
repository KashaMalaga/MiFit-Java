package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.C0151az;
import android.support.v7.widget.af;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.huami.android.widget.share.m;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.util.ArrayList;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public class SlidingPaneLayout extends ViewGroup {
    static final aR a;
    private static final String b = "SlidingPaneLayout";
    private static final int c = 32;
    private static final int d = -858993460;
    private static final int f = 400;
    private int e;
    private int g;
    private Drawable h;
    private Drawable i;
    private final int j;
    private boolean k;
    private View l;
    private float m;
    private float n;
    private int o;
    private boolean p;
    private int q;
    private float r;
    private float s;
    private aO t;
    private final bf u;
    private boolean v;
    private boolean w;
    private final Rect x;
    private final ArrayList<aM> y;

    public class LayoutParams extends MarginLayoutParams {
        private static final int[] e = new int[]{16843137};
        public float a = 0.0f;
        boolean b;
        boolean c;
        Paint d;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e);
            this.a = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.a = layoutParams.a;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new aP();
        boolean a;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readInt() != 0;
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a ? 1 : 0);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 17) {
            a = new aU();
        } else if (i >= 16) {
            a = new aT();
        } else {
            a = new aS();
        }
    }

    public SlidingPaneLayout(Context context) {
        this(context, null);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = d;
        this.w = true;
        this.x = new Rect();
        this.y = new ArrayList();
        float f = context.getResources().getDisplayMetrics().density;
        this.j = (int) ((32.0f * f) + 0.5f);
        ViewConfiguration.get(context);
        setWillNotDraw(false);
        C0151az.a((View) this, new C0207aL(this));
        C0151az.d((View) this, 1);
        this.u = bf.a((ViewGroup) this, 0.5f, new aN());
        this.u.a(f * a.bP);
    }

    private void a(float f) {
        Object obj;
        int childCount;
        int i;
        View childAt;
        int i2;
        boolean l = l();
        LayoutParams layoutParams = (LayoutParams) this.l.getLayoutParams();
        if (layoutParams.c) {
            if ((l ? layoutParams.rightMargin : layoutParams.leftMargin) <= 0) {
                obj = 1;
                childCount = getChildCount();
                for (i = 0; i < childCount; i++) {
                    childAt = getChildAt(i);
                    if (childAt == this.l) {
                        i2 = (int) ((1.0f - this.n) * ((float) this.q));
                        this.n = f;
                        i2 -= (int) ((1.0f - f) * ((float) this.q));
                        if (l) {
                            i2 = -i2;
                        }
                        childAt.offsetLeftAndRight(i2);
                        if (obj == null) {
                            a(childAt, l ? this.n - 1.0f : 1.0f - this.n, this.g);
                        }
                    }
                }
            }
        }
        obj = null;
        childCount = getChildCount();
        for (i = 0; i < childCount; i++) {
            childAt = getChildAt(i);
            if (childAt == this.l) {
                i2 = (int) ((1.0f - this.n) * ((float) this.q));
                this.n = f;
                i2 -= (int) ((1.0f - f) * ((float) this.q));
                if (l) {
                    i2 = -i2;
                }
                childAt.offsetLeftAndRight(i2);
                if (obj == null) {
                    if (l) {
                    }
                    a(childAt, l ? this.n - 1.0f : 1.0f - this.n, this.g);
                }
            }
        }
    }

    private void a(View view, float f, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f > 0.0f && i != 0) {
            int i2 = (((int) (((float) ((C0151az.s & i) >>> 24)) * f)) << 24) | (C0151az.r & i);
            if (layoutParams.d == null) {
                layoutParams.d = new Paint();
            }
            layoutParams.d.setColorFilter(new PorterDuffColorFilter(i2, Mode.SRC_OVER));
            if (C0151az.h(view) != 2) {
                C0151az.a(view, 2, layoutParams.d);
            }
            g(view);
        } else if (C0151az.h(view) != 0) {
            if (layoutParams.d != null) {
                layoutParams.d.setColorFilter(null);
            }
            Runnable aMVar = new aM(this, view);
            this.y.add(aMVar);
            C0151az.a((View) this, aMVar);
        }
    }

    private boolean a(View view, int i) {
        if (!this.w && !a(0.0f, i)) {
            return false;
        }
        this.v = false;
        return true;
    }

    private boolean b(View view, int i) {
        if (!this.w && !a(1.0f, i)) {
            return false;
        }
        this.v = true;
        return true;
    }

    private static boolean f(View view) {
        if (C0151az.l(view)) {
            return true;
        }
        if (VERSION.SDK_INT >= 18) {
            return false;
        }
        Drawable background = view.getBackground();
        return background != null ? background.getOpacity() == -1 : false;
    }

    private void g(int i) {
        if (this.l == null) {
            this.m = 0.0f;
            return;
        }
        boolean l = l();
        LayoutParams layoutParams = (LayoutParams) this.l.getLayoutParams();
        int width = this.l.getWidth();
        if (l) {
            i = (getWidth() - i) - width;
        }
        this.m = ((float) (i - ((l ? layoutParams.rightMargin : layoutParams.leftMargin) + (l ? getPaddingRight() : getPaddingLeft())))) / ((float) this.o);
        if (this.q != 0) {
            a(this.m);
        }
        if (layoutParams.c) {
            a(this.l, this.m, this.e);
        }
        a(this.l);
    }

    private void g(View view) {
        a.a(this, view);
    }

    private boolean l() {
        return C0151az.j(this) == 1;
    }

    public int a() {
        return this.q;
    }

    public void a(int i) {
        this.q = i;
        requestLayout();
    }

    @Deprecated
    public void a(Drawable drawable) {
        b(drawable);
    }

    public void a(aO aOVar) {
        this.t = aOVar;
    }

    void a(View view) {
        if (this.t != null) {
            this.t.a(view, this.m);
        }
    }

    boolean a(float f, int i) {
        if (!this.k) {
            return false;
        }
        int width;
        LayoutParams layoutParams = (LayoutParams) this.l.getLayoutParams();
        if (l()) {
            width = (int) (((float) getWidth()) - ((((float) (layoutParams.rightMargin + getPaddingRight())) + (((float) this.o) * f)) + ((float) this.l.getWidth())));
        } else {
            width = (int) (((float) (layoutParams.leftMargin + getPaddingLeft())) + (((float) this.o) * f));
        }
        if (!this.u.a(this.l, width, this.l.getTop())) {
            return false;
        }
        d();
        C0151az.d(this);
        return true;
    }

    protected boolean a(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
                    if (a(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (z) {
            if (!l()) {
                i = -i;
            }
            if (C0151az.a(view, i)) {
                return true;
            }
        }
        return false;
    }

    public int b() {
        return this.e;
    }

    public void b(int i) {
        this.e = i;
    }

    public void b(Drawable drawable) {
        this.h = drawable;
    }

    void b(View view) {
        if (this.t != null) {
            this.t.a(view);
        }
        sendAccessibilityEvent(c);
    }

    public int c() {
        return this.g;
    }

    public void c(int i) {
        this.g = i;
    }

    public void c(Drawable drawable) {
        this.i = drawable;
    }

    void c(View view) {
        if (this.t != null) {
            this.t.b(view);
        }
        sendAccessibilityEvent(c);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        if (!this.u.a(true)) {
            return;
        }
        if (this.k) {
            C0151az.d(this);
        } else {
            this.u.h();
        }
    }

    void d() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    @Deprecated
    public void d(int i) {
        a(getResources().getDrawable(i));
    }

    void d(View view) {
        int i;
        int i2;
        int i3;
        int i4;
        boolean l = l();
        int width = l ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = l ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view == null || !f(view)) {
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        } else {
            i4 = view.getLeft();
            i3 = view.getRight();
            i2 = view.getTop();
            i = view.getBottom();
        }
        int childCount = getChildCount();
        int i5 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt != view) {
                int i6 = (Math.max(l ? paddingLeft : width, childAt.getLeft()) < i4 || Math.max(paddingTop, childAt.getTop()) < i2 || Math.min(l ? width : paddingLeft, childAt.getRight()) > i3 || Math.min(height, childAt.getBottom()) > i) ? 0 : 4;
                childAt.setVisibility(i6);
                i5++;
            } else {
                return;
            }
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = l() ? this.i : this.h;
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt != null && drawable != null) {
            int right;
            int i;
            int top = childAt.getTop();
            int bottom = childAt.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (l()) {
                right = childAt.getRight();
                i = right + intrinsicWidth;
            } else {
                i = childAt.getLeft();
                right = i - intrinsicWidth;
            }
            drawable.setBounds(right, top, i, bottom);
            drawable.draw(canvas);
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int save = canvas.save(2);
        if (!(!this.k || layoutParams.b || this.l == null)) {
            canvas.getClipBounds(this.x);
            if (l()) {
                this.x.left = Math.max(this.x.left, this.l.getRight());
            } else {
                this.x.right = Math.min(this.x.right, this.l.getLeft());
            }
            canvas.clipRect(this.x);
        }
        if (VERSION.SDK_INT >= 11) {
            drawChild = super.drawChild(canvas, view, j);
        } else if (!layoutParams.c || this.m <= 0.0f) {
            if (view.isDrawingCacheEnabled()) {
                view.setDrawingCacheEnabled(false);
            }
            drawChild = super.drawChild(canvas, view, j);
        } else {
            if (!view.isDrawingCacheEnabled()) {
                view.setDrawingCacheEnabled(true);
            }
            Bitmap drawingCache = view.getDrawingCache();
            if (drawingCache != null) {
                canvas.drawBitmap(drawingCache, (float) view.getLeft(), (float) view.getTop(), layoutParams.d);
                drawChild = false;
            } else {
                Log.e(b, "drawChild: child view " + view + " returned null drawing cache");
                drawChild = super.drawChild(canvas, view, j);
            }
        }
        canvas.restoreToCount(save);
        return drawChild;
    }

    @Deprecated
    public void e() {
        f();
    }

    public void e(int i) {
        b(getResources().getDrawable(i));
    }

    boolean e(View view) {
        if (view == null) {
            return false;
        }
        boolean z = this.k && ((LayoutParams) view.getLayoutParams()).c && this.m > 0.0f;
        return z;
    }

    public void f(int i) {
        c(getResources().getDrawable(i));
    }

    public boolean f() {
        return b(this.l, 0);
    }

    @Deprecated
    public void g() {
        h();
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new LayoutParams((MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public boolean h() {
        return a(this.l, 0);
    }

    public boolean i() {
        return !this.k || this.m == 1.0f;
    }

    @Deprecated
    public boolean j() {
        return this.k;
    }

    public boolean k() {
        return this.k;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.w = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.w = true;
        int size = this.y.size();
        for (int i = 0; i < size; i++) {
            ((aM) this.y.get(i)).run();
        }
        this.y.clear();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
        r7 = this;
        r2 = 0;
        r1 = 1;
        r3 = android.support.v4.view.Y.a(r8);
        r0 = r7.k;
        if (r0 != 0) goto L_0x002d;
    L_0x000a:
        if (r3 != 0) goto L_0x002d;
    L_0x000c:
        r0 = r7.getChildCount();
        if (r0 <= r1) goto L_0x002d;
    L_0x0012:
        r0 = r7.getChildAt(r1);
        if (r0 == 0) goto L_0x002d;
    L_0x0018:
        r4 = r7.u;
        r5 = r8.getX();
        r5 = (int) r5;
        r6 = r8.getY();
        r6 = (int) r6;
        r0 = r4.b(r0, r5, r6);
        if (r0 != 0) goto L_0x0041;
    L_0x002a:
        r0 = r1;
    L_0x002b:
        r7.v = r0;
    L_0x002d:
        r0 = r7.k;
        if (r0 == 0) goto L_0x0037;
    L_0x0031:
        r0 = r7.p;
        if (r0 == 0) goto L_0x0043;
    L_0x0035:
        if (r3 == 0) goto L_0x0043;
    L_0x0037:
        r0 = r7.u;
        r0.g();
        r2 = super.onInterceptTouchEvent(r8);
    L_0x0040:
        return r2;
    L_0x0041:
        r0 = r2;
        goto L_0x002b;
    L_0x0043:
        r0 = 3;
        if (r3 == r0) goto L_0x0048;
    L_0x0046:
        if (r3 != r1) goto L_0x004e;
    L_0x0048:
        r0 = r7.u;
        r0.g();
        goto L_0x0040;
    L_0x004e:
        switch(r3) {
            case 0: goto L_0x005e;
            case 1: goto L_0x0051;
            case 2: goto L_0x0082;
            default: goto L_0x0051;
        };
    L_0x0051:
        r0 = r2;
    L_0x0052:
        r3 = r7.u;
        r3 = r3.a(r8);
        if (r3 != 0) goto L_0x005c;
    L_0x005a:
        if (r0 == 0) goto L_0x0040;
    L_0x005c:
        r2 = r1;
        goto L_0x0040;
    L_0x005e:
        r7.p = r2;
        r0 = r8.getX();
        r3 = r8.getY();
        r7.r = r0;
        r7.s = r3;
        r4 = r7.u;
        r5 = r7.l;
        r0 = (int) r0;
        r3 = (int) r3;
        r0 = r4.b(r5, r0, r3);
        if (r0 == 0) goto L_0x0051;
    L_0x0078:
        r0 = r7.l;
        r0 = r7.e(r0);
        if (r0 == 0) goto L_0x0051;
    L_0x0080:
        r0 = r1;
        goto L_0x0052;
    L_0x0082:
        r0 = r8.getX();
        r3 = r8.getY();
        r4 = r7.r;
        r0 = r0 - r4;
        r0 = java.lang.Math.abs(r0);
        r4 = r7.s;
        r3 = r3 - r4;
        r3 = java.lang.Math.abs(r3);
        r4 = r7.u;
        r4 = r4.f();
        r4 = (float) r4;
        r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r4 <= 0) goto L_0x0051;
    L_0x00a3:
        r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x0051;
    L_0x00a7:
        r0 = r7.u;
        r0.g();
        r7.p = r1;
        goto L_0x0040;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.SlidingPaneLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        boolean l = l();
        if (l) {
            this.u.a(2);
        } else {
            this.u.a(1);
        }
        int i6 = i3 - i;
        int paddingRight = l ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = l ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.w) {
            float f = (this.k && this.v) ? 1.0f : 0.0f;
            this.m = f;
        }
        int i7 = 0;
        int i8 = paddingRight;
        while (i7 < childCount) {
            int i9;
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() == 8) {
                i5 = paddingRight;
                i9 = i8;
            } else {
                int i10;
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (layoutParams.b) {
                    int min = (Math.min(paddingRight, (i6 - paddingLeft) - this.j) - i8) - (layoutParams.leftMargin + layoutParams.rightMargin);
                    this.o = min;
                    i9 = l ? layoutParams.rightMargin : layoutParams.leftMargin;
                    layoutParams.c = ((i8 + i9) + min) + (measuredWidth / 2) > i6 - paddingLeft;
                    i5 = (int) (((float) min) * this.m);
                    i10 = i8 + (i9 + i5);
                    this.m = ((float) i5) / ((float) this.o);
                    i5 = 0;
                } else if (!this.k || this.q == 0) {
                    i5 = 0;
                    i10 = paddingRight;
                } else {
                    i5 = (int) ((1.0f - this.m) * ((float) this.q));
                    i10 = paddingRight;
                }
                if (l) {
                    i9 = (i6 - i10) + i5;
                    i5 = i9 - measuredWidth;
                } else {
                    i5 = i10 - i5;
                    i9 = i5 + measuredWidth;
                }
                childAt.layout(i5, paddingTop, i9, childAt.getMeasuredHeight() + paddingTop);
                i5 = childAt.getWidth() + paddingRight;
                i9 = i10;
            }
            i7++;
            paddingRight = i5;
            i8 = i9;
        }
        if (this.w) {
            if (this.k) {
                if (this.q != 0) {
                    a(this.m);
                }
                if (((LayoutParams) this.l.getLayoutParams()).c) {
                    a(this.l, this.m, this.e);
                }
            } else {
                for (i5 = 0; i5 < childCount; i5++) {
                    a(getChildAt(i5), 0.0f, this.e);
                }
            }
            d(this.l);
        }
        this.w = false;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            if (mode2 == 0) {
                if (!isInEditMode()) {
                    throw new IllegalStateException("Height must not be UNSPECIFIED");
                } else if (mode2 == 0) {
                    i3 = Integer.MIN_VALUE;
                    i4 = size;
                    size = m.n;
                }
            }
            i3 = mode2;
            i4 = size;
            size = size2;
        } else if (!isInEditMode()) {
            throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        } else if (mode == af.a) {
            i3 = mode2;
            i4 = size;
            size = size2;
        } else {
            if (mode == 0) {
                i3 = mode2;
                i4 = m.n;
                size = size2;
            }
            i3 = mode2;
            i4 = size;
            size = size2;
        }
        switch (i3) {
            case af.a /*-2147483648*/:
                size2 = 0;
                mode2 = (size - getPaddingTop()) - getPaddingBottom();
                break;
            case 1073741824:
                size2 = (size - getPaddingTop()) - getPaddingBottom();
                mode2 = size2;
                break;
            default:
                size2 = 0;
                mode2 = -1;
                break;
        }
        boolean z = false;
        int paddingLeft = (i4 - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        if (childCount > 2) {
            Log.e(b, "onMeasure: More than two child views are not supported.");
        }
        this.l = null;
        int i6 = 0;
        int i7 = paddingLeft;
        int i8 = size2;
        float f = 0.0f;
        while (i6 < childCount) {
            float f2;
            boolean z2;
            View childAt = getChildAt(i6);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                layoutParams.c = false;
                size2 = i7;
                f2 = f;
                i5 = i8;
                z2 = z;
            } else {
                if (layoutParams.a > 0.0f) {
                    f += layoutParams.a;
                    if (layoutParams.width == 0) {
                        size2 = i7;
                        f2 = f;
                        i5 = i8;
                        z2 = z;
                    }
                }
                mode = layoutParams.leftMargin + layoutParams.rightMargin;
                mode = layoutParams.width == -2 ? MeasureSpec.makeMeasureSpec(paddingLeft - mode, af.a) : layoutParams.width == -1 ? MeasureSpec.makeMeasureSpec(paddingLeft - mode, 1073741824) : MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
                i5 = layoutParams.height == -2 ? MeasureSpec.makeMeasureSpec(mode2, af.a) : layoutParams.height == -1 ? MeasureSpec.makeMeasureSpec(mode2, 1073741824) : MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                childAt.measure(mode, i5);
                mode = childAt.getMeasuredWidth();
                i5 = childAt.getMeasuredHeight();
                if (i3 == Integer.MIN_VALUE && i5 > i8) {
                    i8 = Math.min(i5, mode2);
                }
                i5 = i7 - mode;
                boolean z3 = i5 < 0;
                layoutParams.b = z3;
                z3 |= z;
                if (layoutParams.b) {
                    this.l = childAt;
                }
                size2 = i5;
                i5 = i8;
                float f3 = f;
                z2 = z3;
                f2 = f3;
            }
            i6++;
            z = z2;
            i8 = i5;
            f = f2;
            i7 = size2;
        }
        if (z || f > 0.0f) {
            int i9 = paddingLeft - this.j;
            for (i3 = 0; i3 < childCount; i3++) {
                View childAt2 = getChildAt(i3);
                if (childAt2.getVisibility() != 8) {
                    layoutParams = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != 8) {
                        Object obj = (layoutParams.width != 0 || layoutParams.a <= 0.0f) ? null : 1;
                        i5 = obj != null ? 0 : childAt2.getMeasuredWidth();
                        if (!z || childAt2 == this.l) {
                            if (layoutParams.a > 0.0f) {
                                mode = layoutParams.width == 0 ? layoutParams.height == -2 ? MeasureSpec.makeMeasureSpec(mode2, af.a) : layoutParams.height == -1 ? MeasureSpec.makeMeasureSpec(mode2, 1073741824) : MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824) : MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                if (z) {
                                    size2 = paddingLeft - (layoutParams.rightMargin + layoutParams.leftMargin);
                                    i6 = MeasureSpec.makeMeasureSpec(size2, 1073741824);
                                    if (i5 != size2) {
                                        childAt2.measure(i6, mode);
                                    }
                                } else {
                                    childAt2.measure(MeasureSpec.makeMeasureSpec(((int) ((layoutParams.a * ((float) Math.max(0, i7))) / f)) + i5, 1073741824), mode);
                                }
                            }
                        } else if (layoutParams.width < 0 && (i5 > i9 || layoutParams.a > 0.0f)) {
                            size2 = obj != null ? layoutParams.height == -2 ? MeasureSpec.makeMeasureSpec(mode2, af.a) : layoutParams.height == -1 ? MeasureSpec.makeMeasureSpec(mode2, 1073741824) : MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824) : MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                            childAt2.measure(MeasureSpec.makeMeasureSpec(i9, 1073741824), size2);
                        }
                    }
                }
            }
        }
        setMeasuredDimension(i4, (getPaddingTop() + i8) + getPaddingBottom());
        this.k = z;
        if (this.u.b() != 0 && !z) {
            this.u.h();
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.a) {
            f();
        } else {
            h();
        }
        this.v = savedState.a;
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = k() ? i() : this.v;
        return savedState;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.w = true;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.k) {
            return super.onTouchEvent(motionEvent);
        }
        this.u.b(motionEvent);
        float x;
        float y;
        switch (motionEvent.getAction() & HeartRateInfo.HR_EMPTY_VALUE) {
            case a.i /*0*/:
                x = motionEvent.getX();
                y = motionEvent.getY();
                this.r = x;
                this.s = y;
                return true;
            case l.a /*1*/:
                if (!e(this.l)) {
                    return true;
                }
                x = motionEvent.getX();
                y = motionEvent.getY();
                float f = x - this.r;
                float f2 = y - this.s;
                int f3 = this.u.f();
                if ((f * f) + (f2 * f2) >= ((float) (f3 * f3)) || !this.u.b(this.l, (int) x, (int) y)) {
                    return true;
                }
                a(this.l, 0);
                return true;
            default:
                return true;
        }
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.k) {
            this.v = view == this.l;
        }
    }
}
