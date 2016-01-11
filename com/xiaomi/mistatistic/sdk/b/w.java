package com.xiaomi.mistatistic.sdk.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class w extends Handler {
    final /* synthetic */ u a;

    w(u uVar, Looper looper) {
        this.a = uVar;
        super(looper);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1023:
                m.b().a(new x(this));
                return;
            default:
                return;
        }
    }
}
