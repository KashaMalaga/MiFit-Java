package com.c.b.h.a;

import java.util.Formatter;

class i {
    private static final int a = 5;
    private final c b;
    private final d[] c;

    i(c cVar) {
        this.b = new c(cVar);
        this.c = new d[((cVar.d() - cVar.c()) + 1)];
    }

    final c a() {
        return this.b;
    }

    final d a(int i) {
        d c = c(i);
        if (c != null) {
            return c;
        }
        for (int i2 = 1; i2 < a; i2++) {
            int b = b(i) - i2;
            if (b >= 0) {
                c = this.c[b];
                if (c != null) {
                    return c;
                }
            }
            b = b(i) + i2;
            if (b < this.c.length) {
                c = this.c[b];
                if (c != null) {
                    return c;
                }
            }
        }
        return null;
    }

    final void a(int i, d dVar) {
        this.c[b(i)] = dVar;
    }

    final int b(int i) {
        return i - this.b.c();
    }

    final d[] b() {
        return this.c;
    }

    final d c(int i) {
        return this.c[b(i)];
    }

    public String toString() {
        Formatter formatter = new Formatter();
        d[] dVarArr = this.c;
        int length = dVarArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3;
            d dVar = dVarArr[i];
            if (dVar == null) {
                Object[] objArr = new Object[1];
                i3 = i2 + 1;
                objArr[0] = Integer.valueOf(i2);
                formatter.format("%3d:    |   %n", objArr);
            } else {
                r9 = new Object[3];
                i3 = i2 + 1;
                r9[0] = Integer.valueOf(i2);
                r9[1] = Integer.valueOf(dVar.h());
                r9[2] = Integer.valueOf(dVar.g());
                formatter.format("%3d: %3d|%3d%n", r9);
            }
            i++;
            i2 = i3;
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }
}
