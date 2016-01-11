package cn.com.smartdevices.bracelet.gps.ui;

class C implements Runnable {
    final /* synthetic */ GPSResultActivity a;

    C(GPSResultActivity gPSResultActivity) {
        this.a = gPSResultActivity;
    }

    public void run() {
        this.a.H.a(this.a, this.a.G, 4, this.a.s.getWidth(), this.a.s.getHeight(), this.a.p);
    }
}
