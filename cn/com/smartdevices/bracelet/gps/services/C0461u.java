package cn.com.smartdevices.bracelet.gps.services;

import java.util.TimerTask;

final class C0461u extends TimerTask {
    final /* synthetic */ C0456o a;
    private boolean b;

    private C0461u(C0456o c0456o) {
        this.a = c0456o;
        this.b = false;
    }

    public void a() {
        this.b = true;
    }

    public void run() {
        if (!this.b) {
            C0456o.a(this.a, 1000);
            this.a.y.a(this.a.v);
            this.a.g.a();
        }
    }
}
