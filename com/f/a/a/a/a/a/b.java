package com.f.a.a.a.a.a;

import java.util.concurrent.Callable;

class b implements Callable<Void> {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public Void a() {
        synchronized (this.a) {
            if (this.a.w == null) {
            } else {
                this.a.o();
                this.a.p();
                if (this.a.m()) {
                    this.a.l();
                    this.a.y = 0;
                }
            }
        }
        return null;
    }

    public /* synthetic */ Object call() {
        return a();
    }
}
