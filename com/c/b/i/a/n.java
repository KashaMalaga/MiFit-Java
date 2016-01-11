package com.c.b.i.a;

import com.c.b.c.b;
import com.c.b.c.b.a;
import com.c.b.c.b.c;
import com.c.b.c.e;
import com.c.b.d;
import com.c.b.h;
import com.c.b.r;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.util.Map;

public final class n {
    private final c a = new c(a.e);

    private e a(a aVar, Map<com.c.b.e, ?> map) {
        s b = aVar.b();
        o a = aVar.a().a();
        b[] a2 = b.a(aVar.c(), b, a);
        int i = 0;
        for (b a3 : a2) {
            i += a3.a();
        }
        byte[] bArr = new byte[i];
        int length = a2.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            b bVar = a2[i2];
            byte[] b2 = bVar.b();
            int a4 = bVar.a();
            a(b2, a4);
            i = i3;
            i3 = 0;
            while (i3 < a4) {
                int i4 = i + 1;
                bArr[i] = b2[i3];
                i3++;
                i = i4;
            }
            i2++;
            i3 = i;
        }
        return m.a(bArr, b, a, (Map) map);
    }

    private void a(byte[] bArr, int i) {
        int i2 = 0;
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & HeartRateInfo.HR_EMPTY_VALUE;
        }
        try {
            this.a.a(iArr, bArr.length - i);
            while (i2 < i) {
                bArr[i2] = (byte) iArr[i2];
                i2++;
            }
        } catch (com.c.b.c.b.e e) {
            throw d.a();
        }
    }

    public e a(b bVar) {
        return a(bVar, null);
    }

    public e a(b bVar, Map<com.c.b.e, ?> map) {
        e a;
        d dVar;
        h e;
        r rVar = null;
        a aVar = new a(bVar);
        try {
            a = a(aVar, (Map) map);
        } catch (h e2) {
            h hVar = e2;
            dVar = rVar;
            try {
                aVar.d();
                aVar.a(true);
                aVar.b();
                aVar.a();
                aVar.e();
                a = a(aVar, (Map) map);
                a.a(new r(true));
                return a;
            } catch (h e3) {
                e = e3;
                if (hVar != null) {
                    throw hVar;
                } else if (dVar == null) {
                    throw dVar;
                } else {
                    throw e;
                }
            } catch (d e4) {
                e = e4;
                if (hVar != null) {
                    throw hVar;
                } else if (dVar == null) {
                    throw e;
                } else {
                    throw dVar;
                }
            }
        } catch (d e5) {
            dVar = e5;
            r rVar2 = rVar;
            aVar.d();
            aVar.a(true);
            aVar.b();
            aVar.a();
            aVar.e();
            a = a(aVar, (Map) map);
            a.a(new r(true));
            return a;
        }
        return a;
    }

    public e a(boolean[][] zArr) {
        return a(zArr, null);
    }

    public e a(boolean[][] zArr, Map<com.c.b.e, ?> map) {
        int length = zArr.length;
        b bVar = new b(length);
        for (int i = 0; i < length; i++) {
            for (int i2 = 0; i2 < length; i2++) {
                if (zArr[i][i2]) {
                    bVar.b(i2, i);
                }
            }
        }
        return a(bVar, (Map) map);
    }
}
