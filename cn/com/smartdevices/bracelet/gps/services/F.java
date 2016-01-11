package cn.com.smartdevices.bracelet.gps.services;

import android.content.Context;
import cn.com.smartdevices.bracelet.gps.h.e;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.location.LocationProviderProxy;

class F extends C0441a {
    private static final float f = 0.0f;
    private static final long g = 0;
    private static final String h = "GaodeLocationProcessor";
    private LocationManagerProxy d = null;
    private AMapLocationListener e = null;
    private boolean i = false;

    public F(Context context, boolean z) {
        super(context);
        this.d = LocationManagerProxy.getInstance(context);
        this.e = new G(this);
        a(4, z);
        e.a("GPS", "GaodeLocationProcessor inited");
    }

    private void a(int i, boolean z) {
        d();
        if (z && this.d != null) {
            this.d.addGpsStatusListener(this.a);
        }
    }

    private void e() {
        if (this.d == null || this.e == null) {
            throw new IllegalStateException("Listener and location manager is null");
        }
        this.d.removeUpdates(this.e);
        this.d.removeGpsStatusListener(this.a);
    }

    public void a() {
        e();
        this.d = null;
        this.e = null;
    }

    public int c() {
        return -1;
    }

    void d() {
        if (this.d == null || this.e == null) {
            throw new IllegalStateException("Listener and location manager is null");
        }
        this.d.removeUpdates(this.e);
        this.d.requestLocationData(LocationProviderProxy.AMapNetwork, g, f, this.e);
        this.i = true;
    }
}
