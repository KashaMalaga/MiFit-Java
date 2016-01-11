package cn.com.smartdevices.bracelet.weight;

import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.c;

class C0885w implements c {
    final /* synthetic */ C0882t a;

    C0885w(C0882t c0882t) {
        this.a = c0882t;
    }

    public void a(WheelView wheelView, int i, int i2) {
        int a = this.a.a(this.a.m, this.a.k);
        int i3 = (i % a) + 1;
        this.a.l = (i2 % a) + 1;
        this.a.a();
    }
}
