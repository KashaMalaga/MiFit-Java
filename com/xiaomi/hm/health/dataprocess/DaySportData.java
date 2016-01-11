package com.xiaomi.hm.health.dataprocess;

import android.support.v4.media.h;
import android.support.v7.widget.af;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.c.d;
import cn.com.smartdevices.bracelet.gps.services.ay;
import cn.com.smartdevices.bracelet.lab.sportmode.SportBaseInfo;
import cn.com.smartdevices.bracelet.shoes.sync.SyncShoesDataService;
import com.xiaomi.e.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DaySportData implements Serializable {
    public static final int DAY_SPORT_LEN = 1440;
    public static final ArrayList<SportData> INIT_INDEX_LIST = new ArrayList();
    public static final int RE_GOALS_NORMAL = 8000;
    private static final long serialVersionUID = 1;
    private ArrayList<SportData> analysisDatas;
    private ArrayList<SportData> datas;
    private ArrayList<SportIndex> indexs;
    private SleepInfo mSleepInfo;
    private StepsInfo mStepsInfo;
    private boolean needPostProcess;
    private boolean needSyncToLocal;
    private SportDay sDay;

    public interface Summary {
        int getDayStepGoal();

        int getSleep();

        int getSleepDeepTime();

        long getSleepRiseTime();

        int getSleepShallowTime();

        long getSleepStartTime();

        int getSleepWakeTime();

        int getStepCalories();

        int getStepDistance();

        int getStepDuration();

        int getStepRunCalories();

        int getStepRunDistance();

        int getStepRunDuration();

        int getStepWalkCalories();

        int getStepWalkDistance();

        int getStepWalkDuration();

        int getSteps();

        int getUserSleepEnd();

        int getUserSleepStart();

        boolean isEmpty();
    }

    public class SummaryEmpty implements Summary {
        public int getDayStepGoal() {
            return DaySportData.RE_GOALS_NORMAL;
        }

        public int getSleep() {
            return 0;
        }

        public int getSleepDeepTime() {
            return 0;
        }

        public long getSleepRiseTime() {
            return 0;
        }

        public int getSleepShallowTime() {
            return 0;
        }

        public long getSleepStartTime() {
            return 0;
        }

        public int getSleepWakeTime() {
            return 0;
        }

        public int getStepCalories() {
            return 0;
        }

        public int getStepDistance() {
            return 0;
        }

        public int getStepDuration() {
            return 0;
        }

        public int getStepRunCalories() {
            return 0;
        }

        public int getStepRunDistance() {
            return 0;
        }

        public int getStepRunDuration() {
            return 0;
        }

        public int getStepWalkCalories() {
            return 0;
        }

        public int getStepWalkDistance() {
            return 0;
        }

        public int getStepWalkDuration() {
            return 0;
        }

        public int getSteps() {
            return 0;
        }

        public int getUserSleepEnd() {
            return af.a;
        }

        public int getUserSleepStart() {
            return af.a;
        }

        public boolean isEmpty() {
            return true;
        }
    }

    public class SummaryEntity implements Summary {
        private int daySportGoal = DaySportData.RE_GOALS_NORMAL;
        private int sleep;
        private int sleepDeepTime;
        private long sleepRiseTime;
        private int sleepShallowTime;
        private long sleepStartTime;
        private int sleepWakeTime;
        private int stepCalories;
        private int stepDistance;
        private int stepDuration;
        private int stepRunCalories;
        private int stepRunDistance;
        private int stepRunDuration;
        private int stepWalkCalories;
        private int stepWalkDistance;
        private int stepWalkDuration;
        private int steps;
        private int userSleepEnd = af.a;
        private int userSleepStart = af.a;

        public int getDayStepGoal() {
            return this.daySportGoal;
        }

        public int getSleep() {
            return this.sleep;
        }

        public int getSleepDeepTime() {
            return this.sleepDeepTime;
        }

        public long getSleepRiseTime() {
            return this.sleepRiseTime;
        }

        public int getSleepShallowTime() {
            return this.sleepShallowTime;
        }

        public long getSleepStartTime() {
            return this.sleepStartTime;
        }

        public int getSleepWakeTime() {
            return this.sleepWakeTime;
        }

        public int getStepCalories() {
            return this.stepCalories;
        }

        public int getStepDistance() {
            return this.stepDistance;
        }

        public int getStepDuration() {
            return this.stepDuration;
        }

        public int getStepRunCalories() {
            return this.stepRunCalories;
        }

        public int getStepRunDistance() {
            return this.stepRunDistance;
        }

        public int getStepRunDuration() {
            return this.stepRunDuration;
        }

        public int getStepWalkCalories() {
            return this.stepWalkCalories;
        }

        public int getStepWalkDistance() {
            return this.stepWalkDistance;
        }

        public int getStepWalkDuration() {
            return this.stepWalkDuration;
        }

        public int getSteps() {
            return this.steps;
        }

        public int getUserSleepEnd() {
            return this.userSleepEnd;
        }

        public int getUserSleepStart() {
            return this.userSleepStart;
        }

        public boolean isEmpty() {
            return false;
        }

        public void setDayStepGoal(int i) {
            this.daySportGoal = i;
        }

        public void setSleep(int i) {
            this.sleep = i;
        }

        public void setSleepDeepTime(int i) {
            this.sleepDeepTime = i;
        }

        public void setSleepRiseTime(long j) {
            this.sleepRiseTime = j;
        }

        public void setSleepShallowTime(int i) {
            this.sleepShallowTime = i;
        }

        public void setSleepStartTime(long j) {
            this.sleepStartTime = j;
        }

        public void setSleepWakeTime(int i) {
            this.sleepWakeTime = i;
        }

        public void setStepCalories(int i) {
            this.stepCalories = i;
        }

        public void setStepDistance(int i) {
            this.stepDistance = i;
        }

        public void setStepDuration(int i) {
            this.stepDuration = i;
        }

        public void setStepRunCalories(int i) {
            this.stepRunCalories = i;
        }

        public void setStepRunDistance(int i) {
            this.stepRunDistance = i;
        }

        public void setStepRunDuration(int i) {
            this.stepRunDuration = i;
        }

        public void setStepWalkCalories(int i) {
            this.stepWalkCalories = i;
        }

        public void setStepWalkDistance(int i) {
            this.stepWalkDistance = i;
        }

        public void setStepWalkDuration(int i) {
            this.stepWalkDuration = i;
        }

        public void setSteps(int i) {
            this.steps = i;
        }

        public void setUserSleepEnd(int i) {
            this.userSleepEnd = i;
        }

        public void setUserSleepStart(int i) {
            this.userSleepStart = i;
        }

        public String toString() {
            return "Steps: " + this.steps + " , Sleep : " + this.sleep;
        }
    }

    static {
        for (int i = 0; i < DAY_SPORT_LEN; i++) {
            INIT_INDEX_LIST.add(new SportData(i, h.i, 0, 0));
        }
    }

    public DaySportData(int i, int i2, int i3) {
        this(new SportDay(i, i2, i3));
    }

    public DaySportData(SportDay sportDay) {
        this.sDay = null;
        this.datas = null;
        this.indexs = new ArrayList();
        this.needSyncToLocal = false;
        this.needPostProcess = true;
        this.mStepsInfo = null;
        this.mSleepInfo = null;
        this.analysisDatas = null;
        this.sDay = sportDay;
        this.datas = new ArrayList(INIT_INDEX_LIST);
    }

    public DaySportData(Calendar calendar) {
        this(new SportDay(calendar));
    }

    private void handleIndex(int i) {
        if (this.indexs.size() == 0) {
            this.indexs.add(new SportIndex(i, i));
            return;
        }
        SportIndex sportIndex = (SportIndex) this.indexs.get(this.indexs.size() - 1);
        if (sportIndex.stopIndex + 1 == i) {
            sportIndex.stopIndex = i;
            return;
        }
        this.indexs.add(new SportIndex(i, i));
    }

    public void add(SportData sportData) {
        int timeIndex = sportData.getTimeIndex();
        if (((SportData) this.datas.get(timeIndex)).getSportMode() == h.i) {
            this.datas.set(timeIndex, sportData);
            if (sportData.getSportMode() != h.i) {
                handleIndex(timeIndex);
            }
        }
    }

    public void add(SportData sportData, boolean z) {
        int step;
        C0596r.e("xxx", "sensorhub step:" + sportData.getStep());
        int timeIndex = sportData.getTimeIndex();
        if (z) {
            step = ((SportData) this.datas.get(timeIndex)).getStep();
            C0596r.e("xxx", "origin step:" + step);
            step += sportData.getStep();
        } else {
            step = sportData.getStep();
        }
        C0596r.e("xxx", "index:" + timeIndex + ",step:" + step + ",needMerge:" + z);
        int i = step > HeartRateInfo.HR_EMPTY_VALUE ? HeartRateInfo.HR_EMPTY_VALUE : step;
        step = 0;
        int i2 = timeIndex;
        int i3 = 0;
        while (i3 > 0) {
            int i4;
            i2 = step == 0 ? i2 - 1 : i2 + 1;
            if (i2 < 0) {
                i4 = timeIndex + 1;
                i2 = 1;
            } else {
                i4 = i2;
                i2 = step;
            }
            SportData sportData2 = (SportData) this.datas.get(i4);
            int step2 = sportData2.getStep() + i3;
            if (step2 > HeartRateInfo.HR_EMPTY_VALUE) {
                i3 = step2 - 255;
                step2 = HeartRateInfo.HR_EMPTY_VALUE;
            } else {
                i3 = 0;
            }
            C0596r.e("xxx", "merge to old index:" + i4 + ",old steps:" + sportData2.getStep() + ",current steps:" + step2);
            sportData2.setStep(step2);
            sportData2.setMode(sportData.getSportMode());
            sportData2.setActivity(sportData.getActivity());
            step = i2;
            i2 = i4;
        }
        this.datas.set(timeIndex, new SportData(timeIndex, sportData.getSportMode(), sportData.getActivity(), i));
        this.indexs.clear();
        this.indexs.add(new SportIndex(0, i2 > timeIndex ? i2 : timeIndex));
    }

    public ArrayList<SportData> data() {
        return this.datas;
    }

    public void fromBinaryData(SportDay sportDay, byte[] bArr) {
        int length = bArr.length;
        for (int i = 0; i < length; i += 3) {
            add(new SportData(i / 3, bArr[i] & HeartRateInfo.HR_EMPTY_VALUE, bArr[i + 1] & HeartRateInfo.HR_EMPTY_VALUE, bArr[i + 2] & HeartRateInfo.HR_EMPTY_VALUE));
        }
    }

    public void fromBinaryWithHRData(SportDay sportDay, byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        for (int i = 0; i < length; i += 3) {
            add(new SportData(i / 3, bArr[i] & HeartRateInfo.HR_EMPTY_VALUE, bArr[i + 1] & HeartRateInfo.HR_EMPTY_VALUE, bArr[i + 2] & HeartRateInfo.HR_EMPTY_VALUE, bArr2[i / 3] & HeartRateInfo.HR_EMPTY_VALUE));
        }
    }

    public ArrayList<SportData> getAnalysisData() {
        return this.analysisDatas;
    }

    public byte[] getBinaryData() {
        byte[] bArr = new byte[(this.datas.size() * 3)];
        for (int i = 0; i < this.datas.size(); i++) {
            SportData sportData = (SportData) this.datas.get(i);
            bArr[i * 3] = (byte) sportData.getSportMode();
            bArr[(i * 3) + 1] = (byte) sportData.getActivity();
            bArr[(i * 3) + 2] = (byte) sportData.getStep();
        }
        return bArr;
    }

    public byte[] getBinaryHRData(byte[] bArr) {
        byte[] bArr2 = new byte[this.datas.size()];
        if (bArr == null) {
            bArr = new byte[DAY_SPORT_LEN];
        }
        int size = this.datas.size();
        int i = 0;
        Object obj = null;
        while (i < size) {
            Object obj2;
            bArr2[i] = (byte) -2;
            SportData sportData = (SportData) this.datas.get(i);
            byte hr = sportData.getHR();
            if (bArr[i] != hr && HeartRateInfo.isHRValueValid(bArr[i])) {
                bArr2[i] = bArr[i];
                sportData.setHR(bArr[i]);
                obj2 = 1;
            } else if (HeartRateInfo.isValueGetByMeasurred(hr)) {
                bArr2[i] = (byte) hr;
                int i2 = 1;
            } else {
                obj2 = obj;
            }
            i++;
            obj = obj2;
        }
        return obj == null ? null : bArr2;
    }

    public int getDay() {
        return this.sDay.day;
    }

    public String getHRSummary(String str) {
        Object obj;
        JSONObject jSONObject;
        int i = 0;
        for (int i2 = 0; i2 < this.datas.size(); i2++) {
            if (HeartRateInfo.isHRValueValid(((SportData) this.datas.get(i2)).getHR())) {
                i++;
            }
        }
        if (str == null) {
            try {
                obj = a.f;
            } catch (JSONException e) {
                JSONException jSONException = e;
                jSONObject = null;
                JSONException jSONException2 = jSONException;
                jSONException2.printStackTrace();
                return jSONObject.toString();
            }
        }
        jSONObject = TextUtils.isEmpty(obj) ? new JSONObject() : new JSONObject(obj);
        try {
            jSONObject.put(ay.b, i);
            if (jSONObject.optJSONArray(SyncShoesDataService.d) == null) {
                jSONObject.put(SyncShoesDataService.d, new JSONArray());
            }
        } catch (JSONException e2) {
            jSONException2 = e2;
            jSONException2.printStackTrace();
            return jSONObject.toString();
        }
        return jSONObject.toString();
    }

    public String getIndexS() {
        JSONArray jSONArray = new JSONArray();
        Iterator it = this.indexs.iterator();
        while (it.hasNext()) {
            jSONArray.put(((SportIndex) it.next()).toJSONObject());
        }
        return jSONArray.toString();
    }

    public String getKey() {
        return this.sDay.getKey();
    }

    public int getMonth() {
        return this.sDay.mon;
    }

    public SleepInfo getSleepInfo() {
        return this.mSleepInfo;
    }

    public SportDay getSportDay() {
        return this.sDay;
    }

    public StepsInfo getStepsInfo() {
        return this.mStepsInfo;
    }

    public String getSummary(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SportBaseInfo.VERSION, 5);
            if (this.mSleepInfo != null) {
                jSONObject.put(SleepInfo.KEY_SLEEP_INFO, this.mSleepInfo.getSummaryJson());
            }
            if (this.mStepsInfo != null) {
                jSONObject.put(StepsInfo.KEY_STEP_INFO, this.mStepsInfo.getSummaryJson());
            }
            jSONObject.put(d.c, i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public long getTimestamp() {
        return this.sDay.getTimestamp();
    }

    public int getYear() {
        return this.sDay.year;
    }

    public boolean isLocalNeedSync() {
        return this.needSyncToLocal;
    }

    public boolean isNeedPostProcess() {
        return this.needPostProcess;
    }

    public void merge(DaySportData daySportData) {
        ArrayList arrayList = daySportData.datas;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            SportData sportData = (SportData) arrayList.get(i);
            if (!(sportData.getSportMode() == h.i || sportData.getSportMode() == h.j)) {
                add(sportData);
            }
        }
    }

    public void setAnalysisData(ArrayList<SportData> arrayList) {
        this.analysisDatas = arrayList;
    }

    public void setInfos(StepsInfo stepsInfo, SleepInfo sleepInfo, int i) {
        boolean z = true;
        this.mStepsInfo = stepsInfo;
        this.mSleepInfo = sleepInfo;
        if (i != 1) {
            z = false;
        }
        this.needPostProcess = z;
    }

    public void setLocalNeedSync(boolean z) {
        this.needSyncToLocal = z;
    }

    public void setNeedPostProcess(boolean z) {
        this.needPostProcess = z;
    }

    public void setNeedSync(boolean z) {
        this.needSyncToLocal = z;
    }

    public void setSleepInfo(SleepInfo sleepInfo) {
        this.mSleepInfo = sleepInfo;
    }

    public void setStepsInfo(StepsInfo stepsInfo) {
        this.mStepsInfo = stepsInfo;
    }
}
