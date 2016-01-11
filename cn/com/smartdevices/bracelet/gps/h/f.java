package cn.com.smartdevices.bracelet.gps.h;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.services.geocoder.GeocodeSearch;

public class f {
    private f() {
    }

    public static Intent a() {
        return new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
    }

    public static boolean a(Context context) {
        return ((LocationManager) context.getSystemService(LocationManagerProxy.KEY_LOCATION_CHANGED)).isProviderEnabled(GeocodeSearch.GPS);
    }

    public static boolean b(Context context) {
        return a(context) || c(context);
    }

    public static boolean c(Context context) {
        return ((LocationManager) context.getSystemService(LocationManagerProxy.KEY_LOCATION_CHANGED)).isProviderEnabled(LocationManagerProxy.NETWORK_PROVIDER);
    }
}
