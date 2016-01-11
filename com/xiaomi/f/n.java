package com.xiaomi.f;

import com.xiaomi.channel.a.b.c;
import com.xiaomi.push.service.e;

class n extends e {
    final /* synthetic */ Object a;
    final /* synthetic */ String b;
    final /* synthetic */ l c;

    n(l lVar, int i, Object obj, String str) {
        this.c = lVar;
        this.a = obj;
        this.b = str;
        super(i);
    }

    public void a() {
        if (this.c.a(this.a)) {
            c.a("setChallenge hash = " + com.xiaomi.channel.a.e.c.a(this.b).substring(0, 8));
            this.c.k = this.b;
            this.c.a(1, 0, null);
            return;
        }
        c.a("drop challenge = \u201c +  challenge + \u201c connection was already disconnected");
    }

    public String b() {
        return "Receive challenge";
    }
}
