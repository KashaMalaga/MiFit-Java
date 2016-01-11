package cn.com.smartdevices.bracelet.chart;

import android.content.Context;
import android.graphics.RectF;
import cn.com.smartdevices.bracelet.chart.base.c;
import java.util.List;

class C0415e extends C0413c {
    final /* synthetic */ C0411a b;

    public C0415e(C0411a c0411a, Context context) {
        this.b = c0411a;
        super(c0411a, context);
    }

    protected float a(RectF rectF, c cVar) {
        if (cVar.c > this.b.C || cVar.c < this.b.B || this.b.B == this.b.C) {
            return 0.0f;
        }
        float width = ((((rectF.width() - this.k) - this.m) / ((float) ((this.b.C - this.b.B) + 1))) * ((float) cVar.d)) - (this.c * 2.0f);
        return width < this.p * 1.0f ? this.p * 1.0f : width;
    }

    protected void a_(List<c> list) {
        if (this.b.B != this.b.C) {
            super.a_(list);
        }
    }

    protected float b(RectF rectF, c cVar) {
        return cVar.b == 3 ? 196.6f * this.p : (cVar.b == 2 || cVar.b == 1 || cVar.b == 4) ? 160.0f * this.p : 0.0f;
    }

    protected float c(RectF rectF, c cVar) {
        if (cVar.c > this.b.C || cVar.c < this.b.B || this.b.B == this.b.C) {
            return 0.0f;
        }
        return ((C0412b) this.b.f).c() + (this.k + ((((rectF.width() - this.k) - this.m) / ((float) ((this.b.C - this.b.B) + 1))) * ((float) (cVar.c - this.b.B))));
    }
}
