package b.a;

import java.util.HashMap;
import java.util.Map.Entry;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class U extends dk<T> {
    private U() {
    }

    public void a(cY cYVar, T t) {
        cYVar.j();
        while (true) {
            cT l = cYVar.l();
            if (l.b == (byte) 0) {
                cYVar.k();
                if (t.s()) {
                    t.t();
                    return;
                }
                throw new C0340cZ("Required field 'ts' was not found in serialized data! Struct: " + toString());
            }
            switch (l.c) {
                case l.a /*1*/:
                    if (l.b != C0374dh.i) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    t.a = cYVar.z();
                    t.a(true);
                    break;
                case a.k /*2*/:
                    if (l.b != C0374dh.k) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    cV n = cYVar.n();
                    t.b = new HashMap(n.c * 2);
                    for (int i = 0; i < n.c; i++) {
                        String z = cYVar.z();
                        C0311bc c0311bc = new C0311bc();
                        c0311bc.a(cYVar);
                        t.b.put(z, c0311bc);
                    }
                    cYVar.o();
                    t.b(true);
                    break;
                case a.l /*3*/:
                    if (l.b != (byte) 10) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    t.c = cYVar.x();
                    t.c(true);
                    break;
                case a.aQ /*4*/:
                    if (l.b != (byte) 8) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    t.d = cYVar.w();
                    t.d(true);
                    break;
                case a.X /*5*/:
                    if (l.b != (byte) 10) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    t.e = cYVar.x();
                    t.e(true);
                    break;
                default:
                    C0369dc.a(cYVar, l.b);
                    break;
            }
            cYVar.m();
        }
    }

    public void b(cY cYVar, T t) {
        t.t();
        cYVar.a(T.g);
        if (t.a != null) {
            cYVar.a(T.h);
            cYVar.a(t.a);
            cYVar.c();
        }
        if (t.b != null) {
            cYVar.a(T.i);
            cYVar.a(new cV(C0374dh.i, C0374dh.j, t.b.size()));
            for (Entry entry : t.b.entrySet()) {
                cYVar.a((String) entry.getKey());
                ((C0311bc) entry.getValue()).b(cYVar);
            }
            cYVar.e();
            cYVar.c();
        }
        if (t.m()) {
            cYVar.a(T.j);
            cYVar.a(t.c);
            cYVar.c();
        }
        if (t.p()) {
            cYVar.a(T.k);
            cYVar.a(t.d);
            cYVar.c();
        }
        cYVar.a(T.l);
        cYVar.a(t.e);
        cYVar.c();
        cYVar.d();
        cYVar.b();
    }
}
