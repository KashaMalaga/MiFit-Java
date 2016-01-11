package com.g.a.a;

import android.content.Context;
import b.a.bX;
import com.amap.api.location.LocationManagerProxy;
import com.g.a.C1059a;
import com.g.a.C1060b;
import com.g.a.f;
import com.g.a.p;
import com.g.a.r;
import com.g.a.s;
import com.g.a.z;
import com.xiaomi.market.sdk.o;
import java.util.HashMap;

class e implements r {
    private s a = f.a();
    private c b = null;
    private final int c = 100;
    private final int d = 1;
    private final int e;
    private final int f;
    private final int g;
    private final String h;
    private final String i;
    private final String j;
    private final String k;
    private final String l;
    private final String m;
    private final String n;
    private final String o;
    private final String p;
    private final String q;
    private final String r;
    private final String s;
    private final String t;
    private final String u;
    private final String v;
    private final String w;
    private Context x;

    public e() {
        this.a.a(1);
        this.e = 0;
        this.f = -1;
        this.g = 1;
        this.h = "level";
        this.i = "pay";
        this.j = "buy";
        this.k = "use";
        this.l = "bonus";
        this.m = "item";
        this.n = "cash";
        this.o = "coin";
        this.p = o.L;
        this.q = "amount";
        this.r = "user_level";
        this.s = "bonus_source";
        this.t = "level";
        this.u = LocationManagerProxy.KEY_STATUS_CHANGED;
        this.v = "duration";
        this.w = "UMGameAgent.init(Context) should be called before any game api";
        b.a = true;
    }

    private void a(String str, int i) {
        if (this.x == null) {
            bX.b(p.e, "UMGameAgent.init(Context) should be called before any game api");
        } else {
            z.a(new g(this, str, i));
        }
    }

    public void a() {
        bX.c(p.e, "App resume from background");
        if (this.x == null) {
            bX.b(p.e, "UMGameAgent.init(Context) should be called before any game api");
        } else if (b.a) {
            this.b.b();
        }
    }

    void a(double d, double d2, int i) {
        if (this.x == null) {
            bX.b(p.e, "UMGameAgent.init(Context) should be called before any game api");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cash", Long.valueOf((long) (d * 100.0d)));
        hashMap.put("coin", Long.valueOf((long) (d2 * 100.0d)));
        hashMap.put(o.L, Integer.valueOf(i));
        if (this.b.b != null) {
            hashMap.put("user_level", this.b.b);
        }
        if (this.b.a != null) {
            hashMap.put("level", this.b.a);
        }
        this.a.a(this.x, "pay", hashMap);
    }

    void a(double d, int i) {
        if (this.x == null) {
            bX.b(p.e, "UMGameAgent.init(Context) should be called before any game api");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("coin", Long.valueOf((long) (100.0d * d)));
        hashMap.put("bonus_source", Integer.valueOf(i));
        if (this.b.b != null) {
            hashMap.put("user_level", this.b.b);
        }
        if (this.b.a != null) {
            hashMap.put("level", this.b.a);
        }
        this.a.a(this.x, "bonus", hashMap);
    }

    void a(double d, String str, int i, double d2, int i2) {
        a(d, d2 * ((double) i), i2);
        a(str, i, d2);
    }

    void a(Context context) {
        if (context == null) {
            bX.b(p.e, "Context is null, can't init GameAgent");
            return;
        }
        this.x = context.getApplicationContext();
        this.a.a((r) this);
        this.b = new c(this.x);
    }

    void a(String str) {
        this.b.b = str;
    }

    void a(String str, int i, double d) {
        if (this.x == null) {
            bX.b(p.e, "UMGameAgent.init(Context) should be called before any game api");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item", str);
        hashMap.put("amount", Integer.valueOf(i));
        hashMap.put("coin", Long.valueOf((long) ((((double) i) * d) * 100.0d)));
        if (this.b.b != null) {
            hashMap.put("user_level", this.b.b);
        }
        if (this.b.a != null) {
            hashMap.put("level", this.b.a);
        }
        this.a.a(this.x, "buy", hashMap);
    }

    void a(String str, int i, double d, int i2) {
        a(((double) i) * d, i2);
        a(str, i, d);
    }

    void a(String str, int i, C1060b c1060b, String str2) {
        C1059a.h = str;
        C1059a.g = i;
        C1059a.f = c1060b;
        C1059a.i = str2;
    }

    void a(boolean z) {
        bX.c(p.e, String.format("Trace sleep time : %b", new Object[]{Boolean.valueOf(z)}));
        b.a = z;
    }

    public void b() {
        if (this.x == null) {
            bX.b(p.e, "UMGameAgent.init(Context) should be called before any game api");
        } else if (b.a) {
            this.b.a();
        }
    }

    void b(String str) {
        if (this.x == null) {
            bX.b(p.e, "UMGameAgent.init(Context) should be called before any game api");
            return;
        }
        this.b.a = str;
        z.a(new f(this, str));
    }

    void b(String str, int i, double d) {
        if (this.x == null) {
            bX.b(p.e, "UMGameAgent.init(Context) should be called before any game api");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item", str);
        hashMap.put("amount", Integer.valueOf(i));
        hashMap.put("coin", Long.valueOf((long) ((((double) i) * d) * 100.0d)));
        if (this.b.b != null) {
            hashMap.put("user_level", this.b.b);
        }
        if (this.b.a != null) {
            hashMap.put("level", this.b.a);
        }
        this.a.a(this.x, "use", hashMap);
    }

    void c(String str) {
        if (this.x == null) {
            bX.b(p.e, "UMGameAgent.init(Context) should be called before any game api");
        } else {
            a(str, 1);
        }
    }

    void d(String str) {
        if (this.x == null) {
            bX.b(p.e, "UMGameAgent.init(Context) should be called before any game api");
        } else {
            a(str, -1);
        }
    }
}
