package cn.com.smartdevices.bracelet.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class C0802ew implements OnCheckedChangeListener {
    final /* synthetic */ SettingPhoneNotifyActivity a;

    C0802ew(SettingPhoneNotifyActivity settingPhoneNotifyActivity) {
        this.a = settingPhoneNotifyActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.a.a(z);
    }
}
