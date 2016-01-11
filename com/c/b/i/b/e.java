package com.c.b.i.b;

import cn.com.smartdevices.bracelet.gps.c.d;
import com.c.b.c.b;
import com.c.b.n;
import com.c.b.u;
import com.c.b.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class e {
    protected static final int a = 3;
    protected static final int b = 57;
    private static final int c = 2;
    private final b d;
    private final List<d> e;
    private boolean f;
    private final int[] g;
    private final v h;

    public e(b bVar) {
        this(bVar, null);
    }

    public e(b bVar, v vVar) {
        this.d = bVar;
        this.e = new ArrayList();
        this.g = new int[5];
        this.h = vVar;
    }

    private static float a(int[] iArr, int i) {
        return ((float) ((i - iArr[4]) - iArr[a])) - (((float) iArr[c]) / 2.0f);
    }

    private boolean a(int i, int i2, int i3, int i4) {
        int[] c = c();
        int i5 = 0;
        while (i >= i5 && i2 >= i5 && this.d.a(i2 - i5, i - i5)) {
            c[c] = c[c] + 1;
            i5++;
        }
        if (i < i5 || i2 < i5) {
            return false;
        }
        while (i >= i5 && i2 >= i5 && !this.d.a(i2 - i5, i - i5) && c[1] <= i3) {
            c[1] = c[1] + 1;
            i5++;
        }
        if (i < i5 || i2 < i5 || c[1] > i3) {
            return false;
        }
        while (i >= i5 && i2 >= i5 && this.d.a(i2 - i5, i - i5) && c[0] <= i3) {
            c[0] = c[0] + 1;
            i5++;
        }
        if (c[0] > i3) {
            return false;
        }
        int g = this.d.g();
        int f = this.d.f();
        i5 = 1;
        while (i + i5 < g && i2 + i5 < f && this.d.a(i2 + i5, i + i5)) {
            c[c] = c[c] + 1;
            i5++;
        }
        if (i + i5 >= g || i2 + i5 >= f) {
            return false;
        }
        while (i + i5 < g && i2 + i5 < f && !this.d.a(i2 + i5, i + i5) && c[a] < i3) {
            c[a] = c[a] + 1;
            i5++;
        }
        if (i + i5 >= g || i2 + i5 >= f || c[a] >= i3) {
            return false;
        }
        while (i + i5 < g && i2 + i5 < f && this.d.a(i2 + i5, i + i5) && c[4] < i3) {
            c[4] = c[4] + 1;
            i5++;
        }
        return c[4] >= i3 ? false : Math.abs(((((c[0] + c[1]) + c[c]) + c[a]) + c[4]) - i4) < i4 * c && a(c);
    }

    protected static boolean a(int[] iArr) {
        boolean z = true;
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f = ((float) i) / 7.0f;
        float f2 = f / 2.0f;
        if (Math.abs(f - ((float) iArr[0])) >= f2 || Math.abs(f - ((float) iArr[1])) >= f2 || Math.abs((3.0f * f) - ((float) iArr[c])) >= 3.0f * f2 || Math.abs(f - ((float) iArr[a])) >= f2 || Math.abs(f - ((float) iArr[4])) >= f2) {
            z = false;
        }
        return z;
    }

    private float b(int i, int i2, int i3, int i4) {
        b bVar = this.d;
        int g = bVar.g();
        int[] c = c();
        int i5 = i;
        while (i5 >= 0 && bVar.a(i2, i5)) {
            c[c] = c[c] + 1;
            i5--;
        }
        if (i5 < 0) {
            return Float.NaN;
        }
        while (i5 >= 0 && !bVar.a(i2, i5) && c[1] <= i3) {
            c[1] = c[1] + 1;
            i5--;
        }
        if (i5 < 0 || c[1] > i3) {
            return Float.NaN;
        }
        while (i5 >= 0 && bVar.a(i2, i5) && c[0] <= i3) {
            c[0] = c[0] + 1;
            i5--;
        }
        if (c[0] > i3) {
            return Float.NaN;
        }
        i5 = i + 1;
        while (i5 < g && bVar.a(i2, i5)) {
            c[c] = c[c] + 1;
            i5++;
        }
        if (i5 == g) {
            return Float.NaN;
        }
        while (i5 < g && !bVar.a(i2, i5) && c[a] < i3) {
            c[a] = c[a] + 1;
            i5++;
        }
        if (i5 == g || c[a] >= i3) {
            return Float.NaN;
        }
        while (i5 < g && bVar.a(i2, i5) && c[4] < i3) {
            c[4] = c[4] + 1;
            i5++;
        }
        return (c[4] >= i3 || Math.abs(((((c[0] + c[1]) + c[c]) + c[a]) + c[4]) - i4) * 5 >= i4 * c || !a(c)) ? Float.NaN : a(c, i5);
    }

    private float c(int i, int i2, int i3, int i4) {
        b bVar = this.d;
        int f = bVar.f();
        int[] c = c();
        int i5 = i;
        while (i5 >= 0 && bVar.a(i5, i2)) {
            c[c] = c[c] + 1;
            i5--;
        }
        if (i5 < 0) {
            return Float.NaN;
        }
        while (i5 >= 0 && !bVar.a(i5, i2) && c[1] <= i3) {
            c[1] = c[1] + 1;
            i5--;
        }
        if (i5 < 0 || c[1] > i3) {
            return Float.NaN;
        }
        while (i5 >= 0 && bVar.a(i5, i2) && c[0] <= i3) {
            c[0] = c[0] + 1;
            i5--;
        }
        if (c[0] > i3) {
            return Float.NaN;
        }
        i5 = i + 1;
        while (i5 < f && bVar.a(i5, i2)) {
            c[c] = c[c] + 1;
            i5++;
        }
        if (i5 == f) {
            return Float.NaN;
        }
        while (i5 < f && !bVar.a(i5, i2) && c[a] < i3) {
            c[a] = c[a] + 1;
            i5++;
        }
        if (i5 == f || c[a] >= i3) {
            return Float.NaN;
        }
        while (i5 < f && bVar.a(i5, i2) && c[4] < i3) {
            c[4] = c[4] + 1;
            i5++;
        }
        return (c[4] >= i3 || Math.abs(((((c[0] + c[1]) + c[c]) + c[a]) + c[4]) - i4) * 5 >= i4 || !a(c)) ? Float.NaN : a(c, i5);
    }

    private int[] c() {
        this.g[0] = 0;
        this.g[1] = 0;
        this.g[c] = 0;
        this.g[a] = 0;
        this.g[4] = 0;
        return this.g;
    }

    private int d() {
        if (this.e.size() <= 1) {
            return 0;
        }
        u uVar = null;
        for (u uVar2 : this.e) {
            u uVar22;
            if (uVar22.d() < c) {
                uVar22 = uVar;
            } else if (uVar != null) {
                this.f = true;
                return ((int) (Math.abs(uVar.a() - uVar22.a()) - Math.abs(uVar.b() - uVar22.b()))) / c;
            }
            uVar = uVar22;
        }
        return 0;
    }

    private boolean e() {
        float f = 0.0f;
        int size = this.e.size();
        float f2 = 0.0f;
        int i = 0;
        for (d dVar : this.e) {
            float c;
            int i2;
            if (dVar.d() >= c) {
                c = dVar.c() + f2;
                i2 = i + 1;
            } else {
                c = f2;
                i2 = i;
            }
            i = i2;
            f2 = c;
        }
        if (i < a) {
            return false;
        }
        float f3 = f2 / ((float) size);
        for (d dVar2 : this.e) {
            f += Math.abs(dVar2.c() - f3);
        }
        return f <= 0.05f * f2;
    }

    private d[] f() {
        float f = 0.0f;
        int size = this.e.size();
        if (size < a) {
            throw n.a();
        }
        if (size > a) {
            float c;
            float f2 = 0.0f;
            float f3 = 0.0f;
            for (d c2 : this.e) {
                c = c2.c();
                f3 += c;
                f2 = (c * c) + f2;
            }
            f3 /= (float) size;
            c = (float) Math.sqrt((double) ((f2 / ((float) size)) - (f3 * f3)));
            Collections.sort(this.e, new h(f3, null));
            float max = Math.max(d.b * f3, c);
            int i = 0;
            while (i < this.e.size() && this.e.size() > a) {
                if (Math.abs(((d) this.e.get(i)).c() - f3) > max) {
                    this.e.remove(i);
                    i--;
                }
                i++;
            }
        }
        if (this.e.size() > a) {
            for (d c22 : this.e) {
                f += c22.c();
            }
            Collections.sort(this.e, new g(f / ((float) this.e.size()), null));
            this.e.subList(a, this.e.size()).clear();
        }
        d[] dVarArr = new d[a];
        dVarArr[0] = (d) this.e.get(0);
        dVarArr[1] = (d) this.e.get(1);
        dVarArr[c] = (d) this.e.get(c);
        return dVarArr;
    }

    protected final b a() {
        return this.d;
    }

    protected final boolean a(int[] iArr, int i, int i2, boolean z) {
        boolean z2 = false;
        int i3 = (((iArr[0] + iArr[1]) + iArr[c]) + iArr[a]) + iArr[4];
        float a = a(iArr, i2);
        float b = b(i, (int) a, iArr[c], i3);
        if (Float.isNaN(b)) {
            return false;
        }
        float c = c((int) a, (int) b, iArr[c], i3);
        if (Float.isNaN(c)) {
            return false;
        }
        if (z && !a((int) b, (int) c, iArr[c], i3)) {
            return false;
        }
        float f = ((float) i3) / 7.0f;
        for (int i4 = 0; i4 < this.e.size(); i4++) {
            d dVar = (d) this.e.get(i4);
            if (dVar.a(f, b, c)) {
                this.e.set(i4, dVar.b(b, c, f));
                z2 = true;
                break;
            }
        }
        if (!z2) {
            u dVar2 = new d(c, b, f);
            this.e.add(dVar2);
            if (this.h != null) {
                this.h.a(dVar2);
            }
        }
        return true;
    }

    final i b(Map<com.c.b.e, ?> map) {
        Object obj = (map == null || !map.containsKey(com.c.b.e.TRY_HARDER)) ? null : 1;
        boolean z = map != null && map.containsKey(com.c.b.e.PURE_BARCODE);
        int g = this.d.g();
        int f = this.d.f();
        int i = (g * a) / 228;
        if (i < a || obj != null) {
            i = a;
        }
        boolean z2 = false;
        int[] iArr = new int[5];
        int i2 = i - 1;
        int i3 = i;
        while (i2 < g && !r4) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[c] = 0;
            iArr[a] = 0;
            iArr[4] = 0;
            i = 0;
            int i4 = 0;
            while (i4 < f) {
                if (this.d.a(i4, i2)) {
                    if ((i & 1) == 1) {
                        i++;
                    }
                    iArr[i] = iArr[i] + 1;
                } else if ((i & 1) != 0) {
                    iArr[i] = iArr[i] + 1;
                } else if (i != 4) {
                    i++;
                    iArr[i] = iArr[i] + 1;
                } else if (!a(iArr)) {
                    iArr[0] = iArr[c];
                    iArr[1] = iArr[a];
                    iArr[c] = iArr[4];
                    iArr[a] = 1;
                    iArr[4] = 0;
                    i = a;
                } else if (a(iArr, i2, i4, z)) {
                    boolean e;
                    i3 = c;
                    if (this.f) {
                        e = e();
                    } else {
                        i = d();
                        if (i > iArr[c]) {
                            i4 = i2 + ((i - iArr[c]) - c);
                            i = f - 1;
                        } else {
                            i = i4;
                            i4 = i2;
                        }
                        i2 = i4;
                        i4 = i;
                        e = z2;
                    }
                    iArr[0] = 0;
                    iArr[1] = 0;
                    iArr[c] = 0;
                    iArr[a] = 0;
                    iArr[4] = 0;
                    z2 = e;
                    i = 0;
                } else {
                    iArr[0] = iArr[c];
                    iArr[1] = iArr[a];
                    iArr[c] = iArr[4];
                    iArr[a] = 1;
                    iArr[4] = 0;
                    i = a;
                }
                i4++;
            }
            if (a(iArr) && a(iArr, i2, f, z)) {
                i3 = iArr[0];
                if (this.f) {
                    z2 = e();
                }
            }
            i2 += i3;
        }
        u[] f2 = f();
        u.a(f2);
        return new i(f2);
    }

    protected final List<d> b() {
        return this.e;
    }
}
