package cn.com.smartdevices.bracelet.chart;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import cn.com.smartdevices.bracelet.chart.base.q;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.chart.util.a;
import cn.com.smartdevices.bracelet.chart.util.t;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import com.xiaomi.hm.health.k;
import kankan.wheel.widget.l;

public class o extends q {
    private static final String g = "Chart.DynamicPieChart";
    private static final float h = 1.33f;
    private static final float i = 14.33f;
    private static final float x = 16.33f;
    private static final int y = 200;
    private int A;
    private Bitmap B;
    private Bitmap C;
    private Bitmap D;
    private Bitmap E;
    private Paint F = new Paint(1);
    private Paint G = new Paint(1);
    private float H;
    private Paint I;
    private RectF J;
    private RectF K;
    private float L;
    private float[] M;
    private boolean z;

    public o(Context context) {
        super(context);
        this.B = ((BitmapDrawable) context.getResources().getDrawable(k.ic_dynamic_step)).getBitmap();
        this.C = ((BitmapDrawable) context.getResources().getDrawable(k.ic_dynamic_sleep)).getBitmap();
        this.D = ((BitmapDrawable) context.getResources().getDrawable(k.heart_icon)).getBitmap();
        this.E = ((BitmapDrawable) context.getResources().getDrawable(k.shose)).getBitmap();
        this.F.setColor(-1);
        this.F.setStrokeWidth(this.p * h);
        this.F.setStyle(Style.STROKE);
        this.G.setColor(1308622847);
        this.G.setStrokeWidth(this.p * h);
        this.G.setStyle(Style.STROKE);
        this.L = i * this.p;
        this.H = x * this.p;
        this.I = new Paint(1);
        this.I.setColor(1308622847);
        this.I.setStrokeWidth(1.0f);
        this.I.setStyle(Style.STROKE);
    }

    private void a(float f, float f2, float f3, Canvas canvas) {
        float f4 = 0.0f;
        if (this.A > 0) {
            f4 = 7.0f;
        }
        canvas.drawArc(this.J, f4 - 90.0f, 360.0f - (f4 * 2.0f), false, this.I);
        a(canvas, f, f2, f3, this.G, y);
    }

    private void a(Canvas canvas, float f, float f2, float f3, Paint paint, int i) {
        if (this.M == null) {
            this.M = new float[a.d];
            float strokeWidth = (f3 - (this.I.getStrokeWidth() / 2.0f)) - (this.H * 2.0f);
            float strokeWidth2 = ((f3 - (this.I.getStrokeWidth() / 2.0f)) - (this.H * 2.0f)) - this.L;
            for (int i2 = 0; i2 < y; i2++) {
                float f4 = ((float) i2) * 0.03141593f;
                float sin = (float) (((double) f) + (Math.sin((double) f4) * ((double) strokeWidth)));
                float cos = (float) (((double) f2) - (Math.cos((double) f4) * ((double) strokeWidth)));
                float sin2 = (float) (((double) f) + (Math.sin((double) f4) * ((double) strokeWidth2)));
                f4 = (float) (((double) f2) - (Math.cos((double) f4) * ((double) strokeWidth2)));
                this.M[i2 * 4] = sin;
                this.M[(i2 * 4) + 1] = cos;
                this.M[(i2 * 4) + 2] = sin2;
                this.M[(i2 * 4) + 3] = f4;
            }
        }
        canvas.drawLines(this.M, 0, i * 4, paint);
    }

    public void a() {
        this.z = true;
    }

    public void a(int i) {
        this.A = i;
        switch (this.A) {
            case l.a /*1*/:
                this.I.setColor(1728053247);
                return;
            case kankan.wheel.widget.a.bp /*16*/:
                this.I.setColor(1308622847);
                return;
            default:
                return;
        }
    }

    protected void a(Canvas canvas, RectF rectF, float f, float f2, float f3, float f4, float f5) {
        a(f, f2, f3, canvas);
        float f6 = this.q;
        if (t.a()) {
            f6 = (float) (((double) f6) * 0.88d);
        }
        switch (this.A) {
            case l.a /*1*/:
                t.a(canvas, this.K.centerX(), this.K.centerY(), f6, this.B, null);
                break;
            case kankan.wheel.widget.a.bp /*16*/:
                t.a(canvas, this.K.centerX(), this.K.centerY(), f6, this.C, null);
                break;
            case ChartData.d /*4096*/:
                if (this.f > 0.0f) {
                    this.F.setAlpha((int) this.f);
                } else {
                    this.F.setAlpha(HeartRateInfo.HR_EMPTY_VALUE);
                }
                t.a(canvas, this.K.centerX(), this.K.centerY(), f6, this.D, null);
                break;
            case ChartData.e /*4352*/:
                if (this.f > 0.0f) {
                    this.F.setAlpha((int) this.f);
                } else {
                    this.F.setAlpha(HeartRateInfo.HR_EMPTY_VALUE);
                }
                t.a(canvas, this.K.centerX(), this.K.centerY(), f6, this.E, null);
                break;
        }
        float f7 = f4 * f5;
        if (f7 > 1.0f) {
            f7 = 1.0f;
        }
        Canvas canvas2;
        float f8;
        float f9;
        if (this.z) {
            canvas.save();
            canvas.rotate(this.e * 360.0f, f, f2);
            if (f7 < 0.3f) {
                f7 = 0.3f;
            }
            if (f7 > 0.6f) {
                f7 = 0.6f;
            }
            canvas2 = canvas;
            f8 = f;
            f6 = f2;
            f9 = f3;
            a(canvas2, f8, f6, f9, this.F, (int) (f7 * 200.0f));
            canvas.restore();
        } else if (f7 > 0.0f || f7 < 1.0f) {
            canvas2 = canvas;
            f8 = f;
            f6 = f2;
            f9 = f3;
            a(canvas2, f8, f6, f9, this.F, (int) (f7 * 200.0f));
        } else if (f7 == 1.0f) {
            a(canvas, f, f2, f3, this.F, y);
        }
    }

    protected void a(RectF rectF) {
        super.a(rectF);
        this.K = new RectF();
        this.K.left = rectF.centerX() - (15.5f * this.p);
        this.K.top = rectF.top + (2.0f * this.p);
        this.K.right = this.K.left + (this.p * 31.0f);
        this.K.bottom = this.K.top + (this.p * 31.0f);
        this.J = new RectF(rectF);
        RectF rectF2 = this.J;
        rectF2.left += this.H;
        rectF2 = this.J;
        rectF2.top += this.H;
        rectF2 = this.J;
        rectF2.right -= this.H;
        rectF2 = this.J;
        rectF2.bottom -= this.H;
    }

    public void b() {
        this.z = false;
    }
}
