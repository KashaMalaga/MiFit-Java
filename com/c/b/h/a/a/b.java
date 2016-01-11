package com.c.b.h.a.a;

import com.c.b.h.a;

public final class b {
    public static final b a = new b(a.a, 3);
    private final int[] b;
    private final int[] c;
    private final c d;
    private final c e;
    private final int f;

    private b(int i, int i2) {
        int i3;
        this.f = i;
        this.b = new int[i];
        this.c = new int[i];
        int i4 = 1;
        for (i3 = 0; i3 < i; i3++) {
            this.b[i3] = i4;
            i4 = (i4 * i2) % i;
        }
        for (i3 = 0; i3 < i - 1; i3++) {
            this.c[this.b[i3]] = i3;
        }
        this.d = new c(this, new int[]{0});
        this.e = new c(this, new int[]{1});
    }

    int a(int i) {
        return this.b[i];
    }

    c a() {
        return this.d;
    }

    c a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.d;
        } else {
            int[] iArr = new int[(i + 1)];
            iArr[0] = i2;
            return new c(this, iArr);
        }
    }

    int b(int i) {
        if (i != 0) {
            return this.c[i];
        }
        throw new IllegalArgumentException();
    }

    int b(int i, int i2) {
        return (i + i2) % this.f;
    }

    c b() {
        return this.e;
    }

    int c() {
        return this.f;
    }

    int c(int i) {
        if (i != 0) {
            return this.b[(this.f - this.c[i]) - 1];
        }
        throw new ArithmeticException();
    }

    int c(int i, int i2) {
        return ((this.f + i) - i2) % this.f;
    }

    int d(int i, int i2) {
        return (i == 0 || i2 == 0) ? 0 : this.b[(this.c[i] + this.c[i2]) % (this.f - 1)];
    }
}
