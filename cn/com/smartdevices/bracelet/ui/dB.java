package cn.com.smartdevices.bracelet.ui;

import android.content.Intent;
import com.xiaomi.hm.health.R;

class dB implements Runnable {
    final /* synthetic */ SelectDevicesActivity a;

    dB(SelectDevicesActivity selectDevicesActivity) {
        this.a = selectDevicesActivity;
    }

    public void run() {
        this.a.startActivityForResult(new Intent(this.a, SearchWeightScaleActivity.class), 1);
        this.a.overridePendingTransition(R.anim.fw_in, R.anim.fw_out);
        this.a.finish();
    }
}
