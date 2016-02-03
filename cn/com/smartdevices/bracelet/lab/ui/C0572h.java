package cn.com.smartdevices.bracelet.lab.ui;

import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import com.huami.android.view.b;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.bt.a.d;

class C0572h extends d {
    final /* synthetic */ boolean a;
    final /* synthetic */ C0571g b;

    C0572h(C0571g c0571g, boolean z) {
        this.b = c0571g;
        this.a = z;
    }

    public void a(Object obj) {
        super.a(obj);
        if (obj == null || !((Boolean) obj).booleanValue()) {
            b.a(this.b.a, (int) R.string.bt_operation_failed_tips, 0).show();
            return;
        }
        this.b.a.d.enableConnectedBtAdv(this.a);
        this.b.a.d.setNeedSyncServer(2);
        Keeper.keepPersonInfo(this.b.a.d);
        Utils.a(this.b.a, this.b.a.d);
    }

    public void b(Object obj) {
        super.b(obj);
        b.a(this.b.a, (int) R.string.bt_operation_failed_tips, 0).show();
    }
}
