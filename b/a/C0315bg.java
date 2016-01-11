package b.a;

import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class C0315bg extends dk<C0314bf> {
    private C0315bg() {
    }

    public void a(cY cYVar, C0314bf c0314bf) {
        cYVar.j();
        while (true) {
            cT l = cYVar.l();
            if (l.b == (byte) 0) {
                cYVar.k();
                if (!c0314bf.e()) {
                    throw new C0340cZ("Required field 'height' was not found in serialized data! Struct: " + toString());
                } else if (c0314bf.i()) {
                    c0314bf.j();
                    return;
                } else {
                    throw new C0340cZ("Required field 'width' was not found in serialized data! Struct: " + toString());
                }
            }
            switch (l.c) {
                case l.a /*1*/:
                    if (l.b != (byte) 8) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    c0314bf.a = cYVar.w();
                    c0314bf.a(true);
                    break;
                case a.k /*2*/:
                    if (l.b != (byte) 8) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    c0314bf.b = cYVar.w();
                    c0314bf.b(true);
                    break;
                default:
                    C0369dc.a(cYVar, l.b);
                    break;
            }
            cYVar.m();
        }
    }

    public void b(cY cYVar, C0314bf c0314bf) {
        c0314bf.j();
        cYVar.a(C0314bf.d);
        cYVar.a(C0314bf.e);
        cYVar.a(c0314bf.a);
        cYVar.c();
        cYVar.a(C0314bf.f);
        cYVar.a(c0314bf.b);
        cYVar.c();
        cYVar.d();
        cYVar.b();
    }
}
