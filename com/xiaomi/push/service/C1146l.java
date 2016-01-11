package com.xiaomi.push.service;

import com.xiaomi.channel.a.b.c;

class C1146l extends e {
    Z a = null;
    int b;
    String c;
    String e;
    final /* synthetic */ XMPushService f;

    public C1146l(XMPushService xMPushService, Z z, int i, String str, String str2) {
        this.f = xMPushService;
        super(9);
        this.a = z;
        this.b = i;
        this.c = str;
        this.e = str2;
    }

    public void a() {
        if (!(this.a.m == ab.unbind || this.f.h == null)) {
            try {
                this.f.h.a(this.a.h, this.a.b);
            } catch (Exception e) {
                c.a((Throwable) e);
                this.f.b(10, e);
            }
        }
        this.a.a(ab.unbind, this.b, 0, this.e, this.c);
    }

    public String b() {
        return "unbind the channel. " + this.a.h + ", " + this.a.b;
    }
}
