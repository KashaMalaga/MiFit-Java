package com.c.b.i.c;

import a.a.a.B;
import android.support.v4.media.h;
import android.support.v4.view.a.C0113o;
import cn.com.smartdevices.bracelet.honor.a.d;
import cn.com.smartdevices.bracelet.model.ShareData;
import com.c.b.i.a.o;
import com.c.b.i.a.s;
import com.c.b.x;
import com.xiaomi.channel.relationservice.data.BuddyData;
import kankan.wheel.widget.a;

final class f {
    private static final int[][] a = new int[][]{new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
    private static final int[][] b = new int[][]{new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
    private static final int[][] c = new int[][]{new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, ShareData.SHARE_TYPE_LAB_SITUP_NEW_RECORD, -1, -1}, new int[]{6, 28, 54, 80, B.o, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, BuddyData.s, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, ShareData.SHARE_TYPE_LAB_SITUP_NEW_RECORD, h.i, -1}, new int[]{6, 26, 52, 78, d.e, h.k, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, BuddyData.s, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, ShareData.SHARE_TYPE_LAB_SITUP_NEW_RECORD, h.i, a.ap}, new int[]{6, 24, 50, 76, ShareData.SHARE_TYPE_LAB_SITUP_NEW_RECORD, C0113o.h, 154}, new int[]{6, 28, 54, 80, B.o, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, BuddyData.s, 142, a.aC}};
    private static final int[][] d = new int[][]{new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};
    private static final int e = 7973;
    private static final int f = 1335;
    private static final int g = 21522;

    private f() {
    }

    static int a(int i) {
        int i2 = 0;
        while (i != 0) {
            i >>>= 1;
            i2++;
        }
        return i2;
    }

    static int a(int i, int i2) {
        if (i2 == 0) {
            throw new IllegalArgumentException("0 polynomial");
        }
        int a = a(i2);
        int i3 = i << (a - 1);
        while (a(i3) >= a) {
            i3 ^= i2 << (a(i3) - a);
        }
        return i3;
    }

    private static void a(int i, int i2, b bVar) {
        int i3 = 0;
        while (i3 < 8) {
            if (b(bVar.a(i + i3, i2))) {
                bVar.a(i + i3, i2, 0);
                i3++;
            } else {
                throw new x();
            }
        }
    }

    static void a(com.c.b.c.a aVar, int i, b bVar) {
        int b = bVar.b() - 1;
        int a = bVar.a() - 1;
        int i2 = -1;
        int i3 = 0;
        while (b > 0) {
            int i4;
            int i5;
            if (b == 6) {
                i4 = a;
                i5 = b - 1;
                a = i3;
            } else {
                i4 = a;
                i5 = b;
                a = i3;
            }
            while (i4 >= 0 && i4 < bVar.a()) {
                for (i3 = 0; i3 < 2; i3++) {
                    int i6 = i5 - i3;
                    if (b(bVar.a(i6, i4))) {
                        boolean a2;
                        if (a < aVar.a()) {
                            b = a + 1;
                            a2 = aVar.a(a);
                        } else {
                            b = a;
                            a2 = false;
                        }
                        if (i != -1 && e.a(i, i6, i4)) {
                            a2 = !a2;
                        }
                        bVar.a(i6, i4, a2);
                        a = b;
                    }
                }
                i4 += i2;
            }
            i2 = -i2;
            b = i5 - 2;
            i3 = a;
            a = i4 + i2;
        }
        if (i3 != aVar.a()) {
            throw new x("Not all bits consumed: " + i3 + '/' + aVar.a());
        }
    }

    static void a(com.c.b.c.a aVar, o oVar, s sVar, int i, b bVar) {
        a(bVar);
        a(sVar, bVar);
        a(oVar, i, bVar);
        b(sVar, bVar);
        a(aVar, i, bVar);
    }

    static void a(o oVar, int i, com.c.b.c.a aVar) {
        if (g.b(i)) {
            int a = (oVar.a() << 3) | i;
            aVar.c(a, 5);
            aVar.c(a(a, (int) f), 10);
            com.c.b.c.a aVar2 = new com.c.b.c.a();
            aVar2.c(g, 15);
            aVar.b(aVar2);
            if (aVar.a() != 15) {
                throw new x("should not happen but we got: " + aVar.a());
            }
            return;
        }
        throw new x("Invalid mask pattern");
    }

    static void a(o oVar, int i, b bVar) {
        com.c.b.c.a aVar = new com.c.b.c.a();
        a(oVar, i, aVar);
        for (int i2 = 0; i2 < aVar.a(); i2++) {
            boolean a = aVar.a((aVar.a() - 1) - i2);
            bVar.a(d[i2][0], d[i2][1], a);
            if (i2 < 8) {
                bVar.a((bVar.b() - i2) - 1, 8, a);
            } else {
                bVar.a(8, (bVar.a() - 7) + (i2 - 8), a);
            }
        }
    }

    static void a(s sVar, com.c.b.c.a aVar) {
        aVar.c(sVar.a(), 6);
        aVar.c(a(sVar.a(), (int) e), 12);
        if (aVar.a() != 18) {
            throw new x("should not happen but we got: " + aVar.a());
        }
    }

    static void a(s sVar, b bVar) {
        d(bVar);
        c(bVar);
        c(sVar, bVar);
        b(bVar);
    }

    static void a(b bVar) {
        bVar.a((byte) -1);
    }

    private static void b(int i, int i2, b bVar) {
        int i3 = 0;
        while (i3 < 7) {
            if (b(bVar.a(i, i2 + i3))) {
                bVar.a(i, i2 + i3, 0);
                i3++;
            } else {
                throw new x();
            }
        }
    }

    static void b(s sVar, b bVar) {
        if (sVar.a() >= 7) {
            com.c.b.c.a aVar = new com.c.b.c.a();
            a(sVar, aVar);
            int i = 17;
            int i2 = 0;
            while (i2 < 6) {
                int i3 = i;
                for (i = 0; i < 3; i++) {
                    boolean a = aVar.a(i3);
                    i3--;
                    bVar.a(i2, (bVar.a() - 11) + i, a);
                    bVar.a((bVar.a() - 11) + i, i2, a);
                }
                i2++;
                i = i3;
            }
        }
    }

    private static void b(b bVar) {
        for (int i = 8; i < bVar.b() - 8; i++) {
            int i2 = (i + 1) % 2;
            if (b(bVar.a(i, 6))) {
                bVar.a(i, 6, i2);
            }
            if (b(bVar.a(6, i))) {
                bVar.a(6, i, i2);
            }
        }
    }

    private static boolean b(int i) {
        return i == -1;
    }

    private static void c(int i, int i2, b bVar) {
        for (int i3 = 0; i3 < 5; i3++) {
            for (int i4 = 0; i4 < 5; i4++) {
                bVar.a(i + i4, i2 + i3, b[i3][i4]);
            }
        }
    }

    private static void c(s sVar, b bVar) {
        if (sVar.a() >= 2) {
            int a = sVar.a() - 1;
            int[] iArr = c[a];
            int length = c[a].length;
            for (int i = 0; i < length; i++) {
                for (a = 0; a < length; a++) {
                    int i2 = iArr[i];
                    int i3 = iArr[a];
                    if (!(i3 == -1 || i2 == -1 || !b(bVar.a(i3, i2)))) {
                        c(i3 - 2, i2 - 2, bVar);
                    }
                }
            }
        }
    }

    private static void c(b bVar) {
        if (bVar.a(8, bVar.a() - 8) == (byte) 0) {
            throw new x();
        }
        bVar.a(8, bVar.a() - 8, 1);
    }

    private static void d(int i, int i2, b bVar) {
        for (int i3 = 0; i3 < 7; i3++) {
            for (int i4 = 0; i4 < 7; i4++) {
                bVar.a(i + i4, i2 + i3, a[i3][i4]);
            }
        }
    }

    private static void d(b bVar) {
        int length = a[0].length;
        d(0, 0, bVar);
        d(bVar.b() - length, 0, bVar);
        d(0, bVar.b() - length, bVar);
        a(0, 7, bVar);
        a(bVar.b() - 8, 7, bVar);
        a(0, bVar.b() - 8, bVar);
        b(7, 0, bVar);
        b((bVar.a() - 7) - 1, 0, bVar);
        b(7, bVar.a() - 7, bVar);
    }
}
