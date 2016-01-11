package com.c.b.i.a;

import com.c.b.c.b;

abstract class c {
    private static final c[] a = new c[]{new e(), new f(), new g(), new h(), new i(), new j(), new k(), new l()};

    private c() {
    }

    static c a(int i) {
        if (i >= 0 && i <= 7) {
            return a[i];
        }
        throw new IllegalArgumentException();
    }

    final void a(b bVar, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < i; i3++) {
                if (a(i2, i3)) {
                    bVar.d(i3, i2);
                }
            }
        }
    }

    abstract boolean a(int i, int i2);
}
