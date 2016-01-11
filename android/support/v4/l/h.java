package android.support.v4.l;

public class h<E> implements Cloneable {
    private static final Object a = new Object();
    private boolean b;
    private long[] c;
    private Object[] d;
    private int e;

    public h() {
        this(10);
    }

    public h(int i) {
        this.b = false;
        if (i == 0) {
            this.c = e.b;
            this.d = e.c;
        } else {
            int b = e.b(i);
            this.c = new long[b];
            this.d = new Object[b];
        }
        this.e = 0;
    }

    private void d() {
        int i = this.e;
        long[] jArr = this.c;
        Object[] objArr = this.d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != a) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.b = false;
        this.e = i2;
    }

    public int a(E e) {
        if (this.b) {
            d();
        }
        for (int i = 0; i < this.e; i++) {
            if (this.d[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public h<E> a() {
        try {
            h<E> hVar = (h) super.clone();
            try {
                hVar.c = (long[]) this.c.clone();
                hVar.d = (Object[]) this.d.clone();
                return hVar;
            } catch (CloneNotSupportedException e) {
                return hVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public E a(long j) {
        return a(j, null);
    }

    public E a(long j, E e) {
        int a = e.a(this.c, this.e, j);
        return (a < 0 || this.d[a] == a) ? e : this.d[a];
    }

    public void a(int i) {
        if (this.d[i] != a) {
            this.d[i] = a;
            this.b = true;
        }
    }

    public void a(int i, E e) {
        if (this.b) {
            d();
        }
        this.d[i] = e;
    }

    public int b() {
        if (this.b) {
            d();
        }
        return this.e;
    }

    public long b(int i) {
        if (this.b) {
            d();
        }
        return this.c[i];
    }

    public void b(long j) {
        int a = e.a(this.c, this.e, j);
        if (a >= 0 && this.d[a] != a) {
            this.d[a] = a;
            this.b = true;
        }
    }

    public void b(long j, E e) {
        int a = e.a(this.c, this.e, j);
        if (a >= 0) {
            this.d[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.e || this.d[a] != a) {
            if (this.b && this.e >= this.c.length) {
                d();
                a = e.a(this.c, this.e, j) ^ -1;
            }
            if (this.e >= this.c.length) {
                int b = e.b(this.e + 1);
                Object obj = new long[b];
                Object obj2 = new Object[b];
                System.arraycopy(this.c, 0, obj, 0, this.c.length);
                System.arraycopy(this.d, 0, obj2, 0, this.d.length);
                this.c = obj;
                this.d = obj2;
            }
            if (this.e - a != 0) {
                System.arraycopy(this.c, a, this.c, a + 1, this.e - a);
                System.arraycopy(this.d, a, this.d, a + 1, this.e - a);
            }
            this.c[a] = j;
            this.d[a] = e;
            this.e++;
            return;
        }
        this.c[a] = j;
        this.d[a] = e;
    }

    public E c(int i) {
        if (this.b) {
            d();
        }
        return this.d[i];
    }

    public void c() {
        int i = this.e;
        Object[] objArr = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.e = 0;
        this.b = false;
    }

    public void c(long j) {
        b(j);
    }

    public void c(long j, E e) {
        if (this.e == 0 || j > this.c[this.e - 1]) {
            if (this.b && this.e >= this.c.length) {
                d();
            }
            int i = this.e;
            if (i >= this.c.length) {
                int b = e.b(i + 1);
                Object obj = new long[b];
                Object obj2 = new Object[b];
                System.arraycopy(this.c, 0, obj, 0, this.c.length);
                System.arraycopy(this.d, 0, obj2, 0, this.d.length);
                this.c = obj;
                this.d = obj2;
            }
            this.c[i] = j;
            this.d[i] = e;
            this.e = i + 1;
            return;
        }
        b(j, e);
    }

    public /* synthetic */ Object clone() {
        return a();
    }

    public int d(long j) {
        if (this.b) {
            d();
        }
        return e.a(this.c, this.e, j);
    }

    public String toString() {
        if (b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(b(i));
            stringBuilder.append('=');
            h c = c(i);
            if (c != this) {
                stringBuilder.append(c);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
