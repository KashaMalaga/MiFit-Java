package cn.com.smartdevices.bracelet.shoes.ui;

import cn.com.smartdevices.bracelet.shoes.sync.b.f;

final class F implements f {
    final /* synthetic */ ShoesCalibrateActivity a;

    private F(ShoesCalibrateActivity shoesCalibrateActivity) {
        this.a = shoesCalibrateActivity;
    }

    public void a(int i) {
        if (3 == i || 5 == i || 7 == i || 6 == i) {
            this.a.K.sendEmptyMessage(i);
        }
    }
}
