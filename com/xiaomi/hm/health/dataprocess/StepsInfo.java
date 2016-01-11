package com.xiaomi.hm.health.dataprocess;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.services.ay;
import cn.com.smartdevices.bracelet.lab.sportmode.DaySportOriginInfo;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class StepsInfo {
    public static String KEY_ACTIVITY_LIST = "actives";
    public static String KEY_CALORIES = DaySportOriginInfo.KEY_CAL_OF_DAY;
    public static String KEY_DISTANCE = ay.c;
    public static String KEY_STEPS = "ttl";
    public static String KEY_STEP_INFO = "stp";
    public static String KEY_STEP_RUN_CALORIES = "runCal";
    public static String KEY_STEP_RUN_DISTANCE = "runDist";
    public static String KEY_STEP_RUN_TIME = "rn";
    public static String KEY_STEP_WALK_TIME = "wk";
    private static final String TAG = "StepsInfo";
    private ArrayList<ActiveItem> activeList;
    private int activeMinutes;
    private int calories;
    private int continusActive;
    private int distance;
    private int forefootSteps;
    private ArrayList<ActiveItem> fullActiveList;
    private int runCalories;
    private int runDistance;
    private int runtime;
    private SportDay sDay;
    private ArrayList<StageSteps> sSteps;
    private int steps;
    private int time;
    private int walkCalories;
    private int walkDistance;

    public StepsInfo() {
        this.sDay = null;
        this.steps = 0;
        this.time = 0;
        this.runtime = 0;
        this.distance = 0;
        this.runDistance = 0;
        this.walkDistance = 0;
        this.calories = 0;
        this.runCalories = 0;
        this.walkCalories = 0;
        this.forefootSteps = 0;
        this.sSteps = new ArrayList();
        this.activeMinutes = 0;
        this.continusActive = 0;
        this.activeList = new ArrayList();
        this.fullActiveList = new ArrayList();
        this.sDay = new SportDay();
    }

    public StepsInfo(SportDay sportDay) {
        this.sDay = null;
        this.steps = 0;
        this.time = 0;
        this.runtime = 0;
        this.distance = 0;
        this.runDistance = 0;
        this.walkDistance = 0;
        this.calories = 0;
        this.runCalories = 0;
        this.walkCalories = 0;
        this.forefootSteps = 0;
        this.sSteps = new ArrayList();
        this.activeMinutes = 0;
        this.continusActive = 0;
        this.activeList = new ArrayList();
        this.fullActiveList = new ArrayList();
        this.sDay = sportDay;
    }

    public void copy(StepsInfo stepsInfo) {
        this.steps = stepsInfo.steps;
        this.time = stepsInfo.time;
        this.runtime = stepsInfo.runtime;
        this.distance = stepsInfo.distance;
        this.runDistance = stepsInfo.runDistance;
        this.walkDistance = stepsInfo.walkDistance;
        this.calories = stepsInfo.calories;
        this.runCalories = stepsInfo.runCalories;
        this.walkCalories = stepsInfo.walkCalories;
        this.activeMinutes = stepsInfo.activeMinutes;
        this.continusActive = stepsInfo.continusActive;
        this.forefootSteps = stepsInfo.forefootSteps;
        this.sSteps.clear();
        this.sSteps.addAll(stepsInfo.sSteps);
        this.activeList.clear();
        this.activeList.addAll(stepsInfo.activeList);
        this.fullActiveList.clear();
        this.fullActiveList.addAll(stepsInfo.fullActiveList);
    }

    public int getActMinutes() {
        return this.activeMinutes;
    }

    public ArrayList<ActiveItem> getActiveList() {
        return this.activeList;
    }

    public int getCalories() {
        return this.calories;
    }

    public int getContinuesActive() {
        return this.continusActive;
    }

    public int getDistance() {
        return this.distance;
    }

    public ArrayList<ActiveItem> getFullActiveList() {
        return this.fullActiveList;
    }

    public int getRunCalories() {
        return this.runCalories;
    }

    public int getRunDistance() {
        return this.runDistance;
    }

    public int getRunTimeCount() {
        return this.runtime;
    }

    public SportDay getSportDay() {
        return this.sDay;
    }

    public ArrayList<StageSteps> getStageSteps() {
        return this.sSteps;
    }

    public int getStepsCount() {
        return this.steps;
    }

    public int getStepsTimeCount() {
        return this.time;
    }

    public JSONObject getSummaryJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_STEPS, this.steps);
            jSONObject.put(KEY_DISTANCE, this.distance);
            jSONObject.put(KEY_CALORIES, this.calories);
            jSONObject.put(KEY_STEP_WALK_TIME, this.time);
            jSONObject.put(KEY_STEP_RUN_TIME, this.runtime);
            jSONObject.put(KEY_STEP_RUN_DISTANCE, this.runDistance);
            jSONObject.put(KEY_STEP_RUN_CALORIES, this.runCalories);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public int getWalkCalories() {
        return this.walkCalories;
    }

    public int getWalkDistance() {
        return this.walkDistance;
    }

    public int getforefootSteps() {
        return this.forefootSteps;
    }

    public void setActMinutes(int i) {
        this.activeMinutes = i;
    }

    public void setActiveList(ArrayList<ActiveItem> arrayList) {
        this.activeList.clear();
        this.activeList.addAll(arrayList);
    }

    public void setCalories(int i) {
        this.calories = i;
    }

    public void setContinuesActive(int i) {
        this.continusActive = i;
    }

    public void setDistance(int i) {
        this.distance = i;
    }

    public void setInfos(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, ArrayList<StageSteps> arrayList, ArrayList<ActiveItem> arrayList2) {
        this.steps = i;
        this.time = i2;
        this.runtime = i3;
        this.distance = i4;
        this.runDistance = i5;
        this.walkDistance = i6;
        this.calories = i7;
        this.runCalories = i8;
        this.walkCalories = i9;
        this.activeMinutes = i10;
        this.continusActive = i11;
        this.sSteps = arrayList;
        this.activeList = arrayList2;
        C0596r.d(TAG, toString());
    }

    public void setInfos(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, ArrayList<StageSteps> arrayList, ArrayList<ActiveItem> arrayList2, ArrayList<ActiveItem> arrayList3) {
        this.steps = i;
        this.time = i2;
        this.runtime = i3;
        this.distance = i4;
        this.runDistance = i5;
        this.walkDistance = i6;
        this.calories = i7;
        this.runCalories = i8;
        this.walkCalories = i9;
        this.activeMinutes = i10;
        this.continusActive = i11;
        this.sSteps = arrayList;
        this.activeList = arrayList2;
        this.fullActiveList = arrayList3;
        C0596r.d(TAG, toString());
    }

    public void setRunCalories(int i) {
        this.runCalories = i;
    }

    public void setRunDistance(int i) {
        this.runDistance = i;
    }

    public void setRunTimeCount(int i) {
        this.runtime = i;
    }

    public void setSportDay(SportDay sportDay) {
        this.sDay = sportDay;
    }

    public void setStageSteps(ArrayList<StageSteps> arrayList) {
        this.sSteps.clear();
        this.sSteps.addAll(arrayList);
    }

    public void setStepsCount(int i) {
        this.steps = i;
    }

    public void setStepsTimeCount(int i) {
        this.time = i;
    }

    public void setWalkCalories(int i) {
        this.walkCalories = i;
    }

    public void setWalkDistance(int i) {
        this.walkDistance = i;
    }

    public void setforefootSteps(int i) {
        this.forefootSteps = i;
    }

    public String toString() {
        String str = "\nBaseInfo:\nthis.steps:" + this.steps + "\n" + "this.time:" + this.time + "\n" + "this.runtime:" + this.runtime + "\n" + "this.distance:" + this.distance + "\n" + "this.runDistance:" + this.runDistance + "\n" + "this.walkDistance:" + this.walkDistance + "\n" + "this.calories:" + this.calories + "\n" + "this.runCalories:" + this.runCalories + "\n" + "this.walkCalories:" + this.walkCalories + "\n" + "this.activeMinutes:" + this.activeMinutes + "\n" + "this.continusActive:" + this.continusActive + "\n" + "this.sSteps:" + this.sSteps.size() + "\n" + "this.activeList:" + this.activeList.size() + "\n" + "this.fullActiveList:" + this.fullActiveList.size();
        Iterator it = this.sSteps.iterator();
        String str2 = "\nStageStepInfo:\n";
        while (it.hasNext()) {
            str2 = str2 + ((StageSteps) it.next()).toString() + "\n";
        }
        return str + str2;
    }
}
