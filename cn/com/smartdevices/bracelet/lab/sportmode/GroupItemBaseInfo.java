package cn.com.smartdevices.bracelet.lab.sportmode;

import cn.com.smartdevices.bracelet.C0596r;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;

public class GroupItemBaseInfo {
    public static final String KEY_COUNT = "c";
    public static final String KEY_END_TIME = "e";
    public static final String KEY_START_TIME = "s";
    protected int mCount = 0;
    protected long mEndSecondTimeInDay = 0;
    private long mSportDayStartMilis = 0;
    protected int mSportType = -1;
    protected long mStartSecondTimeInDay = 0;

    public GroupItemBaseInfo(int i) {
        this.mSportType = i;
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        this.mSportDayStartMilis = instance.getTimeInMillis();
        this.mStartSecondTimeInDay = getSecondInDay(System.currentTimeMillis());
        this.mEndSecondTimeInDay = this.mStartSecondTimeInDay;
    }

    public GroupItemBaseInfo(long j, long j2, int i) {
        this.mSportType = i;
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        this.mSportDayStartMilis = instance.getTimeInMillis();
        this.mStartSecondTimeInDay = getSecondInDay(j);
        this.mEndSecondTimeInDay = getSecondInDay(j2);
    }

    private long getSecondInDay(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        long timeInMillis = (instance.getTimeInMillis() - this.mSportDayStartMilis) / 1000;
        return (instance.getTimeInMillis() - this.mSportDayStartMilis) % 1000 >= 500 ? timeInMillis + 1 : timeInMillis;
    }

    public long getCostTime() {
        return this.mEndSecondTimeInDay - this.mStartSecondTimeInDay;
    }

    public int getCount() {
        return this.mCount;
    }

    public long getEndTime() {
        return this.mEndSecondTimeInDay;
    }

    public JSONObject getJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_START_TIME, this.mStartSecondTimeInDay);
            jSONObject.put(KEY_END_TIME, this.mEndSecondTimeInDay);
            jSONObject.put(KEY_COUNT, this.mCount);
        } catch (JSONException e) {
            C0596r.a("GroupBaseInfo", e.getMessage());
        }
        return jSONObject;
    }

    public long getStartTime() {
        return this.mStartSecondTimeInDay;
    }

    public int getType() {
        return this.mSportType;
    }

    public void setCount(int i) {
        this.mCount = i;
    }

    public void setEndTime(long j) {
        this.mEndSecondTimeInDay = getSecondInDay(j);
    }

    public void setStartTime(long j) {
        this.mStartSecondTimeInDay = getSecondInDay(j);
    }

    public void setType(int i) {
        this.mSportType = i;
    }
}
