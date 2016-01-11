package cn.com.smartdevices.bracelet.chart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.chart.base.a;
import cn.com.smartdevices.bracelet.chart.base.c;
import java.util.List;

public class C0411a extends a {
    private static final String a = "Chart.DynamicDetailChart";
    private static final int b = 600;
    private static final float x = 196.6f;
    private static final float y = 160.0f;
    private C0416f A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private C0415e z;

    public C0411a(Context context) {
        super(context);
        this.f = new C0412b(this, context);
        this.f.a((float) ((int) (((double) this.p) * 2.5d)), 0.0f, (float) ((int) (((double) this.p) * 2.5d)), 0.0f);
        this.z = new C0415e(this, context);
        this.z.a((float) ((int) (this.p * 8.0f)), (float) ((int) (130.0f * this.p)), (float) ((int) (this.p * 8.0f)), 0.0f);
        this.z.c(1.0f);
        this.A = new C0416f(this, context);
        this.A.a((float) ((int) (((double) this.p) * 2.5d)), (float) ((int) (95.0f * this.p)), (float) ((int) (((double) this.p) * 2.5d)), 0.0f);
        this.A.i(b);
        this.A.c(0.5f * this.p);
    }

    static /* synthetic */ int c(C0411a c0411a, int i) {
        int i2 = c0411a.D - i;
        c0411a.D = i2;
        return i2;
    }

    static /* synthetic */ int d(C0411a c0411a, int i) {
        int i2 = c0411a.E + i;
        c0411a.E = i2;
        return i2;
    }

    public void a() {
        this.A.t();
        this.B = 0;
        this.C = 0;
        this.D = 0;
        this.E = 0;
    }

    protected void a(float f) {
        C0596r.g(a, "Scroll :" + f);
        if (this.u != null) {
            C0412b c0412b = (C0412b) this.f;
            if (this.r > 0.0f) {
                this.r = 0.0f;
            }
            if (this.r < c0412b.d()) {
                this.r = c0412b.d();
            }
            C0596r.g(a, "ScrollTo : " + this.r);
            c0412b.e(this.r);
        }
    }

    public void a(int i) {
        this.F = i;
    }

    public void a(int i, int i2) {
        C0596r.e(a, "Sleep Time : " + i + " , " + i2);
        this.B = i;
        this.C = i2;
        this.D = this.B / 60;
        this.E = this.C / 60;
        if (this.B == this.C) {
            c(8);
        }
    }

    public void a(Canvas canvas, float f) {
        if (!w().k()) {
            this.z.a(canvas, f);
            this.A.a(canvas, f);
        }
        super.a(canvas, f);
    }

    protected void a(RectF rectF) {
        super.a(rectF);
        RectF m = this.f.m();
        RectF rectF2 = new RectF(rectF);
        rectF2.bottom = m.top;
        this.A.b(rectF2);
        rectF2 = new RectF(rectF);
        rectF2.bottom = m.top;
        this.z.b(rectF2);
    }

    public void a(List<C0414d> list) {
        this.A.g(list);
    }

    public void b() {
        this.z.t();
        this.B = 0;
        this.C = 0;
        this.D = 0;
        this.E = 0;
    }

    public void b(int i) {
        C0412b c0412b = (C0412b) this.f;
        c0412b.b = i;
        c0412b.g = 0;
        c0412b.a();
    }

    public void b(List<C0414d> list) {
        this.z.g(list);
        this.z.k();
    }

    public a c() {
        return this.z;
    }

    public void c(int i) {
        C0596r.e(a, "Before, Start : " + this.B + " End : " + this.C + " , StartHour : " + this.D + " EndHour : " + this.E);
        if (this.E - this.D < i - 1) {
            this.E = this.D + (i - 1);
            if (this.E > 23) {
                this.E = 23;
                this.D = this.E - (i - 1);
            }
            this.B = this.D * 60;
            this.C = this.E * 60;
        }
        C0596r.e(a, "After, Start : " + this.B + " End : " + this.C + " , StartHour : " + this.D + " EndHour : " + this.E);
        ((C0412b) this.f).e();
    }

    public void c(List<c> list) {
        this.z.f(list);
    }

    public a d() {
        return this.A;
    }

    public void d(List<C0414d> list) {
        this.A.f(list);
    }

    public void e() {
        this.z.e();
        this.A.e();
    }

    public int f() {
        return this.B;
    }

    public int g() {
        return this.C;
    }

    public float h() {
        return ((C0412b) this.f).d();
    }
}
