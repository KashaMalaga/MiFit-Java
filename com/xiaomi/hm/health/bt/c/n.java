package com.xiaomi.hm.health.bt.c;

import cn.com.smartdevices.bracelet.C0596r;
import java.util.concurrent.ThreadFactory;

class n implements ThreadFactory {
    final /* synthetic */ C1118a a;

    n(C1118a c1118a) {
        this.a = c1118a;
    }

    public Thread newThread(Runnable runnable) {
        C0596r.e();
        C0596r.d("********************************");
        C0596r.d("NEW THREAD: " + C1118a.d);
        C0596r.d("********************************");
        Thread thread = new Thread(runnable, C1118a.d);
        thread.setUncaughtExceptionHandler(new o(this));
        return thread;
    }
}
