package com.c.b.f.a;

import com.c.b.c.g;
import com.c.b.e;
import com.c.b.f.c;
import com.c.b.i.a.r;
import com.c.b.s;
import com.c.b.t;
import com.c.b.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class a extends com.c.b.i.a implements c {
    private static final s[] a = new s[0];
    private static final u[] b = new u[0];

    private static List<s> a(List<s> list) {
        s sVar;
        int i;
        for (s sVar2 : list) {
            if (sVar2.e().containsKey(t.STRUCTURED_APPEND_SEQUENCE)) {
                i = 1;
                break;
            }
        }
        i = 0;
        if (i == 0) {
            return list;
        }
        List<s> arrayList = new ArrayList();
        List<s> arrayList2 = new ArrayList();
        for (s sVar22 : list) {
            arrayList.add(sVar22);
            if (sVar22.e().containsKey(t.STRUCTURED_APPEND_SEQUENCE)) {
                arrayList2.add(sVar22);
            }
        }
        Collections.sort(arrayList2, new c());
        StringBuilder stringBuilder = new StringBuilder();
        int i2 = 0;
        int i3 = 0;
        for (s sVar222 : arrayList2) {
            stringBuilder.append(sVar222.a());
            i3 += sVar222.b().length;
            if (sVar222.e().containsKey(t.BYTE_SEGMENTS)) {
                for (byte[] length : (Iterable) sVar222.e().get(t.BYTE_SEGMENTS)) {
                    i2 += length.length;
                }
            }
            i2 = i2;
        }
        Object obj = new byte[i3];
        Object obj2 = new byte[i2];
        i3 = 0;
        int i4 = 0;
        for (s sVar2222 : arrayList2) {
            System.arraycopy(sVar2222.b(), 0, obj, i4, sVar2222.b().length);
            i4 += sVar2222.b().length;
            if (sVar2222.e().containsKey(t.BYTE_SEGMENTS)) {
                for (byte[] length2 : (Iterable) sVar2222.e().get(t.BYTE_SEGMENTS)) {
                    System.arraycopy(length2, 0, obj2, i3, length2.length);
                    i3 += length2.length;
                }
            }
            i3 = i3;
        }
        sVar2222 = new s(stringBuilder.toString(), obj, b, com.c.b.a.QR_CODE);
        if (i2 > 0) {
            Collection arrayList3 = new ArrayList();
            arrayList3.add(obj2);
            sVar2222.a(t.BYTE_SEGMENTS, arrayList3);
        }
        arrayList.add(sVar2222);
        return arrayList;
    }

    public s[] a_(com.c.b.c cVar) {
        return a_(cVar, null);
    }

    public s[] a_(com.c.b.c cVar, Map<e, ?> map) {
        List arrayList = new ArrayList();
        for (g gVar : new com.c.b.f.a.a.a(cVar.c()).a(map)) {
            try {
                com.c.b.c.e a = b().a(gVar.d(), (Map) map);
                u[] e = gVar.e();
                if (a.g() instanceof r) {
                    ((r) a.g()).a(e);
                }
                s sVar = new s(a.b(), a.a(), e, com.c.b.a.QR_CODE);
                List c = a.c();
                if (c != null) {
                    sVar.a(t.BYTE_SEGMENTS, c);
                }
                String d = a.d();
                if (d != null) {
                    sVar.a(t.ERROR_CORRECTION_LEVEL, d);
                }
                if (a.h()) {
                    sVar.a(t.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(a.j()));
                    sVar.a(t.STRUCTURED_APPEND_PARITY, Integer.valueOf(a.i()));
                }
                arrayList.add(sVar);
            } catch (com.c.b.r e2) {
            }
        }
        if (arrayList.isEmpty()) {
            return a;
        }
        List a2 = a(arrayList);
        return (s[]) a2.toArray(new s[a2.size()]);
    }
}
