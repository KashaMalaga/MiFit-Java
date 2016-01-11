package b.a;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map.Entry;

class W extends dl<T> {
    private W() {
    }

    public void a(cY cYVar, T t) {
        C0372df c0372df = (C0372df) cYVar;
        c0372df.a(t.a);
        c0372df.a(t.b.size());
        for (Entry entry : t.b.entrySet()) {
            c0372df.a((String) entry.getKey());
            ((C0311bc) entry.getValue()).b((cY) c0372df);
        }
        c0372df.a(t.e);
        BitSet bitSet = new BitSet();
        if (t.m()) {
            bitSet.set(0);
        }
        if (t.p()) {
            bitSet.set(1);
        }
        c0372df.a(bitSet, 2);
        if (t.m()) {
            c0372df.a(t.c);
        }
        if (t.p()) {
            c0372df.a(t.d);
        }
    }

    public /* synthetic */ void a(cY cYVar, cq cqVar) {
        b(cYVar, (T) cqVar);
    }

    public void b(cY cYVar, T t) {
        C0372df c0372df = (C0372df) cYVar;
        t.a = c0372df.z();
        t.a(true);
        cV cVVar = new cV(C0374dh.i, C0374dh.j, c0372df.w());
        t.b = new HashMap(cVVar.c * 2);
        for (int i = 0; i < cVVar.c; i++) {
            String z = c0372df.z();
            C0311bc c0311bc = new C0311bc();
            c0311bc.a((cY) c0372df);
            t.b.put(z, c0311bc);
        }
        t.b(true);
        t.e = c0372df.x();
        t.e(true);
        BitSet b = c0372df.b(2);
        if (b.get(0)) {
            t.c = c0372df.x();
            t.c(true);
        }
        if (b.get(1)) {
            t.d = c0372df.w();
            t.d(true);
        }
    }

    public /* synthetic */ void b(cY cYVar, cq cqVar) {
        a(cYVar, (T) cqVar);
    }
}
