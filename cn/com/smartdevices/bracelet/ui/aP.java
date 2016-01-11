package cn.com.smartdevices.bracelet.ui;

import android.view.View;
import android.view.View.OnClickListener;

class aP implements OnClickListener {
    final /* synthetic */ FwLowBatteryActivity a;

    aP(FwLowBatteryActivity fwLowBatteryActivity) {
        this.a = fwLowBatteryActivity;
    }

    public void onClick(View view) {
        this.a.finish();
    }
}
