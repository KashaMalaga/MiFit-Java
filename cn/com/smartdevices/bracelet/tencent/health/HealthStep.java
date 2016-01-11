package cn.com.smartdevices.bracelet.tencent.health;

import cn.com.smartdevices.bracelet.gps.c.a.g;
import cn.com.smartdevices.bracelet.relation.db.a;
import java.util.HashMap;
import java.util.Map;

public class HealthStep implements HealthData {
    private int achieve;
    private int calories;
    private int distance;
    private int duration;
    private int steps;
    private int target;
    private int time;

    public int getAchieve() {
        return this.achieve;
    }

    public int getCalories() {
        return this.calories;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getSteps() {
        return this.steps;
    }

    public int getTarget() {
        return this.target;
    }

    public int getTime() {
        return this.time;
    }

    public void setAchieve(int i) {
        this.achieve = i;
    }

    public void setCalories(int i) {
        this.calories = i;
    }

    public void setDistance(int i) {
        this.distance = i;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setSteps(int i) {
        this.steps = i;
    }

    public void setTarget(int i) {
        this.target = i;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public Map<String, String> toMap() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put(g.f, String.valueOf(this.time));
        hashMap.put(a.g, String.valueOf(this.distance));
        hashMap.put("steps", String.valueOf(this.steps));
        hashMap.put("duration", String.valueOf(this.duration));
        hashMap.put("calories", String.valueOf(this.calories));
        hashMap.put("achieve", String.valueOf(this.achieve));
        hashMap.put("target", String.valueOf(this.target));
        return hashMap;
    }
}
