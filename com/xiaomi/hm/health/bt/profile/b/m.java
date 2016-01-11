package com.xiaomi.hm.health.bt.profile.b;

import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.a.d;
import com.xiaomi.hm.health.bt.model.p;
import kankan.wheel.widget.a;

public class m extends b {
    private f b = null;
    private d c = null;
    private int d = 48;

    public m(f fVar, int i, d dVar) {
        this.b = fVar;
        this.c = dVar;
        this.d = i;
    }

    protected void d() {
        boolean z = true;
        if (this.c != null) {
            this.c.c();
        }
        if (this.b != null && this.b.u()) {
            p x = this.b.x();
            C0596r.d("RunningBaseTask", "lep:" + x);
            if (x == null) {
                z = false;
            } else if ((this.d >= 60 || x.a >= 60) && ((double) Math.abs(this.d - x.a)) > ((double) this.d) * 0.1d) {
                z = false;
            }
            if (!z) {
                z = this.b.a(this.d, this.d, 0, a.aB, 0);
                C0596r.d("RunningBaseTask", "lep:" + this.b.x());
            }
            if (this.c != null) {
                this.c.c(Boolean.valueOf(z));
            }
        } else if (this.c != null) {
            this.c.c(Boolean.valueOf(false));
        }
    }
}
