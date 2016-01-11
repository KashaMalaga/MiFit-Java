package com.f.a.b;

import com.f.a.b.e.a;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

class o {
    final j a;
    private Executor b;
    private Executor c;
    private Executor d;
    private final Map<Integer, String> e = Collections.synchronizedMap(new HashMap());
    private final Map<String, ReentrantLock> f = new WeakHashMap();
    private final AtomicBoolean g = new AtomicBoolean(false);
    private final AtomicBoolean h = new AtomicBoolean(false);
    private final AtomicBoolean i = new AtomicBoolean(false);
    private final Object j = new Object();

    o(j jVar) {
        this.a = jVar;
        this.b = jVar.g;
        this.c = jVar.h;
        this.d = a.a();
    }

    private void g() {
        if (!this.a.i && ((ExecutorService) this.b).isShutdown()) {
            this.b = h();
        }
        if (!this.a.j && ((ExecutorService) this.c).isShutdown()) {
            this.c = h();
        }
    }

    private Executor h() {
        return a.a(this.a.k, this.a.l, this.a.m);
    }

    String a(a aVar) {
        return (String) this.e.get(Integer.valueOf(aVar.f()));
    }

    ReentrantLock a(String str) {
        ReentrantLock reentrantLock = (ReentrantLock) this.f.get(str);
        if (reentrantLock != null) {
            return reentrantLock;
        }
        reentrantLock = new ReentrantLock();
        this.f.put(str, reentrantLock);
        return reentrantLock;
    }

    void a() {
        this.g.set(true);
    }

    void a(a aVar, String str) {
        this.e.put(Integer.valueOf(aVar.f()), str);
    }

    void a(r rVar) {
        this.d.execute(new p(this, rVar));
    }

    void a(w wVar) {
        g();
        this.c.execute(wVar);
    }

    void a(Runnable runnable) {
        this.d.execute(runnable);
    }

    void a(boolean z) {
        this.h.set(z);
    }

    void b() {
        this.g.set(false);
        synchronized (this.j) {
            this.j.notifyAll();
        }
    }

    void b(a aVar) {
        this.e.remove(Integer.valueOf(aVar.f()));
    }

    void b(boolean z) {
        this.i.set(z);
    }

    AtomicBoolean c() {
        return this.g;
    }

    Object d() {
        return this.j;
    }

    boolean e() {
        return this.h.get();
    }

    boolean f() {
        return this.i.get();
    }

    void stop() {
        if (!this.a.i) {
            ((ExecutorService) this.b).shutdownNow();
        }
        if (!this.a.j) {
            ((ExecutorService) this.c).shutdownNow();
        }
        this.e.clear();
        this.f.clear();
    }
}
