package com.xiaomi.hm.health.bt.profile.b;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.xiaomi.hm.health.bt.c.x;
import com.xiaomi.hm.health.bt.d.b;
import com.xiaomi.hm.health.bt.d.d;
import com.xiaomi.hm.health.bt.d.e;
import com.xiaomi.hm.health.bt.d.f;
import com.xiaomi.hm.health.bt.model.i;
import com.xiaomi.hm.health.bt.model.m;
import com.xiaomi.hm.health.bt.profile.c.a;
import com.xiaomi.hm.health.bt.profile.c.g;
import java.util.ArrayList;
import java.util.Iterator;

public class j extends a implements d {
    private Context b = null;
    private f c = null;
    private k d = null;
    private c e = null;
    private ArrayList<d> f = new ArrayList();
    private ArrayList<e> g = new ArrayList();

    public j(Context context, g gVar) {
        super(context, gVar);
        this.b = context;
    }

    private void b(m mVar) {
        synchronized (this) {
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                ((d) it.next()).a(mVar);
            }
            it = this.g.iterator();
            while (it.hasNext()) {
                ((e) it.next()).a(mVar.d());
            }
        }
    }

    public m a() {
        return this.c != null ? this.c.y() : new m();
    }

    public void a(m mVar) {
        b(mVar);
    }

    public boolean a(int i, com.xiaomi.hm.health.bt.a.d dVar) {
        if (this.c == null || !this.c.u()) {
            return false;
        }
        new m(this.c, i, dVar).c();
        return true;
    }

    public boolean a(com.xiaomi.hm.health.bt.a.d dVar) {
        if (!f()) {
            return false;
        }
        new e(this.c, dVar).a();
        return true;
    }

    public boolean a(d dVar) {
        boolean z;
        synchronized (this) {
            if (this.f.contains(dVar)) {
                z = false;
            } else {
                this.f.add(dVar);
                if (this.c != null) {
                    dVar.a(a());
                }
                z = true;
            }
        }
        return z;
    }

    public boolean a(e eVar) {
        boolean z;
        synchronized (this) {
            if (this.g.contains(eVar)) {
                z = false;
            } else {
                this.g.add(eVar);
                if (this.c != null) {
                    eVar.a(a().d());
                }
                z = true;
            }
        }
        return z;
    }

    public boolean a(f fVar) {
        if (this.d != null || !f()) {
            return false;
        }
        this.d = new k(this.c, fVar);
        this.d.a();
        return true;
    }

    public boolean a(String str, b bVar) {
        if (!f()) {
            return false;
        }
        new d(this.c, str, bVar).a();
        return true;
    }

    public void b() {
        synchronized (this) {
            this.f.clear();
            this.g.clear();
        }
    }

    public void b(d dVar) {
        synchronized (this) {
            if (this.f.size() > 0 && this.f.contains(dVar)) {
                this.f.remove(dVar);
            }
        }
    }

    public void b(e eVar) {
        synchronized (this) {
            if (this.g.size() > 0 && this.g.contains(eVar)) {
                this.g.remove(eVar);
            }
        }
    }

    public boolean b(com.xiaomi.hm.health.bt.a.d dVar) {
        if (this.c == null || !this.c.u()) {
            return false;
        }
        this.e = new c(this.c, dVar);
        this.e.a();
        return true;
    }

    public boolean c() {
        if (this.e != null) {
            this.e.stop();
        }
        this.e = null;
        return true;
    }

    public boolean c(com.xiaomi.hm.health.bt.a.d dVar) {
        if (!f()) {
            return false;
        }
        new n(this.c, dVar).a();
        return true;
    }

    public boolean d() {
        if (f() && this.d != null) {
            this.d.stop();
        }
        this.d = null;
        return true;
    }

    public i e() {
        return f() ? this.c.D() : null;
    }

    protected x f(BluetoothDevice bluetoothDevice) {
        this.c = new f(this.b, bluetoothDevice, this);
        this.c.a((d) this);
        return this.c;
    }

    public boolean f() {
        return this.c != null && this.c.u();
    }
}
