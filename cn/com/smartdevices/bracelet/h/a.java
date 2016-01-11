package cn.com.smartdevices.bracelet.h;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.F;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.config.b;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.xiaomi.hm.health.bt.d.e;
import com.xiaomi.hm.health.dataprocess.DataAnalysis;
import com.xiaomi.hm.health.dataprocess.DaySportData;
import com.xiaomi.hm.health.dataprocess.SportData;
import com.xiaomi.hm.health.dataprocess.SportDay;
import com.xiaomi.hm.health.dataprocess.UserInfo;
import com.xiaomi.mistatistic.sdk.d;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kankan.wheel.widget.l;

public class a implements cn.com.smartdevices.bracelet.datasource.a {
    private static a l = null;
    private final String a = "SensorHubController";
    private Context b = null;
    private f c = null;
    private b d = b.h();
    private SensorManager e;
    private Sensor f;
    private d g = new d(this);
    private int h = 0;
    private SportDay i = null;
    private e j = null;
    private e k = null;
    private boolean m = false;
    private DaySportData n = null;

    private a(Context context) {
        this.b = context;
        this.c = new f(context.getContentResolver());
        this.k = Keeper.readSensorHubInfo();
        C0596r.d("SensorHubController", this.k.toString());
        this.e = (SensorManager) this.b.getSystemService("sensor");
        this.f = this.e.getDefaultSensor(18);
    }

    private int a(long j, long j2) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        int i = instance.get(11);
        int i2 = instance.get(12);
        instance.setTimeInMillis(j2);
        return (instance.get(12) + ((instance.get(11) - i) * 60)) - i2;
    }

    static /* synthetic */ int a(a aVar, float f) {
        int i = (int) (((float) aVar.h) + f);
        aVar.h = i;
        return i;
    }

    public static a a() {
        return l;
    }

    private com.xiaomi.hm.health.bt.model.b a(LinkedList<g> linkedList) {
        if (linkedList == null || linkedList.size() == 0) {
            C0596r.d("SensorHubController", "toActivitiesNew steps is null!!!");
            return null;
        }
        g gVar = (g) linkedList.getFirst();
        int a = a(gVar.b(), gVar.c());
        long b = gVar.b();
        if (Math.abs(a) >= 1) {
            b += d.g;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(b);
        List arrayList = new ArrayList();
        C0596r.d("xxx", "=======================origin<I>steps=======================");
        b((LinkedList) linkedList);
        C0596r.d("xxx", "=======================origin<O>steps=======================");
        LinkedList c = c((LinkedList) linkedList);
        C0596r.d("xxx", "************************merged<I>steps************************");
        b(c);
        C0596r.d("xxx", "************************merged<O>steps************************");
        Iterator it = c.iterator();
        while (it.hasNext()) {
            arrayList.addAll(a((g) it.next()));
        }
        C0596r.d("xxx", "data date:" + instance.getTime().toString() + ",date size:" + arrayList.size());
        return new com.xiaomi.hm.health.bt.model.b(instance, arrayList);
    }

    private List<com.xiaomi.hm.health.bt.model.a> a(g gVar) {
        byte b;
        byte b2;
        int i = 0;
        C0596r.d("SensorHubController", "getActivityDataFromStep:" + gVar.toString());
        List<com.xiaomi.hm.health.bt.model.a> arrayList = new ArrayList();
        switch (gVar.d()) {
            case kankan.wheel.widget.a.i /*0*/:
            case l.a /*1*/:
                b = (byte) 0;
                b2 = (byte) 0;
                break;
            case kankan.wheel.widget.a.k /*2*/:
                b2 = (byte) 1;
                b = (byte) 120;
                break;
            case kankan.wheel.widget.a.l /*3*/:
                b2 = (byte) 2;
                b = (byte) -76;
                break;
            default:
                b = (byte) 0;
                b2 = (byte) 0;
                break;
        }
        int a = a(gVar.b(), gVar.c());
        if (a == 0) {
            arrayList.add(new com.xiaomi.hm.health.bt.model.a(b, gVar.e(), b2));
        } else {
            int e = gVar.e() / a;
            int e2 = gVar.e() % a;
            C0596r.e("xxx", "aveStep:" + e + ",modSteps:" + e2);
            while (i < a - 1) {
                arrayList.add(new com.xiaomi.hm.health.bt.model.a(b, e, b2));
                i++;
            }
            arrayList.add(new com.xiaomi.hm.health.bt.model.a(b, e + e2, b2));
        }
        return arrayList;
    }

    public static void a(Context context) {
        l = new a(context);
    }

    private void a(boolean z) {
        new Thread(new b(this, z)).start();
    }

    private void b(LinkedList<g> linkedList) {
        g gVar;
        Iterator it = linkedList.iterator();
        int i = 0;
        while (it.hasNext()) {
            gVar = (g) it.next();
            int e = gVar.e() + i;
            C0596r.e("xxx", "Step:" + gVar.toString());
            i = e;
        }
        gVar = (g) linkedList.getFirst();
        g gVar2 = (g) linkedList.getLast();
        C0596r.e("xxx", "start time:" + new Date(gVar.b()).toString());
        C0596r.e("xxx", "stop time:" + new Date(gVar2.c()).toString());
        C0596r.e("xxx", "total minutes:" + a(gVar.b(), gVar2.c()));
        C0596r.e("xxx", "total steps:" + i);
    }

    private LinkedList<g> c(LinkedList<g> linkedList) {
        LinkedList<g> linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        g gVar = null;
        while (it.hasNext()) {
            g gVar2 = (g) it.next();
            if (gVar != null) {
                int a = a(gVar.b(), gVar2.c());
                int a2 = a(gVar.c(), gVar2.b());
                int a3 = a(gVar2.b(), gVar2.c());
                if (a2 == 0) {
                    Object obj;
                    g gVar3;
                    g gVar4;
                    if (a == 0 && a3 == 0) {
                        obj = 1;
                        gVar3 = gVar;
                    } else if (a == 0 && a3 != 0) {
                        a = 1;
                        gVar3 = gVar2;
                    } else if (a == 0 || a3 != 0) {
                        obj = null;
                        gVar3 = gVar;
                    } else {
                        a = 1;
                        gVar3 = gVar;
                    }
                    if (obj != null) {
                        gVar4 = new g(gVar3.a(), gVar.b(), gVar2.c(), gVar3.d(), gVar.e() + gVar2.e());
                    } else {
                        linkedList2.add(gVar);
                        gVar4 = gVar2;
                    }
                    gVar2 = gVar4;
                } else if (a2 == 1) {
                    linkedList2.add(gVar);
                    if (a3 > 0) {
                        linkedList2.add(new g(-1, gVar.c(), gVar2.b(), 1, 0));
                    }
                } else {
                    linkedList2.add(gVar);
                    linkedList2.add(new g(-1, gVar.c(), a3 == 0 ? gVar2.b() - d.g : gVar2.b(), 1, 0));
                }
            }
            gVar = gVar2;
        }
        linkedList2.add(gVar);
        return linkedList2;
    }

    private boolean c() {
        C0596r.e("SensorHubController", "enableSensor");
        if (this.m) {
            return true;
        }
        if (this.f != null) {
            boolean registerListener = this.e.registerListener(this.g, this.f, 2);
            if (registerListener) {
                this.m = true;
            }
            return registerListener;
        }
        C0596r.d("SensorHubController", "sensor detector is null!!");
        return false;
    }

    private void d() {
        C0596r.e("SensorHubController", "disableSensor");
        if (this.m && this.e != null) {
            this.e.unregisterListener(this.g);
            this.m = false;
        }
    }

    public DaySportData a(SportDay sportDay) {
        DaySportData daySportData = new DaySportData(sportDay);
        com.xiaomi.hm.health.bt.model.b a = a(this.c.a(sportDay.getKey()));
        if (a != null) {
            List<com.xiaomi.hm.health.bt.model.a> list = a.b;
            Calendar calendar = a.a;
            for (com.xiaomi.hm.health.bt.model.a aVar : list) {
                int i = (calendar.get(11) * 60) + calendar.get(12);
                C0596r.e("xxx", "baseMin:" + i);
                daySportData.add(new SportData(i, aVar.e, aVar.c, aVar.d), true);
                calendar.add(12, 1);
            }
            PersonInfo readPersonInfo = Keeper.readPersonInfo();
            UserInfo userInfo = new UserInfo();
            userInfo.gender = readPersonInfo.gender;
            userInfo.weight = Utils.l();
            userInfo.height = readPersonInfo.height;
            userInfo.goal = readPersonInfo.getDaySportGoalSteps();
            DataAnalysis.dataPostProcess(userInfo, null, daySportData, null, null, null, null, null);
        }
        return daySportData;
    }

    public void a(Context context, F f) {
        new Thread(new c(this, f)).start();
    }

    public void a(e eVar) {
        C0596r.d("SensorHubController", eVar.toString());
        this.k = eVar;
        a(true);
    }

    public boolean a(boolean z, e eVar) {
        this.j = eVar;
        if (z) {
            boolean c = c();
            if (!c) {
                return c;
            }
            a(false);
            return c;
        }
        d();
        return true;
    }

    public int b() {
        int i;
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        long timeInMillis = instance.getTimeInMillis();
        LinkedList b = this.c.b(timeInMillis);
        if (b == null) {
            i = 0;
        } else {
            Iterator it = b.iterator();
            i = 0;
            while (it.hasNext()) {
                int e;
                g gVar = (g) it.next();
                C0596r.e("SensorHubController", "nearbyStep:" + gVar.toString());
                if (gVar.b() < timeInMillis || gVar.c() > timeInMillis) {
                    e = gVar.e() + i;
                } else {
                    int abs = Math.abs(a(gVar.b(), gVar.c()));
                    int abs2 = Math.abs(a(gVar.b(), timeInMillis));
                    if (Math.abs(abs) <= 1) {
                        e = gVar.e();
                    } else {
                        i = gVar.e() / abs;
                        e = abs2 == abs ? (gVar.e() % abs) + i : i;
                    }
                }
                i = e;
            }
        }
        C0596r.e("SensorHubController", "baseStep:" + 0 + ",totalStep:" + i);
        return 0 + i;
    }

    public DaySportData g(SportDay sportDay) {
        return this.n;
    }

    public int i(SportDay sportDay) {
        this.n = a(sportDay);
        return 0;
    }

    public SportDay k() {
        return this.c.a();
    }

    public SportDay l() {
        return new SportDay();
    }

    public SportDay m() {
        return new SportDay();
    }

    public SportDay n() {
        return new SportDay();
    }
}
