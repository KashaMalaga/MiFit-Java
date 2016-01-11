package com.amap.api.mapcore;

import android.util.Log;
import com.amap.api.mapcore.util.az;
import com.amap.api.mapcore.util.i;
import com.amap.api.mapcore.util.t;
import com.amap.api.mapcore.util.u;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.LatLngBounds.Builder;
import com.amap.api.services.poisearch.PoiSearch.SearchBound;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import java.nio.FloatBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;

class as implements ab {
    private static float p = 1.0E10f;
    private t a;
    private float b = 0.0f;
    private boolean c = true;
    private String d;
    private float e;
    private int f;
    private int g;
    private List<LatLng> h;
    private CopyOnWriteArrayList<IPoint> i = new CopyOnWriteArrayList();
    private FloatBuffer j;
    private FloatBuffer k;
    private int l = 0;
    private int m = 0;
    private LatLngBounds n = null;
    private boolean o = false;

    public as(t tVar) {
        this.a = tVar;
        try {
            this.d = c();
        } catch (Throwable e) {
            az.a(e, "PolygonDelegateImp", "create");
            e.printStackTrace();
        }
    }

    static FPoint[] a(FPoint[] fPointArr) {
        int i = 0;
        int length = fPointArr.length;
        float[] fArr = new float[(length * 2)];
        for (int i2 = 0; i2 < length; i2++) {
            fArr[i2 * 2] = fPointArr[i2].x * p;
            fArr[(i2 * 2) + 1] = fPointArr[i2].y * p;
        }
        t a = new i().a(fArr);
        length = a.b;
        FPoint[] fPointArr2 = new FPoint[length];
        while (i < length) {
            fPointArr2[i] = new FPoint();
            fPointArr2[i].x = fArr[a.a(i) * 2] / p;
            fPointArr2[i].y = fArr[(a.a(i) * 2) + 1] / p;
            i++;
        }
        return fPointArr2;
    }

    public void a(float f) {
        this.b = f;
        this.a.H();
        this.a.e(false);
    }

    public void a(int i) {
        this.f = i;
        this.a.e(false);
    }

    public void a(List<LatLng> list) {
        this.h = list;
        b((List) list);
        this.a.e(false);
    }

    public void a(GL10 gl10) {
        if (this.i != null && this.i.size() != 0) {
            if (this.j == null || this.k == null || this.l == 0 || this.m == 0) {
                g();
            }
            if (this.j != null && this.k != null && this.l > 0 && this.m > 0) {
                p.a(gl10, this.f, this.g, this.j, this.e, this.k, this.l, this.m);
            }
            this.o = true;
        }
    }

    public void a(boolean z) {
        this.c = z;
        this.a.e(false);
    }

    public boolean a() {
        if (this.n == null) {
            return false;
        }
        LatLngBounds B = this.a.B();
        return B == null ? true : this.n.contains(B) || this.n.intersects(B);
    }

    public boolean a(aa aaVar) {
        return equals(aaVar) || aaVar.c().equals(c());
    }

    public boolean a(LatLng latLng) {
        try {
            return u.a(latLng, l());
        } catch (Throwable th) {
            az.a(th, "PolygonDelegateImp", "contains");
            th.printStackTrace();
            return false;
        }
    }

    public void b() {
        this.a.a(c());
        this.a.e(false);
    }

    public void b(float f) {
        this.e = f;
        this.a.e(false);
    }

    public void b(int i) {
        this.g = i;
        this.a.e(false);
    }

    void b(List<LatLng> list) {
        Builder builder = LatLngBounds.builder();
        this.i.clear();
        if (list != null) {
            Object obj = null;
            for (LatLng latLng : list) {
                if (!latLng.equals(obj)) {
                    IPoint iPoint = new IPoint();
                    this.a.a(latLng.latitude, latLng.longitude, iPoint);
                    this.i.add(iPoint);
                    builder.include(latLng);
                    obj = latLng;
                }
            }
            int size = this.i.size();
            if (size > 1) {
                IPoint iPoint2 = (IPoint) this.i.get(0);
                IPoint iPoint3 = (IPoint) this.i.get(size - 1);
                if (iPoint2.x == iPoint3.x && iPoint2.y == iPoint3.y) {
                    this.i.remove(size - 1);
                }
            }
        }
        this.n = builder.build();
        if (this.j != null) {
            this.j.clear();
        }
        if (this.k != null) {
            this.k.clear();
        }
        this.l = 0;
        this.m = 0;
        this.a.e(false);
    }

    public String c() {
        if (this.d == null) {
            this.d = r.a(SearchBound.POLYGON_SHAPE);
        }
        return this.d;
    }

    public float d() {
        return this.b;
    }

    public boolean e() {
        return this.c;
    }

    public int f() {
        return super.hashCode();
    }

    public void g() {
        int i = 0;
        this.o = false;
        FPoint[] fPointArr = new FPoint[this.i.size()];
        float[] fArr = new float[(this.i.size() * 3)];
        Iterator it = this.i.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            IPoint iPoint = (IPoint) it.next();
            fPointArr[i2] = new FPoint();
            this.a.b(iPoint.y, iPoint.x, fPointArr[i2]);
            fArr[i2 * 3] = fPointArr[i2].x;
            fArr[(i2 * 3) + 1] = fPointArr[i2].y;
            fArr[(i2 * 3) + 2] = 0.0f;
            i2++;
        }
        FPoint[] a = a(fPointArr);
        if (a.length == 0) {
            if (p == 1.0E10f) {
                p = 1.0E8f;
            } else {
                p = 1.0E10f;
            }
            a = a(fPointArr);
        }
        float[] fArr2 = new float[(a.length * 3)];
        int length = a.length;
        i2 = 0;
        while (i < length) {
            FPoint fPoint = a[i];
            fArr2[i2 * 3] = fPoint.x;
            fArr2[(i2 * 3) + 1] = fPoint.y;
            fArr2[(i2 * 3) + 2] = 0.0f;
            i2++;
            i++;
        }
        this.l = fPointArr.length;
        this.m = a.length;
        this.j = u.a(fArr);
        this.k = u.a(fArr2);
    }

    public float h() {
        return this.e;
    }

    public int i() {
        return this.f;
    }

    public void j() {
        try {
            if (this.j != null) {
                this.j.clear();
                this.j = null;
            }
            if (this.k != null) {
                this.k = null;
            }
        } catch (Throwable th) {
            az.a(th, "PolygonDelegateImp", "destroy");
            th.printStackTrace();
            Log.d("destroy erro", "PolygonDelegateImp destroy");
        }
    }

    public boolean k() {
        return this.o;
    }

    public List<LatLng> l() {
        return this.h;
    }

    public int m() {
        return this.g;
    }
}
