package com.huami.android.bitmapfun;

import java.util.concurrent.Callable;

class n implements Callable<Void> {
    final /* synthetic */ m a;

    n(m mVar) {
        this.a = mVar;
    }

    public Void a() {
        synchronized (this.a) {
            if (this.a.s == null) {
            } else {
                this.a.m();
                if (this.a.k()) {
                    this.a.j();
                    this.a.u = 0;
                }
            }
        }
        return null;
    }

    public /* synthetic */ Object call() {
        return a();
    }
}
