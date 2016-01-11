package com.xiaomi.h.a;

import b.a.C0374dh;
import cn.com.smartdevices.bracelet.shoes.sync.b.g;
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
import org.apache.thrift.protocol.c;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.i;
import org.apache.thrift.protocol.k;

public class C1102i implements Serializable, Cloneable, b<C1102i, C1103j> {
    public static final Map<C1103j, org.apache.thrift.meta_data.b> d;
    private static final k e = new k("StatsEvents");
    private static final c f = new c(g.n, C0374dh.i, (short) 1);
    private static final c g = new c("operator", C0374dh.i, (short) 2);
    private static final c h = new c("events", C0374dh.m, (short) 3);
    public String a;
    public String b;
    public List<C1100g> c;

    static {
        Map enumMap = new EnumMap(C1103j.class);
        enumMap.put(C1103j.UUID, new org.apache.thrift.meta_data.b(g.n, (byte) 1, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(C1103j.OPERATOR, new org.apache.thrift.meta_data.b("operator", (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(C1103j.EVENTS, new org.apache.thrift.meta_data.b("events", (byte) 1, new d(C0374dh.m, new org.apache.thrift.meta_data.g(C0374dh.j, C1100g.class))));
        d = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(C1102i.class, d);
    }

    public C1102i(String str, List<C1100g> list) {
        this();
        this.a = str;
        this.c = list;
    }

    public C1102i a(String str) {
        this.b = str;
        return this;
    }

    public void a(f fVar) {
        fVar.g();
        while (true) {
            c i = fVar.i();
            if (i.b == (byte) 0) {
                fVar.h();
                d();
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
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.b = fVar.w();
                        break;
                    }
                case a.l /*3*/:
                    if (i.b != C0374dh.m) {
                        i.a(fVar, i.b);
                        break;
                    }
                    org.apache.thrift.protocol.d m = fVar.m();
                    this.c = new ArrayList(m.b);
                    for (int i2 = 0; i2 < m.b; i2++) {
                        C1100g c1100g = new C1100g();
                        c1100g.a(fVar);
                        this.c.add(c1100g);
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
        return this.a != null;
    }

    public boolean a(C1102i c1102i) {
        if (c1102i == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = c1102i.a();
        if ((a || a2) && (!a || !a2 || !this.a.equals(c1102i.a))) {
            return false;
        }
        a = b();
        a2 = c1102i.b();
        if ((a || a2) && (!a || !a2 || !this.b.equals(c1102i.b))) {
            return false;
        }
        a = c();
        a2 = c1102i.c();
        return !(a || a2) || (a && a2 && this.c.equals(c1102i.c));
    }

    public int b(C1102i c1102i) {
        if (!getClass().equals(c1102i.getClass())) {
            return getClass().getName().compareTo(c1102i.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(c1102i.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            compareTo = org.apache.thrift.c.a(this.a, c1102i.a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(c1102i.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            compareTo = org.apache.thrift.c.a(this.b, c1102i.b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(c()).compareTo(Boolean.valueOf(c1102i.c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (c()) {
            compareTo = org.apache.thrift.c.a(this.c, c1102i.c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public void b(f fVar) {
        d();
        fVar.a(e);
        if (this.a != null) {
            fVar.a(f);
            fVar.a(this.a);
            fVar.b();
        }
        if (this.b != null && b()) {
            fVar.a(g);
            fVar.a(this.b);
            fVar.b();
        }
        if (this.c != null) {
            fVar.a(h);
            fVar.a(new org.apache.thrift.protocol.d(C0374dh.j, this.c.size()));
            for (C1100g b : this.c) {
                b.b(fVar);
            }
            fVar.e();
            fVar.b();
        }
        fVar.c();
        fVar.a();
    }

    public boolean b() {
        return this.b != null;
    }

    public boolean c() {
        return this.c != null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((C1102i) obj);
    }

    public void d() {
        if (this.a == null) {
            throw new org.apache.thrift.protocol.g("Required field 'uuid' was not present! Struct: " + toString());
        } else if (this.c == null) {
            throw new org.apache.thrift.protocol.g("Required field 'events' was not present! Struct: " + toString());
        }
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof C1102i)) ? a((C1102i) obj) : false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("StatsEvents(");
        stringBuilder.append("uuid:");
        if (this.a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.a);
        }
        if (b()) {
            stringBuilder.append(", ");
            stringBuilder.append("operator:");
            if (this.b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.b);
            }
        }
        stringBuilder.append(", ");
        stringBuilder.append("events:");
        if (this.c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.c);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
