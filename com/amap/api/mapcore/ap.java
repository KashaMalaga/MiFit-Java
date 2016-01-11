package com.amap.api.mapcore;

import android.graphics.Color;
import android.support.v4.view.C0151az;
import android.util.Log;
import com.amap.api.mapcore.util.az;
import com.amap.api.maps.AMapNativeRenderer;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.LatLngBounds.Builder;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;

class ap implements z {
    float a;
    float b;
    float c;
    float d;
    float e;
    float f;
    float g;
    float h;
    float[] i;
    private t j;
    private float k = 10.0f;
    private int l = C0151az.s;
    private int m = C0151az.s;
    private float n = 0.0f;
    private boolean o = true;
    private String p;
    private CopyOnWriteArrayList<IPoint> q = new CopyOnWriteArrayList();
    private int r = 0;
    private boolean s = false;
    private LatLngBounds t = null;

    public ap(t tVar) {
        this.j = tVar;
        try {
            this.p = c();
        } catch (Throwable e) {
            az.a(e, "NavigateArrowDelegateImp", "create");
            e.printStackTrace();
        }
    }

    private List<LatLng> n() {
        if (this.q == null) {
            return null;
        }
        List<LatLng> arrayList = new ArrayList();
        Iterator it = this.q.iterator();
        while (it.hasNext()) {
            IPoint iPoint = (IPoint) it.next();
            if (iPoint != null) {
                DPoint dPoint = new DPoint();
                this.j.b(iPoint.x, iPoint.y, dPoint);
                arrayList.add(new LatLng(dPoint.y, dPoint.x));
            }
        }
        return arrayList;
    }

    public void a(float f) {
        this.n = f;
        this.j.H();
        this.j.e(false);
    }

    public void a(int i) {
        this.l = i;
        this.a = ((float) Color.alpha(i)) / 255.0f;
        this.b = ((float) Color.red(i)) / 255.0f;
        this.c = ((float) Color.green(i)) / 255.0f;
        this.d = ((float) Color.blue(i)) / 255.0f;
        this.j.e(false);
    }

    public void a(List<LatLng> list) {
        b((List) list);
    }

    public void a(GL10 gl10) {
        if (this.q != null && this.q.size() != 0 && this.k > 0.0f) {
            if (this.r == 0) {
                g();
            }
            if (this.i != null && this.r > 0) {
                AMapNativeRenderer.nativeDrawArrowLineWithPoints(this.i, this.i.length, this.j.c().getMapLenWithWin((int) this.k), this.b, this.c, this.d, this.a, this.f, this.g, this.h, this.e, this.j.c().getMapLenWithWin(1));
            }
            this.s = true;
        }
    }

    public void a(boolean z) {
        this.o = z;
        this.j.e(false);
    }

    public boolean a() {
        if (this.t == null) {
            return false;
        }
        LatLngBounds B = this.j.B();
        return B == null ? true : B.contains(this.t) || this.t.intersects(B);
    }

    public boolean a(aa aaVar) {
        return equals(aaVar) || aaVar.c().equals(c());
    }

    public void b() {
        this.j.a(c());
        this.j.e(false);
    }

    public void b(float f) {
        this.k = f;
        this.j.e(false);
    }

    public void b(int i) {
        this.m = i;
        this.e = ((float) Color.alpha(i)) / 255.0f;
        this.f = ((float) Color.red(i)) / 255.0f;
        this.g = ((float) Color.green(i)) / 255.0f;
        this.h = ((float) Color.blue(i)) / 255.0f;
        this.j.e(false);
    }

    void b(List<LatLng> list) {
        Builder builder = LatLngBounds.builder();
        this.q.clear();
        if (list != null) {
            Object obj = null;
            for (LatLng latLng : list) {
                if (!(latLng == null || latLng.equals(r1))) {
                    IPoint iPoint = new IPoint();
                    this.j.a(latLng.latitude, latLng.longitude, iPoint);
                    this.q.add(iPoint);
                    builder.include(latLng);
                    obj = latLng;
                }
            }
        }
        this.t = builder.build();
        this.r = 0;
        this.j.e(false);
    }

    public String c() {
        if (this.p == null) {
            this.p = r.a("NavigateArrow");
        }
        return this.p;
    }

    public float d() {
        return this.n;
    }

    public boolean e() {
        return this.o;
    }

    public int f() {
        return super.hashCode();
    }

    public void g() {
        this.s = false;
        FPoint fPoint = new FPoint();
        this.i = new float[(this.q.size() * 3)];
        Iterator it = this.q.iterator();
        int i = 0;
        while (it.hasNext()) {
            IPoint iPoint = (IPoint) it.next();
            this.j.b(iPoint.y, iPoint.x, fPoint);
            this.i[i * 3] = fPoint.x;
            this.i[(i * 3) + 1] = fPoint.y;
            this.i[(i * 3) + 2] = 0.0f;
            i++;
        }
        this.r = this.q.size();
    }

    public float h() {
        return this.k;
    }

    public int i() {
        return this.l;
    }

    public void j() {
        try {
            if (this.i != null) {
                this.i = null;
            }
        } catch (Throwable th) {
            az.a(th, "NavigateArrowDelegateImp", "destroy");
            th.printStackTrace();
            Log.d("destroy erro", "NavigateArrowDelegateImp destroy");
        }
    }

    public boolean k() {
        return this.s;
    }

    public int l() {
        return this.m;
    }

    public List<LatLng> m() {
        return n();
    }
}
