package com.c.b.g.a;

import android.support.v4.media.h;
import com.c.b.c.a;
import com.c.b.g.q;
import com.c.b.n;
import com.c.b.s;
import com.c.b.u;
import com.c.b.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public final class e extends a {
    private static final int[] a = new int[]{1, 10, 34, 70, h.i};
    private static final int[] b = new int[]{4, 20, 48, 81};
    private static final int[] c = new int[]{0, 161, 961, 2015, 2715};
    private static final int[] d = new int[]{0, 336, 1036, 1516};
    private static final int[] e = new int[]{8, 6, 4, 3, 1};
    private static final int[] f = new int[]{2, 4, 6, 8};
    private static final int[][] g = new int[][]{new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};
    private final List<d> h = new ArrayList();
    private final List<d> i = new ArrayList();

    private b a(a aVar, c cVar, boolean z) {
        int i;
        int length;
        int i2;
        int[] c = c();
        c[0] = 0;
        c[1] = 0;
        c[2] = 0;
        c[3] = 0;
        c[4] = 0;
        c[5] = 0;
        c[6] = 0;
        c[7] = 0;
        if (z) {
            q.b(aVar, cVar.b()[0], c);
        } else {
            q.a(aVar, cVar.b()[1] + 1, c);
            i = 0;
            for (length = c.length - 1; i < length; length--) {
                i2 = c[i];
                c[i] = c[length];
                c[length] = i2;
                i++;
            }
        }
        length = z ? 16 : 15;
        float a = ((float) a.a(c)) / ((float) length);
        int[] f = f();
        int[] g = g();
        float[] d = d();
        float[] e = e();
        for (i = 0; i < c.length; i++) {
            float f2 = ((float) c[i]) / a;
            i2 = (int) (0.5f + f2);
            if (i2 < 1) {
                i2 = 1;
            } else if (i2 > 8) {
                i2 = 8;
            }
            int i3 = i / 2;
            if ((i & 1) == 0) {
                f[i3] = i2;
                d[i3] = f2 - ((float) i2);
            } else {
                g[i3] = i2;
                e[i3] = f2 - ((float) i2);
            }
        }
        a(z, length);
        length = f.length - 1;
        int i4 = 0;
        int i5 = 0;
        while (length >= 0) {
            i = (i4 * 9) + f[length];
            length--;
            i4 = i;
            i5 = f[length] + i5;
        }
        i2 = 0;
        i = 0;
        for (length = g.length - 1; length >= 0; length--) {
            i2 = (i2 * 9) + g[length];
            i += g[length];
        }
        i2 = i4 + (i2 * 3);
        if (z) {
            if ((i5 & 1) != 0 || i5 > 12 || i5 < 4) {
                throw n.a();
            }
            length = (12 - i5) / 2;
            i = e[length];
            i4 = 9 - i;
            return new b(((f.a(f, i, false) * a[length]) + f.a(g, i4, true)) + c[length], i2);
        } else if ((i & 1) != 0 || i > 10 || i < 4) {
            throw n.a();
        } else {
            length = (10 - i) / 2;
            i = f[length];
            return new b((f.a(f, i, true) + (f.a(g, 9 - i, false) * b[length])) + d[length], i2);
        }
    }

    private c a(a aVar, int i, boolean z, int[] iArr) {
        int a;
        boolean a2 = aVar.a(iArr[0]);
        int i2 = iArr[0] - 1;
        while (i2 >= 0 && (aVar.a(i2) ^ a2) != 0) {
            i2--;
        }
        int i3 = i2 + 1;
        i2 = iArr[0] - i3;
        Object b = b();
        System.arraycopy(b, 0, b, 1, b.length - 1);
        b[0] = i2;
        int a3 = a.a((int[]) b, g);
        int i4 = iArr[1];
        if (z) {
            a = (aVar.a() - 1) - i3;
            i4 = (aVar.a() - 1) - i4;
        } else {
            a = i3;
        }
        return new c(a3, new int[]{i3, iArr[1]}, a, i4, i);
    }

    private d a(a aVar, boolean z, int i, Map<com.c.b.e, ?> map) {
        try {
            int[] a = a(aVar, 0, z);
            c a2 = a(aVar, i, z, a);
            v vVar = map == null ? null : (v) map.get(com.c.b.e.NEED_RESULT_POINT_CALLBACK);
            if (vVar != null) {
                float f = ((float) (a[0] + a[1])) / 2.0f;
                if (z) {
                    f = ((float) (aVar.a() - 1)) - f;
                }
                vVar.a(new u(f, (float) i));
            }
            b a3 = a(aVar, a2, true);
            b a4 = a(aVar, a2, false);
            return new d((a3.a() * 1597) + a4.a(), a3.b() + (a4.b() * 4), a2);
        } catch (n e) {
            return null;
        }
    }

    private static s a(d dVar, d dVar2) {
        int length;
        String valueOf = String.valueOf((4537077 * ((long) dVar.a())) + ((long) dVar2.a()));
        StringBuilder stringBuilder = new StringBuilder(14);
        for (length = 13 - valueOf.length(); length > 0; length--) {
            stringBuilder.append('0');
        }
        stringBuilder.append(valueOf);
        int i = 0;
        for (int i2 = 0; i2 < 13; i2++) {
            length = stringBuilder.charAt(i2) - 48;
            if ((i2 & 1) == 0) {
                length *= 3;
            }
            i += length;
        }
        length = 10 - (i % 10);
        if (length == 10) {
            length = 0;
        }
        stringBuilder.append(length);
        u[] c = dVar.c().c();
        u[] c2 = dVar2.c().c();
        return new s(String.valueOf(stringBuilder.toString()), null, new u[]{c[0], c[1], c2[0], c2[1]}, com.c.b.a.RSS_14);
    }

    private static void a(Collection<d> collection, d dVar) {
        if (dVar != null) {
            Object obj;
            for (d dVar2 : collection) {
                if (dVar2.a() == dVar.a()) {
                    dVar2.e();
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                collection.add(dVar);
            }
        }
    }

    private void a(boolean z, int i) {
        Object obj;
        Object obj2;
        Object obj3;
        int i2;
        Object obj4 = null;
        Object obj5 = 1;
        int a = a.a(f());
        int a2 = a.a(g());
        int i3 = (a + a2) - i;
        Object obj6 = (a & 1) == (z ? 1 : 0) ? 1 : null;
        Object obj7 = (a2 & 1) == 1 ? 1 : null;
        int i4;
        if (z) {
            if (a > 12) {
                obj = 1;
                obj2 = null;
            } else if (a < 4) {
                obj = null;
                i4 = 1;
            } else {
                obj = null;
                obj2 = null;
            }
            if (a2 > 12) {
                obj3 = null;
                obj4 = 1;
            } else {
                if (a2 < 4) {
                    i2 = 1;
                }
                obj3 = null;
            }
        } else {
            if (a > 11) {
                obj = 1;
                obj2 = null;
            } else if (a < 5) {
                obj = null;
                i4 = 1;
            } else {
                obj = null;
                obj2 = null;
            }
            if (a2 > 10) {
                obj3 = null;
                int i5 = 1;
            } else {
                if (a2 < 4) {
                    i2 = 1;
                }
                obj3 = null;
            }
        }
        if (i3 == 1) {
            if (obj6 != null) {
                if (obj7 != null) {
                    throw n.a();
                }
                obj = obj2;
                obj5 = obj3;
                obj3 = 1;
            } else if (obj7 == null) {
                throw n.a();
            } else {
                i5 = 1;
                obj5 = obj3;
                obj3 = obj;
                obj = obj2;
            }
        } else if (i3 == -1) {
            if (obj6 != null) {
                if (obj7 != null) {
                    throw n.a();
                }
                r12 = obj3;
                obj3 = obj;
                r3 = 1;
                obj5 = r12;
            } else if (obj7 == null) {
                throw n.a();
            } else {
                obj3 = obj;
                obj = obj2;
            }
        } else if (i3 != 0) {
            throw n.a();
        } else if (obj6 != null) {
            if (obj7 == null) {
                throw n.a();
            } else if (a < a2) {
                i5 = 1;
                r12 = obj3;
                obj3 = obj;
                r3 = 1;
                obj5 = r12;
            } else {
                i2 = 1;
                obj = obj2;
            }
        } else if (obj7 != null) {
            throw n.a();
        } else {
            obj5 = obj3;
            obj3 = obj;
            obj = obj2;
        }
        if (obj != null) {
            if (obj3 != null) {
                throw n.a();
            }
            a.a(f(), d());
        }
        if (obj3 != null) {
            a.b(f(), d());
        }
        if (obj5 != null) {
            if (obj4 != null) {
                throw n.a();
            }
            a.a(g(), d());
        }
        if (obj4 != null) {
            a.b(g(), e());
        }
    }

    private int[] a(a aVar, int i, boolean z) {
        int[] b = b();
        b[0] = 0;
        b[1] = 0;
        b[2] = 0;
        b[3] = 0;
        int a = aVar.a();
        boolean z2 = false;
        int i2 = i;
        while (i2 < a) {
            z2 = !aVar.a(i2);
            if (z == z2) {
                break;
            }
            i2++;
        }
        int i3 = z2;
        int i4 = i2;
        i2 = 0;
        for (int i5 = i2; i5 < a; i5++) {
            if ((aVar.a(i5) ^ i3) != 0) {
                b[i2] = b[i2] + 1;
            } else {
                if (i2 != 3) {
                    i2++;
                } else if (a.b(b)) {
                    return new int[]{i4, i5};
                } else {
                    i4 += b[0] + b[1];
                    b[0] = b[2];
                    b[1] = b[3];
                    b[2] = 0;
                    b[3] = 0;
                    i2--;
                }
                b[i2] = 1;
                i3 = i3 == 0 ? 1 : 0;
            }
        }
        throw n.a();
    }

    private static boolean b(d dVar, d dVar2) {
        int b = (dVar.b() + (dVar2.b() * 16)) % 79;
        int a = (dVar.c().a() * 9) + dVar2.c().a();
        if (a > 72) {
            a--;
        }
        if (a > 8) {
            a--;
        }
        return b == a;
    }

    public s a(int i, a aVar, Map<com.c.b.e, ?> map) {
        a(this.h, a(aVar, false, i, (Map) map));
        aVar.e();
        a(this.i, a(aVar, true, i, (Map) map));
        aVar.e();
        int size = this.h.size();
        for (int i2 = 0; i2 < size; i2++) {
            d dVar = (d) this.h.get(i2);
            if (dVar.d() > 1) {
                int size2 = this.i.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    d dVar2 = (d) this.i.get(i3);
                    if (dVar2.d() > 1 && b(dVar, dVar2)) {
                        return a(dVar, dVar2);
                    }
                }
                continue;
            }
        }
        throw n.a();
    }

    public void a() {
        this.h.clear();
        this.i.clear();
    }
}
