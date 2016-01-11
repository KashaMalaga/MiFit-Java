package cn.com.smartdevices.bracelet.gps.services;

final class Q {
    Integer[] a;
    long b;

    public Q() {
        this.a = null;
        this.b = 0;
        this.a = new Integer[2];
    }

    public Q(int i, int i2) {
        this.a = null;
        this.b = 0;
        this.a = new Integer[2];
        this.a[0] = Integer.valueOf(i);
        this.a[1] = Integer.valueOf(i2);
    }

    public void a() {
        this.b = 0;
    }

    public void a(int i) {
        this.a[1] = Integer.valueOf(i);
    }

    public int b() {
        return this.a[1].intValue();
    }

    public void b(int i) {
        this.a[0] = Integer.valueOf(i);
    }

    public long c() {
        return this.b;
    }

    public int d() {
        return this.a[0].intValue();
    }

    public void e() {
        this.b = System.currentTimeMillis() / 1000;
    }
}
