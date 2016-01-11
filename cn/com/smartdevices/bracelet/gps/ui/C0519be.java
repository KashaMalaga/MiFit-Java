package cn.com.smartdevices.bracelet.gps.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class C0519be implements OnCheckedChangeListener {
    final /* synthetic */ RunningSettingActivity a;

    C0519be(RunningSettingActivity runningSettingActivity) {
        this.a = runningSettingActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.a.f.a(z);
        this.a.d();
    }
}
