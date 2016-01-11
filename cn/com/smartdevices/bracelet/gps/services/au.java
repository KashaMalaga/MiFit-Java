package cn.com.smartdevices.bracelet.gps.services;

import android.os.Handler;
import android.os.Message;
import cn.com.smartdevices.bracelet.gps.c.a.p;
import cn.com.smartdevices.bracelet.gps.c.b;
import cn.com.smartdevices.bracelet.gps.h.e;

final class au extends Handler {
    static final int a = 1;
    static final int b = 2;
    static final int c = 3;
    final /* synthetic */ SubGPSSportService d;

    private au(SubGPSSportService subGPSSportService) {
        this.d = subGPSSportService;
    }

    public void a() {
        removeMessages(a);
        removeMessages(b);
        removeMessages(c);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case a /*1*/:
                if (this.d.g != null) {
                    this.d.g.d();
                }
                e.a("RService", "MSG_LOCATION_RETRY:" + (System.currentTimeMillis() / 1000));
                return;
            case b /*2*/:
                if (!(this.d.g == null || this.d.h == null)) {
                    this.d.h.d = false;
                    this.d.g.d();
                }
                e.a("RService", "MSG_LOST_LOCATION 10s:" + (System.currentTimeMillis() / 1000));
                return;
            case c /*3*/:
                if (b.f(this.d.j)) {
                    long c = p.c(this.d.j);
                    if (c > 0) {
                        this.d.f.g(c);
                    }
                    e.a("RService", "MSG_RESTORE_SPORT deathID = " + c);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
