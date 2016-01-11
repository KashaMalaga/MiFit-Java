package cn.com.smartdevices.bracelet.heartrate;

import android.os.Handler;
import android.os.Message;

class k extends Handler {
    final /* synthetic */ HeartRateMainActivity a;

    k(HeartRateMainActivity heartRateMainActivity) {
        this.a = heartRateMainActivity;
    }

    public void handleMessage(Message message) {
        this.a.A = new t(this.a);
        this.a.l.schedule(this.a.A, 0, 1000);
    }
}
