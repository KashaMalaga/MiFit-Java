package com.c.b.c;

import com.c.b.b;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.lang.reflect.Array;

public final class j extends h {
    private static final int a = 3;
    private static final int b = 8;
    private static final int c = 7;
    private static final int d = 40;
    private static final int e = 24;
    private b f;

    public j(com.c.b.j jVar) {
        super(jVar);
    }

    private static int a(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    private static void a(byte[] bArr, int i, int i2, int i3, int i4, b bVar) {
        int i5 = (i2 * i4) + i;
        int i6 = 0;
        while (i6 < b) {
            for (int i7 = 0; i7 < b; i7++) {
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
            int i6 = i5 << a;
            int i7 = i4 - 8;
            if (i6 <= i7) {
                i7 = i6;
            }
            for (int i8 = 0; i8 < i; i8++) {
                i6 = i8 << a;
                int i9 = i3 - 8;
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
            int i6 = i5 << a;
            int i7 = i4 - 8;
            if (i6 <= i7) {
                i7 = i6;
            }
            int i8 = 0;
            while (i8 < i) {
                int i9 = i8 << a;
                i6 = i3 - 8;
                if (i9 <= i6) {
                    i6 = i9;
                }
                int i10 = 0;
                int i11 = HeartRateInfo.HR_EMPTY_VALUE;
                i9 = 0;
                int i12 = 0;
                int i13 = (i7 * i3) + i6;
                while (i12 < b) {
                    int i14 = 0;
                    while (i14 < b) {
                        i6 = bArr[i13 + i14] & HeartRateInfo.HR_EMPTY_VALUE;
                        int i15 = i10 + i6;
                        i10 = i6 < i11 ? i6 : i11;
                        if (i6 <= i9) {
                            i6 = i9;
                        }
                        i14++;
                        i11 = i10;
                        i9 = i6;
                        i10 = i15;
                    }
                    if (i9 - i11 > e) {
                        i6 = i13 + i3;
                        i13 = i12 + 1;
                        i12 = i10;
                        while (i13 < b) {
                            i10 = i12;
                            for (i12 = 0; i12 < b; i12++) {
                                i10 += bArr[i6 + i12] & HeartRateInfo.HR_EMPTY_VALUE;
                            }
                            i13++;
                            i6 += i3;
                            i12 = i10;
                        }
                    } else {
                        i6 = i13;
                        i13 = i12;
                        i12 = i10;
                    }
                    i10 = i13 + 1;
                    i13 = i6 + i3;
                    int i16 = i10;
                    i10 = i12;
                    i12 = i16;
                }
                i6 = i10 >> 6;
                if (i9 - i11 <= e) {
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

    public b a(com.c.b.j jVar) {
        return new j(jVar);
    }

    public b b() {
        if (this.f != null) {
            return this.f;
        }
        com.c.b.j a = a();
        int g = a.g();
        int h = a.h();
        if (g < d || h < d) {
            this.f = super.b();
        } else {
            byte[] a2 = a.a();
            int i = g >> a;
            if ((g & c) != 0) {
                i++;
            }
            int i2 = h >> a;
            if ((h & c) != 0) {
                i2++;
            }
            int[][] a3 = a(a2, i, i2, g, h);
            b bVar = new b(g, h);
            a(a2, i, i2, g, h, a3, bVar);
            this.f = bVar;
        }
        return this.f;
    }
}
