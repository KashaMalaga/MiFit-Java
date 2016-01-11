package com.c.b.g;

import com.c.b.c;
import com.c.b.c.a;
import com.c.b.e;
import com.c.b.n;
import com.c.b.r;
import com.c.b.s;
import com.c.b.t;
import com.c.b.u;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public abstract class q implements com.c.b.q {
    protected static float a(int[] iArr, int[] iArr2, float f) {
        int i;
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        for (i = 0; i < length; i++) {
            i3 += iArr[i];
            i2 += iArr2[i];
        }
        if (i3 < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = ((float) i3) / ((float) i2);
        float f3 = f * f2;
        float f4 = 0.0f;
        for (i = 0; i < length; i++) {
            int i4 = iArr[i];
            float f5 = ((float) iArr2[i]) * f2;
            float f6 = ((float) i4) > f5 ? ((float) i4) - f5 : f5 - ((float) i4);
            if (f6 > f3) {
                return Float.POSITIVE_INFINITY;
            }
            f4 += f6;
        }
        return f4 / ((float) i3);
    }

    protected static void a(a aVar, int i, int[] iArr) {
        int length = iArr.length;
        Arrays.fill(iArr, 0, length, 0);
        int a = aVar.a();
        if (i >= a) {
            throw n.a();
        }
        int i2;
        int i3 = !aVar.a(i) ? 1 : 0;
        int i4 = 0;
        while (i < a) {
            if ((aVar.a(i) ^ i3) != 0) {
                iArr[i4] = iArr[i4] + 1;
                i2 = i3;
            } else {
                i2 = i4 + 1;
                if (i2 == length) {
                    break;
                }
                iArr[i2] = 1;
                int i5 = i2;
                i2 = i3 == 0 ? 1 : 0;
                i4 = i5;
            }
            i++;
            i3 = i2;
        }
        i2 = i4;
        if (i2 == length) {
            return;
        }
        if (i2 != length - 1 || i != a) {
            throw n.a();
        }
    }

    private s b(c cVar, Map<e, ?> map) {
        Object obj;
        int max;
        int i;
        a aVar;
        Map map2;
        int i2;
        int i3;
        int i4;
        Map enumMap;
        s a;
        u[] c;
        int a2 = cVar.a();
        int b = cVar.b();
        a aVar2 = new a(a2);
        int i5 = b >> 1;
        if (map != null) {
            if (map.containsKey(e.TRY_HARDER)) {
                obj = 1;
                max = Math.max(1, b >> (obj == null ? 8 : 5));
                i = obj == null ? b : 15;
                aVar = aVar2;
                map2 = map;
                for (i2 = 0; i2 < i; i2++) {
                    i3 = (i2 + 1) / 2;
                    if (((i2 & 1) != 0 ? 1 : null) == null) {
                        i3 = -i3;
                    }
                    i4 = i5 + (i3 * max);
                    if (i4 < 0 || i4 >= b) {
                        break;
                    }
                    try {
                        aVar = cVar.a(i4, aVar);
                        i3 = 0;
                        while (i3 < 2) {
                            if (i3 == 1) {
                                aVar.e();
                                if (map2 != null && map2.containsKey(e.NEED_RESULT_POINT_CALLBACK)) {
                                    enumMap = new EnumMap(e.class);
                                    enumMap.putAll(map2);
                                    enumMap.remove(e.NEED_RESULT_POINT_CALLBACK);
                                    a = a(i4, aVar, enumMap);
                                    if (i3 == 1) {
                                        a.a(t.ORIENTATION, Integer.valueOf(cn.com.smartdevices.bracelet.gps.c.a.i));
                                        c = a.c();
                                        if (c != null) {
                                            c[0] = new u((((float) a2) - c[0].a()) - 1.0f, c[0].b());
                                            c[1] = new u((((float) a2) - c[1].a()) - 1.0f, c[1].b());
                                        }
                                    }
                                    return a;
                                }
                            }
                            enumMap = map2;
                            try {
                                a = a(i4, aVar, enumMap);
                                if (i3 == 1) {
                                    a.a(t.ORIENTATION, Integer.valueOf(cn.com.smartdevices.bracelet.gps.c.a.i));
                                    c = a.c();
                                    if (c != null) {
                                        c[0] = new u((((float) a2) - c[0].a()) - 1.0f, c[0].b());
                                        c[1] = new u((((float) a2) - c[1].a()) - 1.0f, c[1].b());
                                    }
                                }
                                return a;
                            } catch (r e) {
                                i3++;
                                map2 = enumMap;
                            }
                        }
                        continue;
                    } catch (n e2) {
                    }
                }
                throw n.a();
            }
        }
        obj = null;
        if (obj == null) {
        }
        max = Math.max(1, b >> (obj == null ? 8 : 5));
        if (obj == null) {
        }
        aVar = aVar2;
        map2 = map;
        for (i2 = 0; i2 < i; i2++) {
            i3 = (i2 + 1) / 2;
            if ((i2 & 1) != 0) {
            }
            if (((i2 & 1) != 0 ? 1 : null) == null) {
                i3 = -i3;
            }
            i4 = i5 + (i3 * max);
            aVar = cVar.a(i4, aVar);
            i3 = 0;
            while (i3 < 2) {
                if (i3 == 1) {
                    aVar.e();
                    enumMap = new EnumMap(e.class);
                    enumMap.putAll(map2);
                    enumMap.remove(e.NEED_RESULT_POINT_CALLBACK);
                    a = a(i4, aVar, enumMap);
                    if (i3 == 1) {
                        a.a(t.ORIENTATION, Integer.valueOf(cn.com.smartdevices.bracelet.gps.c.a.i));
                        c = a.c();
                        if (c != null) {
                            c[0] = new u((((float) a2) - c[0].a()) - 1.0f, c[0].b());
                            c[1] = new u((((float) a2) - c[1].a()) - 1.0f, c[1].b());
                        }
                    }
                    return a;
                }
                enumMap = map2;
                a = a(i4, aVar, enumMap);
                if (i3 == 1) {
                    a.a(t.ORIENTATION, Integer.valueOf(cn.com.smartdevices.bracelet.gps.c.a.i));
                    c = a.c();
                    if (c != null) {
                        c[0] = new u((((float) a2) - c[0].a()) - 1.0f, c[0].b());
                        c[1] = new u((((float) a2) - c[1].a()) - 1.0f, c[1].b());
                    }
                }
                return a;
            }
            continue;
        }
        throw n.a();
    }

    protected static void b(a aVar, int i, int[] iArr) {
        int length = iArr.length;
        boolean a = aVar.a(i);
        while (i > 0 && length >= 0) {
            i--;
            if (aVar.a(i) != a) {
                length--;
                a = !a;
            }
        }
        if (length >= 0) {
            throw n.a();
        }
        a(aVar, i + 1, iArr);
    }

    public abstract s a(int i, a aVar, Map<e, ?> map);

    public s a(c cVar) {
        return a(cVar, null);
    }

    public s a(c cVar, Map<e, ?> map) {
        try {
            return b(cVar, map);
        } catch (n e) {
            Object obj = (map == null || !map.containsKey(e.TRY_HARDER)) ? null : 1;
            if (obj == null || !cVar.e()) {
                throw e;
            }
            c f = cVar.f();
            s b = b(f, map);
            Map e2 = b.e();
            int intValue = (e2 == null || !e2.containsKey(t.ORIENTATION)) ? 270 : (((Integer) e2.get(t.ORIENTATION)).intValue() + 270) % cn.com.smartdevices.bracelet.gps.c.a.e;
            b.a(t.ORIENTATION, Integer.valueOf(intValue));
            u[] c = b.c();
            if (c != null) {
                int b2 = f.b();
                for (intValue = 0; intValue < c.length; intValue++) {
                    c[intValue] = new u((((float) b2) - c[intValue].b()) - 1.0f, c[intValue].a());
                }
            }
            return b;
        }
    }

    public void a() {
    }
}
