package b.a;

import java.util.BitSet;

class C0285ad extends dl<C0282aa> {
    private C0285ad() {
    }

    public void a(cY cYVar, C0282aa c0282aa) {
        C0372df c0372df = (C0372df) cYVar;
        c0372df.a(c0282aa.a);
        c0372df.a(c0282aa.c);
        c0372df.a(c0282aa.d);
        BitSet bitSet = new BitSet();
        if (c0282aa.i()) {
            bitSet.set(0);
        }
        c0372df.a(bitSet, 1);
        if (c0282aa.i()) {
            c0372df.a(c0282aa.b);
        }
    }

    public /* synthetic */ void a(cY cYVar, cq cqVar) {
        b(cYVar, (C0282aa) cqVar);
    }

    public void b(cY cYVar, C0282aa c0282aa) {
        C0372df c0372df = (C0372df) cYVar;
        c0282aa.a = c0372df.z();
        c0282aa.a(true);
        c0282aa.c = c0372df.z();
        c0282aa.c(true);
        c0282aa.d = c0372df.x();
        c0282aa.d(true);
        if (c0372df.b(1).get(0)) {
            c0282aa.b = c0372df.z();
            c0282aa.b(true);
        }
    }

    public /* synthetic */ void b(cY cYVar, cq cqVar) {
        a(cYVar, (C0282aa) cqVar);
    }
}
