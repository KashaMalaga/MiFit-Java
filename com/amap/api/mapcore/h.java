package com.amap.api.mapcore;

import android.location.Location;
import com.amap.api.mapcore.util.az;
import com.amap.api.maps.LocationSource.OnLocationChangedListener;

class h implements OnLocationChangedListener {
    Location a;
    private t b;

    h(t tVar) {
        this.b = tVar;
    }

    public void onLocationChanged(Location location) {
        this.a = location;
        try {
            if (this.b.s()) {
                this.b.a(location);
            }
        } catch (Throwable e) {
            az.a(e, "AMapOnLocationChangedListener", "onLocationChanged");
            e.printStackTrace();
        }
    }
}
