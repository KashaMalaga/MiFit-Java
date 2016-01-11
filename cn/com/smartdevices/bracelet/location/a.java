package cn.com.smartdevices.bracelet.location;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.format.DateFormat;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.location.Location.Address;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.location.LocationProviderProxy;

public class a implements i, AMapLocationListener {
    private static final String a = "AmapLocationService";
    private Context b;
    private LocationManagerProxy c;
    private d d;
    private int e;

    public a(Context context) {
        this.b = context;
        this.c = LocationManagerProxy.getInstance(context);
    }

    private Location a(AMapLocation aMapLocation) {
        Location location = new Location();
        location.b(aMapLocation.getLatitude());
        location.a(aMapLocation.getLongitude());
        Address address = new Address();
        address.c(aMapLocation.getProvince());
        address.e(aMapLocation.getCity());
        address.f(aMapLocation.getDistrict());
        address.g(aMapLocation.getStreet());
        address.h(aMapLocation.getAdCode());
        address.i(aMapLocation.getCityCode());
        location.a(address);
        return location;
    }

    private void b(AMapLocation aMapLocation) {
        C0596r.e(a, "Location : " + aMapLocation.getLatitude() + "  " + aMapLocation.getLongitude());
        C0596r.e(a, "Accuracy : " + String.valueOf(aMapLocation.getAccuracy()));
        C0596r.e(a, "Provider : " + aMapLocation.getProvider());
        C0596r.e(a, "Time : " + DateFormat.format("yyyy-MM-dd HH:mm:ss", aMapLocation.getTime()));
        C0596r.e(a, "Address : " + aMapLocation.getAddress());
        C0596r.e(a, "Addr Province : " + aMapLocation.getProvince());
        C0596r.e(a, "Addr City : " + aMapLocation.getCity());
        C0596r.e(a, "Addr CityCode : " + aMapLocation.getCityCode());
        C0596r.e(a, "Addr District : " + aMapLocation.getDistrict());
        C0596r.e(a, "Addr Stress : " + aMapLocation.getStreet());
        C0596r.e(a, "Addr AddrCode : " + aMapLocation.getAdCode());
    }

    public void a() {
        C0596r.e(a, "Start Location!!");
        this.c.requestLocationData(LocationProviderProxy.AMapNetwork, (long) this.e, 15.0f, this);
    }

    public void a(d dVar) {
        this.d = dVar;
    }

    public void a(g gVar) {
        if (h.HighAccuracy == gVar.c()) {
            this.c.setGpsEnable(true);
        } else if (h.BatterySave == gVar.c()) {
            this.c.setGpsEnable(false);
        } else if (h.GpsOnly == gVar.c()) {
            this.c.setGpsEnable(true);
        }
        this.e = gVar.a();
    }

    public void b() {
        C0596r.e(a, "Stop Location!!");
        this.c.removeUpdates((AMapLocationListener) this);
        this.c.destroy();
    }

    public Location c() {
        AMapLocation lastKnownLocation = this.c.getLastKnownLocation(LocationProviderProxy.AMapNetwork);
        C0596r.e(a, "Last Amap Known Location : ");
        if (lastKnownLocation == null) {
            return null;
        }
        b(lastKnownLocation);
        return a(lastKnownLocation);
    }

    public void onLocationChanged(Location location) {
    }

    public void onLocationChanged(AMapLocation aMapLocation) {
        if (aMapLocation != null) {
            int errorCode = aMapLocation.getAMapException().getErrorCode();
            if (errorCode != 0) {
                C0401a.a(this.b, C0401a.eF, "Amap_" + errorCode);
                return;
            }
            b(aMapLocation);
            if (this.d != null) {
                this.d.a(a(aMapLocation));
            }
        }
    }

    public void onProviderDisabled(String str) {
    }

    public void onProviderEnabled(String str) {
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
