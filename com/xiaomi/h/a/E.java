package com.xiaomi.h.a;

import b.a.C0374dh;
import cn.com.smartdevices.bracelet.partner.NativeInterface;
import cn.com.smartdevices.bracelet.shoes.sync.SyncShoesDataService;
import com.huami.android.widget.f;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import com.xiaomi.market.sdk.o;
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
import org.apache.thrift.meta_data.g;
import org.apache.thrift.protocol.c;
import org.apache.thrift.protocol.i;
import org.apache.thrift.protocol.k;

public class E implements Serializable, Cloneable, b<E, F> {
    public static final Map<F, org.apache.thrift.meta_data.b> m;
    private static final k n = new k("XmPushActionSendMessage");
    private static final c o = new c("debug", C0374dh.i, (short) 1);
    private static final c p = new c("target", C0374dh.j, (short) 2);
    private static final c q = new c(SyncShoesDataService.d, C0374dh.i, (short) 3);
    private static final c r = new c("appId", C0374dh.i, (short) 4);
    private static final c s = new c(o.d, C0374dh.i, (short) 5);
    private static final c t = new c(NativeInterface.PARAM_SHARE_TOPIC, C0374dh.i, (short) 6);
    private static final c u = new c("aliasName", C0374dh.i, (short) 7);
    private static final c v = new c(f.a, C0374dh.j, (short) 8);
    private static final c w = new c("needAck", (byte) 2, (short) 9);
    private static final c x = new c("params", C0374dh.k, (short) 10);
    private static final c y = new c(WidgetRequestParam.REQ_PARAM_COMMENT_CATEGORY, C0374dh.i, (short) 11);
    private static final c z = new c("userAccount", C0374dh.i, (short) 12);
    private BitSet A = new BitSet(1);
    public String a;
    public C1104k b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public C1096c h;
    public boolean i = true;
    public Map<String, String> j;
    public String k;
    public String l;

    static {
        Map enumMap = new EnumMap(F.class);
        enumMap.put(F.DEBUG, new org.apache.thrift.meta_data.b("debug", (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(F.TARGET, new org.apache.thrift.meta_data.b("target", (byte) 2, new g(C0374dh.j, C1104k.class)));
        enumMap.put(F.ID, new org.apache.thrift.meta_data.b(SyncShoesDataService.d, (byte) 1, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(F.APP_ID, new org.apache.thrift.meta_data.b("appId", (byte) 1, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(F.PACKAGE_NAME, new org.apache.thrift.meta_data.b(o.d, (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(F.TOPIC, new org.apache.thrift.meta_data.b(NativeInterface.PARAM_SHARE_TOPIC, (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(F.ALIAS_NAME, new org.apache.thrift.meta_data.b("aliasName", (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(F.MESSAGE, new org.apache.thrift.meta_data.b(f.a, (byte) 2, new g(C0374dh.j, C1096c.class)));
        enumMap.put(F.NEED_ACK, new org.apache.thrift.meta_data.b("needAck", (byte) 2, new org.apache.thrift.meta_data.c((byte) 2)));
        enumMap.put(F.PARAMS, new org.apache.thrift.meta_data.b("params", (byte) 2, new e(C0374dh.k, new org.apache.thrift.meta_data.c(C0374dh.i), new org.apache.thrift.meta_data.c(C0374dh.i))));
        enumMap.put(F.CATEGORY, new org.apache.thrift.meta_data.b(WidgetRequestParam.REQ_PARAM_COMMENT_CATEGORY, (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(F.USER_ACCOUNT, new org.apache.thrift.meta_data.b("userAccount", (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        m = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(E.class, m);
    }

    public void a(org.apache.thrift.protocol.f fVar) {
        fVar.g();
        while (true) {
            c i = fVar.i();
            if (i.b == (byte) 0) {
                fVar.h();
                t();
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
                    if (i.b != C0374dh.j) {
                        i.a(fVar, i.b);
                        break;
                    }
                    this.b = new C1104k();
                    this.b.a(fVar);
                    break;
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
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.e = fVar.w();
                        break;
                    }
                case a.bt /*6*/:
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.f = fVar.w();
                        break;
                    }
                case a.bc /*7*/:
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.g = fVar.w();
                        break;
                    }
                case a.ba /*8*/:
                    if (i.b != C0374dh.j) {
                        i.a(fVar, i.b);
                        break;
                    }
                    this.h = new C1096c();
                    this.h.a(fVar);
                    break;
                case a.bo /*9*/:
                    if (i.b != (byte) 2) {
                        i.a(fVar, i.b);
                        break;
                    }
                    this.i = fVar.q();
                    a(true);
                    break;
                case a.bd /*10*/:
                    if (i.b != C0374dh.k) {
                        i.a(fVar, i.b);
                        break;
                    }
                    org.apache.thrift.protocol.e k = fVar.k();
                    this.j = new HashMap(k.c * 2);
                    for (int i2 = 0; i2 < k.c; i2++) {
                        this.j.put(fVar.w(), fVar.w());
                    }
                    fVar.l();
                    break;
                case a.aW /*11*/:
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.k = fVar.w();
                        break;
                    }
                case a.be /*12*/:
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.l = fVar.w();
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
        this.A.set(0, z);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(E e) {
        if (e == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = e.a();
        if ((a || a2) && (!a || !a2 || !this.a.equals(e.a))) {
            return false;
        }
        a = b();
        a2 = e.b();
        if ((a || a2) && (!a || !a2 || !this.b.a(e.b))) {
            return false;
        }
        a = d();
        a2 = e.d();
        if ((a || a2) && (!a || !a2 || !this.c.equals(e.c))) {
            return false;
        }
        a = f();
        a2 = e.f();
        if ((a || a2) && (!a || !a2 || !this.d.equals(e.d))) {
            return false;
        }
        a = g();
        a2 = e.g();
        if ((a || a2) && (!a || !a2 || !this.e.equals(e.e))) {
            return false;
        }
        a = i();
        a2 = e.i();
        if ((a || a2) && (!a || !a2 || !this.f.equals(e.f))) {
            return false;
        }
        a = k();
        a2 = e.k();
        if ((a || a2) && (!a || !a2 || !this.g.equals(e.g))) {
            return false;
        }
        a = m();
        a2 = e.m();
        if ((a || a2) && (!a || !a2 || !this.h.a(e.h))) {
            return false;
        }
        a = n();
        a2 = e.n();
        if ((a || a2) && (!a || !a2 || this.i != e.i)) {
            return false;
        }
        a = o();
        a2 = e.o();
        if ((a || a2) && (!a || !a2 || !this.j.equals(e.j))) {
            return false;
        }
        a = q();
        a2 = e.q();
        if ((a || a2) && (!a || !a2 || !this.k.equals(e.k))) {
            return false;
        }
        a = s();
        a2 = e.s();
        return !(a || a2) || (a && a2 && this.l.equals(e.l));
    }

    public int b(E e) {
        if (!getClass().equals(e.getClass())) {
            return getClass().getName().compareTo(e.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(e.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            compareTo = org.apache.thrift.c.a(this.a, e.a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(e.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            compareTo = org.apache.thrift.c.a(this.b, e.b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(d()).compareTo(Boolean.valueOf(e.d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (d()) {
            compareTo = org.apache.thrift.c.a(this.c, e.c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(f()).compareTo(Boolean.valueOf(e.f()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (f()) {
            compareTo = org.apache.thrift.c.a(this.d, e.d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(g()).compareTo(Boolean.valueOf(e.g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (g()) {
            compareTo = org.apache.thrift.c.a(this.e, e.e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(i()).compareTo(Boolean.valueOf(e.i()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (i()) {
            compareTo = org.apache.thrift.c.a(this.f, e.f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(k()).compareTo(Boolean.valueOf(e.k()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (k()) {
            compareTo = org.apache.thrift.c.a(this.g, e.g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m()).compareTo(Boolean.valueOf(e.m()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m()) {
            compareTo = org.apache.thrift.c.a(this.h, e.h);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(n()).compareTo(Boolean.valueOf(e.n()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (n()) {
            compareTo = org.apache.thrift.c.a(this.i, e.i);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(o()).compareTo(Boolean.valueOf(e.o()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (o()) {
            compareTo = org.apache.thrift.c.a(this.j, e.j);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(q()).compareTo(Boolean.valueOf(e.q()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (q()) {
            compareTo = org.apache.thrift.c.a(this.k, e.k);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(s()).compareTo(Boolean.valueOf(e.s()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (s()) {
            compareTo = org.apache.thrift.c.a(this.l, e.l);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public void b(org.apache.thrift.protocol.f fVar) {
        t();
        fVar.a(n);
        if (this.a != null && a()) {
            fVar.a(o);
            fVar.a(this.a);
            fVar.b();
        }
        if (this.b != null && b()) {
            fVar.a(p);
            this.b.b(fVar);
            fVar.b();
        }
        if (this.c != null) {
            fVar.a(q);
            fVar.a(this.c);
            fVar.b();
        }
        if (this.d != null) {
            fVar.a(r);
            fVar.a(this.d);
            fVar.b();
        }
        if (this.e != null && g()) {
            fVar.a(s);
            fVar.a(this.e);
            fVar.b();
        }
        if (this.f != null && i()) {
            fVar.a(t);
            fVar.a(this.f);
            fVar.b();
        }
        if (this.g != null && k()) {
            fVar.a(u);
            fVar.a(this.g);
            fVar.b();
        }
        if (this.h != null && m()) {
            fVar.a(v);
            this.h.b(fVar);
            fVar.b();
        }
        if (n()) {
            fVar.a(w);
            fVar.a(this.i);
            fVar.b();
        }
        if (this.j != null && o()) {
            fVar.a(x);
            fVar.a(new org.apache.thrift.protocol.e(C0374dh.i, C0374dh.i, this.j.size()));
            for (Entry entry : this.j.entrySet()) {
                fVar.a((String) entry.getKey());
                fVar.a((String) entry.getValue());
            }
            fVar.d();
            fVar.b();
        }
        if (this.k != null && q()) {
            fVar.a(y);
            fVar.a(this.k);
            fVar.b();
        }
        if (this.l != null && s()) {
            fVar.a(z);
            fVar.a(this.l);
            fVar.b();
        }
        fVar.c();
        fVar.a();
    }

    public boolean b() {
        return this.b != null;
    }

    public String c() {
        return this.c;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((E) obj);
    }

    public boolean d() {
        return this.c != null;
    }

    public String e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof E)) ? a((E) obj) : false;
    }

    public boolean f() {
        return this.d != null;
    }

    public boolean g() {
        return this.e != null;
    }

    public String h() {
        return this.f;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f != null;
    }

    public String j() {
        return this.g;
    }

    public boolean k() {
        return this.g != null;
    }

    public C1096c l() {
        return this.h;
    }

    public boolean m() {
        return this.h != null;
    }

    public boolean n() {
        return this.A.get(0);
    }

    public boolean o() {
        return this.j != null;
    }

    public String p() {
        return this.k;
    }

    public boolean q() {
        return this.k != null;
    }

    public String r() {
        return this.l;
    }

    public boolean s() {
        return this.l != null;
    }

    public void t() {
        if (this.c == null) {
            throw new org.apache.thrift.protocol.g("Required field 'id' was not present! Struct: " + toString());
        } else if (this.d == null) {
            throw new org.apache.thrift.protocol.g("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        Object obj = null;
        StringBuilder stringBuilder = new StringBuilder("XmPushActionSendMessage(");
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
        if (g()) {
            stringBuilder.append(", ");
            stringBuilder.append("packageName:");
            if (this.e == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.e);
            }
        }
        if (i()) {
            stringBuilder.append(", ");
            stringBuilder.append("topic:");
            if (this.f == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f);
            }
        }
        if (k()) {
            stringBuilder.append(", ");
            stringBuilder.append("aliasName:");
            if (this.g == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.g);
            }
        }
        if (m()) {
            stringBuilder.append(", ");
            stringBuilder.append("message:");
            if (this.h == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.h);
            }
        }
        if (n()) {
            stringBuilder.append(", ");
            stringBuilder.append("needAck:");
            stringBuilder.append(this.i);
        }
        if (o()) {
            stringBuilder.append(", ");
            stringBuilder.append("params:");
            if (this.j == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.j);
            }
        }
        if (q()) {
            stringBuilder.append(", ");
            stringBuilder.append("category:");
            if (this.k == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.k);
            }
        }
        if (s()) {
            stringBuilder.append(", ");
            stringBuilder.append("userAccount:");
            if (this.l == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.l);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
