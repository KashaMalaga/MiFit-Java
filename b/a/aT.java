package b.a;

import java.util.BitSet;

class aT extends dl<aQ> {
    private aT() {
    }

    public void a(cY cYVar, aQ aQVar) {
        cYVar = (C0372df) cYVar;
        BitSet bitSet = new BitSet();
        if (aQVar.e()) {
            bitSet.set(0);
        }
        if (aQVar.i()) {
            bitSet.set(1);
        }
        if (aQVar.l()) {
            bitSet.set(2);
        }
        if (aQVar.o()) {
            bitSet.set(3);
        }
        if (aQVar.r()) {
            bitSet.set(4);
        }
        if (aQVar.u()) {
            bitSet.set(5);
        }
        if (aQVar.x()) {
            bitSet.set(6);
        }
        if (aQVar.A()) {
            bitSet.set(7);
        }
        if (aQVar.D()) {
            bitSet.set(8);
        }
        if (aQVar.G()) {
            bitSet.set(9);
        }
        if (aQVar.J()) {
            bitSet.set(10);
        }
        cYVar.a(bitSet, 11);
        if (aQVar.e()) {
            cYVar.a(aQVar.a);
        }
        if (aQVar.i()) {
            cYVar.a(aQVar.b);
        }
        if (aQVar.l()) {
            cYVar.a(aQVar.c);
        }
        if (aQVar.o()) {
            cYVar.a(aQVar.d);
        }
        if (aQVar.r()) {
            cYVar.a(aQVar.e);
        }
        if (aQVar.u()) {
            cYVar.a(aQVar.f);
        }
        if (aQVar.x()) {
            cYVar.a(aQVar.g);
        }
        if (aQVar.A()) {
            cYVar.a(aQVar.h);
        }
        if (aQVar.D()) {
            cYVar.a(aQVar.i.a());
        }
        if (aQVar.G()) {
            cYVar.a(aQVar.j);
        }
        if (aQVar.J()) {
            aQVar.k.b(cYVar);
        }
    }

    public /* synthetic */ void a(cY cYVar, cq cqVar) {
        b(cYVar, (aQ) cqVar);
    }

    public void b(cY cYVar, aQ aQVar) {
        cYVar = (C0372df) cYVar;
        BitSet b = cYVar.b(11);
        if (b.get(0)) {
            aQVar.a = cYVar.w();
            aQVar.a(true);
        }
        if (b.get(1)) {
            aQVar.b = cYVar.z();
            aQVar.b(true);
        }
        if (b.get(2)) {
            aQVar.c = cYVar.z();
            aQVar.c(true);
        }
        if (b.get(3)) {
            aQVar.d = cYVar.y();
            aQVar.d(true);
        }
        if (b.get(4)) {
            aQVar.e = cYVar.y();
            aQVar.e(true);
        }
        if (b.get(5)) {
            aQVar.f = cYVar.z();
            aQVar.f(true);
        }
        if (b.get(6)) {
            aQVar.g = cYVar.w();
            aQVar.g(true);
        }
        if (b.get(7)) {
            aQVar.h = cYVar.z();
            aQVar.h(true);
        }
        if (b.get(8)) {
            aQVar.i = C0382h.a(cYVar.w());
            aQVar.i(true);
        }
        if (b.get(9)) {
            aQVar.j = cYVar.z();
            aQVar.j(true);
        }
        if (b.get(10)) {
            aQVar.k = new bK();
            aQVar.k.a(cYVar);
            aQVar.k(true);
        }
    }

    public /* synthetic */ void b(cY cYVar, cq cqVar) {
        a(cYVar, (aQ) cqVar);
    }
}
