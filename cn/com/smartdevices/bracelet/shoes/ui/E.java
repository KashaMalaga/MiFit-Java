package cn.com.smartdevices.bracelet.shoes.ui;

import com.xiaomi.hm.health.bt.a.d;

class E extends d {
    final /* synthetic */ ShoesCalibrateActivity a;

    E(ShoesCalibrateActivity shoesCalibrateActivity) {
        this.a = shoesCalibrateActivity;
    }

    public void a() {
        super.a();
        this.a.k();
    }

    public void a(Object obj) {
        super.a(obj);
        this.a.c = false;
        if (obj == null || !((Boolean) obj).booleanValue()) {
            this.a.j();
        } else {
            this.a.h();
        }
    }
}
