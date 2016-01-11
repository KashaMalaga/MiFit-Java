package com.c.b.i;

import com.c.b.c;
import com.c.b.c.b;
import com.c.b.c.g;
import com.c.b.e;
import com.c.b.i.a.n;
import com.c.b.i.a.r;
import com.c.b.q;
import com.c.b.s;
import com.c.b.t;
import com.c.b.u;
import java.util.List;
import java.util.Map;

public class a implements q {
    private static final u[] a = new u[0];
    private final n b = new n();

    private static float a(int[] iArr, b bVar) {
        int g = bVar.g();
        int f = bVar.f();
        int i = iArr[0];
        boolean z = true;
        int i2 = iArr[1];
        int i3 = i;
        int i4 = 0;
        while (i3 < f && i2 < g) {
            boolean z2;
            if (z != bVar.a(i3, i2)) {
                i = i4 + 1;
                if (i == 5) {
                    break;
                }
                int i5 = i;
                z2 = !z;
                i4 = i5;
            } else {
                z2 = z;
            }
            i3++;
            i2++;
            z = z2;
        }
        if (i3 != f && i2 != g) {
            return ((float) (i3 - iArr[0])) / 7.0f;
        }
        throw com.c.b.n.a();
    }

    private static b a(b bVar) {
        int[] d = bVar.d();
        int[] e = bVar.e();
        if (d == null || e == null) {
            throw com.c.b.n.a();
        }
        float a = a(d, bVar);
        int i = d[1];
        int i2 = e[1];
        int i3 = d[0];
        int i4 = e[0];
        if (i3 >= i4 || i >= i2) {
            throw com.c.b.n.a();
        }
        if (i2 - i != i4 - i3) {
            i4 = (i2 - i) + i3;
        }
        int round = Math.round(((float) ((i4 - i3) + 1)) / a);
        int round2 = Math.round(((float) ((i2 - i) + 1)) / a);
        if (round <= 0 || round2 <= 0) {
            throw com.c.b.n.a();
        } else if (round2 != round) {
            throw com.c.b.n.a();
        } else {
            int i5 = (int) (a / 2.0f);
            int i6 = i + i5;
            i = i3 + i5;
            i4 = (((int) (((float) (round - 1)) * a)) + i) - i4;
            if (i4 <= 0) {
                i3 = i;
            } else if (i4 > i5) {
                throw com.c.b.n.a();
            } else {
                i3 = i - i4;
            }
            i4 = (((int) (((float) (round2 - 1)) * a)) + i6) - i2;
            if (i4 <= 0) {
                i4 = i6;
            } else if (i4 > i5) {
                throw com.c.b.n.a();
            } else {
                i4 = i6 - i4;
            }
            b bVar2 = new b(round, round2);
            for (i = 0; i < round2; i++) {
                i5 = i4 + ((int) (((float) i) * a));
                for (i6 = 0; i6 < round; i6++) {
                    if (bVar.a(((int) (((float) i6) * a)) + i3, i5)) {
                        bVar2.b(i6, i);
                    }
                }
            }
            return bVar2;
        }
    }

    public s a(c cVar) {
        return a(cVar, null);
    }

    public final s a(c cVar, Map<e, ?> map) {
        com.c.b.c.e a;
        u[] e;
        if (map == null || !map.containsKey(e.PURE_BARCODE)) {
            g b = new com.c.b.i.b.c(cVar.c()).b(map);
            a = this.b.a(b.d(), (Map) map);
            e = b.e();
        } else {
            a = this.b.a(a(cVar.c()), (Map) map);
            e = a;
        }
        if (a.g() instanceof r) {
            ((r) a.g()).a(e);
        }
        s sVar = new s(a.b(), a.a(), e, com.c.b.a.QR_CODE);
        List c = a.c();
        if (c != null) {
            sVar.a(t.BYTE_SEGMENTS, c);
        }
        String d = a.d();
        if (d != null) {
            sVar.a(t.ERROR_CORRECTION_LEVEL, d);
        }
        if (a.h()) {
            sVar.a(t.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(a.j()));
            sVar.a(t.STRUCTURED_APPEND_PARITY, Integer.valueOf(a.i()));
        }
        return sVar;
    }

    public void a() {
    }

    protected final n b() {
        return this.b;
    }
}
