package com.xiaomi.hm.health.dataprocess;

import java.io.Serializable;
import kankan.wheel.widget.a;

public class SportData implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    private int activity;
    private int hr;
    private int mode;
    private int step;
    private int timeIndex;

    public SportData(int i, int i2, int i3, int i4) {
        this.timeIndex = 0;
        this.hr = HeartRateInfo.NO_HR_VALUE;
        this.timeIndex = i;
        this.mode = i2;
        this.activity = i3;
        this.step = i4;
    }

    public SportData(int i, int i2, int i3, int i4, int i5) {
        this(i, i2, i3, i4);
        this.hr = i5;
    }

    public SportData copy() {
        return (SportData) clone();
    }

    public int getActivity() {
        return this.activity;
    }

    public int getHR() {
        return this.hr;
    }

    public int getSportMode() {
        return this.mode;
    }

    public int getStep() {
        return this.step;
    }

    public int getTimeIndex() {
        return this.timeIndex;
    }

    public void setActivity(int i) {
        this.activity = i;
    }

    public void setHR(int i) {
        this.hr = i;
    }

    public void setMode(int i) {
        this.mode = i;
    }

    public void setStep(int i) {
        this.step = i;
    }

    public String toString() {
        return "<" + this.timeIndex + a.ci + this.mode + a.ci + this.activity + a.ci + this.step + ">";
    }
}
