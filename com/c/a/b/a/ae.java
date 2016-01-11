package com.c.a.b.a;

import com.c.a.G;
import com.c.a.N;
import com.c.a.d.a;
import com.c.a.d.d;
import com.c.a.d.e;

final class ae extends N<Number> {
    ae() {
    }

    public Number a(a aVar) {
        if (aVar.f() == d.NULL) {
            aVar.j();
            return null;
        }
        try {
            return Long.valueOf(aVar.l());
        } catch (Throwable e) {
            throw new G(e);
        }
    }

    public void a(e eVar, Number number) {
        eVar.a(number);
    }

    public /* synthetic */ Object b(a aVar) {
        return a(aVar);
    }
}
