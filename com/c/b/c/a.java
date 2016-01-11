package com.c.b.c;

import java.util.Arrays;

public final class a implements Cloneable {
    private int[] a;
    private int b;

    public a() {
        this.b = 0;
        this.a = new int[1];
    }

    public a(int i) {
        this.b = i;
        this.a = g(i);
    }

    a(int[] iArr, int i) {
        this.a = iArr;
        this.b = i;
    }

    private void f(int i) {
        if (i > this.a.length * 32) {
            Object g = g(i);
            System.arraycopy(this.a, 0, g, 0, this.a.length);
            this.a = g;
        }
    }

    private static int[] g(int i) {
        return new int[((i + 31) / 32)];
    }

    public int a() {
        return this.b;
    }

    public void a(int i, int i2) {
        this.a[i / 32] = i2;
    }

    public void a(int i, byte[] bArr, int i2, int i3) {
        int i4 = 0;
        int i5 = i;
        while (i4 < i3) {
            int i6 = i5;
            i5 = 0;
            for (int i7 = 0; i7 < 8; i7++) {
                if (a(i6)) {
                    i5 |= 1 << (7 - i7);
                }
                i6++;
            }
            bArr[i2 + i4] = (byte) i5;
            i4++;
            i5 = i6;
        }
    }

    public void a(a aVar) {
        int i = aVar.b;
        f(this.b + i);
        for (int i2 = 0; i2 < i; i2++) {
            a(aVar.a(i2));
        }
    }

    public void a(boolean z) {
        f(this.b + 1);
        if (z) {
            int[] iArr = this.a;
            int i = this.b / 32;
            iArr[i] = iArr[i] | (1 << (this.b & 31));
        }
        this.b++;
    }

    public boolean a(int i) {
        return (this.a[i / 32] & (1 << (i & 31))) != 0;
    }

    public boolean a(int i, int i2, boolean z) {
        if (i2 < i) {
            throw new IllegalArgumentException();
        } else if (i2 == i) {
            return true;
        } else {
            int i3 = i2 - 1;
            int i4 = i / 32;
            int i5 = i3 / 32;
            int i6 = i4;
            while (i6 <= i5) {
                int i7;
                int i8 = i6 > i4 ? 0 : i & 31;
                int i9 = i6 < i5 ? 31 : i3 & 31;
                if (i8 == 0 && i9 == 31) {
                    i8 = -1;
                } else {
                    i7 = i8;
                    i8 = 0;
                    while (i7 <= i9) {
                        int i10 = (1 << i7) | i8;
                        i7++;
                        i8 = i10;
                    }
                }
                i7 = this.a[i6] & i8;
                if (!z) {
                    i8 = 0;
                }
                if (i7 != i8) {
                    return false;
                }
                i6++;
            }
            return true;
        }
    }

    public int b() {
        return (this.b + 7) / 8;
    }

    public void b(int i) {
        int[] iArr = this.a;
        int i2 = i / 32;
        iArr[i2] = iArr[i2] | (1 << (i & 31));
    }

    public void b(int i, int i2) {
        if (i2 < i) {
            throw new IllegalArgumentException();
        } else if (i2 != i) {
            int i3 = i2 - 1;
            int i4 = i / 32;
            int i5 = i3 / 32;
            int i6 = i4;
            while (i6 <= i5) {
                int i7 = i6 > i4 ? 0 : i & 31;
                int i8 = i6 < i5 ? 31 : i3 & 31;
                if (i7 == 0 && i8 == 31) {
                    i7 = -1;
                } else {
                    int i9 = i7;
                    i7 = 0;
                    while (i9 <= i8) {
                        int i10 = (1 << i9) | i7;
                        i9++;
                        i7 = i10;
                    }
                }
                int[] iArr = this.a;
                iArr[i6] = i7 | iArr[i6];
                i6++;
            }
        }
    }

    public void b(a aVar) {
        if (this.a.length != aVar.a.length) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        for (int i = 0; i < this.a.length; i++) {
            int[] iArr = this.a;
            iArr[i] = iArr[i] ^ aVar.a[i];
        }
    }

    public void c() {
        int length = this.a.length;
        for (int i = 0; i < length; i++) {
            this.a[i] = 0;
        }
    }

    public void c(int i) {
        int[] iArr = this.a;
        int i2 = i / 32;
        iArr[i2] = iArr[i2] ^ (1 << (i & 31));
    }

    public void c(int i, int i2) {
        if (i2 < 0 || i2 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        f(this.b + i2);
        while (i2 > 0) {
            a(((i >> (i2 + -1)) & 1) == 1);
            i2--;
        }
    }

    public /* synthetic */ Object clone() {
        return f();
    }

    public int d(int i) {
        if (i >= this.b) {
            return this.b;
        }
        int i2 = i / 32;
        int i3 = this.a[i2] & (((1 << (i & 31)) - 1) ^ -1);
        while (i3 == 0) {
            i2++;
            if (i2 == this.a.length) {
                return this.b;
            }
            i3 = this.a[i2];
        }
        i3 = Integer.numberOfTrailingZeros(i3) + (i2 * 32);
        return i3 > this.b ? this.b : i3;
    }

    public int[] d() {
        return this.a;
    }

    public int e(int i) {
        if (i >= this.b) {
            return this.b;
        }
        int i2 = i / 32;
        int i3 = (this.a[i2] ^ -1) & (((1 << (i & 31)) - 1) ^ -1);
        while (i3 == 0) {
            i2++;
            if (i2 == this.a.length) {
                return this.b;
            }
            i3 = this.a[i2] ^ -1;
        }
        i3 = Integer.numberOfTrailingZeros(i3) + (i2 * 32);
        return i3 > this.b ? this.b : i3;
    }

    public void e() {
        int i;
        int i2 = 1;
        int[] iArr = new int[this.a.length];
        int i3 = (this.b - 1) / 32;
        int i4 = i3 + 1;
        for (i = 0; i < i4; i++) {
            long j = (long) this.a[i];
            j = ((j & 1431655765) << 1) | ((j >> 1) & 1431655765);
            j = ((j & 858993459) << 2) | ((j >> 2) & 858993459);
            j = ((j & 252645135) << 4) | ((j >> 4) & 252645135);
            j = ((j & 16711935) << 8) | ((j >> 8) & 16711935);
            iArr[i3 - i] = (int) (((j & 65535) << 16) | ((j >> 16) & 65535));
        }
        if (this.b != i4 * 32) {
            int i5 = (i4 * 32) - this.b;
            i3 = 1;
            for (i = 0; i < 31 - i5; i++) {
                i3 = (i3 << 1) | 1;
            }
            i = (iArr[0] >> i5) & i3;
            while (i2 < i4) {
                int i6 = iArr[i2];
                iArr[i2 - 1] = i | (i6 << (32 - i5));
                i = (i6 >> i5) & i3;
                i2++;
            }
            iArr[i4 - 1] = i;
        }
        this.a = iArr;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.b == aVar.b && Arrays.equals(this.a, aVar.a);
    }

    public a f() {
        return new a((int[]) this.a.clone(), this.b);
    }

    public int hashCode() {
        return (this.b * 31) + Arrays.hashCode(this.a);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.b);
        for (int i = 0; i < this.b; i++) {
            if ((i & 7) == 0) {
                stringBuilder.append(' ');
            }
            stringBuilder.append(a(i) ? 'X' : '.');
        }
        return stringBuilder.toString();
    }
}
