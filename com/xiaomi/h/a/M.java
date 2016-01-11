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

public class M implements Serializable, Cloneable, b<M, N> {
    public static final Map<N, org.apache.thrift.meta_data.b> i;
    private static final k j = new k("XmPushActionUnRegistrationResult");
    private static final c k = new c("debug", C0374dh.i, (short) 1);
    private static final c l = new c("target", C0374dh.j, (short) 2);
    private static final c m = new c(SyncShoesDataService.d, C0374dh.i, (short) 3);
    private static final c n = new c("appId", C0374dh.i, (short) 4);
    private static final c o = new c(SocialConstants.TYPE_REQUEST, C0374dh.j, (short) 5);
    private static final c p = new c(a.c, (byte) 10, (short) 6);
    private static final c q = new c("reason", C0374dh.i, (short) 7);
    private static final c r = new c(o.d, C0374dh.i, (short) 8);
    public String a;
    public C1104k b;
    public String c;
    public String d;
    public K e;
    public long f;
    public String g;
    public String h;
    private BitSet s = new BitSet(1);

    static {
        Map enumMap = new EnumMap(N.class);
        enumMap.put(N.DEBUG, new org.apache.thrift.meta_data.b("debug", (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(N.TARGET, new org.apache.thrift.meta_data.b("target", (byte) 2, new g(C0374dh.j, C1104k.class)));
        enumMap.put(N.ID, new org.apache.thrift.meta_data.b(SyncShoesDataService.d, (byte) 1, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(N.APP_ID, new org.apache.thrift.meta_data.b("appId", (byte) 1, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(N.REQUEST, new org.apache.thrift.meta_data.b(SocialConstants.TYPE_REQUEST, (byte) 2, new g(C0374dh.j, K.class)));
        enumMap.put(N.ERROR_CODE, new org.apache.thrift.meta_data.b(a.c, (byte) 1, new org.apache.thrift.meta_data.c((byte) 10)));
        enumMap.put(N.REASON, new org.apache.thrift.meta_data.b("reason", (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(N.PACKAGE_NAME, new org.apache.thrift.meta_data.b(o.d, (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        i = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(M.class, i);
    }

    public void a(f fVar) {
        fVar.g();
        while (true) {
            c i = fVar.i();
            if (i.b == (byte) 0) {
                fVar.h();
                if (f()) {
                    i();
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
                    this.e = new K();
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

    public boolean a(M m) {
        if (m == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = m.a();
        if ((a || a2) && (!a || !a2 || !this.a.equals(m.a))) {
            return false;
        }
        a = b();
        a2 = m.b();
        if ((a || a2) && (!a || !a2 || !this.b.a(m.b))) {
            return false;
        }
        a = c();
        a2 = m.c();
        if ((a || a2) && (!a || !a2 || !this.c.equals(m.c))) {
            return false;
        }
        a = d();
        a2 = m.d();
        if ((a || a2) && (!a || !a2 || !this.d.equals(m.d))) {
            return false;
        }
        a = e();
        a2 = m.e();
        if (((a || a2) && (!a || !a2 || !this.e.a(m.e))) || this.f != m.f) {
            return false;
        }
        a = g();
        a2 = m.g();
        if ((a || a2) && (!a || !a2 || !this.g.equals(m.g))) {
            return false;
        }
        a = h();
        a2 = m.h();
        return !(a || a2) || (a && a2 && this.h.equals(m.h));
    }

    public int b(M m) {
        if (!getClass().equals(m.getClass())) {
            return getClass().getName().compareTo(m.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(m.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            compareTo = org.apache.thrift.c.a(this.a, m.a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(m.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            compareTo = org.apache.thrift.c.a(this.b, m.b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(c()).compareTo(Boolean.valueOf(m.c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (c()) {
            compareTo = org.apache.thrift.c.a(this.c, m.c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(d()).compareTo(Boolean.valueOf(m.d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (d()) {
            compareTo = org.apache.thrift.c.a(this.d, m.d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(e()).compareTo(Boolean.valueOf(m.e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (e()) {
            compareTo = org.apache.thrift.c.a(this.e, m.e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(f()).compareTo(Boolean.valueOf(m.f()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (f()) {
            compareTo = org.apache.thrift.c.a(this.f, m.f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(g()).compareTo(Boolean.valueOf(m.g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (g()) {
            compareTo = org.apache.thrift.c.a(this.g, m.g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(h()).compareTo(Boolean.valueOf(m.h()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (h()) {
            compareTo = org.apache.thrift.c.a(this.h, m.h);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public void b(f fVar) {
        i();
        fVar.a(j);
        if (this.a != null && a()) {
            fVar.a(k);
            fVar.a(this.a);
            fVar.b();
        }
        if (this.b != null && b()) {
            fVar.a(l);
            this.b.b(fVar);
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
        if (this.e != null && e()) {
            fVar.a(o);
            this.e.b(fVar);
            fVar.b();
        }
        fVar.a(p);
        fVar.a(this.f);
        fVar.b();
        if (this.g != null && g()) {
            fVar.a(q);
            fVar.a(this.g);
            fVar.b();
        }
        if (this.h != null && h()) {
            fVar.a(r);
            fVar.a(this.h);
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
        return b((M) obj);
    }

    public boolean d() {
        return this.d != null;
    }

    public boolean e() {
        return this.e != null;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof M)) ? a((M) obj) : false;
    }

    public boolean f() {
        return this.s.get(0);
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

    public void i() {
        if (this.c == null) {
            throw new org.apache.thrift.protocol.g("Required field 'id' was not present! Struct: " + toString());
        } else if (this.d == null) {
            throw new org.apache.thrift.protocol.g("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        Object obj = null;
        StringBuilder stringBuilder = new StringBuilder("XmPushActionUnRegistrationResult(");
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
