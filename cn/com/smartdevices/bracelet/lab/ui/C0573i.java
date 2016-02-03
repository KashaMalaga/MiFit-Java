package cn.com.smartdevices.bracelet.lab.ui;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.huami.android.view.b;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.bt.a.d;

class C0573i extends d {
    final /* synthetic */ boolean a;
    final /* synthetic */ LabFactoryReminderActivity b;

    C0573i(LabFactoryReminderActivity labFactoryReminderActivity, boolean z) {
        this.b = labFactoryReminderActivity;
        this.a = z;
    }

    public void a(Object obj) {
        int i = 0;
        super.a(obj);
        if (obj == null || !((Boolean) obj).booleanValue()) {
            C0596r.d("LabFactoryReminderActivity", "enableReminder(" + this.a + ")" + " failed!!!");
            b.a(this.b, (int) R.string.bt_operation_failed_tips, 0).show();
            return;
        }
        PersonInfo a = this.b.b;
        if (this.a) {
            i = 1;
        }
        a.setMiliDisconnectedReminder(i);
        this.b.b.setNeedSyncServer(2);
        Utils.a(this.b, this.b.b);
    }

    public void b(Object obj) {
        super.b(obj);
        C0596r.d("LabFactoryReminderActivity", "enableReminder(" + this.a + ")" + " failed!!!");
        b.a(this.b, (int) R.string.bt_operation_failed_tips, 0).show();
    }
}
