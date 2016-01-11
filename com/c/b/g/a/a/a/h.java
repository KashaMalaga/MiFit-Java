package com.c.b.g.a.a.a;

import com.c.b.c.a;

abstract class h extends j {
    protected static final int a = 40;

    h(a aVar) {
        super(aVar);
    }

    private static void a(StringBuilder stringBuilder, int i) {
        int charAt;
        int i2 = 0;
        for (int i3 = 0; i3 < 13; i3++) {
            charAt = stringBuilder.charAt(i3 + i) - 48;
            if ((i3 & 1) == 0) {
                charAt *= 3;
            }
            i2 += charAt;
        }
        charAt = 10 - (i2 % 10);
        if (charAt == 10) {
            charAt = 0;
        }
        stringBuilder.append(charAt);
    }

    protected final void a(StringBuilder stringBuilder, int i, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            int a = c().a((i3 * 10) + i, 10);
            if (a / 100 == 0) {
                stringBuilder.append('0');
            }
            if (a / 10 == 0) {
                stringBuilder.append('0');
            }
            stringBuilder.append(a);
        }
        a(stringBuilder, i2);
    }

    protected final void b(StringBuilder stringBuilder, int i) {
        stringBuilder.append("(01)");
        int length = stringBuilder.length();
        stringBuilder.append('9');
        a(stringBuilder, i, length);
    }
}
