package cn.com.smartdevices.bracelet.chart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import cn.com.smartdevices.bracelet.chart.base.a;
import cn.com.smartdevices.bracelet.chart.base.c;

class C0413c extends a {
    final /* synthetic */ C0411a a;

    public C0413c(C0411a c0411a, Context context) {
        this.a = c0411a;
        super(context);
    }

    protected void a(Canvas canvas, RectF rectF, float f) {
        synchronized (this.s) {
            int i = 0;
            for (c cVar : this.s) {
                i = cVar.e ? i + 1 : i;
            }
            int i2 = 0;
            for (c cVar2 : this.s) {
                if (cVar2.e) {
                    float f2 = f / (1.0f - (((float) i2) * (0.6f / ((float) i))));
                    if (f2 > 1.0f) {
                        f2 = 1.0f;
                    }
                    cVar2.a(canvas, f2);
                    i2++;
                }
            }
        }
    }
}
