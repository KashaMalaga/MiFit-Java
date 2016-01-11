package cn.com.smartdevices.bracelet.gps.services;

import android.location.GpsSatellite;
import android.location.GpsStatus.Listener;

public final class C0444c implements Listener {
    final /* synthetic */ C0441a a;

    protected C0444c(C0441a c0441a) {
        this.a = c0441a;
    }

    public void onGpsStatusChanged(int i) {
        if (this.a.c != null && 4 == i) {
            int i2 = 0;
            for (GpsSatellite usedInFix : this.a.c.getGpsStatus(null).getSatellites()) {
                if (usedInFix.usedInFix()) {
                    i2++;
                }
            }
            this.a.b.a(C0462v.a(i2).a());
        }
    }
}
