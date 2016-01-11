package cn.com.smartdevices.bracelet.chart;

import android.content.Context;
import android.graphics.RectF;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.chart.base.c;
import cn.com.smartdevices.bracelet.chart.util.a;
import cn.com.smartdevices.bracelet.chart.util.t;
import java.util.List;

class C0416f extends C0413c {
    final /* synthetic */ C0411a b;
    private float x;
    private int y = 10;

    public C0416f(C0411a c0411a, Context context) {
        this.b = c0411a;
        super(c0411a, context);
    }

    protected float a(RectF rectF, c cVar) {
        return (((rectF.width() - this.k) - this.m) / ((float) ((this.b.E - this.b.D) + 1))) - (this.c * 2.0f);
    }

    protected void a(RectF rectF) {
        super.a(rectF);
        if (rectF != null) {
            this.x = t.a(this.d, (rectF.height() - this.l) - this.n, this.y);
        }
    }

    protected void a_(List<c> list) {
        super.a_(list);
        this.d = t.a((List) list, 0, (int) a.b);
        if (this.j != null) {
            this.x = t.a(this.d, (this.j.height() - this.l) - this.n, this.y);
        }
        this.b.D = Integer.MAX_VALUE;
        this.b.E = 0;
        for (c cVar : list) {
            C0596r.e("Chart.DynamicDetailChart", "Step Item : " + cVar);
            if (cVar.c < this.b.D) {
                this.b.D = cVar.c;
            }
            if (cVar.c > this.b.E) {
                this.b.E = cVar.c;
            }
        }
        if (list.size() == 0) {
            this.b.D = 0;
            this.b.E = 47;
        } else {
            if (this.b.D % 6 != 0) {
                C0411a.c(this.b, this.b.D % 6);
            }
            if ((this.b.E + 1) % 6 != 0) {
                C0411a.d(this.b, 6 - ((this.b.E + 1) % 6));
            }
            if ((this.b.E - this.b.D) + 1 < 48) {
                this.b.D = (this.b.E - 48) + 1;
            }
        }
        this.b.B = this.b.D * 60;
        this.b.C = this.b.E * 60;
        ((C0412b) this.b.f).e();
    }

    protected float b(RectF rectF, c cVar) {
        return cVar.b >= this.d ? (rectF.height() - this.l) - this.n : t.a(this.d, cVar.b, this.x, this.y);
    }

    protected float c(RectF rectF, c cVar) {
        return ((C0412b) this.b.f).c() + (this.k + ((((rectF.width() - this.k) - this.m) / ((float) ((this.b.E - this.b.D) + 1))) * ((float) (cVar.c - this.b.D))));
    }
}
