package b.a;

import java.util.ArrayList;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class bF extends dk<bE> {
    private bF() {
    }

    public void a(cY cYVar, bE bEVar) {
        cYVar.j();
        while (true) {
            cT l = cYVar.l();
            if (l.b == (byte) 0) {
                cYVar.k();
                bEVar.I();
                return;
            }
            cU p;
            int i;
            switch (l.c) {
                case l.a /*1*/:
                    if (l.b != C0374dh.j) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    bEVar.a = new C0395u();
                    bEVar.a.a(cYVar);
                    bEVar.a(true);
                    break;
                case a.k /*2*/:
                    if (l.b != C0374dh.j) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    bEVar.b = new C0389o();
                    bEVar.b.a(cYVar);
                    bEVar.b(true);
                    break;
                case a.l /*3*/:
                    if (l.b != C0374dh.j) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    bEVar.c = new A();
                    bEVar.c.a(cYVar);
                    bEVar.c(true);
                    break;
                case a.aQ /*4*/:
                    if (l.b != C0374dh.j) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    bEVar.d = new aQ();
                    bEVar.d.a(cYVar);
                    bEVar.d(true);
                    break;
                case a.X /*5*/:
                    if (l.b != C0374dh.j) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    bEVar.e = new C0383i();
                    bEVar.e.a(cYVar);
                    bEVar.e(true);
                    break;
                case a.bt /*6*/:
                    if (l.b != C0374dh.m) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    p = cYVar.p();
                    bEVar.f = new ArrayList(p.b);
                    for (i = 0; i < p.b; i++) {
                        aE aEVar = new aE();
                        aEVar.a(cYVar);
                        bEVar.f.add(aEVar);
                    }
                    cYVar.q();
                    bEVar.f(true);
                    break;
                case a.bc /*7*/:
                    if (l.b != C0374dh.m) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    p = cYVar.p();
                    bEVar.g = new ArrayList(p.b);
                    for (i = 0; i < p.b; i++) {
                        C0327bs c0327bs = new C0327bs();
                        c0327bs.a(cYVar);
                        bEVar.g.add(c0327bs);
                    }
                    cYVar.q();
                    bEVar.g(true);
                    break;
                case a.ba /*8*/:
                    if (l.b != C0374dh.j) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    bEVar.h = new C0300as();
                    bEVar.h.a(cYVar);
                    bEVar.h(true);
                    break;
                case a.bo /*9*/:
                    if (l.b != C0374dh.j) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    bEVar.i = new C0294am();
                    bEVar.i.a(cYVar);
                    bEVar.i(true);
                    break;
                default:
                    C0369dc.a(cYVar, l.b);
                    break;
            }
            cYVar.m();
        }
    }

    public void b(cY cYVar, bE bEVar) {
        bEVar.I();
        cYVar.a(bE.k);
        if (bEVar.a != null) {
            cYVar.a(bE.l);
            bEVar.a.b(cYVar);
            cYVar.c();
        }
        if (bEVar.b != null) {
            cYVar.a(bE.m);
            bEVar.b.b(cYVar);
            cYVar.c();
        }
        if (bEVar.c != null) {
            cYVar.a(bE.n);
            bEVar.c.b(cYVar);
            cYVar.c();
        }
        if (bEVar.d != null) {
            cYVar.a(bE.o);
            bEVar.d.b(cYVar);
            cYVar.c();
        }
        if (bEVar.e != null && bEVar.r()) {
            cYVar.a(bE.p);
            bEVar.e.b(cYVar);
            cYVar.c();
        }
        if (bEVar.f != null && bEVar.w()) {
            cYVar.a(bE.q);
            cYVar.a(new cU(C0374dh.j, bEVar.f.size()));
            for (aE b : bEVar.f) {
                b.b(cYVar);
            }
            cYVar.f();
            cYVar.c();
        }
        if (bEVar.g != null && bEVar.B()) {
            cYVar.a(bE.r);
            cYVar.a(new cU(C0374dh.j, bEVar.g.size()));
            for (C0327bs b2 : bEVar.g) {
                b2.b(cYVar);
            }
            cYVar.f();
            cYVar.c();
        }
        if (bEVar.h != null && bEVar.E()) {
            cYVar.a(bE.s);
            bEVar.h.b(cYVar);
            cYVar.c();
        }
        if (bEVar.i != null && bEVar.H()) {
            cYVar.a(bE.t);
            bEVar.i.b(cYVar);
            cYVar.c();
        }
        cYVar.d();
        cYVar.b();
    }
}
