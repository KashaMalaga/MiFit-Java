package com.c.a.b.a;

import com.c.a.G;
import com.c.a.N;
import com.c.a.d.a;
import com.c.a.d.d;
import com.c.a.d.e;
import java.math.BigDecimal;

final class E extends N<BigDecimal> {
    E() {
    }

    public BigDecimal a(a aVar) {
        if (aVar.f() == d.NULL) {
            aVar.j();
            return null;
        }
        try {
            return new BigDecimal(aVar.h());
        } catch (Throwable e) {
            throw new G(e);
        }
    }

    public void a(e eVar, BigDecimal bigDecimal) {
        eVar.a((Number) bigDecimal);
    }

    public /* synthetic */ Object b(a aVar) {
        return a(aVar);
    }
}
