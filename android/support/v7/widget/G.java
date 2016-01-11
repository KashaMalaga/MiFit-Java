package android.support.v7.widget;

import java.util.ArrayList;

class G<E> implements Cloneable {
    private static final Object a = new Object();
    private boolean b;
    private int[] c;
    private Object[] d;
    private int e;

    public G() {
        this(10);
    }

    public G(int i) {
        this.b = false;
        if (i == 0) {
            this.c = H.b;
            this.d = H.d;
        } else {
            int l = l(i);
            this.c = new int[l];
            this.d = new Object[l];
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

    static int h(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            if (i <= (1 << i2) - 12) {
                return (1 << i2) - 12;
            }
        }
        return i;
    }

    static int i(int i) {
        return h(i);
    }

    static int j(int i) {
        return h(i * 2) / 2;
    }

    static int k(int i) {
        return h(i * 2) / 2;
    }

    static int l(int i) {
        return h(i * 4) / 4;
    }

    static int m(int i) {
        return h(i * 4) / 4;
    }

    static int n(int i) {
        return h(i * 4) / 4;
    }

    static int o(int i) {
        return h(i * 8) / 8;
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

    public G<E> a() {
        try {
            G<E> g = (G) super.clone();
            try {
                g.c = (int[]) this.c.clone();
                g.d = (Object[]) this.d.clone();
                return g;
            } catch (CloneNotSupportedException e) {
                return g;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public E a(int i) {
        return a(i, null);
    }

    public E a(int i, E e) {
        int a = H.a(this.c, this.e, i);
        return (a < 0 || this.d[a] == a) ? e : this.d[a];
    }

    public void a(int i, int i2) {
        int min = Math.min(this.e, i + i2);
        while (i < min) {
            d(i);
            i++;
        }
    }

    public void a(ArrayList<E> arrayList, int i, int i2) {
    }

    public int b() {
        if (this.b) {
            d();
        }
        return this.e;
    }

    public void b(int i) {
        int a = H.a(this.c, this.e, i);
        if (a >= 0 && this.d[a] != a) {
            this.d[a] = a;
            this.b = true;
        }
    }

    public void b(int i, int i2) {
    }

    public void b(int i, E e) {
        int a = H.a(this.c, this.e, i);
        if (a >= 0) {
            this.d[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.e || this.d[a] != a) {
            if (this.b && this.e >= this.c.length) {
                d();
                a = H.a(this.c, this.e, i) ^ -1;
            }
            if (this.e >= this.c.length) {
                int l = l(this.e + 1);
                Object obj = new int[l];
                Object obj2 = new Object[l];
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
                int l = l(i2 + 1);
                Object obj = new int[l];
                Object obj2 = new Object[l];
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
        b(i, (Object) e);
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
        return H.a(this.c, this.e, i);
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
            G f = f(i);
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
