package com.xiaomi.hm.health.bt.model;

public class c extends a {
    public static final int g = 4;
    public int h = -1;

    public c(byte b, byte b2, byte b3, byte b4) {
        super(b, b2, b3);
        this.h = b4;
    }

    public String toString() {
        return super.toString() + " heartrate=" + this.h;
    }
}
