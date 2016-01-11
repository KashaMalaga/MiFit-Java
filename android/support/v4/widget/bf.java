package android.support.v4.widget;

import android.content.Context;
import android.support.v4.view.C0146au;
import android.support.v4.view.C0151az;
import android.support.v4.view.Y;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.xiaomi.account.openauth.h;
import java.util.Arrays;
import kankan.wheel.widget.a;

public class bf {
    private static final Interpolator L = new bg();
    public static final int a = -1;
    public static final int b = 0;
    public static final int c = 1;
    public static final int d = 2;
    public static final int e = 1;
    public static final int f = 2;
    public static final int g = 4;
    public static final int h = 8;
    public static final int i = 15;
    public static final int j = 1;
    public static final int k = 2;
    public static final int l = 3;
    private static final String m = "ViewDragHelper";
    private static final int n = 20;
    private static final int o = 256;
    private static final int p = 600;
    private int A;
    private VelocityTracker B;
    private float C;
    private float D;
    private int E;
    private int F;
    private C0219am G;
    private final bi H;
    private View I;
    private boolean J;
    private final ViewGroup K;
    private final Runnable M = new bh(this);
    private int q;
    private int r;
    private int s = a;
    private float[] t;
    private float[] u;
    private float[] v;
    private float[] w;
    private int[] x;
    private int[] y;
    private int[] z;

    private bf(Context context, ViewGroup viewGroup, bi biVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (biVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.K = viewGroup;
            this.H = biVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.E = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.r = viewConfiguration.getScaledTouchSlop();
            this.C = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.D = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.G = C0219am.a(context, L);
        }
    }

    private float a(float f, float f2, float f3) {
        float abs = Math.abs(f);
        return abs < f2 ? 0.0f : abs > f3 ? f <= 0.0f ? -f3 : f3 : f;
    }

    private int a(int i, int i2, int i3) {
        if (i == 0) {
            return b;
        }
        int width = this.K.getWidth();
        int i4 = width / k;
        float b = (b(Math.min(1.0f, ((float) Math.abs(i)) / ((float) width))) * ((float) i4)) + ((float) i4);
        i4 = Math.abs(i2);
        return Math.min(i4 > 0 ? Math.round(Math.abs(b / ((float) i4)) * 1000.0f) * g : (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f), p);
    }

    private int a(View view, int i, int i2, int i3, int i4) {
        int b = b(i3, (int) this.D, (int) this.C);
        int b2 = b(i4, (int) this.D, (int) this.C);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(b);
        int abs4 = Math.abs(b2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        return (int) (((b2 != 0 ? ((float) abs4) / ((float) i5) : ((float) abs2) / ((float) i6)) * ((float) a(i2, b2, this.H.b(view)))) + ((b != 0 ? ((float) abs3) / ((float) i5) : ((float) abs) / ((float) i6)) * ((float) a(i, b, this.H.a(view)))));
    }

    public static bf a(ViewGroup viewGroup, float f, bi biVar) {
        bf a = a(viewGroup, biVar);
        a.r = (int) (((float) a.r) * (1.0f / f));
        return a;
    }

    public static bf a(ViewGroup viewGroup, bi biVar) {
        return new bf(viewGroup.getContext(), viewGroup, biVar);
    }

    private void a(float f, float f2) {
        this.J = true;
        this.H.a(this.I, f, f2);
        this.J = false;
        if (this.q == j) {
            c((int) b);
        }
    }

    private void a(float f, float f2, int i) {
        g(i);
        float[] fArr = this.t;
        this.v[i] = f;
        fArr[i] = f;
        fArr = this.u;
        this.w[i] = f2;
        fArr[i] = f2;
        this.x[i] = f((int) f, (int) f2);
        this.A |= j << i;
    }

    private boolean a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.x[i] & i2) != i2 || (this.F & i2) == 0 || (this.z[i] & i2) == i2 || (this.y[i] & i2) == i2) {
            return false;
        }
        if (abs <= ((float) this.r) && abs2 <= ((float) this.r)) {
            return false;
        }
        if (abs >= abs2 * 0.5f || !this.H.b(i2)) {
            return (this.y[i] & i2) == 0 && abs > ((float) this.r);
        } else {
            int[] iArr = this.z;
            iArr[i] = iArr[i] | i2;
            return false;
        }
    }

    private boolean a(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.H.a(view) > 0 ? true : b;
        boolean z2 = this.H.b(view) > 0 ? true : b;
        return (z && z2) ? (f * f) + (f2 * f2) > ((float) (this.r * this.r)) : z ? Math.abs(f) > ((float) this.r) : z2 ? Math.abs(f2) > ((float) this.r) : false;
    }

    private float b(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    private int b(int i, int i2, int i3) {
        int abs = Math.abs(i);
        return abs < i2 ? b : abs > i3 ? i <= 0 ? -i3 : i3 : i;
    }

    private void b(float f, float f2, int i) {
        int i2 = j;
        if (!a(f, f2, i, (int) j)) {
            i2 = b;
        }
        if (a(f2, f, i, (int) g)) {
            i2 |= g;
        }
        if (a(f, f2, i, (int) k)) {
            i2 |= k;
        }
        if (a(f2, f, i, (int) h)) {
            i2 |= h;
        }
        if (i2 != 0) {
            int[] iArr = this.y;
            iArr[i] = iArr[i] | i2;
            this.H.b(i2, i);
        }
    }

    private boolean b(int i, int i2, int i3, int i4) {
        int left = this.I.getLeft();
        int top = this.I.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.G.h();
            c((int) b);
            return false;
        }
        this.G.a(left, top, i5, i6, a(this.I, i5, i6, i3, i4));
        c((int) k);
        return true;
    }

    private void c(int i, int i2, int i3, int i4) {
        int a;
        int b;
        int left = this.I.getLeft();
        int top = this.I.getTop();
        if (i3 != 0) {
            a = this.H.a(this.I, i, i3);
            this.I.offsetLeftAndRight(a - left);
        } else {
            a = i;
        }
        if (i4 != 0) {
            b = this.H.b(this.I, i2, i4);
            this.I.offsetTopAndBottom(b - top);
        } else {
            b = i2;
        }
        if (i3 != 0 || i4 != 0) {
            this.H.a(this.I, a, b, a - left, b - top);
        }
    }

    private void c(MotionEvent motionEvent) {
        int c = Y.c(motionEvent);
        for (int i = b; i < c; i += j) {
            int b = Y.b(motionEvent, i);
            float c2 = Y.c(motionEvent, i);
            float d = Y.d(motionEvent, i);
            this.v[b] = c2;
            this.w[b] = d;
        }
    }

    private int f(int i, int i2) {
        int i3 = b;
        if (i < this.K.getLeft() + this.E) {
            i3 = j;
        }
        if (i2 < this.K.getTop() + this.E) {
            i3 |= g;
        }
        if (i > this.K.getRight() - this.E) {
            i3 |= k;
        }
        return i2 > this.K.getBottom() - this.E ? i3 | h : i3;
    }

    private void f(int i) {
        if (this.t != null) {
            this.t[i] = 0.0f;
            this.u[i] = 0.0f;
            this.v[i] = 0.0f;
            this.w[i] = 0.0f;
            this.x[i] = b;
            this.y[i] = b;
            this.z[i] = b;
            this.A &= (j << i) ^ a;
        }
    }

    private void g(int i) {
        if (this.t == null || this.t.length <= i) {
            Object obj = new float[(i + j)];
            Object obj2 = new float[(i + j)];
            Object obj3 = new float[(i + j)];
            Object obj4 = new float[(i + j)];
            Object obj5 = new int[(i + j)];
            Object obj6 = new int[(i + j)];
            Object obj7 = new int[(i + j)];
            if (this.t != null) {
                System.arraycopy(this.t, b, obj, b, this.t.length);
                System.arraycopy(this.u, b, obj2, b, this.u.length);
                System.arraycopy(this.v, b, obj3, b, this.v.length);
                System.arraycopy(this.w, b, obj4, b, this.w.length);
                System.arraycopy(this.x, b, obj5, b, this.x.length);
                System.arraycopy(this.y, b, obj6, b, this.y.length);
                System.arraycopy(this.z, b, obj7, b, this.z.length);
            }
            this.t = obj;
            this.u = obj2;
            this.v = obj3;
            this.w = obj4;
            this.x = obj5;
            this.y = obj6;
            this.z = obj7;
        }
    }

    private void i() {
        if (this.t != null) {
            Arrays.fill(this.t, 0.0f);
            Arrays.fill(this.u, 0.0f);
            Arrays.fill(this.v, 0.0f);
            Arrays.fill(this.w, 0.0f);
            Arrays.fill(this.x, b);
            Arrays.fill(this.y, b);
            Arrays.fill(this.z, b);
            this.A = b;
        }
    }

    private void j() {
        this.B.computeCurrentVelocity(h.E, this.C);
        a(a(C0146au.a(this.B, this.s), this.D, this.C), a(C0146au.b(this.B, this.s), this.D, this.C));
    }

    public float a() {
        return this.D;
    }

    public void a(float f) {
        this.D = f;
    }

    public void a(int i) {
        this.F = i;
    }

    public void a(int i, int i2, int i3, int i4) {
        if (this.J) {
            this.G.a(this.I.getLeft(), this.I.getTop(), (int) C0146au.a(this.B, this.s), (int) C0146au.b(this.B, this.s), i, i3, i2, i4);
            c((int) k);
            return;
        }
        throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
    }

    public void a(View view, int i) {
        if (view.getParent() != this.K) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.K + ")");
        }
        this.I = view;
        this.s = i;
        this.H.b(view, i);
        c((int) j);
    }

    public boolean a(int i, int i2) {
        if (this.J) {
            return b(i, i2, (int) C0146au.a(this.B, this.s), (int) C0146au.b(this.B, this.s));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(android.view.MotionEvent r14) {
        /*
        r13 = this;
        r0 = android.support.v4.view.Y.a(r14);
        r1 = android.support.v4.view.Y.b(r14);
        if (r0 != 0) goto L_0x000d;
    L_0x000a:
        r13.g();
    L_0x000d:
        r2 = r13.B;
        if (r2 != 0) goto L_0x0017;
    L_0x0011:
        r2 = android.view.VelocityTracker.obtain();
        r13.B = r2;
    L_0x0017:
        r2 = r13.B;
        r2.addMovement(r14);
        switch(r0) {
            case 0: goto L_0x0026;
            case 1: goto L_0x0119;
            case 2: goto L_0x0092;
            case 3: goto L_0x0119;
            case 4: goto L_0x001f;
            case 5: goto L_0x005a;
            case 6: goto L_0x0110;
            default: goto L_0x001f;
        };
    L_0x001f:
        r0 = r13.q;
        r1 = 1;
        if (r0 != r1) goto L_0x011e;
    L_0x0024:
        r0 = 1;
    L_0x0025:
        return r0;
    L_0x0026:
        r0 = r14.getX();
        r1 = r14.getY();
        r2 = 0;
        r2 = android.support.v4.view.Y.b(r14, r2);
        r13.a(r0, r1, r2);
        r0 = (int) r0;
        r1 = (int) r1;
        r0 = r13.e(r0, r1);
        r1 = r13.I;
        if (r0 != r1) goto L_0x0048;
    L_0x0040:
        r1 = r13.q;
        r3 = 2;
        if (r1 != r3) goto L_0x0048;
    L_0x0045:
        r13.b(r0, r2);
    L_0x0048:
        r0 = r13.x;
        r0 = r0[r2];
        r1 = r13.F;
        r1 = r1 & r0;
        if (r1 == 0) goto L_0x001f;
    L_0x0051:
        r1 = r13.H;
        r3 = r13.F;
        r0 = r0 & r3;
        r1.a(r0, r2);
        goto L_0x001f;
    L_0x005a:
        r0 = android.support.v4.view.Y.b(r14, r1);
        r2 = android.support.v4.view.Y.c(r14, r1);
        r1 = android.support.v4.view.Y.d(r14, r1);
        r13.a(r2, r1, r0);
        r3 = r13.q;
        if (r3 != 0) goto L_0x007f;
    L_0x006d:
        r1 = r13.x;
        r1 = r1[r0];
        r2 = r13.F;
        r2 = r2 & r1;
        if (r2 == 0) goto L_0x001f;
    L_0x0076:
        r2 = r13.H;
        r3 = r13.F;
        r1 = r1 & r3;
        r2.a(r1, r0);
        goto L_0x001f;
    L_0x007f:
        r3 = r13.q;
        r4 = 2;
        if (r3 != r4) goto L_0x001f;
    L_0x0084:
        r2 = (int) r2;
        r1 = (int) r1;
        r1 = r13.e(r2, r1);
        r2 = r13.I;
        if (r1 != r2) goto L_0x001f;
    L_0x008e:
        r13.b(r1, r0);
        goto L_0x001f;
    L_0x0092:
        r2 = android.support.v4.view.Y.c(r14);
        r0 = 0;
        r1 = r0;
    L_0x0098:
        if (r1 >= r2) goto L_0x00f5;
    L_0x009a:
        r3 = android.support.v4.view.Y.b(r14, r1);
        r0 = android.support.v4.view.Y.c(r14, r1);
        r4 = android.support.v4.view.Y.d(r14, r1);
        r5 = r13.t;
        r5 = r5[r3];
        r5 = r0 - r5;
        r6 = r13.u;
        r6 = r6[r3];
        r6 = r4 - r6;
        r0 = (int) r0;
        r4 = (int) r4;
        r4 = r13.e(r0, r4);
        if (r4 == 0) goto L_0x00fa;
    L_0x00ba:
        r0 = r13.a(r4, r5, r6);
        if (r0 == 0) goto L_0x00fa;
    L_0x00c0:
        r0 = 1;
    L_0x00c1:
        if (r0 == 0) goto L_0x00fc;
    L_0x00c3:
        r7 = r4.getLeft();
        r8 = (int) r5;
        r8 = r8 + r7;
        r9 = r13.H;
        r10 = (int) r5;
        r8 = r9.a(r4, r8, r10);
        r9 = r4.getTop();
        r10 = (int) r6;
        r10 = r10 + r9;
        r11 = r13.H;
        r12 = (int) r6;
        r10 = r11.b(r4, r10, r12);
        r11 = r13.H;
        r11 = r11.a(r4);
        r12 = r13.H;
        r12 = r12.b(r4);
        if (r11 == 0) goto L_0x00ef;
    L_0x00eb:
        if (r11 <= 0) goto L_0x00fc;
    L_0x00ed:
        if (r8 != r7) goto L_0x00fc;
    L_0x00ef:
        if (r12 == 0) goto L_0x00f5;
    L_0x00f1:
        if (r12 <= 0) goto L_0x00fc;
    L_0x00f3:
        if (r10 != r9) goto L_0x00fc;
    L_0x00f5:
        r13.c(r14);
        goto L_0x001f;
    L_0x00fa:
        r0 = 0;
        goto L_0x00c1;
    L_0x00fc:
        r13.b(r5, r6, r3);
        r5 = r13.q;
        r6 = 1;
        if (r5 == r6) goto L_0x00f5;
    L_0x0104:
        if (r0 == 0) goto L_0x010c;
    L_0x0106:
        r0 = r13.b(r4, r3);
        if (r0 != 0) goto L_0x00f5;
    L_0x010c:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0098;
    L_0x0110:
        r0 = android.support.v4.view.Y.b(r14, r1);
        r13.f(r0);
        goto L_0x001f;
    L_0x0119:
        r13.g();
        goto L_0x001f;
    L_0x011e:
        r0 = 0;
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.bf.a(android.view.MotionEvent):boolean");
    }

    public boolean a(View view, int i, int i2) {
        this.I = view;
        this.s = a;
        boolean b = b(i, i2, b, b);
        if (!(b || this.q != 0 || this.I == null)) {
            this.I = null;
        }
        return b;
    }

    protected boolean a(View view, boolean z, int i, int i2, int i3, int i4) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() + a; childCount >= 0; childCount += a) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i3 + scrollX >= childAt.getLeft() && i3 + scrollX < childAt.getRight() && i4 + scrollY >= childAt.getTop() && i4 + scrollY < childAt.getBottom()) {
                    if (a(childAt, true, i, i2, (i3 + scrollX) - childAt.getLeft(), (i4 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        return z && (C0151az.a(view, -i) || C0151az.b(view, -i2));
    }

    public boolean a(boolean z) {
        if (this.q == k) {
            int i;
            boolean g = this.G.g();
            int b = this.G.b();
            int c = this.G.c();
            int left = b - this.I.getLeft();
            int top = c - this.I.getTop();
            if (left != 0) {
                this.I.offsetLeftAndRight(left);
            }
            if (top != 0) {
                this.I.offsetTopAndBottom(top);
            }
            if (!(left == 0 && top == 0)) {
                this.H.a(this.I, b, c, left, top);
            }
            if (g && b == this.G.d() && c == this.G.e()) {
                this.G.h();
                i = b;
            } else {
                boolean z2 = g;
            }
            if (i == 0) {
                if (z) {
                    this.K.post(this.M);
                } else {
                    c((int) b);
                }
            }
        }
        return this.q == k;
    }

    public int b() {
        return this.q;
    }

    public void b(MotionEvent motionEvent) {
        int i = b;
        int a = Y.a(motionEvent);
        int b = Y.b(motionEvent);
        if (a == 0) {
            g();
        }
        if (this.B == null) {
            this.B = VelocityTracker.obtain();
        }
        this.B.addMovement(motionEvent);
        float x;
        float y;
        View e;
        int i2;
        switch (a) {
            case b /*0*/:
                x = motionEvent.getX();
                y = motionEvent.getY();
                i = Y.b(motionEvent, b);
                e = e((int) x, (int) y);
                a(x, y, i);
                b(e, i);
                i2 = this.x[i];
                if ((this.F & i2) != 0) {
                    this.H.a(i2 & this.F, i);
                    return;
                }
                return;
            case j /*1*/:
                if (this.q == j) {
                    j();
                }
                g();
                return;
            case k /*2*/:
                if (this.q == j) {
                    i = Y.a(motionEvent, this.s);
                    x = Y.c(motionEvent, i);
                    i2 = (int) (x - this.v[this.s]);
                    i = (int) (Y.d(motionEvent, i) - this.w[this.s]);
                    c(this.I.getLeft() + i2, this.I.getTop() + i, i2, i);
                    c(motionEvent);
                    return;
                }
                i2 = Y.c(motionEvent);
                while (i < i2) {
                    a = Y.b(motionEvent, i);
                    float c = Y.c(motionEvent, i);
                    float d = Y.d(motionEvent, i);
                    float f = c - this.t[a];
                    float f2 = d - this.u[a];
                    b(f, f2, a);
                    if (this.q != j) {
                        e = e((int) c, (int) d);
                        if (!a(e, f, f2) || !b(e, a)) {
                            i += j;
                        }
                    }
                    c(motionEvent);
                    return;
                }
                c(motionEvent);
                return;
            case l /*3*/:
                if (this.q == j) {
                    a(0.0f, 0.0f);
                }
                g();
                return;
            case a.X /*5*/:
                i = Y.b(motionEvent, b);
                x = Y.c(motionEvent, b);
                y = Y.d(motionEvent, b);
                a(x, y, i);
                if (this.q == 0) {
                    b(e((int) x, (int) y), i);
                    i2 = this.x[i];
                    if ((this.F & i2) != 0) {
                        this.H.a(i2 & this.F, i);
                        return;
                    }
                    return;
                } else if (d((int) x, (int) y)) {
                    b(this.I, i);
                    return;
                } else {
                    return;
                }
            case a.bt /*6*/:
                a = Y.b(motionEvent, b);
                if (this.q == j && a == this.s) {
                    b = Y.c(motionEvent);
                    while (i < b) {
                        int b2 = Y.b(motionEvent, i);
                        if (b2 != this.s) {
                            if (e((int) Y.c(motionEvent, i), (int) Y.d(motionEvent, i)) == this.I && b(this.I, b2)) {
                                i = this.s;
                                if (i == a) {
                                    j();
                                }
                            }
                        }
                        i += j;
                    }
                    i = a;
                    if (i == a) {
                        j();
                    }
                }
                f(a);
                return;
            default:
                return;
        }
    }

    public boolean b(int i) {
        return (this.A & (j << i)) != 0;
    }

    public boolean b(int i, int i2) {
        if (!b(i2)) {
            return false;
        }
        boolean z = (i & j) == j ? true : b;
        boolean z2 = (i & k) == k ? true : b;
        float f = this.v[i2] - this.t[i2];
        float f2 = this.w[i2] - this.u[i2];
        return (z && z2) ? (f * f) + (f2 * f2) > ((float) (this.r * this.r)) : z ? Math.abs(f) > ((float) this.r) : z2 ? Math.abs(f2) > ((float) this.r) : false;
    }

    boolean b(View view, int i) {
        if (view == this.I && this.s == i) {
            return true;
        }
        if (view == null || !this.H.a(view, i)) {
            return false;
        }
        this.s = i;
        a(view, i);
        return true;
    }

    public boolean b(View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    public int c() {
        return this.E;
    }

    void c(int i) {
        if (this.q != i) {
            this.q = i;
            this.H.a(i);
            if (this.q == 0) {
                this.I = null;
            }
        }
    }

    public boolean c(int i, int i2) {
        return b(i2) && (this.x[i2] & i) != 0;
    }

    public View d() {
        return this.I;
    }

    public boolean d(int i) {
        int length = this.t.length;
        for (int i2 = b; i2 < length; i2 += j) {
            if (b(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean d(int i, int i2) {
        return b(this.I, i, i2);
    }

    public int e() {
        return this.s;
    }

    public View e(int i, int i2) {
        for (int childCount = this.K.getChildCount() + a; childCount >= 0; childCount += a) {
            View childAt = this.K.getChildAt(this.H.c(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public boolean e(int i) {
        int length = this.x.length;
        for (int i2 = b; i2 < length; i2 += j) {
            if (c(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public int f() {
        return this.r;
    }

    public void g() {
        this.s = a;
        i();
        if (this.B != null) {
            this.B.recycle();
            this.B = null;
        }
    }

    public void h() {
        g();
        if (this.q == k) {
            int b = this.G.b();
            int c = this.G.c();
            this.G.h();
            int b2 = this.G.b();
            int c2 = this.G.c();
            this.H.a(this.I, b2, c2, b2 - b, c2 - c);
        }
        c((int) b);
    }
}
