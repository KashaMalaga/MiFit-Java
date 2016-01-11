package cn.com.smartdevices.bracelet.weight;

import android.view.View;
import android.view.View.OnClickListener;
import cn.com.smartdevices.bracelet.C0596r;

class R implements OnClickListener {
    final /* synthetic */ Q a;

    R(Q q) {
        this.a = q;
    }

    public void onClick(View view) {
        C0596r.e("UserListActivity", "onEmptyClick");
        this.a.b();
    }
}
