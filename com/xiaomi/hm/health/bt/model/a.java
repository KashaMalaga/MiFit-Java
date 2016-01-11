package com.xiaomi.hm.health.bt.model;

import com.xiaomi.hm.health.dataprocess.HeartRateInfo;

public class a {
    public static final int a = 3;
    public static final int b = 4;
    public int c;
    public int d;
    public int e;
    public int f;

    public a(byte b, byte b2, byte b3) {
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = HeartRateInfo.NO_HR_VALUE;
        this.c = b;
        this.d = b2;
        this.e = b3;
    }

    public a(byte b, int i, byte b2) {
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = HeartRateInfo.NO_HR_VALUE;
        this.c = b;
        this.d = i;
        this.e = b2;
    }

    public a(byte b, int i, byte b2, int i2) {
        this(b, i, b2);
        this.f = i2;
    }

    public String toString() {
        return "ActivityData [intensity=" + this.c + ", steps=" + this.d + ", category=" + this.e + "]";
    }
}
