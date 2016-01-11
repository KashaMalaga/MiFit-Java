package cn.com.smartdevices.bracelet.shoes.ui;

import cn.com.smartdevices.bracelet.C0596r;

class C0646c implements Runnable {
    final /* synthetic */ ShoesBindActivity a;

    C0646c(ShoesBindActivity shoesBindActivity) {
        this.a = shoesBindActivity;
    }

    public void run() {
        this.a.d();
        C0596r.e("ShoesBindActivity", "EventFwUpgradeComplete failed");
    }
}
