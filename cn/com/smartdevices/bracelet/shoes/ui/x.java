package cn.com.smartdevices.bracelet.shoes.ui;

import android.view.View;
import android.view.View.OnClickListener;

class x implements OnClickListener {
    final /* synthetic */ ShoesBindTestActivity a;

    x(ShoesBindTestActivity shoesBindTestActivity) {
        this.a = shoesBindTestActivity;
    }

    public void onClick(View view) {
        this.a.startActivityForResult(this.a.f(), 1);
    }
}
