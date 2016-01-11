package com.b;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.amap.api.services.geocoder.GeocodeSearch;
import java.text.SimpleDateFormat;

final class C0936u implements LocationListener {
    private /* synthetic */ at a;

    C0936u(at atVar) {
        this.a = atVar;
    }

    private static boolean a(Location location) {
        return location != null && GeocodeSearch.GPS.equalsIgnoreCase(location.getProvider()) && location.getLatitude() > -90.0d && location.getLatitude() < 90.0d && location.getLongitude() > -180.0d && location.getLongitude() < 180.0d;
    }

    public final void onLocationChanged(Location location) {
        try {
            long time = location.getTime();
            long currentTimeMillis = System.currentTimeMillis();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            simpleDateFormat.format(Long.valueOf(time));
            simpleDateFormat.format(Long.valueOf(currentTimeMillis));
            if (time > 0) {
                currentTimeMillis = time;
            }
            if (location != null && C0936u.a(location)) {
                if (location.getSpeed() > ((float) at.e)) {
                    C.a(at.h);
                    C.b(at.h * 10);
                } else if (location.getSpeed() > ((float) at.d)) {
                    C.a(at.g);
                    C.b(at.g * 10);
                } else {
                    C.a(at.f);
                    C.b(at.f * 10);
                }
                this.a.y.a();
                C0936u.a(location);
                if (this.a.y.a() && C0936u.a(location)) {
                    location.setTime(System.currentTimeMillis());
                    this.a.q = System.currentTimeMillis();
                    this.a.D = location;
                    if (!this.a.k) {
                        at.a(this.a, location, 0, currentTimeMillis);
                    } else {
                        L.a("collector");
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public final void onProviderDisabled(String str) {
    }

    public final void onProviderEnabled(String str) {
    }

    public final void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
