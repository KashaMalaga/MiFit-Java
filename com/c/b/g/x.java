package com.c.b.g;

import com.c.b.c.a;
import com.c.b.d;
import com.c.b.e;
import com.c.b.h;
import com.c.b.n;
import com.c.b.r;
import com.c.b.s;
import com.c.b.t;
import com.c.b.u;
import com.c.b.v;
import java.util.Arrays;
import java.util.Map;

public abstract class x extends q {
    private static final float a = 0.48f;
    static final int[] b = new int[]{1, 1, 1};
    static final int[] c = new int[]{1, 1, 1, 1, 1};
    static final int[][] d = new int[][]{new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
    static final int[][] e = new int[20][];
    private static final float f = 0.7f;
    private final StringBuilder g = new StringBuilder(20);
    private final w h = new w();
    private final l i = new l();

    static {
        System.arraycopy(d, 0, e, 0, 10);
        for (int i = 10; i < 20; i++) {
            int[] iArr = d[i - 10];
            int[] iArr2 = new int[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                iArr2[i2] = iArr[(iArr.length - i2) - 1];
            }
            e[i] = iArr2;
        }
    }

    protected x() {
    }

    static int a(a aVar, int[] iArr, int i, int[][] iArr2) {
        q.a(aVar, i, iArr);
        float f = a;
        int i2 = -1;
        int length = iArr2.length;
        int i3 = 0;
        while (i3 < length) {
            float a = q.a(iArr, iArr2[i3], (float) f);
            if (a < f) {
                i2 = i3;
            } else {
                a = f;
            }
            i3++;
            f = a;
        }
        if (i2 >= 0) {
            return i2;
        }
        throw n.a();
    }

    static boolean a(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i;
        int i2 = 0;
        for (i = length - 2; i >= 0; i -= 2) {
            int charAt = charSequence.charAt(i) - 48;
            if (charAt < 0 || charAt > 9) {
                throw h.a();
            }
            i2 += charAt;
        }
        i2 *= 3;
        for (i = length - 1; i >= 0; i -= 2) {
            length = charSequence.charAt(i) - 48;
            if (length < 0 || length > 9) {
                throw h.a();
            }
            i2 += length;
        }
        return i2 % 10 == 0;
    }

    static int[] a(a aVar) {
        int[] iArr = new int[b.length];
        int i = 0;
        int[] iArr2 = null;
        boolean z = false;
        while (!z) {
            Arrays.fill(iArr, 0, b.length, 0);
            iArr2 = a(aVar, i, false, b, iArr);
            int i2 = iArr2[0];
            i = iArr2[1];
            int i3 = i2 - (i - i2);
            if (i3 >= 0) {
                z = aVar.a(i3, i2, false);
            }
        }
        return iArr2;
    }

    static int[] a(a aVar, int i, boolean z, int[] iArr) {
        return a(aVar, i, z, iArr, new int[iArr.length]);
    }

    private static int[] a(a aVar, int i, boolean z, int[] iArr, int[] iArr2) {
        int length = iArr.length;
        int a = aVar.a();
        int e = z ? aVar.e(i) : aVar.d(i);
        int i2 = 0;
        int i3 = z;
        for (int i4 = e; i4 < a; i4++) {
            if ((aVar.a(i4) ^ i3) != 0) {
                iArr2[i2] = iArr2[i2] + 1;
            } else {
                if (i2 != length - 1) {
                    i2++;
                } else if (q.a(iArr2, iArr, (float) f) < a) {
                    return new int[]{e, i4};
                } else {
                    e += iArr2[0] + iArr2[1];
                    System.arraycopy(iArr2, 2, iArr2, 0, length - 2);
                    iArr2[length - 2] = 0;
                    iArr2[length - 1] = 0;
                    i2--;
                }
                iArr2[i2] = 1;
                i3 = i3 == 0 ? 1 : 0;
            }
        }
        throw n.a();
    }

    protected abstract int a(a aVar, int[] iArr, StringBuilder stringBuilder);

    public s a(int i, a aVar, Map<e, ?> map) {
        return a(i, aVar, a(aVar), (Map) map);
    }

    public s a(int i, a aVar, int[] iArr, Map<e, ?> map) {
        v vVar = map == null ? null : (v) map.get(e.NEED_RESULT_POINT_CALLBACK);
        if (vVar != null) {
            vVar.a(new u(((float) (iArr[0] + iArr[1])) / 2.0f, (float) i));
        }
        StringBuilder stringBuilder = this.g;
        stringBuilder.setLength(0);
        int a = a(aVar, iArr, stringBuilder);
        if (vVar != null) {
            vVar.a(new u((float) a, (float) i));
        }
        int[] a2 = a(aVar, a);
        if (vVar != null) {
            vVar.a(new u(((float) (a2[0] + a2[1])) / 2.0f, (float) i));
        }
        int i2 = a2[1];
        int i3 = (i2 - a2[0]) + i2;
        if (i3 >= aVar.a() || !aVar.a(i2, i3, false)) {
            throw n.a();
        }
        String stringBuilder2 = stringBuilder.toString();
        if (stringBuilder2.length() < 8) {
            throw h.a();
        } else if (a(stringBuilder2)) {
            float f = ((float) (iArr[1] + iArr[0])) / 2.0f;
            float f2 = ((float) (a2[1] + a2[0])) / 2.0f;
            com.c.b.a b = b();
            s sVar = new s(stringBuilder2, null, new u[]{new u(f, (float) i), new u(f2, (float) i)}, b);
            i2 = 0;
            try {
                s a3 = this.h.a(i, aVar, a2[1]);
                sVar.a(t.UPC_EAN_EXTENSION, a3.a());
                sVar.a(a3.e());
                sVar.a(a3.c());
                i3 = a3.a().length();
            } catch (r e) {
                i3 = i2;
            }
            a2 = map == null ? null : (int[]) map.get(e.ALLOWED_EAN_EXTENSIONS);
            if (a2 != null) {
                Object obj = null;
                for (int i4 : a2) {
                    if (i3 == i4) {
                        obj = 1;
                        break;
                    }
                }
                if (obj == null) {
                    throw n.a();
                }
            }
            if (b == com.c.b.a.EAN_13 || b == com.c.b.a.UPC_A) {
                String a4 = this.i.a(stringBuilder2);
                if (a4 != null) {
                    sVar.a(t.POSSIBLE_COUNTRY, a4);
                }
            }
            return sVar;
        } else {
            throw d.a();
        }
    }

    boolean a(String str) {
        return a((CharSequence) str);
    }

    int[] a(a aVar, int i) {
        return a(aVar, i, false, b);
    }

    abstract com.c.b.a b();
}
