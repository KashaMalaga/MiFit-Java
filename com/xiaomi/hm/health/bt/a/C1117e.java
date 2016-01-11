package com.xiaomi.hm.health.bt.a;

import android.os.Handler;
import android.os.Message;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class C1117e extends Handler {
    final /* synthetic */ d a;

    C1117e(d dVar) {
        this.a = dVar;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case a.i /*0*/:
                this.a.a();
                return;
            case l.a /*1*/:
                this.a.a(message.obj);
                return;
            case a.k /*2*/:
                this.a.a(message.arg1);
                return;
            case a.l /*3*/:
                this.a.b(message.obj);
                return;
            default:
                return;
        }
    }
}
