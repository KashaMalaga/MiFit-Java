package com.amap.api.location;

import android.app.Activity;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import com.amap.api.location.core.d;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class LocationManagerProxy {
    public static final String GPS_PROVIDER = "gps";
    public static final String KEY_LOCATION_CHANGED = "location";
    public static final String KEY_PROVIDER_ENABLED = "providerEnabled";
    public static final String KEY_PROXIMITY_ENTERING = "entering";
    public static final String KEY_STATUS_CHANGED = "status";
    public static final String NETWORK_PROVIDER = "network";
    public static final int WEATHER_TYPE_FORECAST = 2;
    public static final int WEATHER_TYPE_LIVE = 1;
    static Object a = new Object();
    private static LocationManagerProxy c = null;
    private LocationManager b = null;
    private a d = null;
    private Context e;
    private f f;
    private b g;
    private ArrayList<PendingIntent> h = new ArrayList();
    private Hashtable<String, LocationProviderProxy> i = new Hashtable();
    private Vector<g> j = new Vector();
    private Vector<g> k = new Vector();
    private a l = new a(this);

    class a implements AMapLocationListener {
        final /* synthetic */ LocationManagerProxy a;

        a(LocationManagerProxy locationManagerProxy) {
            this.a = locationManagerProxy;
        }

        public void onLocationChanged(Location location) {
            int i = 0;
            int i2;
            g gVar;
            if (location != null) {
                try {
                    AMapLocation aMapLocation = new AMapLocation(location);
                    i2 = 0;
                    while (this.a.j != null && i2 < this.a.j.size()) {
                        gVar = (g) this.a.j.get(i2);
                        if (!(gVar == null || gVar.b == null)) {
                            gVar.b.onLocationChanged(aMapLocation);
                        }
                        if (!(gVar == null || gVar.a != -1 || this.a.k == null)) {
                            this.a.k.add(gVar);
                        }
                        i2 += LocationManagerProxy.WEATHER_TYPE_LIVE;
                    }
                    if (this.a.k != null && this.a.k.size() > 0 && this.a.j != null) {
                        while (i < this.a.k.size()) {
                            this.a.j.remove(this.a.k.get(i));
                            i += LocationManagerProxy.WEATHER_TYPE_LIVE;
                        }
                        this.a.k.clear();
                        if (this.a.j.size() == 0 && this.a.b != null && this.a.l != null) {
                            this.a.b.removeUpdates(this.a.l);
                            return;
                        }
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            }
            i2 = 0;
            while (this.a.j != null && i2 < this.a.j.size()) {
                gVar = (g) this.a.j.get(i2);
                if (!(gVar == null || gVar.a != -1 || this.a.k == null)) {
                    this.a.k.add(gVar);
                }
                i2 += LocationManagerProxy.WEATHER_TYPE_LIVE;
            }
            if (this.a.k != null && this.a.k.size() > 0 && this.a.j != null) {
                for (int i3 = 0; i3 < this.a.k.size(); i3 += LocationManagerProxy.WEATHER_TYPE_LIVE) {
                    this.a.j.remove(this.a.k.get(i3));
                }
                this.a.k.clear();
                if (this.a.j.size() == 0 && this.a.b != null && this.a.l != null) {
                    this.a.b.removeUpdates(this.a.l);
                }
            }
        }

        public void onLocationChanged(AMapLocation aMapLocation) {
        }

        public void onProviderDisabled(String str) {
        }

        public void onProviderEnabled(String str) {
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    class b implements AMapLocationListener {
        final /* synthetic */ LocationManagerProxy a;

        b(LocationManagerProxy locationManagerProxy) {
            this.a = locationManagerProxy;
        }

        public void onLocationChanged(Location location) {
            try {
                if (this.a.h != null && this.a.h.size() > 0) {
                    Iterator it = this.a.h.iterator();
                    while (it.hasNext()) {
                        PendingIntent pendingIntent = (PendingIntent) it.next();
                        Intent intent = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putParcelable(LocationManagerProxy.KEY_LOCATION_CHANGED, location);
                        intent.putExtras(bundle);
                        pendingIntent.send(this.a.e, 0, intent);
                    }
                }
            } catch (CanceledException e) {
                e.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public void onLocationChanged(AMapLocation aMapLocation) {
            try {
                if (this.a.h != null && this.a.h.size() > 0) {
                    Iterator it = this.a.h.iterator();
                    while (it.hasNext()) {
                        PendingIntent pendingIntent = (PendingIntent) it.next();
                        Intent intent = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putParcelable(LocationManagerProxy.KEY_LOCATION_CHANGED, aMapLocation);
                        intent.putExtras(bundle);
                        pendingIntent.send(this.a.e, 0, intent);
                    }
                }
            } catch (CanceledException e) {
                e.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public void onProviderDisabled(String str) {
        }

        public void onProviderEnabled(String str) {
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    private LocationManagerProxy(Activity activity) {
        a(activity.getApplicationContext());
    }

    private LocationManagerProxy(Context context) {
        a(context);
    }

    private static void a() {
        c = null;
    }

    private void a(Context context) {
        try {
            this.e = context;
            this.b = (LocationManager) context.getSystemService(KEY_LOCATION_CHANGED);
            this.d = a.a(context.getApplicationContext(), this.b);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private synchronized void a(String str, long j, float f, AMapLocationListener aMapLocationListener, boolean z) {
        try {
            if (this.d == null) {
                this.d = a.a(this.e.getApplicationContext(), this.b);
            }
            String str2 = str == null ? LocationProviderProxy.AMapNetwork : str;
            if (LocationProviderProxy.AMapNetwork.equals(str2)) {
                if (this.d != null) {
                    this.d.a(j, f, aMapLocationListener, LocationProviderProxy.AMapNetwork, z);
                }
            } else if (!GPS_PROVIDER.equals(str2)) {
                Looper mainLooper = this.e.getMainLooper();
                if (Looper.myLooper() == null) {
                    Looper.prepare();
                }
                this.j.add(new g(j, f, aMapLocationListener, str2, false));
                this.b.requestLocationUpdates(str2, j, f, this.l, mainLooper);
            } else if (this.d != null) {
                this.d.a(j, f, aMapLocationListener, GPS_PROVIDER, z);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static LocationManagerProxy getInstance(Activity activity) {
        try {
            synchronized (a) {
                if (c == null) {
                    c = new LocationManagerProxy(activity);
                }
            }
            return c;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static synchronized LocationManagerProxy getInstance(Context context) {
        LocationManagerProxy locationManagerProxy;
        synchronized (LocationManagerProxy.class) {
            try {
                if (c == null) {
                    c = new LocationManagerProxy(context);
                }
                locationManagerProxy = c;
            } catch (Throwable th) {
                th.printStackTrace();
                locationManagerProxy = null;
            }
        }
        return locationManagerProxy;
    }

    public static String getVersion() {
        try {
            return "V1.3.1";
        } catch (Exception e) {
            e.printStackTrace();
            return com.xiaomi.e.a.f;
        }
    }

    public void addGeoFenceAlert(double d, double d2, float f, long j, PendingIntent pendingIntent) {
        try {
            if (this.d != null) {
                this.d.b(d, d2, f, j, pendingIntent);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean addGpsStatusListener(Listener listener) {
        try {
            if (this.b != null) {
                return this.b.addGpsStatusListener(listener);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    public void addProximityAlert(double d, double d2, float f, long j, PendingIntent pendingIntent) {
        try {
            if (this.d.f) {
                this.b.addProximityAlert(d, d2, f, j, pendingIntent);
            }
            this.d.a(d, d2, f, j, pendingIntent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void addTestProvider(String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i, int i2) {
        try {
            if (this.b != null) {
                this.b.addTestProvider(str, z, z2, z3, z4, z5, z6, z7, i, i2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void clearTestProviderEnabled(String str) {
        try {
            if (this.b != null) {
                this.b.clearTestProviderEnabled(str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void clearTestProviderLocation(String str) {
        try {
            if (this.b != null) {
                this.b.clearTestProviderLocation(str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void clearTestProviderStatus(String str) {
        try {
            if (this.b != null) {
                this.b.clearTestProviderStatus(str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Deprecated
    public void destory() {
        try {
            destroy();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void destroy() {
        try {
            synchronized (a) {
                a.c();
                if (this.i != null) {
                    this.i.clear();
                }
                if (this.j != null) {
                    this.j.clear();
                }
                if (this.b != null) {
                    if (this.l != null) {
                        this.b.removeUpdates(this.l);
                    }
                    if (this.h != null) {
                        for (int i = 0; i < this.h.size(); i += WEATHER_TYPE_LIVE) {
                            PendingIntent pendingIntent = (PendingIntent) this.h.get(i);
                            if (pendingIntent != null) {
                                this.b.removeUpdates(pendingIntent);
                            }
                        }
                    }
                }
                if (this.h != null) {
                    this.h.clear();
                }
                this.d = null;
                a();
                this.l = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public List<String> getAllProviders() {
        try {
            List<String> allProviders = this.b.getAllProviders();
            if (allProviders == null) {
                allProviders = new ArrayList();
                allProviders.add(LocationProviderProxy.AMapNetwork);
                allProviders.addAll(this.b.getAllProviders());
                return allProviders;
            } else if (allProviders.contains(LocationProviderProxy.AMapNetwork)) {
                return allProviders;
            } else {
                allProviders.add(LocationProviderProxy.AMapNetwork);
                return allProviders;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public String getBestProvider(Criteria criteria, boolean z) {
        try {
            String str = LocationProviderProxy.AMapNetwork;
            if (criteria == null) {
                return str;
            }
            if (!getProvider(LocationProviderProxy.AMapNetwork).meetsCriteria(criteria)) {
                str = this.b.getBestProvider(criteria, z);
            }
            return (!z || d.a(this.e)) ? str : this.b.getBestProvider(criteria, z);
        } catch (Throwable th) {
            th.printStackTrace();
            return GPS_PROVIDER;
        }
    }

    public GpsStatus getGpsStatus(GpsStatus gpsStatus) {
        GpsStatus gpsStatus2 = null;
        try {
            if (this.b != null) {
                gpsStatus2 = this.b.getGpsStatus(gpsStatus);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return gpsStatus2;
    }

    public AMapLocation getLastKnownLocation(String str) {
        try {
            if (this.d == null) {
                return null;
            }
            if (LocationProviderProxy.AMapNetwork.equals(str)) {
                return this.d.a();
            }
            if (this.b == null) {
                return null;
            }
            Location lastKnownLocation = this.b.getLastKnownLocation(str);
            return lastKnownLocation != null ? new AMapLocation(lastKnownLocation) : null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public LocationProviderProxy getProvider(String str) {
        if (str == null) {
            try {
                throw new IllegalArgumentException("name\u4e0d\u80fd\u4e3a\u7a7a\uff01");
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        } else if (this.i.containsKey(str)) {
            return (LocationProviderProxy) this.i.get(str);
        } else {
            LocationProviderProxy a = LocationProviderProxy.a(this.b, str);
            this.i.put(str, a);
            return a;
        }
    }

    public List<String> getProviders(Criteria criteria, boolean z) {
        try {
            List<String> providers = this.b.getProviders(criteria, z);
            if (providers == null || providers.size() == 0) {
                providers = new ArrayList();
            }
            if (!LocationProviderProxy.AMapNetwork.equals(getBestProvider(criteria, z))) {
                return providers;
            }
            providers.add(LocationProviderProxy.AMapNetwork);
            return providers;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public List<String> getProviders(boolean z) {
        try {
            List<String> providers = this.b.getProviders(z);
            if (!isProviderEnabled(LocationProviderProxy.AMapNetwork)) {
                return providers;
            }
            if (providers == null || providers.size() == 0) {
                providers = new ArrayList();
            }
            providers.add(LocationProviderProxy.AMapNetwork);
            return providers;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public boolean isProviderEnabled(String str) {
        try {
            return LocationProviderProxy.AMapNetwork.equals(str) ? d.a(this.e) : this.b.isProviderEnabled(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public void removeGeoFenceAlert(PendingIntent pendingIntent) {
        try {
            if (this.d != null) {
                this.d.b(pendingIntent);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void removeGpsStatusListener(Listener listener) {
        try {
            if (this.b != null) {
                this.b.removeGpsStatusListener(listener);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void removeProximityAlert(PendingIntent pendingIntent) {
        try {
            if (!(this.d == null || !this.d.f || this.b == null)) {
                this.b.removeProximityAlert(pendingIntent);
            }
            if (this.d != null) {
                this.d.a(pendingIntent);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void removeUpdates(PendingIntent pendingIntent) {
        try {
            if (this.f != null) {
                this.h.remove(pendingIntent);
                if (this.h.size() == 0) {
                    this.f.a();
                }
            }
            this.f = null;
            this.b.removeUpdates(pendingIntent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public synchronized void removeUpdates(AMapLocationListener aMapLocationListener) {
        if (aMapLocationListener != null) {
            try {
                if (this.d != null) {
                    this.d.a(aMapLocationListener);
                }
                this.b.removeUpdates(aMapLocationListener);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (this.j != null && this.j.size() > 0) {
            int size = this.j.size();
            int i = 0;
            while (i < size) {
                int i2;
                g gVar = (g) this.j.get(i);
                if (aMapLocationListener.equals(gVar.b)) {
                    this.j.remove(gVar);
                    i2 = i - 1;
                    i = size - 1;
                } else {
                    i2 = i;
                    i = size;
                }
                size = i;
                i = i2 + WEATHER_TYPE_LIVE;
            }
            if (this.j.size() == 0 && this.l != null) {
                this.b.removeUpdates(this.l);
            }
        }
    }

    public synchronized void requestLocationData(String str, long j, float f, AMapLocationListener aMapLocationListener) {
        a(str, j, f, aMapLocationListener, true);
    }

    public void requestLocationUpdates(String str, long j, float f, PendingIntent pendingIntent) {
        try {
            if (LocationProviderProxy.AMapNetwork.equals(str)) {
                if (this.f == null) {
                    this.f = new f(this);
                }
                if (this.g == null) {
                    this.g = new b(this);
                }
                this.f.a(this.g, j, f, str);
                this.h.add(pendingIntent);
                return;
            }
            this.h.add(pendingIntent);
            this.b.requestLocationUpdates(str, j, f, pendingIntent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Deprecated
    public synchronized void requestLocationUpdates(String str, long j, float f, AMapLocationListener aMapLocationListener) {
        a(str, j, f, aMapLocationListener, false);
    }

    public void requestWeatherUpdates(int i, AMapLocalWeatherListener aMapLocalWeatherListener) {
        try {
            this.d.a(i, aMapLocalWeatherListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setGpsEnable(boolean z) {
        try {
            if (this.d != null) {
                this.d.a(z);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setTestProviderEnabled(String str, boolean z) {
        try {
            if (this.b != null) {
                this.b.setTestProviderEnabled(str, z);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setTestProviderLocation(String str, Location location) {
        try {
            if (this.b != null) {
                this.b.setTestProviderLocation(str, location);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setTestProviderStatus(String str, int i, Bundle bundle, long j) {
        try {
            if (this.b != null) {
                this.b.setTestProviderStatus(str, i, bundle, j);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
