package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.C0891z;
import cn.com.smartdevices.bracelet.model.ThirdTokenState;

class C0733ci implements Runnable {
    final /* synthetic */ ThirdTokenState a;
    final /* synthetic */ MainUIActivity b;

    C0733ci(MainUIActivity mainUIActivity, ThirdTokenState thirdTokenState) {
        this.b = mainUIActivity;
        this.a = thirdTokenState;
    }

    public void run() {
        C0596r.e("MainUIActivity", "ThirdTokenState:" + this.a);
        if (this.a.accountType == 1) {
            C0891z.a(this.b).a(this.a.isExpired);
            this.b.d(false);
        }
    }
}
