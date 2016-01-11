package android.support.v7.widget;

class C0260e {
    static final int a = 64;
    static final long b = Long.MIN_VALUE;
    long c = 0;
    C0260e d;

    C0260e() {
    }

    private void b() {
        if (this.d == null) {
            this.d = new C0260e();
        }
    }

    void a() {
        this.c = 0;
        if (this.d != null) {
            this.d.a();
        }
    }

    void a(int i) {
        if (i >= a) {
            b();
            this.d.a(i - 64);
            return;
        }
        this.c |= 1 << i;
    }

    void a(int i, boolean z) {
        if (i >= a) {
            b();
            this.d.a(i - 64, z);
            return;
        }
        boolean z2 = (this.c & b) != 0;
        long j = (1 << i) - 1;
        this.c = (((j ^ -1) & this.c) << 1) | (this.c & j);
        if (z) {
            a(i);
        } else {
            b(i);
        }
        if (z2 || this.d != null) {
            b();
            this.d.a(0, z2);
        }
    }

    void b(int i) {
        if (i < a) {
            this.c &= (1 << i) ^ -1;
        } else if (this.d != null) {
            this.d.b(i - 64);
        }
    }

    boolean c(int i) {
        if (i < a) {
            return (this.c & (1 << i)) != 0;
        } else {
            b();
            return this.d.c(i - 64);
        }
    }

    boolean d(int i) {
        if (i >= a) {
            b();
            return this.d.d(i - 64);
        }
        long j = 1 << i;
        boolean z = (this.c & j) != 0;
        this.c &= j ^ -1;
        j--;
        this.c = Long.rotateRight((j ^ -1) & this.c, 1) | (this.c & j);
        if (this.d == null) {
            return z;
        }
        if (this.d.c(0)) {
            a(63);
        }
        this.d.d(0);
        return z;
    }

    int e(int i) {
        return this.d == null ? i >= a ? Long.bitCount(this.c) : Long.bitCount(this.c & ((1 << i) - 1)) : i < a ? Long.bitCount(this.c & ((1 << i) - 1)) : this.d.e(i - 64) + Long.bitCount(this.c);
    }

    public String toString() {
        return this.d == null ? Long.toBinaryString(this.c) : this.d.toString() + "xx" + Long.toBinaryString(this.c);
    }
}
