package com.c.a.b.a;

import com.c.a.G;
import com.c.a.N;
import com.c.a.d.a;
import com.c.a.d.d;
import com.c.a.d.e;
import java.math.BigInteger;

final class F extends N<BigInteger> {
    F() {
    }

    public BigInteger a(a aVar) {
        if (aVar.f() == d.NULL) {
            aVar.j();
            return null;
        }
        try {
            return new BigInteger(aVar.h());
        } catch (Throwable e) {
            throw new G(e);
        }
    }

    public void a(e eVar, BigInteger bigInteger) {
        eVar.a((Number) bigInteger);
    }

    public /* synthetic */ Object b(a aVar) {
        return a(aVar);
    }
}
