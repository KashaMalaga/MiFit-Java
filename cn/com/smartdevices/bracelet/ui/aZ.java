package cn.com.smartdevices.bracelet.ui;

import com.huami.android.view.b;
import com.xiaomi.hm.health.bt.a.d;
import com.xiaomi.hm.health.r;

class aZ extends d {
    final /* synthetic */ HealthGoalsActivity a;

    aZ(HealthGoalsActivity healthGoalsActivity) {
        this.a = healthGoalsActivity;
    }

    public void a() {
        super.a();
    }

    public void a(Object obj) {
        super.a(obj);
        if (!((Boolean) obj).booleanValue()) {
            b.a(this.a, this.a.getString(r.bt_operation_failed_tips), 0).show();
        }
    }

    public void b(Object obj) {
        super.b(obj);
        b.a(this.a, this.a.getString(r.bt_operation_failed_tips), 0).show();
    }
}
