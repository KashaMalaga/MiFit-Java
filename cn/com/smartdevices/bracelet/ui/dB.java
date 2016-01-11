package cn.com.smartdevices.bracelet.ui;

import android.content.Intent;
import com.xiaomi.hm.health.e;

class dB implements Runnable {
    final /* synthetic */ SelectDevicesActivity a;

    dB(SelectDevicesActivity selectDevicesActivity) {
        this.a = selectDevicesActivity;
    }

    public void run() {
        this.a.startActivityForResult(new Intent(this.a, SearchWeightScaleActivity.class), 1);
        this.a.overridePendingTransition(e.fw_in, e.fw_out);
        this.a.finish();
    }
}
