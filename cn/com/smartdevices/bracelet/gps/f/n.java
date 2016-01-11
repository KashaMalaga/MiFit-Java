package cn.com.smartdevices.bracelet.gps.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v4.view.C0151az;
import android.support.v4.view.a.C0113o;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.model.c;
import cn.com.smartdevices.bracelet.gps.model.g;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMap.CancelableCallback;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.GroundOverlay;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.LatLngBounds.Builder;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.WeightedLatLng;
import com.amap.api.maps.overlay.WalkRouteOverlay;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.WalkPath;
import com.amap.api.services.route.WalkStep;
import com.edmodo.cropper.cropwindow.CropOverlayView;
import com.xiaomi.hm.health.b.a.h;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

@SuppressLint({"Assert"})
public class n implements r, s {
    private static final int A = 40;
    private static final int B = 11;
    private static final int C = 21;
    private static final double E = 5.0d;
    private static final double F = 5.0d;
    private static final float a = 1.0f;
    private static final float b = 16.0f;
    private int D = A;
    private final float c = 90.0f;
    private AMap d = null;
    private p e = null;
    private Builder f = null;
    private Polyline g = null;
    private CameraPosition.Builder h = null;
    private LatLng i = null;
    private WeakReference<Context> j = null;
    private MarkerOptions k = null;
    private Marker l = null;
    private GroundOverlay m = null;
    private Marker n = null;
    private List<GroundOverlay> o = null;
    private Marker p = null;
    private c q = null;
    private float r = 18.0f;
    private z s = null;
    private Marker t = null;
    private float u = 0.0f;
    private WalkRouteOverlay v = null;
    private Marker w = null;
    private List<Marker> x = null;
    private final GroundOverlay y = null;
    private CameraPosition.Builder z = null;

    public n(Context context, AMap aMap) {
        this.d = aMap;
        this.o = new ArrayList();
        this.x = new ArrayList();
        this.j = new WeakReference(context);
        this.f = new Builder();
        this.r *= a;
        this.s = new z(new q());
        this.g = null;
        l();
        k();
    }

    private int a(float f, float f2, float f3) {
        if (f == f2) {
            return Color.argb(HeartRateInfo.HR_EMPTY_VALUE, 0, 158, 224);
        }
        int i = f3 == f2 ? 125 : 0;
        i = Color.HSVToColor(new float[]{(float) i, CropOverlayView.a, CropOverlayView.a});
        Color.red(i);
        Color.green(i);
        Color.blue(i);
        if (f3 == f) {
            i = (int) (90.0f / (f3 / ((f + f2) / 2.0f)));
        } else {
            i = (int) (90.0f / (f3 / ((f + f2) / 2.0f)));
        }
        i = (int) (((float) i) >= 10.0f ? (float) i : 10.0f);
        return (int) (((float) i) <= 125.0f ? (float) i : 125.0f);
    }

    private BitmapDescriptor a(Object obj) {
        return BitmapDescriptorFactory.defaultMarker(0.0f);
    }

    private MarkerOptions a(c cVar, int i) {
        BitmapDescriptor fromResource;
        switch (i) {
            case a.i /*0*/:
                fromResource = BitmapDescriptorFactory.fromResource(h.running_location);
                break;
            case l.a /*1*/:
                fromResource = BitmapDescriptorFactory.fromResource(h.running_detail_star);
                break;
            case a.k /*2*/:
                fromResource = BitmapDescriptorFactory.fromResource(h.running_detail_pause);
                break;
            case a.l /*3*/:
                fromResource = BitmapDescriptorFactory.fromResource(h.running_detail_end);
                break;
            default:
                try {
                    throw new IllegalArgumentException();
                } catch (Exception e) {
                    C0596r.d("Run", e.getMessage());
                    return null;
                }
        }
        MarkerOptions markerOptions = new MarkerOptions();
        if (cVar != null) {
            markerOptions.position(cn.com.smartdevices.bracelet.gps.h.a.a(cVar));
        }
        markerOptions.icon(fromResource);
        markerOptions.setFlat(false);
        return markerOptions;
    }

    private void a(LatLngBounds latLngBounds, u uVar) {
        CancelableCallback cancelableCallback = null;
        if (uVar != null) {
            cancelableCallback = new o(this, uVar);
        }
        this.d.animateCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds, 30), cancelableCallback);
    }

    private void a(List<c> list, g gVar, int i) {
        List arrayList = new ArrayList(i - 1);
        int i2 = 0;
        Object obj = null;
        for (c cVar : list) {
            int b = cVar.b();
            arrayList.add(cVar);
            i2++;
            if (b == 3 || b == 2) {
                if (obj == 2 && b == 3 && i2 > 1) {
                    f(cVar);
                    arrayList.clear();
                    arrayList.add(cVar);
                    obj = null;
                } else {
                    if (i2 < i) {
                        f(cVar);
                    }
                    a(arrayList, gVar);
                    arrayList.clear();
                    if (b == 2) {
                        obj = 2;
                    } else {
                        arrayList.add(cVar);
                        obj = null;
                    }
                }
            } else if (obj == 2 && i2 != i) {
                f(cVar);
                arrayList.clear();
                arrayList.add(cVar);
                obj = null;
            } else if (i2 == i) {
                a(arrayList, gVar);
                arrayList.clear();
            }
        }
    }

    private void b(boolean z) {
        this.d.getUiSettings().setMyLocationButtonEnabled(z);
        this.d.setMyLocationEnabled(z);
    }

    private void d(List<c> list) {
        if (list != null) {
            for (c h : list) {
                h(h);
            }
        }
    }

    private void h(c cVar) {
        if (this.e == null) {
            this.e = new p(this, cVar);
        }
        if (cVar.p > this.e.b.p) {
            this.e.b.p = cVar.p;
            this.e.a = true;
        } else if (cVar.p > this.e.c.p) {
            this.e.c.p = cVar.p;
            this.e.a = true;
        } else if (cVar.p < this.e.d.p) {
            this.e.d.p = cVar.p;
            this.e.a = true;
        } else if (cVar.p < this.e.e.p) {
            this.e.e.p = cVar.p;
            this.e.a = true;
        }
        if (cVar.q > this.e.b.q) {
            this.e.b.q = cVar.q;
            this.e.a = true;
        } else if (cVar.q > this.e.d.q) {
            this.e.d.q = cVar.q;
            this.e.a = true;
        } else if (cVar.q < this.e.c.q) {
            this.e.c.q = cVar.q;
            this.e.a = true;
        } else if (cVar.q < this.e.e.q) {
            this.e.e.q = cVar.q;
            this.e.a = true;
        }
    }

    private int i() {
        return Color.argb(HeartRateInfo.HR_EMPTY_VALUE, 0, HeartRateInfo.HR_EMPTY_VALUE, 0);
    }

    private boolean i(c cVar) {
        if (this.t != null) {
            return false;
        }
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        myLocationStyle.strokeColor(C0151az.s);
        myLocationStyle.radiusFillColor(Color.argb(100, 0, 0, cn.com.smartdevices.bracelet.gps.c.a.i));
        myLocationStyle.myLocationIcon(BitmapDescriptorFactory.fromResource(h.running_gps_map_location_marker));
        myLocationStyle.strokeWidth(0.1f);
        this.d.setMyLocationStyle(myLocationStyle);
        this.d.setMyLocationRotateAngle(BitmapDescriptorFactory.HUE_CYAN);
        this.d.getUiSettings().setMyLocationButtonEnabled(false);
        this.d.animateCamera(CameraUpdateFactory.newCameraPosition(this.z.target(cn.com.smartdevices.bracelet.gps.h.a.a(cVar)).build()));
        this.d.setMyLocationEnabled(true);
        this.d.setMyLocationType(1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(BitmapDescriptorFactory.fromResource(h.running_gps_map_cur_location_point1));
        arrayList.add(BitmapDescriptorFactory.fromResource(h.running_gps_map_cur_location_point2));
        this.t = this.d.addMarker(new MarkerOptions().anchor(0.5f, 0.5f).icons(arrayList).period(50));
        return true;
    }

    private int j() {
        return Color.rgb(C0113o.h, C0113o.h, C0113o.h);
    }

    private void j(c cVar) {
        if (cVar != null) {
            if (this.l != null) {
                this.l.remove();
                this.l.destroy();
                this.l = null;
            }
            this.k.position(cn.com.smartdevices.bracelet.gps.h.a.a(cVar));
            this.l = this.d.addMarker(this.k);
            this.l.setAnchor(0.5f, 0.5f);
            if (this.d.getCameraPosition().zoom < this.u) {
                this.h.zoom(this.u);
            } else {
                this.h.zoom(this.d.getCameraPosition().zoom);
            }
            this.d.animateCamera(CameraUpdateFactory.newCameraPosition(this.h.target(cn.com.smartdevices.bracelet.gps.h.a.a(cVar)).build()));
        }
    }

    private void k() {
        this.u = this.d.getMaxZoomLevel();
        if (this.u >= 10.0f) {
            this.u -= 3.0f;
        }
        this.z = new CameraPosition.Builder().zoom(this.u).bearing(0.0f).tilt(0.0f);
        this.h = new CameraPosition.Builder().bearing(0.0f).tilt(0.0f);
    }

    private void k(c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException();
        } else if (this.q != null && this.q.d() == cVar.d()) {
            if (this.p != null) {
                this.p.setPosition(cn.com.smartdevices.bracelet.gps.h.a.a(cVar));
                return;
            }
            MarkerOptions a = a(cVar, 2);
            if (a != null) {
                this.p = this.d.addMarker(a);
                this.p.setAnchor(0.5f, 0.5f);
                this.q = cVar;
            }
        }
    }

    private void l() {
        this.k = a(null, 0);
    }

    private void m() {
        if (this.g != null) {
            this.g.remove();
            this.g = null;
        }
    }

    public Polyline a(c cVar, c cVar2, g gVar) {
        if (cVar == null || cVar2 == null) {
            return null;
        }
        List arrayList = new ArrayList(2);
        arrayList.add(cVar);
        arrayList.add(cVar2);
        return a(arrayList, gVar);
    }

    public Polyline a(List<c> list, g gVar) {
        if (list == null || list.size() < 2) {
            return null;
        }
        PolylineOptions polylineOptions = new PolylineOptions();
        polylineOptions.addAll(cn.com.smartdevices.bracelet.gps.h.a.a((List) list));
        int i = this.D;
        this.D = i + 1;
        polylineOptions.zIndex((float) i);
        polylineOptions.width(this.r);
        if (gVar != null) {
            polylineOptions.color(gVar.f ? j() : i());
        } else {
            polylineOptions.color(i());
        }
        Polyline addPolyline = this.d.addPolyline(polylineOptions);
        if (list != null && list.size() > 0) {
            for (c a : list) {
                this.f.include(cn.com.smartdevices.bracelet.gps.h.a.a(a));
            }
        }
        return addPolyline;
    }

    public void a() {
        this.d.clear();
    }

    public void a(float f) {
        this.r = f;
    }

    public void a(int i) {
        if (this.y != null) {
            this.y.setVisible(false);
        }
    }

    public void a(int i, c cVar) {
    }

    public void a(u uVar) {
        if (this.f != null) {
            try {
                a(this.f.build(), uVar);
            } catch (Exception e) {
                C0596r.a("Run", e.getMessage());
            }
        }
    }

    public void a(c cVar) {
        if (cVar != null && this.j != null) {
            Context context = (Context) this.j.get();
            if (context != null) {
                if (this.d.getCameraPosition().target == null) {
                    LatLng latLng = this.i;
                }
                if (this.m != null) {
                    this.m.remove();
                    this.m = null;
                }
                Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), h.running_gps_map_dark_background);
                Builder builder = new Builder();
                builder.include(new LatLng(-90.0d, -180.0d)).include(new LatLng(-90.0d, 180.0d)).include(new LatLng(90.0d, -180.0d)).include(new LatLng(90.0d, 180.0d));
                LatLngBounds build = builder.build();
                GroundOverlayOptions groundOverlayOptions = new GroundOverlayOptions();
                BitmapDescriptor fromBitmap = BitmapDescriptorFactory.fromBitmap(decodeResource);
                groundOverlayOptions.anchor(0.5f, 0.5f);
                groundOverlayOptions.zIndex(21.0f);
                groundOverlayOptions.positionFromBounds(b(1, cVar));
                groundOverlayOptions.image(fromBitmap);
                this.m = this.d.addGroundOverlay(groundOverlayOptions);
                this.m.setPositionFromBounds(build);
                decodeResource.recycle();
            }
        }
    }

    public void a(List<c> list) {
        Builder builder = new Builder();
        for (c cVar : list) {
            builder.include(new LatLng(cVar.p, cVar.q));
        }
        LatLngBounds build = builder.build();
        double d = build.northeast.longitude + F;
        if (d > 179.0d) {
            d = 179.0d;
        }
        double d2 = build.northeast.latitude + F;
        if (d2 > 90.0d) {
            d2 = 90.0d;
        }
        double d3 = build.southwest.longitude - F;
        if (d3 < -179.0d) {
            d3 = -179.0d;
        }
        double d4 = build.southwest.latitude - F;
        if (d4 < -90.0d) {
            d4 = -90.0d;
        }
        this.d.addPolygon(new PolygonOptions().add(new LatLng(d2, d3)).add(new LatLng(d2, d)).add(new LatLng(d4, d)).add(new LatLng(d4, d3)).fillColor(1996488704).strokeWidth(0.0f).zIndex(21.0f));
        this.d.setMapTextZIndex(B);
    }

    public void a(List<c> list, u uVar) {
        if (list != null) {
            Builder builder = new Builder();
            for (c a : list) {
                builder.include(cn.com.smartdevices.bracelet.gps.h.a.a(a));
            }
            try {
                a(builder.build(), uVar);
            } catch (Exception e) {
                C0596r.a("Run", e.getMessage());
            }
        }
    }

    public void a(boolean z) {
        Iterator it = this.o.iterator();
        if (it.hasNext()) {
            while (it.hasNext()) {
                try {
                    ((GroundOverlay) it.next()).setVisible(z);
                } catch (Exception e) {
                    C0596r.a("Run", e.getMessage());
                }
            }
            return;
        }
        for (Marker visible : this.x) {
            try {
                visible.setVisible(z);
            } catch (Exception e2) {
                C0596r.a("Run", e2.getMessage());
            }
        }
    }

    public LatLngBounds b(int i, c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException();
        }
        LatLonPoint b = cn.com.smartdevices.bracelet.gps.h.a.b(cVar);
        Builder builder = new Builder();
        builder.include(new LatLng(b.getLatitude() - WeightedLatLng.DEFAULT_INTENSITY, b.getLongitude() - WeightedLatLng.DEFAULT_INTENSITY));
        builder.include(new LatLng(b.getLatitude() - WeightedLatLng.DEFAULT_INTENSITY, b.getLongitude() + WeightedLatLng.DEFAULT_INTENSITY));
        builder.include(new LatLng(b.getLatitude() + WeightedLatLng.DEFAULT_INTENSITY, b.getLongitude() - WeightedLatLng.DEFAULT_INTENSITY));
        builder.include(new LatLng(b.getLatitude() + WeightedLatLng.DEFAULT_INTENSITY, b.getLongitude() + WeightedLatLng.DEFAULT_INTENSITY));
        return builder.build();
    }

    public void b() {
    }

    public void b(int i) {
    }

    public void b(c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException();
        }
        LatLng a = cn.com.smartdevices.bracelet.gps.h.a.a(cVar);
        BitmapDescriptor a2 = a(null);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(a);
        markerOptions.draggable(true);
        markerOptions.icon(a2);
        markerOptions.setFlat(false);
        markerOptions.anchor(0.5f, a);
        this.x.add(this.d.addMarker(markerOptions));
    }

    public void b(c cVar, c cVar2, g gVar) {
    }

    public void b(List<c> list) {
        if (list != null && list.size() != 0 && this.j != null) {
            Context context = (Context) this.j.get();
            if (context != null) {
                List c = cn.com.smartdevices.bracelet.gps.h.a.c((List) list);
                WalkStep walkStep = new WalkStep();
                walkStep.setPolyline(c);
                WalkPath walkPath = new WalkPath();
                List arrayList = new ArrayList();
                arrayList.add(walkStep);
                walkPath.setSteps(arrayList);
                int size = c.size();
                if (this.v != null) {
                    this.v.removeFromMap();
                }
                this.v = new WalkRouteOverlay(context, this.d, walkPath, (LatLonPoint) c.get(0), (LatLonPoint) c.get(size - 1));
                this.v.addToMap();
            }
        }
    }

    public void b(List<c> list, g gVar) {
        int size = list.size();
        if (size > 0) {
            if (gVar.g) {
                g((c) list.get(0));
            }
            this.s.a((List) list, gVar);
            if (gVar.h) {
                d((c) list.get(size - 1));
            }
        }
    }

    public void c() {
        Iterator it = this.o.iterator();
        if (it.hasNext()) {
            this.x.clear();
            while (it.hasNext()) {
                ((GroundOverlay) it.next()).remove();
            }
            this.o.clear();
            return;
        }
        this.o.clear();
        for (Marker remove : this.x) {
            remove.remove();
        }
        this.x.clear();
    }

    public void c(int i) {
        this.d.setMapType(1);
    }

    public void c(c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException();
        }
        LatLng a = cn.com.smartdevices.bracelet.gps.h.a.a(cVar.p, cVar.q);
        this.i = a;
        this.d.animateCamera(CameraUpdateFactory.newLatLngZoom(a, b));
    }

    public void c(List<Polyline> list) {
        if (list == null) {
            throw new IllegalStateException("Don't support now");
        }
    }

    public void c(List<c> list, g gVar) {
        if (list != null) {
            int size = list.size();
            if (size >= 1) {
                c cVar = (c) list.get(0);
                if (cVar.d() == 0) {
                    g(cVar);
                }
                j((c) list.get(size - 1));
                this.s.a((List) list, gVar);
            }
        }
    }

    public void d() {
        if (this.o != null) {
            this.o.clear();
        }
        if (this.s != null) {
            this.s.a();
        }
        if (this.g != null) {
            this.g.remove();
            this.g = null;
        }
        if (this.x != null) {
            this.x.clear();
        }
        if (this.d != null) {
            this.d.clear();
        }
    }

    public void d(int i) {
        this.d.animateCamera(CameraUpdateFactory.newLatLngZoom(this.d.getCameraPosition().target, this.d.getCameraPosition().zoom + ((float) i)));
    }

    public void d(c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException();
        }
        MarkerOptions a = a(cVar, 3);
        if (a != null) {
            this.n = this.d.addMarker(a);
            this.n.setAnchor(0.5f, 0.5f);
        }
    }

    public List<GroundOverlay> e() {
        return this.o;
    }

    public void e(c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException();
        }
        i(cVar);
        this.t.setPosition(cn.com.smartdevices.bracelet.gps.h.a.a(cVar));
        this.d.setMyLocationRotateAngle(this.d.getCameraPosition().bearing);
    }

    public List<Polyline> f() {
        return null;
    }

    public void f(c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException();
        }
        MarkerOptions a = a(cVar, 2);
        if (a != null) {
            this.p = this.d.addMarker(a);
            this.p.setAnchor(0.5f, 0.5f);
            this.q = cVar;
        }
    }

    public void g() {
        this.d.clear();
        this.n = null;
    }

    public void g(c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException();
        } else if (this.w != null) {
            this.w.setPosition(cn.com.smartdevices.bracelet.gps.h.a.a(cVar));
        } else {
            b(false);
            MarkerOptions a = a(cVar, 1);
            if (a != null) {
                this.w = this.d.addMarker(a);
                this.w.setAnchor(0.5f, 0.5f);
            }
        }
    }

    public void h() {
        a(null);
    }
}
