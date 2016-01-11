package cn.com.smartdevices.bracelet.weight;

import com.xiaomi.account.openauth.h;
import java.util.Calendar;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.e;

class C0888z implements e {
    final /* synthetic */ C0882t a;

    C0888z(C0882t c0882t) {
        this.a = c0882t;
    }

    public void a(WheelView wheelView) {
    }

    public void b(WheelView wheelView) {
        int i = Calendar.getInstance().get(5);
        int f = wheelView.f() + 1;
        long a = this.a.a(this.a.m, this.a.k, f, this.a.n, this.a.o, 0);
        if (a == 0 || a > System.currentTimeMillis()) {
            this.a.d.b(this.a.a(this.a.m, this.a.k) - (f - i), (int) h.E);
        }
    }
}
