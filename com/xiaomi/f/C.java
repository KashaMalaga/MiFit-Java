package com.xiaomi.f;

import com.xiaomi.push.service.e;

class C extends e {
    final /* synthetic */ int a;
    final /* synthetic */ Exception b;
    final /* synthetic */ A c;

    C(A a, int i, int i2, Exception exception) {
        this.c = a;
        this.a = i2;
        this.b = exception;
        super(i);
    }

    public void a() {
        this.c.u.b(this.a, this.b);
    }

    public String b() {
        return "shutdown the connection. " + this.a + ", " + this.b;
    }
}
