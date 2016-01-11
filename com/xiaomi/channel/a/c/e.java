package com.xiaomi.channel.a.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class e extends Handler {
    final /* synthetic */ b a;

    e(b bVar, Looper looper) {
        this.a = bVar;
        super(looper);
    }

    public void handleMessage(Message message) {
        d dVar = (d) message.obj;
        if (message.what == 0) {
            dVar.a();
        } else if (message.what == 1) {
            dVar.c();
        }
        super.handleMessage(message);
    }
}
