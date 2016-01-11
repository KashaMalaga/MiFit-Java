package cn.com.smartdevices.bracelet.tencent.health.sync;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0591m;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.chart.C0420j;
import cn.com.smartdevices.bracelet.chart.C0422l;
import cn.com.smartdevices.bracelet.i.a.a;
import cn.com.smartdevices.bracelet.i.a.f;
import cn.com.smartdevices.bracelet.i.a.g;
import cn.com.smartdevices.bracelet.i.a.h;
import cn.com.smartdevices.bracelet.i.a.i;
import cn.com.smartdevices.bracelet.i.c;
import cn.com.smartdevices.bracelet.i.d;
import cn.com.smartdevices.bracelet.j.k;
import cn.com.smartdevices.bracelet.tencent.QQLogin;
import cn.com.smartdevices.bracelet.tencent.health.HealthSleep;
import cn.com.smartdevices.bracelet.tencent.health.HealthSleep.SleepDetail;
import cn.com.smartdevices.bracelet.tencent.health.HealthStep;
import cn.com.smartdevices.bracelet.tencent.health.QQHealth;
import cn.com.smartdevices.bracelet.ui.C0681ak;
import com.d.a.a.O;
import com.xiaomi.hm.health.dataprocess.DaySportData;
import com.xiaomi.hm.health.dataprocess.SleepInfo;
import com.xiaomi.hm.health.dataprocess.SportDay;
import com.xiaomi.hm.health.dataprocess.StepsInfo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import kankan.wheel.widget.l;

public class HealthSportSyncer extends d<SportDay> {
    private static final String TAG = "Syncer.Health.Sport";
    private Context mContext;
    private QQHealth mQQHealth;
    private QQLogin mQQLogin;

    public class SleepAccess extends a<SportDay, SleepInfo> {
        public SleepInfo access(SportDay sportDay) {
            C0591m a = C0591m.a();
            a.i(sportDay);
            DaySportData g = a.g(sportDay);
            if (g == null) {
                return null;
            }
            SleepInfo sleepInfo = g.getSleepInfo();
            sleepInfo.setSportDay(sportDay);
            return sleepInfo;
        }

        public boolean isEmpty(SleepInfo sleepInfo) {
            return sleepInfo == null || sleepInfo.getSleepCount() == 0;
        }
    }

    public class SleepWrap extends i<SleepInfo, HealthSleep> {
        private static ArrayList<SleepDetail> wrapSleepDetailInfoToHealth(int i, int i2, C0420j c0420j) {
            ArrayList<SleepDetail> arrayList = new ArrayList();
            int i3 = 0;
            int i4 = 0;
            for (C0422l c0422l : c0420j.c) {
                i4++;
                if ((i4 != 1 && i4 != c0420j.c.size()) || c0422l.e != 1) {
                    SleepDetail sleepDetail = new SleepDetail();
                    sleepDetail.setTime((i3 * 60) + i);
                    i3 += c0422l.g;
                    if (c0422l.e != 0) {
                        switch (c0422l.e) {
                            case l.a /*1*/:
                                sleepDetail.setState(1);
                                break;
                            case kankan.wheel.widget.a.k /*2*/:
                            case kankan.wheel.widget.a.aQ /*4*/:
                                sleepDetail.setState(2);
                                break;
                            case kankan.wheel.widget.a.l /*3*/:
                                sleepDetail.setState(3);
                                break;
                        }
                        arrayList.add(sleepDetail);
                    }
                }
            }
            SleepDetail sleepDetail2 = new SleepDetail();
            sleepDetail2.setTime(i2);
            sleepDetail2.setState(1);
            arrayList.add(sleepDetail2);
            return arrayList;
        }

        public HealthSleep wrap(SleepInfo sleepInfo) {
            HealthSleep healthSleep = new HealthSleep();
            healthSleep.setDay(sleepInfo.getSportDay());
            Date startDate = sleepInfo.getStartDate();
            int time = (int) (sleepInfo.getStopDate().getTime() / 1000);
            healthSleep.setStartTime((int) (startDate.getTime() / 1000));
            healthSleep.setEndTime(time);
            healthSleep.setTotalTime(sleepInfo.getSleepCount());
            healthSleep.setDeepTime(sleepInfo.getNonRemCount());
            healthSleep.setLightTime(sleepInfo.getRemCount());
            healthSleep.setAwakeTime(sleepInfo.getAwakeCount());
            healthSleep.setGoal(kankan.wheel.widget.a.ax);
            healthSleep.setDetails(wrapSleepDetailInfoToHealth(healthSleep.getStartTime(), healthSleep.getEndTime(), C0681ak.a(C0591m.a(), healthSleep.getDay(), 16)));
            return healthSleep;
        }
    }

    public class StepAccess extends a<SportDay, StepsInfo> {
        public StepsInfo access(SportDay sportDay) {
            C0591m a = C0591m.a();
            a.i(sportDay);
            DaySportData g = a.g(sportDay);
            if (g == null) {
                return null;
            }
            StepsInfo stepsInfo = g.getStepsInfo();
            stepsInfo.setSportDay(sportDay);
            return stepsInfo;
        }

        public boolean isEmpty(StepsInfo stepsInfo) {
            return stepsInfo == null || stepsInfo.getStepsCount() == 0;
        }
    }

    public class StepWrap extends i<StepsInfo, HealthStep> {
        public HealthStep wrap(StepsInfo stepsInfo) {
            long currentTimeMillis;
            HealthStep healthStep = new HealthStep();
            SportDay sportDay = stepsInfo.getSportDay();
            if (sportDay.equals(new SportDay())) {
                currentTimeMillis = System.currentTimeMillis();
            } else {
                Calendar calendar = sportDay.getCalendar();
                calendar.set(11, 23);
                calendar.set(12, 59);
                calendar.set(13, 59);
                currentTimeMillis = calendar.getTimeInMillis();
            }
            healthStep.setTime((int) (currentTimeMillis / 1000));
            healthStep.setSteps(stepsInfo.getStepsCount());
            healthStep.setDistance(stepsInfo.getDistance());
            healthStep.setCalories(stepsInfo.getCalories());
            healthStep.setDuration(stepsInfo.getActMinutes() * 60);
            int daySportGoalSteps = Keeper.readPersonInfoBaseConfig().getDaySportGoalSteps();
            healthStep.setAchieve((stepsInfo.getStepsCount() * 100) / daySportGoalSteps);
            healthStep.setTarget(daySportGoalSteps);
            return healthStep;
        }
    }

    public HealthSportSyncer(Context context, SportDay sportDay) {
        super(sportDay);
        this.mContext = context;
        this.mQQHealth = QQHealth.getInstance(context);
        this.mQQLogin = QQLogin.getInstance(context);
    }

    public String tag() {
        return "Syncer.Health.Sport_@" + Integer.toHexString(hashCode());
    }

    public void work() {
        C0596r.e(tag(), "Sync Start!!");
        try {
            cn.com.smartdevices.bracelet.i.b.a aVar = new cn.com.smartdevices.bracelet.i.b.a(this.mWorkParams);
            a stepAccess = new StepAccess();
            a sleepAccess = new SleepAccess();
            i stepWrap = new StepWrap();
            i sleepWrap = new SleepWrap();
            i healthDataWrap = new HealthDataWrap(this.mQQLogin.getOAuthInfo());
            g aVar2 = new cn.com.smartdevices.bracelet.i.a.a.a(k.a("URL_POST_STEPS"));
            g aVar3 = new cn.com.smartdevices.bracelet.i.a.a.a(k.a("URL_POST_SLEEP"));
            h healthTransportCheck = new HealthTransportCheck();
            f anonymousClass1 = new f() {
                public void then(c cVar) {
                    if (cVar.j() && cVar.l().a() == 17) {
                        C0596r.e(HealthSportSyncer.this.tag(), "Access Then...No Data");
                        HealthSportSyncer.this.mQQHealth.removeNeedSyncDay((SportDay) HealthSportSyncer.this.mWorkParams);
                    }
                }
            };
            cn.com.smartdevices.bracelet.i.a.c anonymousClass2 = new cn.com.smartdevices.bracelet.i.a.c() {
                public void before() {
                    if (HealthSportSyncer.this.mQQLogin == null || !HealthSportSyncer.this.mQQLogin.isLoginValid()) {
                        throw new cn.com.smartdevices.bracelet.i.a(4, "QQ Login is invalid!!");
                    }
                    C0596r.e(HealthSportSyncer.this.tag(), "Send Before...");
                    C0401a.a(HealthSportSyncer.this.mContext, C0401a.fd);
                }
            };
            cn.com.smartdevices.bracelet.i.a.c anonymousClass3 = new cn.com.smartdevices.bracelet.i.a.c() {
                public void before() {
                    String o = ((O) this.mArg).toString();
                    if ((((SportDay) HealthSportSyncer.this.mWorkParams).toString() + "_" + o).equals(HealthSportSyncer.this.mQQHealth.readSyncedSleepData())) {
                        throw new cn.com.smartdevices.bracelet.i.a(4, "Already Post Sleep : \nParams : " + o);
                    }
                }
            };
            f anonymousClass4 = new f() {
                public void then(c cVar) {
                    if (cVar.j()) {
                        C0596r.e(HealthSportSyncer.this.tag(), "Send Then...Exception");
                        HealthSportSyncer.this.mQQHealth.addNeedSyncDay((SportDay) HealthSportSyncer.this.mWorkParams);
                    }
                }
            };
            f anonymousClass5 = new f() {
                public void then(c cVar) {
                    if (cVar.h()) {
                        C0596r.e(HealthSportSyncer.this.tag(), "Check Then...Success");
                        HealthSportSyncer.this.mQQHealth.removeNeedSyncDay((SportDay) HealthSportSyncer.this.mWorkParams);
                        C0401a.a(HealthSportSyncer.this.mContext, C0401a.fe);
                    } else if (cVar.i()) {
                        C0596r.e(HealthSportSyncer.this.tag(), "Check Then...Failure");
                        HealthSportSyncer.this.mQQHealth.addNeedSyncDay((SportDay) HealthSportSyncer.this.mWorkParams);
                        HealthTransportCheck.checkRelogin(HealthSportSyncer.this.tag(), cVar.m(), HealthSportSyncer.this.mQQLogin);
                        C0401a.a(HealthSportSyncer.this.mContext, C0401a.ff, cVar.n());
                    }
                }
            };
            f anonymousClass6 = new f() {
                public void then(c cVar) {
                    if (cVar.h()) {
                        C0596r.e(HealthSportSyncer.this.tag(), "Check Then...Sleep Success");
                        HealthSportSyncer.this.mQQHealth.saveSyncedSleepData((SportDay) HealthSportSyncer.this.mWorkParams, ((O) this.mArg).toString());
                    }
                }
            };
            aVar.a((d) this, stepAccess).a(anonymousClass1).a((d) this, stepWrap).a((d) this, healthDataWrap).a(anonymousClass2).a((d) this, aVar2).a(anonymousClass4).a((d) this, healthTransportCheck).a(anonymousClass5);
            aVar = aVar.a((d) this, sleepAccess).a(anonymousClass1).a((d) this, sleepWrap).a((d) this, healthDataWrap);
            aVar.a(aVar.a(), anonymousClass3).a(anonymousClass2).a((d) this, aVar3).a(anonymousClass4).a((d) this, healthTransportCheck).a(anonymousClass5).a(aVar.a(), anonymousClass6);
        } catch (Throwable e) {
            C0596r.a(tag(), "Sync Exception!!", e);
        }
        C0596r.e(tag(), "Sync Finish!!");
    }
}
