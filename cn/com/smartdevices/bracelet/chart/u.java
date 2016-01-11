package cn.com.smartdevices.bracelet.chart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import cn.com.smartdevices.bracelet.chart.base.e;

class u extends e {
    static final int a = 18;
    static final int b = 1;
    float c;
    Paint d;
    final /* synthetic */ t e;

    public u(t tVar, Context context) {
        this.e = tVar;
        super(context);
        this.f = a;
        this.g = b;
        this.d = new TextPaint();
        this.d.setColor(-1);
        this.d.setTextSize(6.5f * this.p);
        this.d.setAntiAlias(true);
    }

    protected void a(Canvas canvas, RectF rectF, float f) {
        Rect rect = new Rect();
        for (int i = 0; ((float) i) < ((float) this.f) * f; i += b) {
            int i2 = (this.g % this.f) + i;
            if (i2 % 2 == 0) {
                String valueOf = String.valueOf(i2);
                this.d.getTextBounds(valueOf, 0, valueOf.length(), rect);
                canvas.drawText(valueOf, ((((float) i) * this.c) + ((this.c - ((float) rect.width())) / 2.0f)) + rectF.left, (((float) (this.h + rect.height())) / 2.0f) + rectF.top, this.d);
            }
        }
    }

    protected void a(RectF rectF) {
        this.c = rectF.width() / ((float) this.f);
    }
}
