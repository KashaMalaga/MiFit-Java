package cn.com.smartdevices.bracelet.shoes.ui;

import android.app.ProgressDialog;

class C0651h implements Runnable {
    final /* synthetic */ ShoesBindTestActivity a;

    C0651h(ShoesBindTestActivity shoesBindTestActivity) {
        this.a = shoesBindTestActivity;
    }

    public void run() {
        this.a.w = ProgressDialog.show(this.a.r, "\u56fa\u4ef6\u5347\u7ea7", "\u9a6c\u4e0a\u8fdb\u884c\u56fa\u4ef6\u5347\u7ea7\uff01");
    }
}
