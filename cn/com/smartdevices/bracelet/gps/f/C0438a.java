package cn.com.smartdevices.bracelet.gps.f;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder.DeathRecipient;
import cn.com.smartdevices.bracelet.gps.model.c;
import cn.com.smartdevices.bracelet.gps.model.g;
import cn.com.smartdevices.bracelet.gps.services.C0463w;
import cn.com.smartdevices.bracelet.gps.services.SubGPSSportService;
import cn.com.smartdevices.bracelet.gps.services.a.a;
import cn.com.smartdevices.bracelet.gps.services.a.b;
import cn.com.smartdevices.bracelet.gps.services.a.d;
import cn.com.smartdevices.bracelet.gps.services.az;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.LocationSource.OnLocationChangedListener;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class C0438a implements b, LocationSource {
    protected final DeathRecipient a;
    protected long b;
    protected ConcurrentLinkedQueue<Integer> c;
    protected a d;
    protected e e;
    protected d f;
    protected C0440c g;
    protected d h;
    protected OnLocationChangedListener i;

    public C0438a(Context context) {
        this.a = new C0439b(this);
        this.b = -1;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.g = new C0440c(this);
        this.c = new ConcurrentLinkedQueue();
        context.bindService(new Intent(context, SubGPSSportService.class), this.g, 1);
    }

    public int a() {
        return this.f == null ? C0463w.DEFAULT.a() : this.f.c();
    }

    public az a(long j) {
        return this.f == null ? null : this.f.b(j);
    }

    public void a(int i) {
        if (this.h != null) {
            this.h.a(i, -1);
        }
    }

    public void a(Context context) {
        if (this.g != null) {
            context.unbindService(this.g);
        }
        if (this.h != null) {
            this.h = null;
        }
        if (this.e != null) {
            this.e = null;
        }
        if (this.c != null) {
            this.c.clear();
        }
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.h = dVar;
        }
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.e = eVar;
        }
    }

    public void a(c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException();
        }
        if (!(this.i == null || cVar == null)) {
            this.i.onLocationChanged(c.a(cVar));
        }
        if (this.h != null) {
            this.h.a(cVar);
        }
    }

    public void a(c cVar, c cVar2, g gVar) {
    }

    public void a(a aVar) {
        if (aVar != null) {
            this.d = aVar;
        }
    }

    public void a(List<c> list, g gVar) {
    }

    public void activate(OnLocationChangedListener onLocationChangedListener) {
        this.i = onLocationChangedListener;
    }

    public int b() {
        return this.f == null ? -1 : this.f.a(this.b);
    }

    public void b(int i) {
    }

    public void b(e eVar) {
        this.e = null;
    }

    public long c() {
        return this.f == null ? -1 : this.f.e();
    }

    public long d() {
        return this.b > 0 ? this.b : this.f != null ? this.f.f() : this.b;
    }

    public void deactivate() {
        this.i = null;
    }

    public int e() {
        return this.f == null ? -1 : this.f.c(this.b);
    }

    public abstract void f();

    public void g() {
        this.h = null;
    }

    public void h() {
        if (this.f != null && this.d != null) {
            this.f.b(this.d);
        }
    }
}
