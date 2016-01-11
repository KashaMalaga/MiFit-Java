package com.xiaomi.hm.health.bt.model;

public final class p {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;

    public p(int i, int i2, int i3, int i4, int i5, int i6) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(160);
        stringBuilder.append("[[[ " + getClass().getSimpleName() + " ]]]");
        stringBuilder.append("\n  connIntMin: " + ((int) (((double) this.a) * 1.25d)) + "ms");
        stringBuilder.append("\n  connIntMax: " + ((int) (((double) this.b) * 1.25d)) + "ms");
        stringBuilder.append("\n     latency: " + this.c + "ms");
        stringBuilder.append("\n     timeout: " + (this.d * 10) + "ms");
        stringBuilder.append("\n     connInt: " + ((int) (((double) this.e) * 1.25d)) + "ms");
        stringBuilder.append("\n      advInt: " + ((int) (((double) this.f) * 0.625d)) + "ms");
        return stringBuilder.toString();
    }
}
