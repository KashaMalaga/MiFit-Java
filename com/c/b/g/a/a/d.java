package com.c.b.g.a.a;

import a.a.a.B;
import android.support.v4.media.h;
import android.support.v4.view.a.C0113o;
import cn.com.smartdevices.bracelet.model.ShareData;
import com.c.b.e;
import com.c.b.g.a.a;
import com.c.b.g.a.a.a.j;
import com.c.b.g.a.b;
import com.c.b.g.a.c;
import com.c.b.g.a.f;
import com.c.b.g.q;
import com.c.b.n;
import com.c.b.s;
import com.c.b.u;
import com.xiaomi.channel.b.v;
import com.xiaomi.channel.relationservice.data.BuddyData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class d extends a {
    private static final int[] a = new int[]{7, k, j, i, g};
    private static final int[] b = new int[]{j, 20, 52, cn.com.smartdevices.bracelet.honor.a.d.e, 204};
    private static final int[] c = new int[]{f, 348, 1388, 2948, 3988};
    private static final int[][] d = new int[][]{new int[]{g, 8, j, g}, new int[]{i, 6, j, g}, new int[]{i, j, 6, g}, new int[]{i, h, 8, g}, new int[]{h, 6, k, g}, new int[]{h, h, 9, g}};
    private static final int[][] e = new int[][]{new int[]{g, i, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, cn.com.smartdevices.bracelet.gps.c.a.i, 118, 143, 7, 21, 63}, new int[]{189, 145, 13, 39, 117, 140, 209, 205}, new int[]{193, 157, 49, 147, 19, 57, 171, 91}, new int[]{62, 186, 136, 197, 169, 85, 44, 132}, new int[]{185, 133, 188, 142, j, 12, 36, 108}, new int[]{113, C0113o.h, 173, 97, 80, 29, 87, 50}, new int[]{kankan.wheel.widget.a.ap, 28, 84, 41, 123, 158, 52, 156}, new int[]{46, 138, 203, 187, 139, 206, 196, 166}, new int[]{76, 17, 51, 153, 37, 111, 122, 155}, new int[]{43, 129, 176, B.o, B.p, 110, 119, 146}, new int[]{16, 48, 144, 10, 30, 90, 59, 177}, new int[]{109, 116, 137, v.C, 178, 112, 125, 164}, new int[]{70, 210, 208, 202, 184, h.k, 179, 115}, new int[]{134, 191, 151, 31, 93, 68, 204, 190}, new int[]{148, 22, 66, 198, 172, 94, 71, h}, new int[]{6, 18, 54, 162, 64, 192, 154, 40}, new int[]{120, 149, 25, 75, 14, 42, h.i, 167}, new int[]{79, 26, 78, 23, 69, 207, 199, 175}, new int[]{ShareData.SHARE_TYPE_LAB_SITUP_ACCUMULATE, 98, 83, 38, BuddyData.s, 131, 182, 124}, new int[]{161, 61, 183, h.j, kankan.wheel.widget.a.aC, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, k, 15}, new int[]{45, 135, 194, 160, 58, 174, 100, 89}};
    private static final int f = 0;
    private static final int g = 1;
    private static final int h = 2;
    private static final int i = 3;
    private static final int j = 4;
    private static final int k = 5;
    private static final int[][] l = new int[][]{new int[]{f, f}, new int[]{f, g, g}, new int[]{f, h, g, i}, new int[]{f, j, g, i, h}, new int[]{f, j, g, i, i, k}, new int[]{f, j, g, i, j, k, k}, new int[]{f, f, g, g, h, h, i, i}, new int[]{f, f, g, g, h, h, i, j, j}, new int[]{f, f, g, g, h, h, i, j, k, k}, new int[]{f, f, g, g, h, i, i, j, j, k, k}};
    private static final int m = 11;
    private final List<b> n = new ArrayList(m);
    private final List<c> o = new ArrayList();
    private final int[] p = new int[h];
    private boolean q = false;

    private static int a(com.c.b.c.a aVar, int i) {
        return aVar.a(i) ? aVar.d(aVar.e(i)) : aVar.e(aVar.d(i));
    }

    private c a(com.c.b.c.a aVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (z) {
            i2 = this.p[f] - 1;
            while (i2 >= 0 && !aVar.a(i2)) {
                i2--;
            }
            i3 = i2 + g;
            i2 = this.p[f] - i3;
            i4 = this.p[g];
        } else {
            i3 = this.p[f];
            i4 = aVar.e(this.p[g] + g);
            i2 = i4 - this.p[g];
        }
        Object b = b();
        System.arraycopy(b, f, b, g, b.length - 1);
        b[f] = i2;
        try {
            int a = a.a((int[]) b, d);
            int[] iArr = new int[h];
            iArr[f] = i3;
            iArr[g] = i4;
            return new c(a, iArr, i3, i4, i);
        } catch (n e) {
            return null;
        }
    }

    static s a(List<b> list) {
        String a = j.a(a.a(list)).a();
        u[] c = ((b) list.get(f)).d().c();
        u[] c2 = ((b) list.get(list.size() - 1)).d().c();
        u[] uVarArr = new u[j];
        uVarArr[f] = c[f];
        uVarArr[g] = c[g];
        uVarArr[h] = c2[f];
        uVarArr[i] = c2[g];
        return new s(a, null, uVarArr, com.c.b.a.RSS_EXPANDED);
    }

    private List<b> a(List<c> list, int i) {
        while (i < this.o.size()) {
            c cVar = (c) this.o.get(i);
            this.n.clear();
            int size = list.size();
            for (int i2 = f; i2 < size; i2 += g) {
                this.n.addAll(((c) list.get(i2)).a());
            }
            this.n.addAll(cVar.a());
            if (b(this.n)) {
                if (i()) {
                    return this.n;
                }
                List arrayList = new ArrayList();
                arrayList.addAll(list);
                arrayList.add(cVar);
                try {
                    return a(arrayList, i + g);
                } catch (n e) {
                }
            }
            i += g;
        }
        throw n.a();
    }

    private List<b> a(boolean z) {
        List<b> list = null;
        if (this.o.size() > 25) {
            this.o.clear();
        } else {
            this.n.clear();
            if (z) {
                Collections.reverse(this.o);
            }
            try {
                list = a(new ArrayList(), (int) f);
            } catch (n e) {
            }
            if (z) {
                Collections.reverse(this.o);
            }
        }
        return list;
    }

    private void a(int i) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4 = null;
        Object obj5 = g;
        int a = a.a(f());
        int a2 = a.a(g());
        int i2 = (a + a2) - i;
        Object obj6 = (a & g) == g ? g : f;
        Object obj7 = (a2 & g) == 0 ? g : f;
        if (a > 13) {
            obj = g;
            obj2 = f;
        } else if (a < j) {
            obj = f;
            obj2 = g;
        } else {
            obj = f;
            obj2 = f;
        }
        if (a2 > 13) {
            obj3 = f;
            obj4 = g;
        } else {
            obj3 = a2 < j ? g : f;
        }
        if (i2 == g) {
            if (obj6 != null) {
                if (obj7 != null) {
                    throw n.a();
                }
                obj = obj2;
                obj5 = obj3;
                obj3 = g;
            } else if (obj7 == null) {
                throw n.a();
            } else {
                obj4 = g;
                obj5 = obj3;
                obj3 = obj;
                obj = obj2;
            }
        } else if (i2 == -1) {
            if (obj6 != null) {
                if (obj7 != null) {
                    throw n.a();
                }
                r12 = obj3;
                obj3 = obj;
                obj = g;
                obj5 = r12;
            } else if (obj7 == null) {
                throw n.a();
            } else {
                obj3 = obj;
                obj = obj2;
            }
        } else if (i2 != 0) {
            throw n.a();
        } else if (obj6 != null) {
            if (obj7 == null) {
                throw n.a();
            } else if (a < a2) {
                obj4 = g;
                r12 = obj3;
                obj3 = obj;
                obj = g;
                obj5 = r12;
            } else {
                obj3 = g;
                obj = obj2;
            }
        } else if (obj7 != null) {
            throw n.a();
        } else {
            obj5 = obj3;
            obj3 = obj;
            obj = obj2;
        }
        if (obj != null) {
            if (obj3 != null) {
                throw n.a();
            }
            a.a(f(), d());
        }
        if (obj3 != null) {
            a.b(f(), d());
        }
        if (obj5 != null) {
            if (obj4 != null) {
                throw n.a();
            }
            a.a(g(), d());
        }
        if (obj4 != null) {
            a.b(g(), e());
        }
    }

    private void a(int i, boolean z) {
        boolean z2 = false;
        boolean z3 = false;
        int i2 = f;
        while (i2 < this.o.size()) {
            c cVar = (c) this.o.get(i2);
            if (cVar.b() > i) {
                z2 = cVar.a(this.n);
                break;
            }
            i2 += g;
            z3 = cVar.a(this.n);
        }
        if (!z2 && !r1 && !a(this.n, this.o)) {
            this.o.add(i2, new c(this.n, i, z));
            a(this.n, this.o);
        }
    }

    private static void a(List<b> list, List<c> list2) {
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.a().size() != list.size()) {
                Object obj;
                for (b bVar : cVar.a()) {
                    for (b equals : list) {
                        if (bVar.equals(equals)) {
                            obj = g;
                            continue;
                            break;
                        }
                    }
                    obj = f;
                    continue;
                    if (obj == null) {
                        obj = f;
                        break;
                    }
                }
                obj = g;
                if (obj != null) {
                    it.remove();
                }
            }
        }
    }

    private static boolean a(c cVar, boolean z, boolean z2) {
        return (cVar.a() == 0 && z && z2) ? false : true;
    }

    private static boolean a(Iterable<b> iterable, Iterable<c> iterable2) {
        for (c cVar : iterable2) {
            Object obj;
            for (b bVar : iterable) {
                Object obj2;
                for (b equals : cVar.a()) {
                    if (bVar.equals(equals)) {
                        obj2 = g;
                        continue;
                        break;
                    }
                }
                obj2 = f;
                continue;
                if (obj2 == null) {
                    obj = f;
                    continue;
                    break;
                }
            }
            obj = g;
            continue;
            if (obj != null) {
                return true;
            }
        }
        return false;
    }

    private void b(com.c.b.c.a aVar, List<b> list, int i) {
        int[] b = b();
        b[f] = f;
        b[g] = f;
        b[h] = f;
        b[i] = f;
        int a = aVar.a();
        if (i < 0) {
            i = list.isEmpty() ? f : ((b) list.get(list.size() - 1)).d().b()[g];
        }
        Object obj = list.size() % h != 0 ? g : null;
        if (this.q) {
            obj = obj == null ? g : null;
        }
        int i2 = f;
        int i3 = i;
        while (i3 < a) {
            i2 = !aVar.a(i3) ? g : f;
            if (i2 == 0) {
                break;
            }
            i3 += g;
        }
        int i4 = i3;
        i3 = f;
        int i5 = i2;
        i2 = i4;
        for (int i6 = i3; i6 < a; i6 += g) {
            if ((aVar.a(i6) ^ i5) != 0) {
                b[i3] = b[i3] + g;
            } else {
                if (i3 == i) {
                    if (obj != null) {
                        c(b);
                    }
                    if (a.b(b)) {
                        this.p[f] = i2;
                        this.p[g] = i6;
                        return;
                    }
                    if (obj != null) {
                        c(b);
                    }
                    i2 += b[f] + b[g];
                    b[f] = b[h];
                    b[g] = b[i];
                    b[h] = f;
                    b[i] = f;
                    i3--;
                } else {
                    i3 += g;
                }
                b[i3] = g;
                i5 = i5 == 0 ? g : f;
            }
        }
        throw n.a();
    }

    private static boolean b(List<b> list) {
        int[][] iArr = l;
        int length = iArr.length;
        for (int i = f; i < length; i += g) {
            int[] iArr2 = iArr[i];
            if (list.size() <= iArr2.length) {
                boolean z;
                for (int i2 = f; i2 < list.size(); i2 += g) {
                    if (((b) list.get(i2)).d().a() != iArr2[i2]) {
                        z = false;
                        break;
                    }
                }
                z = g;
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void c(int[] iArr) {
        int length = iArr.length;
        for (int i = f; i < length / h; i += g) {
            int i2 = iArr[i];
            iArr[i] = iArr[(length - i) - 1];
            iArr[(length - i) - 1] = i2;
        }
    }

    private boolean i() {
        boolean z = true;
        b bVar = (b) this.n.get(f);
        b b = bVar.b();
        b c = bVar.c();
        if (c == null) {
            return false;
        }
        int i = h;
        int b2 = c.b();
        for (int i2 = g; i2 < this.n.size(); i2 += g) {
            bVar = (b) this.n.get(i2);
            b2 += bVar.b().b();
            i += g;
            c = bVar.c();
            if (c != null) {
                b2 += c.b();
                i += g;
            }
        }
        if ((b2 % 211) + ((i - 4) * 211) != b.a()) {
            z = false;
        }
        return z;
    }

    b a(com.c.b.c.a aVar, List<b> list, int i) {
        boolean z;
        c a;
        boolean z2 = list.size() % h == 0 ? true : f;
        if (this.q) {
            z = !z2 ? true : f;
        } else {
            z = z2;
        }
        int i2 = -1;
        boolean z3 = true;
        do {
            b(aVar, list, i2);
            a = a(aVar, i, z);
            if (a == null) {
                i2 = a(aVar, this.p[f]);
                continue;
            } else {
                z3 = f;
                continue;
            }
        } while (z3);
        b a2 = a(aVar, a, z, true);
        if (list.isEmpty() || !((b) list.get(list.size() - 1)).e()) {
            b a3;
            try {
                a3 = a(aVar, a, z, false);
            } catch (n e) {
                a3 = null;
            }
            return new b(a2, a3, a, true);
        }
        throw n.a();
    }

    b a(com.c.b.c.a aVar, c cVar, boolean z, boolean z2) {
        int i;
        int length;
        int[] c = c();
        c[f] = f;
        c[g] = f;
        c[h] = f;
        c[i] = f;
        c[j] = f;
        c[k] = f;
        c[6] = f;
        c[7] = f;
        if (z2) {
            q.b(aVar, cVar.b()[f], c);
        } else {
            q.a(aVar, cVar.b()[g], c);
            i = f;
            for (length = c.length - 1; i < length; length--) {
                int i2 = c[i];
                c[i] = c[length];
                c[length] = i2;
                i += g;
            }
        }
        float a = ((float) a.a(c)) / ((float) 17);
        float f = ((float) (cVar.b()[g] - cVar.b()[f])) / 15.0f;
        if (Math.abs(a - f) / f > 0.3f) {
            throw n.a();
        }
        int i3;
        int[] f2 = f();
        int[] g = g();
        float[] d = d();
        float[] e = e();
        for (length = f; length < c.length; length += g) {
            float f3 = (1.0f * ((float) c[length])) / a;
            i = (int) (0.5f + f3);
            if (i < g) {
                if (f3 < 0.3f) {
                    throw n.a();
                }
                i = g;
            } else if (i > 8) {
                if (f3 > 8.7f) {
                    throw n.a();
                }
                i = 8;
            }
            int i4 = length / h;
            if ((length & g) == 0) {
                f2[i4] = i;
                d[i4] = f3 - ((float) i);
            } else {
                g[i4] = i;
                e[i4] = f3 - ((float) i);
            }
        }
        a(17);
        int a2 = ((z2 ? f : g) + ((cVar.a() * j) + (z ? f : h))) - 1;
        i2 = f;
        i = f2.length - 1;
        length = f;
        while (i >= 0) {
            if (a(cVar, z, z2)) {
                length += e[a2][i * h] * f2[i];
            }
            i--;
            i2 = f2[i] + i2;
        }
        int length2 = g.length - 1;
        i = f;
        for (i3 = length2; i3 >= 0; i3--) {
            if (a(cVar, z, z2)) {
                i += e[a2][(i3 * h) + g] * g[i3];
            }
        }
        length += i;
        if ((i2 & g) != 0 || i2 > 13 || i2 < j) {
            throw n.a();
        }
        i = (13 - i2) / h;
        i3 = a[i];
        return new b(c[i] + ((f.a(f2, i3, true) * b[i]) + f.a(g, 9 - i3, false)), length);
    }

    public s a(int i, com.c.b.c.a aVar, Map<e, ?> map) {
        this.n.clear();
        this.q = false;
        try {
            return a(a(i, aVar));
        } catch (n e) {
            this.n.clear();
            this.q = true;
            return a(a(i, aVar));
        }
    }

    List<b> a(int i, com.c.b.c.a aVar) {
        while (true) {
            try {
                this.n.add(a(aVar, this.n, i));
            } catch (n e) {
                if (this.n.isEmpty()) {
                    throw e;
                } else if (i()) {
                    return this.n;
                } else {
                    boolean z = !this.o.isEmpty();
                    a(i, false);
                    if (z) {
                        List<b> a = a(false);
                        if (a != null) {
                            return a;
                        }
                        a = a(true);
                        if (a != null) {
                            return a;
                        }
                    }
                    throw n.a();
                }
            }
        }
    }

    public void a() {
        this.n.clear();
        this.o.clear();
    }

    List<c> h() {
        return this.o;
    }
}
