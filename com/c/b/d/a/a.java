package com.c.b.d.a;

import com.c.b.c.b;
import com.c.b.h;

final class a {
    private final b a;
    private final b b;
    private final g c;

    a(b bVar) {
        int g = bVar.g();
        if (g < 8 || g > 144 || (g & 1) != 0) {
            throw h.a();
        }
        this.c = b(bVar);
        this.a = a(bVar);
        this.b = new b(this.a.f(), this.a.g());
    }

    private static g b(b bVar) {
        return g.a(bVar.g(), bVar.f());
    }

    int a(int i, int i2) {
        int i3 = (a(i + -1, 0, i, i2) ? 1 : 0) << 1;
        if (a(i - 1, 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (a(i - 1, 2, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (a(0, i2 - 2, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (a(0, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (a(1, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (a(2, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        return a(3, i2 + -1, i, i2) ? i3 | 1 : i3;
    }

    b a(b bVar) {
        int b = this.c.b();
        int c = this.c.c();
        if (bVar.g() != b) {
            throw new IllegalArgumentException("Dimension of bitMarix must match the version size");
        }
        int d = this.c.d();
        int e = this.c.e();
        int i = b / d;
        int i2 = c / e;
        b bVar2 = new b(i2 * e, i * d);
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = i3 * d;
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = i5 * e;
                for (c = 0; c < d; c++) {
                    int i7 = (((d + 2) * i3) + 1) + c;
                    int i8 = i4 + c;
                    for (b = 0; b < e; b++) {
                        if (bVar.a((((e + 2) * i5) + 1) + b, i7)) {
                            bVar2.b(i6 + b, i8);
                        }
                    }
                }
            }
        }
        return bVar2;
    }

    g a() {
        return this.c;
    }

    boolean a(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        if (i < 0) {
            i5 = i + i3;
            i6 = (4 - ((i3 + 4) & 7)) + i2;
        } else {
            i6 = i2;
            i5 = i;
        }
        if (i6 < 0) {
            i6 += i4;
            i5 += 4 - ((i4 + 4) & 7);
        }
        this.b.b(i6, i5);
        return this.a.a(i6, i5);
    }

    int b(int i, int i2) {
        int i3 = (a(i + -3, 0, i, i2) ? 1 : 0) << 1;
        if (a(i - 2, 0, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (a(i - 1, 0, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (a(0, i2 - 4, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (a(0, i2 - 3, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (a(0, i2 - 2, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (a(0, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        return a(1, i2 + -1, i, i2) ? i3 | 1 : i3;
    }

    int b(int i, int i2, int i3, int i4) {
        int i5 = 0;
        if (a(i - 2, i2 - 2, i3, i4)) {
            i5 = 1;
        }
        i5 <<= 1;
        if (a(i - 2, i2 - 1, i3, i4)) {
            i5 |= 1;
        }
        i5 <<= 1;
        if (a(i - 1, i2 - 2, i3, i4)) {
            i5 |= 1;
        }
        i5 <<= 1;
        if (a(i - 1, i2 - 1, i3, i4)) {
            i5 |= 1;
        }
        i5 <<= 1;
        if (a(i - 1, i2, i3, i4)) {
            i5 |= 1;
        }
        i5 <<= 1;
        if (a(i, i2 - 2, i3, i4)) {
            i5 |= 1;
        }
        i5 <<= 1;
        if (a(i, i2 - 1, i3, i4)) {
            i5 |= 1;
        }
        i5 <<= 1;
        return a(i, i2, i3, i4) ? i5 | 1 : i5;
    }

    byte[] b() {
        Object obj = null;
        byte[] bArr = new byte[this.c.f()];
        int g = this.a.g();
        int f = this.a.f();
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        int i = 0;
        int i2 = 4;
        int i3 = 0;
        while (true) {
            int i4;
            if (i2 == g && i == 0 && r4 == null) {
                i4 = i3 + 1;
                bArr[i3] = (byte) a(g, f);
                int i5 = i + 2;
                i = i4;
                i4 = i2 - 2;
                i2 = i5;
                obj4 = 1;
            } else if (i2 == g - 2 && i == 0 && (f & 3) != 0 && r3 == null) {
                i4 = i3 + 1;
                bArr[i3] = (byte) b(g, f);
                int i6 = i + 2;
                i = i4;
                i4 = i2 - 2;
                i2 = i6;
                i6 = 1;
            } else if (i2 == g + 4 && i == 2 && (f & 7) == 0 && r2 == null) {
                i4 = i3 + 1;
                bArr[i3] = (byte) c(g, f);
                int i7 = i + 2;
                i = i4;
                i4 = i2 - 2;
                i2 = i7;
                i7 = 1;
            } else if (i2 == g - 2 && i == 0 && (f & 7) == 4 && r0 == null) {
                i4 = i3 + 1;
                bArr[i3] = (byte) d(g, f);
                int i8 = i + 2;
                i = i4;
                i4 = i2 - 2;
                i2 = i8;
                i8 = 1;
            } else {
                i4 = i;
                int i9 = i2;
                i2 = i3;
                i3 = i9;
                while (true) {
                    if (i3 >= g || i4 < 0 || this.b.a(i4, i3)) {
                        i = i2;
                    } else {
                        i = i2 + 1;
                        bArr[i2] = (byte) b(i3, i4, g, f);
                    }
                    i3 -= 2;
                    i2 = i4 + 2;
                    if (i3 < 0 || i2 >= f) {
                        i3++;
                        i4 = i2 + 3;
                        i2 = i;
                    } else {
                        i4 = i2;
                        i2 = i;
                    }
                }
                i3++;
                i4 = i2 + 3;
                i2 = i;
                while (true) {
                    if (i3 < 0 || i4 >= f || this.b.a(i4, i3)) {
                        i = i2;
                    } else {
                        i = i2 + 1;
                        bArr[i2] = (byte) b(i3, i4, g, f);
                    }
                    i3 += 2;
                    i2 = i4 - 2;
                    if (i3 >= g || i2 < 0) {
                        i4 = i3 + 3;
                        i2++;
                    } else {
                        i4 = i2;
                        i2 = i;
                    }
                }
                i4 = i3 + 3;
                i2++;
            }
            if (i4 >= g && i2 >= f) {
                break;
            }
            i3 = i;
            i = i2;
            i2 = i4;
        }
        if (i == this.c.f()) {
            return bArr;
        }
        throw h.a();
    }

    int c(int i, int i2) {
        int i3 = (a(i + -1, 0, i, i2) ? 1 : 0) << 1;
        if (a(i - 1, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (a(0, i2 - 3, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (a(0, i2 - 2, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (a(0, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (a(1, i2 - 3, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (a(1, i2 - 2, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        return a(1, i2 + -1, i, i2) ? i3 | 1 : i3;
    }

    int d(int i, int i2) {
        int i3 = (a(i + -3, 0, i, i2) ? 1 : 0) << 1;
        if (a(i - 2, 0, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (a(i - 1, 0, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (a(0, i2 - 2, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (a(0, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (a(1, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (a(2, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        return a(3, i2 + -1, i, i2) ? i3 | 1 : i3;
    }
}
