package com.c.b.g;

import com.c.b.a;
import com.c.b.c.b;
import com.c.b.g;
import java.util.Map;

public final class k extends y {
    private static final int a = 67;

    public b a(String str, a aVar, int i, int i2, Map<g, ?> map) {
        if (aVar == a.EAN_8) {
            return super.a(str, aVar, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_8, but got " + aVar);
    }

    public boolean[] a(String str) {
        if (str.length() != 8) {
            throw new IllegalArgumentException("Requested contents should be 8 digits long, but got " + str.length());
        }
        int i;
        boolean[] zArr = new boolean[a];
        int a = r.a(zArr, 0, x.b, true) + 0;
        for (i = 0; i <= 3; i++) {
            a += r.a(zArr, a, x.d[Integer.parseInt(str.substring(i, i + 1))], false);
        }
        int a2 = a + r.a(zArr, a, x.c, false);
        for (i = 4; i <= 7; i++) {
            a2 += r.a(zArr, a2, x.d[Integer.parseInt(str.substring(i, i + 1))], true);
        }
        r.a(zArr, a2, x.b, true);
        return zArr;
    }
}
