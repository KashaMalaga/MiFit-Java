package cn.com.smartdevices.bracelet.gps.services;

final class V implements Runnable {
    final /* synthetic */ R a;

    private V(R r) {
        this.a = r;
    }

    public void run() {
        this.a.j();
        if (!this.a.q) {
            this.a.i();
        }
    }
}
