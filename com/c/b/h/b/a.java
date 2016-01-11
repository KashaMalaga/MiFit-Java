package com.c.b.h.b;

import com.c.b.c;
import com.c.b.c.b;
import com.c.b.e;
import com.c.b.u;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class a {
    private static final int[] a = new int[]{0, 4, 1, j};
    private static final int[] b = new int[]{6, 2, 7, g};
    private static final float c = 0.42f;
    private static final float d = 0.8f;
    private static final int[] e = new int[]{8, 1, 1, 1, 1, 1, 1, g};
    private static final int[] f = new int[]{7, 1, 1, g, 1, 1, 1, 2, 1};
    private static final int g = 3;
    private static final int h = 5;
    private static final int i = 25;
    private static final int j = 5;
    private static final int k = 10;

    private a() {
    }

    private static float a(int[] iArr, int[] iArr2, float f) {
        int i;
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        for (i = 0; i < length; i++) {
            i3 += iArr[i];
            i2 += iArr2[i];
        }
        if (i3 < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = ((float) i3) / ((float) i2);
        float f3 = f * f2;
        float f4 = 0.0f;
        for (i = 0; i < length; i++) {
            int i4 = iArr[i];
            float f5 = ((float) iArr2[i]) * f2;
            float f6 = ((float) i4) > f5 ? ((float) i4) - f5 : f5 - ((float) i4);
            if (f6 > f3) {
                return Float.POSITIVE_INFINITY;
            }
            f4 += f6;
        }
        return f4 / ((float) i3);
    }

    public static b a(c cVar, Map<e, ?> map, boolean z) {
        b c = cVar.c();
        List a = a(z, c);
        if (a.isEmpty()) {
            c = c.i();
            c.b();
            a = a(z, c);
        }
        return new b(c, a);
    }

    private static List<u[]> a(boolean z, b bVar) {
        List<u[]> arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i3 < bVar.g()) {
            Object a = a(bVar, i3, i2);
            if (a[0] != null || a[g] != null) {
                arrayList.add(a);
                if (!z) {
                    break;
                }
                if (a[2] != null) {
                    i = (int) a[2].a();
                    i2 = (int) a[2].b();
                } else {
                    i = (int) a[4].a();
                    i2 = (int) a[4].b();
                }
                i3 = i2;
                i2 = i;
                i = 1;
            } else if (i == 0) {
                break;
            } else {
                for (u[] uVarArr : arrayList) {
                    if (uVarArr[1] != null) {
                        i3 = (int) Math.max((float) i3, uVarArr[1].b());
                    }
                    if (uVarArr[g] != null) {
                        i3 = Math.max(i3, (int) uVarArr[g].b());
                    }
                }
                i2 = 0;
                i3 += j;
                i = 0;
            }
        }
        return arrayList;
    }

    private static void a(u[] uVarArr, u[] uVarArr2, int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            uVarArr[iArr[i]] = uVarArr2[i];
        }
    }

    private static int[] a(b bVar, int i, int i2, int i3, boolean z, int[] iArr, int[] iArr2) {
        int i4;
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int length = iArr.length;
        int i5 = 0;
        while (bVar.a(i, i2) && i > 0) {
            i4 = i5 + 1;
            if (i5 >= g) {
                break;
            }
            i--;
            i5 = i4;
        }
        i5 = 0;
        i4 = i;
        int i6 = z;
        while (i < i3) {
            if ((bVar.a(i, i2) ^ i6) != 0) {
                iArr2[i5] = iArr2[i5] + 1;
            } else {
                if (i5 != length - 1) {
                    i5++;
                } else if (a(iArr2, iArr, (float) d) < c) {
                    return new int[]{i4, i};
                } else {
                    i4 += iArr2[0] + iArr2[1];
                    System.arraycopy(iArr2, 2, iArr2, 0, length - 2);
                    iArr2[length - 2] = 0;
                    iArr2[length - 1] = 0;
                    i5--;
                }
                iArr2[i5] = 1;
                i6 = i6 == 0 ? 1 : 0;
            }
            i++;
        }
        if (i5 != length - 1 || a(iArr2, iArr, (float) d) >= c) {
            return null;
        }
        return new int[]{i4, i - 1};
    }

    private static u[] a(b bVar, int i, int i2) {
        int a;
        int b;
        int g = bVar.g();
        int f = bVar.f();
        u[] uVarArr = new u[8];
        a(uVarArr, a(bVar, g, f, i, i2, e), a);
        if (uVarArr[4] != null) {
            a = (int) uVarArr[4].a();
            b = (int) uVarArr[4].b();
        } else {
            a = i2;
            b = i;
        }
        a(uVarArr, a(bVar, g, f, b, a, f), b);
        return uVarArr;
    }

    private static u[] a(b bVar, int i, int i2, int i3, int i4, int[] iArr) {
        int i5;
        Object obj;
        int i6;
        u[] uVarArr = new u[4];
        int[] iArr2 = new int[iArr.length];
        int i7 = i3;
        while (i7 < i) {
            int[] a = a(bVar, i4, i7, i2, false, iArr, iArr2);
            int[] iArr3;
            int i8;
            int i9;
            if (a != null) {
                iArr3 = a;
                i5 = i7;
                while (i5 > 0) {
                    i7 = i5 - 1;
                    a = a(bVar, i4, i7, i2, false, iArr, iArr2);
                    if (a == null) {
                        i5 = i7 + 1;
                        break;
                    }
                    iArr3 = a;
                    i5 = i7;
                }
                uVarArr[0] = new u((float) iArr3[0], (float) i5);
                uVarArr[1] = new u((float) iArr3[1], (float) i5);
                obj = 1;
                i6 = i5;
                i5 = i6 + 1;
                if (obj != null) {
                    iArr3 = new int[]{(int) uVarArr[0].a(), (int) uVarArr[1].a()};
                    i8 = 0;
                    i7 = i5;
                    while (i7 < i) {
                        a = a(bVar, iArr3[0], i7, i2, false, iArr, iArr2);
                        if (a == null && Math.abs(iArr3[0] - a[0]) < j && Math.abs(iArr3[1] - a[1]) < j) {
                            i9 = 0;
                        } else if (i8 > i) {
                            break;
                        } else {
                            i9 = i8 + 1;
                            a = iArr3;
                        }
                        i7++;
                        iArr3 = a;
                        i8 = i9;
                    }
                    i5 = i7 - (i8 + 1);
                    uVarArr[2] = new u((float) iArr3[0], (float) i5);
                    uVarArr[g] = new u((float) iArr3[1], (float) i5);
                }
                if (i5 - i6 < k) {
                    for (i5 = 0; i5 < uVarArr.length; i5++) {
                        uVarArr[i5] = null;
                    }
                }
                return uVarArr;
            }
            i7 += j;
        }
        obj = null;
        i6 = i7;
        i5 = i6 + 1;
        if (obj != null) {
            iArr3 = new int[]{(int) uVarArr[0].a(), (int) uVarArr[1].a()};
            i8 = 0;
            i7 = i5;
            while (i7 < i) {
                a = a(bVar, iArr3[0], i7, i2, false, iArr, iArr2);
                if (a == null) {
                }
                if (i8 > i) {
                    break;
                }
                i9 = i8 + 1;
                a = iArr3;
                i7++;
                iArr3 = a;
                i8 = i9;
            }
            i5 = i7 - (i8 + 1);
            uVarArr[2] = new u((float) iArr3[0], (float) i5);
            uVarArr[g] = new u((float) iArr3[1], (float) i5);
        }
        if (i5 - i6 < k) {
            for (i5 = 0; i5 < uVarArr.length; i5++) {
                uVarArr[i5] = null;
            }
        }
        return uVarArr;
    }
}
