package com.xiaomi.push.service;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class F extends Handler {
    final /* synthetic */ C1135E a;

    F(C1135E c1135e, Looper looper) {
        this.a = c1135e;
        super(looper);
    }

    public void handleMessage(Message message) {
        this.a.b = true;
        this.a.a = System.currentTimeMillis();
        if (message.obj instanceof e) {
            ((e) message.obj).c();
        }
        this.a.b = false;
    }
}
