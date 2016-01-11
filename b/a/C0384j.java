package b.a;

import kankan.wheel.widget.l;

class C0384j extends dk<C0383i> {
    private C0384j() {
    }

    public void a(cY cYVar, C0383i c0383i) {
        cYVar.j();
        while (true) {
            cT l = cYVar.l();
            if (l.b == (byte) 0) {
                cYVar.k();
                if (c0383i.e()) {
                    c0383i.f();
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
                    c0383i.a = cYVar.x();
                    c0383i.a(true);
                    break;
                default:
                    C0369dc.a(cYVar, l.b);
                    break;
            }
            cYVar.m();
        }
    }

    public void b(cY cYVar, C0383i c0383i) {
        c0383i.f();
        cYVar.a(C0383i.c);
        cYVar.a(C0383i.d);
        cYVar.a(c0383i.a);
        cYVar.c();
        cYVar.d();
        cYVar.b();
    }
}
