package b.a;

import java.util.HashMap;
import java.util.Map.Entry;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class H extends dk<G> {
    private H() {
    }

    public void a(cY cYVar, G g) {
        cYVar.j();
        while (true) {
            cT l = cYVar.l();
            if (l.b == (byte) 0) {
                cYVar.k();
                if (g.e()) {
                    g.t();
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
                    g.a = cYVar.x();
                    g.a(true);
                    break;
                case a.k /*2*/:
                    if (l.b != C0374dh.i) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    g.b = cYVar.z();
                    g.b(true);
                    break;
                case a.l /*3*/:
                    if (l.b != C0374dh.k) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    cV n = cYVar.n();
                    g.c = new HashMap(n.c * 2);
                    for (int i = 0; i < n.c; i++) {
                        g.c.put(cYVar.z(), cYVar.z());
                    }
                    cYVar.o();
                    g.c(true);
                    break;
                case a.aQ /*4*/:
                    if (l.b != (byte) 10) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    g.d = cYVar.x();
                    g.d(true);
                    break;
                case a.X /*5*/:
                    if (l.b != (byte) 8) {
                        C0369dc.a(cYVar, l.b);
                        break;
                    }
                    g.e = cYVar.w();
                    g.e(true);
                    break;
                default:
                    C0369dc.a(cYVar, l.b);
                    break;
            }
            cYVar.m();
        }
    }

    public void b(cY cYVar, G g) {
        g.t();
        cYVar.a(G.g);
        cYVar.a(G.h);
        cYVar.a(g.a);
        cYVar.c();
        if (g.b != null) {
            cYVar.a(G.i);
            cYVar.a(g.b);
            cYVar.c();
        }
        if (g.c != null) {
            cYVar.a(G.j);
            cYVar.a(new cV(C0374dh.i, C0374dh.i, g.c.size()));
            for (Entry entry : g.c.entrySet()) {
                cYVar.a((String) entry.getKey());
                cYVar.a((String) entry.getValue());
            }
            cYVar.e();
            cYVar.c();
        }
        if (g.p()) {
            cYVar.a(G.k);
            cYVar.a(g.d);
            cYVar.c();
        }
        if (g.s()) {
            cYVar.a(G.l);
            cYVar.a(g.e);
            cYVar.c();
        }
        cYVar.d();
        cYVar.b();
    }
}
