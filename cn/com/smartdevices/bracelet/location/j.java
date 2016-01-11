package cn.com.smartdevices.bracelet.location;

import android.content.Context;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.location.Location.Address;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.services.geocoder.GeocodeSearch;
import java.io.IOException;
import java.util.List;

public class j implements LocationListener, i {
    private static final String a = "SystemLocationService";
    private Context b;
    private LocationManager c;
    private d d;
    private String e;
    private int f;

    public j(Context context) {
        this.b = context;
        this.c = (LocationManager) context.getSystemService(LocationManagerProxy.KEY_LOCATION_CHANGED);
        C0596r.e(a, "Provider : " + this.c.getAllProviders());
    }

    public void a() {
        C0596r.e(a, "Start Location!!");
        this.c.requestLocationUpdates(this.e, (long) this.f, 15.0f, this);
        C0596r.e(a, "Last Loc : " + this.c.getLastKnownLocation(LocationManagerProxy.NETWORK_PROVIDER));
    }

    public void a(d dVar) {
        this.d = dVar;
    }

    public void a(g gVar) {
        if (h.HighAccuracy == gVar.c()) {
            this.e = GeocodeSearch.GPS;
        } else if (h.BatterySave == gVar.c()) {
            this.e = LocationManagerProxy.NETWORK_PROVIDER;
        } else if (h.GpsOnly == gVar.c()) {
            this.e = GeocodeSearch.GPS;
        }
    }

    public void b() {
        C0596r.e(a, "Stop Location!!");
        this.c.removeUpdates(this);
    }

    public Location c() {
        return null;
    }

    public void onLocationChanged(Location location) {
        Address address;
        Location location2;
        IOException iOException;
        C0596r.e(a, "Time : " + location.getTime());
        C0596r.e(a, "Latitude : " + location.getLatitude());
        C0596r.e(a, "Longitude : " + location.getLongitude());
        try {
            List fromLocation = new Geocoder(this.b).getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            C0596r.e(a, "Address : " + fromLocation);
            if (fromLocation == null || fromLocation.size() <= 0) {
                address = null;
                if (this.d == null) {
                    location2 = new Location();
                    location2.b(location.getLatitude());
                    location2.a(location.getLongitude());
                    if (address != null) {
                        location2.a(address);
                    }
                    this.d.a(location2);
                }
            }
            android.location.Address address2 = (android.location.Address) fromLocation.get(0);
            Address address3 = new Address();
            try {
                address3.a(address2.getCountryName());
                address3.b(address2.getCountryCode());
                address3.c(address2.getAdminArea());
                address3.d(address2.getSubAdminArea());
                address3.e(address2.getLocality());
                address3.f(address2.getSubLocality());
                address3.g(address2.getThoroughfare());
                address = address3;
            } catch (IOException e) {
                IOException iOException2 = e;
                address = address3;
                iOException = iOException2;
                iOException.printStackTrace();
                if (this.d == null) {
                    location2 = new Location();
                    location2.b(location.getLatitude());
                    location2.a(location.getLongitude());
                    if (address != null) {
                        location2.a(address);
                    }
                    this.d.a(location2);
                }
            }
            if (this.d == null) {
                location2 = new Location();
                location2.b(location.getLatitude());
                location2.a(location.getLongitude());
                if (address != null) {
                    location2.a(address);
                }
                this.d.a(location2);
            }
        } catch (IOException e2) {
            iOException = e2;
            address = null;
            iOException.printStackTrace();
            if (this.d == null) {
                location2 = new Location();
                location2.b(location.getLatitude());
                location2.a(location.getLongitude());
                if (address != null) {
                    location2.a(address);
                }
                this.d.a(location2);
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
