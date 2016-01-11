package cn.com.smartdevices.bracelet.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class cE implements OnCheckedChangeListener {
    final /* synthetic */ NewAlarmActivity a;

    cE(NewAlarmActivity newAlarmActivity) {
        this.a = newAlarmActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.a.k.setDuration(30);
        } else {
            this.a.k.setDuration(0);
        }
    }
}
