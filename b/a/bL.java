package b.a;

import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class bL extends dk<bK> {
    private bL() {
    }

    public void a(cY cYVar, bK bKVar) {
        cYVar.j();
        while (true) {
            cT l = cYVar.l();
            if (l.b == (byte) 0) {
                cYVar.k();
                bKVar.p();
                return;
            }
            switch (l.c) {
                case l.a /*1*/:
                    if (l.b != (byte) 8) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    bKVar.a = Z.a(cYVar.w());
                    bKVar.a(true);
                    break;
                case a.k /*2*/:
                    if (l.b != (byte) 8) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    bKVar.b = cYVar.w();
                    bKVar.b(true);
                    break;
                case a.l /*3*/:
                    if (l.b != C0374dh.i) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    bKVar.c = cYVar.z();
                    bKVar.c(true);
                    break;
                case a.aQ /*4*/:
                    if (l.b != C0374dh.i) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    bKVar.d = cYVar.z();
                    bKVar.d(true);
                    break;
                default:
                    C0369dc.a(cYVar, l.b);
                    break;
            }
            cYVar.m();
        }
    }

    public void b(cY cYVar, bK bKVar) {
        bKVar.p();
        cYVar.a(bK.f);
        if (bKVar.a != null && bKVar.e()) {
            cYVar.a(bK.g);
            cYVar.a(bKVar.a.a());
            cYVar.c();
        }
        if (bKVar.i()) {
            cYVar.a(bK.h);
            cYVar.a(bKVar.b);
            cYVar.c();
        }
        if (bKVar.c != null && bKVar.l()) {
            cYVar.a(bK.i);
            cYVar.a(bKVar.c);
            cYVar.c();
        }
        if (bKVar.d != null && bKVar.o()) {
            cYVar.a(bK.j);
            cYVar.a(bKVar.d);
            cYVar.c();
        }
        cYVar.d();
        cYVar.b();
    }
}
