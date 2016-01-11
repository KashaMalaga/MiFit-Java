package com.xiaomi.hm.health.bt.bleservice;

import cn.com.smartdevices.bracelet.C0596r;
import java.lang.Thread.UncaughtExceptionHandler;

class h implements UncaughtExceptionHandler {
    final /* synthetic */ BLEService a;

    h(BLEService bLEService) {
        this.a = bLEService;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        C0596r.e();
        th.printStackTrace();
    }
}
