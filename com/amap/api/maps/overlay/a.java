package com.amap.api.maps.overlay;

import android.support.v4.view.a.C0113o;
import com.amap.api.maps.model.LatLng;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

class a {
    public static int a = C0113o.l;

    a() {
    }

    public static LatLng a(LatLonPoint latLonPoint) {
        return new LatLng(latLonPoint.getLatitude(), latLonPoint.getLongitude());
    }

    public static ArrayList<LatLng> a(List<LatLonPoint> list) {
        ArrayList<LatLng> arrayList = new ArrayList();
        for (LatLonPoint a : list) {
            arrayList.add(a(a));
        }
        return arrayList;
    }
}
