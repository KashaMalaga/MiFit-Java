package com.amap.api.maps;

import android.graphics.Point;
import com.amap.api.mapcore.k;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;

public final class CameraUpdateFactory {
    public static CameraUpdate changeBearing(float f) {
        return new CameraUpdate(k.d(f % 360.0f));
    }

    public static CameraUpdate changeLatLng(LatLng latLng) {
        IPoint iPoint = new IPoint();
        MapProjection.lonlat2Geo(latLng.longitude, latLng.latitude, iPoint);
        return new CameraUpdate(k.a(iPoint));
    }

    public static CameraUpdate changeTilt(float f) {
        return new CameraUpdate(k.c(f));
    }

    public static CameraUpdate newCameraPosition(CameraPosition cameraPosition) {
        return new CameraUpdate(k.a(cameraPosition));
    }

    public static CameraUpdate newLatLng(LatLng latLng) {
        return new CameraUpdate(k.a(latLng));
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i) {
        return new CameraUpdate(k.a(latLngBounds, i));
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i, int i2, int i3) {
        return new CameraUpdate(k.a(latLngBounds, i, i2, i3));
    }

    public static CameraUpdate newLatLngZoom(LatLng latLng, float f) {
        return new CameraUpdate(k.a(latLng, f));
    }

    public static CameraUpdate scrollBy(float f, float f2) {
        return new CameraUpdate(k.a(f, f2));
    }

    public static CameraUpdate zoomBy(float f) {
        return new CameraUpdate(k.b(f));
    }

    public static CameraUpdate zoomBy(float f, Point point) {
        return new CameraUpdate(k.a(f, point));
    }

    public static CameraUpdate zoomIn() {
        return new CameraUpdate(k.b());
    }

    public static CameraUpdate zoomOut() {
        return new CameraUpdate(k.c());
    }

    public static CameraUpdate zoomTo(float f) {
        return new CameraUpdate(k.a(f));
    }
}
