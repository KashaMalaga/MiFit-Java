package b.a;

import java.util.BitSet;

class P extends dl<M> {
    private P() {
    }

    public void a(cY cYVar, M m) {
        C0372df c0372df = (C0372df) cYVar;
        c0372df.a(m.a);
        c0372df.a(m.b);
        BitSet bitSet = new BitSet();
        if (m.l()) {
            bitSet.set(0);
        }
        c0372df.a(bitSet, 1);
        if (m.l()) {
            c0372df.a(m.c.a());
        }
    }

    public /* synthetic */ void a(cY cYVar, cq cqVar) {
        b(cYVar, (M) cqVar);
    }

    public void b(cY cYVar, M m) {
        C0372df c0372df = (C0372df) cYVar;
        m.a = c0372df.x();
        m.b(true);
        m.b = c0372df.z();
        m.c(true);
        if (c0372df.b(1).get(0)) {
            m.c = S.a(c0372df.w());
            m.d(true);
        }
    }

    public /* synthetic */ void b(cY cYVar, cq cqVar) {
        a(cYVar, (M) cqVar);
    }
}
