package com.huami.android.bitmapfun;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class C1061a<Params, Progress, Result> {
    public static final Executor a = new ThreadPoolExecutor(e, f, 1, TimeUnit.SECONDS, i, h, new DiscardOldestPolicy());
    public static final Executor b = (E.c() ? new h() : Executors.newSingleThreadExecutor(h));
    public static final Executor c = Executors.newFixedThreadPool(k, h);
    private static final String d = "AsyncTask";
    private static final int e = 5;
    private static final int f = 128;
    private static final int g = 1;
    private static final ThreadFactory h = new C1062b();
    private static final BlockingQueue<Runnable> i = new LinkedBlockingQueue(10);
    private static final int j = 1;
    private static final int k = 2;
    private static final g l = new g();
    private static volatile Executor m = b;
    private final k<Params, Result> n = new C1063c(this);
    private final FutureTask<Result> o = new C1064d(this, this.n);
    private volatile j p = j.PENDING;
    private final AtomicBoolean q = new AtomicBoolean();
    private final AtomicBoolean r = new AtomicBoolean();

    public static void a() {
        l.getLooper();
    }

    public static void a(Runnable runnable) {
        m.execute(runnable);
    }

    public static void a(Executor executor) {
        m = executor;
    }

    private void c(Result result) {
        if (!this.r.get()) {
            d((Object) result);
        }
    }

    private Result d(Result result) {
        g gVar = l;
        Object[] objArr = new Object[j];
        objArr[0] = result;
        gVar.obtainMessage(j, new f(this, objArr)).sendToTarget();
        return result;
    }

    private void e(Result result) {
        if (e()) {
            b((Object) result);
        } else {
            a((Object) result);
        }
        this.p = j.FINISHED;
    }

    public final C1061a<Params, Progress, Result> a(Executor executor, Params... paramsArr) {
        if (this.p != j.PENDING) {
            switch (C1065e.a[this.p.ordinal()]) {
                case j /*1*/:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case k /*2*/:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.p = j.RUNNING;
        c();
        this.n.b = paramsArr;
        executor.execute(this.o);
        return this;
    }

    public final Result a(long j, TimeUnit timeUnit) {
        return this.o.get(j, timeUnit);
    }

    protected abstract Result a(Params... paramsArr);

    protected void a(Result result) {
    }

    public final boolean a(boolean z) {
        this.q.set(true);
        return this.o.cancel(z);
    }

    public final j b() {
        return this.p;
    }

    protected void b(Result result) {
        d();
    }

    protected void b(Progress... progressArr) {
    }

    public final C1061a<Params, Progress, Result> c(Params... paramsArr) {
        return a(m, (Object[]) paramsArr);
    }

    protected void c() {
    }

    protected void d() {
    }

    protected final void d(Progress... progressArr) {
        if (!e()) {
            l.obtainMessage(k, new f(this, progressArr)).sendToTarget();
        }
    }

    public final boolean e() {
        return this.q.get();
    }

    public final Result f() {
        return this.o.get();
    }
}
