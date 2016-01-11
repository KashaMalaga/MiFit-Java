package cn.com.smartdevices.bracelet.tencent.health;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.text.format.DateFormat;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0591m;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.chart.C0420j;
import cn.com.smartdevices.bracelet.chart.C0422l;
import cn.com.smartdevices.bracelet.datasource.a;
import cn.com.smartdevices.bracelet.j.d;
import cn.com.smartdevices.bracelet.j.k;
import cn.com.smartdevices.bracelet.tencent.QQLogin;
import cn.com.smartdevices.bracelet.tencent.health.HealthSleep.SleepDetail;
import cn.com.smartdevices.bracelet.tencent.health.sync.HealthSportSyncer;
import cn.com.smartdevices.bracelet.ui.C0681ak;
import cn.com.smartdevices.bracelet.weight.J;
import cn.com.smartdevices.bracelet.weight.UserInfo;
import cn.com.smartdevices.bracelet.weight.WeightInfo;
import cn.com.smartdevices.bracelet.weight.aA;
import cn.com.smartdevices.bracelet.weight.ah;
import com.d.a.a.O;
import com.d.a.a.h;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.Tencent;
import com.xiaomi.hm.health.dataprocess.DaySportData;
import com.xiaomi.hm.health.dataprocess.SleepInfo;
import com.xiaomi.hm.health.dataprocess.SportDay;
import com.xiaomi.hm.health.dataprocess.StepsInfo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kankan.wheel.widget.l;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

public class QQHealth {
    private static final String KEY_HAVE_SYNCED_SLEEP_DATA = "HaveSyncedSleepData";
    private static final String KEY_NEED_SYNC_DAYS = "NeedSyncDays";
    private static final String KEY_NEED_SYNC_WEIGHTS = "NeedSyncWeights";
    private static final String TAG = "QQ.Health";
    private static QQHealth sHealth;
    private Context mContext;
    private String mMiID;
    private List<SportDay> mNeedSyncDays;
    private List<Long> mNeedSyncWeights;
    private SharedPreferences mPrefs;
    private QQLogin mQQLogin = QQLogin.getInstance(this.mContext);

    class SyncDataTask extends AsyncTask<SportDay, Void, Void> {
        private SyncDataTask() {
        }

        protected Void doInBackground(SportDay... sportDayArr) {
            for (SportDay healthSportSyncer : sportDayArr) {
                new HealthSportSyncer(QQHealth.this.mContext, healthSportSyncer).work();
            }
            return null;
        }
    }

    private QQHealth(Context context) {
        this.mContext = context;
        this.mPrefs = context.getSharedPreferences(TAG, 0);
        this.mNeedSyncDays = new ArrayList();
        this.mNeedSyncDays.addAll(readNeedSyncDays());
        this.mNeedSyncWeights = new ArrayList();
        this.mNeedSyncWeights.addAll(readNeedSyncWeights());
    }

    private boolean checkPostResult(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            int optInt = new JSONObject(str).optInt(QQLogin.KEY_RESULT, -1);
            if (optInt == 0) {
                C0401a.a(this.mContext, C0401a.fe);
                return true;
            }
            if (optInt == -73) {
                C0596r.g(TAG, "Login is invalid : " + optInt);
                Tencent tencent = this.mQQLogin.getTencent();
                tencent.setAccessToken(tencent.getAccessToken(), Constants.VIA_RESULT_SUCCESS);
                this.mQQLogin.saveOAuthInfo();
            }
            C0401a.a(this.mContext, C0401a.ff, str);
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            C0401a.a(this.mContext, e);
            return false;
        }
    }

    private void cleanNeedSyncMarks() {
        this.mNeedSyncDays.clear();
        saveNeedSyncDays(this.mNeedSyncDays);
        this.mNeedSyncWeights.clear();
        saveNeedSyncWeights(this.mNeedSyncWeights);
    }

    public static QQHealth getInstance() {
        return sHealth;
    }

    public static QQHealth getInstance(Context context) {
        if (sHealth == null) {
            sHealth = new QQHealth(context);
        }
        if (TextUtils.isEmpty(sHealth.mMiID)) {
            sHealth.mMiID = QQLogin.fetchMiID();
        }
        return sHealth;
    }

    private List<SportDay> readNeedSyncDays() {
        String string = this.mPrefs.getString(KEY_NEED_SYNC_DAYS + this.mMiID, null);
        if (string == null) {
            string = this.mPrefs.getString(KEY_NEED_SYNC_DAYS, null);
        }
        C0596r.e(TAG, "Days Json : " + string);
        List<SportDay> arrayList = new ArrayList();
        if (string != null) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(SportDay.fromString(jSONArray.getString(i)));
                }
            } catch (Exception e) {
                e.printStackTrace();
                C0401a.a(this.mContext, e);
            }
        }
        C0596r.e(TAG, "Read Need Sync Days : " + arrayList);
        return arrayList;
    }

    private List<Long> readNeedSyncWeights() {
        String string = this.mPrefs.getString(KEY_NEED_SYNC_WEIGHTS + this.mMiID, null);
        C0596r.e(TAG, "Weights Json : " + string);
        List<Long> arrayList = new ArrayList();
        if (string != null) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(Long.valueOf(jSONArray.getLong(i)));
                }
            } catch (Exception e) {
                e.printStackTrace();
                C0401a.a(this.mContext, e);
            }
        }
        C0596r.e(TAG, "Read Need Sync Weights : " + arrayList);
        return arrayList;
    }

    private void saveNeedSyncDays(List<SportDay> list) {
        if (list != null) {
            C0596r.e(TAG, "Save Need Sync Days : " + list);
            Editor edit = this.mPrefs.edit();
            if (list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (SportDay sportDay : list) {
                    jSONArray.put(sportDay.toString());
                }
                C0596r.e(TAG, "Days Json : " + jSONArray.toString());
                edit.putString(KEY_NEED_SYNC_DAYS + this.mMiID, jSONArray.toString());
            } else {
                edit.remove(KEY_NEED_SYNC_DAYS + this.mMiID);
                edit.remove(KEY_NEED_SYNC_DAYS);
            }
            edit.commit();
        }
    }

    private void saveNeedSyncWeights(List<Long> list) {
        if (list != null) {
            C0596r.e(TAG, "Save Need Sync Weights : " + list);
            Editor edit = this.mPrefs.edit();
            if (list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (Long put : list) {
                    jSONArray.put(put);
                }
                C0596r.e(TAG, "Weights Json : " + jSONArray.toString());
                edit.putString(KEY_NEED_SYNC_WEIGHTS + this.mMiID, jSONArray.toString());
            } else {
                edit.remove(KEY_NEED_SYNC_WEIGHTS + this.mMiID);
            }
            edit.commit();
        }
    }

    private void syncData(SportDay sportDay) {
        SleepInfo sleepInfo = null;
        if (sportDay != null) {
            StepsInfo stepsInfo;
            C0596r.e(TAG, "Sync Sport Info To QQ : " + sportDay);
            a a = C0591m.a();
            a.i(sportDay);
            DaySportData g = a.g(sportDay);
            if (g != null) {
                stepsInfo = g.getStepsInfo();
                sleepInfo = g.getSleepInfo();
            } else {
                removeNeedSyncDay(sportDay);
                stepsInfo = null;
            }
            if (stepsInfo != null && stepsInfo.getStepsCount() > 0) {
                HealthStep wrapStepInfoToHealth = wrapStepInfoToHealth(sportDay, stepsInfo);
                if (wrapStepInfoToHealth != null) {
                    C0596r.e(TAG, "Sync Step Data To QQ Health!!");
                    postStep(sportDay, wrapStepInfoToHealth);
                }
            }
            if (sleepInfo != null && sleepInfo.getSleepCount() > 0) {
                HealthSleep wrapSleepInfoToHealth = wrapSleepInfoToHealth(sleepInfo);
                wrapSleepInfoToHealth.setDetails(wrapSleepDetailInfoToHealth(wrapSleepInfoToHealth.getStartTime(), C0681ak.a(a, sportDay, 16)));
                if (wrapSleepInfoToHealth != null) {
                    C0596r.e(TAG, "Sync Sleep Data To QQ Health!!");
                    postSleep(sportDay, wrapSleepInfoToHealth);
                }
            }
        }
    }

    private void syncDataWeight(Long l) {
        if (l != null) {
            C0596r.e(TAG, "Sync Weight : " + DateFormat.format("yyyy-MM-dd HH:mm:ss", l.longValue()));
            WeightInfo b = ah.a().b(l.longValue());
            if (b != null) {
                HealthWeight wrapWeightInfoToHealth = wrapWeightInfoToHealth(b);
                if (wrapWeightInfoToHealth != null) {
                    postWeight(wrapWeightInfoToHealth);
                }
            }
        }
    }

    private void syncDataWeight(List<Long> list) {
        if (list != null && list.size() > 0) {
            C0596r.e(TAG, "Sync Weights : " + list);
            for (Long syncDataWeight : list) {
                syncDataWeight(syncDataWeight);
            }
        }
    }

    public static ArrayList<SleepDetail> wrapSleepDetailInfoToHealth(int i, C0420j c0420j) {
        ArrayList<SleepDetail> arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        for (C0422l c0422l : c0420j.c) {
            i3++;
            if (!(((i3 == 1 || i3 == c0420j.c.size()) && c0422l.e == 1) || c0422l.e == 0)) {
                SleepDetail sleepDetail = new SleepDetail();
                sleepDetail.setTime((i2 * 60) + i);
                i2 += c0422l.g;
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
        return arrayList;
    }

    private HealthSleep wrapSleepInfoToHealth(SleepInfo sleepInfo) {
        HealthSleep healthSleep = new HealthSleep();
        try {
            Date startDate = sleepInfo.getStartDate();
            int time = (int) (sleepInfo.getStopDate().getTime() / 1000);
            healthSleep.setStartTime((int) (startDate.getTime() / 1000));
            healthSleep.setEndTime(time);
            healthSleep.setTotalTime(sleepInfo.getSleepCount());
            healthSleep.setDeepTime(sleepInfo.getNonRemCount());
            healthSleep.setLightTime(sleepInfo.getRemCount());
            healthSleep.setAwakeTime(sleepInfo.getAwakeCount());
            healthSleep.setGoal(kankan.wheel.widget.a.ax);
            return healthSleep;
        } catch (Exception e) {
            Exception exception = e;
            exception.printStackTrace();
            C0401a.a(this.mContext, exception);
            return null;
        }
    }

    private HealthStep wrapStepInfoToHealth(SportDay sportDay, StepsInfo stepsInfo) {
        HealthStep healthStep = new HealthStep();
        try {
            long currentTimeMillis;
            if (sportDay.equals(Calendar.getInstance())) {
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
        } catch (Exception e) {
            Exception exception = e;
            exception.printStackTrace();
            C0401a.a(this.mContext, exception);
            return null;
        }
    }

    private HealthWeight wrapWeightInfoToHealth(WeightInfo weightInfo) {
        HealthWeight healthWeight = new HealthWeight();
        try {
            healthWeight.setTime((int) (weightInfo.timestamp / 1000));
            healthWeight.setWeight(weightInfo.weight);
            UserInfo a = J.a().a(weightInfo.uid);
            healthWeight.setBmi(aA.a(a, weightInfo.weight));
            healthWeight.setWeightTarget(a.targetWeight);
            return healthWeight;
        } catch (Exception e) {
            Exception exception = e;
            exception.printStackTrace();
            C0401a.a(this.mContext, exception);
            return null;
        }
    }

    public void addNeedSyncDay(SportDay sportDay) {
        for (SportDay equals : this.mNeedSyncDays) {
            if (sportDay.equals(equals)) {
                Object obj = null;
                break;
            }
        }
        if (obj != null) {
            C0596r.e(TAG, "Add Need Sync Day : " + obj);
            this.mNeedSyncDays.add(obj);
            saveNeedSyncDays(this.mNeedSyncDays);
        }
    }

    public void addNeedSyncDays(List<SportDay> list) {
        for (SportDay sportDay : list) {
            for (SportDay equals : this.mNeedSyncDays) {
                if (sportDay.equals(equals)) {
                    break;
                }
            }
            C0596r.e(TAG, "Add Need Sync Day : " + sportDay);
            this.mNeedSyncDays.add(sportDay);
        }
        saveNeedSyncDays(this.mNeedSyncDays);
    }

    public void addNeedSyncWeight(Long l) {
        if (l != null && !this.mNeedSyncWeights.contains(l)) {
            C0596r.e(TAG, "Add Need Sync Weight : " + l);
            this.mNeedSyncWeights.add(l);
            saveNeedSyncWeights(this.mNeedSyncWeights);
        }
    }

    public void addNeedSyncWeights(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long l : list) {
                if (!this.mNeedSyncWeights.contains(l)) {
                    C0596r.e(TAG, "Add Need Sync Weight : " + l);
                    this.mNeedSyncWeights.add(l);
                }
            }
            saveNeedSyncWeights(this.mNeedSyncWeights);
        }
    }

    public void clean(boolean z) {
        if (z) {
            cleanNeedSyncMarks();
            Editor edit = this.mPrefs.edit();
            edit.remove(KEY_NEED_SYNC_DAYS + this.mMiID);
            edit.remove(KEY_HAVE_SYNCED_SLEEP_DATA + this.mMiID);
            edit.remove(KEY_NEED_SYNC_WEIGHTS + this.mMiID);
            edit.remove(KEY_NEED_SYNC_DAYS);
            edit.remove(KEY_HAVE_SYNCED_SLEEP_DATA);
            edit.commit();
            return;
        }
        sHealth = null;
    }

    public void postSleep(final SportDay sportDay, HealthSleep healthSleep) {
        if (this.mQQLogin == null || !this.mQQLogin.isLoginValid()) {
            C0596r.g(TAG, "Login is invalid!!");
            return;
        }
        String a = k.a("URL_POST_SLEEP");
        Map oAuthInfo = this.mQQLogin.getOAuthInfo();
        oAuthInfo.putAll(healthSleep.toMap());
        O o = new O(oAuthInfo);
        final String o2 = o.toString();
        if ((sportDay.toString() + "_" + o2).equals(readSyncedSleepData())) {
            C0596r.e(TAG, "Already Post Sleep : " + a + "\nParams : " + o);
            return;
        }
        C0596r.e(TAG, "Post Sleep : " + a + "\nParams : " + o);
        C0401a.a(this.mContext, C0401a.fd);
        cn.com.smartdevices.bracelet.j.a.b(d.b, a, o, new h() {
            public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                QQHealth.this.addNeedSyncDay(sportDay);
                C0596r.b(QQHealth.TAG, "Post Sleep Failed!!", th);
                if (bArr != null) {
                    C0596r.e(QQHealth.TAG, "Respone : " + new String(bArr));
                }
            }

            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                if (bArr != null) {
                    C0596r.e(QQHealth.TAG, "Post Sleep Successed!!");
                    String str = new String(bArr);
                    C0596r.e(QQHealth.TAG, "Respone : " + str);
                    if (QQHealth.this.checkPostResult(str)) {
                        QQHealth.this.removeNeedSyncDay(sportDay);
                        QQHealth.this.saveSyncedSleepData(sportDay, o2);
                    }
                }
            }
        });
    }

    public void postStep(final SportDay sportDay, HealthStep healthStep) {
        if (this.mQQLogin == null || !this.mQQLogin.isLoginValid()) {
            C0596r.g(TAG, "Login is invalid!!");
            return;
        }
        String a = k.a("URL_POST_STEPS");
        Map oAuthInfo = this.mQQLogin.getOAuthInfo();
        oAuthInfo.putAll(healthStep.toMap());
        O o = new O(oAuthInfo);
        C0596r.e(TAG, "Post Step : " + a + "\nParams : " + o);
        C0401a.a(this.mContext, C0401a.fd);
        cn.com.smartdevices.bracelet.j.a.b(d.b, a, o, new h() {
            public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                QQHealth.this.addNeedSyncDay(sportDay);
                C0596r.b(QQHealth.TAG, "Post Step Failed!!", th);
                if (bArr != null) {
                    C0596r.e(QQHealth.TAG, "Respone : " + new String(bArr));
                }
            }

            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                C0596r.e(QQHealth.TAG, "Post Step Successed!!");
                if (bArr != null) {
                    String str = new String(bArr);
                    C0596r.e(QQHealth.TAG, "Respone : " + str);
                    if (QQHealth.this.checkPostResult(str)) {
                        QQHealth.this.removeNeedSyncDay(sportDay);
                    }
                }
            }
        });
    }

    public void postWeight(final HealthWeight healthWeight) {
        if (this.mQQLogin == null || !this.mQQLogin.isLoginValid()) {
            C0596r.g(TAG, "Login is invalid!!");
            return;
        }
        String a = k.a("URL_POST_WEIGHT");
        Map oAuthInfo = this.mQQLogin.getOAuthInfo();
        oAuthInfo.putAll(healthWeight.toMap());
        O o = new O(oAuthInfo);
        C0596r.e(TAG, "Post Weight : " + a + "\nParams : " + o);
        C0401a.a(this.mContext, C0401a.fd);
        cn.com.smartdevices.bracelet.j.a.b(d.b, a, o, new h() {
            public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                QQHealth.this.addNeedSyncWeight(Long.valueOf(((long) healthWeight.getTime()) * 1000));
                C0596r.b(QQHealth.TAG, "Post Weight Failed!!", th);
                if (bArr != null) {
                    C0596r.e(QQHealth.TAG, "Respone : " + new String(bArr));
                }
            }

            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                if (bArr != null) {
                    C0596r.e(QQHealth.TAG, "Post Weight Successed!!");
                    String str = new String(bArr);
                    C0596r.e(QQHealth.TAG, "Respone : " + str);
                    if (QQHealth.this.checkPostResult(str)) {
                        QQHealth.this.removeNeedSyncWeight(Long.valueOf(((long) healthWeight.getTime()) * 1000));
                    }
                }
            }
        });
    }

    public String readSyncedSleepData() {
        return this.mPrefs.getString(KEY_HAVE_SYNCED_SLEEP_DATA + this.mMiID, null);
    }

    public void removeNeedSyncDay(SportDay sportDay) {
        for (SportDay equals : this.mNeedSyncDays) {
            if (sportDay.equals(equals)) {
                break;
            }
        }
        Object obj = null;
        if (obj != null) {
            C0596r.e(TAG, "Remove Need Sync Day : " + obj);
            this.mNeedSyncDays.remove(obj);
            saveNeedSyncDays(this.mNeedSyncDays);
        }
    }

    public void removeNeedSyncWeight(Long l) {
        if (l != null) {
            C0596r.e(TAG, "Remove Need Sync Weight : " + l);
            if (this.mNeedSyncWeights.remove(l)) {
                saveNeedSyncWeights(this.mNeedSyncWeights);
            }
        }
    }

    public void removeNeedSyncWeights(List<Long> list) {
        if (list != null && list.size() > 0) {
            C0596r.e(TAG, "Remove Need Sync Weights : " + list);
            if (this.mNeedSyncWeights.removeAll(list)) {
                saveNeedSyncWeights(this.mNeedSyncWeights);
            }
        }
    }

    public void saveSyncedSleepData(SportDay sportDay, String str) {
        Editor edit = this.mPrefs.edit();
        edit.putString(KEY_HAVE_SYNCED_SLEEP_DATA + this.mMiID, sportDay.toString() + "_" + str);
        edit.commit();
    }

    public void syncDataAsync() {
        syncDataAsync(this.mNeedSyncDays);
    }

    public void syncDataAsync(SportDay sportDay) {
        if (this.mQQLogin == null || !this.mQQLogin.isLoginValid()) {
            C0596r.g(TAG, "Login is invalid!!");
            return;
        }
        new SyncDataTask().execute(new SportDay[]{sportDay});
    }

    public void syncDataAsync(List<SportDay> list) {
        if (this.mQQLogin == null || !this.mQQLogin.isLoginValid()) {
            C0596r.g(TAG, "Login is invalid!!");
        } else if (list != null && list.size() > 0) {
            SportDay[] sportDayArr = new SportDay[list.size()];
            for (int i = 0; i < list.size(); i++) {
                sportDayArr[i] = (SportDay) list.get(i);
            }
            new SyncDataTask().execute(sportDayArr);
        }
    }

    public void syncDataWeight() {
        List arrayList = new ArrayList(this.mNeedSyncWeights);
        Collections.sort(arrayList);
        syncDataWeight(arrayList);
    }
}
