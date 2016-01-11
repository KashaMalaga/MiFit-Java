package com.xiaomi.push.service;

public class C1139d extends e {
    public int a;
    public Exception b;
    final /* synthetic */ XMPushService c;

    C1139d(XMPushService xMPushService, int i, Exception exception) {
        this.c = xMPushService;
        super(2);
        this.a = i;
        this.b = exception;
    }

    public void a() {
        this.c.b(this.a, this.b);
    }

    public String b() {
        return "disconnect the connection.";
    }
}
