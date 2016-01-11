package cn.com.smartdevices.bracelet.shoes.ui;

import android.widget.Toast;

class C0665v implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ ShoesBindTestActivity b;

    C0665v(ShoesBindTestActivity shoesBindTestActivity, int i) {
        this.b = shoesBindTestActivity;
        this.a = i;
    }

    public void run() {
        if (this.b.w != null) {
            this.b.w.dismiss();
            this.b.w = null;
        }
        CharSequence charSequence = "\u56fa\u4ef6\u5347\u7ea7\u5931\u8d25";
        if (this.a == 0) {
            charSequence = "\u56fa\u4ef6\u5347\u7ea7\u6210\u529f";
            if (this.b.v != null) {
                this.b.v.a(false);
                this.b.v.b();
                this.b.v = null;
            }
        }
        Toast.makeText(this.b.r, charSequence, 0).show();
    }
}
