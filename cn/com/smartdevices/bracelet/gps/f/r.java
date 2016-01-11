package cn.com.smartdevices.bracelet.gps.f;

import cn.com.smartdevices.bracelet.gps.model.c;
import com.amap.api.maps.model.GroundOverlay;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Polyline;
import java.util.List;

public interface r {
    LatLngBounds b(int i, c cVar);

    void c(List<Polyline> list);

    List<GroundOverlay> e();

    List<Polyline> f();
}
