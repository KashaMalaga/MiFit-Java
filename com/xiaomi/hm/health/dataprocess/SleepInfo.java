package com.xiaomi.hm.health.dataprocess;

import android.support.v7.widget.af;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.lab.sportmode.SportBaseInfo;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import kankan.wheel.widget.a;
import org.json.JSONException;
import org.json.JSONObject;

public class SleepInfo {
    public static String KEY_AWAKE_MINUTES = "wk";
    public static String KEY_DEEP_MINUTES = "dp";
    public static String KEY_END_DATE = SportBaseInfo.KEY_END_TIME;
    public static String KEY_LIGHT_MINUTES = "lt";
    public static String KEY_SLEEP_INFO = "slp";
    public static String KEY_START_DATE = SportBaseInfo.KEY_START_TIME;
    public static String KEY_USER_SLEEP_END = "usrEd";
    public static String KEY_USER_SLEEP_START = "usrSt";
    public static int NOSLEEP_DATALOST = 2;
    public static int NOSLEEP_NONE = 0;
    public static int NOSLEEP_NONWEAR = 1;
    public static int NOSLEEP_UNKNOWN = HeartRateInfo.HR_EMPTY_VALUE;
    private static final String TAG = "SleepInfo";
    private int awakeCount = 0;
    private int awakeNum = 0;
    private SportDay day;
    private boolean hasSleep = false;
    private int minutesOfNonRem = 0;
    private int minutesOfRem = 0;
    private int nosleepReason = NOSLEEP_NONE;
    private int sleepCount = 0;
    private ArrayList<StageSleep> stageSleep = new ArrayList();
    private Date startDate;
    private Date startOnBedDate;
    private Date stopDate;
    private Date stopOnBedDate;
    private int userSleepEnd = af.a;
    private int userSleepStart = af.a;

    public SleepInfo() {
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        this.startDate = new Date(instance.getTimeInMillis());
        this.startOnBedDate = new Date(instance.getTimeInMillis());
        this.stopDate = new Date(instance.getTimeInMillis());
        this.stopOnBedDate = new Date(instance.getTimeInMillis());
    }

    public SleepInfo(long j) {
        C0596r.d(TAG, "SleepInfo date:" + new Date(j) + ",timestamp:" + j);
        this.startDate = new Date(j);
        this.startOnBedDate = new Date(j);
        this.stopDate = new Date(j);
        this.stopOnBedDate = new Date(j);
    }

    private Date updateDateAsIndex(Date date, int i) {
        Calendar instance = Calendar.getInstance();
        instance.clear();
        instance.setTime(date);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.add(12, i);
        return instance.getTime();
    }

    public int getAwakeCount() {
        return this.awakeCount;
    }

    public int getAwakeNum() {
        return this.awakeNum;
    }

    public boolean getHasSleep() {
        return this.hasSleep;
    }

    public int getNonRemCount() {
        return this.minutesOfNonRem;
    }

    public int getNosleepReason() {
        return this.nosleepReason;
    }

    public int getRemCount() {
        return this.minutesOfRem;
    }

    public int getSleepCount() {
        return this.sleepCount;
    }

    public SportDay getSportDay() {
        return this.day;
    }

    public ArrayList<StageSleep> getStageSleep() {
        return this.stageSleep;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public int getStartDateMin() {
        return (this.startDate.getHours() * 60) + this.startDate.getMinutes();
    }

    public String getStartDateStr() {
        int hours = this.startDate.getHours();
        int minutes = this.startDate.getMinutes();
        return (hours < 10 ? Constants.VIA_RESULT_SUCCESS + hours : Integer.valueOf(hours)) + a.ci + (minutes < 10 ? Constants.VIA_RESULT_SUCCESS + minutes : Integer.valueOf(minutes));
    }

    public Date getStartOnBedDate() {
        return this.startOnBedDate;
    }

    public Date getStopDate() {
        return this.stopDate;
    }

    public int getStopDateMin() {
        return (this.stopDate.getHours() * 60) + this.stopDate.getMinutes();
    }

    public String getStopDateStr() {
        int hours = this.stopDate.getHours();
        int minutes = this.stopDate.getMinutes();
        return (hours < 10 ? Constants.VIA_RESULT_SUCCESS + hours : Integer.valueOf(hours)) + a.ci + (minutes < 10 ? Constants.VIA_RESULT_SUCCESS + minutes : Integer.valueOf(minutes));
    }

    public Date getStopOnBedDate() {
        return this.stopOnBedDate;
    }

    public JSONObject getSummaryJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_START_DATE, this.startDate.getTime() / 1000);
            jSONObject.put(KEY_END_DATE, this.stopDate.getTime() / 1000);
            jSONObject.put(KEY_DEEP_MINUTES, this.minutesOfNonRem);
            jSONObject.put(KEY_LIGHT_MINUTES, this.minutesOfRem);
            jSONObject.put(KEY_AWAKE_MINUTES, this.awakeCount);
            if (this.userSleepStart > af.a) {
                jSONObject.put(KEY_USER_SLEEP_START, this.userSleepStart);
            }
            if (this.userSleepEnd > af.a) {
                jSONObject.put(KEY_USER_SLEEP_END, this.userSleepEnd);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public void setAwakeCount(int i) {
        this.awakeCount = i;
    }

    public void setAwakeNum(int i) {
        this.awakeNum = i;
    }

    public void setHasSleep(boolean z) {
        this.hasSleep = z;
    }

    public void setInfos(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, ArrayList<StageSleep> arrayList) {
        this.startDate = updateDateAsIndex(this.startDate, i);
        this.startOnBedDate = updateDateAsIndex(this.startOnBedDate, i2);
        this.stopDate = updateDateAsIndex(this.stopDate, i3);
        this.stopOnBedDate = updateDateAsIndex(this.stopOnBedDate, i4);
        this.minutesOfRem = i5;
        this.minutesOfNonRem = i6;
        this.sleepCount = i7;
        this.awakeCount = i8;
        this.awakeNum = i9;
        this.userSleepStart = i10;
        this.userSleepEnd = i11;
        this.nosleepReason = i12;
        this.hasSleep = i13 == 1;
        this.stageSleep = arrayList;
        C0596r.d(TAG, toString());
    }

    public void setNonRemCount(int i) {
        this.minutesOfNonRem = i;
    }

    public void setNosleepReason(int i) {
        this.nosleepReason = i;
    }

    public void setRemCount(int i) {
        this.minutesOfRem = i;
    }

    public void setSleepCount(int i) {
        this.sleepCount = i;
    }

    public void setSportDay(SportDay sportDay) {
        this.day = sportDay;
    }

    public void setStartDate(Date date) {
        this.startDate = date;
    }

    public void setStartOnBedDate(Date date) {
        this.startOnBedDate = date;
    }

    public void setStopDate(Date date) {
        this.stopDate = date;
    }

    public void setStopOnBedDate(Date date) {
        this.stopOnBedDate = date;
    }

    public void setUserSleepEnd(int i) {
        this.userSleepEnd = i;
    }

    public void setUserSleepStart(int i) {
        this.userSleepStart = i;
    }

    public String toString() {
        String str = "\nBaseInfo:\nthis.startDate:" + this.startDate + "\n" + "this.startOnBedDate:" + this.startOnBedDate + "\n" + "this.stopDate:" + this.stopDate + "\n" + "this.stopOnBedDate:" + this.stopOnBedDate + "\n" + "this.minutesOfRem:" + this.minutesOfRem + "\n" + "this.minutesOfNonRem:" + this.minutesOfNonRem + "\n" + "this.sleepCount:" + this.sleepCount + "\n" + "this.awakeCount:" + this.awakeCount + "\n" + "this.awakeNum:" + this.awakeNum + "\n" + "this.userSleepStart:" + this.userSleepStart + "\n" + "this.userSleepEnd:" + this.userSleepEnd + "\n" + "this.nosleepReason:" + this.nosleepReason + "\n" + "this.hasSleep:" + this.hasSleep + "\n" + "this.stageSleep:" + this.stageSleep.size();
        Iterator it = this.stageSleep.iterator();
        String str2 = "\nStageSleepInfo:\n";
        while (it.hasNext()) {
            str2 = str2 + ((StageSleep) it.next()).toString() + "\n";
        }
        return str + str2;
    }
}
