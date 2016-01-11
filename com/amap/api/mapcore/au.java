package com.amap.api.mapcore;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import com.amap.api.mapcore.util.az;
import com.amap.api.mapcore.util.u;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import javax.microedition.khronos.opengles.GL10;

class au implements y {
    private boolean a = false;
    private int b = 0;
    private int c = 0;
    private FloatBuffer d = null;
    private String e;
    private FPoint f;
    private BitmapDescriptor g;
    private boolean h = true;
    private FloatBuffer i;
    private Object j;
    private int k;
    private t l = null;
    private MapProjection m = null;
    private float n = 0.5f;
    private float o = 1.0f;
    private boolean p;
    private boolean q = false;
    private boolean r = true;
    private int s = 20;

    public au(MarkerOptions markerOptions, t tVar) {
        this.l = tVar;
        this.m = tVar.c();
        b(markerOptions.getIcon());
        this.b = markerOptions.getInfoWindowOffsetX();
        this.c = markerOptions.getInfoWindowOffsetY();
        this.h = markerOptions.isVisible();
        this.e = h();
        r();
    }

    private void J() {
        if (this.l != null) {
            this.l.e(false);
        }
    }

    private void a(GL10 gl10, int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (floatBuffer != null && floatBuffer2 != null) {
            gl10.glEnable(3042);
            gl10.glBlendFunc(1, 771);
            gl10.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            gl10.glEnable(3553);
            gl10.glEnableClientState(32884);
            gl10.glEnableClientState(32888);
            gl10.glBindTexture(3553, i);
            gl10.glVertexPointer(3, 5126, 0, floatBuffer);
            gl10.glTexCoordPointer(2, 5126, 0, floatBuffer2);
            gl10.glDrawArrays(6, 0, 4);
            gl10.glDisableClientState(32884);
            gl10.glDisableClientState(32888);
            gl10.glDisable(3553);
            gl10.glDisable(3042);
        }
    }

    private int b(GL10 gl10) {
        int F = this.l.F();
        if (F != 0) {
            return F;
        }
        int[] iArr = new int[]{0};
        gl10.glGenTextures(1, iArr, 0);
        return iArr[0];
    }

    private void b(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.k = 0;
            this.g = bitmapDescriptor;
        }
    }

    public boolean A() {
        return false;
    }

    public int B() {
        return this.b;
    }

    public int C() {
        return this.c;
    }

    public int D() {
        return 0;
    }

    public int E() {
        return 0;
    }

    public boolean F() {
        return false;
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

    public BitmapDescriptor I() {
        return this.g;
    }

    public void a() {
    }

    public void a(float f) {
    }

    public void a(float f, float f2) {
        if (this.n != f || this.o != f2) {
            this.n = f;
            this.o = f2;
            J();
        }
    }

    public void a(int i) {
        if (i <= 1) {
            this.s = 1;
        } else {
            this.s = i;
        }
    }

    public void a(int i, int i2) {
    }

    public void a(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.g = bitmapDescriptor;
            this.q = false;
            if (this.i != null) {
                this.i.clear();
                this.i = null;
            }
            J();
        }
    }

    public void a(LatLng latLng) {
    }

    public void a(FPoint fPoint) {
        if (!fPoint.equals(this.f)) {
            this.f = fPoint;
            J();
        }
    }

    public void a(Object obj) {
        this.j = obj;
    }

    public void a(String str) {
    }

    public void a(ArrayList<BitmapDescriptor> arrayList) {
    }

    public void a(GL10 gl10) {
        if (this.h && this.f != null && I() != null) {
            if (!this.q) {
                try {
                    if (this.k != 0) {
                        gl10.glDeleteTextures(1, new int[]{this.k}, 0);
                        this.l.f(this.k);
                    }
                    this.k = b(gl10);
                    if (this.g != null) {
                        Bitmap bitmap = this.g.getBitmap();
                        if (!(bitmap == null || bitmap.isRecycled())) {
                            u.a(gl10, this.k, bitmap);
                        }
                        this.q = true;
                    }
                } catch (Throwable th) {
                    az.a(th, "PopupOverlay", "drawMarker");
                    th.printStackTrace();
                    return;
                }
            }
            if (r()) {
                gl10.glLoadIdentity();
                gl10.glViewport(0, 0, this.l.h(), this.l.i());
                gl10.glMatrixMode(5889);
                gl10.glLoadIdentity();
                gl10.glOrthof(0.0f, (float) this.l.h(), 0.0f, (float) this.l.i(), 1.0f, GroundOverlayOptions.NO_DIMENSION);
                a(gl10, this.k, this.d, this.i);
                if (this.p) {
                    a();
                    this.p = false;
                }
            }
        }
    }

    public void a(GL10 gl10, t tVar) {
    }

    public void a(boolean z) {
    }

    public boolean a(y yVar) {
        return equals(yVar) || yVar.h().equals(h());
    }

    public void b(int i, int i2) {
        this.b = i;
        this.c = i2;
    }

    public void b(String str) {
    }

    public void b(boolean z) {
        if (!this.h && z) {
            this.p = true;
        }
        this.h = z;
        J();
    }

    public boolean b() {
        J();
        if (this.k != 0) {
            this.l.f(this.k);
        }
        return true;
    }

    public void c(boolean z) {
    }

    public boolean c() {
        return this.r;
    }

    public Rect d() {
        return null;
    }

    public void d(boolean z) {
        J();
    }

    public LatLng e() {
        return null;
    }

    public FPoint f() {
        return this.f;
    }

    public LatLng g() {
        return null;
    }

    public String h() {
        if (this.e == null) {
            this.e = "PopupOverlay";
        }
        return this.e;
    }

    public String i() {
        return null;
    }

    public String j() {
        return null;
    }

    public boolean k() {
        return false;
    }

    public void l() {
    }

    public void m() {
    }

    public boolean n() {
        return false;
    }

    public boolean o() {
        return this.h;
    }

    public void p() {
    }

    public int q() {
        return super.hashCode();
    }

    public boolean r() {
        if (this.f == null) {
            return false;
        }
        IPoint iPoint = new IPoint();
        this.l.c().map2Win(this.f.x, this.f.y, iPoint);
        int G = G();
        int H = H();
        int i = (int) (((float) (iPoint.x + this.b)) - (((float) G) * this.n));
        int i2 = (int) (((float) (iPoint.y + this.c)) + (((float) H) * (1.0f - this.o)));
        if (i - G > this.l.h() || i < (-G) * 2 || i2 < (-H) * 2 || i2 - H > this.l.i() || this.g == null) {
            return false;
        }
        G = this.g.getWidth();
        float width = ((float) G) / ((float) this.g.getBitmap().getWidth());
        float height = ((float) this.g.getHeight()) / ((float) this.g.getBitmap().getHeight());
        if (this.i == null) {
            this.i = u.a(new float[]{0.0f, height, width, height, width, 0.0f, 0.0f, 0.0f});
        }
        float[] fArr = new float[]{(float) i, (float) (this.l.i() - i2), 0.0f, (float) (i + G), (float) (this.l.i() - i2), 0.0f, (float) (G + i), (float) ((this.l.i() - i2) + H), 0.0f, (float) i, (float) ((this.l.i() - i2) + H), 0.0f};
        if (this.d == null) {
            this.d = u.a(fArr);
        } else {
            this.d = u.a(fArr, this.d);
        }
        return true;
    }

    public Object s() {
        return this.j;
    }

    public boolean t() {
        return false;
    }

    public float u() {
        return 0.0f;
    }

    public int v() {
        return this.s;
    }

    public ArrayList<BitmapDescriptor> w() {
        return null;
    }

    public boolean x() {
        return this.a;
    }

    public void y() {
        if (this.a) {
            try {
                b();
                if (this.g != null) {
                    Bitmap bitmap = this.g.getBitmap();
                    if (bitmap != null) {
                        bitmap.recycle();
                        this.g = null;
                    }
                }
                if (this.i != null) {
                    this.i.clear();
                    this.i = null;
                }
                if (this.d != null) {
                    this.d.clear();
                    this.d = null;
                }
                this.f = null;
                this.j = null;
                this.k = 0;
            } catch (Throwable th) {
                az.a(th, "PopupOverlay", "realDestroy");
                th.printStackTrace();
                Log.d("destroy erro", "MarkerDelegateImp destroy");
            }
        }
    }

    public void z() {
    }
}
