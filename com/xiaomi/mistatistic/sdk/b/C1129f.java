package com.xiaomi.mistatistic.sdk.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class C1129f extends Handler {
    final /* synthetic */ C1128e a;

    C1129f(C1128e c1128e, Looper looper) {
        this.a = c1128e;
        super(looper);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case l.a /*1*/:
                m.a().a(new C1130g(this));
                return;
            case a.k /*2*/:
                m.a().a(new C1131h(this));
                return;
            default:
                return;
        }
    }
}
