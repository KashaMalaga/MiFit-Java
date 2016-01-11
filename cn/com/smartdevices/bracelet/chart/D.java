package cn.com.smartdevices.bracelet.chart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import cn.com.smartdevices.bracelet.chart.base.a;
import cn.com.smartdevices.bracelet.chart.base.c;

class D extends a {
    final /* synthetic */ A a;

    public D(A a, Context context) {
        this.a = a;
        super(context);
    }

    protected float a(RectF rectF, c cVar) {
        return this.a.K - (this.c * 2.0f);
    }

    public void a(Canvas canvas, float f, float f2, float f3, float f4, float f5) {
        synchronized (this.s) {
            for (c cVar : this.s) {
                if (cVar.e) {
                    ((E) cVar).a(canvas, f, f2, f3, f4, f5);
                }
            }
        }
    }

    protected boolean a(c cVar) {
        int i = this.a.f.g;
        return cVar.c >= (i - this.a.L) + -1 && cVar.c <= (i + this.a.L) + 1;
    }

    protected float c(RectF rectF, c cVar) {
        return this.a.T == 1 ? (((float) (this.a.L - cVar.c)) * this.a.K) - this.a.f.s() : (((float) (this.a.L + cVar.c)) * this.a.K) + this.a.f.s();
    }
}
