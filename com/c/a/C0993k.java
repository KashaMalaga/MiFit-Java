package com.c.a;

import com.c.a.b.C0975f;
import com.c.a.b.F;
import com.c.a.b.G;
import com.c.a.b.a.C0944a;
import com.c.a.b.a.C0946c;
import com.c.a.b.a.C0948e;
import com.c.a.b.a.C0950g;
import com.c.a.b.a.C0952i;
import com.c.a.b.a.C0954k;
import com.c.a.b.a.C0956m;
import com.c.a.b.a.C0959p;
import com.c.a.b.a.C0963t;
import com.c.a.b.a.C0965v;
import com.c.a.b.a.C0968y;
import com.c.a.b.s;
import com.c.a.c.a;
import com.c.a.d.d;
import com.c.a.d.e;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class C0993k {
    static final boolean a = false;
    private static final String d = ")]}'\n";
    final u b;
    final D c;
    private final ThreadLocal<Map<a<?>, q<?>>> e;
    private final Map<a<?>, N<?>> f;
    private final List<P> g;
    private final C0975f h;
    private final boolean i;
    private final boolean j;
    private final boolean k;
    private final boolean l;

    public C0993k() {
        this(s.a, C0987d.IDENTITY, Collections.emptyMap(), a, a, a, true, a, a, H.DEFAULT, Collections.emptyList());
    }

    C0993k(s sVar, C0986j c0986j, Map<Type, s<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, H h, List<P> list) {
        this.e = new ThreadLocal();
        this.f = Collections.synchronizedMap(new HashMap());
        this.b = new C0994l(this);
        this.c = new C0995m(this);
        this.h = new C0975f(map);
        this.i = z;
        this.k = z3;
        this.j = z4;
        this.l = z5;
        List arrayList = new ArrayList();
        arrayList.add(C0968y.Q);
        arrayList.add(C0956m.a);
        arrayList.add(sVar);
        arrayList.addAll(list);
        arrayList.add(C0968y.x);
        arrayList.add(C0968y.m);
        arrayList.add(C0968y.g);
        arrayList.add(C0968y.i);
        arrayList.add(C0968y.k);
        arrayList.add(C0968y.a(Long.TYPE, Long.class, a(h)));
        arrayList.add(C0968y.a(Double.TYPE, Double.class, a(z6)));
        arrayList.add(C0968y.a(Float.TYPE, Float.class, b(z6)));
        arrayList.add(C0968y.r);
        arrayList.add(C0968y.t);
        arrayList.add(C0968y.z);
        arrayList.add(C0968y.B);
        arrayList.add(C0968y.a(BigDecimal.class, C0968y.v));
        arrayList.add(C0968y.a(BigInteger.class, C0968y.w));
        arrayList.add(C0968y.D);
        arrayList.add(C0968y.F);
        arrayList.add(C0968y.J);
        arrayList.add(C0968y.O);
        arrayList.add(C0968y.H);
        arrayList.add(C0968y.d);
        arrayList.add(C0948e.a);
        arrayList.add(C0968y.M);
        arrayList.add(C0965v.a);
        arrayList.add(C0963t.a);
        arrayList.add(C0968y.K);
        arrayList.add(C0944a.a);
        arrayList.add(C0968y.R);
        arrayList.add(C0968y.b);
        arrayList.add(new C0946c(this.h));
        arrayList.add(new C0954k(this.h, z2));
        arrayList.add(new C0959p(this.h, c0986j, sVar));
        this.g = Collections.unmodifiableList(arrayList);
    }

    private N<Number> a(H h) {
        return h == H.DEFAULT ? C0968y.n : new C0998p(this);
    }

    private N<Number> a(boolean z) {
        return z ? C0968y.p : new C0996n(this);
    }

    private e a(Writer writer) {
        if (this.k) {
            writer.write(d);
        }
        e eVar = new e(writer);
        if (this.l) {
            eVar.c("  ");
        }
        eVar.d(this.i);
        return eVar;
    }

    private void a(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this" + " behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private static void a(Object obj, com.c.a.d.a aVar) {
        if (obj != null) {
            try {
                if (aVar.f() != d.END_DOCUMENT) {
                    throw new x("JSON document was not fully consumed.");
                }
            } catch (Throwable e) {
                throw new G(e);
            } catch (Throwable e2) {
                throw new x(e2);
            }
        }
    }

    private N<Number> b(boolean z) {
        return z ? C0968y.o : new C0997o(this);
    }

    public <T> N<T> a(P p, a<T> aVar) {
        Object obj = null;
        for (P p2 : this.g) {
            if (obj != null) {
                N<T> a = p2.a(this, aVar);
                if (a != null) {
                    return a;
                }
            } else if (p2 == p) {
                obj = 1;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public <T> N<T> a(a<T> aVar) {
        N<T> n = (N) this.f.get(aVar);
        if (n == null) {
            Map map;
            Map map2 = (Map) this.e.get();
            Object obj = null;
            if (map2 == null) {
                HashMap hashMap = new HashMap();
                this.e.set(hashMap);
                map = hashMap;
                obj = 1;
            } else {
                map = map2;
            }
            q qVar = (q) map.get(aVar);
            if (qVar == null) {
                try {
                    q qVar2 = new q();
                    map.put(aVar, qVar2);
                    for (P a : this.g) {
                        n = a.a(this, aVar);
                        if (n != null) {
                            qVar2.a(n);
                            this.f.put(aVar, n);
                            map.remove(aVar);
                            if (obj != null) {
                                this.e.remove();
                            }
                        }
                    }
                    throw new IllegalArgumentException("GSON cannot handle " + aVar);
                } catch (Throwable th) {
                    map.remove(aVar);
                    if (obj != null) {
                        this.e.remove();
                    }
                }
            }
        }
        return n;
    }

    public <T> N<T> a(Class<T> cls) {
        return a(a.get((Class) cls));
    }

    public w a(Object obj) {
        return obj == null ? y.a : a(obj, obj.getClass());
    }

    public w a(Object obj, Type type) {
        e c0952i = new C0952i();
        a(obj, type, c0952i);
        return c0952i.a();
    }

    public <T> T a(com.c.a.d.a aVar, Type type) {
        boolean z = true;
        boolean p = aVar.p();
        aVar.a(true);
        try {
            aVar.f();
            z = a;
            T b = a(a.get(type)).b(aVar);
            aVar.a(p);
            return b;
        } catch (Throwable e) {
            if (z) {
                aVar.a(p);
                return null;
            }
            throw new G(e);
        } catch (Throwable e2) {
            throw new G(e2);
        } catch (Throwable e22) {
            throw new G(e22);
        } catch (Throwable th) {
            aVar.a(p);
        }
    }

    public <T> T a(w wVar, Class<T> cls) {
        return F.a((Class) cls).cast(a(wVar, (Type) cls));
    }

    public <T> T a(w wVar, Type type) {
        return wVar == null ? null : a(new C0950g(wVar), type);
    }

    public <T> T a(Reader reader, Class<T> cls) {
        com.c.a.d.a aVar = new com.c.a.d.a(reader);
        Object a = a(aVar, (Type) cls);
        C0993k.a(a, aVar);
        return F.a((Class) cls).cast(a);
    }

    public <T> T a(Reader reader, Type type) {
        com.c.a.d.a aVar = new com.c.a.d.a(reader);
        Object a = a(aVar, type);
        C0993k.a(a, aVar);
        return a;
    }

    public <T> T a(String str, Class<T> cls) {
        return F.a((Class) cls).cast(a(str, (Type) cls));
    }

    public <T> T a(String str, Type type) {
        return str == null ? null : a(new StringReader(str), type);
    }

    public String a(w wVar) {
        Appendable stringWriter = new StringWriter();
        a(wVar, stringWriter);
        return stringWriter.toString();
    }

    public void a(w wVar, e eVar) {
        boolean g = eVar.g();
        eVar.b(true);
        boolean h = eVar.h();
        eVar.c(this.j);
        boolean i = eVar.i();
        eVar.d(this.i);
        try {
            G.a(wVar, eVar);
            eVar.b(g);
            eVar.c(h);
            eVar.d(i);
        } catch (Throwable e) {
            throw new x(e);
        } catch (Throwable th) {
            eVar.b(g);
            eVar.c(h);
            eVar.d(i);
        }
    }

    public void a(w wVar, Appendable appendable) {
        try {
            a(wVar, a(G.a(appendable)));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void a(Object obj, Appendable appendable) {
        if (obj != null) {
            a(obj, obj.getClass(), appendable);
        } else {
            a(y.a, appendable);
        }
    }

    public void a(Object obj, Type type, e eVar) {
        N a = a(a.get(type));
        boolean g = eVar.g();
        eVar.b(true);
        boolean h = eVar.h();
        eVar.c(this.j);
        boolean i = eVar.i();
        eVar.d(this.i);
        try {
            a.a(eVar, obj);
            eVar.b(g);
            eVar.c(h);
            eVar.d(i);
        } catch (Throwable e) {
            throw new x(e);
        } catch (Throwable th) {
            eVar.b(g);
            eVar.c(h);
            eVar.d(i);
        }
    }

    public void a(Object obj, Type type, Appendable appendable) {
        try {
            a(obj, type, a(G.a(appendable)));
        } catch (Throwable e) {
            throw new x(e);
        }
    }

    public String b(Object obj) {
        return obj == null ? a(y.a) : b(obj, obj.getClass());
    }

    public String b(Object obj, Type type) {
        Appendable stringWriter = new StringWriter();
        a(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public String toString() {
        return "{serializeNulls:" + this.i + "factories:" + this.g + ",instanceCreators:" + this.h + "}";
    }
}
