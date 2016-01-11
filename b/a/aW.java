package b.a;

import cn.com.smartdevices.bracelet.C0410c;
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

public class aW implements cq<aW, C0310bb>, Serializable, Cloneable {
    public static final Map<C0310bb, cI> c;
    private static final C0371de d = new C0371de(C0410c.n);
    private static final cT e = new cT("page_name", C0374dh.i, (short) 1);
    private static final cT f = new cT("duration", (byte) 10, (short) 2);
    private static final Map<Class<? extends di>, dj> g = new HashMap();
    private static final int h = 0;
    public String a;
    public long b;
    private byte i;

    static {
        g.put(dk.class, new aY());
        g.put(dl.class, new C0309ba());
        Map enumMap = new EnumMap(C0310bb.class);
        enumMap.put(C0310bb.PAGE_NAME, new cI("page_name", (byte) 1, new cJ(C0374dh.i)));
        enumMap.put(C0310bb.DURATION, new cI("duration", (byte) 1, new cJ((byte) 10)));
        c = Collections.unmodifiableMap(enumMap);
        cI.a(aW.class, c);
    }

    public aW() {
        this.i = (byte) 0;
    }

    public aW(aW aWVar) {
        this.i = (byte) 0;
        this.i = aWVar.i;
        if (aWVar.e()) {
            this.a = aWVar.a;
        }
        this.b = aWVar.b;
    }

    public aW(String str, long j) {
        this();
        this.a = str;
        this.b = j;
        b(true);
    }

    private void a(ObjectInputStream objectInputStream) {
        try {
            this.i = (byte) 0;
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

    public aW a() {
        return new aW(this);
    }

    public aW a(long j) {
        this.b = j;
        b(true);
        return this;
    }

    public aW a(String str) {
        this.a = str;
        return this;
    }

    public C0310bb a(int i) {
        return C0310bb.a(i);
    }

    public void a(cY cYVar) {
        ((dj) g.get(cYVar.D())).b().a(cYVar, this);
    }

    public void a(boolean z) {
        if (!z) {
            this.a = null;
        }
    }

    public /* synthetic */ cz b(int i) {
        return a(i);
    }

    public void b() {
        this.a = null;
        b(false);
        this.b = 0;
    }

    public void b(cY cYVar) {
        ((dj) g.get(cYVar.D())).b().b(cYVar, this);
    }

    public void b(boolean z) {
        this.i = C0353cn.a(this.i, 0, z);
    }

    public String c() {
        return this.a;
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
        this.i = C0353cn.b(this.i, 0);
    }

    public boolean i() {
        return C0353cn.a(this.i, 0);
    }

    public void j() {
        if (this.a == null) {
            throw new C0340cZ("Required field 'page_name' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Page(");
        stringBuilder.append("page_name:");
        if (this.a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.a);
        }
        stringBuilder.append(", ");
        stringBuilder.append("duration:");
        stringBuilder.append(this.b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
