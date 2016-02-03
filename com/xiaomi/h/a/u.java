package com.xiaomi.h.a;

import b.a.C0374dh;
import cn.com.smartdevices.bracelet.shoes.sync.SyncShoesDataService;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import com.xiaomi.channel.relationservice.data.a;
import com.xiaomi.market.sdk.o;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import kankan.wheel.widget.l;
import org.apache.thrift.b;
import org.apache.thrift.meta_data.e;
import org.apache.thrift.meta_data.g;
import org.apache.thrift.protocol.c;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.i;
import org.apache.thrift.protocol.k;

public class u implements Serializable, Cloneable, b<u, v> {
    public static final Map<v, org.apache.thrift.meta_data.b> k;
    private static final k l = new k("XmPushActionNotification");
    private static final c m = new c("debug", C0374dh.i, (short) 1);
    private static final c n = new c("target", C0374dh.j, (short) 2);
    private static final c o = new c(SyncShoesDataService.d, C0374dh.i, (short) 3);
    private static final c p = new c("appId", C0374dh.i, (short) 4);
    private static final c q = new c(a.h, C0374dh.i, (short) 5);
    private static final c r = new c("requireAck", (byte) 2, (short) 6);
    private static final c s = new c("payload", C0374dh.i, (short) 7);
    private static final c t = new c(a.G, C0374dh.k, (short) 8);
    private static final c u = new c(o.d, C0374dh.i, (short) 9);
    private static final c v = new c(WidgetRequestParam.REQ_PARAM_COMMENT_CATEGORY, C0374dh.i, (short) 10);
    public String a;
    public C1104k b;
    public String c;
    public String d;
    public String e;
    public boolean f = true;
    public String g;
    public Map<String, String> h;
    public String i;
    public String j;
    private BitSet w = new BitSet(1);

    static {
        Map enumMap = new EnumMap(v.class);
        enumMap.put(v.DEBUG, new org.apache.thrift.meta_data.b("debug", (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(v.TARGET, new org.apache.thrift.meta_data.b("target", (byte) 2, new g(C0374dh.j, C1104k.class)));
        enumMap.put(v.ID, new org.apache.thrift.meta_data.b(SyncShoesDataService.d, (byte) 1, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(v.APP_ID, new org.apache.thrift.meta_data.b("appId", (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(v.TYPE, new org.apache.thrift.meta_data.b(a.h, (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(v.REQUIRE_ACK, new org.apache.thrift.meta_data.b("requireAck", (byte) 1, new org.apache.thrift.meta_data.c((byte) 2)));
        enumMap.put(v.PAYLOAD, new org.apache.thrift.meta_data.b("payload", (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(v.EXTRA, new org.apache.thrift.meta_data.b(a.G, (byte) 2, new e(C0374dh.k, new org.apache.thrift.meta_data.c(C0374dh.i), new org.apache.thrift.meta_data.c(C0374dh.i))));
        enumMap.put(v.PACKAGE_NAME, new org.apache.thrift.meta_data.b(o.d, (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(v.CATEGORY, new org.apache.thrift.meta_data.b(WidgetRequestParam.REQ_PARAM_COMMENT_CATEGORY, (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        k = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(u.class, k);
    }

    public u a(String str) {
        this.c = str;
        return this;
    }

    public u a(boolean z) {
        this.f = z;
        b(true);
        return this;
    }

    public void a(f fVar) {
        fVar.g();
        while (true) {
            c i = fVar.i();
            if (i.b == (byte) 0) {
                fVar.h();
                if (f()) {
                    l();
                    return;
                }
                throw new org.apache.thrift.protocol.g("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
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
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.e = fVar.w();
                        break;
                    }
                case kankan.wheel.widget.a.bt /*6*/:
                    if (i.b != (byte) 2) {
                        i.a(fVar, i.b);
                        break;
                    }
                    this.f = fVar.q();
                    b(true);
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
                    if (i.b != C0374dh.k) {
                        i.a(fVar, i.b);
                        break;
                    }
                    org.apache.thrift.protocol.e k = fVar.k();
                    this.h = new HashMap(k.c * 2);
                    for (int i2 = 0; i2 < k.c; i2++) {
                        this.h.put(fVar.w(), fVar.w());
                    }
                    fVar.l();
                    break;
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

    public boolean a() {
        return this.a != null;
    }

    public boolean a(u uVar) {
        if (uVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = uVar.a();
        if ((a || a2) && (!a || !a2 || !this.a.equals(uVar.a))) {
            return false;
        }
        a = b();
        a2 = uVar.b();
        if ((a || a2) && (!a || !a2 || !this.b.a(uVar.b))) {
            return false;
        }
        a = c();
        a2 = uVar.c();
        if ((a || a2) && (!a || !a2 || !this.c.equals(uVar.c))) {
            return false;
        }
        a = d();
        a2 = uVar.d();
        if ((a || a2) && (!a || !a2 || !this.d.equals(uVar.d))) {
            return false;
        }
        a = e();
        a2 = uVar.e();
        if (((a || a2) && (!a || !a2 || !this.e.equals(uVar.e))) || this.f != uVar.f) {
            return false;
        }
        a = g();
        a2 = uVar.g();
        if ((a || a2) && (!a || !a2 || !this.g.equals(uVar.g))) {
            return false;
        }
        a = i();
        a2 = uVar.i();
        if ((a || a2) && (!a || !a2 || !this.h.equals(uVar.h))) {
            return false;
        }
        a = j();
        a2 = uVar.j();
        if ((a || a2) && (!a || !a2 || !this.i.equals(uVar.i))) {
            return false;
        }
        a = k();
        a2 = uVar.k();
        return !(a || a2) || (a && a2 && this.j.equals(uVar.j));
    }

    public int b(u uVar) {
        if (!getClass().equals(uVar.getClass())) {
            return getClass().getName().compareTo(uVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(uVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            compareTo = org.apache.thrift.c.a(this.a, uVar.a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(uVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            compareTo = org.apache.thrift.c.a(this.b, uVar.b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(c()).compareTo(Boolean.valueOf(uVar.c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (c()) {
            compareTo = org.apache.thrift.c.a(this.c, uVar.c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(d()).compareTo(Boolean.valueOf(uVar.d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (d()) {
            compareTo = org.apache.thrift.c.a(this.d, uVar.d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(e()).compareTo(Boolean.valueOf(uVar.e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (e()) {
            compareTo = org.apache.thrift.c.a(this.e, uVar.e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(f()).compareTo(Boolean.valueOf(uVar.f()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (f()) {
            compareTo = org.apache.thrift.c.a(this.f, uVar.f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(g()).compareTo(Boolean.valueOf(uVar.g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (g()) {
            compareTo = org.apache.thrift.c.a(this.g, uVar.g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(i()).compareTo(Boolean.valueOf(uVar.i()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (i()) {
            compareTo = org.apache.thrift.c.a(this.h, uVar.h);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(j()).compareTo(Boolean.valueOf(uVar.j()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (j()) {
            compareTo = org.apache.thrift.c.a(this.i, uVar.i);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(k()).compareTo(Boolean.valueOf(uVar.k()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (k()) {
            compareTo = org.apache.thrift.c.a(this.j, uVar.j);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public u b(String str) {
        this.d = str;
        return this;
    }

    public void b(f fVar) {
        l();
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
        if (this.d != null && d()) {
            fVar.a(p);
            fVar.a(this.d);
            fVar.b();
        }
        if (this.e != null && e()) {
            fVar.a(q);
            fVar.a(this.e);
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
        if (this.h != null && i()) {
            fVar.a(t);
            fVar.a(new org.apache.thrift.protocol.e(C0374dh.i, C0374dh.i, this.h.size()));
            for (Entry entry : this.h.entrySet()) {
                fVar.a((String) entry.getKey());
                fVar.a((String) entry.getValue());
            }
            fVar.d();
            fVar.b();
        }
        if (this.i != null && j()) {
            fVar.a(u);
            fVar.a(this.i);
            fVar.b();
        }
        if (this.j != null && k()) {
            fVar.a(v);
            fVar.a(this.j);
            fVar.b();
        }
        fVar.c();
        fVar.a();
    }

    public void b(boolean z) {
        this.w.set(0, z);
    }

    public boolean b() {
        return this.b != null;
    }

    public u c(String str) {
        this.e = str;
        return this;
    }

    public boolean c() {
        return this.c != null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((u) obj);
    }

    public boolean d() {
        return this.d != null;
    }

    public boolean e() {
        return this.e != null;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof u)) ? a((u) obj) : false;
    }

    public boolean f() {
        return this.w.get(0);
    }

    public boolean g() {
        return this.g != null;
    }

    public Map<String, String> h() {
        return this.h;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.h != null;
    }

    public boolean j() {
        return this.i != null;
    }

    public boolean k() {
        return this.j != null;
    }

    public void l() {
        if (this.c == null) {
            throw new org.apache.thrift.protocol.g("Required field 'id' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        Object obj = null;
        StringBuilder stringBuilder = new StringBuilder("XmPushActionNotification(");
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
        if (d()) {
            stringBuilder.append(", ");
            stringBuilder.append("appId:");
            if (this.d == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.d);
            }
        }
        if (e()) {
            stringBuilder.append(", ");
            stringBuilder.append("type:");
            if (this.e == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.e);
            }
        }
        stringBuilder.append(", ");
        stringBuilder.append("requireAck:");
        stringBuilder.append(this.f);
        if (g()) {
            stringBuilder.append(", ");
            stringBuilder.append("payload:");
            if (this.g == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.g);
            }
        }
        if (i()) {
            stringBuilder.append(", ");
            stringBuilder.append("extra:");
            if (this.h == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.h);
            }
        }
        if (j()) {
            stringBuilder.append(", ");
            stringBuilder.append("packageName:");
            if (this.i == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.i);
            }
        }
        if (k()) {
            stringBuilder.append(", ");
            stringBuilder.append("category:");
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
