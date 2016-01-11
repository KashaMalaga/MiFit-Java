package b.a;

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
import java.util.Map.Entry;

public class C0300as implements cq<C0300as, C0305ax>, Serializable, Cloneable {
    public static final Map<C0305ax, cI> d;
    private static final C0371de e = new C0371de("Imprint");
    private static final cT f = new cT("property", C0374dh.k, (short) 1);
    private static final cT g = new cT(o.x, (byte) 8, (short) 2);
    private static final cT h = new cT("checksum", C0374dh.i, (short) 3);
    private static final Map<Class<? extends di>, dj> i = new HashMap();
    private static final int j = 0;
    public Map<String, C0306ay> a;
    public int b;
    public String c;
    private byte k;

    static {
        i.put(dk.class, new C0302au());
        i.put(dl.class, new C0304aw());
        Map enumMap = new EnumMap(C0305ax.class);
        enumMap.put(C0305ax.PROPERTY, new cI("property", (byte) 1, new cL(C0374dh.k, new cJ(C0374dh.i), new cN(C0374dh.j, C0306ay.class))));
        enumMap.put(C0305ax.VERSION, new cI(o.x, (byte) 1, new cJ((byte) 8)));
        enumMap.put(C0305ax.CHECKSUM, new cI("checksum", (byte) 1, new cJ(C0374dh.i)));
        d = Collections.unmodifiableMap(enumMap);
        cI.a(C0300as.class, d);
    }

    public C0300as() {
        this.k = (byte) 0;
    }

    public C0300as(C0300as c0300as) {
        this.k = (byte) 0;
        this.k = c0300as.k;
        if (c0300as.f()) {
            Map hashMap = new HashMap();
            for (Entry entry : c0300as.a.entrySet()) {
                hashMap.put((String) entry.getKey(), new C0306ay((C0306ay) entry.getValue()));
            }
            this.a = hashMap;
        }
        this.b = c0300as.b;
        if (c0300as.m()) {
            this.c = c0300as.c;
        }
    }

    public C0300as(Map<String, C0306ay> map, int i, String str) {
        this();
        this.a = map;
        this.b = i;
        b(true);
        this.c = str;
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

    public C0300as a() {
        return new C0300as(this);
    }

    public C0300as a(int i) {
        this.b = i;
        b(true);
        return this;
    }

    public C0300as a(String str) {
        this.c = str;
        return this;
    }

    public C0300as a(Map<String, C0306ay> map) {
        this.a = map;
        return this;
    }

    public void a(cY cYVar) {
        ((dj) i.get(cYVar.D())).b().a(cYVar, this);
    }

    public void a(String str, C0306ay c0306ay) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        this.a.put(str, c0306ay);
    }

    public void a(boolean z) {
        if (!z) {
            this.a = null;
        }
    }

    public /* synthetic */ cz b(int i) {
        return c(i);
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

    public int c() {
        return this.a == null ? 0 : this.a.size();
    }

    public C0305ax c(int i) {
        return C0305ax.a(i);
    }

    public void c(boolean z) {
        if (!z) {
            this.c = null;
        }
    }

    public Map<String, C0306ay> d() {
        return this.a;
    }

    public void e() {
        this.a = null;
    }

    public boolean f() {
        return this.a != null;
    }

    public /* synthetic */ cq g() {
        return a();
    }

    public int h() {
        return this.b;
    }

    public void i() {
        this.k = C0353cn.b(this.k, 0);
    }

    public boolean j() {
        return C0353cn.a(this.k, 0);
    }

    public String k() {
        return this.c;
    }

    public void l() {
        this.c = null;
    }

    public boolean m() {
        return this.c != null;
    }

    public void n() {
        if (this.a == null) {
            throw new C0340cZ("Required field 'property' was not present! Struct: " + toString());
        } else if (this.c == null) {
            throw new C0340cZ("Required field 'checksum' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Imprint(");
        stringBuilder.append("property:");
        if (this.a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.a);
        }
        stringBuilder.append(", ");
        stringBuilder.append("version:");
        stringBuilder.append(this.b);
        stringBuilder.append(", ");
        stringBuilder.append("checksum:");
        if (this.c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.c);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
