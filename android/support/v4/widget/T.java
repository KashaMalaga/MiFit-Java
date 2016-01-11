package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.v4.view.C0151az;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.amap.api.maps.model.WeightedLatLng;
import java.util.ArrayList;

class T extends Drawable implements Animatable {
    static final int a = 0;
    static final int b = 1;
    private static final Interpolator d = new LinearInterpolator();
    private static final Interpolator e = new X();
    private static final Interpolator f = new C0208aa();
    private static final Interpolator g = new AccelerateDecelerateInterpolator();
    private static final int h = 40;
    private static final float i = 8.75f;
    private static final float j = 2.5f;
    private static final int k = 56;
    private static final float l = 12.5f;
    private static final float m = 3.0f;
    private static final int o = 1333;
    private static final float p = 5.0f;
    private static final int t = 10;
    private static final int u = 5;
    private static final float v = 5.0f;
    private static final int w = 12;
    private static final int x = 6;
    private static final float y = 0.8f;
    private View A;
    private Animation B;
    private float C;
    private double D;
    private double E;
    private final Callback F = new W(this);
    boolean c;
    private final int[] n;
    private final ArrayList<Animation> q = new ArrayList();
    private final Z r;
    private float s;
    private Resources z;

    public T(Context context, View view) {
        int[] iArr = new int[b];
        iArr[a] = C0151az.s;
        this.n = iArr;
        this.A = view;
        this.z = context.getResources();
        this.r = new Z(this.F);
        this.r.a(this.n);
        a((int) b);
        d();
    }

    private void a(double d, double d2, double d3, double d4, float f, float f2) {
        Z z = this.r;
        float f3 = this.z.getDisplayMetrics().density;
        this.D = ((double) f3) * d;
        this.E = ((double) f3) * d2;
        z.a(((float) d4) * f3);
        z.a(((double) f3) * d3);
        z.b((int) a);
        z.a(f * f3, f3 * f2);
        z.a((int) this.D, (int) this.E);
    }

    private void a(float f, Z z) {
        float floor = (float) (Math.floor((double) (z.k() / y)) + WeightedLatLng.DEFAULT_INTENSITY);
        z.b(z.e() + ((z.f() - z.e()) * f));
        z.d(((floor - z.k()) * f) + z.k());
    }

    private float c() {
        return this.s;
    }

    private void d() {
        Z z = this.r;
        Animation c0204u = new C0204U(this, z);
        c0204u.setRepeatCount(-1);
        c0204u.setRepeatMode(b);
        c0204u.setInterpolator(d);
        c0204u.setAnimationListener(new V(this, z));
        this.B = c0204u;
    }

    public void a(float f) {
        this.r.e(f);
    }

    public void a(float f, float f2) {
        this.r.b(f);
        this.r.c(f2);
    }

    public void a(@Y int i) {
        if (i == 0) {
            a(56.0d, 56.0d, 12.5d, 3.0d, 12.0f, 6.0f);
        } else {
            a(40.0d, 40.0d, 8.75d, 2.5d, 10.0f, v);
        }
    }

    public void a(boolean z) {
        this.r.a(z);
    }

    public void a(int... iArr) {
        this.r.a(iArr);
        this.r.b((int) a);
    }

    public void b(float f) {
        this.r.d(f);
    }

    public void b(int i) {
        this.r.a(i);
    }

    void c(float f) {
        this.s = f;
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int save = canvas.save();
        canvas.rotate(this.s, bounds.exactCenterX(), bounds.exactCenterY());
        this.r.a(canvas, bounds);
        canvas.restoreToCount(save);
    }

    public int getAlpha() {
        return this.r.b();
    }

    public int getIntrinsicHeight() {
        return (int) this.E;
    }

    public int getIntrinsicWidth() {
        return (int) this.D;
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isRunning() {
        ArrayList arrayList = this.q;
        int size = arrayList.size();
        for (int i = a; i < size; i += b) {
            Animation animation = (Animation) arrayList.get(i);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }

    public void setAlpha(int i) {
        this.r.c(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.r.a(colorFilter);
    }

    public void start() {
        this.B.reset();
        this.r.l();
        if (this.r.g() != this.r.d()) {
            this.c = true;
            this.B.setDuration(666);
            this.A.startAnimation(this.B);
            return;
        }
        this.r.b((int) a);
        this.r.m();
        this.B.setDuration(1333);
        this.A.startAnimation(this.B);
    }

    public void stop() {
        this.A.clearAnimation();
        c(0.0f);
        this.r.a(false);
        this.r.b((int) a);
        this.r.m();
    }
}
