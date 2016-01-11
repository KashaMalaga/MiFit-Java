package cn.com.smartdevices.bracelet.ui;

import android.os.Handler;
import android.os.Message;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0409b;
import cn.com.smartdevices.bracelet.C0410c;
import cn.com.smartdevices.bracelet.Keeper;
import com.huami.android.view.b;
import com.xiaomi.hm.health.r;
import java.util.HashMap;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class aR extends Handler {
    final /* synthetic */ FwUpgradeActivity a;

    aR(FwUpgradeActivity fwUpgradeActivity) {
        this.a = fwUpgradeActivity;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case l.a /*1*/:
                if (this.a.m == 2) {
                    this.a.t.a(this.a.z);
                } else {
                    this.a.r.c(this.a.z);
                }
                this.a.e();
                return;
            case a.k /*2*/:
                this.a.b();
                return;
            case a.l /*3*/:
                if (this.a.m == 2) {
                    this.a.t.a(message.arg1);
                    return;
                } else {
                    this.a.r.c(message.arg1);
                    return;
                }
            case a.aQ /*4*/:
                if (message.arg1 != 0) {
                    b.a(this.a.j, this.a.getString(r.fw_upgrade_failed), 0).show();
                    HashMap hashMap = new HashMap();
                    hashMap.put(C0410c.c, (this.a.w - this.a.v) + com.xiaomi.e.a.f);
                    if (this.a.m == 1) {
                        hashMap.put(C0410c.q, Keeper.readWeightHwInfo().address);
                        C0401a.a(this.a.j, C0409b.az, hashMap);
                    } else {
                        hashMap.put(C0410c.q, Keeper.readBraceletBtInfo().b);
                        C0401a.a(this.a.j, C0409b.ai, hashMap);
                    }
                } else {
                    b.a(this.a.j, this.a.getString(r.fw_upgrade_succ), 0).show();
                    if (this.a.m == 1) {
                        C0401a.a(this.a.j, C0409b.az, (this.a.w - this.a.v) + com.xiaomi.e.a.f);
                    } else {
                        C0401a.a(this.a.j, C0409b.ah, (this.a.w - this.a.v) + com.xiaomi.e.a.f);
                    }
                }
                this.a.b();
                return;
            default:
                return;
        }
    }
}
