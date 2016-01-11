package com.xiaomi.push.service;

import com.xiaomi.channel.a.b.c;

class C1158x extends e {
    final /* synthetic */ String a;
    final /* synthetic */ byte[] b;
    final /* synthetic */ XMPushService c;

    C1158x(XMPushService xMPushService, int i, String str, byte[] bArr) {
        this.c = xMPushService;
        this.a = str;
        this.b = bArr;
        super(i);
    }

    public void a() {
        try {
            this.c.a(this.a, this.b);
        } catch (Exception e) {
            c.a((Throwable) e);
            this.c.b(10, e);
        }
    }

    public String b() {
        return "send mi push message";
    }
}
