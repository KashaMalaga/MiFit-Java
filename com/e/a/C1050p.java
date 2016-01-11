package com.e.a;

import java.util.ArrayList;

class C1050p extends C1047u {
    private int g;
    private int h;
    private int i;
    private boolean j = true;

    public C1050p(C1053s... c1053sArr) {
        super(c1053sArr);
    }

    public C1050p a() {
        ArrayList arrayList = this.e;
        int size = this.e.size();
        C1053s[] c1053sArr = new C1053s[size];
        for (int i = 0; i < size; i++) {
            c1053sArr[i] = (C1053s) ((C1051q) arrayList.get(i)).f();
        }
        return new C1050p(c1053sArr);
    }

    public Object a(float f) {
        return Integer.valueOf(b(f));
    }

    public int b(float f) {
        int i = 1;
        if (this.a == 2) {
            if (this.j) {
                this.j = false;
                this.g = ((C1053s) this.e.get(0)).g();
                this.h = ((C1053s) this.e.get(1)).g();
                this.i = this.h - this.g;
            }
            if (this.d != null) {
                f = this.d.getInterpolation(f);
            }
            return this.f == null ? this.g + ((int) (((float) this.i) * f)) : ((Number) this.f.a(f, Integer.valueOf(this.g), Integer.valueOf(this.h))).intValue();
        } else if (f <= 0.0f) {
            r0 = (C1053s) this.e.get(0);
            r1 = (C1053s) this.e.get(1);
            r2 = r0.g();
            r3 = r1.g();
            r0 = r0.c();
            r4 = r1.c();
            r1 = r1.d();
            if (r1 != null) {
                f = r1.getInterpolation(f);
            }
            r0 = (f - r0) / (r4 - r0);
            return this.f == null ? ((int) (r0 * ((float) (r3 - r2)))) + r2 : ((Number) this.f.a(r0, Integer.valueOf(r2), Integer.valueOf(r3))).intValue();
        } else if (f >= 1.0f) {
            r0 = (C1053s) this.e.get(this.a - 2);
            r1 = (C1053s) this.e.get(this.a - 1);
            r2 = r0.g();
            r3 = r1.g();
            r0 = r0.c();
            r4 = r1.c();
            r1 = r1.d();
            if (r1 != null) {
                f = r1.getInterpolation(f);
            }
            r0 = (f - r0) / (r4 - r0);
            return this.f == null ? ((int) (r0 * ((float) (r3 - r2)))) + r2 : ((Number) this.f.a(r0, Integer.valueOf(r2), Integer.valueOf(r3))).intValue();
        } else {
            C1053s c1053s = (C1053s) this.e.get(0);
            while (i < this.a) {
                r0 = (C1053s) this.e.get(i);
                if (f < r0.c()) {
                    r1 = r0.d();
                    if (r1 != null) {
                        f = r1.getInterpolation(f);
                    }
                    float c = (f - c1053s.c()) / (r0.c() - c1053s.c());
                    r2 = c1053s.g();
                    int g = r0.g();
                    return this.f == null ? ((int) (((float) (g - r2)) * c)) + r2 : ((Number) this.f.a(c, Integer.valueOf(r2), Integer.valueOf(g))).intValue();
                } else {
                    i++;
                    c1053s = r0;
                }
            }
            return ((Number) ((C1051q) this.e.get(this.a - 1)).b()).intValue();
        }
    }

    public /* synthetic */ C1047u b() {
        return a();
    }
}
