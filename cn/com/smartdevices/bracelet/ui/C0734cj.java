package cn.com.smartdevices.bracelet.ui;

class C0734cj implements Runnable {
    final /* synthetic */ MainUIActivity a;

    C0734cj(MainUIActivity mainUIActivity) {
        this.a = mainUIActivity;
    }

    public void run() {
        this.a.runOnUiThread(new C0735ck(this));
    }
}
