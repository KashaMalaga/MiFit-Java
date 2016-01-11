package cn.com.smartdevices.bracelet.chart;

import android.content.Context;
import android.graphics.RectF;
import cn.com.smartdevices.bracelet.chart.base.a;
import cn.com.smartdevices.bracelet.chart.base.c;
import com.d.a.a.C1012a;

public class t extends a {
    private int a;

    public t(Context context) {
        super(context);
        this.f = new u(this, context);
        this.f.h = (int) (9.0f * this.p);
        this.d = C1012a.b;
        this.c = (float) ((int) (2.0f * this.p));
        a(0.0f, 0.0f, 0.0f, (float) this.f.h);
        this.a = (int) (7.0f * this.p);
    }

    protected float a(RectF rectF, c cVar) {
        return (rectF.width() / 18.0f) - (this.c * 2.0f);
    }

    public int a() {
        return 18;
    }

    public void a(int i) {
        ((u) this.f).g = i;
    }

    protected float b(RectF rectF, c cVar) {
        return cVar.b >= this.d ? (rectF.height() - this.l) - this.n : ((float) this.a) + ((((float) cVar.b) / ((float) this.d)) * (((rectF.height() - this.l) - this.n) - ((float) this.a)));
    }

    protected float c(RectF rectF, c cVar) {
        u uVar = (u) this.f;
        return ((float) (((v) cVar).c - uVar.g)) * uVar.c;
    }
}
