package com.c.b.g.a.a.a;

import cn.com.smartdevices.bracelet.gps.model.RunningReminderInfo;
import com.c.b.c.a;
import com.c.b.h;

final class t {
    private final a a;
    private final m b = new m();
    private final StringBuilder c = new StringBuilder();

    t(a aVar) {
        this.a = aVar;
    }

    static int a(a aVar, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (aVar.a(i + i4)) {
                i3 |= 1 << ((i2 - i4) - 1);
            }
        }
        return i3;
    }

    private p a() {
        l d;
        boolean b;
        do {
            int a = this.b.a();
            if (this.b.b()) {
                d = d();
                b = d.b();
            } else if (this.b.d()) {
                d = c();
                b = d.b();
            } else {
                d = b();
                b = d.b();
            }
            if ((a != this.b.a() ? 1 : null) == null && !b) {
                break;
            }
        } while (!b);
        return d.a();
    }

    private boolean a(int i) {
        if (i + 7 > this.a.a()) {
            return i + 4 <= this.a.a();
        } else {
            for (int i2 = i; i2 < i + 3; i2++) {
                if (this.a.a(i2)) {
                    return true;
                }
            }
            return this.a.a(i + 3);
        }
    }

    private l b() {
        while (a(this.b.a())) {
            q b = b(this.b.a());
            this.b.a(b.g());
            if (b.d()) {
                return new l(b.e() ? new p(this.b.a(), this.c.toString()) : new p(this.b.a(), this.c.toString(), b.b()), true);
            }
            this.c.append(b.a());
            if (b.e()) {
                return new l(new p(this.b.a(), this.c.toString()), true);
            }
            this.c.append(b.b());
        }
        if (i(this.b.a())) {
            this.b.f();
            this.b.b(4);
        }
        return new l(false);
    }

    private q b(int i) {
        if (i + 7 > this.a.a()) {
            int a = a(i, 4);
            return a == 0 ? new q(this.a.a(), 10, 10) : new q(this.a.a(), a - 1, 10);
        } else {
            int a2 = a(i, 7);
            return new q(i + 7, (a2 - 8) / 11, (a2 - 8) % 11);
        }
    }

    private l c() {
        while (c(this.b.a())) {
            o d = d(this.b.a());
            this.b.a(d.g());
            if (d.b()) {
                return new l(new p(this.b.a(), this.c.toString()), true);
            }
            this.c.append(d.a());
        }
        if (h(this.b.a())) {
            this.b.b(3);
            this.b.e();
        } else if (g(this.b.a())) {
            if (this.b.a() + 5 < this.a.a()) {
                this.b.b(5);
            } else {
                this.b.a(this.a.a());
            }
            this.b.f();
        }
        return new l(false);
    }

    private boolean c(int i) {
        boolean z = true;
        if (i + 5 > this.a.a()) {
            return false;
        }
        int a = a(i, 5);
        if (a >= 5 && a < 16) {
            return true;
        }
        if (i + 7 > this.a.a()) {
            return false;
        }
        a = a(i, 7);
        if (a >= 64 && a < 116) {
            return true;
        }
        if (i + 8 > this.a.a()) {
            return false;
        }
        a = a(i, 8);
        if (a < 232 || a >= 253) {
            z = false;
        }
        return z;
    }

    private l d() {
        while (e(this.b.a())) {
            o f = f(this.b.a());
            this.b.a(f.g());
            if (f.b()) {
                return new l(new p(this.b.a(), this.c.toString()), true);
            }
            this.c.append(f.a());
        }
        if (h(this.b.a())) {
            this.b.b(3);
            this.b.e();
        } else if (g(this.b.a())) {
            if (this.b.a() + 5 < this.a.a()) {
                this.b.b(5);
            } else {
                this.b.a(this.a.a());
            }
            this.b.g();
        }
        return new l(false);
    }

    private o d(int i) {
        int a = a(i, 5);
        if (a == 15) {
            return new o(i + 5, '$');
        }
        if (a >= 5 && a < 15) {
            return new o(i + 5, (char) ((a + 48) - 5));
        }
        a = a(i, 7);
        if (a >= 64 && a < 90) {
            return new o(i + 7, (char) (a + 1));
        }
        if (a >= 90 && a < 116) {
            return new o(i + 7, (char) (a + 7));
        }
        char c;
        switch (a(i, 8)) {
            case 232:
                c = '!';
                break;
            case 233:
                c = '\"';
                break;
            case 234:
                c = '%';
                break;
            case 235:
                c = '&';
                break;
            case 236:
                c = '\'';
                break;
            case 237:
                c = '(';
                break;
            case 238:
                c = ')';
                break;
            case com.xiaomi.hm.health.bt.profile.a.a.ac /*239*/:
                c = '*';
                break;
            case RunningReminderInfo.b /*240*/:
                c = '+';
                break;
            case 241:
                c = ',';
                break;
            case 242:
                c = '-';
                break;
            case 243:
                c = '.';
                break;
            case 244:
                c = '/';
                break;
            case 245:
                c = ':';
                break;
            case 246:
                c = ';';
                break;
            case 247:
                c = '<';
                break;
            case 248:
                c = '=';
                break;
            case 249:
                c = '>';
                break;
            case 250:
                c = '?';
                break;
            case 251:
                c = '_';
                break;
            case 252:
                c = ' ';
                break;
            default:
                throw h.a();
        }
        return new o(i + 8, c);
    }

    private boolean e(int i) {
        boolean z = true;
        if (i + 5 > this.a.a()) {
            return false;
        }
        int a = a(i, 5);
        if (a >= 5 && a < 16) {
            return true;
        }
        if (i + 6 > this.a.a()) {
            return false;
        }
        a = a(i, 6);
        if (a < 16 || a >= 63) {
            z = false;
        }
        return z;
    }

    private o f(int i) {
        int a = a(i, 5);
        if (a == 15) {
            return new o(i + 5, '$');
        }
        if (a >= 5 && a < 15) {
            return new o(i + 5, (char) ((a + 48) - 5));
        }
        a = a(i, 6);
        if (a >= 32 && a < 58) {
            return new o(i + 6, (char) (a + 33));
        }
        char c;
        switch (a) {
            case 58:
                c = '*';
                break;
            case 59:
                c = ',';
                break;
            case kankan.wheel.widget.a.aD /*60*/:
                c = '-';
                break;
            case 61:
                c = '.';
                break;
            case 62:
                c = '/';
                break;
            default:
                throw new IllegalStateException("Decoding invalid alphanumeric value: " + a);
        }
        return new o(i + 6, c);
    }

    private boolean g(int i) {
        if (i + 1 > this.a.a()) {
            return false;
        }
        int i2 = 0;
        while (i2 < 5 && i2 + i < this.a.a()) {
            if (i2 == 2) {
                if (!this.a.a(i + 2)) {
                    return false;
                }
            } else if (this.a.a(i + i2)) {
                return false;
            }
            i2++;
        }
        return true;
    }

    private boolean h(int i) {
        if (i + 3 > this.a.a()) {
            return false;
        }
        for (int i2 = i; i2 < i + 3; i2++) {
            if (this.a.a(i2)) {
                return false;
            }
        }
        return true;
    }

    private boolean i(int i) {
        if (i + 1 > this.a.a()) {
            return false;
        }
        int i2 = 0;
        while (i2 < 4 && i2 + i < this.a.a()) {
            if (this.a.a(i + i2)) {
                return false;
            }
            i2++;
        }
        return true;
    }

    int a(int i, int i2) {
        return a(this.a, i, i2);
    }

    p a(int i, String str) {
        this.c.setLength(0);
        if (str != null) {
            this.c.append(str);
        }
        this.b.a(i);
        p a = a();
        return (a == null || !a.b()) ? new p(this.b.a(), this.c.toString()) : new p(this.b.a(), this.c.toString(), a.c());
    }

    String a(StringBuilder stringBuilder, int i) {
        String str = null;
        while (true) {
            p a = a(i, str);
            str = s.a(a.a());
            if (str != null) {
                stringBuilder.append(str);
            }
            str = a.b() ? String.valueOf(a.c()) : null;
            if (i == a.g()) {
                return stringBuilder.toString();
            }
            i = a.g();
        }
    }
}
