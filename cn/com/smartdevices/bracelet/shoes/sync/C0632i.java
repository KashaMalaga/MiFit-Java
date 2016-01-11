package cn.com.smartdevices.bracelet.shoes.sync;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.eventbus.shoes.EventDeviceState;
import cn.com.smartdevices.bracelet.shoes.data.db.t;
import cn.com.smartdevices.bracelet.shoes.model.c;
import cn.com.smartdevices.bracelet.shoes.sync.b.a;
import cn.com.smartdevices.bracelet.shoes.sync.b.e;
import com.xiaomi.hm.health.bt.bleservice.BLEService;
import com.xiaomi.hm.health.bt.d.b;
import com.xiaomi.hm.health.bt.model.HwConnStatus;
import com.xiaomi.hm.health.bt.model.i;
import com.xiaomi.hm.health.bt.model.m;
import com.xiaomi.hm.health.bt.profile.b.j;
import com.xiaomi.hm.health.bt.profile.c.d;
import com.xiaomi.hm.health.bt.profile.c.f;
import com.xiaomi.hm.health.bt.profile.c.g;
import com.xiaomi.hm.health.bt.profile.c.h;
import de.greenrobot.event.EventBus;
import java.io.Closeable;
import java.util.UUID;
import kankan.wheel.widget.l;

public class C0632i implements e, f, Closeable {
    public static final boolean a = false;
    public static final boolean b = false;
    private a c = null;
    private cn.com.smartdevices.bracelet.shoes.sync.b.f d = null;
    private j e = null;
    private C0634k f = null;
    private Context g = null;
    private c h = null;
    private String i = null;
    private boolean j = false;

    public C0632i(Context context, c cVar) {
        a(context, cVar, false);
    }

    public C0632i(Context context, c cVar, boolean z) {
        a(context, cVar, z);
    }

    private static j a(Context context, String str, boolean z) {
        j jVar = (j) d.a().b(str);
        if (jVar != null) {
            return jVar;
        }
        g gVar = new g(str);
        gVar.a(z).a(com.xiaomi.hm.health.bt.b.c.SHOES).a(1, 90000).b(true);
        return (j) d.a().a(context, gVar);
    }

    private void a(int i) {
        if (this.d != null) {
            this.d.a(i);
        }
    }

    private void a(Context context, c cVar, boolean z) {
        this.g = context.getApplicationContext();
        this.h = cVar;
        this.i = b(z);
        this.f = new C0634k(this);
        this.j = z;
        C0635l.a(this.g).b(this.i);
    }

    public static boolean a(Context context, int i) {
        if (context == null) {
            return false;
        }
        String a = C0635l.a(context).a();
        if (TextUtils.isEmpty(a)) {
            return false;
        }
        j a2 = C0632i.a(context, a, true);
        return a2 != null ? i < 0 ? a2.a(39, null) : a2.a(i, null) : false;
    }

    static boolean a(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return false;
        }
        com.xiaomi.hm.health.bt.profile.c.a aVar = (j) d.a().b(str);
        if (aVar == null) {
            return false;
        }
        aVar.b();
        d.a().a(aVar);
        EventBus.getDefault().post(new EventDeviceState(3, 7));
        return true;
    }

    private int b(h hVar) {
        switch (C0633j.a[hVar.ordinal()]) {
            case l.a /*1*/:
                C0596r.e("ConnHelper", "CONNECTING");
                C0632i.b(this.g, 2);
                return 4;
            case kankan.wheel.widget.a.k /*2*/:
                C0596r.e("ConnHelper", "CONNECTED");
                C0632i.b(this.g, 6);
                return 5;
            case kankan.wheel.widget.a.l /*3*/:
                C0596r.d("ConnHelper", "FALIED_TO_CONNECT");
                C0632i.b(this.g, 1);
                return 6;
            case kankan.wheel.widget.a.aQ /*4*/:
                C0596r.e("ConnHelper", "SCANNING");
                C0632i.b(this.g, 0);
                return 1;
            case kankan.wheel.widget.a.X /*5*/:
                C0596r.e("ConnHelper", "FOUND");
                C0632i.b(this.g, 0);
                return 2;
            case kankan.wheel.widget.a.bt /*6*/:
                C0596r.d("ConnHelper", "FAILED_TO_SCAN");
                C0632i.b(this.g, 1);
                return 3;
            case kankan.wheel.widget.a.bc /*7*/:
                C0596r.e("ConnHelper", "UNKNOWN");
                C0632i.b(this.g, 0);
                return 0;
            default:
                C0596r.e("ConnHelper", "UNKNOWN " + hVar);
                C0632i.b(this.g, 0);
                return 0;
        }
    }

    private String b(boolean z) {
        return z ? this.h + "@" + UUID.randomUUID().toString() : UUID.randomUUID().toString();
    }

    private static void b(Context context, int i) {
        Parcelable hwConnStatus = new HwConnStatus(i, com.xiaomi.hm.health.bt.b.c.SHOES);
        Intent intent = new Intent(BLEService.b);
        intent.putExtra(BLEService.j, hwConnStatus);
        context.sendBroadcast(intent);
    }

    private boolean c(com.xiaomi.hm.health.bt.a.d dVar) {
        if (this.e == null || !this.e.f()) {
            return false;
        }
        this.e.a(39, dVar);
        return true;
    }

    private void o() {
        this.d = null;
        if (this.e != null) {
            this.e.b((f) this);
            if (!(!this.j || this.e.f() || this.h == null)) {
                C0596r.d("ConnHelper", "destroy.from bound op disconned?:" + C0632i.a(this.g, this.h.b()) + ",mac:" + this.h.b());
            }
            this.e = null;
        }
        C0635l.a(this.g).c(this.i);
        C0596r.e("ConnHelper", "destroy");
    }

    private void p() {
        if (this.e == null || this.h == null || this.h.e()) {
            C0596r.d("ConnHelper", "saveDeviceInfoIfNeeded mIdentity is invalid return");
            return;
        }
        i e = this.e.e();
        if (e != null) {
            if (TextUtils.isEmpty(this.h.a())) {
                this.h.a(e.a);
                t.h(this.g, this.h);
            }
            if (!TextUtils.isEmpty(e.c)) {
                cn.com.smartdevices.bracelet.shoes.c.a(this.g, this.h.b(), e.c);
            }
        }
    }

    public void a(cn.com.smartdevices.bracelet.shoes.sync.b.f fVar) {
        this.d = fVar;
    }

    public void a(h hVar) {
        a(b(hVar));
        if (h.CONNECTED.equals(hVar)) {
            l();
            p();
        }
    }

    public boolean a() {
        return a(false);
    }

    public boolean a(a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException();
        } else if (this.e == null || !this.e.f()) {
            return false;
        } else {
            this.c = aVar;
            if (!this.e.c(this.f)) {
                return false;
            }
            this.c.d();
            return true;
        }
    }

    public boolean a(com.xiaomi.hm.health.bt.a.d dVar) {
        return this.e != null ? this.e.a(dVar) : false;
    }

    public boolean a(com.xiaomi.hm.health.bt.d.d dVar) {
        if (dVar != null) {
            return this.e == null ? false : this.e.a(dVar);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean a(com.xiaomi.hm.health.bt.d.e eVar) {
        if (eVar != null) {
            return this.e == null ? false : this.e.a(eVar);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean a(com.xiaomi.hm.health.bt.d.f fVar) {
        if (fVar != null) {
            return (this.e == null || !this.e.f()) ? false : this.e.a(fVar);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean a(String str, b bVar) {
        if (bVar != null) {
            return (this.e == null || !this.e.f()) ? false : this.e.a(str, bVar);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean a(boolean z) {
        C0596r.e("ConnHelper", "connect mAddress = " + this.h + ",mClassTag = " + this.i);
        if (this.g == null || this.h == null || this.h.e()) {
            return false;
        }
        this.e = C0632i.a(this.g, this.h.b(), z);
        if (this.e == null) {
            C0596r.d("ConnHelper", "Failed to get connection address = " + this.h);
            return false;
        }
        this.e.a((f) this);
        a(b(this.e.g()));
        return this.e.f();
    }

    public int b() {
        return this.e == null ? 0 : b(this.e.g());
    }

    public void b(cn.com.smartdevices.bracelet.shoes.sync.b.f fVar) {
        this.d = null;
    }

    public boolean b(com.xiaomi.hm.health.bt.a.d dVar) {
        return (this.e == null || !this.e.f()) ? false : this.e.b(dVar);
    }

    public boolean b(com.xiaomi.hm.health.bt.d.d dVar) {
        if (this.e == null || dVar == null) {
            return false;
        }
        this.e.b(dVar);
        return true;
    }

    public boolean b(com.xiaomi.hm.health.bt.d.e eVar) {
        if (this.e == null || eVar == null) {
            return false;
        }
        this.e.b(eVar);
        return true;
    }

    public h c() {
        return this.e == null ? null : this.e.g();
    }

    public void close() {
        o();
    }

    public String d() {
        if (this.e == null) {
            return com.xiaomi.e.a.f;
        }
        i e = this.e.e();
        return e == null ? com.xiaomi.e.a.f : e.a;
    }

    public String e() {
        i e = (this.e == null || !this.e.f()) ? null : this.e.e();
        return e == null ? null : e.c;
    }

    public c f() {
        return this.h;
    }

    public void finalize() {
    }

    public String g() {
        return this.h == null ? com.xiaomi.e.a.f : this.h.b();
    }

    public m h() {
        return this.e != null ? this.e.a() : new m();
    }

    public boolean i() {
        return this.e == null ? false : this.e.f();
    }

    public boolean j() {
        if (this.e == null) {
            return false;
        }
        h g = this.e.g();
        return (g == h.CONNECTED || g == h.CONNECT_FAILED || h.SEARCH_FAILED == g) ? false : true;
    }

    public boolean k() {
        return this.e == null ? false : h().b();
    }

    public boolean l() {
        return c(null);
    }

    public boolean m() {
        return (this.e == null || !this.e.f()) ? false : this.e.c();
    }

    public boolean n() {
        return (this.e == null || !this.e.f()) ? false : this.e.d();
    }
}
