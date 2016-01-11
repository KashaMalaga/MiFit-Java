package com.c.b.c.b;

import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.activeandroid.b;

public final class a {
    public static final a a = new a(4201, ChartData.d, 1);
    public static final a b = new a(1033, b.a, 1);
    public static final a c = new a(67, 64, 1);
    public static final a d = new a(19, 16, 1);
    public static final a e = new a(285, PersonInfo.INCOMING_CALL_DISABLE_BIT, 0);
    public static final a f = new a(301, PersonInfo.INCOMING_CALL_DISABLE_BIT, 1);
    public static final a g = f;
    public static final a h = c;
    private final int[] i;
    private final int[] j;
    private final b k;
    private final b l;
    private final int m;
    private final int n;
    private final int o;

    public a(int i, int i2, int i3) {
        this.n = i;
        this.m = i2;
        this.o = i3;
        this.i = new int[i2];
        this.j = new int[i2];
        int i4 = 1;
        for (int i5 = 0; i5 < i2; i5++) {
            this.i[i5] = i4;
            i4 *= 2;
            if (i4 >= i2) {
                i4 = (i4 ^ i) & (i2 - 1);
            }
        }
        for (i4 = 0; i4 < i2 - 1; i4++) {
            this.j[this.i[i4]] = i4;
        }
        this.k = new b(this, new int[]{0});
        this.l = new b(this, new int[]{1});
    }

    static int b(int i, int i2) {
        return i ^ i2;
    }

    int a(int i) {
        return this.i[i];
    }

    b a() {
        return this.k;
    }

    b a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.k;
        } else {
            int[] iArr = new int[(i + 1)];
            iArr[0] = i2;
            return new b(this, iArr);
        }
    }

    int b(int i) {
        if (i != 0) {
            return this.j[i];
        }
        throw new IllegalArgumentException();
    }

    b b() {
        return this.l;
    }

    public int c() {
        return this.m;
    }

    int c(int i) {
        if (i != 0) {
            return this.i[(this.m - this.j[i]) - 1];
        }
        throw new ArithmeticException();
    }

    int c(int i, int i2) {
        return (i == 0 || i2 == 0) ? 0 : this.i[(this.j[i] + this.j[i2]) % (this.m - 1)];
    }

    public int d() {
        return this.o;
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.n) + ',' + this.m + ')';
    }
}
