package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.view.C0151az;
import android.support.v4.view.Y;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import com.amap.api.maps.model.GroundOverlayOptions;
import kankan.wheel.widget.a;

public abstract class C0203a implements OnTouchListener {
    private static final int A = 315;
    private static final int B = 1575;
    private static final float C = Float.MAX_VALUE;
    private static final float D = 0.2f;
    private static final float E = 1.0f;
    private static final int F = ViewConfiguration.getTapTimeout();
    private static final int G = 500;
    private static final int H = 500;
    public static final float a = 0.0f;
    public static final float b = Float.MAX_VALUE;
    public static final float c = 0.0f;
    public static final int d = 0;
    public static final int e = 1;
    public static final int f = 2;
    private static final int g = 0;
    private static final int h = 1;
    private static final int z = 1;
    private final C0234c i = new C0234c();
    private final Interpolator j = new AccelerateInterpolator();
    private final View k;
    private Runnable l;
    private float[] m = new float[]{c, c};
    private float[] n = new float[]{b, b};
    private int o;
    private int p;
    private float[] q = new float[]{c, c};
    private float[] r = new float[]{c, c};
    private float[] s = new float[]{b, b};
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;

    public C0203a(View view) {
        this.k = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int i = (int) ((1575.0f * displayMetrics.density) + 0.5f);
        int i2 = (int) ((displayMetrics.density * 315.0f) + 0.5f);
        a((float) i, (float) i);
        b((float) i2, (float) i2);
        a((int) z);
        e(b, b);
        d(D, D);
        c((float) E, (float) E);
        b(F);
        c((int) H);
        d((int) H);
    }

    private float a(float f, float f2, float f3, float f4) {
        float f5;
        float b = C0203a.b(f * f2, (float) c, f3);
        b = f(f2 - f4, b) - f(f4, b);
        if (b < c) {
            f5 = -this.j.getInterpolation(-b);
        } else if (b <= c) {
            return c;
        } else {
            f5 = this.j.getInterpolation(b);
        }
        return C0203a.b(f5, (float) GroundOverlayOptions.NO_DIMENSION, (float) E);
    }

    private float a(int i, float f, float f2, float f3) {
        float a = a(this.m[i], f2, this.n[i], f);
        if (a == c) {
            return c;
        }
        float f4 = this.q[i];
        float f5 = this.r[i];
        float f6 = this.s[i];
        f4 *= f3;
        return a > c ? C0203a.b(a * f4, f5, f6) : -C0203a.b((-a) * f4, f5, f6);
    }

    private static float b(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    private static int b(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    private boolean c() {
        C0234c c0234c = this.i;
        int e = c0234c.e();
        int d = c0234c.d();
        return (e != 0 && f(e)) || (d != 0 && e(d));
    }

    private void d() {
        if (this.l == null) {
            this.l = new C0235d();
        }
        this.w = true;
        this.u = true;
        if (this.t || this.p <= 0) {
            this.l.run();
        } else {
            C0151az.a(this.k, this.l, (long) this.p);
        }
        this.t = true;
    }

    private void e() {
        if (this.u) {
            this.w = false;
        } else {
            this.i.a();
        }
    }

    private float f(float f, float f2) {
        if (f2 == c) {
            return c;
        }
        switch (this.o) {
            case g /*0*/:
            case z /*1*/:
                return f < f2 ? f >= c ? E - (f / f2) : (this.w && this.o == z) ? E : c : c;
            case f /*2*/:
                return f < c ? f / (-f2) : c;
            default:
                return c;
        }
    }

    private void f() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, c, c, g);
        this.k.onTouchEvent(obtain);
        obtain.recycle();
    }

    public C0203a a(float f, float f2) {
        this.s[g] = f / 1000.0f;
        this.s[z] = f2 / 1000.0f;
        return this;
    }

    public C0203a a(int i) {
        this.o = i;
        return this;
    }

    public C0203a a(boolean z) {
        if (this.x && !z) {
            e();
        }
        this.x = z;
        return this;
    }

    public abstract void a(int i, int i2);

    public boolean a() {
        return this.x;
    }

    public C0203a b(float f, float f2) {
        this.r[g] = f / 1000.0f;
        this.r[z] = f2 / 1000.0f;
        return this;
    }

    public C0203a b(int i) {
        this.p = i;
        return this;
    }

    public C0203a b(boolean z) {
        this.y = z;
        return this;
    }

    public boolean b() {
        return this.y;
    }

    public C0203a c(float f, float f2) {
        this.q[g] = f / 1000.0f;
        this.q[z] = f2 / 1000.0f;
        return this;
    }

    public C0203a c(int i) {
        this.i.a(i);
        return this;
    }

    public C0203a d(float f, float f2) {
        this.m[g] = f;
        this.m[z] = f2;
        return this;
    }

    public C0203a d(int i) {
        this.i.b(i);
        return this;
    }

    public C0203a e(float f, float f2) {
        this.n[g] = f;
        this.n[z] = f2;
        return this;
    }

    public abstract boolean e(int i);

    public abstract boolean f(int i);

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z = true;
        if (!this.x) {
            return false;
        }
        switch (Y.a(motionEvent)) {
            case g /*0*/:
                this.v = true;
                this.t = false;
                break;
            case z /*1*/:
            case a.l /*3*/:
                e();
                break;
            case f /*2*/:
                break;
        }
        this.i.a(a((int) g, motionEvent.getX(), (float) view.getWidth(), (float) this.k.getWidth()), a((int) z, motionEvent.getY(), (float) view.getHeight(), (float) this.k.getHeight()));
        if (!this.w && c()) {
            d();
        }
        if (!(this.y && this.w)) {
            z = false;
        }
        return z;
    }
}
