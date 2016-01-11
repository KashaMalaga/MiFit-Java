package cn.com.smartdevices.bracelet.chart.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;

public class f extends b {
    public f(Context context) {
        super(context);
    }

    protected void a(Canvas canvas, RectF rectF, float f) {
        canvas.drawRect(rectF, this.o.c);
    }
}
