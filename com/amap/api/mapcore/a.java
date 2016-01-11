package com.amap.api.mapcore;

import android.content.Context;
import android.graphics.Point;
import android.os.Message;
import com.amap.api.mapcore.util.az;
import com.amap.api.mapcore.util.o;
import com.amap.api.mapcore.util.u;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.WeightedLatLng;
import com.autonavi.amap.mapcore.BaseMapCallImplement;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapCore;
import com.autonavi.amap.mapcore.MapProjection;
import com.xiaomi.hm.health.t;
import javax.microedition.khronos.opengles.GL10;
import kankan.wheel.widget.l;

class a extends BaseMapCallImplement {
    IPoint a = new IPoint();
    float b;
    float c;
    float d;
    IPoint e = new IPoint();
    private AMapDelegateImpGLSurfaceView f;
    private float g = GroundOverlayOptions.NO_DIMENSION;
    private int h;
    private int i;

    /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[a.values().length];

        static {
            try {
                a[a.changeCenter.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[a.changeBearing.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[a.changeBearingGeoCenter.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[a.changeTilt.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[a.changeGeoCenterZoom.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[a.newCameraPosition.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                a[a.zoomIn.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                a[a.zoomOut.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                a[a.zoomTo.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                a[a.zoomBy.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                a[a.scrollBy.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                a[a.newLatLngBounds.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                a[a.newLatLngBoundsWithSize.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                a[a.changeGeoCenterZoomTiltBearing.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
        }
    }

    public a(AMapDelegateImpGLSurfaceView aMapDelegateImpGLSurfaceView) {
        this.f = aMapDelegateImpGLSurfaceView;
    }

    private float a(LatLng latLng, LatLng latLng2, int i, int i2) {
        float b;
        MapProjection c = this.f.c();
        c.setMapAngle(0.0f);
        c.setCameraHeaderAngle(0.0f);
        c.recalculate();
        IPoint iPoint = new IPoint();
        IPoint iPoint2 = new IPoint();
        this.f.b(latLng.latitude, latLng.longitude, iPoint);
        this.f.b(latLng2.latitude, latLng2.longitude, iPoint2);
        double d = (double) (iPoint.x - iPoint2.x);
        double d2 = (double) (iPoint2.y - iPoint.y);
        if (d <= 0.0d) {
            d = WeightedLatLng.DEFAULT_INTENSITY;
        }
        if (d2 <= 0.0d) {
            d2 = WeightedLatLng.DEFAULT_INTENSITY;
        }
        d = Math.log(((double) i) / d) / Math.log(2.0d);
        double min = Math.min(d, Math.log(((double) i2) / d2) / Math.log(2.0d));
        Object obj = Math.abs(min - d) < 1.0E-7d ? 1 : null;
        float b2 = u.b((float) (((double) c.getMapZoomer()) + Math.floor(min)));
        while (true) {
            b = u.b((float) (((double) b2) + 0.1d));
            c.setMapZoomer(b);
            c.recalculate();
            this.f.b(latLng.latitude, latLng.longitude, iPoint);
            this.f.b(latLng2.latitude, latLng2.longitude, iPoint2);
            d = (double) (iPoint.x - iPoint2.x);
            min = (double) (iPoint2.y - iPoint.y);
            if (obj != null) {
                if (d >= ((double) i)) {
                    break;
                }
                if (b < 20.0f) {
                    return b;
                }
                b2 = b;
            } else {
                if (min >= ((double) i2)) {
                    break;
                }
                if (b < 20.0f) {
                    return b;
                }
                b2 = b;
            }
        }
        return (float) (((double) b) - 0.1d);
    }

    private IPoint a(MapProjection mapProjection) {
        return a(mapProjection, this.h, this.i);
    }

    private IPoint a(MapProjection mapProjection, int i, int i2) {
        FPoint fPoint = new FPoint();
        mapProjection.win2Map(i, i2, fPoint);
        IPoint iPoint = new IPoint();
        mapProjection.map2Geo(fPoint.x, fPoint.y, iPoint);
        return iPoint;
    }

    private void a(MapProjection mapProjection, float f) {
        a(mapProjection, f, this.h, this.i);
    }

    private void a(MapProjection mapProjection, float f, int i, int i2) {
        IPoint a = a(mapProjection, i, i2);
        mapProjection.setMapZoomer(f);
        a(mapProjection, a, i, i2);
    }

    private void a(MapProjection mapProjection, k kVar) {
        mapProjection.setMapAngle(kVar.g);
        a(mapProjection, kVar.o);
    }

    private void a(MapProjection mapProjection, IPoint iPoint) {
        a(mapProjection, iPoint, this.h, this.i);
    }

    private void a(MapProjection mapProjection, IPoint iPoint, float f, float f2, float f3) {
        mapProjection.setMapZoomer(f);
        mapProjection.setMapAngle(f2);
        mapProjection.setCameraHeaderAngle(f3);
        a(mapProjection, iPoint);
    }

    private void a(MapProjection mapProjection, IPoint iPoint, int i, int i2) {
        mapProjection.recalculate();
        IPoint a = a(mapProjection, i, i2);
        IPoint iPoint2 = new IPoint();
        mapProjection.getGeoCenter(iPoint2);
        mapProjection.setGeoCenter((iPoint2.x + iPoint.x) - a.x, (iPoint2.y + iPoint.y) - a.y);
    }

    private void b(k kVar) {
        MapCore a = this.f.a();
        MapProjection c = this.f.c();
        LatLngBounds latLngBounds = kVar.i;
        int i = kVar.k;
        int i2 = kVar.l;
        int i3 = kVar.j;
        IPoint iPoint = new IPoint();
        IPoint iPoint2 = new IPoint();
        MapProjection.lonlat2Geo(latLngBounds.northeast.longitude, latLngBounds.northeast.latitude, iPoint);
        MapProjection.lonlat2Geo(latLngBounds.southwest.longitude, latLngBounds.southwest.latitude, iPoint2);
        int i4 = iPoint2.y - iPoint.y;
        int i5 = i - (i3 * 2);
        i = i2 - (i3 * 2);
        if (iPoint.x - iPoint2.x >= 0 || i4 >= 0) {
            if (i5 <= 0) {
                i5 = 1;
            }
            if (i <= 0) {
                i = 1;
            }
            float a2 = a(latLngBounds.northeast, latLngBounds.southwest, i5, i);
            i5 = (iPoint.x + iPoint2.x) / 2;
            int i6 = (iPoint.y + iPoint2.y) / 2;
            c.setMapZoomer(a2);
            c.setGeoCenter(i5, i6);
            c.setCameraHeaderAngle(0.0f);
            c.setMapAngle(0.0f);
            a.setMapstate(c);
        }
    }

    private void b(MapProjection mapProjection, k kVar) {
        mapProjection.setMapZoomer(kVar.d);
        a(mapProjection, kVar.o);
    }

    private void c(MapProjection mapProjection, k kVar) {
        IPoint a = a(mapProjection);
        mapProjection.setCameraHeaderAngle(kVar.f);
        a(mapProjection, a);
    }

    private void d(MapProjection mapProjection, k kVar) {
        IPoint a = a(mapProjection);
        mapProjection.setMapAngle(kVar.g);
        a(mapProjection, a);
    }

    public void OnMapDestory(GL10 gl10, MapCore mapCore) {
        super.OnMapDestory(mapCore);
    }

    public void OnMapLoaderError(int i) {
        o.a("MapCore", "OnMapLoaderError=" + i, 112);
    }

    public void OnMapProcessEvent(MapCore mapCore) {
        float f = 0.0f;
        if (this.f != null && this.f.J()) {
            this.f.K();
        }
        if (this.f != null) {
            float z = this.f.z();
            a(mapCore);
            while (true) {
                aj a = this.f.a.a();
                if (a == null) {
                    break;
                }
                if (a.a == 2) {
                    if (a.a()) {
                        mapCore.setParameter(2010, 4, 0, 0, 0);
                    } else {
                        mapCore.setParameter(2010, 0, 0, 0, 0);
                    }
                }
                if (a.a == 2011) {
                    if (a.b) {
                        mapCore.setParameter(2011, 3, 0, 0, 0);
                    } else {
                        mapCore.setParameter(2011, 0, 0, 0, 0);
                    }
                } else if (a.a == 2012) {
                    this.f.k(a.b);
                }
            }
            mapCore.setMapstate(this.f.c());
            if (!(this.b < this.f.n() || this.g == z || this.f.i == null)) {
                this.f.i.obtainMessage(21).sendToTarget();
            }
            f = z;
        }
        this.g = f;
    }

    public void OnMapReferencechanged(MapCore mapCore, String str, String str2) {
        try {
            if (this.f.u().c()) {
                this.f.e();
            }
            if (this.f.u().a()) {
                this.f.f();
            }
            this.f.j(true);
        } catch (Throwable e) {
            az.a(e, "AMapCallback", "OnMapReferencechanged");
            e.printStackTrace();
        }
        this.f.P();
    }

    public void OnMapSufaceChanged(GL10 gl10, MapCore mapCore, int i, int i2) {
    }

    public void OnMapSurfaceCreate(GL10 gl10, MapCore mapCore) {
        super.OnMapSurfaceCreate(mapCore);
    }

    public void OnMapSurfaceRenderer(GL10 gl10, MapCore mapCore, int i) {
        if (i == 3) {
            this.f.g.a(gl10, true, this.f.L());
            if (this.f.f != null) {
                this.f.f.onDrawFrame(gl10);
            }
        }
    }

    public void a(int i, int i2) {
        this.h = i;
        this.i = i2;
    }

    void a(k kVar) {
        MapCore a = this.f.a();
        MapProjection c = this.f.c();
        kVar.d = this.f.b(kVar.d);
        kVar.f = u.a(kVar.f);
        float b;
        switch (AnonymousClass1.a[kVar.a.ordinal()]) {
            case l.a /*1*/:
                if (kVar.n) {
                    a(c, kVar.o);
                } else {
                    c.setGeoCenter(kVar.o.x, kVar.o.y);
                }
                a.setMapstate(c);
                return;
            case kankan.wheel.widget.a.k /*2*/:
                if (kVar.n) {
                    d(c, kVar);
                } else {
                    c.setMapAngle(kVar.g);
                }
                a.setMapstate(c);
                return;
            case kankan.wheel.widget.a.l /*3*/:
                if (kVar.n) {
                    a(c, kVar);
                } else {
                    c.setMapAngle(kVar.g);
                    c.setGeoCenter(kVar.o.x, kVar.o.y);
                }
                a.setMapstate(c);
                return;
            case kankan.wheel.widget.a.aQ /*4*/:
                if (kVar.n) {
                    c(c, kVar);
                } else {
                    c.setCameraHeaderAngle(kVar.f);
                }
                a.setMapstate(c);
                return;
            case kankan.wheel.widget.a.X /*5*/:
                if (kVar.n) {
                    b(c, kVar);
                } else {
                    c.setGeoCenter(kVar.o.x, kVar.o.y);
                    c.setMapZoomer(kVar.d);
                }
                a.setMapstate(c);
                return;
            case kankan.wheel.widget.a.bt /*6*/:
                LatLng latLng = kVar.h.target;
                IPoint iPoint = new IPoint();
                MapProjection.lonlat2Geo(latLng.longitude, latLng.latitude, iPoint);
                float b2 = u.b(kVar.h.zoom);
                float f = kVar.h.bearing;
                float a2 = u.a(kVar.h.tilt);
                if (kVar.n) {
                    a(c, iPoint, b2, f, a2);
                } else {
                    c.setGeoCenter(iPoint.x, iPoint.y);
                    c.setMapZoomer(b2);
                    c.setMapAngle(f);
                    c.setCameraHeaderAngle(a2);
                }
                a.setMapstate(c);
                return;
            case kankan.wheel.widget.a.bc /*7*/:
                b = this.f.b(c.getMapZoomer() + 1.0f);
                if (kVar.n) {
                    a(c, b);
                } else {
                    c.setMapZoomer(b);
                }
                a.setMapstate(c);
                return;
            case kankan.wheel.widget.a.ba /*8*/:
                b = this.f.b(c.getMapZoomer() - 1.0f);
                if (kVar.n) {
                    a(c, b);
                } else {
                    c.setMapZoomer(b);
                }
                c.setMapZoomer(b);
                a.setMapstate(c);
                return;
            case kankan.wheel.widget.a.bo /*9*/:
                b = kVar.d;
                if (kVar.n) {
                    a(c, b);
                } else {
                    c.setMapZoomer(b);
                }
                a.setMapstate(c);
                return;
            case kankan.wheel.widget.a.bd /*10*/:
                b = this.f.b(c.getMapZoomer() + kVar.e);
                Point point = kVar.m;
                if (point != null) {
                    a(c, b, point.x, point.y);
                } else if (kVar.n) {
                    a(c, b);
                } else {
                    c.setMapZoomer(b);
                }
                a.setMapstate(c);
                return;
            case kankan.wheel.widget.a.aW /*11*/:
                b = kVar.b;
                b += ((float) this.f.getWidth()) / 2.0f;
                float height = kVar.c + (((float) this.f.getHeight()) / 2.0f);
                IPoint iPoint2 = new IPoint();
                this.f.a((int) b, (int) height, iPoint2);
                c.setGeoCenter(iPoint2.x, iPoint2.y);
                a.setMapstate(c);
                return;
            case kankan.wheel.widget.a.be /*12*/:
                kVar.a = a.newLatLngBoundsWithSize;
                kVar.k = this.f.getWidth();
                kVar.l = this.f.getHeight();
                b(kVar);
                return;
            case t.WeightView_wv_bmi_size /*13*/:
                b(kVar);
                return;
            case t.WeightView_wv_tips /*14*/:
                if (kVar.n) {
                    a(c, kVar.o, kVar.d, kVar.g, kVar.f);
                } else {
                    c.setGeoCenter(kVar.o.x, kVar.o.y);
                    c.setMapZoomer(kVar.d);
                    c.setMapAngle(kVar.g);
                    c.setCameraHeaderAngle(kVar.f);
                }
                a.setMapstate(c);
                return;
            default:
                a.setMapstate(c);
                return;
        }
    }

    void a(MapCore mapCore) {
        Object obj = null;
        MapProjection c = this.f.c();
        float mapZoomer = c.getMapZoomer();
        float cameraHeaderAngle = c.getCameraHeaderAngle();
        float mapAngle = c.getMapAngle();
        c.getGeoCenter(this.e);
        int i = 0;
        while (true) {
            k c2 = this.f.a.c();
            if (c2 == null) {
                break;
            }
            try {
                a(c2);
                i |= c2.p;
            } catch (Throwable e) {
                az.a(e, "AMapCallback", "runMessage");
                e.printStackTrace();
            }
        }
        this.b = c.getMapZoomer();
        this.c = c.getCameraHeaderAngle();
        this.d = c.getMapAngle();
        c.getGeoCenter(this.a);
        if (!(mapZoomer == this.b && this.c == cameraHeaderAngle && this.d == mapAngle && this.a.x == this.e.x && this.a.y == this.e.y)) {
            obj = 1;
        }
        if (obj != null) {
            try {
                this.f.e(false);
                if (this.f.w() != null) {
                    DPoint dPoint = new DPoint();
                    MapProjection.geo2LonLat(this.a.x, this.a.y, dPoint);
                    this.f.a(new CameraPosition(new LatLng(dPoint.y, dPoint.x), this.b, this.c, this.d));
                }
                this.f.A();
            } catch (Throwable e2) {
                az.a(e2, "AMapCallback", "runMessage cameraChange");
                e2.printStackTrace();
                return;
            }
        }
        this.f.e(true);
        if (i != 0) {
            if (i != 0) {
                this.f.j(true);
            } else {
                this.f.j(false);
            }
            Message message = new Message();
            message.what = 17;
            this.f.i.sendMessage(message);
        }
        if (!(this.c == cameraHeaderAngle && this.d == mapAngle) && this.f.u().c()) {
            this.f.e();
        }
        if (mapZoomer != this.b && this.f.u().a()) {
            this.f.f();
        }
    }

    public Context getContext() {
        return this.f.getContext();
    }

    public String getMapSvrAddress() {
        return "http://mm.amap.com";
    }

    public boolean isMapEngineValid() {
        return this.f.a() != null ? this.f.a().isMapEngineValid() : false;
    }

    public void onSetParameter(MapCore mapCore) {
        this.f.e(false);
    }
}
