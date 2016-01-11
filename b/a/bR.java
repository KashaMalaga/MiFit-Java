package b.a;

import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class bR extends dk<bQ> {
    private bR() {
    }

    public void a(cY cYVar, bQ bQVar) {
        cYVar.j();
        while (true) {
            cT l = cYVar.l();
            if (l.b == (byte) 0) {
                cYVar.k();
                if (!bQVar.o()) {
                    throw new C0340cZ("Required field 'serial_num' was not found in serialized data! Struct: " + toString());
                } else if (!bQVar.r()) {
                    throw new C0340cZ("Required field 'ts_secs' was not found in serialized data! Struct: " + toString());
                } else if (bQVar.u()) {
                    bQVar.F();
                    return;
                } else {
                    throw new C0340cZ("Required field 'length' was not found in serialized data! Struct: " + toString());
                }
            }
            switch (l.c) {
                case l.a /*1*/:
                    if (l.b != C0374dh.i) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    bQVar.a = cYVar.z();
                    bQVar.a(true);
                    break;
                case a.k /*2*/:
                    if (l.b != C0374dh.i) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    bQVar.b = cYVar.z();
                    bQVar.b(true);
                    break;
                case a.l /*3*/:
                    if (l.b != C0374dh.i) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    bQVar.c = cYVar.z();
                    bQVar.c(true);
                    break;
                case a.aQ /*4*/:
                    if (l.b != (byte) 8) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    bQVar.d = cYVar.w();
                    bQVar.d(true);
                    break;
                case a.X /*5*/:
                    if (l.b != (byte) 8) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    bQVar.e = cYVar.w();
                    bQVar.e(true);
                    break;
                case a.bt /*6*/:
                    if (l.b != (byte) 8) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    bQVar.f = cYVar.w();
                    bQVar.f(true);
                    break;
                case a.bc /*7*/:
                    if (l.b != C0374dh.i) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    bQVar.g = cYVar.A();
                    bQVar.g(true);
                    break;
                case a.ba /*8*/:
                    if (l.b != C0374dh.i) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    bQVar.h = cYVar.z();
                    bQVar.h(true);
                    break;
                case a.bo /*9*/:
                    if (l.b != C0374dh.i) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    bQVar.i = cYVar.z();
                    bQVar.i(true);
                    break;
                default:
                    C0369dc.a(cYVar, l.b);
                    break;
            }
            cYVar.m();
        }
    }

    public void b(cY cYVar, bQ bQVar) {
        bQVar.F();
        cYVar.a(bQ.k);
        if (bQVar.a != null) {
            cYVar.a(bQ.l);
            cYVar.a(bQVar.a);
            cYVar.c();
        }
        if (bQVar.b != null) {
            cYVar.a(bQ.m);
            cYVar.a(bQVar.b);
            cYVar.c();
        }
        if (bQVar.c != null) {
            cYVar.a(bQ.n);
            cYVar.a(bQVar.c);
            cYVar.c();
        }
        cYVar.a(bQ.o);
        cYVar.a(bQVar.d);
        cYVar.c();
        cYVar.a(bQ.p);
        cYVar.a(bQVar.e);
        cYVar.c();
        cYVar.a(bQ.q);
        cYVar.a(bQVar.f);
        cYVar.c();
        if (bQVar.g != null) {
            cYVar.a(bQ.r);
            cYVar.a(bQVar.g);
            cYVar.c();
        }
        if (bQVar.h != null) {
            cYVar.a(bQ.s);
            cYVar.a(bQVar.h);
            cYVar.c();
        }
        if (bQVar.i != null) {
            cYVar.a(bQ.t);
            cYVar.a(bQVar.i);
            cYVar.c();
        }
        cYVar.d();
        cYVar.b();
    }
}
