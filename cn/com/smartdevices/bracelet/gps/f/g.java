package cn.com.smartdevices.bracelet.gps.f;

import android.content.Context;
import android.content.Intent;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.model.c;
import cn.com.smartdevices.bracelet.gps.services.N;
import cn.com.smartdevices.bracelet.gps.services.SubGPSSportService;
import cn.com.smartdevices.bracelet.gps.services.a.b;
import com.amap.api.maps.AMap;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public class g extends C0438a {
    private static final String k = "GPSSportController";
    protected t j = null;
    private WeakReference<Context> l = null;
    private N m = null;
    private h n = null;
    private ExecutorService o = null;
    private boolean p = false;

    public g(Context context, C c) {
        super(context);
        this.l = new WeakReference(context);
        this.j = l.a(context, 1, c);
    }

    private f l() {
        if (this.f == null) {
            return this.g != null ? this.g.a : f.DEFAULT;
        } else {
            this.f.d(this.b);
            return f.SERVICE_READY;
        }
    }

    private f m() {
        if (this.f == null) {
            return this.g != null ? this.g.a : f.DEFAULT;
        } else {
            this.f.e(this.b);
            return f.SERVICE_READY;
        }
    }

    private void n() {
        C0596r.e("UI", "retrieveTrackDataIfNeeded mTrackId = " + this.b + ",mIsMapLoaded = " + this.p);
        if (this.p && this.b > 0) {
            this.o = Executors.newFixedThreadPool(1);
            this.n = new h(this, 4, this.b);
            this.n.executeOnExecutor(this.o, new Long[0]);
        }
    }

    private f o() {
        if (this.f != null) {
            this.f.a((b) this);
            if (this.d != null) {
                this.f.a(this.d);
            }
            this.f.b((b) this);
            this.b = this.f.a((b) this, 4);
            return f.SERVICE_READY;
        } else if (this.g == null || this.g.a == f.SERVICE_UNBINDED) {
            return f.SERVICE_UNBINDED;
        } else {
            this.c.add(Integer.valueOf(1));
            return f.BINDING_SERVICE;
        }
    }

    private f p() {
        if (this.f == null) {
            return this.g != null ? this.g.a : f.DEFAULT;
        } else {
            this.f.d((b) this);
            if (this.d != null) {
                this.f.b(this.d);
            }
            this.f.f(this.b);
            return f.SERVICE_READY;
        }
    }

    public void a(int i) {
        super.a(i);
    }

    public void a(Context context) {
        super.a(context);
        if (this.j != null) {
            this.j.b();
        }
        if (this.n != null) {
            this.n.cancel(true);
            this.n = null;
        }
        if (this.o != null) {
            this.o.shutdown();
        }
        this.m = null;
    }

    public void a(c cVar) {
        super.a(cVar);
        this.j.d(cVar);
    }

    public void a(c cVar, c cVar2, cn.com.smartdevices.bracelet.gps.model.g gVar) {
        this.j.a(cVar, cVar2, gVar);
    }

    public void a(AMap aMap) {
        aMap.setLocationSource(this);
    }

    public void a(List<c> list, cn.com.smartdevices.bracelet.gps.model.g gVar) {
        if (list == null || list.size() <= 0) {
            throw new IllegalArgumentException();
        }
        this.j.a((List) list, gVar);
    }

    public void a(boolean z) {
        this.j.a(z);
    }

    public void b(int i) {
        super.b(i);
    }

    public void b(c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException();
        }
        this.j.c(cVar);
        this.j.b(cVar);
        this.j.d();
    }

    public f c(int i) {
        if (i.a(i)) {
            Context context = (Context) this.l.get();
            if (context != null) {
                switch (i) {
                    case l.a /*1*/:
                        context.startService(new Intent(context, SubGPSSportService.class));
                        f o = o();
                        n();
                        return o;
                    case a.k /*2*/:
                        return m();
                    case a.l /*3*/:
                        return l();
                    case a.aQ /*4*/:
                        f p = p();
                        context.stopService(new Intent(context, SubGPSSportService.class));
                        return p;
                }
            }
            return f.DEFAULT;
        }
        throw new IllegalArgumentException();
    }

    public void c(c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException();
        }
        this.j.b(cVar);
    }

    public void d(int i) {
        if (w.a(i)) {
            this.j.b(i);
            return;
        }
        throw new IllegalArgumentException("Dont support type =" + i);
    }

    protected void d(c cVar) {
        this.j.d(cVar);
    }

    public void f() {
        n();
    }

    public void i() {
        if (this.f != null) {
            this.f.g();
        }
    }

    public void j() {
        this.p = true;
        n();
    }

    protected void k() {
        this.j.a();
    }
}
