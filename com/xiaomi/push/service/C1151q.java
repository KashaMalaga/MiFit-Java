package com.xiaomi.push.service;

import com.xiaomi.channel.a.b.c;
import com.xiaomi.f.c.e;

public class C1151q extends e {
    private XMPushService a = null;
    private e b;

    public C1151q(XMPushService xMPushService, e eVar) {
        super(4);
        this.a = xMPushService;
        this.b = eVar;
    }

    public void a() {
        try {
            this.a.a(this.b);
        } catch (Exception e) {
            c.a((Throwable) e);
            this.a.b(10, e);
        }
    }

    public String b() {
        return "send a message.";
    }
}
