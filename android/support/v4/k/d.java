package android.support.v4.k;

import b.a.C0374dh;
import com.xiaomi.hm.health.t;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class d {
    private static final int a = 1792;
    private static final byte[] b = new byte[a];
    private final String c;
    private final boolean d;
    private final int e;
    private int f;
    private char g;

    static {
        for (int i = 0; i < a; i++) {
            b[i] = Character.getDirectionality(i);
        }
    }

    d(String str, boolean z) {
        this.c = str;
        this.d = z;
        this.e = str.length();
    }

    private static byte a(char c) {
        return c < '\u0700' ? b[c] : Character.getDirectionality(c);
    }

    private byte e() {
        int i = this.f;
        while (this.f < this.e) {
            String str = this.c;
            int i2 = this.f;
            this.f = i2 + 1;
            this.g = str.charAt(i2);
            if (this.g == '>') {
                return C0374dh.j;
            }
            if (this.g == '\"' || this.g == '\'') {
                char c = this.g;
                while (this.f < this.e) {
                    String str2 = this.c;
                    int i3 = this.f;
                    this.f = i3 + 1;
                    char charAt = str2.charAt(i3);
                    this.g = charAt;
                    if (charAt == c) {
                        break;
                    }
                }
            }
        }
        this.f = i;
        this.g = '<';
        return C0374dh.k;
    }

    private byte f() {
        int i = this.f;
        while (this.f > 0) {
            String str = this.c;
            int i2 = this.f - 1;
            this.f = i2;
            this.g = str.charAt(i2);
            if (this.g == '<') {
                return C0374dh.j;
            }
            if (this.g == '>') {
                break;
            } else if (this.g == '\"' || this.g == '\'') {
                char c = this.g;
                while (this.f > 0) {
                    String str2 = this.c;
                    int i3 = this.f - 1;
                    this.f = i3;
                    char charAt = str2.charAt(i3);
                    this.g = charAt;
                    if (charAt == c) {
                        break;
                    }
                }
            }
        }
        this.f = i;
        this.g = '>';
        return C0374dh.k;
    }

    private byte g() {
        while (this.f < this.e) {
            String str = this.c;
            int i = this.f;
            this.f = i + 1;
            char charAt = str.charAt(i);
            this.g = charAt;
            if (charAt == ';') {
                break;
            }
        }
        return C0374dh.j;
    }

    private byte h() {
        int i = this.f;
        while (this.f > 0) {
            String str = this.c;
            int i2 = this.f - 1;
            this.f = i2;
            this.g = str.charAt(i2);
            if (this.g != '&') {
                if (this.g == ';') {
                    break;
                }
            }
            return C0374dh.j;
        }
        this.f = i;
        this.g = ';';
        return C0374dh.k;
    }

    int a() {
        this.f = 0;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (this.f < this.e && i == 0) {
            switch (c()) {
                case a.i /*0*/:
                    if (i3 != 0) {
                        i = i3;
                        break;
                    }
                    return -1;
                case l.a /*1*/:
                case a.k /*2*/:
                    if (i3 != 0) {
                        i = i3;
                        break;
                    }
                    return 1;
                case a.bo /*9*/:
                    break;
                case t.WeightView_wv_tips /*14*/:
                case a.aV /*15*/:
                    i3++;
                    i2 = -1;
                    break;
                case a.bp /*16*/:
                case a.bu /*17*/:
                    i3++;
                    i2 = 1;
                    break;
                case a.br /*18*/:
                    i3--;
                    i2 = 0;
                    break;
                default:
                    i = i3;
                    break;
            }
        }
        if (i == 0) {
            return 0;
        }
        if (i2 != 0) {
            return i2;
        }
        while (this.f > 0) {
            switch (d()) {
                case t.WeightView_wv_tips /*14*/:
                case a.aV /*15*/:
                    if (i != i3) {
                        i3--;
                        break;
                    }
                    return -1;
                case a.bp /*16*/:
                case a.bu /*17*/:
                    if (i != i3) {
                        i3--;
                        break;
                    }
                    return 1;
                case a.br /*18*/:
                    i3++;
                    break;
                default:
                    break;
            }
        }
        return 0;
    }

    int b() {
        this.f = this.e;
        int i = 0;
        int i2 = 0;
        while (this.f > 0) {
            switch (d()) {
                case a.i /*0*/:
                    if (i2 != 0) {
                        if (i != 0) {
                            break;
                        }
                        i = i2;
                        break;
                    }
                    return -1;
                case l.a /*1*/:
                case a.k /*2*/:
                    if (i2 != 0) {
                        if (i != 0) {
                            break;
                        }
                        i = i2;
                        break;
                    }
                    return 1;
                case a.bo /*9*/:
                    break;
                case t.WeightView_wv_tips /*14*/:
                case a.aV /*15*/:
                    if (i != i2) {
                        i2--;
                        break;
                    }
                    return -1;
                case a.bp /*16*/:
                case a.bu /*17*/:
                    if (i != i2) {
                        i2--;
                        break;
                    }
                    return 1;
                case a.br /*18*/:
                    i2++;
                    break;
                default:
                    if (i != 0) {
                        break;
                    }
                    i = i2;
                    break;
            }
        }
        return 0;
    }

    byte c() {
        this.g = this.c.charAt(this.f);
        if (Character.isHighSurrogate(this.g)) {
            int codePointAt = Character.codePointAt(this.c, this.f);
            this.f += Character.charCount(codePointAt);
            return Character.getDirectionality(codePointAt);
        }
        this.f++;
        byte a = a(this.g);
        return this.d ? this.g == '<' ? e() : this.g == '&' ? g() : a : a;
    }

    byte d() {
        this.g = this.c.charAt(this.f - 1);
        if (Character.isLowSurrogate(this.g)) {
            int codePointBefore = Character.codePointBefore(this.c, this.f);
            this.f -= Character.charCount(codePointBefore);
            return Character.getDirectionality(codePointBefore);
        }
        this.f--;
        byte a = a(this.g);
        return this.d ? this.g == '>' ? f() : this.g == ';' ? h() : a : a;
    }
}
