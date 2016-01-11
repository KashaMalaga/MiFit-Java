package com.xiaomi.hm.health.bt.bleservice;

import com.xiaomi.hm.health.bt.a.d;

class o extends d {
    final /* synthetic */ BLEService a;

    o(BLEService bLEService) {
        this.a = bLEService;
    }

    public void a(Object obj) {
        super.a(obj);
        if (obj != null) {
            this.a.b(6);
        } else {
            this.a.b(4);
        }
    }

    public void b(Object obj) {
        super.b(obj);
        this.a.b(4);
    }
}
