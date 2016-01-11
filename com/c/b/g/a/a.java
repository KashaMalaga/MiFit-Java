package com.c.b.g.a;

import android.support.v7.widget.af;
import com.c.b.g.q;
import com.c.b.n;

public abstract class a extends q {
    private static final float a = 0.2f;
    private static final float b = 0.45f;
    private static final float c = 0.7916667f;
    private static final float d = 0.89285713f;
    private final int[] e = new int[4];
    private final int[] f = new int[8];
    private final float[] g = new float[4];
    private final float[] h = new float[4];
    private final int[] i = new int[(this.f.length / 2)];
    private final int[] j = new int[(this.f.length / 2)];

    protected a() {
    }

    protected static int a(int[] iArr) {
        int i = 0;
        int i2 = 0;
        while (i < iArr.length) {
            i2 += iArr[i];
            i++;
        }
        return i2;
    }

    protected static int a(int[] iArr, int[][] iArr2) {
        for (int i = 0; i < iArr2.length; i++) {
            if (q.a(iArr, iArr2[i], (float) b) < a) {
                return i;
            }
        }
        throw n.a();
    }

    protected static void a(int[] iArr, float[] fArr) {
        int i = 0;
        float f = fArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (fArr[i2] > f) {
                f = fArr[i2];
                i = i2;
            }
        }
        iArr[i] = iArr[i] + 1;
    }

    protected static void b(int[] iArr, float[] fArr) {
        int i = 0;
        float f = fArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (fArr[i2] < f) {
                f = fArr[i2];
                i = i2;
            }
        }
        iArr[i] = iArr[i] - 1;
    }

    protected static boolean b(int[] iArr) {
        int i = iArr[0] + iArr[1];
        float f = ((float) i) / ((float) ((iArr[2] + i) + iArr[3]));
        if (f < c || f > d) {
            return false;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = af.a;
        int length = iArr.length;
        int i4 = 0;
        while (i4 < length) {
            i = iArr[i4];
            if (i > i3) {
                i3 = i;
            }
            if (i >= i2) {
                i = i2;
            }
            i4++;
            i2 = i;
        }
        return i3 < i2 * 10;
    }

    protected final int[] b() {
        return this.e;
    }

    protected final int[] c() {
        return this.f;
    }

    protected final float[] d() {
        return this.g;
    }

    protected final float[] e() {
        return this.h;
    }

    protected final int[] f() {
        return this.i;
    }

    protected final int[] g() {
        return this.j;
    }
}
