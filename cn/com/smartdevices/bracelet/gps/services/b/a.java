package cn.com.smartdevices.bracelet.gps.services.b;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Looper;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.location.LocationProviderProxy;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.edmodo.cropper.cropwindow.CropOverlayView;
import java.util.ArrayList;
import java.util.Timer;

class a implements AMapLocationListener {
    private static final long a = 30000;
    private static final float b = 10.0f;
    private static final long c = 5000;
    private static final long d = 30000;
    private static final long e = 30000;
    private static final long f = 210000;
    private a g;
    private final boolean h = false;
    private boolean i;
    private final ArrayList<ScanResult> j;
    private Location k;
    private LocationManager l;
    private final ArrayList<ScanResult> m;
    private final boolean n = false;
    private final WifiManager o;
    private LocationManagerProxy p;
    private ArrayList<ScanResult> q;
    private Timer r;
    private boolean s;
    private Location t;
    private Timer u;
    private Timer v;
    private Timer w;

    public a(Context context) {
        this.o = (WifiManager) context.getSystemService("wifi");
        this.j = new ArrayList();
        this.m = new ArrayList();
        this.s = true;
    }

    private void a(Context context, long j) {
        if (this.v != null) {
            this.v.cancel();
            this.v = null;
        }
        this.v = new Timer();
        this.v.schedule(new d(this, context), j);
        if (this.w != null) {
            this.w.cancel();
            this.w = null;
        }
        this.w = new Timer();
        this.w.schedule(new e(this, context), j + f);
        if (this.r != null) {
            this.r.cancel();
            this.r = null;
        }
        this.r = new Timer();
        this.r.schedule(new f(this, context), (j + f) + e);
        if (this.u != null) {
            this.u.cancel();
            this.u = null;
        }
        this.u = new Timer();
        this.u.schedule(new g(this, context), ((j + f) + e) + e);
    }

    private void a(Context context, long j, float f, String str) {
        try {
            this.l = (LocationManager) context.getSystemService(com.xiaomi.channel.relationservice.data.a.l);
            if (this.l.isProviderEnabled("passive")) {
                this.l.requestLocationUpdates("passive", j, f, this, Looper.getMainLooper());
            }
            if (str.equals(LocationManagerProxy.NETWORK_PROVIDER) && this.l.isProviderEnabled(LocationManagerProxy.NETWORK_PROVIDER)) {
                this.l.requestLocationUpdates(LocationManagerProxy.NETWORK_PROVIDER, j, f, this, Looper.getMainLooper());
            }
            if (str.equals(GeocodeSearch.GPS)) {
                if (this.l.isProviderEnabled(LocationManagerProxy.NETWORK_PROVIDER)) {
                    this.l.requestLocationUpdates(LocationManagerProxy.NETWORK_PROVIDER, j, f, this, Looper.getMainLooper());
                }
                if (this.l.isProviderEnabled(GeocodeSearch.GPS)) {
                    this.l.requestLocationUpdates(GeocodeSearch.GPS, j, f, this, Looper.getMainLooper());
                    if (this.p != null) {
                        this.p.removeUpdates((AMapLocationListener) this);
                        this.p.destory();
                        this.p = null;
                    }
                    this.p = LocationManagerProxy.getInstance(context);
                    this.p.setGpsEnable(str.equals(GeocodeSearch.GPS));
                    this.p.requestLocationUpdates(LocationProviderProxy.AMapNetwork, j, f, (AMapLocationListener) this);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean a(Location location) {
        return this.t != null && location.getTime() > this.t.getTime();
    }

    private boolean b() {
        return true;
    }

    private boolean b(Location location) {
        if (location.getAccuracy() >= 501.0f) {
            return false;
        }
        if ((this.s && location.getAccuracy() > CropOverlayView.a) || a(location)) {
            return false;
        }
        this.t = location;
        if (!this.s) {
            a();
            a(null, e);
        }
        return true;
    }

    public void a() {
        if (this.v != null) {
            this.v.cancel();
            this.v = null;
        }
        if (this.w != null) {
            this.w.cancel();
            this.w = null;
        }
        if (this.r != null) {
            this.r.cancel();
            this.r = null;
        }
        if (this.u != null) {
            this.u.cancel();
            this.u = null;
        }
        if (this.p != null) {
            this.p.removeUpdates((AMapLocationListener) this);
            this.p.destory();
            this.p = null;
        }
        if (this.l != null) {
            this.l.removeUpdates(this);
            this.l = null;
        }
    }

    public void a(Context context) {
        a();
        if (this.s) {
            new Timer().schedule(new b(this, context), 0);
        }
        a(context, e);
    }

    public void b(Context context) {
        if (this.s) {
            this.s = false;
            a();
            a(context, 0);
        }
    }

    public void c(Context context) {
        if (!this.s) {
            this.s = true;
            a();
            new Timer().schedule(new c(this, context), 0);
        }
    }

    public void onLocationChanged(Location location) {
        if (b(location)) {
            this.k = location;
        }
    }

    public void onLocationChanged(AMapLocation aMapLocation) {
        if (b((Location) aMapLocation)) {
            this.k = aMapLocation;
        }
    }

    public void onProviderDisabled(String str) {
    }

    public void onProviderEnabled(String str) {
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
