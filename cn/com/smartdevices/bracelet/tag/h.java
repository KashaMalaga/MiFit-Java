package cn.com.smartdevices.bracelet.tag;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.hm.health.bt.bleservice.BLEService;
import com.xiaomi.hm.health.bt.model.HwConnStatus;

class h extends BroadcastReceiver {
    final /* synthetic */ TagDataActivity a;

    h(TagDataActivity tagDataActivity) {
        this.a = tagDataActivity;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(BLEService.b)) {
            this.a.l.a((HwConnStatus) intent.getParcelableExtra(BLEService.j));
        }
    }
}
