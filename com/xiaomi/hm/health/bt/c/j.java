package com.xiaomi.hm.health.bt.c;

import cn.com.smartdevices.bracelet.C0596r;
import java.lang.Thread.UncaughtExceptionHandler;

class j implements UncaughtExceptionHandler {
    final /* synthetic */ C1118a a;

    j(C1118a c1118a) {
        this.a = c1118a;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        C0596r.e();
        th.printStackTrace();
    }
}
