package com.c.a.b.a;

import com.c.a.N;
import com.c.a.d.a;
import com.c.a.d.d;
import com.c.a.d.e;

final class W extends N<Boolean> {
    W() {
    }

    public Boolean a(a aVar) {
        if (aVar.f() != d.NULL) {
            return aVar.f() == d.STRING ? Boolean.valueOf(Boolean.parseBoolean(aVar.h())) : Boolean.valueOf(aVar.i());
        } else {
            aVar.j();
            return null;
        }
    }

    public void a(e eVar, Boolean bool) {
        if (bool == null) {
            eVar.f();
        } else {
            eVar.a(bool.booleanValue());
        }
    }

    public /* synthetic */ Object b(a aVar) {
        return a(aVar);
    }
}
