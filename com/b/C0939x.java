package com.b;

import android.os.Handler;
import android.os.Message;
import kankan.wheel.widget.l;

final class C0939x extends Handler {
    private /* synthetic */ C0938w a;

    C0939x(C0938w c0938w) {
        this.a = c0938w;
    }

    public final void handleMessage(Message message) {
        try {
            switch (message.what) {
                case l.a /*1*/:
                    if (this.a.a.E != null) {
                        this.a.a.E.a((String) message.obj);
                        return;
                    }
                    return;
                default:
                    return;
            }
        } catch (Exception e) {
        }
    }
}
