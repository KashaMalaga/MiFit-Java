package cn.com.smartdevices.bracelet.ui;

import android.view.View;
import android.view.View.OnClickListener;
import cn.com.smartdevices.bracelet.C0401a;
import com.huami.android.view.b;
import com.xiaomi.hm.health.R;

class E implements OnClickListener {
    final /* synthetic */ BindQQHealthActivity a;

    E(BindQQHealthActivity bindQQHealthActivity) {
        this.a = bindQQHealthActivity;
    }

    public void onClick(View view) {
        if (this.a.a.isLoginValid()) {
            this.a.a.logout();
            this.a.a.clean(true);
            this.a.b.clean(true);
            this.a.a(this.a.f, this.a.g);
            b.a(this.a, (int) R.string.state_unbind_success, 0).show();
            C0401a.a(this.a, C0401a.eY);
            return;
        }
        this.a.a.login(this.a);
        C0401a.a(this.a, C0401a.eT, "FromUser");
    }
}
