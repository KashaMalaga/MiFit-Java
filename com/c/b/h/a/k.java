package com.c.b.h.a;

import android.support.v4.widget.C0203a;
import com.c.b.h.a;
import java.lang.reflect.Array;

final class k {
    private static final float[][] a = ((float[][]) Array.newInstance(Float.TYPE, new int[]{a.h.length, 8}));

    static {
        for (int i = 0; i < a.h.length; i++) {
            int i2 = a.h[i];
            int i3 = i2 & 1;
            for (int i4 = 0; i4 < 8; i4++) {
                float f = 0.0f;
                while ((i2 & 1) == i3) {
                    f += 1.0f;
                    i2 >>= 1;
                }
                i3 = i2 & 1;
                a[i][(8 - i4) - 1] = f / 17.0f;
            }
        }
    }

    private k() {
    }

    static int a(int[] iArr) {
        int c = c(b(iArr));
        return c != -1 ? c : e(iArr);
    }

    private static int[] b(int[] iArr) {
        int i = 0;
        float a = (float) a.a(iArr);
        int[] iArr2 = new int[8];
        int i2 = 0;
        for (int i3 = 0; i3 < 17; i3++) {
            if (((float) (iArr[i2] + i)) <= (a / 34.0f) + ((((float) i3) * a) / 17.0f)) {
                i += iArr[i2];
                i2++;
            }
            iArr2[i2] = iArr2[i2] + 1;
        }
        return iArr2;
    }

    private static int c(int[] iArr) {
        int d = d(iArr);
        return a.a(d) == -1 ? -1 : d;
    }

    private static int d(int[] iArr) {
        long j = 0;
        for (int i = 0; i < iArr.length; i++) {
            int i2 = 0;
            while (i2 < iArr[i]) {
                i2++;
                j = (j << 1) | ((long) (i % 2 == 0 ? 1 : 0));
            }
        }
        return (int) j;
    }

    private static int e(int[] iArr) {
        int i;
        int a = a.a(iArr);
        float[] fArr = new float[8];
        for (i = 0; i < fArr.length; i++) {
            fArr[i] = ((float) iArr[i]) / ((float) a);
        }
        float f = C0203a.b;
        a = -1;
        for (i = 0; i < a.length; i++) {
            float f2 = 0.0f;
            float[] fArr2 = a[i];
            for (int i2 = 0; i2 < 8; i2++) {
                float f3 = fArr2[i2] - fArr[i2];
                f2 += f3 * f3;
                if (f2 >= f) {
                    break;
                }
            }
            if (f2 < f) {
                a = a.h[i];
                f = f2;
            }
        }
        return a;
    }
}
