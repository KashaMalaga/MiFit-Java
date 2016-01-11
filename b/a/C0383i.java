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

public class C0383i implements cq<C0383i, C0388n>, Serializable, Cloneable {
    public static final Map<C0388n, cI> b;
    private static final C0371de c = new C0371de("ActivateMsg");
    private static final cT d = new cT(ay.H, (byte) 10, (short) 1);
    private static final Map<Class<? extends di>, dj> e = new HashMap();
    private static final int f = 0;
    public long a;
    private byte g;

    static {
        e.put(dk.class, new C0385k());
        e.put(dl.class, new C0387m());
        Map enumMap = new EnumMap(C0388n.class);
        enumMap.put(C0388n.TS, new cI(ay.H, (byte) 1, new cJ((byte) 10)));
        b = Collections.unmodifiableMap(enumMap);
        cI.a(C0383i.class, b);
    }

    public C0383i() {
        this.g = (byte) 0;
    }

    public C0383i(long j) {
        this();
        this.a = j;
        a(true);
    }

    public C0383i(C0383i c0383i) {
        this.g = (byte) 0;
        this.g = c0383i.g;
        this.a = c0383i.a;
    }

    private void a(ObjectInputStream objectInputStream) {
        try {
            this.g = (byte) 0;
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

    public C0383i a() {
        return new C0383i(this);
    }

    public C0383i a(long j) {
        this.a = j;
        a(true);
        return this;
    }

    public C0388n a(int i) {
        return C0388n.a(i);
    }

    public void a(cY cYVar) {
        ((dj) e.get(cYVar.D())).b().a(cYVar, this);
    }

    public void a(boolean z) {
        this.g = C0353cn.a(this.g, 0, z);
    }

    public /* synthetic */ cz b(int i) {
        return a(i);
    }

    public void b() {
        a(false);
        this.a = 0;
    }

    public void b(cY cYVar) {
        ((dj) e.get(cYVar.D())).b().b(cYVar, this);
    }

    public long c() {
        return this.a;
    }

    public void d() {
        this.g = C0353cn.b(this.g, 0);
    }

    public boolean e() {
        return C0353cn.a(this.g, 0);
    }

    public void f() {
    }

    public /* synthetic */ cq g() {
        return a();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ActivateMsg(");
        stringBuilder.append("ts:");
        stringBuilder.append(this.a);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
