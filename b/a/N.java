package b.a;

import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class N extends dk<M> {
    private N() {
    }

    public void a(cY cYVar, M m) {
        cYVar.j();
        while (true) {
            cT l = cYVar.l();
            if (l.b == (byte) 0) {
                cYVar.k();
                if (m.e()) {
                    m.m();
                    return;
                }
                throw new C0340cZ("Required field 'ts' was not found in serialized data! Struct: " + toString());
            }
            switch (l.c) {
                case l.a /*1*/:
                    if (l.b != (byte) 10) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    m.a = cYVar.x();
                    m.b(true);
                    break;
                case a.k /*2*/:
                    if (l.b != C0374dh.i) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    m.b = cYVar.z();
                    m.c(true);
                    break;
                case a.l /*3*/:
                    if (l.b != (byte) 8) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    m.c = S.a(cYVar.w());
                    m.d(true);
                    break;
                default:
                    C0369dc.a(cYVar, l.b);
                    break;
            }
            cYVar.m();
        }
    }

    public void b(cY cYVar, M m) {
        m.m();
        cYVar.a(M.e);
        cYVar.a(M.f);
        cYVar.a(m.a);
        cYVar.c();
        if (m.b != null) {
            cYVar.a(M.g);
            cYVar.a(m.b);
            cYVar.c();
        }
        if (m.c != null && m.l()) {
            cYVar.a(M.h);
            cYVar.a(m.c.a());
            cYVar.c();
        }
        cYVar.d();
        cYVar.b();
    }
}
