package cn.com.smartdevices.bracelet.gps.services;

class X {
    static final int a = 0;
    static final int b = 1;
    static final int c = -1;
    private static final int f = 10000;
    private static final int g = 180000;
    private final int d = C0463w.UNAVAILABLE.a();
    private final int e = C0463w.AVAILABLE.a();
    private int h = C0463w.DEFAULT.a();
    private int i = C0463w.DEFAULT.a();
    private int j = C0463w.DEFAULT.a();
    private boolean k = false;
    private boolean l = false;
    private long m = 0;
    private long n = System.currentTimeMillis();
    private C0464x o = null;

    public X(C0464x c0464x) {
        this.o = c0464x;
    }

    int a() {
        return this.j;
    }

    int a(int i, boolean z) {
        int i2 = this.h;
        int i3 = C0463w.a(i) ? this.e : this.d;
        if (this.h <= this.d) {
            this.h = this.d;
            this.h = i3 | this.h;
        } else {
            this.h = i3 & this.h;
        }
        if (z) {
            return c;
        }
        if (this.h > this.d || i2 == C0463w.DEFAULT.a()) {
            this.n = System.currentTimeMillis();
        }
        if (!this.l && this.h <= this.d && System.currentTimeMillis() - this.n >= 180000) {
            this.l = true;
            return a;
        } else if (!this.l || this.h <= this.d) {
            return c;
        } else {
            this.l = false;
            return b;
        }
    }

    void a(int i) {
        int i2 = C0463w.a(i) ? this.e : this.d;
        if (this.i != i2) {
            this.i = i2;
            this.k = false;
            this.m = System.currentTimeMillis();
            if (this.i == this.e) {
                this.j = i;
                this.o.a(i);
            }
        } else if (!this.k && this.i == this.d && System.currentTimeMillis() - this.m >= 10000) {
            this.k = true;
            this.j = i;
            this.o.a(i);
        }
    }

    void b() {
        this.l = false;
        this.n = System.currentTimeMillis();
        this.h = C0463w.DEFAULT.a();
    }
}
