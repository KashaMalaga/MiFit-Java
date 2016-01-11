package com.c.b.e;

import com.c.b.c.b;
import com.c.b.e;
import com.c.b.e.a.c;
import com.c.b.n;
import com.c.b.q;
import com.c.b.s;
import com.c.b.t;
import com.c.b.u;
import java.util.Map;

public final class a implements q {
    private static final u[] a = new u[0];
    private static final int b = 30;
    private static final int c = 33;
    private final c d = new c();

    private static b a(b bVar) {
        int[] c = bVar.c();
        if (c == null) {
            throw n.a();
        }
        int i = c[0];
        int i2 = c[1];
        int i3 = c[2];
        int i4 = c[3];
        b bVar2 = new b(b, c);
        for (int i5 = 0; i5 < c; i5++) {
            int i6 = i2 + (((i5 * i4) + (i4 / 2)) / c);
            for (int i7 = 0; i7 < b; i7++) {
                if (bVar.a(((((i7 * i3) + (i3 / 2)) + (((i5 & 1) * i3) / 2)) / b) + i, i6)) {
                    bVar2.b(i7, i5);
                }
            }
        }
        return bVar2;
    }

    public s a(com.c.b.c cVar) {
        return a(cVar, null);
    }

    public s a(com.c.b.c cVar, Map<e, ?> map) {
        if (map == null || !map.containsKey(e.PURE_BARCODE)) {
            throw n.a();
        }
        com.c.b.c.e a = this.d.a(a(cVar.c()), map);
        s sVar = new s(a.b(), a.a(), a, com.c.b.a.MAXICODE);
        String d = a.d();
        if (d != null) {
            sVar.a(t.ERROR_CORRECTION_LEVEL, d);
        }
        return sVar;
    }

    public void a() {
    }
}
