package cn.com.smartdevices.bracelet.shoes.ui;

import android.view.View;
import android.view.View.OnClickListener;

class B implements OnClickListener {
    final /* synthetic */ ShoesBindTestActivity a;

    B(ShoesBindTestActivity shoesBindTestActivity) {
        this.a = shoesBindTestActivity;
    }

    public void onClick(View view) {
        if (view.getTag().equals("start")) {
            this.a.k();
            view.setTag("stop");
            this.a.p.setText("\u7ed3\u675f\u5b9e\u65f6\u6570\u636e\u4f20\u8f93");
            return;
        }
        this.a.l();
        view.setTag("start");
        this.a.p.setText("\u5f00\u59cb\u5b9e\u65f6\u6570\u636e\u4f20\u8f93");
    }
}
