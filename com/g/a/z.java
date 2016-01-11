package com.g.a;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class z {
    private static ExecutorService a = Executors.newSingleThreadExecutor();
    private static long b = 5;
    private static ExecutorService c = Executors.newSingleThreadExecutor();

    public static void a() {
        try {
            if (!a.isShutdown()) {
                a.shutdown();
            }
            if (!c.isShutdown()) {
                c.shutdown();
            }
            a.awaitTermination(b, TimeUnit.SECONDS);
            c.awaitTermination(b, TimeUnit.SECONDS);
        } catch (Exception e) {
        }
    }

    public static void a(Runnable runnable) {
        if (a.isShutdown()) {
            a = Executors.newSingleThreadExecutor();
        }
        a.execute(runnable);
    }

    public static void b(Runnable runnable) {
        if (c.isShutdown()) {
            c = Executors.newSingleThreadExecutor();
        }
        c.execute(runnable);
    }
}
