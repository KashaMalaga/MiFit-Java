package cn.com.smartdevices.bracelet.shoes.ui;

import cn.com.smartdevices.bracelet.shoes.reflection.a;

class K implements a {
    final /* synthetic */ ShoesDetailActivity a;

    K(ShoesDetailActivity shoesDetailActivity) {
        this.a = shoesDetailActivity;
    }

    public void a(boolean z) {
        if (z && this.a.v != null) {
            this.a.z.setClickable(true);
            this.a.v.setVisibility(0);
        }
    }
}
