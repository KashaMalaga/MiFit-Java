package com.xiaomi.h.a;

import b.a.C0374dh;
import cn.com.smartdevices.bracelet.shoes.sync.SyncShoesDataService;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import com.tencent.open.SocialConstants;
import com.xiaomi.channel.b.a;
import com.xiaomi.market.sdk.o;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import kankan.wheel.widget.l;
import org.apache.thrift.b;
import org.apache.thrift.meta_data.d;
import org.apache.thrift.meta_data.g;
import org.apache.thrift.protocol.c;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.i;
import org.apache.thrift.protocol.k;

public class C1110q implements Serializable, Cloneable, b<C1110q, C1111r> {
    public static final Map<C1111r, org.apache.thrift.meta_data.b> l;
    private static final k m = new k("XmPushActionCommandResult");
    private static final c n = new c("debug", C0374dh.i, (short) 1);
    private static final c o = new c("target", C0374dh.j, (short) 2);
    private static final c p = new c(SyncShoesDataService.d, C0374dh.i, (short) 3);
    private static final c q = new c("appId", C0374dh.i, (short) 4);
    private static final c r = new c("cmdName", C0374dh.i, (short) 5);
    private static final c s = new c(SocialConstants.TYPE_REQUEST, C0374dh.j, (short) 6);
    private static final c t = new c(a.c, (byte) 10, (short) 7);
    private static final c u = new c("reason", C0374dh.i, (short) 8);
    private static final c v = new c(o.d, C0374dh.i, (short) 9);
    private static final c w = new c("cmdArgs", C0374dh.m, (short) 10);
    private static final c x = new c(WidgetRequestParam.REQ_PARAM_COMMENT_CATEGORY, C0374dh.i, (short) 12);
    public String a;
    public C1104k b;
    public String c;
    public String d;
    public String e;
    public C1108o f;
    public long g;
    public String h;
    public String i;
    public List<String> j;
    public String k;
    private BitSet y = new BitSet(1);

    static {
        Map enumMap = new EnumMap(C1111r.class);
        enumMap.put(C1111r.DEBUG, new org.apache.thrift.meta_data.b("debug", (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(C1111r.TARGET, new org.apache.thrift.meta_data.b("target", (byte) 2, new g(C0374dh.j, C1104k.class)));
        enumMap.put(C1111r.ID, new org.apache.thrift.meta_data.b(SyncShoesDataService.d, (byte) 1, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(C1111r.APP_ID, new org.apache.thrift.meta_data.b("appId", (byte) 1, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(C1111r.CMD_NAME, new org.apache.thrift.meta_data.b("cmdName", (byte) 1, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(C1111r.REQUEST, new org.apache.thrift.meta_data.b(SocialConstants.TYPE_REQUEST, (byte) 2, new g(C0374dh.j, C1108o.class)));
        enumMap.put(C1111r.ERROR_CODE, new org.apache.thrift.meta_data.b(a.c, (byte) 1, new org.apache.thrift.meta_data.c((byte) 10)));
        enumMap.put(C1111r.REASON, new org.apache.thrift.meta_data.b("reason", (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(C1111r.PACKAGE_NAME, new org.apache.thrift.meta_data.b(o.d, (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(C1111r.CMD_ARGS, new org.apache.thrift.meta_data.b("cmdArgs", (byte) 2, new d(C0374dh.m, new org.apache.thrift.meta_data.c(C0374dh.i))));
        enumMap.put(C1111r.CATEGORY, new org.apache.thrift.meta_data.b(WidgetRequestParam.REQ_PARAM_COMMENT_CATEGORY, (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        l = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(C1110q.class, l);
    }

    public void a(f fVar) {
        fVar.g();
        while (true) {
            c i = fVar.i();
            if (i.b == (byte) 0) {
                fVar.h();
                if (h()) {
                    o();
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
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.e = fVar.w();
                        break;
                    }
                case kankan.wheel.widget.a.bt /*6*/:
                    if (i.b != C0374dh.j) {
                        i.a(fVar, i.b);
                        break;
                    }
                    this.f = new C1108o();
                    this.f.a(fVar);
                    break;
                case kankan.wheel.widget.a.bc /*7*/:
                    if (i.b != (byte) 10) {
                        i.a(fVar, i.b);
                        break;
                    }
                    this.g = fVar.u();
                    a(true);
                    break;
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
                    if (i.b != C0374dh.m) {
                        i.a(fVar, i.b);
                        break;
                    }
                    org.apache.thrift.protocol.d m = fVar.m();
                    this.j = new ArrayList(m.b);
                    for (int i2 = 0; i2 < m.b; i2++) {
                        this.j.add(fVar.w());
                    }
                    fVar.n();
                    break;
                case kankan.wheel.widget.a.be /*12*/:
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.k = fVar.w();
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
        this.y.set(0, z);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(C1110q c1110q) {
        if (c1110q == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = c1110q.a();
        if ((a || a2) && (!a || !a2 || !this.a.equals(c1110q.a))) {
            return false;
        }
        a = b();
        a2 = c1110q.b();
        if ((a || a2) && (!a || !a2 || !this.b.a(c1110q.b))) {
            return false;
        }
        a = c();
        a2 = c1110q.c();
        if ((a || a2) && (!a || !a2 || !this.c.equals(c1110q.c))) {
            return false;
        }
        a = d();
        a2 = c1110q.d();
        if ((a || a2) && (!a || !a2 || !this.d.equals(c1110q.d))) {
            return false;
        }
        a = f();
        a2 = c1110q.f();
        if ((a || a2) && (!a || !a2 || !this.e.equals(c1110q.e))) {
            return false;
        }
        a = g();
        a2 = c1110q.g();
        if (((a || a2) && (!a || !a2 || !this.f.a(c1110q.f))) || this.g != c1110q.g) {
            return false;
        }
        a = i();
        a2 = c1110q.i();
        if ((a || a2) && (!a || !a2 || !this.h.equals(c1110q.h))) {
            return false;
        }
        a = j();
        a2 = c1110q.j();
        if ((a || a2) && (!a || !a2 || !this.i.equals(c1110q.i))) {
            return false;
        }
        a = l();
        a2 = c1110q.l();
        if ((a || a2) && (!a || !a2 || !this.j.equals(c1110q.j))) {
            return false;
        }
        a = n();
        a2 = c1110q.n();
        return !(a || a2) || (a && a2 && this.k.equals(c1110q.k));
    }

    public int b(C1110q c1110q) {
        if (!getClass().equals(c1110q.getClass())) {
            return getClass().getName().compareTo(c1110q.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(c1110q.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            compareTo = org.apache.thrift.c.a(this.a, c1110q.a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(c1110q.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            compareTo = org.apache.thrift.c.a(this.b, c1110q.b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(c()).compareTo(Boolean.valueOf(c1110q.c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (c()) {
            compareTo = org.apache.thrift.c.a(this.c, c1110q.c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(d()).compareTo(Boolean.valueOf(c1110q.d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (d()) {
            compareTo = org.apache.thrift.c.a(this.d, c1110q.d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(f()).compareTo(Boolean.valueOf(c1110q.f()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (f()) {
            compareTo = org.apache.thrift.c.a(this.e, c1110q.e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(g()).compareTo(Boolean.valueOf(c1110q.g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (g()) {
            compareTo = org.apache.thrift.c.a(this.f, c1110q.f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(h()).compareTo(Boolean.valueOf(c1110q.h()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (h()) {
            compareTo = org.apache.thrift.c.a(this.g, c1110q.g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(i()).compareTo(Boolean.valueOf(c1110q.i()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (i()) {
            compareTo = org.apache.thrift.c.a(this.h, c1110q.h);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(j()).compareTo(Boolean.valueOf(c1110q.j()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (j()) {
            compareTo = org.apache.thrift.c.a(this.i, c1110q.i);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(l()).compareTo(Boolean.valueOf(c1110q.l()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (l()) {
            compareTo = org.apache.thrift.c.a(this.j, c1110q.j);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(n()).compareTo(Boolean.valueOf(c1110q.n()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (n()) {
            compareTo = org.apache.thrift.c.a(this.k, c1110q.k);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public void b(f fVar) {
        o();
        fVar.a(m);
        if (this.a != null && a()) {
            fVar.a(n);
            fVar.a(this.a);
            fVar.b();
        }
        if (this.b != null && b()) {
            fVar.a(o);
            this.b.b(fVar);
            fVar.b();
        }
        if (this.c != null) {
            fVar.a(p);
            fVar.a(this.c);
            fVar.b();
        }
        if (this.d != null) {
            fVar.a(q);
            fVar.a(this.d);
            fVar.b();
        }
        if (this.e != null) {
            fVar.a(r);
            fVar.a(this.e);
            fVar.b();
        }
        if (this.f != null && g()) {
            fVar.a(s);
            this.f.b(fVar);
            fVar.b();
        }
        fVar.a(t);
        fVar.a(this.g);
        fVar.b();
        if (this.h != null && i()) {
            fVar.a(u);
            fVar.a(this.h);
            fVar.b();
        }
        if (this.i != null && j()) {
            fVar.a(v);
            fVar.a(this.i);
            fVar.b();
        }
        if (this.j != null && l()) {
            fVar.a(w);
            fVar.a(new org.apache.thrift.protocol.d(C0374dh.i, this.j.size()));
            for (String a : this.j) {
                fVar.a(a);
            }
            fVar.e();
            fVar.b();
        }
        if (this.k != null && n()) {
            fVar.a(x);
            fVar.a(this.k);
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
        return b((C1110q) obj);
    }

    public boolean d() {
        return this.d != null;
    }

    public String e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof C1110q)) ? a((C1110q) obj) : false;
    }

    public boolean f() {
        return this.e != null;
    }

    public boolean g() {
        return this.f != null;
    }

    public boolean h() {
        return this.y.get(0);
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

    public List<String> k() {
        return this.j;
    }

    public boolean l() {
        return this.j != null;
    }

    public String m() {
        return this.k;
    }

    public boolean n() {
        return this.k != null;
    }

    public void o() {
        if (this.c == null) {
            throw new org.apache.thrift.protocol.g("Required field 'id' was not present! Struct: " + toString());
        } else if (this.d == null) {
            throw new org.apache.thrift.protocol.g("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.e == null) {
            throw new org.apache.thrift.protocol.g("Required field 'cmdName' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        Object obj = null;
        StringBuilder stringBuilder = new StringBuilder("XmPushActionCommandResult(");
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
        stringBuilder.append(", ");
        stringBuilder.append("cmdName:");
        if (this.e == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.e);
        }
        if (g()) {
            stringBuilder.append(", ");
            stringBuilder.append("request:");
            if (this.f == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f);
            }
        }
        stringBuilder.append(", ");
        stringBuilder.append("errorCode:");
        stringBuilder.append(this.g);
        if (i()) {
            stringBuilder.append(", ");
            stringBuilder.append("reason:");
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
        if (l()) {
            stringBuilder.append(", ");
            stringBuilder.append("cmdArgs:");
            if (this.j == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.j);
            }
        }
        if (n()) {
            stringBuilder.append(", ");
            stringBuilder.append("category:");
            if (this.k == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.k);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
