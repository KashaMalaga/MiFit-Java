package com.xiaomi.hm.health.dataprocess;

import com.xiaomi.mipush.sdk.f;

public class StageSteps {
    public int count = 0;
    public int distance = 0;
    public int steps = 0;
    public int time = 0;

    public void setInfos(int i, int i2, int i3, int i4) {
        this.time = i;
        this.steps = i2;
        this.count = i3;
        this.distance = i4;
    }

    public String toString() {
        return "this.time:" + this.time + f.i + "this.steps:" + this.steps + f.i + "this.count:" + this.count + f.i + "this.distance:" + this.distance;
    }
}
