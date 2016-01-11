package com.xiaomi.hm.health.bt.bleservice;

import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.profile.Weight.b;

class e implements b {
    final /* synthetic */ BLEService a;

    e(BLEService bLEService) {
        this.a = bLEService;
    }

    public void a() {
        C0596r.d("BLEService", "onLowBattery");
        this.a.E.post(new f(this));
    }
}
