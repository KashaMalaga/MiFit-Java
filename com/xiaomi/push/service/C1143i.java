package com.xiaomi.push.service;

import com.xiaomi.channel.a.b.c;
import com.xiaomi.g.i;

class C1143i extends e {
    final /* synthetic */ XMPushService a;

    public C1143i(XMPushService xMPushService) {
        this.a = xMPushService;
        super(4);
    }

    public void a() {
        if (this.a.f()) {
            try {
                i.a();
                this.a.h.c();
            } catch (Exception e) {
                c.a((Throwable) e);
                this.a.b(10, e);
            }
        }
    }

    public String b() {
        return "send ping..";
    }
}
