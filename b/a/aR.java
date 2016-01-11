package b.a;

import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class aR extends dk<aQ> {
    private aR() {
    }

    public void a(cY cYVar, aQ aQVar) {
        cYVar.j();
        while (true) {
            cT l = cYVar.l();
            if (l.b == (byte) 0) {
                cYVar.k();
                aQVar.K();
                return;
            }
            switch (l.c) {
                case l.a /*1*/:
                    if (l.b != (byte) 8) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    aQVar.a = cYVar.w();
                    aQVar.a(true);
                    break;
                case a.k /*2*/:
                    if (l.b != C0374dh.i) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    aQVar.b = cYVar.z();
                    aQVar.b(true);
                    break;
                case a.l /*3*/:
                    if (l.b != C0374dh.i) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    aQVar.c = cYVar.z();
                    aQVar.c(true);
                    break;
                case a.aQ /*4*/:
                    if (l.b != (byte) 4) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    aQVar.d = cYVar.y();
                    aQVar.d(true);
                    break;
                case a.X /*5*/:
                    if (l.b != (byte) 4) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    aQVar.e = cYVar.y();
                    aQVar.e(true);
                    break;
                case a.bt /*6*/:
                    if (l.b != C0374dh.i) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    aQVar.f = cYVar.z();
                    aQVar.f(true);
                    break;
                case a.bc /*7*/:
                    if (l.b != (byte) 8) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    aQVar.g = cYVar.w();
                    aQVar.g(true);
                    break;
                case a.ba /*8*/:
                    if (l.b != C0374dh.i) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    aQVar.h = cYVar.z();
                    aQVar.h(true);
                    break;
                case a.bo /*9*/:
                    if (l.b != (byte) 8) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    aQVar.i = C0382h.a(cYVar.w());
                    aQVar.i(true);
                    break;
                case a.bd /*10*/:
                    if (l.b != C0374dh.i) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    aQVar.j = cYVar.z();
                    aQVar.j(true);
                    break;
                case a.aW /*11*/:
                    if (l.b != C0374dh.j) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    aQVar.k = new bK();
                    aQVar.k.a(cYVar);
                    aQVar.k(true);
                    break;
                default:
                    C0369dc.a(cYVar, l.b);
                    break;
            }
            cYVar.m();
        }
    }

    public void b(cY cYVar, aQ aQVar) {
        aQVar.K();
        cYVar.a(aQ.m);
        if (aQVar.e()) {
            cYVar.a(aQ.n);
            cYVar.a(aQVar.a);
            cYVar.c();
        }
        if (aQVar.b != null && aQVar.i()) {
            cYVar.a(aQ.o);
            cYVar.a(aQVar.b);
            cYVar.c();
        }
        if (aQVar.c != null && aQVar.l()) {
            cYVar.a(aQ.p);
            cYVar.a(aQVar.c);
            cYVar.c();
        }
        if (aQVar.o()) {
            cYVar.a(aQ.q);
            cYVar.a(aQVar.d);
            cYVar.c();
        }
        if (aQVar.r()) {
            cYVar.a(aQ.r);
            cYVar.a(aQVar.e);
            cYVar.c();
        }
        if (aQVar.f != null && aQVar.u()) {
            cYVar.a(aQ.s);
            cYVar.a(aQVar.f);
            cYVar.c();
        }
        if (aQVar.x()) {
            cYVar.a(aQ.t);
            cYVar.a(aQVar.g);
            cYVar.c();
        }
        if (aQVar.h != null && aQVar.A()) {
            cYVar.a(aQ.u);
            cYVar.a(aQVar.h);
            cYVar.c();
        }
        if (aQVar.i != null && aQVar.D()) {
            cYVar.a(aQ.v);
            cYVar.a(aQVar.i.a());
            cYVar.c();
        }
        if (aQVar.j != null && aQVar.G()) {
            cYVar.a(aQ.w);
            cYVar.a(aQVar.j);
            cYVar.c();
        }
        if (aQVar.k != null && aQVar.J()) {
            cYVar.a(aQ.x);
            aQVar.k.b(cYVar);
            cYVar.c();
        }
        cYVar.d();
        cYVar.b();
    }
}
