package com.amap.api.mapcore;

import android.graphics.Bitmap;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.amap.api.mapcore.util.az;
import com.amap.api.mapcore.util.f;
import com.amap.api.mapcore.util.f.d;
import com.amap.api.mapcore.util.k;
import com.amap.api.mapcore.util.m;
import com.amap.api.mapcore.util.o;
import com.amap.api.mapcore.util.u;
import com.amap.api.maps.model.TileOverlayOptions;
import com.amap.api.maps.model.TileProvider;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;

public class ay implements af {
    private static int f = 0;
    private az a;
    private TileProvider b;
    private Float c;
    private boolean d;
    private t e;
    private int g = PersonInfo.INCOMING_CALL_DISABLE_BIT;
    private int h = PersonInfo.INCOMING_CALL_DISABLE_BIT;
    private int i = -1;
    private k j;
    private CopyOnWriteArrayList<a> k = new CopyOnWriteArrayList();
    private boolean l = false;
    private b m = null;
    private String n = null;
    private FloatBuffer o = null;

    public class a implements Cloneable {
        public int a;
        public int b;
        public int c;
        public int d;
        public IPoint e;
        public int f = 0;
        public boolean g = false;
        public FloatBuffer h = null;
        public Bitmap i = null;
        public com.amap.api.mapcore.util.m.a j = null;
        public int k = 0;
        final /* synthetic */ ay l;

        public a(ay ayVar, int i, int i2, int i3, int i4) {
            this.l = ayVar;
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }

        public a(ay ayVar, a aVar) {
            this.l = ayVar;
            this.a = aVar.a;
            this.b = aVar.b;
            this.c = aVar.c;
            this.d = aVar.d;
            this.e = aVar.e;
            this.h = aVar.h;
        }

        public a a() {
            try {
                a aVar = (a) super.clone();
                aVar.a = this.a;
                aVar.b = this.b;
                aVar.c = this.c;
                aVar.d = this.d;
                aVar.e = (IPoint) this.e.clone();
                aVar.h = this.h.asReadOnlyBuffer();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return new a(this.l, this);
        }

        public void a(Bitmap bitmap) {
            if (bitmap != null && !bitmap.isRecycled()) {
                try {
                    this.j = null;
                    this.i = u.a(bitmap, u.a(bitmap.getWidth()), u.a(bitmap.getHeight()));
                    this.l.e.e(false);
                } catch (Throwable th) {
                    az.a(th, "TileOverlayDelegateImp", "setBitmap");
                    th.printStackTrace();
                    if (this.k < 3) {
                        this.l.j.a(true, this);
                        this.k++;
                        o.a("TileOverlayDelegateImp", "setBitmap Throwable: " + this + "retry: " + this.k, 111);
                    }
                }
            } else if (this.k < 3) {
                this.l.j.a(true, this);
                this.k++;
                o.a("TileOverlayDelegateImp", "setBitmap failed: " + this + "retry: " + this.k, 111);
            }
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }

        public void b() {
            m.a(this);
            if (this.g) {
                this.l.a.c.add(Integer.valueOf(this.f));
            }
            this.g = false;
            this.f = 0;
            if (!(this.i == null || this.i.isRecycled())) {
                this.i.recycle();
            }
            this.i = null;
            if (this.h != null) {
                this.h.clear();
            }
            this.h = null;
            this.j = null;
        }

        public /* synthetic */ Object clone() {
            return a();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b && this.c == aVar.c && this.d == aVar.d;
        }

        public int hashCode() {
            return (((this.a * 7) + (this.b * 11)) + (this.c * 13)) + this.d;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a);
            stringBuilder.append("-");
            stringBuilder.append(this.b);
            stringBuilder.append("-");
            stringBuilder.append(this.c);
            stringBuilder.append("-");
            stringBuilder.append(this.d);
            return stringBuilder.toString();
        }
    }

    class b extends f<t, Void, List<a>> {
        final /* synthetic */ ay a;
        private int e;
        private boolean f;

        public b(ay ayVar, boolean z) {
            this.a = ayVar;
            this.f = z;
        }

        protected List<a> a(t... tVarArr) {
            int i;
            int i2 = 0;
            try {
                int h = tVarArr[0].h();
                i = tVarArr[0].i();
                this.e = (int) tVarArr[0].z();
                i2 = h;
            } catch (Throwable th) {
                i = 0;
            }
            return (i2 <= 0 || i <= 0) ? null : this.a.a(this.e, i2, i);
        }

        protected void a(List<a> list) {
            if (list != null && list.size() > 0) {
                this.a.a((List) list, this.e, this.f);
                list.clear();
            }
        }
    }

    public ay(TileOverlayOptions tileOverlayOptions, az azVar) {
        this.a = azVar;
        this.b = tileOverlayOptions.getTileProvider();
        this.g = this.b.getTileWidth();
        this.h = this.b.getTileHeight();
        int a = u.a(this.g);
        float f = ((float) this.g) / ((float) a);
        float a2 = ((float) this.h) / ((float) u.a(this.h));
        this.o = u.a(new float[]{0.0f, a2, f, a2, f, 0.0f, 0.0f, 0.0f});
        this.c = Float.valueOf(tileOverlayOptions.getZIndex());
        this.d = tileOverlayOptions.isVisible();
        this.n = c();
        this.e = this.a.a();
        this.i = Integer.valueOf(this.n.substring("TileOverlay".length())).intValue();
        com.amap.api.mapcore.util.j.a aVar = new com.amap.api.mapcore.util.j.a(this.a.getContext(), this.n);
        aVar.a(tileOverlayOptions.getMemoryCacheEnabled());
        aVar.b(tileOverlayOptions.getDiskCacheEnabled());
        aVar.a(tileOverlayOptions.getMemCacheSize());
        aVar.b(tileOverlayOptions.getDiskCacheSize());
        String diskCacheDir = tileOverlayOptions.getDiskCacheDir();
        if (!(diskCacheDir == null || diskCacheDir.equals(com.xiaomi.e.a.f))) {
            aVar.a(diskCacheDir);
        }
        this.j = new k(this.a.getContext(), this.g, this.h);
        this.j.a(this.b);
        this.j.a(aVar);
        b(true);
    }

    private static String a(String str) {
        f++;
        return str + f;
    }

    private ArrayList<a> a(int i, int i2, int i3) {
        MapProjection c = this.e.c();
        FPoint fPoint = new FPoint();
        IPoint iPoint = new IPoint();
        IPoint iPoint2 = new IPoint();
        c.win2Map(0, 0, fPoint);
        c.map2Geo(fPoint.x, fPoint.y, iPoint);
        int min = Math.min(Integer.MAX_VALUE, iPoint.x);
        int max = Math.max(0, iPoint.x);
        int min2 = Math.min(Integer.MAX_VALUE, iPoint.y);
        int max2 = Math.max(0, iPoint.y);
        c.win2Map(i2, 0, fPoint);
        c.map2Geo(fPoint.x, fPoint.y, iPoint);
        min = Math.min(min, iPoint.x);
        max = Math.max(max, iPoint.x);
        min2 = Math.min(min2, iPoint.y);
        max2 = Math.max(max2, iPoint.y);
        c.win2Map(0, i3, fPoint);
        c.map2Geo(fPoint.x, fPoint.y, iPoint);
        min = Math.min(min, iPoint.x);
        max = Math.max(max, iPoint.x);
        min2 = Math.min(min2, iPoint.y);
        max2 = Math.max(max2, iPoint.y);
        c.win2Map(i2, i3, fPoint);
        c.map2Geo(fPoint.x, fPoint.y, iPoint);
        min = Math.min(min, iPoint.x);
        int max3 = Math.max(max, iPoint.x);
        max = Math.min(min2, iPoint.y);
        int max4 = Math.max(max2, iPoint.y);
        int i4 = min - ((1 << (20 - i)) * this.g);
        int i5 = max - ((1 << (20 - i)) * this.h);
        c.getGeoCenter(iPoint2);
        max = (iPoint2.x >> (20 - i)) / this.g;
        min2 = (iPoint2.y >> (20 - i)) / this.h;
        int i6 = (max << (20 - i)) * this.g;
        int i7 = (min2 << (20 - i)) * this.h;
        a aVar = new a(this, max, min2, i, this.i);
        aVar.e = new IPoint(i6, i7);
        ArrayList<a> arrayList = new ArrayList();
        arrayList.add(aVar);
        min = 1;
        while (true) {
            Object obj = null;
            for (i6 = max - min; i6 <= max + min; i6++) {
                i7 = min2 + min;
                IPoint iPoint3 = new IPoint((i6 << (20 - i)) * this.g, (i7 << (20 - i)) * this.h);
                if (iPoint3.x < max3 && iPoint3.x > i4 && iPoint3.y < max4 && iPoint3.y > i5) {
                    if (obj == null) {
                        obj = 1;
                    }
                    a aVar2 = new a(this, i6, i7, i, this.i);
                    aVar2.e = iPoint3;
                    arrayList.add(aVar2);
                }
                i7 = min2 - min;
                iPoint3 = new IPoint((i6 << (20 - i)) * this.g, (i7 << (20 - i)) * this.h);
                if (iPoint3.x < max3 && iPoint3.x > i4 && iPoint3.y < max4 && iPoint3.y > i5) {
                    if (obj == null) {
                        obj = 1;
                    }
                    aVar2 = new a(this, i6, i7, i, this.i);
                    aVar2.e = iPoint3;
                    arrayList.add(aVar2);
                }
            }
            for (i7 = (min2 + min) - 1; i7 > min2 - min; i7--) {
                i6 = max + min;
                iPoint3 = new IPoint((i6 << (20 - i)) * this.g, (i7 << (20 - i)) * this.h);
                if (iPoint3.x < max3 && iPoint3.x > i4 && iPoint3.y < max4 && iPoint3.y > i5) {
                    if (obj == null) {
                        obj = 1;
                    }
                    aVar2 = new a(this, i6, i7, i, this.i);
                    aVar2.e = iPoint3;
                    arrayList.add(aVar2);
                }
                i6 = max - min;
                iPoint3 = new IPoint((i6 << (20 - i)) * this.g, (i7 << (20 - i)) * this.h);
                if (iPoint3.x < max3 && iPoint3.x > i4 && iPoint3.y < max4 && iPoint3.y > i5) {
                    if (obj == null) {
                        obj = 1;
                    }
                    aVar2 = new a(this, i6, i7, i, this.i);
                    aVar2.e = iPoint3;
                    arrayList.add(aVar2);
                }
            }
            if (obj == null) {
                return arrayList;
            }
            min++;
        }
    }

    private void a(GL10 gl10, int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (floatBuffer != null && floatBuffer2 != null) {
            gl10.glEnable(3042);
            gl10.glTexEnvf(8960, 8704, 8448.0f);
            gl10.glBlendFunc(770, 771);
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

    private boolean a(a aVar) {
        MapProjection c = this.e.c();
        float f = (float) aVar.c;
        int i = this.g;
        int i2 = this.h;
        int i3 = aVar.e.x;
        int i4 = aVar.e.y + ((1 << (20 - ((int) f))) * i2);
        r6 = new float[12];
        FPoint fPoint = new FPoint();
        c.geo2Map(i3, i4, fPoint);
        FPoint fPoint2 = new FPoint();
        c.geo2Map(((1 << (20 - ((int) f))) * i) + i3, i4, fPoint2);
        FPoint fPoint3 = new FPoint();
        c.geo2Map((i * (1 << (20 - ((int) f)))) + i3, i4 - ((1 << (20 - ((int) f))) * i2), fPoint3);
        FPoint fPoint4 = new FPoint();
        c.geo2Map(i3, i4 - ((1 << (20 - ((int) f))) * i2), fPoint4);
        r6[0] = fPoint.x;
        r6[1] = fPoint.y;
        r6[2] = 0.0f;
        r6[3] = fPoint2.x;
        r6[4] = fPoint2.y;
        r6[5] = 0.0f;
        r6[6] = fPoint3.x;
        r6[7] = fPoint3.y;
        r6[8] = 0.0f;
        r6[9] = fPoint4.x;
        r6[10] = fPoint4.y;
        r6[11] = 0.0f;
        if (aVar.h == null) {
            aVar.h = u.a(r6);
        } else {
            aVar.h = u.a(r6, aVar.h);
        }
        return true;
    }

    private boolean a(List<a> list, int i, boolean z) {
        int i2 = 0;
        if (list == null) {
            return false;
        }
        if (this.k == null) {
            return false;
        }
        int i3;
        Iterator it = this.k.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            for (a aVar2 : list) {
                if (aVar.equals(aVar2) && aVar.g) {
                    aVar2.g = aVar.g;
                    aVar2.f = aVar.f;
                    i3 = 1;
                    break;
                }
            }
            i3 = 0;
            if (i3 == 0) {
                aVar.b();
            }
        }
        this.k.clear();
        if (i > ((int) this.e.m()) || i < ((int) this.e.n())) {
            return false;
        }
        i3 = list.size();
        if (i3 <= 0) {
            return false;
        }
        while (i2 < i3) {
            aVar = (a) list.get(i2);
            if (aVar != null) {
                this.k.add(aVar);
                if (!aVar.g) {
                    this.j.a(z, aVar);
                }
            }
            i2++;
        }
        return true;
    }

    public void a() {
        if (this.m != null && this.m.a() == d.RUNNING) {
            this.m.a(true);
        }
        Iterator it = this.k.iterator();
        while (it.hasNext()) {
            ((a) it.next()).b();
        }
        this.k.clear();
        this.j.h();
        this.a.b((af) this);
        this.e.e(false);
    }

    public void a(float f) {
        this.c = Float.valueOf(f);
        this.a.c();
    }

    public void a(GL10 gl10) {
        if (this.k != null && this.k.size() != 0) {
            Iterator it = this.k.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (!aVar.g) {
                    try {
                        IPoint iPoint = aVar.e;
                        if (!(aVar.i == null || aVar.i.isRecycled() || iPoint == null)) {
                            aVar.f = u.a(gl10, aVar.i);
                            if (aVar.f != 0) {
                                aVar.g = true;
                            }
                            aVar.i = null;
                        }
                    } catch (Throwable th) {
                        az.a(th, "TileOverlayDelegateImp", "drawTiles");
                        o.a("TileOverlayDelegateImp", th.toString(), 112);
                    }
                }
                if (aVar.g) {
                    a(aVar);
                    a(gl10, aVar.f, aVar.h, this.o);
                }
            }
        }
    }

    public void a(boolean z) {
        this.d = z;
        this.e.e(false);
        if (z) {
            b(true);
        }
    }

    public boolean a(af afVar) {
        return equals(afVar) || afVar.c().equals(c());
    }

    public void b() {
        this.j.f();
    }

    public void b(boolean z) {
        if (!this.l) {
            if (this.m != null && this.m.a() == d.RUNNING) {
                this.m.a(true);
            }
            this.m = new b(this, z);
            this.m.c((Object[]) new t[]{this.e});
        }
    }

    public String c() {
        if (this.n == null) {
            this.n = a("TileOverlay");
        }
        return this.n;
    }

    public void c(boolean z) {
        if (this.l != z) {
            this.l = z;
            this.j.b(z);
        }
    }

    public float d() {
        return this.c.floatValue();
    }

    public boolean e() {
        return this.d;
    }

    public int f() {
        return super.hashCode();
    }

    public void g() {
        this.j.b(false);
        this.j.a(true);
        this.j.g();
    }

    public void h() {
        this.j.a(false);
    }
}
