package com.a.a.a;

public class X {
    private final long a;
    private final long b;

    public X(long j, long j2) {
        this.a = j;
        this.b = j2;
    }

    public X(X x) {
        this.a = x.a;
        this.b = x.b;
    }

    public long a() {
        return this.a;
    }

    public long b() {
        return this.b;
    }

    public double c() {
        return ((double) this.a) / ((double) this.b);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof X)) {
            return false;
        }
        X x = (X) obj;
        return this.a == x.a && this.b == x.b;
    }

    public String toString() {
        return this.a + "/" + this.b;
    }
}
