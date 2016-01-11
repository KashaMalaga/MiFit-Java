package cn.com.smartdevices.bracelet.lab.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import cn.com.smartdevices.bracelet.C0596r;

class C0576l implements OnCheckedChangeListener {
    final /* synthetic */ LabFactoryReminderActivity a;

    C0576l(LabFactoryReminderActivity labFactoryReminderActivity) {
        this.a = labFactoryReminderActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        C0596r.e("LabFactoryReminderActivity", "enableReminder");
        this.a.a(z);
    }
}
