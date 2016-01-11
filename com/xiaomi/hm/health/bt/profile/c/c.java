package com.xiaomi.hm.health.bt.profile.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class c extends Handler {
    final /* synthetic */ a a;

    c(a aVar, Looper looper) {
        this.a = aVar;
        super(looper);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case a.i /*0*/:
                synchronized (this.a.e) {
                    this.a.e = (h) message.obj;
                }
                this.a.a(this.a.e);
                return;
            case l.a /*1*/:
                this.a.a();
                return;
            default:
                return;
        }
    }
}
