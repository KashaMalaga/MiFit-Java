package b.a;

import java.util.ArrayList;
import java.util.BitSet;

class aH extends dl<aE> {
    private aH() {
    }

    public void a(cY cYVar, aE aEVar) {
        cYVar = (C0372df) cYVar;
        cYVar.a(aEVar.a);
        BitSet bitSet = new BitSet();
        if (aEVar.k()) {
            bitSet.set(0);
        }
        if (aEVar.p()) {
            bitSet.set(1);
        }
        if (aEVar.u()) {
            bitSet.set(2);
        }
        cYVar.a(bitSet, 3);
        if (aEVar.k()) {
            cYVar.a(aEVar.b.size());
            for (M b : aEVar.b) {
                b.b(cYVar);
            }
        }
        if (aEVar.p()) {
            cYVar.a(aEVar.c.size());
            for (T b2 : aEVar.c) {
                b2.b(cYVar);
            }
        }
        if (aEVar.u()) {
            cYVar.a(aEVar.d.size());
            for (T b22 : aEVar.d) {
                b22.b(cYVar);
            }
        }
    }

    public /* synthetic */ void a(cY cYVar, cq cqVar) {
        b(cYVar, (aE) cqVar);
    }

    public void b(cY cYVar, aE aEVar) {
        int i;
        int i2 = 0;
        cYVar = (C0372df) cYVar;
        aEVar.a = cYVar.z();
        aEVar.a(true);
        BitSet b = cYVar.b(3);
        if (b.get(0)) {
            cU cUVar;
            cUVar = new cU(C0374dh.j, cYVar.w());
            aEVar.b = new ArrayList(cUVar.b);
            for (i = 0; i < cUVar.b; i++) {
                M m = new M();
                m.a(cYVar);
                aEVar.b.add(m);
            }
            aEVar.b(true);
        }
        if (b.get(1)) {
            cUVar = new cU(C0374dh.j, cYVar.w());
            aEVar.c = new ArrayList(cUVar.b);
            for (i = 0; i < cUVar.b; i++) {
                T t = new T();
                t.a(cYVar);
                aEVar.c.add(t);
            }
            aEVar.c(true);
        }
        if (b.get(2)) {
            cU cUVar2 = new cU(C0374dh.j, cYVar.w());
            aEVar.d = new ArrayList(cUVar2.b);
            while (i2 < cUVar2.b) {
                T t2 = new T();
                t2.a(cYVar);
                aEVar.d.add(t2);
                i2++;
            }
            aEVar.d(true);
        }
    }

    public /* synthetic */ void b(cY cYVar, cq cqVar) {
        a(cYVar, (aE) cqVar);
    }
}
