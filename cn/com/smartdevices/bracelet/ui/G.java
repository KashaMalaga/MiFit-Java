package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.C0401a;

class G implements Runnable {
    final /* synthetic */ BindQQHealthActivity a;

    G(BindQQHealthActivity bindQQHealthActivity) {
        this.a = bindQQHealthActivity;
    }

    public void run() {
        this.a.a.logout();
        this.a.a(this.a.f, this.a.g);
        this.a.a.login(this.a);
        C0401a.a(this.a, C0401a.eT, "FromQQ");
    }
}
