package cn.com.smartdevices.bracelet.chart.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.text.style.ReplacementSpan;

public class s extends ReplacementSpan {
    private float a;
    private float b;
    private float c;
    private float d;

    public s(float f, float f2, float f3, float f4) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        canvas.drawText(charSequence.subSequence(i, i2).toString(), (this.a + f) - this.c, (((float) i4) + this.b) - this.d, paint);
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, FontMetricsInt fontMetricsInt) {
        return (int) paint.measureText(charSequence.subSequence(i, i2).toString());
    }
}
