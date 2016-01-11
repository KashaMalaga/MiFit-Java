package com.xiaomi.h.a;

import b.a.C0374dh;
import cn.com.smartdevices.bracelet.shoes.sync.SyncShoesDataService;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import com.xiaomi.market.sdk.o;
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
import org.apache.thrift.meta_data.g;
import org.apache.thrift.protocol.c;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.i;
import org.apache.thrift.protocol.k;

public class C1108o implements Serializable, Cloneable, b<C1108o, C1109p> {
    public static final Map<C1109p, org.apache.thrift.meta_data.b> i;
    private static final k j = new k("XmPushActionCommand");
    private static final c k = new c("debug", C0374dh.i, (short) 1);
    private static final c l = new c("target", C0374dh.j, (short) 2);
    private static final c m = new c(SyncShoesDataService.d, C0374dh.i, (short) 3);
    private static final c n = new c("appId", C0374dh.i, (short) 4);
    private static final c o = new c("cmdName", C0374dh.i, (short) 5);
    private static final c p = new c("cmdArgs", C0374dh.m, (short) 6);
    private static final c q = new c(o.d, C0374dh.i, (short) 7);
    private static final c r = new c(WidgetRequestParam.REQ_PARAM_COMMENT_CATEGORY, C0374dh.i, (short) 9);
    public String a;
    public C1104k b;
    public String c;
    public String d;
    public String e;
    public List<String> f;
    public String g;
    public String h;

    static {
        Map enumMap = new EnumMap(C1109p.class);
        enumMap.put(C1109p.DEBUG, new org.apache.thrift.meta_data.b("debug", (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(C1109p.TARGET, new org.apache.thrift.meta_data.b("target", (byte) 2, new g(C0374dh.j, C1104k.class)));
        enumMap.put(C1109p.ID, new org.apache.thrift.meta_data.b(SyncShoesDataService.d, (byte) 1, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(C1109p.APP_ID, new org.apache.thrift.meta_data.b("appId", (byte) 1, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(C1109p.CMD_NAME, new org.apache.thrift.meta_data.b("cmdName", (byte) 1, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(C1109p.CMD_ARGS, new org.apache.thrift.meta_data.b("cmdArgs", (byte) 2, new d(C0374dh.m, new org.apache.thrift.meta_data.c(C0374dh.i))));
        enumMap.put(C1109p.PACKAGE_NAME, new org.apache.thrift.meta_data.b(o.d, (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(C1109p.CATEGORY, new org.apache.thrift.meta_data.b(WidgetRequestParam.REQ_PARAM_COMMENT_CATEGORY, (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        i = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(C1108o.class, i);
    }

    public C1108o a(String str) {
        this.c = str;
        return this;
    }

    public void a(f fVar) {
        fVar.g();
        while (true) {
            c i = fVar.i();
            if (i.b == (byte) 0) {
                fVar.h();
                i();
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
                    if (i.b != C0374dh.m) {
                        i.a(fVar, i.b);
                        break;
                    }
                    org.apache.thrift.protocol.d m = fVar.m();
                    this.f = new ArrayList(m.b);
                    for (int i2 = 0; i2 < m.b; i2++) {
                        this.f.add(fVar.w());
                    }
                    fVar.n();
                    break;
                case a.bc /*7*/:
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.g = fVar.w();
                        break;
                    }
                case a.bo /*9*/:
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

    public boolean a() {
        return this.a != null;
    }

    public boolean a(C1108o c1108o) {
        if (c1108o == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = c1108o.a();
        if ((a || a2) && (!a || !a2 || !this.a.equals(c1108o.a))) {
            return false;
        }
        a = b();
        a2 = c1108o.b();
        if ((a || a2) && (!a || !a2 || !this.b.a(c1108o.b))) {
            return false;
        }
        a = c();
        a2 = c1108o.c();
        if ((a || a2) && (!a || !a2 || !this.c.equals(c1108o.c))) {
            return false;
        }
        a = d();
        a2 = c1108o.d();
        if ((a || a2) && (!a || !a2 || !this.d.equals(c1108o.d))) {
            return false;
        }
        a = e();
        a2 = c1108o.e();
        if ((a || a2) && (!a || !a2 || !this.e.equals(c1108o.e))) {
            return false;
        }
        a = f();
        a2 = c1108o.f();
        if ((a || a2) && (!a || !a2 || !this.f.equals(c1108o.f))) {
            return false;
        }
        a = g();
        a2 = c1108o.g();
        if ((a || a2) && (!a || !a2 || !this.g.equals(c1108o.g))) {
            return false;
        }
        a = h();
        a2 = c1108o.h();
        return !(a || a2) || (a && a2 && this.h.equals(c1108o.h));
    }

    public int b(C1108o c1108o) {
        if (!getClass().equals(c1108o.getClass())) {
            return getClass().getName().compareTo(c1108o.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(c1108o.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            compareTo = org.apache.thrift.c.a(this.a, c1108o.a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(c1108o.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            compareTo = org.apache.thrift.c.a(this.b, c1108o.b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(c()).compareTo(Boolean.valueOf(c1108o.c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (c()) {
            compareTo = org.apache.thrift.c.a(this.c, c1108o.c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(d()).compareTo(Boolean.valueOf(c1108o.d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (d()) {
            compareTo = org.apache.thrift.c.a(this.d, c1108o.d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(e()).compareTo(Boolean.valueOf(c1108o.e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (e()) {
            compareTo = org.apache.thrift.c.a(this.e, c1108o.e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(f()).compareTo(Boolean.valueOf(c1108o.f()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (f()) {
            compareTo = org.apache.thrift.c.a(this.f, c1108o.f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(g()).compareTo(Boolean.valueOf(c1108o.g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (g()) {
            compareTo = org.apache.thrift.c.a(this.g, c1108o.g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(h()).compareTo(Boolean.valueOf(c1108o.h()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (h()) {
            compareTo = org.apache.thrift.c.a(this.h, c1108o.h);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public C1108o b(String str) {
        this.d = str;
        return this;
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
        if (this.e != null) {
            fVar.a(o);
            fVar.a(this.e);
            fVar.b();
        }
        if (this.f != null && f()) {
            fVar.a(p);
            fVar.a(new org.apache.thrift.protocol.d(C0374dh.i, this.f.size()));
            for (String a : this.f) {
                fVar.a(a);
            }
            fVar.e();
            fVar.b();
        }
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

    public C1108o c(String str) {
        this.e = str;
        return this;
    }

    public boolean c() {
        return this.c != null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((C1108o) obj);
    }

    public void d(String str) {
        if (this.f == null) {
            this.f = new ArrayList();
        }
        this.f.add(str);
    }

    public boolean d() {
        return this.d != null;
    }

    public C1108o e(String str) {
        this.g = str;
        return this;
    }

    public boolean e() {
        return this.e != null;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof C1108o)) ? a((C1108o) obj) : false;
    }

    public C1108o f(String str) {
        this.h = str;
        return this;
    }

    public boolean f() {
        return this.f != null;
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
        } else if (this.e == null) {
            throw new org.apache.thrift.protocol.g("Required field 'cmdName' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        Object obj = null;
        StringBuilder stringBuilder = new StringBuilder("XmPushActionCommand(");
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
        if (f()) {
            stringBuilder.append(", ");
            stringBuilder.append("cmdArgs:");
            if (this.f == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f);
            }
        }
        if (g()) {
            stringBuilder.append(", ");
            stringBuilder.append("packageName:");
            if (this.g == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.g);
            }
        }
        if (h()) {
            stringBuilder.append(", ");
            stringBuilder.append("category:");
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
