package com.amap.api.mapcore;

import android.location.Location;
import android.view.View;
import com.amap.api.maps.AMap.CancelableCallback;
import com.amap.api.maps.AMap.InfoWindowAdapter;
import com.amap.api.maps.AMap.OnCacheRemoveListener;
import com.amap.api.maps.AMap.OnCameraChangeListener;
import com.amap.api.maps.AMap.OnInfoWindowClickListener;
import com.amap.api.maps.AMap.OnMapClickListener;
import com.amap.api.maps.AMap.OnMapLoadedListener;
import com.amap.api.maps.AMap.OnMapLongClickListener;
import com.amap.api.maps.AMap.OnMapScreenShotListener;
import com.amap.api.maps.AMap.OnMapTouchListener;
import com.amap.api.maps.AMap.OnMarkerClickListener;
import com.amap.api.maps.AMap.OnMarkerDragListener;
import com.amap.api.maps.AMap.OnMyLocationChangeListener;
import com.amap.api.maps.AMap.OnPOIClickListener;
import com.amap.api.maps.AMap.onMapPrintScreenListener;
import com.amap.api.maps.CustomRenderer;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.model.ArcOptions;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.NavigateArrowOptions;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.TileOverlay;
import com.amap.api.maps.model.TileOverlayOptions;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
import java.util.ArrayList;
import java.util.List;

public interface t {
    LatLngBounds B();

    float E();

    int F();

    List<Marker> G();

    void H();

    void I();

    int L();

    boolean M();

    j N();

    void O();

    ab a(PolygonOptions polygonOptions);

    ac a(PolylineOptions polylineOptions);

    u a(ArcOptions arcOptions);

    v a(CircleOptions circleOptions);

    w a(GroundOverlayOptions groundOverlayOptions);

    z a(NavigateArrowOptions navigateArrowOptions);

    LatLngBounds a(LatLng latLng, float f);

    Marker a(MarkerOptions markerOptions);

    TileOverlay a(TileOverlayOptions tileOverlayOptions);

    ArrayList<Marker> a(ArrayList<MarkerOptions> arrayList, boolean z);

    void a(double d, double d2, FPoint fPoint);

    void a(double d, double d2, IPoint iPoint);

    void a(float f);

    void a(int i);

    void a(int i, int i2);

    void a(int i, int i2, int i3, int i4);

    void a(int i, int i2, DPoint dPoint);

    void a(int i, int i2, FPoint fPoint);

    void a(Location location);

    void a(k kVar);

    void a(k kVar, long j, CancelableCallback cancelableCallback);

    void a(k kVar, CancelableCallback cancelableCallback);

    void a(q qVar);

    void a(y yVar);

    void a(InfoWindowAdapter infoWindowAdapter);

    void a(OnCacheRemoveListener onCacheRemoveListener);

    void a(OnCameraChangeListener onCameraChangeListener);

    void a(OnInfoWindowClickListener onInfoWindowClickListener);

    void a(OnMapClickListener onMapClickListener);

    void a(OnMapLoadedListener onMapLoadedListener);

    void a(OnMapLongClickListener onMapLongClickListener);

    void a(OnMapScreenShotListener onMapScreenShotListener);

    void a(OnMapTouchListener onMapTouchListener);

    void a(OnMarkerClickListener onMarkerClickListener);

    void a(OnMarkerDragListener onMarkerDragListener);

    void a(OnMyLocationChangeListener onMyLocationChangeListener);

    void a(OnPOIClickListener onPOIClickListener);

    void a(onMapPrintScreenListener com_amap_api_maps_AMap_onMapPrintScreenListener);

    void a(CustomRenderer customRenderer);

    void a(LocationSource locationSource);

    void a(MyLocationStyle myLocationStyle);

    void a(boolean z);

    boolean a(String str);

    int b();

    void b(double d, double d2, IPoint iPoint);

    void b(int i);

    void b(int i, int i2, DPoint dPoint);

    void b(int i, int i2, FPoint fPoint);

    void b(k kVar);

    void b(boolean z);

    boolean b(y yVar);

    float c(int i);

    MapProjection c();

    void c(boolean z);

    void d();

    void d(int i);

    void d(boolean z);

    void e(int i);

    void e(boolean z);

    void f(int i);

    void f(boolean z);

    void g(int i);

    void g(boolean z);

    int h();

    void h(int i);

    void h(boolean z);

    int i();

    CameraPosition i(boolean z);

    int j();

    void k();

    CameraPosition l();

    void l(boolean z);

    float m();

    float n();

    void o();

    void onPause();

    void onResume();

    void p();

    int q();

    boolean r();

    boolean s();

    void setZOrderOnTop(boolean z);

    Location t();

    ag u();

    ad v();

    View x();

    void y();

    float z();
}
