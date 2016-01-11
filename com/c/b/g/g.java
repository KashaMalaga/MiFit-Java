package com.c.b.g;

import cn.com.smartdevices.bracelet.gps.c.a;
import com.c.b.d;
import com.c.b.e;
import com.c.b.h;
import com.c.b.n;
import com.c.b.s;
import com.c.b.u;
import com.huami.android.widget.share.m;
import java.util.Arrays;
import java.util.Map;

public final class g extends q {
    private static final String a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*";
    private static final char[] b = a.toCharArray();
    private static final int[] c = new int[]{276, 328, 324, 322, 296, 292, 290, 336, 274, 266, 424, 420, 418, 404, 402, 394, a.e, 356, 354, 308, 282, 344, 332, 326, m.n, 278, 436, 434, 428, 422, 406, 410, 364, 358, 310, 314, 302, 468, 466, 458, 366, 374, 430, 294, 474, 470, 306, 350};
    private static final int d = c[47];
    private final StringBuilder e = new StringBuilder(20);
    private final int[] f = new int[6];

    private static char a(int i) {
        for (int i2 = 0; i2 < c.length; i2++) {
            if (c[i2] == i) {
                return b[i2];
            }
        }
        throw n.a();
    }

    private static int a(int[] iArr) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (i < iArr.length) {
            i++;
            i2 = iArr[i] + i2;
        }
        i = 0;
        for (int i3 = 0; i3 < length; i3++) {
            int round = Math.round((((float) iArr[i3]) * 9.0f) / ((float) i2));
            if (round < 1 || round > 4) {
                return -1;
            }
            if ((i3 & 1) == 0) {
                int i4 = 0;
                while (i4 < round) {
                    i4++;
                    i = (i << 1) | 1;
                }
            } else {
                i <<= round;
            }
        }
        return i;
    }

    private static String a(CharSequence charSequence) {
        int length = charSequence.length();
        StringBuilder stringBuilder = new StringBuilder(length);
        int i = 0;
        while (i < length) {
            int i2;
            char charAt = charSequence.charAt(i);
            if (charAt < 'a' || charAt > 'd') {
                stringBuilder.append(charAt);
                i2 = i;
            } else if (i >= length - 1) {
                throw h.a();
            } else {
                char charAt2 = charSequence.charAt(i + 1);
                switch (charAt) {
                    case 'a':
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            charAt = (char) (charAt2 - 64);
                            break;
                        }
                        throw h.a();
                        break;
                    case 'b':
                        if (charAt2 < 'A' || charAt2 > 'E') {
                            if (charAt2 >= 'F' && charAt2 <= 'W') {
                                charAt = (char) (charAt2 - 11);
                                break;
                            }
                            throw h.a();
                        }
                        charAt = (char) (charAt2 - 38);
                        break;
                        break;
                    case 'c':
                        if (charAt2 >= 'A' && charAt2 <= 'O') {
                            charAt = (char) (charAt2 - 32);
                            break;
                        } else if (charAt2 == 'Z') {
                            charAt = ':';
                            break;
                        } else {
                            throw h.a();
                        }
                    case kankan.wheel.widget.a.ar /*100*/:
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            charAt = (char) (charAt2 + 32);
                            break;
                        }
                        throw h.a();
                        break;
                    default:
                        charAt = '\u0000';
                        break;
                }
                stringBuilder.append(charAt);
                i2 = i + 1;
            }
            i = i2 + 1;
        }
        return stringBuilder.toString();
    }

    private static void a(CharSequence charSequence, int i, int i2) {
        int i3 = 1;
        int i4 = i - 1;
        int i5 = 0;
        while (i4 >= 0) {
            int indexOf = (a.indexOf(charSequence.charAt(i4)) * i3) + i5;
            i5 = i3 + 1;
            if (i5 > i2) {
                i5 = 1;
            }
            i4--;
            i3 = i5;
            i5 = indexOf;
        }
        if (charSequence.charAt(i) != b[i5 % 47]) {
            throw d.a();
        }
    }

    private int[] a(com.c.b.c.a aVar) {
        int a = aVar.a();
        int d = aVar.d(0);
        Arrays.fill(this.f, 0);
        int[] iArr = this.f;
        int length = iArr.length;
        int i = 0;
        int i2 = d;
        d = 0;
        for (int i3 = d; i3 < a; i3++) {
            if ((aVar.a(i3) ^ i) != 0) {
                iArr[d] = iArr[d] + 1;
            } else {
                if (d != length - 1) {
                    d++;
                } else if (a(iArr) == d) {
                    return new int[]{i2, i3};
                } else {
                    i2 += iArr[0] + iArr[1];
                    System.arraycopy(iArr, 2, iArr, 0, length - 2);
                    iArr[length - 2] = 0;
                    iArr[length - 1] = 0;
                    d--;
                }
                iArr[d] = 1;
                i = i == 0 ? 1 : 0;
            }
        }
        throw n.a();
    }

    private static void b(CharSequence charSequence) {
        int length = charSequence.length();
        a(charSequence, length - 2, 20);
        a(charSequence, length - 1, 15);
    }

    public s a(int i, com.c.b.c.a aVar, Map<e, ?> map) {
        int d = aVar.d(a(aVar)[1]);
        int a = aVar.a();
        int[] iArr = this.f;
        Arrays.fill(iArr, 0);
        CharSequence charSequence = this.e;
        charSequence.setLength(0);
        while (true) {
            q.a(aVar, d, iArr);
            int a2 = a(iArr);
            if (a2 < 0) {
                throw n.a();
            }
            char a3 = a(a2);
            charSequence.append(a3);
            int i2 = d;
            for (int i3 : iArr) {
                i2 += i3;
            }
            a2 = aVar.d(i2);
            if (a3 == '*') {
                break;
            }
            d = a2;
        }
        charSequence.deleteCharAt(charSequence.length() - 1);
        int i4 = 0;
        for (int i32 : iArr) {
            i4 += i32;
        }
        if (a2 == a || !aVar.a(a2)) {
            throw n.a();
        } else if (charSequence.length() < 2) {
            throw n.a();
        } else {
            b(charSequence);
            charSequence.setLength(charSequence.length() - 2);
            float f = ((float) d) + (((float) i4) / 2.0f);
            return new s(a(charSequence), null, new u[]{new u(((float) (r4[1] + r4[0])) / 2.0f, (float) i), new u(f, (float) i)}, com.c.b.a.CODE_93);
        }
    }
}
