package com.c.b.h.a;

import com.c.b.h.a;
import java.util.Formatter;

final class h {
    private static final int a = 2;
    private final a b;
    private final i[] c = new i[(this.e + a)];
    private c d;
    private final int e;

    h(a aVar, c cVar) {
        this.b = aVar;
        this.e = aVar.a();
        this.d = cVar;
    }

    private static int a(int i, int i2, d dVar) {
        if (dVar == null || dVar.a()) {
            return i2;
        }
        if (!dVar.a(i)) {
            return i2 + 1;
        }
        dVar.b(i);
        return 0;
    }

    private void a(int i, int i2, d[] dVarArr) {
        d dVar = dVarArr[i2];
        d[] b = this.c[i - 1].b();
        d[] b2 = this.c[i + 1] != null ? this.c[i + 1].b() : b;
        d[] dVarArr2 = new d[14];
        dVarArr2[a] = b[i2];
        dVarArr2[3] = b2[i2];
        if (i2 > 0) {
            dVarArr2[0] = dVarArr[i2 - 1];
            dVarArr2[4] = b[i2 - 1];
            dVarArr2[5] = b2[i2 - 1];
        }
        if (i2 > 1) {
            dVarArr2[8] = dVarArr[i2 - 2];
            dVarArr2[10] = b[i2 - 2];
            dVarArr2[11] = b2[i2 - 2];
        }
        if (i2 < dVarArr.length - 1) {
            dVarArr2[1] = dVarArr[i2 + 1];
            dVarArr2[6] = b[i2 + 1];
            dVarArr2[7] = b2[i2 + 1];
        }
        if (i2 < dVarArr.length - 2) {
            dVarArr2[9] = dVarArr[i2 + a];
            dVarArr2[12] = b[i2 + a];
            dVarArr2[13] = b2[i2 + a];
        }
        int length = dVarArr2.length;
        int i3 = 0;
        while (i3 < length && !a(dVar, dVarArr2[i3])) {
            i3++;
        }
    }

    private void a(i iVar) {
        if (iVar != null) {
            ((j) iVar).a(this.b);
        }
    }

    private static boolean a(d dVar, d dVar2) {
        if (dVar2 == null || !dVar2.a() || dVar2.f() != dVar.f()) {
            return false;
        }
        dVar.b(dVar2.h());
        return true;
    }

    private int f() {
        int g = g();
        if (g == 0) {
            return 0;
        }
        for (int i = 1; i < this.e + 1; i++) {
            d[] b = this.c[i].b();
            int i2 = 0;
            while (i2 < b.length) {
                if (!(b[i2] == null || b[i2].a())) {
                    a(i, i2, b);
                }
                i2++;
            }
        }
        return g;
    }

    private int g() {
        h();
        return j() + i();
    }

    private void h() {
        int i = 0;
        if (this.c[0] != null && this.c[this.e + 1] != null) {
            d[] b = this.c[0].b();
            d[] b2 = this.c[this.e + 1].b();
            while (i < b.length) {
                if (!(b[i] == null || b2[i] == null || b[i].h() != b2[i].h())) {
                    for (int i2 = 1; i2 <= this.e; i2++) {
                        d dVar = this.c[i2].b()[i];
                        if (dVar != null) {
                            dVar.b(b[i].h());
                            if (!dVar.a()) {
                                this.c[i2].b()[i] = null;
                            }
                        }
                    }
                }
                i++;
            }
        }
    }

    private int i() {
        if (this.c[this.e + 1] == null) {
            return 0;
        }
        d[] b = this.c[this.e + 1].b();
        int i = 0;
        for (int i2 = 0; i2 < b.length; i2++) {
            if (b[i2] != null) {
                int h = b[i2].h();
                int i3 = i;
                i = 0;
                for (int i4 = this.e + 1; i4 > 0 && i < a; i4--) {
                    d dVar = this.c[i4].b()[i2];
                    if (dVar != null) {
                        i = a(h, i, dVar);
                        if (!dVar.a()) {
                            i3++;
                        }
                    }
                }
                i = i3;
            }
        }
        return i;
    }

    private int j() {
        if (this.c[0] == null) {
            return 0;
        }
        d[] b = this.c[0].b();
        int i = 0;
        for (int i2 = 0; i2 < b.length; i2++) {
            if (b[i2] != null) {
                int h = b[i2].h();
                int i3 = i;
                int i4 = 0;
                for (i = 1; i < this.e + 1 && i4 < a; i++) {
                    d dVar = this.c[i].b()[i2];
                    if (dVar != null) {
                        i4 = a(h, i4, dVar);
                        if (!dVar.a()) {
                            i3++;
                        }
                    }
                }
                i = i3;
            }
        }
        return i;
    }

    i a(int i) {
        return this.c[i];
    }

    void a(int i, i iVar) {
        this.c[i] = iVar;
    }

    public void a(c cVar) {
        this.d = cVar;
    }

    i[] a() {
        a(this.c[0]);
        a(this.c[this.e + 1]);
        int i = a.b;
        while (true) {
            int f = f();
            if (f > 0 && f < r0) {
                i = f;
            }
        }
        return this.c;
    }

    int b() {
        return this.e;
    }

    int c() {
        return this.b.c();
    }

    int d() {
        return this.b.b();
    }

    c e() {
        return this.d;
    }

    public String toString() {
        i iVar = this.c[0];
        if (iVar == null) {
            iVar = this.c[this.e + 1];
        }
        Formatter formatter = new Formatter();
        for (int i = 0; i < iVar.b().length; i++) {
            formatter.format("CW %3d:", new Object[]{Integer.valueOf(i)});
            for (int i2 = 0; i2 < this.e + a; i2++) {
                if (this.c[i2] == null) {
                    formatter.format("    |   ", new Object[0]);
                } else {
                    d dVar = this.c[i2].b()[i];
                    if (dVar == null) {
                        formatter.format("    |   ", new Object[0]);
                    } else {
                        Object[] objArr = new Object[a];
                        objArr[0] = Integer.valueOf(dVar.h());
                        objArr[1] = Integer.valueOf(dVar.g());
                        formatter.format(" %3d|%3d", objArr);
                    }
                }
            }
            formatter.format("%n", new Object[0]);
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }
}
