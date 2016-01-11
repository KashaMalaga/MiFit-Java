package b.a;

import cn.com.smartdevices.bracelet.shoes.ui.ShoesBindActivity;
import com.g.a.b.b;
import com.xiaomi.market.sdk.o;
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
import kankan.wheel.widget.a;

public class A implements cq<A, F>, Serializable, Cloneable {
    private static final cT A = new cT("os_version", C0374dh.i, (short) 8);
    private static final cT B = new cT(o.p, C0374dh.j, (short) 9);
    private static final cT C = new cT("is_jailbroken", (byte) 2, (short) 10);
    private static final cT D = new cT("is_pirated", (byte) 2, (short) 11);
    private static final cT E = new cT("device_board", C0374dh.i, (short) 12);
    private static final cT F = new cT("device_brand", C0374dh.i, (short) 13);
    private static final cT G = new cT("device_manutime", (byte) 10, (short) 14);
    private static final cT H = new cT("device_manufacturer", C0374dh.i, (short) 15);
    private static final cT I = new cT("device_manuid", C0374dh.i, (short) 16);
    private static final cT J = new cT("device_name", C0374dh.i, (short) 17);
    private static final Map<Class<? extends di>, dj> K = new HashMap();
    private static final int L = 0;
    private static final int M = 1;
    private static final int N = 2;
    public static final Map<F, cI> r;
    private static final C0371de s = new C0371de("DeviceInfo");
    private static final cT t = new cT(a.ak, C0374dh.i, (short) 1);
    private static final cT u = new cT(b.d, C0374dh.i, (short) 2);
    private static final cT v = new cT(ShoesBindActivity.c, C0374dh.i, (short) 3);
    private static final cT w = new cT("open_udid", C0374dh.i, (short) 4);
    private static final cT x = new cT("model", C0374dh.i, (short) 5);
    private static final cT y = new cT("cpu", C0374dh.i, (short) 6);
    private static final cT z = new cT(o.j, C0374dh.i, (short) 7);
    private byte O;
    private F[] P;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public C0314bf i;
    public boolean j;
    public boolean k;
    public String l;
    public String m;
    public long n;
    public String o;
    public String p;
    public String q;

    static {
        K.put(dk.class, new C());
        K.put(dl.class, new E());
        Map enumMap = new EnumMap(F.class);
        enumMap.put(F.DEVICE_ID, new cI(a.ak, (byte) 2, new cJ(C0374dh.i)));
        enumMap.put(F.IDMD5, new cI(b.d, (byte) 2, new cJ(C0374dh.i)));
        enumMap.put(F.MAC_ADDRESS, new cI(ShoesBindActivity.c, (byte) 2, new cJ(C0374dh.i)));
        enumMap.put(F.OPEN_UDID, new cI("open_udid", (byte) 2, new cJ(C0374dh.i)));
        enumMap.put(F.MODEL, new cI("model", (byte) 2, new cJ(C0374dh.i)));
        enumMap.put(F.CPU, new cI("cpu", (byte) 2, new cJ(C0374dh.i)));
        enumMap.put(F.OS, new cI(o.j, (byte) 2, new cJ(C0374dh.i)));
        enumMap.put(F.OS_VERSION, new cI("os_version", (byte) 2, new cJ(C0374dh.i)));
        enumMap.put(F.RESOLUTION, new cI(o.p, (byte) 2, new cN(C0374dh.j, C0314bf.class)));
        enumMap.put(F.IS_JAILBROKEN, new cI("is_jailbroken", (byte) 2, new cJ((byte) 2)));
        enumMap.put(F.IS_PIRATED, new cI("is_pirated", (byte) 2, new cJ((byte) 2)));
        enumMap.put(F.DEVICE_BOARD, new cI("device_board", (byte) 2, new cJ(C0374dh.i)));
        enumMap.put(F.DEVICE_BRAND, new cI("device_brand", (byte) 2, new cJ(C0374dh.i)));
        enumMap.put(F.DEVICE_MANUTIME, new cI("device_manutime", (byte) 2, new cJ((byte) 10)));
        enumMap.put(F.DEVICE_MANUFACTURER, new cI("device_manufacturer", (byte) 2, new cJ(C0374dh.i)));
        enumMap.put(F.DEVICE_MANUID, new cI("device_manuid", (byte) 2, new cJ(C0374dh.i)));
        enumMap.put(F.DEVICE_NAME, new cI("device_name", (byte) 2, new cJ(C0374dh.i)));
        r = Collections.unmodifiableMap(enumMap);
        cI.a(A.class, r);
    }

    public A() {
        this.O = (byte) 0;
        this.P = new F[]{F.DEVICE_ID, F.IDMD5, F.MAC_ADDRESS, F.OPEN_UDID, F.MODEL, F.CPU, F.OS, F.OS_VERSION, F.RESOLUTION, F.IS_JAILBROKEN, F.IS_PIRATED, F.DEVICE_BOARD, F.DEVICE_BRAND, F.DEVICE_MANUTIME, F.DEVICE_MANUFACTURER, F.DEVICE_MANUID, F.DEVICE_NAME};
    }

    public A(A a) {
        this.O = (byte) 0;
        this.P = new F[]{F.DEVICE_ID, F.IDMD5, F.MAC_ADDRESS, F.OPEN_UDID, F.MODEL, F.CPU, F.OS, F.OS_VERSION, F.RESOLUTION, F.IS_JAILBROKEN, F.IS_PIRATED, F.DEVICE_BOARD, F.DEVICE_BRAND, F.DEVICE_MANUTIME, F.DEVICE_MANUFACTURER, F.DEVICE_MANUID, F.DEVICE_NAME};
        this.O = a.O;
        if (a.e()) {
            this.a = a.a;
        }
        if (a.i()) {
            this.b = a.b;
        }
        if (a.l()) {
            this.c = a.c;
        }
        if (a.o()) {
            this.d = a.d;
        }
        if (a.r()) {
            this.e = a.e;
        }
        if (a.u()) {
            this.f = a.f;
        }
        if (a.x()) {
            this.g = a.g;
        }
        if (a.A()) {
            this.h = a.h;
        }
        if (a.D()) {
            this.i = new C0314bf(a.i);
        }
        this.j = a.j;
        this.k = a.k;
        if (a.M()) {
            this.l = a.l;
        }
        if (a.P()) {
            this.m = a.m;
        }
        this.n = a.n;
        if (a.V()) {
            this.o = a.o;
        }
        if (a.Y()) {
            this.p = a.p;
        }
        if (a.ab()) {
            this.q = a.q;
        }
    }

    private void a(ObjectInputStream objectInputStream) {
        try {
            this.O = (byte) 0;
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

    public C0314bf B() {
        return this.i;
    }

    public void C() {
        this.i = null;
    }

    public boolean D() {
        return this.i != null;
    }

    public boolean E() {
        return this.j;
    }

    public void F() {
        this.O = C0353cn.b(this.O, (int) L);
    }

    public boolean G() {
        return C0353cn.a(this.O, (int) L);
    }

    public boolean H() {
        return this.k;
    }

    public void I() {
        this.O = C0353cn.b(this.O, (int) M);
    }

    public boolean J() {
        return C0353cn.a(this.O, (int) M);
    }

    public String K() {
        return this.l;
    }

    public void L() {
        this.l = null;
    }

    public boolean M() {
        return this.l != null;
    }

    public String N() {
        return this.m;
    }

    public void O() {
        this.m = null;
    }

    public boolean P() {
        return this.m != null;
    }

    public long Q() {
        return this.n;
    }

    public void R() {
        this.O = C0353cn.b(this.O, (int) N);
    }

    public boolean S() {
        return C0353cn.a(this.O, (int) N);
    }

    public String T() {
        return this.o;
    }

    public void U() {
        this.o = null;
    }

    public boolean V() {
        return this.o != null;
    }

    public String W() {
        return this.p;
    }

    public void X() {
        this.p = null;
    }

    public boolean Y() {
        return this.p != null;
    }

    public String Z() {
        return this.q;
    }

    public A a() {
        return new A(this);
    }

    public A a(long j) {
        this.n = j;
        p(true);
        return this;
    }

    public A a(C0314bf c0314bf) {
        this.i = c0314bf;
        return this;
    }

    public A a(String str) {
        this.a = str;
        return this;
    }

    public F a(int i) {
        return F.a(i);
    }

    public void a(cY cYVar) {
        ((dj) K.get(cYVar.D())).b().a(cYVar, this);
    }

    public void a(boolean z) {
        if (!z) {
            this.a = null;
        }
    }

    public void aa() {
        this.q = null;
    }

    public boolean ab() {
        return this.q != null;
    }

    public void ac() {
        if (this.i != null) {
            this.i.j();
        }
    }

    public A b(String str) {
        this.b = str;
        return this;
    }

    public /* synthetic */ cz b(int i) {
        return a(i);
    }

    public void b() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        k(false);
        this.j = false;
        m(false);
        this.k = false;
        this.l = null;
        this.m = null;
        p(false);
        this.n = 0;
        this.o = null;
        this.p = null;
        this.q = null;
    }

    public void b(cY cYVar) {
        ((dj) K.get(cYVar.D())).b().b(cYVar, this);
    }

    public void b(boolean z) {
        if (!z) {
            this.b = null;
        }
    }

    public A c(String str) {
        this.c = str;
        return this;
    }

    public String c() {
        return this.a;
    }

    public void c(boolean z) {
        if (!z) {
            this.c = null;
        }
    }

    public A d(String str) {
        this.d = str;
        return this;
    }

    public void d() {
        this.a = null;
    }

    public void d(boolean z) {
        if (!z) {
            this.d = null;
        }
    }

    public A e(String str) {
        this.e = str;
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

    public A f(String str) {
        this.f = str;
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

    public A g(String str) {
        this.g = str;
        return this;
    }

    public /* synthetic */ cq g() {
        return a();
    }

    public void g(boolean z) {
        if (!z) {
            this.g = null;
        }
    }

    public A h(String str) {
        this.h = str;
        return this;
    }

    public void h() {
        this.b = null;
    }

    public void h(boolean z) {
        if (!z) {
            this.h = null;
        }
    }

    public A i(String str) {
        this.l = str;
        return this;
    }

    public void i(boolean z) {
        if (!z) {
            this.i = null;
        }
    }

    public boolean i() {
        return this.b != null;
    }

    public A j(String str) {
        this.m = str;
        return this;
    }

    public A j(boolean z) {
        this.j = z;
        k(true);
        return this;
    }

    public String j() {
        return this.c;
    }

    public A k(String str) {
        this.o = str;
        return this;
    }

    public void k() {
        this.c = null;
    }

    public void k(boolean z) {
        this.O = C0353cn.a(this.O, (int) L, z);
    }

    public A l(String str) {
        this.p = str;
        return this;
    }

    public A l(boolean z) {
        this.k = z;
        m(true);
        return this;
    }

    public boolean l() {
        return this.c != null;
    }

    public A m(String str) {
        this.q = str;
        return this;
    }

    public String m() {
        return this.d;
    }

    public void m(boolean z) {
        this.O = C0353cn.a(this.O, (int) M, z);
    }

    public void n() {
        this.d = null;
    }

    public void n(boolean z) {
        if (!z) {
            this.l = null;
        }
    }

    public void o(boolean z) {
        if (!z) {
            this.m = null;
        }
    }

    public boolean o() {
        return this.d != null;
    }

    public String p() {
        return this.e;
    }

    public void p(boolean z) {
        this.O = C0353cn.a(this.O, (int) N, z);
    }

    public void q() {
        this.e = null;
    }

    public void q(boolean z) {
        if (!z) {
            this.o = null;
        }
    }

    public void r(boolean z) {
        if (!z) {
            this.p = null;
        }
    }

    public boolean r() {
        return this.e != null;
    }

    public String s() {
        return this.f;
    }

    public void s(boolean z) {
        if (!z) {
            this.q = null;
        }
    }

    public void t() {
        this.f = null;
    }

    public String toString() {
        Object obj = null;
        StringBuilder stringBuilder = new StringBuilder("DeviceInfo(");
        Object obj2 = M;
        if (e()) {
            stringBuilder.append("device_id:");
            if (this.a == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.a);
            }
            obj2 = L;
        }
        if (i()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("idmd5:");
            if (this.b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.b);
            }
            obj2 = L;
        }
        if (l()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("mac_address:");
            if (this.c == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.c);
            }
            obj2 = L;
        }
        if (o()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("open_udid:");
            if (this.d == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.d);
            }
            obj2 = L;
        }
        if (r()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("model:");
            if (this.e == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.e);
            }
            obj2 = L;
        }
        if (u()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("cpu:");
            if (this.f == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f);
            }
            obj2 = L;
        }
        if (x()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("os:");
            if (this.g == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.g);
            }
            obj2 = L;
        }
        if (A()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("os_version:");
            if (this.h == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.h);
            }
            obj2 = L;
        }
        if (D()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("resolution:");
            if (this.i == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.i);
            }
            obj2 = L;
        }
        if (G()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("is_jailbroken:");
            stringBuilder.append(this.j);
            obj2 = L;
        }
        if (J()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("is_pirated:");
            stringBuilder.append(this.k);
            obj2 = L;
        }
        if (M()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("device_board:");
            if (this.l == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.l);
            }
            obj2 = L;
        }
        if (P()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("device_brand:");
            if (this.m == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.m);
            }
            obj2 = L;
        }
        if (S()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("device_manutime:");
            stringBuilder.append(this.n);
            obj2 = L;
        }
        if (V()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("device_manufacturer:");
            if (this.o == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.o);
            }
            obj2 = L;
        }
        if (Y()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("device_manuid:");
            if (this.p == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.p);
            }
        } else {
            obj = obj2;
        }
        if (ab()) {
            if (obj == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("device_name:");
            if (this.q == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.q);
            }
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
