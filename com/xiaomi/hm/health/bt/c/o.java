package com.xiaomi.hm.health.bt.c;

import cn.com.smartdevices.bracelet.C0596r;
import java.lang.Thread.UncaughtExceptionHandler;

class o implements UncaughtExceptionHandler {
    final /* synthetic */ n a;

    o(n nVar) {
        this.a = nVar;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        C0596r.e();
        th.printStackTrace();
    }
}
