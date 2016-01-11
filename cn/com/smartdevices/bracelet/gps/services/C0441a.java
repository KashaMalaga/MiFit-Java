package cn.com.smartdevices.bracelet.gps.services;

import android.content.Context;
import android.location.LocationManager;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.services.a.c;
import cn.com.smartdevices.bracelet.gps.services.b.j;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.services.geocoder.GeocodeSearch;

abstract class C0441a {
    protected final C0444c a = new C0444c(this);
    protected c b = new C0443b(this);
    protected LocationManager c = null;

    public C0441a(Context context) {
        this.c = (LocationManager) context.getSystemService(LocationManagerProxy.KEY_LOCATION_CHANGED);
    }

    protected static boolean a(Context context) {
        if (context != null) {
            return ((LocationManager) context.getSystemService(LocationManagerProxy.KEY_LOCATION_CHANGED)).isProviderEnabled(GeocodeSearch.GPS);
        }
        throw new IllegalArgumentException();
    }

    static double[] a(double d, double d2) {
        double[] dArr = new double[2];
        j.a(d, d2, dArr);
        return dArr;
    }

    public abstract void a();

    protected void a(c cVar) {
        C0596r.d(getClass().getName(), "registerListener|listener:" + cVar);
        if (cVar != null) {
            this.b = cVar;
        }
    }

    protected void b() {
        C0596r.d(getClass().getName(), "unregisterListener");
        this.b = new C0443b(this);
    }
}
