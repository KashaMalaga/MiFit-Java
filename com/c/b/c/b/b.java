package com.c.b.c.b;

final class b {
    private final a a;
    private final int[] b;

    b(a aVar, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.a = aVar;
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

    b a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.a.a();
        } else {
            int length = this.b.length;
            int[] iArr = new int[(length + i)];
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = this.a.c(this.b[i3], i2);
            }
            return new b(this.a, iArr);
        }
    }

    b a(b bVar) {
        if (!this.a.equals(bVar.a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (c()) {
            return bVar;
        } else {
            if (bVar.c()) {
                return this;
            }
            Object obj = this.b;
            Object obj2 = bVar.b;
            if (obj.length <= obj2.length) {
                Object obj3 = obj2;
                obj2 = obj;
                obj = obj3;
            }
            Object obj4 = new int[obj.length];
            int length = obj.length - r1.length;
            System.arraycopy(obj, 0, obj4, 0, length);
            for (int i = length; i < obj.length; i++) {
                obj4[i] = a.b(r1[i - length], obj[i]);
            }
            return new b(this.a, obj4);
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
                int b = a.b(i3, iArr[i2]);
                i2++;
                i3 = b;
            }
            return i3;
        }
        i3 = this.b[0];
        i2 = 1;
        while (i2 < length) {
            b = a.b(this.a.c(i, i3), this.b[i2]);
            i2++;
            i3 = b;
        }
        return i3;
    }

    b b(b bVar) {
        if (!this.a.equals(bVar.a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (c() || bVar.c()) {
            return this.a.a();
        } else {
            int[] iArr = this.b;
            int length = iArr.length;
            int[] iArr2 = bVar.b;
            int length2 = iArr2.length;
            int[] iArr3 = new int[((length + length2) - 1)];
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                for (int i3 = 0; i3 < length2; i3++) {
                    iArr3[i + i3] = a.b(iArr3[i + i3], this.a.c(i2, iArr2[i3]));
                }
            }
            return new b(this.a, iArr3);
        }
    }

    b c(int i) {
        if (i == 0) {
            return this.a.a();
        }
        if (i == 1) {
            return this;
        }
        int length = this.b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.a.c(this.b[i2], i);
        }
        return new b(this.a, iArr);
    }

    boolean c() {
        return this.b[0] == 0;
    }

    b[] c(b bVar) {
        if (!this.a.equals(bVar.a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (bVar.c()) {
            throw new IllegalArgumentException("Divide by 0");
        } else {
            b a = this.a.a();
            int c = this.a.c(bVar.a(bVar.b()));
            b bVar2 = a;
            a = this;
            while (a.b() >= bVar.b() && !a.c()) {
                int b = a.b() - bVar.b();
                int c2 = this.a.c(a.a(a.b()), c);
                b a2 = bVar.a(b, c2);
                bVar2 = bVar2.a(this.a.a(b, c2));
                a = a.a(a2);
            }
            return new b[]{bVar2, a};
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
                    a = this.a.b(a);
                    if (a == 0) {
                        stringBuilder.append('1');
                    } else if (a == 1) {
                        stringBuilder.append('a');
                    } else {
                        stringBuilder.append("a^");
                        stringBuilder.append(a);
                    }
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
