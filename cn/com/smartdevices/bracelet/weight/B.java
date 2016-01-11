package cn.com.smartdevices.bracelet.weight;

import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.account.openauth.h;
import java.util.Calendar;
import java.util.Date;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.e;

class B implements e {
    final /* synthetic */ C0882t a;

    B(C0882t c0882t) {
        this.a = c0882t;
    }

    public void a(WheelView wheelView) {
    }

    public void b(WheelView wheelView) {
        boolean z = false;
        int i = Calendar.getInstance().get(12);
        int f = wheelView.f();
        C0596r.e("SettingDateFragment", "nowMinute " + i + " curMinute " + f);
        long a = this.a.a(this.a.m, this.a.k, this.a.l, this.a.n, f, 0);
        String str = "SettingDateFragment";
        StringBuilder stringBuilder = new StringBuilder();
        if (a == 0 || a > System.currentTimeMillis()) {
            z = true;
        }
        C0596r.e(str, stringBuilder.append(z).append("   l ").append(a).append(" ").append(new Date(a).toLocaleString()).append(" System.cur ").append(System.currentTimeMillis()).append(" ").append(new Date(System.currentTimeMillis()).toLocaleString()).toString());
        if (a == 0 || a > System.currentTimeMillis()) {
            this.a.f.b(60 - (f - i), (int) h.E);
        }
    }
}
