package cn.com.smartdevices.bracelet;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.C0056bn;
import android.support.v4.app.aT;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.datasource.DeviceSource;
import cn.com.smartdevices.bracelet.f.f;
import cn.com.smartdevices.bracelet.lab.sportmode.LabFactoryActiveItem;
import cn.com.smartdevices.bracelet.lua.LuaEvent;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.ReportData;
import cn.com.smartdevices.bracelet.model.ReportInfo;
import cn.com.smartdevices.bracelet.ui.DailySleepReportActivity;
import cn.com.smartdevices.bracelet.ui.DailySportReportActivity;
import com.huami.android.zxing.l;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.dataprocess.ActiveItem;
import com.xiaomi.hm.health.dataprocess.DaySportData;
import com.xiaomi.hm.health.dataprocess.SleepInfo;
import com.xiaomi.hm.health.dataprocess.SportDay;
import com.xiaomi.hm.health.dataprocess.StepsInfo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class DynamicManager {
    private static final int a = 20;
    private static final int b = 1290;
    private static final int c = 630;
    private static final int e = 300;
    private static DynamicManager f = null;
    private final String d = "DynamicManager";

    private DynamicManager() {
    }

    private void a(Context context, int i, int i2) {
        CharSequence string;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (i >= i2) {
            string = context.getString(R.string.daily_sport_report_notify, new Object[]{Integer.valueOf(i)});
        } else {
            string = context.getString(R.string.daily_sport_report_notify_hurry, new Object[]{Integer.valueOf(i2 - i)});
        }
        aT e = new aT(context).a((int) R.drawable.app_icon).a(string).b(context.getString(R.string.daily_sport_report_notify_content)).e(true);
        e.a(new long[]{100, 500});
        e.a(PendingIntent.getActivity(context, 0, new Intent(context, DailySportReportActivity.class), 268435456));
        notificationManager.notify(l.a, e.c());
    }

    private void a(Context context, String str) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        aT e = new aT(context).a((int) R.drawable.app_icon).a((CharSequence) str).b(context.getString(R.string.notify_sleep_content)).e(true);
        e.a(new long[]{100, 500});
        e.a(PendingIntent.getActivity(context, 0, new Intent(context, DailySleepReportActivity.class), 268435456));
        notificationManager.notify(16, e.c());
    }

    private void a(Context context, boolean z) {
        String readLastWeekReportDate = Keeper.readLastWeekReportDate();
        ReportData e = C0591m.a().e();
        if (e.isValid()) {
            C0596r.e("DynamicManager", e.toString());
            if (z || readLastWeekReportDate == null || !readLastWeekReportDate.equals(e.timeFrom)) {
                Keeper.KeepLastWeekReportDate(e.timeFrom);
                C0596r.e("DynamicManager", "set week report .........................");
                LuaEvent.getInstance(context).setWeekReport(e);
                return;
            }
            return;
        }
        C0596r.e("DynamicManager", "generateLastWeekReport inValid!!!!");
    }

    private void b(Context context, boolean z) {
        if (Calendar.getInstance().get(5) <= 10) {
            String readLastMonthReportDate = Keeper.readLastMonthReportDate();
            ReportData g = C0591m.a().g();
            if (g.isValid()) {
                C0596r.e("DynamicManager", g.toString());
                if (z || readLastMonthReportDate == null || !readLastMonthReportDate.equals(g.timeFrom)) {
                    Keeper.KeepLastMonthReportDate(g.timeFrom);
                    C0596r.e("DynamicManager", "set Month report .........................");
                    LuaEvent.getInstance(context).setMonthReport(g);
                    return;
                }
                return;
            }
            C0596r.e("DynamicManager", "generateLastMonthReport inValid!!!!!!!");
        }
    }

    private void c(Context context, boolean z) {
        ReportInfo readContinueReachGoalRi = Keeper.readContinueReachGoalRi();
        ReportData i = C0591m.a().i();
        if (!i.isValid()) {
            C0596r.e("DynamicManager", "reportData is inValid");
            z = true;
        }
        ReportInfo reportInfo = new ReportInfo();
        reportInfo.dateTo = i.timeTo;
        reportInfo.dateFrom = i.timeFrom;
        C0596r.e("DynamicManager", "lastRi date from =" + readContinueReachGoalRi.dateFrom + ", lastReport.timeTo = " + readContinueReachGoalRi.dateTo);
        C0596r.e("DynamicManager", "report date from =" + i.timeFrom + ", reportData.timeTo = " + i.timeTo);
        if (z || !readContinueReachGoalRi.dateFrom.equals(i.timeFrom) || !readContinueReachGoalRi.dateTo.equals(i.timeTo)) {
            C0596r.e("DynamicManager", i.toString());
            Keeper.keepContinueReachGoalRi(reportInfo);
            C0596r.e("DynamicManager", "continue reach goal report .........................");
            LuaEvent.getInstance(context).setContinueReport(i);
        }
    }

    private void e(Context context) {
        C0591m a = C0591m.a();
        DaySportData g = a.g(a.n());
        LuaEvent instance = LuaEvent.getInstance(context);
        if (g != null) {
            StepsInfo stepsInfo = g.getStepsInfo();
            if (stepsInfo != null) {
                int stepsCount = stepsInfo.getStepsCount();
                if (new SportDay().addDay(-7).compare(C0591m.a().k()) > 0) {
                    ReportData h = C0591m.a().h();
                    C0596r.e("DynamicManager", h.toString());
                    if (stepsCount > h.steps) {
                        C0596r.e("DynamicManager", "newRecordReport .........................");
                        h.setStepsInfo(stepsInfo);
                        instance.setRecord(h);
                        return;
                    }
                    return;
                }
                C0596r.e("DynamicManager", "newRecordReport do nothing.........................");
            }
        }
    }

    private void f(Context context) {
        C0591m a = C0591m.a();
        DaySportData g = a.g(a.n());
        LuaEvent instance = LuaEvent.getInstance(context);
        if (g != null) {
            SleepInfo sleepInfo = g.getSleepInfo();
            if (sleepInfo != null) {
                Calendar instance2 = Calendar.getInstance();
                if (instance2.get(12) + (instance2.get(11) * 60) > e) {
                    C0596r.e("DynamicManager", "sleep report .........................");
                    instance.setSleep(sleepInfo);
                }
            }
        }
    }

    private void g(Context context) {
        C0591m a = C0591m.a();
        DaySportData g = a.g(a.n());
        LuaEvent instance = LuaEvent.getInstance(context);
        if (g != null) {
            StepsInfo stepsInfo = g.getStepsInfo();
            if (stepsInfo != null) {
                ArrayList activeList = stepsInfo.getActiveList();
                C0596r.e("DynamicManager", "Dump ActiveList:");
                Iterator it = activeList.iterator();
                while (it.hasNext()) {
                    ActiveItem activeItem = (ActiveItem) it.next();
                    C0596r.e("DynamicManager", "ActiveItem:" + activeItem.toString());
                    C0596r.e("DynamicManager", "steps " + activeItem.steps + " startTime " + activeItem.start + " " + new Date((long) activeItem.start) + " runtime " + activeItem.activeTime);
                    if (activeItem.flag == 0) {
                        instance.setActivities(activeItem);
                    }
                }
            }
        }
    }

    public static DynamicManager getInstance() {
        if (f == null) {
            f = new DynamicManager();
        }
        return f;
    }

    private void h(Context context) {
        Object obj = 1;
        C0591m a = C0591m.a();
        DaySportData g = a.g(a.n());
        LuaEvent instance = LuaEvent.getInstance(context);
        if (g != null) {
            StepsInfo stepsInfo = g.getStepsInfo();
            if (stepsInfo != null) {
                int c;
                if (ChartData.a().x()) {
                    c = ChartData.a().c();
                    if (c <= 0) {
                        c = stepsInfo.getStepsCount();
                    }
                } else {
                    c = stepsInfo.getStepsCount();
                }
                PersonInfo readPersonInfo = Keeper.readPersonInfo();
                int daySportGoalSteps = readPersonInfo.getDaySportGoalSteps();
                C0596r.e("DynamicManager", "steps:" + c + ",goal:" + daySportGoalSteps);
                Calendar instance2 = Calendar.getInstance();
                if ((instance2.get(11) >= a ? 1 : null) != null || c >= daySportGoalSteps) {
                    instance.setGoal(c, daySportGoalSteps);
                } else {
                    instance.deleteGoalAchievedMsg();
                }
                if ((instance2.get(11) * 60) + instance2.get(12) < b) {
                    obj = null;
                }
                if (obj == null) {
                    c(context);
                } else if (readPersonInfo.getMiliConfig().getDailySportNofity().equals(C0401a.fG)) {
                    obj = Keeper.readDailySportReport();
                    if (TextUtils.isEmpty(obj) || !obj.equals(new SportDay().toString())) {
                        a(context, c, daySportGoalSteps);
                        Keeper.keepDailySportReport(new SportDay().toString());
                        i(context);
                    }
                }
            }
        }
    }

    private void i(Context context) {
        Calendar instance = Calendar.getInstance();
        instance.add(6, 1);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 1);
        ((AlarmManager) context.getSystemService(C0056bn.f)).set(0, instance.getTimeInMillis(), PendingIntent.getBroadcast(context, instance.hashCode(), new Intent(Constant.aY), 134217728));
    }

    private void j(Context context) {
        if (DeviceSource.hasBindBracelet()) {
            C0591m a = C0591m.a();
            DaySportData g = a.g(a.n());
            Calendar instance = Calendar.getInstance();
            if (g != null) {
                SleepInfo sleepInfo = g.getSleepInfo();
                if (sleepInfo != null) {
                    boolean hasSleep = sleepInfo.getHasSleep();
                    if (!hasSleep) {
                        C0596r.d("DynamicManager", "hasSleep = " + hasSleep);
                    } else if (sleepInfo.getStopDate() != null) {
                        Object obj = null;
                        int i = instance.get(12) + (instance.get(11) * 60);
                        if (i > C0591m.a().q() && i < c) {
                            obj = 1;
                        }
                        if (obj == null) {
                            return;
                        }
                        if (Keeper.readPersonInfo().getMiliConfig().getDailySleepNofity()) {
                            obj = Keeper.readLastNotifySleepDate();
                            if (TextUtils.isEmpty(obj) || !obj.equals(new SportDay().toString())) {
                                Keeper.setLastNotifySleepDate(new SportDay().toString());
                                a(context, f.a(context, sleepInfo.getSleepCount()));
                                return;
                            }
                            return;
                        }
                        d(context);
                    }
                }
            }
        }
    }

    public void a(Context context) {
        h(context);
        c(context, true);
    }

    public void a(Context context, int i) {
        LuaEvent.getInstance(context).updateWeatherTips(i);
    }

    public void a(Context context, LabFactoryActiveItem labFactoryActiveItem) {
        LuaEvent.getInstance(context).callLabFactoryActivities(labFactoryActiveItem);
    }

    public void analysisDynamic(Context context, boolean z) {
        a(context, z);
        b(context, z);
        f(context);
        h(context);
        g(context);
        e(context);
        c(context, z);
        j(context);
    }

    public void b(Context context) {
        f(context);
    }

    public void c(Context context) {
        ((NotificationManager) context.getSystemService("notification")).cancel(l.a);
    }

    public void d(Context context) {
        ((NotificationManager) context.getSystemService("notification")).cancel(16);
    }
}
