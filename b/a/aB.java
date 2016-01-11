package b.a;

import java.util.BitSet;

class aB extends dl<C0306ay> {
    private aB() {
    }

    public void a(cY cYVar, C0306ay c0306ay) {
        C0372df c0372df = (C0372df) cYVar;
        c0372df.a(c0306ay.b);
        c0372df.a(c0306ay.c);
        BitSet bitSet = new BitSet();
        if (c0306ay.e()) {
            bitSet.set(0);
        }
        c0372df.a(bitSet, 1);
        if (c0306ay.e()) {
            c0372df.a(c0306ay.a);
        }
    }

    public /* synthetic */ void a(cY cYVar, cq cqVar) {
        b(cYVar, (C0306ay) cqVar);
    }

    public void b(cY cYVar, C0306ay c0306ay) {
        C0372df c0372df = (C0372df) cYVar;
        c0306ay.b = c0372df.x();
        c0306ay.b(true);
        c0306ay.c = c0372df.z();
        c0306ay.c(true);
        if (c0372df.b(1).get(0)) {
            c0306ay.a = c0372df.z();
            c0306ay.a(true);
        }
    }

    public /* synthetic */ void b(cY cYVar, cq cqVar) {
        a(cYVar, (C0306ay) cqVar);
    }
}
