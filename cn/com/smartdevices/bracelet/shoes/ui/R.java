package cn.com.smartdevices.bracelet.shoes.ui;

import cn.com.smartdevices.bracelet.shoes.reflection.FwUpgradeManager;
import cn.com.smartdevices.bracelet.shoes.reflection.a;
import com.huami.android.view.b;
import com.xiaomi.hm.health.c.m;

class R implements a {
    final /* synthetic */ ShoesListActivity a;

    R(ShoesListActivity shoesListActivity) {
        this.a = shoesListActivity;
    }

    public void a(boolean z) {
        if (z) {
            FwUpgradeManager.upgrade(this.a.b, 2, true);
        } else {
            b.a(this.a.b, m.shoes_fw_uptodate, 1).show();
        }
        FwUpgradeManager.forceUpdateShoes(Boolean.valueOf(false));
    }
}
