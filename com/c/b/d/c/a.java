package com.c.b.d.c;

import android.support.v4.media.h;
import kankan.wheel.widget.l;

final class a implements g {
    a() {
    }

    private static char a(char c, char c2) {
        if (j.a(c) && j.a(c2)) {
            return (char) ((((c - 48) * 10) + (c2 - 48)) + h.k);
        }
        throw new IllegalArgumentException("not digits: " + c + c2);
    }

    public int a() {
        return 0;
    }

    public void a(h hVar) {
        if (j.a(hVar.a(), hVar.a) >= 2) {
            hVar.a(a(hVar.a().charAt(hVar.a), hVar.a().charAt(hVar.a + 1)));
            hVar.a += 2;
            return;
        }
        char b = hVar.b();
        int a = j.a(hVar.a(), hVar.a, a());
        if (a != a()) {
            switch (a) {
                case l.a /*1*/:
                    hVar.a('\u00e6');
                    hVar.b(1);
                    return;
                case kankan.wheel.widget.a.k /*2*/:
                    hVar.a('\u00ef');
                    hVar.b(2);
                    return;
                case kankan.wheel.widget.a.l /*3*/:
                    hVar.a('\u00ee');
                    hVar.b(3);
                    return;
                case kankan.wheel.widget.a.aQ /*4*/:
                    hVar.a('\u00f0');
                    hVar.b(4);
                    return;
                case kankan.wheel.widget.a.X /*5*/:
                    hVar.a('\u00e7');
                    hVar.b(5);
                    return;
                default:
                    throw new IllegalStateException("Illegal mode: " + a);
            }
        } else if (j.b(b)) {
            hVar.a('\u00eb');
            hVar.a((char) ((b - 128) + 1));
            hVar.a++;
        } else {
            hVar.a((char) (b + 1));
            hVar.a++;
        }
    }
}
