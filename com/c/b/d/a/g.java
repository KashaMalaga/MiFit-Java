package com.c.b.d.a;

import cn.com.smartdevices.bracelet.honor.a.d;
import cn.com.smartdevices.bracelet.model.ShareData;
import com.c.b.h;

public final class g {
    private static final g[] a = h();
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final j g;
    private final int h;

    private g(int i, int i2, int i3, int i4, int i5, j jVar) {
        int i6 = 0;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
        this.g = jVar;
        int a = jVar.a();
        i[] b = jVar.b();
        int length = b.length;
        int i7 = 0;
        while (i6 < length) {
            i iVar = b[i6];
            i7 += (iVar.b() + a) * iVar.a();
            i6++;
        }
        this.h = i7;
    }

    public static g a(int i, int i2) {
        if ((i & 1) == 0 && (i2 & 1) == 0) {
            for (g gVar : a) {
                if (gVar.c == i && gVar.d == i2) {
                    return gVar;
                }
            }
            throw h.a();
        }
        throw h.a();
    }

    private static g[] h() {
        return new g[]{new g(1, 10, 10, 8, 8, new j(5, new i(1, 3))), new g(2, 12, 12, 10, 10, new j(7, new i(1, 5))), new g(3, 14, 14, 12, 12, new j(10, new i(1, 8))), new g(4, 16, 16, 14, 14, new j(12, new i(1, 12))), new g(5, 18, 18, 16, 16, new j(14, new i(1, 18))), new g(6, 20, 20, 18, 18, new j(18, new i(1, 22))), new g(7, 22, 22, 20, 20, new j(20, new i(1, 30))), new g(8, 24, 24, 22, 22, new j(24, new i(1, 36))), new g(9, 26, 26, 24, 24, new j(28, new i(1, 44))), new g(10, 32, 32, 14, 14, new j(36, new i(1, 62))), new g(11, 36, 36, 16, 16, new j(42, new i(1, 86))), new g(12, 40, 40, 18, 18, new j(48, new i(1, 114))), new g(13, 44, 44, 20, 20, new j(56, new i(1, 144))), new g(14, 48, 48, 22, 22, new j(68, new i(1, 174))), new g(15, 52, 52, 24, 24, new j(42, new i(2, ShareData.SHARE_TYPE_LAB_SITUP_NEW_RECORD))), new g(16, 64, 64, 14, 14, new j(56, new i(2, 140))), new g(17, 72, 72, 16, 16, new j(36, new i(4, 92))), new g(18, 80, 80, 18, 18, new j(48, new i(4, 114))), new g(19, 88, 88, 20, 20, new j(56, new i(4, 144))), new g(20, 96, 96, 22, 22, new j(68, new i(4, 174))), new g(21, d.e, d.e, 24, 24, new j(56, new i(6, 136))), new g(22, 120, 120, 18, 18, new j(68, new i(6, 175))), new g(23, 132, 132, 20, 20, new j(62, new i(8, 163))), new g(24, 144, 144, 22, 22, new j(62, new i(8, 156), new i(2, 155))), new g(25, 8, 18, 6, 16, new j(7, new i(1, 5))), new g(26, 8, 32, 6, 14, new j(11, new i(1, 10))), new g(27, 12, 26, 10, 24, new j(14, new i(1, 16))), new g(28, 12, 36, 10, 16, new j(18, new i(1, 22))), new g(29, 16, 36, 14, 16, new j(24, new i(1, 32))), new g(30, 16, 48, 14, 22, new j(28, new i(1, 49)))};
    }

    public int a() {
        return this.b;
    }

    public int b() {
        return this.c;
    }

    public int c() {
        return this.d;
    }

    public int d() {
        return this.e;
    }

    public int e() {
        return this.f;
    }

    public int f() {
        return this.h;
    }

    j g() {
        return this.g;
    }

    public String toString() {
        return String.valueOf(this.b);
    }
}
