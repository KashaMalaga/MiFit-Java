package com.amap.api.location;

import android.location.Location;
import android.os.Bundle;

public class f implements AMapLocationListener {
    private LocationManagerProxy a;
    private AMapLocationListener b = null;

    public f(LocationManagerProxy locationManagerProxy) {
        this.a = locationManagerProxy;
    }

    public void a() {
        if (this.a != null) {
            this.a.removeUpdates((AMapLocationListener) this);
        }
        this.b = null;
    }

    public boolean a(AMapLocationListener aMapLocationListener, long j, float f, String str) {
        this.b = aMapLocationListener;
        if (!LocationProviderProxy.AMapNetwork.equals(str)) {
            return false;
        }
        this.a.requestLocationUpdates(str, j, f, (AMapLocationListener) this);
        return true;
    }

    public void onLocationChanged(Location location) {
        if (this.b != null) {
            this.b.onLocationChanged(location);
        }
    }

    public void onLocationChanged(AMapLocation aMapLocation) {
        if (this.b != null) {
            this.b.onLocationChanged(aMapLocation);
        }
    }

    public void onProviderDisabled(String str) {
        if (this.b != null) {
            this.b.onProviderDisabled(str);
        }
    }

    public void onProviderEnabled(String str) {
        if (this.b != null) {
            this.b.onProviderEnabled(str);
        }
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
        if (this.b != null) {
            this.b.onStatusChanged(str, i, bundle);
        }
    }
}
