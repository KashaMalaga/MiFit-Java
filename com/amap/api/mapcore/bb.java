package com.amap.api.mapcore;

import android.os.Handler;
import android.os.Message;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class bb extends Handler {
    final /* synthetic */ ba a;

    bb(ba baVar) {
        this.a = baVar;
    }

    public void handleMessage(Message message) {
        if (message != null) {
            switch (message.what) {
                case a.i /*0*/:
                    this.a.b.a(this.a.h);
                    return;
                case l.a /*1*/:
                    this.a.b.d(this.a.j);
                    return;
                case a.k /*2*/:
                    this.a.b.c(this.a.i);
                    return;
                case a.l /*3*/:
                    this.a.b.b(this.a.f);
                    return;
                default:
                    return;
            }
        }
    }
}
