package com.xiaomi.hm.health.bt.profile.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.mistatistic.sdk.d;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class p extends Handler {
    final /* synthetic */ o a;

    p(o oVar, Looper looper) {
        this.a = oVar;
        super(looper);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case a.i /*0*/:
                this.a.a();
                return;
            case l.a /*1*/:
                this.a.b();
                return;
            case a.k /*2*/:
                this.a.c();
                sendEmptyMessageDelayed(2, d.g);
                return;
            case a.l /*3*/:
                if (this.a.q != null) {
                    this.a.q.a(message.arg1);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
