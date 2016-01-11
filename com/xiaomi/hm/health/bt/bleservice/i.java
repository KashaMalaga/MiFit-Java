package com.xiaomi.hm.health.bt.bleservice;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class i extends Handler {
    final /* synthetic */ BLEService a;

    i(BLEService bLEService, Looper looper) {
        this.a = bLEService;
        super(looper);
    }

    public void handleMessage(Message message) {
        this.a.a(message);
    }
}
