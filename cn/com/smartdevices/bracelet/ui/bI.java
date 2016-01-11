package cn.com.smartdevices.bracelet.ui;

class bI implements Runnable {
    final /* synthetic */ bH a;

    bI(bH bHVar) {
        this.a = bHVar;
    }

    public void run() {
        this.a.h = this.a.c();
        this.a.a();
    }
}
