package cn.com.smartdevices.bracelet.shoes.ui;

import android.view.View;
import android.view.View.OnLongClickListener;

class I implements OnLongClickListener {
    final /* synthetic */ ShoesDetailActivity a;

    I(ShoesDetailActivity shoesDetailActivity) {
        this.a = shoesDetailActivity;
    }

    public boolean onLongClick(View view) {
        this.a.b(true);
        return true;
    }
}
