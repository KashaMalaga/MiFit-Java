package com.xiaomi.hm.health.bt.model;

public class m {
    public static final int a = -1;
    public static final int b = -2;
    private int c = a;
    private int d = a;

    public m(int i) {
        this.c = i;
    }

    public m(int i, int i2) {
        this.c = i;
        this.d = i2;
    }

    public void a(int i, int i2) {
        this.c = i;
        this.d = i2;
    }

    public boolean a() {
        return this.d == a;
    }

    public boolean b() {
        return this.d == b;
    }

    public boolean c() {
        return this.d >= 0;
    }

    public int d() {
        return this.c;
    }

    public int e() {
        return this.d;
    }
}
