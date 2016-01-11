package com.c.b.h.a.a;

final class c {
    private final b a;
    private final int[] b;

    c(b bVar, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.a = bVar;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.b = iArr;
            return;
        }
        int i = 1;
        while (i < length && iArr[i] == 0) {
            i++;
        }
        if (i == length) {
            this.b = new int[]{0};
            return;
        }
        this.b = new int[(length - i)];
        System.arraycopy(iArr, i, this.b, 0, this.b.length);
    }

    int a(int i) {
        return this.b[(this.b.length - 1) - i];
    }

    c a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.a.a();
        } else {
            int length = this.b.length;
            int[] iArr = new int[(length + i)];
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = this.a.d(this.b[i3], i2);
            }
            return new c(this.a, iArr);
        }
    }

    c a(c cVar) {
        if (!this.a.equals(cVar.a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        } else if (c()) {
            return cVar;
        } else {
            if (cVar.c()) {
                return this;
            }
            Object obj = this.b;
            Object obj2 = cVar.b;
            if (obj.length <= obj2.length) {
                Object obj3 = obj2;
                obj2 = obj;
                obj = obj3;
            }
            Object obj4 = new int[obj.length];
            int length = obj.length - r1.length;
            System.arraycopy(obj, 0, obj4, 0, length);
            for (int i = length; i < obj.length; i++) {
                obj4[i] = this.a.b(r1[i - length], obj[i]);
            }
            return new c(this.a, obj4);
        }
    }

    int[] a() {
        return this.b;
    }

    int b() {
        return this.b.length - 1;
    }

    int b(int i) {
        int i2 = 0;
        if (i == 0) {
            return a(0);
        }
        int length = this.b.length;
        int i3;
        if (i == 1) {
            int[] iArr = this.b;
            int length2 = iArr.length;
            i3 = 0;
            while (i2 < length2) {
                i2++;
                i3 = this.a.b(i3, iArr[i2]);
            }
            return i3;
        }
        i3 = this.b[0];
        i2 = 1;
        while (i2 < length) {
            int b = this.a.b(this.a.d(i, i3), this.b[i2]);
            i2++;
            i3 = b;
        }
        return i3;
    }

    c b(c cVar) {
        if (this.a.equals(cVar.a)) {
            return cVar.c() ? this : a(cVar.d());
        } else {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
    }

    c c(int i) {
        if (i == 0) {
            return this.a.a();
        }
        if (i == 1) {
            return this;
        }
        int length = this.b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.a.d(this.b[i2], i);
        }
        return new c(this.a, iArr);
    }

    c c(c cVar) {
        if (!this.a.equals(cVar.a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        } else if (c() || cVar.c()) {
            return this.a.a();
        } else {
            int[] iArr = this.b;
            int length = iArr.length;
            int[] iArr2 = cVar.b;
            int length2 = iArr2.length;
            int[] iArr3 = new int[((length + length2) - 1)];
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                for (int i3 = 0; i3 < length2; i3++) {
                    iArr3[i + i3] = this.a.b(iArr3[i + i3], this.a.d(i2, iArr2[i3]));
                }
            }
            return new c(this.a, iArr3);
        }
    }

    boolean c() {
        return this.b[0] == 0;
    }

    c d() {
        int length = this.b.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = this.a.c(0, this.b[i]);
        }
        return new c(this.a, iArr);
    }

    c[] d(c cVar) {
        if (!this.a.equals(cVar.a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        } else if (cVar.c()) {
            throw new IllegalArgumentException("Divide by 0");
        } else {
            c a = this.a.a();
            int c = this.a.c(cVar.a(cVar.b()));
            c cVar2 = a;
            a = this;
            while (a.b() >= cVar.b() && !a.c()) {
                int b = a.b() - cVar.b();
                int d = this.a.d(a.a(a.b()), c);
                c a2 = cVar.a(b, d);
                cVar2 = cVar2.a(this.a.a(b, d));
                a = a.b(a2);
            }
            return new c[]{cVar2, a};
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(b() * 8);
        for (int b = b(); b >= 0; b--) {
            int a = a(b);
            if (a != 0) {
                if (a < 0) {
                    stringBuilder.append(" - ");
                    a = -a;
                } else if (stringBuilder.length() > 0) {
                    stringBuilder.append(" + ");
                }
                if (b == 0 || a != 1) {
                    stringBuilder.append(a);
                }
                if (b != 0) {
                    if (b == 1) {
                        stringBuilder.append('x');
                    } else {
                        stringBuilder.append("x^");
                        stringBuilder.append(b);
                    }
                }
            }
        }
        return stringBuilder.toString();
    }
}
