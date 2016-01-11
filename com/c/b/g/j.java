package com.c.b.g;

import com.c.b.c.a;

public final class j extends x {
    private final int[] a = new int[4];

    protected int a(a aVar, int[] iArr, StringBuilder stringBuilder) {
        int[] iArr2 = this.a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int a = aVar.a();
        int i = iArr[1];
        int i2 = 0;
        while (i2 < 4 && i < a) {
            stringBuilder.append((char) (x.a(aVar, iArr2, i, d) + 48));
            int i3 = i;
            for (int i4 : iArr2) {
                i3 += i4;
            }
            i2++;
            i = i3;
        }
        i = x.a(aVar, i, true, c)[1];
        i2 = 0;
        while (i2 < 4 && i < a) {
            stringBuilder.append((char) (x.a(aVar, iArr2, i, d) + 48));
            i3 = i;
            for (int i42 : iArr2) {
                i3 += i42;
            }
            i2++;
            i = i3;
        }
        return i;
    }

    com.c.b.a b() {
        return com.c.b.a.EAN_8;
    }
}
