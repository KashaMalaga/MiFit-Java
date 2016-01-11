package android.support.v4.content;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import kankan.wheel.widget.l;

class w extends Handler {
    final /* synthetic */ v a;

    w(v vVar, Looper looper) {
        this.a = vVar;
        super(looper);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case l.a /*1*/:
                this.a.a();
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
