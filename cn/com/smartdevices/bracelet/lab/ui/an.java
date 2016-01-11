package cn.com.smartdevices.bracelet.lab.ui;

import android.os.CountDownTimer;

class an extends CountDownTimer {
    final /* synthetic */ StepsCountActivity a;

    an(StepsCountActivity stepsCountActivity, long j, long j2) {
        this.a = stepsCountActivity;
        super(j, j2);
    }

    public void onFinish() {
        this.a.c();
    }

    public void onTick(long j) {
        this.a.C = (int) (j / 1000);
        this.a.d.setText(Long.toString((long) this.a.C));
        this.a.e();
    }
}
