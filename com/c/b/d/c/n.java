package com.c.b.d.c;

final class n extends c {
    n() {
    }

    public int a() {
        return 3;
    }

    int a(char c, StringBuilder stringBuilder) {
        if (c == '\r') {
            stringBuilder.append('\u0000');
        } else if (c == '*') {
            stringBuilder.append('\u0001');
        } else if (c == '>') {
            stringBuilder.append('\u0002');
        } else if (c == ' ') {
            stringBuilder.append('\u0003');
        } else if (c >= '0' && c <= '9') {
            stringBuilder.append((char) ((c - 48) + 4));
        } else if (c < 'A' || c > 'Z') {
            j.c(c);
        } else {
            stringBuilder.append((char) ((c - 65) + 14));
        }
        return 1;
    }

    public void a(h hVar) {
        StringBuilder stringBuilder = new StringBuilder();
        while (hVar.h()) {
            char b = hVar.b();
            hVar.a++;
            a(b, stringBuilder);
            if (stringBuilder.length() % 3 == 0) {
                c.a(hVar, stringBuilder);
                int a = j.a(hVar.a(), hVar.a, a());
                if (a != a()) {
                    hVar.b(a);
                    break;
                }
            }
        }
        b(hVar, stringBuilder);
    }

    void b(h hVar, StringBuilder stringBuilder) {
        hVar.k();
        int i = hVar.j().i() - hVar.e();
        hVar.a -= stringBuilder.length();
        if (hVar.i() > 1 || i > 1 || hVar.i() != i) {
            hVar.a('\u00fe');
        }
        if (hVar.f() < 0) {
            hVar.b(0);
        }
    }
}
