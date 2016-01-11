package b.a;

import cn.com.smartdevices.bracelet.gps.services.ay;
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

public class C0282aa implements cq<C0282aa, C0287af>, Serializable, Cloneable {
    public static final Map<C0287af, cI> e;
    private static final C0371de f = new C0371de("IdJournal");
    private static final cT g = new cT("domain", C0374dh.i, (short) 1);
    private static final cT h = new cT("old_id", C0374dh.i, (short) 2);
    private static final cT i = new cT("new_id", C0374dh.i, (short) 3);
    private static final cT j = new cT(ay.H, (byte) 10, (short) 4);
    private static final Map<Class<? extends di>, dj> k = new HashMap();
    private static final int l = 0;
    public String a;
    public String b;
    public String c;
    public long d;
    private byte m;
    private C0287af[] n;

    static {
        k.put(dk.class, new C0284ac());
        k.put(dl.class, new C0286ae());
        Map enumMap = new EnumMap(C0287af.class);
        enumMap.put(C0287af.DOMAIN, new cI("domain", (byte) 1, new cJ(C0374dh.i)));
        enumMap.put(C0287af.OLD_ID, new cI("old_id", (byte) 2, new cJ(C0374dh.i)));
        enumMap.put(C0287af.NEW_ID, new cI("new_id", (byte) 1, new cJ(C0374dh.i)));
        enumMap.put(C0287af.TS, new cI(ay.H, (byte) 1, new cJ((byte) 10)));
        e = Collections.unmodifiableMap(enumMap);
        cI.a(C0282aa.class, e);
    }

    public C0282aa() {
        this.m = (byte) 0;
        this.n = new C0287af[]{C0287af.OLD_ID};
    }

    public C0282aa(C0282aa c0282aa) {
        this.m = (byte) 0;
        this.n = new C0287af[]{C0287af.OLD_ID};
        this.m = c0282aa.m;
        if (c0282aa.e()) {
            this.a = c0282aa.a;
        }
        if (c0282aa.i()) {
            this.b = c0282aa.b;
        }
        if (c0282aa.l()) {
            this.c = c0282aa.c;
        }
        this.d = c0282aa.d;
    }

    public C0282aa(String str, String str2, long j) {
        this();
        this.a = str;
        this.c = str2;
        this.d = j;
        d(true);
    }

    private void a(ObjectInputStream objectInputStream) {
        try {
            this.m = (byte) 0;
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

    public C0282aa a() {
        return new C0282aa(this);
    }

    public C0282aa a(long j) {
        this.d = j;
        d(true);
        return this;
    }

    public C0282aa a(String str) {
        this.a = str;
        return this;
    }

    public C0287af a(int i) {
        return C0287af.a(i);
    }

    public void a(cY cYVar) {
        ((dj) k.get(cYVar.D())).b().a(cYVar, this);
    }

    public void a(boolean z) {
        if (!z) {
            this.a = null;
        }
    }

    public C0282aa b(String str) {
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
        d(false);
        this.d = 0;
    }

    public void b(cY cYVar) {
        ((dj) k.get(cYVar.D())).b().b(cYVar, this);
    }

    public void b(boolean z) {
        if (!z) {
            this.b = null;
        }
    }

    public C0282aa c(String str) {
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

    public void d() {
        this.a = null;
    }

    public void d(boolean z) {
        this.m = C0353cn.a(this.m, 0, z);
    }

    public boolean e() {
        return this.a != null;
    }

    public String f() {
        return this.b;
    }

    public /* synthetic */ cq g() {
        return a();
    }

    public void h() {
        this.b = null;
    }

    public boolean i() {
        return this.b != null;
    }

    public String j() {
        return this.c;
    }

    public void k() {
        this.c = null;
    }

    public boolean l() {
        return this.c != null;
    }

    public long m() {
        return this.d;
    }

    public void n() {
        this.m = C0353cn.b(this.m, 0);
    }

    public boolean o() {
        return C0353cn.a(this.m, 0);
    }

    public void p() {
        if (this.a == null) {
            throw new C0340cZ("Required field 'domain' was not present! Struct: " + toString());
        } else if (this.c == null) {
            throw new C0340cZ("Required field 'new_id' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("IdJournal(");
        stringBuilder.append("domain:");
        if (this.a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.a);
        }
        if (i()) {
            stringBuilder.append(", ");
            stringBuilder.append("old_id:");
            if (this.b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.b);
            }
        }
        stringBuilder.append(", ");
        stringBuilder.append("new_id:");
        if (this.c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.c);
        }
        stringBuilder.append(", ");
        stringBuilder.append("ts:");
        stringBuilder.append(this.d);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
