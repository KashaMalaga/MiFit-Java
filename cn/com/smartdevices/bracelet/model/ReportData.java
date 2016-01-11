package cn.com.smartdevices.bracelet.model;

import cn.com.smartdevices.bracelet.Utils;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.dataprocess.StepsInfo;

public class ReportData {
    public int calories = 0;
    private int continueDays = 0;
    public int continueStatus = 0;
    public int distance = 0;
    public int maxContinueDays = 0;
    public int maxDateStep = 0;
    public String maxDateStr = a.f;
    public String picture_url;
    public int runDistance = 0;
    public int skips = 0;
    public int steps = 0;
    public String timeFrom = a.f;
    public String timeTo = a.f;
    public int todayComplete = 0;
    public String type = ShareListDelegateActivity.SHARE_TYPE_LAST_WEEK;

    public static ReportData fromJsonStr(String str) {
        return (ReportData) Utils.c().a(str, ReportData.class);
    }

    public void clearPartSportData() {
        this.calories = 0;
        this.steps = 0;
        this.distance = 0;
        this.runDistance = 0;
        this.timeFrom = a.f;
    }

    public int getCalories() {
        return this.calories;
    }

    public int getContinueDays() {
        return this.continueDays;
    }

    public int getContinueStatus() {
        return this.continueStatus;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getMaxContinueDays() {
        return this.maxContinueDays;
    }

    public int getMaxDateStep() {
        return this.maxDateStep;
    }

    public String getMaxDateStr() {
        return this.maxDateStr;
    }

    public int getRunDistance() {
        return this.runDistance;
    }

    public int getSkips() {
        return this.skips;
    }

    public int getSteps() {
        return this.steps;
    }

    public String getTimeFrom() {
        return this.timeFrom;
    }

    public String getTimeTo() {
        return this.timeTo;
    }

    public int getTodayComplete() {
        return this.todayComplete;
    }

    public String getType() {
        return this.type;
    }

    public boolean isChallengeValid() {
        return this.continueDays >= 2;
    }

    public boolean isValid() {
        return this.steps > 0;
    }

    public void setCalories(int i) {
        this.calories = i;
    }

    public void setContinueDays(int i) {
        this.continueDays = i;
    }

    public void setContinueStatus(int i) {
        this.continueStatus = i;
    }

    public void setDistance(int i) {
        this.distance = i;
    }

    public void setMaxContinueDays(int i) {
        this.maxContinueDays = i;
    }

    public void setMaxDateStep(int i) {
        this.maxDateStep = i;
    }

    public void setMaxDateStr(String str) {
        this.maxDateStr = str;
    }

    public void setSkips(int i) {
        this.skips = i;
    }

    public void setSteps(int i) {
        this.steps = i;
    }

    public void setStepsInfo(StepsInfo stepsInfo) {
        this.steps = stepsInfo.getStepsCount();
        this.distance = stepsInfo.getDistance();
        this.calories = stepsInfo.getCalories();
    }

    public void setTimeFrom(String str) {
        this.timeFrom = str;
    }

    public void setTimeTo(String str) {
        this.timeTo = str;
    }

    public void setTodayComplete(int i) {
        this.todayComplete = i;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String toJsonStr() {
        return Utils.c().b((Object) this);
    }

    public String toString() {
        return "report data:\nsteps:" + this.steps + "\n" + "distance:" + this.distance + "\n" + "calories:" + this.calories + "\n" + "timeFrom:" + this.timeFrom + "\n" + "timeTo:" + this.timeTo + "\n" + "maxDateStr:" + this.maxDateStr + "\n" + "maxDateStep:" + this.maxDateStep + "\n" + "continueDays:" + this.continueDays + "\n" + "maxContinueDays:" + this.maxContinueDays + "\n" + "todayComplete:" + this.todayComplete + "\n" + "skips = " + this.skips + "continueStatus = " + this.continueStatus;
    }
}
