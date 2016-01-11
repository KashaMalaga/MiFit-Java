package com.c.a.b.a;

import com.c.a.C;
import com.c.a.d.a;
import com.c.a.d.d;
import com.c.a.t;
import com.c.a.w;
import com.c.a.y;
import com.c.a.z;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public final class C0950g extends a {
    private static final Reader a = new C0951h();
    private static final Object b = new Object();
    private final List<Object> c = new ArrayList();

    public C0950g(w wVar) {
        super(a);
        this.c.add(wVar);
    }

    private void a(d dVar) {
        if (f() != dVar) {
            throw new IllegalStateException("Expected " + dVar + " but was " + f());
        }
    }

    private Object q() {
        return this.c.get(this.c.size() - 1);
    }

    private Object r() {
        return this.c.remove(this.c.size() - 1);
    }

    public void a() {
        a(d.BEGIN_ARRAY);
        this.c.add(((t) q()).iterator());
    }

    public void b() {
        a(d.END_ARRAY);
        r();
        r();
    }

    public void c() {
        a(d.BEGIN_OBJECT);
        this.c.add(((z) q()).b().iterator());
    }

    public void close() {
        this.c.clear();
        this.c.add(b);
    }

    public void d() {
        a(d.END_OBJECT);
        r();
        r();
    }

    public boolean e() {
        d f = f();
        return (f == d.END_OBJECT || f == d.END_ARRAY) ? false : true;
    }

    public d f() {
        if (this.c.isEmpty()) {
            return d.END_DOCUMENT;
        }
        Object q = q();
        if (q instanceof Iterator) {
            boolean z = this.c.get(this.c.size() - 2) instanceof z;
            Iterator it = (Iterator) q;
            if (!it.hasNext()) {
                return z ? d.END_OBJECT : d.END_ARRAY;
            } else {
                if (z) {
                    return d.NAME;
                }
                this.c.add(it.next());
                return f();
            }
        } else if (q instanceof z) {
            return d.BEGIN_OBJECT;
        } else {
            if (q instanceof t) {
                return d.BEGIN_ARRAY;
            }
            if (q instanceof C) {
                C c = (C) q;
                if (c.z()) {
                    return d.STRING;
                }
                if (c.b()) {
                    return d.BOOLEAN;
                }
                if (c.y()) {
                    return d.NUMBER;
                }
                throw new AssertionError();
            } else if (q instanceof y) {
                return d.NULL;
            } else {
                if (q == b) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    public String g() {
        a(d.NAME);
        Entry entry = (Entry) ((Iterator) q()).next();
        this.c.add(entry.getValue());
        return (String) entry.getKey();
    }

    public String h() {
        d f = f();
        if (f == d.STRING || f == d.NUMBER) {
            return ((C) r()).d();
        }
        throw new IllegalStateException("Expected " + d.STRING + " but was " + f);
    }

    public boolean i() {
        a(d.BOOLEAN);
        return ((C) r()).n();
    }

    public void j() {
        a(d.NULL);
        r();
    }

    public double k() {
        d f = f();
        if (f == d.NUMBER || f == d.STRING) {
            double e = ((C) q()).e();
            if (p() || !(Double.isNaN(e) || Double.isInfinite(e))) {
                r();
                return e;
            }
            throw new NumberFormatException("JSON forbids NaN and infinities: " + e);
        }
        throw new IllegalStateException("Expected " + d.NUMBER + " but was " + f);
    }

    public long l() {
        d f = f();
        if (f == d.NUMBER || f == d.STRING) {
            long i = ((C) q()).i();
            r();
            return i;
        }
        throw new IllegalStateException("Expected " + d.NUMBER + " but was " + f);
    }

    public int m() {
        d f = f();
        if (f == d.NUMBER || f == d.STRING) {
            int j = ((C) q()).j();
            r();
            return j;
        }
        throw new IllegalStateException("Expected " + d.NUMBER + " but was " + f);
    }

    public void n() {
        if (f() == d.NAME) {
            g();
        } else {
            r();
        }
    }

    public void o() {
        a(d.NAME);
        Entry entry = (Entry) ((Iterator) q()).next();
        this.c.add(entry.getValue());
        this.c.add(new C((String) entry.getKey()));
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
