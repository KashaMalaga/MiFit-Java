package com.amap.api.mapcore.util;

import java.util.concurrent.Callable;

class bm implements Callable<Void> {
    final /* synthetic */ bl a;

    bm(bl blVar) {
        this.a = blVar;
    }

    public Void a() {
        synchronized (this.a) {
            if (this.a.k == null) {
            } else {
                this.a.j();
                if (this.a.h()) {
                    this.a.g();
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
