package com.c.a.b.a;

import com.c.a.C0993k;
import com.c.a.N;
import com.c.a.b.E;
import com.c.a.d.a;
import com.c.a.d.d;
import com.c.a.d.e;
import java.lang.reflect.Type;
import java.util.Collection;

final class C0947d<E> extends N<Collection<E>> {
    private final N<E> a;
    private final E<? extends Collection<E>> b;

    public C0947d(C0993k c0993k, Type type, N<E> n, E<? extends Collection<E>> e) {
        this.a = new C0967x(c0993k, n, type);
        this.b = e;
    }

    public Collection<E> a(a aVar) {
        if (aVar.f() == d.NULL) {
            aVar.j();
            return null;
        }
        Collection<E> collection = (Collection) this.b.a();
        aVar.a();
        while (aVar.e()) {
            collection.add(this.a.b(aVar));
        }
        aVar.b();
        return collection;
    }

    public void a(e eVar, Collection<E> collection) {
        if (collection == null) {
            eVar.f();
            return;
        }
        eVar.b();
        for (E a : collection) {
            this.a.a(eVar, (Object) a);
        }
        eVar.c();
    }

    public /* synthetic */ Object b(a aVar) {
        return a(aVar);
    }
}
