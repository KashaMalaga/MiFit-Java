package com.b;

import android.os.Looper;
import com.amap.api.services.geocoder.GeocodeSearch;
import java.util.List;

final class C0938w extends Thread {
    final /* synthetic */ at a;

    C0938w(at atVar, String str) {
        this.a = atVar;
        super(str);
    }

    public final void run() {
        try {
            Looper.prepare();
            this.a.B = Looper.myLooper();
            this.a.E = new C0940y(this.a);
            try {
                this.a.s.addGpsStatusListener(this.a.E);
                this.a.s.addNmeaListener(this.a.E);
            } catch (Exception e) {
            }
            this.a.F = new C0939x(this);
            List allProviders = this.a.s.getAllProviders();
            if (allProviders != null && allProviders.contains(GeocodeSearch.GPS)) {
                allProviders.contains("passive");
            }
            try {
                this.a.s.requestLocationUpdates("passive", 1000, (float) at.c, this.a.H);
            } catch (Exception e2) {
            }
            Looper.loop();
        } catch (Exception e3) {
        }
    }
}
