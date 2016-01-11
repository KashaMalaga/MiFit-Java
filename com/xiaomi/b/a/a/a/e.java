package com.xiaomi.b.a.a.a;

import b.a.C0374dh;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import com.xiaomi.b.a.a.a;
import java.io.Serializable;
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

public class e implements Serializable, Cloneable, b<e, f> {
    public static final Map<f, org.apache.thrift.meta_data.b> a;
    private static final k b = new k("HttpLog");
    private static final c c = new c("common", C0374dh.j, (short) 1);
    private static final c d = new c(WidgetRequestParam.REQ_PARAM_COMMENT_CATEGORY, C0374dh.i, (short) 2);
    private static final c e = new c("httpApi", C0374dh.j, (short) 3);
    private static final c f = new c("passport", C0374dh.j, (short) 4);
    private a g;
    private String h = com.xiaomi.e.a.f;
    private c i;
    private k j;

    static {
        Map enumMap = new EnumMap(f.class);
        enumMap.put(f.COMMON, new org.apache.thrift.meta_data.b("common", (byte) 1, new g(C0374dh.j, a.class)));
        enumMap.put(f.CATEGORY, new org.apache.thrift.meta_data.b(WidgetRequestParam.REQ_PARAM_COMMENT_CATEGORY, (byte) 1, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(f.HTTP_API, new org.apache.thrift.meta_data.b("httpApi", (byte) 2, new g(C0374dh.j, c.class)));
        enumMap.put(f.PASSPORT, new org.apache.thrift.meta_data.b("passport", (byte) 2, new g(C0374dh.j, k.class)));
        a = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(e.class, a);
    }

    public e a(c cVar) {
        this.i = cVar;
        return this;
    }

    public e a(a aVar) {
        this.g = aVar;
        return this;
    }

    public e a(String str) {
        this.h = str;
        return this;
    }

    public void a(f fVar) {
        fVar.g();
        while (true) {
            c i = fVar.i();
            if (i.b == (byte) 0) {
                fVar.h();
                e();
                return;
            }
            switch (i.c) {
                case l.a /*1*/:
                    if (i.b != C0374dh.j) {
                        i.a(fVar, i.b);
                        break;
                    }
                    this.g = new a();
                    this.g.a(fVar);
                    break;
                case kankan.wheel.widget.a.k /*2*/:
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.h = fVar.w();
                        break;
                    }
                case kankan.wheel.widget.a.l /*3*/:
                    if (i.b != C0374dh.j) {
                        i.a(fVar, i.b);
                        break;
                    }
                    this.i = new c();
                    this.i.a(fVar);
                    break;
                case kankan.wheel.widget.a.aQ /*4*/:
                    if (i.b != C0374dh.j) {
                        i.a(fVar, i.b);
                        break;
                    }
                    this.j = new k();
                    this.j.a(fVar);
                    break;
                default:
                    i.a(fVar, i.b);
                    break;
            }
            fVar.j();
        }
    }

    public boolean a() {
        return this.g != null;
    }

    public boolean a(e eVar) {
        if (eVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = eVar.a();
        if ((a || a2) && (!a || !a2 || !this.g.a(eVar.g))) {
            return false;
        }
        a = b();
        a2 = eVar.b();
        if ((a || a2) && (!a || !a2 || !this.h.equals(eVar.h))) {
            return false;
        }
        a = c();
        a2 = eVar.c();
        if ((a || a2) && (!a || !a2 || !this.i.a(eVar.i))) {
            return false;
        }
        a = d();
        a2 = eVar.d();
        return !(a || a2) || (a && a2 && this.j.a(eVar.j));
    }

    public int b(e eVar) {
        if (!getClass().equals(eVar.getClass())) {
            return getClass().getName().compareTo(eVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(eVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            compareTo = org.apache.thrift.c.a(this.g, eVar.g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(eVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            compareTo = org.apache.thrift.c.a(this.h, eVar.h);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(c()).compareTo(Boolean.valueOf(eVar.c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (c()) {
            compareTo = org.apache.thrift.c.a(this.i, eVar.i);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(d()).compareTo(Boolean.valueOf(eVar.d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (d()) {
            compareTo = org.apache.thrift.c.a(this.j, eVar.j);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public void b(f fVar) {
        e();
        fVar.a(b);
        if (this.g != null) {
            fVar.a(c);
            this.g.b(fVar);
            fVar.b();
        }
        if (this.h != null) {
            fVar.a(d);
            fVar.a(this.h);
            fVar.b();
        }
        if (this.i != null && c()) {
            fVar.a(e);
            this.i.b(fVar);
            fVar.b();
        }
        if (this.j != null && d()) {
            fVar.a(f);
            this.j.b(fVar);
            fVar.b();
        }
        fVar.c();
        fVar.a();
    }

    public boolean b() {
        return this.h != null;
    }

    public boolean c() {
        return this.i != null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((e) obj);
    }

    public boolean d() {
        return this.j != null;
    }

    public void e() {
        if (this.g == null) {
            throw new org.apache.thrift.protocol.g("Required field 'common' was not present! Struct: " + toString());
        } else if (this.h == null) {
            throw new org.apache.thrift.protocol.g("Required field 'category' was not present! Struct: " + toString());
        }
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof e)) ? a((e) obj) : false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("HttpLog(");
        stringBuilder.append("common:");
        if (this.g == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.g);
        }
        stringBuilder.append(", ");
        stringBuilder.append("category:");
        if (this.h == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.h);
        }
        if (c()) {
            stringBuilder.append(", ");
            stringBuilder.append("httpApi:");
            if (this.i == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.i);
            }
        }
        if (d()) {
            stringBuilder.append(", ");
            stringBuilder.append("passport:");
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
