package com.xiaomi.f;

import com.xiaomi.push.service.e;

class j extends e {
    final /* synthetic */ Exception a;
    final /* synthetic */ C1091b b;

    j(C1091b c1091b, int i, Exception exception) {
        this.b = c1091b;
        this.a = exception;
        super(i);
    }

    public void a() {
        this.b.n.b(0, this.a);
    }

    public String b() {
        return "shutdown the connection. " + this.a;
    }
}
