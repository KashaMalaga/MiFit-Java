package cn.com.smartdevices.bracelet.activity;

import android.view.View;
import android.view.View.OnClickListener;
import cn.com.smartdevices.bracelet.Utils;
import com.huami.android.view.b;
import com.xiaomi.hm.health.r;

class C implements OnClickListener {
    final /* synthetic */ WebActivity a;

    C(WebActivity webActivity) {
        this.a = webActivity;
    }

    public void onClick(View view) {
        if (Utils.l(this.a)) {
            this.a.mWebView.clearHistory();
            this.a.loadPages();
            return;
        }
        b.a(this.a, (int) r.network_error, 1).show();
    }
}
