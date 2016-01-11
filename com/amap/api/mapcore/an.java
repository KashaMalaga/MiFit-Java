package com.amap.api.mapcore;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.opengl.GLES10;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import android.util.Log;
import com.amap.api.mapcore.util.az;
import com.amap.api.mapcore.util.by;
import com.amap.api.mapcore.util.u;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;

class an implements y {
    private static int a = 0;
    private Object A;
    private boolean B = false;
    private CopyOnWriteArrayList<BitmapDescriptor> C = null;
    private boolean D = false;
    private boolean E = false;
    private boolean F = true;
    private int G = 0;
    private int H = 20;
    private boolean I = false;
    private int J;
    private int K;
    private boolean b = false;
    private float c = 0.0f;
    private float d = 0.0f;
    private boolean e = false;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private FPoint j = new FPoint();
    private float k = 0.0f;
    private float[] l;
    private int[] m = null;
    private boolean n = false;
    private FloatBuffer o = null;
    private String p;
    private LatLng q;
    private LatLng r;
    private String s;
    private String t;
    private float u = 0.5f;
    private float v = 1.0f;
    private boolean w = false;
    private boolean x = true;
    private al y;
    private FloatBuffer z;

    public an(MarkerOptions markerOptions, al alVar) {
        this.y = alVar;
        this.D = markerOptions.isGps();
        if (markerOptions.getPosition() != null) {
            if (this.D) {
                try {
                    double[] a = by.a(markerOptions.getPosition().longitude, markerOptions.getPosition().latitude);
                    this.r = new LatLng(a[1], a[0]);
                } catch (Throwable th) {
                    az.a(th, "MarkerDelegateImp", "create");
                    this.r = markerOptions.getPosition();
                }
            }
            this.q = markerOptions.getPosition();
        }
        this.u = markerOptions.getAnchorU();
        this.v = markerOptions.getAnchorV();
        this.f = markerOptions.getInfoWindowOffsetX();
        this.g = markerOptions.getInfoWindowOffsetY();
        this.H = markerOptions.getPeriod();
        b(markerOptions.getIcons());
        this.x = markerOptions.isVisible();
        this.t = markerOptions.getSnippet();
        this.s = markerOptions.getTitle();
        this.w = markerOptions.isDraggable();
        this.p = h();
        this.B = markerOptions.isPerspective();
        this.e = markerOptions.isFlat();
    }

    private void J() {
        if (this.y.a != null) {
            this.y.a.e(false);
        }
    }

    private int a(GL10 gl10) {
        int F = this.y.a.F();
        if (F != 0) {
            return F;
        }
        int[] iArr = new int[]{0};
        gl10.glGenTextures(1, iArr, 0);
        return iArr[0];
    }

    private void a(float f, float f2, IPoint iPoint) {
        float f3 = (float) ((3.141592653589793d * ((double) this.c)) / 180.0d);
        iPoint.x = (int) ((((double) f) * Math.cos((double) f3)) + (((double) f2) * Math.sin((double) f3)));
        iPoint.y = (int) ((((double) f2) * Math.cos((double) f3)) - (Math.sin((double) f3) * ((double) f)));
    }

    private void a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (i != 0 && floatBuffer != null && floatBuffer2 != null) {
            GLES10.glEnable(3042);
            GLES10.glBlendFunc(1, 771);
            GLES10.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GLES10.glEnable(3553);
            GLES10.glEnableClientState(32884);
            GLES10.glEnableClientState(32888);
            GLES10.glBindTexture(3553, i);
            GLES10.glVertexPointer(3, 5126, 0, floatBuffer);
            GLES10.glTexCoordPointer(2, 5126, 0, floatBuffer2);
            GLES10.glDrawArrays(6, 0, 4);
            GLES10.glDisableClientState(32884);
            GLES10.glDisableClientState(32888);
            GLES10.glDisable(3553);
            GLES10.glDisable(3042);
        }
    }

    private void a(t tVar) {
        float[] a = a(tVar, this.e ? 1 : 0);
        if (this.o == null) {
            this.o = u.a(a);
        } else {
            this.o = u.a(a, this.o);
        }
        if (this.C != null && this.C.size() > 0) {
            this.G++;
            if (this.G >= this.H * this.C.size()) {
                this.G = 0;
            }
            int i = this.G / this.H;
            if (!this.F) {
                J();
            }
            if (this.m != null && this.m.length > 0) {
                a(this.m[i % this.C.size()], this.o, this.z);
            }
        }
    }

    private float[] a(t tVar, int i) {
        float f = this.j.x;
        float f2 = this.j.y;
        Object obj = new float[12];
        float a = tVar.v().a(G());
        float a2 = tVar.v().a(H());
        float[] fArr = new float[16];
        float[] fArr2 = new float[4];
        Matrix.setIdentityM(fArr, 0);
        if (i == 3) {
            Matrix.translateM(fArr, 0, f, f2, 0.0f);
            Matrix.rotateM(fArr, 0, tVar.c().getMapAngle(), 0.0f, 0.0f, 1.0f);
            Matrix.translateM(fArr, 0, -f, -f2, 0.0f);
            Matrix.translateM(fArr, 0, f - (a / 2.0f), f2 - (a2 / 2.0f), 0.0f);
            Matrix.rotateM(fArr, 0, -tVar.c().getCameraHeaderAngle(), 1.0f, 0.0f, 0.0f);
            Matrix.translateM(fArr, 0, (a / 2.0f) - f, (a2 / 2.0f) - f2, 0.0f);
        } else if (i == 1) {
            Matrix.translateM(fArr, 0, f, f2, 0.0f);
            Matrix.rotateM(fArr, 0, this.c, 0.0f, 0.0f, 1.0f);
            Matrix.translateM(fArr, 0, -f, -f2, 0.0f);
        } else {
            Matrix.translateM(fArr, 0, f, f2, 0.0f);
            Matrix.rotateM(fArr, 0, tVar.c().getMapAngle(), 0.0f, 0.0f, 1.0f);
            Matrix.rotateM(fArr, 0, -tVar.c().getCameraHeaderAngle(), 1.0f, 0.0f, 0.0f);
            Matrix.rotateM(fArr, 0, this.c, 0.0f, 0.0f, 1.0f);
            Matrix.translateM(fArr, 0, -f, -f2, 0.0f);
        }
        float[] fArr3 = new float[]{f - (this.u * a), ((1.0f - this.v) * a2) + f2, 0.0f, 1.0f};
        Matrix.multiplyMV(fArr3, 0, fArr, 0, fArr2, 0);
        obj[0] = fArr3[0];
        obj[1] = fArr3[1];
        obj[2] = fArr3[2];
        fArr2[0] = ((1.0f - this.u) * a) + f;
        fArr2[1] = ((1.0f - this.v) * a2) + f2;
        fArr2[2] = 0.0f;
        fArr2[3] = 1.0f;
        Matrix.multiplyMV(fArr3, 0, fArr, 0, fArr2, 0);
        obj[3] = fArr3[0];
        obj[4] = fArr3[1];
        obj[5] = fArr3[2];
        fArr2[0] = ((1.0f - this.u) * a) + f;
        fArr2[1] = f2 - (this.v * a2);
        fArr2[2] = 0.0f;
        fArr2[3] = 1.0f;
        Matrix.multiplyMV(fArr3, 0, fArr, 0, fArr2, 0);
        obj[6] = fArr3[0];
        obj[7] = fArr3[1];
        obj[8] = fArr3[2];
        fArr2[0] = f - (this.u * a);
        fArr2[1] = f2 - (this.v * a2);
        fArr2[2] = 0.0f;
        fArr2[3] = 1.0f;
        Matrix.multiplyMV(fArr3, 0, fArr, 0, fArr2, 0);
        obj[9] = fArr3[0];
        obj[10] = fArr3[1];
        obj[11] = fArr3[2];
        this.l = (float[]) obj.clone();
        return obj;
    }

    private static String c(String str) {
        a++;
        return str + a;
    }

    public boolean A() {
        return this.e;
    }

    public int B() {
        return this.f;
    }

    public int C() {
        return this.g;
    }

    public int D() {
        return this.h;
    }

    public int E() {
        return this.i;
    }

    public boolean F() {
        return this.I;
    }

    public int G() {
        try {
            return I().getWidth();
        } catch (Throwable th) {
            return 0;
        }
    }

    public int H() {
        try {
            return I().getHeight();
        } catch (Throwable th) {
            return 0;
        }
    }

    public synchronized BitmapDescriptor I() {
        BitmapDescriptor I;
        try {
            if (this.C == null || this.C.size() == 0) {
                a();
                this.C.add(BitmapDescriptorFactory.defaultMarker());
            } else if (this.C.get(0) == null) {
                this.C.clear();
                I = I();
            }
            I = (BitmapDescriptor) this.C.get(0);
        } catch (Throwable th) {
            az.a(th, "MarkerDelegateImp", "getBitmapDescriptor");
            th.printStackTrace();
            I = null;
        }
        return I;
    }

    synchronized void a() {
        if (this.C == null) {
            this.C = new CopyOnWriteArrayList();
        } else {
            this.C.clear();
        }
    }

    public void a(float f) {
        this.d = f;
        this.c = (((-f) % 360.0f) + 360.0f) % 360.0f;
        r();
        if (n()) {
            this.y.e(this);
            this.y.d(this);
        }
        J();
    }

    public void a(float f, float f2) {
        if (this.u != f || this.v != f2) {
            this.u = f;
            this.v = f2;
            if (n()) {
                this.y.e(this);
                this.y.d(this);
            }
            J();
        }
    }

    public void a(int i) {
        if (i <= 1) {
            this.H = 1;
        } else {
            this.H = i;
        }
    }

    public void a(int i, int i2) {
        int i3 = 1;
        this.J = i;
        this.K = i2;
        this.I = true;
        r();
        try {
            t tVar = this.y.a;
            if (!this.e) {
                i3 = 0;
            }
            a(tVar, i3);
        } catch (Throwable th) {
            az.a(th, "MarkerDelegateImp", "setPositionByPixels");
        }
        J();
        if (n()) {
            l();
        }
    }

    public synchronized void a(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            try {
                if (this.C != null) {
                    this.C.clear();
                    this.C.add(bitmapDescriptor);
                    this.E = false;
                    this.b = false;
                    this.m = null;
                    if (this.z != null) {
                        this.z.clear();
                        this.z = null;
                    }
                    if (n()) {
                        this.y.e(this);
                        this.y.d(this);
                    }
                    J();
                }
            } catch (Throwable th) {
                az.a(th, "MarkerDelegateImp", "setIcon");
                th.printStackTrace();
            }
        }
    }

    public void a(LatLng latLng) {
        if (this.D) {
            try {
                double[] a = by.a(latLng.longitude, latLng.latitude);
                this.r = new LatLng(a[1], a[0]);
            } catch (Throwable th) {
                this.r = latLng;
            }
        }
        this.q = latLng;
        this.I = false;
        r();
        J();
    }

    public void a(Object obj) {
        this.A = obj;
    }

    public void a(String str) {
        this.s = str;
        J();
    }

    public synchronized void a(ArrayList<BitmapDescriptor> arrayList) {
        if (arrayList != null) {
            try {
                if (this.C != null) {
                    b((ArrayList) arrayList);
                    this.E = false;
                    this.b = false;
                    if (this.z != null) {
                        this.z.clear();
                        this.z = null;
                    }
                    this.m = null;
                    if (n()) {
                        this.y.e(this);
                        this.y.d(this);
                    }
                    J();
                }
            } catch (Throwable th) {
                az.a(th, "MarkerDelegateImp", "setIcons");
                th.printStackTrace();
            }
        }
    }

    public void a(GL10 gl10, t tVar) {
        int i = 0;
        if (this.x && this.q != null) {
            if (I() != null || this.C != null) {
                int i2;
                int i3;
                BitmapDescriptor bitmapDescriptor;
                if (!this.E) {
                    try {
                        if (this.C != null) {
                            this.m = new int[this.C.size()];
                            i2 = VERSION.SDK_INT >= 12 ? 1 : 0;
                            Iterator it = this.C.iterator();
                            i3 = 0;
                            while (it.hasNext()) {
                                bitmapDescriptor = (BitmapDescriptor) it.next();
                                if (i2 != 0) {
                                    i = this.y.a(bitmapDescriptor);
                                }
                                if (i == 0) {
                                    Bitmap bitmap = bitmapDescriptor.getBitmap();
                                    if (!(bitmap == null || bitmap.isRecycled())) {
                                        i = a(gl10);
                                        if (i2 != 0) {
                                            this.y.a(new ar(bitmapDescriptor, i));
                                        }
                                        u.b(gl10, i, bitmap, false);
                                    }
                                }
                                int i4 = i;
                                this.m[i3] = i4;
                                i3++;
                                i = i4;
                            }
                            if (this.C.size() == 1) {
                                this.F = true;
                            } else {
                                this.F = false;
                            }
                            this.E = true;
                        }
                    } catch (Throwable th) {
                        az.a(th, "MarkerDelegateImp", "loadtexture");
                        th.printStackTrace();
                        return;
                    }
                }
                try {
                    if (!(this.b && tVar.z() == this.k)) {
                        if (this.D) {
                            tVar.a(this.r.latitude, this.r.longitude, this.j);
                        } else {
                            tVar.a(this.q.latitude, this.q.longitude, this.j);
                        }
                        this.k = tVar.z();
                        bitmapDescriptor = I();
                        if (bitmapDescriptor != null) {
                            i = bitmapDescriptor.getWidth();
                            i3 = bitmapDescriptor.getHeight();
                            i2 = bitmapDescriptor.getBitmap().getHeight();
                            float width = ((float) i) / ((float) bitmapDescriptor.getBitmap().getWidth());
                            float f = ((float) i3) / ((float) i2);
                            if (this.z == null) {
                                this.z = u.a(new float[]{0.0f, f, width, f, width, 0.0f, 0.0f, 0.0f});
                            }
                            this.b = true;
                        } else {
                            return;
                        }
                    }
                    if (this.I) {
                        tVar.a(this.J, this.K, this.j);
                    }
                    a(tVar);
                } catch (Throwable th2) {
                    az.a(th2, "MarkerDelegateImp", "drawMarker");
                    th2.printStackTrace();
                }
            }
        }
    }

    public void a(boolean z) {
        this.w = z;
        J();
    }

    public boolean a(y yVar) {
        return equals(yVar) || yVar.h().equals(h());
    }

    public void b(String str) {
        this.t = str;
        J();
    }

    public synchronized void b(ArrayList<BitmapDescriptor> arrayList) {
        a();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                BitmapDescriptor bitmapDescriptor = (BitmapDescriptor) it.next();
                if (bitmapDescriptor != null) {
                    this.C.add(bitmapDescriptor);
                }
            }
        }
    }

    public void b(boolean z) {
        if (this.x != z) {
            this.x = z;
            if (!z && n()) {
                this.y.e(this);
            }
            J();
        }
    }

    public synchronized boolean b() {
        J();
        return this.y.b((y) this);
    }

    public void c(boolean z) {
        this.B = z;
    }

    public boolean c() {
        return this.F;
    }

    public Rect d() {
        if (this.l == null) {
            return new Rect(0, 0, 0, 0);
        }
        try {
            Rect rect;
            MapProjection c = this.y.a.c();
            int G = G();
            int H = H();
            IPoint iPoint = new IPoint();
            IPoint iPoint2 = new IPoint();
            c.map2Win(this.j.x, this.j.y, iPoint);
            if (this.e) {
                c.map2Win(this.l[0], this.l[1], iPoint2);
                rect = new Rect(iPoint2.x, iPoint2.y, iPoint2.x, iPoint2.y);
                c.map2Win(this.l[3], this.l[4], iPoint2);
                rect.union(iPoint2.x, iPoint2.y);
                c.map2Win(this.l[6], this.l[7], iPoint2);
                rect.union(iPoint2.x, iPoint2.y);
                c.map2Win(this.l[9], this.l[10], iPoint2);
                rect.union(iPoint2.x, iPoint2.y);
            } else {
                a((-this.u) * ((float) G), (this.v - 1.0f) * ((float) H), iPoint2);
                rect = new Rect(iPoint.x + iPoint2.x, iPoint.y - iPoint2.y, iPoint.x + iPoint2.x, iPoint.y - iPoint2.y);
                a((-this.u) * ((float) G), this.v * ((float) H), iPoint2);
                rect.union(iPoint.x + iPoint2.x, iPoint.y - iPoint2.y);
                a((1.0f - this.u) * ((float) G), this.v * ((float) H), iPoint2);
                rect.union(iPoint.x + iPoint2.x, iPoint.y - iPoint2.y);
                a((1.0f - this.u) * ((float) G), (this.v - 1.0f) * ((float) H), iPoint2);
                rect.union(iPoint.x + iPoint2.x, iPoint.y - iPoint2.y);
            }
            this.h = rect.centerX() - iPoint.x;
            this.i = rect.top - iPoint.y;
            return rect;
        } catch (Throwable th) {
            az.a(th, "MarkerDelegateImp", "getRect");
            th.printStackTrace();
            return new Rect(0, 0, 0, 0);
        }
    }

    public void d(boolean z) {
        this.e = z;
        J();
    }

    public LatLng e() {
        if (!this.I) {
            return this.q;
        }
        DPoint dPoint = new DPoint();
        this.y.a.a(this.J, this.K, dPoint);
        return new LatLng(dPoint.y, dPoint.x);
    }

    public FPoint f() {
        return this.j;
    }

    public LatLng g() {
        return this.D ? this.r : this.q;
    }

    public String h() {
        if (this.p == null) {
            this.p = c("Marker");
        }
        return this.p;
    }

    public String i() {
        return this.s;
    }

    public String j() {
        return this.t;
    }

    public boolean k() {
        return this.w;
    }

    public void l() {
        if (this.x) {
            this.y.d(this);
            J();
        }
    }

    public void m() {
        if (n()) {
            this.y.e(this);
            J();
        }
    }

    public boolean n() {
        return this.y.f(this);
    }

    public boolean o() {
        return this.x;
    }

    public void p() {
        try {
            this.n = true;
            if (!(this.y == null || this.y.a == null)) {
                this.y.e(this);
                this.y.a.I();
            }
            this.m = null;
        } catch (Throwable th) {
            az.a(th, "MarkerDelegateImp", "destroy");
            th.printStackTrace();
            Log.d("destroy erro", "MarkerDelegateImp destroy");
        }
    }

    public int q() {
        return super.hashCode();
    }

    public boolean r() {
        this.b = false;
        if (this.I) {
            this.y.a.c().win2Map(this.J, this.K, this.j);
            DPoint dPoint = new DPoint();
            this.y.a.a(this.J, this.K, dPoint);
            this.q = new LatLng(dPoint.y, dPoint.y);
        }
        return true;
    }

    public Object s() {
        return this.A;
    }

    public boolean t() {
        return this.B;
    }

    public float u() {
        return this.d;
    }

    public int v() {
        return this.H;
    }

    public synchronized ArrayList<BitmapDescriptor> w() {
        ArrayList<BitmapDescriptor> arrayList;
        if (this.C == null || this.C.size() <= 0) {
            arrayList = null;
        } else {
            ArrayList<BitmapDescriptor> arrayList2 = new ArrayList();
            Iterator it = this.C.iterator();
            while (it.hasNext()) {
                arrayList2.add((BitmapDescriptor) it.next());
            }
            arrayList = arrayList2;
        }
        return arrayList;
    }

    public boolean x() {
        return this.n;
    }

    public synchronized void y() {
        if (this.n) {
            try {
                b();
                if (this.C != null) {
                    Iterator it = this.C.iterator();
                    while (it.hasNext()) {
                        Bitmap bitmap = ((BitmapDescriptor) it.next()).getBitmap();
                        if (bitmap != null) {
                            bitmap.recycle();
                        }
                    }
                    this.C = null;
                }
                if (this.z != null) {
                    this.z.clear();
                    this.z = null;
                }
                if (this.o != null) {
                    this.o.clear();
                    this.o = null;
                }
                this.q = null;
                this.A = null;
            } catch (Throwable th) {
                az.a(th, "MarkerDelegateImp", "realdestroy");
                th.printStackTrace();
                Log.d("destroy erro", "MarkerDelegateImp destroy");
            }
        }
        return;
    }

    public void z() {
        this.y.c(this);
    }
}
