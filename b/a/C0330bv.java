package b.a;

import java.util.ArrayList;
import java.util.BitSet;

class C0330bv extends dl<C0327bs> {
    private C0330bv() {
    }

    public void a(cY cYVar, C0327bs c0327bs) {
        cYVar = (C0372df) cYVar;
        cYVar.a(c0327bs.a);
        cYVar.a(c0327bs.b);
        cYVar.a(c0327bs.c);
        cYVar.a(c0327bs.d);
        BitSet bitSet = new BitSet();
        if (c0327bs.t()) {
            bitSet.set(0);
        }
        if (c0327bs.y()) {
            bitSet.set(1);
        }
        if (c0327bs.B()) {
            bitSet.set(2);
        }
        cYVar.a(bitSet, 3);
        if (c0327bs.t()) {
            cYVar.a(c0327bs.e.size());
            for (aW b : c0327bs.e) {
                b.b(cYVar);
            }
        }
        if (c0327bs.y()) {
            cYVar.a(c0327bs.f.size());
            for (aK b2 : c0327bs.f) {
                b2.b(cYVar);
            }
        }
        if (c0327bs.B()) {
            c0327bs.g.b(cYVar);
        }
    }

    public /* synthetic */ void a(cY cYVar, cq cqVar) {
        b(cYVar, (C0327bs) cqVar);
    }

    public void b(cY cYVar, C0327bs c0327bs) {
        int i = 0;
        cYVar = (C0372df) cYVar;
        c0327bs.a = cYVar.z();
        c0327bs.a(true);
        c0327bs.b = cYVar.x();
        c0327bs.b(true);
        c0327bs.c = cYVar.x();
        c0327bs.c(true);
        c0327bs.d = cYVar.x();
        c0327bs.d(true);
        BitSet b = cYVar.b(3);
        if (b.get(0)) {
            cU cUVar = new cU(C0374dh.j, cYVar.w());
            c0327bs.e = new ArrayList(cUVar.b);
            for (int i2 = 0; i2 < cUVar.b; i2++) {
                aW aWVar = new aW();
                aWVar.a(cYVar);
                c0327bs.e.add(aWVar);
            }
            c0327bs.e(true);
        }
        if (b.get(1)) {
            cU cUVar2 = new cU(C0374dh.j, cYVar.w());
            c0327bs.f = new ArrayList(cUVar2.b);
            while (i < cUVar2.b) {
                aK aKVar = new aK();
                aKVar.a(cYVar);
                c0327bs.f.add(aKVar);
                i++;
            }
            c0327bs.f(true);
        }
        if (b.get(2)) {
            c0327bs.g = new C0333by();
            c0327bs.g.a(cYVar);
            c0327bs.g(true);
        }
    }

    public /* synthetic */ void b(cY cYVar, cq cqVar) {
        a(cYVar, (C0327bs) cqVar);
    }
}
