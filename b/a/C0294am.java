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
import java.util.Map.Entry;

public class C0294am implements cq<C0294am, C0299ar>, Serializable, Cloneable {
    public static final Map<C0299ar, cI> d;
    private static final C0371de e = new C0371de("IdTracking");
    private static final cT f = new cT("snapshots", C0374dh.k, (short) 1);
    private static final cT g = new cT("journals", C0374dh.m, (short) 2);
    private static final cT h = new cT("checksum", C0374dh.i, (short) 3);
    private static final Map<Class<? extends di>, dj> i = new HashMap();
    public Map<String, C0288ag> a;
    public List<C0282aa> b;
    public String c;
    private C0299ar[] j;

    static {
        i.put(dk.class, new C0296ao());
        i.put(dl.class, new C0298aq());
        Map enumMap = new EnumMap(C0299ar.class);
        enumMap.put(C0299ar.SNAPSHOTS, new cI("snapshots", (byte) 1, new cL(C0374dh.k, new cJ(C0374dh.i), new cN(C0374dh.j, C0288ag.class))));
        enumMap.put(C0299ar.JOURNALS, new cI("journals", (byte) 2, new cK(C0374dh.m, new cN(C0374dh.j, C0282aa.class))));
        enumMap.put(C0299ar.CHECKSUM, new cI("checksum", (byte) 2, new cJ(C0374dh.i)));
        d = Collections.unmodifiableMap(enumMap);
        cI.a(C0294am.class, d);
    }

    public C0294am() {
        this.j = new C0299ar[]{C0299ar.JOURNALS, C0299ar.CHECKSUM};
    }

    public C0294am(C0294am c0294am) {
        this.j = new C0299ar[]{C0299ar.JOURNALS, C0299ar.CHECKSUM};
        if (c0294am.f()) {
            Map hashMap = new HashMap();
            for (Entry entry : c0294am.a.entrySet()) {
                hashMap.put((String) entry.getKey(), new C0288ag((C0288ag) entry.getValue()));
            }
            this.a = hashMap;
        }
        if (c0294am.l()) {
            List arrayList = new ArrayList();
            for (C0282aa c0282aa : c0294am.b) {
                arrayList.add(new C0282aa(c0282aa));
            }
            this.b = arrayList;
        }
        if (c0294am.o()) {
            this.c = c0294am.c;
        }
    }

    public C0294am(Map<String, C0288ag> map) {
        this();
        this.a = map;
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

    public C0294am a() {
        return new C0294am(this);
    }

    public C0294am a(String str) {
        this.c = str;
        return this;
    }

    public C0294am a(List<C0282aa> list) {
        this.b = list;
        return this;
    }

    public C0294am a(Map<String, C0288ag> map) {
        this.a = map;
        return this;
    }

    public C0299ar a(int i) {
        return C0299ar.a(i);
    }

    public void a(C0282aa c0282aa) {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        this.b.add(c0282aa);
    }

    public void a(cY cYVar) {
        ((dj) i.get(cYVar.D())).b().a(cYVar, this);
    }

    public void a(String str, C0288ag c0288ag) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        this.a.put(str, c0288ag);
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
        this.b = null;
        this.c = null;
    }

    public void b(cY cYVar) {
        ((dj) i.get(cYVar.D())).b().b(cYVar, this);
    }

    public void b(boolean z) {
        if (!z) {
            this.b = null;
        }
    }

    public int c() {
        return this.a == null ? 0 : this.a.size();
    }

    public void c(boolean z) {
        if (!z) {
            this.c = null;
        }
    }

    public Map<String, C0288ag> d() {
        return this.a;
    }

    public void e() {
        this.a = null;
    }

    public boolean f() {
        return this.a != null;
    }

    public /* synthetic */ cq g() {
        return a();
    }

    public int h() {
        return this.b == null ? 0 : this.b.size();
    }

    public Iterator<C0282aa> i() {
        return this.b == null ? null : this.b.iterator();
    }

    public List<C0282aa> j() {
        return this.b;
    }

    public void k() {
        this.b = null;
    }

    public boolean l() {
        return this.b != null;
    }

    public String m() {
        return this.c;
    }

    public void n() {
        this.c = null;
    }

    public boolean o() {
        return this.c != null;
    }

    public void p() {
        if (this.a == null) {
            throw new C0340cZ("Required field 'snapshots' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("IdTracking(");
        stringBuilder.append("snapshots:");
        if (this.a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.a);
        }
        if (l()) {
            stringBuilder.append(", ");
            stringBuilder.append("journals:");
            if (this.b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.b);
            }
        }
        if (o()) {
            stringBuilder.append(", ");
            stringBuilder.append("checksum:");
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
