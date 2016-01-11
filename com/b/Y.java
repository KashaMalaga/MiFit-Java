package com.b;

public class Y {
    public double a = 0.0d;
    public double b = 0.0d;
    public float c = 0.0f;
    int d = -1;
    private long e = -1;

    public long a() {
        return this.e;
    }

    public void a(long j) {
        if (j >= 0) {
            this.e = ao.a() + j;
        } else {
            this.e = j;
        }
    }

    public String b() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a).append("#").append(this.b).append("#").append(this.c);
        return stringBuilder.toString();
    }
}
