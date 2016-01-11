package com.amap.api.location;

import android.location.LocationListener;

public interface AMapLocationListener extends LocationListener {
    void onLocationChanged(AMapLocation aMapLocation);
}
