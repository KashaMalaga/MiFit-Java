package cn.com.smartdevices.bracelet.chart.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;

public class c extends g<k> {
    public int b;
    public int c;
    public int d;
    public boolean e;

    public c(Context context) {
        super(context);
    }

    protected void a(Canvas canvas, RectF rectF, float f) {
        if (this.e && this.o != null) {
            float width = (rectF.width() / 2.0f) + rectF.left;
            float f2 = rectF.bottom;
            float width2 = (rectF.width() / 2.0f) + rectF.left;
            float height = rectF.bottom - (rectF.height() * f);
            this.o.c.setStrokeWidth(rectF.width());
            canvas.drawLine(width, f2, width2, height, this.o.c);
        }
    }

    protected void a(Canvas canvas, RectF rectF, float f, boolean z) {
        if (this.e && this.o != null) {
            if (z) {
                float width = (rectF.width() / 2.0f) + rectF.left;
                float f2 = rectF.top;
                float width2 = (rectF.width() / 2.0f) + rectF.left;
                float height = (rectF.height() * f) + rectF.top;
                this.o.c.setStrokeWidth(rectF.width());
                canvas.drawLine(width, f2, width2, height, this.o.c);
                return;
            }
            a(canvas, rectF, f);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Value : " + this.b).append(" , ");
        stringBuilder.append("Index : " + this.c).append(" , ");
        stringBuilder.append("Scope : " + this.d).append(" , ");
        stringBuilder.append("NeedDrow : " + this.e);
        return stringBuilder.toString();
    }
}
