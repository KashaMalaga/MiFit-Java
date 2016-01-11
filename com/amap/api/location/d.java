package com.amap.api.location;

import android.content.Context;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Looper;
import com.amap.api.services.geocoder.GeocodeSearch;

public class d {
    public LocationManager a = null;
    LocationListener b = new e(this);
    private a c;
    private a d;
    private Context e;

    d(Context context, LocationManager locationManager, a aVar, a aVar2) {
        this.e = context;
        this.a = locationManager;
        this.d = aVar2;
        this.c = aVar;
    }

    void a() {
    }

    void a(long j, float f) {
        try {
            Looper mainLooper = this.e.getMainLooper();
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            this.a.requestLocationUpdates(GeocodeSearch.GPS, j, f, this.b, mainLooper);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    void b() {
        if (this.b != null) {
            this.a.removeUpdates(this.b);
        }
    }
}
