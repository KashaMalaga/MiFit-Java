package com.f.a.b.a;

import cn.com.smartdevices.bracelet.gps.c.a;

public class f {
    private static final int a = 9;
    private static final String b = "x";
    private final int c;
    private final int d;

    public f(int i, int i2) {
        this.c = i;
        this.d = i2;
    }

    public f(int i, int i2, int i3) {
        if (i3 % a.i == 0) {
            this.c = i;
            this.d = i2;
            return;
        }
        this.c = i2;
        this.d = i;
    }

    public int a() {
        return this.c;
    }

    public f a(float f) {
        return new f((int) (((float) this.c) * f), (int) (((float) this.d) * f));
    }

    public f a(int i) {
        return new f(this.c / i, this.d / i);
    }

    public int b() {
        return this.d;
    }

    public String toString() {
        return new StringBuilder(a).append(this.c).append(b).append(this.d).toString();
    }
}
