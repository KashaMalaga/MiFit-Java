package com.xiaomi.hm.health.bt.c;

class e implements Runnable {
    final /* synthetic */ B a;
    final /* synthetic */ byte[] b;
    final /* synthetic */ C1118a c;

    e(C1118a c1118a, B b, byte[] bArr) {
        this.c = c1118a;
        this.a = b;
        this.b = bArr;
    }

    public void run() {
        this.a.a(this.b);
    }
}
