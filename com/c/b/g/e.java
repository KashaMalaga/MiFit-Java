package com.c.b.g;

import cn.com.smartdevices.bracelet.upgrade.i;
import com.c.b.c.a;
import com.c.b.d;
import com.c.b.h;
import com.c.b.n;
import com.c.b.s;
import com.c.b.u;
import java.util.Arrays;
import java.util.Map;

public final class e extends q {
    static final String a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%";
    static final int[] b = new int[]{52, 289, 97, 352, 49, 304, 112, 37, 292, 100, i.c, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, 448, 145, 400, 208, 133, 388, 196, 148, 168, 162, 138, 42};
    private static final char[] c = a.toCharArray();
    private static final int d = b[39];
    private final boolean e;
    private final boolean f;
    private final StringBuilder g;
    private final int[] h;

    public e() {
        this(false);
    }

    public e(boolean z) {
        this(z, false);
    }

    public e(boolean z, boolean z2) {
        this.e = z;
        this.f = z2;
        this.g = new StringBuilder(20);
        this.h = new int[9];
    }

    private static char a(int i) {
        for (int i2 = 0; i2 < b.length; i2++) {
            if (b[i2] == i) {
                return c[i2];
            }
        }
        throw n.a();
    }

    private static int a(int[] iArr) {
        int i;
        int i2;
        int length = iArr.length;
        int i3 = 0;
        while (true) {
            int i4 = Integer.MAX_VALUE;
            for (int i5 : iArr) {
                if (i5 < i4 && i5 > r0) {
                    i4 = i5;
                }
            }
            i3 = 0;
            int i52 = 0;
            i = 0;
            for (i2 = 0; i2 < length; i2++) {
                int i6 = iArr[i2];
                if (i6 > i4) {
                    i3 |= 1 << ((length - 1) - i2);
                    i++;
                    i52 += i6;
                }
            }
            if (i == 3) {
                break;
            } else if (i <= 3) {
                return -1;
            } else {
                i3 = i4;
            }
        }
        int i7 = i;
        for (i = 0; i < length && i7 > 0; i++) {
            i2 = iArr[i];
            if (i2 > i4) {
                i7--;
                if (i2 * 2 >= i52) {
                    return -1;
                }
            }
        }
        return i3;
    }

    private static String a(CharSequence charSequence) {
        int length = charSequence.length();
        StringBuilder stringBuilder = new StringBuilder(length);
        int i = 0;
        while (i < length) {
            int i2;
            char charAt = charSequence.charAt(i);
            if (charAt == '+' || charAt == '$' || charAt == '%' || charAt == '/') {
                char charAt2 = charSequence.charAt(i + 1);
                switch (charAt) {
                    case '$':
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            charAt = (char) (charAt2 - 64);
                            break;
                        }
                        throw h.a();
                        break;
                    case '%':
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
                    case '+':
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            charAt = (char) (charAt2 + 32);
                            break;
                        }
                        throw h.a();
                        break;
                    case '/':
                        if (charAt2 >= 'A' && charAt2 <= 'O') {
                            charAt = (char) (charAt2 - 32);
                            break;
                        } else if (charAt2 == 'Z') {
                            charAt = ':';
                            break;
                        } else {
                            throw h.a();
                        }
                    default:
                        charAt = '\u0000';
                        break;
                }
                stringBuilder.append(charAt);
                i2 = i + 1;
            } else {
                stringBuilder.append(charAt);
                i2 = i;
            }
            i = i2 + 1;
        }
        return stringBuilder.toString();
    }

    private static int[] a(a aVar, int[] iArr) {
        int a = aVar.a();
        int d = aVar.d(0);
        int length = iArr.length;
        int i = d;
        int i2 = 0;
        int i3 = 0;
        while (i < a) {
            if ((aVar.a(i) ^ i2) != 0) {
                iArr[i3] = iArr[i3] + 1;
            } else {
                if (i3 != length - 1) {
                    i3++;
                } else if (a(iArr) == d && aVar.a(Math.max(0, d - ((i - d) / 2)), d, false)) {
                    return new int[]{d, i};
                } else {
                    d += iArr[0] + iArr[1];
                    System.arraycopy(iArr, 2, iArr, 0, length - 2);
                    iArr[length - 2] = 0;
                    iArr[length - 1] = 0;
                    i3--;
                }
                iArr[i3] = 1;
                i2 = i2 == 0 ? 1 : 0;
            }
            i++;
        }
        throw n.a();
    }

    public s a(int i, a aVar, Map<com.c.b.e, ?> map) {
        int a;
        int i2;
        int[] iArr = this.h;
        Arrays.fill(iArr, 0);
        CharSequence charSequence = this.g;
        charSequence.setLength(0);
        int d = aVar.d(a(aVar, iArr)[1]);
        int a2 = aVar.a();
        while (true) {
            q.a(aVar, d, iArr);
            a = a(iArr);
            if (a < 0) {
                throw n.a();
            }
            char a3 = a(a);
            charSequence.append(a3);
            i2 = d;
            for (int i3 : iArr) {
                i2 += i3;
            }
            a = aVar.d(i2);
            if (a3 == '*') {
                break;
            }
            d = a;
        }
        charSequence.setLength(charSequence.length() - 1);
        int i4 = 0;
        for (int i32 : iArr) {
            i4 += i32;
        }
        i2 = (a - d) - i4;
        if (a == a2 || i2 * 2 >= i4) {
            if (this.e) {
                int length = charSequence.length() - 1;
                i2 = 0;
                for (a = 0; a < length; a++) {
                    i2 += a.indexOf(this.g.charAt(a));
                }
                if (charSequence.charAt(length) != c[i2 % 43]) {
                    throw d.a();
                }
                charSequence.setLength(length);
            }
            if (charSequence.length() == 0) {
                throw n.a();
            }
            float f = ((float) d) + (((float) i4) / 2.0f);
            return new s(this.f ? a(charSequence) : charSequence.toString(), null, new u[]{new u(((float) (r6[1] + r6[0])) / 2.0f, (float) i), new u(f, (float) i)}, com.c.b.a.CODE_39);
        }
        throw n.a();
    }
}
