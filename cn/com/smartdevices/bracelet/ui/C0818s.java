package cn.com.smartdevices.bracelet.ui;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.aj;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.C0891z;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.datasource.DeviceSource;
import cn.com.smartdevices.bracelet.eventbus.EventBtOnOff;
import cn.com.smartdevices.bracelet.eventbus.EventLoadDataComplete;
import com.xiaomi.hm.health.bt.a.j;
import com.xiaomi.hm.health.bt.bleservice.a;
import com.xiaomi.hm.health.bt.model.HwConnStatus;
import com.xiaomi.hm.health.bt.model.h;
import com.xiaomi.hm.health.bt.profile.a.d;
import com.xiaomi.hm.health.bt.profile.a.i;
import de.greenrobot.event.EventBus;
import java.util.Date;

class C0818s extends Handler {
    final /* synthetic */ BaseSCActivity a;

    C0818s(BaseSCActivity baseSCActivity) {
        this.a = baseSCActivity;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 4098:
                C0596r.e("BaseSCActivity", "MSG_LOAD_DATA_COMPLETE......................" + new Date().toString());
                EventBus.getDefault().post(new EventLoadDataComplete());
                return;
            case aj.K /*4099*/:
                if (this.a.b.checkMiliFwUpgrade()) {
                    new j(new C0819t(this)).f();
                    return;
                }
                h f = a.f();
                if (f != null && f.a()) {
                    i q = Utils.q();
                    if (q != null) {
                        new d().a(q.h, null);
                        return;
                    }
                    return;
                }
                return;
            case 4100:
                C0596r.e("BaseSCActivity", "shoes sync data complete");
                if (this.a.b.checkShoesFwUpgrade()) {
                    this.a.b.upgrade(2);
                    return;
                }
                return;
            case 4101:
                this.a.m();
                if (DeviceSource.hasBindWeight() && this.a.L) {
                    C0891z.a(this.a.x).b();
                    this.a.b(false);
                }
                if (DeviceSource.hasBindBracelet() || DeviceSource.hasBindShoesDevice()) {
                    EventBus.getDefault().post(new EventBtOnOff(0));
                    return;
                }
                return;
            case 4102:
                this.a.n();
                if (DeviceSource.hasBindBracelet() || DeviceSource.hasBindShoesDevice()) {
                    EventBus.getDefault().post(new EventBtOnOff(1));
                }
                if (DeviceSource.hasBindWeight()) {
                    C0891z.a(this.a.x).a();
                    this.a.b(false);
                    return;
                }
                return;
            case 4103:
                this.a.b(false);
                return;
            case 4104:
                this.a.f(message.arg1);
                return;
            case 4105:
                if (this.a.b.checkWeightFwUpgrade()) {
                    this.a.b.upgrade(1);
                    return;
                } else {
                    this.a.z();
                    return;
                }
            case 4112:
                C0596r.d("BaseSCActivity", "addWeightConnectFailedDynamic");
                C0891z.a(this.a.x).a();
                this.a.b(false);
                return;
            case 4113:
                this.a.f();
                return;
            case 4114:
                this.a.g();
                return;
            case 4115:
                this.a.b();
                return;
            case 4116:
                this.a.a((HwConnStatus) message.obj);
                return;
            default:
                return;
        }
    }
}
