package com.xiaomi.hm.health.bt.profile.a;

public enum h {
    CLOSE((byte) 0),
    OPEN((byte) 1);
    
    private byte c;

    private h(byte b) {
        this.c = (byte) 0;
        this.c = b;
    }

    public byte a() {
        return this.c;
    }
}
