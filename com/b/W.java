package com.b;

import java.util.concurrent.Callable;

class W implements Callable<Void> {
    final /* synthetic */ R a;

    W(R r) {
        this.a = r;
    }

    public Void a() {
        synchronized (this.a) {
            if (this.a.k == null) {
            } else {
                this.a.h();
                if (this.a.f()) {
                    this.a.e();
                    this.a.m = 0;
                }
            }
        }
        return null;
    }

    public /* synthetic */ Object call() {
        return a();
    }
}
