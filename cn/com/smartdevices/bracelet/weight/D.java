package cn.com.smartdevices.bracelet.weight;

import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.c;

class D implements c {
    final /* synthetic */ C0882t a;

    D(C0882t c0882t) {
        this.a = c0882t;
    }

    public void a(WheelView wheelView, int i, int i2) {
        this.a.p = i2;
        if (i == 0 && this.a.p == 1) {
            C0882t.d(this.a, 12);
        } else if (i == 1 && i2 == 0) {
            C0882t.g(this.a, 12);
        }
        this.a.a();
    }
}
