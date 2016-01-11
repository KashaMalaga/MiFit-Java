package com.amap.api.mapcore;

import android.graphics.Point;
import android.graphics.PointF;
import com.amap.api.mapcore.util.u;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.TileProjection;
import com.amap.api.maps.model.VisibleRegion;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;

class av implements ad {
    private t a;

    public av(t tVar) {
        this.a = tVar;
    }

    public float a(int i) {
        return i <= 0 ? 0.0f : this.a.c(i);
    }

    public Point a(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        IPoint iPoint = new IPoint();
        this.a.b(latLng.latitude, latLng.longitude, iPoint);
        return new Point(iPoint.x, iPoint.y);
    }

    public LatLng a(Point point) {
        if (point == null) {
            return null;
        }
        DPoint dPoint = new DPoint();
        this.a.a(point.x, point.y, dPoint);
        return new LatLng(dPoint.y, dPoint.x);
    }

    public LatLngBounds a(LatLng latLng, float f) {
        return (this.a == null || latLng == null) ? null : this.a.a(latLng, u.b(f));
    }

    public TileProjection a(LatLngBounds latLngBounds, int i, int i2) {
        if (latLngBounds == null || i < 0 || i > 20 || i2 <= 0) {
            return null;
        }
        IPoint iPoint = new IPoint();
        IPoint iPoint2 = new IPoint();
        this.a.a(latLngBounds.southwest.latitude, latLngBounds.southwest.longitude, iPoint);
        this.a.a(latLngBounds.northeast.latitude, latLngBounds.northeast.longitude, iPoint2);
        int i3 = (iPoint.x >> (20 - i)) / i2;
        int i4 = (iPoint2.y >> (20 - i)) / i2;
        return new TileProjection((iPoint.x - ((i3 << (20 - i)) * i2)) >> (20 - i), (iPoint2.y - ((i4 << (20 - i)) * i2)) >> (20 - i), i3, (iPoint2.x >> (20 - i)) / i2, i4, (iPoint.y >> (20 - i)) / i2);
    }

    public VisibleRegion a() {
        int h = this.a.h();
        int i = this.a.i();
        LatLng a = a(new Point(0, 0));
        LatLng a2 = a(new Point(h, 0));
        LatLng a3 = a(new Point(0, i));
        LatLng a4 = a(new Point(h, i));
        return new VisibleRegion(a3, a4, a, a2, LatLngBounds.builder().include(a3).include(a4).include(a).include(a2).build());
    }

    public PointF b(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        FPoint fPoint = new FPoint();
        this.a.a(latLng.latitude, latLng.longitude, fPoint);
        return new PointF(fPoint.x, fPoint.y);
    }
}
