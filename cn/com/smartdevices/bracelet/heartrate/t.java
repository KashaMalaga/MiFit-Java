package cn.com.smartdevices.bracelet.heartrate;

import cn.com.smartdevices.bracelet.Constant;
import java.util.TimerTask;

class t extends TimerTask {
    final /* synthetic */ HeartRateMainActivity a;

    private t(HeartRateMainActivity heartRateMainActivity) {
        this.a = heartRateMainActivity;
    }

    public void run() {
        if (this.a.s > 0) {
            cancel();
            this.a.a(true, false);
        } else if (this.a.s == 0) {
            this.a.a(false, false);
        } else if (this.a.p > Constant.dk) {
            cancel();
            this.a.a(false, false);
        } else {
            this.a.d.c((float) (this.a.p + 400));
            HeartRateMainActivity.b(this.a, 400);
        }
    }
}
