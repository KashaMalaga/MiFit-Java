package com.xiaomi.push.service;

import com.xiaomi.f.c.e;

class C1142h extends e {
    final /* synthetic */ XMPushService a;
    private e b = null;

    public C1142h(XMPushService xMPushService, e eVar) {
        this.a = xMPushService;
        super(8);
        this.b = eVar;
    }

    public void a() {
        this.a.j.a(this.b);
    }

    public String b() {
        return "receive a message.";
    }
}
