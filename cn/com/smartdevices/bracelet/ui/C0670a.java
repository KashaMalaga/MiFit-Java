package cn.com.smartdevices.bracelet.ui;

import android.os.Handler;
import android.os.Message;
import kankan.wheel.widget.l;

class C0670a extends Handler {
    final /* synthetic */ AlarmActivity a;

    C0670a(AlarmActivity alarmActivity) {
        this.a = alarmActivity;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case l.a /*1*/:
                this.a.h();
                return;
            default:
                return;
        }
    }
}
