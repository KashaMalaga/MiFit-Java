package cn.com.smartdevices.bracelet.ui;

class bN implements Runnable {
    final /* synthetic */ bM a;

    bN(bM bMVar) {
        this.a = bMVar;
    }

    public void run() {
        this.a.b.dismiss();
    }
}
