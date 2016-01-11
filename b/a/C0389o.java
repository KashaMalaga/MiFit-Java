package b.a;

import cn.com.smartdevices.bracelet.d.C0430g;
import com.g.a.b.b;
import com.xiaomi.market.sdk.o;
import com.xiaomi.market.sdk.q;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class C0389o implements cq<C0389o, C0394t>, Serializable, Cloneable {
    public static final Map<C0394t, cI> k;
    private static final C0371de l = new C0371de("AppInfo");
    private static final cT m = new cT(C0430g.b, C0374dh.i, (short) 1);
    private static final cT n = new cT(o.x, C0374dh.i, (short) 2);
    private static final cT o = new cT("version_index", (byte) 8, (short) 3);
    private static final cT p = new cT(q.c, C0374dh.i, (short) 4);
    private static final cT q = new cT("sdk_type", (byte) 8, (short) 5);
    private static final cT r = new cT(b.g, C0374dh.i, (short) 6);
    private static final cT s = new cT(b.c, C0374dh.i, (short) 7);
    private static final cT t = new cT("wrapper_type", C0374dh.i, (short) 8);
    private static final cT u = new cT("wrapper_version", C0374dh.i, (short) 9);
    private static final cT v = new cT("vertical_type", (byte) 8, (short) 10);
    private static final Map<Class<? extends di>, dj> w = new HashMap();
    private static final int x = 0;
    private static final int y = 1;
    private C0394t[] A;
    public String a;
    public String b;
    public int c;
    public String d;
    public C0326br e;
    public String f;
    public String g;
    public String h;
    public String i;
    public int j;
    private byte z;

    static {
        w.put(dk.class, new C0391q());
        w.put(dl.class, new C0393s());
        Map enumMap = new EnumMap(C0394t.class);
        enumMap.put(C0394t.KEY, new cI(C0430g.b, (byte) 1, new cJ(C0374dh.i)));
        enumMap.put(C0394t.VERSION, new cI(o.x, (byte) 2, new cJ(C0374dh.i)));
        enumMap.put(C0394t.VERSION_INDEX, new cI("version_index", (byte) 2, new cJ((byte) 8)));
        enumMap.put(C0394t.PACKAGE_NAME, new cI(q.c, (byte) 2, new cJ(C0374dh.i)));
        enumMap.put(C0394t.SDK_TYPE, new cI("sdk_type", (byte) 1, new cH(C0374dh.n, C0326br.class)));
        enumMap.put(C0394t.SDK_VERSION, new cI(b.g, (byte) 1, new cJ(C0374dh.i)));
        enumMap.put(C0394t.CHANNEL, new cI(b.c, (byte) 1, new cJ(C0374dh.i)));
        enumMap.put(C0394t.WRAPPER_TYPE, new cI("wrapper_type", (byte) 2, new cJ(C0374dh.i)));
        enumMap.put(C0394t.WRAPPER_VERSION, new cI("wrapper_version", (byte) 2, new cJ(C0374dh.i)));
        enumMap.put(C0394t.VERTICAL_TYPE, new cI("vertical_type", (byte) 2, new cJ((byte) 8)));
        k = Collections.unmodifiableMap(enumMap);
        cI.a(C0389o.class, k);
    }

    public C0389o() {
        this.z = (byte) 0;
        this.A = new C0394t[]{C0394t.VERSION, C0394t.VERSION_INDEX, C0394t.PACKAGE_NAME, C0394t.WRAPPER_TYPE, C0394t.WRAPPER_VERSION, C0394t.VERTICAL_TYPE};
    }

    public C0389o(C0389o c0389o) {
        this.z = (byte) 0;
        this.A = new C0394t[]{C0394t.VERSION, C0394t.VERSION_INDEX, C0394t.PACKAGE_NAME, C0394t.WRAPPER_TYPE, C0394t.WRAPPER_VERSION, C0394t.VERTICAL_TYPE};
        this.z = c0389o.z;
        if (c0389o.e()) {
            this.a = c0389o.a;
        }
        if (c0389o.i()) {
            this.b = c0389o.b;
        }
        this.c = c0389o.c;
        if (c0389o.o()) {
            this.d = c0389o.d;
        }
        if (c0389o.r()) {
            this.e = c0389o.e;
        }
        if (c0389o.u()) {
            this.f = c0389o.f;
        }
        if (c0389o.x()) {
            this.g = c0389o.g;
        }
        if (c0389o.A()) {
            this.h = c0389o.h;
        }
        if (c0389o.D()) {
            this.i = c0389o.i;
        }
        this.j = c0389o.j;
    }

    public C0389o(String str, C0326br c0326br, String str2, String str3) {
        this();
        this.a = str;
        this.e = c0326br;
        this.f = str2;
        this.g = str3;
    }

    private void a(ObjectInputStream objectInputStream) {
        try {
            this.z = (byte) 0;
            a(new C0337cQ(new C0376dm((InputStream) objectInputStream)));
        } catch (C0339cy e) {
            throw new IOException(e.getMessage());
        }
    }

    private void a(ObjectOutputStream objectOutputStream) {
        try {
            b(new C0337cQ(new C0376dm((OutputStream) objectOutputStream)));
        } catch (C0339cy e) {
            throw new IOException(e.getMessage());
        }
    }

    public boolean A() {
        return this.h != null;
    }

    public String B() {
        return this.i;
    }

    public void C() {
        this.i = null;
    }

    public boolean D() {
        return this.i != null;
    }

    public int E() {
        return this.j;
    }

    public void F() {
        this.z = C0353cn.b(this.z, (int) y);
    }

    public boolean G() {
        return C0353cn.a(this.z, (int) y);
    }

    public void H() {
        if (this.a == null) {
            throw new C0340cZ("Required field 'key' was not present! Struct: " + toString());
        } else if (this.e == null) {
            throw new C0340cZ("Required field 'sdk_type' was not present! Struct: " + toString());
        } else if (this.f == null) {
            throw new C0340cZ("Required field 'sdk_version' was not present! Struct: " + toString());
        } else if (this.g == null) {
            throw new C0340cZ("Required field 'channel' was not present! Struct: " + toString());
        }
    }

    public C0389o a() {
        return new C0389o(this);
    }

    public C0389o a(int i) {
        this.c = i;
        c(true);
        return this;
    }

    public C0389o a(C0326br c0326br) {
        this.e = c0326br;
        return this;
    }

    public C0389o a(String str) {
        this.a = str;
        return this;
    }

    public void a(cY cYVar) {
        ((dj) w.get(cYVar.D())).b().a(cYVar, this);
    }

    public void a(boolean z) {
        if (!z) {
            this.a = null;
        }
    }

    public /* synthetic */ cz b(int i) {
        return d(i);
    }

    public C0389o b(String str) {
        this.b = str;
        return this;
    }

    public void b() {
        this.a = null;
        this.b = null;
        c(false);
        this.c = x;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        j(false);
        this.j = x;
    }

    public void b(cY cYVar) {
        ((dj) w.get(cYVar.D())).b().b(cYVar, this);
    }

    public void b(boolean z) {
        if (!z) {
            this.b = null;
        }
    }

    public C0389o c(int i) {
        this.j = i;
        j(true);
        return this;
    }

    public C0389o c(String str) {
        this.d = str;
        return this;
    }

    public String c() {
        return this.a;
    }

    public void c(boolean z) {
        this.z = C0353cn.a(this.z, (int) x, z);
    }

    public C0389o d(String str) {
        this.f = str;
        return this;
    }

    public C0394t d(int i) {
        return C0394t.a(i);
    }

    public void d() {
        this.a = null;
    }

    public void d(boolean z) {
        if (!z) {
            this.d = null;
        }
    }

    public C0389o e(String str) {
        this.g = str;
        return this;
    }

    public void e(boolean z) {
        if (!z) {
            this.e = null;
        }
    }

    public boolean e() {
        return this.a != null;
    }

    public C0389o f(String str) {
        this.h = str;
        return this;
    }

    public String f() {
        return this.b;
    }

    public void f(boolean z) {
        if (!z) {
            this.f = null;
        }
    }

    public /* synthetic */ cq g() {
        return a();
    }

    public C0389o g(String str) {
        this.i = str;
        return this;
    }

    public void g(boolean z) {
        if (!z) {
            this.g = null;
        }
    }

    public void h() {
        this.b = null;
    }

    public void h(boolean z) {
        if (!z) {
            this.h = null;
        }
    }

    public void i(boolean z) {
        if (!z) {
            this.i = null;
        }
    }

    public boolean i() {
        return this.b != null;
    }

    public int j() {
        return this.c;
    }

    public void j(boolean z) {
        this.z = C0353cn.a(this.z, (int) y, z);
    }

    public void k() {
        this.z = C0353cn.b(this.z, (int) x);
    }

    public boolean l() {
        return C0353cn.a(this.z, (int) x);
    }

    public String m() {
        return this.d;
    }

    public void n() {
        this.d = null;
    }

    public boolean o() {
        return this.d != null;
    }

    public C0326br p() {
        return this.e;
    }

    public void q() {
        this.e = null;
    }

    public boolean r() {
        return this.e != null;
    }

    public String s() {
        return this.f;
    }

    public void t() {
        this.f = null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("AppInfo(");
        stringBuilder.append("key:");
        if (this.a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.a);
        }
        if (i()) {
            stringBuilder.append(", ");
            stringBuilder.append("version:");
            if (this.b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.b);
            }
        }
        if (l()) {
            stringBuilder.append(", ");
            stringBuilder.append("version_index:");
            stringBuilder.append(this.c);
        }
        if (o()) {
            stringBuilder.append(", ");
            stringBuilder.append("package_name:");
            if (this.d == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.d);
            }
        }
        stringBuilder.append(", ");
        stringBuilder.append("sdk_type:");
        if (this.e == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.e);
        }
        stringBuilder.append(", ");
        stringBuilder.append("sdk_version:");
        if (this.f == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f);
        }
        stringBuilder.append(", ");
        stringBuilder.append("channel:");
        if (this.g == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.g);
        }
        if (A()) {
            stringBuilder.append(", ");
            stringBuilder.append("wrapper_type:");
            if (this.h == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.h);
            }
        }
        if (D()) {
            stringBuilder.append(", ");
            stringBuilder.append("wrapper_version:");
            if (this.i == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.i);
            }
        }
        if (G()) {
            stringBuilder.append(", ");
            stringBuilder.append("vertical_type:");
            stringBuilder.append(this.j);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public boolean u() {
        return this.f != null;
    }

    public String v() {
        return this.g;
    }

    public void w() {
        this.g = null;
    }

    public boolean x() {
        return this.g != null;
    }

    public String y() {
        return this.h;
    }

    public void z() {
        this.h = null;
    }
}
