package cn.com.smartdevices.bracelet.ui;

import android.os.Handler;
import android.os.Message;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.datasource.DeviceSource;
import cn.com.smartdevices.bracelet.weight.WeightGoalSetActivity;
import cn.com.smartdevices.bracelet.weight.family.h;
import com.xiaomi.hm.health.bt.b.c;
import com.xiaomi.hm.health.bt.bleservice.a;
import com.xiaomi.hm.health.bt.model.HwConnStatus;
import com.xiaomi.hm.health.bt.model.HwSyncDataStatus;

class C0742cr extends Handler {
    final /* synthetic */ MainUIActivity a;

    C0742cr(MainUIActivity mainUIActivity) {
        this.a = mainUIActivity;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case WeightGoalSetActivity.c /*272*/:
                C0596r.e("MainUIActivity", "receive the msg reconnect timeout");
                this.a.e(0);
                this.a.d(true);
                this.a.au = true;
                return;
            case h.d /*273*/:
                HwConnStatus k;
                if (DeviceSource.hasBindBracelet()) {
                    k = a.k();
                    HwSyncDataStatus l = this.a.s;
                    if (k.b().c() && l.e()) {
                        this.a.onEvent(l);
                        return;
                    } else if (l.h().c() && !k.d()) {
                        this.a.onEvent(k);
                        return;
                    } else {
                        return;
                    }
                } else if (DeviceSource.hasBindShoesDevice()) {
                    HwSyncDataStatus l2 = this.a.s;
                    if (c.SHOES.equals(l2.h()) && l2.e()) {
                        this.a.onEvent(l2);
                        return;
                    }
                    k = this.a.z;
                    if (c.SHOES.equals(k.b()) && !k.d()) {
                        this.a.onEvent(k);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            case 274:
                this.a.I();
                return;
            case MainUIActivity.c /*520*/:
                this.a.D = -1;
                return;
            default:
                return;
        }
    }
}
