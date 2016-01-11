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

public class aE implements cq<aE, aJ>, Serializable, Cloneable {
    public static final Map<aJ, cI> e;
    private static final C0371de f = new C0371de("InstantMsg");
    private static final cT g = new cT(SyncShoesDataService.d, C0374dh.i, (short) 1);
    private static final cT h = new cT("errors", C0374dh.m, (short) 2);
    private static final cT i = new cT("events", C0374dh.m, (short) 3);
    private static final cT j = new cT("game_events", C0374dh.m, (short) 4);
    private static final Map<Class<? extends di>, dj> k = new HashMap();
    public String a;
    public List<M> b;
    public List<T> c;
    public List<T> d;
    private aJ[] l;

    static {
        k.put(dk.class, new aG());
        k.put(dl.class, new aI());
        Map enumMap = new EnumMap(aJ.class);
        enumMap.put(aJ.ID, new cI(SyncShoesDataService.d, (byte) 1, new cJ(C0374dh.i)));
        enumMap.put(aJ.ERRORS, new cI("errors", (byte) 2, new cK(C0374dh.m, new cN(C0374dh.j, M.class))));
        enumMap.put(aJ.EVENTS, new cI("events", (byte) 2, new cK(C0374dh.m, new cN(C0374dh.j, T.class))));
        enumMap.put(aJ.GAME_EVENTS, new cI("game_events", (byte) 2, new cK(C0374dh.m, new cN(C0374dh.j, T.class))));
        e = Collections.unmodifiableMap(enumMap);
        cI.a(aE.class, e);
    }

    public aE() {
        this.l = new aJ[]{aJ.ERRORS, aJ.EVENTS, aJ.GAME_EVENTS};
    }

    public aE(aE aEVar) {
        List arrayList;
        this.l = new aJ[]{aJ.ERRORS, aJ.EVENTS, aJ.GAME_EVENTS};
        if (aEVar.e()) {
            this.a = aEVar.a;
        }
        if (aEVar.k()) {
            arrayList = new ArrayList();
            for (M m : aEVar.b) {
                arrayList.add(new M(m));
            }
            this.b = arrayList;
        }
        if (aEVar.p()) {
            arrayList = new ArrayList();
            for (T t : aEVar.c) {
                arrayList.add(new T(t));
            }
            this.c = arrayList;
        }
        if (aEVar.u()) {
            arrayList = new ArrayList();
            for (T t2 : aEVar.d) {
                arrayList.add(new T(t2));
            }
            this.d = arrayList;
        }
    }

    public aE(String str) {
        this();
        this.a = str;
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

    public aE a() {
        return new aE(this);
    }

    public aE a(String str) {
        this.a = str;
        return this;
    }

    public aE a(List<M> list) {
        this.b = list;
        return this;
    }

    public aJ a(int i) {
        return aJ.a(i);
    }

    public void a(M m) {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        this.b.add(m);
    }

    public void a(T t) {
        if (this.c == null) {
            this.c = new ArrayList();
        }
        this.c.add(t);
    }

    public void a(cY cYVar) {
        ((dj) k.get(cYVar.D())).b().a(cYVar, this);
    }

    public void a(boolean z) {
        if (!z) {
            this.a = null;
        }
    }

    public aE b(List<T> list) {
        this.c = list;
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
    }

    public void b(T t) {
        if (this.d == null) {
            this.d = new ArrayList();
        }
        this.d.add(t);
    }

    public void b(cY cYVar) {
        ((dj) k.get(cYVar.D())).b().b(cYVar, this);
    }

    public void b(boolean z) {
        if (!z) {
            this.b = null;
        }
    }

    public aE c(List<T> list) {
        this.d = list;
        return this;
    }

    public String c() {
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

    public boolean e() {
        return this.a != null;
    }

    public int f() {
        return this.b == null ? 0 : this.b.size();
    }

    public /* synthetic */ cq g() {
        return a();
    }

    public Iterator<M> h() {
        return this.b == null ? null : this.b.iterator();
    }

    public List<M> i() {
        return this.b;
    }

    public void j() {
        this.b = null;
    }

    public boolean k() {
        return this.b != null;
    }

    public int l() {
        return this.c == null ? 0 : this.c.size();
    }

    public Iterator<T> m() {
        return this.c == null ? null : this.c.iterator();
    }

    public List<T> n() {
        return this.c;
    }

    public void o() {
        this.c = null;
    }

    public boolean p() {
        return this.c != null;
    }

    public int q() {
        return this.d == null ? 0 : this.d.size();
    }

    public Iterator<T> r() {
        return this.d == null ? null : this.d.iterator();
    }

    public List<T> s() {
        return this.d;
    }

    public void t() {
        this.d = null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("InstantMsg(");
        stringBuilder.append("id:");
        if (this.a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.a);
        }
        if (k()) {
            stringBuilder.append(", ");
            stringBuilder.append("errors:");
            if (this.b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.b);
            }
        }
        if (p()) {
            stringBuilder.append(", ");
            stringBuilder.append("events:");
            if (this.c == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.c);
            }
        }
        if (u()) {
            stringBuilder.append(", ");
            stringBuilder.append("game_events:");
            if (this.d == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.d);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public boolean u() {
        return this.d != null;
    }

    public void v() {
        if (this.a == null) {
            throw new C0340cZ("Required field 'id' was not present! Struct: " + toString());
        }
    }
}
