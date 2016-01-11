package com.xiaomi.push.service;

import com.xiaomi.channel.a.b.c;
import com.xiaomi.f.c.d;

public class C1147m extends e {
    private XMPushService a = null;
    private d[] b;

    public C1147m(XMPushService xMPushService, d[] dVarArr) {
        super(4);
        this.a = xMPushService;
        this.b = dVarArr;
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
        return "batch send message.";
    }
}
