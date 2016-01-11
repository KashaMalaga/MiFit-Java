package cn.com.smartdevices.bracelet.shoes.ui;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.reflection.FwUpgradeManager;
import cn.com.smartdevices.bracelet.shoes.reflection.a;
import com.huami.android.view.b;
import com.xiaomi.hm.health.c.m;

class C0645b implements a {
    final /* synthetic */ ShoesBindActivity a;

    C0645b(ShoesBindActivity shoesBindActivity) {
        this.a = shoesBindActivity;
    }

    public void a(boolean z) {
        C0596r.e("ShoesBindActivity", "checkFwUpgrade state = " + z);
        if (z) {
            this.a.i = true;
            if (this.a.s != null) {
                this.a.s.setText(m.shoes_check_upgrade_waiting);
            }
            FwUpgradeManager.setUpgradeState(this.a.o, true);
            this.a.h = FwUpgradeManager.isOldShoesVersion(this.a.o);
            C0596r.e("ShoesBindActivity", "Found a new upgrade OldShoesVersion " + this.a.h);
            if (this.a.h) {
                FwUpgradeManager.upgrade(this.a.o, 2, true);
                return;
            } else {
                this.a.a(this.a.o, this.a.p, this.a.j);
                return;
            }
        }
        FwUpgradeManager.setUpgradeState(this.a.o, false);
        this.a.a(this.a.o, this.a.p, this.a.j);
        b.a(this.a.o, this.a.getResources().getString(m.shoes_bind_success), 1).show();
        this.a.h();
    }
}
