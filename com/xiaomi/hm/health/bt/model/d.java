package com.xiaomi.hm.health.bt.model;

import com.xiaomi.hm.health.dataprocess.HeartRateInfo;

public class d {
    private int a = 0;
    private int b = 0;
    private int c = 0;
    private int d = 0;
    private int e = -1;

    public d(byte b, byte b2, byte b3) {
        this.e = b;
        this.a = (b >> 4) & 15;
        this.b = b & 15;
        this.c = b2 & HeartRateInfo.HR_EMPTY_VALUE;
        this.d = b3 & HeartRateInfo.HR_EMPTY_VALUE;
    }

    public d(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public int a() {
        return this.a * 10;
    }

    public void a(int i) {
        this.a = i;
    }

    public float b() {
        return ((float) this.b) / 15.0f;
    }

    public void b(int i) {
        this.b = i;
    }

    public int c() {
        return this.c * 2;
    }

    public void c(int i) {
        this.c = i;
    }

    public int d() {
        return this.d * 2;
    }

    public void d(int i) {
        this.d = i;
    }

    public int e() {
        return this.e;
    }

    public byte[] f() {
        return new byte[]{(byte) (((this.a & 15) << 4) | (this.b & 15)), (byte) this.c, (byte) this.d};
    }

    public String toString() {
        return "{time:" + this.a + ",percent:" + this.b + ",frontSteps:" + this.c + ",totalSteps:" + this.d + "}";
    }
}
