package com.xiaomi.h.a;

import b.a.C0374dh;
import com.tencent.open.SocialConstants;
import com.tencent.tauth.AuthActivity;
import com.xiaomi.market.sdk.o;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import kankan.wheel.widget.l;
import org.apache.thrift.b;
import org.apache.thrift.meta_data.a;
import org.apache.thrift.meta_data.g;
import org.apache.thrift.protocol.c;
import org.apache.thrift.protocol.f;
import org.apache.thrift.protocol.i;
import org.apache.thrift.protocol.k;

public class C1112s implements Serializable, Cloneable, b<C1112s, t> {
    public static final Map<t, org.apache.thrift.meta_data.b> i;
    private static final k j = new k("XmPushActionContainer");
    private static final c k = new c(AuthActivity.ACTION_KEY, (byte) 8, (short) 1);
    private static final c l = new c("encryptAction", (byte) 2, (short) 2);
    private static final c m = new c("isRequest", (byte) 2, (short) 3);
    private static final c n = new c("pushAction", C0374dh.i, (short) 4);
    private static final c o = new c(SocialConstants.PARAM_APP_ID, C0374dh.i, (short) 5);
    private static final c p = new c(o.d, C0374dh.i, (short) 6);
    private static final c q = new c("target", C0374dh.j, (short) 7);
    private static final c r = new c("metaInfo", C0374dh.j, (short) 8);
    public C1094a a;
    public boolean b = true;
    public boolean c = true;
    public ByteBuffer d;
    public String e;
    public String f;
    public C1104k g;
    public C1098e h;
    private BitSet s = new BitSet(2);

    static {
        Map enumMap = new EnumMap(t.class);
        enumMap.put(t.ACTION, new org.apache.thrift.meta_data.b(AuthActivity.ACTION_KEY, (byte) 1, new a(C0374dh.n, C1094a.class)));
        enumMap.put(t.ENCRYPT_ACTION, new org.apache.thrift.meta_data.b("encryptAction", (byte) 1, new org.apache.thrift.meta_data.c((byte) 2)));
        enumMap.put(t.IS_REQUEST, new org.apache.thrift.meta_data.b("isRequest", (byte) 1, new org.apache.thrift.meta_data.c((byte) 2)));
        enumMap.put(t.PUSH_ACTION, new org.apache.thrift.meta_data.b("pushAction", (byte) 1, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(t.APPID, new org.apache.thrift.meta_data.b(SocialConstants.PARAM_APP_ID, (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(t.PACKAGE_NAME, new org.apache.thrift.meta_data.b(o.d, (byte) 2, new org.apache.thrift.meta_data.c(C0374dh.i)));
        enumMap.put(t.TARGET, new org.apache.thrift.meta_data.b("target", (byte) 1, new g(C0374dh.j, C1104k.class)));
        enumMap.put(t.META_INFO, new org.apache.thrift.meta_data.b("metaInfo", (byte) 2, new g(C0374dh.j, C1098e.class)));
        i = Collections.unmodifiableMap(enumMap);
        org.apache.thrift.meta_data.b.a(C1112s.class, i);
    }

    public C1094a a() {
        return this.a;
    }

    public C1112s a(C1094a c1094a) {
        this.a = c1094a;
        return this;
    }

    public C1112s a(C1098e c1098e) {
        this.h = c1098e;
        return this;
    }

    public C1112s a(C1104k c1104k) {
        this.g = c1104k;
        return this;
    }

    public C1112s a(String str) {
        this.e = str;
        return this;
    }

    public C1112s a(ByteBuffer byteBuffer) {
        this.d = byteBuffer;
        return this;
    }

    public C1112s a(boolean z) {
        this.b = z;
        b(true);
        return this;
    }

    public void a(f fVar) {
        fVar.g();
        while (true) {
            c i = fVar.i();
            if (i.b == (byte) 0) {
                fVar.h();
                if (!d()) {
                    throw new org.apache.thrift.protocol.g("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
                } else if (e()) {
                    o();
                    return;
                } else {
                    throw new org.apache.thrift.protocol.g("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
                }
            }
            switch (i.c) {
                case l.a /*1*/:
                    if (i.b != (byte) 8) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.a = C1094a.a(fVar.t());
                        break;
                    }
                case kankan.wheel.widget.a.k /*2*/:
                    if (i.b != (byte) 2) {
                        i.a(fVar, i.b);
                        break;
                    }
                    this.b = fVar.q();
                    b(true);
                    break;
                case kankan.wheel.widget.a.l /*3*/:
                    if (i.b != (byte) 2) {
                        i.a(fVar, i.b);
                        break;
                    }
                    this.c = fVar.q();
                    d(true);
                    break;
                case kankan.wheel.widget.a.aQ /*4*/:
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.d = fVar.x();
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
                    if (i.b != C0374dh.i) {
                        i.a(fVar, i.b);
                        break;
                    } else {
                        this.f = fVar.w();
                        break;
                    }
                case kankan.wheel.widget.a.bc /*7*/:
                    if (i.b != C0374dh.j) {
                        i.a(fVar, i.b);
                        break;
                    }
                    this.g = new C1104k();
                    this.g.a(fVar);
                    break;
                case kankan.wheel.widget.a.ba /*8*/:
                    if (i.b != C0374dh.j) {
                        i.a(fVar, i.b);
                        break;
                    }
                    this.h = new C1098e();
                    this.h.a(fVar);
                    break;
                default:
                    i.a(fVar, i.b);
                    break;
            }
            fVar.j();
        }
    }

    public boolean a(C1112s c1112s) {
        if (c1112s == null) {
            return false;
        }
        boolean b = b();
        boolean b2 = c1112s.b();
        if (((b || b2) && (!b || !b2 || !this.a.equals(c1112s.a))) || this.b != c1112s.b || this.c != c1112s.c) {
            return false;
        }
        b = g();
        b2 = c1112s.g();
        if ((b || b2) && (!b || !b2 || !this.d.equals(c1112s.d))) {
            return false;
        }
        b = i();
        b2 = c1112s.i();
        if ((b || b2) && (!b || !b2 || !this.e.equals(c1112s.e))) {
            return false;
        }
        b = k();
        b2 = c1112s.k();
        if ((b || b2) && (!b || !b2 || !this.f.equals(c1112s.f))) {
            return false;
        }
        b = l();
        b2 = c1112s.l();
        if ((b || b2) && (!b || !b2 || !this.g.a(c1112s.g))) {
            return false;
        }
        b = n();
        b2 = c1112s.n();
        return !(b || b2) || (b && b2 && this.h.a(c1112s.h));
    }

    public int b(C1112s c1112s) {
        if (!getClass().equals(c1112s.getClass())) {
            return getClass().getName().compareTo(c1112s.getClass().getName());
        }
        int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(c1112s.b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (b()) {
            compareTo = org.apache.thrift.c.a(this.a, c1112s.a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(d()).compareTo(Boolean.valueOf(c1112s.d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (d()) {
            compareTo = org.apache.thrift.c.a(this.b, c1112s.b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(e()).compareTo(Boolean.valueOf(c1112s.e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (e()) {
            compareTo = org.apache.thrift.c.a(this.c, c1112s.c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(g()).compareTo(Boolean.valueOf(c1112s.g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (g()) {
            compareTo = org.apache.thrift.c.a(this.d, c1112s.d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(i()).compareTo(Boolean.valueOf(c1112s.i()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (i()) {
            compareTo = org.apache.thrift.c.a(this.e, c1112s.e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(k()).compareTo(Boolean.valueOf(c1112s.k()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (k()) {
            compareTo = org.apache.thrift.c.a(this.f, c1112s.f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(l()).compareTo(Boolean.valueOf(c1112s.l()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (l()) {
            compareTo = org.apache.thrift.c.a(this.g, c1112s.g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(n()).compareTo(Boolean.valueOf(c1112s.n()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (n()) {
            compareTo = org.apache.thrift.c.a(this.h, c1112s.h);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public C1112s b(String str) {
        this.f = str;
        return this;
    }

    public void b(f fVar) {
        o();
        fVar.a(j);
        if (this.a != null) {
            fVar.a(k);
            fVar.a(this.a.a());
            fVar.b();
        }
        fVar.a(l);
        fVar.a(this.b);
        fVar.b();
        fVar.a(m);
        fVar.a(this.c);
        fVar.b();
        if (this.d != null) {
            fVar.a(n);
            fVar.a(this.d);
            fVar.b();
        }
        if (this.e != null && i()) {
            fVar.a(o);
            fVar.a(this.e);
            fVar.b();
        }
        if (this.f != null && k()) {
            fVar.a(p);
            fVar.a(this.f);
            fVar.b();
        }
        if (this.g != null) {
            fVar.a(q);
            this.g.b(fVar);
            fVar.b();
        }
        if (this.h != null && n()) {
            fVar.a(r);
            this.h.b(fVar);
            fVar.b();
        }
        fVar.c();
        fVar.a();
    }

    public void b(boolean z) {
        this.s.set(0, z);
    }

    public boolean b() {
        return this.a != null;
    }

    public C1112s c(boolean z) {
        this.c = z;
        d(true);
        return this;
    }

    public boolean c() {
        return this.b;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return b((C1112s) obj);
    }

    public void d(boolean z) {
        this.s.set(1, z);
    }

    public boolean d() {
        return this.s.get(0);
    }

    public boolean e() {
        return this.s.get(1);
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof C1112s)) ? a((C1112s) obj) : false;
    }

    public byte[] f() {
        a(org.apache.thrift.c.c(this.d));
        return this.d.array();
    }

    public boolean g() {
        return this.d != null;
    }

    public String h() {
        return this.e;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.e != null;
    }

    public String j() {
        return this.f;
    }

    public boolean k() {
        return this.f != null;
    }

    public boolean l() {
        return this.g != null;
    }

    public C1098e m() {
        return this.h;
    }

    public boolean n() {
        return this.h != null;
    }

    public void o() {
        if (this.a == null) {
            throw new org.apache.thrift.protocol.g("Required field 'action' was not present! Struct: " + toString());
        } else if (this.d == null) {
            throw new org.apache.thrift.protocol.g("Required field 'pushAction' was not present! Struct: " + toString());
        } else if (this.g == null) {
            throw new org.apache.thrift.protocol.g("Required field 'target' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("XmPushActionContainer(");
        stringBuilder.append("action:");
        if (this.a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.a);
        }
        stringBuilder.append(", ");
        stringBuilder.append("encryptAction:");
        stringBuilder.append(this.b);
        stringBuilder.append(", ");
        stringBuilder.append("isRequest:");
        stringBuilder.append(this.c);
        stringBuilder.append(", ");
        stringBuilder.append("pushAction:");
        if (this.d == null) {
            stringBuilder.append("null");
        } else {
            org.apache.thrift.c.a(this.d, stringBuilder);
        }
        if (i()) {
            stringBuilder.append(", ");
            stringBuilder.append("appid:");
            if (this.e == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.e);
            }
        }
        if (k()) {
            stringBuilder.append(", ");
            stringBuilder.append("packageName:");
            if (this.f == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f);
            }
        }
        stringBuilder.append(", ");
        stringBuilder.append("target:");
        if (this.g == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.g);
        }
        if (n()) {
            stringBuilder.append(", ");
            stringBuilder.append("metaInfo:");
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
