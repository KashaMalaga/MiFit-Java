package com.huami.android.bitmapfun;

import android.os.Handler;
import android.os.Message;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class g extends Handler {
    private g() {
    }

    public void handleMessage(Message message) {
        f fVar = (f) message.obj;
        switch (message.what) {
            case l.a /*1*/:
                fVar.a.e(fVar.b[0]);
                return;
            case a.k /*2*/:
                fVar.a.b(fVar.b);
                return;
            default:
                return;
        }
    }
}
