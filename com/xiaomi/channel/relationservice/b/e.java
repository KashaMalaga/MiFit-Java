package com.xiaomi.channel.relationservice.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Iterator;

class e extends Handler {
    final /* synthetic */ a a;

    public e(a aVar, Looper looper) {
        this.a = aVar;
        super(looper);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        synchronized (this.a.d) {
            Iterator it = this.a.d.iterator();
            while (it.hasNext()) {
                ((d) it.next()).a(message);
            }
        }
    }
}
