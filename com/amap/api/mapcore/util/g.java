package com.amap.api.mapcore.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class g implements ThreadFactory {
    private final AtomicInteger a = new AtomicInteger(1);

    g() {
    }

    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "AsyncTask #" + this.a.getAndIncrement());
    }
}
