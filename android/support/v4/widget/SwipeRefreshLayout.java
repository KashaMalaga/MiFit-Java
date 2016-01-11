package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.C0151az;
import android.support.v4.view.Y;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import com.amap.api.maps.model.GroundOverlayOptions;
import kankan.wheel.widget.a;

public class SwipeRefreshLayout extends ViewGroup {
    private static final int[] H;
    public static final int a = 0;
    public static final int b = 1;
    private static final String e = SwipeRefreshLayout.class.getSimpleName();
    private static final int f = 255;
    private static final int g = 76;
    private static final int h = 40;
    private static final int i = 56;
    private static final float j = 2.0f;
    private static final int k = -1;
    private static final float l = 0.5f;
    private static final float m = 0.8f;
    private static final int n = 150;
    private static final int o = 300;
    private static final int p = 200;
    private static final int q = 200;
    private static final int r = -328966;
    private static final int s = 64;
    private boolean A;
    private float B;
    private boolean C;
    private int D;
    private boolean E;
    private boolean F;
    private final DecelerateInterpolator G;
    private C0237f I;
    private int J;
    private float K;
    private T L;
    private Animation M;
    private Animation N;
    private Animation O;
    private Animation P;
    private Animation Q;
    private float R;
    private boolean S;
    private int T;
    private int U;
    private boolean V;
    private AnimationListener W;
    private final Animation aa;
    private final Animation ab;
    protected int c;
    protected int d;
    private View t;
    private be u;
    private boolean v;
    private int w;
    private float x;
    private int y;
    private int z;

    static {
        int[] iArr = new int[b];
        iArr[a] = 16842766;
        H = iArr;
    }

    public SwipeRefreshLayout(Context context) {
        this(context, null);
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.v = false;
        this.x = GroundOverlayOptions.NO_DIMENSION;
        this.A = false;
        this.D = k;
        this.J = k;
        this.W = new aW(this);
        this.aa = new bb(this);
        this.ab = new bc(this);
        this.w = ViewConfiguration.get(context).getScaledTouchSlop();
        this.y = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.G = new DecelerateInterpolator(j);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, H);
        setEnabled(obtainStyledAttributes.getBoolean(a, true));
        obtainStyledAttributes.recycle();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.T = (int) (displayMetrics.density * 40.0f);
        this.U = (int) (displayMetrics.density * 40.0f);
        c();
        C0151az.a((ViewGroup) this, true);
        this.R = displayMetrics.density * 64.0f;
        this.x = this.R;
    }

    private float a(MotionEvent motionEvent, int i) {
        int a = Y.a(motionEvent, i);
        return a < 0 ? GroundOverlayOptions.NO_DIMENSION : Y.d(motionEvent, a);
    }

    private Animation a(int i, int i2) {
        if (this.E && d()) {
            return null;
        }
        Animation aZVar = new aZ(this, i, i2);
        aZVar.setDuration(300);
        this.I.a(null);
        this.I.clearAnimation();
        this.I.startAnimation(aZVar);
        return aZVar;
    }

    private void a(float f) {
        if (d()) {
            d((int) (255.0f * f));
            return;
        }
        C0151az.i(this.I, f);
        C0151az.j(this.I, f);
    }

    private void a(int i, AnimationListener animationListener) {
        this.c = i;
        this.aa.reset();
        this.aa.setDuration(200);
        this.aa.setInterpolator(this.G);
        if (animationListener != null) {
            this.I.a(animationListener);
        }
        this.I.clearAnimation();
        this.I.startAnimation(this.aa);
    }

    private void a(int i, boolean z) {
        this.I.bringToFront();
        this.I.offsetTopAndBottom(i);
        this.z = this.I.getTop();
        if (z && VERSION.SDK_INT < 11) {
            invalidate();
        }
    }

    private void a(MotionEvent motionEvent) {
        int b = Y.b(motionEvent);
        if (Y.b(motionEvent, b) == this.D) {
            this.D = Y.b(motionEvent, b == 0 ? b : a);
        }
    }

    private void a(AnimationListener animationListener) {
        this.I.setVisibility(a);
        if (VERSION.SDK_INT >= 11) {
            this.L.setAlpha(f);
        }
        this.M = new aX(this);
        this.M.setDuration((long) this.y);
        if (animationListener != null) {
            this.I.a(animationListener);
        }
        this.I.clearAnimation();
        this.I.startAnimation(this.M);
    }

    private void a(boolean z, boolean z2) {
        if (this.v != z) {
            this.S = z2;
            g();
            this.v = z;
            if (this.v) {
                a(this.z, this.W);
            } else {
                b(this.W);
            }
        }
    }

    private boolean a(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void b(float f) {
        a((this.c + ((int) (((float) (this.d - this.c)) * f))) - this.I.getTop(), false);
    }

    private void b(int i, AnimationListener animationListener) {
        if (this.E) {
            c(i, animationListener);
            return;
        }
        this.c = i;
        this.ab.reset();
        this.ab.setDuration(200);
        this.ab.setInterpolator(this.G);
        if (animationListener != null) {
            this.I.a(animationListener);
        }
        this.I.clearAnimation();
        this.I.startAnimation(this.ab);
    }

    private void b(AnimationListener animationListener) {
        this.N = new aY(this);
        this.N.setDuration(150);
        this.I.a(animationListener);
        this.I.clearAnimation();
        this.I.startAnimation(this.N);
    }

    private void c() {
        this.I = new C0237f(getContext(), r, 20.0f);
        this.L = new T(getContext(), this);
        this.L.b((int) r);
        this.I.setImageDrawable(this.L);
        this.I.setVisibility(8);
        addView(this.I);
    }

    private void c(int i, AnimationListener animationListener) {
        this.c = i;
        if (d()) {
            this.K = (float) this.L.getAlpha();
        } else {
            this.K = C0151az.E(this.I);
        }
        this.Q = new bd(this);
        this.Q.setDuration(150);
        if (animationListener != null) {
            this.I.a(animationListener);
        }
        this.I.clearAnimation();
        this.I.startAnimation(this.Q);
    }

    private void d(int i) {
        this.I.getBackground().setAlpha(i);
        this.L.setAlpha(i);
    }

    private boolean d() {
        return VERSION.SDK_INT < 11;
    }

    private void e() {
        this.O = a(this.L.getAlpha(), (int) g);
    }

    private void f() {
        this.P = a(this.L.getAlpha(), (int) f);
    }

    private void g() {
        if (this.t == null) {
            int i = a;
            while (i < getChildCount()) {
                View childAt = getChildAt(i);
                if (childAt.equals(this.I)) {
                    i += b;
                } else {
                    this.t = childAt;
                    return;
                }
            }
        }
    }

    public void a(int i) {
        if (i == 0 || i == b) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            int i2;
            if (i == 0) {
                i2 = (int) (displayMetrics.density * 56.0f);
                this.T = i2;
                this.U = i2;
            } else {
                i2 = (int) (displayMetrics.density * 40.0f);
                this.T = i2;
                this.U = i2;
            }
            this.I.setImageDrawable(null);
            this.L.a(i);
            this.I.setImageDrawable(this.L);
        }
    }

    public void a(be beVar) {
        this.u = beVar;
    }

    public void a(boolean z) {
        if (!z || this.v == z) {
            a(z, false);
            return;
        }
        this.v = z;
        a((!this.V ? (int) (this.R + ((float) this.d)) : (int) this.R) - this.z, true);
        this.S = false;
        a(this.W);
    }

    public void a(boolean z, int i) {
        this.R = (float) i;
        this.E = z;
        this.I.invalidate();
    }

    public void a(boolean z, int i, int i2) {
        this.E = z;
        this.I.setVisibility(8);
        this.z = i;
        this.d = i;
        this.R = (float) i2;
        this.V = true;
        this.I.invalidate();
    }

    @Deprecated
    public void a(int... iArr) {
        b(iArr);
    }

    public boolean a() {
        return this.v;
    }

    public void b(int i) {
        this.I.setBackgroundColor(i);
        this.L.b(getResources().getColor(i));
    }

    public void b(int... iArr) {
        Resources resources = getResources();
        int[] iArr2 = new int[iArr.length];
        for (int i = a; i < iArr.length; i += b) {
            iArr2[i] = resources.getColor(iArr[i]);
        }
        c(iArr2);
    }

    public boolean b() {
        boolean z = true;
        if (VERSION.SDK_INT >= 14) {
            return C0151az.b(this.t, (int) k);
        }
        if (this.t instanceof AbsListView) {
            AbsListView absListView = (AbsListView) this.t;
            return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(a).getTop() < absListView.getPaddingTop());
        } else {
            if (this.t.getScrollY() <= 0) {
                z = a;
            }
            return z;
        }
    }

    public void c(int i) {
        this.x = (float) i;
    }

    public void c(int... iArr) {
        g();
        this.L.a(iArr);
    }

    protected int getChildDrawingOrder(int i, int i2) {
        return this.J < 0 ? i2 : i2 == i + k ? this.J : i2 >= this.J ? i2 + b : i2;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        g();
        int a = Y.a(motionEvent);
        if (this.F && a == 0) {
            this.F = false;
        }
        if (!isEnabled() || this.F || b() || this.v) {
            return false;
        }
        float a2;
        switch (a) {
            case a /*0*/:
                a(this.d - this.I.getTop(), true);
                this.D = Y.b(motionEvent, a);
                this.C = false;
                a2 = a(motionEvent, this.D);
                if (a2 != GroundOverlayOptions.NO_DIMENSION) {
                    this.B = a2;
                    break;
                }
                return false;
            case b /*1*/:
            case a.l /*3*/:
                this.C = false;
                this.D = k;
                break;
            case a.k /*2*/:
                break;
            case a.bt /*6*/:
                a(motionEvent);
                break;
        }
        if (this.D == k) {
            Log.e(e, "Got ACTION_MOVE event but don't have an active pointer id.");
            return false;
        }
        a2 = a(motionEvent, this.D);
        if (a2 == GroundOverlayOptions.NO_DIMENSION) {
            return false;
        }
        if (a2 - this.B > ((float) this.w) && !this.C) {
            this.C = true;
            this.L.setAlpha(g);
        }
        return this.C;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.t == null) {
                g();
            }
            if (this.t != null) {
                View view = this.t;
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                measuredHeight = this.I.getMeasuredWidth();
                this.I.layout((measuredWidth / 2) - (measuredHeight / 2), this.z, (measuredWidth / 2) + (measuredHeight / 2), this.z + this.I.getMeasuredHeight());
            }
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.t == null) {
            g();
        }
        if (this.t != null) {
            int i3;
            this.t.measure(MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.I.measure(MeasureSpec.makeMeasureSpec(this.T, 1073741824), MeasureSpec.makeMeasureSpec(this.U, 1073741824));
            if (!(this.V || this.A)) {
                this.A = true;
                i3 = -this.I.getMeasuredHeight();
                this.d = i3;
                this.z = i3;
            }
            this.J = k;
            for (i3 = a; i3 < getChildCount(); i3 += b) {
                if (getChildAt(i3) == this.I) {
                    this.J = i3;
                    return;
                }
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Y.a(motionEvent);
        if (this.F && a == 0) {
            this.F = false;
        }
        if (!isEnabled() || this.F || b()) {
            return false;
        }
        float d;
        switch (a) {
            case a /*0*/:
                this.D = Y.b(motionEvent, a);
                this.C = false;
                break;
            case b /*1*/:
            case a.l /*3*/:
                if (this.D == k) {
                    if (a == b) {
                        Log.e(e, "Got ACTION_UP event but don't have an active pointer id.");
                    }
                    return false;
                }
                d = (Y.d(motionEvent, Y.a(motionEvent, this.D)) - this.B) * l;
                this.C = false;
                if (d > this.x) {
                    a(true, true);
                } else {
                    this.v = false;
                    this.L.a(0.0f, 0.0f);
                    AnimationListener animationListener = null;
                    if (!this.E) {
                        animationListener = new ba(this);
                    }
                    b(this.z, animationListener);
                    this.L.a(false);
                }
                this.D = k;
                return false;
            case a.k /*2*/:
                a = Y.a(motionEvent, this.D);
                if (a >= 0) {
                    float d2 = l * (Y.d(motionEvent, a) - this.B);
                    if (this.C) {
                        this.L.a(true);
                        d = d2 / this.x;
                        if (d >= 0.0f) {
                            float min = Math.min(1.0f, Math.abs(d));
                            float max = (((float) Math.max(((double) min) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
                            float abs = Math.abs(d2) - this.x;
                            d = this.V ? this.R - ((float) this.d) : this.R;
                            abs = Math.max(0.0f, Math.min(abs, j * d) / d);
                            abs = ((float) (((double) (abs / 4.0f)) - Math.pow((double) (abs / 4.0f), 2.0d))) * j;
                            a = ((int) ((d * min) + ((d * abs) * j))) + this.d;
                            if (this.I.getVisibility() != 0) {
                                this.I.setVisibility(a);
                            }
                            if (!this.E) {
                                C0151az.i(this.I, 1.0f);
                                C0151az.j(this.I, 1.0f);
                            }
                            if (d2 < this.x) {
                                if (this.E) {
                                    a(d2 / this.x);
                                }
                                if (this.L.getAlpha() > g && !a(this.O)) {
                                    e();
                                }
                                this.L.a(0.0f, Math.min(m, m * max));
                                this.L.a(Math.min(1.0f, max));
                            } else if (this.L.getAlpha() < f && !a(this.P)) {
                                f();
                            }
                            this.L.b(((-0.25f + (0.4f * max)) + (j * abs)) * l);
                            a(a - this.z, true);
                            break;
                        }
                        return false;
                    }
                }
                Log.e(e, "Got ACTION_MOVE event but have an invalid active pointer id.");
                return false;
                break;
            case a.X /*5*/:
                this.D = Y.b(motionEvent, Y.b(motionEvent));
                break;
            case a.bt /*6*/:
                a(motionEvent);
                break;
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
    }
}
