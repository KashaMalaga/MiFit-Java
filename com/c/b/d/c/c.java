package com.c.b.d.c;

import cn.com.smartdevices.bracelet.model.PersonInfo;

class c implements g {
    c() {
    }

    private int a(h hVar, StringBuilder stringBuilder, StringBuilder stringBuilder2, int i) {
        int length = stringBuilder.length();
        stringBuilder.delete(length - i, length);
        hVar.a--;
        length = a(hVar.b(), stringBuilder2);
        hVar.l();
        return length;
    }

    private static String a(CharSequence charSequence, int i) {
        char charAt = (char) (((((charSequence.charAt(i) * 1600) + (charSequence.charAt(i + 1) * 40)) + charSequence.charAt(i + 2)) + 1) % PersonInfo.INCOMING_CALL_DISABLE_BIT);
        return new String(new char[]{(char) (r0 / PersonInfo.INCOMING_CALL_DISABLE_BIT), charAt});
    }

    static void a(h hVar, StringBuilder stringBuilder) {
        hVar.a(a((CharSequence) stringBuilder, 0));
        stringBuilder.delete(0, 3);
    }

    public int a() {
        return 1;
    }

    int a(char c, StringBuilder stringBuilder) {
        if (c == ' ') {
            stringBuilder.append('\u0003');
            return 1;
        } else if (c >= '0' && c <= '9') {
            stringBuilder.append((char) ((c - 48) + 4));
            return 1;
        } else if (c >= 'A' && c <= 'Z') {
            stringBuilder.append((char) ((c - 65) + 14));
            return 1;
        } else if (c >= '\u0000' && c <= '\u001f') {
            stringBuilder.append('\u0000');
            stringBuilder.append(c);
            return 2;
        } else if (c >= '!' && c <= '/') {
            stringBuilder.append('\u0001');
            stringBuilder.append((char) (c - 33));
            return 2;
        } else if (c >= ':' && c <= '@') {
            stringBuilder.append('\u0001');
            stringBuilder.append((char) ((c - 58) + 15));
            return 2;
        } else if (c >= '[' && c <= '_') {
            stringBuilder.append('\u0001');
            stringBuilder.append((char) ((c - 91) + 22));
            return 2;
        } else if (c >= '`' && c <= '\u007f') {
            stringBuilder.append('\u0002');
            stringBuilder.append((char) (c - 96));
            return 2;
        } else if (c >= '\u0080') {
            stringBuilder.append("\u0001\u001e");
            return a((char) (c - 128), stringBuilder) + 2;
        } else {
            throw new IllegalArgumentException("Illegal character: " + c);
        }
    }

    public void a(h hVar) {
        StringBuilder stringBuilder = new StringBuilder();
        while (hVar.h()) {
            char b = hVar.b();
            hVar.a++;
            int a = a(b, stringBuilder);
            int length = ((stringBuilder.length() / 3) * 2) + hVar.e();
            hVar.c(length);
            length = hVar.j().i() - length;
            if (!hVar.h()) {
                StringBuilder stringBuilder2 = new StringBuilder();
                if (stringBuilder.length() % 3 == 2 && (length < 2 || length > 2)) {
                    a = a(hVar, stringBuilder, stringBuilder2, a);
                }
                while (stringBuilder.length() % 3 == 1 && ((a <= 3 && length != 1) || a > 3)) {
                    a = a(hVar, stringBuilder, stringBuilder2, a);
                }
            } else if (stringBuilder.length() % 3 == 0) {
                a = j.a(hVar.a(), hVar.a, a());
                if (a != a()) {
                    hVar.b(a);
                    break;
                }
            }
        }
        b(hVar, stringBuilder);
    }

    void b(h hVar, StringBuilder stringBuilder) {
        int length = stringBuilder.length() % 3;
        int length2 = ((stringBuilder.length() / 3) * 2) + hVar.e();
        hVar.c(length2);
        length2 = hVar.j().i() - length2;
        if (length == 2) {
            stringBuilder.append('\u0000');
            while (stringBuilder.length() >= 3) {
                a(hVar, stringBuilder);
            }
            if (hVar.h()) {
                hVar.a('\u00fe');
            }
        } else if (length2 == 1 && length == 1) {
            while (stringBuilder.length() >= 3) {
                a(hVar, stringBuilder);
            }
            if (hVar.h()) {
                hVar.a('\u00fe');
            }
            hVar.a--;
        } else if (length == 0) {
            while (stringBuilder.length() >= 3) {
                a(hVar, stringBuilder);
            }
            if (length2 > 0 || hVar.h()) {
                hVar.a('\u00fe');
            }
        } else {
            throw new IllegalStateException("Unexpected case. Please report!");
        }
        hVar.b(0);
    }
}
