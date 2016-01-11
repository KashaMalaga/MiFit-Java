package cn.com.smartdevices.bracelet.ui;

class C0745cu implements Runnable {
    final /* synthetic */ MainUIActivity a;

    C0745cu(MainUIActivity mainUIActivity) {
        this.a = mainUIActivity;
    }

    public void run() {
        this.a.r.post(new C0746cv(this));
        this.a.r.postDelayed(new C0747cw(this), 10000);
    }
}
