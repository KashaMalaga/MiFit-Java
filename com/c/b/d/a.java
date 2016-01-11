package com.c.b.d;

import com.c.b.c;
import com.c.b.c.b;
import com.c.b.c.g;
import com.c.b.d.a.f;
import com.c.b.e;
import com.c.b.n;
import com.c.b.q;
import com.c.b.s;
import com.c.b.t;
import com.c.b.u;
import java.util.List;
import java.util.Map;

public final class a implements q {
    private static final u[] a = new u[0];
    private final f b = new f();

    private static int a(int[] iArr, b bVar) {
        int f = bVar.f();
        int i = iArr[0];
        int i2 = iArr[1];
        while (i < f && bVar.a(i, i2)) {
            i++;
        }
        if (i == f) {
            throw n.a();
        }
        i -= iArr[0];
        if (i != 0) {
            return i;
        }
        throw n.a();
    }

    private static b a(b bVar) {
        int[] d = bVar.d();
        int[] e = bVar.e();
        if (d == null || e == null) {
            throw n.a();
        }
        int a = a(d, bVar);
        int i = d[1];
        int i2 = e[1];
        int i3 = d[0];
        int i4 = ((e[0] - i3) + 1) / a;
        i2 = ((i2 - i) + 1) / a;
        if (i4 <= 0 || i2 <= 0) {
            throw n.a();
        }
        int i5 = a / 2;
        i += i5;
        int i6 = i3 + i5;
        b bVar2 = new b(i4, i2);
        for (i5 = 0; i5 < i2; i5++) {
            int i7 = i + (i5 * a);
            for (i3 = 0; i3 < i4; i3++) {
                if (bVar.a((i3 * a) + i6, i7)) {
                    bVar2.b(i3, i5);
                }
            }
        }
        return bVar2;
    }

    public s a(c cVar) {
        return a(cVar, null);
    }

    public s a(c cVar, Map<e, ?> map) {
        com.c.b.c.e a;
        u[] e;
        if (map == null || !map.containsKey(e.PURE_BARCODE)) {
            g a2 = new com.c.b.d.b.a(cVar.c()).a();
            a = this.b.a(a2.d());
            e = a2.e();
        } else {
            a = this.b.a(a(cVar.c()));
            e = a;
        }
        s sVar = new s(a.b(), a.a(), e, com.c.b.a.DATA_MATRIX);
        List c = a.c();
        if (c != null) {
            sVar.a(t.BYTE_SEGMENTS, c);
        }
        String d = a.d();
        if (d != null) {
            sVar.a(t.ERROR_CORRECTION_LEVEL, d);
        }
        return sVar;
    }

    public void a() {
    }
}
