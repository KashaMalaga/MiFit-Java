package cn.com.smartdevices.bracelet.shoes.sync;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.data.analyzer.ShoesDataAnalysis;
import cn.com.smartdevices.bracelet.shoes.data.db.t;
import cn.com.smartdevices.bracelet.shoes.model.DateRawData;
import cn.com.smartdevices.bracelet.shoes.model.c;
import cn.com.smartdevices.bracelet.shoes.model.h;
import cn.com.smartdevices.bracelet.shoes.model.k;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.bt.model.b;
import com.xiaomi.hm.health.bt.model.d;
import com.xiaomi.hm.health.dataprocess.SportDay;
import com.xiaomi.hm.health.dataprocess.UserInfo;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class C0628e {
    private static final String a = "DDP";
    private static final boolean b = true;

    private C0628e() {
    }

    static C0629f a(Context context, c cVar, b<d> bVar) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        C0596r.e(a, "Phonetime:" + Calendar.getInstance().getTime().toString() + ",deviceAdress= " + cVar);
        if (cVar == null || cVar.e()) {
            return new C0629f();
        }
        Set b = C0628e.b(context, cVar, (b) bVar);
        boolean a = C0628e.a(context, cVar, b);
        if (!a) {
            C0596r.d(a, "process failed");
        }
        return new C0629f(a, b);
    }

    private static Set<String> a(Context context, c cVar, List<b<d>> list) {
        if (cVar == null || cVar.e() || list == null || list.size() == 0) {
            return null;
        }
        Set<String> hashSet = new HashSet();
        SportDay sportDay = new SportDay();
        String str = a.f;
        C0635l a = C0635l.a(context);
        for (b bVar : list) {
            Calendar calendar = bVar.a;
            List<d> list2 = bVar.b;
            C0596r.e(a, "Datatime:" + calendar.getTime().toString() + ",size:" + list2.size());
            sportDay.year = calendar.get(1);
            sportDay.mon = calendar.get(2);
            sportDay.day = calendar.get(5);
            String key = sportDay.getKey();
            hashSet.add(key);
            for (d a2 : list2) {
                int i = (calendar.get(11) * 60) + calendar.get(12);
                a.a(key, cVar, (boolean) b).a(i, a2);
                calendar.add(12, 1);
            }
            list2.clear();
        }
        list.clear();
        return hashSet;
    }

    private static boolean a(Context context, c cVar, Set<String> set) {
        if (set == null || set.size() == 0) {
            C0596r.e(a, "No changed date");
            return b;
        }
        UserInfo a = cn.com.smartdevices.bracelet.shoes.b.c.a();
        int i = 1;
        for (String str : set) {
            h a2 = C0635l.a(context).a(cVar, str);
            if (a2 != null) {
                int a3;
                if (a != null) {
                    C0596r.e(a, "processData date:" + str + ",process ?=" + a2.z());
                }
                if (a2.z()) {
                    C0628e.a(a2.c(), a);
                    a2.B();
                    a2.l(k.STATE_UNSYNCED.a());
                    a3 = t.a(context, a2) & i;
                } else {
                    a3 = i;
                }
                i = a3;
            }
        }
        return i != 0 ? C0630g.a(context, cVar, null) & i : false;
    }

    public static boolean a(DateRawData dateRawData, UserInfo userInfo) {
        if (dateRawData == null || userInfo == null) {
            C0596r.e(a, "Invalid parameter data = " + dateRawData + ",info = " + userInfo);
            return false;
        }
        try {
            ShoesDataAnalysis.processData(userInfo, dateRawData);
        } catch (Error e) {
            C0596r.d(a, "processData error e:" + e);
        } catch (Exception e2) {
            C0596r.d(a, "processData exception e:" + e2);
        }
        return b;
    }

    private static boolean a(String str) {
        return "1970-01-01".equals(str);
    }

    private static Set<String> b(Context context, c cVar, b<d> bVar) {
        if (cVar == null || cVar.e() || bVar == null) {
            C0596r.d(a, "mac or fragment is empty,mac:" + cVar + ",fragment:" + bVar);
            return null;
        }
        Calendar calendar = bVar.a;
        if (calendar == null) {
            C0596r.d(a, "fragment.timestamp is empty");
            return null;
        }
        SportDay sportDay = new SportDay();
        sportDay.year = calendar.get(1);
        sportDay.mon = calendar.get(2);
        sportDay.day = calendar.get(5);
        if (C0628e.a(sportDay.getKey())) {
            C0596r.d(a, "datatime:" + calendar.getTime().toString());
            return null;
        }
        List<d> list = bVar.b;
        if (list == null) {
            C0596r.d(a, "fragment.data is empty,datatime:" + calendar.getTime().toString());
            return null;
        }
        C0635l a = C0635l.a(context);
        Set<String> hashSet = new HashSet();
        String key = sportDay.getKey();
        hashSet.add(key);
        for (d dVar : list) {
            if (dVar == null) {
                C0596r.d(a, "runningdata is empty,datatime:" + calendar.getTime().toString());
            } else {
                a.a(key, cVar, (boolean) b).a((calendar.get(11) * 60) + calendar.get(12), dVar);
                calendar.add(12, 1);
            }
        }
        list.clear();
        return hashSet;
    }

    private static boolean b(Context context, c cVar, List<b<d>> list) {
        boolean z = false;
        if (context == null) {
            throw new IllegalArgumentException();
        }
        C0596r.e(a, "Phonetime:" + Calendar.getInstance().getTime().toString() + ",deviceAdress= " + cVar);
        if (!(cVar == null || cVar.e())) {
            Set a = C0628e.a(context, cVar, (List) list);
            if (a == null || a.size() == 0) {
                C0596r.e(a, "No changed date");
            } else {
                z = C0628e.a(context, cVar, a);
                if (!z) {
                    C0596r.e(a, "processAndUpdateDateData failed");
                }
                if (a != null) {
                    a.clear();
                }
            }
        }
        return z;
    }
}
