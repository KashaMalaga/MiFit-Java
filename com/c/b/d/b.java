package com.c.b.d;

import com.c.b.a;
import com.c.b.d.c.e;
import com.c.b.d.c.k;
import com.c.b.w;

public final class b implements w {
    private static com.c.b.c.b a(e eVar, k kVar) {
        int d = kVar.d();
        int e = kVar.e();
        com.c.b.i.c.b bVar = new com.c.b.i.c.b(kVar.f(), kVar.g());
        int i = 0;
        int i2 = 0;
        while (i < e) {
            int i3;
            int i4;
            int i5;
            if (i % kVar.c == 0) {
                i3 = 0;
                for (i4 = 0; i4 < kVar.f(); i4++) {
                    bVar.a(i3, i2, i4 % 2 == 0);
                    i3++;
                }
                i4 = i2 + 1;
            } else {
                i4 = i2;
            }
            i3 = 0;
            for (i2 = 0; i2 < d; i2++) {
                if (i2 % kVar.b == 0) {
                    bVar.a(i3, i4, true);
                    i3++;
                }
                bVar.a(i3, i4, eVar.a(i2, i));
                i5 = i3 + 1;
                if (i2 % kVar.b == kVar.b - 1) {
                    bVar.a(i5, i4, i % 2 == 0);
                    i3 = i5 + 1;
                } else {
                    i3 = i5;
                }
            }
            i5 = i4 + 1;
            if (i % kVar.c == kVar.c - 1) {
                i3 = 0;
                for (i4 = 0; i4 < kVar.f(); i4++) {
                    bVar.a(i3, i5, true);
                    i3++;
                }
                i4 = i5 + 1;
            } else {
                i4 = i5;
            }
            i++;
            i2 = i4;
        }
        return a(bVar);
    }

    private static com.c.b.c.b a(com.c.b.i.c.b bVar) {
        int b = bVar.b();
        int a = bVar.a();
        com.c.b.c.b bVar2 = new com.c.b.c.b(b, a);
        bVar2.a();
        for (int i = 0; i < b; i++) {
            for (int i2 = 0; i2 < a; i2++) {
                if (bVar.a(i, i2) == (byte) 1) {
                    bVar2.b(i, i2);
                }
            }
        }
        return bVar2;
    }

    public com.c.b.c.b a(String str, a aVar, int i, int i2) {
        return a(str, aVar, i, i2, null);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.c.b.c.b a(java.lang.String r7, com.c.b.a r8, int r9, int r10, java.util.Map<com.c.b.g, ?> r11) {
        /*
        r6 = this;
        r0 = r7.isEmpty();
        if (r0 == 0) goto L_0x000e;
    L_0x0006:
        r0 = new java.lang.IllegalArgumentException;
        r1 = "Found empty contents";
        r0.<init>(r1);
        throw r0;
    L_0x000e:
        r0 = com.c.b.a.DATA_MATRIX;
        if (r8 == r0) goto L_0x002b;
    L_0x0012:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Can only encode DATA_MATRIX, but got ";
        r1 = r1.append(r2);
        r1 = r1.append(r8);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x002b:
        if (r9 < 0) goto L_0x002f;
    L_0x002d:
        if (r10 >= 0) goto L_0x0052;
    L_0x002f:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Requested dimensions are too small: ";
        r1 = r1.append(r2);
        r1 = r1.append(r9);
        r2 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
        r1 = r1.append(r2);
        r1 = r1.append(r10);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0052:
        r1 = com.c.b.d.c.l.FORCE_NONE;
        r2 = new com.c.b.f;
        r2.<init>(r9, r10);
        r3 = 0;
        if (r11 == 0) goto L_0x00a2;
    L_0x005c:
        r0 = com.c.b.g.DATA_MATRIX_SHAPE;
        r0 = r11.get(r0);
        r0 = (com.c.b.d.c.l) r0;
        if (r0 == 0) goto L_0x0067;
    L_0x0066:
        r1 = r0;
    L_0x0067:
        r0 = com.c.b.g.MIN_SIZE;
        r0 = r11.get(r0);
        r0 = (com.c.b.f) r0;
        if (r0 == 0) goto L_0x0072;
    L_0x0071:
        r2 = r0;
    L_0x0072:
        r0 = com.c.b.g.MAX_SIZE;
        r0 = r11.get(r0);
        r0 = (com.c.b.f) r0;
        if (r0 == 0) goto L_0x00a2;
    L_0x007c:
        r3 = com.c.b.d.c.j.a(r7, r1, r2, r0);
        r4 = r3.length();
        r5 = 1;
        r0 = com.c.b.d.c.k.a(r4, r1, r2, r0, r5);
        r1 = com.c.b.d.c.i.a(r3, r0);
        r2 = new com.c.b.d.c.e;
        r3 = r0.d();
        r4 = r0.e();
        r2.<init>(r1, r3, r4);
        r2.d();
        r0 = a(r2, r0);
        return r0;
    L_0x00a2:
        r0 = r3;
        goto L_0x007c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.b.d.b.a(java.lang.String, com.c.b.a, int, int, java.util.Map):com.c.b.c.b");
    }
}
