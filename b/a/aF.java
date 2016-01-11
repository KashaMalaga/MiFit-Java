package b.a;

import java.util.ArrayList;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class aF extends dk<aE> {
    private aF() {
    }

    public void a(cY cYVar, aE aEVar) {
        cYVar.j();
        while (true) {
            cT l = cYVar.l();
            if (l.b == (byte) 0) {
                cYVar.k();
                aEVar.v();
                return;
            }
            cU p;
            int i;
            T t;
            switch (l.c) {
                case l.a /*1*/:
                    if (l.b != C0374dh.i) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    aEVar.a = cYVar.z();
                    aEVar.a(true);
                    break;
                case a.k /*2*/:
                    if (l.b != C0374dh.m) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    p = cYVar.p();
                    aEVar.b = new ArrayList(p.b);
                    for (i = 0; i < p.b; i++) {
                        M m = new M();
                        m.a(cYVar);
                        aEVar.b.add(m);
                    }
                    cYVar.q();
                    aEVar.b(true);
                    break;
                case a.l /*3*/:
                    if (l.b != C0374dh.m) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    p = cYVar.p();
                    aEVar.c = new ArrayList(p.b);
                    for (i = 0; i < p.b; i++) {
                        t = new T();
                        t.a(cYVar);
                        aEVar.c.add(t);
                    }
                    cYVar.q();
                    aEVar.c(true);
                    break;
                case a.aQ /*4*/:
                    if (l.b != C0374dh.m) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    p = cYVar.p();
                    aEVar.d = new ArrayList(p.b);
                    for (i = 0; i < p.b; i++) {
                        t = new T();
                        t.a(cYVar);
                        aEVar.d.add(t);
                    }
                    cYVar.q();
                    aEVar.d(true);
                    break;
                default:
                    C0369dc.a(cYVar, l.b);
                    break;
            }
            cYVar.m();
        }
    }

    public void b(cY cYVar, aE aEVar) {
        aEVar.v();
        cYVar.a(aE.f);
        if (aEVar.a != null) {
            cYVar.a(aE.g);
            cYVar.a(aEVar.a);
            cYVar.c();
        }
        if (aEVar.b != null && aEVar.k()) {
            cYVar.a(aE.h);
            cYVar.a(new cU(C0374dh.j, aEVar.b.size()));
            for (M b : aEVar.b) {
                b.b(cYVar);
            }
            cYVar.f();
            cYVar.c();
        }
        if (aEVar.c != null && aEVar.p()) {
            cYVar.a(aE.i);
            cYVar.a(new cU(C0374dh.j, aEVar.c.size()));
            for (T b2 : aEVar.c) {
                b2.b(cYVar);
            }
            cYVar.f();
            cYVar.c();
        }
        if (aEVar.d != null && aEVar.u()) {
            cYVar.a(aE.j);
            cYVar.a(new cU(C0374dh.j, aEVar.d.size()));
            for (T b22 : aEVar.d) {
                b22.b(cYVar);
            }
            cYVar.f();
            cYVar.c();
        }
        cYVar.d();
        cYVar.b();
    }
}
