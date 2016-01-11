package com.c.b.g;

import com.c.b.a;
import com.c.b.c.b;
import com.c.b.g;
import java.util.Map;

public final class f extends r {
    private static void a(int i, int[] iArr) {
        for (int i2 = 0; i2 < 9; i2++) {
            iArr[i2] = ((1 << (8 - i2)) & i) == 0 ? 1 : 2;
        }
    }

    public b a(String str, a aVar, int i, int i2, Map<g, ?> map) {
        if (aVar == a.CODE_39) {
            return super.a(str, aVar, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_39, but got " + aVar);
    }

    public boolean[] a(String str) {
        int length = str.length();
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
        }
        int indexOf;
        int[] iArr = new int[9];
        int i = length + 25;
        int i2 = 0;
        while (i2 < length) {
            indexOf = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(str.charAt(i2));
            if (indexOf < 0) {
                throw new IllegalArgumentException("Bad contents: " + str);
            }
            a(e.b[indexOf], iArr);
            indexOf = i;
            for (int i3 : iArr) {
                indexOf += i3;
            }
            i2++;
            i = indexOf;
        }
        boolean[] zArr = new boolean[i];
        a(e.b[39], iArr);
        i = r.a(zArr, 0, iArr, true);
        int[] iArr2 = new int[]{1};
        indexOf = i + r.a(zArr, i, iArr2, false);
        for (i = 0; i < length; i++) {
            a(e.b["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(str.charAt(i))], iArr);
            indexOf += r.a(zArr, indexOf, iArr, true);
            indexOf += r.a(zArr, indexOf, iArr2, false);
        }
        a(e.b[39], iArr);
        r.a(zArr, indexOf, iArr, true);
        return zArr;
    }
}
