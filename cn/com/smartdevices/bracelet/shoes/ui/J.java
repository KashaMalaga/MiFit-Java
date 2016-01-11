package cn.com.smartdevices.bracelet.shoes.ui;

import com.xiaomi.hm.health.bt.a.d;

class J extends d {
    final /* synthetic */ boolean a;
    final /* synthetic */ ShoesDetailActivity b;

    J(ShoesDetailActivity shoesDetailActivity, boolean z) {
        this.b = shoesDetailActivity;
        this.a = z;
    }

    public void a(Object obj) {
        super.a(obj);
        int intValue = ((Integer) obj).intValue();
        this.b.a(this.b.getApplicationContext(), intValue);
        this.b.a(intValue, this.a);
    }
}
