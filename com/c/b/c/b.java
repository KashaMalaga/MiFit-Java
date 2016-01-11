package com.c.b.c;

import java.util.Arrays;

public final class b implements Cloneable {
    private final int a;
    private final int b;
    private final int c;
    private final int[] d;

    public b(int i) {
        this(i, i);
    }

    public b(int i, int i2) {
        if (i < 1 || i2 < 1) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.a = i;
        this.b = i2;
        this.c = (i + 31) / 32;
        this.d = new int[(this.c * i2)];
    }

    private b(int i, int i2, int i3, int[] iArr) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = iArr;
    }

    public static b a(String str, String str2, String str3) {
        int i = 0;
        if (str == null) {
            throw new IllegalArgumentException();
        }
        boolean[] zArr = new boolean[str.length()];
        int i2 = 0;
        int i3 = 0;
        int i4 = -1;
        int i5 = 0;
        int i6 = 0;
        while (i2 < str.length()) {
            if (str.charAt(i2) == '\n' || str.charAt(i2) == '\r') {
                if (i6 > i5) {
                    if (i4 == -1) {
                        i4 = i6 - i5;
                    } else if (i6 - i5 != i4) {
                        throw new IllegalArgumentException("row lengths do not match");
                    }
                    i3++;
                    i5 = i6;
                }
                i2++;
            } else if (str.substring(i2, str2.length() + i2).equals(str2)) {
                i2 += str2.length();
                zArr[i6] = true;
                i6++;
            } else if (str.substring(i2, str3.length() + i2).equals(str3)) {
                i2 += str3.length();
                zArr[i6] = false;
                i6++;
            } else {
                throw new IllegalArgumentException("illegal character encountered: " + str.substring(i2));
            }
        }
        if (i6 > i5) {
            if (i4 == -1) {
                i4 = i6 - i5;
            } else if (i6 - i5 != i4) {
                throw new IllegalArgumentException("row lengths do not match");
            }
            i3++;
        }
        b bVar = new b(i4, i3);
        while (i < i6) {
            if (zArr[i]) {
                bVar.b(i % i4, i / i4);
            }
            i++;
        }
        return bVar;
    }

    public a a(int i, a aVar) {
        if (aVar == null || aVar.a() < this.a) {
            aVar = new a(this.a);
        } else {
            aVar.c();
        }
        int i2 = i * this.c;
        for (int i3 = 0; i3 < this.c; i3++) {
            aVar.a(i3 * 32, this.d[i2 + i3]);
        }
        return aVar;
    }

    public String a(String str, String str2) {
        return b(str, str2, "\n");
    }

    public void a() {
        int length = this.d.length;
        for (int i = 0; i < length; i++) {
            this.d[i] = 0;
        }
    }

    public void a(int i, int i2, int i3, int i4) {
        if (i2 < 0 || i < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        } else if (i4 < 1 || i3 < 1) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        } else {
            int i5 = i + i3;
            int i6 = i2 + i4;
            if (i6 > this.b || i5 > this.a) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            while (i2 < i6) {
                int i7 = i2 * this.c;
                for (int i8 = i; i8 < i5; i8++) {
                    int[] iArr = this.d;
                    int i9 = (i8 / 32) + i7;
                    iArr[i9] = iArr[i9] | (1 << (i8 & 31));
                }
                i2++;
            }
        }
    }

    public void a(b bVar) {
        if (this.a == bVar.f() && this.b == bVar.g() && this.c == bVar.h()) {
            a aVar = new a((this.a / 32) + 1);
            for (int i = 0; i < this.b; i++) {
                int i2 = i * this.c;
                int[] d = bVar.a(i, aVar).d();
                for (int i3 = 0; i3 < this.c; i3++) {
                    int[] iArr = this.d;
                    int i4 = i2 + i3;
                    iArr[i4] = iArr[i4] ^ d[i3];
                }
            }
            return;
        }
        throw new IllegalArgumentException("input matrix dimensions do not match");
    }

    public boolean a(int i, int i2) {
        return ((this.d[(this.c * i2) + (i / 32)] >>> (i & 31)) & 1) != 0;
    }

    @Deprecated
    public String b(String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder(this.b * (this.a + 1));
        for (int i = 0; i < this.b; i++) {
            for (int i2 = 0; i2 < this.a; i2++) {
                stringBuilder.append(a(i2, i) ? str : str2);
            }
            stringBuilder.append(str3);
        }
        return stringBuilder.toString();
    }

    public void b() {
        int f = f();
        int g = g();
        a aVar = new a(f);
        a aVar2 = new a(f);
        for (f = 0; f < (g + 1) / 2; f++) {
            aVar = a(f, aVar);
            aVar2 = a((g - 1) - f, aVar2);
            aVar.e();
            aVar2.e();
            b(f, aVar2);
            b((g - 1) - f, aVar);
        }
    }

    public void b(int i, int i2) {
        int i3 = (this.c * i2) + (i / 32);
        int[] iArr = this.d;
        iArr[i3] = iArr[i3] | (1 << (i & 31));
    }

    public void b(int i, a aVar) {
        System.arraycopy(aVar.d(), 0, this.d, this.c * i, this.c);
    }

    public void c(int i, int i2) {
        int i3 = (this.c * i2) + (i / 32);
        int[] iArr = this.d;
        iArr[i3] = iArr[i3] & ((1 << (i & 31)) ^ -1);
    }

    public int[] c() {
        int i = this.a;
        int i2 = this.b;
        int i3 = i;
        i = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < this.b; i5++) {
            int i6 = 0;
            while (i6 < this.c) {
                int i7;
                int i8 = this.d[(this.c * i5) + i6];
                if (i8 != 0) {
                    if (i5 < i2) {
                        i2 = i5;
                    }
                    if (i5 > i4) {
                        i4 = i5;
                    }
                    if (i6 * 32 < i3) {
                        i7 = 0;
                        while ((i8 << (31 - i7)) == 0) {
                            i7++;
                        }
                        if ((i6 * 32) + i7 < i3) {
                            i7 = (i6 * 32) + i7;
                            if ((i6 * 32) + 31 > i) {
                                i3 = 31;
                                while ((i8 >>> i3) == 0) {
                                    i3--;
                                }
                                if ((i6 * 32) + i3 > i) {
                                    i = (i6 * 32) + i3;
                                    i3 = i2;
                                    i2 = i;
                                    i = i4;
                                }
                            }
                            i3 = i2;
                            i2 = i;
                            i = i4;
                        }
                    }
                    i7 = i3;
                    if ((i6 * 32) + 31 > i) {
                        i3 = 31;
                        while ((i8 >>> i3) == 0) {
                            i3--;
                        }
                        if ((i6 * 32) + i3 > i) {
                            i = (i6 * 32) + i3;
                            i3 = i2;
                            i2 = i;
                            i = i4;
                        }
                    }
                    i3 = i2;
                    i2 = i;
                    i = i4;
                } else {
                    i7 = i3;
                    i3 = i2;
                    i2 = i;
                    i = i4;
                }
                i6++;
                i4 = i;
                i = i2;
                i2 = i3;
                i3 = i7;
            }
        }
        i4 -= i2;
        if (i - i3 < 0 || i4 < 0) {
            return null;
        }
        return new int[]{i3, i2, i, i4};
    }

    public /* synthetic */ Object clone() {
        return i();
    }

    public void d(int i, int i2) {
        int i3 = (this.c * i2) + (i / 32);
        int[] iArr = this.d;
        iArr[i3] = iArr[i3] ^ (1 << (i & 31));
    }

    public int[] d() {
        int i = 0;
        while (i < this.d.length && this.d[i] == 0) {
            i++;
        }
        if (i == this.d.length) {
            return null;
        }
        int i2 = i / this.c;
        int i3 = (i % this.c) * 32;
        int i4 = this.d[i];
        i = 0;
        while ((i4 << (31 - i)) == 0) {
            i++;
        }
        i3 += i;
        return new int[]{i3, i2};
    }

    public int[] e() {
        int length = this.d.length - 1;
        while (length >= 0 && this.d[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i = length / this.c;
        int i2 = (length % this.c) * 32;
        int i3 = this.d[length];
        length = 31;
        while ((i3 >>> length) == 0) {
            length--;
        }
        i2 += length;
        return new int[]{i2, i};
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.a == bVar.a && this.b == bVar.b && this.c == bVar.c && Arrays.equals(this.d, bVar.d);
    }

    public int f() {
        return this.a;
    }

    public int g() {
        return this.b;
    }

    public int h() {
        return this.c;
    }

    public int hashCode() {
        return (((((((this.a * 31) + this.a) * 31) + this.b) * 31) + this.c) * 31) + Arrays.hashCode(this.d);
    }

    public b i() {
        return new b(this.a, this.b, this.c, (int[]) this.d.clone());
    }

    public String toString() {
        return a("X ", "  ");
    }
}
