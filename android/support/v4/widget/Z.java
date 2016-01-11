package android.support.v4.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable.Callback;
import android.support.a.q;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;

class Z {
    private final RectF a = new RectF();
    private final Paint b = new Paint();
    private final Paint c = new Paint();
    private final Callback d;
    private float e = 0.0f;
    private float f = 0.0f;
    private float g = 0.0f;
    private float h = 5.0f;
    private float i = 2.5f;
    private int[] j;
    private int k;
    private float l;
    private float m;
    private float n;
    private boolean o;
    private Path p;
    private float q;
    private double r;
    private int s;
    private int t;
    private int u;
    private final Paint v = new Paint();
    private int w;

    public Z(Callback callback) {
        this.d = callback;
        this.b.setStrokeCap(Cap.SQUARE);
        this.b.setAntiAlias(true);
        this.b.setStyle(Style.STROKE);
        this.c.setStyle(Style.FILL);
        this.c.setAntiAlias(true);
    }

    private void a(Canvas canvas, float f, float f2, Rect rect) {
        if (this.o) {
            if (this.p == null) {
                this.p = new Path();
                this.p.setFillType(FillType.EVEN_ODD);
            } else {
                this.p.reset();
            }
            float f3 = ((float) (((int) this.i) / 2)) * this.q;
            float cos = (float) ((this.r * Math.cos(0.0d)) + ((double) rect.exactCenterX()));
            float sin = (float) ((this.r * Math.sin(0.0d)) + ((double) rect.exactCenterY()));
            this.p.moveTo(0.0f, 0.0f);
            this.p.lineTo(((float) this.s) * this.q, 0.0f);
            this.p.lineTo((((float) this.s) * this.q) / 2.0f, ((float) this.t) * this.q);
            this.p.offset(cos - f3, sin);
            this.p.close();
            this.c.setColor(this.j[this.k]);
            canvas.rotate((f + f2) - 5.0f, rect.exactCenterX(), rect.exactCenterY());
            canvas.drawPath(this.p, this.c);
        }
    }

    private void n() {
        this.d.invalidateDrawable(null);
    }

    public void a() {
        this.k = (this.k + 1) % this.j.length;
    }

    public void a(double d) {
        this.r = d;
    }

    public void a(float f) {
        this.h = f;
        this.b.setStrokeWidth(f);
        n();
    }

    public void a(float f, float f2) {
        this.s = (int) f;
        this.t = (int) f2;
    }

    public void a(int i) {
        this.w = i;
    }

    public void a(int i, int i2) {
        float min = (float) Math.min(i, i2);
        min = (this.r <= 0.0d || min < 0.0f) ? (float) Math.ceil((double) (this.h / 2.0f)) : (float) (((double) (min / 2.0f)) - this.r);
        this.i = min;
    }

    public void a(Canvas canvas, Rect rect) {
        RectF rectF = this.a;
        rectF.set(rect);
        rectF.inset(this.i, this.i);
        float f = (this.e + this.g) * 360.0f;
        float f2 = ((this.f + this.g) * 360.0f) - f;
        this.b.setColor(this.j[this.k]);
        canvas.drawArc(rectF, f, f2, false, this.b);
        a(canvas, f, f2, rect);
        if (this.u < HeartRateInfo.HR_EMPTY_VALUE) {
            this.v.setColor(this.w);
            this.v.setAlpha(255 - this.u);
            canvas.drawCircle(rect.exactCenterX(), rect.exactCenterY(), (float) (rect.width() / 2), this.v);
        }
    }

    public void a(ColorFilter colorFilter) {
        this.b.setColorFilter(colorFilter);
        n();
    }

    public void a(boolean z) {
        if (this.o != z) {
            this.o = z;
            n();
        }
    }

    public void a(@q int[] iArr) {
        this.j = iArr;
        b(0);
    }

    public int b() {
        return this.u;
    }

    public void b(float f) {
        this.e = f;
        n();
    }

    public void b(int i) {
        this.k = i;
    }

    public float c() {
        return this.h;
    }

    public void c(float f) {
        this.f = f;
        n();
    }

    public void c(int i) {
        this.u = i;
    }

    public float d() {
        return this.e;
    }

    public void d(float f) {
        this.g = f;
        n();
    }

    public float e() {
        return this.l;
    }

    public void e(float f) {
        if (f != this.q) {
            this.q = f;
            n();
        }
    }

    public float f() {
        return this.m;
    }

    public float g() {
        return this.f;
    }

    public float h() {
        return this.g;
    }

    public float i() {
        return this.i;
    }

    public double j() {
        return this.r;
    }

    public float k() {
        return this.n;
    }

    public void l() {
        this.l = this.e;
        this.m = this.f;
        this.n = this.g;
    }

    public void m() {
        this.l = 0.0f;
        this.m = 0.0f;
        this.n = 0.0f;
        b(0.0f);
        c(0.0f);
        d(0.0f);
    }
}
