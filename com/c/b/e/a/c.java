package com.c.b.e.a;

import com.c.b.c.b;
import com.c.b.c.b.a;
import com.c.b.c.b.e;
import com.c.b.d;
import com.c.b.h;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.util.Map;

public final class c {
    private static final int a = 0;
    private static final int b = 1;
    private static final int c = 2;
    private final com.c.b.c.b.c d = new com.c.b.c.b.c(a.h);

    private void a(byte[] bArr, int i, int i2, int i3, int i4) {
        int i5 = a;
        int i6 = i2 + i3;
        int i7 = i4 == 0 ? b : c;
        int[] iArr = new int[(i6 / i7)];
        int i8 = a;
        while (i8 < i6) {
            if (i4 == 0 || i8 % c == i4 - 1) {
                iArr[i8 / i7] = bArr[i8 + i] & HeartRateInfo.HR_EMPTY_VALUE;
            }
            i8 += b;
        }
        try {
            this.d.a(iArr, i3 / i7);
            while (i5 < i2) {
                if (i4 == 0 || i5 % c == i4 - 1) {
                    bArr[i5 + i] = (byte) iArr[i5 / i7];
                }
                i5 += b;
            }
        } catch (e e) {
            throw d.a();
        }
    }

    public com.c.b.c.e a(b bVar) {
        return a(bVar, null);
    }

    public com.c.b.c.e a(b bVar, Map<com.c.b.e, ?> map) {
        byte[] bArr;
        Object a = new a(bVar).a();
        a(a, a, 10, 10, a);
        int i = a[a] & 15;
        switch (i) {
            case c /*2*/:
            case kankan.wheel.widget.a.l /*3*/:
            case kankan.wheel.widget.a.aQ /*4*/:
                a(a, 20, 84, 40, b);
                a(a, 20, 84, 40, c);
                bArr = new byte[94];
                break;
            case kankan.wheel.widget.a.X /*5*/:
                a(a, 20, 68, 56, b);
                a(a, 20, 68, 56, c);
                bArr = new byte[78];
                break;
            default:
                throw h.a();
        }
        System.arraycopy(a, a, bArr, a, 10);
        System.arraycopy(a, 20, bArr, 10, bArr.length - 10);
        return b.a(bArr, i);
    }
}
