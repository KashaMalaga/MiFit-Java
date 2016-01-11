package cn.com.smartdevices.bracelet.gps.sync;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class C0470c extends Handler {
    final /* synthetic */ C0468b a;

    public C0470c(C0468b c0468b, Looper looper) {
        this.a = c0468b;
        super(looper);
    }

    public void handleMessage(Message message) {
        this.a.a((Intent) message.obj);
        this.a.stopSelf(message.arg1);
    }
}
