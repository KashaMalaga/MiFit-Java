package cn.com.smartdevices.bracelet.gps.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import cn.com.smartdevices.bracelet.gps.e.a;

class C0518bd implements OnCheckedChangeListener {
    final /* synthetic */ RunningSettingActivity a;

    C0518bd(RunningSettingActivity runningSettingActivity) {
        this.a = runningSettingActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.a.f.c(z);
        if (z) {
            a.j();
        }
        this.a.a(this.a.b, z);
        this.a.d();
    }
}
