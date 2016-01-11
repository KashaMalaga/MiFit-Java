package android.support.v4.content;

import android.os.Handler;
import android.os.Message;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class F extends Handler {
    private F() {
    }

    public void handleMessage(Message message) {
        E e = (E) message.obj;
        switch (message.what) {
            case l.a /*1*/:
                e.a.e(e.b[0]);
                return;
            case a.k /*2*/:
                e.a.b(e.b);
                return;
            default:
                return;
        }
    }
}
