package cn.com.smartdevices.bracelet.gps.ui;

import android.os.Handler;
import android.os.Message;
import com.xiaomi.hm.health.b.a.n;
import kankan.wheel.widget.l;

class A extends Handler {
    final /* synthetic */ C0543z a;

    A(C0543z c0543z) {
        this.a = c0543z;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case l.a /*1*/:
                this.a.w.setText(this.a.getString(n.hr_not_wear_bracelet));
                return;
            default:
                return;
        }
    }
}
