package cn.com.smartdevices.bracelet.gps.ui;

import android.content.Context;
import android.content.Intent;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.f.C;
import cn.com.smartdevices.bracelet.gps.f.g;

class C0527i extends g {
    final /* synthetic */ GPSMainActivity k;

    public C0527i(GPSMainActivity gPSMainActivity, Context context, C c) {
        this.k = gPSMainActivity;
        super(context, c);
    }

    public void f() {
        super.f();
        this.k.a(this.k.o.a());
        if (this.k.o.d() > 0) {
            this.k.u();
            this.k.K.setVisibility(4);
            return;
        }
        Intent intent = this.k.getIntent();
        if (intent == null || !intent.getBooleanExtra(GPSMainActivity.a, false)) {
            C0596r.d("RunUI", "onCreate intent is null");
        } else {
            this.k.p();
        }
    }
}
