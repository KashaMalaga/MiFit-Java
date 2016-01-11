package com.xiaomi.mistatistic.sdk.b;

class C1132i implements p {
    final /* synthetic */ C1128e a;

    C1132i(C1128e c1128e) {
        this.a = c1128e;
    }

    public void a() {
        this.a.b = E.a(C1125b.a(), "upload_policy", 4);
        if (this.a.b == 4) {
            this.a.c = E.a(C1125b.a(), "upload_interval", 180000);
        } else {
            this.a.c = -1;
        }
    }
}
