package b.a;

import java.util.ArrayList;
import java.util.BitSet;

class bH extends dl<bE> {
    private bH() {
    }

    public void a(cY cYVar, bE bEVar) {
        cYVar = (C0372df) cYVar;
        bEVar.a.b(cYVar);
        bEVar.b.b(cYVar);
        bEVar.c.b(cYVar);
        bEVar.d.b(cYVar);
        BitSet bitSet = new BitSet();
        if (bEVar.r()) {
            bitSet.set(0);
        }
        if (bEVar.w()) {
            bitSet.set(1);
        }
        if (bEVar.B()) {
            bitSet.set(2);
        }
        if (bEVar.E()) {
            bitSet.set(3);
        }
        if (bEVar.H()) {
            bitSet.set(4);
        }
        cYVar.a(bitSet, 5);
        if (bEVar.r()) {
            bEVar.e.b(cYVar);
        }
        if (bEVar.w()) {
            cYVar.a(bEVar.f.size());
            for (aE b : bEVar.f) {
                b.b(cYVar);
            }
        }
        if (bEVar.B()) {
            cYVar.a(bEVar.g.size());
            for (C0327bs b2 : bEVar.g) {
                b2.b(cYVar);
            }
        }
        if (bEVar.E()) {
            bEVar.h.b(cYVar);
        }
        if (bEVar.H()) {
            bEVar.i.b(cYVar);
        }
    }

    public /* synthetic */ void a(cY cYVar, cq cqVar) {
        b(cYVar, (bE) cqVar);
    }

    public void b(cY cYVar, bE bEVar) {
        int i = 0;
        cYVar = (C0372df) cYVar;
        bEVar.a = new C0395u();
        bEVar.a.a(cYVar);
        bEVar.a(true);
        bEVar.b = new C0389o();
        bEVar.b.a(cYVar);
        bEVar.b(true);
        bEVar.c = new A();
        bEVar.c.a(cYVar);
        bEVar.c(true);
        bEVar.d = new aQ();
        bEVar.d.a(cYVar);
        bEVar.d(true);
        BitSet b = cYVar.b(5);
        if (b.get(0)) {
            bEVar.e = new C0383i();
            bEVar.e.a(cYVar);
            bEVar.e(true);
        }
        if (b.get(1)) {
            cU cUVar = new cU(C0374dh.j, cYVar.w());
            bEVar.f = new ArrayList(cUVar.b);
            for (int i2 = 0; i2 < cUVar.b; i2++) {
                aE aEVar = new aE();
                aEVar.a(cYVar);
                bEVar.f.add(aEVar);
            }
            bEVar.f(true);
        }
        if (b.get(2)) {
            cU cUVar2 = new cU(C0374dh.j, cYVar.w());
            bEVar.g = new ArrayList(cUVar2.b);
            while (i < cUVar2.b) {
                C0327bs c0327bs = new C0327bs();
                c0327bs.a(cYVar);
                bEVar.g.add(c0327bs);
                i++;
            }
            bEVar.g(true);
        }
        if (b.get(3)) {
            bEVar.h = new C0300as();
            bEVar.h.a(cYVar);
            bEVar.h(true);
        }
        if (b.get(4)) {
            bEVar.i = new C0294am();
            bEVar.i.a(cYVar);
            bEVar.i(true);
        }
    }

    public /* synthetic */ void b(cY cYVar, cq cqVar) {
        a(cYVar, (bE) cqVar);
    }
}
