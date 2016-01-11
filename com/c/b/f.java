package com.c.b;

public final class f {
    private final int a;
    private final int b;

    public f(int i, int i2) {
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException();
        }
        this.a = i;
        this.b = i2;
    }

    public int a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.a == fVar.a && this.b == fVar.b;
    }

    public int hashCode() {
        return (this.a * 32713) + this.b;
    }

    public String toString() {
        return this.a + "x" + this.b;
    }
}
