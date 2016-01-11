package b.a;

import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class C0334bz extends dk<C0333by> {
    private C0334bz() {
    }

    public void a(cY cYVar, C0333by c0333by) {
        cYVar.j();
        while (true) {
            cT l = cYVar.l();
            if (l.b == (byte) 0) {
                cYVar.k();
                if (!c0333by.e()) {
                    throw new C0340cZ("Required field 'upload_traffic' was not found in serialized data! Struct: " + toString());
                } else if (c0333by.i()) {
                    c0333by.j();
                    return;
                } else {
                    throw new C0340cZ("Required field 'download_traffic' was not found in serialized data! Struct: " + toString());
                }
            }
            switch (l.c) {
                case l.a /*1*/:
                    if (l.b != (byte) 8) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    c0333by.a = cYVar.w();
                    c0333by.a(true);
                    break;
                case a.k /*2*/:
                    if (l.b != (byte) 8) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    c0333by.b = cYVar.w();
                    c0333by.b(true);
                    break;
                default:
                    C0369dc.a(cYVar, l.b);
                    break;
            }
            cYVar.m();
        }
    }

    public void b(cY cYVar, C0333by c0333by) {
        c0333by.j();
        cYVar.a(C0333by.d);
        cYVar.a(C0333by.e);
        cYVar.a(c0333by.a);
        cYVar.c();
        cYVar.a(C0333by.f);
        cYVar.a(c0333by.b);
        cYVar.c();
        cYVar.d();
        cYVar.b();
    }
}
