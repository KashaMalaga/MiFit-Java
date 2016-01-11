package cn.com.smartdevices.bracelet.weight;

import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.account.openauth.h;
import java.util.Calendar;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.e;

class A implements e {
    final /* synthetic */ C0882t a;

    A(C0882t c0882t) {
        this.a = c0882t;
    }

    public void a(WheelView wheelView) {
    }

    public void b(WheelView wheelView) {
        int i = Calendar.getInstance().get(11);
        int f = wheelView.f();
        C0596r.e("SettingDateFragment", "nowHour " + i + " curHour " + f);
        long a = this.a.a(this.a.m, this.a.k, this.a.l, this.a.p == 1 ? f + 12 : f, this.a.o, 0);
        if (a != 0 && a <= System.currentTimeMillis()) {
            return;
        }
        if (this.a.r) {
            this.a.e.b(24 - (f - i), (int) h.E);
        } else {
            this.a.e.b(12 - (f - i), (int) h.E);
        }
    }
}
