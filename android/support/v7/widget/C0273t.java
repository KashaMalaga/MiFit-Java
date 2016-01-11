package android.support.v7.widget;

import android.util.SparseIntArray;

public abstract class C0273t {
    final SparseIntArray a = new SparseIntArray();
    private boolean b = false;

    public abstract int a(int i);

    public int a(int i, int i2) {
        int a = a(i);
        if (a == i2) {
            return 0;
        }
        int b;
        int a2;
        int i3;
        if (this.b && this.a.size() > 0) {
            b = b(i);
            if (b >= 0) {
                a2 = this.a.get(b) + a(b);
                b++;
                i3 = b;
                while (i3 < i) {
                    b = a(i3);
                    a2 += b;
                    if (a2 == i2) {
                        b = 0;
                    } else if (a2 <= i2) {
                        b = a2;
                    }
                    i3++;
                    a2 = b;
                }
                return a2 + a > i2 ? a2 : 0;
            }
        }
        b = 0;
        a2 = 0;
        i3 = b;
        while (i3 < i) {
            b = a(i3);
            a2 += b;
            if (a2 == i2) {
                b = 0;
            } else if (a2 <= i2) {
                b = a2;
            }
            i3++;
            a2 = b;
        }
        if (a2 + a > i2) {
        }
    }

    public void a() {
        this.a.clear();
    }

    public void a(boolean z) {
        this.b = z;
    }

    int b(int i) {
        int i2 = 0;
        int size = this.a.size() - 1;
        while (i2 <= size) {
            int i3 = (i2 + size) >>> 1;
            if (this.a.keyAt(i3) < i) {
                i2 = i3 + 1;
            } else {
                size = i3 - 1;
            }
        }
        size = i2 - 1;
        return (size < 0 || size >= this.a.size()) ? -1 : this.a.keyAt(size);
    }

    int b(int i, int i2) {
        if (!this.b) {
            return a(i, i2);
        }
        int i3 = this.a.get(i, -1);
        if (i3 != -1) {
            return i3;
        }
        i3 = a(i, i2);
        this.a.put(i, i3);
        return i3;
    }

    public boolean b() {
        return this.b;
    }

    public int c(int i, int i2) {
        int a = a(i);
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < i) {
            int a2 = a(i3);
            i5 += a2;
            if (i5 == i2) {
                i4++;
                a2 = 0;
            } else if (i5 > i2) {
                i4++;
            } else {
                a2 = i5;
            }
            i3++;
            i5 = a2;
        }
        return i5 + a > i2 ? i4 + 1 : i4;
    }
}
