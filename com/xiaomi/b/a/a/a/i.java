package com.xiaomi.b.a.a.a;

import b.a.C0374dh;
import cn.com.smartdevices.bracelet.location.e;
import com.amap.api.services.district.DistrictSearchQuery;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;
import org.apache.thrift.b;
import org.apache.thrift.protocol.c;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.k;

public class i implements Serializable, Cloneable, b<i, j> {
    public static final Map<j, org.apache.thrift.meta_data.b> a;
    private static final k b = new k(e.e);
    private static final c c = new c("contry", C0374dh.i, (short) 1);
    private static final c d = new c(DistrictSearchQuery.KEYWORDS_PROVINCE, C0374dh.i, (short) 2);
    private static final c e = new c(DistrictSearchQuery.KEYWORDS_CITY, C0374dh.i, (short) 3);
    private static final c f = new c("isp", C0374dh.i, (short) 4);
    private String g;
    private String h;
    private String i;
    private String j;

    static {
        Map enumMap = new EnumMap(j.class);
        enumMap.put(j.CONTRY, new org.apache.thrift.meta_data.b("contry", (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(j.PROVINCE, new org.apache.thrift.meta_data.b(DistrictSearchQuery.KEYWORDS_PROVINCE, (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(j.CITY, new org.apache.thrift.meta_data.b(DistrictSearchQuery.KEYWORDS_CITY, (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(j.ISP, new org.apache.thrift.meta_data.b("isp", (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        a = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(i.class, a);
    }

    public i a(String str) {
        this.g = str;
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
                    if (i.b != C0374dh.i) {
                        org.apache.thrift.protocol.i.a(fVar, i.b);
                        break;
                    } else {
                        this.g = fVar.w();
                        break;
                    }
                case a.k /*2*/:
                    if (i.b != C0374dh.i) {
                        org.apache.thrift.protocol.i.a(fVar, i.b);
                        break;
                    } else {
                        this.h = fVar.w();
                        break;
                    }
                case a.l /*3*/:
                    if (i.b != C0374dh.i) {
                        org.apache.thrift.protocol.i.a(fVar, i.b);
                        break;
                    } else {
                        this.i = fVar.w();
                        break;
                    }
                case a.aQ /*4*/:
                    if (i.b != C0374dh.i) {
                        org.apache.thrift.protocol.i.a(fVar, i.b);
                        break;
                    } else {
                        this.j = fVar.w();
                        break;
                    }
                default:
                    org.apache.thrift.protocol.i.a(fVar, i.b);
                    break;
            }
            fVar.j();
        }
    }

    public boolean a() {
        return this.g != null;
    }

    public boolean a(i iVar) {
        if (iVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = iVar.a();
        if ((a || a2) && (!a || !a2 || !this.g.equals(iVar.g))) {
            return false;
        }
        a = b();
        a2 = iVar.b();
        if ((a || a2) && (!a || !a2 || !this.h.equals(iVar.h))) {
            return false;
        }
        a = c();
        a2 = iVar.c();
        if ((a || a2) && (!a || !a2 || !this.i.equals(iVar.i))) {
            return false;
        }
        a = d();
        a2 = iVar.d();
        return !(a || a2) || (a && a2 && this.j.equals(iVar.j));
    }

    public int b(i iVar) {
        if (!getClass().equals(iVar.getClass())) {
            return getClass().getName().compareTo(iVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(iVar.a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (a()) {
            compareTo = org.apache.thrift.c.a(this.g, iVar.g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(iVar.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            compareTo = org.apache.thrift.c.a(this.h, iVar.h);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iVar.c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (c()) {
            compareTo = org.apache.thrift.c.a(this.i, iVar.i);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iVar.d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (d()) {
            compareTo = org.apache.thrift.c.a(this.j, iVar.j);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public i b(String str) {
        this.h = str;
        return this;
    }

    public void b(f fVar) {
        e();
        fVar.a(b);
        if (this.g != null && a()) {
            fVar.a(c);
            fVar.a(this.g);
            fVar.b();
        }
        if (this.h != null && b()) {
            fVar.a(d);
            fVar.a(this.h);
            fVar.b();
        }
        if (this.i != null && c()) {
            fVar.a(e);
            fVar.a(this.i);
            fVar.b();
        }
        if (this.j != null && d()) {
            fVar.a(f);
            fVar.a(this.j);
            fVar.b();
        }
        fVar.c();
        fVar.a();
    }

    public boolean b() {
        return this.h != null;
    }

    public i c(String str) {
        this.i = str;
        return this;
    }

    public boolean c() {
        return this.i != null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((i) obj);
    }

    public i d(String str) {
        this.j = str;
        return this;
    }

    public boolean d() {
        return this.j != null;
    }

    public void e() {
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof i)) ? a((i) obj) : false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        Object obj = null;
        StringBuilder stringBuilder = new StringBuilder("Location(");
        Object obj2 = 1;
        if (a()) {
            stringBuilder.append("contry:");
            if (this.g == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.g);
            }
            obj2 = null;
        }
        if (b()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("province:");
            if (this.h == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.h);
            }
            obj2 = null;
        }
        if (c()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("city:");
            if (this.i == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.i);
            }
        } else {
            obj = obj2;
        }
        if (d()) {
            if (obj == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("isp:");
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
