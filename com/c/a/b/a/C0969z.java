package com.c.a.b.a;

import com.c.a.N;
import com.c.a.d.a;
import com.c.a.d.d;
import com.c.a.d.e;

final class C0969z extends N<Class> {
    C0969z() {
    }

    public Class a(a aVar) {
        if (aVar.f() == d.NULL) {
            aVar.j();
            return null;
        }
        throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
    }

    public void a(e eVar, Class cls) {
        if (cls == null) {
            eVar.f();
            return;
        }
        throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
    }

    public /* synthetic */ Object b(a aVar) {
        return a(aVar);
    }
}
