package com.xiaomi.h.a;

import b.a.C0374dh;
import cn.com.smartdevices.bracelet.shoes.sync.SyncShoesDataService;
import com.xiaomi.market.sdk.o;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;
import org.apache.thrift.b;
import org.apache.thrift.meta_data.g;
import org.apache.thrift.protocol.c;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.i;
import org.apache.thrift.protocol.k;

public class w implements Serializable, Cloneable, b<w, x> {
    public static final Map<x, org.apache.thrift.meta_data.b> k;
    private static final k l = new k("XmPushActionRegistration");
    private static final c m = new c("debug", C0374dh.i, (short) 1);
    private static final c n = new c("target", C0374dh.j, (short) 2);
    private static final c o = new c(SyncShoesDataService.d, C0374dh.i, (short) 3);
    private static final c p = new c("appId", C0374dh.i, (short) 4);
    private static final c q = new c("appVersion", C0374dh.i, (short) 5);
    private static final c r = new c(o.d, C0374dh.i, (short) 6);
    private static final c s = new c("token", C0374dh.i, (short) 7);
    private static final c t = new c("deviceId", C0374dh.i, (short) 8);
    private static final c u = new c("aliasName", C0374dh.i, (short) 9);
    private static final c v = new c("sdkVersion", C0374dh.i, (short) 10);
    public String a;
    public C1104k b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;

    static {
        Map enumMap = new EnumMap(x.class);
        enumMap.put(x.DEBUG, new org.apache.thrift.meta_data.b("debug", (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(x.TARGET, new org.apache.thrift.meta_data.b("target", (byte) 2, new g(C0374dh.j, C1104k.class)));
        enumMap.put(x.ID, new org.apache.thrift.meta_data.b(SyncShoesDataService.d, (byte) 1, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(x.APP_ID, new org.apache.thrift.meta_data.b("appId", (byte) 1, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(x.APP_VERSION, new org.apache.thrift.meta_data.b("appVersion", (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(x.PACKAGE_NAME, new org.apache.thrift.meta_data.b(o.d, (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(x.TOKEN, new org.apache.thrift.meta_data.b("token", (byte) 1, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(x.DEVICE_ID, new org.apache.thrift.meta_data.b("deviceId", (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(x.ALIAS_NAME, new org.apache.thrift.meta_data.b("aliasName", (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(x.SDK_VERSION, new org.apache.thrift.meta_data.b("sdkVersion", (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        k = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(w.class, k);
    }

    public w a(String str) {
        this.c = str;
        return this;
    }

    public void a(f fVar) {
        fVar.g();
        while (true) {
            c i = fVar.i();
            if (i.b == (byte) 0) {
                fVar.h();
                m();
                return;
            }
            switch (i.c) {
                case l.a /*1*/:
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.a = fVar.w();
                        break;
                    }
                case a.k /*2*/:
                    if (i.b != C0374dh.j) {
                        i.a(fVar, i.b);
                        break;
                    }
                    this.b = new C1104k();
                    this.b.a(fVar);
                    break;
                case a.l /*3*/:
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.c = fVar.w();
                        break;
                    }
                case a.aQ /*4*/:
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.d = fVar.w();
                        break;
                    }
                case a.X /*5*/:
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.e = fVar.w();
                        break;
                    }
                case a.bt /*6*/:
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.f = fVar.w();
                        break;
                    }
                case a.bc /*7*/:
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.g = fVar.w();
                        break;
                    }
                case a.ba /*8*/:
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.h = fVar.w();
                        break;
                    }
                case a.bo /*9*/:
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.i = fVar.w();
                        break;
                    }
                case a.bd /*10*/:
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.j = fVar.w();
                        break;
                    }
                default:
                    i.a(fVar, i.b);
                    break;
            }
            fVar.j();
        }
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(w wVar) {
        if (wVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = wVar.a();
        if ((a || a2) && (!a || !a2 || !this.a.equals(wVar.a))) {
            return false;
        }
        a = b();
        a2 = wVar.b();
        if ((a || a2) && (!a || !a2 || !this.b.a(wVar.b))) {
            return false;
        }
        a = c();
        a2 = wVar.c();
        if ((a || a2) && (!a || !a2 || !this.c.equals(wVar.c))) {
            return false;
        }
        a = e();
        a2 = wVar.e();
        if ((a || a2) && (!a || !a2 || !this.d.equals(wVar.d))) {
            return false;
        }
        a = f();
        a2 = wVar.f();
        if ((a || a2) && (!a || !a2 || !this.e.equals(wVar.e))) {
            return false;
        }
        a = g();
        a2 = wVar.g();
        if ((a || a2) && (!a || !a2 || !this.f.equals(wVar.f))) {
            return false;
        }
        a = i();
        a2 = wVar.i();
        if ((a || a2) && (!a || !a2 || !this.g.equals(wVar.g))) {
            return false;
        }
        a = j();
        a2 = wVar.j();
        if ((a || a2) && (!a || !a2 || !this.h.equals(wVar.h))) {
            return false;
        }
        a = k();
        a2 = wVar.k();
        if ((a || a2) && (!a || !a2 || !this.i.equals(wVar.i))) {
            return false;
        }
        a = l();
        a2 = wVar.l();
        return !(a || a2) || (a && a2 && this.j.equals(wVar.j));
    }

    public int b(w wVar) {
        if (!getClass().equals(wVar.getClass())) {
            return getClass().getName().compareTo(wVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(wVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            compareTo = org.apache.thrift.c.a(this.a, wVar.a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(wVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            compareTo = org.apache.thrift.c.a(this.b, wVar.b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(c()).compareTo(Boolean.valueOf(wVar.c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (c()) {
            compareTo = org.apache.thrift.c.a(this.c, wVar.c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(e()).compareTo(Boolean.valueOf(wVar.e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (e()) {
            compareTo = org.apache.thrift.c.a(this.d, wVar.d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(f()).compareTo(Boolean.valueOf(wVar.f()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (f()) {
            compareTo = org.apache.thrift.c.a(this.e, wVar.e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(g()).compareTo(Boolean.valueOf(wVar.g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (g()) {
            compareTo = org.apache.thrift.c.a(this.f, wVar.f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(i()).compareTo(Boolean.valueOf(wVar.i()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (i()) {
            compareTo = org.apache.thrift.c.a(this.g, wVar.g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(j()).compareTo(Boolean.valueOf(wVar.j()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (j()) {
            compareTo = org.apache.thrift.c.a(this.h, wVar.h);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(k()).compareTo(Boolean.valueOf(wVar.k()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (k()) {
            compareTo = org.apache.thrift.c.a(this.i, wVar.i);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(l()).compareTo(Boolean.valueOf(wVar.l()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (l()) {
            compareTo = org.apache.thrift.c.a(this.j, wVar.j);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public w b(String str) {
        this.d = str;
        return this;
    }

    public void b(f fVar) {
        m();
        fVar.a(l);
        if (this.a != null && a()) {
            fVar.a(m);
            fVar.a(this.a);
            fVar.b();
        }
        if (this.b != null && b()) {
            fVar.a(n);
            this.b.b(fVar);
            fVar.b();
        }
        if (this.c != null) {
            fVar.a(o);
            fVar.a(this.c);
            fVar.b();
        }
        if (this.d != null) {
            fVar.a(p);
            fVar.a(this.d);
            fVar.b();
        }
        if (this.e != null && f()) {
            fVar.a(q);
            fVar.a(this.e);
            fVar.b();
        }
        if (this.f != null && g()) {
            fVar.a(r);
            fVar.a(this.f);
            fVar.b();
        }
        if (this.g != null) {
            fVar.a(s);
            fVar.a(this.g);
            fVar.b();
        }
        if (this.h != null && j()) {
            fVar.a(t);
            fVar.a(this.h);
            fVar.b();
        }
        if (this.i != null && k()) {
            fVar.a(u);
            fVar.a(this.i);
            fVar.b();
        }
        if (this.j != null && l()) {
            fVar.a(v);
            fVar.a(this.j);
            fVar.b();
        }
        fVar.c();
        fVar.a();
    }

    public boolean b() {
        return this.b != null;
    }

    public w c(String str) {
        this.e = str;
        return this;
    }

    public boolean c() {
        return this.c != null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((w) obj);
    }

    public w d(String str) {
        this.f = str;
        return this;
    }

    public String d() {
        return this.d;
    }

    public w e(String str) {
        this.g = str;
        return this;
    }

    public boolean e() {
        return this.d != null;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof w)) ? a((w) obj) : false;
    }

    public w f(String str) {
        this.h = str;
        return this;
    }

    public boolean f() {
        return this.e != null;
    }

    public boolean g() {
        return this.f != null;
    }

    public String h() {
        return this.g;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.g != null;
    }

    public boolean j() {
        return this.h != null;
    }

    public boolean k() {
        return this.i != null;
    }

    public boolean l() {
        return this.j != null;
    }

    public void m() {
        if (this.c == null) {
            throw new org.apache.thrift.protocol.g("Required field 'id' was not present! Struct: " + toString());
        } else if (this.d == null) {
            throw new org.apache.thrift.protocol.g("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.g == null) {
            throw new org.apache.thrift.protocol.g("Required field 'token' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        Object obj = null;
        StringBuilder stringBuilder = new StringBuilder("XmPushActionRegistration(");
        Object obj2 = 1;
        if (a()) {
            stringBuilder.append("debug:");
            if (this.a == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.a);
            }
            obj2 = null;
        }
        if (b()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("target:");
            if (this.b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.b);
            }
        } else {
            obj = obj2;
        }
        if (obj == null) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("id:");
        if (this.c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.c);
        }
        stringBuilder.append(", ");
        stringBuilder.append("appId:");
        if (this.d == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.d);
        }
        if (f()) {
            stringBuilder.append(", ");
            stringBuilder.append("appVersion:");
            if (this.e == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.e);
            }
        }
        if (g()) {
            stringBuilder.append(", ");
            stringBuilder.append("packageName:");
            if (this.f == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f);
            }
        }
        stringBuilder.append(", ");
        stringBuilder.append("token:");
        if (this.g == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.g);
        }
        if (j()) {
            stringBuilder.append(", ");
            stringBuilder.append("deviceId:");
            if (this.h == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.h);
            }
        }
        if (k()) {
            stringBuilder.append(", ");
            stringBuilder.append("aliasName:");
            if (this.i == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.i);
            }
        }
        if (l()) {
            stringBuilder.append(", ");
            stringBuilder.append("sdkVersion:");
            if (this.j == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.j);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
