package cn.com.smartdevices.bracelet.heartrate;

import cn.com.smartdevices.bracelet.Constant;
import com.xiaomi.channel.b.v;
import java.util.TimerTask;

class w extends TimerTask {
    final /* synthetic */ HeartRateMainActivity a;

    private w(HeartRateMainActivity heartRateMainActivity) {
        this.a = heartRateMainActivity;
    }

    public void run() {
        if (this.a.s > 0) {
            cancel();
            this.a.a(true, false);
        } else if (this.a.s == 0) {
            this.a.a(false, false);
        } else if (this.a.p > Constant.di) {
            cancel();
            this.a.m.sendEmptyMessage(1);
        } else {
            this.a.d.c((float) this.a.p);
            HeartRateMainActivity.b(this.a, (int) v.C);
        }
    }
}
