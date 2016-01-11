package com.xiaomi.hm.health.dataprocess;

public class StageSleep {
    public int mode;
    public int start;
    public int stop;

    public void setInfos(int i, int i2, int i3) {
        this.start = i;
        this.stop = i2;
        this.mode = i3;
    }

    public String toString() {
        return "this.start:" + this.start + ",this.stop:" + this.stop + ",this.mode:" + this.mode;
    }
}
