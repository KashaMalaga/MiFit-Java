package com.xiaomi.b.a.a.a;

import b.a.C0374dh;
import cn.com.smartdevices.bracelet.shoes.sync.b.g;
import com.amap.api.location.LocationManagerProxy;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import com.xiaomi.channel.b.v;
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
import org.apache.thrift.protocol.i;
import org.apache.thrift.protocol.j;
import org.apache.thrift.protocol.k;

public class c implements Serializable, Cloneable, b<c, d> {
    public static final Map<d, org.apache.thrift.meta_data.b> a;
    private static final k b = new k("HttpApi");
    private static final org.apache.thrift.protocol.c c = new org.apache.thrift.protocol.c(WidgetRequestParam.REQ_PARAM_COMMENT_CATEGORY, C0374dh.i, (short) 1);
    private static final org.apache.thrift.protocol.c d = new org.apache.thrift.protocol.c(g.n, C0374dh.i, (short) 2);
    private static final org.apache.thrift.protocol.c e = new org.apache.thrift.protocol.c(o.x, C0374dh.i, (short) 3);
    private static final org.apache.thrift.protocol.c f = new org.apache.thrift.protocol.c(LocationManagerProxy.NETWORK_PROVIDER, C0374dh.i, (short) 4);
    private static final org.apache.thrift.protocol.c g = new org.apache.thrift.protocol.c("client_ip", C0374dh.i, (short) 5);
    private static final org.apache.thrift.protocol.c h = new org.apache.thrift.protocol.c(LocationManagerProxy.KEY_LOCATION_CHANGED, C0374dh.j, (short) 6);
    private static final org.apache.thrift.protocol.c i = new org.apache.thrift.protocol.c("host_info", C0374dh.l, (short) 7);
    private static final org.apache.thrift.protocol.c j = new org.apache.thrift.protocol.c("version_type", C0374dh.i, (short) 8);
    private static final org.apache.thrift.protocol.c k = new org.apache.thrift.protocol.c(v.v, C0374dh.i, (short) 9);
    private static final org.apache.thrift.protocol.c l = new org.apache.thrift.protocol.c("app_version", C0374dh.i, (short) 10);
    private String m = a.f;
    private String n;
    private String o;
    private String p;
    private String q;
    private i r;
    private Set<a> s;
    private String t = a.f;
    private String u = a.f;
    private String v = a.f;

    static {
        Map enumMap = new EnumMap(d.class);
        enumMap.put(d.CATEGORY, new org.apache.thrift.meta_data.b(WidgetRequestParam.REQ_PARAM_COMMENT_CATEGORY, (byte) 1, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(d.UUID, new org.apache.thrift.meta_data.b(g.n, (byte) 1, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(d.VERSION, new org.apache.thrift.meta_data.b(o.x, (byte) 1, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(d.NETWORK, new org.apache.thrift.meta_data.b(LocationManagerProxy.NETWORK_PROVIDER, (byte) 1, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(d.CLIENT_IP, new org.apache.thrift.meta_data.b("client_ip", (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(d.LOCATION, new org.apache.thrift.meta_data.b(LocationManagerProxy.KEY_LOCATION_CHANGED, (byte) 2, new org.apache.thrift.meta_data.g(C0374dh.j, i.class)));
        enumMap.put(d.HOST_INFO, new org.apache.thrift.meta_data.b("host_info", (byte) 2, new f(C0374dh.l, new org.apache.thrift.meta_data.g(C0374dh.j, a.class))));
        enumMap.put(d.VERSION_TYPE, new org.apache.thrift.meta_data.b("version_type", (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(d.APP_NAME, new org.apache.thrift.meta_data.b(v.v, (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(d.APP_VERSION, new org.apache.thrift.meta_data.b("app_version", (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        a = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(c.class, a);
    }

    public c a(i iVar) {
        this.r = iVar;
        return this;
    }

    public c a(String str) {
        this.m = str;
        return this;
    }

    public void a(a aVar) {
        if (this.s == null) {
            this.s = new HashSet();
        }
        this.s.add(aVar);
    }

    public void a(org.apache.thrift.protocol.f fVar) {
        fVar.g();
        while (true) {
            org.apache.thrift.protocol.c i = fVar.i();
            if (i.b == (byte) 0) {
                fVar.h();
                l();
                return;
            }
            switch (i.c) {
                case l.a /*1*/:
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.m = fVar.w();
                        break;
                    }
                case kankan.wheel.widget.a.k /*2*/:
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.n = fVar.w();
                        break;
                    }
                case kankan.wheel.widget.a.l /*3*/:
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.o = fVar.w();
                        break;
                    }
                case kankan.wheel.widget.a.aQ /*4*/:
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.p = fVar.w();
                        break;
                    }
                case kankan.wheel.widget.a.X /*5*/:
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.q = fVar.w();
                        break;
                    }
                case kankan.wheel.widget.a.bt /*6*/:
                    if (i.b != C0374dh.j) {
                        i.a(fVar, i.b);
                        break;
                    }
                    this.r = new i();
                    this.r.a(fVar);
                    break;
                case kankan.wheel.widget.a.bc /*7*/:
                    if (i.b != C0374dh.l) {
                        i.a(fVar, i.b);
                        break;
                    }
                    j o = fVar.o();
                    this.s = new HashSet(o.b * 2);
                    for (int i2 = 0; i2 < o.b; i2++) {
                        a aVar = new a();
                        aVar.a(fVar);
                        this.s.add(aVar);
                    }
                    fVar.p();
                    break;
                case kankan.wheel.widget.a.ba /*8*/:
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.t = fVar.w();
                        break;
                    }
                case kankan.wheel.widget.a.bo /*9*/:
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.u = fVar.w();
                        break;
                    }
                case kankan.wheel.widget.a.bd /*10*/:
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.v = fVar.w();
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
        return this.m != null;
    }

    public boolean a(c cVar) {
        if (cVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = cVar.a();
        if ((a || a2) && (!a || !a2 || !this.m.equals(cVar.m))) {
            return false;
        }
        a = b();
        a2 = cVar.b();
        if ((a || a2) && (!a || !a2 || !this.n.equals(cVar.n))) {
            return false;
        }
        a = c();
        a2 = cVar.c();
        if ((a || a2) && (!a || !a2 || !this.o.equals(cVar.o))) {
            return false;
        }
        a = d();
        a2 = cVar.d();
        if ((a || a2) && (!a || !a2 || !this.p.equals(cVar.p))) {
            return false;
        }
        a = e();
        a2 = cVar.e();
        if ((a || a2) && (!a || !a2 || !this.q.equals(cVar.q))) {
            return false;
        }
        a = f();
        a2 = cVar.f();
        if ((a || a2) && (!a || !a2 || !this.r.a(cVar.r))) {
            return false;
        }
        a = h();
        a2 = cVar.h();
        if ((a || a2) && (!a || !a2 || !this.s.equals(cVar.s))) {
            return false;
        }
        a = i();
        a2 = cVar.i();
        if ((a || a2) && (!a || !a2 || !this.t.equals(cVar.t))) {
            return false;
        }
        a = j();
        a2 = cVar.j();
        if ((a || a2) && (!a || !a2 || !this.u.equals(cVar.u))) {
            return false;
        }
        a = k();
        a2 = cVar.k();
        return !(a || a2) || (a && a2 && this.v.equals(cVar.v));
    }

    public int b(c cVar) {
        if (!getClass().equals(cVar.getClass())) {
            return getClass().getName().compareTo(cVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(cVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            compareTo = org.apache.thrift.c.a(this.m, cVar.m);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(cVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            compareTo = org.apache.thrift.c.a(this.n, cVar.n);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(c()).compareTo(Boolean.valueOf(cVar.c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (c()) {
            compareTo = org.apache.thrift.c.a(this.o, cVar.o);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(d()).compareTo(Boolean.valueOf(cVar.d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (d()) {
            compareTo = org.apache.thrift.c.a(this.p, cVar.p);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(e()).compareTo(Boolean.valueOf(cVar.e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (e()) {
            compareTo = org.apache.thrift.c.a(this.q, cVar.q);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(f()).compareTo(Boolean.valueOf(cVar.f()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (f()) {
            compareTo = org.apache.thrift.c.a(this.r, cVar.r);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(h()).compareTo(Boolean.valueOf(cVar.h()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (h()) {
            compareTo = org.apache.thrift.c.a(this.s, cVar.s);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(i()).compareTo(Boolean.valueOf(cVar.i()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (i()) {
            compareTo = org.apache.thrift.c.a(this.t, cVar.t);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(j()).compareTo(Boolean.valueOf(cVar.j()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (j()) {
            compareTo = org.apache.thrift.c.a(this.u, cVar.u);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(k()).compareTo(Boolean.valueOf(cVar.k()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (k()) {
            compareTo = org.apache.thrift.c.a(this.v, cVar.v);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public c b(String str) {
        this.n = str;
        return this;
    }

    public void b(org.apache.thrift.protocol.f fVar) {
        l();
        fVar.a(b);
        if (this.m != null) {
            fVar.a(c);
            fVar.a(this.m);
            fVar.b();
        }
        if (this.n != null) {
            fVar.a(d);
            fVar.a(this.n);
            fVar.b();
        }
        if (this.o != null) {
            fVar.a(e);
            fVar.a(this.o);
            fVar.b();
        }
        if (this.p != null) {
            fVar.a(f);
            fVar.a(this.p);
            fVar.b();
        }
        if (this.q != null && e()) {
            fVar.a(g);
            fVar.a(this.q);
            fVar.b();
        }
        if (this.r != null && f()) {
            fVar.a(h);
            this.r.b(fVar);
            fVar.b();
        }
        if (this.s != null && h()) {
            fVar.a(i);
            fVar.a(new j(C0374dh.j, this.s.size()));
            for (a b : this.s) {
                b.b(fVar);
            }
            fVar.f();
            fVar.b();
        }
        if (this.t != null && i()) {
            fVar.a(j);
            fVar.a(this.t);
            fVar.b();
        }
        if (this.u != null && j()) {
            fVar.a(k);
            fVar.a(this.u);
            fVar.b();
        }
        if (this.v != null && k()) {
            fVar.a(l);
            fVar.a(this.v);
            fVar.b();
        }
        fVar.c();
        fVar.a();
    }

    public boolean b() {
        return this.n != null;
    }

    public c c(String str) {
        this.o = str;
        return this;
    }

    public boolean c() {
        return this.o != null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((c) obj);
    }

    public c d(String str) {
        this.p = str;
        return this;
    }

    public boolean d() {
        return this.p != null;
    }

    public c e(String str) {
        this.q = str;
        return this;
    }

    public boolean e() {
        return this.q != null;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof c)) ? a((c) obj) : false;
    }

    public c f(String str) {
        this.t = str;
        return this;
    }

    public boolean f() {
        return this.r != null;
    }

    public int g() {
        return this.s == null ? 0 : this.s.size();
    }

    public c g(String str) {
        this.u = str;
        return this;
    }

    public c h(String str) {
        this.v = str;
        return this;
    }

    public boolean h() {
        return this.s != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.t != null;
    }

    public boolean j() {
        return this.u != null;
    }

    public boolean k() {
        return this.v != null;
    }

    public void l() {
        if (this.m == null) {
            throw new org.apache.thrift.protocol.g("Required field 'category' was not present! Struct: " + toString());
        } else if (this.n == null) {
            throw new org.apache.thrift.protocol.g("Required field 'uuid' was not present! Struct: " + toString());
        } else if (this.o == null) {
            throw new org.apache.thrift.protocol.g("Required field 'version' was not present! Struct: " + toString());
        } else if (this.p == null) {
            throw new org.apache.thrift.protocol.g("Required field 'network' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("HttpApi(");
        stringBuilder.append("category:");
        if (this.m == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.m);
        }
        stringBuilder.append(", ");
        stringBuilder.append("uuid:");
        if (this.n == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.n);
        }
        stringBuilder.append(", ");
        stringBuilder.append("version:");
        if (this.o == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.o);
        }
        stringBuilder.append(", ");
        stringBuilder.append("network:");
        if (this.p == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.p);
        }
        if (e()) {
            stringBuilder.append(", ");
            stringBuilder.append("client_ip:");
            if (this.q == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.q);
            }
        }
        if (f()) {
            stringBuilder.append(", ");
            stringBuilder.append("location:");
            if (this.r == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.r);
            }
        }
        if (h()) {
            stringBuilder.append(", ");
            stringBuilder.append("host_info:");
            if (this.s == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.s);
            }
        }
        if (i()) {
            stringBuilder.append(", ");
            stringBuilder.append("version_type:");
            if (this.t == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.t);
            }
        }
        if (j()) {
            stringBuilder.append(", ");
            stringBuilder.append("app_name:");
            if (this.u == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.u);
            }
        }
        if (k()) {
            stringBuilder.append(", ");
            stringBuilder.append("app_version:");
            if (this.v == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.v);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
