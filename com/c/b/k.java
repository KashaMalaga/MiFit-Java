package com.c.b;

import com.c.b.a.b;
import com.c.b.g.o;
import com.c.b.i.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class k implements q {
    private Map<e, ?> a;
    private q[] b;

    private s c(c cVar) {
        if (this.b != null) {
            q[] qVarArr = this.b;
            int length = qVarArr.length;
            int i = 0;
            while (i < length) {
                try {
                    return qVarArr[i].a(cVar, this.a);
                } catch (r e) {
                    i++;
                }
            }
        }
        throw n.a();
    }

    public s a(c cVar) {
        a(null);
        return c(cVar);
    }

    public s a(c cVar, Map<e, ?> map) {
        a((Map) map);
        return c(cVar);
    }

    public void a() {
        if (this.b != null) {
            for (q a : this.b) {
                a.a();
            }
        }
    }

    public void a(Map<e, ?> map) {
        Object obj = null;
        this.a = map;
        Object obj2 = (map == null || !map.containsKey(e.TRY_HARDER)) ? null : 1;
        Collection collection = map == null ? null : (Collection) map.get(e.POSSIBLE_FORMATS);
        Collection arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(a.UPC_A) || collection.contains(a.UPC_E) || collection.contains(a.EAN_13) || collection.contains(a.EAN_8) || collection.contains(a.CODABAR) || collection.contains(a.CODE_39) || collection.contains(a.CODE_93) || collection.contains(a.CODE_128) || collection.contains(a.ITF) || collection.contains(a.RSS_14) || collection.contains(a.RSS_EXPANDED)) {
                obj = 1;
            }
            if (obj != null && obj2 == null) {
                arrayList.add(new o(map));
            }
            if (collection.contains(a.QR_CODE)) {
                arrayList.add(new a());
            }
            if (collection.contains(a.DATA_MATRIX)) {
                arrayList.add(new com.c.b.d.a());
            }
            if (collection.contains(a.AZTEC)) {
                arrayList.add(new b());
            }
            if (collection.contains(a.PDF_417)) {
                arrayList.add(new com.c.b.h.b());
            }
            if (collection.contains(a.MAXICODE)) {
                arrayList.add(new com.c.b.e.a());
            }
            if (!(obj == null || obj2 == null)) {
                arrayList.add(new o(map));
            }
        }
        if (arrayList.isEmpty()) {
            if (obj2 == null) {
                arrayList.add(new o(map));
            }
            arrayList.add(new a());
            arrayList.add(new com.c.b.d.a());
            arrayList.add(new b());
            arrayList.add(new com.c.b.h.b());
            arrayList.add(new com.c.b.e.a());
            if (obj2 != null) {
                arrayList.add(new o(map));
            }
        }
        this.b = (q[]) arrayList.toArray(new q[arrayList.size()]);
    }

    public s b(c cVar) {
        if (this.b == null) {
            a(null);
        }
        return c(cVar);
    }
}
