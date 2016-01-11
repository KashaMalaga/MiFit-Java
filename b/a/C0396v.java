package b.a;

import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class C0396v extends dk<C0395u> {
    private C0396v() {
    }

    public void a(cY cYVar, C0395u c0395u) {
        cYVar.j();
        while (true) {
            cT l = cYVar.l();
            if (l.b == (byte) 0) {
                cYVar.k();
                if (!c0395u.e()) {
                    throw new C0340cZ("Required field 'successful_requests' was not found in serialized data! Struct: " + toString());
                } else if (c0395u.i()) {
                    c0395u.m();
                    return;
                } else {
                    throw new C0340cZ("Required field 'failed_requests' was not found in serialized data! Struct: " + toString());
                }
            }
            switch (l.c) {
                case l.a /*1*/:
                    if (l.b != (byte) 8) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    c0395u.a = cYVar.w();
                    c0395u.a(true);
                    break;
                case a.k /*2*/:
                    if (l.b != (byte) 8) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    c0395u.b = cYVar.w();
                    c0395u.b(true);
                    break;
                case a.l /*3*/:
                    if (l.b != (byte) 8) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    c0395u.c = cYVar.w();
                    c0395u.c(true);
                    break;
                default:
                    C0369dc.a(cYVar, l.b);
                    break;
            }
            cYVar.m();
        }
    }

    public void b(cY cYVar, C0395u c0395u) {
        c0395u.m();
        cYVar.a(C0395u.e);
        cYVar.a(C0395u.f);
        cYVar.a(c0395u.a);
        cYVar.c();
        cYVar.a(C0395u.g);
        cYVar.a(c0395u.b);
        cYVar.c();
        if (c0395u.l()) {
            cYVar.a(C0395u.h);
            cYVar.a(c0395u.c);
            cYVar.c();
        }
        cYVar.d();
        cYVar.b();
    }
}
