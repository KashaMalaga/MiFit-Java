package com.amap.api.mapcore.util;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public final class aw {
    private static aw a = null;
    private ExecutorService b;
    private ConcurrentHashMap<ay, Future<?>> c = new ConcurrentHashMap();
    private a d = new ax(this);

    private aw(int i) {
        try {
            this.b = Executors.newFixedThreadPool(i);
        } catch (Throwable th) {
            az.a(th, "TPool", "ThreadPool");
            th.printStackTrace();
        }
    }

    public static synchronized aw a(int i) {
        aw awVar;
        synchronized (aw.class) {
            if (a == null) {
                a = new aw(i);
            }
            awVar = a;
        }
        return awVar;
    }

    private synchronized void a(ay ayVar, boolean z) {
        try {
            Future future = (Future) this.c.remove(ayVar);
            if (z && future != null) {
                future.cancel(true);
            }
        } catch (Throwable th) {
            az.a(th, "TPool", "removeQueue");
            th.printStackTrace();
        }
    }
}
