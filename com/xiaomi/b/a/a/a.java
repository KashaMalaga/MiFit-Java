package com.xiaomi.b.a.a;

import b.a.C0374dh;
import cn.com.smartdevices.bracelet.shoes.sync.b.g;
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

public class a implements Serializable, Cloneable, b<a, b> {
    public static final Map<b, org.apache.thrift.meta_data.b> f;
    private static final k g = new k("Common");
    private static final c h = new c(g.n, (byte) 10, (short) 1);
    private static final c i = new c(cn.com.smartdevices.bracelet.gps.c.a.g.f, C0374dh.i, (short) 2);
    private static final c j = new c("clientIp", C0374dh.i, (short) 3);
    private static final c k = new c("serverIp", C0374dh.i, (short) 4);
    private static final c l = new c("serverHost", C0374dh.i, (short) 5);
    public long a = 0;
    public String b = com.xiaomi.e.a.f;
    public String c = com.xiaomi.e.a.f;
    public String d = com.xiaomi.e.a.f;
    public String e = com.xiaomi.e.a.f;
    private BitSet m = new BitSet(1);

    static {
        Map enumMap = new EnumMap(b.class);
        enumMap.put(b.UUID, new org.apache.thrift.meta_data.b(g.n, (byte) 2, new org.apache.thrift.meta_data.c((byte) 10)));
        enumMap.put(b.TIME, new org.apache.thrift.meta_data.b(cn.com.smartdevices.bracelet.gps.c.a.g.f, (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(b.CLIENT_IP, new org.apache.thrift.meta_data.b("clientIp", (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(b.SERVER_IP, new org.apache.thrift.meta_data.b("serverIp", (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(b.SERVER_HOST, new org.apache.thrift.meta_data.b("serverHost", (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        f = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(a.class, f);
    }

    public void a(f fVar) {
        fVar.g();
        while (true) {
            c i = fVar.i();
            if (i.b == (byte) 0) {
                fVar.h();
                f();
                return;
            }
            switch (i.c) {
                case l.a /*1*/:
                    if (i.b != (byte) 10) {
                        i.a(fVar, i.b);
                        break;
                    }
                    this.a = fVar.u();
                    a(true);
                    break;
                case kankan.wheel.widget.a.k /*2*/:
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.b = fVar.w();
                        break;
                    }
                case kankan.wheel.widget.a.l /*3*/:
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.c = fVar.w();
                        break;
                    }
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
                default:
                    i.a(fVar, i.b);
                    break;
            }
            fVar.j();
        }
    }

    public void a(boolean z) {
        this.m.set(0, z);
    }

    public boolean a() {
        return this.m.get(0);
    }

    public boolean a(a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = aVar.a();
        if ((a || a2) && (!a || !a2 || this.a != aVar.a)) {
            return false;
        }
        a = b();
        a2 = aVar.b();
        if ((a || a2) && (!a || !a2 || !this.b.equals(aVar.b))) {
            return false;
        }
        a = c();
        a2 = aVar.c();
        if ((a || a2) && (!a || !a2 || !this.c.equals(aVar.c))) {
            return false;
        }
        a = d();
        a2 = aVar.d();
        if ((a || a2) && (!a || !a2 || !this.d.equals(aVar.d))) {
            return false;
        }
        a = e();
        a2 = aVar.e();
        return !(a || a2) || (a && a2 && this.e.equals(aVar.e));
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
            compareTo = org.apache.thrift.c.a(this.a, aVar.a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(aVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            compareTo = org.apache.thrift.c.a(this.b, aVar.b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(c()).compareTo(Boolean.valueOf(aVar.c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (c()) {
            compareTo = org.apache.thrift.c.a(this.c, aVar.c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(d()).compareTo(Boolean.valueOf(aVar.d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (d()) {
            compareTo = org.apache.thrift.c.a(this.d, aVar.d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(e()).compareTo(Boolean.valueOf(aVar.e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (e()) {
            compareTo = org.apache.thrift.c.a(this.e, aVar.e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public void b(f fVar) {
        f();
        fVar.a(g);
        if (a()) {
            fVar.a(h);
            fVar.a(this.a);
            fVar.b();
        }
        if (this.b != null && b()) {
            fVar.a(i);
            fVar.a(this.b);
            fVar.b();
        }
        if (this.c != null && c()) {
            fVar.a(j);
            fVar.a(this.c);
            fVar.b();
        }
        if (this.d != null && d()) {
            fVar.a(k);
            fVar.a(this.d);
            fVar.b();
        }
        if (this.e != null && e()) {
            fVar.a(l);
            fVar.a(this.e);
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
        return b((a) obj);
    }

    public boolean d() {
        return this.d != null;
    }

    public boolean e() {
        return this.e != null;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof a)) ? a((a) obj) : false;
    }

    public void f() {
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        Object obj = null;
        StringBuilder stringBuilder = new StringBuilder("Common(");
        Object obj2 = 1;
        if (a()) {
            stringBuilder.append("uuid:");
            stringBuilder.append(this.a);
            obj2 = null;
        }
        if (b()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("time:");
            if (this.b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.b);
            }
            obj2 = null;
        }
        if (c()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("clientIp:");
            if (this.c == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.c);
            }
            obj2 = null;
        }
        if (d()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("serverIp:");
            if (this.d == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.d);
            }
        } else {
            obj = obj2;
        }
        if (e()) {
            if (obj == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("serverHost:");
            if (this.e == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.e);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
