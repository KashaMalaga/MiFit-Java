package com.c.b.f.a.a;

import com.c.b.c.b;
import com.c.b.c.g;
import com.c.b.e;
import com.c.b.i.b.c;
import com.c.b.i.b.i;
import com.c.b.n;
import com.c.b.r;
import com.c.b.v;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class a extends c {
    private static final g[] a = new g[0];

    public a(b bVar) {
        super(bVar);
    }

    public g[] a(Map<e, ?> map) {
        i[] a = new b(a(), map == null ? null : (v) map.get(e.NEED_RESULT_POINT_CALLBACK)).a(map);
        if (a.length == 0) {
            throw n.a();
        }
        List arrayList = new ArrayList();
        for (i a2 : a) {
            try {
                arrayList.add(a(a2));
            } catch (r e) {
            }
        }
        return arrayList.isEmpty() ? a : (g[]) arrayList.toArray(new g[arrayList.size()]);
    }
}
