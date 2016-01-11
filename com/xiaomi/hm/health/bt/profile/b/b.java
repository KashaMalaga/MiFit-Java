package com.xiaomi.hm.health.bt.profile.b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class b implements Runnable {
    protected static final String a = "RunningBaseTask";
    private static ExecutorService b = Executors.newSingleThreadExecutor();
    private static ExecutorService c = Executors.newSingleThreadExecutor();
    private static ExecutorService d = Executors.newSingleThreadExecutor();

    public void a() {
        b.execute(this);
    }

    public void b() {
        c.execute(this);
    }

    public void c() {
        d.execute(this);
    }

    protected abstract void d();

    public void run() {
        d();
    }

    public void stop() {
    }
}
