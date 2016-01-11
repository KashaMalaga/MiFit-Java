package b.a;

import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class aL extends dk<aK> {
    private aL() {
    }

    public void a(cY cYVar, aK aKVar) {
        cYVar.j();
        while (true) {
            cT l = cYVar.l();
            if (l.b == (byte) 0) {
                cYVar.k();
                if (!aKVar.e()) {
                    throw new C0340cZ("Required field 'lat' was not found in serialized data! Struct: " + toString());
                } else if (!aKVar.i()) {
                    throw new C0340cZ("Required field 'lng' was not found in serialized data! Struct: " + toString());
                } else if (aKVar.l()) {
                    aKVar.m();
                    return;
                } else {
                    throw new C0340cZ("Required field 'ts' was not found in serialized data! Struct: " + toString());
                }
            }
            switch (l.c) {
                case l.a /*1*/:
                    if (l.b != (byte) 4) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    aKVar.a = cYVar.y();
                    aKVar.a(true);
                    break;
                case a.k /*2*/:
                    if (l.b != (byte) 4) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    aKVar.b = cYVar.y();
                    aKVar.b(true);
                    break;
                case a.l /*3*/:
                    if (l.b != (byte) 10) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    aKVar.c = cYVar.x();
                    aKVar.c(true);
                    break;
                default:
                    C0369dc.a(cYVar, l.b);
                    break;
            }
            cYVar.m();
        }
    }

    public void b(cY cYVar, aK aKVar) {
        aKVar.m();
        cYVar.a(aK.e);
        cYVar.a(aK.f);
        cYVar.a(aKVar.a);
        cYVar.c();
        cYVar.a(aK.g);
        cYVar.a(aKVar.b);
        cYVar.c();
        cYVar.a(aK.h);
        cYVar.a(aKVar.c);
        cYVar.c();
        cYVar.d();
        cYVar.b();
    }
}
