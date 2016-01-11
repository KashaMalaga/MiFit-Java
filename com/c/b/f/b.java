package com.c.b.f;

import com.c.b.c;
import com.c.b.e;
import com.c.b.n;
import com.c.b.q;
import com.c.b.r;
import com.c.b.s;
import com.c.b.u;
import com.edmodo.cropper.cropwindow.CropOverlayView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class b implements c {
    private static final int a = 100;
    private static final int b = 4;
    private final q c;

    public b(q qVar) {
        this.c = qVar;
    }

    private static s a(s sVar, int i, int i2) {
        u[] c = sVar.c();
        if (c == null) {
            return sVar;
        }
        u[] uVarArr = new u[c.length];
        for (int i3 = 0; i3 < c.length; i3++) {
            u uVar = c[i3];
            if (uVar != null) {
                uVarArr[i3] = new u(uVar.a() + ((float) i), uVar.b() + ((float) i2));
            }
        }
        s sVar2 = new s(sVar.a(), sVar.b(), uVarArr, sVar.d());
        sVar2.a(sVar.e());
        return sVar2;
    }

    private void a(c cVar, Map<e, ?> map, List<s> list, int i, int i2, int i3) {
        if (i3 <= b) {
            try {
                Object obj;
                s a = this.c.a(cVar, map);
                for (s a2 : list) {
                    if (a2.a().equals(a.a())) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    list.add(a(a, i, i2));
                }
                u[] c = a.c();
                if (c != null && c.length != 0) {
                    int a3 = cVar.a();
                    int b = cVar.b();
                    float f = (float) a3;
                    float f2 = (float) b;
                    float f3 = 0.0f;
                    float f4 = 0.0f;
                    int length = c.length;
                    int i4 = 0;
                    while (i4 < length) {
                        float f5;
                        float f6;
                        float f7;
                        u uVar = c[i4];
                        if (uVar == null) {
                            f5 = f4;
                            f6 = f2;
                            f7 = f;
                            f = f3;
                        } else {
                            float a4 = uVar.a();
                            f5 = uVar.b();
                            f7 = a4 < f ? a4 : f;
                            f6 = f5 < f2 ? f5 : f2;
                            f = a4 > f3 ? a4 : f3;
                            if (f5 <= f4) {
                                f5 = f4;
                            }
                        }
                        i4++;
                        f4 = f5;
                        f3 = f;
                        f2 = f6;
                        f = f7;
                    }
                    if (f > CropOverlayView.a) {
                        a(cVar.a(0, 0, (int) f, b), map, list, i, i2, i3 + 1);
                    }
                    if (f2 > CropOverlayView.a) {
                        a(cVar.a(0, 0, a3, (int) f2), map, list, i, i2, i3 + 1);
                    }
                    if (f3 < ((float) (a3 - 100))) {
                        a(cVar.a((int) f3, 0, a3 - ((int) f3), b), map, list, i + ((int) f3), i2, i3 + 1);
                    }
                    if (f4 < ((float) (b - 100))) {
                        a(cVar.a(0, (int) f4, a3, b - ((int) f4)), map, list, i, i2 + ((int) f4), i3 + 1);
                    }
                }
            } catch (r e) {
            }
        }
    }

    public s[] a_(c cVar) {
        return a_(cVar, null);
    }

    public s[] a_(c cVar, Map<e, ?> map) {
        List arrayList = new ArrayList();
        a(cVar, map, arrayList, 0, 0, 0);
        if (!arrayList.isEmpty()) {
            return (s[]) arrayList.toArray(new s[arrayList.size()]);
        }
        throw n.a();
    }
}
