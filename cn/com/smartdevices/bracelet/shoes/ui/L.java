package cn.com.smartdevices.bracelet.shoes.ui;

import cn.com.smartdevices.bracelet.shoes.sync.b.f;

final class L implements f {
    final /* synthetic */ ShoesDetailActivity a;

    private L(ShoesDetailActivity shoesDetailActivity) {
        this.a = shoesDetailActivity;
    }

    public void a(int i) {
        if (this.a.H != null) {
            this.a.H.sendEmptyMessage(i);
        }
    }
}
