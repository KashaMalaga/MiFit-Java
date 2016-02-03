package cn.com.smartdevices.bracelet.gps.sync;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0595q;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.c.a.g;
import cn.com.smartdevices.bracelet.gps.c.a.p;
import cn.com.smartdevices.bracelet.gps.h.h;
import cn.com.smartdevices.bracelet.gps.services.C0466z;
import cn.com.smartdevices.bracelet.j.e;
import cn.com.smartdevices.bracelet.j.i;
import cn.com.smartdevices.bracelet.lab.sync.l;
import cn.com.smartdevices.bracelet.model.HeartRateItem;
import com.d.a.a.C1012a;
import com.xiaomi.channel.relationservice.data.a;
import com.xiaomi.market.sdk.o;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class A {
    private static final String a = "SyncGPSSportData";

    private A() {
    }

    static JSONObject a(Context context, long j, long j2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(g.f, j);
            jSONObject.put(a.h, 1);
            jSONObject.put(kankan.wheel.widget.a.ak, cn.com.smartdevices.bracelet.e.a.d(context));
            jSONObject.put(o.L, 4);
            jSONObject.put(l.f, j2);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    static void a(Context context, int i, long j) {
        if (context == null || !C0595q.a(i)) {
            throw new IllegalArgumentException();
        }
        C0475h.a(context, new D(context), j);
    }

    static boolean a(Context context, int i, C0466z c0466z) {
        int b = 1 & b(context, i, c0466z);
        if (b == 0) {
            C0596r.d(a, "sync gps to server fail!");
            return false;
        }
        b &= a(context, c0466z);
        if (b == 0) {
            C0596r.d(a, "sync HR to server fail!");
            return false;
        }
        boolean a = F.a(context, c0466z) & b;
        C0596r.d(a, "sync sport summary to server " + a);
        return a;
    }

    static boolean a(Context context, int i, List<Long> list) {
        if (context == null || !C0595q.a(i)) {
            throw new IllegalArgumentException();
        }
        List<C0466z> a = p.a(context, i, (List) list);
        if (a == null || a.size() <= 0) {
            C0596r.e("Sync", "syncSportDataFromServer  !isNeedToSync");
        } else {
            for (C0466z c0466z : a) {
                a(context, c0466z.G(), c0466z.r(), i);
            }
        }
        return true;
    }

    public static boolean a(Context context, long j) {
        if (context == null) {
            throw new IllegalArgumentException();
        } else if (j <= 0) {
            return false;
        } else {
            C0466z d = p.d(context, j);
            if (d != null && d.L()) {
                return a(context, j, d.r(), d.v());
            }
            C0596r.e("Sync", "syncSportDataFromServer  !isNeedToSync trackId = " + j);
            if (d != null) {
                C0596r.e("Sync", "syncSportDataFromServer  !isNeedToSync syncState = " + d.B());
            }
            return true;
        }
    }

    static boolean a(Context context, long j, int i, int i2) {
        if (context == null || !C0595q.a(i2)) {
            throw new IllegalArgumentException();
        }
        i iVar = new i(context, i2);
        iVar.p = j;
        iVar.j = i;
        C0480n c0480n = new C0480n();
        C0475h.a(iVar, e.a(C0475h.f), new E(i2, c0480n, context, j));
        return c0480n.a;
    }

    static boolean a(Context context, C0466z c0466z) {
        int a;
        List a2 = p.a(1, context, c0466z.x(), c0466z.z());
        if (a2 == null || a2.isEmpty()) {
            return true;
        }
        int i = 1;
        int size = a2.size();
        long j = ((HeartRateItem) a2.get(0)).time;
        JSONArray jSONArray = new JSONArray();
        JSONObject a3 = a(context, j, c0466z.G());
        jSONArray.put(a3);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        long j2 = j;
        while (i2 < size) {
            try {
                JSONObject jSONObject;
                JSONArray jSONArray2;
                long j3;
                int i3;
                HeartRateItem heartRateItem = (HeartRateItem) a2.get(i2);
                j = heartRateItem.time;
                j2 = j - j2;
                if (j2 > 60 || arrayList.size() > C1012a.b) {
                    a3.put("rate", h.a(arrayList));
                    a = i & a(context, jSONArray.toString());
                    try {
                        JSONArray jSONArray3 = new JSONArray();
                        try {
                            a3 = a(context, j, c0466z.G());
                            jSONArray3.put(a3);
                            arrayList.clear();
                            arrayList.add(Byte.valueOf((byte) heartRateItem.hr));
                            jSONObject = a3;
                            jSONArray2 = jSONArray3;
                            j3 = j;
                            i3 = a;
                        } catch (JSONException e) {
                            jSONArray = jSONArray3;
                            i = a;
                        }
                    } catch (JSONException e2) {
                        i = a;
                    }
                } else {
                    for (a = 1; ((long) a) < j2; a++) {
                        arrayList.add(Byte.valueOf((byte) 0));
                    }
                    arrayList.add(Byte.valueOf((byte) heartRateItem.hr));
                    jSONObject = a3;
                    jSONArray2 = jSONArray;
                    long j4 = j;
                    i3 = i;
                    j3 = j4;
                }
                i2++;
                j2 = j3;
                jSONArray = jSONArray2;
                i = i3;
                a3 = jSONObject;
            } catch (JSONException e3) {
            }
        }
        a3.put("rate", h.a(arrayList));
        return a(context, jSONArray.toString()) & i;
    }

    static boolean a(Context context, String str) {
        C0480n c0480n = new C0480n();
        C0475h.a(context, str, new C(c0480n, context));
        return c0480n.a;
    }

    static boolean b(Context context, int i, long j) {
        if (context == null || !C0595q.a(i)) {
            throw new IllegalArgumentException();
        }
        List arrayList = new ArrayList(1);
        arrayList.add(Long.valueOf(j));
        List<C0466z> a = p.a(context, i, arrayList);
        if (a == null || a.size() <= 0) {
            C0596r.e("Sync", "syncSportDataFromServer  !isNeedToSync");
        } else {
            for (C0466z c0466z : a) {
                a(context, c0466z.G(), c0466z.r(), i);
            }
        }
        return true;
    }

    static boolean b(Context context, int i, C0466z c0466z) {
        long G = c0466z.G();
        List e = p.e(context, G);
        if (e == null) {
            return true;
        }
        int size = e.size();
        if (size <= 0) {
            p.g(context, G, i);
            return true;
        }
        i iVar = new i(context, i);
        C0471d a = C0472e.a(size, e);
        iVar.p = G;
        iVar.j = a.b;
        C0480n c0480n = new C0480n();
        C0475h.a(iVar, e.a(C0475h.e), a.a.toString(), null, new B(c0480n, context));
        return c0480n.a;
    }
}
