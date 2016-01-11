package cn.com.smartdevices.bracelet.chart;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextPaint;
import cn.com.smartdevices.bracelet.chart.base.e;
import cn.com.smartdevices.bracelet.chart.util.t;
import cn.com.smartdevices.bracelet.f.f;
import com.xiaomi.hm.health.k;

class C0412b extends e {
    final /* synthetic */ C0411a a;
    private int b;
    private float c;
    private Paint d;
    private Paint e;
    private Bitmap i;
    private Bitmap x;

    public C0412b(C0411a c0411a, Context context) {
        this.a = c0411a;
        super(context);
        this.b = 0;
        this.f = 24;
        this.g = this.b;
        this.d = new TextPaint(1);
        this.d.setColor(1711276032);
        this.d.setTextSize(9.0f * this.p);
        this.e = new Paint();
        this.e.setColor(-855310);
    }

    private void a(Canvas canvas, RectF rectF) {
        if (this.a.B != this.a.C) {
            Rect rect = new Rect();
            float f = (8.0f * this.p) + rectF.left;
            float centerY = rectF.centerY();
            t.a(canvas, f, centerY, this.q, false, true, this.i, null);
            String a = f.a(this.a.B);
            this.d.getTextBounds(a, 0, a.length(), rect);
            rect.offset((int) (f + (15.0f * this.p)), (int) (((double) (centerY + ((float) (rect.height() / 2)))) - (0.66d * ((double) this.p))));
            t.a(canvas, new RectF(rect), a, this.d);
            f = (rectF.right - (8.0f * this.p)) - (((float) this.x.getWidth()) * this.q);
            centerY = rectF.centerY();
            t.a(canvas, f, centerY, this.q, false, true, this.x, null);
            a = f.a(this.a.C);
            this.d.getTextBounds(a, 0, a.length(), rect);
            rect.offset((int) ((f - ((float) rect.width())) - (6.0f * this.p)), (int) (((double) (centerY + ((float) (rect.height() / 2)))) - (0.66d * ((double) this.p))));
            t.a(canvas, new RectF(rect), a, this.d);
        }
    }

    private void b(Canvas canvas, RectF rectF) {
        if (this.a.D != this.a.E) {
            Rect rect = new Rect();
            int i = ((this.a.E - this.a.D) + 1) / 6 >= 20 ? 1 : 0;
            int i2 = Integer.MIN_VALUE;
            for (int i3 = 0; i3 < (this.a.E - this.a.D) + 1; i3++) {
                int a = (this.a.D + i3) / 6;
                if (a < 0) {
                    a += 24;
                }
                if (a % 2 == 0 && a != r3) {
                    float f = (this.r / this.c) % 1.0f == 0.0f ? 0.0f : this.r % this.c;
                    String b = i == 0 ? f.b(a * 60) : String.valueOf(a);
                    this.d.getTextBounds(b, 0, b.length(), rect);
                    canvas.drawText(b, f + ((((((float) i3) * this.c) + (((this.c * 6.0f) - ((float) rect.width())) / 2.0f)) + rectF.left) + this.k), (((float) (this.h + rect.height())) / 2.0f) + rectF.top, this.d);
                    i2 = a;
                }
            }
        }
    }

    private void j() {
        if (this.i == null) {
            this.i = ((BitmapDrawable) this.t.getResources().getDrawable(k.ic_dynamic_detail_sleep_start)).getBitmap();
        }
        if (this.x == null) {
            this.x = ((BitmapDrawable) this.t.getResources().getDrawable(k.ic_dynamic_detail_sleep_end)).getBitmap();
        }
    }

    public void a() {
        this.r = ((float) (this.b - this.g)) * this.c;
        this.a.r = this.r;
    }

    protected void a(float f) {
        this.g = (-((int) (this.r / this.c))) + this.b;
    }

    protected void a(Canvas canvas, RectF rectF, float f) {
        canvas.drawRect(rectF, this.e);
        if (this.a.F == 16) {
            j();
            a(canvas, rectF);
        } else if (this.a.F == 1) {
            b(canvas, rectF);
        }
    }

    protected void a(RectF rectF) {
        a();
    }

    public float b() {
        return this.c * ((float) this.f);
    }

    public float c() {
        return this.r - (((float) this.b) * this.c);
    }

    public float d() {
        return ((float) this.b) * this.c;
    }

    public void e() {
        if (this.j != null && this.a.D != this.a.E) {
            this.c = ((this.j.width() - this.k) - this.m) / ((float) ((this.a.E - this.a.D) + 1));
        }
    }

    public float f() {
        int i = (-this.g) % this.f;
        if (g()) {
            i = ((-this.g) % this.f) + this.f;
        }
        return (((float) i) * this.c) + (this.r % this.c);
    }

    public boolean g() {
        return this.r - (((float) this.b) * this.c) < 0.0f && (this.r - (((float) this.b) * this.c)) % b() < 0.0f;
    }

    public int h() {
        return this.g / this.f;
    }

    public float i() {
        return g() ? (((float) (-h())) * b()) + (this.c * ((float) this.b)) : ((float) (-h())) * b();
    }
}
