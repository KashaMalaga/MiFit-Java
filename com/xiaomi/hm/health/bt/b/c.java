package com.xiaomi.hm.health.bt.b;

import java.io.Serializable;

public enum c implements Serializable {
    VDEVICE(b.VDevice, -1),
    MILI(b.MILI, 0),
    MILI_1A(b.MILI, 5),
    MILI_1S(b.MILI, 4),
    WEIGHT(b.WEIGHT, 1),
    SENSORHUB(b.SENSORHUB, 2),
    SHOES(b.SHOES, 3);
    
    private b h;
    private int i;

    private c(b bVar, int i) {
        this.h = b.MILI;
        this.i = 0;
        this.h = bVar;
        this.i = i;
    }

    public b a() {
        return this.h;
    }

    public int b() {
        return this.i;
    }

    public boolean c() {
        return this.h == b.MILI;
    }

    public boolean d() {
        return this.h == b.SHOES;
    }
}
