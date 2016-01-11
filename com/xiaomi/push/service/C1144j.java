package com.xiaomi.push.service;

import com.xiaomi.channel.a.b.c;

class C1144j extends e {
    Z a = null;
    final /* synthetic */ XMPushService b;

    public C1144j(XMPushService xMPushService, Z z) {
        this.b = xMPushService;
        super(4);
        this.a = z;
    }

    public void a() {
        try {
            this.a.a(ab.unbind, 1, 16, null, null);
            this.b.h.a(this.a.h, this.a.b);
            this.a.a(ab.binding, 1, 16, null, null);
            this.b.h.a(this.a);
        } catch (Exception e) {
            c.a((Throwable) e);
            this.b.b(10, e);
        }
    }

    public String b() {
        return "bind the client. " + this.a.h + ", " + this.a.b;
    }
}
