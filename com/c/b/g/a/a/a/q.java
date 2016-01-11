package com.c.b.g.a.a.a;

import com.c.b.h;

final class q extends r {
    static final int a = 10;
    private final int b;
    private final int c;

    q(int i, int i2, int i3) {
        super(i);
        if (i2 < 0 || i2 > a || i3 < 0 || i3 > a) {
            throw h.a();
        }
        this.b = i2;
        this.c = i3;
    }

    int a() {
        return this.b;
    }

    int b() {
        return this.c;
    }

    int c() {
        return (this.b * a) + this.c;
    }

    boolean d() {
        return this.b == a;
    }

    boolean e() {
        return this.c == a;
    }

    boolean f() {
        return this.b == a || this.c == a;
    }
}
