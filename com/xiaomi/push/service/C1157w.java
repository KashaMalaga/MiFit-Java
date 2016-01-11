package com.xiaomi.push.service;

import com.tencent.connect.common.Constants;
import com.xiaomi.channel.a.c.a;
import com.xiaomi.f.o;

class C1157w extends e {
    final /* synthetic */ int a;
    final /* synthetic */ byte[] b;
    final /* synthetic */ String c;
    final /* synthetic */ XMPushService e;

    C1157w(XMPushService xMPushService, int i, int i2, byte[] bArr, String str) {
        this.e = xMPushService;
        this.a = i2;
        this.b = bArr;
        this.c = str;
        super(i);
    }

    public void a() {
        I.b(this.e);
        X.a().a(Constants.VIA_SHARE_TYPE_TEXT);
        a.a(this.a);
        this.e.b.c(o.d());
        this.e.a(this.b, this.c);
    }

    public String b() {
        return "clear account cache.";
    }
}
