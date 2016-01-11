package com.c.b.g;

import com.c.b.c.a;
import com.c.b.e;
import com.c.b.h;
import com.c.b.n;
import com.c.b.s;
import com.c.b.u;
import java.util.Map;

public final class m extends q {
    static final int[][] a = new int[][]{new int[]{e, e, d, d, e}, new int[]{d, e, e, e, d}, new int[]{e, d, e, e, d}, new int[]{d, d, e, e, e}, new int[]{e, e, d, e, d}, new int[]{d, e, d, e, e}, new int[]{e, d, d, e, e}, new int[]{e, e, e, d, d}, new int[]{d, e, e, d, e}, new int[]{e, d, e, d, e}};
    private static final float b = 0.38f;
    private static final float c = 0.78f;
    private static final int d = 3;
    private static final int e = 1;
    private static final int[] f = new int[]{6, 8, 10, 12, 14};
    private static final int[] h = new int[]{e, e, e, e};
    private static final int[] i = new int[]{e, e, d};
    private int g = -1;

    private static int a(int[] iArr) {
        float f = b;
        int i = -1;
        int length = a.length;
        int i2 = 0;
        while (i2 < length) {
            float a = q.a(iArr, a[i2], (float) c);
            if (a < f) {
                i = i2;
            } else {
                a = f;
            }
            i2 += e;
            f = a;
        }
        if (i >= 0) {
            return i;
        }
        throw n.a();
    }

    private void a(a aVar, int i) {
        int i2 = this.g * 10;
        if (i2 >= i) {
            i2 = i;
        }
        int i3 = i2;
        i2 = i - 1;
        while (i3 > 0 && i2 >= 0 && !aVar.a(i2)) {
            i3--;
            i2--;
        }
        if (i3 != 0) {
            throw n.a();
        }
    }

    private static void a(a aVar, int i, int i2, StringBuilder stringBuilder) {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        int i3 = i;
        while (i3 < i2) {
            int i4;
            q.a(aVar, i3, iArr);
            for (i4 = 0; i4 < 5; i4 += e) {
                int i5 = i4 * 2;
                iArr2[i4] = iArr[i5];
                iArr3[i4] = iArr[i5 + e];
            }
            stringBuilder.append((char) (a(iArr2) + 48));
            stringBuilder.append((char) (a(iArr3) + 48));
            i4 = i3;
            for (i3 = 0; i3 < iArr.length; i3 += e) {
                i4 += iArr[i3];
            }
            i3 = i4;
        }
    }

    private static int c(a aVar) {
        int a = aVar.a();
        int d = aVar.d(0);
        if (d != a) {
            return d;
        }
        throw n.a();
    }

    private static int[] c(a aVar, int i, int[] iArr) {
        int length = iArr.length;
        Object obj = new int[length];
        int a = aVar.a();
        int i2 = i;
        int i3 = 0;
        int i4 = 0;
        while (i < a) {
            if ((aVar.a(i) ^ i4) != 0) {
                obj[i3] = obj[i3] + e;
            } else {
                if (i3 != length - 1) {
                    i3 += e;
                } else if (q.a((int[]) obj, iArr, (float) c) < b) {
                    return new int[]{i2, i};
                } else {
                    i2 += obj[0] + obj[e];
                    System.arraycopy(obj, 2, obj, 0, length - 2);
                    obj[length - 2] = null;
                    obj[length - 1] = null;
                    i3--;
                }
                obj[i3] = e;
                i4 = i4 == 0 ? e : 0;
            }
            i += e;
        }
        throw n.a();
    }

    public s a(int i, a aVar, Map<e, ?> map) {
        int i2;
        int[] a = a(aVar);
        int[] b = b(aVar);
        StringBuilder stringBuilder = new StringBuilder(20);
        a(aVar, a[e], b[0], stringBuilder);
        String stringBuilder2 = stringBuilder.toString();
        int[] iArr = map != null ? (int[]) map.get(e.ALLOWED_LENGTHS) : null;
        if (iArr == null) {
            iArr = f;
        }
        int length = stringBuilder2.length();
        int length2 = iArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length2) {
            int i5 = iArr[i3];
            if (length == i5) {
                i2 = e;
                break;
            }
            if (i5 <= i4) {
                i5 = i4;
            }
            i3 += e;
            i4 = i5;
        }
        i2 = 0;
        if (i2 == 0 && length > i4) {
            i2 = e;
        }
        if (i2 == 0) {
            throw h.a();
        }
        return new s(stringBuilder2, null, new u[]{new u((float) a[e], (float) i), new u((float) b[0], (float) i)}, com.c.b.a.ITF);
    }

    int[] a(a aVar) {
        int[] c = c(aVar, c(aVar), h);
        this.g = (c[e] - c[0]) / 4;
        a(aVar, c[0]);
        return c;
    }

    int[] b(a aVar) {
        aVar.e();
        try {
            int[] c = c(aVar, c(aVar), i);
            a(aVar, c[0]);
            int i = c[0];
            c[0] = aVar.a() - c[e];
            c[e] = aVar.a() - i;
            return c;
        } finally {
            aVar.e();
        }
    }
}
