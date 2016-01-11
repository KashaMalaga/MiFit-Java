package b.a;

import java.util.HashMap;
import java.util.Map.Entry;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class C0301at extends dk<C0300as> {
    private C0301at() {
    }

    public void a(cY cYVar, C0300as c0300as) {
        cYVar.j();
        while (true) {
            cT l = cYVar.l();
            if (l.b == (byte) 0) {
                cYVar.k();
                if (c0300as.j()) {
                    c0300as.n();
                    return;
                }
                throw new C0340cZ("Required field 'version' was not found in serialized data! Struct: " + toString());
            }
            switch (l.c) {
                case l.a /*1*/:
                    if (l.b != C0374dh.k) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    cV n = cYVar.n();
                    c0300as.a = new HashMap(n.c * 2);
                    for (int i = 0; i < n.c; i++) {
                        String z = cYVar.z();
                        C0306ay c0306ay = new C0306ay();
                        c0306ay.a(cYVar);
                        c0300as.a.put(z, c0306ay);
                    }
                    cYVar.o();
                    c0300as.a(true);
                    break;
                case a.k /*2*/:
                    if (l.b != (byte) 8) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    c0300as.b = cYVar.w();
                    c0300as.b(true);
                    break;
                case a.l /*3*/:
                    if (l.b != C0374dh.i) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    c0300as.c = cYVar.z();
                    c0300as.c(true);
                    break;
                default:
                    C0369dc.a(cYVar, l.b);
                    break;
            }
            cYVar.m();
        }
    }

    public void b(cY cYVar, C0300as c0300as) {
        c0300as.n();
        cYVar.a(C0300as.e);
        if (c0300as.a != null) {
            cYVar.a(C0300as.f);
            cYVar.a(new cV(C0374dh.i, C0374dh.j, c0300as.a.size()));
            for (Entry entry : c0300as.a.entrySet()) {
                cYVar.a((String) entry.getKey());
                ((C0306ay) entry.getValue()).b(cYVar);
            }
            cYVar.e();
            cYVar.c();
        }
        cYVar.a(C0300as.g);
        cYVar.a(c0300as.b);
        cYVar.c();
        if (c0300as.c != null) {
            cYVar.a(C0300as.h);
            cYVar.a(c0300as.c);
            cYVar.c();
        }
        cYVar.d();
        cYVar.b();
    }
}
