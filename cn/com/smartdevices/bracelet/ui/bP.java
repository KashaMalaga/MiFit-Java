package cn.com.smartdevices.bracelet.ui;

class bP implements Runnable {
    final /* synthetic */ bM a;

    bP(bM bMVar) {
        this.a = bMVar;
    }

    public void run() {
        this.a.b.dismiss();
    }
}
