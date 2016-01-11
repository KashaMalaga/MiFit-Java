package com.c.b.a;

import com.c.b.a.c.a;
import com.c.b.c.b;
import com.c.b.g;
import com.c.b.w;
import java.nio.charset.Charset;
import java.util.Map;

public final class c implements w {
    private static final Charset a = Charset.forName("ISO-8859-1");

    private static b a(a aVar, int i, int i2) {
        b e = aVar.e();
        if (e == null) {
            throw new IllegalStateException();
        }
        int f = e.f();
        int g = e.g();
        int max = Math.max(i, f);
        int max2 = Math.max(i2, g);
        int min = Math.min(max / f, max2 / g);
        int i3 = (max - (f * min)) / 2;
        int i4 = (max2 - (g * min)) / 2;
        b bVar = new b(max, max2);
        max2 = i4;
        for (int i5 = 0; i5 < g; i5++) {
            i4 = i3;
            max = 0;
            while (max < f) {
                if (e.a(max, i5)) {
                    bVar.a(i4, max2, min, min);
                }
                max++;
                i4 += min;
            }
            max2 += min;
        }
        return bVar;
    }

    private static b a(String str, com.c.b.a aVar, int i, int i2, Charset charset, int i3, int i4) {
        if (aVar == com.c.b.a.AZTEC) {
            return a(com.c.b.a.c.c.a(str.getBytes(charset), i3, i4), i, i2);
        }
        throw new IllegalArgumentException("Can only encode AZTEC, but got " + aVar);
    }

    public b a(String str, com.c.b.a aVar, int i, int i2) {
        return a(str, aVar, i, i2, null);
    }

    public b a(String str, com.c.b.a aVar, int i, int i2, Map<g, ?> map) {
        String str2 = map == null ? null : (String) map.get(g.CHARACTER_SET);
        Number number = map == null ? null : (Number) map.get(g.ERROR_CORRECTION);
        Number number2 = map == null ? null : (Number) map.get(g.AZTEC_LAYERS);
        return a(str, aVar, i, i2, str2 == null ? a : Charset.forName(str2), number == null ? 33 : number.intValue(), number2 == null ? 0 : number2.intValue());
    }
}
