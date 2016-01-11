package b.a;

import cn.com.smartdevices.bracelet.C0410c;
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

public class M implements cq<M, R>, Serializable, Cloneable {
    public static final Map<R, cI> d;
    private static final C0371de e = new C0371de(C0410c.j);
    private static final cT f = new cT(ay.H, (byte) 10, (short) 1);
    private static final cT g = new cT("context", C0374dh.i, (short) 2);
    private static final cT h = new cT(o.L, (byte) 8, (short) 3);
    private static final Map<Class<? extends di>, dj> i = new HashMap();
    private static final int j = 0;
    public long a;
    public String b;
    public S c;
    private byte k;
    private R[] l;

    static {
        i.put(dk.class, new O());
        i.put(dl.class, new Q());
        Map enumMap = new EnumMap(R.class);
        enumMap.put(R.TS, new cI(ay.H, (byte) 1, new cJ((byte) 10)));
        enumMap.put(R.CONTEXT, new cI("context", (byte) 1, new cJ(C0374dh.i)));
        enumMap.put(R.SOURCE, new cI(o.L, (byte) 2, new cH(C0374dh.n, S.class)));
        d = Collections.unmodifiableMap(enumMap);
        cI.a(M.class, d);
    }

    public M() {
        this.k = (byte) 0;
        this.l = new R[]{R.SOURCE};
    }

    public M(long j, String str) {
        this();
        this.a = j;
        b(true);
        this.b = str;
    }

    public M(M m) {
        this.k = (byte) 0;
        this.l = new R[]{R.SOURCE};
        this.k = m.k;
        this.a = m.a;
        if (m.i()) {
            this.b = m.b;
        }
        if (m.l()) {
            this.c = m.c;
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

    public M a() {
        return new M(this);
    }

    public M a(long j) {
        this.a = j;
        b(true);
        return this;
    }

    public M a(S s) {
        this.c = s;
        return this;
    }

    public M a(String str) {
        this.b = str;
        return this;
    }

    public R a(int i) {
        return R.a(i);
    }

    public void a(cY cYVar) {
        ((dj) i.get(cYVar.D())).b().a(cYVar, this);
    }

    public /* synthetic */ cz b(int i) {
        return a(i);
    }

    public void b() {
        b(false);
        this.a = 0;
        this.b = null;
        this.c = null;
    }

    public void b(cY cYVar) {
        ((dj) i.get(cYVar.D())).b().b(cYVar, this);
    }

    public void b(boolean z) {
        this.k = C0353cn.a(this.k, 0, z);
    }

    public long c() {
        return this.a;
    }

    public void c(boolean z) {
        if (!z) {
            this.b = null;
        }
    }

    public void d() {
        this.k = C0353cn.b(this.k, 0);
    }

    public void d(boolean z) {
        if (!z) {
            this.c = null;
        }
    }

    public boolean e() {
        return C0353cn.a(this.k, 0);
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

    public S j() {
        return this.c;
    }

    public void k() {
        this.c = null;
    }

    public boolean l() {
        return this.c != null;
    }

    public void m() {
        if (this.b == null) {
            throw new C0340cZ("Required field 'context' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Error(");
        stringBuilder.append("ts:");
        stringBuilder.append(this.a);
        stringBuilder.append(", ");
        stringBuilder.append("context:");
        if (this.b == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.b);
        }
        if (l()) {
            stringBuilder.append(", ");
            stringBuilder.append("source:");
            if (this.c == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.c);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
