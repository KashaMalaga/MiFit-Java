package com.xiaomi.hm.health.bt.e;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.hm.health.bt.model.e;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class b extends Handler {
    final /* synthetic */ a a;

    b(a aVar, Looper looper) {
        this.a = aVar;
        super(looper);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case a.i /*0*/:
                this.a.start();
                return;
            case l.a /*1*/:
                this.a.stop();
                return;
            case a.k /*2*/:
                this.a.b((e) message.obj);
                return;
            case a.l /*3*/:
                this.a.stop();
                Message message2 = new Message();
                message2.what = 0;
                message2.obj = message.obj;
                sendMessageDelayed(message2, 0);
                return;
            case a.aQ /*4*/:
                f fVar = (f) message.obj;
                if (this.a.r.remove(fVar)) {
                    fVar.d().b(fVar);
                }
                if (this.a.r.size() < 1) {
                    this.a.p = true;
                    sendEmptyMessage(1);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
