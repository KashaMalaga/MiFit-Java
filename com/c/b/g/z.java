package com.c.b.g;

import cn.com.smartdevices.bracelet.Constant;
import com.c.b.n;
import kankan.wheel.widget.a;

public final class z extends x {
    private static final int[] a = new int[]{1, 1, 1, 1, 1, 1};
    private static final int[][] f = new int[][]{new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};
    private final int[] g = new int[4];

    private static void a(StringBuilder stringBuilder, int i) {
        for (int i2 = 0; i2 <= 1; i2++) {
            for (int i3 = 0; i3 < 10; i3++) {
                if (i == f[i2][i3]) {
                    stringBuilder.insert(0, (char) (i2 + 48));
                    stringBuilder.append((char) (i3 + 48));
                    return;
                }
            }
        }
        throw n.a();
    }

    public static String b(String str) {
        char[] cArr = new char[6];
        str.getChars(1, 7, cArr, 0);
        StringBuilder stringBuilder = new StringBuilder(12);
        stringBuilder.append(str.charAt(0));
        char c = cArr[5];
        switch (c) {
            case Constant.bh /*48*/:
            case a.az /*49*/:
            case a.aS /*50*/:
                stringBuilder.append(cArr, 0, 2);
                stringBuilder.append(c);
                stringBuilder.append("0000");
                stringBuilder.append(cArr, 2, 3);
                break;
            case '3':
                stringBuilder.append(cArr, 0, 3);
                stringBuilder.append("00000");
                stringBuilder.append(cArr, 3, 2);
                break;
            case '4':
                stringBuilder.append(cArr, 0, 4);
                stringBuilder.append("00000");
                stringBuilder.append(cArr[4]);
                break;
            default:
                stringBuilder.append(cArr, 0, 5);
                stringBuilder.append("0000");
                stringBuilder.append(c);
                break;
        }
        stringBuilder.append(str.charAt(7));
        return stringBuilder.toString();
    }

    protected int a(com.c.b.c.a aVar, int[] iArr, StringBuilder stringBuilder) {
        int[] iArr2 = this.g;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int a = aVar.a();
        int i = iArr[1];
        int i2 = 0;
        int i3 = 0;
        while (i2 < 6 && i < a) {
            int a2 = x.a(aVar, iArr2, i, e);
            stringBuilder.append((char) ((a2 % 10) + 48));
            int i4 = i;
            for (int i5 : iArr2) {
                i4 += i5;
            }
            if (a2 >= 10) {
                i3 |= 1 << (5 - i2);
            }
            i2++;
            i = i4;
        }
        a(stringBuilder, i3);
        return i;
    }

    protected boolean a(String str) {
        return super.a(b(str));
    }

    protected int[] a(com.c.b.c.a aVar, int i) {
        return x.a(aVar, i, true, a);
    }

    com.c.b.a b() {
        return com.c.b.a.UPC_E;
    }
}
