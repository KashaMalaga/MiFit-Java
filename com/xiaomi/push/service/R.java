package com.xiaomi.push.service;

import com.xiaomi.channel.a.b.c;
import com.xiaomi.h.a.C1112s;

final class R extends e {
    final /* synthetic */ XMPushService a;
    final /* synthetic */ C1112s b;
    final /* synthetic */ String c;

    R(int i, XMPushService xMPushService, C1112s c1112s, String str) {
        this.a = xMPushService;
        this.b = c1112s;
        this.c = str;
        super(i);
    }

    public void a() {
        try {
            C1112s a = M.e(this.a, this.b);
            a.m().a("absent_target_package", this.c);
            this.a.b(a);
        } catch (Exception e) {
            c.a((Throwable) e);
            this.a.b(10, e);
        }
    }

    public String b() {
        return "send app absent ack message for message.";
    }
}
