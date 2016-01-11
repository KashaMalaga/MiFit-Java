package com.amap.api.mapcore;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.RemoteException;
import android.support.v4.view.C0151az;
import android.util.Log;
import com.amap.api.mapcore.util.az;
import com.amap.api.mapcore.util.u;
import com.amap.api.maps.AMapNativeRenderer;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.LatLngBounds.Builder;
import com.amap.api.maps.model.WeightedLatLng;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.f.a.b.d.a;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;

class at implements ac {
    private Bitmap A = null;
    private boolean B;
    float a;
    float b;
    float c;
    float d;
    float[] e;
    private t f;
    private float g = 10.0f;
    private int h = C0151az.s;
    private float i = 0.0f;
    private boolean j = true;
    private String k;
    private ArrayList<IPoint> l = new ArrayList();
    private FloatBuffer m;
    private int n = 0;
    private boolean o = false;
    private boolean p = false;
    private List<LatLng> q = new ArrayList();
    private boolean r = false;
    private float s = 0.0f;
    private Object t = new Object();
    private boolean u = true;
    private LatLngBounds v = null;
    private boolean w;
    private int x = 0;
    private boolean y = true;
    private boolean z = false;

    public at(t tVar) {
        this.f = tVar;
        try {
            this.k = c();
        } catch (Throwable e) {
            az.a(e, "PolylineDelegateImp", "create");
            e.printStackTrace();
        }
    }

    private boolean o() {
        Boolean valueOf = Boolean.valueOf(false);
        try {
            if (this.f.l().zoom <= 10.0f) {
                return false;
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            Boolean valueOf2;
            if (this.f != null) {
                Rect rect = new Rect(-100, -100, this.f.h() + 100, this.f.i() + 100);
                LatLng latLng = this.v.northeast;
                LatLng latLng2 = this.v.southwest;
                IPoint iPoint = new IPoint();
                this.f.b(latLng.latitude, latLng2.longitude, iPoint);
                IPoint iPoint2 = new IPoint();
                this.f.b(latLng.latitude, latLng.longitude, iPoint2);
                IPoint iPoint3 = new IPoint();
                this.f.b(latLng2.latitude, latLng.longitude, iPoint3);
                IPoint iPoint4 = new IPoint();
                this.f.b(latLng2.latitude, latLng2.longitude, iPoint4);
                valueOf2 = (rect.contains(iPoint.x, iPoint.y) && rect.contains(iPoint2.x, iPoint2.y) && rect.contains(iPoint3.x, iPoint3.y) && rect.contains(iPoint4.x, iPoint4.y)) ? Boolean.valueOf(false) : Boolean.valueOf(true);
            } else {
                valueOf2 = valueOf;
            }
            return valueOf2.booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    public LatLng a(LatLng latLng) {
        int i = 0;
        if (latLng == null) {
            return null;
        }
        if (this.q == null || this.q.size() == 0) {
            return null;
        }
        float f = 0.0f;
        int i2 = 0;
        while (i < this.q.size()) {
            try {
                float calculateLineDistance;
                int i3;
                if (i == 0) {
                    calculateLineDistance = AMapUtils.calculateLineDistance(latLng, (LatLng) this.q.get(i));
                    i3 = i2;
                } else {
                    calculateLineDistance = AMapUtils.calculateLineDistance(latLng, (LatLng) this.q.get(i));
                    if (f > calculateLineDistance) {
                        i3 = i;
                    } else {
                        calculateLineDistance = f;
                        i3 = i2;
                    }
                }
                i++;
                i2 = i3;
                f = calculateLineDistance;
            } catch (Throwable th) {
                az.a(th, "PolylineDelegateImp", "getNearestLatLng");
                th.printStackTrace();
                return null;
            }
        }
        return (LatLng) this.q.get(i2);
    }

    IPoint a(IPoint iPoint, IPoint iPoint2, IPoint iPoint3, double d, int i) {
        IPoint iPoint4 = new IPoint();
        double d2 = (double) (iPoint2.x - iPoint.x);
        double d3 = (double) (iPoint2.y - iPoint.y);
        iPoint4.y = (int) (((((double) i) * d) / Math.sqrt(((d3 * d3) / (d2 * d2)) + WeightedLatLng.DEFAULT_INTENSITY)) + ((double) iPoint3.y));
        iPoint4.x = (int) (((d3 * ((double) (iPoint3.y - iPoint4.y))) / d2) + ((double) iPoint3.x));
        return iPoint4;
    }

    public void a(float f) {
        this.i = f;
        this.f.H();
        this.f.e(false);
    }

    public void a(int i) {
        this.h = i;
        this.a = ((float) Color.alpha(i)) / 255.0f;
        this.b = ((float) Color.red(i)) / 255.0f;
        this.c = ((float) Color.green(i)) / 255.0f;
        this.d = ((float) Color.blue(i)) / 255.0f;
        this.f.e(false);
    }

    public void a(Bitmap bitmap) {
        this.y = false;
        this.z = true;
        this.A = bitmap;
        this.f.e(false);
    }

    void a(LatLng latLng, LatLng latLng2, List<IPoint> list, Builder builder) {
        double abs = (Math.abs(latLng.longitude - latLng2.longitude) * 3.141592653589793d) / 180.0d;
        LatLng latLng3 = new LatLng((latLng2.latitude + latLng.latitude) / 2.0d, (latLng2.longitude + latLng.longitude) / 2.0d, false);
        builder.include(latLng).include(latLng3).include(latLng2);
        int i = latLng3.latitude > 0.0d ? -1 : 1;
        IPoint iPoint = new IPoint();
        this.f.a(latLng.latitude, latLng.longitude, iPoint);
        IPoint iPoint2 = new IPoint();
        this.f.a(latLng2.latitude, latLng2.longitude, iPoint2);
        IPoint iPoint3 = new IPoint();
        this.f.a(latLng3.latitude, latLng3.longitude, iPoint3);
        double cos = Math.cos(0.5d * abs);
        IPoint a = a(iPoint, iPoint2, iPoint3, (Math.hypot((double) (iPoint.x - iPoint2.x), (double) (iPoint.y - iPoint2.y)) * 0.5d) * Math.tan(0.5d * abs), i);
        List arrayList = new ArrayList();
        arrayList.add(iPoint);
        arrayList.add(a);
        arrayList.add(iPoint2);
        a(arrayList, list, cos);
    }

    public void a(List<LatLng> list) {
        try {
            this.q = list;
            this.w = true;
            synchronized (this.t) {
                b((List) list);
            }
            this.w = false;
            this.f.e(false);
            this.w = false;
        } catch (Throwable th) {
            try {
                az.a(th, "PolylineDelegateImp", "setPoints");
                this.l.clear();
                th.printStackTrace();
            } finally {
                this.w = false;
            }
        }
    }

    void a(List<IPoint> list, List<IPoint> list2, double d) {
        if (list.size() == 3) {
            for (int i = 0; i <= 10; i = (int) (((float) i) + 1.0f)) {
                float f = ((float) i) / 10.0f;
                IPoint iPoint = new IPoint();
                double d2 = ((((WeightedLatLng.DEFAULT_INTENSITY - ((double) f)) * (WeightedLatLng.DEFAULT_INTENSITY - ((double) f))) * ((double) ((IPoint) list.get(0)).x)) + (((((double) (2.0f * f)) * (WeightedLatLng.DEFAULT_INTENSITY - ((double) f))) * ((double) ((IPoint) list.get(1)).x)) * d)) + ((double) (((float) ((IPoint) list.get(2)).x) * (f * f)));
                double d3 = ((((WeightedLatLng.DEFAULT_INTENSITY - ((double) f)) * (WeightedLatLng.DEFAULT_INTENSITY - ((double) f))) * ((double) ((IPoint) list.get(0)).y)) + (((((double) (2.0f * f)) * (WeightedLatLng.DEFAULT_INTENSITY - ((double) f))) * ((double) ((IPoint) list.get(1)).y)) * d)) + ((double) (((float) ((IPoint) list.get(2)).y) * (f * f)));
                double d4 = (((WeightedLatLng.DEFAULT_INTENSITY - ((double) f)) * (WeightedLatLng.DEFAULT_INTENSITY - ((double) f))) + ((((double) (2.0f * f)) * (WeightedLatLng.DEFAULT_INTENSITY - ((double) f))) * d)) + ((double) (f * f));
                iPoint.x = (int) (d2 / ((((WeightedLatLng.DEFAULT_INTENSITY - ((double) f)) * (WeightedLatLng.DEFAULT_INTENSITY - ((double) f))) + ((((double) (2.0f * f)) * (WeightedLatLng.DEFAULT_INTENSITY - ((double) f))) * d)) + ((double) (f * f))));
                iPoint.y = (int) (d3 / d4);
                list2.add(iPoint);
            }
        }
    }

    public void a(GL10 gl10) {
        if (this.l != null && this.l.size() != 0 && this.g > 0.0f && !this.w) {
            if (this.p || !this.y) {
                if (o()) {
                    synchronized (this.t) {
                        this.e = u.a(this.f, this.l);
                    }
                    this.n = this.e != null ? this.e.length / 3 : 0;
                    this.B = true;
                } else if (this.B) {
                    g();
                    this.B = false;
                }
            }
            if (this.n == 0) {
                g();
            }
            if (this.e != null && this.n > 0) {
                if (this.u) {
                    float mapLenWithWin;
                    float mapLenWithWin2 = this.f.c().getMapLenWithWin((int) this.g);
                    this.s = this.f.c().getMapZoomer();
                    if (this.n <= a.a || this.s > 10.0f) {
                        mapLenWithWin = this.f.c().getMapLenWithWin(1);
                    } else {
                        mapLenWithWin = this.f.c().getMapLenWithWin((int) ((this.g / 2.0f) + (this.s / 2.0f) <= 10.0f ? (this.g / 2.0f) + (this.s / 2.0f) : 10.0f));
                    }
                    if (this.y) {
                        if (this.p) {
                            this.x = this.f.j();
                        } else {
                            this.x = this.f.b();
                        }
                    } else if (this.z) {
                        if (this.x != 0) {
                            this.f.f(this.x);
                            gl10.glDeleteTextures(1, new int[]{this.x}, 0);
                        }
                        this.x = this.f.F();
                        if (this.x == 0) {
                            int[] iArr = new int[]{0};
                            gl10.glGenTextures(1, iArr, 0);
                            this.x = iArr[0];
                        }
                        if (!(this.A == null || this.A.isRecycled())) {
                            u.a(gl10, this.x, this.A, true);
                        }
                        this.z = false;
                    }
                    AMapNativeRenderer.nativeDrawLineByTextureID(this.e, this.e.length, mapLenWithWin2, this.x, this.b, this.c, this.d, this.a, mapLenWithWin, this.p, this.y);
                } else {
                    if (this.m == null) {
                        this.m = u.a(this.e);
                    }
                    p.a(gl10, 3, this.h, this.m, this.g, this.n);
                }
            }
            this.r = true;
        }
    }

    public void a(boolean z) {
        this.j = z;
        this.f.e(false);
    }

    public boolean a() {
        if (this.v == null) {
            return false;
        }
        LatLngBounds B = this.f.B();
        return B == null ? true : B.contains(this.v) || this.v.intersects(B);
    }

    public boolean a(aa aaVar) {
        return equals(aaVar) || aaVar.c().equals(c());
    }

    public void b() {
        this.f.a(c());
        this.f.e(false);
    }

    public void b(float f) {
        this.g = f;
        this.f.e(false);
    }

    void b(List<LatLng> list) {
        Object arrayList = new ArrayList();
        Builder builder = LatLngBounds.builder();
        if (list != null) {
            LatLng latLng = null;
            for (LatLng latLng2 : list) {
                if (!(latLng2 == null || latLng2.equals(latLng))) {
                    IPoint iPoint;
                    if (!this.o) {
                        iPoint = new IPoint();
                        this.f.a(latLng2.latitude, latLng2.longitude, iPoint);
                        arrayList.add(iPoint);
                        builder.include(latLng2);
                    } else if (latLng != null) {
                        if (Math.abs(latLng2.longitude - latLng.longitude) < 0.01d) {
                            iPoint = new IPoint();
                            this.f.a(latLng.latitude, latLng.longitude, iPoint);
                            arrayList.add(iPoint);
                            builder.include(latLng);
                            iPoint = new IPoint();
                            this.f.a(latLng2.latitude, latLng2.longitude, iPoint);
                            arrayList.add(iPoint);
                            builder.include(latLng2);
                        } else {
                            a(latLng, latLng2, arrayList, builder);
                        }
                    }
                    latLng = latLng2;
                }
            }
        }
        this.l = arrayList;
        this.n = 0;
        if (this.l.size() > 0) {
            this.v = builder.build();
        }
        this.f.e(false);
    }

    public void b(boolean z) {
        this.o = z;
        this.f.e(false);
    }

    public String c() {
        if (this.k == null) {
            this.k = r.a("Polyline");
        }
        return this.k;
    }

    public void c(boolean z) {
        this.p = z;
        this.f.e(false);
    }

    public float d() {
        return this.i;
    }

    public void d(boolean z) {
        this.u = z;
        this.f.e(false);
    }

    public boolean e() {
        return this.j;
    }

    public int f() {
        return super.hashCode();
    }

    public void g() {
        if (!this.w) {
            this.r = false;
            synchronized (this.t) {
                FPoint fPoint = new FPoint();
                this.e = new float[(this.l.size() * 3)];
                Iterator it = this.l.iterator();
                int i = 0;
                while (it.hasNext()) {
                    IPoint iPoint = (IPoint) it.next();
                    this.f.b(iPoint.y, iPoint.x, fPoint);
                    this.e[i * 3] = fPoint.x;
                    this.e[(i * 3) + 1] = fPoint.y;
                    this.e[(i * 3) + 2] = 0.0f;
                    i++;
                }
            }
            if (!this.u) {
                this.m = u.a(this.e);
            }
            this.n = this.l.size();
        }
    }

    public float h() {
        return this.g;
    }

    public int i() {
        return this.h;
    }

    public void j() {
        try {
            if (this.e != null) {
                this.e = null;
            }
            if (this.m != null) {
                this.m.clear();
                this.m = null;
            }
        } catch (Throwable th) {
            az.a(th, "PolylineDelegateImp", "destroy");
            th.printStackTrace();
            Log.d("destroy erro", "PolylineDelegateImp destroy");
        }
    }

    public boolean k() {
        return this.r;
    }

    public List<LatLng> l() {
        return this.q;
    }

    public boolean m() {
        return this.o;
    }

    public boolean n() {
        return this.p;
    }
}
