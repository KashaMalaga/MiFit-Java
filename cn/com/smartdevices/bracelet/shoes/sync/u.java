package cn.com.smartdevices.bracelet.shoes.sync;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class u extends Handler {
    final /* synthetic */ C0643t a;
    private Looper b = null;

    public u(C0643t c0643t, Looper looper) {
        this.a = c0643t;
        super(looper);
        this.b = looper;
    }

    public void a() {
        if (this.b != null) {
            this.b.quit();
        }
    }

    public void handleMessage(Message message) {
        this.a.a(message);
        synchronized (this.a.d) {
            boolean b = this.a.c;
        }
        if (b && !this.a.a.hasMessages(0)) {
            this.a.a.a();
        }
    }
}
