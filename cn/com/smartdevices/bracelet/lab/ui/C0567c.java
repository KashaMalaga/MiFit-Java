package cn.com.smartdevices.bracelet.lab.ui;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;

class C0567c extends Handler {
    final /* synthetic */ C0565b a;

    C0567c(C0565b c0565b) {
        this.a = c0565b;
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
