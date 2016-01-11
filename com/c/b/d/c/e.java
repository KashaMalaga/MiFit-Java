package com.c.b.d.c;

import java.util.Arrays;

public class e {
    private final CharSequence a;
    private final int b;
    private final int c;
    private final byte[] d;

    public e(CharSequence charSequence, int i, int i2) {
        this.a = charSequence;
        this.c = i;
        this.b = i2;
        this.d = new byte[(i * i2)];
        Arrays.fill(this.d, (byte) -1);
    }

    private void a(int i) {
        a(this.b - 1, 0, i, 1);
        a(this.b - 1, 1, i, 2);
        a(this.b - 1, 2, i, 3);
        a(0, this.c - 2, i, 4);
        a(0, this.c - 1, i, 5);
        a(1, this.c - 1, i, 6);
        a(2, this.c - 1, i, 7);
        a(3, this.c - 1, i, 8);
    }

    private void a(int i, int i2, int i3) {
        a(i - 2, i2 - 2, i3, 1);
        a(i - 2, i2 - 1, i3, 2);
        a(i - 1, i2 - 2, i3, 3);
        a(i - 1, i2 - 1, i3, 4);
        a(i - 1, i2, i3, 5);
        a(i, i2 - 2, i3, 6);
        a(i, i2 - 1, i3, 7);
        a(i, i2, i3, 8);
    }

    private void a(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        boolean z = true;
        if (i < 0) {
            i5 = i + this.b;
            i6 = (4 - ((this.b + 4) % 8)) + i2;
        } else {
            i6 = i2;
            i5 = i;
        }
        if (i6 < 0) {
            i6 += this.c;
            i5 += 4 - ((this.c + 4) % 8);
        }
        if ((this.a.charAt(i3) & (1 << (8 - i4))) == 0) {
            z = false;
        }
        a(i6, i5, z);
    }

    private void b(int i) {
        a(this.b - 3, 0, i, 1);
        a(this.b - 2, 0, i, 2);
        a(this.b - 1, 0, i, 3);
        a(0, this.c - 4, i, 4);
        a(0, this.c - 3, i, 5);
        a(0, this.c - 2, i, 6);
        a(0, this.c - 1, i, 7);
        a(1, this.c - 1, i, 8);
    }

    private void c(int i) {
        a(this.b - 3, 0, i, 1);
        a(this.b - 2, 0, i, 2);
        a(this.b - 1, 0, i, 3);
        a(0, this.c - 2, i, 4);
        a(0, this.c - 1, i, 5);
        a(1, this.c - 1, i, 6);
        a(2, this.c - 1, i, 7);
        a(3, this.c - 1, i, 8);
    }

    private void d(int i) {
        a(this.b - 1, 0, i, 1);
        a(this.b - 1, this.c - 1, i, 2);
        a(0, this.c - 3, i, 3);
        a(0, this.c - 2, i, 4);
        a(0, this.c - 1, i, 5);
        a(1, this.c - 3, i, 6);
        a(1, this.c - 2, i, 7);
        a(1, this.c - 1, i, 8);
    }

    final int a() {
        return this.b;
    }

    final void a(int i, int i2, boolean z) {
        this.d[(this.c * i2) + i] = z ? (byte) 1 : (byte) 0;
    }

    public final boolean a(int i, int i2) {
        return this.d[(this.c * i2) + i] == (byte) 1;
    }

    final int b() {
        return this.c;
    }

    final boolean b(int i, int i2) {
        return this.d[(this.c * i2) + i] >= (byte) 0;
    }

    final byte[] c() {
        return this.d;
    }

    public final void d() {
        int i = 0;
        int i2 = 4;
        int i3 = 0;
        while (true) {
            int i4;
            if (i2 == this.b && r0 == 0) {
                i4 = i3 + 1;
                a(i3);
                i3 = i4;
            }
            if (i2 == this.b - 2 && r0 == 0 && this.c % 4 != 0) {
                i4 = i3 + 1;
                b(i3);
                i3 = i4;
            }
            if (i2 == this.b - 2 && r0 == 0 && this.c % 8 == 4) {
                i4 = i3 + 1;
                c(i3);
                i3 = i4;
            }
            if (i2 == this.b + 4 && r0 == 2 && this.c % 8 == 0) {
                i4 = i3 + 1;
                d(i3);
                i3 = i4;
            }
            do {
                if (i2 < this.b && i >= 0 && !b(i, i2)) {
                    i4 = i3 + 1;
                    a(i2, i, i3);
                    i3 = i4;
                }
                i2 -= 2;
                i += 2;
                if (i2 < 0) {
                    break;
                }
            } while (i < this.c);
            i4 = i2 + 1;
            i2 = i + 3;
            i = i3;
            while (true) {
                if (i4 < 0 || i2 >= this.c || b(i2, i4)) {
                    i3 = i;
                } else {
                    i3 = i + 1;
                    a(i4, i2, i);
                }
                i4 += 2;
                i = i2 - 2;
                if (i4 >= this.b || i < 0) {
                    i2 = i4 + 3;
                    i++;
                } else {
                    i2 = i;
                    i = i3;
                }
            }
            i2 = i4 + 3;
            i++;
            if (i2 >= this.b && i >= this.c) {
                break;
            }
        }
        if (!b(this.c - 1, this.b - 1)) {
            a(this.c - 1, this.b - 1, true);
            a(this.c - 2, this.b - 2, true);
        }
    }
}
