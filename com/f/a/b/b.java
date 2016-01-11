package com.f.a.b;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class b implements ThreadFactory {
    private static final AtomicInteger a = new AtomicInteger(1);
    private final ThreadGroup b;
    private final AtomicInteger c = new AtomicInteger(1);
    private final String d;
    private final int e;

    b(int i, String str) {
        this.e = i;
        SecurityManager securityManager = System.getSecurityManager();
        this.b = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.d = str + a.getAndIncrement() + "-thread-";
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.b, runnable, this.d + this.c.getAndIncrement(), 0);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        thread.setPriority(this.e);
        return thread;
    }
}
