package cn.com.smartdevices.bracelet.gps.services;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;

class C0452k extends Handler {
    final /* synthetic */ C0451j a;

    C0452k(C0451j c0451j) {
        this.a = c0451j;
    }

    public void handleMessage(Message message) {
        synchronized (this.a) {
            long a = this.a.b - SystemClock.elapsedRealtime();
            if (a <= 0) {
                this.a.b();
            } else {
                sendMessageDelayed(obtainMessage(1), a);
            }
        }
    }
}
