package cn.com.smartdevices.bracelet.shoes.ui;

import android.os.Handler;
import android.os.Message;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class C0660q extends Handler {
    final /* synthetic */ ShoesBindTestActivity a;

    C0660q(ShoesBindTestActivity shoesBindTestActivity) {
        this.a = shoesBindTestActivity;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case l.a /*1*/:
                this.a.m.setText((String) message.obj);
                return;
            case a.k /*2*/:
                this.a.q.setText("\u5b9e\u65f6\u6b65\u6570\uff1a" + message.arg1);
                return;
            case a.l /*3*/:
                this.a.h();
                return;
            case a.aQ /*4*/:
                this.a.j();
                return;
            default:
                return;
        }
    }
}
