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

public class C0395u implements cq<C0395u, C0400z>, Serializable, Cloneable {
    public static final Map<C0400z, cI> d;
    private static final C0371de e = new C0371de("ClientStats");
    private static final cT f = new cT("successful_requests", (byte) 8, (short) 1);
    private static final cT g = new cT("failed_requests", (byte) 8, (short) 2);
    private static final cT h = new cT("last_request_spent_ms", (byte) 8, (short) 3);
    private static final Map<Class<? extends di>, dj> i = new HashMap();
    private static final int j = 0;
    private static final int k = 1;
    private static final int l = 2;
    public int a;
    public int b;
    public int c;
    private byte m;
    private C0400z[] n;

    static {
        i.put(dk.class, new C0397w());
        i.put(dl.class, new C0399y());
        Map enumMap = new EnumMap(C0400z.class);
        enumMap.put(C0400z.SUCCESSFUL_REQUESTS, new cI("successful_requests", (byte) 1, new cJ((byte) 8)));
        enumMap.put(C0400z.FAILED_REQUESTS, new cI("failed_requests", (byte) 1, new cJ((byte) 8)));
        enumMap.put(C0400z.LAST_REQUEST_SPENT_MS, new cI("last_request_spent_ms", (byte) 2, new cJ((byte) 8)));
        d = Collections.unmodifiableMap(enumMap);
        cI.a(C0395u.class, d);
    }

    public C0395u() {
        this.m = (byte) 0;
        C0400z[] c0400zArr = new C0400z[k];
        c0400zArr[j] = C0400z.LAST_REQUEST_SPENT_MS;
        this.n = c0400zArr;
        this.a = j;
        this.b = j;
    }

    public C0395u(int i, int i2) {
        this();
        this.a = i;
        a(true);
        this.b = i2;
        b(true);
    }

    public C0395u(C0395u c0395u) {
        this.m = (byte) 0;
        C0400z[] c0400zArr = new C0400z[k];
        c0400zArr[j] = C0400z.LAST_REQUEST_SPENT_MS;
        this.n = c0400zArr;
        this.m = c0395u.m;
        this.a = c0395u.a;
        this.b = c0395u.b;
        this.c = c0395u.c;
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

    public C0395u a() {
        return new C0395u(this);
    }

    public C0395u a(int i) {
        this.a = i;
        a(true);
        return this;
    }

    public void a(cY cYVar) {
        ((dj) i.get(cYVar.D())).b().a(cYVar, this);
    }

    public void a(boolean z) {
        this.m = C0353cn.a(this.m, (int) j, z);
    }

    public /* synthetic */ cz b(int i) {
        return e(i);
    }

    public void b() {
        this.a = j;
        this.b = j;
        c(false);
        this.c = j;
    }

    public void b(cY cYVar) {
        ((dj) i.get(cYVar.D())).b().b(cYVar, this);
    }

    public void b(boolean z) {
        this.m = C0353cn.a(this.m, (int) k, z);
    }

    public int c() {
        return this.a;
    }

    public C0395u c(int i) {
        this.b = i;
        b(true);
        return this;
    }

    public void c(boolean z) {
        this.m = C0353cn.a(this.m, (int) l, z);
    }

    public C0395u d(int i) {
        this.c = i;
        c(true);
        return this;
    }

    public void d() {
        this.m = C0353cn.b(this.m, (int) j);
    }

    public C0400z e(int i) {
        return C0400z.a(i);
    }

    public boolean e() {
        return C0353cn.a(this.m, (int) j);
    }

    public int f() {
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

    public int j() {
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
        StringBuilder stringBuilder = new StringBuilder("ClientStats(");
        stringBuilder.append("successful_requests:");
        stringBuilder.append(this.a);
        stringBuilder.append(", ");
        stringBuilder.append("failed_requests:");
        stringBuilder.append(this.b);
        if (l()) {
            stringBuilder.append(", ");
            stringBuilder.append("last_request_spent_ms:");
            stringBuilder.append(this.c);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
