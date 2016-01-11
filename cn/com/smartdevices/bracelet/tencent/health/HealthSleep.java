package cn.com.smartdevices.bracelet.tencent.health;

import android.text.TextUtils;
import cn.com.smartdevices.bracelet.gps.c.d;
import cn.com.smartdevices.bracelet.j.f;
import cn.com.smartdevices.bracelet.relation.db.a;
import com.xiaomi.hm.health.dataprocess.SportDay;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HealthSleep implements HealthData {
    private int awakeTime;
    private SportDay day;
    private int deepTime;
    private ArrayList<SleepDetail> details;
    private int endTime;
    private int goal;
    private int lightTime;
    private int startTime;
    private int totalTime;

    public class SleepDetail {
        public static final int STATE_AWAKE = 1;
        public static final int STATE_DEEP = 3;
        public static final int STATE_LIGHT = 2;
        private int state;
        private int time;

        public int getState() {
            return this.state;
        }

        public int getTime() {
            return this.time;
        }

        public void setState(int i) {
            this.state = i;
        }

        public void setTime(int i) {
            this.time = i;
        }
    }

    public int getAwakeTime() {
        return this.awakeTime;
    }

    public SportDay getDay() {
        return this.day;
    }

    public int getDeepTime() {
        return this.deepTime;
    }

    public ArrayList<SleepDetail> getDetails() {
        return this.details;
    }

    public int getEndTime() {
        return this.endTime;
    }

    public int getGoal() {
        return this.goal;
    }

    public int getLightTime() {
        return this.lightTime;
    }

    public int getStartTime() {
        return this.startTime;
    }

    public int getTotalTime() {
        return this.totalTime;
    }

    public void setAwakeTime(int i) {
        this.awakeTime = i;
    }

    public void setDay(SportDay sportDay) {
        this.day = sportDay;
    }

    public void setDeepTime(int i) {
        this.deepTime = i;
    }

    public void setDetails(ArrayList<SleepDetail> arrayList) {
        this.details = arrayList;
    }

    public void setEndTime(int i) {
        this.endTime = i;
    }

    public void setGoal(int i) {
        this.goal = i;
    }

    public void setLightTime(int i) {
        this.lightTime = i;
    }

    public void setStartTime(int i) {
        this.startTime = i;
    }

    public void setTotalTime(int i) {
        this.totalTime = i;
    }

    public Map<String, String> toMap() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("start_time", String.valueOf(this.startTime));
        hashMap.put("end_time", String.valueOf(this.endTime));
        hashMap.put("total_time", String.valueOf(this.totalTime));
        hashMap.put("light_sleep", String.valueOf(this.lightTime));
        hashMap.put(a.e, String.valueOf(this.deepTime));
        hashMap.put("awake_time", String.valueOf(this.awakeTime));
        if (this.goal > 0) {
            hashMap.put(d.c, String.valueOf(this.goal));
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (this.details != null) {
            Iterator it = this.details.iterator();
            while (it.hasNext()) {
                SleepDetail sleepDetail = (SleepDetail) it.next();
                stringBuilder.append('[').append(sleepDetail.time).append(',').append(sleepDetail.state).append("],");
            }
        }
        if (!TextUtils.isEmpty(stringBuilder.toString())) {
            stringBuilder.setLength(stringBuilder.length() - 1);
        }
        hashMap.put(f.au, stringBuilder.toString());
        return hashMap;
    }
}
