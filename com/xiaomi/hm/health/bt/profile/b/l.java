package com.xiaomi.hm.health.bt.profile.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.mistatistic.sdk.d;
import kankan.wheel.widget.a;

class l extends Handler {
    final /* synthetic */ k a;

    l(k kVar, Looper looper) {
        this.a = kVar;
        super(looper);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case a.i /*0*/:
                this.a.g();
                return;
            case kankan.wheel.widget.l.a /*1*/:
                this.a.h();
                return;
            case a.k /*2*/:
                this.a.f();
                sendEmptyMessageDelayed(2, d.g);
                return;
            case a.l /*3*/:
                if (this.a.m != null) {
                    this.a.m.a(message.arg1);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
