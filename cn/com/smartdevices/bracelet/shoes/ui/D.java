package cn.com.smartdevices.bracelet.shoes.ui;

import cn.com.smartdevices.bracelet.shoes.calibrate.c;
import com.xiaomi.hm.health.bt.d.f;

class D implements f {
    final /* synthetic */ ShoesCalibrateActivity a;

    D(ShoesCalibrateActivity shoesCalibrateActivity) {
        this.a = shoesCalibrateActivity;
    }

    public void a(int i) {
        this.a.K.obtainMessage(11, Integer.valueOf(i)).sendToTarget();
    }

    public void a(short s, short s2, short s3) {
        this.a.K.obtainMessage(12, new c(s, s2, s3)).sendToTarget();
    }
}
