package com.c.b.h;

import com.c.b.d;
import com.c.b.e;
import com.c.b.f.c;
import com.c.b.h;
import com.c.b.h.a.l;
import com.c.b.h.b.a;
import com.c.b.n;
import com.c.b.q;
import com.c.b.s;
import com.c.b.t;
import com.c.b.u;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class b implements c, q {
    private static int a(u uVar, u uVar2) {
        return (uVar == null || uVar2 == null) ? 0 : (int) Math.abs(uVar.a() - uVar2.a());
    }

    private static int a(u[] uVarArr) {
        return Math.max(Math.max(a(uVarArr[0], uVarArr[4]), (a(uVarArr[6], uVarArr[2]) * 17) / 18), Math.max(a(uVarArr[1], uVarArr[5]), (a(uVarArr[7], uVarArr[3]) * 17) / 18));
    }

    private static s[] a(com.c.b.c cVar, Map<e, ?> map, boolean z) {
        List arrayList = new ArrayList();
        com.c.b.h.b.b a = a.a(cVar, (Map) map, z);
        for (u[] uVarArr : a.b()) {
            com.c.b.c.e a2 = l.a(a.a(), uVarArr[4], uVarArr[5], uVarArr[6], uVarArr[7], b(uVarArr), a(uVarArr));
            s sVar = new s(a2.b(), a2.a(), uVarArr, com.c.b.a.PDF_417);
            sVar.a(t.ERROR_CORRECTION_LEVEL, a2.d());
            c cVar2 = (c) a2.g();
            if (cVar2 != null) {
                sVar.a(t.PDF417_EXTRA_METADATA, cVar2);
            }
            arrayList.add(sVar);
        }
        return (s[]) arrayList.toArray(new s[arrayList.size()]);
    }

    private static int b(u uVar, u uVar2) {
        return (uVar == null || uVar2 == null) ? Integer.MAX_VALUE : (int) Math.abs(uVar.a() - uVar2.a());
    }

    private static int b(u[] uVarArr) {
        return Math.min(Math.min(b(uVarArr[0], uVarArr[4]), (b(uVarArr[6], uVarArr[2]) * 17) / 18), Math.min(b(uVarArr[1], uVarArr[5]), (b(uVarArr[7], uVarArr[3]) * 17) / 18));
    }

    public s a(com.c.b.c cVar) {
        return a(cVar, null);
    }

    public s a(com.c.b.c cVar, Map<e, ?> map) {
        s[] a = a(cVar, map, false);
        if (a != null && a.length != 0 && a[0] != null) {
            return a[0];
        }
        throw n.a();
    }

    public void a() {
    }

    public s[] a_(com.c.b.c cVar) {
        return a_(cVar, null);
    }

    public s[] a_(com.c.b.c cVar, Map<e, ?> map) {
        try {
            return a(cVar, map, true);
        } catch (h e) {
            throw n.a();
        } catch (d e2) {
            throw n.a();
        }
    }
}
