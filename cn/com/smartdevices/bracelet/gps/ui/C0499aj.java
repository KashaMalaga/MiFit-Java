package cn.com.smartdevices.bracelet.gps.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.ui.b.b;

class C0499aj implements OnClickListener {
    final /* synthetic */ Context a;
    final /* synthetic */ C0498ai b;

    C0499aj(C0498ai c0498ai, Context context) {
        this.b = c0498ai;
        this.a = context;
    }

    public void onClick(View view) {
        this.b.a = 1 + this.b.a;
        if (this.b.b == 0) {
            this.b.b = System.currentTimeMillis();
        } else if (System.currentTimeMillis() - this.b.b > 2000) {
            this.b.a = 0;
            this.b.b = 0;
        }
        C0596r.e("UI", "mEmailTriggerCount=" + this.b.a + ",mEmailTriggerTime= " + this.b.b);
        if (this.b.a >= 4) {
            this.b.a = 0;
            this.b.b = 0;
            if (!b.a(this.a)) {
                com.huami.android.view.b.a(this.a, "No log to send", 0).show();
            }
        }
    }
}
