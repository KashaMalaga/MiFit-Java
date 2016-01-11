package cn.com.smartdevices.bracelet.chart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import cn.com.smartdevices.bracelet.chart.base.c;

public class v extends c {
    public v(Context context) {
        super(context);
    }

    protected void a(Canvas canvas, RectF rectF, float f) {
        if (this.e) {
            float width = rectF.width() / 2.0f;
            RectF rectF2 = new RectF(rectF);
            rectF2.bottom += width;
            canvas.save();
            canvas.clipRect(rectF);
            canvas.drawRoundRect(rectF2, width, width, this.o.c);
            canvas.restore();
        }
    }
}
