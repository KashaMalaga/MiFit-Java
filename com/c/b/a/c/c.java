package com.c.b.a.c;

import com.c.b.c.a;
import com.c.b.c.b;
import com.c.b.c.b.d;

public final class c {
    public static final int a = 33;
    public static final int b = 0;
    private static final int c = 32;
    private static final int d = 4;
    private static final int[] e = new int[]{d, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private c() {
    }

    private static int a(int i, boolean z) {
        return ((z ? 88 : 112) + (i * 16)) * i;
    }

    public static a a(byte[] bArr) {
        return a(bArr, (int) a, (int) b);
    }

    public static a a(byte[] bArr, int i, int i2) {
        int a;
        int i3;
        int i4;
        int i5;
        boolean z;
        a aVar;
        int i6;
        a a2 = new d(bArr).a();
        int a3 = ((a2.a() * i) / 100) + 11;
        int a4 = a2.a() + a3;
        int abs;
        if (i2 != 0) {
            boolean z2 = i2 < 0;
            abs = Math.abs(i2);
            if (abs > (z2 ? d : c)) {
                throw new IllegalArgumentException(String.format("Illegal value %s for layers", new Object[]{Integer.valueOf(i2)}));
            }
            a = a(abs, z2);
            i3 = e[abs];
            i4 = a - (a % i3);
            a a5 = a(a2, i3);
            if (a5.a() + a3 > i4) {
                throw new IllegalArgumentException("Data to large for user specified layer");
            } else if (!z2 || a5.a() <= i3 * 64) {
                a aVar2 = a5;
                i5 = i3;
                i3 = a;
                a = abs;
                z = z2;
                aVar = aVar2;
            } else {
                throw new IllegalArgumentException("Data to large for user specified layer");
            }
        }
        i5 = b;
        aVar = null;
        a = b;
        while (a <= c) {
            boolean z3 = a <= 3;
            i3 = z3 ? a + 1 : a;
            abs = a(i3, z3);
            if (a4 <= abs) {
                if (i5 != e[i3]) {
                    i5 = e[i3];
                    aVar = a(a2, i5);
                }
                int i7 = abs - (abs % i5);
                if ((!z3 || r2.a() <= i5 * 64) && r2.a() + a3 <= i7) {
                    a = i3;
                    i3 = abs;
                    z = z3;
                }
            }
            a++;
        }
        throw new IllegalArgumentException("Data too large for an Aztec code");
        a a6 = a(aVar, i3, i5);
        int a7 = aVar.a() / i5;
        a a8 = a(z, a, a7);
        int i8 = z ? (a * d) + 11 : (a * d) + 14;
        int[] iArr = new int[i8];
        if (z) {
            for (i5 = b; i5 < iArr.length; i5++) {
                iArr[i5] = i5;
            }
            i5 = i8;
        } else {
            i5 = (i8 + 1) + ((((i8 / 2) - 1) / 15) * 2);
            i4 = i8 / 2;
            i6 = i5 / 2;
            for (i3 = b; i3 < i4; i3++) {
                a3 = (i3 / 15) + i3;
                iArr[(i4 - i3) - 1] = (i6 - a3) - 1;
                iArr[i4 + i3] = (a3 + i6) + 1;
            }
        }
        b bVar = new b(i5);
        a3 = b;
        for (a4 = b; a4 < a; a4++) {
            i3 = z ? ((a - a4) * d) + 9 : ((a - a4) * d) + 12;
            for (i6 = b; i6 < i3; i6++) {
                int i9 = i6 * 2;
                for (i4 = b; i4 < 2; i4++) {
                    if (a6.a((a3 + i9) + i4)) {
                        bVar.b(iArr[(a4 * 2) + i4], iArr[(a4 * 2) + i6]);
                    }
                    if (a6.a((((i3 * 2) + a3) + i9) + i4)) {
                        bVar.b(iArr[(a4 * 2) + i6], iArr[((i8 - 1) - (a4 * 2)) - i4]);
                    }
                    if (a6.a((((i3 * d) + a3) + i9) + i4)) {
                        bVar.b(iArr[((i8 - 1) - (a4 * 2)) - i4], iArr[((i8 - 1) - (a4 * 2)) - i6]);
                    }
                    if (a6.a((((i3 * 6) + a3) + i9) + i4)) {
                        bVar.b(iArr[((i8 - 1) - (a4 * 2)) - i6], iArr[(a4 * 2) + i4]);
                    }
                }
            }
            a3 = (i3 * 8) + a3;
        }
        a(bVar, z, i5, a8);
        if (z) {
            a(bVar, i5 / 2, 5);
        } else {
            a(bVar, i5 / 2, 7);
            i4 = b;
            i3 = b;
            while (i4 < (i8 / 2) - 1) {
                for (i6 = (i5 / 2) & 1; i6 < i5; i6 += 2) {
                    bVar.b((i5 / 2) - i3, i6);
                    bVar.b((i5 / 2) + i3, i6);
                    bVar.b(i6, (i5 / 2) - i3);
                    bVar.b(i6, (i5 / 2) + i3);
                }
                i4 += 15;
                i3 += 16;
            }
        }
        a aVar3 = new a();
        aVar3.a(z);
        aVar3.a(i5);
        aVar3.b(a);
        aVar3.c(a7);
        aVar3.a(bVar);
        return aVar3;
    }

    static a a(a aVar, int i) {
        a aVar2 = new a();
        int a = aVar.a();
        int i2 = (1 << i) - 2;
        int i3 = b;
        while (i3 < a) {
            int i4 = b;
            int i5 = b;
            while (i4 < i) {
                if (i3 + i4 >= a || aVar.a(i3 + i4)) {
                    i5 |= 1 << ((i - 1) - i4);
                }
                i4++;
            }
            if ((i5 & i2) == i2) {
                aVar2.c(i5 & i2, i);
                i5 = i3 - 1;
            } else if ((i5 & i2) == 0) {
                aVar2.c(i5 | 1, i);
                i5 = i3 - 1;
            } else {
                aVar2.c(i5, i);
                i5 = i3;
            }
            i3 = i5 + i;
        }
        return aVar2;
    }

    private static a a(a aVar, int i, int i2) {
        int i3 = b;
        int a = aVar.a() / i2;
        d dVar = new d(a(i2));
        int i4 = i / i2;
        int[] b = b(aVar, i2, i4);
        dVar.a(b, i4 - a);
        a = i % i2;
        a aVar2 = new a();
        aVar2.c(b, a);
        a = b.length;
        while (i3 < a) {
            aVar2.c(b[i3], i2);
            i3++;
        }
        return aVar2;
    }

    static a a(boolean z, int i, int i2) {
        a aVar = new a();
        if (z) {
            aVar.c(i - 1, 2);
            aVar.c(i2 - 1, 6);
            return a(aVar, 28, (int) d);
        }
        aVar.c(i - 1, 5);
        aVar.c(i2 - 1, 11);
        return a(aVar, 40, (int) d);
    }

    private static com.c.b.c.b.a a(int i) {
        switch (i) {
            case d /*4*/:
                return com.c.b.c.b.a.d;
            case kankan.wheel.widget.a.bt /*6*/:
                return com.c.b.c.b.a.c;
            case kankan.wheel.widget.a.ba /*8*/:
                return com.c.b.c.b.a.g;
            case kankan.wheel.widget.a.bd /*10*/:
                return com.c.b.c.b.a.b;
            case kankan.wheel.widget.a.be /*12*/:
                return com.c.b.c.b.a.a;
            default:
                return null;
        }
    }

    private static void a(b bVar, int i, int i2) {
        for (int i3 = b; i3 < i2; i3 += 2) {
            for (int i4 = i - i3; i4 <= i + i3; i4++) {
                bVar.b(i4, i - i3);
                bVar.b(i4, i + i3);
                bVar.b(i - i3, i4);
                bVar.b(i + i3, i4);
            }
        }
        bVar.b(i - i2, i - i2);
        bVar.b((i - i2) + 1, i - i2);
        bVar.b(i - i2, (i - i2) + 1);
        bVar.b(i + i2, i - i2);
        bVar.b(i + i2, (i - i2) + 1);
        bVar.b(i + i2, (i + i2) - 1);
    }

    private static void a(b bVar, boolean z, int i, a aVar) {
        int i2 = b;
        int i3 = i / 2;
        int i4;
        if (z) {
            while (i2 < 7) {
                i4 = (i3 - 3) + i2;
                if (aVar.a(i2)) {
                    bVar.b(i4, i3 - 5);
                }
                if (aVar.a(i2 + 7)) {
                    bVar.b(i3 + 5, i4);
                }
                if (aVar.a(20 - i2)) {
                    bVar.b(i4, i3 + 5);
                }
                if (aVar.a(27 - i2)) {
                    bVar.b(i3 - 5, i4);
                }
                i2++;
            }
            return;
        }
        while (i2 < 10) {
            i4 = ((i3 - 5) + i2) + (i2 / 5);
            if (aVar.a(i2)) {
                bVar.b(i4, i3 - 7);
            }
            if (aVar.a(i2 + 10)) {
                bVar.b(i3 + 7, i4);
            }
            if (aVar.a(29 - i2)) {
                bVar.b(i4, i3 + 7);
            }
            if (aVar.a(39 - i2)) {
                bVar.b(i3 - 7, i4);
            }
            i2++;
        }
    }

    private static int[] b(a aVar, int i, int i2) {
        int[] iArr = new int[i2];
        int a = aVar.a() / i;
        for (int i3 = b; i3 < a; i3++) {
            int i4 = b;
            for (int i5 = b; i5 < i; i5++) {
                i4 |= aVar.a((i3 * i) + i5) ? 1 << ((i - i5) - 1) : b;
            }
            iArr[i3] = i4;
        }
        return iArr;
    }
}
