package com.c.b.g.a.a.a;

import com.c.b.c.a;

abstract class i extends h {
    i(a aVar) {
        super(aVar);
    }

    protected abstract int a(int i);

    protected abstract void a(StringBuilder stringBuilder, int i);

    protected final void b(StringBuilder stringBuilder, int i, int i2) {
        int a = c().a(i, i2);
        a(stringBuilder, a);
        int a2 = a(a);
        int i3 = 100000;
        for (a = 0; a < 5; a++) {
            if (a2 / i3 == 0) {
                stringBuilder.append('0');
            }
            i3 /= 10;
        }
        stringBuilder.append(a2);
    }
}
