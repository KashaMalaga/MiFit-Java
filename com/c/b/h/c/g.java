package com.c.b.h.c;

import android.support.v4.view.a.C0113o;
import b.a.C0374dh;
import com.c.b.c.d;
import com.c.b.x;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;
import kankan.wheel.widget.a;

final class g {
    private static final int a = 0;
    private static final int b = 1;
    private static final int c = 2;
    private static final int d = 0;
    private static final int e = 1;
    private static final int f = 2;
    private static final int g = 3;
    private static final int h = 900;
    private static final int i = 901;
    private static final int j = 902;
    private static final int k = 913;
    private static final int l = 924;
    private static final int m = 925;
    private static final int n = 926;
    private static final int o = 927;
    private static final byte[] p = new byte[]{(byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 38, C0374dh.k, (byte) 9, (byte) 44, (byte) 58, (byte) 35, (byte) 45, (byte) 46, (byte) 36, (byte) 47, (byte) 43, (byte) 37, (byte) 42, (byte) 61, (byte) 94, (byte) 0, (byte) 32, (byte) 0, (byte) 0, (byte) 0};
    private static final byte[] q = new byte[]{(byte) 59, (byte) 60, (byte) 62, (byte) 64, (byte) 91, (byte) 92, (byte) 93, (byte) 95, (byte) 96, a.ac, (byte) 33, C0374dh.k, (byte) 9, (byte) 44, (byte) 58, (byte) 10, (byte) 45, (byte) 46, (byte) 36, (byte) 47, (byte) 34, (byte) 124, (byte) 42, (byte) 40, (byte) 41, (byte) 63, (byte) 123, (byte) 125, (byte) 39, (byte) 0};
    private static final byte[] r = new byte[C0113o.h];
    private static final byte[] s = new byte[C0113o.h];
    private static final Charset t = Charset.forName("ISO-8859-1");

    static {
        byte b;
        byte b2 = (byte) 0;
        Arrays.fill(r, (byte) -1);
        for (b = (byte) 0; b < p.length; b = (byte) (b + e)) {
            byte b3 = p[b];
            if (b3 > (byte) 0) {
                r[b3] = b;
            }
        }
        Arrays.fill(s, (byte) -1);
        while (b2 < q.length) {
            b = q[b2];
            if (b > (byte) 0) {
                s[b] = b2;
            }
            b2 = (byte) (b2 + e);
        }
    }

    private g() {
    }

    private static int a(CharSequence charSequence, int i) {
        int i2 = d;
        int length = charSequence.length();
        if (i < length) {
            char charAt = charSequence.charAt(i);
            while (a(charAt) && i < length) {
                i2 += e;
                i += e;
                if (i < length) {
                    charAt = charSequence.charAt(i);
                }
            }
        }
        return i2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int a(java.lang.CharSequence r9, int r10, int r11, java.lang.StringBuilder r12, int r13) {
        /*
        r8 = 28;
        r7 = 27;
        r2 = 1;
        r6 = 29;
        r1 = 0;
        r5 = new java.lang.StringBuilder;
        r5.<init>(r11);
        r0 = r1;
    L_0x000e:
        r3 = r10 + r0;
        r3 = r9.charAt(r3);
        switch(r13) {
            case 0: goto L_0x0047;
            case 1: goto L_0x0080;
            case 2: goto L_0x00c1;
            default: goto L_0x0017;
        };
    L_0x0017:
        r4 = e(r3);
        if (r4 == 0) goto L_0x0112;
    L_0x001d:
        r4 = s;
        r3 = r4[r3];
        r3 = (char) r3;
        r5.append(r3);
    L_0x0025:
        r0 = r0 + 1;
        if (r0 < r11) goto L_0x000e;
    L_0x0029:
        r6 = r5.length();
        r3 = r1;
        r4 = r1;
    L_0x002f:
        if (r3 >= r6) goto L_0x0121;
    L_0x0031:
        r0 = r3 % 2;
        if (r0 == 0) goto L_0x0118;
    L_0x0035:
        r0 = r2;
    L_0x0036:
        if (r0 == 0) goto L_0x011b;
    L_0x0038:
        r0 = r4 * 30;
        r4 = r5.charAt(r3);
        r0 = r0 + r4;
        r0 = (char) r0;
        r12.append(r0);
    L_0x0043:
        r3 = r3 + 1;
        r4 = r0;
        goto L_0x002f;
    L_0x0047:
        r4 = b(r3);
        if (r4 == 0) goto L_0x005e;
    L_0x004d:
        r4 = 32;
        if (r3 != r4) goto L_0x0057;
    L_0x0051:
        r3 = 26;
        r5.append(r3);
        goto L_0x0025;
    L_0x0057:
        r3 = r3 + -65;
        r3 = (char) r3;
        r5.append(r3);
        goto L_0x0025;
    L_0x005e:
        r4 = c(r3);
        if (r4 == 0) goto L_0x0069;
    L_0x0064:
        r5.append(r7);
        r13 = r2;
        goto L_0x000e;
    L_0x0069:
        r4 = d(r3);
        if (r4 == 0) goto L_0x0074;
    L_0x006f:
        r13 = 2;
        r5.append(r8);
        goto L_0x000e;
    L_0x0074:
        r5.append(r6);
        r4 = s;
        r3 = r4[r3];
        r3 = (char) r3;
        r5.append(r3);
        goto L_0x0025;
    L_0x0080:
        r4 = c(r3);
        if (r4 == 0) goto L_0x0097;
    L_0x0086:
        r4 = 32;
        if (r3 != r4) goto L_0x0090;
    L_0x008a:
        r3 = 26;
        r5.append(r3);
        goto L_0x0025;
    L_0x0090:
        r3 = r3 + -97;
        r3 = (char) r3;
        r5.append(r3);
        goto L_0x0025;
    L_0x0097:
        r4 = b(r3);
        if (r4 == 0) goto L_0x00a8;
    L_0x009d:
        r5.append(r7);
        r3 = r3 + -65;
        r3 = (char) r3;
        r5.append(r3);
        goto L_0x0025;
    L_0x00a8:
        r4 = d(r3);
        if (r4 == 0) goto L_0x00b4;
    L_0x00ae:
        r13 = 2;
        r5.append(r8);
        goto L_0x000e;
    L_0x00b4:
        r5.append(r6);
        r4 = s;
        r3 = r4[r3];
        r3 = (char) r3;
        r5.append(r3);
        goto L_0x0025;
    L_0x00c1:
        r4 = d(r3);
        if (r4 == 0) goto L_0x00d1;
    L_0x00c7:
        r4 = r;
        r3 = r4[r3];
        r3 = (char) r3;
        r5.append(r3);
        goto L_0x0025;
    L_0x00d1:
        r4 = b(r3);
        if (r4 == 0) goto L_0x00dd;
    L_0x00d7:
        r5.append(r8);
        r13 = r1;
        goto L_0x000e;
    L_0x00dd:
        r4 = c(r3);
        if (r4 == 0) goto L_0x00e9;
    L_0x00e3:
        r5.append(r7);
        r13 = r2;
        goto L_0x000e;
    L_0x00e9:
        r4 = r10 + r0;
        r4 = r4 + 1;
        if (r4 >= r11) goto L_0x0105;
    L_0x00ef:
        r4 = r10 + r0;
        r4 = r4 + 1;
        r4 = r9.charAt(r4);
        r4 = e(r4);
        if (r4 == 0) goto L_0x0105;
    L_0x00fd:
        r13 = 3;
        r3 = 25;
        r5.append(r3);
        goto L_0x000e;
    L_0x0105:
        r5.append(r6);
        r4 = s;
        r3 = r4[r3];
        r3 = (char) r3;
        r5.append(r3);
        goto L_0x0025;
    L_0x0112:
        r5.append(r6);
        r13 = r1;
        goto L_0x000e;
    L_0x0118:
        r0 = r1;
        goto L_0x0036;
    L_0x011b:
        r0 = r5.charAt(r3);
        goto L_0x0043;
    L_0x0121:
        r0 = r6 % 2;
        if (r0 == 0) goto L_0x012d;
    L_0x0125:
        r0 = r4 * 30;
        r0 = r0 + 29;
        r0 = (char) r0;
        r12.append(r0);
    L_0x012d:
        return r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.b.h.c.g.a(java.lang.CharSequence, int, int, java.lang.StringBuilder, int):int");
    }

    private static int a(CharSequence charSequence, byte[] bArr, int i) {
        int length = charSequence.length();
        int i2 = i;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            int i3 = d;
            while (i3 < 13 && a(r1)) {
                i3 += e;
                int i4 = i2 + i3;
                if (i4 >= length) {
                    break;
                }
                charAt = charSequence.charAt(i4);
            }
            if (i3 >= 13) {
                return i2 - i;
            }
            char charAt2 = charSequence.charAt(i2);
            if (bArr[i2] != (byte) 63 || charAt2 == '?') {
                i2 += e;
            } else {
                throw new x("Non-encodable character detected: " + charAt2 + " (Unicode: " + charAt2 + ')');
            }
        }
        return i2 - i;
    }

    static String a(String str, c cVar, Charset charset) {
        StringBuilder stringBuilder = new StringBuilder(str.length());
        if (charset == null) {
            charset = t;
        } else if (!t.equals(charset)) {
            d a = d.a(charset.name());
            if (a != null) {
                a(a.a(), stringBuilder);
            }
        }
        int length = str.length();
        byte[] bArr = null;
        if (cVar == c.TEXT) {
            a((CharSequence) str, (int) d, length, stringBuilder, (int) d);
        } else if (cVar == c.BYTE) {
            bArr = str.getBytes(charset);
            a(bArr, (int) d, bArr.length, (int) e, stringBuilder);
        } else if (cVar == c.NUMERIC) {
            stringBuilder.append('\u0386');
            a(str, d, length, stringBuilder);
        } else {
            int i = d;
            int i2 = d;
            int i3 = d;
            while (i3 < length) {
                int a2 = a((CharSequence) str, i3);
                if (a2 >= 13) {
                    stringBuilder.append('\u0386');
                    i = f;
                    a(str, i3, a2, stringBuilder);
                    i3 += a2;
                    i2 = d;
                } else {
                    int b = b(str, i3);
                    if (b >= 5 || a2 == length) {
                        if (i != 0) {
                            stringBuilder.append('\u0384');
                            i = d;
                            i2 = d;
                        }
                        i2 = a((CharSequence) str, i3, b, stringBuilder, i2);
                        i3 += b;
                    } else {
                        if (bArr == null) {
                            bArr = str.getBytes(charset);
                        }
                        a2 = a((CharSequence) str, bArr, i3);
                        if (a2 == 0) {
                            a2 = e;
                        }
                        if (a2 == e && i == 0) {
                            a(bArr, i3, (int) e, (int) d, stringBuilder);
                        } else {
                            a(bArr, i3, a2, i, stringBuilder);
                            i = e;
                            i2 = d;
                        }
                        i3 += a2;
                    }
                }
            }
        }
        return stringBuilder.toString();
    }

    private static void a(int i, StringBuilder stringBuilder) {
        if (i >= 0 && i < h) {
            stringBuilder.append('\u039f');
            stringBuilder.append((char) i);
        } else if (i < 810900) {
            stringBuilder.append('\u039e');
            stringBuilder.append((char) ((i / h) - 1));
            stringBuilder.append((char) (i % h));
        } else if (i < 811800) {
            stringBuilder.append('\u039d');
            stringBuilder.append((char) (810900 - i));
        } else {
            throw new x("ECI number not in valid range from 0..811799, but was " + i);
        }
    }

    private static void a(String str, int i, int i2, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder((i2 / g) + e);
        BigInteger valueOf = BigInteger.valueOf(900);
        BigInteger valueOf2 = BigInteger.valueOf(0);
        int i3 = d;
        while (i3 < i2) {
            stringBuilder2.setLength(d);
            int min = Math.min(44, i2 - i3);
            BigInteger bigInteger = new BigInteger('1' + str.substring(i + i3, (i + i3) + min));
            do {
                stringBuilder2.append((char) bigInteger.mod(valueOf).intValue());
                bigInteger = bigInteger.divide(valueOf);
            } while (!bigInteger.equals(valueOf2));
            for (int length = stringBuilder2.length() - 1; length >= 0; length--) {
                stringBuilder.append(stringBuilder2.charAt(length));
            }
            i3 += min;
        }
    }

    private static void a(byte[] bArr, int i, int i2, int i3, StringBuilder stringBuilder) {
        int i4;
        if (i2 == e && i3 == 0) {
            stringBuilder.append('\u0391');
        } else {
            if ((i2 % 6 == 0 ? e : null) != null) {
                stringBuilder.append('\u039c');
            } else {
                stringBuilder.append('\u0385');
            }
        }
        if (i2 >= 6) {
            char[] cArr = new char[5];
            i4 = i;
            while ((i + i2) - i4 >= 6) {
                int i5;
                long j = 0;
                for (i5 = d; i5 < 6; i5 += e) {
                    j = (j << 8) + ((long) (bArr[i4 + i5] & HeartRateInfo.HR_EMPTY_VALUE));
                }
                for (i5 = d; i5 < 5; i5 += e) {
                    cArr[i5] = (char) ((int) (j % 900));
                    j /= 900;
                }
                for (i5 = cArr.length - 1; i5 >= 0; i5--) {
                    stringBuilder.append(cArr[i5]);
                }
                i4 += 6;
            }
        } else {
            i4 = i;
        }
        while (i4 < i + i2) {
            stringBuilder.append((char) (bArr[i4] & HeartRateInfo.HR_EMPTY_VALUE));
            i4 += e;
        }
    }

    private static boolean a(char c) {
        return c >= '0' && c <= '9';
    }

    private static int b(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = i;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            int i3 = d;
            while (i3 < 13 && a(r2) && i2 < length) {
                i3 += e;
                int i4 = i2 + e;
                if (i4 < length) {
                    charAt = charSequence.charAt(i4);
                    i2 = i4;
                } else {
                    i2 = i4;
                }
            }
            if (i3 >= 13) {
                return (i2 - i) - i3;
            }
            if (i3 <= 0) {
                if (!f(charSequence.charAt(i2))) {
                    break;
                }
                i2 += e;
            }
        }
        return i2 - i;
    }

    private static boolean b(char c) {
        return c == ' ' || (c >= 'A' && c <= 'Z');
    }

    private static boolean c(char c) {
        return c == ' ' || (c >= 'a' && c <= 'z');
    }

    private static boolean d(char c) {
        return r[c] != (byte) -1;
    }

    private static boolean e(char c) {
        return s[c] != (byte) -1;
    }

    private static boolean f(char c) {
        return c == '\t' || c == '\n' || c == '\r' || (c >= ' ' && c <= '~');
    }
}
