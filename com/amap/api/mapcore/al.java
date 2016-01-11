package com.amap.api.mapcore;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.amap.api.mapcore.util.az;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.RuntimeRemoteException;
import com.autonavi.amap.mapcore.IPoint;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;

class al extends View {
    t a;
    private CopyOnWriteArrayList<y> b = new CopyOnWriteArrayList();
    private List<ar> c = Collections.synchronizedList(new ArrayList());
    private IPoint d;
    private y e;
    private final Handler f = new Handler();

    public al(Context context) {
        super(context);
    }

    public al(Context context, AttributeSet attributeSet, t tVar) {
        super(context, attributeSet);
        this.a = tVar;
    }

    private void i() {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            y yVar = (y) it.next();
            if (this.e != null && this.e.h().equals(yVar.h())) {
                if (!this.e.F()) {
                    this.a.k();
                } else {
                    return;
                }
            }
        }
    }

    protected synchronized int a() {
        return this.b.size();
    }

    public synchronized int a(BitmapDescriptor bitmapDescriptor) {
        int b;
        if (bitmapDescriptor != null) {
            if (!(bitmapDescriptor.getBitmap() == null || bitmapDescriptor.getBitmap().isRecycled())) {
                for (int i = 0; i < this.c.size(); i++) {
                    ar arVar = (ar) this.c.get(i);
                    if (arVar.a().equals(bitmapDescriptor)) {
                        b = arVar.b();
                        break;
                    }
                }
                b = 0;
            }
        }
        b = 0;
        return b;
    }

    public y a(MotionEvent motionEvent) {
        for (int size = this.b.size() - 1; size >= 0; size--) {
            y yVar = (y) this.b.get(size);
            if (a(yVar.d(), (int) motionEvent.getX(), (int) motionEvent.getY())) {
                this.e = yVar;
                return this.e;
            }
        }
        return null;
    }

    public synchronized void a(ar arVar) {
        if (arVar != null) {
            if (arVar.b() != 0) {
                this.c.add(arVar);
            }
        }
    }

    public synchronized void a(y yVar) {
        e(yVar);
        this.b.remove(yVar);
        this.b.add(yVar);
    }

    public void a(GL10 gl10) {
        this.f.postDelayed(new Runnable(this) {
            final /* synthetic */ al a;

            {
                this.a = r1;
            }

            public void run() {
                try {
                    this.a.i();
                } catch (Throwable e) {
                    az.a(e, "MapOverlayImageView", "redrawInfoWindow post");
                    e.printStackTrace();
                }
            }
        }, 0);
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((y) it.next()).a(gl10, this.a);
        }
    }

    public boolean a(Rect rect, int i, int i2) {
        return rect.contains(i, i2);
    }

    public synchronized void b() {
        try {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                ((y) it.next()).b();
            }
        } catch (Throwable e) {
            az.a(e, "MapOverlayImageView", "clear");
            e.printStackTrace();
        }
        this.b.clear();
    }

    public boolean b(MotionEvent motionEvent) {
        for (int size = this.b.size() - 1; size >= 0; size--) {
            y yVar = (y) this.b.get(size);
            Rect d = yVar.d();
            boolean a = a(d, (int) motionEvent.getX(), (int) motionEvent.getY());
            if (a) {
                this.d = new IPoint(d.left + (d.width() / 2), d.top);
                this.e = yVar;
                return a;
            }
        }
        return false;
    }

    public synchronized boolean b(y yVar) {
        e(yVar);
        return this.b.remove(yVar);
    }

    public synchronized void c() {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            y yVar = (y) it.next();
            try {
                if (yVar.o()) {
                    yVar.r();
                }
            } catch (Throwable th) {
                az.a(th, "MapOverlayImageView", "calFPoint");
                th.printStackTrace();
            }
        }
    }

    public synchronized void c(y yVar) {
        try {
            int size = this.b.size() - 1;
            this.b.set(this.b.indexOf(yVar), this.b.get(size));
            this.b.set(size, yVar);
        } catch (Throwable th) {
            az.a(th, "MapOverlayImageView", "set2Top");
            th.printStackTrace();
        }
    }

    public void d(y yVar) {
        if (this.d == null) {
            this.d = new IPoint();
        }
        Rect d = yVar.d();
        this.d = new IPoint(d.left + (d.width() / 2), d.top);
        this.e = yVar;
        try {
            this.a.a(this.e);
        } catch (Throwable e) {
            az.a(e, "MapOverlayImageView", "showInfoWindow");
            e.printStackTrace();
        }
    }

    public synchronized boolean d() {
        boolean z;
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            if (!((y) it.next()).c()) {
                z = false;
                break;
            }
        }
        z = true;
        return z;
    }

    public y e() {
        return this.e;
    }

    public void e(y yVar) {
        if (f(yVar)) {
            this.a.y();
            this.e = null;
        }
    }

    public synchronized void f() {
        try {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                y yVar = (y) it.next();
                if (yVar != null) {
                    yVar.p();
                }
            }
            b();
            this.c.clear();
        } catch (Throwable th) {
            az.a(th, "MapOverlayImageView", "destroy");
            th.printStackTrace();
            Log.d("amapApi", "MapOverlayImageView clear erro" + th.getMessage());
        }
        return;
    }

    public boolean f(y yVar) {
        try {
            return this.a.b(yVar);
        } catch (Throwable e) {
            az.a(e, "MapOverlayImageView", "isInfoWindowShown");
            throw new RuntimeRemoteException(e);
        }
    }

    public synchronized List<Marker> g() {
        List<Marker> arrayList;
        arrayList = new ArrayList();
        try {
            Rect rect = new Rect(0, 0, this.a.h(), this.a.i());
            IPoint iPoint = new IPoint();
            for (int i = 0; i < this.b.size(); i++) {
                LatLng g = ((y) this.b.get(i)).g();
                if (g != null) {
                    this.a.b(g.latitude, g.longitude, iPoint);
                    if (a(rect, iPoint.x, iPoint.y)) {
                        arrayList.add(new Marker((y) this.b.get(i)));
                    }
                }
            }
        } catch (Throwable th) {
            az.a(th, "MapOverlayImageView", "getMapScreenMarkers");
            th.printStackTrace();
        }
        return arrayList;
    }

    public synchronized void h() {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            y yVar = (y) it.next();
            if (yVar.x()) {
                yVar.y();
            }
        }
    }
}
