package com.xiaomi.hm.health.dataprocess;

public class ActiveItem {
    public static final int MODE_ACTIVE = 0;
    public static final int MODE_RUN = 2;
    public static final int MODE_WALK = 1;
    public int activeTime = MODE_ACTIVE;
    public int calories = MODE_ACTIVE;
    public int distance = MODE_ACTIVE;
    public int flag = MODE_ACTIVE;
    public int mode = MODE_ACTIVE;
    public int runCalories = MODE_ACTIVE;
    public int runDistance = MODE_ACTIVE;
    public int runtime = MODE_ACTIVE;
    public int start = MODE_ACTIVE;
    public int steps = MODE_ACTIVE;
    public int stop = MODE_ACTIVE;
    public int walkCalories = MODE_ACTIVE;
    public int walkDistance = MODE_ACTIVE;

    public int getActiveTime() {
        return this.activeTime;
    }

    public int getCalories() {
        return this.calories;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getKey() {
        return (this.start << 16) | this.stop;
    }

    public int getMode() {
        return this.mode;
    }

    public int getRunCalories() {
        return this.runCalories;
    }

    public int getRunDistance() {
        return this.runDistance;
    }

    public int getRuntime() {
        return this.runtime;
    }

    public int getStart() {
        return this.start;
    }

    public int getSteps() {
        return this.steps;
    }

    public int getStop() {
        return this.stop;
    }

    public int getWalkCalories() {
        return this.walkCalories;
    }

    public int getWalkDistance() {
        return this.walkDistance;
    }

    public void setActiveTime(int i) {
        this.activeTime = i;
    }

    public void setCalories(int i) {
        this.calories = i;
    }

    public void setDistance(int i) {
        this.distance = i;
    }

    public void setInfos(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
        this.start = i;
        this.stop = i2;
        this.mode = i3;
        this.distance = i4;
        this.calories = i5;
        this.runtime = i6;
        this.steps = i7;
        this.flag = i8;
        this.activeTime = i9;
        this.walkDistance = i10;
        this.walkCalories = i11;
        this.runDistance = i12;
        this.runCalories = i13;
    }

    public void setMode(int i) {
        this.mode = i;
    }

    public void setRunCalories(int i) {
        this.runCalories = i;
    }

    public void setRunDistance(int i) {
        this.runDistance = i;
    }

    public void setRuntime(int i) {
        this.runtime = i;
    }

    public void setStart(int i) {
        this.start = i;
    }

    public void setSteps(int i) {
        this.steps = i;
    }

    public void setStop(int i) {
        this.stop = i;
    }

    public void setWalkCalories(int i) {
        this.walkCalories = i;
    }

    public void setWalkDistance(int i) {
        this.walkDistance = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-----------------------\r\n");
        stringBuilder.append("start " + this.start + "\r\n");
        stringBuilder.append("stop " + this.stop + "\r\n");
        stringBuilder.append("mode " + this.mode + "\r\n");
        stringBuilder.append("distance " + this.distance + "\r\n");
        stringBuilder.append("calories " + this.calories + "\r\n");
        stringBuilder.append("runtime " + this.runtime + "\r\n");
        stringBuilder.append("steps " + this.steps + "\r\n");
        stringBuilder.append("flag " + this.flag + "\r\n");
        stringBuilder.append("activeTime " + this.activeTime + "\r\n");
        stringBuilder.append("walkDistance " + this.walkDistance + "\r\n");
        stringBuilder.append("walkCalories " + this.walkCalories + "\r\n");
        stringBuilder.append("runDistance " + this.runDistance + "\r\n");
        stringBuilder.append("runCalories " + this.runCalories + "\r\n");
        stringBuilder.append("-----------------------\r\n");
        return stringBuilder.toString();
    }
}
