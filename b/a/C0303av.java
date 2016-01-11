package b.a;

import java.util.HashMap;
import java.util.Map.Entry;

class C0303av extends dl<C0300as> {
    private C0303av() {
    }

    public void a(cY cYVar, C0300as c0300as) {
        cYVar = (C0372df) cYVar;
        cYVar.a(c0300as.a.size());
        for (Entry entry : c0300as.a.entrySet()) {
            cYVar.a((String) entry.getKey());
            ((C0306ay) entry.getValue()).b(cYVar);
        }
        cYVar.a(c0300as.b);
        cYVar.a(c0300as.c);
    }

    public /* synthetic */ void a(cY cYVar, cq cqVar) {
        b(cYVar, (C0300as) cqVar);
    }

    public void b(cY cYVar, C0300as c0300as) {
        cYVar = (C0372df) cYVar;
        cV cVVar = new cV(C0374dh.i, C0374dh.j, cYVar.w());
        c0300as.a = new HashMap(cVVar.c * 2);
        for (int i = 0; i < cVVar.c; i++) {
            String z = cYVar.z();
            C0306ay c0306ay = new C0306ay();
            c0306ay.a(cYVar);
            c0300as.a.put(z, c0306ay);
        }
        c0300as.a(true);
        c0300as.b = cYVar.w();
        c0300as.b(true);
        c0300as.c = cYVar.z();
        c0300as.c(true);
    }

    public /* synthetic */ void b(cY cYVar, cq cqVar) {
        a(cYVar, (C0300as) cqVar);
    }
}
