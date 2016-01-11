package com.xiaomi.hm.health.bt.bleservice;

import com.xiaomi.hm.health.bt.profile.Weight.c;
import com.xiaomi.hm.health.bt.profile.Weight.e;
import de.greenrobot.event.EventBus;

class d implements c {
    final /* synthetic */ BLEService a;

    d(BLEService bLEService) {
        this.a = bLEService;
    }

    public void a(e eVar) {
        EventBus.getDefault().post(eVar);
    }
}
