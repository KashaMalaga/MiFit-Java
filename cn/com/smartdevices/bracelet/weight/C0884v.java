package cn.com.smartdevices.bracelet.weight;

import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.account.openauth.h;
import java.util.Date;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.e;

class C0884v implements e {
    final /* synthetic */ C0882t a;

    C0884v(C0882t c0882t) {
        this.a = c0882t;
    }

    public void a(WheelView wheelView) {
    }

    public void b(WheelView wheelView) {
        long a = this.a.a(this.a.m, this.a.k, this.a.l, this.a.n, this.a.o, 0);
        C0596r.e("SettingDateFragment", "time in str " + new Date(a).toLocaleString());
        if ((a == 0 || a > System.currentTimeMillis()) && wheelView.f() == 1) {
            this.a.g.b(-1, (int) h.E);
        }
    }
}
