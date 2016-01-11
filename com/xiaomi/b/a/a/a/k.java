package com.xiaomi.b.a.a.a;

import b.a.C0374dh;
import cn.com.smartdevices.bracelet.shoes.sync.b.g;
import com.amap.api.location.LocationManagerProxy;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import com.xiaomi.e.a;
import com.xiaomi.market.sdk.o;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kankan.wheel.widget.l;
import org.apache.thrift.b;
import org.apache.thrift.meta_data.f;
import org.apache.thrift.protocol.c;
import org.apache.thrift.protocol.i;
import org.apache.thrift.protocol.j;

public class k implements Serializable, Cloneable, b<k, l> {
    public static final Map<l, org.apache.thrift.meta_data.b> a;
    private static final org.apache.thrift.protocol.k b = new org.apache.thrift.protocol.k("Passport");
    private static final c c = new c(WidgetRequestParam.REQ_PARAM_COMMENT_CATEGORY, C0374dh.i, (short) 1);
    private static final c d = new c(g.n, C0374dh.i, (short) 2);
    private static final c e = new c(o.x, C0374dh.i, (short) 3);
    private static final c f = new c(LocationManagerProxy.NETWORK_PROVIDER, C0374dh.i, (short) 4);
    private static final c g = new c("rid", C0374dh.i, (short) 5);
    private static final c h = new c(LocationManagerProxy.KEY_LOCATION_CHANGED, C0374dh.j, (short) 6);
    private static final c i = new c("host_info", C0374dh.l, (short) 7);
    private String j = a.f;
    private String k;
    private String l;
    private String m;
    private String n;
    private i o;
    private Set<m> p;

    static {
        Map enumMap = new EnumMap(l.class);
        enumMap.put(l.CATEGORY, new org.apache.thrift.meta_data.b(WidgetRequestParam.REQ_PARAM_COMMENT_CATEGORY, (byte) 1, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(l.UUID, new org.apache.thrift.meta_data.b(g.n, (byte) 1, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(l.VERSION, new org.apache.thrift.meta_data.b(o.x, (byte) 1, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(l.NETWORK, new org.apache.thrift.meta_data.b(LocationManagerProxy.NETWORK_PROVIDER, (byte) 1, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(l.RID, new org.apache.thrift.meta_data.b("rid", (byte) 1, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(l.LOCATION, new org.apache.thrift.meta_data.b(LocationManagerProxy.KEY_LOCATION_CHANGED, (byte) 2, new org.apache.thrift.meta_data.g(C0374dh.j, i.class)));
        enumMap.put(l.HOST_INFO, new org.apache.thrift.meta_data.b("host_info", (byte) 2, new f(C0374dh.l, new org.apache.thrift.meta_data.g(C0374dh.j, m.class))));
        a = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(k.class, a);
    }

    public void a(org.apache.thrift.protocol.f fVar) {
        fVar.g();
        while (true) {
            c i = fVar.i();
            if (i.b == (byte) 0) {
                fVar.h();
                h();
                return;
            }
            switch (i.c) {
                case l.a /*1*/:
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.j = fVar.w();
                        break;
                    }
                case kankan.wheel.widget.a.k /*2*/:
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.k = fVar.w();
                        break;
                    }
                case kankan.wheel.widget.a.l /*3*/:
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.l = fVar.w();
                        break;
                    }
                case kankan.wheel.widget.a.aQ /*4*/:
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.m = fVar.w();
                        break;
                    }
                case kankan.wheel.widget.a.X /*5*/:
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.n = fVar.w();
                        break;
                    }
                case kankan.wheel.widget.a.bt /*6*/:
                    if (i.b != C0374dh.j) {
                        i.a(fVar, i.b);
                        break;
                    }
                    this.o = new i();
                    this.o.a(fVar);
                    break;
                case kankan.wheel.widget.a.bc /*7*/:
                    if (i.b != C0374dh.l) {
                        i.a(fVar, i.b);
                        break;
                    }
                    j o = fVar.o();
                    this.p = new HashSet(o.b * 2);
                    for (int i2 = 0; i2 < o.b; i2++) {
                        m mVar = new m();
                        mVar.a(fVar);
                        this.p.add(mVar);
                    }
                    fVar.p();
                    break;
                default:
                    i.a(fVar, i.b);
                    break;
            }
            fVar.j();
        }
    }

    public boolean a() {
        return this.j != null;
    }

    public boolean a(k kVar) {
        if (kVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = kVar.a();
        if ((a || a2) && (!a || !a2 || !this.j.equals(kVar.j))) {
            return false;
        }
        a = b();
        a2 = kVar.b();
        if ((a || a2) && (!a || !a2 || !this.k.equals(kVar.k))) {
            return false;
        }
        a = c();
        a2 = kVar.c();
        if ((a || a2) && (!a || !a2 || !this.l.equals(kVar.l))) {
            return false;
        }
        a = d();
        a2 = kVar.d();
        if ((a || a2) && (!a || !a2 || !this.m.equals(kVar.m))) {
            return false;
        }
        a = e();
        a2 = kVar.e();
        if ((a || a2) && (!a || !a2 || !this.n.equals(kVar.n))) {
            return false;
        }
        a = f();
        a2 = kVar.f();
        if ((a || a2) && (!a || !a2 || !this.o.a(kVar.o))) {
            return false;
        }
        a = g();
        a2 = kVar.g();
        return !(a || a2) || (a && a2 && this.p.equals(kVar.p));
    }

    public int b(k kVar) {
        if (!getClass().equals(kVar.getClass())) {
            return getClass().getName().compareTo(kVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(kVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            compareTo = org.apache.thrift.c.a(this.j, kVar.j);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(kVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            compareTo = org.apache.thrift.c.a(this.k, kVar.k);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(c()).compareTo(Boolean.valueOf(kVar.c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (c()) {
            compareTo = org.apache.thrift.c.a(this.l, kVar.l);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(d()).compareTo(Boolean.valueOf(kVar.d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (d()) {
            compareTo = org.apache.thrift.c.a(this.m, kVar.m);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(e()).compareTo(Boolean.valueOf(kVar.e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (e()) {
            compareTo = org.apache.thrift.c.a(this.n, kVar.n);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(f()).compareTo(Boolean.valueOf(kVar.f()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (f()) {
            compareTo = org.apache.thrift.c.a(this.o, kVar.o);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(g()).compareTo(Boolean.valueOf(kVar.g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (g()) {
            compareTo = org.apache.thrift.c.a(this.p, kVar.p);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public void b(org.apache.thrift.protocol.f fVar) {
        h();
        fVar.a(b);
        if (this.j != null) {
            fVar.a(c);
            fVar.a(this.j);
            fVar.b();
        }
        if (this.k != null) {
            fVar.a(d);
            fVar.a(this.k);
            fVar.b();
        }
        if (this.l != null) {
            fVar.a(e);
            fVar.a(this.l);
            fVar.b();
        }
        if (this.m != null) {
            fVar.a(f);
            fVar.a(this.m);
            fVar.b();
        }
        if (this.n != null) {
            fVar.a(g);
            fVar.a(this.n);
            fVar.b();
        }
        if (this.o != null && f()) {
            fVar.a(h);
            this.o.b(fVar);
            fVar.b();
        }
        if (this.p != null && g()) {
            fVar.a(i);
            fVar.a(new j(C0374dh.j, this.p.size()));
            for (m b : this.p) {
                b.b(fVar);
            }
            fVar.f();
            fVar.b();
        }
        fVar.c();
        fVar.a();
    }

    public boolean b() {
        return this.k != null;
    }

    public boolean c() {
        return this.l != null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((k) obj);
    }

    public boolean d() {
        return this.m != null;
    }

    public boolean e() {
        return this.n != null;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof k)) ? a((k) obj) : false;
    }

    public boolean f() {
        return this.o != null;
    }

    public boolean g() {
        return this.p != null;
    }

    public void h() {
        if (this.j == null) {
            throw new org.apache.thrift.protocol.g("Required field 'category' was not present! Struct: " + toString());
        } else if (this.k == null) {
            throw new org.apache.thrift.protocol.g("Required field 'uuid' was not present! Struct: " + toString());
        } else if (this.l == null) {
            throw new org.apache.thrift.protocol.g("Required field 'version' was not present! Struct: " + toString());
        } else if (this.m == null) {
            throw new org.apache.thrift.protocol.g("Required field 'network' was not present! Struct: " + toString());
        } else if (this.n == null) {
            throw new org.apache.thrift.protocol.g("Required field 'rid' was not present! Struct: " + toString());
        }
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Passport(");
        stringBuilder.append("category:");
        if (this.j == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.j);
        }
        stringBuilder.append(", ");
        stringBuilder.append("uuid:");
        if (this.k == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.k);
        }
        stringBuilder.append(", ");
        stringBuilder.append("version:");
        if (this.l == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.l);
        }
        stringBuilder.append(", ");
        stringBuilder.append("network:");
        if (this.m == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.m);
        }
        stringBuilder.append(", ");
        stringBuilder.append("rid:");
        if (this.n == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.n);
        }
        if (f()) {
            stringBuilder.append(", ");
            stringBuilder.append("location:");
            if (this.o == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.o);
            }
        }
        if (g()) {
            stringBuilder.append(", ");
            stringBuilder.append("host_info:");
            if (this.p == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.p);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
