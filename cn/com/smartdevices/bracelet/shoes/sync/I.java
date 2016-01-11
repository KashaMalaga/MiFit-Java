package cn.com.smartdevices.bracelet.shoes.sync;

import android.content.Context;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.d;
import cn.com.smartdevices.bracelet.shoes.data.db.t;
import cn.com.smartdevices.bracelet.shoes.model.a;
import cn.com.smartdevices.bracelet.shoes.model.c;
import cn.com.smartdevices.bracelet.shoes.sync.b.j;
import cn.com.smartdevices.bracelet.shoes.sync.c.b;
import com.xiaomi.hm.health.dataprocess.SportDay;
import com.xiaomi.mipush.sdk.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

class I {
    private static final int a = 3;
    private static final int b = 7;
    private static final int c = 30;

    private I() {
    }

    static T a(Context context, c cVar, HashSet<String> hashSet) {
        hashSet.remove(new SportDay().getKey());
        int size = hashSet.size();
        if (size == 0) {
            return T.NONE;
        }
        List arrayList = new ArrayList(size);
        arrayList.addAll(hashSet);
        boolean a = a(context, cVar, arrayList, true);
        arrayList.clear();
        hashSet.clear();
        if (!a) {
            C0596r.d(B.a, "Failed to batch sync datedata from server,mac:" + cVar);
        } else if (!C.b(context, cVar)) {
            C0596r.d(B.a, "Failed to sync myshoes from server");
        }
        return a ? T.OK : T.ERROR;
    }

    private static void a(List<String> list, int i, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : list) {
            stringBuilder.append(append).append(f.i);
        }
        C0596r.d(B.a, str + ",size:" + i + ",dates:" + stringBuilder.toString());
    }

    static boolean a(Context context) {
        List<a> f = t.f(context);
        if (f == null || f.size() == 0) {
            C0596r.e(B.a, "sync all shoesdata to server no data");
            return true;
        }
        boolean z = true;
        for (a aVar : f) {
            if (TextUtils.isEmpty(aVar.f()) && TextUtils.isEmpty(cn.com.smartdevices.bracelet.shoes.c.b(context, aVar.j()))) {
                C0596r.d(B.a, "sync shoesdata skip;shoes:" + aVar.t() + ",mac:" + aVar.j());
            } else {
                z = a(context, aVar.g(), aVar.b(), null) & z;
            }
        }
        if (z) {
            return z;
        }
        C0596r.d(B.a, "Failed to sync all shoesdata to server");
        return z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean a(android.content.Context r12, cn.com.smartdevices.bracelet.shoes.model.c r13) {
        /*
        r8 = 1;
        r6 = 0;
        r10 = java.util.Calendar.getInstance();
        r11 = 10;
        r0 = 0;
        r2 = r0;
        r0 = r6;
    L_0x000c:
        r9 = r2 + 1;
        if (r9 < r11) goto L_0x003d;
    L_0x0010:
        r2 = r8;
    L_0x0011:
        if (r2 != 0) goto L_0x0035;
    L_0x0013:
        r3 = "SSync";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "sync all datedata from server finally:";
        r4 = r4.append(r5);
        r4 = r4.append(r2);
        r5 = ",nextSyncTime:";
        r4 = r4.append(r5);
        r0 = r4.append(r0);
        r0 = r0.toString();
        cn.com.smartdevices.bracelet.C0596r.d(r3, r0);
    L_0x0035:
        if (r13 != 0) goto L_0x00bb;
    L_0x0037:
        r0 = "";
    L_0x0039:
        cn.com.smartdevices.bracelet.shoes.data.a.a(r12, r0, r2);
        return r2;
    L_0x003d:
        r0 = cn.com.smartdevices.bracelet.shoes.data.db.t.f(r12, r13);
        r2 = "SSync";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "sync all datedata from server nextSyncTime:";
        r3 = r3.append(r4);
        r3 = r3.append(r0);
        r3 = r3.toString();
        cn.com.smartdevices.bracelet.C0596r.e(r2, r3);
        r2 = -1;
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 != 0) goto L_0x0068;
    L_0x005f:
        r2 = "SSync";
        r3 = "No data to sync from server";
        cn.com.smartdevices.bracelet.C0596r.d(r2, r3);
        r2 = r8;
        goto L_0x0011;
    L_0x0068:
        r2 = 0;
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 != 0) goto L_0x00b9;
    L_0x006e:
        r0 = new com.xiaomi.hm.health.dataprocess.SportDay;
        r0.<init>();
        r1 = -1;
        r0 = r0.addDay(r1);
        r0 = r0.getTimestamp();
        r2 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r0 = r0 / r2;
        r6 = r0;
    L_0x0080:
        r0 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r0 = r0 * r6;
        r10.setTimeInMillis(r0);
        r0 = new com.xiaomi.hm.health.dataprocess.SportDay;
        r0.<init>(r10);
        r2 = r0.getKey();
        r1 = -3;
        r0 = r0.addMonth(r1);
        r1 = r0.getKey();
        r3 = 0;
        r4 = cn.com.smartdevices.bracelet.shoes.d.a;
        r0 = r12;
        r5 = r13;
        r0 = cn.com.smartdevices.bracelet.shoes.sync.K.a(r0, r1, r2, r3, r4, r5);
        r1 = r0.b();
        if (r1 == 0) goto L_0x00ae;
    L_0x00a7:
        r2 = r0.a();
        cn.com.smartdevices.bracelet.shoes.data.db.t.a(r12, r2, r13);
    L_0x00ae:
        r0 = r0.b();
        r0 = r0 & r8;
        if (r0 != 0) goto L_0x00c1;
    L_0x00b5:
        r2 = r0;
        r0 = r6;
        goto L_0x0011;
    L_0x00b9:
        r6 = r0;
        goto L_0x0080;
    L_0x00bb:
        r0 = r13.b();
        goto L_0x0039;
    L_0x00c1:
        r2 = r9;
        r8 = r0;
        r0 = r6;
        goto L_0x000c;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.smartdevices.bracelet.shoes.sync.I.a(android.content.Context, cn.com.smartdevices.bracelet.shoes.model.c):boolean");
    }

    static boolean a(Context context, c cVar, int i, HashSet<String> hashSet) {
        boolean z;
        int i2 = true;
        C0596r.e(B.a, "syncIntegralShoesData indentity:" + cVar + ",boundState:" + i);
        if (cVar == null || cVar.e()) {
            C0596r.d(B.a, "syncIntegralShoesData deviceAddress is empty");
        } else {
            boolean z2;
            if (!cn.com.smartdevices.bracelet.shoes.c.d(context, cVar.b())) {
                cn.com.smartdevices.bracelet.shoes.c.a(context, cVar.b(), v.a(context, cVar));
            }
            T b = b(context, cVar);
            if (T.NONE.equals(b)) {
                z2 = (!T.ERROR.equals(d(context, cVar)) ? 1 : 0) & 1;
            } else {
                z2 = (!T.ERROR.equals(b) ? 1 : 0) & 1;
            }
            if (hashSet != null) {
                if (T.ERROR.equals(a(context, cVar, (HashSet) hashSet))) {
                    i2 = 0;
                }
                z = i2 & z2;
            } else {
                z = z2;
            }
            if (z) {
                if (T.OK.equals(c(context, cVar))) {
                    z &= C.b(context, cVar);
                    if (!z) {
                        C0596r.d(B.a, "Failed to sync myshoes from server");
                    }
                }
            }
            if (i == 0) {
                cn.com.smartdevices.bracelet.shoes.data.a.b(context, cVar.b(), false);
                cn.com.smartdevices.bracelet.shoes.c.a(context, cVar.b(), false);
            }
        }
        return z;
    }

    private static boolean a(Context context, c cVar, List<String> list, boolean z) {
        int size = list.size();
        int i = z ? b : c;
        boolean z2 = true;
        int i2 = 0;
        while (i2 < size) {
            z2 &= K.a(context, list.subList(i2, i2 + i >= size ? size : i2 + i), z, d.a, cVar);
            i2 += i;
        }
        return z2;
    }

    private static T b(Context context, c cVar) {
        if (cn.com.smartdevices.bracelet.shoes.data.a.b(context, cVar.b())) {
            return T.NONE;
        }
        SportDay sportDay = new SportDay();
        boolean b = K.a(context, sportDay.getKey(), sportDay.getKey(), true, d.a, cVar).b();
        if (b) {
            b &= C.b(context, cVar);
            if (!b) {
                C0596r.d(B.a, "isInitShoesDataIfNeeded syncMyShoesFromServer?=" + b);
            }
        } else {
            C0596r.d(B.a, "isInitShoesDataIfNeeded syncDeviceDataFromServer?=" + b);
        }
        cn.com.smartdevices.bracelet.shoes.data.a.b(context, cVar.b(), b);
        C0596r.e(B.a, "syncIntegralShoesData Inited ?= " + b + ",indentity:" + cVar);
        return b ? T.OK : T.ERROR;
    }

    private static T c(Context context, c cVar) {
        T a = K.a(context, d.a, cVar);
        if (T.ERROR.equals(a)) {
            C0596r.d(B.a, "Failed to syncDeviceDataToServer");
        }
        boolean a2 = C.a(context, cVar);
        if (!a2) {
            C0596r.d(B.a, "syncMyShoesInfoToServer?=" + a2);
        }
        return a;
    }

    private static T d(Context context, c cVar) {
        T e = e(context, cVar);
        C0596r.e(B.a, "syncIntegralShoesData diffResult=?" + e);
        if (T.NONE.equals(e)) {
            return T.NONE;
        }
        if (T.OK.equals(e)) {
            boolean b = C.b(context, cVar);
            if (!b) {
                C0596r.d(B.a, "syncDiffDateData syncMyShoesFromServer?=" + b);
            }
            return b ? T.OK : T.ERROR;
        } else {
            C0596r.d(B.a, "syncDiffDateData ?= false");
            return T.ERROR;
        }
    }

    private static T e(Context context, c cVar) {
        SportDay sportDay = new SportDay();
        SportDay addMonth = sportDay.addMonth(-3);
        j a = K.a(context, addMonth.getKey(), sportDay.getKey(), d.a, cVar);
        List a2 = b.a(a.a());
        if (a2.size() == 0) {
            C0596r.e(B.a, "Diff date list is empty");
            return T.NONE;
        }
        a.a().clear();
        C0596r.e(B.a, "Diff data sever list size:" + a2.size());
        Object b = t.b(context, cVar, addMonth.getKey(), sportDay.getKey());
        if (b != null) {
            a2.removeAll(b);
            b.clear();
        }
        if (a2.size() == 0) {
            C0596r.e(B.a, "Diff date list is empty");
            return T.NONE;
        }
        int a3;
        List<String> a4 = t.a(context, cVar, addMonth.getKey(), sportDay.getKey());
        if (a4 != null) {
            Collection arrayList = new ArrayList(a2.size());
            for (String str : a4) {
                if (a2.contains(str)) {
                    arrayList.add(str);
                }
            }
            if (arrayList.size() > 0) {
                C0596r.d(B.a, "Diff date list with data list size:" + arrayList.size());
                a3 = a(context, cVar, a2, true) & 1;
                if (a3 == 0) {
                    C0596r.d(B.a, "batchSyncDateDataFromServer isSucceeded:" + a3);
                }
            } else {
                a3 = 1;
            }
            a2.removeAll(arrayList);
        } else {
            a3 = 1;
        }
        if (a2.size() > 0) {
            C0596r.d(B.a, "Diff date list without data list size:" + a2.size());
            a3 &= a(context, cVar, a2, false);
            if (a3 == 0) {
                C0596r.d(B.a, "batchSyncDateDataFromServer isSucceeded:" + a3);
            }
        }
        a2.clear();
        return a3 != 0 ? T.OK : T.ERROR;
    }
}
