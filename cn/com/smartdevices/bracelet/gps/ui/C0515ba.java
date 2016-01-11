package cn.com.smartdevices.bracelet.gps.ui;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.f.C0438a;
import cn.com.smartdevices.bracelet.gps.h.e;

final class C0515ba extends C0438a {
    final /* synthetic */ RunningMainActivity j;

    public C0515ba(RunningMainActivity runningMainActivity, Context context) {
        this.j = runningMainActivity;
        super(context);
    }

    public void f() {
        e.a("GPS", "onSportServcieConnected");
        long d = d();
        this.j.h.setEnabled(true);
        C0596r.g("RunningMainActivity", "trackId is " + d);
        C0596r.g("RunningMainActivity", "GPSSignalLevel:" + a());
        if (d <= 0) {
            this.j.d(a());
        } else {
            this.j.a(false);
        }
    }
}
