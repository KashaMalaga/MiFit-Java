package cn.com.smartdevices.bracelet.chart;

import android.content.Context;
import android.graphics.RectF;
import cn.com.smartdevices.bracelet.chart.base.c;
import cn.com.smartdevices.bracelet.chart.util.t;

class F extends D {
    final /* synthetic */ A b;
    private float x;
    private int y = 10;

    public F(A a, Context context) {
        this.b = a;
        super(a, context);
    }

    protected void a(RectF rectF) {
        super.a(rectF);
        if (rectF != null) {
            this.x = t.a(this.d, (rectF.height() - this.l) - this.n, this.y);
        }
    }

    protected float b(RectF rectF, c cVar) {
        return cVar.b >= this.d ? (rectF.height() - this.l) - this.n : t.a(this.d, cVar.b, this.x, this.y);
    }
}
