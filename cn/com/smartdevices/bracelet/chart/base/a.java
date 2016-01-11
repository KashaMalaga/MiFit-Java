package cn.com.smartdevices.bracelet.chart.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import java.util.Collections;
import java.util.List;

public class a extends g<c> {
    protected float c;
    protected int d;
    protected int e;
    protected b f;
    protected b g;
    protected boolean h;
    protected boolean i;

    public a(Context context) {
        super(context);
    }

    protected float a(RectF rectF, c cVar) {
        return (rectF.width() / ((float) this.s.size())) - (this.c * 2.0f);
    }

    protected void a(Canvas canvas, RectF rectF, float f) {
        synchronized (this.s) {
            int size = this.s.size();
            for (int i = 0; i < size; i++) {
                ((c) this.s.get(i)).a(canvas, f, this.h);
            }
        }
        if (this.f != null) {
            this.f.a(canvas, f);
        }
        if (this.g != null) {
            this.g.a(canvas, f);
        }
    }

    protected void a(RectF rectF) {
        if (this.f != null) {
            RectF rectF2 = new RectF();
            rectF2.left = rectF.left;
            rectF2.top = rectF.bottom - ((float) this.f.h);
            rectF2.right = rectF.right;
            rectF2.bottom = rectF.bottom;
            this.f.b(rectF2);
        }
        if (this.g != null) {
            rectF2 = new RectF();
            rectF2.left = rectF.left;
            rectF2.top = rectF.top;
            rectF2.right = rectF.left + ((float) this.g.h);
            rectF2.bottom = rectF.bottom;
            this.g.b(rectF2);
        }
        this.i = true;
    }

    protected void a(RectF rectF, List<? extends c> list) {
        if (rectF != null && list != null && list.size() != 0) {
            for (c cVar : list) {
                if (a(cVar)) {
                    RectF rectF2;
                    float a;
                    cVar.e = true;
                    if (this.i || cVar.j == null) {
                        if (cVar.j == null) {
                            cVar.j = new RectF();
                        }
                        rectF2 = cVar.j;
                        a = a(rectF, cVar);
                        float b = b(rectF, cVar);
                        if (this.h) {
                            rectF2.top = rectF.top + this.l;
                            rectF2.bottom = b + rectF2.top;
                        } else {
                            rectF2.bottom = rectF.bottom - this.n;
                            rectF2.top = rectF2.bottom - b;
                        }
                    } else {
                        rectF2 = cVar.j;
                        a = rectF2.width();
                    }
                    rectF2.left = rectF.left + this.c;
                    rectF2.right = a + rectF2.left;
                    rectF2.offset(c(rectF, cVar), 0.0f);
                } else {
                    cVar.e = false;
                }
            }
            this.i = false;
        }
    }

    public void a(boolean z) {
        this.i = z;
    }

    protected boolean a(c cVar) {
        return true;
    }

    protected void a_(List<c> list) {
        for (c cVar : list) {
            cVar.p = this.p;
            cVar.q = this.q;
        }
        this.i = true;
    }

    protected float b(RectF rectF, c cVar) {
        return cVar.b >= this.d ? (rectF.height() - this.l) - this.n : (((float) cVar.b) / ((float) this.d)) * ((rectF.height() - this.l) - this.n);
    }

    protected float c(RectF rectF, c cVar) {
        return (rectF.width() / ((float) this.s.size())) * ((float) this.s.indexOf(cVar));
    }

    public void c(float f) {
        this.c = f;
    }

    protected float d(RectF rectF, c cVar) {
        return 0.0f;
    }

    public void e() {
        synchronized (this.s) {
            a(this.j, this.s);
        }
    }

    public int i() {
        return this.d;
    }

    public void i(int i) {
        this.d = i;
    }

    public int j() {
        return this.e;
    }

    public void j(int i) {
        this.e = i;
    }

    public void k() {
        synchronized (this.s) {
            Collections.sort(this.s, new d());
        }
    }
}
