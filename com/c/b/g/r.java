package com.c.b.g;

import com.c.b.a;
import com.c.b.c.b;
import com.c.b.g;
import com.c.b.w;
import java.util.Map;

public abstract class r implements w {
    protected static int a(boolean[] zArr, int i, int[] iArr, boolean z) {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = i;
        while (i2 < length) {
            int i5 = iArr[i2];
            int i6 = i4;
            i4 = 0;
            while (i4 < i5) {
                int i7 = i6 + 1;
                zArr[i6] = z;
                i4++;
                i6 = i7;
            }
            i3 += i5;
            i2++;
            z = !z;
            i4 = i6;
        }
        return i3;
    }

    private static b a(boolean[] zArr, int i, int i2, int i3) {
        int length = zArr.length;
        int i4 = length + i3;
        int max = Math.max(i, i4);
        int max2 = Math.max(1, i2);
        int i5 = max / i4;
        i4 = (max - (length * i5)) / 2;
        b bVar = new b(max, max2);
        max = 0;
        while (max < length) {
            if (zArr[max]) {
                bVar.a(i4, 0, i5, max2);
            }
            max++;
            i4 += i5;
        }
        return bVar;
    }

    public int a() {
        return 10;
    }

    public final b a(String str, a aVar, int i, int i2) {
        return a(str, aVar, i, i2, null);
    }

    public b a(String str, a aVar, int i, int i2, Map<g, ?> map) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Negative size is not allowed. Input: " + i + 'x' + i2);
        } else {
            int intValue;
            int a = a();
            if (map != null) {
                Integer num = (Integer) map.get(g.MARGIN);
                if (num != null) {
                    intValue = num.intValue();
                    return a(a(str), i, i2, intValue);
                }
            }
            intValue = a;
            return a(a(str), i, i2, intValue);
        }
    }

    public abstract boolean[] a(String str);
}
