package com.c.b.i.b;

import com.c.b.n;
import com.c.b.u;
import com.c.b.v;
import java.util.ArrayList;
import java.util.List;

final class b {
    private final com.c.b.c.b a;
    private final List<a> b = new ArrayList(5);
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final float g;
    private final int[] h;
    private final v i;

    b(com.c.b.c.b bVar, int i, int i2, int i3, int i4, float f, v vVar) {
        this.a = bVar;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.g = f;
        this.h = new int[3];
        this.i = vVar;
    }

    private float a(int i, int i2, int i3, int i4) {
        com.c.b.c.b bVar = this.a;
        int g = bVar.g();
        int[] iArr = this.h;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        int i5 = i;
        while (i5 >= 0 && bVar.a(i2, i5) && iArr[1] <= i3) {
            iArr[1] = iArr[1] + 1;
            i5--;
        }
        if (i5 < 0 || iArr[1] > i3) {
            return Float.NaN;
        }
        while (i5 >= 0 && !bVar.a(i2, i5) && iArr[0] <= i3) {
            iArr[0] = iArr[0] + 1;
            i5--;
        }
        if (iArr[0] > i3) {
            return Float.NaN;
        }
        i5 = i + 1;
        while (i5 < g && bVar.a(i2, i5) && iArr[1] <= i3) {
            iArr[1] = iArr[1] + 1;
            i5++;
        }
        if (i5 == g || iArr[1] > i3) {
            return Float.NaN;
        }
        while (i5 < g && !bVar.a(i2, i5) && iArr[2] <= i3) {
            iArr[2] = iArr[2] + 1;
            i5++;
        }
        return (iArr[2] > i3 || Math.abs(((iArr[0] + iArr[1]) + iArr[2]) - i4) * 5 >= i4 * 2 || !a(iArr)) ? Float.NaN : a(iArr, i5);
    }

    private static float a(int[] iArr, int i) {
        return ((float) (i - iArr[2])) - (((float) iArr[1]) / 2.0f);
    }

    private a a(int[] iArr, int i, int i2) {
        int i3 = (iArr[0] + iArr[1]) + iArr[2];
        float a = a(iArr, i2);
        float a2 = a(i, (int) a, iArr[1] * 2, i3);
        if (!Float.isNaN(a2)) {
            float f = ((float) ((iArr[0] + iArr[1]) + iArr[2])) / 3.0f;
            for (a aVar : this.b) {
                if (aVar.a(f, a2, a)) {
                    return aVar.b(a2, a, f);
                }
            }
            u aVar2 = new a(a, a2, f);
            this.b.add(aVar2);
            if (this.i != null) {
                this.i.a(aVar2);
            }
        }
        return null;
    }

    private boolean a(int[] iArr) {
        float f = this.g;
        float f2 = f / 2.0f;
        for (int i = 0; i < 3; i++) {
            if (Math.abs(f - ((float) iArr[i])) >= f2) {
                return false;
            }
        }
        return true;
    }

    a a() {
        int i = this.c;
        int i2 = this.f;
        int i3 = i + this.e;
        int i4 = this.d + (i2 / 2);
        int[] iArr = new int[3];
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = i4 + ((i5 & 1) == 0 ? (i5 + 1) / 2 : -((i5 + 1) / 2));
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i7 = i;
            while (i7 < i3 && !this.a.a(i7, i6)) {
                i7++;
            }
            i7 = 0;
            for (int i8 = i7; i8 < i3; i8++) {
                a a;
                if (!this.a.a(i8, i6)) {
                    if (i7 == 1) {
                        i7++;
                    }
                    iArr[i7] = iArr[i7] + 1;
                } else if (i7 == 1) {
                    iArr[i7] = iArr[i7] + 1;
                } else if (i7 == 2) {
                    if (a(iArr)) {
                        a = a(iArr, i6, i8);
                        if (a != null) {
                            return a;
                        }
                    }
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i7 = 1;
                } else {
                    i7++;
                    iArr[i7] = iArr[i7] + 1;
                }
            }
            if (a(iArr)) {
                a = a(iArr, i6, i3);
                if (a != null) {
                    return a;
                }
            }
        }
        if (!this.b.isEmpty()) {
            return (a) this.b.get(0);
        }
        throw n.a();
    }
}
