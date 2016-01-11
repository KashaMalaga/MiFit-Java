package cn.com.smartdevices.bracelet.ui;

class bO implements Runnable {
    final /* synthetic */ bM a;

    bO(bM bMVar) {
        this.a = bMVar;
    }

    public void run() {
        this.a.b.dismiss();
    }
}
