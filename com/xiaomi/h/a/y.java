package com.xiaomi.h.a;

import b.a.C0374dh;
import cn.com.smartdevices.bracelet.shoes.sync.SyncShoesDataService;
import com.tencent.open.SocialConstants;
import com.xiaomi.channel.b.a;
import com.xiaomi.market.sdk.o;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import kankan.wheel.widget.l;
import org.apache.thrift.b;
import org.apache.thrift.meta_data.g;
import org.apache.thrift.protocol.c;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.i;
import org.apache.thrift.protocol.k;

public class y implements Serializable, Cloneable, b<y, z> {
    public static final Map<z, org.apache.thrift.meta_data.b> k;
    private static final k l = new k("XmPushActionRegistrationResult");
    private static final c m = new c("debug", C0374dh.i, (short) 1);
    private static final c n = new c("target", C0374dh.j, (short) 2);
    private static final c o = new c(SyncShoesDataService.d, C0374dh.i, (short) 3);
    private static final c p = new c("appId", C0374dh.i, (short) 4);
    private static final c q = new c(SocialConstants.TYPE_REQUEST, C0374dh.j, (short) 5);
    private static final c r = new c(a.c, (byte) 10, (short) 6);
    private static final c s = new c("reason", C0374dh.i, (short) 7);
    private static final c t = new c("regId", C0374dh.i, (short) 8);
    private static final c u = new c("regSecret", C0374dh.i, (short) 9);
    private static final c v = new c(o.d, C0374dh.i, (short) 10);
    public String a;
    public C1104k b;
    public String c;
    public String d;
    public w e;
    public long f;
    public String g;
    public String h;
    public String i;
    public String j;
    private BitSet w = new BitSet(1);

    static {
        Map enumMap = new EnumMap(z.class);
        enumMap.put(z.DEBUG, new org.apache.thrift.meta_data.b("debug", (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(z.TARGET, new org.apache.thrift.meta_data.b("target", (byte) 2, new g(C0374dh.j, C1104k.class)));
        enumMap.put(z.ID, new org.apache.thrift.meta_data.b(SyncShoesDataService.d, (byte) 1, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(z.APP_ID, new org.apache.thrift.meta_data.b("appId", (byte) 1, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(z.REQUEST, new org.apache.thrift.meta_data.b(SocialConstants.TYPE_REQUEST, (byte) 2, new g(C0374dh.j, w.class)));
        enumMap.put(z.ERROR_CODE, new org.apache.thrift.meta_data.b(a.c, (byte) 1, new org.apache.thrift.meta_data.c((byte) 10)));
        enumMap.put(z.REASON, new org.apache.thrift.meta_data.b("reason", (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(z.REG_ID, new org.apache.thrift.meta_data.b("regId", (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(z.REG_SECRET, new org.apache.thrift.meta_data.b("regSecret", (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(z.PACKAGE_NAME, new org.apache.thrift.meta_data.b(o.d, (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        k = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(y.class, k);
    }

    public void a(f fVar) {
        fVar.g();
        while (true) {
            c i = fVar.i();
            if (i.b == (byte) 0) {
                fVar.h();
                if (f()) {
                    k();
                    return;
                }
                throw new org.apache.thrift.protocol.g("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
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
                case kankan.wheel.widget.a.k /*2*/:
                    if (i.b != C0374dh.j) {
                        i.a(fVar, i.b);
                        break;
                    }
                    this.b = new C1104k();
                    this.b.a(fVar);
                    break;
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
                    if (i.b != C0374dh.j) {
                        i.a(fVar, i.b);
                        break;
                    }
                    this.e = new w();
                    this.e.a(fVar);
                    break;
                case kankan.wheel.widget.a.bt /*6*/:
                    if (i.b != (byte) 10) {
                        i.a(fVar, i.b);
                        break;
                    }
                    this.f = fVar.u();
                    a(true);
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
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.i = fVar.w();
                        break;
                    }
                case kankan.wheel.widget.a.bd /*10*/:
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

    public void a(boolean z) {
        this.w.set(0, z);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(y yVar) {
        if (yVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = yVar.a();
        if ((a || a2) && (!a || !a2 || !this.a.equals(yVar.a))) {
            return false;
        }
        a = b();
        a2 = yVar.b();
        if ((a || a2) && (!a || !a2 || !this.b.a(yVar.b))) {
            return false;
        }
        a = c();
        a2 = yVar.c();
        if ((a || a2) && (!a || !a2 || !this.c.equals(yVar.c))) {
            return false;
        }
        a = d();
        a2 = yVar.d();
        if ((a || a2) && (!a || !a2 || !this.d.equals(yVar.d))) {
            return false;
        }
        a = e();
        a2 = yVar.e();
        if (((a || a2) && (!a || !a2 || !this.e.a(yVar.e))) || this.f != yVar.f) {
            return false;
        }
        a = g();
        a2 = yVar.g();
        if ((a || a2) && (!a || !a2 || !this.g.equals(yVar.g))) {
            return false;
        }
        a = h();
        a2 = yVar.h();
        if ((a || a2) && (!a || !a2 || !this.h.equals(yVar.h))) {
            return false;
        }
        a = i();
        a2 = yVar.i();
        if ((a || a2) && (!a || !a2 || !this.i.equals(yVar.i))) {
            return false;
        }
        a = j();
        a2 = yVar.j();
        return !(a || a2) || (a && a2 && this.j.equals(yVar.j));
    }

    public int b(y yVar) {
        if (!getClass().equals(yVar.getClass())) {
            return getClass().getName().compareTo(yVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(yVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            compareTo = org.apache.thrift.c.a(this.a, yVar.a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(yVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            compareTo = org.apache.thrift.c.a(this.b, yVar.b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(c()).compareTo(Boolean.valueOf(yVar.c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (c()) {
            compareTo = org.apache.thrift.c.a(this.c, yVar.c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(d()).compareTo(Boolean.valueOf(yVar.d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (d()) {
            compareTo = org.apache.thrift.c.a(this.d, yVar.d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(e()).compareTo(Boolean.valueOf(yVar.e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (e()) {
            compareTo = org.apache.thrift.c.a(this.e, yVar.e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(f()).compareTo(Boolean.valueOf(yVar.f()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (f()) {
            compareTo = org.apache.thrift.c.a(this.f, yVar.f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(g()).compareTo(Boolean.valueOf(yVar.g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (g()) {
            compareTo = org.apache.thrift.c.a(this.g, yVar.g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(h()).compareTo(Boolean.valueOf(yVar.h()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (h()) {
            compareTo = org.apache.thrift.c.a(this.h, yVar.h);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(i()).compareTo(Boolean.valueOf(yVar.i()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (i()) {
            compareTo = org.apache.thrift.c.a(this.i, yVar.i);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(j()).compareTo(Boolean.valueOf(yVar.j()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (j()) {
            compareTo = org.apache.thrift.c.a(this.j, yVar.j);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public void b(f fVar) {
        k();
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
        if (this.e != null && e()) {
            fVar.a(q);
            this.e.b(fVar);
            fVar.b();
        }
        fVar.a(r);
        fVar.a(this.f);
        fVar.b();
        if (this.g != null && g()) {
            fVar.a(s);
            fVar.a(this.g);
            fVar.b();
        }
        if (this.h != null && h()) {
            fVar.a(t);
            fVar.a(this.h);
            fVar.b();
        }
        if (this.i != null && i()) {
            fVar.a(u);
            fVar.a(this.i);
            fVar.b();
        }
        if (this.j != null && j()) {
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

    public boolean c() {
        return this.c != null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((y) obj);
    }

    public boolean d() {
        return this.d != null;
    }

    public boolean e() {
        return this.e != null;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof y)) ? a((y) obj) : false;
    }

    public boolean f() {
        return this.w.get(0);
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
        return this.i != null;
    }

    public boolean j() {
        return this.j != null;
    }

    public void k() {
        if (this.c == null) {
            throw new org.apache.thrift.protocol.g("Required field 'id' was not present! Struct: " + toString());
        } else if (this.d == null) {
            throw new org.apache.thrift.protocol.g("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        Object obj = null;
        StringBuilder stringBuilder = new StringBuilder("XmPushActionRegistrationResult(");
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
        if (e()) {
            stringBuilder.append(", ");
            stringBuilder.append("request:");
            if (this.e == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.e);
            }
        }
        stringBuilder.append(", ");
        stringBuilder.append("errorCode:");
        stringBuilder.append(this.f);
        if (g()) {
            stringBuilder.append(", ");
            stringBuilder.append("reason:");
            if (this.g == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.g);
            }
        }
        if (h()) {
            stringBuilder.append(", ");
            stringBuilder.append("regId:");
            if (this.h == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.h);
            }
        }
        if (i()) {
            stringBuilder.append(", ");
            stringBuilder.append("regSecret:");
            if (this.i == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.i);
            }
        }
        if (j()) {
            stringBuilder.append(", ");
            stringBuilder.append("packageName:");
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
