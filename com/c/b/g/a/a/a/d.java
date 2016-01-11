package com.c.b.g.a.a.a;

import com.c.b.c.a;
import com.c.b.n;

final class d extends h {
    private static final int b = 8;
    private static final int c = 2;
    private static final int d = 10;

    d(a aVar) {
        super(aVar);
    }

    public String a() {
        if (b().a() < 48) {
            throw n.a();
        }
        StringBuilder stringBuilder = new StringBuilder();
        b(stringBuilder, b);
        int a = c().a(48, (int) c);
        stringBuilder.append("(393");
        stringBuilder.append(a);
        stringBuilder.append(')');
        a = c().a(50, (int) d);
        if (a / 100 == 0) {
            stringBuilder.append('0');
        }
        if (a / d == 0) {
            stringBuilder.append('0');
        }
        stringBuilder.append(a);
        stringBuilder.append(c().a(60, null).a());
        return stringBuilder.toString();
    }
}
