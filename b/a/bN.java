package b.a;

import java.util.BitSet;

class bN extends dl<bK> {
    private bN() {
    }

    public void a(cY cYVar, bK bKVar) {
        C0372df c0372df = (C0372df) cYVar;
        BitSet bitSet = new BitSet();
        if (bKVar.e()) {
            bitSet.set(0);
        }
        if (bKVar.i()) {
            bitSet.set(1);
        }
        if (bKVar.l()) {
            bitSet.set(2);
        }
        if (bKVar.o()) {
            bitSet.set(3);
        }
        c0372df.a(bitSet, 4);
        if (bKVar.e()) {
            c0372df.a(bKVar.a.a());
        }
        if (bKVar.i()) {
            c0372df.a(bKVar.b);
        }
        if (bKVar.l()) {
            c0372df.a(bKVar.c);
        }
        if (bKVar.o()) {
            c0372df.a(bKVar.d);
        }
    }

    public /* synthetic */ void a(cY cYVar, cq cqVar) {
        b(cYVar, (bK) cqVar);
    }

    public void b(cY cYVar, bK bKVar) {
        C0372df c0372df = (C0372df) cYVar;
        BitSet b = c0372df.b(4);
        if (b.get(0)) {
            bKVar.a = Z.a(c0372df.w());
            bKVar.a(true);
        }
        if (b.get(1)) {
            bKVar.b = c0372df.w();
            bKVar.b(true);
        }
        if (b.get(2)) {
            bKVar.c = c0372df.z();
            bKVar.c(true);
        }
        if (b.get(3)) {
            bKVar.d = c0372df.z();
            bKVar.d(true);
        }
    }

    public /* synthetic */ void b(cY cYVar, cq cqVar) {
        a(cYVar, (bK) cqVar);
    }
}
