package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.C0596r;
import com.huami.android.view.b;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.bt.a.d;

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
        b.a(this.a.o, this.a.o.getString(R.string.bt_operation_failed_tips), 0).show();
    }
}
