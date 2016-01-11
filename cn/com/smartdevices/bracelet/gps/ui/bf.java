package cn.com.smartdevices.bracelet.gps.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class bf implements OnCheckedChangeListener {
    final /* synthetic */ RunningSettingActivity a;

    bf(RunningSettingActivity runningSettingActivity) {
        this.a = runningSettingActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.a.f.d(z);
        this.a.a(z);
        this.a.d();
    }
}
