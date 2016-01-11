package com.xiaomi.push.service;

import com.xiaomi.channel.a.b.c;
import com.xiaomi.g.i;

class C1136a extends e {
    Z a = null;
    final /* synthetic */ XMPushService b;

    public C1136a(XMPushService xMPushService, Z z) {
        this.b = xMPushService;
        super(9);
        this.a = z;
    }

    public void a() {
        try {
            if (this.b.f()) {
                Z b = X.a().b(this.a.h, this.a.b);
                if (b == null) {
                    c.a("ignore bind because the channel " + this.a.h + " is removed ");
                    return;
                } else if (b.m == ab.unbind) {
                    b.a(ab.binding, 0, 0, null, null);
                    this.b.h.a(b);
                    i.a(this.b, b);
                    return;
                } else {
                    c.a("trying duplicate bind, ingore! " + b.m);
                    return;
                }
            }
            c.c("trying bind while the connection is not created, quit!");
        } catch (Exception e) {
            c.a((Throwable) e);
            this.b.b(10, e);
        }
    }

    public String b() {
        return "bind the client. " + this.a.h + ", " + this.a.b;
    }
}
