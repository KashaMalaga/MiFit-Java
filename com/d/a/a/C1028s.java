package com.d.a.a;

class C1028s implements Runnable {
    final /* synthetic */ Throwable a;
    final /* synthetic */ C1026q b;

    C1028s(C1026q c1026q, Throwable th) {
        this.b = c1026q;
        this.a = th;
    }

    public void run() {
        this.b.d.onFailure(this.b.b, this.b.c, this.a, this.b.a, null);
    }
}
