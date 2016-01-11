package com.c.b.c.a;

import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.c.b.n;
import com.c.b.u;

public final class b {
    private static final int a = 32;
    private final com.c.b.c.b b;

    public b(com.c.b.c.b bVar) {
        this.b = bVar;
    }

    private u a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10 = i;
        int i11 = i5;
        int[] iArr = null;
        while (i11 < i8 && i11 >= i7 && i10 < i4 && i10 >= i3) {
            int[] a = i2 == 0 ? a(i11, i9, i3, i4, true) : a(i10, i9, i7, i8, false);
            if (a != null) {
                i10 += i2;
                iArr = a;
                i11 += i6;
            } else if (iArr == null) {
                throw n.a();
            } else if (i2 == 0) {
                r3 = i11 - i6;
                if (iArr[0] >= i) {
                    return new u((float) iArr[1], (float) r3);
                }
                if (iArr[1] <= i) {
                    return new u((float) iArr[0], (float) r3);
                }
                return new u(i6 > 0 ? (float) iArr[0] : (float) iArr[1], (float) r3);
            } else {
                r3 = i10 - i2;
                if (iArr[0] >= i5) {
                    return new u((float) r3, (float) iArr[1]);
                }
                if (iArr[1] <= i5) {
                    return new u((float) r3, (float) iArr[0]);
                }
                return new u((float) r3, i2 < 0 ? (float) iArr[0] : (float) iArr[1]);
            }
        }
        throw n.a();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int[] a(int r5, int r6, int r7, int r8, boolean r9) {
        /*
        r4 = this;
        r0 = r7 + r8;
        r1 = r0 / 2;
        r0 = r1;
    L_0x0005:
        if (r0 < r7) goto L_0x0031;
    L_0x0007:
        if (r9 == 0) goto L_0x0014;
    L_0x0009:
        r2 = r4.b;
        r2 = r2.a(r0, r5);
        if (r2 == 0) goto L_0x001c;
    L_0x0011:
        r0 = r0 + -1;
        goto L_0x0005;
    L_0x0014:
        r2 = r4.b;
        r2 = r2.a(r5, r0);
        if (r2 != 0) goto L_0x0011;
    L_0x001c:
        r2 = r0;
    L_0x001d:
        r2 = r2 + -1;
        if (r2 < r7) goto L_0x002b;
    L_0x0021:
        if (r9 == 0) goto L_0x0043;
    L_0x0023:
        r3 = r4.b;
        r3 = r3.a(r2, r5);
        if (r3 == 0) goto L_0x001d;
    L_0x002b:
        r3 = r0 - r2;
        if (r2 < r7) goto L_0x0031;
    L_0x002f:
        if (r3 <= r6) goto L_0x004c;
    L_0x0031:
        r2 = r0 + 1;
        r0 = r1;
    L_0x0034:
        if (r0 >= r8) goto L_0x006b;
    L_0x0036:
        if (r9 == 0) goto L_0x004e;
    L_0x0038:
        r1 = r4.b;
        r1 = r1.a(r0, r5);
        if (r1 == 0) goto L_0x0056;
    L_0x0040:
        r0 = r0 + 1;
        goto L_0x0034;
    L_0x0043:
        r3 = r4.b;
        r3 = r3.a(r5, r2);
        if (r3 == 0) goto L_0x001d;
    L_0x004b:
        goto L_0x002b;
    L_0x004c:
        r0 = r2;
        goto L_0x0005;
    L_0x004e:
        r1 = r4.b;
        r1 = r1.a(r5, r0);
        if (r1 != 0) goto L_0x0040;
    L_0x0056:
        r1 = r0;
    L_0x0057:
        r1 = r1 + 1;
        if (r1 >= r8) goto L_0x0065;
    L_0x005b:
        if (r9 == 0) goto L_0x0079;
    L_0x005d:
        r3 = r4.b;
        r3 = r3.a(r1, r5);
        if (r3 == 0) goto L_0x0057;
    L_0x0065:
        r3 = r1 - r0;
        if (r1 >= r8) goto L_0x006b;
    L_0x0069:
        if (r3 <= r6) goto L_0x0082;
    L_0x006b:
        r1 = r0 + -1;
        if (r1 <= r2) goto L_0x0084;
    L_0x006f:
        r0 = 2;
        r0 = new int[r0];
        r3 = 0;
        r0[r3] = r2;
        r2 = 1;
        r0[r2] = r1;
    L_0x0078:
        return r0;
    L_0x0079:
        r3 = r4.b;
        r3 = r3.a(r5, r1);
        if (r3 == 0) goto L_0x0057;
    L_0x0081:
        goto L_0x0065;
    L_0x0082:
        r0 = r1;
        goto L_0x0034;
    L_0x0084:
        r0 = 0;
        goto L_0x0078;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.b.c.a.b.a(int, int, int, int, boolean):int[]");
    }

    public u[] a() {
        int g = this.b.g();
        int f = this.b.f();
        int i = g / 2;
        int i2 = f / 2;
        int max = Math.max(1, g / PersonInfo.INCOMING_CALL_DISABLE_BIT);
        int max2 = Math.max(1, f / PersonInfo.INCOMING_CALL_DISABLE_BIT);
        int b = ((int) a(i2, 0, 0, f, i, -max, 0, g, i2 / 2).b()) - 1;
        int a = ((int) a(i2, -max2, 0, f, i, 0, b, g, i / 2).a()) - 1;
        f = ((int) a(i2, max2, a, f, i, 0, b, g, i / 2).a()) + 1;
        u a2 = a(i2, 0, a, f, i, max, b, g, i2 / 2);
        u a3 = a(i2, 0, a, f, i, -max, b, ((int) a2.b()) + 1, i2 / 4);
        return new u[]{a3, r12, r11, a2};
    }
}
