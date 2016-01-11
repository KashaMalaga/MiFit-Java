package cn.com.smartdevices.bracelet.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.support.v4.app.aj;
import android.support.v7.widget.af;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.eventbus.EventWeightLowBattery;
import com.xiaomi.hm.health.bt.bleservice.BLEService;
import com.xiaomi.hm.health.bt.model.HwBatteryStatus;
import com.xiaomi.hm.health.bt.model.HwSyncDataStatus;
import com.xiaomi.hm.health.bt.model.o;
import de.greenrobot.event.EventBus;
import kankan.wheel.widget.a;

class C0820u extends BroadcastReceiver {
    final /* synthetic */ BaseSCActivity a;

    C0820u(BaseSCActivity baseSCActivity) {
        this.a = baseSCActivity;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        C0596r.e("BaseSCActivity", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            this.a.w();
        } else if (action.equals(BLEService.b)) {
            Message message = new Message();
            message.what = 4116;
            message.obj = intent.getParcelableExtra(BLEService.j);
            C0596r.d("BaseSCActivity", "INTENT_ACTION_CONN_STATUS_CHANGED......!!!" + message.obj);
            this.a.u.sendMessage(message);
        } else if (action.equals(BLEService.e)) {
            HwSyncDataStatus hwSyncDataStatus = (HwSyncDataStatus) intent.getParcelableExtra(BLEService.j);
            if (hwSyncDataStatus.d()) {
                if (hwSyncDataStatus.g()) {
                    if (hwSyncDataStatus.h().d()) {
                        this.a.u.sendEmptyMessage(4100);
                    } else {
                        this.a.u.sendEmptyMessage(aj.K);
                    }
                    C0401a.a(this.a.x, C0401a.ek, C0401a.dA);
                } else {
                    C0401a.a(this.a.x, C0401a.ek, C0401a.dB);
                }
                this.a.y();
            }
            EventBus.getDefault().postSticky(hwSyncDataStatus);
            return;
        }
        if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
            switch (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", af.a)) {
                case a.bd /*10*/:
                    this.a.u.sendEmptyMessage(4102);
                    return;
                case a.be /*12*/:
                    this.a.u.sendEmptyMessage(4101);
                    return;
                default:
                    return;
            }
        }
        if (BLEService.f.equals(action)) {
            this.a.u.sendEmptyMessage(4103);
        } else if (action.equals(BLEService.h)) {
            HwBatteryStatus hwBatteryStatus = (HwBatteryStatus) intent.getParcelableExtra(BLEService.j);
            if (hwBatteryStatus.e == 1) {
                this.a.c(hwBatteryStatus.f);
            } else if (hwBatteryStatus.e == 2) {
                this.a.u();
            } else if (hwBatteryStatus.e == 3) {
                this.a.t();
            }
            EventBus.getDefault().post(hwBatteryStatus);
            return;
        }
        int intExtra;
        if (BLEService.c.equals(action)) {
            intExtra = intent.getIntExtra(BLEService.j, -1);
            message = new Message();
            message.what = 4104;
            message.arg1 = intExtra;
            this.a.u.sendMessage(message);
            EventBus.getDefault().post(new o(intExtra));
        } else if (action.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
            action = intent.getStringExtra("reason");
            if (!TextUtils.isEmpty(action)) {
                C0596r.d("BaseSCActivity", "ACTION_CLOSE_SYSTEM_DIALOGS:" + action);
                if (action.equals("lock") || action.equals("homekey")) {
                    this.a.u.sendEmptyMessage(4115);
                }
            }
        } else if (action.equals(BLEService.g)) {
            intExtra = intent.getIntExtra(BLEService.j, -1);
            if (!Keeper.readPersonInfo().miliConfig.vibrate || !this.a.d(intExtra)) {
            }
        } else if (action.equals(BLEService.d)) {
            EventBus.getDefault().post(new EventWeightLowBattery());
        } else if (action.equals("android.intent.action.SCREEN_OFF")) {
            Keeper.setEnterAppTrace(3);
            Keeper.setActiveHistory(3);
        }
    }
}
