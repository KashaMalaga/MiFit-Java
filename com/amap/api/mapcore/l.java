package com.amap.api.mapcore;

import android.support.v4.view.C0151az;
import android.util.Log;
import cn.com.smartdevices.bracelet.gps.c.a;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.amap.api.mapcore.util.az;
import com.amap.api.mapcore.util.u;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.WeightedLatLng;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
import java.nio.FloatBuffer;
import javax.microedition.khronos.opengles.GL10;

class l implements v {
    private static float m = 4.0075016E7f;
    private static int n = PersonInfo.INCOMING_CALL_DISABLE_BIT;
    private static int o = 20;
    private LatLng a = null;
    private double b = 0.0d;
    private float c = 10.0f;
    private int d = C0151az.s;
    private int e = 0;
    private float f = 0.0f;
    private boolean g = true;
    private String h;
    private t i;
    private FloatBuffer j;
    private int k = 0;
    private boolean l = false;

    public l(t tVar) {
        this.i = tVar;
        try {
            this.h = c();
        } catch (Throwable e) {
            az.a(e, "CircleDelegateImp", "create");
            e.printStackTrace();
        }
    }

    private float b(double d) {
        return (float) ((Math.cos((3.141592653589793d * d) / 180.0d) * ((double) m)) / ((double) (n << o)));
    }

    private double c(double d) {
        return WeightedLatLng.DEFAULT_INTENSITY / ((double) b(d));
    }

    public void a(double d) {
        this.b = d;
        h();
    }

    public void a(float f) {
        this.f = f;
        this.i.H();
        this.i.e(false);
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(LatLng latLng) {
        this.a = latLng;
        h();
    }

    public void a(GL10 gl10) {
        if (this.a != null && this.b > 0.0d && this.g) {
            if (this.j == null || this.k == 0) {
                g();
            }
            if (this.j != null && this.k > 0) {
                p.b(gl10, this.e, this.d, this.j, this.c, this.k);
            }
            this.l = true;
        }
    }

    public void a(boolean z) {
        this.g = z;
        this.i.e(false);
    }

    public boolean a() {
        return true;
    }

    public boolean a(aa aaVar) {
        return equals(aaVar) || aaVar.c().equals(c());
    }

    public void b() {
        this.i.a(c());
        this.i.e(false);
    }

    public void b(float f) {
        this.c = f;
        this.i.e(false);
    }

    public void b(int i) {
        this.e = i;
        this.i.e(false);
    }

    public boolean b(LatLng latLng) {
        return this.b >= ((double) AMapUtils.calculateLineDistance(this.a, latLng));
    }

    public String c() {
        if (this.h == null) {
            this.h = r.a("Circle");
        }
        return this.h;
    }

    public float d() {
        return this.f;
    }

    public boolean e() {
        return this.g;
    }

    public int f() {
        return 0;
    }

    public void g() {
        int i = 0;
        this.l = false;
        LatLng latLng = this.a;
        if (latLng != null) {
            FPoint[] fPointArr = new FPoint[a.e];
            float[] fArr = new float[(fPointArr.length * 3)];
            double c = c(this.a.latitude) * this.b;
            IPoint iPoint = new IPoint();
            MapProjection c2 = this.i.c();
            MapProjection.lonlat2Geo(latLng.longitude, latLng.latitude, iPoint);
            while (i < a.e) {
                double d = (((double) i) * 3.141592653589793d) / 180.0d;
                double sin = Math.sin(d) * c;
                int i2 = (int) (sin + ((double) iPoint.x));
                int cos = (int) ((Math.cos(d) * c) + ((double) iPoint.y));
                FPoint fPoint = new FPoint();
                c2.geo2Map(i2, cos, fPoint);
                fPointArr[i] = fPoint;
                fArr[i * 3] = fPointArr[i].x;
                fArr[(i * 3) + 1] = fPointArr[i].y;
                fArr[(i * 3) + 2] = 0.0f;
                i++;
            }
            this.k = fPointArr.length;
            this.j = u.a(fArr);
        }
    }

    void h() {
        this.k = 0;
        if (this.j != null) {
            this.j.clear();
        }
        this.i.e(false);
    }

    public LatLng i() {
        return this.a;
    }

    public void j() {
        try {
            this.a = null;
            if (this.j != null) {
                this.j.clear();
                this.j = null;
            }
        } catch (Throwable th) {
            az.a(th, "CircleDelegateImp", "destroy");
            th.printStackTrace();
            Log.d("destroy erro", "CircleDelegateImp destroy");
        }
    }

    public boolean k() {
        return this.l;
    }

    public double l() {
        return this.b;
    }

    public float m() {
        return this.c;
    }

    public int n() {
        return this.d;
    }

    public int o() {
        return this.e;
    }
}
