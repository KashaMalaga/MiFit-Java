package com.c.a;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class t extends w implements Iterable<w> {
    private final List<w> a = new ArrayList();

    t a() {
        t tVar = new t();
        for (w o : this.a) {
            tVar.a(o.o());
        }
        return tVar;
    }

    public w a(int i) {
        return (w) this.a.get(i);
    }

    public void a(t tVar) {
        this.a.addAll(tVar.a);
    }

    public void a(w wVar) {
        Object obj;
        if (wVar == null) {
            obj = y.a;
        }
        this.a.add(obj);
    }

    public int b() {
        return this.a.size();
    }

    public Number c() {
        if (this.a.size() == 1) {
            return ((w) this.a.get(0)).c();
        }
        throw new IllegalStateException();
    }

    public String d() {
        if (this.a.size() == 1) {
            return ((w) this.a.get(0)).d();
        }
        throw new IllegalStateException();
    }

    public double e() {
        if (this.a.size() == 1) {
            return ((w) this.a.get(0)).e();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof t) && ((t) obj).a.equals(this.a));
    }

    public BigDecimal f() {
        if (this.a.size() == 1) {
            return ((w) this.a.get(0)).f();
        }
        throw new IllegalStateException();
    }

    public BigInteger g() {
        if (this.a.size() == 1) {
            return ((w) this.a.get(0)).g();
        }
        throw new IllegalStateException();
    }

    public float h() {
        if (this.a.size() == 1) {
            return ((w) this.a.get(0)).h();
        }
        throw new IllegalStateException();
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public long i() {
        if (this.a.size() == 1) {
            return ((w) this.a.get(0)).i();
        }
        throw new IllegalStateException();
    }

    public Iterator<w> iterator() {
        return this.a.iterator();
    }

    public int j() {
        if (this.a.size() == 1) {
            return ((w) this.a.get(0)).j();
        }
        throw new IllegalStateException();
    }

    public byte k() {
        if (this.a.size() == 1) {
            return ((w) this.a.get(0)).k();
        }
        throw new IllegalStateException();
    }

    public char l() {
        if (this.a.size() == 1) {
            return ((w) this.a.get(0)).l();
        }
        throw new IllegalStateException();
    }

    public short m() {
        if (this.a.size() == 1) {
            return ((w) this.a.get(0)).m();
        }
        throw new IllegalStateException();
    }

    public boolean n() {
        if (this.a.size() == 1) {
            return ((w) this.a.get(0)).n();
        }
        throw new IllegalStateException();
    }

    /* synthetic */ w o() {
        return a();
    }
}
