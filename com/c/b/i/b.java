package com.c.b.i;

import com.c.b.a;
import com.c.b.i.a.o;
import com.c.b.i.c.c;
import com.c.b.i.c.g;
import com.c.b.w;
import java.util.Map;

public final class b implements w {
    private static final int a = 4;

    private static com.c.b.c.b a(g gVar, int i, int i2, int i3) {
        com.c.b.i.c.b e = gVar.e();
        if (e == null) {
            throw new IllegalStateException();
        }
        int b = e.b();
        int a = e.a();
        int i4 = (i3 * 2) + b;
        int i5 = (i3 * 2) + a;
        int max = Math.max(i, i4);
        int max2 = Math.max(i2, i5);
        int min = Math.min(max / i4, max2 / i5);
        i5 = (max - (b * min)) / 2;
        i4 = (max2 - (a * min)) / 2;
        com.c.b.c.b bVar = new com.c.b.c.b(max, max2);
        max2 = i4;
        for (int i6 = 0; i6 < a; i6++) {
            max = 0;
            i4 = i5;
            while (max < b) {
                if (e.a(max, i6) == (byte) 1) {
                    bVar.a(i4, max2, min, min);
                }
                max++;
                i4 += min;
            }
            max2 += min;
        }
        return bVar;
    }

    public com.c.b.c.b a(String str, a aVar, int i, int i2) {
        return a(str, aVar, i, i2, null);
    }

    public com.c.b.c.b a(String str, a aVar, int i, int i2, Map<com.c.b.g, ?> map) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (aVar != a.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got " + aVar);
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i + 'x' + i2);
        } else {
            int intValue;
            o oVar = o.L;
            if (map != null) {
                o oVar2 = (o) map.get(com.c.b.g.ERROR_CORRECTION);
                if (oVar2 != null) {
                    oVar = oVar2;
                }
                Integer num = (Integer) map.get(com.c.b.g.MARGIN);
                if (num != null) {
                    intValue = num.intValue();
                    return a(c.a(str, oVar, (Map) map), i, i2, intValue);
                }
            }
            intValue = a;
            return a(c.a(str, oVar, (Map) map), i, i2, intValue);
        }
    }
}
