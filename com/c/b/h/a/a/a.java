package com.c.b.h.a.a;

import com.c.b.d;

public final class a {
    private final b a = b.a;

    private int[] a(c cVar) {
        int b = cVar.b();
        int[] iArr = new int[b];
        int i = 0;
        for (int i2 = 1; i2 < this.a.c() && i < b; i2++) {
            if (cVar.b(i2) == 0) {
                iArr[i] = this.a.c(i2);
                i++;
            }
        }
        if (i == b) {
            return iArr;
        }
        throw d.a();
    }

    private int[] a(c cVar, c cVar2, int[] iArr) {
        int i;
        int b = cVar2.b();
        int[] iArr2 = new int[b];
        for (i = 1; i <= b; i++) {
            iArr2[b - i] = this.a.d(i, cVar2.a(i));
        }
        c cVar3 = new c(this.a, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (i = 0; i < length; i++) {
            int c = this.a.c(iArr[i]);
            iArr3[i] = this.a.d(this.a.c(0, cVar.b(c)), this.a.c(cVar3.b(c)));
        }
        return iArr3;
    }

    private c[] a(c cVar, c cVar2, int i) {
        if (cVar.b() >= cVar2.b()) {
            c cVar3 = cVar2;
            cVar2 = cVar;
            cVar = cVar3;
        }
        c a = this.a.a();
        c b = this.a.b();
        while (cVar.b() >= i / 2) {
            if (cVar.c()) {
                throw d.a();
            }
            c a2 = this.a.a();
            int c = this.a.c(cVar.a(cVar.b()));
            c cVar4 = a2;
            a2 = cVar2;
            while (a2.b() >= cVar.b() && !a2.c()) {
                int b2 = a2.b() - cVar.b();
                int d = this.a.d(a2.a(a2.b()), c);
                cVar4 = cVar4.a(this.a.a(b2, d));
                a2 = a2.b(cVar.a(b2, d));
            }
            cVar2 = cVar;
            cVar = a2;
            cVar3 = b;
            b = cVar4.c(b).b(a).d();
            a = cVar3;
        }
        int a3 = b.a(0);
        if (a3 == 0) {
            throw d.a();
        }
        a3 = this.a.c(a3);
        b = b.c(a3);
        a = cVar.c(a3);
        return new c[]{b, a};
    }

    public int a(int[] iArr, int i, int[] iArr2) {
        c cVar = new c(this.a, iArr);
        int[] iArr3 = new int[i];
        int i2 = 0;
        for (int i3 = i; i3 > 0; i3--) {
            int b = cVar.b(this.a.a(i3));
            iArr3[i - i3] = b;
            if (b != 0) {
                i2 = 1;
            }
        }
        if (i2 == 0) {
            return 0;
        }
        c cVar2;
        c b2 = this.a.b();
        if (iArr2 != null) {
            cVar2 = b2;
            for (int b3 : iArr2) {
                b3 = this.a.a((iArr.length - 1) - b3);
                cVar2 = cVar2.c(new c(this.a, new int[]{this.a.c(0, b3), 1}));
            }
        }
        c[] a = a(this.a.a(i, 1), new c(this.a, iArr3), i);
        cVar2 = a[0];
        b2 = a[1];
        int[] a2 = a(cVar2);
        int[] a3 = a(b2, cVar2, a2);
        for (i2 = 0; i2 < a2.length; i2++) {
            int length = (iArr.length - 1) - this.a.b(a2[i2]);
            if (length < 0) {
                throw d.a();
            }
            iArr[length] = this.a.c(iArr[length], a3[i2]);
        }
        return a2.length;
    }
}
