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

public class G implements cq<G, L>, Serializable, Cloneable {
    public static final Map<L, cI> f;
    private static final C0371de g = new C0371de("Ekv");
    private static final cT h = new cT(ay.H, (byte) 10, (short) 1);
    private static final cT i = new cT("name", C0374dh.i, (short) 2);
    private static final cT j = new cT("ckv", C0374dh.k, (short) 3);
    private static final cT k = new cT("duration", (byte) 10, (short) 4);
    private static final cT l = new cT("acc", (byte) 8, (short) 5);
    private static final Map<Class<? extends di>, dj> m = new HashMap();
    private static final int n = 0;
    private static final int o = 1;
    private static final int p = 2;
    public long a;
    public String b;
    public Map<String, String> c;
    public long d;
    public int e;
    private byte q;
    private L[] r;

    static {
        m.put(dk.class, new I());
        m.put(dl.class, new K());
        Map enumMap = new EnumMap(L.class);
        enumMap.put(L.TS, new cI(ay.H, (byte) 1, new cJ((byte) 10)));
        enumMap.put(L.NAME, new cI("name", (byte) 1, new cJ(C0374dh.i)));
        enumMap.put(L.CKV, new cI("ckv", (byte) 1, new cL(C0374dh.k, new cJ(C0374dh.i), new cJ(C0374dh.i))));
        enumMap.put(L.DURATION, new cI("duration", (byte) 2, new cJ((byte) 10)));
        enumMap.put(L.ACC, new cI("acc", (byte) 2, new cJ((byte) 8)));
        f = Collections.unmodifiableMap(enumMap);
        cI.a(G.class, f);
    }

    public G() {
        this.q = (byte) 0;
        L[] lArr = new L[p];
        lArr[n] = L.DURATION;
        lArr[o] = L.ACC;
        this.r = lArr;
    }

    public G(long j, String str, Map<String, String> map) {
        this();
        this.a = j;
        a(true);
        this.b = str;
        this.c = map;
    }

    public G(G g) {
        this.q = (byte) 0;
        L[] lArr = new L[p];
        lArr[n] = L.DURATION;
        lArr[o] = L.ACC;
        this.r = lArr;
        this.q = g.q;
        this.a = g.a;
        if (g.i()) {
            this.b = g.b;
        }
        if (g.m()) {
            Map hashMap = new HashMap();
            for (Entry entry : g.c.entrySet()) {
                hashMap.put((String) entry.getKey(), (String) entry.getValue());
            }
            this.c = hashMap;
        }
        this.d = g.d;
        this.e = g.e;
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

    public G a() {
        return new G(this);
    }

    public G a(int i) {
        this.e = i;
        e(true);
        return this;
    }

    public G a(long j) {
        this.a = j;
        a(true);
        return this;
    }

    public G a(String str) {
        this.b = str;
        return this;
    }

    public G a(Map<String, String> map) {
        this.c = map;
        return this;
    }

    public void a(cY cYVar) {
        ((dj) m.get(cYVar.D())).b().a(cYVar, this);
    }

    public void a(String str, String str2) {
        if (this.c == null) {
            this.c = new HashMap();
        }
        this.c.put(str, str2);
    }

    public void a(boolean z) {
        this.q = C0353cn.a(this.q, (int) n, z);
    }

    public G b(long j) {
        this.d = j;
        d(true);
        return this;
    }

    public /* synthetic */ cz b(int i) {
        return c(i);
    }

    public void b() {
        a(false);
        this.a = 0;
        this.b = null;
        this.c = null;
        d(false);
        this.d = 0;
        e(false);
        this.e = n;
    }

    public void b(cY cYVar) {
        ((dj) m.get(cYVar.D())).b().b(cYVar, this);
    }

    public void b(boolean z) {
        if (!z) {
            this.b = null;
        }
    }

    public long c() {
        return this.a;
    }

    public L c(int i) {
        return L.a(i);
    }

    public void c(boolean z) {
        if (!z) {
            this.c = null;
        }
    }

    public void d() {
        this.q = C0353cn.b(this.q, (int) n);
    }

    public void d(boolean z) {
        this.q = C0353cn.a(this.q, (int) o, z);
    }

    public void e(boolean z) {
        this.q = C0353cn.a(this.q, (int) p, z);
    }

    public boolean e() {
        return C0353cn.a(this.q, (int) n);
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

    public int j() {
        return this.c == null ? n : this.c.size();
    }

    public Map<String, String> k() {
        return this.c;
    }

    public void l() {
        this.c = null;
    }

    public boolean m() {
        return this.c != null;
    }

    public long n() {
        return this.d;
    }

    public void o() {
        this.q = C0353cn.b(this.q, (int) o);
    }

    public boolean p() {
        return C0353cn.a(this.q, (int) o);
    }

    public int q() {
        return this.e;
    }

    public void r() {
        this.q = C0353cn.b(this.q, (int) p);
    }

    public boolean s() {
        return C0353cn.a(this.q, (int) p);
    }

    public void t() {
        if (this.b == null) {
            throw new C0340cZ("Required field 'name' was not present! Struct: " + toString());
        } else if (this.c == null) {
            throw new C0340cZ("Required field 'ckv' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Ekv(");
        stringBuilder.append("ts:");
        stringBuilder.append(this.a);
        stringBuilder.append(", ");
        stringBuilder.append("name:");
        if (this.b == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.b);
        }
        stringBuilder.append(", ");
        stringBuilder.append("ckv:");
        if (this.c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.c);
        }
        if (p()) {
            stringBuilder.append(", ");
            stringBuilder.append("duration:");
            stringBuilder.append(this.d);
        }
        if (s()) {
            stringBuilder.append(", ");
            stringBuilder.append("acc:");
            stringBuilder.append(this.e);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
