package com.c.b.g;

import cn.com.smartdevices.bracelet.model.ShareData;
import com.c.b.a;
import com.c.b.c.b;
import com.c.b.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class d extends r {
    private static final int a = 104;
    private static final int b = 105;
    private static final int c = 100;
    private static final int d = 99;
    private static final int e = 106;
    private static final char f = '\u00f1';
    private static final char g = '\u00f2';
    private static final char h = '\u00f3';
    private static final char i = '\u00f4';
    private static final int j = 102;
    private static final int k = 97;
    private static final int l = 96;
    private static final int m = 100;

    private static boolean a(CharSequence charSequence, int i, int i2) {
        int i3 = i + i2;
        int length = charSequence.length();
        while (i < i3 && i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < '0' || charAt > '9') {
                if (charAt != f) {
                    return false;
                }
                i3++;
            }
            i++;
        }
        return i3 <= length;
    }

    public b a(String str, a aVar, int i, int i2, Map<g, ?> map) {
        if (aVar == a.CODE_128) {
            return super.a(str, aVar, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got " + aVar);
    }

    public boolean[] a(String str) {
        int i = 0;
        int length = str.length();
        if (length < 1 || length > 80) {
            throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got " + length);
        }
        int i2;
        for (i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt < ' ' || charAt > '~') {
                switch (charAt) {
                    case '\u00f1':
                    case '\u00f2':
                    case '\u00f3':
                    case '\u00f4':
                        break;
                    default:
                        throw new IllegalArgumentException("Bad character in input: " + charAt);
                }
            }
        }
        Collection<int[]> arrayList = new ArrayList();
        int i3 = 0;
        int i4 = 0;
        int i5 = 1;
        int i6 = 0;
        while (i3 < length) {
            int i7 = a(str, i3, i4 == d ? 2 : 4) ? d : m;
            if (i7 == i4) {
                switch (str.charAt(i3)) {
                    case '\u00f1':
                        i2 = j;
                        break;
                    case '\u00f2':
                        i2 = k;
                        break;
                    case '\u00f3':
                        i2 = l;
                        break;
                    case '\u00f4':
                        i2 = m;
                        break;
                    default:
                        if (i4 != m) {
                            i2 = Integer.parseInt(str.substring(i3, i3 + 2));
                            i3++;
                            break;
                        }
                        i2 = str.charAt(i3) - 32;
                        break;
                }
                i3++;
                i7 = i4;
            } else {
                i2 = i4 == 0 ? i7 == m ? a : b : i7;
            }
            arrayList.add(c.a[i2]);
            i4 = i6 + (i2 * i5);
            i5 = i3 != 0 ? i5 + 1 : i5;
            i6 = i4;
            i4 = i7;
        }
        arrayList.add(c.a[i6 % ShareData.SHARE_TYPE_LAB_SITUP_ACCUMULATE]);
        arrayList.add(c.a[e]);
        int i8 = 0;
        for (int[] iArr : arrayList) {
            i3 = 0;
            while (i3 < iArr.length) {
                i7 = iArr[i3] + i8;
                i3++;
                i8 = i7;
            }
        }
        boolean[] zArr = new boolean[i8];
        for (int[] iArr2 : arrayList) {
            i += r.a(zArr, i, iArr2, true);
        }
        return zArr;
    }
}
