package com.c.a.b.a;

import com.c.a.C;
import com.c.a.N;
import com.c.a.b.v;
import com.c.a.d.a;
import com.c.a.d.e;
import com.c.a.t;
import com.c.a.w;
import com.c.a.y;
import com.c.a.z;
import java.util.Iterator;
import java.util.Map.Entry;
import kankan.wheel.widget.l;

final class R extends N<w> {
    R() {
    }

    public w a(a aVar) {
        w tVar;
        switch (Z.a[aVar.f().ordinal()]) {
            case l.a /*1*/:
                return new C(new v(aVar.h()));
            case kankan.wheel.widget.a.k /*2*/:
                return new C(Boolean.valueOf(aVar.i()));
            case kankan.wheel.widget.a.l /*3*/:
                return new C(aVar.h());
            case kankan.wheel.widget.a.aQ /*4*/:
                aVar.j();
                return y.a;
            case kankan.wheel.widget.a.X /*5*/:
                tVar = new t();
                aVar.a();
                while (aVar.e()) {
                    tVar.a(a(aVar));
                }
                aVar.b();
                return tVar;
            case kankan.wheel.widget.a.bt /*6*/:
                tVar = new z();
                aVar.c();
                while (aVar.e()) {
                    tVar.a(aVar.g(), a(aVar));
                }
                aVar.d();
                return tVar;
            default:
                throw new IllegalArgumentException();
        }
    }

    public void a(e eVar, w wVar) {
        if (wVar == null || wVar.s()) {
            eVar.f();
        } else if (wVar.r()) {
            C v = wVar.v();
            if (v.y()) {
                eVar.a(v.c());
            } else if (v.b()) {
                eVar.a(v.n());
            } else {
                eVar.b(v.d());
            }
        } else if (wVar.p()) {
            eVar.b();
            Iterator it = wVar.u().iterator();
            while (it.hasNext()) {
                a(eVar, (w) it.next());
            }
            eVar.c();
        } else if (wVar.q()) {
            eVar.d();
            for (Entry entry : wVar.t().b()) {
                eVar.a((String) entry.getKey());
                a(eVar, (w) entry.getValue());
            }
            eVar.e();
        } else {
            throw new IllegalArgumentException("Couldn't write " + wVar.getClass());
        }
    }

    public /* synthetic */ Object b(a aVar) {
        return a(aVar);
    }
}
