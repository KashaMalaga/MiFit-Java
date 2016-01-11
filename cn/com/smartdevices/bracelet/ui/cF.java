package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.C0596r;
import com.huami.android.view.b;
import com.xiaomi.hm.health.bt.a.d;
import com.xiaomi.hm.health.r;

class cF extends d {
    final /* synthetic */ NewAlarmActivity a;

    cF(NewAlarmActivity newAlarmActivity) {
        this.a = newAlarmActivity;
    }

    public void a(Object obj) {
        super.a(obj);
        C0596r.e("NewAlarmActivity", "set alarm to mili OK");
    }

    public void b(Object obj) {
        super.b(obj);
        b.a(this.a.o, this.a.o.getString(r.bt_operation_failed_tips), 0).show();
    }
}
