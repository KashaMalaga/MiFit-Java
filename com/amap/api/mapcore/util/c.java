package com.amap.api.mapcore.util;

import android.content.Context;
import android.view.MotionEvent;

public class c extends d {
    private final a l;
    private boolean m;

    public interface a {
        boolean a(c cVar);

        boolean b(c cVar);

        void c(c cVar);
    }

    public c(Context context, a aVar) {
        super(context);
        this.l = aVar;
    }

    protected void a() {
        super.a();
        this.m = false;
    }

    protected void a(int i, MotionEvent motionEvent) {
        switch (i) {
            case kankan.wheel.widget.a.k /*2*/:
                if (this.m) {
                    this.m = d(motionEvent);
                    if (!this.m) {
                        this.b = this.l.b(this);
                        return;
                    }
                    return;
                }
                return;
            case kankan.wheel.widget.a.X /*5*/:
                a();
                this.c = MotionEvent.obtain(motionEvent);
                this.g = 0;
                b(motionEvent);
                this.m = d(motionEvent);
                if (!this.m) {
                    this.b = this.l.b(this);
                    return;
                }
                return;
            case kankan.wheel.widget.a.bt /*6*/:
                if (!this.m) {
                    return;
                }
                return;
            default:
                return;
        }
    }

    public float b() {
        return (float) (((Math.atan2((double) this.i, (double) this.h) - Math.atan2((double) this.k, (double) this.j)) * 180.0d) / 3.141592653589793d);
    }

    protected void b(int i, MotionEvent motionEvent) {
        switch (i) {
            case kankan.wheel.widget.a.k /*2*/:
                b(motionEvent);
                if (this.e / this.f > 0.67f && this.l.a(this) && this.c != null) {
                    this.c.recycle();
                    this.c = MotionEvent.obtain(motionEvent);
                    return;
                }
                return;
            case kankan.wheel.widget.a.l /*3*/:
                if (!this.m) {
                    this.l.c(this);
                }
                a();
                return;
            case kankan.wheel.widget.a.bt /*6*/:
                b(motionEvent);
                if (!this.m) {
                    this.l.c(this);
                }
                a();
                return;
            default:
                return;
        }
    }
}
