package cn.com.smartdevices.bracelet.shoes.sync;

import android.content.Context;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.eventbus.shoes.EventDeviceBoundState;
import cn.com.smartdevices.bracelet.shoes.data.db.n;
import cn.com.smartdevices.bracelet.shoes.data.db.t;
import cn.com.smartdevices.bracelet.shoes.data.db.u;
import cn.com.smartdevices.bracelet.shoes.model.a;
import cn.com.smartdevices.bracelet.shoes.model.g;
import cn.com.smartdevices.bracelet.shoes.model.h;
import cn.com.smartdevices.bracelet.shoes.model.i;
import cn.com.smartdevices.bracelet.shoes.sync.b.b;
import cn.com.smartdevices.bracelet.shoes.sync.b.c;
import com.xiaomi.hm.health.dataprocess.DaySportData;
import com.xiaomi.hm.health.dataprocess.DaySportData.Summary;
import com.xiaomi.hm.health.dataprocess.DaySportData.SummaryEntity;
import com.xiaomi.hm.health.dataprocess.SportDay;
import com.xiaomi.hm.health.dataprocess.UserInfo;
import com.xiaomi.mistatistic.sdk.d;
import de.greenrobot.event.EventBus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public final class C0635l implements b {
    private static C0635l a = null;
    private static final String c = "SDCM";
    private List<c> b = null;
    private final byte[] d = new byte[0];
    private volatile cn.com.smartdevices.bracelet.shoes.model.c e = null;
    private C0637n f = null;
    private C0638o g = null;
    private HashMap<cn.com.smartdevices.bracelet.shoes.model.c, ConcurrentHashMap<String, h>> h = null;
    private HashMap<String, ConcurrentHashMap<String, Integer>> i = null;
    private C0636m j = null;
    private SportDay k = null;
    private Context l = null;

    private C0635l(Context context) {
        this.l = context.getApplicationContext();
        this.b = new ArrayList();
        this.h = new HashMap();
        this.i = new HashMap();
        this.j = new C0636m(this);
        b(this.l);
    }

    private h a(Context context, cn.com.smartdevices.bracelet.shoes.model.c cVar, String str) {
        h a = a(str, cVar, false);
        if (a == null) {
            return null;
        }
        if (!a.z()) {
            return a;
        }
        C0628e.a(a.c(), cn.com.smartdevices.bracelet.shoes.b.c.a());
        return a;
    }

    public static synchronized C0635l a(Context context) {
        C0635l c0635l;
        synchronized (C0635l.class) {
            if (a == null) {
                a = new C0635l(context);
            }
            c0635l = a;
        }
        return c0635l;
    }

    private void a(cn.com.smartdevices.bracelet.shoes.model.c cVar) {
        cn.com.smartdevices.bracelet.shoes.model.c cVar2;
        boolean a = C0632i.a(this.l, cVar.b());
        synchronized (this.d) {
            cVar2 = this.e;
        }
        if (!(cVar2 == null || cVar.equals(cVar2))) {
            d(cVar);
        }
        C0596r.d(c, "force close.disconnAddress = " + cVar + ",boundAddress = " + cVar2 + ",isDisconned ?= " + a);
    }

    private void a(cn.com.smartdevices.bracelet.shoes.model.c cVar, String str, h hVar) {
        if (hVar != null && cVar != null && !cVar.e()) {
            ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.h.get(cVar);
            if (concurrentHashMap == null) {
                concurrentHashMap = new ConcurrentHashMap();
                concurrentHashMap.put(str, hVar);
                this.h.put(cVar, concurrentHashMap);
                return;
            }
            concurrentHashMap.put(str, hVar);
        }
    }

    private void a(cn.com.smartdevices.bracelet.shoes.model.c cVar, boolean z) {
        if (cVar != null && !cVar.e()) {
            ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.i.get(cVar.b());
            if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
                return;
            }
            if (z) {
                C0596r.d(c, "disconnectConnIfNeeded force ?= " + z + ",macAddress = " + cVar);
                this.j.sendMessage(this.j.a(cVar, true));
                return;
            }
            this.j.sendMessageDelayed(this.j.a(cVar, false), d.g);
        }
    }

    private void b(Context context) {
        c(context);
        d(context);
    }

    private void b(Context context, cn.com.smartdevices.bracelet.shoes.model.c cVar, String str) {
        cn.com.smartdevices.bracelet.shoes.model.c cVar2;
        C0596r.e(c, "onBoundShoesStateChanged argIdentity:" + cVar + ",mCurBoundIndentity:" + this.e);
        synchronized (this.d) {
            cVar2 = this.e;
        }
        boolean z = (Integer.valueOf(str).intValue() == 1 && cVar.equals(cVar2)) ? false : true;
        if (z) {
            J.a(context, cVar2, Integer.valueOf(str).intValue());
            d(cVar2.b());
            a(cVar2, true);
            cn.com.smartdevices.bracelet.shoes.c.a(this.l, -1);
            C0596r.d(c, "onBoundShoesStateChanged update lastBoundIndentity:" + cVar);
        }
        if (Integer.valueOf(str).intValue() != 1) {
            c(cVar2);
            synchronized (this.d) {
                this.e = null;
            }
            EventBus.getDefault().post(new EventDeviceBoundState(cn.com.smartdevices.bracelet.shoes.d.a, 0));
        } else if (!cVar.equals(cVar2)) {
            synchronized (this.d) {
                this.e = cVar;
            }
            J.a(context, cVar, null);
            b(cVar);
            EventBus.getDefault().post(new EventDeviceBoundState(cn.com.smartdevices.bracelet.shoes.d.a, 1));
        }
        C0596r.d(c, "onChange identityArg " + cVar + ",state = " + str + ",curBoundIndentity = " + this.e + ",updateLastDeviceInfo = " + z);
    }

    private void b(cn.com.smartdevices.bracelet.shoes.model.c cVar) {
        for (c a : this.b) {
            a.a(cVar);
        }
    }

    private boolean b(String str, String str2) {
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.i.get(str2);
        if (concurrentHashMap == null) {
            C0596r.d(c, "map zero.tag = " + str + ",address = " + str2 + ",boundAddress = " + this.e);
        } else {
            Integer num = (Integer) concurrentHashMap.get(str);
            if (num == null) {
                C0596r.d(c, "count zero.tag = " + str + ",address = " + str2 + ",boundAddress = " + this.e);
            } else {
                num = Integer.valueOf(num.intValue() - 1);
                if (num.intValue() != 0) {
                    concurrentHashMap.put(str, num);
                } else {
                    concurrentHashMap.remove(str);
                    if (concurrentHashMap.size() == 0) {
                        this.i.remove(str2);
                        C0596r.d(c, "mDeviceConnMapRefs.remove address = " + str2);
                    }
                }
                C0596r.d(c, "cnt = " + num + ",tag = " + str + ",address = " + str2 + ",boundAddress = " + this.e);
            }
        }
        return true;
    }

    private void c(Context context) {
        synchronized (this.d) {
            if (this.e == null) {
                a e = t.e(context);
                this.e = e != null ? e.g() : new cn.com.smartdevices.bracelet.shoes.model.c();
                C0596r.d(c, "initBoundAddressIfNeeded = " + this.e);
            }
        }
        if (this.f == null) {
            this.f = new C0637n(this, context);
            C0596r.d(c, "MyShoesContent.NOTIFIER_URI = " + n.c);
            context.getContentResolver().registerContentObserver(n.c, true, this.f);
        }
        if (this.g == null) {
            this.g = new C0638o(this, context);
            C0596r.d(c, "ShoesDateDataContent.NOTIFIER_URI = " + u.c);
            context.getContentResolver().registerContentObserver(u.c, true, this.g);
        }
    }

    private void c(cn.com.smartdevices.bracelet.shoes.model.c cVar) {
        for (c b : this.b) {
            b.b(cVar);
        }
    }

    private void d(Context context) {
        String[] j = t.j(context);
        if (j == null) {
            k();
            return;
        }
        this.k = SportDay.fromString(j[0]);
        C0596r.d(c, "first start:" + this.k.getKey() + ",end:" + SportDay.fromString(j[1]).getKey());
    }

    private void d(cn.com.smartdevices.bracelet.shoes.model.c cVar) {
        if (cVar != null && !cVar.e()) {
            ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.h.get(cVar);
            if (concurrentHashMap == null) {
                C0596r.d(c, "no data " + cVar);
                return;
            }
            concurrentHashMap.clear();
            this.h.remove(cVar);
        }
    }

    private void d(String str) {
        if (TextUtils.isEmpty(str)) {
            C0596r.d(c, "address is invalid");
            return;
        }
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.i.get(str);
        if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
            C0596r.d(c, "map is zero address = " + str + ",map = " + concurrentHashMap);
            return;
        }
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap(concurrentHashMap.size());
        for (Entry entry : concurrentHashMap.entrySet()) {
            if (((String) entry.getKey()).startsWith(str)) {
                concurrentHashMap2.put(entry.getKey(), entry.getValue());
                C0596r.d(c, "found tag = " + ((String) entry.getKey()) + ",cnt = " + entry.getValue());
            }
        }
        if (concurrentHashMap2.size() > 0) {
            this.i.put(str, concurrentHashMap2);
        } else {
            this.i.remove(str);
            C0596r.d(c, "mDeviceConnMapRefs.remove address = " + str);
        }
        C0596r.d(c, "syncingTag size = " + concurrentHashMap2.size() + ",address = " + str);
    }

    private String e(String str) {
        if (!str.contains("@")) {
            return null;
        }
        String[] split = str.split("@");
        return (split == null || split.length != 2) ? null : split[0];
    }

    private void k() {
        if (this.k == null) {
            this.k = new SportDay();
        }
        C0596r.d(c, "initDefaultFEDays start:" + this.k.getKey());
    }

    h a(cn.com.smartdevices.bracelet.shoes.model.c cVar, String str) {
        if (cVar == null || cVar.e()) {
            return null;
        }
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.h.get(cVar);
        return concurrentHashMap == null ? null : (h) concurrentHashMap.get(str);
    }

    h a(String str, cn.com.smartdevices.bracelet.shoes.model.c cVar, boolean z) {
        if (cVar == null || cVar.e() || TextUtils.isEmpty(str)) {
            return null;
        }
        h a = a(cVar, str);
        if (a != null) {
            return a;
        }
        a = t.a(this.l, str, cVar, true);
        if (a == null && z) {
            a = new h(cVar, str, true);
        }
        a(cVar, str, a);
        return a;
    }

    public i a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        synchronized (this.d) {
            cn.com.smartdevices.bracelet.shoes.model.c cVar = this.e;
        }
        if (cVar == null || cVar.e()) {
            return null;
        }
        h a = a(cVar, str);
        if (a != null) {
            return a.w();
        }
        a = t.a(this.l, str, cVar, false);
        return a != null ? a.w() : null;
    }

    public DaySportData a(SportDay sportDay) {
        if (sportDay == null) {
            throw new IllegalArgumentException();
        }
        cn.com.smartdevices.bracelet.shoes.model.c cVar;
        synchronized (this.d) {
            cVar = this.e;
        }
        h a = a(this.l, cVar, sportDay.getKey());
        if (a == null) {
            return null;
        }
        DaySportData daySportData = new DaySportData(sportDay.getCalendar());
        daySportData.setStepsInfo(a.v());
        return daySportData;
    }

    public String a() {
        c(this.l);
        return this.e.b();
    }

    public void a(c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException();
        } else if (!this.b.contains(cVar)) {
            this.b.add(cVar);
        }
    }

    boolean a(String str, String str2) {
        int i;
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.i.get(str2);
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap();
            concurrentHashMap.put(str, Integer.valueOf(1));
            this.i.put(str2, concurrentHashMap);
            i = 1;
        } else {
            Integer num = (Integer) concurrentHashMap.get(str);
            int intValue = (num == null ? 0 : num.intValue()) + 1;
            concurrentHashMap.put(str, Integer.valueOf(intValue));
            i = intValue;
        }
        C0596r.d(c, "cnt = " + i + ",tag = " + str + ",address =" + str2 + ",boundAddress = " + this.e);
        return true;
    }

    public cn.com.smartdevices.bracelet.shoes.model.c b() {
        c(this.l);
        return this.e;
    }

    public Summary b(SportDay sportDay) {
        if (sportDay == null) {
            throw new IllegalArgumentException();
        }
        SummaryEntity summaryEntity = new SummaryEntity();
        i a = a(sportDay.getKey());
        if (a != null) {
            C0631h.a(summaryEntity, a);
        }
        return summaryEntity;
    }

    public void b(c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException();
        } else if (this.b.contains(cVar)) {
            this.b.remove(cVar);
        }
    }

    boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String str2 = com.xiaomi.e.a.f;
        c(this.l);
        synchronized (this.d) {
            str2 = this.e.b();
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = e(str);
            if (TextUtils.isEmpty(str2)) {
                C0596r.d(c, "address is invalid.tag = " + str);
                return false;
            }
            C0596r.d(c, "address is invalid .maskAddress = " + str2 + ",tag = " + str);
        }
        return a(str, str2);
    }

    public int c(SportDay sportDay) {
        if (sportDay == null) {
            throw new IllegalArgumentException();
        }
        cn.com.smartdevices.bracelet.shoes.model.c cVar;
        synchronized (this.d) {
            cVar = this.e;
        }
        a(this.l, cVar, sportDay.getKey());
        return 0;
    }

    public SportDay c() {
        return e();
    }

    boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        cn.com.smartdevices.bracelet.shoes.model.c cVar;
        String e;
        synchronized (this.d) {
            cVar = this.e;
        }
        if (cVar == null || TextUtils.isEmpty(cVar.b())) {
            e = e(str);
            if (TextUtils.isEmpty(e)) {
                C0596r.d(c, "address is invalid.tag = " + str);
                return false;
            }
            C0596r.d(c, "address is invalid .maskAddress = " + e + ",tag = " + str);
        } else {
            e = cVar.b();
        }
        b(str, e);
        a(cVar, false);
        return true;
    }

    public SportDay d() {
        return this.k;
    }

    public SportDay e() {
        return f();
    }

    public SportDay f() {
        return new SportDay();
    }

    public g g() {
        cn.com.smartdevices.bracelet.shoes.model.c cVar;
        synchronized (this.d) {
            cVar = this.e;
        }
        String key = f().getKey();
        h a = a(this.l, cVar, key);
        if (a == null) {
            return null;
        }
        g gVar = new g();
        gVar.b = a.g();
        gVar.a = a.u();
        gVar.c = a.i();
        gVar.a(key);
        return gVar;
    }

    public int h() {
        cn.com.smartdevices.bracelet.shoes.model.c cVar;
        synchronized (this.d) {
            cVar = this.e;
        }
        h a = a(this.l, cVar, f().getKey());
        return a == null ? -1 : a.u();
    }

    public void i() {
        C0596r.d(c, "logout mCurBoundMacAddress = " + this.e);
        synchronized (this.d) {
            a(this.e);
            this.e = null;
        }
        if (this.h != null) {
            this.h.clear();
        }
        if (this.i != null) {
            this.i.clear();
        }
        if (this.j != null) {
            this.j.a();
        }
    }

    public boolean j() {
        cn.com.smartdevices.bracelet.shoes.model.c cVar;
        synchronized (this.d) {
            cVar = this.e;
        }
        h a = a(this.l, cVar, f().getKey());
        if (a == null) {
            return false;
        }
        UserInfo a2 = cn.com.smartdevices.bracelet.shoes.b.c.a();
        if (a2 == null) {
            return false;
        }
        a.e(a2.goal);
        C0628e.a(a.c(), a2);
        a.B();
        return t.a(this.l, a);
    }
}
