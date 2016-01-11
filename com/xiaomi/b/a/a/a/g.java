package com.xiaomi.b.a.a.a;

import b.a.C0374dh;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;
import org.apache.thrift.b;
import org.apache.thrift.meta_data.e;
import org.apache.thrift.protocol.c;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.i;
import org.apache.thrift.protocol.k;

public class g implements Serializable, Cloneable, b<g, h> {
    public static final Map<h, org.apache.thrift.meta_data.b> a;
    private static final k b = new k("LandNodeInfo");
    private static final c c = new c("ip", C0374dh.i, (short) 1);
    private static final c d = new c("failed_count", (byte) 8, (short) 2);
    private static final c e = new c("success_count", (byte) 8, (short) 3);
    private static final c f = new c("duration", (byte) 10, (short) 4);
    private static final c g = new c("size", (byte) 8, (short) 5);
    private static final c h = new c("exp_info", C0374dh.k, (short) 6);
    private static final c i = new c("http_info", C0374dh.k, (short) 7);
    private String j;
    private int k;
    private int l;
    private long m;
    private int n;
    private Map<String, Integer> o;
    private Map<Integer, Integer> p;
    private BitSet q = new BitSet(4);

    static {
        Map enumMap = new EnumMap(h.class);
        enumMap.put(h.IP, new org.apache.thrift.meta_data.b("ip", (byte) 1, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(h.FAILED_COUNT, new org.apache.thrift.meta_data.b("failed_count", (byte) 1, new org.apache.thrift.meta_data.c((byte) 8)));
        enumMap.put(h.SUCCESS_COUNT, new org.apache.thrift.meta_data.b("success_count", (byte) 1, new org.apache.thrift.meta_data.c((byte) 8)));
        enumMap.put(h.DURATION, new org.apache.thrift.meta_data.b("duration", (byte) 1, new org.apache.thrift.meta_data.c((byte) 10)));
        enumMap.put(h.SIZE, new org.apache.thrift.meta_data.b("size", (byte) 1, new org.apache.thrift.meta_data.c((byte) 8)));
        enumMap.put(h.EXP_INFO, new org.apache.thrift.meta_data.b("exp_info", (byte) 2, new e(C0374dh.k, new org.apache.thrift.meta_data.c(C0374dh.i), new org.apache.thrift.meta_data.c((byte) 8))));
        enumMap.put(h.HTTP_INFO, new org.apache.thrift.meta_data.b("http_info", (byte) 2, new e(C0374dh.k, new org.apache.thrift.meta_data.c((byte) 8), new org.apache.thrift.meta_data.c((byte) 8))));
        a = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(g.class, a);
    }

    public g a(int i) {
        this.k = i;
        a(true);
        return this;
    }

    public g a(long j) {
        this.m = j;
        c(true);
        return this;
    }

    public g a(String str) {
        this.j = str;
        return this;
    }

    public g a(Map<String, Integer> map) {
        this.o = map;
        return this;
    }

    public void a(f fVar) {
        fVar.g();
        while (true) {
            c i = fVar.i();
            if (i.b == (byte) 0) {
                fVar.h();
                if (!b()) {
                    throw new org.apache.thrift.protocol.g("Required field 'failed_count' was not found in serialized data! Struct: " + toString());
                } else if (!c()) {
                    throw new org.apache.thrift.protocol.g("Required field 'success_count' was not found in serialized data! Struct: " + toString());
                } else if (!d()) {
                    throw new org.apache.thrift.protocol.g("Required field 'duration' was not found in serialized data! Struct: " + toString());
                } else if (e()) {
                    h();
                    return;
                } else {
                    throw new org.apache.thrift.protocol.g("Required field 'size' was not found in serialized data! Struct: " + toString());
                }
            }
            org.apache.thrift.protocol.e k;
            int i2;
            switch (i.c) {
                case l.a /*1*/:
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.j = fVar.w();
                        break;
                    }
                case a.k /*2*/:
                    if (i.b != (byte) 8) {
                        i.a(fVar, i.b);
                        break;
                    }
                    this.k = fVar.t();
                    a(true);
                    break;
                case a.l /*3*/:
                    if (i.b != (byte) 8) {
                        i.a(fVar, i.b);
                        break;
                    }
                    this.l = fVar.t();
                    b(true);
                    break;
                case a.aQ /*4*/:
                    if (i.b != (byte) 10) {
                        i.a(fVar, i.b);
                        break;
                    }
                    this.m = fVar.u();
                    c(true);
                    break;
                case a.X /*5*/:
                    if (i.b != (byte) 8) {
                        i.a(fVar, i.b);
                        break;
                    }
                    this.n = fVar.t();
                    d(true);
                    break;
                case a.bt /*6*/:
                    if (i.b != C0374dh.k) {
                        i.a(fVar, i.b);
                        break;
                    }
                    k = fVar.k();
                    this.o = new HashMap(k.c * 2);
                    for (i2 = 0; i2 < k.c; i2++) {
                        this.o.put(fVar.w(), Integer.valueOf(fVar.t()));
                    }
                    fVar.l();
                    break;
                case a.bc /*7*/:
                    if (i.b != C0374dh.k) {
                        i.a(fVar, i.b);
                        break;
                    }
                    k = fVar.k();
                    this.p = new HashMap(k.c * 2);
                    for (i2 = 0; i2 < k.c; i2++) {
                        this.p.put(Integer.valueOf(fVar.t()), Integer.valueOf(fVar.t()));
                    }
                    fVar.l();
                    break;
                default:
                    i.a(fVar, i.b);
                    break;
            }
            fVar.j();
        }
    }

    public void a(boolean z) {
        this.q.set(0, z);
    }

    public boolean a() {
        return this.j != null;
    }

    public boolean a(g gVar) {
        if (gVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = gVar.a();
        if (((a || a2) && (!a || !a2 || !this.j.equals(gVar.j))) || this.k != gVar.k || this.l != gVar.l || this.m != gVar.m || this.n != gVar.n) {
            return false;
        }
        a = f();
        a2 = gVar.f();
        if ((a || a2) && (!a || !a2 || !this.o.equals(gVar.o))) {
            return false;
        }
        a = g();
        a2 = gVar.g();
        return !(a || a2) || (a && a2 && this.p.equals(gVar.p));
    }

    public int b(g gVar) {
        if (!getClass().equals(gVar.getClass())) {
            return getClass().getName().compareTo(gVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(gVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            compareTo = org.apache.thrift.c.a(this.j, gVar.j);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(gVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            compareTo = org.apache.thrift.c.a(this.k, gVar.k);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(c()).compareTo(Boolean.valueOf(gVar.c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (c()) {
            compareTo = org.apache.thrift.c.a(this.l, gVar.l);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(d()).compareTo(Boolean.valueOf(gVar.d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (d()) {
            compareTo = org.apache.thrift.c.a(this.m, gVar.m);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(e()).compareTo(Boolean.valueOf(gVar.e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (e()) {
            compareTo = org.apache.thrift.c.a(this.n, gVar.n);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gVar.f()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (f()) {
            compareTo = org.apache.thrift.c.a(this.o, gVar.o);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(g()).compareTo(Boolean.valueOf(gVar.g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (g()) {
            compareTo = org.apache.thrift.c.a(this.p, gVar.p);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public g b(int i) {
        this.l = i;
        b(true);
        return this;
    }

    public void b(f fVar) {
        h();
        fVar.a(b);
        if (this.j != null) {
            fVar.a(c);
            fVar.a(this.j);
            fVar.b();
        }
        fVar.a(d);
        fVar.a(this.k);
        fVar.b();
        fVar.a(e);
        fVar.a(this.l);
        fVar.b();
        fVar.a(f);
        fVar.a(this.m);
        fVar.b();
        fVar.a(g);
        fVar.a(this.n);
        fVar.b();
        if (this.o != null && f()) {
            fVar.a(h);
            fVar.a(new org.apache.thrift.protocol.e(C0374dh.i, (byte) 8, this.o.size()));
            for (Entry entry : this.o.entrySet()) {
                fVar.a((String) entry.getKey());
                fVar.a(((Integer) entry.getValue()).intValue());
            }
            fVar.d();
            fVar.b();
        }
        if (this.p != null && g()) {
            fVar.a(i);
            fVar.a(new org.apache.thrift.protocol.e((byte) 8, (byte) 8, this.p.size()));
            for (Entry entry2 : this.p.entrySet()) {
                fVar.a(((Integer) entry2.getKey()).intValue());
                fVar.a(((Integer) entry2.getValue()).intValue());
            }
            fVar.d();
            fVar.b();
        }
        fVar.c();
        fVar.a();
    }

    public void b(boolean z) {
        this.q.set(1, z);
    }

    public boolean b() {
        return this.q.get(0);
    }

    public g c(int i) {
        this.n = i;
        d(true);
        return this;
    }

    public void c(boolean z) {
        this.q.set(2, z);
    }

    public boolean c() {
        return this.q.get(1);
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((g) obj);
    }

    public void d(boolean z) {
        this.q.set(3, z);
    }

    public boolean d() {
        return this.q.get(2);
    }

    public boolean e() {
        return this.q.get(3);
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof g)) ? a((g) obj) : false;
    }

    public boolean f() {
        return this.o != null;
    }

    public boolean g() {
        return this.p != null;
    }

    public void h() {
        if (this.j == null) {
            throw new org.apache.thrift.protocol.g("Required field 'ip' was not present! Struct: " + toString());
        }
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("LandNodeInfo(");
        stringBuilder.append("ip:");
        if (this.j == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.j);
        }
        stringBuilder.append(", ");
        stringBuilder.append("failed_count:");
        stringBuilder.append(this.k);
        stringBuilder.append(", ");
        stringBuilder.append("success_count:");
        stringBuilder.append(this.l);
        stringBuilder.append(", ");
        stringBuilder.append("duration:");
        stringBuilder.append(this.m);
        stringBuilder.append(", ");
        stringBuilder.append("size:");
        stringBuilder.append(this.n);
        if (f()) {
            stringBuilder.append(", ");
            stringBuilder.append("exp_info:");
            if (this.o == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.o);
            }
        }
        if (g()) {
            stringBuilder.append(", ");
            stringBuilder.append("http_info:");
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
