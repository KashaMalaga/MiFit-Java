package b.a;

import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class C0307az extends dk<C0306ay> {
    private C0307az() {
    }

    public void a(cY cYVar, C0306ay c0306ay) {
        cYVar.j();
        while (true) {
            cT l = cYVar.l();
            if (l.b == (byte) 0) {
                cYVar.k();
                if (c0306ay.i()) {
                    c0306ay.m();
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
                    c0306ay.a = cYVar.z();
                    c0306ay.a(true);
                    break;
                case a.k /*2*/:
                    if (l.b != (byte) 10) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    c0306ay.b = cYVar.x();
                    c0306ay.b(true);
                    break;
                case a.l /*3*/:
                    if (l.b != C0374dh.i) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    c0306ay.c = cYVar.z();
                    c0306ay.c(true);
                    break;
                default:
                    C0369dc.a(cYVar, l.b);
                    break;
            }
            cYVar.m();
        }
    }

    public void b(cY cYVar, C0306ay c0306ay) {
        c0306ay.m();
        cYVar.a(C0306ay.e);
        if (c0306ay.a != null && c0306ay.e()) {
            cYVar.a(C0306ay.f);
            cYVar.a(c0306ay.a);
            cYVar.c();
        }
        cYVar.a(C0306ay.g);
        cYVar.a(c0306ay.b);
        cYVar.c();
        if (c0306ay.c != null) {
            cYVar.a(C0306ay.h);
            cYVar.a(c0306ay.c);
            cYVar.c();
        }
        cYVar.d();
        cYVar.b();
    }
}
