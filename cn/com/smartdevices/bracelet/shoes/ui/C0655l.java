package cn.com.smartdevices.bracelet.shoes.ui;

import android.view.View;
import android.view.View.OnClickListener;

class C0655l implements OnClickListener {
    final /* synthetic */ ShoesBindTestActivity a;

    C0655l(ShoesBindTestActivity shoesBindTestActivity) {
        this.a = shoesBindTestActivity;
    }

    public void onClick(View view) {
        if (this.a.i == null) {
            return;
        }
        if (this.a.s.getTag().equals("start_calibrate")) {
            this.a.s.setTag("stop_calibrate");
            this.a.s.setText("\u7ed3\u675f\u9759\u6001\u6807\u5b9a");
            this.a.i.b(new C0656m(this));
            return;
        }
        this.a.s.setText("\u5f00\u59cb\u9759\u6001\u6807\u5b9a");
        this.a.s.setTag("start_calibrate");
        this.a.i.c();
    }
}
