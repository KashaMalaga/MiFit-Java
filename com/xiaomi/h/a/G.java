package com.xiaomi.h.a;

import b.a.C0374dh;
import cn.com.smartdevices.bracelet.partner.NativeInterface;
import cn.com.smartdevices.bracelet.shoes.sync.SyncShoesDataService;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import com.xiaomi.market.sdk.o;
import java.io.Serializable;
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

public class G implements Serializable, Cloneable, b<G, H> {
    public static final Map<H, org.apache.thrift.meta_data.b> h;
    private static final k i = new k("XmPushActionSubscription");
    private static final c j = new c("debug", C0374dh.i, (short) 1);
    private static final c k = new c("target", C0374dh.j, (short) 2);
    private static final c l = new c(SyncShoesDataService.d, C0374dh.i, (short) 3);
    private static final c m = new c("appId", C0374dh.i, (short) 4);
    private static final c n = new c(NativeInterface.PARAM_SHARE_TOPIC, C0374dh.i, (short) 5);
    private static final c o = new c(o.d, C0374dh.i, (short) 6);
    private static final c p = new c(WidgetRequestParam.REQ_PARAM_COMMENT_CATEGORY, C0374dh.i, (short) 7);
    public String a;
    public C1104k b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;

    static {
        Map enumMap = new EnumMap(H.class);
        enumMap.put(H.DEBUG, new org.apache.thrift.meta_data.b("debug", (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(H.TARGET, new org.apache.thrift.meta_data.b("target", (byte) 2, new g(C0374dh.j, C1104k.class)));
        enumMap.put(H.ID, new org.apache.thrift.meta_data.b(SyncShoesDataService.d, (byte) 1, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(H.APP_ID, new org.apache.thrift.meta_data.b("appId", (byte) 1, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(H.TOPIC, new org.apache.thrift.meta_data.b(NativeInterface.PARAM_SHARE_TOPIC, (byte) 1, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(H.PACKAGE_NAME, new org.apache.thrift.meta_data.b(o.d, (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(H.CATEGORY, new org.apache.thrift.meta_data.b(WidgetRequestParam.REQ_PARAM_COMMENT_CATEGORY, (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        h = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(G.class, h);
    }

    public G a(String str) {
        this.c = str;
        return this;
    }

    public void a(f fVar) {
        fVar.g();
        while (true) {
            c i = fVar.i();
            if (i.b == (byte) 0) {
                fVar.h();
                h();
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

    public boolean a(G g) {
        if (g == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = g.a();
        if ((a || a2) && (!a || !a2 || !this.a.equals(g.a))) {
            return false;
        }
        a = b();
        a2 = g.b();
        if ((a || a2) && (!a || !a2 || !this.b.a(g.b))) {
            return false;
        }
        a = c();
        a2 = g.c();
        if ((a || a2) && (!a || !a2 || !this.c.equals(g.c))) {
            return false;
        }
        a = d();
        a2 = g.d();
        if ((a || a2) && (!a || !a2 || !this.d.equals(g.d))) {
            return false;
        }
        a = e();
        a2 = g.e();
        if ((a || a2) && (!a || !a2 || !this.e.equals(g.e))) {
            return false;
        }
        a = f();
        a2 = g.f();
        if ((a || a2) && (!a || !a2 || !this.f.equals(g.f))) {
            return false;
        }
        a = g();
        a2 = g.g();
        return !(a || a2) || (a && a2 && this.g.equals(g.g));
    }

    public int b(G g) {
        if (!getClass().equals(g.getClass())) {
            return getClass().getName().compareTo(g.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(g.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            compareTo = org.apache.thrift.c.a(this.a, g.a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(g.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            compareTo = org.apache.thrift.c.a(this.b, g.b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(c()).compareTo(Boolean.valueOf(g.c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (c()) {
            compareTo = org.apache.thrift.c.a(this.c, g.c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(d()).compareTo(Boolean.valueOf(g.d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (d()) {
            compareTo = org.apache.thrift.c.a(this.d, g.d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(e()).compareTo(Boolean.valueOf(g.e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (e()) {
            compareTo = org.apache.thrift.c.a(this.e, g.e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(f()).compareTo(Boolean.valueOf(g.f()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (f()) {
            compareTo = org.apache.thrift.c.a(this.f, g.f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(g()).compareTo(Boolean.valueOf(g.g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (g()) {
            compareTo = org.apache.thrift.c.a(this.g, g.g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public G b(String str) {
        this.d = str;
        return this;
    }

    public void b(f fVar) {
        h();
        fVar.a(i);
        if (this.a != null && a()) {
            fVar.a(j);
            fVar.a(this.a);
            fVar.b();
        }
        if (this.b != null && b()) {
            fVar.a(k);
            this.b.b(fVar);
            fVar.b();
        }
        if (this.c != null) {
            fVar.a(l);
            fVar.a(this.c);
            fVar.b();
        }
        if (this.d != null) {
            fVar.a(m);
            fVar.a(this.d);
            fVar.b();
        }
        if (this.e != null) {
            fVar.a(n);
            fVar.a(this.e);
            fVar.b();
        }
        if (this.f != null && f()) {
            fVar.a(o);
            fVar.a(this.f);
            fVar.b();
        }
        if (this.g != null && g()) {
            fVar.a(p);
            fVar.a(this.g);
            fVar.b();
        }
        fVar.c();
        fVar.a();
    }

    public boolean b() {
        return this.b != null;
    }

    public G c(String str) {
        this.e = str;
        return this;
    }

    public boolean c() {
        return this.c != null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((G) obj);
    }

    public G d(String str) {
        this.f = str;
        return this;
    }

    public boolean d() {
        return this.d != null;
    }

    public G e(String str) {
        this.g = str;
        return this;
    }

    public boolean e() {
        return this.e != null;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof G)) ? a((G) obj) : false;
    }

    public boolean f() {
        return this.f != null;
    }

    public boolean g() {
        return this.g != null;
    }

    public void h() {
        if (this.c == null) {
            throw new org.apache.thrift.protocol.g("Required field 'id' was not present! Struct: " + toString());
        } else if (this.d == null) {
            throw new org.apache.thrift.protocol.g("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.e == null) {
            throw new org.apache.thrift.protocol.g("Required field 'topic' was not present! Struct: " + toString());
        }
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        Object obj = null;
        StringBuilder stringBuilder = new StringBuilder("XmPushActionSubscription(");
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
        stringBuilder.append("topic:");
        if (this.e == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.e);
        }
        if (f()) {
            stringBuilder.append(", ");
            stringBuilder.append("packageName:");
            if (this.f == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f);
            }
        }
        if (g()) {
            stringBuilder.append(", ");
            stringBuilder.append("category:");
            if (this.g == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.g);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
