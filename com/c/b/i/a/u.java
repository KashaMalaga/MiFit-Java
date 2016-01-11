package com.c.b.i.a;

public final class u {
    private final int a;
    private final t[] b;

    u(int i, t... tVarArr) {
        this.a = i;
        this.b = tVarArr;
    }

    public int a() {
        return this.a;
    }

    public int b() {
        int i = 0;
        t[] tVarArr = this.b;
        int i2 = 0;
        while (i < tVarArr.length) {
            i2 += tVarArr[i].a();
            i++;
        }
        return i2;
    }

    public int c() {
        return this.a * b();
    }

    public t[] d() {
        return this.b;
    }
}
