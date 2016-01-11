package com.c.b.a.b;

import android.support.v4.media.h;
import com.c.b.c.b;
import com.c.b.c.b.c;
import com.c.b.c.b.e;
import com.c.b.c.i;
import com.c.b.n;
import com.c.b.u;

public final class a {
    private static final int[] g = new int[]{3808, 476, 2107, 1799};
    private final b a;
    private boolean b;
    private int c;
    private int d;
    private int e;
    private int f;

    public a(b bVar) {
        this.a = bVar;
    }

    private static float a(u uVar, u uVar2) {
        return com.c.b.c.a.a.a(uVar.a(), uVar.b(), uVar2.a(), uVar2.b());
    }

    private static int a(long j, boolean z) {
        int i;
        int i2;
        int i3 = 0;
        if (z) {
            i = 7;
            i2 = 2;
        } else {
            i = 10;
            i2 = 4;
        }
        int i4 = i - i2;
        int[] iArr = new int[i];
        for (i--; i >= 0; i--) {
            iArr[i] = ((int) j) & 15;
            j >>= 4;
        }
        try {
            new c(com.c.b.c.b.a.d).a(iArr, i4);
            for (int i5 = 0; i5 < i2; i5++) {
                i3 = iArr[i5] + (i3 << 4);
            }
            return i3;
        } catch (e e) {
            throw n.a();
        }
    }

    private int a(b bVar, b bVar2) {
        float b = b(bVar, bVar2);
        float b2 = ((float) (bVar2.b() - bVar.b())) / b;
        float c = ((float) (bVar2.c() - bVar.c())) / b;
        float b3 = (float) bVar.b();
        float c2 = (float) bVar.c();
        boolean a = this.a.a(bVar.b(), bVar.c());
        int i = 0;
        float f = b3;
        b3 = c2;
        for (int i2 = 0; ((float) i2) < b; i2++) {
            f += b2;
            b3 += c;
            if (this.a.a(com.c.b.c.a.a.a(f), com.c.b.c.a.a.a(b3)) != a) {
                i++;
            }
        }
        float f2 = ((float) i) / b;
        if (f2 > 0.1f && f2 < 0.9f) {
            return 0;
        }
        return ((f2 > 0.1f ? 1 : (f2 == 0.1f ? 0 : -1)) <= 0) == a ? 1 : -1;
    }

    private int a(u uVar, u uVar2, int i) {
        int i2 = 0;
        float a = a(uVar, uVar2);
        float f = a / ((float) i);
        float a2 = uVar.a();
        float b = uVar.b();
        float a3 = ((uVar2.a() - uVar.a()) * f) / a;
        f = (f * (uVar2.b() - uVar.b())) / a;
        for (int i3 = 0; i3 < i; i3++) {
            if (this.a.a(com.c.b.c.a.a.a((((float) i3) * a3) + a2), com.c.b.c.a.a.a((((float) i3) * f) + b))) {
                i2 |= 1 << ((i - i3) - 1);
            }
        }
        return i2;
    }

    private static int a(int[] iArr, int i) {
        int i2 = 0;
        int i3 = 0;
        for (int i4 : iArr) {
            i3 += (i4 & 1) + ((i4 >> (i - 2)) << 1);
        }
        int i5 = ((i3 & 1) << 11) + (i3 >> 1);
        while (i2 < 4) {
            if (Integer.bitCount(g[i2] ^ i5) <= 2) {
                return i2;
            }
            i2++;
        }
        throw n.a();
    }

    private b a(b bVar, boolean z, int i, int i2) {
        int b = bVar.b() + i;
        int c = bVar.c() + i2;
        while (a(b, c) && this.a.a(b, c) == z) {
            b += i;
            c += i2;
        }
        int i3 = c - i2;
        c = b - i;
        while (a(c, i3) && this.a.a(c, i3) == z) {
            c += i;
        }
        b = c - i;
        c = i3;
        while (a(b, c) && this.a.a(b, c) == z) {
            c += i2;
        }
        return new b(b, c - i2);
    }

    private b a(b bVar, u uVar, u uVar2, u uVar3, u uVar4) {
        i a = i.a();
        int c = c();
        float f = (((float) c) / 2.0f) - ((float) this.e);
        float f2 = (((float) c) / 2.0f) + ((float) this.e);
        return a.a(bVar, c, c, f, f, f2, f, f2, f2, f, f2, uVar.a(), uVar.b(), uVar2.a(), uVar2.b(), uVar3.a(), uVar3.b(), uVar4.a(), uVar4.b());
    }

    private void a(u[] uVarArr) {
        if (a(uVarArr[0]) && a(uVarArr[1]) && a(uVarArr[2]) && a(uVarArr[3])) {
            int[] iArr = new int[]{a(uVarArr[0], uVarArr[1], r1), a(uVarArr[1], uVarArr[2], r1), a(uVarArr[2], uVarArr[3], r1), a(uVarArr[3], uVarArr[0], this.e * 2)};
            this.f = a(iArr, this.e * 2);
            long j = 0;
            for (int i = 0; i < 4; i++) {
                int i2 = iArr[(this.f + i) % 4];
                if (this.b) {
                    j = (j << 7) + ((long) ((i2 >> 1) & h.j));
                } else {
                    j = (j << 10) + ((long) (((i2 >> 1) & 31) + ((i2 >> 2) & 992)));
                }
            }
            int a = a(j, this.b);
            if (this.b) {
                this.c = (a >> 6) + 1;
                this.d = (a & 63) + 1;
                return;
            }
            this.c = (a >> 11) + 1;
            this.d = (a & 2047) + 1;
            return;
        }
        throw n.a();
    }

    private boolean a(int i, int i2) {
        return i >= 0 && i < this.a.f() && i2 > 0 && i2 < this.a.g();
    }

    private boolean a(b bVar, b bVar2, b bVar3, b bVar4) {
        b bVar5 = new b(bVar.b() - 3, bVar.c() + 3);
        b bVar6 = new b(bVar2.b() - 3, bVar2.c() - 3);
        b bVar7 = new b(bVar3.b() + 3, bVar3.c() - 3);
        b bVar8 = new b(bVar4.b() + 3, 3 + bVar4.c());
        int a = a(bVar8, bVar5);
        return a != 0 && a(bVar5, bVar6) == a && a(bVar6, bVar7) == a && a(bVar7, bVar8) == a;
    }

    private boolean a(u uVar) {
        return a(com.c.b.c.a.a.a(uVar.a()), com.c.b.c.a.a.a(uVar.b()));
    }

    private u[] a(b bVar) {
        boolean z = true;
        this.e = 1;
        b bVar2 = bVar;
        b bVar3 = bVar;
        b bVar4 = bVar;
        while (this.e < 9) {
            b a = a(bVar4, z, 1, -1);
            b a2 = a(bVar3, z, 1, 1);
            b a3 = a(bVar2, z, -1, 1);
            b a4 = a(bVar, z, -1, -1);
            if (this.e > 2) {
                float b = (b(a4, a) * ((float) this.e)) / (b(bVar, bVar4) * ((float) (this.e + 2)));
                if (((double) b) >= 0.75d) {
                    if (((double) b) <= 1.25d) {
                        if (!a(a, a2, a3, a4)) {
                            break;
                        }
                    }
                    break;
                }
                break;
            }
            z = !z;
            this.e++;
            bVar = a4;
            bVar2 = a3;
            bVar3 = a2;
            bVar4 = a;
        }
        if (this.e == 5 || this.e == 7) {
            this.b = this.e == 5;
            u uVar = new u(((float) bVar4.b()) + 0.5f, ((float) bVar4.c()) - 0.5f);
            u uVar2 = new u(((float) bVar3.b()) + 0.5f, ((float) bVar3.c()) + 0.5f);
            u uVar3 = new u(((float) bVar2.b()) - 0.5f, ((float) bVar2.c()) + 0.5f);
            u uVar4 = new u(((float) bVar.b()) - 0.5f, ((float) bVar.c()) - 0.5f);
            return a(new u[]{uVar, uVar2, uVar3, uVar4}, (float) ((this.e * 2) - 3), (float) (this.e * 2));
        }
        throw n.a();
    }

    private static u[] a(u[] uVarArr, float f, float f2) {
        float f3 = f2 / (2.0f * f);
        float a = uVarArr[0].a() - uVarArr[2].a();
        float b = uVarArr[0].b() - uVarArr[2].b();
        float a2 = (uVarArr[0].a() + uVarArr[2].a()) / 2.0f;
        float b2 = (uVarArr[0].b() + uVarArr[2].b()) / 2.0f;
        u uVar = new u((f3 * a) + a2, (f3 * b) + b2);
        u uVar2 = new u(a2 - (a * f3), b2 - (b * f3));
        a = uVarArr[1].a() - uVarArr[3].a();
        b = uVarArr[1].b() - uVarArr[3].b();
        a2 = (uVarArr[1].a() + uVarArr[3].a()) / 2.0f;
        b2 = (uVarArr[1].b() + uVarArr[3].b()) / 2.0f;
        u uVar3 = new u((f3 * a) + a2, (f3 * b) + b2);
        u uVar4 = new u(a2 - (a * f3), b2 - (f3 * b));
        return new u[]{uVar, uVar3, uVar2, uVar4};
    }

    private static float b(b bVar, b bVar2) {
        return com.c.b.c.a.a.a(bVar.b(), bVar.c(), bVar2.b(), bVar2.c());
    }

    private b b() {
        u uVar;
        u uVar2;
        u uVar3;
        u uVar4;
        int f;
        int g;
        try {
            u[] a = new com.c.b.c.a.c(this.a).a();
            uVar = a[0];
            uVar2 = a[1];
            uVar3 = a[2];
            uVar4 = a[3];
        } catch (n e) {
            f = this.a.f() / 2;
            g = this.a.g() / 2;
            uVar = a(new b(f + 7, g - 7), false, 1, -1).a();
            uVar2 = a(new b(f + 7, g + 7), false, 1, 1).a();
            uVar3 = a(new b(f - 7, g + 7), false, -1, 1).a();
            uVar4 = a(new b(f - 7, g - 7), false, -1, -1).a();
        }
        g = com.c.b.c.a.a.a((((uVar.a() + uVar4.a()) + uVar2.a()) + uVar3.a()) / 4.0f);
        f = com.c.b.c.a.a.a((((uVar4.b() + uVar.b()) + uVar2.b()) + uVar3.b()) / 4.0f);
        try {
            u[] a2 = new com.c.b.c.a.c(this.a, 15, g, f).a();
            uVar = a2[0];
            uVar2 = a2[1];
            uVar3 = a2[2];
            uVar4 = a2[3];
        } catch (n e2) {
            uVar = a(new b(g + 7, f - 7), false, 1, -1).a();
            uVar2 = a(new b(g + 7, f + 7), false, 1, 1).a();
            uVar3 = a(new b(g - 7, f + 7), false, -1, 1).a();
            uVar4 = a(new b(g - 7, f - 7), false, -1, -1).a();
        }
        return new b(com.c.b.c.a.a.a((((uVar.a() + uVar4.a()) + uVar2.a()) + uVar3.a()) / 4.0f), com.c.b.c.a.a.a((((uVar4.b() + uVar.b()) + uVar2.b()) + uVar3.b()) / 4.0f));
    }

    private u[] b(u[] uVarArr) {
        return a(uVarArr, (float) (this.e * 2), (float) c());
    }

    private int c() {
        return this.b ? (this.c * 4) + 11 : this.c <= 4 ? (this.c * 4) + 15 : ((this.c * 4) + ((((this.c - 4) / 8) + 1) * 2)) + 15;
    }

    public com.c.b.a.a a() {
        return a(false);
    }

    public com.c.b.a.a a(boolean z) {
        u[] a = a(b());
        if (z) {
            u uVar = a[0];
            a[0] = a[2];
            a[2] = uVar;
        }
        a(a);
        return new com.c.b.a.a(a(this.a, a[this.f % 4], a[(this.f + 1) % 4], a[(this.f + 2) % 4], a[(this.f + 3) % 4]), b(a), this.b, this.d, this.c);
    }
}
