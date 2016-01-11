package b.a;

import com.amap.api.services.district.DistrictSearchQuery;
import com.sina.weibo.sdk.constant.WBPageConstants.ParamKey;
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

public class aQ implements cq<aQ, aV>, Serializable, Cloneable {
    private static final int A = 1;
    private static final int B = 2;
    private static final int C = 3;
    public static final Map<aV, cI> l;
    private static final C0371de m = new C0371de("MiscInfo");
    private static final cT n = new cT("time_zone", (byte) 8, (short) 1);
    private static final cT o = new cT("language", C0374dh.i, (short) 2);
    private static final cT p = new cT(DistrictSearchQuery.KEYWORDS_COUNTRY, C0374dh.i, (short) 3);
    private static final cT q = new cT(ParamKey.LATITUDE, (byte) 4, (short) 4);
    private static final cT r = new cT(ParamKey.LONGITUDE, (byte) 4, (short) 5);
    private static final cT s = new cT("carrier", C0374dh.i, (short) 6);
    private static final cT t = new cT("latency", (byte) 8, (short) 7);
    private static final cT u = new cT("display_name", C0374dh.i, (short) 8);
    private static final cT v = new cT("access_type", (byte) 8, (short) 9);
    private static final cT w = new cT("access_subtype", C0374dh.i, (short) 10);
    private static final cT x = new cT("user_info", C0374dh.j, (short) 11);
    private static final Map<Class<? extends di>, dj> y = new HashMap();
    private static final int z = 0;
    private byte D;
    private aV[] E;
    public int a;
    public String b;
    public String c;
    public double d;
    public double e;
    public String f;
    public int g;
    public String h;
    public C0382h i;
    public String j;
    public bK k;

    static {
        y.put(dk.class, new aS());
        y.put(dl.class, new aU());
        Map enumMap = new EnumMap(aV.class);
        enumMap.put(aV.TIME_ZONE, new cI("time_zone", (byte) 2, new cJ((byte) 8)));
        enumMap.put(aV.LANGUAGE, new cI("language", (byte) 2, new cJ(C0374dh.i)));
        enumMap.put(aV.COUNTRY, new cI(DistrictSearchQuery.KEYWORDS_COUNTRY, (byte) 2, new cJ(C0374dh.i)));
        enumMap.put(aV.LATITUDE, new cI(ParamKey.LATITUDE, (byte) 2, new cJ((byte) 4)));
        enumMap.put(aV.LONGITUDE, new cI(ParamKey.LONGITUDE, (byte) 2, new cJ((byte) 4)));
        enumMap.put(aV.CARRIER, new cI("carrier", (byte) 2, new cJ(C0374dh.i)));
        enumMap.put(aV.LATENCY, new cI("latency", (byte) 2, new cJ((byte) 8)));
        enumMap.put(aV.DISPLAY_NAME, new cI("display_name", (byte) 2, new cJ(C0374dh.i)));
        enumMap.put(aV.ACCESS_TYPE, new cI("access_type", (byte) 2, new cH(C0374dh.n, C0382h.class)));
        enumMap.put(aV.ACCESS_SUBTYPE, new cI("access_subtype", (byte) 2, new cJ(C0374dh.i)));
        enumMap.put(aV.USER_INFO, new cI("user_info", (byte) 2, new cN(C0374dh.j, bK.class)));
        l = Collections.unmodifiableMap(enumMap);
        cI.a(aQ.class, l);
    }

    public aQ() {
        this.D = (byte) 0;
        this.E = new aV[]{aV.TIME_ZONE, aV.LANGUAGE, aV.COUNTRY, aV.LATITUDE, aV.LONGITUDE, aV.CARRIER, aV.LATENCY, aV.DISPLAY_NAME, aV.ACCESS_TYPE, aV.ACCESS_SUBTYPE, aV.USER_INFO};
    }

    public aQ(aQ aQVar) {
        this.D = (byte) 0;
        this.E = new aV[]{aV.TIME_ZONE, aV.LANGUAGE, aV.COUNTRY, aV.LATITUDE, aV.LONGITUDE, aV.CARRIER, aV.LATENCY, aV.DISPLAY_NAME, aV.ACCESS_TYPE, aV.ACCESS_SUBTYPE, aV.USER_INFO};
        this.D = aQVar.D;
        this.a = aQVar.a;
        if (aQVar.i()) {
            this.b = aQVar.b;
        }
        if (aQVar.l()) {
            this.c = aQVar.c;
        }
        this.d = aQVar.d;
        this.e = aQVar.e;
        if (aQVar.u()) {
            this.f = aQVar.f;
        }
        this.g = aQVar.g;
        if (aQVar.A()) {
            this.h = aQVar.h;
        }
        if (aQVar.D()) {
            this.i = aQVar.i;
        }
        if (aQVar.G()) {
            this.j = aQVar.j;
        }
        if (aQVar.J()) {
            this.k = new bK(aQVar.k);
        }
    }

    private void a(ObjectInputStream objectInputStream) {
        try {
            this.D = (byte) 0;
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

    public C0382h B() {
        return this.i;
    }

    public void C() {
        this.i = null;
    }

    public boolean D() {
        return this.i != null;
    }

    public String E() {
        return this.j;
    }

    public void F() {
        this.j = null;
    }

    public boolean G() {
        return this.j != null;
    }

    public bK H() {
        return this.k;
    }

    public void I() {
        this.k = null;
    }

    public boolean J() {
        return this.k != null;
    }

    public void K() {
        if (this.k != null) {
            this.k.p();
        }
    }

    public aQ a() {
        return new aQ(this);
    }

    public aQ a(double d) {
        this.d = d;
        d(true);
        return this;
    }

    public aQ a(int i) {
        this.a = i;
        a(true);
        return this;
    }

    public aQ a(bK bKVar) {
        this.k = bKVar;
        return this;
    }

    public aQ a(C0382h c0382h) {
        this.i = c0382h;
        return this;
    }

    public aQ a(String str) {
        this.b = str;
        return this;
    }

    public void a(cY cYVar) {
        ((dj) y.get(cYVar.D())).b().a(cYVar, this);
    }

    public void a(boolean z) {
        this.D = C0353cn.a(this.D, 0, z);
    }

    public aQ b(double d) {
        this.e = d;
        e(true);
        return this;
    }

    public aQ b(String str) {
        this.c = str;
        return this;
    }

    public /* synthetic */ cz b(int i) {
        return d(i);
    }

    public void b() {
        a(false);
        this.a = 0;
        this.b = null;
        this.c = null;
        d(false);
        this.d = 0.0d;
        e(false);
        this.e = 0.0d;
        this.f = null;
        g(false);
        this.g = 0;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
    }

    public void b(cY cYVar) {
        ((dj) y.get(cYVar.D())).b().b(cYVar, this);
    }

    public void b(boolean z) {
        if (!z) {
            this.b = null;
        }
    }

    public int c() {
        return this.a;
    }

    public aQ c(int i) {
        this.g = i;
        g(true);
        return this;
    }

    public aQ c(String str) {
        this.f = str;
        return this;
    }

    public void c(boolean z) {
        if (!z) {
            this.c = null;
        }
    }

    public aQ d(String str) {
        this.h = str;
        return this;
    }

    public aV d(int i) {
        return aV.a(i);
    }

    public void d() {
        this.D = C0353cn.b(this.D, 0);
    }

    public void d(boolean z) {
        this.D = C0353cn.a(this.D, (int) A, z);
    }

    public aQ e(String str) {
        this.j = str;
        return this;
    }

    public void e(boolean z) {
        this.D = C0353cn.a(this.D, (int) B, z);
    }

    public boolean e() {
        return C0353cn.a(this.D, 0);
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

    public void g(boolean z) {
        this.D = C0353cn.a(this.D, (int) C, z);
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

    public String j() {
        return this.c;
    }

    public void j(boolean z) {
        if (!z) {
            this.j = null;
        }
    }

    public void k() {
        this.c = null;
    }

    public void k(boolean z) {
        if (!z) {
            this.k = null;
        }
    }

    public boolean l() {
        return this.c != null;
    }

    public double m() {
        return this.d;
    }

    public void n() {
        this.D = C0353cn.b(this.D, (int) A);
    }

    public boolean o() {
        return C0353cn.a(this.D, (int) A);
    }

    public double p() {
        return this.e;
    }

    public void q() {
        this.D = C0353cn.b(this.D, (int) B);
    }

    public boolean r() {
        return C0353cn.a(this.D, (int) B);
    }

    public String s() {
        return this.f;
    }

    public void t() {
        this.f = null;
    }

    public String toString() {
        Object obj = null;
        StringBuilder stringBuilder = new StringBuilder("MiscInfo(");
        Object obj2 = A;
        if (e()) {
            stringBuilder.append("time_zone:");
            stringBuilder.append(this.a);
            obj2 = null;
        }
        if (i()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("language:");
            if (this.b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.b);
            }
            obj2 = null;
        }
        if (l()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("country:");
            if (this.c == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.c);
            }
            obj2 = null;
        }
        if (o()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("latitude:");
            stringBuilder.append(this.d);
            obj2 = null;
        }
        if (r()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("longitude:");
            stringBuilder.append(this.e);
            obj2 = null;
        }
        if (u()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("carrier:");
            if (this.f == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f);
            }
            obj2 = null;
        }
        if (x()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("latency:");
            stringBuilder.append(this.g);
            obj2 = null;
        }
        if (A()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("display_name:");
            if (this.h == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.h);
            }
            obj2 = null;
        }
        if (D()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("access_type:");
            if (this.i == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.i);
            }
            obj2 = null;
        }
        if (G()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("access_subtype:");
            if (this.j == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.j);
            }
        } else {
            obj = obj2;
        }
        if (J()) {
            if (obj == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("user_info:");
            if (this.k == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.k);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public boolean u() {
        return this.f != null;
    }

    public int v() {
        return this.g;
    }

    public void w() {
        this.D = C0353cn.b(this.D, (int) C);
    }

    public boolean x() {
        return C0353cn.a(this.D, (int) C);
    }

    public String y() {
        return this.h;
    }

    public void z() {
        this.h = null;
    }
}
