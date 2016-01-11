package cn.com.smartdevices.bracelet.gps.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.support.v4.content.v;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.c.a.p;
import cn.com.smartdevices.bracelet.gps.c.c;
import com.xiaomi.hm.health.bt.bleservice.a;
import com.xiaomi.hm.health.bt.model.HwBatteryStatus;
import com.xiaomi.hm.health.bt.model.HwConnStatus;
import com.xiaomi.hm.health.bt.model.f;
import com.xiaomi.hm.health.bt.model.h;
import com.xiaomi.hm.health.bt.profile.a.d;
import com.xiaomi.hm.health.bt.profile.a.j;
import de.greenrobot.event.EventBus;

public class I {
    public static final int a = 0;
    public static final int b = 2;
    public static final int c = 34;
    public static final int d = 546;
    public static final int e = 8738;
    public static final int f = -1;
    public static final int g = 60;
    protected static final String h = "HRProvider";
    private final Context i;
    private final d j;
    private cn.com.smartdevices.bracelet.gps.c.d k = null;
    private L l;
    private int m = a;
    private v n;
    private BroadcastReceiver o;
    private final M p = new M();

    public I(Context context) {
        this.i = context;
        this.k = p.f(context);
        if (this.k == null) {
            this.k = new cn.com.smartdevices.bracelet.gps.c.d(4);
        }
        this.o = new J(this);
        this.n = v.a(context);
        this.n.a(this.o, new IntentFilter(cn.com.smartdevices.bracelet.gps.c.d.a));
        this.j = new d();
        c();
        EventBus.getDefault().register(this);
    }

    private void a(HwBatteryStatus hwBatteryStatus) {
        h f = a.f();
        if (f != null && f.a() && this.m == 0) {
            this.l.b(f, e());
            c();
        }
    }

    private void a(HwConnStatus hwConnStatus) {
        if (hwConnStatus.b().c() && cn.com.smartdevices.bracelet.gps.e.a.g()) {
            if (hwConnStatus.i()) {
                c.a(this.i);
            }
            if (hwConnStatus.k()) {
                c.d(this.i);
            }
            this.l.b(f, e());
            c();
        }
    }

    private void b() {
        this.k = p.f(this.i);
        this.l.b(f, e());
        c();
    }

    private void c() {
        int e = e();
        C0596r.d(h, "current statment:" + e);
        boolean z = e == 0;
        this.j.c(z, new K(this));
        if (z) {
            d();
        }
    }

    private void d() {
        h f = a.f();
        if (f != null && f.a()) {
            j a = a.a();
            if (a != null) {
                a.a(this.p);
            }
        }
    }

    private int e() {
        h f = a.f();
        if (!cn.com.smartdevices.bracelet.gps.e.a.f() || !cn.com.smartdevices.bracelet.gps.e.a.g()) {
            this.m = b;
            return b;
        } else if (!a.c() || f == null) {
            this.m = c;
            return c;
        } else if (this.k.m()) {
            f e = a.e();
            if (e == null || e.a >= 11) {
                this.m = a;
                return a;
            }
            this.m = e;
            return e;
        } else {
            this.m = d;
            return d;
        }
    }

    public void a() {
        EventBus.getDefault().unregister(this);
        if (this.o != null && this.n != null) {
            this.n.a(this.o);
        }
    }

    public void a(L l) {
        if (l != null) {
            this.l = l;
            this.l.b(f, e());
        }
    }

    public void onEvent(HwBatteryStatus hwBatteryStatus) {
        a(hwBatteryStatus);
    }

    public void onEvent(HwConnStatus hwConnStatus) {
        a(hwConnStatus);
    }
}
