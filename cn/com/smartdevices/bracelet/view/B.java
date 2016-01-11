package cn.com.smartdevices.bracelet.view;

class B implements Runnable {
    final /* synthetic */ A a;

    B(A a) {
        this.a = a;
    }

    public void run() {
        this.a.a.d();
    }
}
