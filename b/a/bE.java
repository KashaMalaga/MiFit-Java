package b.a;

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

public class bE implements cq<bE, bJ>, Serializable, Cloneable {
    public static final Map<bJ, cI> j;
    private static final C0371de k = new C0371de("UALogEntry");
    private static final cT l = new cT("client_stats", C0374dh.j, (short) 1);
    private static final cT m = new cT("app_info", C0374dh.j, (short) 2);
    private static final cT n = new cT("device_info", C0374dh.j, (short) 3);
    private static final cT o = new cT("misc_info", C0374dh.j, (short) 4);
    private static final cT p = new cT("activate_msg", C0374dh.j, (short) 5);
    private static final cT q = new cT("instant_msgs", C0374dh.m, (short) 6);
    private static final cT r = new cT("sessions", C0374dh.m, (short) 7);
    private static final cT s = new cT("imprint", C0374dh.j, (short) 8);
    private static final cT t = new cT("id_tracking", C0374dh.j, (short) 9);
    private static final Map<Class<? extends di>, dj> u = new HashMap();
    public C0395u a;
    public C0389o b;
    public A c;
    public aQ d;
    public C0383i e;
    public List<aE> f;
    public List<C0327bs> g;
    public C0300as h;
    public C0294am i;
    private bJ[] v;

    static {
        u.put(dk.class, new bG());
        u.put(dl.class, new bI());
        Map enumMap = new EnumMap(bJ.class);
        enumMap.put(bJ.CLIENT_STATS, new cI("client_stats", (byte) 1, new cN(C0374dh.j, C0395u.class)));
        enumMap.put(bJ.APP_INFO, new cI("app_info", (byte) 1, new cN(C0374dh.j, C0389o.class)));
        enumMap.put(bJ.DEVICE_INFO, new cI("device_info", (byte) 1, new cN(C0374dh.j, A.class)));
        enumMap.put(bJ.MISC_INFO, new cI("misc_info", (byte) 1, new cN(C0374dh.j, aQ.class)));
        enumMap.put(bJ.ACTIVATE_MSG, new cI("activate_msg", (byte) 2, new cN(C0374dh.j, C0383i.class)));
        enumMap.put(bJ.INSTANT_MSGS, new cI("instant_msgs", (byte) 2, new cK(C0374dh.m, new cN(C0374dh.j, aE.class))));
        enumMap.put(bJ.SESSIONS, new cI("sessions", (byte) 2, new cK(C0374dh.m, new cN(C0374dh.j, C0327bs.class))));
        enumMap.put(bJ.IMPRINT, new cI("imprint", (byte) 2, new cN(C0374dh.j, C0300as.class)));
        enumMap.put(bJ.ID_TRACKING, new cI("id_tracking", (byte) 2, new cN(C0374dh.j, C0294am.class)));
        j = Collections.unmodifiableMap(enumMap);
        cI.a(bE.class, j);
    }

    public bE() {
        this.v = new bJ[]{bJ.ACTIVATE_MSG, bJ.INSTANT_MSGS, bJ.SESSIONS, bJ.IMPRINT, bJ.ID_TRACKING};
    }

    public bE(bE bEVar) {
        List arrayList;
        this.v = new bJ[]{bJ.ACTIVATE_MSG, bJ.INSTANT_MSGS, bJ.SESSIONS, bJ.IMPRINT, bJ.ID_TRACKING};
        if (bEVar.e()) {
            this.a = new C0395u(bEVar.a);
        }
        if (bEVar.i()) {
            this.b = new C0389o(bEVar.b);
        }
        if (bEVar.l()) {
            this.c = new A(bEVar.c);
        }
        if (bEVar.o()) {
            this.d = new aQ(bEVar.d);
        }
        if (bEVar.r()) {
            this.e = new C0383i(bEVar.e);
        }
        if (bEVar.w()) {
            arrayList = new ArrayList();
            for (aE aEVar : bEVar.f) {
                arrayList.add(new aE(aEVar));
            }
            this.f = arrayList;
        }
        if (bEVar.B()) {
            arrayList = new ArrayList();
            for (C0327bs c0327bs : bEVar.g) {
                arrayList.add(new C0327bs(c0327bs));
            }
            this.g = arrayList;
        }
        if (bEVar.E()) {
            this.h = new C0300as(bEVar.h);
        }
        if (bEVar.H()) {
            this.i = new C0294am(bEVar.i);
        }
    }

    public bE(C0395u c0395u, C0389o c0389o, A a, aQ aQVar) {
        this();
        this.a = c0395u;
        this.b = c0389o;
        this.c = a;
        this.d = aQVar;
    }

    private void a(ObjectInputStream objectInputStream) {
        try {
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

    public C0300as C() {
        return this.h;
    }

    public void D() {
        this.h = null;
    }

    public boolean E() {
        return this.h != null;
    }

    public C0294am F() {
        return this.i;
    }

    public void G() {
        this.i = null;
    }

    public boolean H() {
        return this.i != null;
    }

    public void I() {
        if (this.a == null) {
            throw new C0340cZ("Required field 'client_stats' was not present! Struct: " + toString());
        } else if (this.b == null) {
            throw new C0340cZ("Required field 'app_info' was not present! Struct: " + toString());
        } else if (this.c == null) {
            throw new C0340cZ("Required field 'device_info' was not present! Struct: " + toString());
        } else if (this.d == null) {
            throw new C0340cZ("Required field 'misc_info' was not present! Struct: " + toString());
        } else {
            if (this.a != null) {
                this.a.m();
            }
            if (this.b != null) {
                this.b.H();
            }
            if (this.c != null) {
                this.c.ac();
            }
            if (this.d != null) {
                this.d.K();
            }
            if (this.e != null) {
                this.e.f();
            }
            if (this.h != null) {
                this.h.n();
            }
            if (this.i != null) {
                this.i.p();
            }
        }
    }

    public bE a() {
        return new bE(this);
    }

    public bE a(A a) {
        this.c = a;
        return this;
    }

    public bE a(aQ aQVar) {
        this.d = aQVar;
        return this;
    }

    public bE a(C0294am c0294am) {
        this.i = c0294am;
        return this;
    }

    public bE a(C0300as c0300as) {
        this.h = c0300as;
        return this;
    }

    public bE a(C0383i c0383i) {
        this.e = c0383i;
        return this;
    }

    public bE a(C0389o c0389o) {
        this.b = c0389o;
        return this;
    }

    public bE a(C0395u c0395u) {
        this.a = c0395u;
        return this;
    }

    public bE a(List<aE> list) {
        this.f = list;
        return this;
    }

    public bJ a(int i) {
        return bJ.a(i);
    }

    public void a(aE aEVar) {
        if (this.f == null) {
            this.f = new ArrayList();
        }
        this.f.add(aEVar);
    }

    public void a(C0327bs c0327bs) {
        if (this.g == null) {
            this.g = new ArrayList();
        }
        this.g.add(c0327bs);
    }

    public void a(cY cYVar) {
        ((dj) u.get(cYVar.D())).b().a(cYVar, this);
    }

    public void a(boolean z) {
        if (!z) {
            this.a = null;
        }
    }

    public bE b(List<C0327bs> list) {
        this.g = list;
        return this;
    }

    public /* synthetic */ cz b(int i) {
        return a(i);
    }

    public void b() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
    }

    public void b(cY cYVar) {
        ((dj) u.get(cYVar.D())).b().b(cYVar, this);
    }

    public void b(boolean z) {
        if (!z) {
            this.b = null;
        }
    }

    public C0395u c() {
        return this.a;
    }

    public void c(boolean z) {
        if (!z) {
            this.c = null;
        }
    }

    public void d() {
        this.a = null;
    }

    public void d(boolean z) {
        if (!z) {
            this.d = null;
        }
    }

    public void e(boolean z) {
        if (!z) {
            this.e = null;
        }
    }

    public boolean e() {
        return this.a != null;
    }

    public C0389o f() {
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
        this.b = null;
    }

    public void h(boolean z) {
        if (!z) {
            this.h = null;
        }
    }

    public void i(boolean z) {
        if (!z) {
            this.i = null;
        }
    }

    public boolean i() {
        return this.b != null;
    }

    public A j() {
        return this.c;
    }

    public void k() {
        this.c = null;
    }

    public boolean l() {
        return this.c != null;
    }

    public aQ m() {
        return this.d;
    }

    public void n() {
        this.d = null;
    }

    public boolean o() {
        return this.d != null;
    }

    public C0383i p() {
        return this.e;
    }

    public void q() {
        this.e = null;
    }

    public boolean r() {
        return this.e != null;
    }

    public int s() {
        return this.f == null ? 0 : this.f.size();
    }

    public Iterator<aE> t() {
        return this.f == null ? null : this.f.iterator();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("UALogEntry(");
        stringBuilder.append("client_stats:");
        if (this.a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.a);
        }
        stringBuilder.append(", ");
        stringBuilder.append("app_info:");
        if (this.b == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.b);
        }
        stringBuilder.append(", ");
        stringBuilder.append("device_info:");
        if (this.c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.c);
        }
        stringBuilder.append(", ");
        stringBuilder.append("misc_info:");
        if (this.d == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.d);
        }
        if (r()) {
            stringBuilder.append(", ");
            stringBuilder.append("activate_msg:");
            if (this.e == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.e);
            }
        }
        if (w()) {
            stringBuilder.append(", ");
            stringBuilder.append("instant_msgs:");
            if (this.f == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f);
            }
        }
        if (B()) {
            stringBuilder.append(", ");
            stringBuilder.append("sessions:");
            if (this.g == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.g);
            }
        }
        if (E()) {
            stringBuilder.append(", ");
            stringBuilder.append("imprint:");
            if (this.h == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.h);
            }
        }
        if (H()) {
            stringBuilder.append(", ");
            stringBuilder.append("id_tracking:");
            if (this.i == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.i);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public List<aE> u() {
        return this.f;
    }

    public void v() {
        this.f = null;
    }

    public boolean w() {
        return this.f != null;
    }

    public int x() {
        return this.g == null ? 0 : this.g.size();
    }

    public Iterator<C0327bs> y() {
        return this.g == null ? null : this.g.iterator();
    }

    public List<C0327bs> z() {
        return this.g;
    }
}
