package cn.com.smartdevices.bracelet.gps.g;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class g extends Handler {
    final /* synthetic */ e a;

    public g(e eVar, Looper looper) {
        this.a = eVar;
        super(looper);
    }

    public void handleMessage(Message message) {
        this.a.a(message);
    }
}
