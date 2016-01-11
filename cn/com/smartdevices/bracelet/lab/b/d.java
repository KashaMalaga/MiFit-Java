package cn.com.smartdevices.bracelet.lab.b;

import cn.com.smartdevices.bracelet.b.c;
import com.amap.api.maps.model.GroundOverlayOptions;

public class d {
    private d() {
    }

    public static float a(c cVar) {
        return cVar == null ? GroundOverlayOptions.NO_DIMENSION : cVar.a(0, 0, 0.0f);
    }

    public static int a(int i, long j) {
        return ((double) i) / ((double) j) >= 3.0d ? (int) (3.4285714285714284d * ((double) i)) : (int) (2.2857142857142856d * ((double) i));
    }
}
