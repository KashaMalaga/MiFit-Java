package android.support.v4.l;

public class d<E> {
    private E[] a;
    private int b;
    private int c;
    private int d;

    public d() {
        this(8);
    }

    public d(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("capacity must be positive");
        }
        if (Integer.bitCount(i) != 1) {
            i = 1 << (Integer.highestOneBit(i) + 1);
        }
        this.d = i - 1;
        this.a = new Object[i];
    }

    private void g() {
        int length = this.a.length;
        int i = length - this.b;
        int i2 = length << 1;
        if (i2 < 0) {
            throw new RuntimeException("Too big");
        }
        Object obj = new Object[i2];
        System.arraycopy(this.a, this.b, obj, 0, i);
        System.arraycopy(this.a, 0, obj, i, this.b);
        this.a = (Object[]) obj;
        this.b = 0;
        this.c = length;
        this.d = i2 - 1;
    }

    public final E a() {
        if (this.b == this.c) {
            throw new ArrayIndexOutOfBoundsException();
        }
        E e = this.a[this.b];
        this.a[this.b] = null;
        this.b = (this.b + 1) & this.d;
        return e;
    }

    public final E a(int i) {
        if (i < 0 || i >= e()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.a[(this.b + i) & this.d];
    }

    public final void a(E e) {
        this.b = (this.b - 1) & this.d;
        this.a[this.b] = e;
        if (this.b == this.c) {
            g();
        }
    }

    public final E b() {
        if (this.b == this.c) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i = (this.c - 1) & this.d;
        E e = this.a[i];
        this.a[i] = null;
        this.c = i;
        return e;
    }

    public final void b(E e) {
        this.a[this.c] = e;
        this.c = (this.c + 1) & this.d;
        if (this.c == this.b) {
            g();
        }
    }

    public final E c() {
        if (this.b != this.c) {
            return this.a[this.b];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public final E d() {
        if (this.b != this.c) {
            return this.a[(this.c - 1) & this.d];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public final int e() {
        return (this.c - this.b) & this.d;
    }

    public final boolean f() {
        return this.b == this.c;
    }
}
