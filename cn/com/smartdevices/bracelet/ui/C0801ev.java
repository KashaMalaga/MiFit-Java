package cn.com.smartdevices.bracelet.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class C0801ev implements OnCheckedChangeListener {
    final /* synthetic */ SettingMiuiSupportIncallActivity a;

    C0801ev(SettingMiuiSupportIncallActivity settingMiuiSupportIncallActivity) {
        this.a = settingMiuiSupportIncallActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.a.c(z);
    }
}
