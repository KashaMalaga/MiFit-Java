package com.xiaomi.account.openauth;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

abstract class o<V> implements Runnable {
    private static ExecutorService a = Executors.newCachedThreadPool();
    protected j<V> c = new j();

    o() {
    }

    protected abstract void a();

    public final void run() {
        a();
    }

    j<V> start() {
        a.execute(this);
        return this.c;
    }
}
