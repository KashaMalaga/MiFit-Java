package com.xiaomi.push.service;

import com.xiaomi.f.c.g;
import com.xiaomi.f.c.i;

class A extends e {
    final /* synthetic */ XMPushService a;

    A(XMPushService xMPushService, int i) {
        this.a = xMPushService;
        super(i);
    }

    public void a() {
        if (this.a.h != null) {
            this.a.h.a(new g(i.unavailable), 15, null);
            this.a.h = null;
        }
    }

    public String b() {
        return "disconnect for service destroy.";
    }
}
