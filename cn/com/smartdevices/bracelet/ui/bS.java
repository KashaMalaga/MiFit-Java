package cn.com.smartdevices.bracelet.ui;

class bS implements Runnable {
    final /* synthetic */ MainUIActivity a;

    bS(MainUIActivity mainUIActivity) {
        this.a = mainUIActivity;
    }

    public void run() {
        this.a.r.post(new bT(this));
        this.a.r.postDelayed(new bU(this), 5000);
    }
}
