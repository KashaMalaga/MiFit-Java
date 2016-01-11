package cn.com.smartdevices.bracelet.shoes.ui;

import android.view.View;
import android.view.View.OnClickListener;

class Q implements OnClickListener {
    final /* synthetic */ ShoesListActivity a;

    Q(ShoesListActivity shoesListActivity) {
        this.a = shoesListActivity;
    }

    public void onClick(View view) {
        this.a.d();
    }
}
