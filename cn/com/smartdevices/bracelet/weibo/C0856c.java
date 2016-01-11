package cn.com.smartdevices.bracelet.weibo;

import android.view.View;
import android.view.View.OnClickListener;

class C0856c implements OnClickListener {
    final /* synthetic */ BindHealthActivity a;

    C0856c(BindHealthActivity bindHealthActivity) {
        this.a = bindHealthActivity;
    }

    public void onClick(View view) {
        if (view.getTag() != null) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (intValue == 0 || intValue == -1) {
                this.a.c();
            } else if (intValue == 1) {
                this.a.b();
            }
        }
    }
}
