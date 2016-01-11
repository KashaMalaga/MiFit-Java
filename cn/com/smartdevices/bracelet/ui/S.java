package cn.com.smartdevices.bracelet.ui;

class S implements Runnable {
    final /* synthetic */ DailySleepReportActivity a;

    S(DailySleepReportActivity dailySleepReportActivity) {
        this.a = dailySleepReportActivity;
    }

    public void run() {
        this.a.o.setVisibility(0);
        this.a.q.setVisibility(0);
        this.a.mHomeBack.setVisibility(8);
        this.a.t.a(this.a.f());
        this.a.mHomeBack.setVisibility(0);
        this.a.q.setVisibility(4);
        this.a.o.setVisibility(4);
    }
}
