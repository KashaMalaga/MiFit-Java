package cn.com.smartdevices.bracelet.gps.ui;

import android.location.Location;
import cn.com.smartdevices.bracelet.C0596r;
import com.amap.api.maps.AMap.OnMyLocationChangeListener;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.model.LatLng;

class C0542y implements OnMyLocationChangeListener {
    final /* synthetic */ C0541x a;

    C0542y(C0541x c0541x) {
        this.a = c0541x;
    }

    public void onMyLocationChange(Location location) {
        C0596r.g("GPSMainMapFragment", "onMyLocationChange");
        if (!this.a.e) {
            this.a.c.moveCamera(CameraUpdateFactory.newCameraPosition(this.a.d.target(new LatLng(location.getLatitude(), location.getLongitude())).build()));
            this.a.e = true;
        }
    }
}
