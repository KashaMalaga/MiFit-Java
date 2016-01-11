package cn.com.smartdevices.bracelet.ui;

class W implements Runnable {
    final /* synthetic */ DailySportReportActivity a;

    W(DailySportReportActivity dailySportReportActivity) {
        this.a = dailySportReportActivity;
    }

    public void run() {
        this.a.m.setVisibility(0);
        this.a.o.setVisibility(0);
        this.a.mHomeBack.setVisibility(8);
        this.a.q.a(this.a.g());
        this.a.mHomeBack.setVisibility(0);
        this.a.o.setVisibility(4);
        this.a.m.setVisibility(4);
    }
}
