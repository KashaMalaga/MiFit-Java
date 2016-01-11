package b.a;

import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class C0283ab extends dk<C0282aa> {
    private C0283ab() {
    }

    public void a(cY cYVar, C0282aa c0282aa) {
        cYVar.j();
        while (true) {
            cT l = cYVar.l();
            if (l.b == (byte) 0) {
                cYVar.k();
                if (c0282aa.o()) {
                    c0282aa.p();
                    return;
                }
                throw new C0340cZ("Required field 'ts' was not found in serialized data! Struct: " + toString());
            }
            switch (l.c) {
                case l.a /*1*/:
                    if (l.b != C0374dh.i) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    c0282aa.a = cYVar.z();
                    c0282aa.a(true);
                    break;
                case a.k /*2*/:
                    if (l.b != C0374dh.i) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    c0282aa.b = cYVar.z();
                    c0282aa.b(true);
                    break;
                case a.l /*3*/:
                    if (l.b != C0374dh.i) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    c0282aa.c = cYVar.z();
                    c0282aa.c(true);
                    break;
                case a.aQ /*4*/:
                    if (l.b != (byte) 10) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    c0282aa.d = cYVar.x();
                    c0282aa.d(true);
                    break;
                default:
                    C0369dc.a(cYVar, l.b);
                    break;
            }
            cYVar.m();
        }
    }

    public void b(cY cYVar, C0282aa c0282aa) {
        c0282aa.p();
        cYVar.a(C0282aa.f);
        if (c0282aa.a != null) {
            cYVar.a(C0282aa.g);
            cYVar.a(c0282aa.a);
            cYVar.c();
        }
        if (c0282aa.b != null && c0282aa.i()) {
            cYVar.a(C0282aa.h);
            cYVar.a(c0282aa.b);
            cYVar.c();
        }
        if (c0282aa.c != null) {
            cYVar.a(C0282aa.i);
            cYVar.a(c0282aa.c);
            cYVar.c();
        }
        cYVar.a(C0282aa.j);
        cYVar.a(c0282aa.d);
        cYVar.c();
        cYVar.d();
        cYVar.b();
    }
}
