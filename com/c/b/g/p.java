package com.c.b.g;

import com.c.b.a;
import com.c.b.e;
import com.c.b.n;
import com.c.b.q;
import com.c.b.r;
import com.c.b.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class p extends q {
    private final x[] a;

    public p(Map<e, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(e.POSSIBLE_FORMATS);
        Collection arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(a.EAN_13)) {
                arrayList.add(new h());
            } else if (collection.contains(a.UPC_A)) {
                arrayList.add(new s());
            }
            if (collection.contains(a.EAN_8)) {
                arrayList.add(new j());
            }
            if (collection.contains(a.UPC_E)) {
                arrayList.add(new z());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new h());
            arrayList.add(new j());
            arrayList.add(new z());
        }
        this.a = (x[]) arrayList.toArray(new x[arrayList.size()]);
    }

    public s a(int i, com.c.b.c.a aVar, Map<e, ?> map) {
        int[] a = x.a(aVar);
        x[] xVarArr = this.a;
        int length = xVarArr.length;
        int i2 = 0;
        while (i2 < length) {
            try {
                s a2 = xVarArr[i2].a(i, aVar, a, (Map) map);
                int i3 = (a2.d() == a.EAN_13 && a2.a().charAt(0) == '0') ? 1 : 0;
                Collection collection = map == null ? null : (Collection) map.get(e.POSSIBLE_FORMATS);
                i2 = (collection == null || collection.contains(a.UPC_A)) ? 1 : 0;
                if (i3 == 0 || i2 == 0) {
                    return a2;
                }
                s sVar = new s(a2.a().substring(1), a2.b(), a2.c(), a.UPC_A);
                sVar.a(a2.e());
                return sVar;
            } catch (r e) {
                i2++;
            }
        }
        throw n.a();
    }

    public void a() {
        for (q a : this.a) {
            a.a();
        }
    }
}
