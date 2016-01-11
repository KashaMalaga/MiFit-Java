package com.xiaomi.h.a;

import b.a.C0374dh;
import cn.com.smartdevices.bracelet.shoes.sync.SyncShoesDataService;
import com.xiaomi.market.sdk.o;
import java.io.Serializable;
import java.util.BitSet;
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

public class C1096c implements Serializable, Cloneable, b<C1096c, C1097d> {
    public static final Map<C1097d, org.apache.thrift.meta_data.b> i;
    private static final k j = new k("PushMessage");
    private static final c k = new c("to", C0374dh.j, (short) 1);
    private static final c l = new c(SyncShoesDataService.d, C0374dh.i, (short) 2);
    private static final c m = new c("appId", C0374dh.i, (short) 3);
    private static final c n = new c("payload", C0374dh.i, (short) 4);
    private static final c o = new c("createAt", (byte) 10, (short) 5);
    private static final c p = new c("ttl", (byte) 10, (short) 6);
    private static final c q = new c("collapseKey", C0374dh.i, (short) 7);
    private static final c r = new c(o.d, C0374dh.i, (short) 8);
    public C1104k a;
    public String b;
    public String c;
    public String d;
    public long e;
    public long f;
    public String g;
    public String h;
    private BitSet s = new BitSet(2);

    static {
        Map enumMap = new EnumMap(C1097d.class);
        enumMap.put(C1097d.TO, new org.apache.thrift.meta_data.b("to", (byte) 2, new g(C0374dh.j, C1104k.class)));
        enumMap.put(C1097d.ID, new org.apache.thrift.meta_data.b(SyncShoesDataService.d, (byte) 1, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(C1097d.APP_ID, new org.apache.thrift.meta_data.b("appId", (byte) 1, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(C1097d.PAYLOAD, new org.apache.thrift.meta_data.b("payload", (byte) 1, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(C1097d.CREATE_AT, new org.apache.thrift.meta_data.b("createAt", (byte) 2, new org.apache.thrift.meta_data.c((byte) 10)));
        enumMap.put(C1097d.TTL, new org.apache.thrift.meta_data.b("ttl", (byte) 2, new org.apache.thrift.meta_data.c((byte) 10)));
        enumMap.put(C1097d.COLLAPSE_KEY, new org.apache.thrift.meta_data.b("collapseKey", (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(C1097d.PACKAGE_NAME, new org.apache.thrift.meta_data.b(o.d, (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        i = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(C1096c.class, i);
    }

    public void a(f fVar) {
        fVar.g();
        while (true) {
            c i = fVar.i();
            if (i.b == (byte) 0) {
                fVar.h();
                l();
                return;
            }
            switch (i.c) {
                case l.a /*1*/:
                    if (i.b != C0374dh.j) {
                        i.a(fVar, i.b);
                        break;
                    }
                    this.a = new C1104k();
                    this.a.a(fVar);
                    break;
                case a.k /*2*/:
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.b = fVar.w();
                        break;
                    }
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
                    if (i.b != (byte) 10) {
                        i.a(fVar, i.b);
                        break;
                    }
                    this.e = fVar.u();
                    a(true);
                    break;
                case a.bt /*6*/:
                    if (i.b != (byte) 10) {
                        i.a(fVar, i.b);
                        break;
                    }
                    this.f = fVar.u();
                    b(true);
                    break;
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
                default:
                    i.a(fVar, i.b);
                    break;
            }
            fVar.j();
        }
    }

    public void a(boolean z) {
        this.s.set(0, z);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(C1096c c1096c) {
        if (c1096c == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = c1096c.a();
        if ((a || a2) && (!a || !a2 || !this.a.a(c1096c.a))) {
            return false;
        }
        a = c();
        a2 = c1096c.c();
        if ((a || a2) && (!a || !a2 || !this.b.equals(c1096c.b))) {
            return false;
        }
        a = d();
        a2 = c1096c.d();
        if ((a || a2) && (!a || !a2 || !this.c.equals(c1096c.c))) {
            return false;
        }
        a = f();
        a2 = c1096c.f();
        if ((a || a2) && (!a || !a2 || !this.d.equals(c1096c.d))) {
            return false;
        }
        a = h();
        a2 = c1096c.h();
        if ((a || a2) && (!a || !a2 || this.e != c1096c.e)) {
            return false;
        }
        a = i();
        a2 = c1096c.i();
        if ((a || a2) && (!a || !a2 || this.f != c1096c.f)) {
            return false;
        }
        a = j();
        a2 = c1096c.j();
        if ((a || a2) && (!a || !a2 || !this.g.equals(c1096c.g))) {
            return false;
        }
        a = k();
        a2 = c1096c.k();
        return !(a || a2) || (a && a2 && this.h.equals(c1096c.h));
    }

    public int b(C1096c c1096c) {
        if (!getClass().equals(c1096c.getClass())) {
            return getClass().getName().compareTo(c1096c.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(c1096c.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            compareTo = org.apache.thrift.c.a(this.a, c1096c.a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(c()).compareTo(Boolean.valueOf(c1096c.c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (c()) {
            compareTo = org.apache.thrift.c.a(this.b, c1096c.b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(d()).compareTo(Boolean.valueOf(c1096c.d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (d()) {
            compareTo = org.apache.thrift.c.a(this.c, c1096c.c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(f()).compareTo(Boolean.valueOf(c1096c.f()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (f()) {
            compareTo = org.apache.thrift.c.a(this.d, c1096c.d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(h()).compareTo(Boolean.valueOf(c1096c.h()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (h()) {
            compareTo = org.apache.thrift.c.a(this.e, c1096c.e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(i()).compareTo(Boolean.valueOf(c1096c.i()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (i()) {
            compareTo = org.apache.thrift.c.a(this.f, c1096c.f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(j()).compareTo(Boolean.valueOf(c1096c.j()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (j()) {
            compareTo = org.apache.thrift.c.a(this.g, c1096c.g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(k()).compareTo(Boolean.valueOf(c1096c.k()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (k()) {
            compareTo = org.apache.thrift.c.a(this.h, c1096c.h);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public String b() {
        return this.b;
    }

    public void b(f fVar) {
        l();
        fVar.a(j);
        if (this.a != null && a()) {
            fVar.a(k);
            this.a.b(fVar);
            fVar.b();
        }
        if (this.b != null) {
            fVar.a(l);
            fVar.a(this.b);
            fVar.b();
        }
        if (this.c != null) {
            fVar.a(m);
            fVar.a(this.c);
            fVar.b();
        }
        if (this.d != null) {
            fVar.a(n);
            fVar.a(this.d);
            fVar.b();
        }
        if (h()) {
            fVar.a(o);
            fVar.a(this.e);
            fVar.b();
        }
        if (i()) {
            fVar.a(p);
            fVar.a(this.f);
            fVar.b();
        }
        if (this.g != null && j()) {
            fVar.a(q);
            fVar.a(this.g);
            fVar.b();
        }
        if (this.h != null && k()) {
            fVar.a(r);
            fVar.a(this.h);
            fVar.b();
        }
        fVar.c();
        fVar.a();
    }

    public void b(boolean z) {
        this.s.set(1, z);
    }

    public boolean c() {
        return this.b != null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((C1096c) obj);
    }

    public boolean d() {
        return this.c != null;
    }

    public String e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof C1096c)) ? a((C1096c) obj) : false;
    }

    public boolean f() {
        return this.d != null;
    }

    public long g() {
        return this.e;
    }

    public boolean h() {
        return this.s.get(0);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.s.get(1);
    }

    public boolean j() {
        return this.g != null;
    }

    public boolean k() {
        return this.h != null;
    }

    public void l() {
        if (this.b == null) {
            throw new org.apache.thrift.protocol.g("Required field 'id' was not present! Struct: " + toString());
        } else if (this.c == null) {
            throw new org.apache.thrift.protocol.g("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.d == null) {
            throw new org.apache.thrift.protocol.g("Required field 'payload' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PushMessage(");
        Object obj = 1;
        if (a()) {
            stringBuilder.append("to:");
            if (this.a == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.a);
            }
            obj = null;
        }
        if (obj == null) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("id:");
        if (this.b == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.b);
        }
        stringBuilder.append(", ");
        stringBuilder.append("appId:");
        if (this.c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.c);
        }
        stringBuilder.append(", ");
        stringBuilder.append("payload:");
        if (this.d == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.d);
        }
        if (h()) {
            stringBuilder.append(", ");
            stringBuilder.append("createAt:");
            stringBuilder.append(this.e);
        }
        if (i()) {
            stringBuilder.append(", ");
            stringBuilder.append("ttl:");
            stringBuilder.append(this.f);
        }
        if (j()) {
            stringBuilder.append(", ");
            stringBuilder.append("collapseKey:");
            if (this.g == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.g);
            }
        }
        if (k()) {
            stringBuilder.append(", ");
            stringBuilder.append("packageName:");
            if (this.h == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.h);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
