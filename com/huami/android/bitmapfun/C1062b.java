package com.huami.android.bitmapfun;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class C1062b implements ThreadFactory {
    private final AtomicInteger a = new AtomicInteger(1);

    C1062b() {
    }

    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "AsyncTask #" + this.a.getAndIncrement());
    }
}
