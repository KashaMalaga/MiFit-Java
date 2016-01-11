package com.d.a.a;

class C1027r implements Runnable {
    final /* synthetic */ Object a;
    final /* synthetic */ C1026q b;

    C1027r(C1026q c1026q, Object obj) {
        this.b = c1026q;
        this.a = obj;
    }

    public void run() {
        this.b.d.onSuccess(this.b.b, this.b.c, this.b.a, this.a);
    }
}
