package com.c.b.g.a.a.a;

import com.c.b.c.a;
import com.c.b.n;

final class e extends i {
    private static final int b = 8;
    private static final int c = 20;
    private static final int d = 16;
    private final String e;
    private final String f;

    e(a aVar, String str, String str2) {
        super(aVar);
        this.e = str2;
        this.f = str;
    }

    private void c(StringBuilder stringBuilder, int i) {
        int a = c().a(i, (int) d);
        if (a != 38400) {
            stringBuilder.append('(');
            stringBuilder.append(this.e);
            stringBuilder.append(')');
            int i2 = a % 32;
            a /= 32;
            int i3 = (a % 12) + 1;
            a /= 12;
            if (a / 10 == 0) {
                stringBuilder.append('0');
            }
            stringBuilder.append(a);
            if (i3 / 10 == 0) {
                stringBuilder.append('0');
            }
            stringBuilder.append(i3);
            if (i2 / 10 == 0) {
                stringBuilder.append('0');
            }
            stringBuilder.append(i2);
        }
    }

    protected int a(int i) {
        return i % 100000;
    }

    public String a() {
        if (b().a() != 84) {
            throw n.a();
        }
        StringBuilder stringBuilder = new StringBuilder();
        b(stringBuilder, b);
        b(stringBuilder, 48, c);
        c(stringBuilder, 68);
        return stringBuilder.toString();
    }

    protected void a(StringBuilder stringBuilder, int i) {
        int i2 = i / 100000;
        stringBuilder.append('(');
        stringBuilder.append(this.f);
        stringBuilder.append(i2);
        stringBuilder.append(')');
    }
}
