package com.xiaomi.hm.health.bt.a;

import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;

public class r extends C {
    public static final byte a = (byte) 1;
    public static final byte b = (byte) 0;
    public static final int c = 1542;
    public static final int d = 393728;
    public static final int e = 263424;
    public static final int f = 393474;
    private int g = c;
    private byte h = b;

    public r(d dVar, int i) {
        super(dVar);
        this.g = i;
        this.h = a;
    }

    public r(d dVar, int i, byte b) {
        super(dVar);
        this.g = i;
        this.h = b;
    }

    public void a(d dVar) {
        if (dVar != null) {
            dVar.c();
        }
        byte b = (byte) ((this.g >> 16) & HeartRateInfo.HR_EMPTY_VALUE);
        byte b2 = (byte) ((this.g >> 8) & HeartRateInfo.HR_EMPTY_VALUE);
        byte b3 = (byte) (this.g & HeartRateInfo.HR_EMPTY_VALUE);
        C0596r.e(p, "r=" + b + ",g=" + b2 + ",b=" + b3);
        boolean a = this.q.a(b, b2, b3, this.h);
        if (dVar != null) {
            dVar.c(Boolean.valueOf(a));
        }
    }
}
