package cn.com.smartdevices.bracelet.chart;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.v4.view.C0151az;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.chart.base.a;
import cn.com.smartdevices.bracelet.chart.util.t;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.d.a.a.C1012a;
import com.edmodo.cropper.cropwindow.CropOverlayView;
import com.xiaomi.hm.health.R;
import java.util.ArrayList;
import java.util.List;
import kankan.wheel.widget.l;

public class A extends a {
    private static final int A = 80;
    private static final int B = 40;
    private static final String a = "Chart.StatisticChart";
    private static final int b = 8000;
    private static final int x = 480;
    private static final float y = 2.5f;
    private static final float z = 1.5f;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private float H = GroundOverlayOptions.NO_DIMENSION;
    private float I = GroundOverlayOptions.NO_DIMENSION;
    private int J;
    private float K;
    private int L;
    private float M;
    private float N;
    private F O;
    private D P;
    private G Q;
    private List<B> R;
    private int S;
    private int T;
    private int U = -5855549;
    private int V = -8947804;
    private int W = -6842439;
    private int X = -9605731;
    private int Y = -4989455;
    private int Z = -11226145;
    private int aa = -3479563;
    private int ab = -10372640;
    private int ac = -1;
    private int ad = -6694193;
    private int ae;
    private float af = 5.0f;
    private float ag = 1.66f;
    private Path ah;
    private Paint ai;

    public A(Context context) {
        float f = 1.0f;
        super(context);
        this.f = new C(this, context);
        this.f.h = (int) (kankan.wheel.widget.a.bf * this.p);
        this.f.a(this.k, 0.0f, this.m, 0.0f);
        this.O = new F(this, context);
        this.O.c(this.p * 0.83f);
        this.O.a(0.0f, (float) ((int) (this.p * BitmapDescriptorFactory.HUE_ORANGE)), 0.0f, 0.0f);
        this.P = new D(this, context);
        this.P.c(this.p * 0.83f);
        this.P.a(0.0f, (float) ((int) (CropOverlayView.a * this.p)), 0.0f, 0.0f);
        b((int) x);
        this.Q = new G(this, context);
        this.Q.c(this.p * 0.83f);
        this.Q.a(0.0f, (float) ((int) (70.0f * this.p)), 0.0f, (float) ((int) (this.p * BitmapDescriptorFactory.HUE_ORANGE)));
        this.R = new ArrayList();
        this.ai = new Paint();
        this.ai.setColor(872415231);
        this.ai.setStyle(Style.STROKE);
        float f2 = 0.3334f * this.p;
        if (f2 >= 1.0f) {
            f = f2;
        }
        this.ai.setStrokeWidth(f);
        this.ai.setPathEffect(new DashPathEffect(new float[]{4.5f * this.p, y * this.p}, 0.0f));
    }

    private void b(Canvas canvas) {
        float f;
        int i;
        if (this.S == 1) {
            f = this.H;
            if (f < 0.0f) {
                RectF m = this.O.m();
                i = this.O.i();
                f = m.bottom;
                if (i > 0 && this.O.x > 0.0f) {
                    f -= t.a(i, this.F, this.O.x, this.O.y);
                }
                this.H = f;
            }
        } else if (this.S == PersonInfo.INCOMING_CALL_DISABLE_BIT) {
            f = this.I;
            if (f < 0.0f) {
                RectF m2 = this.Q.m();
                i = this.Q.i();
                int j = this.Q.j();
                f = m2.bottom - this.Q.q();
                if (j > 0 && i > 0 && this.G >= j && this.G <= i) {
                    f -= ((m2.height() - this.Q.o()) - this.Q.q()) * (((float) (this.G - j)) / ((float) (i - j)));
                }
                this.I = f;
            }
        } else {
            f = 0.0f;
        }
        if (this.ah == null) {
            this.ah = new Path();
            this.ah.moveTo(this.j.left, f);
            this.ah.lineTo(this.j.right, f);
        }
        canvas.drawPath(this.ah, this.ai);
    }

    private void c(Canvas canvas) {
        RectF rectF = new RectF(this.j);
        rectF.left = this.j.centerX() - (this.K / 2.0f);
        rectF.right = this.j.centerX() + (this.K / 2.0f);
        rectF.bottom = this.f.m().top + 0.5f;
        Paint paint = new Paint();
        Path path = new Path();
        path.moveTo(rectF.left + ((rectF.width() - (this.p * 12.0f)) / 2.0f), rectF.bottom);
        path.lineTo(rectF.centerX(), rectF.bottom - (6.0f * this.p));
        path.lineTo(rectF.right - ((rectF.width() - (this.p * 12.0f)) / 2.0f), rectF.bottom);
        path.close();
        Paint paint2 = new Paint(1);
        paint2.setStyle(Style.FILL);
        paint2.setColor(-855310);
        canvas.drawPath(path, paint2);
    }

    private void g() {
        if (this.J > 0 && this.j != null) {
            this.K = ((this.j.width() - this.k) - this.m) / ((float) this.J);
            C0596r.e(a, "Update Bar Item Width : " + this.K);
            this.M = (float) ((int) (this.j.centerX() - (this.K / 2.0f)));
            this.N = (float) ((int) (this.j.centerX() + (this.K / 2.0f)));
        }
    }

    private void k(int i) {
        this.D = i + 60;
        this.E = i - 60;
        if (this.D > C1012a.d) {
            this.D = C1012a.d;
        }
        if (this.E < 0) {
            this.E = 0;
        }
        C0596r.e(a, "MaxValue : " + this.D);
        C0596r.e(a, "MinValue : " + this.E);
        this.Q.i(this.D);
        this.Q.j(this.E);
    }

    private void l(int i) {
        this.D = cn.com.smartdevices.bracelet.chart.util.a.d;
        this.E = 400;
        this.Q.i(this.D);
        this.Q.j(this.E);
        if (i > 0) {
            int i2;
            if (i > this.D) {
                i2 = (((i - this.D) / 100) + 1) * 100;
                this.D += i2;
                this.E = i2 + this.E;
            } else if (i < this.E) {
                i2 = (((this.E - i) / 100) + 1) * 100;
                this.D -= i2;
                this.E -= i2;
            }
            C0596r.e(a, "MaxValue : " + this.D);
            C0596r.e(a, "MinValue : " + this.E);
            this.Q.i(this.D);
            this.Q.j(this.E);
        }
    }

    public int a() {
        return this.J;
    }

    protected void a(float f) {
        if (this.u != null) {
            int i;
            int i2 = this.f.g;
            this.f.e(this.r);
            int i3 = this.f.g;
            Object obj = null;
            int i4;
            int i5;
            if (f < 0.0f) {
                if (i3 == i2 && this.r / this.K < ((float) i3)) {
                    i3++;
                }
                i4 = i2;
                for (i5 = i3; i5 > i2; i5--) {
                    if (!this.u.a(i5)) {
                        obj = 1;
                        i4 = i5;
                    }
                }
                i = i4 - 1;
            } else {
                if (i3 == i2 && (-(this.r / this.K)) < ((float) i3)) {
                    i3--;
                }
                i4 = i2;
                for (i5 = i3; i5 < i2; i5++) {
                    if (!this.u.a(i5)) {
                        obj = 1;
                        i4 = i5;
                    }
                }
                i = i4 + 1;
            }
            if (obj != null) {
                this.r = ((float) (-i)) * this.K;
                this.f.e(this.r);
                int i6 = this.f.g;
                ((M) this.u).a();
                i3 = i6;
            }
            if (i3 != i2) {
                this.u.b(i3);
            }
        }
    }

    public void a(int i) {
        int i2 = b;
        if (i >= b) {
            i2 = i;
        }
        this.O.i((int) (((float) i2) * y));
        this.F = i;
        this.H = GroundOverlayOptions.NO_DIMENSION;
        this.ah = null;
    }

    public void a(Canvas canvas, float f, float f2, float f3, float f4, float f5, boolean z) {
        ((C) this.f).a(canvas, f, f2, f3);
        if (!z) {
            if (this.S == 16) {
                this.P.a(canvas, f, f2, f3, f4, f5);
            } else if (this.S == 1) {
                b(canvas);
                this.O.a(canvas, f, f2, f3, f4, f5);
            } else if (this.S == PersonInfo.INCOMING_CALL_DISABLE_BIT) {
                if (this.G > 0) {
                    b(canvas);
                }
                this.Q.a(canvas, f, f2, f3, f4, f5);
            }
        }
        if (!z || this.S == PersonInfo.INCOMING_CALL_DISABLE_BIT) {
            c(canvas);
        }
    }

    public void a(RectF rectF) {
        super.a(rectF);
        g();
        RectF m = this.f.m();
        RectF rectF2 = new RectF(rectF);
        rectF2.left = rectF.left + this.k;
        rectF2.right = rectF.right - this.m;
        rectF2.bottom = m.top;
        this.O.b(rectF2);
        rectF2 = new RectF(rectF);
        rectF2.left = rectF.left + this.k;
        rectF2.right = rectF.right - this.m;
        rectF2.bottom = m.top;
        this.P.b(rectF2);
        rectF2 = new RectF(rectF);
        rectF2.left = rectF.left + this.k;
        rectF2.right = rectF.right - this.m;
        rectF2.bottom = m.top;
        this.Q.b(rectF2);
    }

    public float b() {
        return this.K;
    }

    public int b(float f) {
        float centerX = this.j.centerX() - (this.K / 2.0f);
        float centerX2 = this.j.centerX() + (this.K / 2.0f);
        return f < centerX ? -Math.round(((float) (((int) ((centerX - f) / this.K)) + 1)) * this.K) : f > centerX2 ? -Math.round(((float) ((-((int) ((f - centerX2) / this.K))) - 1)) * this.K) : 0;
    }

    public void b(int i) {
        this.P.i((int) (((float) i) * z));
    }

    public void b(List<E> list) {
        this.O.f(list);
    }

    public int c() {
        int i = (int) (this.r % this.K);
        if (((float) Math.abs(i)) <= this.K / 2.0f) {
            return i;
        }
        if (i > 0) {
            return (int) (-(this.K - ((float) i)));
        }
        return (int) (((float) i) + this.K);
    }

    public void c(int i) {
        k(i);
        C0596r.e(a, "WeightBase : " + i);
        this.C = i;
    }

    public void c(List<E> list) {
        this.P.f(list);
    }

    public int d() {
        return this.f.g;
    }

    public void d(int i) {
        C0596r.e(a, "WeightGoal : " + i);
        this.G = i;
        this.I = GroundOverlayOptions.NO_DIMENSION;
        this.ah = null;
    }

    public void d(List<H> list) {
        this.Q.f(list);
    }

    public void e() {
        if (this.S == PersonInfo.INCOMING_CALL_DISABLE_BIT) {
            this.Q.e();
            return;
        }
        this.O.e();
        this.P.e();
    }

    public void e(int i) {
        this.S = i;
        int i2 = 0;
        Resources resources = l().getResources();
        switch (i) {
            case l.a /*1*/:
                i2 = resources.getColor(R.color.bg_mode_step);
                break;
            case kankan.wheel.widget.a.bp /*16*/:
                i2 = resources.getColor(R.color.bg_mode_sleep);
                break;
            case PersonInfo.INCOMING_CALL_DISABLE_BIT /*256*/:
                i2 = resources.getColor(R.color.bg_mode_weight);
                break;
        }
        this.ae = i2 & C0151az.r;
    }

    public void e(List<B> list) {
        synchronized (this.R) {
            this.R.clear();
            this.R.addAll(list);
        }
    }

    public void f() {
        h(0);
    }

    public void f(int i) {
        this.T = i;
    }

    public void g(int i) {
        this.J = i;
        C0596r.e(a, "Update Bar Item Count : " + i);
        this.L = (this.J - 1) / 2;
        g();
    }

    public void h(int i) {
        this.r = ((float) i) * this.K;
        this.f.e(this.r);
    }
}
