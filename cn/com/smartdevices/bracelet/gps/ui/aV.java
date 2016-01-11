package cn.com.smartdevices.bracelet.gps.ui;

import cn.com.smartdevices.bracelet.gps.a.b;

class aV implements L {
    final /* synthetic */ K a;
    final /* synthetic */ RunningMainActivity b;

    aV(RunningMainActivity runningMainActivity, K k) {
        this.b = runningMainActivity;
        this.a = k;
    }

    public void a() {
        this.a.dismiss();
        b.b(this.b.getApplicationContext(), false);
    }

    public void b() {
        this.a.dismiss();
        this.b.a(true);
        b.b(this.b.getApplicationContext(), true);
    }
}
