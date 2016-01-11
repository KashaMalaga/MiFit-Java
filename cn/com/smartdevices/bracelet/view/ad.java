package cn.com.smartdevices.bracelet.view;

import android.view.View;
import android.view.View.OnClickListener;
import cn.com.smartdevices.bracelet.weight.UserInfo;

class ad implements OnClickListener {
    final /* synthetic */ UserInfo a;
    final /* synthetic */ int b;
    final /* synthetic */ ac c;

    ad(ac acVar, UserInfo userInfo, int i) {
        this.c = acVar;
        this.a = userInfo;
        this.b = i;
    }

    public void onClick(View view) {
        if (this.c.a.f != null) {
            this.c.a.f.a(view, this.a, this.b);
        }
    }
}
