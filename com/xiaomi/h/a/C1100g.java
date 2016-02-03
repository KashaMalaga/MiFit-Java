package com.xiaomi.h.a;

import b.a.C0374dh;
import cn.com.smartdevices.bracelet.d.C0432i;
import cn.com.smartdevices.bracelet.gps.c.a.g;
import com.xiaomi.channel.relationservice.data.a;
import com.xiaomi.market.sdk.o;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import kankan.wheel.widget.l;
import org.apache.thrift.b;
import org.apache.thrift.protocol.c;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.i;
import org.apache.thrift.protocol.k;

public class C1100g implements Serializable, Cloneable, b<C1100g, C1101h> {
    public static final Map<C1101h, org.apache.thrift.meta_data.b> j;
    private static final k k = new k("StatsEvent");
    private static final c l = new c("chid", (byte) 3, (short) 1);
    private static final c m = new c(a.h, (byte) 8, (short) 2);
    private static final c n = new c(C0432i.b, (byte) 8, (short) 3);
    private static final c o = new c("connpt", C0374dh.i, (short) 4);
    private static final c p = new c(o.A, C0374dh.i, (short) 5);
    private static final c q = new c("subvalue", (byte) 8, (short) 6);
    private static final c r = new c("annotation", C0374dh.i, (short) 7);
    private static final c s = new c("user", C0374dh.i, (short) 8);
    private static final c t = new c(g.f, (byte) 8, (short) 9);
    public byte a;
    public int b;
    public int c;
    public String d;
    public String e;
    public int f;
    public String g;
    public String h;
    public int i;
    private BitSet u = new BitSet(5);

    static {
        Map enumMap = new EnumMap(C1101h.class);
        enumMap.put(C1101h.CHID, new org.apache.thrift.meta_data.b("chid", (byte) 1, new org.apache.thrift.meta_data.c((byte) 3)));
        enumMap.put(C1101h.TYPE, new org.apache.thrift.meta_data.b(a.h, (byte) 1, new org.apache.thrift.meta_data.c((byte) 8)));
        enumMap.put(C1101h.VALUE, new org.apache.thrift.meta_data.b(C0432i.b, (byte) 1, new org.apache.thrift.meta_data.c((byte) 8)));
        enumMap.put(C1101h.CONNPT, new org.apache.thrift.meta_data.b("connpt", (byte) 1, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(C1101h.HOST, new org.apache.thrift.meta_data.b(o.A, (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(C1101h.SUBVALUE, new org.apache.thrift.meta_data.b("subvalue", (byte) 2, new org.apache.thrift.meta_data.c((byte) 8)));
        enumMap.put(C1101h.ANNOTATION, new org.apache.thrift.meta_data.b("annotation", (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(C1101h.USER, new org.apache.thrift.meta_data.b("user", (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(C1101h.TIME, new org.apache.thrift.meta_data.b(g.f, (byte) 2, new org.apache.thrift.meta_data.c((byte) 8)));
        j = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(C1100g.class, j);
    }

    public C1100g a(byte b) {
        this.a = b;
        a(true);
        return this;
    }

    public C1100g a(int i) {
        this.b = i;
        b(true);
        return this;
    }

    public C1100g a(String str) {
        this.d = str;
        return this;
    }

    public void a(f fVar) {
        fVar.g();
        while (true) {
            c i = fVar.i();
            if (i.b == (byte) 0) {
                fVar.h();
                if (!a()) {
                    throw new org.apache.thrift.protocol.g("Required field 'chid' was not found in serialized data! Struct: " + toString());
                } else if (!b()) {
                    throw new org.apache.thrift.protocol.g("Required field 'type' was not found in serialized data! Struct: " + toString());
                } else if (c()) {
                    j();
                    return;
                } else {
                    throw new org.apache.thrift.protocol.g("Required field 'value' was not found in serialized data! Struct: " + toString());
                }
            }
            switch (i.c) {
                case l.a /*1*/:
                    if (i.b != (byte) 3) {
                        i.a(fVar, i.b);
                        break;
                    }
                    this.a = fVar.r();
                    a(true);
                    break;
                case kankan.wheel.widget.a.k /*2*/:
                    if (i.b != (byte) 8) {
                        i.a(fVar, i.b);
                        break;
                    }
                    this.b = fVar.t();
                    b(true);
                    break;
                case kankan.wheel.widget.a.l /*3*/:
                    if (i.b != (byte) 8) {
                        i.a(fVar, i.b);
                        break;
                    }
                    this.c = fVar.t();
                    c(true);
                    break;
                case kankan.wheel.widget.a.aQ /*4*/:
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.d = fVar.w();
                        break;
                    }
                case kankan.wheel.widget.a.X /*5*/:
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.e = fVar.w();
                        break;
                    }
                case kankan.wheel.widget.a.bt /*6*/:
                    if (i.b != (byte) 8) {
                        i.a(fVar, i.b);
                        break;
                    }
                    this.f = fVar.t();
                    d(true);
                    break;
                case kankan.wheel.widget.a.bc /*7*/:
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.g = fVar.w();
                        break;
                    }
                case kankan.wheel.widget.a.ba /*8*/:
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.h = fVar.w();
                        break;
                    }
                case kankan.wheel.widget.a.bo /*9*/:
                    if (i.b != (byte) 8) {
                        i.a(fVar, i.b);
                        break;
                    }
                    this.i = fVar.t();
                    e(true);
                    break;
                default:
                    i.a(fVar, i.b);
                    break;
            }
            fVar.j();
        }
    }

    public void a(boolean z) {
        this.u.set(0, z);
    }

    public boolean a() {
        return this.u.get(0);
    }

    public boolean a(C1100g c1100g) {
        if (c1100g == null || this.a != c1100g.a || this.b != c1100g.b || this.c != c1100g.c) {
            return false;
        }
        boolean d = d();
        boolean d2 = c1100g.d();
        if ((d || d2) && (!d || !d2 || !this.d.equals(c1100g.d))) {
            return false;
        }
        d = e();
        d2 = c1100g.e();
        if ((d || d2) && (!d || !d2 || !this.e.equals(c1100g.e))) {
            return false;
        }
        d = f();
        d2 = c1100g.f();
        if ((d || d2) && (!d || !d2 || this.f != c1100g.f)) {
            return false;
        }
        d = g();
        d2 = c1100g.g();
        if ((d || d2) && (!d || !d2 || !this.g.equals(c1100g.g))) {
            return false;
        }
        d = h();
        d2 = c1100g.h();
        if ((d || d2) && (!d || !d2 || !this.h.equals(c1100g.h))) {
            return false;
        }
        d = i();
        d2 = c1100g.i();
        return !(d || d2) || (d && d2 && this.i == c1100g.i);
    }

    public int b(C1100g c1100g) {
        if (!getClass().equals(c1100g.getClass())) {
            return getClass().getName().compareTo(c1100g.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(c1100g.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            compareTo = org.apache.thrift.c.a(this.a, c1100g.a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(c1100g.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            compareTo = org.apache.thrift.c.a(this.b, c1100g.b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(c()).compareTo(Boolean.valueOf(c1100g.c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (c()) {
            compareTo = org.apache.thrift.c.a(this.c, c1100g.c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(d()).compareTo(Boolean.valueOf(c1100g.d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (d()) {
            compareTo = org.apache.thrift.c.a(this.d, c1100g.d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(e()).compareTo(Boolean.valueOf(c1100g.e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (e()) {
            compareTo = org.apache.thrift.c.a(this.e, c1100g.e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(f()).compareTo(Boolean.valueOf(c1100g.f()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (f()) {
            compareTo = org.apache.thrift.c.a(this.f, c1100g.f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(g()).compareTo(Boolean.valueOf(c1100g.g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (g()) {
            compareTo = org.apache.thrift.c.a(this.g, c1100g.g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(h()).compareTo(Boolean.valueOf(c1100g.h()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (h()) {
            compareTo = org.apache.thrift.c.a(this.h, c1100g.h);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(i()).compareTo(Boolean.valueOf(c1100g.i()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (i()) {
            compareTo = org.apache.thrift.c.a(this.i, c1100g.i);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public C1100g b(int i) {
        this.i = i;
        e(true);
        return this;
    }

    public C1100g b(String str) {
        this.e = str;
        return this;
    }

    public void b(f fVar) {
        j();
        fVar.a(k);
        fVar.a(l);
        fVar.a(this.a);
        fVar.b();
        fVar.a(m);
        fVar.a(this.b);
        fVar.b();
        fVar.a(n);
        fVar.a(this.c);
        fVar.b();
        if (this.d != null) {
            fVar.a(o);
            fVar.a(this.d);
            fVar.b();
        }
        if (this.e != null && e()) {
            fVar.a(p);
            fVar.a(this.e);
            fVar.b();
        }
        if (f()) {
            fVar.a(q);
            fVar.a(this.f);
            fVar.b();
        }
        if (this.g != null && g()) {
            fVar.a(r);
            fVar.a(this.g);
            fVar.b();
        }
        if (this.h != null && h()) {
            fVar.a(s);
            fVar.a(this.h);
            fVar.b();
        }
        if (i()) {
            fVar.a(t);
            fVar.a(this.i);
            fVar.b();
        }
        fVar.c();
        fVar.a();
    }

    public void b(boolean z) {
        this.u.set(1, z);
    }

    public boolean b() {
        return this.u.get(1);
    }

    public C1100g c(String str) {
        this.g = str;
        return this;
    }

    public void c(boolean z) {
        this.u.set(2, z);
    }

    public boolean c() {
        return this.u.get(2);
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((C1100g) obj);
    }

    public C1100g d(String str) {
        this.h = str;
        return this;
    }

    public void d(boolean z) {
        this.u.set(3, z);
    }

    public boolean d() {
        return this.d != null;
    }

    public void e(boolean z) {
        this.u.set(4, z);
    }

    public boolean e() {
        return this.e != null;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof C1100g)) ? a((C1100g) obj) : false;
    }

    public boolean f() {
        return this.u.get(3);
    }

    public boolean g() {
        return this.g != null;
    }

    public boolean h() {
        return this.h != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.u.get(4);
    }

    public void j() {
        if (this.d == null) {
            throw new org.apache.thrift.protocol.g("Required field 'connpt' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("StatsEvent(");
        stringBuilder.append("chid:");
        stringBuilder.append(this.a);
        stringBuilder.append(", ");
        stringBuilder.append("type:");
        stringBuilder.append(this.b);
        stringBuilder.append(", ");
        stringBuilder.append("value:");
        stringBuilder.append(this.c);
        stringBuilder.append(", ");
        stringBuilder.append("connpt:");
        if (this.d == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.d);
        }
        if (e()) {
            stringBuilder.append(", ");
            stringBuilder.append("host:");
            if (this.e == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.e);
            }
        }
        if (f()) {
            stringBuilder.append(", ");
            stringBuilder.append("subvalue:");
            stringBuilder.append(this.f);
        }
        if (g()) {
            stringBuilder.append(", ");
            stringBuilder.append("annotation:");
            if (this.g == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.g);
            }
        }
        if (h()) {
            stringBuilder.append(", ");
            stringBuilder.append("user:");
            if (this.h == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.h);
            }
        }
        if (i()) {
            stringBuilder.append(", ");
            stringBuilder.append("time:");
            stringBuilder.append(this.i);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
