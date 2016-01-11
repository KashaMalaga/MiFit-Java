package com.xiaomi.hm.health.bt.model;

public class j {
    private boolean a = false;
    private int b = -1;

    public j(boolean z, int i) {
        this.a = z;
        this.b = i;
    }

    public boolean a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public String toString() {
        return "isSleepAuxiliary:" + this.a + ",checkCycle:" + this.b;
    }
}
