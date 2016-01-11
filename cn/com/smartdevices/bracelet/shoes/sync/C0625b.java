package cn.com.smartdevices.bracelet.shoes.sync;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.data.db.t;
import cn.com.smartdevices.bracelet.shoes.model.c;
import cn.com.smartdevices.bracelet.shoes.sync.b.a;
import com.xiaomi.hm.health.bt.d.d;
import com.xiaomi.hm.health.bt.d.e;
import com.xiaomi.hm.health.bt.model.m;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

class C0625b {
    private static final String a = "SDC";
    private Context b = null;
    private C0632i c = null;
    private boolean d = false;
    private C0627d e = null;
    private WeakReference<ConcurrentHashMap<c, C0624a>> f = null;
    private boolean g = true;

    public C0625b(Context context, int i, boolean z, boolean z2) {
        this.g = z2;
        this.d = z;
        this.b = context.getApplicationContext();
        this.e = new C0627d();
        C0635l.a(context).a(this.e);
        c b = C0635l.a(context).b();
        C0596r.e(a, "DeviceDataConsumer identity = " + b);
        b(b);
    }

    private C0624a a(c cVar) {
        if (cVar == null || cVar.e()) {
            return null;
        }
        ConcurrentHashMap concurrentHashMap;
        if (this.f == null || this.f.get() == null) {
            ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
            concurrentHashMap2.put(cVar, new C0624a(this.b, cVar, this.d, this.g));
            this.f = new WeakReference(concurrentHashMap2);
            concurrentHashMap = concurrentHashMap2;
        } else {
            concurrentHashMap = (ConcurrentHashMap) this.f.get();
        }
        if (concurrentHashMap == null) {
            return null;
        }
        C0624a c0624a = (C0624a) concurrentHashMap.get(cVar);
        if (c0624a != null) {
            return c0624a;
        }
        c0624a = new C0624a(this.b, cVar, this.d, this.g);
        concurrentHashMap.put(cVar, c0624a);
        return c0624a;
    }

    private synchronized boolean b(c cVar) {
        boolean z = true;
        synchronized (this) {
            if (cVar != null) {
                if (!cVar.e()) {
                    this.c = new C0632i(this.b, cVar);
                    this.c.a(true);
                }
            }
            C0596r.d(a, "initShoesConnection identity = " + cVar);
            z = false;
        }
        return z;
    }

    private synchronized void i() {
        if (this.c != null) {
            this.c.close();
            this.c = null;
        }
        C0596r.e(a, "releaseShoesConnHelper");
    }

    private synchronized boolean j() {
        boolean z = false;
        synchronized (this) {
            if (this.c == null) {
                C0596r.d(a, "connHelper = " + this.c);
            } else {
                c f = this.c.f();
                a a = a(f);
                if (a == null) {
                    C0596r.d(a, "Callback is invalid " + f);
                } else if (a.a()) {
                    C0596r.e(a, "In syncing = " + f);
                    a.c();
                    z = true;
                } else {
                    if (this.c.j()) {
                        a.b();
                    }
                    C0596r.e(a, "mAddress = " + f);
                    z = this.c.a(a);
                }
            }
        }
        return z;
    }

    public void a() {
        i();
        if (this.e != null) {
            C0635l.a(this.b).b(this.e);
            this.e = null;
        }
        C0596r.e(a, "destroy");
    }

    public synchronized boolean a(d dVar) {
        boolean z;
        if (this.c == null) {
            z = false;
        } else {
            this.c.b(dVar);
            z = true;
        }
        return z;
    }

    public synchronized boolean a(e eVar) {
        boolean z;
        if (this.c == null) {
            z = false;
        } else {
            this.c.b(eVar);
            z = true;
        }
        return z;
    }

    public synchronized m b() {
        return this.c == null ? new m() : this.c.h();
    }

    public synchronized boolean b(d dVar) {
        boolean z;
        if (this.c == null || dVar == null) {
            z = false;
        } else {
            this.c.a(dVar);
            z = true;
        }
        return z;
    }

    public synchronized boolean b(e eVar) {
        boolean z;
        if (this.c == null || eVar == null) {
            z = false;
        } else {
            this.c.a(eVar);
            z = true;
        }
        return z;
    }

    public synchronized String c() {
        return this.c.g();
    }

    public synchronized String d() {
        String str = null;
        synchronized (this) {
            c f = this.c.f();
            if (!(f == null || f.e())) {
                cn.com.smartdevices.bracelet.shoes.model.a c = t.c(this.b, f);
                if (c != null) {
                    str = com.xiaomi.hm.health.bt.b.c.SHOES.b() + kankan.wheel.widget.a.ci + c.c() + kankan.wheel.widget.a.ci + c.o();
                }
            }
        }
        return str;
    }

    public synchronized boolean e() {
        return this.c == null ? false : this.c.i();
    }

    public boolean f() {
        return this.c == null ? false : this.c.k();
    }

    public void finalize() {
        C0596r.e(a, "finalize");
    }

    public synchronized boolean g() {
        return this.c != null;
    }

    public boolean h() {
        return j();
    }
}
