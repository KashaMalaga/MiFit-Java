package android.support.v4.l;

public class v<E> implements Cloneable {
    private static final Object a = new Object();
    private boolean b;
    private int[] c;
    private Object[] d;
    private int e;

    public v() {
        this(10);
    }

    public v(int i) {
        this.b = false;
        if (i == 0) {
            this.c = e.a;
            this.d = e.c;
        } else {
            int a = e.a(i);
            this.c = new int[a];
            this.d = new Object[a];
        }
        this.e = 0;
    }

    private void d() {
        int i = this.e;
        int[] iArr = this.c;
        Object[] objArr = this.d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
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

    public v<E> a() {
        try {
            v<E> vVar = (v) super.clone();
            try {
                vVar.c = (int[]) this.c.clone();
                vVar.d = (Object[]) this.d.clone();
                return vVar;
            } catch (CloneNotSupportedException e) {
                return vVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public E a(int i) {
        return a(i, null);
    }

    public E a(int i, E e) {
        int a = e.a(this.c, this.e, i);
        return (a < 0 || this.d[a] == a) ? e : this.d[a];
    }

    public void a(int i, int i2) {
        int min = Math.min(this.e, i + i2);
        while (i < min) {
            d(i);
            i++;
        }
    }

    public int b() {
        if (this.b) {
            d();
        }
        return this.e;
    }

    public void b(int i) {
        int a = e.a(this.c, this.e, i);
        if (a >= 0 && this.d[a] != a) {
            this.d[a] = a;
            this.b = true;
        }
    }

    public void b(int i, E e) {
        int a = e.a(this.c, this.e, i);
        if (a >= 0) {
            this.d[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.e || this.d[a] != a) {
            if (this.b && this.e >= this.c.length) {
                d();
                a = e.a(this.c, this.e, i) ^ -1;
            }
            if (this.e >= this.c.length) {
                int a2 = e.a(this.e + 1);
                Object obj = new int[a2];
                Object obj2 = new Object[a2];
                System.arraycopy(this.c, 0, obj, 0, this.c.length);
                System.arraycopy(this.d, 0, obj2, 0, this.d.length);
                this.c = obj;
                this.d = obj2;
            }
            if (this.e - a != 0) {
                System.arraycopy(this.c, a, this.c, a + 1, this.e - a);
                System.arraycopy(this.d, a, this.d, a + 1, this.e - a);
            }
            this.c[a] = i;
            this.d[a] = e;
            this.e++;
            return;
        }
        this.c[a] = i;
        this.d[a] = e;
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

    public void c(int i) {
        b(i);
    }

    public void c(int i, E e) {
        if (this.b) {
            d();
        }
        this.d[i] = e;
    }

    public /* synthetic */ Object clone() {
        return a();
    }

    public void d(int i) {
        if (this.d[i] != a) {
            this.d[i] = a;
            this.b = true;
        }
    }

    public void d(int i, E e) {
        if (this.e == 0 || i > this.c[this.e - 1]) {
            if (this.b && this.e >= this.c.length) {
                d();
            }
            int i2 = this.e;
            if (i2 >= this.c.length) {
                int a = e.a(i2 + 1);
                Object obj = new int[a];
                Object obj2 = new Object[a];
                System.arraycopy(this.c, 0, obj, 0, this.c.length);
                System.arraycopy(this.d, 0, obj2, 0, this.d.length);
                this.c = obj;
                this.d = obj2;
            }
            this.c[i2] = i;
            this.d[i2] = e;
            this.e = i2 + 1;
            return;
        }
        b(i, e);
    }

    public int e(int i) {
        if (this.b) {
            d();
        }
        return this.c[i];
    }

    public E f(int i) {
        if (this.b) {
            d();
        }
        return this.d[i];
    }

    public int g(int i) {
        if (this.b) {
            d();
        }
        return e.a(this.c, this.e, i);
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
            stringBuilder.append(e(i));
            stringBuilder.append('=');
            v f = f(i);
            if (f != this) {
                stringBuilder.append(f);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
