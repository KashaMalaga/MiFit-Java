package com.xiaomi.push.service;

import com.xiaomi.channel.a.b.c;
import com.xiaomi.h.a.C1112s;

final class N extends e {
    final /* synthetic */ XMPushService a;
    final /* synthetic */ C1112s b;

    N(int i, XMPushService xMPushService, C1112s c1112s) {
        this.a = xMPushService;
        this.b = c1112s;
        super(i);
    }

    public void a() {
        try {
            this.a.b(this.a.a(this.b.j(), this.b.h()));
        } catch (Exception e) {
            c.a((Throwable) e);
            this.a.b(10, e);
        }
    }

    public String b() {
        return "send app absent message.";
    }
}
