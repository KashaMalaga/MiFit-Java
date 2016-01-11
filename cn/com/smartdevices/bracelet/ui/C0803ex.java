package cn.com.smartdevices.bracelet.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class C0803ex implements OnCheckedChangeListener {
    final /* synthetic */ SettingPhoneNotifyActivity a;

    C0803ex(SettingPhoneNotifyActivity settingPhoneNotifyActivity) {
        this.a = settingPhoneNotifyActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.a.c(z);
    }
}
