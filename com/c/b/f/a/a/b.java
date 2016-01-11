package com.c.b.f.a.a;

import com.c.b.i.b.d;
import com.c.b.i.b.e;
import com.c.b.i.b.i;
import com.c.b.n;
import com.c.b.u;
import com.c.b.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

final class b extends e {
    private static final i[] c = new i[0];
    private static final float d = 180.0f;
    private static final float e = 9.0f;
    private static final float f = 0.05f;
    private static final float g = 0.5f;

    b(com.c.b.c.b bVar) {
        super(bVar);
    }

    b(com.c.b.c.b bVar, v vVar) {
        super(bVar, vVar);
    }

    private d[][] c() {
        List b = b();
        int size = b.size();
        if (size < 3) {
            throw n.a();
        } else if (size == 3) {
            d[][] dVarArr = new d[1][];
            dVarArr[0] = new d[]{(d) b.get(0), (d) b.get(1), (d) b.get(2)};
            return dVarArr;
        } else {
            Collections.sort(b, new d());
            List arrayList = new ArrayList();
            for (int i = 0; i < size - 2; i++) {
                d dVar = (d) b.get(i);
                if (dVar != null) {
                    for (int i2 = i + 1; i2 < size - 1; i2++) {
                        d dVar2 = (d) b.get(i2);
                        if (dVar2 != null) {
                            float c = (dVar.c() - dVar2.c()) / Math.min(dVar.c(), dVar2.c());
                            if (Math.abs(dVar.c() - dVar2.c()) > g && c >= f) {
                                break;
                            }
                            for (int i3 = i2 + 1; i3 < size; i3++) {
                                d dVar3 = (d) b.get(i3);
                                if (dVar3 != null) {
                                    float c2 = (dVar2.c() - dVar3.c()) / Math.min(dVar2.c(), dVar3.c());
                                    if (Math.abs(dVar2.c() - dVar3.c()) > g && c2 >= f) {
                                        break;
                                    }
                                    Object obj = new d[]{dVar, dVar2, dVar3};
                                    u.a(obj);
                                    i iVar = new i(obj);
                                    float a = u.a(iVar.b(), iVar.a());
                                    float a2 = u.a(iVar.c(), iVar.a());
                                    c = u.a(iVar.b(), iVar.c());
                                    float c3 = (a + c) / (dVar.c() * 2.0f);
                                    if (c3 <= d && c3 >= e && Math.abs((a - c) / Math.min(a, c)) < 0.1f) {
                                        c = (float) Math.sqrt((double) ((c * c) + (a * a)));
                                        if (Math.abs((a2 - c) / Math.min(a2, c)) < 0.1f) {
                                            arrayList.add(obj);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                return (d[][]) arrayList.toArray(new d[arrayList.size()][]);
            }
            throw n.a();
        }
    }

    public i[] a(Map<com.c.b.e, ?> map) {
        Object obj = (map == null || !map.containsKey(com.c.b.e.TRY_HARDER)) ? null : 1;
        boolean z = map != null && map.containsKey(com.c.b.e.PURE_BARCODE);
        com.c.b.c.b a = a();
        int g = a.g();
        int f = a.f();
        int i = (int) ((((float) g) / 228.0f) * 3.0f);
        if (i < 3 || obj != null) {
            i = 3;
        }
        int[] iArr = new int[5];
        int i2 = i - 1;
        while (i2 < g) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            iArr[4] = 0;
            int i3 = 0;
            int i4 = 0;
            while (i4 < f) {
                if (a.a(i4, i2)) {
                    if ((i3 & 1) == 1) {
                        i3++;
                    }
                    iArr[i3] = iArr[i3] + 1;
                } else if ((i3 & 1) != 0) {
                    iArr[i3] = iArr[i3] + 1;
                } else if (i3 != 4) {
                    i3++;
                    iArr[i3] = iArr[i3] + 1;
                } else if (e.a(iArr) && a(iArr, i2, i4, z)) {
                    i3 = 0;
                    iArr[0] = 0;
                    iArr[1] = 0;
                    iArr[2] = 0;
                    iArr[3] = 0;
                    iArr[4] = 0;
                } else {
                    iArr[0] = iArr[2];
                    iArr[1] = iArr[3];
                    iArr[2] = iArr[4];
                    iArr[3] = 1;
                    iArr[4] = 0;
                    i3 = 3;
                }
                i4++;
            }
            if (e.a(iArr)) {
                a(iArr, i2, f, z);
            }
            i2 += i;
        }
        d[][] c = c();
        List arrayList = new ArrayList();
        for (u[] uVarArr : c) {
            u.a(uVarArr);
            arrayList.add(new i(uVarArr));
        }
        return arrayList.isEmpty() ? c : (i[]) arrayList.toArray(new i[arrayList.size()]);
    }
}
