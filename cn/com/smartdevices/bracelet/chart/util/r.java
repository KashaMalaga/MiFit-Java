package cn.com.smartdevices.bracelet.chart.util;

import cn.com.smartdevices.bracelet.C0591m;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.weight.P;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.xiaomi.hm.health.dataprocess.DaySportData;
import com.xiaomi.hm.health.dataprocess.DaySportData.Summary;
import com.xiaomi.hm.health.dataprocess.SleepInfo;
import com.xiaomi.hm.health.dataprocess.SportDay;
import com.xiaomi.hm.health.dataprocess.StepsInfo;
import com.xiaomi.hm.health.dataprocess.UserSleepModify;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class r {
    private static final String a = "DynamicData";
    private static r z;
    private int b;
    private int c;
    private int d;
    private int e;
    private String f;
    private int g;
    private int h;
    private Date i;
    private Date j;
    private String k;
    private boolean l = true;
    private float m;
    private float n;
    private float o;
    private String p;
    private float q;
    private String r;
    private int s = -1;
    private P t;
    private int u = 20;
    private int v = 1;
    private int w;
    private HashMap<String, UserSleepModify> x = new HashMap();
    private boolean y = false;

    private r() {
    }

    public static r a() {
        if (z == null) {
            z = new r();
        }
        return z;
    }

    public UserSleepModify a(SportDay sportDay) {
        String key = sportDay.getKey();
        if (this.x.containsKey(key)) {
            return (UserSleepModify) this.x.get(key);
        }
        C0591m a = C0591m.a();
        Summary b = a.b(sportDay);
        UserSleepModify userSleepModify = new UserSleepModify();
        if (b == null) {
            return userSleepModify;
        }
        userSleepModify.sleepStart = b.getUserSleepStart();
        userSleepModify.sleepEnd = b.getUserSleepEnd();
        a(sportDay, userSleepModify);
        a.d(sportDay);
        return userSleepModify;
    }

    public void a(float f) {
        this.m = f;
    }

    public void a(int i) {
        this.b = i;
    }

    public void a(int i, int i2) {
        C0596r.e(a, "Update StepInfo With Realtime Steps : " + i);
        C0591m a = C0591m.a();
        SportDay d = a.d(i2);
        if (d != null) {
            float f;
            int i3;
            int i4;
            int i5;
            C0596r.e(a, "Current Step Day : " + Utils.c(d));
            long j = 0;
            SportDay sportDay = null;
            if (this.y) {
                long readRealtimeStepsTimestamp = Keeper.readRealtimeStepsTimestamp(i2);
                if (readRealtimeStepsTimestamp == -1) {
                    readRealtimeStepsTimestamp = 0;
                }
                Calendar instance = Calendar.getInstance();
                instance.setTimeInMillis(readRealtimeStepsTimestamp);
                SportDay sportDay2 = new SportDay(instance);
                if (!sportDay2.equals(d)) {
                    i = -1;
                    Keeper.keepRealtimeSteps(i2, -1);
                } else if (i == -1) {
                    i = Keeper.readRealtimeSteps(i2);
                }
                C0596r.e(a, "Restored/Reseted Realtime Steps : " + i);
                SportDay sportDay3 = sportDay2;
                j = readRealtimeStepsTimestamp;
                sportDay = sportDay3;
            }
            DaySportData b = a.b(i2, d);
            StepsInfo stepsInfo = null;
            if (b != null) {
                stepsInfo = b.getStepsInfo();
            }
            if (stepsInfo == null) {
                stepsInfo = new StepsInfo();
            }
            int stepsCount = stepsInfo.getStepsCount();
            int distance = stepsInfo.getDistance();
            int calories = stepsInfo.getCalories();
            C0596r.e(a, "Origin StepInfo : " + stepsCount + " , " + distance + " , " + calories);
            Object obj = !this.y ? 1 : null;
            if (this.y && i > stepsCount) {
                long readSyncTime = Keeper.readSyncTime(i2);
                if (readSyncTime == -1) {
                    readSyncTime = 0;
                }
                Calendar instance2 = Calendar.getInstance();
                instance2.setTimeInMillis(readSyncTime);
                if (sportDay.equals(new SportDay(instance2))) {
                    f = (((float) ((j - readSyncTime) / 1000)) / BitmapDescriptorFactory.HUE_YELLOW) + 1.0f;
                    C0596r.e(a, "RealtimeSteps : " + j + ", StepInfo : " + readSyncTime + ", Offset : " + f + " Mins");
                } else {
                    f = 1.0f;
                }
                if (((float) (i - stepsCount)) < f * 512.0f) {
                    obj = 1;
                }
            }
            if (obj != null) {
                i3 = stepsCount < 0 ? 0 : stepsCount;
                i4 = i <= 0 ? i3 : i;
                if (i3 > 0) {
                    f = ((float) i4) / ((float) i3);
                    i5 = (int) (((float) distance) * f);
                    i3 = (int) (f * ((float) calories));
                } else {
                    PersonInfo readPersonInfo = Keeper.readPersonInfo();
                    double d2 = (readPersonInfo == null || readPersonInfo.height <= 0) ? 0.714d : (((double) readPersonInfo.height) * 0.42d) / 100.0d;
                    i5 = (int) (d2 * ((double) i4));
                    i3 = (int) ((((((double) readPersonInfo.weight) * 2.2046d) * 1.19d) * ((double) i4)) / 4000.0d);
                }
                C0596r.e(a, "Realtime StepInfo : " + i4 + " , " + i5 + " , " + i3);
            } else {
                i3 = calories;
                i5 = distance;
                i4 = stepsCount;
            }
            a(i4);
            b(i5);
            d(i3);
        }
    }

    public void a(P p) {
        this.t = p;
    }

    public void a(SportDay sportDay, UserSleepModify userSleepModify) {
        this.x.put(sportDay.getKey(), userSleepModify);
    }

    public void a(String str) {
        this.f = str;
    }

    public void a(Date date) {
        this.i = date;
    }

    public void a(boolean z) {
        this.l = z;
    }

    public P b() {
        return this.t;
    }

    public void b(float f) {
        this.n = f;
    }

    public void b(int i) {
        this.c = i;
    }

    public void b(String str) {
        this.k = str;
    }

    public void b(Date date) {
        this.j = date;
    }

    public void b(boolean z) {
        this.y = z;
    }

    public int c() {
        return this.b;
    }

    public void c(float f) {
        this.o = f;
    }

    public void c(int i) {
        this.d = i;
    }

    public void c(String str) {
        this.p = str;
    }

    public int d() {
        return this.c;
    }

    public void d(float f) {
        this.q = f;
    }

    public void d(int i) {
        this.e = i;
    }

    public void d(String str) {
        this.r = str;
    }

    public int e() {
        return this.d;
    }

    public void e(int i) {
        this.g = i;
    }

    public int f() {
        return this.e;
    }

    public void f(int i) {
        this.h = i;
    }

    public String g() {
        return this.f;
    }

    public void g(int i) {
        this.s = i;
    }

    public int h() {
        return this.g;
    }

    public void h(int i) {
        this.w = i;
    }

    public int i() {
        return this.h;
    }

    public void i(int i) {
        this.u = i;
    }

    public Date j() {
        return this.i;
    }

    public void j(int i) {
        this.v = i;
    }

    public Date k() {
        return this.j;
    }

    public String l() {
        return this.k;
    }

    public boolean m() {
        return this.l;
    }

    public float n() {
        return this.m;
    }

    public float o() {
        return this.n;
    }

    public float p() {
        return this.o;
    }

    public String q() {
        return this.p;
    }

    public float r() {
        return this.q;
    }

    public String s() {
        return this.r;
    }

    public int t() {
        return this.s;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("StepCount : " + this.b);
        stringBuilder.append(", StepDistance : " + this.c);
        stringBuilder.append(", LiningDistance : " + this.d);
        stringBuilder.append(", StepCalorie : " + this.e);
        stringBuilder.append(", SleepTime : " + this.g);
        stringBuilder.append(", SleepDeepTime : " + this.h);
        stringBuilder.append("\nWeight : ").append(this.m).append("\nWeightBMI : ").append(this.q).append("\nWeightTip : " + this.r);
        return stringBuilder.toString();
    }

    public int u() {
        return this.w;
    }

    public int v() {
        return this.u;
    }

    public int w() {
        return this.v;
    }

    public boolean x() {
        return this.y;
    }

    public void y() {
        C0591m a = C0591m.a();
        SportDay n = a.n();
        if (n != null) {
            boolean z;
            SleepInfo sleepInfo;
            C0596r.e(a, "Current Sleep Day : " + Utils.c(n));
            DaySportData g = a.g(n);
            SleepInfo sleepInfo2 = null;
            if (g != null) {
                sleepInfo2 = g.getSleepInfo();
            }
            if (sleepInfo2 == null) {
                sleepInfo2 = new SleepInfo();
                z = true;
            } else {
                z = sleepInfo2.getSleepCount() == 0;
            }
            if (z && n.calendar.get(11) >= 5) {
                z = false;
            }
            C0596r.e(a, "Show Previous Day's Sleep Info: " + z);
            if (z) {
                a.i(n.addDay(-1));
                g = a.g(n.addDay(-1));
                if (g != null) {
                    sleepInfo = g.getSleepInfo();
                    if (sleepInfo == null) {
                        sleepInfo = new SleepInfo();
                    }
                    if (sleepInfo.getHasSleep() && sleepInfo.getNosleepReason() == SleepInfo.NOSLEEP_NONWEAR) {
                        a(false);
                    } else {
                        a(true);
                    }
                    e(sleepInfo.getSleepCount());
                    f(sleepInfo.getNonRemCount());
                    a(sleepInfo.getStartDate());
                    b(sleepInfo.getStopDate());
                }
            }
            sleepInfo = sleepInfo2;
            if (sleepInfo.getHasSleep()) {
            }
            a(true);
            e(sleepInfo.getSleepCount());
            f(sleepInfo.getNonRemCount());
            a(sleepInfo.getStartDate());
            b(sleepInfo.getStopDate());
        }
    }
}
