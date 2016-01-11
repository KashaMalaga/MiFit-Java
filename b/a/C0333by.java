package b.a;

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

public class C0333by implements cq<C0333by, bD>, Serializable, Cloneable {
    public static final Map<bD, cI> c;
    private static final C0371de d = new C0371de("Traffic");
    private static final cT e = new cT("upload_traffic", (byte) 8, (short) 1);
    private static final cT f = new cT("download_traffic", (byte) 8, (short) 2);
    private static final Map<Class<? extends di>, dj> g = new HashMap();
    private static final int h = 0;
    private static final int i = 1;
    public int a;
    public int b;
    private byte j;

    static {
        g.put(dk.class, new bA());
        g.put(dl.class, new bC());
        Map enumMap = new EnumMap(bD.class);
        enumMap.put(bD.UPLOAD_TRAFFIC, new cI("upload_traffic", (byte) 1, new cJ((byte) 8)));
        enumMap.put(bD.DOWNLOAD_TRAFFIC, new cI("download_traffic", (byte) 1, new cJ((byte) 8)));
        c = Collections.unmodifiableMap(enumMap);
        cI.a(C0333by.class, c);
    }

    public C0333by() {
        this.j = (byte) 0;
    }

    public C0333by(int i, int i2) {
        this();
        this.a = i;
        a(true);
        this.b = i2;
        b(true);
    }

    public C0333by(C0333by c0333by) {
        this.j = (byte) 0;
        this.j = c0333by.j;
        this.a = c0333by.a;
        this.b = c0333by.b;
    }

    private void a(ObjectInputStream objectInputStream) {
        try {
            this.j = (byte) 0;
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

    public C0333by a() {
        return new C0333by(this);
    }

    public C0333by a(int i) {
        this.a = i;
        a(true);
        return this;
    }

    public void a(cY cYVar) {
        ((dj) g.get(cYVar.D())).b().a(cYVar, this);
    }

    public void a(boolean z) {
        this.j = C0353cn.a(this.j, (int) h, z);
    }

    public /* synthetic */ cz b(int i) {
        return d(i);
    }

    public void b() {
        a(false);
        this.a = h;
        b(false);
        this.b = h;
    }

    public void b(cY cYVar) {
        ((dj) g.get(cYVar.D())).b().b(cYVar, this);
    }

    public void b(boolean z) {
        this.j = C0353cn.a(this.j, (int) i, z);
    }

    public int c() {
        return this.a;
    }

    public C0333by c(int i) {
        this.b = i;
        b(true);
        return this;
    }

    public bD d(int i) {
        return bD.a(i);
    }

    public void d() {
        this.j = C0353cn.b(this.j, (int) h);
    }

    public boolean e() {
        return C0353cn.a(this.j, (int) h);
    }

    public int f() {
        return this.b;
    }

    public /* synthetic */ cq g() {
        return a();
    }

    public void h() {
        this.j = C0353cn.b(this.j, (int) i);
    }

    public boolean i() {
        return C0353cn.a(this.j, (int) i);
    }

    public void j() {
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Traffic(");
        stringBuilder.append("upload_traffic:");
        stringBuilder.append(this.a);
        stringBuilder.append(", ");
        stringBuilder.append("download_traffic:");
        stringBuilder.append(this.b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
