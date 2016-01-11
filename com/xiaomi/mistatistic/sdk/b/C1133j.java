package com.xiaomi.mistatistic.sdk.b;

class C1133j implements p {
    final /* synthetic */ int a;
    final /* synthetic */ long b;
    final /* synthetic */ C1128e c;

    C1133j(C1128e c1128e, int i, long j) {
        this.c = c1128e;
        this.a = i;
        this.b = j;
    }

    public void a() {
        this.c.b = this.a;
        if (this.c.b == 4) {
            this.c.c = this.b;
        } else {
            this.c.c = -1;
        }
        E.b(C1125b.a(), "upload_policy", this.c.b);
        if (this.c.b == 4) {
            E.b(C1125b.a(), "upload_interval", this.c.c);
            m.a().a(new C1134k(this), this.c.c);
        }
    }
}
