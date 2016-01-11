package cn.com.smartdevices.bracelet.activity;

import android.os.Handler;
import android.os.Message;
import kankan.wheel.widget.l;

class x extends Handler {
    final /* synthetic */ StartUpActivity a;

    x(StartUpActivity startUpActivity) {
        this.a = startUpActivity;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case l.a /*1*/:
                this.a.e();
                break;
        }
        super.handleMessage(message);
    }
}
