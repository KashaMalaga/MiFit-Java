package b.a;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map.Entry;

class J extends dl<G> {
    private J() {
    }

    public void a(cY cYVar, G g) {
        C0372df c0372df = (C0372df) cYVar;
        c0372df.a(g.a);
        c0372df.a(g.b);
        c0372df.a(g.c.size());
        for (Entry entry : g.c.entrySet()) {
            c0372df.a((String) entry.getKey());
            c0372df.a((String) entry.getValue());
        }
        BitSet bitSet = new BitSet();
        if (g.p()) {
            bitSet.set(0);
        }
        if (g.s()) {
            bitSet.set(1);
        }
        c0372df.a(bitSet, 2);
        if (g.p()) {
            c0372df.a(g.d);
        }
        if (g.s()) {
            c0372df.a(g.e);
        }
    }

    public /* synthetic */ void a(cY cYVar, cq cqVar) {
        b(cYVar, (G) cqVar);
    }

    public void b(cY cYVar, G g) {
        C0372df c0372df = (C0372df) cYVar;
        g.a = c0372df.x();
        g.a(true);
        g.b = c0372df.z();
        g.b(true);
        cV cVVar = new cV(C0374dh.i, C0374dh.i, c0372df.w());
        g.c = new HashMap(cVVar.c * 2);
        for (int i = 0; i < cVVar.c; i++) {
            g.c.put(c0372df.z(), c0372df.z());
        }
        g.c(true);
        BitSet b = c0372df.b(2);
        if (b.get(0)) {
            g.d = c0372df.x();
            g.d(true);
        }
        if (b.get(1)) {
            g.e = c0372df.w();
            g.e(true);
        }
    }

    public /* synthetic */ void b(cY cYVar, cq cqVar) {
        a(cYVar, (G) cqVar);
    }
}
