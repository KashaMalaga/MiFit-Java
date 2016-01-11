package cn.com.smartdevices.bracelet.lab.ui;

import android.os.Handler;
import android.os.Message;

final class ah extends Handler {
    static final int a = 1;
    static final int b = 2;
    final /* synthetic */ af c;

    private ah(af afVar) {
        this.c = afVar;
    }

    public void a() {
        removeMessages(a);
        removeMessages(b);
    }

    public void dispatchMessage(Message message) {
        switch (message.what) {
            case a /*1*/:
                this.c.h.a();
                return;
            case b /*2*/:
                if (message.arg1 == 0) {
                    removeMessages(a);
                    this.c.h.a(this.c.l, this.c.e, false, 3, 1.0f);
                    Message obtainMessage = this.c.d.obtainMessage();
                    obtainMessage.what = a;
                    obtainMessage.arg1 = message.arg1;
                    sendMessageDelayed(obtainMessage, 2000);
                    return;
                } else if (message.arg1 == a) {
                    this.c.i.a(this.c.l, this.c.f, false, 3, 1.0f);
                    return;
                } else if (message.arg1 == b) {
                    this.c.j.a(this.c.l, this.c.g, false, 3, 1.0f);
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }
}
