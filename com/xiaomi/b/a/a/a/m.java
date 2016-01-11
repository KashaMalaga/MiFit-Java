package com.xiaomi.b.a.a.a;

import b.a.C0374dh;
import com.xiaomi.market.sdk.o;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;
import org.apache.thrift.b;
import org.apache.thrift.meta_data.d;
import org.apache.thrift.meta_data.g;
import org.apache.thrift.protocol.c;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.i;
import org.apache.thrift.protocol.k;

public class m implements Serializable, Cloneable, b<m, n> {
    public static final Map<n, org.apache.thrift.meta_data.b> a;
    private static final k b = new k("PassportHostInfo");
    private static final c c = new c(o.A, C0374dh.i, (short) 1);
    private static final c d = new c("land_node_info", C0374dh.m, (short) 2);
    private String e;
    private List<o> f;

    static {
        Map enumMap = new EnumMap(n.class);
        enumMap.put(n.HOST, new org.apache.thrift.meta_data.b(o.A, (byte) 1, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(n.LAND_NODE_INFO, new org.apache.thrift.meta_data.b("land_node_info", (byte) 1, new d(C0374dh.m, new g(C0374dh.j, o.class))));
        a = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(m.class, a);
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
                case a.k /*2*/:
                    if (i.b != C0374dh.m) {
                        i.a(fVar, i.b);
                        break;
                    }
                    org.apache.thrift.protocol.d m = fVar.m();
                    this.f = new ArrayList(m.b);
                    for (int i2 = 0; i2 < m.b; i2++) {
                        o oVar = new o();
                        oVar.a(fVar);
                        this.f.add(oVar);
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

    public boolean a(m mVar) {
        if (mVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = mVar.a();
        if ((a || a2) && (!a || !a2 || !this.e.equals(mVar.e))) {
            return false;
        }
        a = b();
        a2 = mVar.b();
        return !(a || a2) || (a && a2 && this.f.equals(mVar.f));
    }

    public int b(m mVar) {
        if (!getClass().equals(mVar.getClass())) {
            return getClass().getName().compareTo(mVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(mVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            compareTo = org.apache.thrift.c.a(this.e, mVar.e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(mVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            compareTo = org.apache.thrift.c.a(this.f, mVar.f);
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
            for (o b : this.f) {
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
        return b((m) obj);
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof m)) ? a((m) obj) : false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PassportHostInfo(");
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
