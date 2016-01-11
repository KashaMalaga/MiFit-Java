package com.c.b.h.a;

import com.c.b.c.b;
import com.c.b.c.e;
import com.c.b.d;
import com.c.b.h;
import com.c.b.h.a.a.a;
import com.c.b.n;
import com.c.b.u;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Formatter;
import java.util.List;

public final class l {
    private static final int a = 2;
    private static final int b = 3;
    private static final int c = 512;
    private static final a d = new a();

    private l() {
    }

    private static int a(int i) {
        return a << i;
    }

    private static int a(h hVar, int i, int i2, boolean z) {
        int i3 = z ? 1 : -1;
        d dVar = null;
        if (a(hVar, i - i3)) {
            dVar = hVar.a(i - i3).c(i2);
        }
        if (dVar != null) {
            return z ? dVar.e() : dVar.d();
        } else {
            dVar = hVar.a(i).a(i2);
            if (dVar != null) {
                return z ? dVar.d() : dVar.e();
            } else {
                if (a(hVar, i - i3)) {
                    dVar = hVar.a(i - i3).a(i2);
                }
                if (dVar != null) {
                    return z ? dVar.e() : dVar.d();
                } else {
                    int i4 = 0;
                    while (a(hVar, i - i3)) {
                        i -= i3;
                        for (d dVar2 : hVar.a(i).b()) {
                            if (dVar2 != null) {
                                return ((i3 * i4) * (dVar2.e() - dVar2.d())) + (z ? dVar2.e() : dVar2.d());
                            }
                        }
                        i4++;
                    }
                    return z ? hVar.e().a() : hVar.e().b();
                }
            }
        }
    }

    private static int a(int[] iArr) {
        int i = -1;
        for (int max : iArr) {
            i = Math.max(i, max);
        }
        return i;
    }

    private static int a(int[] iArr, int[] iArr2, int i) {
        if ((iArr2 == null || iArr2.length <= (i / a) + b) && i >= 0 && i <= c) {
            return d.a(iArr, i, iArr2);
        }
        throw d.a();
    }

    private static e a(int i, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) {
        int[] iArr5 = new int[iArr3.length];
        int i2 = 100;
        while (true) {
            int i3 = i2 - 1;
            if (i2 > 0) {
                for (i2 = 0; i2 < iArr5.length; i2++) {
                    iArr[iArr3[i2]] = iArr4[i2][iArr5[i2]];
                }
                try {
                    break;
                } catch (d e) {
                    if (iArr5.length == 0) {
                        throw d.a();
                    }
                    for (i2 = 0; i2 < iArr5.length; i2++) {
                        if (iArr5[i2] < iArr4[i2].length - 1) {
                            iArr5[i2] = iArr5[i2] + 1;
                            break;
                        }
                        iArr5[i2] = 0;
                        if (i2 == iArr5.length - 1) {
                            throw d.a();
                        }
                    }
                    i2 = i3;
                }
            } else {
                throw d.a();
            }
        }
        return a(iArr, i, iArr2);
    }

    public static e a(b bVar, u uVar, u uVar2, u uVar3, u uVar4, int i, int i2) {
        i iVar = null;
        int i3 = 0;
        c cVar = new c(bVar, uVar, uVar2, uVar3, uVar4);
        h hVar = null;
        i iVar2 = null;
        while (i3 < a) {
            i a = uVar != null ? a(bVar, cVar, uVar, true, i, i2) : iVar2;
            i a2 = uVar3 != null ? a(bVar, cVar, uVar3, false, i, i2) : iVar;
            h a3 = a((j) a, (j) a2);
            if (a3 == null) {
                throw n.a();
            } else if (i3 != 0 || a3.e() == null || (a3.e().c() >= cVar.c() && a3.e().d() <= cVar.d())) {
                a3.a(cVar);
                iVar = a2;
                hVar = a3;
                iVar2 = a;
                break;
            } else {
                i3++;
                iVar = a2;
                hVar = a3;
                cVar = a3.e();
                iVar2 = a;
            }
        }
        int b = hVar.b() + 1;
        hVar.a(0, iVar2);
        hVar.a(b, iVar);
        boolean z = iVar2 != null;
        int i4 = 1;
        int i5 = i2;
        i3 = i;
        while (i4 <= b) {
            int i6 = z ? i4 : b - i4;
            if (hVar.a(i6) == null) {
                i jVar;
                if (i6 == 0 || i6 == b) {
                    jVar = new j(cVar, i6 == 0);
                } else {
                    jVar = new i(cVar);
                }
                hVar.a(i6, jVar);
                int c = cVar.c();
                int i7 = -1;
                while (c <= cVar.d()) {
                    int i8;
                    int a4 = a(hVar, i6, c, z);
                    if (a4 < 0 || a4 > cVar.b()) {
                        if (i7 == -1) {
                            i8 = i7;
                            c++;
                            i7 = i8;
                        } else {
                            a4 = i7;
                        }
                    }
                    d a5 = a(bVar, cVar.a(), cVar.b(), z, a4, c, i3, i5);
                    if (a5 != null) {
                        jVar.a(c, a5);
                        i3 = Math.min(i3, a5.c());
                        i5 = Math.max(i5, a5.c());
                        i8 = a4;
                    } else {
                        i8 = i7;
                    }
                    c++;
                    i7 = i8;
                }
            }
            i4++;
        }
        return a(hVar);
    }

    private static e a(h hVar) {
        int i = 0;
        b[][] b = b(hVar);
        a(hVar, b);
        Collection arrayList = new ArrayList();
        int[] iArr = new int[(hVar.c() * hVar.b())];
        List arrayList2 = new ArrayList();
        Collection arrayList3 = new ArrayList();
        for (int i2 = 0; i2 < hVar.c(); i2++) {
            for (int i3 = 0; i3 < hVar.b(); i3++) {
                Object a = b[i2][i3 + 1].a();
                int b2 = (hVar.b() * i2) + i3;
                if (a.length == 0) {
                    arrayList.add(Integer.valueOf(b2));
                } else if (a.length == 1) {
                    iArr[b2] = a[0];
                } else {
                    arrayList3.add(Integer.valueOf(b2));
                    arrayList2.add(a);
                }
            }
        }
        int[][] iArr2 = new int[arrayList2.size()][];
        while (i < iArr2.length) {
            iArr2[i] = (int[]) arrayList2.get(i);
            i++;
        }
        return a(hVar.d(), iArr, com.c.b.h.a.a(arrayList), com.c.b.h.a.a(arrayList3), iArr2);
    }

    private static e a(int[] iArr, int i, int[] iArr2) {
        if (iArr.length == 0) {
            throw h.a();
        }
        int i2 = 1 << (i + 1);
        int a = a(iArr, iArr2, i2);
        a(iArr, i2);
        e a2 = e.a(iArr, String.valueOf(i));
        a2.a(Integer.valueOf(a));
        a2.b(Integer.valueOf(iArr2.length));
        return a2;
    }

    private static c a(j jVar) {
        if (jVar == null) {
            return null;
        }
        int[] d = jVar.d();
        if (d == null) {
            return null;
        }
        int length;
        int a = a(d);
        int i = 0;
        for (int i2 : d) {
            i += a - i2;
            if (i2 > 0) {
                break;
            }
        }
        d[] b = jVar.b();
        int i3 = i;
        i = 0;
        while (i3 > 0 && b[i] == null) {
            i3--;
            i++;
        }
        i = 0;
        for (length = d.length - 1; length >= 0; length--) {
            i += a - d[length];
            if (d[length] > 0) {
                break;
            }
        }
        length = i;
        i = b.length - 1;
        while (length > 0 && b[i] == null) {
            length--;
            i--;
        }
        return jVar.a().a(i3, length, jVar.f());
    }

    private static d a(b bVar, int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
        int b = b(bVar, i, i2, z, i3, i4);
        int[] a = a(bVar, i, i2, z, b, i4);
        if (a == null) {
            return null;
        }
        int i7;
        int a2 = com.c.b.h.a.a(a);
        if (z) {
            i7 = b;
            b += a2;
        } else {
            for (i7 = 0; i7 < a.length / a; i7++) {
                int i8 = a[i7];
                a[i7] = a[(a.length - 1) - i7];
                a[(a.length - 1) - i7] = i8;
            }
            i7 = b - a2;
        }
        if (!a(a2, i5, i6)) {
            return null;
        }
        a2 = k.a(a);
        i8 = com.c.b.h.a.a(a2);
        return i8 == -1 ? null : new d(i7, b, c(a2), i8);
    }

    private static h a(j jVar, j jVar2) {
        if (jVar == null && jVar2 == null) {
            return null;
        }
        a b = b(jVar, jVar2);
        return b != null ? new h(b, c.a(a(jVar), a(jVar2))) : null;
    }

    private static j a(b bVar, c cVar, u uVar, boolean z, int i, int i2) {
        j jVar = new j(cVar, z);
        int i3 = 0;
        while (i3 < a) {
            int i4 = i3 == 0 ? 1 : -1;
            int a = (int) uVar.a();
            int b = (int) uVar.b();
            while (b <= cVar.d() && b >= cVar.c()) {
                d a2 = a(bVar, 0, bVar.f(), z, a, b, i, i2);
                if (a2 != null) {
                    jVar.a(b, a2);
                    a = z ? a2.d() : a2.e();
                }
                b += i4;
            }
            i3++;
        }
        return jVar;
    }

    public static String a(b[][] bVarArr) {
        Formatter formatter = new Formatter();
        for (int i = 0; i < bVarArr.length; i++) {
            formatter.format("Row %2d: ", new Object[]{Integer.valueOf(i)});
            for (b bVar : bVarArr[i]) {
                if (bVar.a().length == 0) {
                    formatter.format("        ", (Object[]) null);
                } else {
                    Object[] objArr = new Object[a];
                    objArr[0] = Integer.valueOf(bVar.a()[0]);
                    objArr[1] = bVar.b(bVar.a()[0]);
                    formatter.format("%4d(%2d)", objArr);
                }
            }
            formatter.format("%n", new Object[0]);
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }

    private static void a(h hVar, b[][] bVarArr) {
        int[] a = bVarArr[0][1].a();
        int b = (hVar.b() * hVar.c()) - a(hVar.d());
        if (a.length == 0) {
            if (b < 1 || b > com.c.b.h.a.b) {
                throw n.a();
            }
            bVarArr[0][1].a(b);
        } else if (a[0] != b) {
            bVarArr[0][1].a(b);
        }
    }

    private static void a(int[] iArr, int i) {
        if (iArr.length < 4) {
            throw h.a();
        }
        int i2 = iArr[0];
        if (i2 > iArr.length) {
            throw h.a();
        } else if (i2 != 0) {
        } else {
            if (i < iArr.length) {
                iArr[0] = iArr.length - i;
                return;
            }
            throw h.a();
        }
    }

    private static boolean a(int i, int i2, int i3) {
        return i2 + -2 <= i && i <= i3 + a;
    }

    private static boolean a(h hVar, int i) {
        return i >= 0 && i <= hVar.b() + 1;
    }

    private static int[] a(b bVar, int i, int i2, boolean z, int i3, int i4) {
        int[] iArr = new int[8];
        int i5 = z ? 1 : -1;
        boolean z2 = z;
        int i6 = 0;
        while (true) {
            if (((z && i3 < i2) || (!z && i3 >= i)) && i6 < iArr.length) {
                if (bVar.a(i3, i4) == z2) {
                    iArr[i6] = iArr[i6] + 1;
                    i3 += i5;
                } else {
                    i6++;
                    z2 = !z2;
                }
            }
        }
        return (i6 == iArr.length || (((z && i3 == i2) || (!z && i3 == i)) && i6 == iArr.length - 1)) ? iArr : null;
    }

    private static int b(b bVar, int i, int i2, boolean z, int i3, int i4) {
        int i5 = 0;
        int i6 = z ? -1 : 1;
        int i7 = i3;
        while (i5 < a) {
            int i8 = i7;
            while (true) {
                if (((!z || i8 < i) && (z || i8 >= i2)) || z != bVar.a(i8, i4)) {
                    i6 = -i6;
                } else if (Math.abs(i3 - i8) > a) {
                    return i3;
                } else {
                    i8 += i6;
                }
            }
            i6 = -i6;
            i5++;
            z = !z;
            i7 = i8;
        }
        return i7;
    }

    private static int b(int[] iArr) {
        return ((((iArr[0] - iArr[a]) + iArr[4]) - iArr[6]) + 9) % 9;
    }

    private static a b(j jVar, j jVar2) {
        if (jVar != null) {
            a e = jVar.e();
            if (e != null) {
                if (jVar2 != null) {
                    a e2 = jVar2.e();
                    if (e2 != null) {
                        return (e.a() == e2.a() || e.b() == e2.b() || e.c() == e2.c()) ? e : null;
                    }
                }
                return e;
            }
        }
        return jVar2 == null ? null : jVar2.e();
    }

    private static int[] b(int i) {
        int[] iArr = new int[8];
        int i2 = 0;
        int length = iArr.length - 1;
        while (true) {
            if ((i & 1) != i2) {
                i2 = i & 1;
                length--;
                if (length < 0) {
                    return iArr;
                }
            }
            iArr[length] = iArr[length] + 1;
            i >>= 1;
        }
    }

    private static b[][] b(h hVar) {
        b[][] bVarArr = (b[][]) Array.newInstance(b.class, new int[]{hVar.c(), hVar.b() + a});
        for (int i = 0; i < bVarArr.length; i++) {
            for (int i2 = 0; i2 < bVarArr[i].length; i2++) {
                bVarArr[i][i2] = new b();
            }
        }
        int i3 = 0;
        for (i iVar : hVar.a()) {
            if (iVar != null) {
                for (d dVar : iVar.b()) {
                    if (dVar != null) {
                        int h = dVar.h();
                        if (h < 0) {
                            continue;
                        } else if (h >= bVarArr.length) {
                            throw h.a();
                        } else {
                            bVarArr[h][i3].a(dVar.g());
                        }
                    }
                }
                continue;
            }
            i3++;
        }
        return bVarArr;
    }

    private static int c(int i) {
        return b(b(i));
    }
}
