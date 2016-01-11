package com.huami.android.zxing.b;

import com.c.b.c.b;
import com.c.b.c.h;
import com.c.b.j;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.lang.reflect.Array;

public final class a extends h {
    private static final int a = 3;
    private static final int b = 5;
    private static int c = a;
    private static int d = (1 << c);
    private static int e = (d - 1);
    private static int f = (d * b);
    private static final int g = 24;
    private b h;

    public a(j jVar) {
        super(jVar);
    }

    private static int a(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    public static void a(int i) {
        c = i;
        f();
    }

    private static void a(byte[] bArr, int i, int i2, int i3, int i4, b bVar) {
        int i5 = (i2 * i4) + i;
        int i6 = 0;
        while (i6 < d) {
            for (int i7 = 0; i7 < d; i7++) {
                if ((bArr[i5 + i7] & HeartRateInfo.HR_EMPTY_VALUE) <= i3) {
                    bVar.b(i + i7, i2 + i6);
                }
            }
            i6++;
            i5 += i4;
        }
    }

    private static void a(byte[] bArr, int i, int i2, int i3, int i4, int[][] iArr, b bVar) {
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = i5 << c;
            int i7 = i4 - d;
            if (i6 <= i7) {
                i7 = i6;
            }
            for (int i8 = 0; i8 < i; i8++) {
                i6 = i8 << c;
                int i9 = i3 - d;
                if (i6 <= i9) {
                    i9 = i6;
                }
                int a = a(i8, 2, i - 3);
                int a2 = a(i5, 2, i2 - 3);
                int i10 = 0;
                for (i6 = -2; i6 <= 2; i6++) {
                    int[] iArr2 = iArr[a2 + i6];
                    i10 += iArr2[a + 2] + (((iArr2[a - 2] + iArr2[a - 1]) + iArr2[a]) + iArr2[a + 1]);
                }
                a(bArr, i9, i7, i10 / 25, i3, bVar);
            }
        }
    }

    private static int[][] a(byte[] bArr, int i, int i2, int i3, int i4) {
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{i2, i});
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = i5 << c;
            int i7 = i4 - d;
            if (i6 <= i7) {
                i7 = i6;
            }
            int i8 = 0;
            while (i8 < i) {
                int i9 = i8 << c;
                i6 = i3 - d;
                if (i9 <= i6) {
                    i6 = i9;
                }
                int i10 = 0;
                int i11 = HeartRateInfo.HR_EMPTY_VALUE;
                int i12 = 0;
                i9 = 0;
                i6 += i7 * i3;
                while (i9 < d) {
                    int i13 = i10;
                    i10 = 0;
                    while (i10 < d) {
                        int i14 = bArr[i6 + i10] & HeartRateInfo.HR_EMPTY_VALUE;
                        i10++;
                        i12 = i14 > i12 ? i14 : i12;
                        i11 = i14 < i11 ? i14 : i11;
                        i13 += i14;
                    }
                    if (i12 - i11 > g) {
                        i9++;
                        i6 += i3;
                        while (i9 < d) {
                            for (i10 = 0; i10 < d; i10++) {
                                i13 += bArr[i6 + i10] & HeartRateInfo.HR_EMPTY_VALUE;
                            }
                            i9++;
                            i6 += i3;
                        }
                    }
                    i10 = i13;
                    i9++;
                    i6 += i3;
                }
                i6 = i10 >> (c * 2);
                if (i12 - i11 <= g) {
                    i9 = i11 / 2;
                    if (i5 > 0 && i8 > 0) {
                        i6 = ((iArr[i5 - 1][i8] + (iArr[i5][i8 - 1] * 2)) + iArr[i5 - 1][i8 - 1]) / 4;
                        if (i11 < i6) {
                        }
                    }
                    i6 = i9;
                }
                iArr[i5][i8] = i6;
                i8++;
            }
        }
        return iArr;
    }

    public static void e() {
        c = a;
        f();
    }

    private static void f() {
        d = 1 << c;
        e = d - 1;
        f = d * b;
    }

    public com.c.b.b a(j jVar) {
        return new a(jVar);
    }

    public b b() {
        if (this.h != null) {
            return this.h;
        }
        j a = a();
        int g = a.g();
        int h = a.h();
        if (g < f || h < f) {
            this.h = super.b();
        } else {
            byte[] a2 = a.a();
            int i = g >> c;
            if ((e & g) != 0) {
                i++;
            }
            int i2 = h >> c;
            if ((e & h) != 0) {
                i2++;
            }
            int[][] a3 = a(a2, i, i2, g, h);
            b bVar = new b(g, h);
            a(a2, i, i2, g, h, a3, bVar);
            this.h = bVar;
        }
        return this.h;
    }
}
