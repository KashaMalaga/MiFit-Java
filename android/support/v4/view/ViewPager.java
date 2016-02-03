package android.support.v4.view;

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
import android.support.v4.view.a.C0099a;
import android.support.v4.widget.C0203a;
import android.support.v4.widget.F;
import android.support.v7.widget.af;
import android.util.AttributeSet;
import android.util.Log;
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
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import cn.com.smartdevices.bracelet.Constant;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.edmodo.cropper.cropwindow.CropOverlayView;
import com.xiaomi.account.openauth.h;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import kankan.wheel.widget.a;

public class ViewPager extends ViewGroup {
    private static final int W = -1;
    public static final int a = 0;
    private static final int af = 2;
    private static final int at = 0;
    private static final int au = 1;
    private static final int av = 2;
    private static final bE ay = new bE();
    public static final int b = 1;
    public static final int c = 2;
    private static final String d = "ViewPager";
    private static final boolean e = false;
    private static final boolean f = false;
    private static final int g = 1;
    private static final int h = 600;
    private static final int i = 25;
    private static final int j = 16;
    private static final int k = 400;
    private static final int[] l;
    private static final Comparator<C0179bw> n = new C0176bs();
    private static final Interpolator o = new C0177bt();
    private Drawable A;
    private int B;
    private int C;
    private float D = -3.4028235E38f;
    private float E = C0203a.b;
    private int F;
    private int G;
    private boolean H;
    private boolean I;
    private boolean J;
    private int K = g;
    private boolean L;
    private boolean M;
    private boolean N;
    private int O;
    private int P;
    private int Q;
    private float R;
    private float S;
    private float T;
    private float U;
    private int V = W;
    private int aA = at;
    private VelocityTracker aa;
    private int ab;
    private int ac;
    private int ad;
    private int ae;
    private boolean ag;
    private long ah;
    private F ai;
    private F aj;
    private boolean ak = true;
    private boolean al = f;
    private boolean am;
    private int an;
    private bz ao;
    private bz ap;
    private by aq;
    private bA ar;
    private Method as;
    private int aw;
    private ArrayList<View> ax;
    private final Runnable az = new C0178bu(this);
    private int m;
    private final ArrayList<C0179bw> p = new ArrayList();
    private final C0179bw q = new C0179bw();
    private final Rect r = new Rect();
    private ae s;
    private int t;
    private int u = W;
    private Parcelable v = null;
    private ClassLoader w = null;
    private Scroller x;
    private bB y;
    private int z;

    public class LayoutParams extends android.view.ViewGroup.LayoutParams {
        public boolean a;
        public int b;
        float c = 0.0f;
        boolean d;
        int e;
        int f;

        public LayoutParams() {
            super(ViewPager.W, ViewPager.W);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.l);
            this.b = obtainStyledAttributes.getInteger(ViewPager.at, 48);
            obtainStyledAttributes.recycle();
        }
    }

    public class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = e.a(new bC());
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
        iArr[at] = 16842931;
        l = iArr;
    }

    public ViewPager(Context context) {
        super(context);
        a();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private int a(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.ad || Math.abs(i2) <= this.ab) {
            i = (int) ((i >= this.t ? 0.4f : 0.6f) + (((float) i) + f));
        } else if (i2 <= 0) {
            i += g;
        }
        if (this.p.size() <= 0) {
            return i;
        }
        return Math.max(((C0179bw) this.p.get(at)).b, Math.min(i, ((C0179bw) this.p.get(this.p.size() + W)).b));
    }

    private Rect a(Rect rect, View view) {
        Rect rect2 = rect == null ? new Rect() : rect;
        if (view == null) {
            rect2.set(at, at, at, at);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        ViewPager parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = parent;
            rect2.left += viewGroup.getLeft();
            rect2.right += viewGroup.getRight();
            rect2.top += viewGroup.getTop();
            rect2.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect2;
    }

    private void a(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.p.isEmpty()) {
            C0179bw f = f(this.t);
            int min = (int) ((f != null ? Math.min(f.e, this.E) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                b((boolean) f);
                scrollTo(min, getScrollY());
                return;
            }
            return;
        }
        int paddingLeft = (int) (((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3)) * (((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4))));
        scrollTo(paddingLeft, getScrollY());
        if (!this.x.isFinished()) {
            this.x.startScroll(paddingLeft, at, (int) (f(this.t).e * ((float) i)), at, this.x.getDuration() - this.x.timePassed());
        }
    }

    private void a(int i, boolean z, int i2, boolean z2) {
        int max;
        C0179bw f = f(i);
        if (f != null) {
            max = (int) (Math.max(this.D, Math.min(f.e, this.E)) * ((float) o()));
        } else {
            max = at;
        }
        if (z) {
            a(max, (int) at, i2);
            if (z2 && this.ao != null) {
                this.ao.a(i);
            }
            if (z2 && this.ap != null) {
                this.ap.a(i);
                return;
            }
            return;
        }
        if (z2 && this.ao != null) {
            this.ao.a(i);
        }
        if (z2 && this.ap != null) {
            this.ap.a(i);
        }
        b((boolean) f);
        scrollTo(max, at);
        i(max);
    }

    private void a(C0179bw c0179bw, int i, C0179bw c0179bw2) {
        float f;
        int i2;
        C0179bw c0179bw3;
        int i3;
        int b = this.s.b();
        int o = o();
        float f2 = o > 0 ? ((float) this.z) / ((float) o) : 0.0f;
        if (c0179bw2 != null) {
            o = c0179bw2.b;
            int i4;
            if (o < c0179bw.b) {
                f = (c0179bw2.e + c0179bw2.d) + f2;
                i4 = o + g;
                i2 = at;
                while (i4 <= c0179bw.b && i2 < this.p.size()) {
                    c0179bw3 = (C0179bw) this.p.get(i2);
                    while (i4 > c0179bw3.b && i2 < this.p.size() + W) {
                        i2 += g;
                        c0179bw3 = (C0179bw) this.p.get(i2);
                    }
                    while (i4 < c0179bw3.b) {
                        f += this.s.d(i4) + f2;
                        i4 += g;
                    }
                    c0179bw3.e = f;
                    f += c0179bw3.d + f2;
                    i4 += g;
                }
            } else if (o > c0179bw.b) {
                i2 = this.p.size() + W;
                f = c0179bw2.e;
                i4 = o + W;
                while (i4 >= c0179bw.b && i2 >= 0) {
                    c0179bw3 = (C0179bw) this.p.get(i2);
                    while (i4 < c0179bw3.b && i2 > 0) {
                        i2 += W;
                        c0179bw3 = (C0179bw) this.p.get(i2);
                    }
                    while (i4 > c0179bw3.b) {
                        f -= this.s.d(i4) + f2;
                        i4 += W;
                    }
                    f -= c0179bw3.d + f2;
                    c0179bw3.e = f;
                    i4 += W;
                }
            }
        }
        int size = this.p.size();
        float f3 = c0179bw.e;
        i2 = c0179bw.b + W;
        this.D = c0179bw.b == 0 ? c0179bw.e : -3.4028235E38f;
        this.E = c0179bw.b == b + W ? (c0179bw.e + c0179bw.d) - 1.0f : C0203a.b;
        for (i3 = i + W; i3 >= 0; i3 += W) {
            c0179bw3 = (C0179bw) this.p.get(i3);
            f = f3;
            while (i2 > c0179bw3.b) {
                f -= this.s.d(i2) + f2;
                i2 += W;
            }
            f3 = f - (c0179bw3.d + f2);
            c0179bw3.e = f3;
            if (c0179bw3.b == 0) {
                this.D = f3;
            }
            i2 += W;
        }
        f3 = (c0179bw.e + c0179bw.d) + f2;
        i2 = c0179bw.b + g;
        for (i3 = i + g; i3 < size; i3 += g) {
            c0179bw3 = (C0179bw) this.p.get(i3);
            f = f3;
            while (i2 < c0179bw3.b) {
                f = (this.s.d(i2) + f2) + f;
                i2 += g;
            }
            if (c0179bw3.b == b + W) {
                this.E = (c0179bw3.d + f) - 1.0f;
            }
            c0179bw3.e = f;
            f3 = f + (c0179bw3.d + f2);
            i2 += g;
        }
        this.al = f;
    }

    private void a(MotionEvent motionEvent) {
        int b = Y.b(motionEvent);
        if (Y.b(motionEvent, b) == this.V) {
            b = b == 0 ? g : at;
            this.R = Y.c(motionEvent, b);
            this.V = Y.b(motionEvent, b);
            if (this.aa != null) {
                this.aa.clear();
            }
        }
    }

    private boolean a(float f, float f2) {
        return ((f >= ((float) this.P) || f2 <= 0.0f) && (f <= ((float) (getWidth() - this.P)) || f2 >= 0.0f)) ? f : true;
    }

    private void b(boolean z) {
        int scrollX;
        boolean z2 = this.aA == c ? g : f;
        if (z2) {
            e((boolean) f);
            this.x.abortAnimation();
            scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.x.getCurrX();
            int currY = this.x.getCurrY();
            if (!(scrollX == currX && scrollY == currY)) {
                scrollTo(currX, currY);
            }
        }
        this.J = f;
        boolean z3 = z2;
        for (scrollX = at; scrollX < this.p.size(); scrollX += g) {
            C0179bw c0179bw = (C0179bw) this.p.get(scrollX);
            if (c0179bw.c) {
                c0179bw.c = f;
                z3 = g;
            }
        }
        if (!z3) {
            return;
        }
        if (z) {
            C0151az.a((View) this, this.az);
        } else {
            this.az.run();
        }
    }

    private void c(boolean z) {
        int childCount = getChildCount();
        for (int i = at; i < childCount; i += g) {
            C0151az.a(getChildAt(i), z ? c : at, null);
        }
    }

    private boolean c(float f) {
        boolean z;
        float f2;
        boolean z2 = true;
        boolean z3 = f;
        float f3 = this.R - f;
        this.R = f;
        float scrollX = ((float) getScrollX()) + f3;
        int o = o();
        float f4 = ((float) o) * this.D;
        float f5 = ((float) o) * this.E;
        C0179bw c0179bw = (C0179bw) this.p.get(at);
        C0179bw c0179bw2 = (C0179bw) this.p.get(this.p.size() + W);
        if (c0179bw.b != 0) {
            f4 = c0179bw.e * ((float) o);
            z = f;
        } else {
            z = g;
        }
        if (c0179bw2.b != this.s.b() + W) {
            f2 = c0179bw2.e * ((float) o);
            z2 = f;
        } else {
            f2 = f5;
        }
        if (scrollX < f4) {
            if (z) {
                z3 = this.ai.a(Math.abs(f4 - scrollX) / ((float) o));
            }
        } else if (scrollX > f2) {
            if (z2) {
                z3 = this.aj.a(Math.abs(scrollX - f2) / ((float) o));
            }
            f4 = f2;
        } else {
            f4 = scrollX;
        }
        this.R += f4 - ((float) ((int) f4));
        scrollTo((int) f4, getScrollY());
        i((int) f4);
        return z3;
    }

    private void d(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private void e(boolean z) {
        if (this.I != z) {
            this.I = z;
        }
    }

    private void h(int i) {
        if (this.aA != i) {
            this.aA = i;
            if (this.ar != null) {
                c(i != 0 ? true : f);
            }
            if (this.ao != null) {
                this.ao.b(i);
            }
        }
    }

    private boolean i(int i) {
        if (this.p.size() == 0) {
            this.am = f;
            a((int) at, 0.0f, (int) at);
            if (this.am) {
                return f;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        C0179bw q = q();
        int o = o();
        int i2 = this.z + o;
        float f = ((float) this.z) / ((float) o);
        int i3 = q.b;
        float f2 = ((((float) i) / ((float) o)) - q.e) / (q.d + f);
        o = (int) (((float) i2) * f2);
        this.am = f;
        a(i3, f2, o);
        if (this.am) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private void n() {
        int i = at;
        while (i < getChildCount()) {
            if (!((LayoutParams) getChildAt(i).getLayoutParams()).a) {
                removeViewAt(i);
                i += W;
            }
            i += g;
        }
    }

    private int o() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void p() {
        if (this.aw != 0) {
            if (this.ax == null) {
                this.ax = new ArrayList();
            } else {
                this.ax.clear();
            }
            int childCount = getChildCount();
            for (int i = at; i < childCount; i += g) {
                this.ax.add(getChildAt(i));
            }
            Collections.sort(this.ax, ay);
        }
    }

    private C0179bw q() {
        int o = o();
        float scrollX = o > 0 ? ((float) getScrollX()) / ((float) o) : 0.0f;
        float f = o > 0 ? ((float) this.z) / ((float) o) : 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i = W;
        int i2 = at;
        Object obj = g;
        C0179bw c0179bw = null;
        while (i2 < this.p.size()) {
            int i3;
            C0179bw c0179bw2;
            C0179bw c0179bw3 = (C0179bw) this.p.get(i2);
            C0179bw c0179bw4;
            if (obj != null || c0179bw3.b == i + g) {
                c0179bw4 = c0179bw3;
                i3 = i2;
                c0179bw2 = c0179bw4;
            } else {
                c0179bw3 = this.q;
                c0179bw3.e = (f2 + f3) + f;
                c0179bw3.b = i + g;
                c0179bw3.d = this.s.d(c0179bw3.b);
                c0179bw4 = c0179bw3;
                i3 = i2 + W;
                c0179bw2 = c0179bw4;
            }
            f2 = c0179bw2.e;
            f3 = (c0179bw2.d + f2) + f;
            if (obj == null && scrollX < f2) {
                return c0179bw;
            }
            if (scrollX < f3 || i3 == this.p.size() + W) {
                return c0179bw2;
            }
            f3 = f2;
            i = c0179bw2.b;
            obj = at;
            f2 = c0179bw2.d;
            c0179bw = c0179bw2;
            i2 = i3 + g;
        }
        return c0179bw;
    }

    private void r() {
        this.L = f;
        this.M = f;
        if (this.aa != null) {
            this.aa.recycle();
            this.aa = null;
        }
    }

    float a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    C0179bw a(View view) {
        for (int i = at; i < this.p.size(); i += g) {
            C0179bw c0179bw = (C0179bw) this.p.get(i);
            if (this.s.a(view, c0179bw.a)) {
                return c0179bw;
            }
        }
        return null;
    }

    void a() {
        setWillNotDraw(f);
        setDescendantFocusability(C0099a.l);
        setFocusable(true);
        Context context = getContext();
        this.x = new Scroller(context, o);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.Q = aZ.a(viewConfiguration);
        this.ab = (int) (a.bP * f);
        this.ac = viewConfiguration.getScaledMaximumFlingVelocity();
        this.ai = new F(context);
        this.aj = new F(context);
        this.ad = (int) (a.bi * f);
        this.ae = (int) (2.0f * f);
        this.O = (int) (16.0f * f);
        C0151az.a((View) this, new C0180bx(this));
        if (C0151az.e(this) == 0) {
            C0151az.d((View) this, (int) g);
        }
    }

    public void a(int i) {
        this.J = f;
        a(i, !this.ak ? true : f, (boolean) f);
    }

    protected void a(int i, float f, int i2) {
        int paddingLeft;
        int paddingRight;
        int i3;
        if (this.an > 0) {
            int scrollX = getScrollX();
            paddingLeft = getPaddingLeft();
            paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            i3 = at;
            while (i3 < childCount) {
                int i4;
                View childAt = getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.a) {
                    int max;
                    switch (layoutParams.b & 7) {
                        case g /*1*/:
                            max = Math.max((width - childAt.getMeasuredWidth()) / c, paddingLeft);
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        case a.l /*3*/:
                            max = childAt.getWidth() + paddingLeft;
                            i4 = paddingLeft;
                            paddingLeft = paddingRight;
                            paddingRight = max;
                            max = i4;
                            break;
                        case a.X /*5*/:
                            max = (width - paddingRight) - childAt.getMeasuredWidth();
                            i4 = paddingRight + childAt.getMeasuredWidth();
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        default:
                            max = paddingLeft;
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                    }
                    max = (max + scrollX) - childAt.getLeft();
                    if (max != 0) {
                        childAt.offsetLeftAndRight(max);
                    }
                } else {
                    i4 = paddingRight;
                    paddingRight = paddingLeft;
                    paddingLeft = i4;
                }
                i3 += g;
                i4 = paddingLeft;
                paddingLeft = paddingRight;
                paddingRight = i4;
            }
        }
        if (this.ao != null) {
            this.ao.a(i, f, i2);
        }
        if (this.ap != null) {
            this.ap.a(i, f, i2);
        }
        if (this.ar != null) {
            paddingRight = getScrollX();
            i3 = getChildCount();
            for (paddingLeft = at; paddingLeft < i3; paddingLeft += g) {
                View childAt2 = getChildAt(paddingLeft);
                if (!((LayoutParams) childAt2.getLayoutParams()).a) {
                    this.ar.a(childAt2, ((float) (childAt2.getLeft() - paddingRight)) / ((float) o()));
                }
            }
        }
        this.am = true;
    }

    void a(int i, int i2) {
        a(i, i2, (int) at);
    }

    void a(int i, int i2, int i3) {
        if (getChildCount() == 0) {
            e((boolean) f);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i4 = i - scrollX;
        int i5 = i2 - scrollY;
        if (i4 == 0 && i5 == 0) {
            b((boolean) f);
            g();
            h(at);
            return;
        }
        e(true);
        h(c);
        int o = o();
        int i6 = o / c;
        float a = (((float) i6) * a(Math.min(1.0f, (((float) Math.abs(i4)) * 1.0f) / ((float) o)))) + ((float) i6);
        int abs = Math.abs(i3);
        if (abs > 0) {
            o = Math.round(1000.0f * Math.abs(a / ((float) abs))) * 4;
        } else {
            o = (int) (((((float) Math.abs(i4)) / ((((float) o) * this.s.d(this.t)) + ((float) this.z))) + 1.0f) * CropOverlayView.a);
        }
        this.x.startScroll(scrollX, scrollY, i4, i5, Math.min(o, h));
        C0151az.d(this);
    }

    public void a(int i, boolean z) {
        this.J = f;
        a(i, z, (boolean) f);
    }

    void a(int i, boolean z, boolean z2) {
        a(i, z, z2, (int) at);
    }

    void a(int i, boolean z, boolean z2, int i2) {
        boolean z3 = f;
        if (this.s == null || this.s.b() <= 0) {
            e((boolean) f);
        } else if (z2 || this.t != i || this.p.size() == 0) {
            if (i < 0) {
                i = at;
            } else if (i >= this.s.b()) {
                i = this.s.b() + W;
            }
            int i3 = this.K;
            if (i > this.t + i3 || i < this.t - i3) {
                for (int i4 = at; i4 < this.p.size(); i4 += g) {
                    ((C0179bw) this.p.get(i4)).c = true;
                }
            }
            if (this.t != i) {
                z3 = true;
            }
            if (this.ak) {
                this.t = i;
                if (z3 && this.ao != null) {
                    this.ao.a(i);
                }
                if (z3 && this.ap != null) {
                    this.ap.a(i);
                }
                requestLayout();
                return;
            }
            e(i);
            a(i, z, i2, z3);
        } else {
            e((boolean) f);
        }
    }

    public void a(Drawable drawable) {
        this.A = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null ? true : f);
        invalidate();
    }

    public void a(ae aeVar) {
        if (this.s != null) {
            this.s.b(this.y);
            this.s.a((ViewGroup) this);
            for (int i = at; i < this.p.size(); i += g) {
                C0179bw c0179bw = (C0179bw) this.p.get(i);
                this.s.a((ViewGroup) this, c0179bw.b, c0179bw.a);
            }
            this.s.b((ViewGroup) this);
            this.p.clear();
            n();
            this.t = at;
            scrollTo(at, at);
        }
        ae aeVar2 = this.s;
        this.s = aeVar;
        this.m = at;
        if (this.s != null) {
            if (this.y == null) {
                this.y = new bB();
            }
            this.s.a(this.y);
            this.J = f;
            boolean z = this.ak;
            this.ak = true;
            this.m = this.s.b();
            if (this.u >= 0) {
                this.s.a(this.v, this.w);
                a(this.u, (boolean) f, true);
                this.u = W;
                this.v = null;
                this.w = null;
            } else if (z) {
                requestLayout();
            } else {
                g();
            }
        }
        if (this.aq != null && aeVar2 != aeVar) {
            this.aq.a(aeVar2, aeVar);
        }
    }

    void a(by byVar) {
        this.aq = byVar;
    }

    public void a(bz bzVar) {
        this.ao = bzVar;
    }

    void a(boolean z) {
        if (VERSION.SDK_INT >= 7) {
            if (this.as == null) {
                try {
                    Class[] clsArr = new Class[g];
                    clsArr[at] = Boolean.TYPE;
                    this.as = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", clsArr);
                } catch (Throwable e) {
                    Log.e(d, "Can't find setChildrenDrawingOrderEnabled", e);
                }
            }
            try {
                Method method = this.as;
                Object[] objArr = new Object[g];
                objArr[at] = Boolean.valueOf(z);
                method.invoke(this, objArr);
            } catch (Throwable e2) {
                Log.e(d, "Error changing children drawing order", e2);
            }
        }
    }

    public void a(boolean z, bA bAVar) {
        int i = g;
        if (VERSION.SDK_INT >= 11) {
            boolean z2 = bAVar != null ? true : f;
            int i2 = z2 != (this.ar != null ? g : at) ? g : at;
            this.ar = bAVar;
            a(z2);
            if (z2) {
                if (z) {
                    i = c;
                }
                this.aw = i;
            } else {
                this.aw = at;
            }
            if (i2 != 0) {
                g();
            }
        }
    }

    public boolean a(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return f;
        }
        switch (keyEvent.getKeyCode()) {
            case com.xiaomi.hm.health.bt.profile.a.a.Z /*21*/:
                return g(17);
            case com.xiaomi.hm.health.bt.profile.a.a.aa /*22*/:
                return g(66);
            case 61:
                return VERSION.SDK_INT >= 11 ? A.a(keyEvent) ? g(c) : A.a(keyEvent, (int) g) ? g(g) : f : f;
            default:
                return f;
        }
    }

    protected boolean a(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() + W; childCount >= 0; childCount += W) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
                    if (a(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        return (z && C0151az.a(view, -i)) ? true : f;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = at; i3 < getChildCount(); i3 += g) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    C0179bw a = a(childAt);
                    if (a != null && a.b == this.t) {
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
        for (int i = at; i < getChildCount(); i += g) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                C0179bw a = a(childAt);
                if (a != null && a.b == this.t) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        android.view.ViewGroup.LayoutParams generateLayoutParams = !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : layoutParams;
        LayoutParams layoutParams2 = (LayoutParams) generateLayoutParams;
        layoutParams2.a |= view instanceof bv;
        if (!this.H) {
            super.addView(view, i, generateLayoutParams);
        } else if (layoutParams2 == null || !layoutParams2.a) {
            layoutParams2.d = true;
            addViewInLayout(view, i, generateLayoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    public ae b() {
        return this.s;
    }

    C0179bw b(int i, int i2) {
        C0179bw c0179bw = new C0179bw();
        c0179bw.b = i;
        c0179bw.a = this.s.a((ViewGroup) this, i);
        c0179bw.d = this.s.d(i);
        if (i2 < 0 || i2 >= this.p.size()) {
            this.p.add(c0179bw);
        } else {
            this.p.add(i2, c0179bw);
        }
        return c0179bw;
    }

    C0179bw b(View view) {
        while (true) {
            ViewPager parent = view.getParent();
            if (parent == this) {
                return a(view);
            }
            if (parent != null && (parent instanceof View)) {
                view = parent;
            }
        }
        return null;
    }

    bz b(bz bzVar) {
        bz bzVar2 = this.ap;
        this.ap = bzVar;
        return bzVar2;
    }

    public void b(float f) {
        if (this.ag) {
            this.R += f;
            float scrollX = ((float) getScrollX()) - f;
            int o = o();
            float f2 = ((float) o) * this.E;
            C0179bw c0179bw = (C0179bw) this.p.get(at);
            C0179bw c0179bw2 = (C0179bw) this.p.get(this.p.size() + W);
            float f3 = c0179bw.b != 0 ? c0179bw.e * ((float) o) : ((float) o) * this.D;
            float f4 = c0179bw2.b != this.s.b() + W ? c0179bw2.e * ((float) o) : f2;
            if (scrollX >= f3) {
                f3 = scrollX > f4 ? f4 : scrollX;
            }
            this.R += f3 - ((float) ((int) f3));
            scrollTo((int) f3, getScrollY());
            i((int) f3);
            MotionEvent obtain = MotionEvent.obtain(this.ah, SystemClock.uptimeMillis(), c, this.R, 0.0f, at);
            this.aa.addMovement(obtain);
            obtain.recycle();
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public void b(int i) {
        if (i < g) {
            Log.w(d, "Requested offscreen page limit " + i + " too small; defaulting to " + g);
            i = g;
        }
        if (i != this.K) {
            this.K = i;
            g();
        }
    }

    public int c() {
        return this.t;
    }

    public void c(int i) {
        int i2 = this.z;
        this.z = i;
        int width = getWidth();
        a(width, width, i, i2);
        requestLayout();
    }

    public boolean canScrollHorizontally(int i) {
        boolean z = true;
        if (this.s == null) {
            return f;
        }
        int o = o();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX <= ((int) (((float) o) * this.D))) {
                z = f;
            }
            return z;
        } else if (i <= 0) {
            return f;
        } else {
            if (scrollX >= ((int) (((float) o) * this.E))) {
                z = f;
            }
            return z;
        }
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return ((layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams)) ? true : f;
    }

    public void computeScroll() {
        if (this.x.isFinished() || !this.x.computeScrollOffset()) {
            b(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.x.getCurrX();
        int currY = this.x.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!i(currX)) {
                this.x.abortAnimation();
                scrollTo(at, currY);
            }
        }
        C0151az.d(this);
    }

    public int d() {
        return this.K;
    }

    public void d(int i) {
        a(getContext().getResources().getDrawable(i));
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return (super.dispatchKeyEvent(keyEvent) || a(keyEvent)) ? true : f;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == ChartData.d) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = at; i < childCount; i += g) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                C0179bw a = a(childAt);
                if (a != null && a.b == this.t && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return f;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int i = at;
        int a = C0151az.a(this);
        if (a == 0 || (a == g && this.s != null && this.s.b() > g)) {
            int height;
            int width;
            if (!this.ai.a()) {
                a = canvas.save();
                height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                width = getWidth();
                canvas.rotate(BitmapDescriptorFactory.HUE_VIOLET);
                canvas.translate((float) ((-height) + getPaddingTop()), this.D * ((float) width));
                this.ai.a(height, width);
                i = at | this.ai.a(canvas);
                canvas.restoreToCount(a);
            }
            if (!this.aj.a()) {
                a = canvas.save();
                height = getWidth();
                width = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.E + 1.0f)) * ((float) height));
                this.aj.a(width, height);
                i |= this.aj.a(canvas);
                canvas.restoreToCount(a);
            }
        } else {
            this.ai.b();
            this.aj.b();
        }
        if (i != 0) {
            C0151az.d(this);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.A;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    public int e() {
        return this.z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void e(int r19) {
        /*
        r18 = this;
        r3 = 0;
        r2 = 2;
        r0 = r18;
        r4 = r0.t;
        r0 = r19;
        if (r4 == r0) goto L_0x033f;
    L_0x000a:
        r0 = r18;
        r2 = r0.t;
        r0 = r19;
        if (r2 >= r0) goto L_0x0030;
    L_0x0012:
        r2 = 66;
    L_0x0014:
        r0 = r18;
        r3 = r0.t;
        r0 = r18;
        r3 = r0.f(r3);
        r0 = r19;
        r1 = r18;
        r1.t = r0;
        r4 = r3;
        r3 = r2;
    L_0x0026:
        r0 = r18;
        r2 = r0.s;
        if (r2 != 0) goto L_0x0033;
    L_0x002c:
        r18.p();
    L_0x002f:
        return;
    L_0x0030:
        r2 = 17;
        goto L_0x0014;
    L_0x0033:
        r0 = r18;
        r2 = r0.J;
        if (r2 == 0) goto L_0x003d;
    L_0x0039:
        r18.p();
        goto L_0x002f;
    L_0x003d:
        r2 = r18.getWindowToken();
        if (r2 == 0) goto L_0x002f;
    L_0x0043:
        r0 = r18;
        r2 = r0.s;
        r0 = r18;
        r2.a(r0);
        r0 = r18;
        r2 = r0.K;
        r5 = 0;
        r0 = r18;
        r6 = r0.t;
        r6 = r6 - r2;
        r11 = java.lang.Math.max(r5, r6);
        r0 = r18;
        r5 = r0.s;
        r12 = r5.b();
        r5 = r12 + -1;
        r0 = r18;
        r6 = r0.t;
        r2 = r2 + r6;
        r13 = java.lang.Math.min(r5, r2);
        r0 = r18;
        r2 = r0.m;
        if (r12 == r2) goto L_0x00da;
    L_0x0073:
        r2 = r18.getResources();	 Catch:{ NotFoundException -> 0x00d0 }
        r3 = r18.getId();	 Catch:{ NotFoundException -> 0x00d0 }
        r2 = r2.getResourceName(r3);	 Catch:{ NotFoundException -> 0x00d0 }
    L_0x007f:
        r3 = new java.lang.IllegalStateException;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ";
        r4 = r4.append(r5);
        r0 = r18;
        r5 = r0.m;
        r4 = r4.append(r5);
        r5 = ", found: ";
        r4 = r4.append(r5);
        r4 = r4.append(r12);
        r5 = " Pager id: ";
        r4 = r4.append(r5);
        r2 = r4.append(r2);
        r4 = " Pager class: ";
        r2 = r2.append(r4);
        r4 = r18.getClass();
        r2 = r2.append(r4);
        r4 = " Problematic adapter: ";
        r2 = r2.append(r4);
        r0 = r18;
        r4 = r0.s;
        r4 = r4.getClass();
        r2 = r2.append(r4);
        r2 = r2.toString();
        r3.<init>(r2);
        throw r3;
    L_0x00d0:
        r2 = move-exception;
        r2 = r18.getId();
        r2 = java.lang.Integer.toHexString(r2);
        goto L_0x007f;
    L_0x00da:
        r6 = 0;
        r2 = 0;
        r5 = r2;
    L_0x00dd:
        r0 = r18;
        r2 = r0.p;
        r2 = r2.size();
        if (r5 >= r2) goto L_0x033c;
    L_0x00e7:
        r0 = r18;
        r2 = r0.p;
        r2 = r2.get(r5);
        r2 = (android.support.v4.view.C0179bw) r2;
        r7 = r2.b;
        r0 = r18;
        r8 = r0.t;
        if (r7 < r8) goto L_0x01cf;
    L_0x00f9:
        r7 = r2.b;
        r0 = r18;
        r8 = r0.t;
        if (r7 != r8) goto L_0x033c;
    L_0x0101:
        if (r2 != 0) goto L_0x0339;
    L_0x0103:
        if (r12 <= 0) goto L_0x0339;
    L_0x0105:
        r0 = r18;
        r2 = r0.t;
        r0 = r18;
        r2 = r0.b(r2, r5);
        r10 = r2;
    L_0x0110:
        if (r10 == 0) goto L_0x0180;
    L_0x0112:
        r9 = 0;
        r8 = r5 + -1;
        if (r8 < 0) goto L_0x01d4;
    L_0x0117:
        r0 = r18;
        r2 = r0.p;
        r2 = r2.get(r8);
        r2 = (android.support.v4.view.C0179bw) r2;
    L_0x0121:
        r14 = r18.o();
        if (r14 > 0) goto L_0x01d7;
    L_0x0127:
        r6 = 0;
    L_0x0128:
        r0 = r18;
        r7 = r0.t;
        r7 = r7 + -1;
        r16 = r7;
        r7 = r9;
        r9 = r16;
        r17 = r8;
        r8 = r5;
        r5 = r17;
    L_0x0138:
        if (r9 < 0) goto L_0x0142;
    L_0x013a:
        r15 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1));
        if (r15 < 0) goto L_0x0216;
    L_0x013e:
        if (r9 >= r11) goto L_0x0216;
    L_0x0140:
        if (r2 != 0) goto L_0x01e6;
    L_0x0142:
        r6 = r10.d;
        r9 = r8 + 1;
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));
        if (r2 >= 0) goto L_0x017b;
    L_0x014c:
        r0 = r18;
        r2 = r0.p;
        r2 = r2.size();
        if (r9 >= r2) goto L_0x024c;
    L_0x0156:
        r0 = r18;
        r2 = r0.p;
        r2 = r2.get(r9);
        r2 = (android.support.v4.view.C0179bw) r2;
        r7 = r2;
    L_0x0161:
        if (r14 > 0) goto L_0x024f;
    L_0x0163:
        r2 = 0;
        r5 = r2;
    L_0x0165:
        r0 = r18;
        r2 = r0.t;
        r2 = r2 + 1;
        r16 = r2;
        r2 = r7;
        r7 = r9;
        r9 = r16;
    L_0x0171:
        if (r9 >= r12) goto L_0x017b;
    L_0x0173:
        r11 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1));
        if (r11 < 0) goto L_0x029a;
    L_0x0177:
        if (r9 <= r13) goto L_0x029a;
    L_0x0179:
        if (r2 != 0) goto L_0x025c;
    L_0x017b:
        r0 = r18;
        r0.a(r10, r8, r4);
    L_0x0180:
        r0 = r18;
        r4 = r0.s;
        r0 = r18;
        r5 = r0.t;
        if (r10 == 0) goto L_0x02e8;
    L_0x018a:
        r2 = r10.a;
    L_0x018c:
        r0 = r18;
        r4.b(r0, r5, r2);
        r0 = r18;
        r2 = r0.s;
        r0 = r18;
        r2.b(r0);
        r5 = r18.getChildCount();
        r2 = 0;
        r4 = r2;
    L_0x01a0:
        if (r4 >= r5) goto L_0x02eb;
    L_0x01a2:
        r0 = r18;
        r6 = r0.getChildAt(r4);
        r2 = r6.getLayoutParams();
        r2 = (android.support.v4.view.ViewPager.LayoutParams) r2;
        r2.f = r4;
        r7 = r2.a;
        if (r7 != 0) goto L_0x01cb;
    L_0x01b4:
        r7 = r2.c;
        r8 = 0;
        r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1));
        if (r7 != 0) goto L_0x01cb;
    L_0x01bb:
        r0 = r18;
        r6 = r0.a(r6);
        if (r6 == 0) goto L_0x01cb;
    L_0x01c3:
        r7 = r6.d;
        r2.c = r7;
        r6 = r6.b;
        r2.e = r6;
    L_0x01cb:
        r2 = r4 + 1;
        r4 = r2;
        goto L_0x01a0;
    L_0x01cf:
        r2 = r5 + 1;
        r5 = r2;
        goto L_0x00dd;
    L_0x01d4:
        r2 = 0;
        goto L_0x0121;
    L_0x01d7:
        r6 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r7 = r10.d;
        r6 = r6 - r7;
        r7 = r18.getPaddingLeft();
        r7 = (float) r7;
        r15 = (float) r14;
        r7 = r7 / r15;
        r6 = r6 + r7;
        goto L_0x0128;
    L_0x01e6:
        r15 = r2.b;
        if (r9 != r15) goto L_0x0210;
    L_0x01ea:
        r15 = r2.c;
        if (r15 != 0) goto L_0x0210;
    L_0x01ee:
        r0 = r18;
        r15 = r0.p;
        r15.remove(r5);
        r0 = r18;
        r15 = r0.s;
        r2 = r2.a;
        r0 = r18;
        r15.a(r0, r9, r2);
        r5 = r5 + -1;
        r8 = r8 + -1;
        if (r5 < 0) goto L_0x0214;
    L_0x0206:
        r0 = r18;
        r2 = r0.p;
        r2 = r2.get(r5);
        r2 = (android.support.v4.view.C0179bw) r2;
    L_0x0210:
        r9 = r9 + -1;
        goto L_0x0138;
    L_0x0214:
        r2 = 0;
        goto L_0x0210;
    L_0x0216:
        if (r2 == 0) goto L_0x0230;
    L_0x0218:
        r15 = r2.b;
        if (r9 != r15) goto L_0x0230;
    L_0x021c:
        r2 = r2.d;
        r7 = r7 + r2;
        r5 = r5 + -1;
        if (r5 < 0) goto L_0x022e;
    L_0x0223:
        r0 = r18;
        r2 = r0.p;
        r2 = r2.get(r5);
        r2 = (android.support.v4.view.C0179bw) r2;
        goto L_0x0210;
    L_0x022e:
        r2 = 0;
        goto L_0x0210;
    L_0x0230:
        r2 = r5 + 1;
        r0 = r18;
        r2 = r0.b(r9, r2);
        r2 = r2.d;
        r7 = r7 + r2;
        r8 = r8 + 1;
        if (r5 < 0) goto L_0x024a;
    L_0x023f:
        r0 = r18;
        r2 = r0.p;
        r2 = r2.get(r5);
        r2 = (android.support.v4.view.C0179bw) r2;
        goto L_0x0210;
    L_0x024a:
        r2 = 0;
        goto L_0x0210;
    L_0x024c:
        r7 = 0;
        goto L_0x0161;
    L_0x024f:
        r2 = r18.getPaddingRight();
        r2 = (float) r2;
        r5 = (float) r14;
        r2 = r2 / r5;
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = r2 + r5;
        r5 = r2;
        goto L_0x0165;
    L_0x025c:
        r11 = r2.b;
        if (r9 != r11) goto L_0x0332;
    L_0x0260:
        r11 = r2.c;
        if (r11 != 0) goto L_0x0332;
    L_0x0264:
        r0 = r18;
        r11 = r0.p;
        r11.remove(r7);
        r0 = r18;
        r11 = r0.s;
        r2 = r2.a;
        r0 = r18;
        r11.a(r0, r9, r2);
        r0 = r18;
        r2 = r0.p;
        r2 = r2.size();
        if (r7 >= r2) goto L_0x0298;
    L_0x0280:
        r0 = r18;
        r2 = r0.p;
        r2 = r2.get(r7);
        r2 = (android.support.v4.view.C0179bw) r2;
    L_0x028a:
        r16 = r6;
        r6 = r2;
        r2 = r16;
    L_0x028f:
        r9 = r9 + 1;
        r16 = r2;
        r2 = r6;
        r6 = r16;
        goto L_0x0171;
    L_0x0298:
        r2 = 0;
        goto L_0x028a;
    L_0x029a:
        if (r2 == 0) goto L_0x02c1;
    L_0x029c:
        r11 = r2.b;
        if (r9 != r11) goto L_0x02c1;
    L_0x02a0:
        r2 = r2.d;
        r6 = r6 + r2;
        r7 = r7 + 1;
        r0 = r18;
        r2 = r0.p;
        r2 = r2.size();
        if (r7 >= r2) goto L_0x02bf;
    L_0x02af:
        r0 = r18;
        r2 = r0.p;
        r2 = r2.get(r7);
        r2 = (android.support.v4.view.C0179bw) r2;
    L_0x02b9:
        r16 = r6;
        r6 = r2;
        r2 = r16;
        goto L_0x028f;
    L_0x02bf:
        r2 = 0;
        goto L_0x02b9;
    L_0x02c1:
        r0 = r18;
        r2 = r0.b(r9, r7);
        r7 = r7 + 1;
        r2 = r2.d;
        r6 = r6 + r2;
        r0 = r18;
        r2 = r0.p;
        r2 = r2.size();
        if (r7 >= r2) goto L_0x02e6;
    L_0x02d6:
        r0 = r18;
        r2 = r0.p;
        r2 = r2.get(r7);
        r2 = (android.support.v4.view.C0179bw) r2;
    L_0x02e0:
        r16 = r6;
        r6 = r2;
        r2 = r16;
        goto L_0x028f;
    L_0x02e6:
        r2 = 0;
        goto L_0x02e0;
    L_0x02e8:
        r2 = 0;
        goto L_0x018c;
    L_0x02eb:
        r18.p();
        r2 = r18.hasFocus();
        if (r2 == 0) goto L_0x002f;
    L_0x02f4:
        r2 = r18.findFocus();
        if (r2 == 0) goto L_0x0330;
    L_0x02fa:
        r0 = r18;
        r2 = r0.b(r2);
    L_0x0300:
        if (r2 == 0) goto L_0x030a;
    L_0x0302:
        r2 = r2.b;
        r0 = r18;
        r4 = r0.t;
        if (r2 == r4) goto L_0x002f;
    L_0x030a:
        r2 = 0;
    L_0x030b:
        r4 = r18.getChildCount();
        if (r2 >= r4) goto L_0x002f;
    L_0x0311:
        r0 = r18;
        r4 = r0.getChildAt(r2);
        r0 = r18;
        r5 = r0.a(r4);
        if (r5 == 0) goto L_0x032d;
    L_0x031f:
        r5 = r5.b;
        r0 = r18;
        r6 = r0.t;
        if (r5 != r6) goto L_0x032d;
    L_0x0327:
        r4 = r4.requestFocus(r3);
        if (r4 != 0) goto L_0x002f;
    L_0x032d:
        r2 = r2 + 1;
        goto L_0x030b;
    L_0x0330:
        r2 = 0;
        goto L_0x0300;
    L_0x0332:
        r16 = r6;
        r6 = r2;
        r2 = r16;
        goto L_0x028f;
    L_0x0339:
        r10 = r2;
        goto L_0x0110;
    L_0x033c:
        r2 = r6;
        goto L_0x0101;
    L_0x033f:
        r4 = r3;
        r3 = r2;
        goto L_0x0026;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.e(int):void");
    }

    C0179bw f(int i) {
        for (int i2 = at; i2 < this.p.size(); i2 += g) {
            C0179bw c0179bw = (C0179bw) this.p.get(i2);
            if (c0179bw.b == i) {
                return c0179bw;
            }
        }
        return null;
    }

    void f() {
        int i;
        int b = this.s.b();
        this.m = b;
        boolean z = (this.p.size() >= (this.K * c) + g || this.p.size() >= b) ? f : true;
        boolean z2 = f;
        int i2 = this.t;
        boolean z3 = z;
        int i3 = at;
        while (i3 < this.p.size()) {
            int i4;
            boolean z4;
            boolean z5;
            C0179bw c0179bw = (C0179bw) this.p.get(i3);
            int a = this.s.a(c0179bw.a);
            if (a == W) {
                i4 = i3;
                z4 = z2;
                i = i2;
                z5 = z3;
            } else if (a == -2) {
                this.p.remove(i3);
                i3 += W;
                if (!z2) {
                    this.s.a((ViewGroup) this);
                    z2 = true;
                }
                this.s.a((ViewGroup) this, c0179bw.b, c0179bw.a);
                if (this.t == c0179bw.b) {
                    i4 = i3;
                    z4 = z2;
                    i = Math.max(at, Math.min(this.t, b + W));
                    z5 = true;
                } else {
                    i4 = i3;
                    z4 = z2;
                    i = i2;
                    z5 = true;
                }
            } else if (c0179bw.b != a) {
                if (c0179bw.b == this.t) {
                    i2 = a;
                }
                c0179bw.b = a;
                i4 = i3;
                z4 = z2;
                i = i2;
                z5 = true;
            } else {
                i4 = i3;
                z4 = z2;
                i = i2;
                z5 = z3;
            }
            z3 = z5;
            i2 = i;
            z2 = z4;
            i3 = i4 + g;
        }
        if (z2) {
            this.s.b((ViewGroup) this);
        }
        Collections.sort(this.p, n);
        if (z3) {
            i = getChildCount();
            for (i3 = at; i3 < i; i3 += g) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
                if (!layoutParams.a) {
                    layoutParams.c = 0.0f;
                }
            }
            a(i2, (boolean) f, true);
            requestLayout();
        }
    }

    void g() {
        e(this.t);
    }

    public boolean g(int i) {
        View view;
        boolean k;
        View findFocus = findFocus();
        if (findFocus == this) {
            view = null;
        } else {
            if (findFocus != null) {
                Object obj;
                for (ViewPager parent = findFocus.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                    if (parent == this) {
                        obj = g;
                        break;
                    }
                }
                obj = at;
                if (obj == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        stringBuilder.append(" => ").append(parent2.getClass().getSimpleName());
                    }
                    Log.e(d, "arrowScroll tried to find focus based on non-child current focused view " + stringBuilder.toString());
                    view = null;
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (findNextFocus == null || findNextFocus == view) {
            if (i == 17 || i == g) {
                k = k();
            } else {
                if (i == 66 || i == c) {
                    k = l();
                }
                k = f;
            }
        } else if (i == 17) {
            k = (view == null || a(this.r, findNextFocus).left < a(this.r, view).left) ? findNextFocus.requestFocus() : k();
        } else {
            if (i == 66) {
                k = (view == null || a(this.r, findNextFocus).left > a(this.r, view).left) ? findNextFocus.requestFocus() : l();
            }
            k = f;
        }
        if (k) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return k;
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

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.aw == c) {
            i2 = (i + W) - i2;
        }
        return ((LayoutParams) ((View) this.ax.get(i2)).getLayoutParams()).f;
    }

    public boolean h() {
        if (this.L) {
            return f;
        }
        this.ag = true;
        h(g);
        this.R = 0.0f;
        this.T = 0.0f;
        if (this.aa == null) {
            this.aa = VelocityTracker.obtain();
        } else {
            this.aa.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, at, 0.0f, 0.0f, at);
        this.aa.addMovement(obtain);
        obtain.recycle();
        this.ah = uptimeMillis;
        return true;
    }

    public void i() {
        if (this.ag) {
            VelocityTracker velocityTracker = this.aa;
            velocityTracker.computeCurrentVelocity(h.E, (float) this.ac);
            int a = (int) C0146au.a(velocityTracker, this.V);
            this.J = true;
            int o = o();
            int scrollX = getScrollX();
            C0179bw q = q();
            a(a(q.b, ((((float) scrollX) / ((float) o)) - q.e) / q.d, a, (int) (this.R - this.T)), true, true, a);
            r();
            this.ag = f;
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public boolean j() {
        return this.ag;
    }

    boolean k() {
        if (this.t <= 0) {
            return f;
        }
        a(this.t + W, true);
        return true;
    }

    boolean l() {
        if (this.s == null || this.t >= this.s.b() + W) {
            return f;
        }
        a(this.t + g, true);
        return true;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.ak = true;
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.az);
        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.z > 0 && this.A != null && this.p.size() > 0 && this.s != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f = ((float) this.z) / ((float) width);
            C0179bw c0179bw = (C0179bw) this.p.get(at);
            float f2 = c0179bw.e;
            int size = this.p.size();
            int i = c0179bw.b;
            int i2 = ((C0179bw) this.p.get(size + W)).b;
            int i3 = at;
            int i4 = i;
            while (i4 < i2) {
                float f3;
                while (i4 > c0179bw.b && i3 < size) {
                    i3 += g;
                    c0179bw = (C0179bw) this.p.get(i3);
                }
                if (i4 == c0179bw.b) {
                    f3 = (c0179bw.e + c0179bw.d) * ((float) width);
                    f2 = (c0179bw.e + c0179bw.d) + f;
                } else {
                    float d = this.s.d(i4);
                    f3 = (f2 + d) * ((float) width);
                    f2 += d + f;
                }
                if (((float) this.z) + f3 > ((float) scrollX)) {
                    this.A.setBounds((int) f3, this.B, (int) ((((float) this.z) + f3) + 0.5f), this.C);
                    this.A.draw(canvas);
                }
                if (f3 <= ((float) (scrollX + width))) {
                    i4 += g;
                } else {
                    return;
                }
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & HeartRateInfo.HR_EMPTY_VALUE;
        if (action == 3 || action == g) {
            this.L = f;
            this.M = f;
            this.V = W;
            if (this.aa == null) {
                return f;
            }
            this.aa.recycle();
            this.aa = null;
            return f;
        }
        if (action != 0) {
            if (this.L) {
                return true;
            }
            if (this.M) {
                return f;
            }
        }
        switch (action) {
            case at /*0*/:
                float x = motionEvent.getX();
                this.T = x;
                this.R = x;
                x = motionEvent.getY();
                this.U = x;
                this.S = x;
                this.V = Y.b(motionEvent, at);
                this.M = f;
                this.x.computeScrollOffset();
                if (this.aA == c && Math.abs(this.x.getFinalX() - this.x.getCurrX()) > this.ae) {
                    this.x.abortAnimation();
                    this.J = f;
                    g();
                    this.L = true;
                    d(true);
                    h(g);
                    break;
                }
                b((boolean) f);
                this.L = f;
                break;
                break;
            case c /*2*/:
                action = this.V;
                if (action != W) {
                    action = Y.a(motionEvent, action);
                    float c = Y.c(motionEvent, action);
                    float f = c - this.R;
                    float abs = Math.abs(f);
                    float d = Y.d(motionEvent, action);
                    float abs2 = Math.abs(d - this.U);
                    if (f == 0.0f || a(this.R, f) || !a(this, f, (int) f, (int) c, (int) d)) {
                        if (abs > ((float) this.Q) && 0.5f * abs > abs2) {
                            this.L = true;
                            d(true);
                            h(g);
                            this.R = f > 0.0f ? this.T + ((float) this.Q) : this.T - ((float) this.Q);
                            this.S = d;
                            e(true);
                        } else if (abs2 > ((float) this.Q)) {
                            this.M = true;
                        }
                        if (this.L && c(c)) {
                            C0151az.d(this);
                            break;
                        }
                    }
                    this.R = c;
                    this.S = d;
                    this.M = true;
                    return f;
                }
                break;
            case a.bt /*6*/:
                a(motionEvent);
                break;
        }
        if (this.aa == null) {
            this.aa = VelocityTracker.obtain();
        }
        this.aa.addMovement(motionEvent);
        return this.L;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int max;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i7 = at;
        int i8 = at;
        while (i8 < childCount) {
            LayoutParams layoutParams;
            int measuredWidth;
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.a) {
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
                        case j /*16*/:
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
                    max += scrollX;
                    childAt.layout(max, measuredWidth, childAt.getMeasuredWidth() + max, childAt.getMeasuredHeight() + measuredWidth);
                    measuredWidth = i7 + g;
                    i7 = paddingBottom;
                    paddingBottom = paddingTop;
                    paddingTop = paddingRight;
                    paddingRight = paddingLeft;
                    i8 += g;
                    paddingLeft = paddingRight;
                    paddingRight = paddingTop;
                    paddingTop = i7;
                    i7 = measuredWidth;
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
        max = (i5 - paddingLeft) - paddingRight;
        for (paddingRight = at; paddingRight < childCount; paddingRight += g) {
            View childAt2 = getChildAt(paddingRight);
            if (childAt2.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams.a) {
                    C0179bw a = a(childAt2);
                    if (a != null) {
                        i5 = ((int) (a.e * ((float) max))) + paddingLeft;
                        if (layoutParams.d) {
                            layoutParams.d = f;
                            childAt2.measure(MeasureSpec.makeMeasureSpec((int) (layoutParams.c * ((float) max)), 1073741824), MeasureSpec.makeMeasureSpec((i6 - paddingTop) - paddingBottom, 1073741824));
                        }
                        childAt2.layout(i5, paddingTop, childAt2.getMeasuredWidth() + i5, childAt2.getMeasuredHeight() + paddingTop);
                    }
                }
            }
        }
        this.B = paddingTop;
        this.C = i6 - paddingBottom;
        this.an = i7;
        if (this.ak) {
            a(this.t, (boolean) f, (int) at, (boolean) f);
        }
        this.ak = f;
    }

    protected void onMeasure(int i, int i2) {
        LayoutParams layoutParams;
        int i3;
        setMeasuredDimension(getDefaultSize(at, i), getDefaultSize(at, i2));
        int measuredWidth = getMeasuredWidth();
        this.P = Math.min(measuredWidth / 10, this.O);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        for (int i4 = at; i4 < childCount; i4 += g) {
            int i5;
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams != null && layoutParams.a) {
                    int i6 = layoutParams.b & 7;
                    int i7 = layoutParams.b & 112;
                    i3 = af.a;
                    i5 = af.a;
                    Object obj = (i7 == 48 || i7 == 80) ? g : at;
                    Object obj2 = (i6 == 3 || i6 == 5) ? g : at;
                    if (obj != null) {
                        i3 = 1073741824;
                    } else if (obj2 != null) {
                        i5 = 1073741824;
                    }
                    if (layoutParams.width != -2) {
                        i7 = 1073741824;
                        i3 = layoutParams.width != W ? layoutParams.width : paddingLeft;
                    } else {
                        i7 = i3;
                        i3 = paddingLeft;
                    }
                    if (layoutParams.height != -2) {
                        i5 = 1073741824;
                        if (layoutParams.height != W) {
                            measuredWidth = layoutParams.height;
                            childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i5));
                            if (obj != null) {
                                measuredHeight -= childAt.getMeasuredHeight();
                            } else if (obj2 != null) {
                                paddingLeft -= childAt.getMeasuredWidth();
                            }
                        }
                    }
                    measuredWidth = measuredHeight;
                    childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i5));
                    if (obj != null) {
                        measuredHeight -= childAt.getMeasuredHeight();
                    } else if (obj2 != null) {
                        paddingLeft -= childAt.getMeasuredWidth();
                    }
                }
            }
        }
        this.F = MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.G = MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.H = true;
        g();
        this.H = f;
        i3 = getChildCount();
        for (i5 = at; i5 < i3; i5 += g) {
            View childAt2 = getChildAt(i5);
            if (childAt2.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt2.getLayoutParams();
                if (layoutParams == null || !layoutParams.a) {
                    childAt2.measure(MeasureSpec.makeMeasureSpec((int) (layoutParams.c * ((float) paddingLeft)), 1073741824), this.G);
                }
            }
        }
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3 = W;
        int childCount = getChildCount();
        if ((i & c) != 0) {
            i3 = g;
            i2 = at;
        } else {
            i2 = childCount + W;
            childCount = W;
        }
        while (i2 != childCount) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                C0179bw a = a(childAt);
                if (a != null && a.b == this.t && childAt.requestFocus(i, rect)) {
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
            if (this.s != null) {
                this.s.a(savedState.b, savedState.c);
                a(savedState.a, (boolean) f, true);
                return;
            }
            this.u = savedState.a;
            this.v = savedState.b;
            this.w = savedState.c;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.t;
        if (this.s != null) {
            savedState.b = this.s.a();
        }
        return savedState;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            a(i, i3, this.z, this.z);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = f;
        if (this.ag) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return f;
        }
        if (this.s == null || this.s.b() == 0) {
            return f;
        }
        if (this.aa == null) {
            this.aa = VelocityTracker.obtain();
        }
        this.aa.addMovement(motionEvent);
        float x;
        int a;
        switch (motionEvent.getAction() & HeartRateInfo.HR_EMPTY_VALUE) {
            case at /*0*/:
                this.x.abortAnimation();
                this.J = f;
                g();
                x = motionEvent.getX();
                this.T = x;
                this.R = x;
                x = motionEvent.getY();
                this.U = x;
                this.S = x;
                this.V = Y.b(motionEvent, at);
                break;
            case g /*1*/:
                if (this.L) {
                    VelocityTracker velocityTracker = this.aa;
                    velocityTracker.computeCurrentVelocity(h.E, (float) this.ac);
                    a = (int) C0146au.a(velocityTracker, this.V);
                    this.J = true;
                    int o = o();
                    int scrollX = getScrollX();
                    C0179bw q = q();
                    a(a(q.b, ((((float) scrollX) / ((float) o)) - q.e) / q.d, a, (int) (Y.c(motionEvent, Y.a(motionEvent, this.V)) - this.T)), true, true, a);
                    this.V = W;
                    r();
                    z = this.aj.c() | this.ai.c();
                    break;
                }
                break;
            case c /*2*/:
                if (!this.L) {
                    a = Y.a(motionEvent, this.V);
                    float c = Y.c(motionEvent, a);
                    float abs = Math.abs(c - this.R);
                    float d = Y.d(motionEvent, a);
                    x = Math.abs(d - this.S);
                    if (abs > ((float) this.Q) && abs > x) {
                        this.L = true;
                        d(true);
                        this.R = c - this.T > 0.0f ? this.T + ((float) this.Q) : this.T - ((float) this.Q);
                        this.S = d;
                        h(g);
                        e(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
                if (this.L) {
                    z = f | c(Y.c(motionEvent, Y.a(motionEvent, this.V)));
                    break;
                }
                break;
            case a.l /*3*/:
                if (this.L) {
                    a(this.t, true, (int) at, (boolean) f);
                    this.V = W;
                    r();
                    z = this.aj.c() | this.ai.c();
                    break;
                }
                break;
            case a.X /*5*/:
                a = Y.b(motionEvent);
                this.R = Y.c(motionEvent, a);
                this.V = Y.b(motionEvent, a);
                break;
            case a.bt /*6*/:
                a(motionEvent);
                this.R = Y.c(motionEvent, Y.a(motionEvent, this.V));
                break;
        }
        if (z) {
            C0151az.d(this);
        }
        return true;
    }

    public void removeView(View view) {
        if (this.H) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return (super.verifyDrawable(drawable) || drawable == this.A) ? true : f;
    }
}
