package com.c.b.h;

import com.c.b.a;
import com.c.b.c.b;
import com.c.b.g;
import com.c.b.h.c.c;
import com.c.b.h.c.e;
import com.c.b.w;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Map;

public final class d implements w {
    static final int a = 30;

    private static b a(e eVar, String str, int i, int i2, int i3) {
        int i4;
        eVar.a(str, 2);
        byte[][] a = eVar.a().a(2, 8);
        if (((i2 > i ? 1 : 0) ^ (a[0].length < a.length ? 1 : 0)) != 0) {
            a = a(a);
            i4 = 1;
        } else {
            i4 = 0;
        }
        int length = i / a[0].length;
        int length2 = i2 / a.length;
        if (length >= length2) {
            length = length2;
        }
        if (length <= 1) {
            return a(a, i3);
        }
        byte[][] a2 = eVar.a().a(length * 2, (length * 4) * 2);
        return a(i4 != 0 ? a(a2) : a2, i3);
    }

    private static b a(byte[][] bArr, int i) {
        b bVar = new b(bArr[0].length + (i * 2), bArr.length + (i * 2));
        bVar.a();
        int g = (bVar.g() - i) - 1;
        int i2 = 0;
        while (i2 < bArr.length) {
            for (int i3 = 0; i3 < bArr[0].length; i3++) {
                if (bArr[i2][i3] == (byte) 1) {
                    bVar.b(i3 + i, g);
                }
            }
            i2++;
            g--;
        }
        return bVar;
    }

    private static byte[][] a(byte[][] bArr) {
        byte[][] bArr2 = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{bArr[0].length, bArr.length});
        for (int i = 0; i < bArr.length; i++) {
            int length = (bArr.length - i) - 1;
            for (int i2 = 0; i2 < bArr[0].length; i2++) {
                bArr2[i2][length] = bArr[i][i2];
            }
        }
        return bArr2;
    }

    public b a(String str, a aVar, int i, int i2) {
        return a(str, aVar, i, i2, null);
    }

    public b a(String str, a aVar, int i, int i2, Map<g, ?> map) {
        if (aVar != a.PDF_417) {
            throw new IllegalArgumentException("Can only encode PDF_417, but got " + aVar);
        }
        e eVar = new e();
        int i3 = a;
        if (map != null) {
            if (map.containsKey(g.PDF417_COMPACT)) {
                eVar.a(((Boolean) map.get(g.PDF417_COMPACT)).booleanValue());
            }
            if (map.containsKey(g.PDF417_COMPACTION)) {
                eVar.a((c) map.get(g.PDF417_COMPACTION));
            }
            if (map.containsKey(g.PDF417_DIMENSIONS)) {
                com.c.b.h.c.d dVar = (com.c.b.h.c.d) map.get(g.PDF417_DIMENSIONS);
                eVar.a(dVar.b(), dVar.a(), dVar.d(), dVar.c());
            }
            if (map.containsKey(g.MARGIN)) {
                i3 = ((Number) map.get(g.MARGIN)).intValue();
            }
            if (map.containsKey(g.CHARACTER_SET)) {
                eVar.a(Charset.forName((String) map.get(g.CHARACTER_SET)));
            }
        }
        return a(eVar, str, i, i2, i3);
    }
}
