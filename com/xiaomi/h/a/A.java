package com.xiaomi.h.a;

import b.a.C0374dh;
import cn.com.smartdevices.bracelet.shoes.sync.SyncShoesDataService;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import java.io.Serializable;
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
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.i;
import org.apache.thrift.protocol.k;

public class A implements Serializable, Cloneable, b<A, B> {
    public static final Map<B, org.apache.thrift.meta_data.b> g;
    private static final k h = new k("XmPushActionSendFeedback");
    private static final c i = new c("debug", C0374dh.i, (short) 1);
    private static final c j = new c("target", C0374dh.j, (short) 2);
    private static final c k = new c(SyncShoesDataService.d, C0374dh.i, (short) 3);
    private static final c l = new c("appId", C0374dh.i, (short) 4);
    private static final c m = new c("feedbacks", C0374dh.k, (short) 5);
    private static final c n = new c(WidgetRequestParam.REQ_PARAM_COMMENT_CATEGORY, C0374dh.i, (short) 6);
    public String a;
    public C1104k b;
    public String c;
    public String d;
    public Map<String, String> e;
    public String f;

    static {
        Map enumMap = new EnumMap(B.class);
        enumMap.put(B.DEBUG, new org.apache.thrift.meta_data.b("debug", (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(B.TARGET, new org.apache.thrift.meta_data.b("target", (byte) 2, new g(C0374dh.j, C1104k.class)));
        enumMap.put(B.ID, new org.apache.thrift.meta_data.b(SyncShoesDataService.d, (byte) 1, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(B.APP_ID, new org.apache.thrift.meta_data.b("appId", (byte) 1, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(B.FEEDBACKS, new org.apache.thrift.meta_data.b("feedbacks", (byte) 2, new e(C0374dh.k, new org.apache.thrift.meta_data.c(C0374dh.i), new org.apache.thrift.meta_data.c(C0374dh.i))));
        enumMap.put(B.CATEGORY, new org.apache.thrift.meta_data.b(WidgetRequestParam.REQ_PARAM_COMMENT_CATEGORY, (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        g = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(A.class, g);
    }

    public void a(f fVar) {
        fVar.g();
        while (true) {
            c i = fVar.i();
            if (i.b == (byte) 0) {
                fVar.h();
                g();
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
                    if (i.b != C0374dh.k) {
                        i.a(fVar, i.b);
                        break;
                    }
                    org.apache.thrift.protocol.e k = fVar.k();
                    this.e = new HashMap(k.c * 2);
                    for (int i2 = 0; i2 < k.c; i2++) {
                        this.e.put(fVar.w(), fVar.w());
                    }
                    fVar.l();
                    break;
                case a.bt /*6*/:
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.f = fVar.w();
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

    public boolean a(A a) {
        if (a == null) {
            return false;
        }
        boolean a2 = a();
        boolean a3 = a.a();
        if ((a2 || a3) && (!a2 || !a3 || !this.a.equals(a.a))) {
            return false;
        }
        a2 = b();
        a3 = a.b();
        if ((a2 || a3) && (!a2 || !a3 || !this.b.a(a.b))) {
            return false;
        }
        a2 = c();
        a3 = a.c();
        if ((a2 || a3) && (!a2 || !a3 || !this.c.equals(a.c))) {
            return false;
        }
        a2 = d();
        a3 = a.d();
        if ((a2 || a3) && (!a2 || !a3 || !this.d.equals(a.d))) {
            return false;
        }
        a2 = e();
        a3 = a.e();
        if ((a2 || a3) && (!a2 || !a3 || !this.e.equals(a.e))) {
            return false;
        }
        a2 = f();
        a3 = a.f();
        return !(a2 || a3) || (a2 && a3 && this.f.equals(a.f));
    }

    public int b(A a) {
        if (!getClass().equals(a.getClass())) {
            return getClass().getName().compareTo(a.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(a.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            compareTo = org.apache.thrift.c.a(this.a, a.a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(a.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            compareTo = org.apache.thrift.c.a(this.b, a.b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(c()).compareTo(Boolean.valueOf(a.c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (c()) {
            compareTo = org.apache.thrift.c.a(this.c, a.c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(d()).compareTo(Boolean.valueOf(a.d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (d()) {
            compareTo = org.apache.thrift.c.a(this.d, a.d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(e()).compareTo(Boolean.valueOf(a.e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (e()) {
            compareTo = org.apache.thrift.c.a(this.e, a.e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(f()).compareTo(Boolean.valueOf(a.f()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (f()) {
            compareTo = org.apache.thrift.c.a(this.f, a.f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public void b(f fVar) {
        g();
        fVar.a(h);
        if (this.a != null && a()) {
            fVar.a(i);
            fVar.a(this.a);
            fVar.b();
        }
        if (this.b != null && b()) {
            fVar.a(j);
            this.b.b(fVar);
            fVar.b();
        }
        if (this.c != null) {
            fVar.a(k);
            fVar.a(this.c);
            fVar.b();
        }
        if (this.d != null) {
            fVar.a(l);
            fVar.a(this.d);
            fVar.b();
        }
        if (this.e != null && e()) {
            fVar.a(m);
            fVar.a(new org.apache.thrift.protocol.e(C0374dh.i, C0374dh.i, this.e.size()));
            for (Entry entry : this.e.entrySet()) {
                fVar.a((String) entry.getKey());
                fVar.a((String) entry.getValue());
            }
            fVar.d();
            fVar.b();
        }
        if (this.f != null && f()) {
            fVar.a(n);
            fVar.a(this.f);
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
        return b((A) obj);
    }

    public boolean d() {
        return this.d != null;
    }

    public boolean e() {
        return this.e != null;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof A)) ? a((A) obj) : false;
    }

    public boolean f() {
        return this.f != null;
    }

    public void g() {
        if (this.c == null) {
            throw new org.apache.thrift.protocol.g("Required field 'id' was not present! Struct: " + toString());
        } else if (this.d == null) {
            throw new org.apache.thrift.protocol.g("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        Object obj = null;
        StringBuilder stringBuilder = new StringBuilder("XmPushActionSendFeedback(");
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
            stringBuilder.append("feedbacks:");
            if (this.e == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.e);
            }
        }
        if (f()) {
            stringBuilder.append(", ");
            stringBuilder.append("category:");
            if (this.f == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
