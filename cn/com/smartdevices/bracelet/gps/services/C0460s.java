package cn.com.smartdevices.bracelet.gps.services;

import android.os.Handler;
import android.os.Message;

final class C0460s extends Handler {
    static final int a = 1;
    final /* synthetic */ C0456o b;

    private C0460s(C0456o c0456o) {
        this.b = c0456o;
    }

    public void a() {
        removeMessages(a);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case a /*1*/:
                this.b.f(message.arg1);
                return;
            default:
                return;
        }
    }
}
