package cn.com.smartdevices.bracelet.relation;

class K implements Runnable {
    final /* synthetic */ J a;

    K(J j) {
        this.a = j;
    }

    public void run() {
        this.a.g = this.a.c();
        this.a.a();
    }
}
