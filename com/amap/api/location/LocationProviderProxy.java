package com.amap.api.location;

import android.location.Criteria;
import android.location.LocationManager;
import android.location.LocationProvider;

public class LocationProviderProxy {
    public static final String AMapNetwork = "lbs";
    public static final int AVAILABLE = 2;
    public static final int OUT_OF_SERVICE = 0;
    public static final int TEMPORARILY_UNAVAILABLE = 1;
    private LocationManager a;
    private String b;

    protected LocationProviderProxy(LocationManager locationManager, String str) {
        this.a = locationManager;
        this.b = str;
    }

    private LocationProvider a() {
        try {
            if (this.a != null) {
                return this.a.getProvider(this.b);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    static LocationProviderProxy a(LocationManager locationManager, String str) {
        return new LocationProviderProxy(locationManager, str);
    }

    public int getAccuracy() {
        try {
            if (AMapNetwork != null && AMapNetwork.equals(this.b)) {
                return AVAILABLE;
            }
            if (a() != null) {
                return a().getAccuracy();
            }
            return -1;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public String getName() {
        try {
            if (AMapNetwork != null && AMapNetwork.equals(this.b)) {
                return AMapNetwork;
            }
            if (a() != null) {
                return a().getName();
            }
            return "null";
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int getPowerRequirement() {
        try {
            if (AMapNetwork != null && AMapNetwork.equals(this.b)) {
                return AVAILABLE;
            }
            if (a() != null) {
                return a().getPowerRequirement();
            }
            return -1;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean hasMonetaryCost() {
        boolean z = false;
        try {
            if ((AMapNetwork == null || !AMapNetwork.equals(this.b)) && a() != null) {
                z = a().hasMonetaryCost();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return z;
    }

    public boolean meetsCriteria(Criteria criteria) {
        try {
            if (AMapNetwork != null && AMapNetwork.equals(this.b)) {
                return criteria == null ? true : (criteria.isAltitudeRequired() || criteria.isBearingRequired() || criteria.isSpeedRequired() || criteria.getAccuracy() == TEMPORARILY_UNAVAILABLE) ? false : true;
            } else {
                if (a() != null) {
                    return a().meetsCriteria(criteria);
                }
                return false;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean requiresCell() {
        boolean z = true;
        try {
            if ((AMapNetwork == null || !AMapNetwork.equals(this.b)) && a() != null) {
                z = a().requiresCell();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return z;
    }

    public boolean requiresNetwork() {
        boolean z = true;
        try {
            if ((AMapNetwork == null || !AMapNetwork.equals(this.b)) && a() != null) {
                z = a().requiresNetwork();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return z;
    }

    public boolean requiresSatellite() {
        try {
            if (AMapNetwork != null && AMapNetwork.equals(this.b)) {
                return false;
            }
            if (a() != null) {
                return a().requiresNetwork();
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean supportsAltitude() {
        boolean z = false;
        try {
            if ((AMapNetwork == null || !AMapNetwork.equals(this.b)) && a() != null) {
                z = a().supportsAltitude();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return z;
    }

    public boolean supportsBearing() {
        boolean z = false;
        try {
            if ((AMapNetwork == null || !AMapNetwork.equals(this.b)) && a() != null) {
                z = a().supportsBearing();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return z;
    }

    public boolean supportsSpeed() {
        boolean z = false;
        try {
            if ((AMapNetwork == null || !AMapNetwork.equals(this.b)) && a() != null) {
                z = a().supportsSpeed();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return z;
    }
}
