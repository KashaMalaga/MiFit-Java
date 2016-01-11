package cn.com.smartdevices.bracelet.chart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.view.a.C0113o;
import android.text.TextPaint;
import cn.com.smartdevices.bracelet.chart.base.e;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;

class C extends e {
    final /* synthetic */ A a;
    private Paint b = new TextPaint(1);
    private Paint c;

    public C(A a, Context context) {
        this.a = a;
        super(context);
        this.b.setColor(1711276032);
        this.c = new Paint();
        this.c.setColor(-855310);
    }

    private void b(Canvas canvas, RectF rectF, float f, float f2, float f3) {
        int i = HeartRateInfo.HR_EMPTY_VALUE;
        int i2 = C0113o.h;
        int c = this.a.ae;
        if (f2 > GroundOverlayOptions.NO_DIMENSION) {
            i = (int) (255.0f * f);
            i2 = (int) (128.0f * f);
        }
        if (f3 > GroundOverlayOptions.NO_DIMENSION) {
            i = (int) ((1.0f - f) * 255.0f);
            i2 = (int) ((1.0f - f) * 128.0f);
        }
        c |= i << 24;
        int i3 = 0 | (i2 << 24);
        if (this.a.S == PersonInfo.INCOMING_CALL_DISABLE_BIT) {
            this.b.setTextSize(15.0f * this.p);
        } else {
            this.b.setTextSize(9.0f * this.p);
        }
        Rect rect = new Rect();
        synchronized (this.a.R) {
            for (B b : this.a.R) {
                if (b.a <= (this.g + ((this.a.J - 1) / 2)) + 1 && b.a >= (this.g + ((this.a.J - 1) / 2)) - this.a.J) {
                    if (this.a.S != PersonInfo.INCOMING_CALL_DISABLE_BIT || b.a == this.g) {
                        float f4;
                        if (this.a.S == PersonInfo.INCOMING_CALL_DISABLE_BIT) {
                            f4 = this.a.M;
                        } else {
                            f4 = (this.a.T == 1 ? ((rectF.right - this.m) - (((float) (b.a + 1)) * this.a.K)) - this.r : ((rectF.right - this.m) + (((float) (b.a - 1)) * this.a.K)) + this.r) - (((float) ((this.a.J - 1) / 2)) * this.a.K);
                        }
                        float f5 = rectF.top;
                        if (b.a == this.g) {
                            this.b.setColor(c);
                        } else {
                            this.b.setColor(i3);
                        }
                        this.b.getTextBounds(b.b, 0, b.b.length(), rect);
                        canvas.drawText(b.b, f4 + ((this.a.K - ((float) rect.width())) / 2.0f), f5 + (((float) (this.h + rect.height())) / 2.0f), this.b);
                    }
                }
            }
        }
    }

    protected void a(float f) {
        this.g = -Math.round(this.r / this.a.K);
    }

    public void a(Canvas canvas, float f, float f2, float f3) {
        a(canvas, this.j, f, f2, f3);
    }

    public void a(Canvas canvas, RectF rectF, float f, float f2, float f3) {
        if (this.a.S == PersonInfo.INCOMING_CALL_DISABLE_BIT) {
            canvas.drawRect(rectF, this.c);
        }
        b(canvas, rectF, f, f2, f3);
    }
}
