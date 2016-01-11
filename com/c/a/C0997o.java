package com.c.a;

import com.c.a.d.a;
import com.c.a.d.d;
import com.c.a.d.e;

class C0997o extends N<Number> {
    final /* synthetic */ C0993k a;

    C0997o(C0993k c0993k) {
        this.a = c0993k;
    }

    public Float a(a aVar) {
        if (aVar.f() != d.NULL) {
            return Float.valueOf((float) aVar.k());
        }
        aVar.j();
        return null;
    }

    public void a(e eVar, Number number) {
        if (number == null) {
            eVar.f();
            return;
        }
        this.a.a((double) number.floatValue());
        eVar.a(number);
    }

    public /* synthetic */ Object b(a aVar) {
        return a(aVar);
    }
}
