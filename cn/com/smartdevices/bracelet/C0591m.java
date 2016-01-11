package cn.com.smartdevices.bracelet;

import android.content.Context;
import android.support.v7.widget.af;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.d.C0425b;
import cn.com.smartdevices.bracelet.datasource.DeviceSource;
import cn.com.smartdevices.bracelet.datasource.a;
import cn.com.smartdevices.bracelet.honor.a.g;
import cn.com.smartdevices.bracelet.honor.a.h;
import cn.com.smartdevices.bracelet.j.l;
import cn.com.smartdevices.bracelet.lab.sportmode.SportBaseInfo;
import cn.com.smartdevices.bracelet.model.BasicDateData;
import cn.com.smartdevices.bracelet.model.LoginData;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.ReportData;
import cn.com.smartdevices.bracelet.model.ShareListDelegateActivity;
import cn.com.smartdevices.bracelet.model.SyncedServerDataInfo;
import cn.com.smartdevices.bracelet.model.UserTotalSportData;
import cn.com.smartdevices.bracelet.shoes.sync.C0635l;
import com.xiaomi.hm.health.dataprocess.DataAnalysis;
import com.xiaomi.hm.health.dataprocess.DaySportData;
import com.xiaomi.hm.health.dataprocess.DaySportData.Summary;
import com.xiaomi.hm.health.dataprocess.DaySportData.SummaryEmpty;
import com.xiaomi.hm.health.dataprocess.DaySportData.SummaryEntity;
import com.xiaomi.hm.health.dataprocess.SleepInfo;
import com.xiaomi.hm.health.dataprocess.SportDay;
import com.xiaomi.hm.health.dataprocess.StepsInfo;
import com.xiaomi.hm.health.dataprocess.UserInfo;
import com.xiaomi.hm.health.dataprocess.UserSleepModify;
import com.xiaomi.mistatistic.sdk.d;
import de.greenrobot.event.EventBus;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class C0591m implements a {
    public static final int a = 4;
    private static final String b = "DataManager";
    private static final boolean c = false;
    private static final int f = 7;
    private static final int g = 0;
    private static final int h = 1;
    private static final int i = 2;
    private static final int j = 3;
    private static final int k = 5;
    private static final int l = 6;
    private static final String m = "2014-09-30";
    private static C0591m v = null;
    private static Context x = null;
    private ReportData A;
    private SportDay d;
    private boolean e = c;
    private C0425b n = null;
    private final ConcurrentHashMap<String, DaySportData> o = new ConcurrentHashMap();
    private final ConcurrentHashMap<String, Summary> p = new ConcurrentHashMap();
    private SportDay q = new SportDay();
    private SportDay r = new SportDay();
    private SportDay s = new SportDay();
    private SportDay t = null;
    private SportDay u = null;
    private SyncedServerDataInfo w = null;
    private SportDay y = null;
    private SportDay z = SportDay.fromString(m);

    private C0591m(Context context) {
        x = context.getApplicationContext();
        this.n = C0425b.a(x);
        c();
    }

    private int a(String str, String str2) {
        return ((int) ((SportDay.toCalenday(str2).getTime().getTime() - SportDay.toCalenday(str).getTime().getTime()) / d.h)) + h;
    }

    public static C0591m a() {
        return v;
    }

    private ReportData a(ReportData reportData, SportDay sportDay, SportDay sportDay2) {
        int a = a(sportDay.toString(), sportDay2.toString());
        if (a >= 0) {
            reportData.clearPartSportData();
            int i = g;
            int i2 = g;
            int i3 = g;
            int i4 = reportData.maxContinueDays;
            int i5 = g;
            C0596r.e(b, "normal maxDays = " + i4);
            reportData.setContinueDays(a(reportData.timeFrom, reportData.timeTo));
            int i6 = g;
            while (i6 < a) {
                int i7;
                SportDay addDay = sportDay.addDay(i6);
                Summary b = b(addDay);
                C0596r.e(b, "temp day:" + addDay + ", steps =" + b.getSteps() + ", goal = " + b.getDayStepGoal() + ", reach: " + (b.getSteps() >= b.getDayStepGoal() ? true : c));
                int i8;
                if (b.getSteps() >= b.getDayStepGoal()) {
                    i3 += h;
                    if (i3 <= i4) {
                        i7 = i4;
                    } else if ((this.e && (addDay.isToday() || addDay.isYesterday())) || i5 == j) {
                        i7 = g;
                        reportData.maxDateStr = com.xiaomi.e.a.f;
                        C0596r.e(b, "set maxDays to 0 because it's in current continue process, not making history! ");
                    } else {
                        reportData.maxDateStr = addDay.toString();
                        C0596r.e(b, "find new maxDays = " + i3 + " date = " + reportData.maxDateStr);
                        i7 = i3;
                    }
                    i5 = i2 + h;
                    if (i5 % f != 0 || i5 < f) {
                        i4 = h;
                    } else {
                        i += h;
                        C0596r.e(b, "skips + 1 = " + i + ", goalDaysTemp = " + i5);
                        i4 = i;
                    }
                    if (addDay.isToday()) {
                        reportData.todayComplete = h;
                    }
                    reportData.calories += b.getStepCalories();
                    reportData.steps += b.getSteps();
                    reportData.distance += b.getStepDistance();
                    reportData.runDistance += b.getStepRunDistance();
                    if (TextUtils.isEmpty(reportData.timeFrom)) {
                        reportData.timeFrom = addDay.toString();
                        i8 = i5;
                        i5 = i;
                        i = i8;
                    } else {
                        i8 = i5;
                        i5 = i;
                        i = i8;
                    }
                } else if (a(addDay)) {
                    if (!addDay.isToday()) {
                        if (!j(addDay)) {
                            C0596r.e(b, "stop of manual algorithm in " + addDay.toString());
                            i7 = (!addDay.isYesterday() || i <= 0) ? g : l;
                            reportData.clearPartSportData();
                            i3 = g;
                        } else if (i > 0) {
                            i--;
                            i7 = j;
                            C0596r.e(b, "server used skips at " + addDay + "....... left skips = " + i);
                        } else {
                            C0596r.d(b, "server and local lazy different, local available skips =" + i);
                            i7 = i5;
                        }
                        i8 = i7;
                        i7 = i4;
                        i4 = i8;
                        i5 = i;
                        i = g;
                    } else if (i > 0) {
                        if (j(addDay)) {
                            i--;
                            i7 = k;
                            C0596r.e(b, "server used skips today ......... left skips = " + i);
                        } else {
                            i7 = a;
                        }
                        C0596r.e(b, "to show tips .........skips = " + i);
                        i5 = i;
                        i = i2;
                        i8 = i4;
                        i4 = i7;
                        i7 = i8;
                    } else {
                        C0596r.e(b, "algo 2, failed today, continue to show previous record.........");
                        i7 = i4;
                        i4 = i5;
                        i5 = i;
                        i = i2;
                    }
                } else if (addDay.isToday()) {
                    i7 = i4;
                    i4 = i5;
                    i5 = i;
                    i = i2;
                } else if (i > 0) {
                    i5 = i - 1;
                    i = g;
                    C0596r.e(b, "skips - 1 = " + i5);
                    if (addDay.offsetDay(new SportDay()) == -1) {
                        i7 = i4;
                        i4 = j;
                    } else {
                        i7 = i4;
                        i4 = h;
                    }
                } else {
                    i3 = g;
                    reportData.clearPartSportData();
                    i7 = i4;
                    i4 = g;
                    i5 = i;
                    i = g;
                }
                i6 += h;
                i2 = i;
                i = i5;
                i5 = i4;
                i4 = i7;
            }
            C0596r.e(b, "Status = " + i5 + ", reachGoalDays = " + i3 + ", skips = " + i);
            reportData.maxContinueDays = i4;
            reportData.setContinueDays(i3);
            reportData.skips = i;
            reportData.continueStatus = i5;
            C0596r.e(b, "get report data  = " + reportData);
        }
        return reportData;
    }

    public static void a(Context context) {
        if (v == null) {
            v = new C0591m(context);
        }
    }

    private void a(Context context, int i, int i2) {
        Object obj = h;
        if (i != i2 && context != null) {
            Object obj2 = i2 - i < 0 ? h : g;
            if (i2 - i <= 0) {
                obj = g;
            }
            if (obj2 != null) {
                C0401a.a(context, C0401a.em, Math.abs(i2 - i));
            } else if (obj != null) {
                C0401a.a(context, C0401a.en, Math.abs(i2 - i));
            }
        }
    }

    private void a(SummaryEntity summaryEntity, JSONObject jSONObject) {
        long j;
        JSONObject jSONObject2 = jSONObject.getJSONObject("steps_info");
        JSONObject jSONObject3 = jSONObject.getJSONObject("sleep_info");
        summaryEntity.setSteps(jSONObject2.optInt("steps"));
        summaryEntity.setStepDistance(jSONObject2.optInt(cn.com.smartdevices.bracelet.relation.db.a.g));
        summaryEntity.setStepCalories(jSONObject2.optInt("calories"));
        summaryEntity.setStepWalkDistance(summaryEntity.getStepDistance());
        summaryEntity.setStepWalkCalories(summaryEntity.getStepCalories());
        summaryEntity.setStepWalkDuration(jSONObject2.optInt("walk_time"));
        summaryEntity.setStepRunDuration(jSONObject2.optInt("run_time"));
        summaryEntity.setStepDuration(summaryEntity.getStepWalkDuration() + summaryEntity.getStepRunDuration());
        summaryEntity.setSleep(jSONObject3.optInt("sleep_minutes"));
        summaryEntity.setSleepDeepTime(jSONObject3.optInt("nrem_minutes"));
        summaryEntity.setSleepShallowTime(jSONObject3.optInt("rem_minutes"));
        try {
            j = jSONObject3.getLong("start_date");
        } catch (Exception e) {
            e.printStackTrace();
            j = Date.parse(jSONObject3.getString("start_date"));
        }
        summaryEntity.setSleepStartTime(j);
        try {
            j = jSONObject3.getLong("stop_date");
        } catch (Exception e2) {
            e2.printStackTrace();
            j = Date.parse(jSONObject3.getString("stop_date"));
        }
        summaryEntity.setSleepRiseTime(j);
        summaryEntity.setSleepWakeTime(jSONObject3.optInt("awake_minutes"));
        jSONObject2 = jSONObject.optJSONObject("daysportgoal_info");
        if (jSONObject2 != null) {
            summaryEntity.setDayStepGoal(jSONObject2.optInt("goalStepsCount"));
        }
    }

    private void a(SummaryEntity summaryEntity, JSONObject jSONObject, int i) {
        JSONObject jSONObject2 = jSONObject.getJSONObject(StepsInfo.KEY_STEP_INFO);
        JSONObject jSONObject3 = jSONObject.getJSONObject(SleepInfo.KEY_SLEEP_INFO);
        summaryEntity.setSteps(jSONObject2.optInt(StepsInfo.KEY_STEPS));
        summaryEntity.setStepDistance(jSONObject2.optInt(StepsInfo.KEY_DISTANCE));
        summaryEntity.setStepCalories(jSONObject2.optInt(StepsInfo.KEY_CALORIES));
        summaryEntity.setStepWalkDuration(jSONObject2.optInt(StepsInfo.KEY_STEP_WALK_TIME));
        summaryEntity.setStepRunDuration(jSONObject2.optInt(StepsInfo.KEY_STEP_RUN_TIME));
        summaryEntity.setStepDuration(summaryEntity.getStepWalkDuration() + summaryEntity.getStepRunDuration());
        summaryEntity.setStepRunDistance(jSONObject2.optInt(StepsInfo.KEY_STEP_RUN_DISTANCE));
        summaryEntity.setStepWalkDistance(summaryEntity.getStepDistance() - summaryEntity.getStepRunDistance());
        summaryEntity.setStepRunCalories(jSONObject2.optInt(StepsInfo.KEY_STEP_RUN_CALORIES));
        summaryEntity.setStepWalkCalories(summaryEntity.getStepCalories() - summaryEntity.getStepRunCalories());
        if (i > i) {
            summaryEntity.setDayStepGoal(jSONObject.optInt(cn.com.smartdevices.bracelet.gps.c.d.c));
        } else if (!jSONObject.isNull("daysportgoal_info")) {
            summaryEntity.setDayStepGoal(jSONObject.optInt("daysportgoal_info"));
        }
        if (jSONObject3 != null) {
            int optInt = jSONObject3.optInt(SleepInfo.KEY_DEEP_MINUTES);
            int optInt2 = jSONObject3.optInt(SleepInfo.KEY_LIGHT_MINUTES);
            if (i == h) {
                summaryEntity.setSleepDeepTime(optInt2);
                summaryEntity.setSleepShallowTime(optInt);
            } else {
                summaryEntity.setSleepDeepTime(optInt);
                summaryEntity.setSleepShallowTime(optInt2);
            }
            summaryEntity.setSleep(optInt + optInt2);
            summaryEntity.setSleepWakeTime(jSONObject3.optInt(SleepInfo.KEY_AWAKE_MINUTES));
            summaryEntity.setSleepStartTime(jSONObject3.getLong(SleepInfo.KEY_START_DATE) * 1000);
            summaryEntity.setSleepRiseTime(jSONObject3.getLong(SleepInfo.KEY_END_DATE) * 1000);
            summaryEntity.setUserSleepStart(jSONObject3.optInt(SleepInfo.KEY_USER_SLEEP_START, af.a));
            summaryEntity.setUserSleepEnd(jSONObject3.optInt(SleepInfo.KEY_USER_SLEEP_END, af.a));
        }
    }

    private void a(DaySportData daySportData, DaySportData daySportData2, DaySportData daySportData3) {
        PersonInfo readPersonInfo = Keeper.readPersonInfo();
        UserSleepModify a = daySportData2 != null ? ChartData.a().a(daySportData2.getSportDay()) : null;
        if (daySportData3 != null) {
            ChartData.a().a(daySportData3.getSportDay());
        }
        UserInfo userInfo = new UserInfo();
        userInfo.gender = readPersonInfo.gender;
        userInfo.weight = Utils.l();
        userInfo.height = readPersonInfo.height;
        userInfo.goal = readPersonInfo.getDaySportGoalSteps();
        DataAnalysis.dataPostProcess(userInfo, daySportData, daySportData2, daySportData3, a, null, daySportData == null ? null : this.n.c(daySportData.getKey(), t()), daySportData2 == null ? null : this.n.c(daySportData2.getKey(), t()));
    }

    private boolean a(SportDay sportDay, Summary summary) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(summary.getSleepStartTime());
        int i = instance.get(l);
        int i2 = instance.get(11);
        int i3 = sportDay.getCalendar().get(l);
        C0596r.e(b, "sleepDay: " + i + "; caclDay: " + i3 + "; sleep time:" + new SimpleDateFormat("HH:mm:ss").format(Long.valueOf(instance.getTimeInMillis())));
        return (i2 >= 23 || i == i3) ? c : true;
    }

    private ReportData b(SportDay sportDay, SportDay sportDay2) {
        ReportData reportData = new ReportData();
        reportData.setTimeTo(sportDay2.getKey());
        reportData.setTimeFrom(sportDay.getKey());
        while (sportDay2.compare(sportDay) >= 0) {
            Summary b = b(sportDay2);
            if (b != null && b.getSteps() > 0) {
                reportData.distance += b.getStepDistance();
                reportData.runDistance += b.getStepRunDistance();
                reportData.calories += b.getStepCalories();
                reportData.steps += b.getSteps();
                if (b.getSteps() > reportData.maxDateStep) {
                    reportData.maxDateStep = b.getSteps();
                    reportData.maxDateStr = sportDay2.getKey();
                }
            }
            C0596r.e(b, "getReportData: stop=" + sportDay2 + " distance = " + reportData.distance + ", startday = " + sportDay);
            sportDay2 = sportDay2.addDay(-1);
        }
        return reportData;
    }

    private void b(C0595q c0595q) {
        long currentTimeMillis = System.currentTimeMillis();
        C0596r.e(b, "in loadNetData");
        if (Utils.l(x)) {
            LoginData f = cn.com.smartdevices.bracelet.e.a.f(x);
            String d = cn.com.smartdevices.bracelet.e.a.d(x);
            C0596r.e(b, "in loadNetData  deviceId = " + d);
            l.a(f, d, c0595q, (int) j, new C0593o(this, c0595q));
            C0596r.e(b, "out loadNetData:" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            return;
        }
        C0596r.d(b, "isNetworkConnected:false");
    }

    private ReportData c(SportDay sportDay, SportDay sportDay2) {
        ArrayList arrayList = new ArrayList();
        ReportData reportData = null;
        while (sportDay2.compare(sportDay) >= 0) {
            Summary b = b(sportDay2);
            if (b.getDayStepGoal() <= b.getSteps()) {
                if (reportData == null) {
                    reportData = new ReportData();
                    arrayList.add(reportData);
                    reportData.type = ShareListDelegateActivity.SHARE_TYPE_CONTIUE_REACH_GOAL;
                    reportData.timeTo = sportDay2.getKey();
                }
                reportData.timeFrom = sportDay2.getKey();
                reportData.calories += b.getStepCalories();
                reportData.steps += b.getSteps();
                reportData.distance += b.getStepDistance();
                reportData.runDistance = b.getStepRunDistance() + reportData.runDistance;
            } else {
                reportData = null;
            }
            sportDay2 = sportDay2.addDay(-1);
        }
        if (arrayList.size() == 0) {
            return new ReportData();
        }
        reportData = (ReportData) arrayList.get(g);
        Calendar instance = Calendar.getInstance();
        instance.add(l, -1);
        Summary b2 = b(new SportDay(instance));
        if (b2.getSteps() >= b2.getDayStepGoal()) {
            this.e = true;
        }
        Iterator it = arrayList.iterator();
        int i = g;
        while (it.hasNext()) {
            ReportData reportData2 = (ReportData) it.next();
            C0596r.e(b, reportData2.timeFrom + "--->" + reportData2.timeTo);
            int a = a(reportData2.timeFrom, reportData2.timeTo);
            boolean z = ((SportDay.fromString(reportData2.timeTo).isToday() || SportDay.fromString(reportData2.timeTo).isYesterday()) && this.e) ? true : g;
            if (a >= i && a > i && !z) {
                C0596r.d(b, "Found days max: " + a + ", yesterdayReachGoal = " + this.e + ", timeTo = " + reportData2.timeTo);
                reportData.maxDateStr = reportData2.timeTo.toString();
                i = a;
            }
            SportDay fromString = SportDay.fromString(m);
            int a2 = a(reportData2.timeFrom, fromString.toString());
            a = a(fromString.toString(), reportData2.timeTo);
            if (a2 >= 0 && a >= 0) {
                this.z = SportDay.fromString(reportData2.timeFrom);
                C0596r.e(b, "Calc startSkipDay = " + this.z + ", lastestRd.timeFrom = " + reportData.timeFrom + ", lastestRd.timeTo = " + reportData.timeTo);
            }
        }
        reportData.maxContinueDays = i;
        return reportData;
    }

    private boolean j(SportDay sportDay) {
        ArrayList d = Utils.d();
        if (d == null) {
            return c;
        }
        Iterator it = d.iterator();
        while (it.hasNext()) {
            if (((String) it.next()).equals(sportDay.toString())) {
                return true;
            }
        }
        return c;
    }

    private int k(SportDay sportDay) {
        DaySportData h;
        DaySportData h2;
        int i = h;
        SportDay addDay = sportDay.addDay(-1);
        SportDay addDay2 = sportDay.addDay(h);
        if (!this.w.isSynced()) {
            b(new C0595q());
        }
        if (!this.o.containsKey(sportDay.getKey())) {
            h = h(sportDay);
            if (h != null) {
                a(h);
            }
        }
        if (!((addDay.compare(this.q) >= 0 ? h : g) == 0 || this.o.containsKey(addDay.getKey()))) {
            h = h(addDay);
            if (h != null) {
                a(h);
            }
        }
        if (addDay2.compare(l()) > 0) {
            i = g;
        }
        if (!(i == 0 || this.o.containsKey(addDay2.getKey()))) {
            h2 = h(addDay2);
            if (h2 != null) {
                a(h2);
            }
        }
        h2 = g(sportDay);
        h = g(addDay);
        DaySportData g = g(addDay2);
        if (h2 != null && h2.isNeedPostProcess()) {
            a(h, h2, g);
        }
        return g;
    }

    private void v() {
        Calendar instance = Calendar.getInstance();
        long readLastCaclMedalTime = Keeper.readLastCaclMedalTime();
        if (readLastCaclMedalTime != 0) {
            instance.setTimeInMillis(readLastCaclMedalTime);
        } else {
            Calendar instance2 = Calendar.getInstance();
            instance2.add(l, -2);
            instance.setTimeInMillis(instance2.getTimeInMillis());
        }
        SportDay sportDay = new SportDay(instance);
        SportDay l = l();
        g gVar = new g();
        while (l.compare(sportDay) >= 0) {
            Summary b = b(sportDay);
            if (b != null && a(sportDay, b)) {
                gVar.h = b.getSleepStartTime();
                gVar.f = b.getSleepRiseTime();
                C0596r.e(b, "SleepSummary:" + gVar.toString());
                EventBus.getDefault().post(gVar);
            }
            sportDay = sportDay.addDay(h);
        }
        Keeper.keepLastCaclMedalTime(Long.valueOf(Calendar.getInstance().getTimeInMillis()));
    }

    private void w() {
        h hVar = new h();
        ReportData reportData = new ReportData();
        SportDay k = k();
        for (SportDay l = l(); l.compare(k) >= 0; l = l.addDay(-1)) {
            Summary b = b(l);
            if (b != null && b.getSteps() > 0) {
                reportData.steps = b.getSteps() + reportData.steps;
            }
        }
        hVar.h = (long) reportData.getSteps();
        DaySportData g = g(m());
        if (g != null) {
            StepsInfo stepsInfo = g.getStepsInfo();
            if (stepsInfo != null) {
                hVar.i = stepsInfo.getStepsCount();
            }
        }
        hVar.j = Keeper.readPersonInfo().getDaySportGoalSteps();
        if (this.A == null) {
            this.A = i();
        }
        hVar.l = this.A.getContinueDays();
        hVar.f = System.currentTimeMillis();
        C0596r.e(b, "step summary = " + hVar);
        EventBus.getDefault().post(hVar);
    }

    private void x() {
        y();
        c();
    }

    private void y() {
        C0596r.e(b, "clear.................................");
        this.o.clear();
        this.p.clear();
        this.q = n();
        this.r = n();
        this.s = n();
    }

    public int a(String str, C0595q c0595q) {
        return this.n.a(str, c0595q);
    }

    public ReportData a(SportDay sportDay, SportDay sportDay2) {
        C0596r.e(b, "getContinueReachGoalReportData ==================== Step 1 =====================");
        ReportData c = c(sportDay, sportDay2);
        C0596r.e(b, "getContinueReachGoalReportData ==================== Step 2 ===================== ");
        return a(c, this.z, sportDay2);
    }

    public Summary a(int i, SportDay sportDay) {
        return i == j ? C0635l.a(x).b(sportDay) : c(sportDay);
    }

    public DaySportData a(int i, int i2, int i3) {
        SportDay sportDay = new SportDay(i, i2, i3);
        if (!(SyncedServerDataInfo.readInfoFromPref(g).isSynced() && this.o.containsKey(sportDay.getKey()))) {
            C0596r.d(b, "Not sync from server or database!!! loading...");
            i(sportDay);
        }
        return g(sportDay);
    }

    public DaySportData a(String str) {
        return (DaySportData) this.o.get(str);
    }

    public SportDay a(int i) {
        return i == j ? C0635l.a(x).d() : this.q;
    }

    public ArrayList<BasicDateData> a(C0595q c0595q) {
        return this.n.a(c0595q);
    }

    public void a(int i, int i2) {
        SportDay sportDay = this.s;
        if (i2 == 0) {
            sportDay = this.s;
        } else if (i2 == h) {
            sportDay = this.q;
        } else if (i2 == i) {
            sportDay = l();
        }
        this.s = sportDay.addDay(i);
    }

    public void a(C0594p c0594p) {
        new C0592n(this, c0594p).execute(new Void[g]);
    }

    public void a(DaySportData daySportData) {
        this.o.put(daySportData.getKey(), daySportData);
        SportDay sportDay = daySportData.getSportDay();
        if (this.q.compare(sportDay) == h) {
            this.q = sportDay;
        }
    }

    public void a(ArrayList<BasicDateData> arrayList, int i, C0595q c0595q) {
        C0596r.e(b, "insertDatas.......................................0");
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            BasicDateData basicDateData = (BasicDateData) it.next();
            SportDay fromString = SportDay.fromString(basicDateData.date);
            C0596r.e(b, "SD:" + fromString.getKey());
            DaySportData h = this.o.containsKey(fromString.getKey()) ? (DaySportData) this.o.get(fromString.getKey()) : h(fromString);
            if (h != null) {
                C0596r.e(b, "dayData not null.................");
                DaySportData daySportData = new DaySportData(fromString);
                daySportData.fromBinaryData(fromString, basicDateData.data);
                daySportData.merge(h);
                basicDateData.data = daySportData.getBinaryData();
            }
        }
        C0596r.e(b, "insertDatas.......................................1");
        this.n.a((ArrayList) arrayList, i, c0595q);
        C0596r.e(b, "insertDatas.......................................2");
        x();
    }

    public boolean a(SportDay sportDay) {
        if (sportDay == null) {
            return c;
        }
        Calendar calendar = sportDay.getCalendar();
        this.d = SportDay.fromString(Keeper.readManualLazyDayAlgoStartDate());
        this.d.getCalendar().set(10, g);
        this.d.getCalendar().set(12, g);
        boolean before = this.d.getCalendar().before(calendar);
        C0596r.e(b, "tempDay = " + sportDay + ", isAlgoritmManual = " + before + ", manual start algo: " + this.d);
        return before;
    }

    public BasicDateData b(String str, C0595q c0595q) {
        return this.n.g(str, c0595q);
    }

    public Summary b(SportDay sportDay) {
        return DeviceSource.hasBindBracelet() ? c(sportDay) : DeviceSource.hasBindShoesDevice() ? C0635l.a(x).b(sportDay) : c(sportDay);
    }

    public DaySportData b(int i, SportDay sportDay) {
        return i == j ? C0635l.a(x).a(sportDay) : DeviceSource.hasBindBracelet() ? sportDay == null ? new DaySportData(n()) : (DaySportData) this.o.get(sportDay.getKey()) : sportDay == null ? new DaySportData(n()) : (DaySportData) this.o.get(sportDay.getKey());
    }

    public SportDay b(int i) {
        return i == j ? C0635l.a(x).f() : n();
    }

    public void b() {
        this.o.clear();
        this.p.clear();
        this.n.d();
        this.w = new SyncedServerDataInfo(g);
    }

    public boolean b(ArrayList<BasicDateData> arrayList, int i, C0595q c0595q) {
        return this.n.b((ArrayList) arrayList, i, c0595q);
    }

    public Summary c(SportDay sportDay) {
        Summary summary = (Summary) this.p.get(sportDay.getKey());
        if (summary == null) {
            Object e = this.n.e(sportDay.getKey(), new C0595q(g));
            C0596r.e(b, "Read Summary : " + sportDay + " , " + e);
            if (TextUtils.isEmpty(e)) {
                summary = new SummaryEmpty();
            } else {
                SummaryEntity summaryEntity = new SummaryEntity();
                try {
                    JSONObject jSONObject = new JSONObject(e);
                    int optInt = jSONObject.optInt(SportBaseInfo.VERSION, g);
                    if (optInt >= h) {
                        a(summaryEntity, jSONObject, optInt);
                    } else {
                        a(summaryEntity, jSONObject);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            this.p.put(sportDay.getKey(), summary);
        }
        return summary;
    }

    public SportDay c(int i) {
        return j == i ? C0635l.a(x).c() : this.s;
    }

    public void c() {
        C0596r.b(b, "in initDays");
        this.y = new SportDay(2014, h, h);
        String[] c = this.n.c();
        if (c != null) {
            this.q = SportDay.fromString(c[g]);
            this.r = SportDay.fromString(c[h]);
            this.s = l();
            if (this.q.compare(this.y) < 0) {
                this.q = this.y;
            }
            if (this.r.compare(this.s) > 0) {
                this.r = this.s;
            }
            C0596r.e(b, "localStartDay:" + this.q + "\n" + "localStopDay:" + this.r + "\n" + "curDay:" + this.s);
        }
        this.w = SyncedServerDataInfo.readInfoFromPref(g);
        if (this.w.isSyncedData()) {
            this.t = SportDay.fromString(this.w.getStartDate());
            this.u = SportDay.fromString(this.w.getStopDate());
        }
        C0596r.e(b, "netStartDay:" + this.t + "\n" + "netStopDay:" + this.u + "\n" + "curDay:" + this.s);
        C0596r.b(b, "out initDays");
    }

    public ReportData d() {
        int i = Calendar.getInstance().get(f);
        SportDay sportDay = new SportDay();
        if (Utils.m()) {
            i--;
        } else {
            if (i == h) {
                i = 8;
            }
            i -= 2;
        }
        return b(sportDay.addDay(-i), sportDay);
    }

    public SportDay d(int i) {
        return i == j ? C0635l.a(x).f() : new SportDay();
    }

    public void d(SportDay sportDay) {
        C0596r.e(b, "Remove Summary : " + sportDay);
        if (sportDay != null && this.p != null) {
            this.p.remove(sportDay.getKey());
        }
    }

    public ReportData e() {
        C0596r.e(b, "in getLastWeekReportData");
        SportDay k = k();
        SportDay l = l();
        ReportData reportData = new ReportData();
        reportData.type = ShareListDelegateActivity.SHARE_TYPE_LAST_WEEK;
        Calendar instance = Calendar.getInstance();
        int i = instance.get(f);
        instance.add(k, (i == h ? -6 : 2 - i) - 7);
        SportDay sportDay = new SportDay(instance);
        instance.add(k, l);
        SportDay sportDay2 = new SportDay(instance);
        if (sportDay2.compare(k) < 0) {
            return reportData;
        }
        reportData.timeFrom = sportDay.getKey();
        reportData.timeTo = sportDay2.getKey();
        if (sportDay.compare(k) < 0) {
            sportDay = k;
        }
        k = sportDay2.compare(l) > 0 ? l : sportDay2;
        while (k.compare(sportDay) >= 0) {
            Summary b = b(k);
            if (b != null && b.getSteps() > 0) {
                reportData.distance += b.getStepDistance();
                reportData.runDistance += b.getStepRunDistance();
                reportData.calories += b.getStepCalories();
                reportData.steps += b.getSteps();
                if (b.getSteps() > reportData.maxDateStep) {
                    reportData.maxDateStep = b.getSteps();
                    reportData.maxDateStr = k.getKey();
                }
            }
            k = k.addDay(-1);
        }
        C0596r.e(b, "out getLastWeekReportData");
        return reportData;
    }

    public UserTotalSportData e(SportDay sportDay) {
        UserTotalSportData userTotalSportData = new UserTotalSportData();
        SportDay sportDay2 = new SportDay(sportDay);
        SportDay k = k();
        userTotalSportData.highestStepDay = k.toString();
        userTotalSportData.longestSleepDay = k.toString();
        int i = g;
        while (sportDay.compare(k) >= 0) {
            Summary b = b(sportDay);
            if (b == null) {
                sportDay = sportDay.addDay(-1);
            } else {
                int steps = b.getSteps();
                if (steps > 0) {
                    userTotalSportData.iDistance += b.getStepDistance();
                    userTotalSportData.iSteps += steps;
                    userTotalSportData.iTotalwearingdays += h;
                    userTotalSportData.totalRunDist += b.getStepRunDistance();
                    if (steps > userTotalSportData.highestStep) {
                        userTotalSportData.highestStep = steps;
                        userTotalSportData.highestStepDay = sportDay.toString();
                    }
                }
                steps = b.getSleep();
                if (steps > 0) {
                    if (steps > userTotalSportData.longestSleepMin) {
                        userTotalSportData.longestSleepMin = steps;
                        userTotalSportData.longestSleepDay = sportDay.toString();
                    }
                    steps = b.getSleepDeepTime();
                    if (steps > userTotalSportData.longestSleepDeepMin) {
                        userTotalSportData.longestSleepDeepMin = steps;
                    }
                    steps = Utils.a(b);
                    userTotalSportData.avgSleepStartTime += steps;
                    userTotalSportData.avgSleepEndTime = (Utils.b(b) + steps) + userTotalSportData.avgSleepEndTime;
                    i += h;
                }
                sportDay = sportDay.addDay(-1);
            }
        }
        userTotalSportData.startUseDay = k.toString();
        if (i > 0) {
            userTotalSportData.avgSleepStartTime /= i;
            userTotalSportData.avgSleepEndTime /= i;
        } else {
            userTotalSportData.avgSleepStartTime = g;
            userTotalSportData.avgSleepEndTime = g;
        }
        userTotalSportData.setReportData(a(k, sportDay2));
        userTotalSportData.setWeekReportData(d());
        if (userTotalSportData.iTotalwearingdays != 0) {
            userTotalSportData.iAverageSteps = userTotalSportData.iSteps / userTotalSportData.iTotalwearingdays;
        } else {
            userTotalSportData.iAverageSteps = g;
        }
        C0596r.e(b, "UserTotalSportData:\n" + userTotalSportData.toString());
        C0596r.e(b, "out getUserTotalSportData ");
        return userTotalSportData;
    }

    public void f() {
        w();
        v();
    }

    public void f(SportDay sportDay) {
        this.s = sportDay;
    }

    public ReportData g() {
        C0596r.e(b, "in getLastMonthReportData");
        ReportData reportData = new ReportData();
        reportData.type = ShareListDelegateActivity.SHARE_TYPE_LAST_MONTH;
        Calendar instance = Calendar.getInstance();
        instance.add(i, -1);
        instance.set(k, h);
        SportDay sportDay = new SportDay(instance);
        instance.set(k, h);
        instance.add(i, h);
        instance.add(k, -1);
        SportDay sportDay2 = new SportDay(instance);
        SportDay k = k();
        SportDay l = l();
        if (sportDay2.compare(k) < 0) {
            return reportData;
        }
        reportData.timeFrom = sportDay.getKey();
        reportData.timeTo = sportDay2.getKey();
        if (sportDay.compare(k) >= 0) {
            k = sportDay;
        }
        sportDay = sportDay2.compare(l) > 0 ? l : sportDay2;
        while (sportDay.compare(k) >= 0) {
            Summary b = b(sportDay);
            if (b != null && b.getSteps() > 0) {
                reportData.distance += b.getStepDistance();
                reportData.runDistance += b.getStepRunDistance();
                reportData.calories += b.getStepCalories();
                reportData.steps += b.getSteps();
                if (b.getSteps() > reportData.maxDateStep) {
                    reportData.maxDateStep = b.getSteps();
                    reportData.maxDateStr = sportDay.getKey();
                }
            }
            sportDay = sportDay.addDay(-1);
        }
        C0596r.e(b, "out getLastMonthReportData");
        return reportData;
    }

    public DaySportData g(SportDay sportDay) {
        return DeviceSource.hasBindBracelet() ? sportDay == null ? new DaySportData(n()) : (DaySportData) this.o.get(sportDay.getKey()) : DeviceSource.hasBindShoesDevice() ? C0635l.a(x).a(sportDay) : sportDay == null ? new DaySportData(n()) : (DaySportData) this.o.get(sportDay.getKey());
    }

    public ReportData h() {
        C0596r.e(b, "in getStepRecord");
        ReportData reportData = new ReportData();
        reportData.type = ShareListDelegateActivity.SHARE_TYPE_NEW_RECORD;
        SportDay k = k();
        for (SportDay addDay = l().addDay(-1); addDay.compare(k) >= 0; addDay = addDay.addDay(-1)) {
            Summary b = b(addDay);
            if (b != null && b.getSteps() > 0 && b.getSteps() > reportData.steps) {
                reportData.distance = b.getStepDistance();
                reportData.calories = b.getStepCalories();
                reportData.steps = b.getSteps();
                reportData.maxDateStep = b.getSteps();
                reportData.maxDateStr = addDay.getKey();
            }
        }
        C0596r.e(b, "out getStepRecord:" + reportData.steps);
        return reportData;
    }

    public DaySportData h(SportDay sportDay) {
        byte[] b = this.n.b(sportDay.getKey(), new C0595q());
        if (b == null || b.length == 0) {
            return null;
        }
        DaySportData daySportData = new DaySportData(sportDay);
        byte[] c = this.n.c(sportDay.getKey(), new C0595q());
        if (c == null || c.length == 0) {
            daySportData.fromBinaryData(sportDay, b);
            return daySportData;
        }
        daySportData.fromBinaryWithHRData(sportDay, b, c);
        return daySportData;
    }

    public synchronized int i(SportDay sportDay) {
        int k;
        k = DeviceSource.hasBindBracelet() ? k(sportDay) : DeviceSource.hasBindShoesDevice() ? C0635l.a(x).c(sportDay) : k(sportDay);
        return k;
    }

    public ReportData i() {
        this.A = a(k(), l());
        return this.A;
    }

    public boolean j() {
        boolean z;
        SportDay k = k();
        for (SportDay l = l(); l.compare(k) >= 0; l = l.addDay(-1)) {
            if (b(l).getSleep() > 0) {
                z = true;
                C0596r.e(b, "Check has sleep summary : true");
                break;
            }
        }
        z = c;
        if (!z) {
            C0596r.e(b, "Check has sleep summary : false");
        }
        return z;
    }

    public SportDay k() {
        return DeviceSource.hasBindBracelet() ? this.q : DeviceSource.hasBindShoesDevice() ? C0635l.a(x).d() : this.q;
    }

    public SportDay l() {
        return DeviceSource.hasBindBracelet() ? n() : DeviceSource.hasBindShoesDevice() ? C0635l.a(x).f() : n();
    }

    public SportDay m() {
        return DeviceSource.hasBindBracelet() ? this.s : DeviceSource.hasBindShoesDevice() ? C0635l.a(x).c() : this.s;
    }

    public SportDay n() {
        return DeviceSource.hasBindBracelet() ? new SportDay() : DeviceSource.hasBindShoesDevice() ? C0635l.a(x).f() : new SportDay();
    }

    public synchronized void o() {
        C0596r.d(b, "in analysis");
        for (Entry entry : this.o.entrySet()) {
            DaySportData daySportData = (DaySportData) entry.getValue();
            SportDay sportDay = daySportData.getSportDay();
            C0596r.e(b, "in analysis entry= " + entry);
            if (daySportData != null && daySportData.isNeedPostProcess() && daySportData.isLocalNeedSync()) {
                SportDay addDay = sportDay.addDay(-1);
                DaySportData g = g(addDay);
                DaySportData h = g == null ? h(addDay) : g;
                SportDay addDay2 = sportDay.addDay(h);
                g = g(addDay2);
                if (g == null) {
                    g = h(addDay2);
                }
                a(h, daySportData, g);
                C0596r.e(b, "in analysis dataPostProcess= " + daySportData);
                d(sportDay);
            }
        }
        C0596r.d(b, "out analysis");
    }

    public void p() {
        C0596r.b(b, "in saveToDb");
        com.xiaomi.hm.health.bt.model.h f = com.xiaomi.hm.health.bt.bleservice.a.f();
        boolean a = f != null ? f.a() : c;
        PersonInfo readPersonInfo = Keeper.readPersonInfo();
        for (Entry value : this.o.entrySet()) {
            DaySportData daySportData = (DaySportData) value.getValue();
            if (daySportData.isLocalNeedSync()) {
                C0596r.d(b, "saveToDb:" + daySportData.getKey());
                if (a) {
                    C0596r.d(b, "MiLi 1S's data saveToDb");
                    this.n.a(daySportData.getKey(), daySportData.getBinaryData(), daySportData.getSummary(readPersonInfo.getDaySportGoalSteps()), daySportData.getIndexS(), t(), daySportData.getBinaryHRData(this.n.c(daySportData.getKey(), t())), daySportData.getHRSummary(this.n.f(daySportData.getKey(), t())));
                } else {
                    C0596r.d(b, "MiLi 1's data saveToDb");
                    this.n.a(daySportData.getKey(), daySportData.getBinaryData(), daySportData.getSummary(readPersonInfo.getDaySportGoalSteps()), daySportData.getIndexS(), t());
                }
                daySportData.setLocalNeedSync(c);
            }
        }
        C0596r.b(b, "out saveToDb");
    }

    public int q() {
        int b = Utils.b(Calendar.getInstance());
        Calendar instance = Calendar.getInstance();
        instance.add(k, 1 - b);
        instance.add(k, -3);
        SportDay sportDay = new SportDay(instance);
        SportDay addDay = sportDay.addDay(-4);
        long j = 0;
        b = g;
        for (SportDay sportDay2 = sportDay; sportDay2.compare(addDay) >= 0; sportDay2 = sportDay2.addDay(-1)) {
            Summary b2 = b(sportDay2);
            if (b2 != null && b2.getSleep() > 0) {
                j += (long) (Utils.b(b2) + Utils.a(b2));
                b += h;
            }
        }
        return b > 0 ? (int) (j / ((long) b)) : g;
    }

    public int r() {
        return (!DeviceSource.hasBindBracelet() && DeviceSource.hasBindShoesDevice()) ? j : g;
    }

    public void s() {
        if (DeviceSource.hasBindBracelet()) {
            SportDay n = n();
            DaySportData g = g(n);
            d(n);
            if (g != null) {
                g.setNeedSync(true);
            }
            p();
        }
        if (DeviceSource.hasBindShoesDevice()) {
            C0635l.a(x).j();
        }
    }

    public C0595q t() {
        com.xiaomi.hm.health.bt.model.h f = com.xiaomi.hm.health.bt.bleservice.a.f();
        return f == null ? new C0595q() : f.b() ? new C0595q(g, k) : f.a() ? new C0595q(g, a) : DeviceSource.hasBindSensorHub() ? new C0595q(g, i) : new C0595q();
    }
}
