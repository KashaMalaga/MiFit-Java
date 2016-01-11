package cn.com.smartdevices.bracelet.ui;

class M implements Runnable {
    final /* synthetic */ BindWeixinActivity a;

    M(BindWeixinActivity bindWeixinActivity) {
        this.a = bindWeixinActivity;
    }

    public void run() {
        if (this.a.b(this.a.n)) {
            this.a.d();
        } else {
            this.a.c();
        }
    }
}
