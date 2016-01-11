package cn.com.smartdevices.bracelet.location;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.config.b;

public class e {
    public static final String a = "ServiceSystem";
    public static final String b = "ServiceAmap";
    public static final String c = "ServiceBaidu";
    public static final String d = "com.xiaomi.hm.health.LocationReceived";
    public static final String e = "Location";
    private static final String f = "LocationManager";
    private static final int g = 1800000;
    private static e h;
    private Context i;
    private i j;
    private g k = new g();
    private d l;

    private e(Context context) {
        this.i = context;
        this.k.a(h.BatterySave);
        this.k.a(true);
        this.k.a((int) g);
        this.l = new f(this);
    }

    public static e a() {
        return h;
    }

    public static e a(Context context) {
        if (h == null) {
            h = new e(context);
        }
        return h;
    }

    public i a(String str) {
        if (this.j != null) {
            this.j.b();
        }
        C0596r.e(f, "Get Location Service : " + str);
        if (a.equals(str)) {
            this.j = new j(this.i);
        } else if (b.equals(str)) {
            this.j = new a(this.i);
        }
        this.j.a(this.k);
        if (this.l != null) {
            this.j.a(this.l);
        }
        return this.j;
    }

    public void a(d dVar) {
        this.l = dVar;
    }

    public i b() {
        return this.j;
    }

    public void b(String str) {
        if (b.h().m.a.booleanValue()) {
            a(str);
            c();
        }
    }

    public void c() {
        if (this.j != null) {
            C0401a.a(this.i, C0401a.eD);
            this.j.a();
        }
    }

    public void d() {
        if (this.j != null) {
            this.j.b();
        }
    }

    public Location e() {
        return this.j == null ? null : this.j.c();
    }
}
