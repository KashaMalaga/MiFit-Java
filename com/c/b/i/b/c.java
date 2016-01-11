package com.c.b.i.b;

import com.c.b.c.a.a;
import com.c.b.c.b;
import com.c.b.c.g;
import com.c.b.c.i;
import com.c.b.c.k;
import com.c.b.e;
import com.c.b.i.a.s;
import com.c.b.n;
import com.c.b.u;
import com.c.b.v;
import java.util.Map;

public class c {
    private final b a;
    private v b;

    public c(b bVar) {
        this.a = bVar;
    }

    private float a(int i, int i2, int i3, int i4) {
        float f;
        int i5;
        int i6 = 0;
        float b = b(i, i2, i3, i4);
        int i7 = i - (i3 - i);
        if (i7 < 0) {
            f = ((float) i) / ((float) (i - i7));
            i5 = 0;
        } else if (i7 >= this.a.f()) {
            f = ((float) ((this.a.f() - 1) - i)) / ((float) (i7 - i));
            i5 = this.a.f() - 1;
        } else {
            i5 = i7;
            f = 1.0f;
        }
        i7 = (int) (((float) i2) - (f * ((float) (i4 - i2))));
        if (i7 < 0) {
            f = ((float) i2) / ((float) (i2 - i7));
        } else if (i7 >= this.a.g()) {
            f = ((float) ((this.a.g() - 1) - i2)) / ((float) (i7 - i2));
            i6 = this.a.g() - 1;
        } else {
            i6 = i7;
            f = 1.0f;
        }
        return (b(i, i2, (int) ((f * ((float) (i5 - i))) + ((float) i)), i6) + b) - 1.0f;
    }

    private float a(u uVar, u uVar2) {
        float a = a((int) uVar.a(), (int) uVar.b(), (int) uVar2.a(), (int) uVar2.b());
        float a2 = a((int) uVar2.a(), (int) uVar2.b(), (int) uVar.a(), (int) uVar.b());
        return Float.isNaN(a) ? a2 / 7.0f : Float.isNaN(a2) ? a / 7.0f : (a + a2) / 14.0f;
    }

    private static int a(u uVar, u uVar2, u uVar3, float f) {
        int a = ((a.a(u.a(uVar, uVar2) / f) + a.a(u.a(uVar, uVar3) / f)) / 2) + 7;
        switch (a & 3) {
            case kankan.wheel.widget.a.i /*0*/:
                return a + 1;
            case kankan.wheel.widget.a.k /*2*/:
                return a - 1;
            case kankan.wheel.widget.a.l /*3*/:
                throw n.a();
            default:
                return a;
        }
    }

    private static b a(b bVar, k kVar, int i) {
        return i.a().a(bVar, i, i, kVar);
    }

    private static k a(u uVar, u uVar2, u uVar3, u uVar4, int i) {
        float a;
        float b;
        float f;
        float f2;
        float f3 = ((float) i) - 3.5f;
        if (uVar4 != null) {
            a = uVar4.a();
            b = uVar4.b();
            f = f3 - 3.0f;
            f2 = f;
        } else {
            a = (uVar2.a() - uVar.a()) + uVar3.a();
            b = (uVar2.b() - uVar.b()) + uVar3.b();
            f = f3;
            f2 = f3;
        }
        return k.a(3.5f, 3.5f, f3, 3.5f, f2, f, 3.5f, f3, uVar.a(), uVar.b(), uVar2.a(), uVar2.b(), a, b, uVar3.a(), uVar3.b());
    }

    private float b(int i, int i2, int i3, int i4) {
        Object obj = Math.abs(i4 - i2) > Math.abs(i3 - i) ? 1 : null;
        if (obj == null) {
            int i5 = i4;
            i4 = i3;
            i3 = i5;
            int i6 = i2;
            i2 = i;
            i = i6;
        }
        int abs = Math.abs(i4 - i2);
        int abs2 = Math.abs(i3 - i);
        int i7 = (-abs) / 2;
        int i8 = i2 < i4 ? 1 : -1;
        int i9 = i < i3 ? 1 : -1;
        int i10 = 0;
        int i11 = i4 + i8;
        int i12 = i2;
        int i13 = i7;
        i7 = i;
        while (i12 != i11) {
            int i14;
            int i15;
            if ((i10 == 1) != this.a.a(obj != null ? i7 : i12, obj != null ? i12 : i7)) {
                i14 = i10;
            } else if (i10 == 2) {
                return a.a(i12, i7, i2, i);
            } else {
                i14 = i10 + 1;
            }
            i10 = i13 + abs2;
            if (i10 <= 0) {
                i15 = i7;
                i7 = i10;
            } else if (i7 == i3) {
                i9 = i14;
                break;
            } else {
                i15 = i7 + i9;
                i7 = i10 - abs;
            }
            i12 += i8;
            i10 = i14;
            i13 = i7;
            i7 = i15;
        }
        i9 = i10;
        return i9 == 2 ? a.a(i4 + i8, i3, i2, i) : Float.NaN;
    }

    protected final float a(u uVar, u uVar2, u uVar3) {
        return (a(uVar, uVar2) + a(uVar, uVar3)) / 2.0f;
    }

    protected final b a() {
        return this.a;
    }

    protected final g a(i iVar) {
        u b = iVar.b();
        u c = iVar.c();
        u a = iVar.a();
        float a2 = a(b, c, a);
        if (a2 < 1.0f) {
            throw n.a();
        }
        u[] uVarArr;
        int a3 = a(b, c, a, a2);
        s a4 = s.a(a3);
        int d = a4.d() - 7;
        u uVar = null;
        if (a4.b().length > 0) {
            float a5 = (c.a() - b.a()) + a.a();
            float b2 = (c.b() - b.b()) + a.b();
            float f = 1.0f - (3.0f / ((float) d));
            int a6 = (int) (((a5 - b.a()) * f) + b.a());
            d = (int) (b.b() + (f * (b2 - b.b())));
            int i = 4;
            while (i <= 16) {
                try {
                    uVar = a(a2, a6, d, (float) i);
                    break;
                } catch (n e) {
                    i <<= 1;
                }
            }
        }
        b a7 = a(this.a, a(b, c, a, uVar, a3), a3);
        if (uVar == null) {
            uVarArr = new u[]{a, b, c};
        } else {
            uVarArr = new u[]{a, b, c, uVar};
        }
        return new g(a7, uVarArr);
    }

    protected final a a(float f, int i, int i2, float f2) {
        int i3 = (int) (f2 * f);
        int max = Math.max(0, i - i3);
        int min = Math.min(this.a.f() - 1, i + i3);
        if (((float) (min - max)) < f * 3.0f) {
            throw n.a();
        }
        int max2 = Math.max(0, i2 - i3);
        int min2 = Math.min(this.a.g() - 1, i3 + i2);
        if (((float) (min2 - max2)) < f * 3.0f) {
            throw n.a();
        }
        return new b(this.a, max, max2, min - max, min2 - max2, f, this.b).a();
    }

    public final g b(Map<e, ?> map) {
        this.b = map == null ? null : (v) map.get(e.NEED_RESULT_POINT_CALLBACK);
        return a(new e(this.a, this.b).b(map));
    }

    protected final v b() {
        return this.b;
    }

    public g c() {
        return b(null);
    }
}
