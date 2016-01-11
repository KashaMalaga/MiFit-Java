package cn.com.smartdevices.bracelet.shoes.ui;

import cn.com.smartdevices.bracelet.shoes.reflection.FwUpgradeManager;
import cn.com.smartdevices.bracelet.shoes.reflection.a;
import com.huami.android.view.b;
import com.xiaomi.hm.health.c.m;

class H implements a {
    final /* synthetic */ ShoesDetailActivity a;

    H(ShoesDetailActivity shoesDetailActivity) {
        this.a = shoesDetailActivity;
    }

    public void a(boolean z) {
        if (z) {
            FwUpgradeManager.upgrade(this.a.x, 2, true);
        } else {
            b.a(this.a.x, m.shoes_fw_uptodate, 1).show();
        }
    }
}
