package android.support.v4.view;

import android.os.Handler;
import android.os.Message;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class C0196t extends Handler {
    final /* synthetic */ C0195s a;

    C0196t(C0195s c0195s) {
        this.a = c0195s;
    }

    C0196t(C0195s c0195s, Handler handler) {
        this.a = c0195s;
        super(handler.getLooper());
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case l.a /*1*/:
                this.a.l.onShowPress(this.a.s);
                return;
            case a.k /*2*/:
                this.a.d();
                return;
            case a.l /*3*/:
                if (this.a.m == null) {
                    return;
                }
                if (this.a.n) {
                    this.a.o = true;
                    return;
                } else {
                    this.a.m.onSingleTapConfirmed(this.a.s);
                    return;
                }
            default:
                throw new RuntimeException("Unknown message " + message);
        }
    }
}
