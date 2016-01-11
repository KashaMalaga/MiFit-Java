package com.c.b.h.a;

import com.c.b.h;
import com.c.b.u;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

final class j extends i {
    private final boolean a;

    j(c cVar, boolean z) {
        super(cVar);
        this.a = z;
    }

    private void a(d[] dVarArr, a aVar) {
        for (int i = 0; i < dVarArr.length; i++) {
            d dVar = dVarArr[i];
            if (dVarArr[i] != null) {
                int g = dVar.g() % 30;
                int h = dVar.h();
                if (h <= aVar.c()) {
                    if (!this.a) {
                        h += 2;
                    }
                    switch (h % 3) {
                        case a.i /*0*/:
                            if ((g * 3) + 1 == aVar.d()) {
                                break;
                            }
                            dVarArr[i] = null;
                            break;
                        case l.a /*1*/:
                            if (g / 3 != aVar.b() || g % 3 != aVar.e()) {
                                dVarArr[i] = null;
                                break;
                            }
                            break;
                            break;
                        case a.k /*2*/:
                            if (g + 1 == aVar.a()) {
                                break;
                            }
                            dVarArr[i] = null;
                            break;
                        default:
                            break;
                    }
                }
                dVarArr[i] = null;
            }
        }
    }

    int a(a aVar) {
        d[] b = b();
        c();
        a(b, aVar);
        c a = a();
        u e = this.a ? a.e() : a.f();
        u g = this.a ? a.g() : a.h();
        int b2 = b((int) e.b());
        int b3 = b((int) g.b());
        float c = ((float) (b3 - b2)) / ((float) aVar.c());
        int i = -1;
        int i2 = b2;
        int i3 = 0;
        int i4 = 1;
        while (i2 < b3) {
            if (b[i2] == null) {
                b2 = i3;
                i3 = i4;
                i4 = i;
            } else {
                d dVar = b[i2];
                b2 = dVar.h() - i;
                if (b2 == 0) {
                    b2 = i3 + 1;
                    i3 = i4;
                    i4 = i;
                } else if (b2 == 1) {
                    b2 = Math.max(i4, i3);
                    i4 = dVar.h();
                    i3 = b2;
                    b2 = 1;
                } else if (b2 < 0 || dVar.h() >= aVar.c() || b2 > i2) {
                    b[i2] = null;
                    b2 = i3;
                    i3 = i4;
                    i4 = i;
                } else {
                    int i5 = i4 > 2 ? b2 * (i4 - 2) : b2;
                    Object obj = i5 >= i2 ? 1 : null;
                    for (int i6 = 1; i6 <= i5 && obj == null; i6++) {
                        obj = b[i2 - i6] != null ? 1 : null;
                    }
                    if (obj != null) {
                        b[i2] = null;
                        b2 = i3;
                        i3 = i4;
                        i4 = i;
                    } else {
                        i3 = i4;
                        i4 = dVar.h();
                        b2 = 1;
                    }
                }
            }
            i2++;
            i = i4;
            i4 = i3;
            i3 = b2;
        }
        return (int) (((double) c) + 0.5d);
    }

    int b(a aVar) {
        c a = a();
        u e = this.a ? a.e() : a.f();
        u g = this.a ? a.g() : a.h();
        int b = b((int) e.b());
        int b2 = b((int) g.b());
        float c = ((float) (b2 - b)) / ((float) aVar.c());
        d[] b3 = b();
        int i = -1;
        b = 0;
        int i2 = 1;
        for (int i3 = b; i3 < b2; i3++) {
            if (b3[i3] != null) {
                d dVar = b3[i3];
                dVar.b();
                int h = dVar.h() - i;
                if (h == 0) {
                    b++;
                } else if (h == 1) {
                    b = Math.max(i2, b);
                    i = dVar.h();
                    i2 = b;
                    b = 1;
                } else if (dVar.h() >= aVar.c()) {
                    b3[i3] = null;
                } else {
                    i = dVar.h();
                    b = 1;
                }
            }
        }
        return (int) (((double) c) + 0.5d);
    }

    void c() {
        for (d dVar : b()) {
            if (dVar != null) {
                dVar.b();
            }
        }
    }

    int[] d() {
        a e = e();
        if (e == null) {
            return null;
        }
        b(e);
        int[] iArr = new int[e.c()];
        for (d dVar : b()) {
            if (dVar != null) {
                int h = dVar.h();
                if (h >= iArr.length) {
                    throw h.a();
                }
                iArr[h] = iArr[h] + 1;
            }
        }
        return iArr;
    }

    a e() {
        d[] b = b();
        b bVar = new b();
        b bVar2 = new b();
        b bVar3 = new b();
        b bVar4 = new b();
        for (d dVar : b) {
            if (dVar != null) {
                dVar.b();
                int g = dVar.g() % 30;
                int h = dVar.h();
                if (!this.a) {
                    h += 2;
                }
                switch (h % 3) {
                    case a.i /*0*/:
                        bVar2.a((g * 3) + 1);
                        break;
                    case l.a /*1*/:
                        bVar4.a(g / 3);
                        bVar3.a(g % 3);
                        break;
                    case a.k /*2*/:
                        bVar.a(g + 1);
                        break;
                    default:
                        break;
                }
            }
        }
        if (bVar.a().length == 0 || bVar2.a().length == 0 || bVar3.a().length == 0 || bVar4.a().length == 0 || bVar.a()[0] < 1 || bVar2.a()[0] + bVar3.a()[0] < 3 || bVar2.a()[0] + bVar3.a()[0] > 90) {
            return null;
        }
        a aVar = new a(bVar.a()[0], bVar2.a()[0], bVar3.a()[0], bVar4.a()[0]);
        a(b, aVar);
        return aVar;
    }

    boolean f() {
        return this.a;
    }

    public String toString() {
        return "IsLeft: " + this.a + '\n' + super.toString();
    }
}
