package com.c.a.d;

import com.c.a.b.a.C0950g;
import com.c.a.b.u;

final class b extends u {
    b() {
    }

    public void a(a aVar) {
        if (aVar instanceof C0950g) {
            ((C0950g) aVar).o();
            return;
        }
        int a = aVar.J;
        if (a == 0) {
            a = aVar.o();
        }
        if (a == 13) {
            aVar.J = 9;
        } else if (a == 12) {
            aVar.J = 8;
        } else if (a == 14) {
            aVar.J = 10;
        } else {
            throw new IllegalStateException("Expected a name but was " + aVar.f() + " " + " at line " + aVar.u() + " column " + aVar.v());
        }
    }
}
