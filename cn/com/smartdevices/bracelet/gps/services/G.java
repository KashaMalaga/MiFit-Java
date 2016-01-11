package cn.com.smartdevices.bracelet.gps.services;

import android.location.Location;
import android.os.Bundle;
import cn.com.smartdevices.bracelet.gps.h.e;
import cn.com.smartdevices.bracelet.gps.model.c;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.location.LocationProviderProxy;
import com.amap.api.location.core.AMapLocException;
import com.amap.api.services.geocoder.GeocodeSearch;

class G implements AMapLocationListener {
    final /* synthetic */ F a;

    G(F f) {
        this.a = f;
    }

    public void onLocationChanged(Location location) {
        this.a.b.a(new c(location));
    }

    public void onLocationChanged(AMapLocation aMapLocation) {
        if (this.a.i) {
            e.a("GPS", "get first location data.lat:" + aMapLocation.getLatitude() + ",long:" + aMapLocation.getLongitude() + ",from:" + aMapLocation.getProvider() + ",accuracy:" + aMapLocation.getAccuracy());
            this.a.i = false;
        }
        AMapLocException aMapException = aMapLocation.getAMapException();
        if (aMapException == null) {
            e.a("GPS", "location exception should not be null");
        } else if (aMapException.getErrorCode() != 0) {
            e.a("GPS", "locate failed, omit location point. current lat : " + aMapLocation.getLatitude() + ", current lng : " + aMapLocation.getLongitude() + ", current accuracy : " + aMapLocation.getAccuracy());
        } else {
            double[] a = C0441a.a(aMapLocation.getLatitude(), aMapLocation.getLongitude());
            aMapLocation.setLatitude(a[0]);
            aMapLocation.setLongitude(a[1]);
            c cVar = new c(aMapLocation, 1);
            cVar.s = aMapLocation.getSpeed();
            cVar.u = aMapLocation.getBearing();
            cVar.o = aMapLocation.getAltitude();
            if (LocationManagerProxy.NETWORK_PROVIDER.equals(aMapLocation.getProvider())) {
                cVar.t = 1;
            } else if (GeocodeSearch.GPS.equals(aMapLocation.getProvider())) {
                cVar.t = 2;
            } else if ("passive".equals(aMapLocation.getProvider())) {
                cVar.t = 3;
            } else if (LocationProviderProxy.AMapNetwork.equals(aMapLocation.getProvider())) {
                cVar.t = 4;
            }
            this.a.b.a(cVar);
        }
    }

    public void onProviderDisabled(String str) {
        this.a.b.a(str);
        e.a("GPS", "AMapLocationListener onProviderDisabled result = " + str);
    }

    public void onProviderEnabled(String str) {
        this.a.b.b(str);
        e.a("GPS", "AMapLocationListener onProviderEnabled result = " + str);
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
        this.a.b.a(str, i, bundle);
        e.a("GPS", "AMapLocationListener onStatusChanged provider = " + str + "  status = " + i);
    }
}
