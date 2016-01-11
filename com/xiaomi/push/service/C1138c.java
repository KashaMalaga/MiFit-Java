package com.xiaomi.push.service;

import com.xiaomi.channel.a.b.c;

public class C1138c extends e {
    final /* synthetic */ XMPushService a;

    C1138c(XMPushService xMPushService) {
        this.a = xMPushService;
        super(1);
    }

    public void a() {
        if (this.a.c()) {
            this.a.l();
        } else {
            c.a("should not connect. quit the job.");
        }
    }

    public String b() {
        return "do reconnect..";
    }
}
