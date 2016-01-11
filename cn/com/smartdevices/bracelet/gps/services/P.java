package cn.com.smartdevices.bracelet.gps.services;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.h.e;
import cn.com.smartdevices.bracelet.gps.model.c;
import java.util.Random;

class P {
    private c a = null;

    P() {
    }

    void a(int i, c cVar, boolean z) {
        if (z) {
            e.a("Run", "onLocationChanged altitude = " + cVar.o + ",accuracy = " + cVar.v + ",latitude = " + cVar.p + ",longitude = " + cVar.q + ",provider = " + cVar.t + ",speed = " + cVar.s + ",mBearing = " + cVar.u + ",time = " + cVar.e());
        } else {
            C0596r.e("Run", "onLocationChanged altitude = " + cVar.o + ",accuracy = " + cVar.v + ",latitude = " + cVar.p + ",longitude = " + cVar.q + ",provider = " + cVar.t + ",speed = " + cVar.s + ",mBearing = " + cVar.u + ",time = " + cVar.e());
        }
        if (!z) {
            cVar.v = 10.0f;
            Random random = new Random(1);
            if (this.a != null) {
                cVar.p = this.a.p + ((double) (random.nextFloat() / 13000.0f));
                cVar.q = ((double) (random.nextFloat() / 13000.0f)) + this.a.q;
                float d = cVar.d(this.a);
                long j = cVar.r - this.a.r;
                C0596r.e("Run", "onLocationChanged dis =" + d + ",span = " + j + ",speed = " + (d / ((float) j)));
                this.a.p = cVar.p;
                this.a.q = cVar.q;
                this.a.r = cVar.r;
                return;
            }
            this.a = cVar.a();
        }
    }
}
