package com.xiaomi.c.a;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

final class C1083n {
    private static final Logger a = Logger.getLogger(C1083n.class.getName());
    private final C1078u b;
    private final Lock c = new ReentrantLock();
    private final Condition d = this.c.newCondition();
    private C1084o e;

    C1083n(C1078u c1078u) {
        if (c1078u == null) {
            throw new IllegalArgumentException("Request body cannot be null");
        }
        this.b = c1078u;
    }

    C1078u a() {
        return this.b;
    }

    void a(C1084o c1084o) {
        this.c.lock();
        try {
            if (this.e != null) {
                throw new IllegalStateException("HTTPResponse was already set");
            }
            this.e = c1084o;
            this.d.signalAll();
        } finally {
            this.c.unlock();
        }
    }

    C1084o b() {
        this.c.lock();
        while (this.e == null) {
            try {
                this.d.await();
            } catch (Throwable e) {
                a.log(Level.FINEST, "Interrupted", e);
            } catch (Throwable th) {
                this.c.unlock();
            }
        }
        C1084o c1084o = this.e;
        this.c.unlock();
        return c1084o;
    }
}
