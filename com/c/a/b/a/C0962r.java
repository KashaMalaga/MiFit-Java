package com.c.a.b.a;

import com.c.a.G;
import com.c.a.N;
import com.c.a.b.E;
import com.c.a.d.a;
import com.c.a.d.d;
import com.c.a.d.e;
import java.util.Map;

public final class C0962r<T> extends N<T> {
    private final E<T> a;
    private final Map<String, C0960s> b;

    private C0962r(E<T> e, Map<String, C0960s> map) {
        this.a = e;
        this.b = map;
    }

    public void a(e eVar, T t) {
        if (t == null) {
            eVar.f();
            return;
        }
        eVar.d();
        try {
            for (C0960s c0960s : this.b.values()) {
                if (c0960s.h) {
                    eVar.a(c0960s.g);
                    c0960s.a(eVar, (Object) t);
                }
            }
            eVar.e();
        } catch (IllegalAccessException e) {
            throw new AssertionError();
        }
    }

    public T b(a aVar) {
        if (aVar.f() == d.NULL) {
            aVar.j();
            return null;
        }
        T a = this.a.a();
        try {
            aVar.c();
            while (aVar.e()) {
                C0960s c0960s = (C0960s) this.b.get(aVar.g());
                if (c0960s == null || !c0960s.i) {
                    aVar.n();
                } else {
                    c0960s.a(aVar, (Object) a);
                }
            }
            aVar.d();
            return a;
        } catch (Throwable e) {
            throw new G(e);
        } catch (IllegalAccessException e2) {
            throw new AssertionError(e2);
        }
    }
}
