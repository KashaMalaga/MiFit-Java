package cn.com.smartdevices.bracelet.heartrate;

import android.os.CountDownTimer;
import com.xiaomi.e.a;

class g extends CountDownTimer {
    final /* synthetic */ HeartRateGuideActivity a;

    g(HeartRateGuideActivity heartRateGuideActivity, long j, long j2) {
        this.a = heartRateGuideActivity;
        super(j, j2);
    }

    public void onFinish() {
        this.a.d();
    }

    public void onTick(long j) {
        this.a.b.setText((j / 1000) + a.f);
    }
}
