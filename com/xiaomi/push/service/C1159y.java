package com.xiaomi.push.service;

import android.content.Intent;

class C1159y extends e {
    final /* synthetic */ Intent a;
    final /* synthetic */ XMPushService b;

    C1159y(XMPushService xMPushService, int i, Intent intent) {
        this.b = xMPushService;
        this.a = intent;
        super(i);
    }

    public void a() {
        this.b.a(this.a);
    }

    public String b() {
        return "add Stats message";
    }
}
