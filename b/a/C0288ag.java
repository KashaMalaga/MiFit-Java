package b.a;

import cn.com.smartdevices.bracelet.gps.services.ay;
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

public class C0288ag implements cq<C0288ag, C0293al>, Serializable, Cloneable {
    public static final Map<C0293al, cI> d;
    private static final C0371de e = new C0371de("IdSnapshot");
    private static final cT f = new cT("identity", C0374dh.i, (short) 1);
    private static final cT g = new cT(ay.H, (byte) 10, (short) 2);
    private static final cT h = new cT(o.x, (byte) 8, (short) 3);
    private static final Map<Class<? extends di>, dj> i = new HashMap();
    private static final int j = 0;
    private static final int k = 1;
    public String a;
    public long b;
    public int c;
    private byte l;

    static {
        i.put(dk.class, new C0290ai());
        i.put(dl.class, new C0292ak());
        Map enumMap = new EnumMap(C0293al.class);
        enumMap.put(C0293al.IDENTITY, new cI("identity", (byte) 1, new cJ(C0374dh.i)));
        enumMap.put(C0293al.TS, new cI(ay.H, (byte) 1, new cJ((byte) 10)));
        enumMap.put(C0293al.VERSION, new cI(o.x, (byte) 1, new cJ((byte) 8)));
        d = Collections.unmodifiableMap(enumMap);
        cI.a(C0288ag.class, d);
    }

    public C0288ag() {
        this.l = (byte) 0;
    }

    public C0288ag(C0288ag c0288ag) {
        this.l = (byte) 0;
        this.l = c0288ag.l;
        if (c0288ag.e()) {
            this.a = c0288ag.a;
        }
        this.b = c0288ag.b;
        this.c = c0288ag.c;
    }

    public C0288ag(String str, long j, int i) {
        this();
        this.a = str;
        this.b = j;
        b(true);
        this.c = i;
        c(true);
    }

    private void a(ObjectInputStream objectInputStream) {
        try {
            this.l = (byte) 0;
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

    public C0288ag a() {
        return new C0288ag(this);
    }

    public C0288ag a(int i) {
        this.c = i;
        c(true);
        return this;
    }

    public C0288ag a(long j) {
        this.b = j;
        b(true);
        return this;
    }

    public C0288ag a(String str) {
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

    public /* synthetic */ cz b(int i) {
        return c(i);
    }

    public void b() {
        this.a = null;
        b(false);
        this.b = 0;
        c(false);
        this.c = j;
    }

    public void b(cY cYVar) {
        ((dj) i.get(cYVar.D())).b().b(cYVar, this);
    }

    public void b(boolean z) {
        this.l = C0353cn.a(this.l, (int) j, z);
    }

    public C0293al c(int i) {
        return C0293al.a(i);
    }

    public String c() {
        return this.a;
    }

    public void c(boolean z) {
        this.l = C0353cn.a(this.l, (int) k, z);
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
        this.l = C0353cn.b(this.l, (int) j);
    }

    public boolean i() {
        return C0353cn.a(this.l, (int) j);
    }

    public int j() {
        return this.c;
    }

    public void k() {
        this.l = C0353cn.b(this.l, (int) k);
    }

    public boolean l() {
        return C0353cn.a(this.l, (int) k);
    }

    public void m() {
        if (this.a == null) {
            throw new C0340cZ("Required field 'identity' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("IdSnapshot(");
        stringBuilder.append("identity:");
        if (this.a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.a);
        }
        stringBuilder.append(", ");
        stringBuilder.append("ts:");
        stringBuilder.append(this.b);
        stringBuilder.append(", ");
        stringBuilder.append("version:");
        stringBuilder.append(this.c);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
