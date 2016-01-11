package cn.com.smartdevices.bracelet.heartrate;

class q implements Runnable {
    final /* synthetic */ HeartRateMainActivity a;

    q(HeartRateMainActivity heartRateMainActivity) {
        this.a = heartRateMainActivity;
    }

    public void run() {
        if (this.a.n) {
            this.a.r.loadUrl("file:///android_asset/heartrate_wave.gif");
        }
    }
}
