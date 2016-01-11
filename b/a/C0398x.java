package b.a;

import java.util.BitSet;

class C0398x extends dl<C0395u> {
    private C0398x() {
    }

    public /* synthetic */ void a(cY cYVar, cq cqVar) {
        b(cYVar, (C0395u) cqVar);
    }

    public void a(cY cYVar, C0395u c0395u) {
        C0372df c0372df = (C0372df) cYVar;
        c0372df.a(c0395u.a);
        c0372df.a(c0395u.b);
        BitSet bitSet = new BitSet();
        if (c0395u.l()) {
            bitSet.set(0);
        }
        c0372df.a(bitSet, 1);
        if (c0395u.l()) {
            c0372df.a(c0395u.c);
        }
    }

    public /* synthetic */ void b(cY cYVar, cq cqVar) {
        a(cYVar, (C0395u) cqVar);
    }

    public void b(cY cYVar, C0395u c0395u) {
        C0372df c0372df = (C0372df) cYVar;
        c0395u.a = c0372df.w();
        c0395u.a(true);
        c0395u.b = c0372df.w();
        c0395u.b(true);
        if (c0372df.b(1).get(0)) {
            c0395u.c = c0372df.w();
            c0395u.c(true);
        }
    }
}
