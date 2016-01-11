package b.a;

import java.util.BitSet;

class C0323bo extends dl<C0320bl> {
    private C0323bo() {
    }

    public void a(cY cYVar, C0320bl c0320bl) {
        cYVar = (C0372df) cYVar;
        cYVar.a(c0320bl.a);
        BitSet bitSet = new BitSet();
        if (c0320bl.i()) {
            bitSet.set(0);
        }
        if (c0320bl.l()) {
            bitSet.set(1);
        }
        cYVar.a(bitSet, 2);
        if (c0320bl.i()) {
            cYVar.a(c0320bl.b);
        }
        if (c0320bl.l()) {
            c0320bl.c.b(cYVar);
        }
    }

    public /* synthetic */ void a(cY cYVar, cq cqVar) {
        b(cYVar, (C0320bl) cqVar);
    }

    public void b(cY cYVar, C0320bl c0320bl) {
        cYVar = (C0372df) cYVar;
        c0320bl.a = cYVar.w();
        c0320bl.a(true);
        BitSet b = cYVar.b(2);
        if (b.get(0)) {
            c0320bl.b = cYVar.z();
            c0320bl.b(true);
        }
        if (b.get(1)) {
            c0320bl.c = new C0300as();
            c0320bl.c.a(cYVar);
            c0320bl.c(true);
        }
    }

    public /* synthetic */ void b(cY cYVar, cq cqVar) {
        a(cYVar, (C0320bl) cqVar);
    }
}
