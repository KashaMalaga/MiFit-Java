package com.xiaomi.channel.a.b;

import com.xiaomi.e.a;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class c {
    private static int a = 2;
    private static a b = new b();
    private static final HashMap<Integer, Long> c = new HashMap();
    private static final HashMap<Integer, String> d = new HashMap();
    private static final Integer e = Integer.valueOf(-1);
    private static AtomicInteger f = new AtomicInteger(1);

    public static void a(int i) {
        if (i < 0 || i > 5) {
            a(2, "set log level as " + i);
        }
        a = i;
    }

    public static void a(int i, String str) {
        if (i >= a) {
            b.b(str);
        }
    }

    public static void a(int i, String str, Throwable th) {
        if (i >= a) {
            b.a(str, th);
        }
    }

    public static void a(int i, Throwable th) {
        if (i >= a) {
            b.a(a.f, th);
        }
    }

    public static void a(a aVar) {
        b = aVar;
    }

    public static void a(Integer num) {
        if (a <= 1 && c.containsKey(num)) {
            long currentTimeMillis = System.currentTimeMillis() - ((Long) c.remove(num)).longValue();
            b.b(((String) d.remove(num)) + " ends in " + currentTimeMillis + " ms");
        }
    }

    public static void a(String str) {
        a(2, "[Thread:" + Thread.currentThread().getId() + "] " + str);
    }

    public static void a(String str, Throwable th) {
        a(4, str, th);
    }

    public static void a(Throwable th) {
        a(4, th);
    }

    public static void b(String str) {
        a(1, "[Thread:" + Thread.currentThread().getId() + "] " + str);
    }

    public static void c(String str) {
        a(4, str);
    }

    public static Integer d(String str) {
        if (a > 1) {
            return e;
        }
        Integer valueOf = Integer.valueOf(f.incrementAndGet());
        c.put(valueOf, Long.valueOf(System.currentTimeMillis()));
        d.put(valueOf, str);
        b.b(str + " starts");
        return valueOf;
    }
}
