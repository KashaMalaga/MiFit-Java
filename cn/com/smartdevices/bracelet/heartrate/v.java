package cn.com.smartdevices.bracelet.heartrate;

import java.util.TimerTask;

class v extends TimerTask {
    final /* synthetic */ HeartRateMainActivity a;

    private v(HeartRateMainActivity heartRateMainActivity) {
        this.a = heartRateMainActivity;
    }

    public void run() {
        if (this.a.p < 0) {
            cancel();
            this.a.d.c(0.0f);
            return;
        }
        this.a.d.c((float) this.a.p);
        HeartRateMainActivity.c(this.a, 400);
    }
}
