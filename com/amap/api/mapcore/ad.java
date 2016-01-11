package com.amap.api.mapcore;

import android.graphics.Point;
import android.graphics.PointF;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.TileProjection;
import com.amap.api.maps.model.VisibleRegion;

public interface ad {
    float a(int i);

    Point a(LatLng latLng);

    LatLng a(Point point);

    LatLngBounds a(LatLng latLng, float f);

    TileProjection a(LatLngBounds latLngBounds, int i, int i2);

    VisibleRegion a();

    PointF b(LatLng latLng);
}
