package com.c.b.c;

import com.c.b.b;
import com.c.b.j;
import com.c.b.n;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;

public class h extends b {
    private static final int a = 5;
    private static final int b = 3;
    private static final int c = 32;
    private static final byte[] d = new byte[0];
    private byte[] e = d;
    private final int[] f = new int[c];

    public h(j jVar) {
        super(jVar);
    }

    private static int a(int[] iArr) {
        int i;
        int i2 = 0;
        int length = iArr.length;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (i = 0; i < length; i++) {
            if (iArr[i] > i3) {
                i3 = iArr[i];
                i4 = i;
            }
            if (iArr[i] > i5) {
                i5 = iArr[i];
            }
        }
        i = 0;
        int i6 = 0;
        while (i2 < length) {
            i3 = i2 - i4;
            i3 *= iArr[i2] * i3;
            if (i3 > i) {
                i = i2;
            } else {
                i3 = i;
                i = i6;
            }
            i2++;
            i6 = i;
            i = i3;
        }
        if (i4 <= i6) {
            int i7 = i6;
            i6 = i4;
            i4 = i7;
        }
        if (i4 - i6 <= length / 16) {
            throw n.a();
        }
        length = i4 - 1;
        i = -1;
        i2 = i4 - 1;
        while (i2 > i6) {
            i3 = i2 - i6;
            i3 = ((i3 * i3) * (i4 - i2)) * (i5 - iArr[i2]);
            if (i3 > i) {
                i = i2;
            } else {
                i3 = i;
                i = length;
            }
            i2--;
            length = i;
            i = i3;
        }
        return length << b;
    }

    private void a(int i) {
        if (this.e.length < i) {
            this.e = new byte[i];
        }
        for (int i2 = 0; i2 < c; i2++) {
            this.f[i2] = 0;
        }
    }

    public b a(j jVar) {
        return new h(jVar);
    }

    public a a(int i, a aVar) {
        int i2;
        int i3;
        int i4 = 1;
        j a = a();
        int g = a.g();
        if (aVar == null || aVar.a() < g) {
            aVar = new a(g);
        } else {
            aVar.c();
        }
        a(g);
        byte[] a2 = a.a(i, this.e);
        int[] iArr = this.f;
        for (i2 = 0; i2 < g; i2++) {
            i3 = (a2[i2] & HeartRateInfo.HR_EMPTY_VALUE) >> b;
            iArr[i3] = iArr[i3] + 1;
        }
        i3 = a(iArr);
        i2 = a2[1] & HeartRateInfo.HR_EMPTY_VALUE;
        int i5 = a2[0] & HeartRateInfo.HR_EMPTY_VALUE;
        while (i4 < g - 1) {
            int i6 = a2[i4 + 1] & HeartRateInfo.HR_EMPTY_VALUE;
            if ((((i2 * 4) - i5) - i6) / 2 < i3) {
                aVar.b(i4);
            }
            i4++;
            i5 = i2;
            i2 = i6;
        }
        return aVar;
    }

    public b b() {
        int i;
        int i2;
        j a = a();
        int g = a.g();
        int h = a.h();
        b bVar = new b(g, h);
        a(g);
        int[] iArr = this.f;
        for (i = 1; i < a; i++) {
            byte[] a2 = a.a((h * i) / a, this.e);
            int i3 = (g * 4) / a;
            for (i2 = g / a; i2 < i3; i2++) {
                int i4 = (a2[i2] & HeartRateInfo.HR_EMPTY_VALUE) >> b;
                iArr[i4] = iArr[i4] + 1;
            }
        }
        int a3 = a(iArr);
        byte[] a4 = a.a();
        for (i = 0; i < h; i++) {
            int i5 = i * g;
            for (i2 = 0; i2 < g; i2++) {
                if ((a4[i5 + i2] & HeartRateInfo.HR_EMPTY_VALUE) < a3) {
                    bVar.b(i2, i);
                }
            }
        }
        return bVar;
    }
}
