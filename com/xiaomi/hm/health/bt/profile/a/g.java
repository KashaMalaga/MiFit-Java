package com.xiaomi.hm.health.bt.profile.a;

public enum g {
    SLEEP((byte) 0),
    CONTINUOUS((byte) 1),
    MANUAL((byte) 2);
    
    private byte d;

    private g(byte b) {
        this.d = (byte) 0;
        this.d = b;
    }

    public byte a() {
        return this.d;
    }
}
