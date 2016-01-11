package cn.com.smartdevices.bracelet.gps.services;

import android.os.Bundle;
import cn.com.smartdevices.bracelet.gps.h.e;
import cn.com.smartdevices.bracelet.gps.services.a.c;

final class at implements c {
    private static final float c = 300.0f;
    private static final int e = 10000;
    private static final String f = "SubGPSSportService";
    final /* synthetic */ SubGPSSportService a;
    private int b = 4;
    private boolean d = false;

    public at(SubGPSSportService subGPSSportService, int i) {
        this.a = subGPSSportService;
        this.b = i;
    }

    private void a() {
        this.a.c.removeMessages(2);
        this.a.c.sendEmptyMessageDelayed(2, 10000);
    }

    private boolean b(cn.com.smartdevices.bracelet.gps.model.c cVar) {
        return cVar.v > c || cVar.v < 0.0f;
    }

    public void a(int i) {
        this.a.d.a(i);
        if (this.a.i != null) {
            this.a.i.b(this.a.d.a(i, this.a.i.h()));
        }
    }

    public void a(cn.com.smartdevices.bracelet.gps.model.c cVar) {
        e.a(f, "get GPS point : " + cVar);
        this.a.e.a(cVar);
        this.d = true;
        a();
        if (this.a.i != null && cn.com.smartdevices.bracelet.gps.model.e.a(this.a.i.d()) && this.b != 4) {
            if (b(cVar)) {
                e.a(f, "GPS point is omitted : " + cVar);
            } else {
                this.a.i.b(cVar);
            }
            this.a.i.j();
        }
    }

    public void a(String str) {
    }

    public void a(String str, int i, Bundle bundle) {
    }

    public void b(String str) {
    }
}
