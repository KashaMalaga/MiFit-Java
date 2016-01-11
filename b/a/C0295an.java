package b.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class C0295an extends dk<C0294am> {
    private C0295an() {
    }

    public void a(cY cYVar, C0294am c0294am) {
        cYVar.j();
        while (true) {
            cT l = cYVar.l();
            if (l.b == (byte) 0) {
                cYVar.k();
                c0294am.p();
                return;
            }
            int i;
            switch (l.c) {
                case l.a /*1*/:
                    if (l.b != C0374dh.k) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    cV n = cYVar.n();
                    c0294am.a = new HashMap(n.c * 2);
                    for (i = 0; i < n.c; i++) {
                        String z = cYVar.z();
                        C0288ag c0288ag = new C0288ag();
                        c0288ag.a(cYVar);
                        c0294am.a.put(z, c0288ag);
                    }
                    cYVar.o();
                    c0294am.a(true);
                    break;
                case a.k /*2*/:
                    if (l.b != C0374dh.m) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    cU p = cYVar.p();
                    c0294am.b = new ArrayList(p.b);
                    for (i = 0; i < p.b; i++) {
                        C0282aa c0282aa = new C0282aa();
                        c0282aa.a(cYVar);
                        c0294am.b.add(c0282aa);
                    }
                    cYVar.q();
                    c0294am.b(true);
                    break;
                case a.l /*3*/:
                    if (l.b != C0374dh.i) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    c0294am.c = cYVar.z();
                    c0294am.c(true);
                    break;
                default:
                    C0369dc.a(cYVar, l.b);
                    break;
            }
            cYVar.m();
        }
    }

    public void b(cY cYVar, C0294am c0294am) {
        c0294am.p();
        cYVar.a(C0294am.e);
        if (c0294am.a != null) {
            cYVar.a(C0294am.f);
            cYVar.a(new cV(C0374dh.i, C0374dh.j, c0294am.a.size()));
            for (Entry entry : c0294am.a.entrySet()) {
                cYVar.a((String) entry.getKey());
                ((C0288ag) entry.getValue()).b(cYVar);
            }
            cYVar.e();
            cYVar.c();
        }
        if (c0294am.b != null && c0294am.l()) {
            cYVar.a(C0294am.g);
            cYVar.a(new cU(C0374dh.j, c0294am.b.size()));
            for (C0282aa b : c0294am.b) {
                b.b(cYVar);
            }
            cYVar.f();
            cYVar.c();
        }
        if (c0294am.c != null && c0294am.o()) {
            cYVar.a(C0294am.h);
            cYVar.a(c0294am.c);
            cYVar.c();
        }
        cYVar.d();
        cYVar.b();
    }
}
