package com.c.b.g;

import android.support.v4.view.a.C0113o;
import com.c.b.e;
import com.c.b.n;
import com.c.b.s;
import com.c.b.u;
import java.util.Arrays;
import java.util.Map;

public final class a extends q {
    static final char[] a = e.toCharArray();
    static final int[] b = new int[]{f, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};
    private static final float c = 2.0f;
    private static final float d = 1.5f;
    private static final String e = "0123456789-$:/.+ABCD";
    private static final int f = 3;
    private static final char[] g = new char[]{'A', 'B', 'C', 'D'};
    private final StringBuilder h = new StringBuilder(20);
    private int[] i = new int[80];
    private int j = 0;

    private void a(com.c.b.c.a aVar) {
        this.j = 0;
        int e = aVar.e(0);
        int a = aVar.a();
        if (e >= a) {
            throw n.a();
        }
        int i = 1;
        e = 0;
        for (int i2 = e; i2 < a; i2++) {
            if ((aVar.a(i2) ^ i) != 0) {
                e++;
            } else {
                b(e);
                i = i == 0 ? 1 : 0;
                e = 1;
            }
        }
        b(e);
    }

    static boolean a(char[] cArr, char c) {
        if (cArr == null) {
            return false;
        }
        for (char c2 : cArr) {
            if (c2 == c) {
                return true;
            }
        }
        return false;
    }

    private int b() {
        int i = 1;
        while (i < this.j) {
            int c = c(i);
            if (c != -1 && a(g, a[c])) {
                int i2 = 0;
                for (c = i; c < i + 7; c++) {
                    i2 += this.i[c];
                }
                if (i == 1 || this.i[i - 1] >= i2 / 2) {
                    return i;
                }
            }
            i += 2;
        }
        throw n.a();
    }

    private void b(int i) {
        this.i[this.j] = i;
        this.j++;
        if (this.j >= this.i.length) {
            Object obj = new int[(this.j * 2)];
            System.arraycopy(this.i, 0, obj, 0, this.j);
            this.i = obj;
        }
    }

    private int c(int i) {
        int i2 = Integer.MAX_VALUE;
        int i3 = i + 7;
        if (i3 >= this.j) {
            return -1;
        }
        int[] iArr = this.i;
        int i4 = i;
        int i5 = Integer.MAX_VALUE;
        int i6 = 0;
        while (i4 < i3) {
            int i7 = iArr[i4];
            if (i7 < i5) {
                i5 = i7;
            }
            if (i7 <= i6) {
                i7 = i6;
            }
            i4 += 2;
            i6 = i7;
        }
        i5 = (i5 + i6) / 2;
        i4 = i + 1;
        i6 = 0;
        while (i4 < i3) {
            i7 = iArr[i4];
            if (i7 < i2) {
                i2 = i7;
            }
            if (i7 <= i6) {
                i7 = i6;
            }
            i4 += 2;
            i6 = i7;
        }
        i6 = (i2 + i6) / 2;
        i4 = 0;
        i2 = 0;
        i3 = C0113o.h;
        while (i4 < 7) {
            i3 >>= 1;
            i7 = iArr[i + i4] > ((i4 & 1) == 0 ? i5 : i6) ? i2 | i3 : i2;
            i4++;
            i2 = i7;
        }
        for (i7 = 0; i7 < b.length; i7++) {
            if (b[i7] == i2) {
                return i7;
            }
        }
        return -1;
    }

    public s a(int i, com.c.b.c.a aVar, Map<e, ?> map) {
        Arrays.fill(this.i, 0);
        a(aVar);
        int b = b();
        this.h.setLength(0);
        int i2 = b;
        do {
            int c = c(i2);
            if (c != -1) {
                this.h.append((char) c);
                i2 += 8;
                if (this.h.length() > 1 && a(g, a[c])) {
                    break;
                }
            } else {
                throw n.a();
            }
        } while (i2 < this.j);
        int i3 = this.i[i2 - 1];
        int i4 = 0;
        for (c = -8; c < -1; c++) {
            i4 += this.i[i2 + c];
        }
        if (i2 >= this.j || i3 >= i4 / 2) {
            a(b);
            for (c = 0; c < this.h.length(); c++) {
                this.h.setCharAt(c, a[this.h.charAt(c)]);
            }
            if (a(g, this.h.charAt(0))) {
                if (!a(g, this.h.charAt(this.h.length() - 1))) {
                    throw n.a();
                } else if (this.h.length() <= f) {
                    throw n.a();
                } else {
                    if (map == null || !map.containsKey(e.RETURN_CODABAR_START_END)) {
                        this.h.deleteCharAt(this.h.length() - 1);
                        this.h.deleteCharAt(0);
                    }
                    i4 = 0;
                    c = 0;
                    while (i4 < b) {
                        i3 = this.i[i4] + c;
                        i4++;
                        c = i3;
                    }
                    float f = (float) c;
                    while (b < i2 - 1) {
                        c += this.i[b];
                        b++;
                    }
                    float f2 = (float) c;
                    return new s(this.h.toString(), null, new u[]{new u(f, (float) i), new u(f2, (float) i)}, com.c.b.a.CODABAR);
                }
            }
            throw n.a();
        }
        throw n.a();
    }

    void a(int i) {
        int[] iArr = new int[]{0, 0, 0, 0};
        int[] iArr2 = new int[]{0, 0, 0, 0};
        int length = this.h.length() - 1;
        int i2 = 0;
        int i3 = i;
        while (true) {
            int i4;
            int i5 = b[this.h.charAt(i2)];
            for (i4 = 6; i4 >= 0; i4--) {
                int i6 = (i4 & 1) + ((i5 & 1) * 2);
                iArr[i6] = iArr[i6] + this.i[i3 + i4];
                iArr2[i6] = iArr2[i6] + 1;
                i5 >>= 1;
            }
            if (i2 >= length) {
                break;
            }
            i3 += 8;
            i2++;
        }
        float[] fArr = new float[4];
        float[] fArr2 = new float[4];
        for (i2 = 0; i2 < 2; i2++) {
            fArr2[i2] = 0.0f;
            fArr2[i2 + 2] = ((((float) iArr[i2]) / ((float) iArr2[i2])) + (((float) iArr[i2 + 2]) / ((float) iArr2[i2 + 2]))) / c;
            fArr[i2] = fArr2[i2 + 2];
            fArr[i2 + 2] = ((((float) iArr[i2 + 2]) * c) + d) / ((float) iArr2[i2 + 2]);
        }
        i2 = 0;
        loop3:
        while (true) {
            i4 = b[this.h.charAt(i2)];
            i3 = 6;
            while (i3 >= 0) {
                int i7 = (i3 & 1) + ((i4 & 1) * 2);
                int i8 = this.i[i + i3];
                if (((float) i8) >= fArr2[i7] && ((float) i8) <= fArr[i7]) {
                    i4 >>= 1;
                    i3--;
                }
            }
            if (i2 < length) {
                i += 8;
                i2++;
            } else {
                return;
            }
        }
        throw n.a();
    }
}
