package b.a;

import java.util.ArrayList;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class C0328bt extends dk<C0327bs> {
    private C0328bt() {
    }

    public void a(cY cYVar, C0327bs c0327bs) {
        cYVar.j();
        while (true) {
            cT l = cYVar.l();
            if (l.b == (byte) 0) {
                cYVar.k();
                if (!c0327bs.i()) {
                    throw new C0340cZ("Required field 'start_time' was not found in serialized data! Struct: " + toString());
                } else if (!c0327bs.l()) {
                    throw new C0340cZ("Required field 'end_time' was not found in serialized data! Struct: " + toString());
                } else if (c0327bs.o()) {
                    c0327bs.C();
                    return;
                } else {
                    throw new C0340cZ("Required field 'duration' was not found in serialized data! Struct: " + toString());
                }
            }
            cU p;
            int i;
            switch (l.c) {
                case l.a /*1*/:
                    if (l.b != C0374dh.i) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    c0327bs.a = cYVar.z();
                    c0327bs.a(true);
                    break;
                case a.k /*2*/:
                    if (l.b != (byte) 10) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    c0327bs.b = cYVar.x();
                    c0327bs.b(true);
                    break;
                case a.l /*3*/:
                    if (l.b != (byte) 10) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    c0327bs.c = cYVar.x();
                    c0327bs.c(true);
                    break;
                case a.aQ /*4*/:
                    if (l.b != (byte) 10) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    c0327bs.d = cYVar.x();
                    c0327bs.d(true);
                    break;
                case a.X /*5*/:
                    if (l.b != C0374dh.m) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    p = cYVar.p();
                    c0327bs.e = new ArrayList(p.b);
                    for (i = 0; i < p.b; i++) {
                        aW aWVar = new aW();
                        aWVar.a(cYVar);
                        c0327bs.e.add(aWVar);
                    }
                    cYVar.q();
                    c0327bs.e(true);
                    break;
                case a.bt /*6*/:
                    if (l.b != C0374dh.m) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    p = cYVar.p();
                    c0327bs.f = new ArrayList(p.b);
                    for (i = 0; i < p.b; i++) {
                        aK aKVar = new aK();
                        aKVar.a(cYVar);
                        c0327bs.f.add(aKVar);
                    }
                    cYVar.q();
                    c0327bs.f(true);
                    break;
                case a.bc /*7*/:
                    if (l.b != C0374dh.j) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    c0327bs.g = new C0333by();
                    c0327bs.g.a(cYVar);
                    c0327bs.g(true);
                    break;
                default:
                    C0369dc.a(cYVar, l.b);
                    break;
            }
            cYVar.m();
        }
    }

    public void b(cY cYVar, C0327bs c0327bs) {
        c0327bs.C();
        cYVar.a(C0327bs.i);
        if (c0327bs.a != null) {
            cYVar.a(C0327bs.j);
            cYVar.a(c0327bs.a);
            cYVar.c();
        }
        cYVar.a(C0327bs.k);
        cYVar.a(c0327bs.b);
        cYVar.c();
        cYVar.a(C0327bs.l);
        cYVar.a(c0327bs.c);
        cYVar.c();
        cYVar.a(C0327bs.m);
        cYVar.a(c0327bs.d);
        cYVar.c();
        if (c0327bs.e != null && c0327bs.t()) {
            cYVar.a(C0327bs.n);
            cYVar.a(new cU(C0374dh.j, c0327bs.e.size()));
            for (aW b : c0327bs.e) {
                b.b(cYVar);
            }
            cYVar.f();
            cYVar.c();
        }
        if (c0327bs.f != null && c0327bs.y()) {
            cYVar.a(C0327bs.o);
            cYVar.a(new cU(C0374dh.j, c0327bs.f.size()));
            for (aK b2 : c0327bs.f) {
                b2.b(cYVar);
            }
            cYVar.f();
            cYVar.c();
        }
        if (c0327bs.g != null && c0327bs.B()) {
            cYVar.a(C0327bs.p);
            c0327bs.g.b(cYVar);
            cYVar.c();
        }
        cYVar.d();
        cYVar.b();
    }
}
