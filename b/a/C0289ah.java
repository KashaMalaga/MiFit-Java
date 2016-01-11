package b.a;

import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class C0289ah extends dk<C0288ag> {
    private C0289ah() {
    }

    public void a(cY cYVar, C0288ag c0288ag) {
        cYVar.j();
        while (true) {
            cT l = cYVar.l();
            if (l.b == (byte) 0) {
                cYVar.k();
                if (!c0288ag.i()) {
                    throw new C0340cZ("Required field 'ts' was not found in serialized data! Struct: " + toString());
                } else if (c0288ag.l()) {
                    c0288ag.m();
                    return;
                } else {
                    throw new C0340cZ("Required field 'version' was not found in serialized data! Struct: " + toString());
                }
            }
            switch (l.c) {
                case l.a /*1*/:
                    if (l.b != C0374dh.i) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    c0288ag.a = cYVar.z();
                    c0288ag.a(true);
                    break;
                case a.k /*2*/:
                    if (l.b != (byte) 10) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    c0288ag.b = cYVar.x();
                    c0288ag.b(true);
                    break;
                case a.l /*3*/:
                    if (l.b != (byte) 8) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    c0288ag.c = cYVar.w();
                    c0288ag.c(true);
                    break;
                default:
                    C0369dc.a(cYVar, l.b);
                    break;
            }
            cYVar.m();
        }
    }

    public void b(cY cYVar, C0288ag c0288ag) {
        c0288ag.m();
        cYVar.a(C0288ag.e);
        if (c0288ag.a != null) {
            cYVar.a(C0288ag.f);
            cYVar.a(c0288ag.a);
            cYVar.c();
        }
        cYVar.a(C0288ag.g);
        cYVar.a(c0288ag.b);
        cYVar.c();
        cYVar.a(C0288ag.h);
        cYVar.a(c0288ag.c);
        cYVar.c();
        cYVar.d();
        cYVar.b();
    }
}
