package b.a;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public class C0311bc extends cC<C0311bc, C0312bd> {
    public static final Map<C0312bd, cI> a;
    private static final C0371de d = new C0371de("PropertyValue");
    private static final cT e = new cT("string_value", C0374dh.i, (short) 1);
    private static final cT f = new cT("long_value", (byte) 10, (short) 2);
    private static /* synthetic */ int[] g;

    static {
        Map enumMap = new EnumMap(C0312bd.class);
        enumMap.put(C0312bd.STRING_VALUE, new cI("string_value", (byte) 3, new cJ(C0374dh.i)));
        enumMap.put(C0312bd.LONG_VALUE, new cI("long_value", (byte) 3, new cJ((byte) 10)));
        a = Collections.unmodifiableMap(enumMap);
        cI.a(C0311bc.class, a);
    }

    public C0311bc(C0311bc c0311bc) {
        super(c0311bc);
    }

    public C0311bc(C0312bd c0312bd, Object obj) {
        super(c0312bd, obj);
    }

    public static C0311bc a(long j) {
        C0311bc c0311bc = new C0311bc();
        c0311bc.b(j);
        return c0311bc;
    }

    public static C0311bc a(String str) {
        C0311bc c0311bc = new C0311bc();
        c0311bc.b(str);
        return c0311bc;
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

    static /* synthetic */ int[] i() {
        int[] iArr = g;
        if (iArr == null) {
            iArr = new int[C0312bd.values().length];
            try {
                iArr[C0312bd.LONG_VALUE.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[C0312bd.STRING_VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            g = iArr;
        }
        return iArr;
    }

    public C0311bc a() {
        return new C0311bc(this);
    }

    public C0312bd a(int i) {
        return C0312bd.a(i);
    }

    protected C0312bd a(short s) {
        return C0312bd.b(s);
    }

    protected cT a(C0312bd c0312bd) {
        switch (C0311bc.i()[c0312bd.ordinal()]) {
            case l.a /*1*/:
                return e;
            case a.k /*2*/:
                return f;
            default:
                throw new IllegalArgumentException("Unknown field id " + c0312bd);
        }
    }

    protected Object a(cY cYVar, cT cTVar) {
        C0312bd a = C0312bd.a(cTVar.c);
        if (a == null) {
            return null;
        }
        switch (C0311bc.i()[a.ordinal()]) {
            case l.a /*1*/:
                if (cTVar.b == e.b) {
                    return cYVar.z();
                }
                C0369dc.a(cYVar, cTVar.b);
                return null;
            case a.k /*2*/:
                if (cTVar.b == f.b) {
                    return Long.valueOf(cYVar.x());
                }
                C0369dc.a(cYVar, cTVar.b);
                return null;
            default:
                throw new IllegalStateException("setField wasn't null, but didn't match any of the case statements!");
        }
    }

    protected Object a(cY cYVar, short s) {
        C0312bd a = C0312bd.a((int) s);
        if (a != null) {
            switch (C0311bc.i()[a.ordinal()]) {
                case l.a /*1*/:
                    return cYVar.z();
                case a.k /*2*/:
                    return Long.valueOf(cYVar.x());
                default:
                    throw new IllegalStateException("setField wasn't null, but didn't match any of the case statements!");
            }
        }
        throw new C0340cZ("Couldn't find a field with field id " + s);
    }

    protected void a(C0312bd c0312bd, Object obj) {
        switch (C0311bc.i()[c0312bd.ordinal()]) {
            case l.a /*1*/:
                if (!(obj instanceof String)) {
                    throw new ClassCastException("Was expecting value of type String for field 'string_value', but got " + obj.getClass().getSimpleName());
                }
                return;
            case a.k /*2*/:
                if (!(obj instanceof Long)) {
                    throw new ClassCastException("Was expecting value of type Long for field 'long_value', but got " + obj.getClass().getSimpleName());
                }
                return;
            default:
                throw new IllegalArgumentException("Unknown field id " + c0312bd);
        }
    }

    public boolean a(C0311bc c0311bc) {
        return c0311bc != null && j() == c0311bc.j() && k().equals(c0311bc.k());
    }

    public int b(C0311bc c0311bc) {
        int a = C0357cs.a((Comparable) j(), (Comparable) c0311bc.j());
        return a == 0 ? C0357cs.a(k(), c0311bc.k()) : a;
    }

    public /* synthetic */ cz b(int i) {
        return a(i);
    }

    protected /* synthetic */ cz b(short s) {
        return a(s);
    }

    public void b(long j) {
        this.c = C0312bd.LONG_VALUE;
        this.b = Long.valueOf(j);
    }

    public void b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.c = C0312bd.STRING_VALUE;
        this.b = str;
    }

    protected C0371de c() {
        return d;
    }

    protected void c(cY cYVar) {
        switch (C0311bc.i()[((C0312bd) this.c).ordinal()]) {
            case l.a /*1*/:
                cYVar.a((String) this.b);
                return;
            case a.k /*2*/:
                cYVar.a(((Long) this.b).longValue());
                return;
            default:
                throw new IllegalStateException("Cannot write union with unknown field " + this.c);
        }
    }

    public String d() {
        if (j() == C0312bd.STRING_VALUE) {
            return (String) k();
        }
        throw new RuntimeException("Cannot get field 'string_value' because union is currently set to " + a((C0312bd) j()).a);
    }

    protected void d(cY cYVar) {
        switch (C0311bc.i()[((C0312bd) this.c).ordinal()]) {
            case l.a /*1*/:
                cYVar.a((String) this.b);
                return;
            case a.k /*2*/:
                cYVar.a(((Long) this.b).longValue());
                return;
            default:
                throw new IllegalStateException("Cannot write union with unknown field " + this.c);
        }
    }

    public long e() {
        if (j() == C0312bd.LONG_VALUE) {
            return ((Long) k()).longValue();
        }
        throw new RuntimeException("Cannot get field 'long_value' because union is currently set to " + a((C0312bd) j()).a);
    }

    public boolean equals(Object obj) {
        return obj instanceof C0311bc ? a((C0311bc) obj) : false;
    }

    public boolean f() {
        return this.c == C0312bd.STRING_VALUE;
    }

    public /* synthetic */ cq g() {
        return a();
    }

    public boolean h() {
        return this.c == C0312bd.LONG_VALUE;
    }

    public int hashCode() {
        return 0;
    }
}
