package android.support.v4.content;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

abstract class z<Params, Progress, Result> {
    private static final String a = "AsyncTask";
    private static final int b = 5;
    private static final int c = 128;
    public static final Executor d = new ThreadPoolExecutor(b, c, 1, TimeUnit.SECONDS, g, f);
    private static final int e = 1;
    private static final ThreadFactory f = new A();
    private static final BlockingQueue<Runnable> g = new LinkedBlockingQueue(10);
    private static final int h = 1;
    private static final int i = 2;
    private static final F j = new F();
    private static volatile Executor k = d;
    private final H<Params, Result> l = new B(this);
    private final FutureTask<Result> m = new C0089C(this, this.l);
    private volatile G n = G.PENDING;
    private final AtomicBoolean o = new AtomicBoolean();

    public static void a(Runnable runnable) {
        k.execute(runnable);
    }

    public static void a(Executor executor) {
        k = executor;
    }

    public static void b() {
        j.getLooper();
    }

    private void c(Result result) {
        if (!this.o.get()) {
            d((Object) result);
        }
    }

    private Result d(Result result) {
        F f = j;
        Object[] objArr = new Object[h];
        objArr[0] = result;
        f.obtainMessage(h, new E(this, objArr)).sendToTarget();
        return result;
    }

    private void e(Result result) {
        if (e()) {
            b((Object) result);
        } else {
            a((Object) result);
        }
        this.n = G.FINISHED;
    }

    public final z<Params, Progress, Result> a(Executor executor, Params... paramsArr) {
        if (this.n != G.PENDING) {
            switch (D.a[this.n.ordinal()]) {
                case h /*1*/:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case i /*2*/:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.n = G.RUNNING;
        d();
        this.l.b = paramsArr;
        executor.execute(this.m);
        return this;
    }

    public final Result a(long j, TimeUnit timeUnit) {
        return this.m.get(j, timeUnit);
    }

    protected abstract Result a(Params... paramsArr);

    protected void a() {
    }

    protected void a(Result result) {
    }

    public final boolean a(boolean z) {
        return this.m.cancel(z);
    }

    protected void b(Result result) {
        a();
    }

    protected void b(Progress... progressArr) {
    }

    public final G c() {
        return this.n;
    }

    public final z<Params, Progress, Result> c(Params... paramsArr) {
        return a(k, (Object[]) paramsArr);
    }

    protected void d() {
    }

    protected final void d(Progress... progressArr) {
        if (!e()) {
            j.obtainMessage(i, new E(this, progressArr)).sendToTarget();
        }
    }

    public final boolean e() {
        return this.m.isCancelled();
    }

    public final Result f() {
        return this.m.get();
    }
}
