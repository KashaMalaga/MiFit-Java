package com.xiaomi.b.a.a.a;

import b.a.C0374dh;
import com.xiaomi.market.sdk.o;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import kankan.wheel.widget.l;
import org.apache.thrift.b;
import org.apache.thrift.meta_data.d;
import org.apache.thrift.meta_data.g;
import org.apache.thrift.protocol.c;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.i;
import org.apache.thrift.protocol.k;

public class a implements Serializable, Cloneable, b<a, b> {
    public static final Map<b, org.apache.thrift.meta_data.b> a;
    private static final k b = new k("HostInfo");
    private static final c c = new c(o.A, C0374dh.i, (short) 1);
    private static final c d = new c("land_node_info", C0374dh.m, (short) 2);
    private String e;
    private List<g> f;

    static {
        Map enumMap = new EnumMap(b.class);
        enumMap.put(b.HOST, new org.apache.thrift.meta_data.b(o.A, (byte) 1, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(b.LAND_NODE_INFO, new org.apache.thrift.meta_data.b("land_node_info", (byte) 1, new d(C0374dh.m, new g(C0374dh.j, g.class))));
        a = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(a.class, a);
    }

    public a a(String str) {
        this.e = str;
        return this;
    }

    public a a(List<g> list) {
        this.f = list;
        return this;
    }

    public void a(f fVar) {
        fVar.g();
        while (true) {
            c i = fVar.i();
            if (i.b == (byte) 0) {
                fVar.h();
                c();
                return;
            }
            switch (i.c) {
                case l.a /*1*/:
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.e = fVar.w();
                        break;
                    }
                case kankan.wheel.widget.a.k /*2*/:
                    if (i.b != C0374dh.m) {
                        i.a(fVar, i.b);
                        break;
                    }
                    org.apache.thrift.protocol.d m = fVar.m();
                    this.f = new ArrayList(m.b);
                    for (int i2 = 0; i2 < m.b; i2++) {
                        g gVar = new g();
                        gVar.a(fVar);
                        this.f.add(gVar);
                    }
                    fVar.n();
                    break;
                default:
                    i.a(fVar, i.b);
                    break;
            }
            fVar.j();
        }
    }

    public boolean a() {
        return this.e != null;
    }

    public boolean a(a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = aVar.a();
        if ((a || a2) && (!a || !a2 || !this.e.equals(aVar.e))) {
            return false;
        }
        a = b();
        a2 = aVar.b();
        return !(a || a2) || (a && a2 && this.f.equals(aVar.f));
    }

    public int b(a aVar) {
        if (!getClass().equals(aVar.getClass())) {
            return getClass().getName().compareTo(aVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(aVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            compareTo = org.apache.thrift.c.a(this.e, aVar.e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(aVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            compareTo = org.apache.thrift.c.a(this.f, aVar.f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public void b(f fVar) {
        c();
        fVar.a(b);
        if (this.e != null) {
            fVar.a(c);
            fVar.a(this.e);
            fVar.b();
        }
        if (this.f != null) {
            fVar.a(d);
            fVar.a(new org.apache.thrift.protocol.d(C0374dh.j, this.f.size()));
            for (g b : this.f) {
                b.b(fVar);
            }
            fVar.e();
            fVar.b();
        }
        fVar.c();
        fVar.a();
    }

    public boolean b() {
        return this.f != null;
    }

    public void c() {
        if (this.e == null) {
            throw new org.apache.thrift.protocol.g("Required field 'host' was not present! Struct: " + toString());
        } else if (this.f == null) {
            throw new org.apache.thrift.protocol.g("Required field 'land_node_info' was not present! Struct: " + toString());
        }
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((a) obj);
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof a)) ? a((a) obj) : false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("HostInfo(");
        stringBuilder.append("host:");
        if (this.e == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.e);
        }
        stringBuilder.append(", ");
        stringBuilder.append("land_node_info:");
        if (this.f == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
