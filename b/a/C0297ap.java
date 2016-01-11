package b.a;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map.Entry;

class C0297ap extends dl<C0294am> {
    private C0297ap() {
    }

    public void a(cY cYVar, C0294am c0294am) {
        cYVar = (C0372df) cYVar;
        cYVar.a(c0294am.a.size());
        for (Entry entry : c0294am.a.entrySet()) {
            cYVar.a((String) entry.getKey());
            ((C0288ag) entry.getValue()).b(cYVar);
        }
        BitSet bitSet = new BitSet();
        if (c0294am.l()) {
            bitSet.set(0);
        }
        if (c0294am.o()) {
            bitSet.set(1);
        }
        cYVar.a(bitSet, 2);
        if (c0294am.l()) {
            cYVar.a(c0294am.b.size());
            for (C0282aa b : c0294am.b) {
                b.b(cYVar);
            }
        }
        if (c0294am.o()) {
            cYVar.a(c0294am.c);
        }
    }

    public /* synthetic */ void a(cY cYVar, cq cqVar) {
        b(cYVar, (C0294am) cqVar);
    }

    public void b(cY cYVar, C0294am c0294am) {
        int i = 0;
        cYVar = (C0372df) cYVar;
        cV cVVar = new cV(C0374dh.i, C0374dh.j, cYVar.w());
        c0294am.a = new HashMap(cVVar.c * 2);
        for (int i2 = 0; i2 < cVVar.c; i2++) {
            String z = cYVar.z();
            C0288ag c0288ag = new C0288ag();
            c0288ag.a(cYVar);
            c0294am.a.put(z, c0288ag);
        }
        c0294am.a(true);
        BitSet b = cYVar.b(2);
        if (b.get(0)) {
            cU cUVar = new cU(C0374dh.j, cYVar.w());
            c0294am.b = new ArrayList(cUVar.b);
            while (i < cUVar.b) {
                C0282aa c0282aa = new C0282aa();
                c0282aa.a(cYVar);
                c0294am.b.add(c0282aa);
                i++;
            }
            c0294am.b(true);
        }
        if (b.get(1)) {
            c0294am.c = cYVar.z();
            c0294am.c(true);
        }
    }

    public /* synthetic */ void b(cY cYVar, cq cqVar) {
        a(cYVar, (C0294am) cqVar);
    }
}
