package com.xiaomi.hm.health.bt.a;

import cn.com.smartdevices.bracelet.C0596r;
import java.util.TimerTask;

class B extends TimerTask {
    final /* synthetic */ A a;

    B(A a) {
        this.a = a;
    }

    public void run() {
        C0596r.d(C.p, "run stopGetActivities!!!");
        this.a.B = true;
        this.a.j();
    }
}
