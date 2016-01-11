package cn.com.smartdevices.bracelet.gps.sync;

class C0478l {
    public static final int a = 100;
    private int b = a;
    private int c = 0;
    private int d = 1;
    private int e = 0;

    public C0478l(int i) {
        b(i);
    }

    public C0478l(int i, int i2) {
        this.b = i2;
        b(i);
    }

    private void b(int i) {
        if (i <= this.b) {
            this.c = this.b / i;
            return;
        }
        this.c = 1;
        this.d = i % this.b == 0 ? i / this.b : (i / this.b) + 1;
    }

    public int a(int i) {
        if (this.d <= 1) {
            this.e += this.c;
        } else if (i % this.d == 0) {
            this.e += this.c;
        }
        return this.e;
    }
}
