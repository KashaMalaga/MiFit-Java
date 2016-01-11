package cn.com.smartdevices.bracelet.weibo;

import android.view.View;
import android.view.View.OnClickListener;

class C0857d implements OnClickListener {
    final /* synthetic */ BindHealthActivity a;

    C0857d(BindHealthActivity bindHealthActivity) {
        this.a = bindHealthActivity;
    }

    public void onClick(View view) {
        if (BindHealthActivity.a == 2) {
            this.a.j.c(this.a);
        }
        this.a.finish();
    }
}
