package b.a;

import cn.com.smartdevices.bracelet.shoes.sync.SyncShoesDataService;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class C0327bs implements cq<C0327bs, C0332bx>, Serializable, Cloneable {
    public static final Map<C0332bx, cI> h;
    private static final C0371de i = new C0371de("Session");
    private static final cT j = new cT(SyncShoesDataService.d, C0374dh.i, (short) 1);
    private static final cT k = new cT("start_time", (byte) 10, (short) 2);
    private static final cT l = new cT("end_time", (byte) 10, (short) 3);
    private static final cT m = new cT("duration", (byte) 10, (short) 4);
    private static final cT n = new cT("pages", C0374dh.m, (short) 5);
    private static final cT o = new cT("locations", C0374dh.m, (short) 6);
    private static final cT p = new cT("traffic", C0374dh.j, (short) 7);
    private static final Map<Class<? extends di>, dj> q = new HashMap();
    private static final int r = 0;
    private static final int s = 1;
    private static final int t = 2;
    public String a;
    public long b;
    public long c;
    public long d;
    public List<aW> e;
    public List<aK> f;
    public C0333by g;
    private byte u;
    private C0332bx[] v;

    static {
        q.put(dk.class, new C0329bu());
        q.put(dl.class, new C0331bw());
        Map enumMap = new EnumMap(C0332bx.class);
        enumMap.put(C0332bx.ID, new cI(SyncShoesDataService.d, (byte) 1, new cJ(C0374dh.i)));
        enumMap.put(C0332bx.START_TIME, new cI("start_time", (byte) 1, new cJ((byte) 10)));
        enumMap.put(C0332bx.END_TIME, new cI("end_time", (byte) 1, new cJ((byte) 10)));
        enumMap.put(C0332bx.DURATION, new cI("duration", (byte) 1, new cJ((byte) 10)));
        enumMap.put(C0332bx.PAGES, new cI("pages", (byte) 2, new cK(C0374dh.m, new cN(C0374dh.j, aW.class))));
        enumMap.put(C0332bx.LOCATIONS, new cI("locations", (byte) 2, new cK(C0374dh.m, new cN(C0374dh.j, aK.class))));
        enumMap.put(C0332bx.TRAFFIC, new cI("traffic", (byte) 2, new cN(C0374dh.j, C0333by.class)));
        h = Collections.unmodifiableMap(enumMap);
        cI.a(C0327bs.class, h);
    }

    public C0327bs() {
        this.u = (byte) 0;
        this.v = new C0332bx[]{C0332bx.PAGES, C0332bx.LOCATIONS, C0332bx.TRAFFIC};
    }

    public C0327bs(C0327bs c0327bs) {
        List arrayList;
        this.u = (byte) 0;
        this.v = new C0332bx[]{C0332bx.PAGES, C0332bx.LOCATIONS, C0332bx.TRAFFIC};
        this.u = c0327bs.u;
        if (c0327bs.e()) {
            this.a = c0327bs.a;
        }
        this.b = c0327bs.b;
        this.c = c0327bs.c;
        this.d = c0327bs.d;
        if (c0327bs.t()) {
            arrayList = new ArrayList();
            for (aW aWVar : c0327bs.e) {
                arrayList.add(new aW(aWVar));
            }
            this.e = arrayList;
        }
        if (c0327bs.y()) {
            arrayList = new ArrayList();
            for (aK aKVar : c0327bs.f) {
                arrayList.add(new aK(aKVar));
            }
            this.f = arrayList;
        }
        if (c0327bs.B()) {
            this.g = new C0333by(c0327bs.g);
        }
    }

    public C0327bs(String str, long j, long j2, long j3) {
        this();
        this.a = str;
        this.b = j;
        b(true);
        this.c = j2;
        c(true);
        this.d = j3;
        d(true);
    }

    private void a(ObjectInputStream objectInputStream) {
        try {
            this.u = (byte) 0;
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

    public void A() {
        this.g = null;
    }

    public boolean B() {
        return this.g != null;
    }

    public void C() {
        if (this.a == null) {
            throw new C0340cZ("Required field 'id' was not present! Struct: " + toString());
        } else if (this.g != null) {
            this.g.j();
        }
    }

    public C0327bs a() {
        return new C0327bs(this);
    }

    public C0327bs a(long j) {
        this.b = j;
        b(true);
        return this;
    }

    public C0327bs a(C0333by c0333by) {
        this.g = c0333by;
        return this;
    }

    public C0327bs a(String str) {
        this.a = str;
        return this;
    }

    public C0327bs a(List<aW> list) {
        this.e = list;
        return this;
    }

    public C0332bx a(int i) {
        return C0332bx.a(i);
    }

    public void a(aK aKVar) {
        if (this.f == null) {
            this.f = new ArrayList();
        }
        this.f.add(aKVar);
    }

    public void a(aW aWVar) {
        if (this.e == null) {
            this.e = new ArrayList();
        }
        this.e.add(aWVar);
    }

    public void a(cY cYVar) {
        ((dj) q.get(cYVar.D())).b().a(cYVar, this);
    }

    public void a(boolean z) {
        if (!z) {
            this.a = null;
        }
    }

    public C0327bs b(long j) {
        this.c = j;
        c(true);
        return this;
    }

    public C0327bs b(List<aK> list) {
        this.f = list;
        return this;
    }

    public /* synthetic */ cz b(int i) {
        return a(i);
    }

    public void b() {
        this.a = null;
        b(false);
        this.b = 0;
        c(false);
        this.c = 0;
        d(false);
        this.d = 0;
        this.e = null;
        this.f = null;
        this.g = null;
    }

    public void b(cY cYVar) {
        ((dj) q.get(cYVar.D())).b().b(cYVar, this);
    }

    public void b(boolean z) {
        this.u = C0353cn.a(this.u, (int) r, z);
    }

    public C0327bs c(long j) {
        this.d = j;
        d(true);
        return this;
    }

    public String c() {
        return this.a;
    }

    public void c(boolean z) {
        this.u = C0353cn.a(this.u, (int) s, z);
    }

    public void d() {
        this.a = null;
    }

    public void d(boolean z) {
        this.u = C0353cn.a(this.u, (int) t, z);
    }

    public void e(boolean z) {
        if (!z) {
            this.e = null;
        }
    }

    public boolean e() {
        return this.a != null;
    }

    public long f() {
        return this.b;
    }

    public void f(boolean z) {
        if (!z) {
            this.f = null;
        }
    }

    public /* synthetic */ cq g() {
        return a();
    }

    public void g(boolean z) {
        if (!z) {
            this.g = null;
        }
    }

    public void h() {
        this.u = C0353cn.b(this.u, (int) r);
    }

    public boolean i() {
        return C0353cn.a(this.u, (int) r);
    }

    public long j() {
        return this.c;
    }

    public void k() {
        this.u = C0353cn.b(this.u, (int) s);
    }

    public boolean l() {
        return C0353cn.a(this.u, (int) s);
    }

    public long m() {
        return this.d;
    }

    public void n() {
        this.u = C0353cn.b(this.u, (int) t);
    }

    public boolean o() {
        return C0353cn.a(this.u, (int) t);
    }

    public int p() {
        return this.e == null ? r : this.e.size();
    }

    public Iterator<aW> q() {
        return this.e == null ? null : this.e.iterator();
    }

    public List<aW> r() {
        return this.e;
    }

    public void s() {
        this.e = null;
    }

    public boolean t() {
        return this.e != null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Session(");
        stringBuilder.append("id:");
        if (this.a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.a);
        }
        stringBuilder.append(", ");
        stringBuilder.append("start_time:");
        stringBuilder.append(this.b);
        stringBuilder.append(", ");
        stringBuilder.append("end_time:");
        stringBuilder.append(this.c);
        stringBuilder.append(", ");
        stringBuilder.append("duration:");
        stringBuilder.append(this.d);
        if (t()) {
            stringBuilder.append(", ");
            stringBuilder.append("pages:");
            if (this.e == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.e);
            }
        }
        if (y()) {
            stringBuilder.append(", ");
            stringBuilder.append("locations:");
            if (this.f == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f);
            }
        }
        if (B()) {
            stringBuilder.append(", ");
            stringBuilder.append("traffic:");
            if (this.g == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.g);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public int u() {
        return this.f == null ? r : this.f.size();
    }

    public Iterator<aK> v() {
        return this.f == null ? null : this.f.iterator();
    }

    public List<aK> w() {
        return this.f;
    }

    public void x() {
        this.f = null;
    }

    public boolean y() {
        return this.f != null;
    }

    public C0333by z() {
        return this.g;
    }
}
