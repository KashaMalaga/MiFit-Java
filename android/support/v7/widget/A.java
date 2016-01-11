package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

public abstract class A extends ae {
    private static final String a = "LinearSmoothScroller";
    public static final int b = -1;
    public static final int c = 1;
    public static final int d = 0;
    private static final boolean j = false;
    private static final float k = 25.0f;
    private static final int l = 10000;
    private static final float m = 1.2f;
    protected final LinearInterpolator e = new LinearInterpolator();
    protected final DecelerateInterpolator f = new DecelerateInterpolator();
    protected PointF g;
    protected int h = d;
    protected int i = d;
    private final float n;

    public A(Context context) {
        this.n = a(context.getResources().getDisplayMetrics());
    }

    private int a(int i, int i2) {
        int i3 = i - i2;
        return i * i3 <= 0 ? d : i3;
    }

    protected float a(DisplayMetrics displayMetrics) {
        return k / ((float) displayMetrics.densityDpi);
    }

    public int a(int i, int i2, int i3, int i4, int i5) {
        switch (i5) {
            case b /*-1*/:
                return i3 - i;
            case d /*0*/:
                int i6 = i3 - i;
                if (i6 > 0) {
                    return i6;
                }
                i6 = i4 - i2;
                return i6 >= 0 ? d : i6;
            case c /*1*/:
                return i4 - i2;
            default:
                throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
    }

    public int a(View view, int i) {
        W e = e();
        if (!e.h()) {
            return d;
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return a(e.o(view) - layoutParams.topMargin, e.q(view) + layoutParams.bottomMargin, e.C(), e.A() - e.E(), i);
    }

    public abstract PointF a(int i);

    protected void a() {
    }

    protected void a(int i, int i2, ag agVar, af afVar) {
        if (i() == 0) {
            stop();
            return;
        }
        this.h = a(this.h, i);
        this.i = a(this.i, i2);
        if (this.h == 0 && this.i == 0) {
            a(afVar);
        }
    }

    protected void a(af afVar) {
        PointF a = a(h());
        if (a == null || (a.x == 0.0f && a.y == 0.0f)) {
            Log.e(a, "To support smooth scrolling, you should override \nLayoutManager#computeScrollVectorForPosition.\nFalling back to instant scroll");
            int h = h();
            stop();
            f(h);
            return;
        }
        a(a);
        this.g = a;
        this.h = (int) (a.x * 10000.0f);
        this.i = (int) (a.y * 10000.0f);
        afVar.a((int) (((float) this.h) * m), (int) (((float) this.i) * m), (int) (((float) c(l)) * m), this.e);
    }

    protected void a(View view, ag agVar, af afVar) {
        int b = b(view, c());
        int a = a(view, d());
        int b2 = b((int) Math.sqrt((double) ((b * b) + (a * a))));
        if (b2 > 0) {
            afVar.a(-b, -a, b2, this.f);
        }
    }

    protected int b(int i) {
        return (int) Math.ceil(((double) c(i)) / 0.3356d);
    }

    public int b(View view, int i) {
        W e = e();
        if (!e.g()) {
            return d;
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return a(e.n(view) - layoutParams.leftMargin, e.p(view) + layoutParams.rightMargin, e.B(), e.z() - e.D(), i);
    }

    protected void b() {
        this.i = d;
        this.h = d;
        this.g = null;
    }

    protected int c() {
        return (this.g == null || this.g.x == 0.0f) ? d : this.g.x > 0.0f ? c : b;
    }

    protected int c(int i) {
        return (int) Math.ceil((double) (((float) Math.abs(i)) * this.n));
    }

    protected int d() {
        return (this.g == null || this.g.y == 0.0f) ? d : this.g.y > 0.0f ? c : b;
    }
}
