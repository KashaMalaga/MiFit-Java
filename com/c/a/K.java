package com.c.a;

import com.c.a.b.G;
import com.c.a.c.a;
import com.c.a.d.e;

final class K<T> extends N<T> {
    private final E<T> a;
    private final v<T> b;
    private final C0993k c;
    private final a<T> d;
    private final P e;
    private N<T> f;

    private K(E<T> e, v<T> vVar, C0993k c0993k, a<T> aVar, P p) {
        this.a = e;
        this.b = vVar;
        this.c = c0993k;
        this.d = aVar;
        this.e = p;
    }

    public static P a(a<?> aVar, Object obj) {
        return new M(obj, aVar, false, null, null);
    }

    public static P a(Class<?> cls, Object obj) {
        return new M(obj, null, false, cls, null);
    }

    private N<T> b() {
        N<T> n = this.f;
        if (n != null) {
            return n;
        }
        n = this.c.a(this.e, this.d);
        this.f = n;
        return n;
    }

    public static P b(a<?> aVar, Object obj) {
        return new M(obj, aVar, aVar.getType() == aVar.getRawType(), null, null);
    }

    public void a(e eVar, T t) {
        if (this.a == null) {
            b().a(eVar, (Object) t);
        } else if (t == null) {
            eVar.f();
        } else {
            G.a(this.a.a(t, this.d.getType(), this.c.c), eVar);
        }
    }

    public T b(com.c.a.d.a aVar) {
        if (this.b == null) {
            return b().b(aVar);
        }
        w a = G.a(aVar);
        return a.s() ? null : this.b.b(a, this.d.getType(), this.c.b);
    }
}
