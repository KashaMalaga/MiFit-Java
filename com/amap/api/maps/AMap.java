package com.amap.api.maps;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.amap.api.mapcore.t;
import com.amap.api.mapcore.util.e;
import com.amap.api.maps.model.Arc;
import com.amap.api.maps.model.ArcOptions;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.GroundOverlay;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.MyTrafficStyle;
import com.amap.api.maps.model.NavigateArrow;
import com.amap.api.maps.model.NavigateArrowOptions;
import com.amap.api.maps.model.Poi;
import com.amap.api.maps.model.Polygon;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.RuntimeRemoteException;
import com.amap.api.maps.model.TileOverlay;
import com.amap.api.maps.model.TileOverlayOptions;
import java.util.ArrayList;
import java.util.List;

public final class AMap {
    public static final int LOCATION_TYPE_LOCATE = 1;
    public static final int LOCATION_TYPE_MAP_FOLLOW = 2;
    public static final int LOCATION_TYPE_MAP_ROTATE = 3;
    public static final int MAP_TYPE_NIGHT = 3;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    private final t a;
    private UiSettings b;
    private Projection c;
    private MyTrafficStyle d;

    public interface CancelableCallback {
        void onCancel();

        void onFinish();
    }

    public interface OnMapLoadedListener {
        void onMapLoaded();
    }

    public interface OnMapTouchListener {
        void onTouch(MotionEvent motionEvent);
    }

    public interface OnMapScreenShotListener {
        void onMapScreenShot(Bitmap bitmap);
    }

    public interface OnMyLocationChangeListener {
        void onMyLocationChange(Location location);
    }

    public interface InfoWindowAdapter {
        View getInfoContents(Marker marker);

        View getInfoWindow(Marker marker);
    }

    public interface OnCacheRemoveListener {
        void onRemoveCacheFinish(boolean z);
    }

    public interface OnCameraChangeListener {
        void onCameraChange(CameraPosition cameraPosition);

        void onCameraChangeFinish(CameraPosition cameraPosition);
    }

    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(Marker marker);
    }

    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);
    }

    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    public interface OnPOIClickListener {
        void onPOIClick(Poi poi);
    }

    public interface onMapPrintScreenListener {
        void onMapPrint(Drawable drawable);
    }

    protected AMap(t tVar) {
        this.a = tVar;
    }

    public static String getVersion() {
        return "V2.4.1";
    }

    public final Arc addArc(ArcOptions arcOptions) {
        try {
            return new Arc(this.a.a(arcOptions));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Circle addCircle(CircleOptions circleOptions) {
        try {
            return new Circle(this.a.a(circleOptions));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) {
        try {
            return new GroundOverlay(this.a.a(groundOverlayOptions));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Marker addMarker(MarkerOptions markerOptions) {
        try {
            return this.a.a(markerOptions);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final ArrayList<Marker> addMarkers(ArrayList<MarkerOptions> arrayList, boolean z) {
        try {
            return this.a.a((ArrayList) arrayList, z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final NavigateArrow addNavigateArrow(NavigateArrowOptions navigateArrowOptions) {
        try {
            return new NavigateArrow(this.a.a(navigateArrowOptions));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polygon addPolygon(PolygonOptions polygonOptions) {
        try {
            return new Polygon(this.a.a(polygonOptions));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polyline addPolyline(PolylineOptions polylineOptions) {
        try {
            return new Polyline(this.a.a(polylineOptions));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions) {
        try {
            return this.a.a(tileOverlayOptions);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate) {
        try {
            this.a.b(cameraUpdate.a());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate, long j, CancelableCallback cancelableCallback) {
        try {
            e.b(j > 0, "durationMs must be positive");
            this.a.a(cameraUpdate.a(), j, cancelableCallback);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate, CancelableCallback cancelableCallback) {
        try {
            this.a.a(cameraUpdate.a(), cancelableCallback);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void clear() {
        try {
            this.a.p();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final CameraPosition getCameraPosition() {
        try {
            return this.a.l();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getMapPrintScreen(onMapPrintScreenListener com_amap_api_maps_AMap_onMapPrintScreenListener) {
        this.a.a(com_amap_api_maps_AMap_onMapPrintScreenListener);
    }

    public final List<Marker> getMapScreenMarkers() {
        try {
            return this.a.G();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getMapScreenShot(OnMapScreenShotListener onMapScreenShotListener) {
        this.a.a(onMapScreenShotListener);
    }

    public final int getMapTextZIndex() {
        try {
            return this.a.L();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int getMapType() {
        try {
            return this.a.q();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMaxZoomLevel() {
        return this.a.m();
    }

    public final float getMinZoomLevel() {
        return this.a.n();
    }

    public final Location getMyLocation() {
        try {
            return this.a.t();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public MyTrafficStyle getMyTrafficStyle() {
        return this.d;
    }

    public final Projection getProjection() {
        try {
            if (this.c == null) {
                this.c = new Projection(this.a.v());
            }
            return this.c;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getScalePerPixel() {
        try {
            return this.a.E();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final UiSettings getUiSettings() {
        try {
            if (this.b == null) {
                this.b = new UiSettings(this.a.u());
            }
            return this.b;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isMyLocationEnabled() {
        try {
            return this.a.s();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isTrafficEnabled() {
        try {
            return this.a.r();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void moveCamera(CameraUpdate cameraUpdate) {
        try {
            this.a.a(cameraUpdate.a());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void removecache() {
        try {
            this.a.O();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void removecache(OnCacheRemoveListener onCacheRemoveListener) {
        try {
            this.a.a(onCacheRemoveListener);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void runOnDrawFrame() {
        this.a.e(false);
    }

    public void setCustomRenderer(CustomRenderer customRenderer) {
        try {
            this.a.a(customRenderer);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setInfoWindowAdapter(InfoWindowAdapter infoWindowAdapter) {
        try {
            this.a.a(infoWindowAdapter);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setLoadOfflineData(boolean z) {
        try {
            this.a.l(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setLocationSource(LocationSource locationSource) {
        try {
            this.a.a(locationSource);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setMapTextZIndex(int i) {
        try {
            this.a.g(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setMapType(int i) {
        try {
            this.a.b(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setMyLocationEnabled(boolean z) {
        try {
            this.a.h(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setMyLocationRotateAngle(float f) {
        try {
            this.a.a(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setMyLocationStyle(MyLocationStyle myLocationStyle) {
        try {
            this.a.a(myLocationStyle);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setMyLocationType(int i) {
        try {
            this.a.a(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setMyTrafficStyle(MyTrafficStyle myTrafficStyle) {
        try {
            this.d = myTrafficStyle;
            this.a.a(myTrafficStyle.getSmoothColor(), myTrafficStyle.getSlowColor(), myTrafficStyle.getCongestedColor(), myTrafficStyle.getSeriousCongestedColor());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) {
        try {
            this.a.a(onCameraChangeListener);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener) {
        try {
            this.a.a(onInfoWindowClickListener);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnMapClickListener(OnMapClickListener onMapClickListener) {
        try {
            this.a.a(onMapClickListener);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnMapLoadedListener(OnMapLoadedListener onMapLoadedListener) {
        try {
            this.a.a(onMapLoadedListener);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) {
        try {
            this.a.a(onMapLongClickListener);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnMapTouchListener(OnMapTouchListener onMapTouchListener) {
        try {
            this.a.a(onMapTouchListener);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        try {
            this.a.a(onMarkerClickListener);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnMarkerDragListener(OnMarkerDragListener onMarkerDragListener) {
        try {
            this.a.a(onMarkerDragListener);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnMyLocationChangeListener(OnMyLocationChangeListener onMyLocationChangeListener) {
        try {
            this.a.a(onMyLocationChangeListener);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnPOIClickListener(OnPOIClickListener onPOIClickListener) {
        try {
            this.a.a(onPOIClickListener);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPointToCenter(int i, int i2) {
        try {
            this.a.a(i, i2);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setTrafficEnabled(boolean z) {
        try {
            this.a.f(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void showMapText(boolean z) {
        try {
            this.a.g(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void stopAnimation() {
        try {
            this.a.o();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
