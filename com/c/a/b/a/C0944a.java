package com.c.a.b.a;

import com.c.a.C0993k;
import com.c.a.N;
import com.c.a.P;
import com.c.a.d.a;
import com.c.a.d.d;
import com.c.a.d.e;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public final class C0944a<E> extends N<Object> {
    public static final P a = new C0945b();
    private final Class<E> b;
    private final N<E> c;

    public C0944a(C0993k c0993k, N<E> n, Class<E> cls) {
        this.c = new C0967x(c0993k, n, cls);
        this.b = cls;
    }

    public void a(e eVar, Object obj) {
        if (obj == null) {
            eVar.f();
            return;
        }
        eVar.b();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.c.a(eVar, Array.get(obj, i));
        }
        eVar.c();
    }

    public Object b(a aVar) {
        if (aVar.f() == d.NULL) {
            aVar.j();
            return null;
        }
        List arrayList = new ArrayList();
        aVar.a();
        while (aVar.e()) {
            arrayList.add(this.c.b(aVar));
        }
        aVar.b();
        Object newInstance = Array.newInstance(this.b, arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }
}
