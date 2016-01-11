package com.c.b.g;

import com.c.b.a;
import com.c.b.e;
import com.c.b.g.a.a.d;
import com.c.b.n;
import com.c.b.q;
import com.c.b.r;
import com.c.b.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class o extends q {
    private final q[] a;

    public o(Map<e, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(e.POSSIBLE_FORMATS);
        boolean z = (map == null || map.get(e.ASSUME_CODE_39_CHECK_DIGIT) == null) ? false : true;
        Collection arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(a.EAN_13) || collection.contains(a.UPC_A) || collection.contains(a.EAN_8) || collection.contains(a.UPC_E)) {
                arrayList.add(new p(map));
            }
            if (collection.contains(a.CODE_39)) {
                arrayList.add(new e(z));
            }
            if (collection.contains(a.CODE_93)) {
                arrayList.add(new g());
            }
            if (collection.contains(a.CODE_128)) {
                arrayList.add(new c());
            }
            if (collection.contains(a.ITF)) {
                arrayList.add(new m());
            }
            if (collection.contains(a.CODABAR)) {
                arrayList.add(new a());
            }
            if (collection.contains(a.RSS_14)) {
                arrayList.add(new com.c.b.g.a.e());
            }
            if (collection.contains(a.RSS_EXPANDED)) {
                arrayList.add(new d());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new p(map));
            arrayList.add(new e());
            arrayList.add(new a());
            arrayList.add(new g());
            arrayList.add(new c());
            arrayList.add(new m());
            arrayList.add(new com.c.b.g.a.e());
            arrayList.add(new d());
        }
        this.a = (q[]) arrayList.toArray(new q[arrayList.size()]);
    }

    public s a(int i, com.c.b.c.a aVar, Map<e, ?> map) {
        q[] qVarArr = this.a;
        int i2 = 0;
        while (i2 < qVarArr.length) {
            try {
                return qVarArr[i2].a(i, aVar, (Map) map);
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
