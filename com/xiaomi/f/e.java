package com.xiaomi.f;

import java.util.concurrent.ThreadFactory;

class e implements ThreadFactory {
    final /* synthetic */ C1091b a;

    e(C1091b c1091b) {
        this.a = c1091b;
    }

    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "Smack Listener Processor (" + this.a.l + ")");
    }
}
