package b.a;

import cn.com.smartdevices.bracelet.gps.services.ay;
import cn.com.smartdevices.bracelet.location.e;
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

public class aK implements cq<aK, aP>, Serializable, Cloneable {
    public static final Map<aP, cI> d;
    private static final C0371de e = new C0371de(e.e);
    private static final cT f = new cT("lat", (byte) 4, (short) 1);
    private static final cT g = new cT("lng", (byte) 4, (short) 2);
    private static final cT h = new cT(ay.H, (byte) 10, (short) 3);
    private static final Map<Class<? extends di>, dj> i = new HashMap();
    private static final int j = 0;
    private static final int k = 1;
    private static final int l = 2;
    public double a;
    public double b;
    public long c;
    private byte m;

    static {
        i.put(dk.class, new aM());
        i.put(dl.class, new aO());
        Map enumMap = new EnumMap(aP.class);
        enumMap.put(aP.LAT, new cI("lat", (byte) 1, new cJ((byte) 4)));
        enumMap.put(aP.LNG, new cI("lng", (byte) 1, new cJ((byte) 4)));
        enumMap.put(aP.TS, new cI(ay.H, (byte) 1, new cJ((byte) 10)));
        d = Collections.unmodifiableMap(enumMap);
        cI.a(aK.class, d);
    }

    public aK() {
        this.m = (byte) 0;
    }

    public aK(double d, double d2, long j) {
        this();
        this.a = d;
        a(true);
        this.b = d2;
        b(true);
        this.c = j;
        c(true);
    }

    public aK(aK aKVar) {
        this.m = (byte) 0;
        this.m = aKVar.m;
        this.a = aKVar.a;
        this.b = aKVar.b;
        this.c = aKVar.c;
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

    public aK a() {
        return new aK(this);
    }

    public aK a(double d) {
        this.a = d;
        a(true);
        return this;
    }

    public aK a(long j) {
        this.c = j;
        c(true);
        return this;
    }

    public aP a(int i) {
        return aP.a(i);
    }

    public void a(cY cYVar) {
        ((dj) i.get(cYVar.D())).b().a(cYVar, this);
    }

    public void a(boolean z) {
        this.m = C0353cn.a(this.m, (int) j, z);
    }

    public aK b(double d) {
        this.b = d;
        b(true);
        return this;
    }

    public /* synthetic */ cz b(int i) {
        return a(i);
    }

    public void b() {
        a(false);
        this.a = 0.0d;
        b(false);
        this.b = 0.0d;
        c(false);
        this.c = 0;
    }

    public void b(cY cYVar) {
        ((dj) i.get(cYVar.D())).b().b(cYVar, this);
    }

    public void b(boolean z) {
        this.m = C0353cn.a(this.m, (int) k, z);
    }

    public double c() {
        return this.a;
    }

    public void c(boolean z) {
        this.m = C0353cn.a(this.m, (int) l, z);
    }

    public void d() {
        this.m = C0353cn.b(this.m, (int) j);
    }

    public boolean e() {
        return C0353cn.a(this.m, (int) j);
    }

    public double f() {
        return this.b;
    }

    public /* synthetic */ cq g() {
        return a();
    }

    public void h() {
        this.m = C0353cn.b(this.m, (int) k);
    }

    public boolean i() {
        return C0353cn.a(this.m, (int) k);
    }

    public long j() {
        return this.c;
    }

    public void k() {
        this.m = C0353cn.b(this.m, (int) l);
    }

    public boolean l() {
        return C0353cn.a(this.m, (int) l);
    }

    public void m() {
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Location(");
        stringBuilder.append("lat:");
        stringBuilder.append(this.a);
        stringBuilder.append(", ");
        stringBuilder.append("lng:");
        stringBuilder.append(this.b);
        stringBuilder.append(", ");
        stringBuilder.append("ts:");
        stringBuilder.append(this.c);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
