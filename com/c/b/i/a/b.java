package com.c.b.i.a;

final class b {
    private final int a;
    private final byte[] b;

    private b(int i, byte[] bArr) {
        this.a = i;
        this.b = bArr;
    }

    static b[] a(byte[] bArr, s sVar, o oVar) {
        if (bArr.length != sVar.c()) {
            throw new IllegalArgumentException();
        }
        int i;
        u a = sVar.a(oVar);
        t[] d = a.d();
        int i2 = 0;
        for (t a2 : d) {
            i2 += a2.a();
        }
        b[] bVarArr = new b[i2];
        int length = d.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            t tVar = d[i3];
            i2 = i4;
            i4 = 0;
            while (i4 < tVar.a()) {
                int b = tVar.b();
                i = i2 + 1;
                bVarArr[i2] = new b(b, new byte[(a.a() + b)]);
                i4++;
                i2 = i;
            }
            i3++;
            i4 = i2;
        }
        i = bVarArr[0].b.length;
        i2 = bVarArr.length - 1;
        while (i2 >= 0 && bVarArr[i2].b.length != i) {
            i2--;
        }
        length = i2 + 1;
        i -= a.a();
        int i5 = 0;
        i2 = 0;
        while (i5 < i) {
            i3 = i2;
            i2 = 0;
            while (i2 < i4) {
                int i6 = i3 + 1;
                bVarArr[i2].b[i5] = bArr[i3];
                i2++;
                i3 = i6;
            }
            i5++;
            i2 = i3;
        }
        i3 = length;
        while (i3 < i4) {
            i6 = i2 + 1;
            bVarArr[i3].b[i] = bArr[i2];
            i3++;
            i2 = i6;
        }
        int length2 = bVarArr[0].b.length;
        while (i < length2) {
            i3 = 0;
            i6 = i2;
            while (i3 < i4) {
                i5 = i6 + 1;
                bVarArr[i3].b[i3 < length ? i : i + 1] = bArr[i6];
                i3++;
                i6 = i5;
            }
            i++;
            i2 = i6;
        }
        return bVarArr;
    }

    int a() {
        return this.a;
    }

    byte[] b() {
        return this.b;
    }
}
