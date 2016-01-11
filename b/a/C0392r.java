package b.a;

import java.util.BitSet;

class C0392r extends dl<C0389o> {
    private C0392r() {
    }

    public /* synthetic */ void a(cY cYVar, cq cqVar) {
        b(cYVar, (C0389o) cqVar);
    }

    public void a(cY cYVar, C0389o c0389o) {
        C0372df c0372df = (C0372df) cYVar;
        c0372df.a(c0389o.a);
        c0372df.a(c0389o.e.a());
        c0372df.a(c0389o.f);
        c0372df.a(c0389o.g);
        BitSet bitSet = new BitSet();
        if (c0389o.i()) {
            bitSet.set(0);
        }
        if (c0389o.l()) {
            bitSet.set(1);
        }
        if (c0389o.o()) {
            bitSet.set(2);
        }
        if (c0389o.A()) {
            bitSet.set(3);
        }
        if (c0389o.D()) {
            bitSet.set(4);
        }
        if (c0389o.G()) {
            bitSet.set(5);
        }
        c0372df.a(bitSet, 6);
        if (c0389o.i()) {
            c0372df.a(c0389o.b);
        }
        if (c0389o.l()) {
            c0372df.a(c0389o.c);
        }
        if (c0389o.o()) {
            c0372df.a(c0389o.d);
        }
        if (c0389o.A()) {
            c0372df.a(c0389o.h);
        }
        if (c0389o.D()) {
            c0372df.a(c0389o.i);
        }
        if (c0389o.G()) {
            c0372df.a(c0389o.j);
        }
    }

    public /* synthetic */ void b(cY cYVar, cq cqVar) {
        a(cYVar, (C0389o) cqVar);
    }

    public void b(cY cYVar, C0389o c0389o) {
        C0372df c0372df = (C0372df) cYVar;
        c0389o.a = c0372df.z();
        c0389o.a(true);
        c0389o.e = C0326br.a(c0372df.w());
        c0389o.e(true);
        c0389o.f = c0372df.z();
        c0389o.f(true);
        c0389o.g = c0372df.z();
        c0389o.g(true);
        BitSet b = c0372df.b(6);
        if (b.get(0)) {
            c0389o.b = c0372df.z();
            c0389o.b(true);
        }
        if (b.get(1)) {
            c0389o.c = c0372df.w();
            c0389o.c(true);
        }
        if (b.get(2)) {
            c0389o.d = c0372df.z();
            c0389o.d(true);
        }
        if (b.get(3)) {
            c0389o.h = c0372df.z();
            c0389o.h(true);
        }
        if (b.get(4)) {
            c0389o.i = c0372df.z();
            c0389o.i(true);
        }
        if (b.get(5)) {
            c0389o.j = c0372df.w();
            c0389o.j(true);
        }
    }
}
