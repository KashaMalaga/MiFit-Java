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
import java.util.Map.Entry;

public class T implements cq<T, Y>, Serializable, Cloneable {
    public static final Map<Y, cI> f;
    private static final C0371de g = new C0371de("Event");
    private static final cT h = new cT("name", C0374dh.i, (short) 1);
    private static final cT i = new cT("properties", C0374dh.k, (short) 2);
    private static final cT j = new cT("duration", (byte) 10, (short) 3);
    private static final cT k = new cT("acc", (byte) 8, (short) 4);
    private static final cT l = new cT(ay.H, (byte) 10, (short) 5);
    private static final Map<Class<? extends di>, dj> m = new HashMap();
    private static final int n = 0;
    private static final int o = 1;
    private static final int p = 2;
    public String a;
    public Map<String, C0311bc> b;
    public long c;
    public int d;
    public long e;
    private byte q;
    private Y[] r;

    static {
        m.put(dk.class, new V());
        m.put(dl.class, new X());
        Map enumMap = new EnumMap(Y.class);
        enumMap.put(Y.NAME, new cI("name", (byte) 1, new cJ(C0374dh.i)));
        enumMap.put(Y.PROPERTIES, new cI("properties", (byte) 1, new cL(C0374dh.k, new cJ(C0374dh.i), new cN(C0374dh.j, C0311bc.class))));
        enumMap.put(Y.DURATION, new cI("duration", (byte) 2, new cJ((byte) 10)));
        enumMap.put(Y.ACC, new cI("acc", (byte) 2, new cJ((byte) 8)));
        enumMap.put(Y.TS, new cI(ay.H, (byte) 1, new cJ((byte) 10)));
        f = Collections.unmodifiableMap(enumMap);
        cI.a(T.class, f);
    }

    public T() {
        this.q = (byte) 0;
        Y[] yArr = new Y[p];
        yArr[n] = Y.DURATION;
        yArr[o] = Y.ACC;
        this.r = yArr;
    }

    public T(T t) {
        this.q = (byte) 0;
        Y[] yArr = new Y[p];
        yArr[n] = Y.DURATION;
        yArr[o] = Y.ACC;
        this.r = yArr;
        this.q = t.q;
        if (t.e()) {
            this.a = t.a;
        }
        if (t.j()) {
            Map hashMap = new HashMap();
            for (Entry entry : t.b.entrySet()) {
                hashMap.put((String) entry.getKey(), new C0311bc((C0311bc) entry.getValue()));
            }
            this.b = hashMap;
        }
        this.c = t.c;
        this.d = t.d;
        this.e = t.e;
    }

    public T(String str, Map<String, C0311bc> map, long j) {
        this();
        this.a = str;
        this.b = map;
        this.e = j;
        e(true);
    }

    private void a(ObjectInputStream objectInputStream) {
        try {
            this.q = (byte) 0;
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

    public T a() {
        return new T(this);
    }

    public T a(int i) {
        this.d = i;
        d(true);
        return this;
    }

    public T a(long j) {
        this.c = j;
        c(true);
        return this;
    }

    public T a(String str) {
        this.a = str;
        return this;
    }

    public T a(Map<String, C0311bc> map) {
        this.b = map;
        return this;
    }

    public void a(cY cYVar) {
        ((dj) m.get(cYVar.D())).b().a(cYVar, this);
    }

    public void a(String str, C0311bc c0311bc) {
        if (this.b == null) {
            this.b = new HashMap();
        }
        this.b.put(str, c0311bc);
    }

    public void a(boolean z) {
        if (!z) {
            this.a = null;
        }
    }

    public T b(long j) {
        this.e = j;
        e(true);
        return this;
    }

    public /* synthetic */ cz b(int i) {
        return c(i);
    }

    public void b() {
        this.a = null;
        this.b = null;
        c(false);
        this.c = 0;
        d(false);
        this.d = n;
        e(false);
        this.e = 0;
    }

    public void b(cY cYVar) {
        ((dj) m.get(cYVar.D())).b().b(cYVar, this);
    }

    public void b(boolean z) {
        if (!z) {
            this.b = null;
        }
    }

    public Y c(int i) {
        return Y.a(i);
    }

    public String c() {
        return this.a;
    }

    public void c(boolean z) {
        this.q = C0353cn.a(this.q, (int) n, z);
    }

    public void d() {
        this.a = null;
    }

    public void d(boolean z) {
        this.q = C0353cn.a(this.q, (int) o, z);
    }

    public void e(boolean z) {
        this.q = C0353cn.a(this.q, (int) p, z);
    }

    public boolean e() {
        return this.a != null;
    }

    public int f() {
        return this.b == null ? n : this.b.size();
    }

    public /* synthetic */ cq g() {
        return a();
    }

    public Map<String, C0311bc> h() {
        return this.b;
    }

    public void i() {
        this.b = null;
    }

    public boolean j() {
        return this.b != null;
    }

    public long k() {
        return this.c;
    }

    public void l() {
        this.q = C0353cn.b(this.q, (int) n);
    }

    public boolean m() {
        return C0353cn.a(this.q, (int) n);
    }

    public int n() {
        return this.d;
    }

    public void o() {
        this.q = C0353cn.b(this.q, (int) o);
    }

    public boolean p() {
        return C0353cn.a(this.q, (int) o);
    }

    public long q() {
        return this.e;
    }

    public void r() {
        this.q = C0353cn.b(this.q, (int) p);
    }

    public boolean s() {
        return C0353cn.a(this.q, (int) p);
    }

    public void t() {
        if (this.a == null) {
            throw new C0340cZ("Required field 'name' was not present! Struct: " + toString());
        } else if (this.b == null) {
            throw new C0340cZ("Required field 'properties' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Event(");
        stringBuilder.append("name:");
        if (this.a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.a);
        }
        stringBuilder.append(", ");
        stringBuilder.append("properties:");
        if (this.b == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.b);
        }
        if (m()) {
            stringBuilder.append(", ");
            stringBuilder.append("duration:");
            stringBuilder.append(this.c);
        }
        if (p()) {
            stringBuilder.append(", ");
            stringBuilder.append("acc:");
            stringBuilder.append(this.d);
        }
        stringBuilder.append(", ");
        stringBuilder.append("ts:");
        stringBuilder.append(this.e);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
