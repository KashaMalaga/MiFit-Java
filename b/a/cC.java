package b.a;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kankan.wheel.widget.a;

public abstract class cC<T extends cC<?, ?>, F extends cz> implements cq<T, F> {
    private static final Map<Class<? extends di>, dj> a = new HashMap();
    protected Object b;
    protected F c;

    static {
        a.put(dk.class, new cE());
        a.put(dl.class, new cG());
    }

    protected cC() {
        this.c = null;
        this.b = null;
    }

    protected cC(cC<T, F> cCVar) {
        if (cCVar.getClass().equals(getClass())) {
            this.c = cCVar.c;
            this.b = a(cCVar.b);
            return;
        }
        throw new ClassCastException();
    }

    protected cC(F f, Object obj) {
        b(f, obj);
    }

    private static Object a(Object obj) {
        return obj instanceof cq ? ((cq) obj).g() : obj instanceof ByteBuffer ? C0357cs.d((ByteBuffer) obj) : obj instanceof List ? a((List) obj) : obj instanceof Set ? a((Set) obj) : obj instanceof Map ? a((Map) obj) : obj;
    }

    private static List a(List list) {
        List arrayList = new ArrayList(list.size());
        for (Object a : list) {
            arrayList.add(a(a));
        }
        return arrayList;
    }

    private static Map a(Map<Object, Object> map) {
        Map hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            hashMap.put(a(entry.getKey()), a(entry.getValue()));
        }
        return hashMap;
    }

    private static Set a(Set set) {
        Set hashSet = new HashSet();
        for (Object a : set) {
            hashSet.add(a(a));
        }
        return hashSet;
    }

    protected abstract cT a(F f);

    protected abstract Object a(cY cYVar, cT cTVar);

    protected abstract Object a(cY cYVar, short s);

    public void a(int i, Object obj) {
        b(b((short) i), obj);
    }

    public void a(cY cYVar) {
        ((dj) a.get(cYVar.D())).b().a(cYVar, this);
    }

    protected abstract void a(F f, Object obj);

    protected abstract F b(short s);

    public Object b(F f) {
        if (f == this.c) {
            return k();
        }
        throw new IllegalArgumentException("Cannot get the value of field " + f + " because union's set field is " + this.c);
    }

    public final void b() {
        this.c = null;
        this.b = null;
    }

    public void b(cY cYVar) {
        ((dj) a.get(cYVar.D())).b().b(cYVar, this);
    }

    public void b(F f, Object obj) {
        a((cz) f, obj);
        this.c = f;
        this.b = obj;
    }

    protected abstract C0371de c();

    public Object c(int i) {
        return b(b((short) i));
    }

    protected abstract void c(cY cYVar);

    public boolean c(F f) {
        return this.c == f;
    }

    protected abstract void d(cY cYVar);

    public boolean d(int i) {
        return c(b((short) i));
    }

    public F j() {
        return this.c;
    }

    public Object k() {
        return this.b;
    }

    public boolean l() {
        return this.c != null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<");
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append(" ");
        if (j() != null) {
            Object k = k();
            stringBuilder.append(a(j()).a);
            stringBuilder.append(a.ci);
            if (k instanceof ByteBuffer) {
                C0357cs.a((ByteBuffer) k, stringBuilder);
            } else {
                stringBuilder.append(k.toString());
            }
        }
        stringBuilder.append(">");
        return stringBuilder.toString();
    }
}
