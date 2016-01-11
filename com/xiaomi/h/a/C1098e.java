package com.xiaomi.h.a;

import b.a.C0374dh;
import cn.com.smartdevices.bracelet.gps.c.a.g;
import cn.com.smartdevices.bracelet.partner.NativeInterface;
import cn.com.smartdevices.bracelet.shoes.sync.SyncShoesDataService;
import com.tencent.open.SocialConstants;
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
import org.apache.thrift.protocol.c;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.i;
import org.apache.thrift.protocol.k;

public class C1098e implements Serializable, Cloneable, b<C1098e, C1099f> {
    public static final Map<C1099f, org.apache.thrift.meta_data.b> k;
    private static final k l = new k("PushMetaInfo");
    private static final c m = new c(SyncShoesDataService.d, C0374dh.i, (short) 1);
    private static final c n = new c("messageTs", (byte) 10, (short) 2);
    private static final c o = new c(NativeInterface.PARAM_SHARE_TOPIC, C0374dh.i, (short) 3);
    private static final c p = new c(SocialConstants.PARAM_TITLE, C0374dh.i, (short) 4);
    private static final c q = new c(SocialConstants.PARAM_COMMENT, C0374dh.i, (short) 5);
    private static final c r = new c("notifyType", (byte) 8, (short) 6);
    private static final c s = new c(SocialConstants.PARAM_URL, C0374dh.i, (short) 7);
    private static final c t = new c("passThrough", (byte) 8, (short) 8);
    private static final c u = new c("notifyId", (byte) 8, (short) 9);
    private static final c v = new c(g.g, C0374dh.k, (short) 10);
    public String a;
    public long b;
    public String c;
    public String d;
    public String e;
    public int f;
    public String g;
    public int h;
    public int i;
    public Map<String, String> j;
    private BitSet w = new BitSet(4);

    static {
        Map enumMap = new EnumMap(C1099f.class);
        enumMap.put(C1099f.ID, new org.apache.thrift.meta_data.b(SyncShoesDataService.d, (byte) 1, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(C1099f.MESSAGE_TS, new org.apache.thrift.meta_data.b("messageTs", (byte) 1, new org.apache.thrift.meta_data.c((byte) 10)));
        enumMap.put(C1099f.TOPIC, new org.apache.thrift.meta_data.b(NativeInterface.PARAM_SHARE_TOPIC, (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(C1099f.TITLE, new org.apache.thrift.meta_data.b(SocialConstants.PARAM_TITLE, (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(C1099f.DESCRIPTION, new org.apache.thrift.meta_data.b(SocialConstants.PARAM_COMMENT, (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(C1099f.NOTIFY_TYPE, new org.apache.thrift.meta_data.b("notifyType", (byte) 2, new org.apache.thrift.meta_data.c((byte) 8)));
        enumMap.put(C1099f.URL, new org.apache.thrift.meta_data.b(SocialConstants.PARAM_URL, (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(C1099f.PASS_THROUGH, new org.apache.thrift.meta_data.b("passThrough", (byte) 2, new org.apache.thrift.meta_data.c((byte) 8)));
        enumMap.put(C1099f.NOTIFY_ID, new org.apache.thrift.meta_data.b("notifyId", (byte) 2, new org.apache.thrift.meta_data.c((byte) 8)));
        enumMap.put(C1099f.EXTRA, new org.apache.thrift.meta_data.b(g.g, (byte) 2, new e(C0374dh.k, new org.apache.thrift.meta_data.c(C0374dh.i), new org.apache.thrift.meta_data.c(C0374dh.i))));
        k = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(C1098e.class, k);
    }

    public C1098e(C1098e c1098e) {
        this.w.clear();
        this.w.or(c1098e.w);
        if (c1098e.c()) {
            this.a = c1098e.a;
        }
        this.b = c1098e.b;
        if (c1098e.g()) {
            this.c = c1098e.c;
        }
        if (c1098e.i()) {
            this.d = c1098e.d;
        }
        if (c1098e.k()) {
            this.e = c1098e.e;
        }
        this.f = c1098e.f;
        if (c1098e.n()) {
            this.g = c1098e.g;
        }
        this.h = c1098e.h;
        this.i = c1098e.i;
        if (c1098e.t()) {
            Map hashMap = new HashMap();
            for (Entry entry : c1098e.j.entrySet()) {
                hashMap.put((String) entry.getKey(), (String) entry.getValue());
            }
            this.j = hashMap;
        }
    }

    public C1098e a() {
        return new C1098e(this);
    }

    public C1098e a(int i) {
        this.f = i;
        b(true);
        return this;
    }

    public C1098e a(String str) {
        this.a = str;
        return this;
    }

    public C1098e a(Map<String, String> map) {
        this.j = map;
        return this;
    }

    public void a(String str, String str2) {
        if (this.j == null) {
            this.j = new HashMap();
        }
        this.j.put(str, str2);
    }

    public void a(f fVar) {
        fVar.g();
        while (true) {
            c i = fVar.i();
            if (i.b == (byte) 0) {
                fVar.h();
                if (e()) {
                    u();
                    return;
                }
                throw new org.apache.thrift.protocol.g("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
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
                    if (i.b != (byte) 10) {
                        i.a(fVar, i.b);
                        break;
                    }
                    this.b = fVar.u();
                    a(true);
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
                    if (i.b != (byte) 8) {
                        i.a(fVar, i.b);
                        break;
                    }
                    this.f = fVar.t();
                    b(true);
                    break;
                case a.bc /*7*/:
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.g = fVar.w();
                        break;
                    }
                case a.ba /*8*/:
                    if (i.b != (byte) 8) {
                        i.a(fVar, i.b);
                        break;
                    }
                    this.h = fVar.t();
                    c(true);
                    break;
                case a.bo /*9*/:
                    if (i.b != (byte) 8) {
                        i.a(fVar, i.b);
                        break;
                    }
                    this.i = fVar.t();
                    d(true);
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

    public boolean a(C1098e c1098e) {
        if (c1098e == null) {
            return false;
        }
        boolean c = c();
        boolean c2 = c1098e.c();
        if (((c || c2) && (!c || !c2 || !this.a.equals(c1098e.a))) || this.b != c1098e.b) {
            return false;
        }
        c = g();
        c2 = c1098e.g();
        if ((c || c2) && (!c || !c2 || !this.c.equals(c1098e.c))) {
            return false;
        }
        c = i();
        c2 = c1098e.i();
        if ((c || c2) && (!c || !c2 || !this.d.equals(c1098e.d))) {
            return false;
        }
        c = k();
        c2 = c1098e.k();
        if ((c || c2) && (!c || !c2 || !this.e.equals(c1098e.e))) {
            return false;
        }
        c = m();
        c2 = c1098e.m();
        if ((c || c2) && (!c || !c2 || this.f != c1098e.f)) {
            return false;
        }
        c = n();
        c2 = c1098e.n();
        if ((c || c2) && (!c || !c2 || !this.g.equals(c1098e.g))) {
            return false;
        }
        c = p();
        c2 = c1098e.p();
        if ((c || c2) && (!c || !c2 || this.h != c1098e.h)) {
            return false;
        }
        c = r();
        c2 = c1098e.r();
        if ((c || c2) && (!c || !c2 || this.i != c1098e.i)) {
            return false;
        }
        c = t();
        c2 = c1098e.t();
        return !(c || c2) || (c && c2 && this.j.equals(c1098e.j));
    }

    public int b(C1098e c1098e) {
        if (!getClass().equals(c1098e.getClass())) {
            return getClass().getName().compareTo(c1098e.getClass().getName());
        }
        int compareTo = Boolean.valueOf(c()).compareTo(Boolean.valueOf(c1098e.c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (c()) {
            compareTo = org.apache.thrift.c.a(this.a, c1098e.a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(e()).compareTo(Boolean.valueOf(c1098e.e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (e()) {
            compareTo = org.apache.thrift.c.a(this.b, c1098e.b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(g()).compareTo(Boolean.valueOf(c1098e.g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (g()) {
            compareTo = org.apache.thrift.c.a(this.c, c1098e.c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(i()).compareTo(Boolean.valueOf(c1098e.i()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (i()) {
            compareTo = org.apache.thrift.c.a(this.d, c1098e.d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(k()).compareTo(Boolean.valueOf(c1098e.k()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (k()) {
            compareTo = org.apache.thrift.c.a(this.e, c1098e.e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m()).compareTo(Boolean.valueOf(c1098e.m()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m()) {
            compareTo = org.apache.thrift.c.a(this.f, c1098e.f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(n()).compareTo(Boolean.valueOf(c1098e.n()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (n()) {
            compareTo = org.apache.thrift.c.a(this.g, c1098e.g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(p()).compareTo(Boolean.valueOf(c1098e.p()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (p()) {
            compareTo = org.apache.thrift.c.a(this.h, c1098e.h);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(r()).compareTo(Boolean.valueOf(c1098e.r()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (r()) {
            compareTo = org.apache.thrift.c.a(this.i, c1098e.i);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(t()).compareTo(Boolean.valueOf(c1098e.t()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (t()) {
            compareTo = org.apache.thrift.c.a(this.j, c1098e.j);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public C1098e b(int i) {
        this.h = i;
        c(true);
        return this;
    }

    public C1098e b(String str) {
        this.c = str;
        return this;
    }

    public String b() {
        return this.a;
    }

    public void b(f fVar) {
        u();
        fVar.a(l);
        if (this.a != null) {
            fVar.a(m);
            fVar.a(this.a);
            fVar.b();
        }
        fVar.a(n);
        fVar.a(this.b);
        fVar.b();
        if (this.c != null && g()) {
            fVar.a(o);
            fVar.a(this.c);
            fVar.b();
        }
        if (this.d != null && i()) {
            fVar.a(p);
            fVar.a(this.d);
            fVar.b();
        }
        if (this.e != null && k()) {
            fVar.a(q);
            fVar.a(this.e);
            fVar.b();
        }
        if (m()) {
            fVar.a(r);
            fVar.a(this.f);
            fVar.b();
        }
        if (this.g != null && n()) {
            fVar.a(s);
            fVar.a(this.g);
            fVar.b();
        }
        if (p()) {
            fVar.a(t);
            fVar.a(this.h);
            fVar.b();
        }
        if (r()) {
            fVar.a(u);
            fVar.a(this.i);
            fVar.b();
        }
        if (this.j != null && t()) {
            fVar.a(v);
            fVar.a(new org.apache.thrift.protocol.e(C0374dh.i, C0374dh.i, this.j.size()));
            for (Entry entry : this.j.entrySet()) {
                fVar.a((String) entry.getKey());
                fVar.a((String) entry.getValue());
            }
            fVar.d();
            fVar.b();
        }
        fVar.c();
        fVar.a();
    }

    public void b(boolean z) {
        this.w.set(1, z);
    }

    public C1098e c(int i) {
        this.i = i;
        d(true);
        return this;
    }

    public C1098e c(String str) {
        this.d = str;
        return this;
    }

    public void c(boolean z) {
        this.w.set(2, z);
    }

    public boolean c() {
        return this.a != null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((C1098e) obj);
    }

    public long d() {
        return this.b;
    }

    public C1098e d(String str) {
        this.e = str;
        return this;
    }

    public void d(boolean z) {
        this.w.set(3, z);
    }

    public boolean e() {
        return this.w.get(0);
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof C1098e)) ? a((C1098e) obj) : false;
    }

    public String f() {
        return this.c;
    }

    public boolean g() {
        return this.c != null;
    }

    public String h() {
        return this.d;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.d != null;
    }

    public String j() {
        return this.e;
    }

    public boolean k() {
        return this.e != null;
    }

    public int l() {
        return this.f;
    }

    public boolean m() {
        return this.w.get(1);
    }

    public boolean n() {
        return this.g != null;
    }

    public int o() {
        return this.h;
    }

    public boolean p() {
        return this.w.get(2);
    }

    public int q() {
        return this.i;
    }

    public boolean r() {
        return this.w.get(3);
    }

    public Map<String, String> s() {
        return this.j;
    }

    public boolean t() {
        return this.j != null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PushMetaInfo(");
        stringBuilder.append("id:");
        if (this.a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.a);
        }
        stringBuilder.append(", ");
        stringBuilder.append("messageTs:");
        stringBuilder.append(this.b);
        if (g()) {
            stringBuilder.append(", ");
            stringBuilder.append("topic:");
            if (this.c == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.c);
            }
        }
        if (i()) {
            stringBuilder.append(", ");
            stringBuilder.append("title:");
            if (this.d == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.d);
            }
        }
        if (k()) {
            stringBuilder.append(", ");
            stringBuilder.append("description:");
            if (this.e == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.e);
            }
        }
        if (m()) {
            stringBuilder.append(", ");
            stringBuilder.append("notifyType:");
            stringBuilder.append(this.f);
        }
        if (n()) {
            stringBuilder.append(", ");
            stringBuilder.append("url:");
            if (this.g == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.g);
            }
        }
        if (p()) {
            stringBuilder.append(", ");
            stringBuilder.append("passThrough:");
            stringBuilder.append(this.h);
        }
        if (r()) {
            stringBuilder.append(", ");
            stringBuilder.append("notifyId:");
            stringBuilder.append(this.i);
        }
        if (t()) {
            stringBuilder.append(", ");
            stringBuilder.append("extra:");
            if (this.j == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.j);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void u() {
        if (this.a == null) {
            throw new org.apache.thrift.protocol.g("Required field 'id' was not present! Struct: " + toString());
        }
    }
}
