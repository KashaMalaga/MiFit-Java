package com.c.b.g;

import com.c.b.a;
import com.c.b.c.b;
import com.c.b.g;
import java.util.Map;

public final class n extends r {
    private static final int[] a = new int[]{1, 1, 1, 1};
    private static final int[] b = new int[]{3, 1, 1};

    public b a(String str, a aVar, int i, int i2, Map<g, ?> map) {
        if (aVar == a.ITF) {
            return super.a(str, aVar, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode ITF, but got " + aVar);
    }

    public boolean[] a(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("The lenght of the input should be even");
        } else if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
        } else {
            boolean[] zArr = new boolean[((length * 9) + 9)];
            int a = r.a(zArr, 0, a, true);
            for (int i = 0; i < length; i += 2) {
                int digit = Character.digit(str.charAt(i), 10);
                int digit2 = Character.digit(str.charAt(i + 1), 10);
                int[] iArr = new int[18];
                for (int i2 = 0; i2 < 5; i2++) {
                    iArr[i2 * 2] = m.a[digit][i2];
                    iArr[(i2 * 2) + 1] = m.a[digit2][i2];
                }
                a += r.a(zArr, a, iArr, true);
            }
            r.a(zArr, a, b, true);
            return zArr;
        }
    }
}
