package b.a;

import cn.com.smartdevices.bracelet.d.C0432i;
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

public class C0306ay implements cq<C0306ay, aD>, Serializable, Cloneable {
    public static final Map<aD, cI> d;
    private static final C0371de e = new C0371de("ImprintValue");
    private static final cT f = new cT(C0432i.b, C0374dh.i, (short) 1);
    private static final cT g = new cT(ay.H, (byte) 10, (short) 2);
    private static final cT h = new cT("guid", C0374dh.i, (short) 3);
    private static final Map<Class<? extends di>, dj> i = new HashMap();
    private static final int j = 0;
    public String a;
    public long b;
    public String c;
    private byte k;
    private aD[] l;

    static {
        i.put(dk.class, new aA());
        i.put(dl.class, new aC());
        Map enumMap = new EnumMap(aD.class);
        enumMap.put(aD.VALUE, new cI(C0432i.b, (byte) 2, new cJ(C0374dh.i)));
        enumMap.put(aD.TS, new cI(ay.H, (byte) 1, new cJ((byte) 10)));
        enumMap.put(aD.GUID, new cI("guid", (byte) 1, new cJ(C0374dh.i)));
        d = Collections.unmodifiableMap(enumMap);
        cI.a(C0306ay.class, d);
    }

    public C0306ay() {
        this.k = (byte) 0;
        this.l = new aD[]{aD.VALUE};
    }

    public C0306ay(long j, String str) {
        this();
        this.b = j;
        b(true);
        this.c = str;
    }

    public C0306ay(C0306ay c0306ay) {
        this.k = (byte) 0;
        this.l = new aD[]{aD.VALUE};
        this.k = c0306ay.k;
        if (c0306ay.e()) {
            this.a = c0306ay.a;
        }
        this.b = c0306ay.b;
        if (c0306ay.l()) {
            this.c = c0306ay.c;
        }
    }

    private void a(ObjectInputStream objectInputStream) {
        try {
            this.k = (byte) 0;
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

    public aD a(int i) {
        return aD.a(i);
    }

    public C0306ay a() {
        return new C0306ay(this);
    }

    public C0306ay a(long j) {
        this.b = j;
        b(true);
        return this;
    }

    public C0306ay a(String str) {
        this.a = str;
        return this;
    }

    public void a(cY cYVar) {
        ((dj) i.get(cYVar.D())).b().a(cYVar, this);
    }

    public void a(boolean z) {
        if (!z) {
            this.a = null;
        }
    }

    public C0306ay b(String str) {
        this.c = str;
        return this;
    }

    public /* synthetic */ cz b(int i) {
        return a(i);
    }

    public void b() {
        this.a = null;
        b(false);
        this.b = 0;
        this.c = null;
    }

    public void b(cY cYVar) {
        ((dj) i.get(cYVar.D())).b().b(cYVar, this);
    }

    public void b(boolean z) {
        this.k = C0353cn.a(this.k, 0, z);
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

    public boolean e() {
        return this.a != null;
    }

    public long f() {
        return this.b;
    }

    public /* synthetic */ cq g() {
        return a();
    }

    public void h() {
        this.k = C0353cn.b(this.k, 0);
    }

    public boolean i() {
        return C0353cn.a(this.k, 0);
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

    public void m() {
        if (this.c == null) {
            throw new C0340cZ("Required field 'guid' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ImprintValue(");
        Object obj = 1;
        if (e()) {
            stringBuilder.append("value:");
            if (this.a == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.a);
            }
            obj = null;
        }
        if (obj == null) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("ts:");
        stringBuilder.append(this.b);
        stringBuilder.append(", ");
        stringBuilder.append("guid:");
        if (this.c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.c);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
