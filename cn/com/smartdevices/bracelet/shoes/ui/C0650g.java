package cn.com.smartdevices.bracelet.shoes.ui;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.sync.b.d;
import cn.com.smartdevices.bracelet.shoes.sync.b.f;

final class C0650g implements f {
    final /* synthetic */ ShoesBindActivity a;

    private C0650g(ShoesBindActivity shoesBindActivity) {
        this.a = shoesBindActivity;
    }

    public void a(int i) {
        C0596r.e("SUI", "onDeviceConnStateChanged state = " + i);
        if (d.a(i) || 5 == i) {
            this.a.m.sendEmptyMessage(i);
        }
    }
}
