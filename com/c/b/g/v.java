package com.c.b.g;

import cn.com.smartdevices.bracelet.Constant;
import com.c.b.n;
import com.c.b.s;
import com.c.b.t;
import com.c.b.u;
import com.tencent.connect.common.Constants;
import com.xiaomi.e.a;
import java.util.EnumMap;
import java.util.Map;

final class v {
    private static final int[] a = new int[]{24, 20, 18, 17, 12, 6, 3, 10, 9, 5};
    private final int[] b = new int[4];
    private final StringBuilder c = new StringBuilder();

    v() {
    }

    private static int a(int i) {
        for (int i2 = 0; i2 < 10; i2++) {
            if (i == a[i2]) {
                return i2;
            }
        }
        throw n.a();
    }

    private static int a(CharSequence charSequence) {
        int i;
        int length = charSequence.length();
        int i2 = 0;
        for (i = length - 2; i >= 0; i -= 2) {
            i2 += charSequence.charAt(i) - 48;
        }
        i2 *= 3;
        for (i = length - 1; i >= 0; i -= 2) {
            i2 += charSequence.charAt(i) - 48;
        }
        return (i2 * 3) % 10;
    }

    private static Map<t, Object> a(String str) {
        if (str.length() != 5) {
            return null;
        }
        String b = b(str);
        if (b == null) {
            return null;
        }
        Map<t, Object> enumMap = new EnumMap(t.class);
        enumMap.put(t.SUGGESTED_PRICE, b);
        return enumMap;
    }

    private static String b(String str) {
        String str2;
        switch (str.charAt(0)) {
            case Constant.bh /*48*/:
                str2 = "\u00a3";
                break;
            case '5':
                str2 = "$";
                break;
            case '9':
                if (!"90000".equals(str)) {
                    if (!"99991".equals(str)) {
                        if (!"99990".equals(str)) {
                            str2 = a.f;
                            break;
                        }
                        return "Used";
                    }
                    return "0.00";
                }
                return null;
            default:
                str2 = a.f;
                break;
        }
        int parseInt = Integer.parseInt(str.substring(1));
        String valueOf = String.valueOf(parseInt / 100);
        parseInt %= 100;
        return str2 + valueOf + '.' + (parseInt < 10 ? Constants.VIA_RESULT_SUCCESS + parseInt : String.valueOf(parseInt));
    }

    int a(com.c.b.c.a aVar, int[] iArr, StringBuilder stringBuilder) {
        int[] iArr2 = this.b;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int a = aVar.a();
        int i = iArr[1];
        int i2 = 0;
        for (int i3 = 0; i3 < 5 && i < a; i3++) {
            int a2 = x.a(aVar, iArr2, i, x.e);
            stringBuilder.append((char) ((a2 % 10) + 48));
            int i4 = 0;
            while (i4 < iArr2.length) {
                int i5 = iArr2[i4] + i;
                i4++;
                i = i5;
            }
            if (a2 >= 10) {
                i2 |= 1 << (4 - i3);
            }
            if (i3 != 4) {
                i = aVar.e(aVar.d(i));
            }
        }
        if (stringBuilder.length() != 5) {
            throw n.a();
        }
        if (a(stringBuilder.toString()) == a(i2)) {
            return i;
        }
        throw n.a();
    }

    s a(int i, com.c.b.c.a aVar, int[] iArr) {
        StringBuilder stringBuilder = this.c;
        stringBuilder.setLength(0);
        int a = a(aVar, iArr, stringBuilder);
        String stringBuilder2 = stringBuilder.toString();
        Map a2 = a(stringBuilder2);
        s sVar = new s(stringBuilder2, null, new u[]{new u(((float) (iArr[0] + iArr[1])) / 2.0f, (float) i), new u((float) a, (float) i)}, com.c.b.a.UPC_EAN_EXTENSION);
        if (a2 != null) {
            sVar.a(a2);
        }
        return sVar;
    }
}
