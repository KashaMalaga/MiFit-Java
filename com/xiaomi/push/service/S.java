package com.xiaomi.push.service;

import com.xiaomi.account.openauth.h;
import com.xiaomi.channel.a.b.c;
import com.xiaomi.h.a.C1112s;

final class S extends e {
    final /* synthetic */ XMPushService a;
    final /* synthetic */ C1112s b;
    final /* synthetic */ String c;
    final /* synthetic */ String e;

    S(int i, XMPushService xMPushService, C1112s c1112s, String str, String str2) {
        this.a = xMPushService;
        this.b = c1112s;
        this.c = str;
        this.e = str2;
        super(i);
    }

    public void a() {
        try {
            C1112s a = M.e(this.a, this.b);
            a.h.a(h.P, this.c);
            a.h.a("reason", this.e);
            this.a.b(a);
        } catch (Exception e) {
            c.a((Throwable) e);
            this.a.b(10, e);
        }
    }

    public String b() {
        return "send wrong message ack for message.";
    }
}
