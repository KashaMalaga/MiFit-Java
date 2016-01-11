package com.c.a;

import com.c.a.d.a;
import com.c.a.d.d;
import com.c.a.d.e;

class C0996n extends N<Number> {
    final /* synthetic */ C0993k a;

    C0996n(C0993k c0993k) {
        this.a = c0993k;
    }

    public Double a(a aVar) {
        if (aVar.f() != d.NULL) {
            return Double.valueOf(aVar.k());
        }
        aVar.j();
        return null;
    }

    public void a(e eVar, Number number) {
        if (number == null) {
            eVar.f();
            return;
        }
        this.a.a(number.doubleValue());
        eVar.a(number);
    }

    public /* synthetic */ Object b(a aVar) {
        return a(aVar);
    }
}
