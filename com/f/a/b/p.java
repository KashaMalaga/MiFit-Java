package com.f.a.b;

import java.io.File;

class p implements Runnable {
    final /* synthetic */ r a;
    final /* synthetic */ o b;

    p(o oVar, r rVar) {
        this.b = oVar;
        this.a = rVar;
    }

    public void run() {
        File a = this.b.a.o.a(this.a.a());
        Object obj = (a == null || !a.exists()) ? null : 1;
        this.b.g();
        if (obj != null) {
            this.b.c.execute(this.a);
        } else {
            this.b.b.execute(this.a);
        }
    }
}
