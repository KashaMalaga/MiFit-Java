package cn.com.smartdevices.bracelet.gps.ui;

import cn.com.smartdevices.bracelet.gps.a.b;

class C0523e extends C0522v {
    final /* synthetic */ GPSMainActivity a;

    C0523e(GPSMainActivity gPSMainActivity) {
        this.a = gPSMainActivity;
    }

    protected void a() {
        if (this.a.v == C0528j.PAUSED) {
            this.a.b(true, true);
            b.e(this.a.getApplicationContext());
        }
    }

    protected void b() {
        if (this.a.d()) {
            this.a.o();
        } else {
            this.a.r();
        }
        b.k(this.a.getApplicationContext());
    }

    protected void c() {
        this.a.a(true, true);
        b.n(this.a.getApplicationContext());
    }
}
