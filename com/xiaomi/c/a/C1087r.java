package com.xiaomi.c.a;

import java.security.SecureRandom;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class C1087r {
    private static final SecureRandom a = new SecureRandom();
    private static final Lock b = new ReentrantLock();
    private AtomicLong c;

    C1087r() {
        this.c = new AtomicLong();
        this.c = new AtomicLong(b());
    }

    private long b() {
        long nextLong;
        b.lock();
        while (true) {
            try {
                nextLong = a.nextLong() & 9007199254740991L;
                if (nextLong <= 9007194959773696L) {
                    break;
                }
            } finally {
                b.unlock();
            }
        }
        return nextLong;
    }

    public long a() {
        return this.c.getAndIncrement();
    }
}
