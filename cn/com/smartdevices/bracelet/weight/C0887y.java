package cn.com.smartdevices.bracelet.weight;

import com.xiaomi.account.openauth.h;
import java.util.Calendar;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.e;

class C0887y implements e {
    final /* synthetic */ C0882t a;

    C0887y(C0882t c0882t) {
        this.a = c0882t;
    }

    public void a(WheelView wheelView) {
    }

    public void b(WheelView wheelView) {
        int i = Calendar.getInstance().get(2) + 1;
        int i2 = Calendar.getInstance().get(5);
        int f = wheelView.f() + 1;
        long a = this.a.a(this.a.m, f, this.a.l, this.a.n, this.a.o, 0);
        if (a == 0 || a > System.currentTimeMillis()) {
            this.a.c.b(12 - (f - i), (int) h.E);
            if (this.a.l > i2) {
                this.a.d.b(this.a.a(this.a.m, i) - (this.a.l - i2), (int) h.E);
            }
        }
    }
}
