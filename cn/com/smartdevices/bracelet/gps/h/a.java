package cn.com.smartdevices.bracelet.gps.h;

import cn.com.smartdevices.bracelet.gps.model.c;
import com.amap.api.maps.model.LatLng;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

public class a {
    private a() {
    }

    public static LatLng a(double d, double d2) {
        return new LatLng(d, d2);
    }

    public static LatLng a(c cVar) {
        if (cVar != null) {
            return new LatLng(cVar.p, cVar.q);
        }
        throw new IllegalArgumentException();
    }

    public static LatLonPoint a(LatLng latLng) {
        if (latLng != null) {
            return new LatLonPoint(latLng.latitude, latLng.longitude);
        }
        throw new IllegalArgumentException();
    }

    public static List<LatLng> a(List<c> list) {
        if (list == null) {
            throw new IllegalArgumentException();
        }
        int size = list.size();
        if (size == 0) {
            return new ArrayList(0);
        }
        List<LatLng> arrayList = new ArrayList(size);
        size = 0;
        for (c cVar : list) {
            arrayList.add(size, a(cVar.p, cVar.q));
            size++;
        }
        return arrayList;
    }

    public static LatLonPoint b(c cVar) {
        if (cVar != null) {
            return new LatLonPoint(cVar.p, cVar.q);
        }
        throw new IllegalArgumentException();
    }

    public static List<LatLng> b(List<LatLonPoint> list) {
        if (list == null) {
            throw new IllegalArgumentException();
        } else if (list.size() == 0) {
            return new ArrayList(0);
        } else {
            List<LatLng> arrayList = new ArrayList();
            int i = 0;
            for (LatLonPoint latLonPoint : list) {
                arrayList.add(i, a(latLonPoint.getLatitude(), latLonPoint.getLongitude()));
                i++;
            }
            return arrayList;
        }
    }

    public static LatLonPoint c(c cVar) {
        if (cVar != null) {
            return new LatLonPoint(cVar.p, cVar.q);
        }
        throw new IllegalArgumentException();
    }

    public static List<LatLonPoint> c(List<c> list) {
        if (list == null) {
            throw new IllegalArgumentException();
        } else if (list.size() == 0) {
            return new ArrayList(0);
        } else {
            List<LatLonPoint> arrayList = new ArrayList();
            int i = 0;
            for (c c : list) {
                arrayList.add(i, c(c));
                i++;
            }
            return arrayList;
        }
    }
}
