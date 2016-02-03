package cn.com.smartdevices.bracelet.chart;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import cn.com.smartdevices.bracelet.chart.base.q;
import cn.com.smartdevices.bracelet.chart.util.t;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.xiaomi.hm.health.R;

public class w extends q {
    private static final float g = 15.0f;
    private static final float h = 16.33f;
    private Paint A;
    private float B;
    private RectF C;
    private RectF D;
    private RectF E;
    private float F;
    private float G;
    private float H;
    private Bitmap i;
    private Paint x = new Paint(1);
    private Paint y = new Paint(1);
    private Paint z = new Paint(1);

    public w(Context context) {
        super(context);
        this.i = ((BitmapDrawable) context.getResources().getDrawable(R.drawable.ic_dynamic_weight)).getBitmap();
        this.x.setColor(-2130706433);
        this.x.setStrokeWidth(this.p * g);
        this.x.setStyle(Style.STROKE);
        this.y.setColor(1308622847);
        this.y.setStrokeWidth(this.p * g);
        this.y.setStyle(Style.STROKE);
        this.z.setColor(-1);
        this.z.setStrokeWidth(2.0f * this.p);
        this.z.setStyle(Style.STROKE);
        this.B = h * this.p;
        this.A = new Paint(1);
        this.A.setColor(1308622847);
        this.A.setStrokeWidth(1.0f);
        this.A.setStyle(Style.STROKE);
        this.F = 135.0f;
        this.G = BitmapDescriptorFactory.HUE_VIOLET;
    }

    protected void a(Canvas canvas, RectF rectF, float f, float f2, float f3, float f4, float f5) {
        canvas.drawArc(this.D, this.F, (this.G / 2.0f) - 7.0f, false, this.A);
        canvas.drawArc(this.D, (this.F + (this.G / 2.0f)) + 7.0f, (this.G / 2.0f) - 7.0f, false, this.A);
        float f6 = this.q;
        if (t.a()) {
            f6 = (float) (((double) f6) * 0.88d);
        }
        t.a(canvas, this.E.centerX(), this.E.centerY(), f6, this.i, null);
        float f7 = (this.G * f4) * f5;
        canvas.drawArc(this.C, this.F, this.G, false, this.y);
        if (f7 > 0.0f) {
            canvas.drawArc(this.C, this.F, f7, false, this.x);
        }
        if (this.H > 0.0f && this.H <= this.a) {
            float f8 = f3 - (this.B * 2.0f);
            float f9 = f8 - (g * this.p);
            float f10 = (float) (((double) ((((this.G * (this.H / this.a)) + (90.0f + this.F)) / 360.0f) * 2.0f)) * 3.141592653589793d);
            Canvas canvas2 = canvas;
            canvas2.drawLine((float) (((double) f) + (Math.sin((double) f10) * ((double) f8))), (float) (((double) f2) - (((double) f8) * Math.cos((double) f10))), (float) (((double) f) + (Math.sin((double) f10) * ((double) f9))), (float) (((double) f2) - (((double) f9) * Math.cos((double) f10))), this.z);
        }
    }

    protected void a(RectF rectF) {
        super.a(rectF);
        this.C = new RectF(rectF);
        RectF rectF2 = this.C;
        rectF2.left += (this.B * 2.0f) + ((this.p * g) / 2.0f);
        rectF2 = this.C;
        rectF2.top += (this.B * 2.0f) + ((this.p * g) / 2.0f);
        rectF2 = this.C;
        rectF2.right -= (this.B * 2.0f) + ((this.p * g) / 2.0f);
        rectF2 = this.C;
        rectF2.bottom -= (this.B * 2.0f) + ((this.p * g) / 2.0f);
        this.D = new RectF(rectF);
        rectF2 = this.D;
        rectF2.left += this.B;
        rectF2 = this.D;
        rectF2.top += this.B;
        rectF2 = this.D;
        rectF2.right -= this.B;
        rectF2 = this.D;
        rectF2.bottom -= this.B;
        this.E = new RectF();
        this.E.left = rectF.centerX() - (15.5f * this.p);
        this.E.top = rectF.top + (this.p * 2.0f);
        this.E.right = this.E.left + (this.p * 31.0f);
        this.E.bottom = this.E.top + (this.p * 31.0f);
    }

    public void b(float f) {
        this.H = f;
    }
}
