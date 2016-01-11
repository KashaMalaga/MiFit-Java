package cn.com.smartdevices.bracelet.tencent.health;

import cn.com.smartdevices.bracelet.gps.c.a.g;
import cn.com.smartdevices.bracelet.relation.db.Friend;
import java.util.HashMap;
import java.util.Map;

public class HealthWeight implements HealthData {
    private float bmi;
    private float fatPer;
    private int time;
    private float weight;
    private float weightTarget;

    public float getBmi() {
        return this.bmi;
    }

    public float getFatPer() {
        return this.fatPer;
    }

    public int getTime() {
        return this.time;
    }

    public float getWeight() {
        return this.weight;
    }

    public float getWeightTarget() {
        return this.weightTarget;
    }

    public void setBmi(float f) {
        this.bmi = f;
    }

    public void setFatPer(float f) {
        this.fatPer = f;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void setWeight(float f) {
        this.weight = f;
    }

    public void setWeightTarget(float f) {
        this.weightTarget = f;
    }

    public Map<String, String> toMap() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put(g.f, String.valueOf(this.time));
        hashMap.put(Friend.d, String.valueOf(Float.valueOf(this.weight)));
        hashMap.put("bmi", String.valueOf(this.bmi));
        hashMap.put("fat_per", String.valueOf(this.fatPer));
        hashMap.put("weight_target", String.valueOf(Float.valueOf(this.weightTarget)));
        return hashMap;
    }
}
