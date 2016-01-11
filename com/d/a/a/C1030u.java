package com.d.a.a;

class C1030u implements Runnable {
    final /* synthetic */ Object a;
    final /* synthetic */ C1029t b;

    C1030u(C1029t c1029t, Object obj) {
        this.b = c1029t;
        this.a = obj;
    }

    public void run() {
        this.b.e.onFailure(this.b.b, this.b.c, this.b.d, this.b.a, this.a);
    }
}
