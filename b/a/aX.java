package b.a;

import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class aX extends dk<aW> {
    private aX() {
    }

    public void a(cY cYVar, aW aWVar) {
        cYVar.j();
        while (true) {
            cT l = cYVar.l();
            if (l.b == (byte) 0) {
                cYVar.k();
                if (aWVar.i()) {
                    aWVar.j();
                    return;
                }
                throw new C0340cZ("Required field 'duration' was not found in serialized data! Struct: " + toString());
            }
            switch (l.c) {
                case l.a /*1*/:
                    if (l.b != C0374dh.i) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    aWVar.a = cYVar.z();
                    aWVar.a(true);
                    break;
                case a.k /*2*/:
                    if (l.b != (byte) 10) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    aWVar.b = cYVar.x();
                    aWVar.b(true);
                    break;
                default:
                    C0369dc.a(cYVar, l.b);
                    break;
            }
            cYVar.m();
        }
    }

    public void b(cY cYVar, aW aWVar) {
        aWVar.j();
        cYVar.a(aW.d);
        if (aWVar.a != null) {
            cYVar.a(aW.e);
            cYVar.a(aWVar.a);
            cYVar.c();
        }
        cYVar.a(aW.f);
        cYVar.a(aWVar.b);
        cYVar.c();
        cYVar.d();
        cYVar.b();
    }
}
