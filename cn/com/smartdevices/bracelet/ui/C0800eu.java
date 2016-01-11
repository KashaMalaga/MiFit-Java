package cn.com.smartdevices.bracelet.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class C0800eu implements OnCheckedChangeListener {
    final /* synthetic */ SettingMiuiSupportIncallActivity a;

    C0800eu(SettingMiuiSupportIncallActivity settingMiuiSupportIncallActivity) {
        this.a = settingMiuiSupportIncallActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.a.b(z);
    }
}
