package com.c.b.c;

import com.c.b.n;

public abstract class i {
    private static i a = new f();

    public static i a() {
        return a;
    }

    protected static void a(b bVar, float[] fArr) {
        int i;
        int f = bVar.f();
        int g = bVar.g();
        Object obj = 1;
        for (i = 0; i < fArr.length && r2 != null; i += 2) {
            int i2 = (int) fArr[i];
            int i3 = (int) fArr[i + 1];
            if (i2 < -1 || i2 > f || i3 < -1 || i3 > g) {
                throw n.a();
            }
            if (i2 == -1) {
                fArr[i] = 0.0f;
                obj = 1;
            } else if (i2 == f) {
                fArr[i] = (float) (f - 1);
                i2 = 1;
            } else {
                obj = null;
            }
            if (i3 == -1) {
                fArr[i + 1] = 0.0f;
                obj = 1;
            } else if (i3 == g) {
                fArr[i + 1] = (float) (g - 1);
                i2 = 1;
            }
        }
        Object obj2 = 1;
        for (i2 = fArr.length - 2; i2 >= 0 && r0 != null; i2 -= 2) {
            i = (int) fArr[i2];
            i3 = (int) fArr[i2 + 1];
            if (i < -1 || i > f || i3 < -1 || i3 > g) {
                throw n.a();
            }
            if (i == -1) {
                fArr[i2] = 0.0f;
                obj2 = 1;
            } else if (i == f) {
                fArr[i2] = (float) (f - 1);
                i = 1;
            } else {
                obj2 = null;
            }
            if (i3 == -1) {
                fArr[i2 + 1] = 0.0f;
                obj2 = 1;
            } else if (i3 == g) {
                fArr[i2 + 1] = (float) (g - 1);
                i = 1;
            }
        }
    }

    public static void a(i iVar) {
        a = iVar;
    }

    public abstract b a(b bVar, int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16);

    public abstract b a(b bVar, int i, int i2, k kVar);
}
