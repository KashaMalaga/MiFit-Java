package com.xiaomi.hm.health.bt.c;

import cn.com.smartdevices.bracelet.C0596r;

class C1119b implements Runnable {
    final /* synthetic */ C1118a a;

    C1119b(C1118a c1118a) {
        this.a = c1118a;
    }

    public void run() {
        this.a.z = C.DISCONNECTED;
        C0596r.c("=================================================");
        C0596r.c("=============== CONNECT TIMEOUT ===============");
        C0596r.c("=================================================");
        this.a.x.execute(new C1120c(this));
    }
}
