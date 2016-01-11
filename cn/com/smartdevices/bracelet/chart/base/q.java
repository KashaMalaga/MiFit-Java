package cn.com.smartdevices.bracelet.chart.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import com.amap.api.maps.model.GroundOverlayOptions;

public abstract class q extends g<k> {
    protected float a;
    protected float b;
    protected float c;
    protected float d;
    protected float e;
    protected float f = GroundOverlayOptions.NO_DIMENSION;

    public q(Context context) {
        super(context);
    }

    protected void a(Canvas canvas, RectF rectF, float f) {
        a(canvas, rectF, rectF.left + this.c, rectF.top + this.c, this.c, this.d, f);
    }

    protected abstract void a(Canvas canvas, RectF rectF, float f, float f2, float f3, float f4, float f5);

    protected void a(RectF rectF) {
        this.c = Math.min(rectF.width(), rectF.height()) / 2.0f;
    }

    public void c(float f) {
        this.a = f;
        g();
    }

    public void d(int i) {
        this.f = (float) i;
    }

    public float f() {
        return this.a;
    }

    public void f(float f) {
        this.b = f;
        g();
    }

    protected void g() {
        if (this.a == 0.0f) {
            this.d = 0.0f;
        } else if (this.b >= this.a) {
            this.d = 1.0f;
        } else {
            this.d = this.b / this.a;
        }
    }

    public void g(float f) {
        this.e = f;
    }
}
