package com.amap.api.mapcore;

import android.graphics.Color;
import android.support.v4.view.C0151az;
import android.util.Log;
import com.amap.api.mapcore.util.az;
import com.amap.api.maps.AMapNativeRenderer;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.WeightedLatLng;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
import javax.microedition.khronos.opengles.GL10;

class i implements u {
    float a;
    float b;
    float c;
    float d;
    private LatLng e;
    private LatLng f;
    private LatLng g;
    private float h = 10.0f;
    private int i = C0151az.s;
    private float j = 0.0f;
    private boolean k = true;
    private String l;
    private t m;
    private float[] n;
    private int o = 0;
    private boolean p = false;
    private double q = 0.0d;
    private double r = 0.0d;
    private double s = 0.0d;

    public i(t tVar) {
        this.m = tVar;
        try {
            this.l = c();
        } catch (Throwable e) {
            az.a(e, "ArcDelegateImp", "create");
            e.printStackTrace();
        }
    }

    private double a(double d, double d2, double d3, double d4) {
        double d5 = (d2 - d4) / this.q;
        if (Math.abs(d5) > WeightedLatLng.DEFAULT_INTENSITY) {
            d5 = Math.signum(d5);
        }
        d5 = Math.asin(d5);
        return d5 >= 0.0d ? d3 < d ? 3.141592653589793d - Math.abs(d5) : d5 : d3 < d ? 3.141592653589793d - d5 : d5 + 6.283185307179586d;
    }

    private FPoint a(MapProjection mapProjection, double d, double d2, double d3) {
        int cos = (int) ((Math.cos(d) * this.q) + d2);
        int i = (int) (((-Math.sin(d)) * this.q) + d3);
        FPoint fPoint = new FPoint();
        mapProjection.geo2Map(cos, i, fPoint);
        return fPoint;
    }

    private boolean l() {
        return Math.abs(((this.e.latitude - this.f.latitude) * (this.f.longitude - this.g.longitude)) - ((this.e.longitude - this.f.longitude) * (this.f.latitude - this.g.latitude))) >= 1.0E-6d;
    }

    private DPoint m() {
        IPoint iPoint = new IPoint();
        this.m.a(this.e.latitude, this.e.longitude, iPoint);
        IPoint iPoint2 = new IPoint();
        this.m.a(this.f.latitude, this.f.longitude, iPoint2);
        IPoint iPoint3 = new IPoint();
        this.m.a(this.g.latitude, this.g.longitude, iPoint3);
        double d = (double) iPoint.x;
        double d2 = (double) iPoint.y;
        double d3 = (double) iPoint2.x;
        double d4 = (double) iPoint2.y;
        double d5 = (double) iPoint3.x;
        double d6 = (double) iPoint3.y;
        double d7 = (((d6 - d2) * ((((d4 * d4) - (d2 * d2)) + (d3 * d3)) - (d * d))) + ((d4 - d2) * ((((d2 * d2) - (d6 * d6)) + (d * d)) - (d5 * d5)))) / (((2.0d * (d3 - d)) * (d6 - d2)) - ((2.0d * (d5 - d)) * (d4 - d2)));
        double d8 = (((d5 - d) * ((((d3 * d3) - (d * d)) + (d4 * d4)) - (d2 * d2))) + ((d3 - d) * ((((d * d) - (d5 * d5)) + (d2 * d2)) - (d6 * d6)))) / (((2.0d * (d4 - d2)) * (d5 - d)) - ((2.0d * (d6 - d2)) * (d3 - d)));
        this.q = Math.sqrt(((d - d7) * (d - d7)) + ((d2 - d8) * (d2 - d8)));
        this.r = a(d7, d8, d, d2);
        d = a(d7, d8, d3, d4);
        this.s = a(d7, d8, d5, d6);
        if (this.r < this.s) {
            if (d <= this.r || d >= this.s) {
                this.s -= 6.283185307179586d;
            }
        } else if (d <= this.s || d >= this.r) {
            this.s += 6.283185307179586d;
        }
        return new DPoint(d7, d8);
    }

    public void a(float f) {
        this.j = f;
        this.m.H();
        this.m.e(false);
    }

    public void a(int i) {
        this.i = i;
        this.a = ((float) Color.alpha(i)) / 255.0f;
        this.b = ((float) Color.red(i)) / 255.0f;
        this.c = ((float) Color.green(i)) / 255.0f;
        this.d = ((float) Color.blue(i)) / 255.0f;
        this.m.e(false);
    }

    public void a(LatLng latLng) {
        this.e = latLng;
    }

    public void a(GL10 gl10) {
        if (this.e != null && this.f != null && this.g != null && this.k) {
            if (this.n == null || this.o == 0) {
                g();
            }
            if (this.n != null && this.o > 0) {
                AMapNativeRenderer.nativeDrawLineByTextureID(this.n, this.n.length, this.m.c().getMapLenWithWin((int) this.h), this.m.b(), this.b, this.c, this.d, this.a, this.m.c().getMapLenWithWin(1), false, true);
            }
            this.p = true;
        }
    }

    public void a(boolean z) {
        this.k = z;
        this.m.e(false);
    }

    public boolean a() {
        return true;
    }

    public boolean a(aa aaVar) {
        return equals(aaVar) || aaVar.c().equals(c());
    }

    public void b() {
        this.m.a(c());
        this.m.e(false);
    }

    public void b(float f) {
        this.h = f;
        this.m.e(false);
    }

    public void b(LatLng latLng) {
        this.f = latLng;
    }

    public String c() {
        if (this.l == null) {
            this.l = r.a("Arc");
        }
        return this.l;
    }

    public void c(LatLng latLng) {
        this.g = latLng;
    }

    public float d() {
        return this.j;
    }

    public boolean e() {
        return this.k;
    }

    public int f() {
        return 0;
    }

    public void g() {
        int i = 0;
        if (this.e != null && this.f != null && this.g != null && this.k) {
            try {
                this.p = false;
                MapProjection c = this.m.c();
                FPoint fPoint;
                if (l()) {
                    DPoint m = m();
                    int abs = (int) ((Math.abs(this.s - this.r) * 180.0d) / 3.141592653589793d);
                    double d = (this.s - this.r) / ((double) abs);
                    FPoint[] fPointArr = new FPoint[(abs + 1)];
                    this.n = new float[(fPointArr.length * 3)];
                    for (int i2 = 0; i2 <= abs; i2++) {
                        MapProjection mapProjection;
                        if (i2 == abs) {
                            fPoint = new FPoint();
                            this.m.a(this.g.latitude, this.g.longitude, fPoint);
                            fPointArr[i2] = fPoint;
                        } else {
                            mapProjection = c;
                            fPointArr[i2] = a(mapProjection, (((double) i2) * d) + this.r, m.x, m.y);
                        }
                        mapProjection = c;
                        fPointArr[i2] = a(mapProjection, (((double) i2) * d) + this.r, m.x, m.y);
                        this.n[i2 * 3] = fPointArr[i2].x;
                        this.n[(i2 * 3) + 1] = fPointArr[i2].y;
                        this.n[(i2 * 3) + 2] = 0.0f;
                    }
                    this.o = fPointArr.length;
                    return;
                }
                FPoint[] fPointArr2 = new FPoint[3];
                this.n = new float[(fPointArr2.length * 3)];
                fPoint = new FPoint();
                this.m.a(this.e.latitude, this.e.longitude, fPoint);
                fPointArr2[0] = fPoint;
                fPoint = new FPoint();
                this.m.a(this.f.latitude, this.f.longitude, fPoint);
                fPointArr2[1] = fPoint;
                fPoint = new FPoint();
                this.m.a(this.g.latitude, this.g.longitude, fPoint);
                fPointArr2[2] = fPoint;
                while (i < 3) {
                    this.n[i * 3] = fPointArr2[i].x;
                    this.n[(i * 3) + 1] = fPointArr2[i].y;
                    this.n[(i * 3) + 2] = 0.0f;
                    i++;
                }
                this.o = fPointArr2.length;
            } catch (Throwable th) {
                az.a(th, "ArcDelegateImp", "calMapFPoint");
                th.printStackTrace();
            }
        }
    }

    public float h() {
        return this.h;
    }

    public int i() {
        return this.i;
    }

    public void j() {
        try {
            this.e = null;
            this.f = null;
            this.g = null;
        } catch (Throwable th) {
            az.a(th, "ArcDelegateImp", "destroy");
            th.printStackTrace();
            Log.d("destroy erro", "ArcDelegateImp destroy");
        }
    }

    public boolean k() {
        return this.p;
    }
}
