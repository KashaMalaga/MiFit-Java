package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.chart.util.a;
import cn.com.smartdevices.bracelet.tencent.health.HealthSleep;
import cn.com.smartdevices.bracelet.tencent.health.HealthSleep.SleepDetail;
import cn.com.smartdevices.bracelet.tencent.health.HealthStep;
import com.d.a.a.C1012a;
import com.huami.android.view.b;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.xiaomi.account.openauth.h;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.dataprocess.SportDay;
import java.util.ArrayList;
import java.util.List;

class C implements IUiListener {
    final /* synthetic */ BindQQHealthActivity a;

    C(BindQQHealthActivity bindQQHealthActivity) {
        this.a = bindQQHealthActivity;
    }

    private void a() {
        HealthStep healthStep = new HealthStep();
        healthStep.setTime((int) (System.currentTimeMillis() / 1000));
        healthStep.setSteps(h.E);
        healthStep.setDistance(100);
        healthStep.setCalories(20);
        healthStep.setDuration(a.b);
        healthStep.setAchieve(10);
        healthStep.setTarget(C1012a.b);
    }

    private void b() {
        HealthSleep healthSleep = new HealthSleep();
        healthSleep.setStartTime((int) (System.currentTimeMillis() / 1000));
        healthSleep.setEndTime((int) (((double) (System.currentTimeMillis() / 1000)) + 23400.0d));
        healthSleep.setTotalTime(330);
        healthSleep.setDeepTime(cn.com.smartdevices.bracelet.gps.c.a.i);
        healthSleep.setLightTime(kankan.wheel.widget.a.ap);
        healthSleep.setAwakeTime(60);
        healthSleep.setGoal(390);
        ArrayList arrayList = new ArrayList();
        SleepDetail sleepDetail = new SleepDetail();
        sleepDetail.setTime(healthSleep.getStartTime());
        sleepDetail.setState(3);
        arrayList.add(sleepDetail);
        sleepDetail = new SleepDetail();
        sleepDetail.setTime(healthSleep.getStartTime() + 3600);
        sleepDetail.setState(2);
        arrayList.add(sleepDetail);
        sleepDetail = new SleepDetail();
        sleepDetail.setTime(healthSleep.getStartTime() + 7200);
        sleepDetail.setState(3);
        arrayList.add(sleepDetail);
        sleepDetail = new SleepDetail();
        sleepDetail.setTime(healthSleep.getStartTime() + 14400);
        sleepDetail.setState(2);
        arrayList.add(sleepDetail);
        sleepDetail = new SleepDetail();
        sleepDetail.setTime(healthSleep.getStartTime() + 18000);
        sleepDetail.setState(1);
        arrayList.add(sleepDetail);
        sleepDetail = new SleepDetail();
        sleepDetail.setTime(healthSleep.getStartTime() + 21600);
        sleepDetail.setState(2);
        arrayList.add(sleepDetail);
        healthSleep.setDetails(arrayList);
    }

    public void onCancel() {
        this.a.a.setNeedLogin(false);
        this.a.a.setNeedSwitchLogin(false);
        this.a.a.setLoginCanceled(true);
        this.a.a.clean(true);
        this.a.b.clean(true);
        this.a.a(this.a.f, this.a.g);
        b.a(this.a, (int) R.string.state_bind_failed, 0).show();
    }

    public void onComplete(Object obj) {
        int i = 0;
        if (this.a.a.isLoginValid()) {
            b.a(this.a, (int) R.string.state_binded, 0).show();
            this.a.a.saveOAuthInfo();
            this.a.a.setNeedLogin(false);
            this.a.a.setNeedSwitchLogin(false);
            this.a.a.requestUserInfo();
            List arrayList = new ArrayList();
            SportDay sportDay = new SportDay();
            while (i < 7) {
                arrayList.add(sportDay.addDay(-i));
                i++;
            }
            this.a.b.addNeedSyncDays(arrayList);
            this.a.b.syncDataAsync();
            this.a.a(this.a.f, this.a.g);
            this.a.finish();
            return;
        }
        b.a(this.a, (int) R.string.state_bind_failed, 0).show();
    }

    public void onError(UiError uiError) {
        this.a.a.setNeedLogin(false);
        this.a.a.setNeedSwitchLogin(false);
        this.a.a.setLoginCanceled(true);
        this.a.a(this.a.f, this.a.g);
        b.a(this.a, (int) R.string.state_bind_failed, 0).show();
    }
}
