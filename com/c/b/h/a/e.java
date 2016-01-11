package com.c.b.h.a;

import com.c.b.c.d;
import com.c.b.h;
import com.c.b.h.c;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;

final class e {
    private static final int a = 900;
    private static final int b = 901;
    private static final int c = 902;
    private static final int d = 924;
    private static final int e = 925;
    private static final int f = 926;
    private static final int g = 927;
    private static final int h = 928;
    private static final int i = 923;
    private static final int j = 922;
    private static final int k = 913;
    private static final int l = 15;
    private static final int m = 25;
    private static final int n = 27;
    private static final int o = 27;
    private static final int p = 28;
    private static final int q = 28;
    private static final int r = 29;
    private static final int s = 29;
    private static final char[] t = new char[]{';', '<', '>', '@', '[', '\\', ']', '_', '`', '~', '!', '\r', '\t', ',', ':', '\n', '-', '.', '$', '/', '\"', '|', '*', '(', ')', '?', '{', '}', '\''};
    private static final char[] u = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '&', '\r', '\t', ',', ':', '#', '-', '.', '$', '/', '+', '%', '*', '=', '^'};
    private static final Charset v = Charset.forName("ISO-8859-1");
    private static final BigInteger[] w = new BigInteger[16];
    private static final int x = 2;

    static {
        w[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900);
        w[1] = valueOf;
        for (int i = x; i < w.length; i++) {
            w[i] = w[i - 1].multiply(valueOf);
        }
    }

    private e() {
    }

    private static int a(int i, int[] iArr, Charset charset, int i2, StringBuilder stringBuilder) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i3;
        long j;
        int i4;
        int i5;
        if (i == b) {
            i3 = 0;
            j = 0;
            int[] iArr2 = new int[6];
            Object obj = null;
            i4 = i2 + 1;
            int i6 = iArr[i2];
            int i7 = i4;
            while (i7 < iArr[0] && r3 == null) {
                i4 = i3 + 1;
                iArr2[i3] = i6;
                j = (j * 900) + ((long) i6);
                int i8 = i7 + 1;
                i6 = iArr[i7];
                if (i6 == a || i6 == b || i6 == c || i6 == d || i6 == h || i6 == i || i6 == j) {
                    obj = 1;
                    i7 = i8 - 1;
                    i3 = i4;
                } else if (i4 % 5 != 0 || i4 <= 0) {
                    i3 = i4;
                    i7 = i8;
                } else {
                    for (i3 = 0; i3 < 6; i3++) {
                        byteArrayOutputStream.write((byte) ((int) (j >> ((5 - i3) * 8))));
                    }
                    j = 0;
                    i3 = 0;
                    i7 = i8;
                }
            }
            if (i7 == iArr[0] && i6 < a) {
                i5 = i3 + 1;
                iArr2[i3] = i6;
                i3 = i5;
            }
            for (i6 = 0; i6 < i3; i6++) {
                byteArrayOutputStream.write((byte) iArr2[i6]);
            }
            i2 = i7;
        } else if (i == d) {
            i5 = 0;
            j = 0;
            Object obj2 = null;
            while (i2 < iArr[0] && r2 == null) {
                i3 = i2 + 1;
                i4 = iArr[i2];
                if (i4 < a) {
                    i5++;
                    j = (j * 900) + ((long) i4);
                    i2 = i3;
                } else if (i4 == a || i4 == b || i4 == c || i4 == d || i4 == h || i4 == i || i4 == j) {
                    i2 = i3 - 1;
                    obj2 = 1;
                } else {
                    i2 = i3;
                }
                if (i5 % 5 == 0 && i5 > 0) {
                    for (i5 = 0; i5 < 6; i5++) {
                        byteArrayOutputStream.write((byte) ((int) (j >> ((5 - i5) * 8))));
                    }
                    j = 0;
                    i5 = 0;
                }
            }
        }
        stringBuilder.append(new String(byteArrayOutputStream.toByteArray(), charset));
        return i2;
    }

    private static int a(int[] iArr, int i, c cVar) {
        if (i + x > iArr[0]) {
            throw h.a();
        }
        int[] iArr2 = new int[x];
        int i2 = 0;
        while (i2 < x) {
            iArr2[i2] = iArr[i];
            i2++;
            i++;
        }
        cVar.a(Integer.parseInt(a(iArr2, (int) x)));
        StringBuilder stringBuilder = new StringBuilder();
        int a = a(iArr, i, stringBuilder);
        cVar.a(stringBuilder.toString());
        if (iArr[a] == i) {
            i2 = a + 1;
            int[] iArr3 = new int[(iArr[0] - i2)];
            int i3 = 0;
            a = i2;
            i2 = 0;
            while (a < iArr[0] && r0 == 0) {
                int i4 = a + 1;
                int i5 = iArr[a];
                if (i5 < a) {
                    a = i3 + 1;
                    iArr3[i3] = i5;
                    i3 = a;
                    a = i4;
                } else {
                    switch (i5) {
                        case j /*922*/:
                            cVar.a(true);
                            a = i4 + 1;
                            i2 = true;
                            break;
                        default:
                            throw h.a();
                    }
                }
            }
            cVar.a(Arrays.copyOf(iArr3, i3));
            return a;
        } else if (iArr[a] != j) {
            return a;
        } else {
            cVar.a(true);
            return a + 1;
        }
    }

    private static int a(int[] iArr, int i, StringBuilder stringBuilder) {
        int[] iArr2 = new int[((iArr[0] - i) * x)];
        int[] iArr3 = new int[((iArr[0] - i) * x)];
        int i2 = 0;
        int i3 = 0;
        while (i < iArr[0] && r0 == 0) {
            int i4 = i + 1;
            int i5 = iArr[i];
            if (i5 >= a) {
                switch (i5) {
                    case a /*900*/:
                        i5 = i3 + 1;
                        iArr2[i3] = a;
                        i3 = i5;
                        i = i4;
                        break;
                    case b /*901*/:
                    case c /*902*/:
                    case j /*922*/:
                    case i /*923*/:
                    case d /*924*/:
                    case h /*928*/:
                        i = i4 - 1;
                        i2 = 1;
                        break;
                    case k /*913*/:
                        iArr2[i3] = k;
                        i = i4 + 1;
                        iArr3[i3] = iArr[i4];
                        i3++;
                        break;
                    default:
                        i = i4;
                        break;
                }
            }
            iArr2[i3] = i5 / 30;
            iArr2[i3 + 1] = i5 % 30;
            i3 += x;
            i = i4;
        }
        a(iArr2, iArr3, i3, stringBuilder);
        return i;
    }

    static com.c.b.c.e a(int[] iArr, String str) {
        StringBuilder stringBuilder = new StringBuilder(iArr.length * x);
        Charset charset = v;
        int i = x;
        int i2 = iArr[1];
        Object cVar = new c();
        while (i < iArr[0]) {
            switch (i2) {
                case a /*900*/:
                    i2 = a(iArr, i, stringBuilder);
                    break;
                case b /*901*/:
                case d /*924*/:
                    i2 = a(i2, iArr, charset, i, stringBuilder);
                    break;
                case c /*902*/:
                    i2 = b(iArr, i, stringBuilder);
                    break;
                case k /*913*/:
                    i2 = i + 1;
                    stringBuilder.append((char) iArr[i]);
                    break;
                case j /*922*/:
                case i /*923*/:
                    throw h.a();
                case e /*925*/:
                    i2 = i + 1;
                    break;
                case f /*926*/:
                    i2 = i + x;
                    break;
                case g /*927*/:
                    i2 = i + 1;
                    charset = Charset.forName(d.a(iArr[i]).name());
                    break;
                case h /*928*/:
                    i2 = a(iArr, i, (c) cVar);
                    break;
                default:
                    i2 = a(iArr, i - 1, stringBuilder);
                    break;
            }
            if (i2 < iArr.length) {
                i = i2 + 1;
                i2 = iArr[i2];
            } else {
                throw h.a();
            }
        }
        if (stringBuilder.length() == 0) {
            throw h.a();
        }
        com.c.b.c.e eVar = new com.c.b.c.e(null, stringBuilder.toString(), null, str);
        eVar.a(cVar);
        return eVar;
    }

    private static String a(int[] iArr, int i) {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i2 = 0; i2 < i; i2++) {
            bigInteger = bigInteger.add(w[(i - i2) - 1].multiply(BigInteger.valueOf((long) iArr[i2])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw h.a();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(int[] r8, int[] r9, int r10, java.lang.StringBuilder r11) {
        /*
        r2 = com.c.b.h.a.g.ALPHA;
        r1 = com.c.b.h.a.g.ALPHA;
        r0 = 0;
        r3 = r0;
    L_0x0006:
        if (r3 >= r10) goto L_0x0146;
    L_0x0008:
        r4 = r8[r3];
        r0 = 0;
        r5 = com.c.b.h.a.f.a;
        r6 = r2.ordinal();
        r5 = r5[r6];
        switch(r5) {
            case 1: goto L_0x001f;
            case 2: goto L_0x0058;
            case 3: goto L_0x0094;
            case 4: goto L_0x00dd;
            case 5: goto L_0x0103;
            case 6: goto L_0x011e;
            default: goto L_0x0016;
        };
    L_0x0016:
        if (r0 == 0) goto L_0x001b;
    L_0x0018:
        r11.append(r0);
    L_0x001b:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x0006;
    L_0x001f:
        r5 = 26;
        if (r4 >= r5) goto L_0x0027;
    L_0x0023:
        r0 = r4 + 65;
        r0 = (char) r0;
        goto L_0x0016;
    L_0x0027:
        r5 = 26;
        if (r4 != r5) goto L_0x002e;
    L_0x002b:
        r0 = 32;
        goto L_0x0016;
    L_0x002e:
        r5 = 27;
        if (r4 != r5) goto L_0x0035;
    L_0x0032:
        r2 = com.c.b.h.a.g.LOWER;
        goto L_0x0016;
    L_0x0035:
        r5 = 28;
        if (r4 != r5) goto L_0x003c;
    L_0x0039:
        r2 = com.c.b.h.a.g.MIXED;
        goto L_0x0016;
    L_0x003c:
        r5 = 29;
        if (r4 != r5) goto L_0x0046;
    L_0x0040:
        r1 = com.c.b.h.a.g.PUNCT_SHIFT;
        r7 = r2;
        r2 = r1;
        r1 = r7;
        goto L_0x0016;
    L_0x0046:
        r5 = 913; // 0x391 float:1.28E-42 double:4.51E-321;
        if (r4 != r5) goto L_0x0051;
    L_0x004a:
        r4 = r9[r3];
        r4 = (char) r4;
        r11.append(r4);
        goto L_0x0016;
    L_0x0051:
        r5 = 900; // 0x384 float:1.261E-42 double:4.447E-321;
        if (r4 != r5) goto L_0x0016;
    L_0x0055:
        r2 = com.c.b.h.a.g.ALPHA;
        goto L_0x0016;
    L_0x0058:
        r5 = 26;
        if (r4 >= r5) goto L_0x0060;
    L_0x005c:
        r0 = r4 + 97;
        r0 = (char) r0;
        goto L_0x0016;
    L_0x0060:
        r5 = 26;
        if (r4 != r5) goto L_0x0067;
    L_0x0064:
        r0 = 32;
        goto L_0x0016;
    L_0x0067:
        r5 = 27;
        if (r4 != r5) goto L_0x0071;
    L_0x006b:
        r1 = com.c.b.h.a.g.ALPHA_SHIFT;
        r7 = r2;
        r2 = r1;
        r1 = r7;
        goto L_0x0016;
    L_0x0071:
        r5 = 28;
        if (r4 != r5) goto L_0x0078;
    L_0x0075:
        r2 = com.c.b.h.a.g.MIXED;
        goto L_0x0016;
    L_0x0078:
        r5 = 29;
        if (r4 != r5) goto L_0x0082;
    L_0x007c:
        r1 = com.c.b.h.a.g.PUNCT_SHIFT;
        r7 = r2;
        r2 = r1;
        r1 = r7;
        goto L_0x0016;
    L_0x0082:
        r5 = 913; // 0x391 float:1.28E-42 double:4.51E-321;
        if (r4 != r5) goto L_0x008d;
    L_0x0086:
        r4 = r9[r3];
        r4 = (char) r4;
        r11.append(r4);
        goto L_0x0016;
    L_0x008d:
        r5 = 900; // 0x384 float:1.261E-42 double:4.447E-321;
        if (r4 != r5) goto L_0x0016;
    L_0x0091:
        r2 = com.c.b.h.a.g.ALPHA;
        goto L_0x0016;
    L_0x0094:
        r5 = 25;
        if (r4 >= r5) goto L_0x009e;
    L_0x0098:
        r0 = u;
        r0 = r0[r4];
        goto L_0x0016;
    L_0x009e:
        r5 = 25;
        if (r4 != r5) goto L_0x00a6;
    L_0x00a2:
        r2 = com.c.b.h.a.g.PUNCT;
        goto L_0x0016;
    L_0x00a6:
        r5 = 26;
        if (r4 != r5) goto L_0x00ae;
    L_0x00aa:
        r0 = 32;
        goto L_0x0016;
    L_0x00ae:
        r5 = 27;
        if (r4 != r5) goto L_0x00b6;
    L_0x00b2:
        r2 = com.c.b.h.a.g.LOWER;
        goto L_0x0016;
    L_0x00b6:
        r5 = 28;
        if (r4 != r5) goto L_0x00be;
    L_0x00ba:
        r2 = com.c.b.h.a.g.ALPHA;
        goto L_0x0016;
    L_0x00be:
        r5 = 29;
        if (r4 != r5) goto L_0x00c9;
    L_0x00c2:
        r1 = com.c.b.h.a.g.PUNCT_SHIFT;
        r7 = r2;
        r2 = r1;
        r1 = r7;
        goto L_0x0016;
    L_0x00c9:
        r5 = 913; // 0x391 float:1.28E-42 double:4.51E-321;
        if (r4 != r5) goto L_0x00d5;
    L_0x00cd:
        r4 = r9[r3];
        r4 = (char) r4;
        r11.append(r4);
        goto L_0x0016;
    L_0x00d5:
        r5 = 900; // 0x384 float:1.261E-42 double:4.447E-321;
        if (r4 != r5) goto L_0x0016;
    L_0x00d9:
        r2 = com.c.b.h.a.g.ALPHA;
        goto L_0x0016;
    L_0x00dd:
        r5 = 29;
        if (r4 >= r5) goto L_0x00e7;
    L_0x00e1:
        r0 = t;
        r0 = r0[r4];
        goto L_0x0016;
    L_0x00e7:
        r5 = 29;
        if (r4 != r5) goto L_0x00ef;
    L_0x00eb:
        r2 = com.c.b.h.a.g.ALPHA;
        goto L_0x0016;
    L_0x00ef:
        r5 = 913; // 0x391 float:1.28E-42 double:4.51E-321;
        if (r4 != r5) goto L_0x00fb;
    L_0x00f3:
        r4 = r9[r3];
        r4 = (char) r4;
        r11.append(r4);
        goto L_0x0016;
    L_0x00fb:
        r5 = 900; // 0x384 float:1.261E-42 double:4.447E-321;
        if (r4 != r5) goto L_0x0016;
    L_0x00ff:
        r2 = com.c.b.h.a.g.ALPHA;
        goto L_0x0016;
    L_0x0103:
        r2 = 26;
        if (r4 >= r2) goto L_0x010d;
    L_0x0107:
        r0 = r4 + 65;
        r0 = (char) r0;
        r2 = r1;
        goto L_0x0016;
    L_0x010d:
        r2 = 26;
        if (r4 != r2) goto L_0x0116;
    L_0x0111:
        r0 = 32;
        r2 = r1;
        goto L_0x0016;
    L_0x0116:
        r2 = 900; // 0x384 float:1.261E-42 double:4.447E-321;
        if (r4 != r2) goto L_0x0147;
    L_0x011a:
        r2 = com.c.b.h.a.g.ALPHA;
        goto L_0x0016;
    L_0x011e:
        r2 = 29;
        if (r4 >= r2) goto L_0x0129;
    L_0x0122:
        r0 = t;
        r0 = r0[r4];
        r2 = r1;
        goto L_0x0016;
    L_0x0129:
        r2 = 29;
        if (r4 != r2) goto L_0x0131;
    L_0x012d:
        r2 = com.c.b.h.a.g.ALPHA;
        goto L_0x0016;
    L_0x0131:
        r2 = 913; // 0x391 float:1.28E-42 double:4.51E-321;
        if (r4 != r2) goto L_0x013e;
    L_0x0135:
        r2 = r9[r3];
        r2 = (char) r2;
        r11.append(r2);
        r2 = r1;
        goto L_0x0016;
    L_0x013e:
        r2 = 900; // 0x384 float:1.261E-42 double:4.447E-321;
        if (r4 != r2) goto L_0x0147;
    L_0x0142:
        r2 = com.c.b.h.a.g.ALPHA;
        goto L_0x0016;
    L_0x0146:
        return;
    L_0x0147:
        r2 = r1;
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.b.h.a.e.a(int[], int[], int, java.lang.StringBuilder):void");
    }

    private static int b(int[] iArr, int i, StringBuilder stringBuilder) {
        int[] iArr2 = new int[l];
        int i2 = 0;
        int i3 = 0;
        while (i < iArr[0] && r0 == 0) {
            int i4 = i + 1;
            int i5 = iArr[i];
            if (i4 == iArr[0]) {
                i2 = 1;
            }
            if (i5 < a) {
                iArr2[i3] = i5;
                i3++;
                i = i4;
            } else if (i5 == a || i5 == b || i5 == d || i5 == h || i5 == i || i5 == j) {
                i = i4 - 1;
                i2 = 1;
            } else {
                i = i4;
            }
            if ((i3 % l == 0 || i5 == c || r0 != 0) && i3 > 0) {
                stringBuilder.append(a(iArr2, i3));
                i3 = 0;
            }
        }
        return i;
    }
}
