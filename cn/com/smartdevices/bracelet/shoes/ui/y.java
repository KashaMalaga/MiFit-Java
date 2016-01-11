package cn.com.smartdevices.bracelet.shoes.ui;

import android.view.View;
import android.view.View.OnClickListener;

class y implements OnClickListener {
    final /* synthetic */ ShoesBindTestActivity a;

    y(ShoesBindTestActivity shoesBindTestActivity) {
        this.a = shoesBindTestActivity;
    }

    public void onClick(View view) {
        this.a.m.setEnabled(false);
        this.a.b();
    }
}
