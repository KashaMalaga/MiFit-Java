package cn.com.smartdevices.bracelet.ui;

import com.xiaomi.hm.health.bt.model.e;

class C0777dz implements Runnable {
    final /* synthetic */ e a;
    final /* synthetic */ SearchWeightScaleActivity b;

    C0777dz(SearchWeightScaleActivity searchWeightScaleActivity, e eVar) {
        this.b = searchWeightScaleActivity;
        this.a = eVar;
    }

    public void run() {
        this.b.a(this.a);
    }
}
