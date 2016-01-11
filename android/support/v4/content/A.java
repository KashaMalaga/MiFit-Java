package android.support.v4.content;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class A implements ThreadFactory {
    private final AtomicInteger a = new AtomicInteger(1);

    A() {
    }

    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "ModernAsyncTask #" + this.a.getAndIncrement());
    }
}
