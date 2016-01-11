package com.xiaomi.hm.health.bt.a;

import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.d.e;

public class o extends C {
    private boolean a = true;
    private e b = null;

    public o(d dVar, boolean z, e eVar) {
        super(dVar);
        this.a = z;
        this.b = eVar;
    }

    public void a(d dVar) {
        if (dVar != null) {
            dVar.c();
        }
        if (this.a) {
            int k_ = this.q.k_();
            if (k_ != -1) {
                this.b.a(k_);
            }
            C0596r.d(p, "getRealtimeSteps return " + k_);
        }
        boolean a = this.q.a(this.a, this.b);
        C0596r.d(p, "enableRealtimeStepNotification enable=" + this.a + ",result:" + a);
        if (dVar != null) {
            dVar.c(Boolean.valueOf(a));
        }
    }
}
