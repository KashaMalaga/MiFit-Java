package com.c.b.d.b;

import com.c.b.c.a.c;
import com.c.b.c.b;
import com.c.b.c.g;
import com.c.b.c.i;
import com.c.b.n;
import com.c.b.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class a {
    private final b a;
    private final c b;

    public a(b bVar) {
        this.a = bVar;
        this.b = new c(bVar);
    }

    private static int a(u uVar, u uVar2) {
        return com.c.b.c.a.a.a(u.a(uVar, uVar2));
    }

    private static b a(b bVar, u uVar, u uVar2, u uVar3, u uVar4, int i, int i2) {
        return i.a().a(bVar, i, i2, 0.5f, 0.5f, ((float) i) - 0.5f, 0.5f, ((float) i) - 0.5f, ((float) i2) - 0.5f, 0.5f, ((float) i2) - 0.5f, uVar.a(), uVar.b(), uVar4.a(), uVar4.b(), uVar3.a(), uVar3.b(), uVar2.a(), uVar2.b());
    }

    private u a(u uVar, u uVar2, u uVar3, u uVar4, int i) {
        float a = ((float) a(uVar, uVar2)) / ((float) i);
        int a2 = a(uVar3, uVar4);
        u uVar5 = new u((((uVar4.a() - uVar3.a()) / ((float) a2)) * a) + uVar4.a(), (a * ((uVar4.b() - uVar3.b()) / ((float) a2))) + uVar4.b());
        float a3 = ((float) a(uVar, uVar3)) / ((float) i);
        int a4 = a(uVar2, uVar4);
        u uVar6 = new u((((uVar4.a() - uVar2.a()) / ((float) a4)) * a3) + uVar4.a(), (a3 * ((uVar4.b() - uVar2.b()) / ((float) a4))) + uVar4.b());
        return !a(uVar5) ? a(uVar6) ? uVar6 : null : (!a(uVar6) || Math.abs(b(uVar3, uVar5).c() - b(uVar2, uVar5).c()) <= Math.abs(b(uVar3, uVar6).c() - b(uVar2, uVar6).c())) ? uVar5 : uVar6;
    }

    private u a(u uVar, u uVar2, u uVar3, u uVar4, int i, int i2) {
        float a = ((float) a(uVar, uVar2)) / ((float) i);
        int a2 = a(uVar3, uVar4);
        u uVar5 = new u((((uVar4.a() - uVar3.a()) / ((float) a2)) * a) + uVar4.a(), (a * ((uVar4.b() - uVar3.b()) / ((float) a2))) + uVar4.b());
        float a3 = ((float) a(uVar, uVar3)) / ((float) i2);
        int a4 = a(uVar2, uVar4);
        u uVar6 = new u((((uVar4.a() - uVar2.a()) / ((float) a4)) * a3) + uVar4.a(), (a3 * ((uVar4.b() - uVar2.b()) / ((float) a4))) + uVar4.b());
        return !a(uVar5) ? a(uVar6) ? uVar6 : null : !a(uVar6) ? uVar5 : Math.abs(i - b(uVar3, uVar5).c()) + Math.abs(i2 - b(uVar2, uVar5).c()) <= Math.abs(i - b(uVar3, uVar6).c()) + Math.abs(i2 - b(uVar2, uVar6).c()) ? uVar5 : uVar6;
    }

    private static void a(Map<u, Integer> map, u uVar) {
        Integer num = (Integer) map.get(uVar);
        map.put(uVar, Integer.valueOf(num == null ? 1 : num.intValue() + 1));
    }

    private boolean a(u uVar) {
        return uVar.a() >= 0.0f && uVar.a() < ((float) this.a.f()) && uVar.b() > 0.0f && uVar.b() < ((float) this.a.g());
    }

    private c b(u uVar, u uVar2) {
        int a = (int) uVar.a();
        int b = (int) uVar.b();
        int a2 = (int) uVar2.a();
        int b2 = (int) uVar2.b();
        Object obj = Math.abs(b2 - b) > Math.abs(a2 - a) ? 1 : null;
        if (obj == null) {
            int i = b2;
            b2 = a2;
            a2 = i;
            int i2 = b;
            b = a;
            a = i2;
        }
        int abs = Math.abs(b2 - b);
        int abs2 = Math.abs(a2 - a);
        int i3 = (-abs) / 2;
        int i4 = a < a2 ? 1 : -1;
        int i5 = b < b2 ? 1 : -1;
        int i6 = 0;
        boolean a3 = this.a.a(obj != null ? a : b, obj != null ? b : a);
        int i7 = a;
        int i8 = i3;
        while (b != b2) {
            boolean a4 = this.a.a(obj != null ? i7 : b, obj != null ? b : i7);
            if (a4 != a3) {
                i6++;
                a3 = a4;
            }
            a = i8 + abs2;
            if (a > 0) {
                if (i7 == a2) {
                    a2 = i6;
                    break;
                }
                i7 += i4;
                a -= abs;
            }
            b += i5;
            i8 = a;
        }
        a2 = i6;
        return new c(uVar, uVar2, a2);
    }

    public g a() {
        u[] a = this.b.a();
        u uVar = a[0];
        u uVar2 = a[1];
        u uVar3 = a[2];
        u uVar4 = a[3];
        List arrayList = new ArrayList(4);
        arrayList.add(b(uVar, uVar2));
        arrayList.add(b(uVar, uVar3));
        arrayList.add(b(uVar2, uVar4));
        arrayList.add(b(uVar3, uVar4));
        Collections.sort(arrayList, new d());
        c cVar = (c) arrayList.get(0);
        c cVar2 = (c) arrayList.get(1);
        Map hashMap = new HashMap();
        a(hashMap, cVar.a());
        a(hashMap, cVar.b());
        a(hashMap, cVar2.a());
        a(hashMap, cVar2.b());
        u uVar5 = null;
        u uVar6 = null;
        u uVar7 = null;
        for (Entry entry : hashMap.entrySet()) {
            u uVar8;
            u uVar9 = (u) entry.getKey();
            if (((Integer) entry.getValue()).intValue() == 2) {
                uVar8 = uVar9;
                uVar9 = uVar7;
                uVar7 = uVar5;
            } else if (uVar5 == null) {
                uVar8 = uVar6;
                u uVar10 = uVar7;
                uVar7 = uVar9;
                uVar9 = uVar10;
            } else {
                uVar8 = uVar6;
                uVar7 = uVar5;
            }
            uVar6 = uVar8;
            uVar5 = uVar7;
            uVar7 = uVar9;
        }
        if (uVar5 == null || uVar6 == null || uVar7 == null) {
            throw n.a();
        }
        b a2;
        a = new u[]{uVar5, uVar6, uVar7};
        u.a(a);
        uVar7 = a[0];
        uVar9 = a[1];
        uVar6 = a[2];
        uVar5 = !hashMap.containsKey(uVar) ? uVar : !hashMap.containsKey(uVar2) ? uVar2 : !hashMap.containsKey(uVar3) ? uVar3 : uVar4;
        int c = b(uVar6, uVar5).c();
        int c2 = b(uVar7, uVar5).c();
        if ((c & 1) == 1) {
            c++;
        }
        c += 2;
        if ((c2 & 1) == 1) {
            c2++;
        }
        int i = c2 + 2;
        int c3;
        if (c * 4 >= i * 7 || i * 4 >= c * 7) {
            uVar4 = a(uVar9, uVar7, uVar6, uVar5, c, i);
            if (uVar4 == null) {
                uVar4 = uVar5;
            }
            c3 = b(uVar6, uVar4).c();
            int c4 = b(uVar7, uVar4).c();
            if ((c3 & 1) == 1) {
                c3++;
            }
            if ((c4 & 1) == 1) {
                c4++;
            }
            a2 = a(this.a, uVar6, uVar9, uVar7, uVar4, c3, c4);
        } else {
            uVar4 = a(uVar9, uVar7, uVar6, uVar5, Math.min(i, c));
            if (uVar4 == null) {
                uVar4 = uVar5;
            }
            c3 = Math.max(b(uVar6, uVar4).c(), b(uVar7, uVar4).c()) + 1;
            if ((c3 & 1) == 1) {
                c3++;
            }
            a2 = a(this.a, uVar6, uVar9, uVar7, uVar4, c3, c3);
        }
        return new g(a2, new u[]{uVar6, uVar9, uVar7, uVar4});
    }
}
