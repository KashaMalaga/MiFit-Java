package b.a;

import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class C0321bm extends dk<C0320bl> {
    private C0321bm() {
    }

    public void a(cY cYVar, C0320bl c0320bl) {
        cYVar.j();
        while (true) {
            cT l = cYVar.l();
            if (l.b == (byte) 0) {
                cYVar.k();
                if (c0320bl.e()) {
                    c0320bl.m();
                    return;
                }
                throw new C0340cZ("Required field 'resp_code' was not found in serialized data! Struct: " + toString());
            }
            switch (l.c) {
                case l.a /*1*/:
                    if (l.b != (byte) 8) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    c0320bl.a = cYVar.w();
                    c0320bl.a(true);
                    break;
                case a.k /*2*/:
                    if (l.b != C0374dh.i) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    c0320bl.b = cYVar.z();
                    c0320bl.b(true);
                    break;
                case a.l /*3*/:
                    if (l.b != C0374dh.j) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    c0320bl.c = new C0300as();
                    c0320bl.c.a(cYVar);
                    c0320bl.c(true);
                    break;
                default:
                    C0369dc.a(cYVar, l.b);
                    break;
            }
            cYVar.m();
        }
    }

    public void b(cY cYVar, C0320bl c0320bl) {
        c0320bl.m();
        cYVar.a(C0320bl.e);
        cYVar.a(C0320bl.f);
        cYVar.a(c0320bl.a);
        cYVar.c();
        if (c0320bl.b != null && c0320bl.i()) {
            cYVar.a(C0320bl.g);
            cYVar.a(c0320bl.b);
            cYVar.c();
        }
        if (c0320bl.c != null && c0320bl.l()) {
            cYVar.a(C0320bl.h);
            c0320bl.c.b(cYVar);
            cYVar.c();
        }
        cYVar.d();
        cYVar.b();
    }
}
