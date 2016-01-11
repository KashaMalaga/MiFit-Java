package com.c.b.g;

import com.c.b.c.a;
import com.c.b.n;
import com.c.b.s;
import com.c.b.t;
import java.util.EnumMap;
import java.util.Map;

final class u {
    private final int[] a = new int[4];
    private final StringBuilder b = new StringBuilder();

    u() {
    }

    private static Map<t, Object> a(String str) {
        if (str.length() != 2) {
            return null;
        }
        Map<t, Object> enumMap = new EnumMap(t.class);
        enumMap.put(t.ISSUE_NUMBER, Integer.valueOf(str));
        return enumMap;
    }

    int a(a aVar, int[] iArr, StringBuilder stringBuilder) {
        int[] iArr2 = this.a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int a = aVar.a();
        int i = iArr[1];
        int i2 = 0;
        for (int i3 = 0; i3 < 2 && i < a; i3++) {
            int a2 = x.a(aVar, iArr2, i, x.e);
            stringBuilder.append((char) ((a2 % 10) + 48));
            int i4 = 0;
            while (i4 < iArr2.length) {
                int i5 = iArr2[i4] + i;
                i4++;
                i = i5;
            }
            if (a2 >= 10) {
                i2 |= 1 << (1 - i3);
            }
            if (i3 != 1) {
                i = aVar.e(aVar.d(i));
            }
        }
        if (stringBuilder.length() != 2) {
            throw n.a();
        } else if (Integer.parseInt(stringBuilder.toString()) % 4 == i2) {
            return i;
        } else {
            throw n.a();
        }
    }

    s a(int i, a aVar, int[] iArr) {
        StringBuilder stringBuilder = this.b;
        stringBuilder.setLength(0);
        int a = a(aVar, iArr, stringBuilder);
        String stringBuilder2 = stringBuilder.toString();
        Map a2 = a(stringBuilder2);
        s sVar = new s(stringBuilder2, null, new com.c.b.u[]{new com.c.b.u(((float) (iArr[0] + iArr[1])) / 2.0f, (float) i), new com.c.b.u((float) a, (float) i)}, com.c.b.a.UPC_EAN_EXTENSION);
        if (a2 != null) {
            sVar.a(a2);
        }
        return sVar;
    }
}
