package cn.com.smartdevices.bracelet.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.hm.health.bt.bleservice.BLEService;

class C0774dw extends BroadcastReceiver {
    final /* synthetic */ SearchWeightScaleActivity a;

    C0774dw(SearchWeightScaleActivity searchWeightScaleActivity) {
        this.a = searchWeightScaleActivity;
    }

    public void onReceive(Context context, Intent intent) {
        this.a.a(intent.getIntExtra(BLEService.j, -1));
    }
}
