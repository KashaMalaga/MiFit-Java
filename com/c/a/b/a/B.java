package com.c.a.b.a;

import com.c.a.G;
import com.c.a.N;
import com.c.a.b.v;
import com.c.a.d.a;
import com.c.a.d.d;
import com.c.a.d.e;
import kankan.wheel.widget.l;

final class B extends N<Number> {
    B() {
    }

    public Number a(a aVar) {
        d f = aVar.f();
        switch (Z.a[f.ordinal()]) {
            case l.a /*1*/:
                return new v(aVar.h());
            case kankan.wheel.widget.a.aQ /*4*/:
                aVar.j();
                return null;
            default:
                throw new G("Expecting number, got: " + f);
        }
    }

    public void a(e eVar, Number number) {
        eVar.a(number);
    }

    public /* synthetic */ Object b(a aVar) {
        return a(aVar);
    }
}
