package cn.com.smartdevices.bracelet.ui;

import android.os.Handler;
import android.os.Message;
import cn.com.smartdevices.bracelet.upgrade.OtaVersionInfo;
import kankan.wheel.widget.l;

class C0779ea extends Handler {
    final /* synthetic */ dW a;

    C0779ea(dW dWVar) {
        this.a = dWVar;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case l.a /*1*/:
                this.a.m = (OtaVersionInfo) message.obj;
                this.a.b(this.a.m);
                return;
            case 4098:
                this.a.d();
                return;
            default:
                return;
        }
    }
}
